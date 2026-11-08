/*
 * Decompiled with CFR 0.152.
 */
package org.apache.http.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.TruncatedChunkException;
import org.apache.http.annotation.NotThreadSafe;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

@NotThreadSafe
public class ChunkedInputStream
extends InputStream {
    private static final int CHUNK_LEN = 1;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_CRLF = 3;
    private static final int BUFFER_SIZE = 2048;
    private final SessionInputBuffer in;
    private final CharArrayBuffer buffer;
    private int state;
    private int chunkSize;
    private int pos;
    private boolean eof = false;
    private boolean closed = false;
    private Header[] footers = new Header[0];

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this.in = Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        this.state = 1;
    }

    public int available() throws IOException {
        if (this.in instanceof BufferInfo) {
            int n = ((BufferInfo)((Object)this.in)).length();
            return Math.min(n, this.chunkSize - this.pos);
        }
        return 0;
    }

    public int read() throws IOException {
        int n;
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.eof) {
            return -1;
        }
        if (this.state != 2) {
            this.nextChunk();
            if (this.eof) {
                return -1;
            }
        }
        if ((n = this.in.read()) != -1) {
            ++this.pos;
            if (this.pos >= this.chunkSize) {
                this.state = 3;
            }
        }
        return n;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        int n3;
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        }
        if (this.eof) {
            return -1;
        }
        if (this.state != 2) {
            this.nextChunk();
            if (this.eof) {
                return -1;
            }
        }
        if ((n3 = this.in.read(byArray, n, Math.min(n2, this.chunkSize - this.pos))) != -1) {
            this.pos += n3;
            if (this.pos >= this.chunkSize) {
                this.state = 3;
            }
            return n3;
        }
        this.eof = true;
        throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    private void nextChunk() throws IOException {
        this.chunkSize = this.getChunkSize();
        if (this.chunkSize < 0) {
            throw new MalformedChunkCodingException("Negative chunk size");
        }
        this.state = 2;
        this.pos = 0;
        if (this.chunkSize == 0) {
            this.eof = true;
            this.parseTrailerHeaders();
        }
    }

    private int getChunkSize() throws IOException {
        int n = this.state;
        switch (n) {
            case 3: {
                this.buffer.clear();
                int n2 = this.in.readLine(this.buffer);
                if (n2 == -1) {
                    return 0;
                }
                if (!this.buffer.isEmpty()) {
                    throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                }
                this.state = 1;
            }
            case 1: {
                this.buffer.clear();
                int n3 = this.in.readLine(this.buffer);
                if (n3 == -1) {
                    return 0;
                }
                int n4 = this.buffer.indexOf(59);
                if (n4 < 0) {
                    n4 = this.buffer.length();
                }
                try {
                    return Integer.parseInt(this.buffer.substringTrimmed(0, n4), 16);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new MalformedChunkCodingException("Bad chunk header");
                }
            }
        }
        throw new IllegalStateException("Inconsistent codec state");
    }

    private void parseTrailerHeaders() throws IOException {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.in, -1, -1, null);
        }
        catch (HttpException httpException) {
            MalformedChunkCodingException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + httpException.getMessage());
            malformedChunkCodingException.initCause(httpException);
            throw malformedChunkCodingException;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        if (!this.closed) {
            try {
                if (!this.eof) {
                    byte[] byArray = new byte[2048];
                    while (this.read(byArray) >= 0) {
                    }
                }
            }
            finally {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[])this.footers.clone();
    }
}

