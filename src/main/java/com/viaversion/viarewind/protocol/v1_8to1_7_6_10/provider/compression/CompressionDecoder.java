/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression;

import com.viaversion.viarewind.api.compression.ThreadLocalCompressionProvider;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

public class CompressionDecoder
extends MessageToMessageDecoder<ByteBuf> {
    private int threshold;

    public CompressionDecoder(int n) {
        this.threshold = n;
    }

    public void setThreshold(int n) {
        this.threshold = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!byteBuf.isReadable()) {
            return;
        }
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        if (n == 0) {
            list.add(byteBuf.readBytes(byteBuf.readableBytes()));
            return;
        }
        if (n < this.threshold) {
            throw new DecoderException("Badly compressed packet - size of " + n + " is below server threshold of " + this.threshold);
        }
        if (n > 0x200000) {
            throw new DecoderException("Badly compressed packet - size of " + n + " is larger than protocol maximum of 2097152");
        }
        ByteBuf byteBuf2 = channelHandlerContext.alloc().buffer(n);
        try {
            ThreadLocalCompressionProvider.inflate(byteBuf, byteBuf2, n);
            list.add(byteBuf2.retain());
        }
        finally {
            byteBuf2.release();
        }
    }
}

