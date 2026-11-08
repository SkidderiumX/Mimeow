/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.InflaterSource;
import okio.RealBufferedSource;
import okio.Segment;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2={"Lokio/GzipSource;", "Lokio/Source;", "source", "(Lokio/Source;)V", "crc", "Ljava/util/zip/CRC32;", "inflater", "Ljava/util/zip/Inflater;", "inflaterSource", "Lokio/InflaterSource;", "section", "", "Lokio/RealBufferedSource;", "checkEqual", "", "name", "", "expected", "", "actual", "close", "consumeHeader", "consumeTrailer", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "offset", "okio"})
@SourceDebugExtension(value={"SMAP\nGzipSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 RealBufferedSource.kt\nokio/RealBufferedSource\n+ 4 GzipSource.kt\nokio/DGzipSourceExtensions\n+ 5 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,220:1\n1#2:221\n62#3:222\n62#3:224\n62#3:226\n62#3:227\n62#3:228\n62#3:230\n62#3:232\n202#4:223\n202#4:225\n202#4:229\n202#4:231\n89#5:233\n*S KotlinDebug\n*F\n+ 1 GzipSource.kt\nokio/GzipSource\n*L\n105#1:222\n107#1:224\n119#1:226\n120#1:227\n122#1:228\n133#1:230\n144#1:232\n106#1:223\n117#1:225\n130#1:229\n141#1:231\n187#1:233\n*E\n"})
public class GzipSource
implements Source {
    private byte section;
    @NotNull
    private final RealBufferedSource source;
    @NotNull
    private final Inflater inflater;
    @NotNull
    private final InflaterSource inflaterSource;
    @NotNull
    private final CRC32 crc;

    public GzipSource(@NotNull Source source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = new RealBufferedSource(source2);
        this.inflater = new Inflater(true);
        this.inflaterSource = new InflaterSource(this.source, this.inflater);
        this.crc = new CRC32();
    }

    @Override
    public long read(@NotNull Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(l >= 0L)) {
            boolean bl = false;
            String string = "byteCount < 0: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        if (l == 0L) {
            return 0L;
        }
        if (this.section == 0) {
            this.consumeHeader();
            this.section = 1;
        }
        if (this.section == 1) {
            long l2 = buffer.size();
            long l3 = this.inflaterSource.read(buffer, l);
            if (l3 != -1L) {
                this.updateCrc(buffer, l2, l3);
                return l3;
            }
            this.section = (byte)2;
        }
        if (this.section == 2) {
            this.consumeTrailer();
            this.section = (byte)3;
            if (!this.source.exhausted()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    private final void consumeHeader() throws IOException {
        boolean bl;
        boolean bl2;
        byte by;
        this.source.require(10L);
        RealBufferedSource realBufferedSource = this.source;
        byte by2 = 0;
        by2 = by = realBufferedSource.bufferField.getByte(3L);
        int n = 1;
        int n2 = 0;
        boolean bl3 = bl2 = (by2 >> n & 1) == 1;
        if (bl2) {
            RealBufferedSource realBufferedSource2 = this.source;
            n = 0;
            this.updateCrc(realBufferedSource2.bufferField, 0L, 10L);
        }
        short s = this.source.readShort();
        this.checkEqual("ID1ID2", 8075, s);
        this.source.skip(8L);
        n = by;
        n2 = 2;
        boolean bl4 = false;
        if ((n >> n2 & 1) == 1) {
            this.source.require(2L);
            if (bl2) {
                RealBufferedSource realBufferedSource3 = this.source;
                n2 = 0;
                this.updateCrc(realBufferedSource3.bufferField, 0L, 2L);
            }
            RealBufferedSource realBufferedSource4 = this.source;
            bl = false;
            long l = realBufferedSource4.bufferField.readShortLe() & 0xFFFF;
            this.source.require(l);
            if (bl2) {
                realBufferedSource4 = this.source;
                bl = false;
                this.updateCrc(realBufferedSource4.bufferField, 0L, l);
            }
            this.source.skip(l);
        }
        byte by3 = by;
        n2 = 3;
        bl4 = false;
        if ((by3 >> n2 & 1) == 1) {
            long l = this.source.indexOf((byte)0);
            if (l == -1L) {
                throw new EOFException();
            }
            if (bl2) {
                RealBufferedSource realBufferedSource5 = this.source;
                bl = false;
                this.updateCrc(realBufferedSource5.bufferField, 0L, l + 1L);
            }
            this.source.skip(l + 1L);
        }
        byte by4 = by;
        n2 = 4;
        boolean bl5 = false;
        if ((by4 >> n2 & 1) == 1) {
            long l = this.source.indexOf((byte)0);
            if (l == -1L) {
                throw new EOFException();
            }
            if (bl2) {
                RealBufferedSource realBufferedSource6 = this.source;
                bl = false;
                this.updateCrc(realBufferedSource6.bufferField, 0L, l + 1L);
            }
            this.source.skip(l + 1L);
        }
        if (bl2) {
            this.checkEqual("FHCRC", this.source.readShortLe(), (short)this.crc.getValue());
            this.crc.reset();
        }
    }

    private final void consumeTrailer() throws IOException {
        this.checkEqual("CRC", this.source.readIntLe(), (int)this.crc.getValue());
        this.checkEqual("ISIZE", this.source.readIntLe(), (int)this.inflater.getBytesWritten());
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    public void close() throws IOException {
        this.inflaterSource.close();
    }

    private final void updateCrc(Buffer buffer, long l, long l2) {
        long l3;
        long l4 = l2;
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment;
        for (l3 = l; l3 >= (long)(segment2.limit - segment2.pos); l3 -= (long)(segment2.limit - segment2.pos)) {
            Intrinsics.checkNotNull(segment2.next);
        }
        while (l4 > 0L) {
            int n = (int)((long)segment2.pos + l3);
            int n2 = segment2.limit - n;
            boolean bl = false;
            int n3 = (int)Math.min((long)n2, l4);
            this.crc.update(segment2.data, n, n3);
            l4 -= (long)n3;
            l3 = 0L;
            Intrinsics.checkNotNull(segment2.next);
        }
    }

    private final void checkEqual(String string, int n, int n2) {
        if (n2 != n) {
            String string2 = "%s: actual 0x%08x != expected 0x%08x";
            Object[] objectArray = new Object[]{string, n2, n};
            String string3 = String.format(string2, Arrays.copyOf(objectArray, objectArray.length));
            Intrinsics.checkNotNullExpressionValue(string3, "format(this, *args)");
            throw new IOException(string3);
        }
    }
}

