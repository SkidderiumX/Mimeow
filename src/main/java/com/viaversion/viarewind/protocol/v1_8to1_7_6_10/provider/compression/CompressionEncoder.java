/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression;

import com.viaversion.viarewind.api.compression.ThreadLocalCompressionProvider;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class CompressionEncoder
extends MessageToByteEncoder<ByteBuf> {
    private int threshold;

    public CompressionEncoder(int n) {
        this.threshold = n;
    }

    public void setThreshold(int n) {
        this.threshold = n;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        int n = byteBuf.readableBytes();
        if (n < this.threshold) {
            byteBuf2.writeByte(0);
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        Types.VAR_INT.writePrimitive(byteBuf2, n);
        ThreadLocalCompressionProvider.deflate(byteBuf, byteBuf2);
    }
}

