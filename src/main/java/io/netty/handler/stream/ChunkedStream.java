/*
 * Decompiled with CFR 0.152.
 */
package io.netty.handler.stream;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.stream.ChunkedInput;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class ChunkedStream
implements ChunkedInput<ByteBuf> {
    static final int DEFAULT_CHUNK_SIZE = 8192;
    private final PushbackInputStream in;
    private final int chunkSize;
    private long offset;

    public ChunkedStream(InputStream inputStream2) {
        this(inputStream2, 8192);
    }

    public ChunkedStream(InputStream inputStream2, int n) {
        if (inputStream2 == null) {
            throw new NullPointerException("in");
        }
        if (n <= 0) {
            throw new IllegalArgumentException("chunkSize: " + n + " (expected: a positive integer)");
        }
        this.in = inputStream2 instanceof PushbackInputStream ? (PushbackInputStream)inputStream2 : new PushbackInputStream(inputStream2);
        this.chunkSize = n;
    }

    public long transferredBytes() {
        return this.offset;
    }

    @Override
    public boolean isEndOfInput() throws Exception {
        int n = this.in.read();
        if (n < 0) {
            return true;
        }
        this.in.unread(n);
        return false;
    }

    @Override
    public void close() throws Exception {
        this.in.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public ByteBuf readChunk(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.isEndOfInput()) {
            return null;
        }
        int n = this.in.available();
        int n2 = n <= 0 ? this.chunkSize : Math.min(this.chunkSize, this.in.available());
        boolean bl = true;
        ByteBuf byteBuf = channelHandlerContext.alloc().buffer(n2);
        try {
            this.offset += (long)byteBuf.writeBytes(this.in, n2);
            bl = false;
            ByteBuf byteBuf2 = byteBuf;
            return byteBuf2;
        }
        finally {
            if (bl) {
                byteBuf.release();
            }
        }
    }
}

