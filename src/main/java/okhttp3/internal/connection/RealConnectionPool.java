package okhttp3.internal.connection;

import java.util.concurrent.*;
import java.net.*;
import okhttp3.internal.*;
import org.jetbrains.annotations.*;
import kotlin.*;
import okhttp3.internal.concurrent.*;
import java.util.*;
import java.lang.ref.*;
import okhttp3.internal.platform.*;
import kotlin.jvm.internal.*;
import okhttp3.*;

@Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u000e\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ.\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0012J\u0006\u0010\"\u001a\u00020\u0005J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u0005J\u0018\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J\u000e\u0010'\u001a\u00020$2\u0006\u0010!\u001a\u00020\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)" }, d2 = { "Lokhttp3/internal/connection/RealConnectionPool;", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "maxIdleConnections", "", "keepAliveDuration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Lokhttp3/internal/concurrent/TaskRunner;IJLjava/util/concurrent/TimeUnit;)V", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/connection/RealConnectionPool$cleanupTask$1", "Lokhttp3/internal/connection/RealConnectionPool$cleanupTask$1;", "connections", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lokhttp3/internal/connection/RealConnection;", "keepAliveDurationNs", "callAcquirePooledConnection", "", "address", "Lokhttp3/Address;", "call", "Lokhttp3/internal/connection/RealCall;", "routes", "", "Lokhttp3/Route;", "requireMultiplexed", "cleanup", "now", "connectionBecameIdle", "connection", "connectionCount", "evictAll", "", "idleConnectionCount", "pruneAndGetAllocationCount", "put", "Companion", "okhttp" })
@SourceDebugExtension({ "SMAP\nRealConnectionPool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 Util.kt\nokhttp3/internal/Util\n*L\n1#1,250:1\n1#2:251\n1774#3,4:252\n608#4,4:256\n608#4,4:260\n608#4,4:264\n*S KotlinDebug\n*F\n+ 1 RealConnectionPool.kt\nokhttp3/internal/connection/RealConnectionPool\n*L\n60#1:252,4\n95#1:256,4\n106#1:260,4\n215#1:264,4\n*E\n" })
public class RealConnectionPool
{
    @NotNull
    public static final Companion Companion;
    private final int maxIdleConnections;
    private final long keepAliveDurationNs;
    @NotNull
    private final TaskQueue cleanupQueue;
    @NotNull
    private final RealConnectionPool$cleanupTask.RealConnectionPool$cleanupTask$1 cleanupTask;
    @NotNull
    private final ConcurrentLinkedQueue<RealConnection> connections;
    
