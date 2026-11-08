/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.FileRegion;
import io.netty.channel.oio.AbstractOioByteChannel;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.WritableByteChannel;

public abstract class OioByteStreamChannel
extends AbstractOioByteChannel {
    private static final InputStream CLOSED_IN = new InputStream(){

        @Override
        public int read() {
            return -1;
        }
    };
    private static final OutputStream CLOSED_OUT = new OutputStream(){

        @Override
        public void write(int n) throws IOException {
            throw new ClosedChannelException();
        }
    };
    private InputStream is;
    private OutputStream os;
    private WritableByteChannel outChannel;

    protected OioByteStreamChannel(Channel channel) {
        super(channel);
    }

    protected final void activate(InputStream inputStream2, OutputStream outputStream2) {
        if (this.is != null) {
            throw new IllegalStateException("input was set already");
        }
        if (this.os != null) {
            throw new IllegalStateException("output was set already");
        }
        if (inputStream2 == null) {
            throw new NullPointerException("is");
        }
        if (outputStream2 == null) {
            throw new NullPointerException("os");
        }
        this.is = inputStream2;
        this.os = outputStream2;
    }

    @Override
    public boolean isActive() {
        InputStream inputStream2 = this.is;
        if (inputStream2 == null || inputStream2 == CLOSED_IN) {
            return false;
        }
        OutputStream outputStream2 = this.os;
        return outputStream2 != null && outputStream2 != CLOSED_OUT;
    }

    @Override
    protected int available() {
        try {
            return this.is.available();
        }
        catch (IOException iOException) {
            return 0;
        }
    }

    @Override
    protected int doReadBytes(ByteBuf byteBuf) throws Exception {
        int n = Math.max(1, Math.min(this.available(), byteBuf.maxWritableBytes()));
        return byteBuf.writeBytes(this.is, n);
    }

    @Override
    protected void doWriteBytes(ByteBuf byteBuf) throws Exception {
        OutputStream outputStream2 = this.os;
        if (outputStream2 == null) {
            throw new NotYetConnectedException();
        }
        byteBuf.readBytes(outputStream2, byteBuf.readableBytes());
    }

    @Override
    protected void doWriteFileRegion(FileRegion fileRegion) throws Exception {
        long l;
        OutputStream outputStream2 = this.os;
        if (outputStream2 == null) {
            throw new NotYetConnectedException();
        }
        if (this.outChannel == null) {
            this.outChannel = Channels.newChannel(outputStream2);
        }
        long l2 = 0L;
        do {
            if ((l = fileRegion.transferTo(this.outChannel, l2)) != -1L) continue;
            OioByteStreamChannel.checkEOF(fileRegion);
            return;
        } while ((l2 += l) < fileRegion.count());
    }

    private static void checkEOF(FileRegion fileRegion) throws IOException {
        if (fileRegion.transfered() < fileRegion.count()) {
            throw new EOFException("Expected to be able to write " + fileRegion.count() + " bytes, " + "but only wrote " + fileRegion.transfered());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void doClose() throws Exception {
        InputStream inputStream2 = this.is;
        OutputStream outputStream2 = this.os;
        this.is = CLOSED_IN;
        this.os = CLOSED_OUT;
        try {
            if (inputStream2 != null) {
                inputStream2.close();
            }
        }
        finally {
            if (outputStream2 != null) {
                outputStream2.close();
            }
        }
    }
}

