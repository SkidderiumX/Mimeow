/*
 * Decompiled with CFR 0.152.
 */
package okio;

import java.io.IOException;
import javax.crypto.Cipher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okio.Buffer;
import okio.BufferedSource;
import okio.Segment;
import okio.SegmentPool;
import okio.Source;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 9, 0}, k=1, xi=48, d1={"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0011H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2={"Lokio/CipherSource;", "Lokio/Source;", "source", "Lokio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "blockSize", "", "buffer", "Lokio/Buffer;", "getCipher", "()Ljavax/crypto/Cipher;", "closed", "", "final", "close", "", "doFinal", "read", "", "sink", "byteCount", "refill", "timeout", "Lokio/Timeout;", "update", "okio"})
@SourceDebugExtension(value={"SMAP\nCipherSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CipherSource.kt\nokio/CipherSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,120:1\n1#2:121\n*E\n"})
public class CipherSource
implements Source {
    @NotNull
    private final BufferedSource source;
    @NotNull
    private final Cipher cipher;
    private final int blockSize;
    @NotNull
    private final Buffer buffer;
    private boolean f0e49beadc3;
    private boolean closed;

    public CipherSource(@NotNull BufferedSource bufferedSource, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.source = bufferedSource;
        this.cipher = cipher;
        this.blockSize = this.cipher.getBlockSize();
        this.buffer = new Buffer();
        if (!(this.blockSize > 0)) {
            boolean bl = false;
            String string = "Block cipher required " + this.cipher;
            throw new IllegalArgumentException(string.toString());
        }
    }

    @NotNull
    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override
    public long read(@NotNull Buffer buffer, long l) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(l >= 0L)) {
            boolean bl = false;
            String string = "byteCount < 0: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        if (!(!this.closed)) {
            boolean bl = false;
            String string = "closed";
            throw new IllegalStateException(string.toString());
        }
        if (l == 0L) {
            return 0L;
        }
        this.refill();
        return this.buffer.read(buffer, l);
    }

    private final void refill() {
        while (this.buffer.size() == 0L && !this.f0e49beadc3) {
            if (this.source.exhausted()) {
                this.f0e49beadc3 = true;
                this.doFinal();
                break;
            }
            this.update();
        }
    }

    private final void update() {
        Segment segment = this.source.getBuffer().head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment;
        int n = segment2.limit - segment2.pos;
        int n2 = this.cipher.getOutputSize(n);
        while (n2 > 8192) {
            if (n <= this.blockSize) {
                this.f0e49beadc3 = true;
                byte[] byArray = this.cipher.doFinal(this.source.readByteArray());
                Intrinsics.checkNotNullExpressionValue(byArray, "doFinal(...)");
                this.buffer.write(byArray);
                return;
            }
            n2 = this.cipher.getOutputSize(n -= this.blockSize);
        }
        Segment segment3 = this.buffer.writableSegment$okio(n2);
        int n3 = this.cipher.update(segment2.data, segment2.pos, n, segment3.data, segment3.pos);
        this.source.skip(n);
        segment3.limit += n3;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + (long)n3);
        if (segment3.pos == segment3.limit) {
            this.buffer.head = segment3.pop();
            SegmentPool.recycle(segment3);
        }
    }

    private final void doFinal() {
        int n = this.cipher.getOutputSize(0);
        if (n == 0) {
            return;
        }
        Segment segment = this.buffer.writableSegment$okio(n);
        int n2 = this.cipher.doFinal(segment.data, segment.pos);
        segment.limit += n2;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + (long)n2);
        if (segment.pos == segment.limit) {
            this.buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
    }

    @Override
    @NotNull
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }
}

