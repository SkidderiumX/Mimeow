/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.platform;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaChannelHandler;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelDecoderException;
import com.viaversion.viaversion.util.ByteBufUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

@ChannelHandler.Sharable
public class ViaDecodeHandler
extends MessageToMessageDecoder<ByteBuf>
implements ViaChannelHandler {
    public static final String NAME = "via-decoder";
    protected final UserConnection connection;

    public ViaDecodeHandler(UserConnection userConnection) {
        this.connection = userConnection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!this.connection.checkIncomingPacket(byteBuf.readableBytes())) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.connection.shouldTransformPacket()) {
            list.add(byteBuf.retain());
            return;
        }
        ByteBuf byteBuf2 = ByteBufUtil.copy(channelHandlerContext.alloc(), byteBuf);
        try {
            this.connection.transformIncoming(byteBuf2, CancelDecoderException::generate);
            list.add(byteBuf2.retain());
        }
        finally {
            byteBuf2.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        if (!(throwable instanceof CancelCodecException)) {
            super.exceptionCaught(channelHandlerContext, throwable);
        }
    }

    @Override
    public boolean isSharable() {
        return true;
    }

    @Override
    public UserConnection connection() {
        return this.connection;
    }
}

