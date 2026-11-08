/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\u0000H\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016J\u0016\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0014\u001a\u00020\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0016H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u001d"}, d2={"Lokio/Timeout;", "", "()V", "deadlineNanoTime", "", "hasDeadline", "", "timeoutNanos", "awaitSignal", "", "condition", "Ljava/util/concurrent/locks/Condition;", "clearDeadline", "clearTimeout", "deadline", "duration", "unit", "Ljava/util/concurrent/TimeUnit;", "intersectWith", "T", "other", "block", "Lkotlin/Function0;", "(Lokio/Timeout;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfReached", "timeout", "waitUntilNotified", "monitor", "Companion", "okio"})
@SourceDebugExtension(value={"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nokio/Timeout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,316:1\n1#2:317\n*E\n"})
public class Timeout {
    @NotNull
    public static final Companion Companion = new Companion(null);
    private boolean hasDeadline;
    private long deadlineNanoTime;
    private long timeoutNanos;
    @JvmField
    @NotNull
    public static final Timeout NONE = new Timeout(){

        @NotNull
        public Timeout timeout(long l, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter((Object)((Object)timeUnit), "unit");
            return this;
        }

        @NotNull
        public Timeout deadlineNanoTime(long l) {
            return this;
        }

        public void throwIfReached() {
        }
    };

    @NotNull
    public Timeout timeout(long l, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)timeUnit, "unit");
        if (!(l >= 0L)) {
            boolean bl = false;
            String string = "timeout < 0: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        this.timeoutNanos = timeUnit.toNanos(l);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
            boolean bl = false;
            String string = "No deadline";
            throw new IllegalStateException(string.toString());
        }
        return this.deadlineNanoTime;
    }

    @NotNull
    public Timeout deadlineNanoTime(long l) {
        this.hasDeadline = true;
        this.deadlineNanoTime = l;
        return this;
    }

    @NotNull
    public final Timeout deadline(long l, @NotNull TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter((Object)timeUnit, "unit");
        if (!(l > 0L)) {
            boolean bl = false;
            String string = "duration <= 0: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        return this.deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(l));
    }

    @NotNull
    public Timeout clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    @NotNull
    public Timeout clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public void throwIfReached() throws IOException {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0L) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public final void awaitSignal(@NotNull Condition condition) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(condition, "condition");
        try {
            long l;
            long l2;
            boolean bl = this.hasDeadline();
            long l3 = this.timeoutNanos();
            if (!bl && l3 == 0L) {
                condition.await();
                return;
            }
            long l4 = System.nanoTime();
            if (bl && l3 != 0L) {
                l2 = this.deadlineNanoTime() - l4;
                l = Math.min(l3, l2);
            } else {
                l = bl ? this.deadlineNanoTime() - l4 : l3;
            }
            long l5 = l;
            l2 = 0L;
            if (l5 > 0L) {
                condition.await(l5, TimeUnit.NANOSECONDS);
                l2 = System.nanoTime() - l4;
            }
            if (l2 >= l5) {
                throw new InterruptedIOException("timeout");
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    public final void waitUntilNotified(@NotNull Object object) throws InterruptedIOException {
        Intrinsics.checkNotNullParameter(object, "monitor");
        try {
            long l;
            long l2;
            boolean bl = this.hasDeadline();
            long l3 = this.timeoutNanos();
            if (!bl && l3 == 0L) {
                object.wait();
                return;
            }
            long l4 = System.nanoTime();
            if (bl && l3 != 0L) {
                l2 = this.deadlineNanoTime() - l4;
                l = Math.min(l3, l2);
            } else {
                l = bl ? this.deadlineNanoTime() - l4 : l3;
            }
            long l5 = l;
            l2 = 0L;
            if (l5 > 0L) {
                long l6 = l5 / 1000000L;
                object.wait(l6, (int)(l5 - l6 * 1000000L));
                l2 = System.nanoTime() - l4;
            }
            if (l2 >= l5) {
                throw new InterruptedIOException("timeout");
            }
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final <T> T intersectWith(@NotNull Timeout timeout2, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(timeout2, "other");
        Intrinsics.checkNotNullParameter(function0, "block");
        boolean bl = false;
        long l = this.timeoutNanos();
        this.timeout(Companion.minTimeout(timeout2.timeoutNanos(), this.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (this.hasDeadline()) {
            long l2 = this.deadlineNanoTime();
            if (timeout2.hasDeadline()) {
                this.deadlineNanoTime(Math.min(this.deadlineNanoTime(), timeout2.deadlineNanoTime()));
            }
            try {
                T t = function0.invoke();
                return t;
            }
            finally {
                InlineMarker.finallyStart(1);
                this.timeout(l, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    this.deadlineNanoTime(l2);
                }
                InlineMarker.finallyEnd(1);
            }
        }
        if (timeout2.hasDeadline()) {
            this.deadlineNanoTime(timeout2.deadlineNanoTime());
        }
        try {
            T t = function0.invoke();
            return t;
        }
        finally {
            InlineMarker.finallyStart(1);
            this.timeout(l, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                this.clearDeadline();
            }
            InlineMarker.finallyEnd(1);
        }
    }

    @Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2={"Lokio/Timeout$Companion;", "", "()V", "NONE", "Lokio/Timeout;", "minTimeout", "", "aNanos", "bNanos", "okio"})
    public static final class Companion {
        private Companion() {
        }

        public final long minTimeout(long l, long l2) {
            return l == 0L ? l2 : (l2 == 0L ? l : (l < l2 ? l : l2));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

