/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSink;
import okio.DeflaterSink;
import okio.RealBufferedSink;
import okio.Segment;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\r\u0010\b\u001a\u00020\tH\u0007\u00a2\u0006\u0002\b\u0010J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u00020\t8G\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"})
@SourceDebugExtension(value={"SMAP\nGzipSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n+ 2 RealBufferedSink.kt\nokio/RealBufferedSink\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,153:1\n51#2:154\n1#3:155\n86#4:156\n*S KotlinDebug\n*F\n+ 1 GzipSink.kt\nokio/GzipSink\n*L\n63#1:154\n131#1:156\n*E\n"})
public class GzipSink
implements Sink {
    @NotNull
    private final RealBufferedSink sink;
    @NotNull
    private final Deflater deflater;
    @NotNull
    private final DeflaterSink deflaterSink;
    private boolean closed;
    @NotNull
    private final CRC32 crc;

    public GzipSink(@NotNull Sink sink2) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        this.sink = new RealBufferedSink(sink2);
        this.deflater = new Deflater(-1, true);
        this.deflaterSink = new DeflaterSink(this.sink, this.deflater);
        this.crc = new CRC32();
        BufferedSink bufferedSink = this.sink;
        boolean bl = false;
        BufferedSink bufferedSink2 = bufferedSink = ((RealBufferedSink)bufferedSink).bufferField;
        boolean bl2 = false;
        ((Buffer)bufferedSink2).writeShort(8075);
        ((Buffer)bufferedSink2).writeByte(8);
        ((Buffer)bufferedSink2).writeByte(0);
        ((Buffer)bufferedSink2).writeInt(0);
        ((Buffer)bufferedSink2).writeByte(0);
        ((Buffer)bufferedSink2).writeByte(0);
    }

    @JvmName(name="deflater")
    @NotNull
    public final Deflater deflater() {
        return this.deflater;
    }

    @Override
    public void write(@NotNull Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "source");
        if (!(l >= 0L)) {
            boolean bl = false;
            String string = "byteCount < 0: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        if (l == 0L) {
            return;
        }
        this.updateCrc(buffer, l);
        this.deflaterSink.write(buffer, l);
    }

    @Override
    public void flush() throws IOException {
        this.deflaterSink.flush();
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @Override
    public void close() throws IOException {
        Throwable throwable;
        block9: {
            block8: {
                if (this.closed) {
                    return;
                }
                throwable = null;
                try {
                    this.deflaterSink.finishDeflate$okio();
                    this.writeFooter();
                }
                catch (Throwable throwable2) {
                    throwable = throwable2;
                }
                try {
                    this.deflater.end();
                }
                catch (Throwable throwable3) {
                    if (throwable != null) break block8;
                    throwable = throwable3;
                }
            }
            try {
                this.sink.close();
            }
            catch (Throwable throwable4) {
                if (throwable != null) break block9;
                throwable = throwable4;
            }
        }
        this.closed = true;
        Throwable throwable5 = throwable;
        if (throwable5 != null) {
            throw throwable5;
        }
    }

    private final void writeFooter() {
        this.sink.writeIntLe((int)this.crc.getValue());
        this.sink.writeIntLe((int)this.deflater.getBytesRead());
    }

    private final void updateCrc(Buffer buffer, long l) {
        int n;
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment;
        for (long i = l; i > 0L; i -= (long)n) {
            int n2 = segment2.limit - segment2.pos;
            boolean bl = false;
            n = (int)Math.min(i, (long)n2);
            this.crc.update(segment2.data, segment2.pos, n);
            Intrinsics.checkNotNull(segment2.next);
        }
    }

    @Deprecated(message="moved to val", replaceWith=@ReplaceWith(expression="deflater", imports={}), level=DeprecationLevel.ERROR)
    @JvmName(name="-deprecated_deflater")
    @NotNull
    public final Deflater mbd22fdcf99() {
        return this.deflater;
    }
}

