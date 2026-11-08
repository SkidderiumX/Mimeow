package okio;

import org.jetbrains.annotations.*;
import kotlin.jvm.*;
import kotlin.jvm.functions.*;
import java.io.*;
import kotlin.jvm.internal.*;
import kotlin.*;

@Metadata(mv = { 1, 9, 0 }, k = 5, xi = 48, d1 = { "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\b\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0005*\u00020\u0006\u001aA\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f" }, d2 = { "blackholeSink", "Lokio/Sink;", "blackhole", "buffer", "Lokio/BufferedSink;", "Lokio/BufferedSource;", "Lokio/Source;", "use", "R", "T", "Ljava/io/Closeable;", "Lokio/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "okio" }, xs = "okio/Okio")
public final class Okio__OkioKt
{
    @NotNull
    public static final BufferedSource buffer(@NotNull final Source source) {
        Intrinsics.checkNotNullParameter(source, "<this>");
        return new RealBufferedSource(source);
    }
    
    @NotNull
    public static final BufferedSink buffer(@NotNull final Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "<this>");
        return new RealBufferedSink(sink);
    }
    
    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return new BlackholeSink();
    }
    
    public static final <T extends Closeable, R> R use(final T t, @NotNull final Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        R invoke = null;
        Throwable t2 = null;
        try {
            invoke = (R)function1.invoke(t);
        }
        catch (final Throwable t3) {
            t2 = t3;
            InlineMarker.finallyStart(1);
            try {
                if (t != null) {
                    t.close();
                }
            }
            catch (final Throwable t4) {
                if (t2 == null) {
                    t2 = t4;
                }
                else {
                    ExceptionsKt__ExceptionsKt.addSuppressed(t2, t4);
                }
            }
            InlineMarker.finallyEnd(1);
        }
        finally {
            InlineMarker.finallyStart(1);
            try {
                if (t != null) {
                    t.close();
                }
            }
            catch (final Throwable t5) {
                t2 = t5;
            }
            InlineMarker.finallyEnd(1);
        }
        final Throwable t6 = t2;
        if (t6 != null) {
            throw t6;
        }
        final R r = invoke;
        Intrinsics.checkNotNull(r);
        return r;
    }
}
