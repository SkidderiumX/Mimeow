/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

public class CharSequenceInputStream
extends InputStream {
    private final CharsetEncoder encoder;
    private final CharBuffer cbuf;
    private final ByteBuffer bbuf;
    private int mark;

    public CharSequenceInputStream(CharSequence charSequence, Charset charset, int n) {
        this.encoder = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bbuf = ByteBuffer.allocate(n);
        this.bbuf.flip();
        this.cbuf = CharBuffer.wrap(charSequence);
        this.mark = -1;
    }

    public CharSequenceInputStream(CharSequence charSequence, String string, int n) {
        this(charSequence, Charset.forName(string), n);
    }

    public CharSequenceInputStream(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 2048);
    }

    public CharSequenceInputStream(CharSequence charSequence, String string) {
        this(charSequence, string, 2048);
    }

    private void fillBuffer() throws CharacterCodingException {
        this.bbuf.compact();
        CoderResult coderResult = this.encoder.encode(this.cbuf, this.bbuf, true);
        if (coderResult.isError()) {
            coderResult.throwException();
        }
        this.bbuf.flip();
    }

    @Override
    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (byArray == null) {
            throw new NullPointerException("Byte array is null");
        }
        if (n2 < 0 || n + n2 > byArray.length) {
            throw new IndexOutOfBoundsException("Array Size=" + byArray.length + ", offset=" + n + ", length=" + n2);
        }
        if (n2 == 0) {
            return 0;
        }
        if (!this.bbuf.hasRemaining() && !this.cbuf.hasRemaining()) {
            return -1;
        }
        int n3 = 0;
        while (n2 > 0) {
            if (this.bbuf.hasRemaining()) {
                int n4 = Math.min(this.bbuf.remaining(), n2);
                this.bbuf.get(byArray, n, n4);
                n += n4;
                n2 -= n4;
                n3 += n4;
                continue;
            }
            this.fillBuffer();
            if (this.bbuf.hasRemaining() || this.cbuf.hasRemaining()) continue;
        }
        return n3 == 0 && !this.cbuf.hasRemaining() ? -1 : n3;
    }

    @Override
    public int read() throws IOException {
        do {
            if (this.bbuf.hasRemaining()) {
                return this.bbuf.get() & 0xFF;
            }
            this.fillBuffer();
        } while (this.bbuf.hasRemaining() || this.cbuf.hasRemaining());
        return -1;
    }

    @Override
    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public long skip(long l) throws IOException {
        int n = 0;
        while (l > 0L && this.cbuf.hasRemaining()) {
            this.cbuf.get();
            --l;
            ++n;
        }
        return n;
    }

    @Override
    public int available() throws IOException {
        return this.cbuf.remaining();
    }

    @Override
    public void close() throws IOException {
    }

    @Override
    public synchronized void mark(int n) {
        this.mark = this.cbuf.position();
    }

    @Override
    public synchronized void reset() throws IOException {
        if (this.mark != -1) {
            this.cbuf.position(this.mark);
            this.mark = -1;
        }
    }

    @Override
    public boolean markSupported() {
        return true;
    }
}

