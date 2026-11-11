/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0014J\r\u0010\u001f\u001a\u00020\u0014H\u0007\u00a2\u0006\u0002\b,J\r\u0010#\u001a\u00020$H\u0007\u00a2\u0006\u0002\b-J&\u0010.\u001a\u00020**\u00020\u00142\u0017\u0010/\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020*00\u00a2\u0006\u0002\b1H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u00020\u00148G\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010 \u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\f\"\u0004\b\"\u0010\u000eR\u0013\u0010#\u001a\u00020$8G\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010%R\u001a\u0010&\u001a\u00020\nX\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\f\"\u0004\b(\u0010\u000e\u00a8\u00062"}, d2={"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "canceled", "", "getCanceled$okio", "()Z", "setCanceled$okio", "(Z)V", "condition", "Ljava/util/concurrent/locks/Condition;", "getCondition", "()Ljava/util/concurrent/locks/Condition;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "getSinkClosed$okio", "setSinkClosed$okio", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "cancel", "", "fold", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"})
@SourceDebugExtension(value={"SMAP\nPipe.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Pipe.kt\nokio/Pipe\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Timeout.kt\nokio/Timeout\n*L\n1#1,257:1\n1#2:258\n268#3,26:259\n*S KotlinDebug\n*F\n+ 1 Pipe.kt\nokio/Pipe\n*L\n217#1:259,26\n*E\n"})
public class Pipe {
    private final long maxBufferSize;
    @NotNull
    private final Buffer buffer;
    private boolean canceled;
    private boolean sinkClosed;
    private boolean sourceClosed;
    @Nullable
    private Sink foldedSink;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final Condition condition;
    @NotNull
    private final Sink sink;
    @NotNull
    private final Source source;

