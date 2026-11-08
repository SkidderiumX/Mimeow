/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.DSegmentedByteString;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Segment;
import okio.SegmentPool;
import okio.Sink;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0002J\r\u0010\u000e\u001a\u00020\u000bH\u0000\u00a2\u0006\u0002\b\u000fJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2={"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"})
@SourceDebugExtension(value={"SMAP\nDeflaterSink.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n+ 2 Util.kt\nokio/DSegmentedByteString\n*L\n1#1,163:1\n86#2:164\n*S KotlinDebug\n*F\n+ 1 DeflaterSink.kt\nokio/DeflaterSink\n*L\n58#1:164\n*E\n"})
public class DeflaterSink
implements Sink {
    @NotNull
    private final BufferedSink sink;
    @NotNull
    private final Deflater deflater;
    private boolean closed;

    public DeflaterSink(@NotNull BufferedSink bufferedSink, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = bufferedSink;
        this.deflater = deflater;
    }

    public DeflaterSink(@NotNull Sink sink2, @NotNull Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink2, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this(Okio.buffer(sink2), deflater);
    }

    @Override
    public void write(@NotNull Buffer buffer, long l) throws IOException {
        int n;
        Intrinsics.checkNotNullParameter(buffer, "source");
        DSegmentedByteString.checkOffsetAndCount(buffer.size(), 0L, l);
        for (long i = l; i > 0L; i -= (long)n) {
            Segment segment;
            Intrinsics.checkNotNull(buffer.head);
            int n2 = segment.limit - segment.pos;
            boolean bl = false;
            n = (int)Math.min(i, (long)n2);
            this.deflater.setInput(segment.data, segment.pos, n);
            this.deflate(false);
            buffer.setSize$okio(buffer.size() - (long)n);
            segment.pos += n;
            if (segment.pos != segment.limit) continue;
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
    }

    private final void deflate(boolean bl) {
        Segment segment;
        Buffer buffer = this.sink.getBuffer();
        while (true) {
            int n;
            segment = buffer.writableSegment$okio(1);
            try {
                n = bl ? this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit, 2) : this.deflater.deflate(segment.data, segment.limit, 8192 - segment.limit);
            }
            catch (NullPointerException nullPointerException) {
                throw new IOException("Deflater already closed", nullPointerException);
            }
            int n2 = n;
            if (n2 > 0) {
                segment.limit += n2;
                buffer.setSize$okio(buffer.size() + (long)n2);
                this.sink.emitCompleteSegments();
                continue;
            }
            if (this.deflater.needsInput()) break;
        }
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
    }

    @Override
    public void flush() throws IOException {
        this.deflate(true);
        this.sink.flush();
    }

    public final void finishDeflate$okio() {
        this.deflater.finish();
        this.deflate(false);
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
                    this.finishDeflate$okio();
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

    @Override
    @NotNull
    public Timeout timeout() {
        return this.sink.timeout();
    }

    @NotNull
    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }
}

