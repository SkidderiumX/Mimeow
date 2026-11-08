/*
 * Decompiled with CFR 0.152.
 */
package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Hpack;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Settings;
import okio.Buffer;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ(\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u0011J&\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000fJ\u001e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'J$\u0010(\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\u0006\u0010,\u001a\u00020\u000fJ\u001e\u0010-\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020\u000fJ$\u00101\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020+0*J\u0016\u00104\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020%J\u000e\u00105\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u0013J\u0016\u00106\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u00107\u001a\u000208J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u000208H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2={"Lokhttp3/internal/http2/Http2Writer;", "Ljava/io/Closeable;", "sink", "Lokio/BufferedSink;", "client", "", "(Lokio/BufferedSink;Z)V", "closed", "hpackBuffer", "Lokio/Buffer;", "hpackWriter", "Lokhttp3/internal/http2/Hpack$Writer;", "getHpackWriter", "()Lokhttp3/internal/http2/Hpack$Writer;", "maxFrameSize", "", "applyAndAckSettings", "", "peerSettings", "Lokhttp3/internal/http2/Settings;", "close", "connectionPreface", "data", "outFinished", "streamId", "source", "byteCount", "dataFrame", "flags", "buffer", "flush", "frameHeader", "length", "type", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "", "headers", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "maxDataLength", "ping", "ack", "payload1", "payload2", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "settings", "windowUpdate", "windowSizeIncrement", "", "writeContinuationFrames", "Companion", "okhttp"})
@SourceDebugExtension(value={"SMAP\nHttp2Writer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Http2Writer.kt\nokhttp3/internal/http2/Http2Writer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,317:1\n1#2:318\n*E\n"})
public class Http2Writer
implements Closeable {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final BufferedSink sink;
    private final boolean client;
    @NotNull
    private final Buffer hpackBuffer;
    private int maxFrameSize;
    private boolean closed;
    @NotNull
    private final Hpack.Writer hpackWriter;
    private static final Logger logger = Logger.getLogger(Http2.class.getName());

    public Http2Writer(@NotNull BufferedSink bufferedSink, boolean bl) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        this.sink = bufferedSink;
        this.client = bl;
        this.hpackBuffer = new Buffer();
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, this.hpackBuffer, 3, null);
    }

    @NotNull
    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void connectionPreface() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!this.client) {
            return;
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Util.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
        }
        this.sink.write(Http2.CONNECTION_PREFACE);
        this.sink.flush();
    }

    public final synchronized void applyAndAckSettings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "peerSettings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
        if (settings.getHeaderTableSize() != -1) {
            this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
        }
        this.frameHeader(0, 0, 4, 1);
        this.sink.flush();
    }

    public final synchronized void pushPromise(int n, int n2, @NotNull List<Header> list) throws IOException {
        Intrinsics.checkNotNullParameter(list, "requestHeaders");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long l = this.hpackBuffer.size();
        int n3 = (int)Math.min((long)this.maxFrameSize - 4L, l);
        this.frameHeader(n, n3 + 4, 5, l == (long)n3 ? 4 : 0);
        this.sink.writeInt(n2 & Integer.MAX_VALUE);
        this.sink.write(this.hpackBuffer, (long)n3);
        if (l > (long)n3) {
            this.writeContinuationFrames(n, l - (long)n3);
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.sink.flush();
    }

    public final synchronized void rstStream(int n, @NotNull ErrorCode errorCode) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            String string = "Failed requirement.";
            throw new IllegalArgumentException(string.toString());
        }
        this.frameHeader(n, 4, 3, 0);
        this.sink.writeInt(errorCode.getHttpCode());
        this.sink.flush();
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void data(boolean bl, int n, @Nullable Buffer buffer, int n2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        int n3 = 0;
        if (bl) {
            n3 |= 1;
        }
        this.dataFrame(n, n3, buffer, n2);
    }

    public final void dataFrame(int n, int n2, @Nullable Buffer buffer, int n3) throws IOException {
        this.frameHeader(n, n3, 0, n2);
        if (n3 > 0) {
            Buffer buffer2 = buffer;
            Intrinsics.checkNotNull(buffer2);
            this.sink.write(buffer2, (long)n3);
        }
    }

    public final synchronized void settings(@NotNull Settings settings) throws IOException {
        Intrinsics.checkNotNullParameter(settings, "settings");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.frameHeader(0, settings.size() * 6, 4, 0);
        for (int i = 0; i < 10; ++i) {
            int n;
            if (!settings.isSet(i)) continue;
            switch (i) {
                case 4: {
                    n = 3;
                    break;
                }
                case 7: {
                    n = 4;
                    break;
                }
                default: {
                    n = i;
                }
            }
            int n2 = n;
            this.sink.writeShort(n2);
            this.sink.writeInt(settings.get(i));
        }
        this.sink.flush();
    }

    public final synchronized void ping(boolean bl, int n, int n2) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        this.frameHeader(0, 8, 6, bl ? 1 : 0);
        this.sink.writeInt(n);
        this.sink.writeInt(n2);
        this.sink.flush();
    }

    public final synchronized void goAway(int n, @NotNull ErrorCode errorCode, @NotNull byte[] byArray) throws IOException {
        Intrinsics.checkNotNullParameter((Object)errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(byArray, "debugData");
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(errorCode.getHttpCode() != -1)) {
            boolean bl = false;
            String string = "errorCode.httpCode == -1";
            throw new IllegalArgumentException(string.toString());
        }
        this.frameHeader(0, 8 + byArray.length, 7, 0);
        this.sink.writeInt(n);
        this.sink.writeInt(errorCode.getHttpCode());
        if (!(byArray.length == 0)) {
            this.sink.write(byArray);
        }
        this.sink.flush();
    }

    public final synchronized void windowUpdate(int n, long l) throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        if (!(l != 0L && l <= Integer.MAX_VALUE)) {
            boolean bl = false;
            String string = "windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + l;
            throw new IllegalArgumentException(string.toString());
        }
        this.frameHeader(n, 4, 8, 0);
        this.sink.writeInt((int)l);
        this.sink.flush();
    }

    public final void frameHeader(int n, int n2, int n3, int n4) throws IOException {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(Http2.INSTANCE.frameLog(false, n, n2, n3, n4));
        }
        if (!(n2 <= this.maxFrameSize)) {
            boolean bl = false;
            String string = "FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + n2;
            throw new IllegalArgumentException(string.toString());
        }
        if (!((n & Integer.MIN_VALUE) == 0)) {
            boolean bl = false;
            String string = "reserved bit set: " + n;
            throw new IllegalArgumentException(string.toString());
        }
        Util.writeMedium(this.sink, n2);
        this.sink.writeByte(n3 & 0xFF);
        this.sink.writeByte(n4 & 0xFF);
        this.sink.writeInt(n & Integer.MAX_VALUE);
    }

    @Override
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    private final void writeContinuationFrames(int n, long l) throws IOException {
        long l2 = l;
        while (l2 > 0L) {
            long l3 = Math.min((long)this.maxFrameSize, l2);
            this.frameHeader(n, (int)l3, 9, (l2 -= l3) == 0L ? 4 : 0);
            this.sink.write(this.hpackBuffer, l3);
        }
    }

    public final synchronized void headers(boolean bl, int n, @NotNull List<Header> list) throws IOException {
        int n2;
        Intrinsics.checkNotNullParameter(list, "headerBlock");
        if (this.closed) {
            throw new IOException("closed");
        }
        this.hpackWriter.writeHeaders(list);
        long l = this.hpackBuffer.size();
        long l2 = Math.min((long)this.maxFrameSize, l);
        int n3 = n2 = l == l2 ? 4 : 0;
        if (bl) {
            n2 |= 1;
        }
        this.frameHeader(n, (int)l2, 1, n2);
        this.sink.write(this.hpackBuffer, l2);
        if (l > l2) {
            this.writeContinuationFrames(n, l - l2);
        }
    }

    @Metadata(mv={1, 8, 0}, k=1, xi=48, d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Lokhttp3/internal/http2/Http2Writer$Companion;", "", "()V", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "okhttp"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}

