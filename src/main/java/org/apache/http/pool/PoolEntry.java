/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.pool;

import java.util.concurrent.TimeUnit;
import org.apache.http.annotation.GuardedBy;
import org.apache.http.annotation.ThreadSafe;
import org.apache.http.util.Args;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
@ThreadSafe
public abstract class PoolEntry<T, C> {
    private final String id;
    private final T route;
    private final C conn;
    private final long created;
    private final long validUnit;
    @GuardedBy(value="this")
    private long updated;
    @GuardedBy(value="this")
    private long expiry;
    private volatile Object state;

    public PoolEntry(String string, T t, C c, long l, TimeUnit timeUnit) {
        Args.notNull(t, "Route");
        Args.notNull(c, "Connection");
        Args.notNull(timeUnit, "Time unit");
        this.id = string;
        this.route = t;
        this.conn = c;
        this.created = System.currentTimeMillis();
        this.validUnit = l > 0L ? this.created + timeUnit.toMillis(l) : Long.MAX_VALUE;
        this.expiry = this.validUnit;
    }

    public PoolEntry(String string, T t, C c) {
        this(string, t, c, 0L, TimeUnit.MILLISECONDS);
    }

    public String getId() {
        return this.id;
    }

    public T getRoute() {
        return this.route;
    }

    public C getConnection() {
        return this.conn;
    }

    public long getCreated() {
        return this.created;
    }

    public long getValidUnit() {
        return this.validUnit;
    }

    public Object getState() {
        return this.state;
    }

    public void setState(Object object) {
        this.state = object;
    }

    public synchronized long getUpdated() {
        return this.updated;
    }

    public synchronized long getExpiry() {
        return this.expiry;
    }

    public synchronized void updateExpiry(long l, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.updated = System.currentTimeMillis();
        long l2 = l > 0L ? this.updated + timeUnit.toMillis(l) : Long.MAX_VALUE;
        this.expiry = Math.min(l2, this.validUnit);
    }

    public synchronized boolean isExpired(long l) {
        return l >= this.expiry;
    }

    public abstract void close();

    public abstract boolean isClosed();

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[id:");
        stringBuilder.append(this.id);
        stringBuilder.append("][route:");
        stringBuilder.append(this.route);
        stringBuilder.append("][state:");
        stringBuilder.append(this.state);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