    public Pipe(long l) {
        this.maxBufferSize = l;
        this.buffer = new Buffer();
        this.lock = new ReentrantLock();
        Condition condition = this.lock.newCondition();
        Intrinsics.checkNotNullExpressionValue(condition, "newCondition(...)");
        this.condition = condition;
        if (!(this.maxBufferSize >= 1L)) {
            boolean bl = false;
            String string = "maxBufferSize < 1: " + this.maxBufferSize;
            throw new IllegalArgumentException(string.toString());
        }
        this.sink = new Sink(this){
            @NotNull
            private final Timeout timeout;
            final /* synthetic */ Pipe this$0;
            {
                this.this$0 = pipe;
                this.timeout = new Timeout();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void write(@NotNull Buffer buffer, long l) {
                Object object;
                Object object2;
                Intrinsics.checkNotNullParameter(buffer, "source");
                long l2 = 0L;
                l2 = l;
                Sink sink2 = null;
                Lock lock = this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean bl = false;
                    if (!(!pipe.getSinkClosed$okio())) {
                        boolean bl2 = false;
                        String string = "closed";
                        throw new IllegalStateException(string.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (l2 > 0L) {
                        Sink sink3 = pipe.getFoldedSink$okio();
                        if (sink3 != null) {
                            object2 = sink3;
                            boolean bl3 = false;
                            sink2 = object2;
                            break;
                        }
                        if (pipe.getSourceClosed$okio()) {
                            throw new IOException("source is closed");
                        }
                        long l3 = pipe.getMaxBufferSize$okio() - pipe.getBuffer$okio().size();
                        if (l3 == 0L) {
                            this.timeout.awaitSignal(pipe.getCondition());
                            if (!pipe.getCanceled$okio()) continue;
                            throw new IOException("canceled");
                        }
                        long l4 = Math.min(l3, l2);
                        pipe.getBuffer$okio().write(buffer, l4);
                        l2 -= l4;
                        pipe.getCondition().signalAll();
                    }
                    object = Unit.INSTANCE;
                }
                finally {
                    lock.unlock();
                }
                lock = sink2;
                if (lock != null) {
                    pipe = this.this$0;
                    object = lock;
                    boolean bl = false;
                    object2 = object.timeout();
                    Timeout timeout2 = pipe.sink().timeout();
                    boolean bl4 = false;
                    long l5 = ((Timeout)object2).timeoutNanos();
                    ((Timeout)object2).timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), ((Timeout)object2).timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (((Timeout)object2).hasDeadline()) {
                        long l6 = ((Timeout)object2).deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            ((Timeout)object2).deadlineNanoTime(Math.min(((Timeout)object2).deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            boolean bl5 = false;
                            Object object3 = object;
                            boolean bl6 = false;
                            object3.write(buffer, l2);
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            ((Timeout)object2).timeout(l5, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                ((Timeout)object2).deadlineNanoTime(l6);
                            }
                        }
                    }
                    if (timeout2.hasDeadline()) {
                        ((Timeout)object2).deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        boolean bl7 = false;
                        Object object4 = object;
                        boolean bl8 = false;
                        object4.write(buffer, l2);
                        Unit unit = Unit.INSTANCE;
                    }
                    finally {
                        ((Timeout)object2).timeout(l5, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            ((Timeout)object2).clearDeadline();
                        }
                    }
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void flush() {
                Object object;
                Object object2;
                Sink sink2 = null;
                Object object3 = this.this$0.getLock();
                Pipe pipe = this.this$0;
                object3.lock();
                try {
                    boolean bl = false;
                    if (!(!pipe.getSinkClosed$okio())) {
                        boolean bl2 = false;
                        String string = "closed";
                        throw new IllegalStateException(string.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    Sink sink3 = pipe.getFoldedSink$okio();
                    if (sink3 != null) {
                        object2 = sink3;
                        boolean bl3 = false;
                        sink2 = object2;
                    } else if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                        throw new IOException("source is closed");
                    }
                    object = Unit.INSTANCE;
                }
                finally {
                    object3.unlock();
                }
                object3 = sink2;
                if (object3 != null) {
                    pipe = this.this$0;
                    object = object3;
                    boolean bl = false;
                    object2 = object.timeout();
                    Timeout timeout2 = pipe.sink().timeout();
                    boolean bl4 = false;
                    long l = ((Timeout)object2).timeoutNanos();
                    ((Timeout)object2).timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), ((Timeout)object2).timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (((Timeout)object2).hasDeadline()) {
                        long l2 = ((Timeout)object2).deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            ((Timeout)object2).deadlineNanoTime(Math.min(((Timeout)object2).deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            boolean bl5 = false;
                            Object object4 = object;
                            boolean bl6 = false;
                            object4.flush();
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            ((Timeout)object2).timeout(l, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                ((Timeout)object2).deadlineNanoTime(l2);
                            }
                        }
                    }
                    if (timeout2.hasDeadline()) {
                        ((Timeout)object2).deadlineNanoTime(timeout2.deadlineNanoTime());
                    }
                    try {
                        boolean bl7 = false;
                        Object object5 = object;
                        boolean bl8 = false;
                        object5.flush();
                        object5 = Unit.INSTANCE;
                    }
                    finally {
                        ((Timeout)object2).timeout(l, TimeUnit.NANOSECONDS);
                        if (timeout2.hasDeadline()) {
                            ((Timeout)object2).clearDeadline();
                        }
                    }
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void close() {
                Object object;
                Sink sink2 = null;
                Object object2 = this.this$0.getLock();
                Pipe pipe = this.this$0;
                object2.lock();
                try {
                    boolean bl = false;
                    if (pipe.getSinkClosed$okio()) {
                        return;
                    }
                    Sink sink3 = pipe.getFoldedSink$okio();
                    if (sink3 != null) {
                        Sink sink4 = sink3;
                        boolean bl2 = false;
                        sink2 = sink4;
                    } else {
                        if (pipe.getSourceClosed$okio() && pipe.getBuffer$okio().size() > 0L) {
                            throw new IOException("source is closed");
                        }
                        pipe.setSinkClosed$okio(true);
                        pipe.getCondition().signalAll();
                    }
                    object = Unit.INSTANCE;
                }
                finally {
                    object2.unlock();
                }
                object2 = sink2;
                if (object2 != null) {
                    pipe = this.this$0;
                    object = object2;
                    boolean bl = false;
                    Timeout timeout2 = object.timeout();
                    Timeout timeout3 = pipe.sink().timeout();
                    boolean bl3 = false;
                    long l = timeout2.timeoutNanos();
                    timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
                    if (timeout2.hasDeadline()) {
                        long l2 = timeout2.deadlineNanoTime();
                        if (timeout3.hasDeadline()) {
                            timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
                        }
                        try {
                            boolean bl4 = false;
                            Object object3 = object;
                            boolean bl5 = false;
                            object3.close();
                            Unit unit = Unit.INSTANCE;
                        }
                        finally {
                            timeout2.timeout(l, TimeUnit.NANOSECONDS);
                            if (timeout3.hasDeadline()) {
                                timeout2.deadlineNanoTime(l2);
                            }
                        }
                    }
                    if (timeout3.hasDeadline()) {
                        timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
                    }
                    try {
                        boolean bl6 = false;
                        Object object4 = object;
                        boolean bl7 = false;
                        object4.close();
                        object4 = Unit.INSTANCE;
                    }
                    finally {
                        timeout2.timeout(l, TimeUnit.NANOSECONDS);
                        if (timeout3.hasDeadline()) {
                            timeout2.clearDeadline();
                        }
                    }
                }
            }

            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
        this.source = new Source(this){
            @NotNull
            private final Timeout timeout;
            final /* synthetic */ Pipe this$0;
            {
                this.this$0 = pipe;
                this.timeout = new Timeout();
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public long read(@NotNull Buffer buffer, long l) {
                Intrinsics.checkNotNullParameter(buffer, "sink");
                Lock lock = this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean bl = false;
                    if (!(!pipe.getSourceClosed$okio())) {
                        boolean bl2 = false;
                        String string = "closed";
                        throw new IllegalStateException(string.toString());
                    }
                    if (pipe.getCanceled$okio()) {
                        throw new IOException("canceled");
                    }
                    while (pipe.getBuffer$okio().size() == 0L) {
                        if (pipe.getSinkClosed$okio()) {
                            long l2 = -1L;
                            return l2;
                        }
                        this.timeout.awaitSignal(pipe.getCondition());
                        if (!pipe.getCanceled$okio()) continue;
                        throw new IOException("canceled");
                    }
                    long l3 = pipe.getBuffer$okio().read(buffer, l);
                    pipe.getCondition().signalAll();
                    long l4 = l3;
                    return l4;
                }
                finally {
                    lock.unlock();
                }
            }

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void close() {
                Lock lock = this.this$0.getLock();
                Pipe pipe = this.this$0;
                lock.lock();
                try {
                    boolean bl = false;
                    pipe.setSourceClosed$okio(true);
                    pipe.getCondition().signalAll();
                    Unit unit = Unit.INSTANCE;
                }
                finally {
                    lock.unlock();
                }
            }

            @NotNull
            public Timeout timeout() {
                return this.timeout;
            }
        };
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    @NotNull
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    public final boolean getCanceled$okio() {
        return this.canceled;
    }

    public final void setCanceled$okio(boolean bl) {
        this.canceled = bl;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final void setSinkClosed$okio(boolean bl) {
        this.sinkClosed = bl;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setSourceClosed$okio(boolean bl) {
        this.sourceClosed = bl;
    }

    @Nullable
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final void setFoldedSink$okio(@Nullable Sink sink2) {
        this.foldedSink = sink2;
    }

    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }

    @NotNull
    public final Condition getCondition() {
        return this.condition;
    }

    @JvmName(name="sink")
    @NotNull
    public final Sink sink() {
        return this.sink;
    }

    @JvmName(name="source")
    @NotNull
    public final Source source() {
        return this.source;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void fold(@NotNull Sink sink2) throws IOException {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        while (true) {
            boolean bl = false;
            Buffer buffer = null;
            Lock lock = this.lock;
            lock.lock();
            try {
                boolean bl2 = false;
                if (!(this.foldedSink == null)) {
                    boolean bl3 = false;
                    String string = "sink already folded";
                    throw new IllegalStateException(string.toString());
                }
                if (this.canceled) {
                    this.foldedSink = sink2;
                    throw new IOException("canceled");
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink2;
                    return;
                }
                bl = this.sinkClosed;
                buffer = new Buffer();
                buffer.write(this.buffer, this.buffer.size());
                this.condition.signalAll();
                Unit unit = Unit.INSTANCE;
            }
            finally {
                lock.unlock();
            }
            boolean bl4 = false;
            try {
                sink2.write(buffer, buffer.size());
                if (bl) {
                    sink2.close();
                } else {
                    sink2.flush();
                }
                bl4 = true;
            }
            catch (Throwable throwable) {
                Lock lock2 = this.lock;
                lock2.lock();
                try {
                    boolean bl5 = false;
                    this.sourceClosed = true;
                    this.condition.signalAll();
                    Unit unit = Unit.INSTANCE;
                    throw throwable;
                }
                finally {
                    lock2.unlock();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void forward(Sink sink2, Function1<? super Sink, Unit> function1) {
        boolean bl = false;
        Timeout timeout2 = sink2.timeout();
        Timeout timeout3 = this.sink().timeout();
        boolean bl2 = false;
        long l = timeout2.timeoutNanos();
        timeout2.timeout(Timeout.Companion.minTimeout(timeout3.timeoutNanos(), timeout2.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (timeout2.hasDeadline()) {
            long l2 = timeout2.deadlineNanoTime();
            if (timeout3.hasDeadline()) {
                timeout2.deadlineNanoTime(Math.min(timeout2.deadlineNanoTime(), timeout3.deadlineNanoTime()));
            }
            try {
                boolean bl3 = false;
                function1.invoke(sink2);
                Unit unit = Unit.INSTANCE;
            }
            finally {
                InlineMarker.finallyStart(1);
                timeout2.timeout(l, TimeUnit.NANOSECONDS);
                if (timeout3.hasDeadline()) {
                    timeout2.deadlineNanoTime(l2);
                }
                InlineMarker.finallyEnd(1);
            }
        }
        if (timeout3.hasDeadline()) {
            timeout2.deadlineNanoTime(timeout3.deadlineNanoTime());
        }
        try {
            boolean bl4 = false;
            function1.invoke(sink2);
            Unit unit = Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart(1);
            timeout2.timeout(l, TimeUnit.NANOSECONDS);
            if (timeout3.hasDeadline()) {
                timeout2.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="sink", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_sink")
    @NotNull
    public final Sink m74f7b86f9c() {
        return this.sink;
    }

    @kotlin.Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="source", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_source")
    @NotNull
    public final Source m4dee6b53ab() {
        return this.source;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void cancel() {
        Lock lock = this.lock;
        lock.lock();
        try {
            boolean bl = false;
            this.canceled = true;
            this.buffer.clear();
            this.condition.signalAll();
            Unit unit = Unit.INSTANCE;
        }
        finally {
            lock.unlock();
        }
    }
}

