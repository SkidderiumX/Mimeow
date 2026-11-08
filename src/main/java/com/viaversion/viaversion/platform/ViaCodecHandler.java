/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.platform;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaChannelHandler;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelDecoderException;
import com.viaversion.viaversion.exception.CancelEncoderException;
import com.viaversion.viaversion.util.ByteBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.ByteToMessageCodec;
import java.util.List;

public class ViaCodecHandler
extends ByteToMessageCodec<ByteBuf>
implements ViaChannelHandler {
    public static final String NAME = "via-codec";
    protected final UserConnection connection;

    public ViaCodecHandler(UserConnection userConnection) {
        this.connection = userConnection;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) {
        if (!this.connection.checkOutgoingPacket()) {
            throw CancelEncoderException.generate(null);
        }
        byteBuf2.writeBytes(byteBuf);
        if (this.connection.shouldTransformPacket()) {
            this.connection.transformOutgoing(byteBuf2, CancelEncoderException::generate);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!this.connection.checkIncomingPacket(byteBuf.readableBytes())) {
            throw CancelDecoderException.generate(null);
        }
        ByteBuf byteBuf2 = ByteBufUtil.copy(channelHandlerContext.alloc(), byteBuf);
        try {
            if (this.connection.shouldTransformPacket()) {
                this.connection.transformIncoming(byteBuf2, CancelDecoderException::generate);
            }
            list.add(byteBuf2.retain());
        }
        finally {
            byteBuf2.release();
        }
    }

    @Override
    public void write(ChannelHandlerContext channelHandlerContext, Object object, ChannelPromise channelPromise) throws Exception {
        try {
            super.write(channelHandlerContext, object, channelPromise);
        }
        catch (Throwable throwable) {
            if (!(throwable instanceof CancelCodecException)) {
                throw throwable;
            }
            channelPromise.setSuccess();
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        block2: {
            try {
                super.channelRead(channelHandlerContext, object);
            }
            catch (Throwable throwable) {
                if (throwable instanceof CancelCodecException) break block2;
                throw throwable;
            }
        }
    }

    @Override
    public UserConnection connection() {
        return this.connection;
    }
}

