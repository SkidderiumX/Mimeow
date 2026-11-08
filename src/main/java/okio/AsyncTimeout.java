/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.DSegmentedByteString;
import okio.Buffer;
import okio.Segment;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0001J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\fH\u0014J%\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2={"Lokio/AsyncTimeout;", "Lokio/Timeout;", "()V", "inQueue", "", "next", "timeoutAt", "", "access$newTimeoutException", "Ljava/io/IOException;", "cause", "enter", "", "exit", "newTimeoutException", "remainingNanos", "now", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "timedOut", "withTimeout", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Companion", "Watchdog", "okio"})
public class AsyncTimeout
extends Timeout {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean inQueue;
    @Nullable
    private AsyncTimeout next;
    private long timeoutAt;
    @NotNull
    private static final ReentrantLock lock = new ReentrantLock();
    @NotNull
    private static final Condition condition;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    @Nullable
    private static AsyncTimeout head;

    public final void enter() {
        long l = this.timeoutNanos();
        boolean bl = this.hasDeadline();
        if (l == 0L && !bl) {
            return;
        }
        AsyncTimeout.Companion.scheduleTimeout(this, l, bl);
    }

    public final boolean exit() {
        return AsyncTimeout.Companion.cancelScheduledTimeout(this);
    }

    private final long remainingNanos(long l) {
        return this.timeoutAt - l;
    }

    protected void timedOut() {
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        return new Sink(this, sink2){
            final /* synthetic */ AsyncTimeout this$0;
            final /* synthetic */ Sink $sink;
            {
                this.this$0 = asyncTimeout;
                this.$sink = sink2;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void write(@NotNull Buffer buffer, long l) {
                long l2;
                Intrinsics.checkNotNullParameter(buffer, "source");
                DSegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, l);
                for (long i = l; i > 0L; i -= l2) {
                    l2 = 0L;
                    Intrinsics.checkNotNull(buffer.head);
                    while (l2 < 65536L) {
                        Segment segment;
                        int n = segment.limit - segment.pos;
                        if ((l2 += (long)n) >= i) {
                            l2 = i;
                            break;
                        }
                        Intrinsics.checkNotNull(segment.next);
                    }
                    AsyncTimeout asyncTimeout = this.this$0;
                    Sink sink2 = this.$sink;
                    boolean bl = false;
                    boolean bl2 = false;
                    asyncTimeout.enter();
                    try {
                        boolean bl3 = false;
                        sink2.write(buffer, l2);
                        Unit unit = Unit.INSTANCE;
                        bl2 = true;
                        Unit unit2 = unit;
                        bl3 = asyncTimeout.exit();
                        if (!bl3) continue;
                    }
                    catch (IOException iOException) {
                        try {
                            throw !asyncTimeout.exit() ? (Throwable)iOException : (Throwable)asyncTimeout.access$newTimeoutException(iOException);
                        }
                        catch (Throwable throwable) {
                            boolean bl4 = asyncTimeout.exit();
                            if (bl4 && bl2) {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                            throw throwable;
                        }
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void flush() {
                AsyncTimeout asyncTimeout = this.this$0;
                Sink sink2 = this.$sink;
                boolean bl = false;
                boolean bl2 = false;
                asyncTimeout.enter();
                try {
                    boolean bl3 = false;
                    sink2.flush();
                    Unit unit = Unit.INSTANCE;
                    bl2 = true;
                    Unit unit2 = unit;
                    boolean bl4 = asyncTimeout.exit();
                    if (!bl4) return;
                }
                catch (IOException iOException) {
                    try {
                        throw !asyncTimeout.exit() ? (Throwable)iOException : (Throwable)asyncTimeout.access$newTimeoutException(iOException);
                    }
                    catch (Throwable throwable) {
                        boolean bl5 = asyncTimeout.exit();
                        if (!bl5 || !bl2) throw throwable;
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                }
                throw asyncTimeout.access$newTimeoutException(null);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void close() {
                AsyncTimeout asyncTimeout = this.this$0;
                Sink sink2 = this.$sink;
                boolean bl = false;
                boolean bl2 = false;
                asyncTimeout.enter();
                try {
                    boolean bl3 = false;
                    sink2.close();
                    Unit unit = Unit.INSTANCE;
                    bl2 = true;
                    Unit unit2 = unit;
                    boolean bl4 = asyncTimeout.exit();
                    if (!bl4) return;
                }
                catch (IOException iOException) {
                    try {
                        throw !asyncTimeout.exit() ? (Throwable)iOException : (Throwable)asyncTimeout.access$newTimeoutException(iOException);
                    }
                    catch (Throwable throwable) {
                        boolean bl5 = asyncTimeout.exit();
                        if (!bl5 || !bl2) throw throwable;
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                }
                throw asyncTimeout.access$newTimeoutException(null);
            }

            @NotNull
            public AsyncTimeout timeout() {
                return this.this$0;
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.sink(" + this.$sink + ')';
            }
        };
    }

    @NotNull
    public final Source source(@NotNull Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        return new Source(this, source2){
            final /* synthetic */ AsyncTimeout this$0;
            final /* synthetic */ Source $source;
            {
                this.this$0 = asyncTimeout;
                this.$source = source2;
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public long read(@NotNull Buffer buffer, long l) {
                Intrinsics.checkNotNullParameter(buffer, "sink");
                AsyncTimeout asyncTimeout = this.this$0;
                Source source2 = this.$source;
                boolean bl = false;
                boolean bl2 = false;
                asyncTimeout.enter();
                try {
                    boolean bl3 = false;
                    long l2 = source2.read(buffer, l);
                    bl2 = true;
                    long l3 = l2;
                    boolean bl4 = asyncTimeout.exit();
                    if (!bl4) return l3;
                }
                catch (IOException iOException) {
                    try {
                        throw !asyncTimeout.exit() ? (Throwable)iOException : (Throwable)asyncTimeout.access$newTimeoutException(iOException);
                    }
                    catch (Throwable throwable) {
                        boolean bl5 = asyncTimeout.exit();
                        if (!bl5 || !bl2) throw throwable;
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                }
                throw asyncTimeout.access$newTimeoutException(null);
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void close() {
                AsyncTimeout asyncTimeout = this.this$0;
                Source source2 = this.$source;
                boolean bl = false;
                boolean bl2 = false;
                asyncTimeout.enter();
                try {
                    boolean bl3 = false;
                    source2.close();
                    Unit unit = Unit.INSTANCE;
                    bl2 = true;
                    Unit unit2 = unit;
                    boolean bl4 = asyncTimeout.exit();
                    if (!bl4) return;
                }
                catch (IOException iOException) {
                    try {
                        throw !asyncTimeout.exit() ? (Throwable)iOException : (Throwable)asyncTimeout.access$newTimeoutException(iOException);
                    }
                    catch (Throwable throwable) {
                        boolean bl5 = asyncTimeout.exit();
                        if (!bl5 || !bl2) throw throwable;
                        throw asyncTimeout.access$newTimeoutException(null);
                    }
                }
                throw asyncTimeout.access$newTimeoutException(null);
            }

            @NotNull
            public AsyncTimeout timeout() {
                return this.this$0;
            }

            @NotNull
            public String toString() {
                return "AsyncTimeout.source(" + this.$source + ')';
            }
        };
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final <T> T withTimeout(@NotNull Function0<? extends T> function0) {
        T t;
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean bl = false;
        boolean bl2 = false;
        this.enter();
        try {
            T t2 = function0.invoke();
            bl2 = true;
            t = t2;
        }
        catch (IOException iOException) {
            try {
                throw !this.exit() ? (Throwable)iOException : (Throwable)this.access$newTimeoutException(iOException);
            }
            catch (Throwable throwable) {
                InlineMarker.finallyStart(1);
                boolean bl3 = this.exit();
                if (bl3 && bl2) {
                    throw this.access$newTimeoutException(null);
                }
                InlineMarker.finallyEnd(1);
                throw throwable;
            }
        }
        InlineMarker.finallyStart(1);
        boolean bl4 = this.exit();
        if (bl4) {
            throw this.access$newTimeoutException(null);
        }
        InlineMarker.finallyEnd(1);
        return t;
    }

    @PublishedApi
    @NotNull
    public final IOException access$newTimeoutException(@Nullable IOException iOException) {
        return this.newTimeoutException(iOException);
    }

    @NotNull
    protected IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    static {
        Condition condition = lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(condition, "newCondition(...)");
        AsyncTimeout.condition = condition;
        IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000f\u0010\u0012\u001a\u0004\u0018\u00010\rH\u0000\u00a2\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2={"Lokio/AsyncTimeout$Companion;", "", "()V", "IDLE_TIMEOUT_MILLIS", "", "IDLE_TIMEOUT_NANOS", "TIMEOUT_WRITE_SIZE", "", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "head", "Lokio/AsyncTimeout;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "awaitTimeout", "awaitTimeout$okio", "cancelScheduledTimeout", "", "node", "scheduleTimeout", "", "timeoutNanos", "hasDeadline", "okio"})
    @SourceDebugExtension(value={"SMAP\nAsyncTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AsyncTimeout.kt\nokio/AsyncTimeout$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,331:1\n1#2:332\n*E\n"})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final ReentrantLock getLock() {
            return lock;
        }

        @NotNull
        public final Condition getCondition() {
            return condition;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private final void scheduleTimeout(AsyncTimeout asyncTimeout, long l, boolean bl) {
            Lock lock = Companion.getLock();
            lock.lock();
            try {
                boolean bl2 = false;
                if (!(!asyncTimeout.inQueue)) {
                    boolean bl3 = false;
                    String string = "Unbalanced enter/exit";
                    throw new IllegalStateException(string.toString());
                }
                asyncTimeout.inQueue = true;
                if (head == null) {
                    head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long l2 = System.nanoTime();
                if (l != 0L && bl) {
                    asyncTimeout.timeoutAt = l2 + Math.min(l, asyncTimeout.deadlineNanoTime() - l2);
                } else if (l != 0L) {
                    asyncTimeout.timeoutAt = l2 + l;
                } else if (bl) {
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                } else {
                    throw new AssertionError();
                }
                long l3 = asyncTimeout.remainingNanos(l2);
                AsyncTimeout asyncTimeout2 = head;
                Intrinsics.checkNotNull(asyncTimeout2);
                AsyncTimeout asyncTimeout3 = asyncTimeout2;
                while (true) {
                    block17: {
                        block16: {
                            if (asyncTimeout3.next == null) break block16;
                            AsyncTimeout asyncTimeout4 = asyncTimeout3.next;
                            Intrinsics.checkNotNull(asyncTimeout4);
                            if (l3 >= asyncTimeout4.remainingNanos(l2)) break block17;
                        }
                        asyncTimeout.next = asyncTimeout3.next;
                        asyncTimeout3.next = asyncTimeout;
                        if (asyncTimeout3 != head) break;
                        Companion.getCondition().signal();
                        break;
                    }
                    Intrinsics.checkNotNull(asyncTimeout3.next);
                }
                Unit unit = Unit.INSTANCE;
            }
            finally {
                lock.unlock();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            Lock lock = Companion.getLock();
            lock.lock();
            try {
                boolean bl = false;
                if (!asyncTimeout.inQueue) {
                    boolean bl2 = false;
                    return bl2;
                }
                asyncTimeout.inQueue = false;
                AsyncTimeout asyncTimeout2 = head;
                while (asyncTimeout2 != null) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        boolean bl3 = false;
                        return bl3;
                    }
                    asyncTimeout2 = asyncTimeout2.next;
                }
                boolean bl4 = true;
                return bl4;
            }
            finally {
                lock.unlock();
            }
        }

        @Nullable
        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = head;
            Intrinsics.checkNotNull(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long l = System.nanoTime();
                this.getCondition().await(IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                AsyncTimeout asyncTimeout3 = head;
                Intrinsics.checkNotNull(asyncTimeout3);
                return asyncTimeout3.next == null && System.nanoTime() - l >= IDLE_TIMEOUT_NANOS ? head : null;
            }
            long l = asyncTimeout2.remainingNanos(System.nanoTime());
            if (l > 0L) {
                this.getCondition().await(l, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout asyncTimeout4 = head;
            Intrinsics.checkNotNull(asyncTimeout4);
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2={"Lokio/AsyncTimeout$Watchdog;", "Ljava/lang/Thread;", "()V", "run", "", "okio"})
    private static final class Watchdog
    extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            this.setDaemon(true);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        @Override
        public void run() {
            while (true) {
                try {
                    AsyncTimeout asyncTimeout = null;
                    Lock lock = Companion.getLock();
                    lock.lock();
                    try {
                        boolean bl = false;
                        asyncTimeout = Companion.awaitTimeout$okio();
                        if (asyncTimeout == head) {
                            head = null;
                            return;
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        lock.unlock();
                    }
                    AsyncTimeout asyncTimeout2 = asyncTimeout;
                    if (asyncTimeout2 != null) {
                        asyncTimeout2.timedOut();
                    }
                }
                catch (InterruptedException interruptedException) {
                }
            }
        }
    }
}

