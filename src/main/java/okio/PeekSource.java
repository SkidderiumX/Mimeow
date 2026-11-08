package okio;

import kotlin.*;
import org.jetbrains.annotations.*;
import kotlin.jvm.internal.*;

@Metadata(mv = { 1, 9, 0 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio" })
@SourceDebugExtension({ "SMAP\nPeekSource.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeekSource.kt\nokio/PeekSource\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,74:1\n1#2:75\n*E\n" })
public class PeekSource implements Source
{
    @NotNull
    private final BufferedSource upstream;
    @NotNull
    private final Buffer buffer;
    @Nullable
    private Segment expectedSegment;
    private int expectedPos;
    private boolean closed;
    private long pos;
    
    public PeekSource(@NotNull final BufferedSource upstream) {
        Intrinsics.checkNotNullParameter(upstream, "upstream");
        this.upstream = upstream;
        this.buffer = this.upstream.getBuffer();
        this.expectedSegment = this.buffer.head;
        final Segment head = this.buffer.head;
        this.expectedPos = ((head != null) ? head.pos : -1);
    }
    
    @Override
    public long read(@NotNull final Buffer buffer, final long n) {
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (n < 0L) {
            throw new IllegalArgumentException(("byteCount < 0: " + n).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        boolean b = false;
        Label_0139: {
            Label_0134: {
                if (this.expectedSegment != null) {
                    if (this.expectedSegment == this.buffer.head) {
                        final int expectedPos = this.expectedPos;
                        final Segment head = this.buffer.head;
                        Intrinsics.checkNotNull(head);
                        if (expectedPos == head.pos) {
                            break Label_0134;
                        }
                    }
                    b = false;
                    break Label_0139;
                }
            }
            b = true;
        }
        if (!b) {
            throw new IllegalStateException("Peek source is invalid because upstream source was used".toString());
        }
        if (n == 0L) {
            return 0L;
        }
        if (!this.upstream.request(this.pos + 1L)) {
            return -1L;
        }
        if (this.expectedSegment == null && this.buffer.head != null) {
            this.expectedSegment = this.buffer.head;
            final Segment head2 = this.buffer.head;
            Intrinsics.checkNotNull(head2);
            this.expectedPos = head2.pos;
        }
        final long min = Math.min(n, this.buffer.size() - this.pos);
        this.buffer.copyTo(buffer, this.pos, min);
        this.pos += min;
        return min;
    }
    
    @NotNull
    @Override
    public Timeout timeout() {
        return this.upstream.timeout();
    }
    
    @Override
    public void close() {
        this.closed = true;
    }
}
