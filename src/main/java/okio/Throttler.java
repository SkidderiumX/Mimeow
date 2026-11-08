/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u0014J$\u0010\u0006\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b\u001bJ\f\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\u0002J\f\u0010\u001d\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2={"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "bytesToNanos", "nanosToBytes", "okio"})
public class Throttler {
    private long allocatedUntil;
    private long bytesPerSecond;
    private long waitByteCount;
    private long maxByteCount;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final Condition condition;

    public Throttler(long l) {
        this.allocatedUntil = l;
        this.waitByteCount = 8192L;
        this.maxByteCount = 262144L;
        this.lock = new ReentrantLock();
        Condition condition = this.lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(condition, "newCondition(...)");
        this.condition = condition;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    public Throttler() {
        this(System.nanoTime());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @JvmOverloads
    public final void bytesPerSecond(long l, long l2, long l3) {
        Lock lock = this.lock;
        lock.lock();
        try {
            boolean bl = false;
            if (!(l >= 0L)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(l2 > 0L)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            if (!(l3 >= l2)) {
                String string = "Failed requirement.";
                throw new IllegalArgumentException(string.toString());
            }
            this.bytesPerSecond = l;
            this.waitByteCount = l2;
            this.maxByteCount = l3;
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        }
        finally {
            lock.unlock();
        }
    }

    public static /* synthetic */ void bytesPerSecond$default(Throttler throttler, long l, long l2, long l3, int n, Object object) {
        if ((n & 2) != 0) {
            l2 = throttler.waitByteCount;
        }
        if ((n & 4) != 0) {
            l3 = throttler.maxByteCount;
        }
        throttler.bytesPerSecond(l, l2, l3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final long take$okio(long l) {
        if (!(l > 0L)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        Lock lock = this.lock;
        lock.lock();
        try {
            boolean bl = false;
            while (true) {
                long l2;
                long l3;
                if ((l3 = this.byteCountOrWaitNanos$okio(l2 = System.nanoTime(), l)) >= 0L) {
                    long l4 = l3;
                    return l4;
                }
                this.condition.awaitNanos(-l3);
            }
        }
        finally {
            lock.unlock();
        }
    }

    public final long byteCountOrWaitNanos$okio(long l, long l2) {
        if (this.bytesPerSecond == 0L) {
            return l2;
        }
        long l3 = Math.max(this.allocatedUntil - l, 0L);
        long l4 = this.maxByteCount - this.nanosToBytes(l3);
        if (l4 >= l2) {
            this.allocatedUntil = l + l3 + this.bytesToNanos(l2);
            return l2;
        }
        if (l4 >= this.waitByteCount) {
            this.allocatedUntil = l + this.bytesToNanos(this.maxByteCount);
            return l4;
        }
        long l5 = Math.min(this.waitByteCount, l2);
        long l6 = l3 + this.bytesToNanos(l5 - this.maxByteCount);
        if (l6 == 0L) {
            this.allocatedUntil = l + this.bytesToNanos(this.maxByteCount);
            return l5;
        }
        return -l6;
    }

    private final long nanosToBytes(long l) {
        return l * this.bytesPerSecond / 1000000000L;
    }

    private final long bytesToNanos(long l) {
        return l * 1000000000L / this.bytesPerSecond;
    }

    @NotNull
    public final Source source(@NotNull Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        return new ForwardingSource(source2, this){
            final /* synthetic */ Throttler this$0;
            {
                this.this$0 = throttler;
                super(source2);
            }

            public long read(@NotNull Buffer buffer, long l) {
                Intrinsics.checkNotNullParameter(buffer, "sink");
                try {
                    long l2 = this.this$0.take$okio(l);
                    return super.read(buffer, l2);
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    @NotNull
    public final Sink sink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        return new ForwardingSink(sink2, this){
            final /* synthetic */ Throttler this$0;
            {
                this.this$0 = throttler;
                super(sink2);
            }

            public void write(@NotNull Buffer buffer, long l) throws IOException {
                Intrinsics.checkNotNullParameter(buffer, "source");
                try {
                    long l2;
                    for (long i = l; i > 0L; i -= l2) {
                        l2 = this.this$0.take$okio(i);
                        super.write(buffer, l2);
                    }
                }
                catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedIOException("interrupted");
                }
            }
        };
    }

    @JvmOverloads
    public final void bytesPerSecond(long l, long l2) {
        Throttler.bytesPerSecond$default(this, l, l2, 0L, 4, null);
    }

    @JvmOverloads
    public final void bytesPerSecond(long l) {
        Throttler.bytesPerSecond$default(this, l, 0L, 0L, 6, null);
    }
}

