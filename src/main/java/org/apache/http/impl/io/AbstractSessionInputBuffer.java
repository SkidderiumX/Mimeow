/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.apache.http.Consts;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.HttpTransportMetricsImpl;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.params.HttpParams;
import org.apache.http.util.Args;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

@Deprecated
@NotThreadSafe
public abstract class AbstractSessionInputBuffer
implements SessionInputBuffer,
BufferInfo {
    private InputStream instream;
    private byte[] buffer;
    private ByteArrayBuffer linebuffer;
    private Charset charset;
    private boolean ascii;
    private int maxLineLen;
    private int minChunkLimit;
    private HttpTransportMetricsImpl metrics;
    private CodingErrorAction onMalformedCharAction;
    private CodingErrorAction onUnmappableCharAction;
    private int bufferpos;
    private int bufferlen;
    private CharsetDecoder decoder;
    private CharBuffer cbuf;

    protected void init(InputStream inputStream2, int n, HttpParams httpParams) {
        Args.notNull(inputStream2, "Input stream");
        Args.notNegative(n, "Buffer size");
        Args.notNull(httpParams, "HTTP parameters");
        this.instream = inputStream2;
        this.buffer = new byte[n];
        this.bufferpos = 0;
        this.bufferlen = 0;
        this.linebuffer = new ByteArrayBuffer(n);
        String string = (String)httpParams.getParameter("http.protocol.element-charset");
        this.charset = string != null ? Charset.forName(string) : Consts.ASCII;
        this.ascii = this.charset.equals(Consts.ASCII);
        this.decoder = null;
        this.maxLineLen = httpParams.getIntParameter("http.connection.max-line-length", -1);
        this.minChunkLimit = httpParams.getIntParameter("http.connection.min-chunk-limit", 512);
        this.metrics = this.createTransportMetrics();
        CodingErrorAction codingErrorAction = (CodingErrorAction)httpParams.getParameter("http.malformed.input.action");
        this.onMalformedCharAction = codingErrorAction != null ? codingErrorAction : CodingErrorAction.REPORT;
        CodingErrorAction codingErrorAction2 = (CodingErrorAction)httpParams.getParameter("http.unmappable.input.action");
        this.onUnmappableCharAction = codingErrorAction2 != null ? codingErrorAction2 : CodingErrorAction.REPORT;
    }

    protected HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
    }

    public int capacity() {
        return this.buffer.length;
    }

    public int length() {
        return this.bufferlen - this.bufferpos;
    }

    public int available() {
        return this.capacity() - this.length();
    }

    protected int fillBuffer() throws IOException {
        int n;
        int n2;
        int n3;
        if (this.bufferpos > 0) {
            n3 = this.bufferlen - this.bufferpos;
            if (n3 > 0) {
                System.arraycopy(this.buffer, this.bufferpos, this.buffer, 0, n3);
            }
            this.bufferpos = 0;
            this.bufferlen = n3;
        }
        if ((n3 = this.instream.read(this.buffer, n2 = this.bufferlen, n = this.buffer.length - n2)) == -1) {
            return -1;
        }
        this.bufferlen = n2 + n3;
        this.metrics.incrementBytesTransferred(n3);
        return n3;
    }

    protected boolean hasBufferedData() {
        return this.bufferpos < this.bufferlen;
    }

    public int read() throws IOException {
        while (!this.hasBufferedData()) {
            int n = this.fillBuffer();
            if (n != -1) continue;
            return -1;
        }
        return this.buffer[this.bufferpos++] & 0xFF;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        if (byArray == null) {
            return 0;
        }
        if (this.hasBufferedData()) {
            int n4 = Math.min(n2, this.bufferlen - this.bufferpos);
            System.arraycopy(this.buffer, this.bufferpos, byArray, n, n4);
            this.bufferpos += n4;
            return n4;
        }
        if (n2 > this.minChunkLimit) {
            int n5 = this.instream.read(byArray, n, n2);
            if (n5 > 0) {
                this.metrics.incrementBytesTransferred(n5);
            }
            return n5;
        }
        while (!this.hasBufferedData()) {
            n3 = this.fillBuffer();
            if (n3 != -1) continue;
            return -1;
        }
        n3 = Math.min(n2, this.bufferlen - this.bufferpos);
        System.arraycopy(this.buffer, this.bufferpos, byArray, n, n3);
        this.bufferpos += n3;
        return n3;
    }

    public int read(byte[] byArray) throws IOException {
        if (byArray == null) {
            return 0;
        }
        return this.read(byArray, 0, byArray.length);
    }

    private int locateLF() {
        for (int i = this.bufferpos; i < this.bufferlen; ++i) {
            if (this.buffer[i] != 10) continue;
            return i;
        }
        return -1;
    }

    public int readLine(CharArrayBuffer charArrayBuffer) throws IOException {
        Args.notNull(charArrayBuffer, "Char array buffer");
        int n = 0;
        boolean bl = true;
        while (bl) {
            int n2;
            int n3 = this.locateLF();
            if (n3 != -1) {
                if (this.linebuffer.isEmpty()) {
                    return this.lineFromReadBuffer(charArrayBuffer, n3);
                }
                bl = false;
                n2 = n3 + 1 - this.bufferpos;
                this.linebuffer.append(this.buffer, this.bufferpos, n2);
                this.bufferpos = n3 + 1;
            } else {
                if (this.hasBufferedData()) {
                    n2 = this.bufferlen - this.bufferpos;
                    this.linebuffer.append(this.buffer, this.bufferpos, n2);
                    this.bufferpos = this.bufferlen;
                }
                if ((n = this.fillBuffer()) == -1) {
                    bl = false;
                }
            }
            if (this.maxLineLen <= 0 || this.linebuffer.length() < this.maxLineLen) continue;
            throw new IOException("Maximum line length limit exceeded");
        }
        if (n == -1 && this.linebuffer.isEmpty()) {
            return -1;
        }
        return this.lineFromLineBuffer(charArrayBuffer);
    }

    private int lineFromLineBuffer(CharArrayBuffer charArrayBuffer) throws IOException {
        int n = this.linebuffer.length();
        if (n > 0) {
            if (this.linebuffer.byteAt(n - 1) == 10) {
                --n;
            }
            if (n > 0 && this.linebuffer.byteAt(n - 1) == 13) {
                --n;
            }
        }
        if (this.ascii) {
            charArrayBuffer.append(this.linebuffer, 0, n);
        } else {
            ByteBuffer byteBuffer = ByteBuffer.wrap(this.linebuffer.buffer(), 0, n);
            n = this.appendDecoded(charArrayBuffer, byteBuffer);
        }
        this.linebuffer.clear();
        return n;
    }

    private int lineFromReadBuffer(CharArrayBuffer charArrayBuffer, int n) throws IOException {
        int n2 = this.bufferpos;
        int n3 = n;
        this.bufferpos = n3 + 1;
        if (n3 > n2 && this.buffer[n3 - 1] == 13) {
            --n3;
        }
        int n4 = n3 - n2;
        if (this.ascii) {
            charArrayBuffer.append(this.buffer, n2, n4);
        } else {
            ByteBuffer byteBuffer = ByteBuffer.wrap(this.buffer, n2, n4);
            n4 = this.appendDecoded(charArrayBuffer, byteBuffer);
        }
        return n4;
    }

    private int appendDecoded(CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        CoderResult coderResult;
        if (!byteBuffer.hasRemaining()) {
            return 0;
        }
        if (this.decoder == null) {
            this.decoder = this.charset.newDecoder();
            this.decoder.onMalformedInput(this.onMalformedCharAction);
            this.decoder.onUnmappableCharacter(this.onUnmappableCharAction);
        }
        if (this.cbuf == null) {
            this.cbuf = CharBuffer.allocate(1024);
        }
        this.decoder.reset();
        int n = 0;
        while (byteBuffer.hasRemaining()) {
            coderResult = this.decoder.decode(byteBuffer, this.cbuf, true);
            n += this.handleDecodingResult(coderResult, charArrayBuffer, byteBuffer);
        }
        coderResult = this.decoder.flush(this.cbuf);
        this.cbuf.clear();
        return n += this.handleDecodingResult(coderResult, charArrayBuffer, byteBuffer);
    }

    private int handleDecodingResult(CoderResult coderResult, CharArrayBuffer charArrayBuffer, ByteBuffer byteBuffer) throws IOException {
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.cbuf.flip();
        int n = this.cbuf.remaining();
        while (this.cbuf.hasRemaining()) {
            charArrayBuffer.append(this.cbuf.get());
        }
        this.cbuf.compact();
        return n;
    }

    public String readLine() throws IOException {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(64);
        int n = this.readLine(charArrayBuffer);
        if (n != -1) {
            return charArrayBuffer.toString();
        }
        return null;
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}

