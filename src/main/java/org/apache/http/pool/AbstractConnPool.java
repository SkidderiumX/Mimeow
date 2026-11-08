/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.pool;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.concurrent.FutureCallback;
import org.apache.http.pool.ConnFactory;
import org.apache.http.pool.ConnPool;
import org.apache.http.pool.ConnPoolControl;
import org.apache.http.pool.PoolEntry;
import org.apache.http.pool.PoolEntryCallback;
import org.apache.http.pool.PoolEntryFuture;
import org.apache.http.pool.PoolStats;
import org.apache.http.pool.RouteSpecificPool;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public abstract class AbstractConnPool<T, C, E extends PoolEntry<T, C>>
implements ConnPool<T, E>,
ConnPoolControl<T> {
    private final Lock lock;
    private final ConnFactory<T, C> connFactory;
    private final Map<T, RouteSpecificPool<T, C, E>> routeToPool;
    private final Set<E> leased;
    private final LinkedList<E> available;
    private final LinkedList<PoolEntryFuture<E>> pending;
    private final Map<T, Integer> maxPerRoute;
    private volatile boolean isShutDown;
    private volatile int defaultMaxPerRoute;
    private volatile int maxTotal;

    public AbstractConnPool(ConnFactory<T, C> connFactory, int n, int n2) {
        this.connFactory = Args.notNull(connFactory, "Connection factory");
        this.defaultMaxPerRoute = Args.notNegative(n, "Max per route value");
        this.maxTotal = Args.notNegative(n2, "Max total value");
        this.lock = new ReentrantLock();
        this.routeToPool = new HashMap<T, RouteSpecificPool<T, C, E>>();
        this.leased = new HashSet();
        this.available = new LinkedList();
        this.pending = new LinkedList();
        this.maxPerRoute = new HashMap<T, Integer>();
    }

    protected abstract E createEntry(T var1, C var2);

    protected void onLease(E e) {
    }

    protected void onRelease(E e) {
    }

    public boolean isShutdown() {
        return this.isShutDown;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void shutdown() throws IOException {
        if (this.isShutDown) {
            return;
        }
        this.isShutDown = true;
        this.lock.lock();
        try {
            for (PoolEntry object : this.available) {
                object.close();
            }
            for (PoolEntry poolEntry : this.leased) {
                poolEntry.close();
            }
            for (RouteSpecificPool routeSpecificPool : this.routeToPool.values()) {
                routeSpecificPool.shutdown();
            }
            this.routeToPool.clear();
            this.leased.clear();
            this.available.clear();
        }
        finally {
            this.lock.unlock();
        }
    }

    private RouteSpecificPool<T, C, E> getPool(final T t) {
        RouteSpecificPool routeSpecificPool = this.routeToPool.get(t);
        if (routeSpecificPool == null) {
            routeSpecificPool = new RouteSpecificPool<T, C, E>(t){

                @Override
                protected E createEntry(C c) {
                    return AbstractConnPool.this.createEntry(t, c);
                }
            };
            this.routeToPool.put(t, routeSpecificPool);
        }
        return routeSpecificPool;
    }

    @Override
    public Future<E> lease(final T t, final Object object, FutureCallback<E> futureCallback) {
        Args.notNull(t, "Route");
        Asserts.check(!this.isShutDown, "Connection pool shut down");
        return new PoolEntryFuture<E>(this.lock, futureCallback){

            @Override
            public E getPoolEntry(long l, TimeUnit timeUnit) throws InterruptedException, TimeoutException, IOException {
                PoolEntry poolEntry = AbstractConnPool.this.getPoolEntryBlocking(t, object, l, timeUnit, this);
                AbstractConnPool.this.onLease(poolEntry);
                return poolEntry;
            }
        };
    }

    public Future<E> lease(T t, Object object) {
        return this.lease(t, object, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private E getPoolEntryBlocking(T t, Object object, long l, TimeUnit timeUnit, PoolEntryFuture<E> poolEntryFuture) throws IOException, InterruptedException, TimeoutException {
        Date date = null;
        if (l > 0L) {
            date = new Date(System.currentTimeMillis() + timeUnit.toMillis(l));
        }
        this.lock.lock();
        try {
            RouteSpecificPool routeSpecificPool = this.getPool(t);
            PoolEntry poolEntry = null;
            while (poolEntry == null) {
                int n;
                int n2;
                Asserts.check(!this.isShutDown, "Connection pool shut down");
                while ((poolEntry = (PoolEntry)routeSpecificPool.getFree(object)) != null && (poolEntry.isClosed() || poolEntry.isExpired(System.currentTimeMillis()))) {
                    poolEntry.close();
                    this.available.remove(poolEntry);
                    routeSpecificPool.free(poolEntry, false);
                }
                if (poolEntry != null) {
                    this.available.remove(poolEntry);
                    this.leased.add(poolEntry);
                    PoolEntry poolEntry2 = poolEntry;
                    return (E)poolEntry2;
                }
                int n3 = this.getMax(t);
                int n4 = Math.max(0, routeSpecificPool.getAllocatedCount() + 1 - n3);
                if (n4 > 0) {
                    E e;
                    for (n2 = 0; n2 < n4 && (e = routeSpecificPool.getLastUsed()) != null; ++n2) {
                        ((PoolEntry)e).close();
                        this.available.remove(e);
                        routeSpecificPool.remove(e);
                    }
                }
                if (routeSpecificPool.getAllocatedCount() < n3 && (n = Math.max(this.maxTotal - (n2 = this.leased.size()), 0)) > 0) {
                    Object object2;
                    Object object3;
                    int n5 = this.available.size();
                    if (n5 > n - 1 && !this.available.isEmpty()) {
                        object3 = (PoolEntry)this.available.removeLast();
                        ((PoolEntry)object3).close();
                        object2 = this.getPool(((PoolEntry)object3).getRoute());
                        ((RouteSpecificPool)object2).remove(object3);
                    }
                    object3 = this.connFactory.create(t);
                    poolEntry = routeSpecificPool.add(object3);
                    this.leased.add(poolEntry);
                    object2 = poolEntry;
                    return (E)object2;
                }
                n2 = 0;
                try {
                    routeSpecificPool.queue(poolEntryFuture);
                    this.pending.add(poolEntryFuture);
                    n2 = poolEntryFuture.await(date) ? 1 : 0;
                }
                finally {
                    routeSpecificPool.unqueue(poolEntryFuture);
                    this.pending.remove(poolEntryFuture);
                }
                if (n2 != 0 || date == null || date.getTime() > System.currentTimeMillis()) continue;
                break;
            }
            throw new TimeoutException("Timeout waiting for connection");
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void release(E e, boolean bl) {
        this.lock.lock();
        try {
            if (this.leased.remove(e)) {
                RouteSpecificPool routeSpecificPool = this.getPool(((PoolEntry)e).getRoute());
                routeSpecificPool.free(e, bl);
                if (bl && !this.isShutDown) {
                    this.available.addFirst(e);
                    this.onRelease(e);
                } else {
                    ((PoolEntry)e).close();
                }
                PoolEntryFuture<E> poolEntryFuture = routeSpecificPool.nextPending();
                if (poolEntryFuture != null) {
                    this.pending.remove(poolEntryFuture);
                } else {
                    poolEntryFuture = this.pending.poll();
                }
                if (poolEntryFuture != null) {
                    poolEntryFuture.wakeup();
                }
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    private int getMax(T t) {
        Integer n = this.maxPerRoute.get(t);
        if (n != null) {
            return n;
        }
        return this.defaultMaxPerRoute;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setMaxTotal(int n) {
        Args.notNegative(n, "Max value");
        this.lock.lock();
        try {
            this.maxTotal = n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getMaxTotal() {
        this.lock.lock();
        try {
            int n = this.maxTotal;
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setDefaultMaxPerRoute(int n) {
        Args.notNegative(n, "Max per route value");
        this.lock.lock();
        try {
            this.defaultMaxPerRoute = n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getDefaultMaxPerRoute() {
        this.lock.lock();
        try {
            int n = this.defaultMaxPerRoute;
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setMaxPerRoute(T t, int n) {
        Args.notNull(t, "Route");
        Args.notNegative(n, "Max per route value");
        this.lock.lock();
        try {
            this.maxPerRoute.put(t, n);
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int getMaxPerRoute(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            int n = this.getMax(t);
            return n;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PoolStats getTotalStats() {
        this.lock.lock();
        try {
            PoolStats poolStats = new PoolStats(this.leased.size(), this.pending.size(), this.available.size(), this.maxTotal);
            return poolStats;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public PoolStats getStats(T t) {
        Args.notNull(t, "Route");
        this.lock.lock();
        try {
            RouteSpecificPool<T, C, E> routeSpecificPool = this.getPool(t);
            PoolStats poolStats = new PoolStats(routeSpecificPool.getLeasedCount(), routeSpecificPool.getPendingCount(), routeSpecificPool.getAvailableCount(), this.getMax(t));
            return poolStats;
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void enumAvailable(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            Iterator iterator2 = this.available.iterator();
            while (iterator2.hasNext()) {
                PoolEntry poolEntry = (PoolEntry)iterator2.next();
                poolEntryCallback.process(poolEntry);
                if (!poolEntry.isClosed()) continue;
                RouteSpecificPool routeSpecificPool = this.getPool(poolEntry.getRoute());
                routeSpecificPool.remove(poolEntry);
                iterator2.remove();
            }
            this.purgePoolMap();
        }
        finally {
            this.lock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void enumLeased(PoolEntryCallback<T, C> poolEntryCallback) {
        this.lock.lock();
        try {
            for (PoolEntry poolEntry : this.leased) {
                poolEntryCallback.process(poolEntry);
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    private void purgePoolMap() {
        Iterator<Map.Entry<T, RouteSpecificPool<T, C, E>>> iterator2 = this.routeToPool.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<T, RouteSpecificPool<T, C, E>> entry = iterator2.next();
            RouteSpecificPool<T, C, E> routeSpecificPool = entry.getValue();
            if (routeSpecificPool.getPendingCount() + routeSpecificPool.getAllocatedCount() != 0) continue;
            iterator2.remove();
        }
    }

    public void closeIdle(long l, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        long l2 = timeUnit.toMillis(l);
        if (l2 < 0L) {
            l2 = 0L;
        }
        final long l3 = System.currentTimeMillis() - l2;
        this.enumAvailable(new PoolEntryCallback<T, C>(){

            @Override
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.getUpdated() <= l3) {
                    poolEntry.close();
                }
            }
        });
    }

    public void closeExpired() {
        final long l = System.currentTimeMillis();
        this.enumAvailable(new PoolEntryCallback<T, C>(){

            @Override
            public void process(PoolEntry<T, C> poolEntry) {
                if (poolEntry.isExpired(l)) {
                    poolEntry.close();
                }
            }
        });
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[leased: ");
        stringBuilder.append(this.leased);
        stringBuilder.append("][available: ");
        stringBuilder.append(this.available);
        stringBuilder.append("][pending: ");
        stringBuilder.append(this.pending);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

