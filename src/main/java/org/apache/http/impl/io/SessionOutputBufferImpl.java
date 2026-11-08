/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.io;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.Asserts;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class SessionOutputBufferImpl
implements SessionOutputBuffer,
BufferInfo {
    private static final byte[] CRLF = new byte[]{13, 10};
    private final HttpTransportMetricsImpl metrics;
    private final ByteArrayBuffer buffer;
    private final int fragementSizeHint;
    private final CharsetEncoder encoder;
    private OutputStream outstream;
    private ByteBuffer bbuf;

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int n, int n2, CharsetEncoder charsetEncoder) {
        Args.positive(n, "Buffer size");
        Args.notNull(httpTransportMetricsImpl, "HTTP transport metrcis");
        this.metrics = httpTransportMetricsImpl;
        this.buffer = new ByteArrayBuffer(n);
        this.fragementSizeHint = n2 >= 0 ? n2 : 0;
        this.encoder = charsetEncoder;
    }

    public SessionOutputBufferImpl(HttpTransportMetricsImpl httpTransportMetricsImpl, int n) {
        this(httpTransportMetricsImpl, n, n, null);
    }

    public void bind(OutputStream outputStream2) {
        this.outstream = outputStream2;
    }

    public boolean isBound() {
        return this.outstream != null;
    }

    public int capacity() {
        return this.buffer.capacity();
    }

    public int length() {
        return this.buffer.length();
    }

    public int available() {
        return this.capacity() - this.length();
    }

    private void streamWrite(byte[] byArray, int n, int n2) throws IOException {
        Asserts.notNull(this.outstream, "Output stream");
        this.outstream.write(byArray, n, n2);
    }

    private void flushStream() throws IOException {
        if (this.outstream != null) {
            this.outstream.flush();
        }
    }

    private void flushBuffer() throws IOException {
        int n = this.buffer.length();
        if (n > 0) {
            this.streamWrite(this.buffer.buffer(), 0, n);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred(n);
        }
    }

    public void flush() throws IOException {
        this.flushBuffer();
        this.flushStream();
    }

    public void write(byte[] byArray, int n, int n2) throws IOException {
        if (byArray == null) {
            return;
        }
        if (n2 > this.fragementSizeHint || n2 > this.buffer.capacity()) {
            this.flushBuffer();
            this.streamWrite(byArray, n, n2);
            this.metrics.incrementBytesTransferred(n2);
        } else {
            int n3 = this.buffer.capacity() - this.buffer.length();
            if (n2 > n3) {
                this.flushBuffer();
            }
            this.buffer.append(byArray, n, n2);
        }
    }

    public void write(byte[] byArray) throws IOException {
        if (byArray == null) {
            return;
        }
        this.write(byArray, 0, byArray.length);
    }

    public void write(int n) throws IOException {
        if (this.fragementSizeHint > 0) {
            if (this.buffer.isFull()) {
                this.flushBuffer();
            }
            this.buffer.append(n);
        } else {
            this.flushBuffer();
            this.outstream.write(n);
        }
    }

    public void writeLine(String string) throws IOException {
        if (string == null) {
            return;
        }
        if (string.length() > 0) {
            if (this.encoder == null) {
                for (int i = 0; i < string.length(); ++i) {
                    this.write(string.charAt(i));
                }
            } else {
                CharBuffer charBuffer = CharBuffer.wrap(string);
                this.writeEncoded(charBuffer);
            }
        }
        this.write(CRLF);
    }

    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer == null) {
            return;
        }
        if (this.encoder == null) {
            int n;
            int n2 = 0;
            for (int i = charArrayBuffer.length(); i > 0; i -= n) {
                n = this.buffer.capacity() - this.buffer.length();
                if ((n = Math.min(n, i)) > 0) {
                    this.buffer.append(charArrayBuffer, n2, n);
                }
                if (this.buffer.isFull()) {
                    this.flushBuffer();
                }
                n2 += n;
            }
        } else {
            CharBuffer charBuffer = CharBuffer.wrap(charArrayBuffer.buffer(), 0, charArrayBuffer.length());
            this.writeEncoded(charBuffer);
        }
        this.write(CRLF);
    }

    private void writeEncoded(CharBuffer charBuffer) throws IOException {
        CoderResult coderResult;
        if (!charBuffer.hasRemaining()) {
            return;
        }
        if (this.bbuf == null) {
            this.bbuf = ByteBuffer.allocate(1024);
        }
        this.encoder.reset();
        while (charBuffer.hasRemaining()) {
            coderResult = this.encoder.encode(charBuffer, this.bbuf, true);
            this.handleEncodingResult(coderResult);
        }
        coderResult = this.encoder.flush(this.bbuf);
        this.handleEncodingResult(coderResult);
        this.bbuf.clear();
    }

    private void handleEncodingResult(CoderResult coderResult) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
        while (this.bbuf.hasRemaining()) {
            this.write(this.bbuf.get());
        }
        this.bbuf.compact();
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}

