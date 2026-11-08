/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.vialoadingbase.netty.handler;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelEncoderException;
import com.viaversion.viaversion.util.PipelineUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.util.List;

@ChannelHandler.Sharable
public class VLBViaEncodeHandler
extends MessageToMessageEncoder<ByteBuf> {
    private final UserConnection user;

    public VLBViaEncodeHandler(UserConnection userConnection) {
        this.user = userConnection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!this.user.checkServerboundPacket()) {
            throw CancelEncoderException.generate(null);
        }
        if (!this.user.shouldTransformPacket()) {
            list.add(byteBuf.retain());
            return;
        }
        ByteBuf byteBuf2 = channelHandlerContext.alloc().buffer().writeBytes(byteBuf);
        try {
            this.user.transformServerbound(byteBuf2, CancelEncoderException::generate);
            list.add(byteBuf2.retain());
        }
        finally {
            byteBuf2.release();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        if (PipelineUtil.containsCause(throwable, CancelCodecException.class)) {
            return;
        }
        super.exceptionCaught(channelHandlerContext, throwable);
    }
}

