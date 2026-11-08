/*
 * Decompiled with CFR 0.152.
 */
package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=2, xi=48, d1={"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b\u00a8\u0006*"}, d2={"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"})
@JvmName(name="DRealBufferedSink")
@SourceDebugExtension(value={"SMAP\nRealBufferedSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/DRealBufferedSink\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSink.kt\nokio/RealBufferedSink\n*L\n1#1,219:1\n1#2:220\n51#3:221\n51#3:222\n51#3:223\n51#3:224\n51#3:225\n51#3:226\n51#3:227\n51#3:228\n51#3:229\n51#3:230\n51#3:231\n51#3:232\n51#3:233\n51#3:234\n51#3:235\n51#3:236\n51#3:237\n51#3:238\n51#3:239\n51#3:240\n51#3:241\n51#3:242\n51#3:243\n51#3:244\n51#3:245\n51#3:246\n51#3:247\n*S KotlinDebug\n*F\n+ 1 RealBufferedSink.kt\nokio/internal/DRealBufferedSink\n*L\n35#1:221\n41#1:222\n51#1:223\n57#1:224\n67#1:225\n73#1:226\n79#1:227\n89#1:228\n96#1:229\n107#1:230\n117#1:231\n123#1:232\n129#1:233\n135#1:234\n141#1:235\n147#1:236\n153#1:237\n159#1:238\n165#1:239\n171#1:240\n172#1:241\n178#1:242\n179#1:243\n185#1:244\n186#1:245\n198#1:246\n199#1:247\n*E\n"})
public class DRealBufferedSink {
    public static final void commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull Buffer buffer, long l) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "source");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(buffer, l);
        realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byteString);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull ByteString byteString, int n, int n2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byteString, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink, @NotNull String string) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8(string);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8(@NotNull RealBufferedSink realBufferedSink, @NotNull String string, int n, int n2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string2 = "closed";
            throw new IllegalStateException(string2.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8(string, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteUtf8CodePoint(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeUtf8CodePoint(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] byArray) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byArray, "source");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byArray);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull byte[] byArray, int n, int n2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(byArray, "source");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.write(byArray, n, n2);
        return realBufferedSink.emitCompleteSegments();
    }

    public static final long commonWriteAll(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source2) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source");
        boolean bl = false;
        long l = 0L;
        while (true) {
            RealBufferedSink realBufferedSink2 = realBufferedSink;
            boolean bl2 = false;
            long l2 = source2.read(realBufferedSink2.bufferField, 8192L);
            if (l2 == -1L) break;
            l += l2;
            realBufferedSink.emitCompleteSegments();
        }
        return l;
    }

    @NotNull
    public static final BufferedSink commonWrite(@NotNull RealBufferedSink realBufferedSink, @NotNull Source source2, long l) {
        long l2;
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        Intrinsics.checkNotNullParameter(source2, "source");
        boolean bl = false;
        for (long i = l; i > 0L; i -= l2) {
            RealBufferedSink realBufferedSink2 = realBufferedSink;
            boolean bl2 = false;
            l2 = source2.read(realBufferedSink2.bufferField, i);
            if (l2 == -1L) {
                throw new EOFException();
            }
            realBufferedSink.emitCompleteSegments();
        }
        return realBufferedSink;
    }

    @NotNull
    public static final BufferedSink commonWriteByte(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeByte(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShort(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeShort(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteShortLe(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeShortLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteInt(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeInt(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteIntLe(@NotNull RealBufferedSink realBufferedSink, int n) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeIntLe(n);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLong(@NotNull RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteLongLe(@NotNull RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeLongLe(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteDecimalLong(@NotNull RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeDecimalLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@NotNull RealBufferedSink realBufferedSink, long l) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        realBufferedSink2.bufferField.writeHexadecimalUnsignedLong(l);
        return realBufferedSink.emitCompleteSegments();
    }

    @NotNull
    public static final BufferedSink commonEmitCompleteSegments(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        long l = realBufferedSink2.bufferField.completeSegmentByteCount();
        if (l > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, l);
        }
        return realBufferedSink;
    }

    @NotNull
    public static final BufferedSink commonEmit(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        long l = realBufferedSink2.bufferField.size();
        if (l > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, l);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        if (!(!realBufferedSink.closed)) {
            boolean bl2 = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        RealBufferedSink realBufferedSink2 = realBufferedSink;
        boolean bl3 = false;
        if (realBufferedSink2.bufferField.size() > 0L) {
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink2 = realBufferedSink;
            bl3 = false;
            realBufferedSink.sink.write(realBufferedSink2.bufferField, realBufferedSink2.bufferField.size());
        }
        realBufferedSink.sink.flush();
    }

    public static final void commonClose(@NotNull RealBufferedSink realBufferedSink) {
        Throwable throwable;
        block7: {
            Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
            boolean bl = false;
            if (realBufferedSink.closed) {
                return;
            }
            throwable = null;
            try {
                RealBufferedSink realBufferedSink2 = realBufferedSink;
                boolean bl2 = false;
                if (realBufferedSink2.bufferField.size() > 0L) {
                    realBufferedSink2 = realBufferedSink;
                    bl2 = false;
                    realBufferedSink2 = realBufferedSink;
                    bl2 = false;
                    realBufferedSink.sink.write(realBufferedSink2.bufferField, realBufferedSink2.bufferField.size());
                }
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
            }
            try {
                realBufferedSink.sink.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block7;
                throwable = throwable3;
            }
        }
        realBufferedSink.closed = true;
        Throwable throwable4 = throwable;
        if (throwable4 != null) {
            throw throwable4;
        }
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        return realBufferedSink.sink.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSink realBufferedSink) {
        Intrinsics.checkNotNullParameter(realBufferedSink, "<this>");
        boolean bl = false;
        return "buffer(" + realBufferedSink.sink + ')';
    }
}