    public RealConnectionPool(@NotNull final TaskRunner taskRunner, final int maxIdleConnections, final long n, @NotNull final TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDurationNs = timeUnit.toNanos(n);
        this.cleanupQueue = taskRunner.newQueue();
        this.cleanupTask = new RealConnectionPool$cleanupTask.RealConnectionPool$cleanupTask$1(this, Util.okHttpName + " ConnectionPool");
        this.connections = new ConcurrentLinkedQueue<RealConnection>();
        if (n <= 0L) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + n).toString());
        }
    }
    
    public final int idleConnectionCount() {
        // 
        final ConcurrentLinkedQueue<RealConnection> connections = this.connections;
        if (connections.isEmpty()) {
            return 0;
        }
        int n = 0;
        for (final RealConnection connection : connections) {
            Intrinsics.checkNotNullExpressionValue(connection, "it");
            final RealConnection it = connection;
            synchronized (it) {
                if (connection.getCalls().isEmpty()) {
                    if (n == Integer.MAX_VALUE) {
                        kotlin.collections.CollectionsKt.throwCountOverflow();
                    }
                    n++;
                }
            }
        }
        return n;
    }
    
    public final int connectionCount() {
        return this.connections.size();
    }
    
    public final boolean callAcquirePooledConnection(@NotNull final Address address, @NotNull final RealCall realCall, @Nullable final List<Route> list, final boolean b) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(realCall, "call");
        for (final RealConnection realConnection : this.connections) {
            Intrinsics.checkNotNullExpressionValue(realConnection, "connection");
            synchronized (realConnection) {
                if ((!b || realConnection.isMultiplexed$okhttp()) && realConnection.isEligible$okhttp(address, list)) {
                    realCall.acquireConnectionNoEvents(realConnection);
                    return true;
                }
                final Unit instance = Unit.INSTANCE;
                continue;
            }
            break;
        }
        return false;
    }
    
    public final void put(@NotNull final RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection));
        }
        this.connections.add(realConnection);
        TaskQueue.schedule$default(this.cleanupQueue, (Task)this.cleanupTask, 0L, 2, null);
    }
    
    public final boolean connectionBecameIdle(@NotNull final RealConnection realConnection) {
        Intrinsics.checkNotNullParameter(realConnection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection));
        }
        boolean b;
        if (realConnection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            b = true;
        }
        else {
            TaskQueue.schedule$default(this.cleanupQueue, (Task)this.cleanupTask, 0L, 2, null);
            b = false;
        }
        return b;
    }
    
    public final void evictAll() {
        Iterator iterator = this.connections.iterator();
        Intrinsics.checkNotNullExpressionValue(iterator, "connections.iterator()");
        while (iterator.hasNext()) {
            RealConnection realConnection = (RealConnection)iterator.next();
            Intrinsics.checkNotNullExpressionValue(realConnection, "connection");
            Socket socket = null;
            synchronized (realConnection) {
                if (realConnection.getCalls().isEmpty()) {
                    iterator.remove();
                    realConnection.setNoNewExchanges(true);
                    socket = realConnection.socket();
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }
    
    public final long cleanup(final long n) {
        int n2 = 0;
        int n3 = 0;
        Object o = null;
        long n4 = Long.MIN_VALUE;
        for (final RealConnection realConnection : this.connections) {
            Intrinsics.checkNotNullExpressionValue(realConnection, "connection");
            synchronized (realConnection) {
                if (this.pruneAndGetAllocationCount(realConnection, n) > 0) {
                    final int i = n2;
                    n2 = i + 1;
                }
                else {
                    ++n3;
                    final long n5 = n - realConnection.getIdleAtNs$okhttp();
                    if (n5 > n4) {
                        n4 = n5;
                        o = realConnection;
                    }
                    final Unit instance = Unit.INSTANCE;
                }
                continue;
            }
            break;
        }
        if (n4 >= this.keepAliveDurationNs || n3 > this.maxIdleConnections) {
            final Object o2 = o;
            Intrinsics.checkNotNull(o2);
            final RealConnection realConnection2 = (RealConnection)o2;
            synchronized (realConnection2) {
                if (!realConnection2.getCalls().isEmpty()) {
                    return 0L;
                }
                if (realConnection2.getIdleAtNs$okhttp() + n4 != n) {
                    return 0L;
                }
                realConnection2.setNoNewExchanges(true);
                this.connections.remove(o);
            }
            Util.closeQuietly(realConnection2.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
        if (n3 > 0) {
            return this.keepAliveDurationNs - n4;
        }
        if (n2 > 0) {
            return this.keepAliveDurationNs;
        }
        return -1L;
    }
    
    private final int pruneAndGetAllocationCount(final RealConnection obj, final long n) {
        if (Util.assertionsEnabled && !Thread.holdsLock(obj)) {
            throw new AssertionError((Object)("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj));
        }
        final List<Reference<RealCall>> calls = obj.getCalls();
        int i = 0;
        while (i < calls.size()) {
            final Reference reference = calls.get(i);
            if (reference.get() != null) {
                ++i;
            }
            else {
                Intrinsics.checkNotNull(reference, "null cannot be cast to non-null type okhttp3.internal.connection.RealCall.CallReference");
                Platform.Companion.get().logCloseableLeak("A connection to " + obj.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference)reference).getCallStackTrace());
                calls.remove(i);
                obj.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    obj.setIdleAtNs$okhttp(n - this.keepAliveDurationNs);
                    return 0;
                }
                continue;
            }
        }
        return calls.size();
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 8, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007" }, d2 = { "Lokhttp3/internal/connection/RealConnectionPool$Companion;", "", "()V", "get", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/ConnectionPool;", "okhttp" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final RealConnectionPool get(@NotNull final ConnectionPool connectionPool) {
            Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }
}
