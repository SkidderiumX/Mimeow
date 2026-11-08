/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.vialoadingbase.netty.handler;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.exception.CancelCodecException;
import com.viaversion.viaversion.exception.CancelDecoderException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.util.PipelineUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import java.util.List;

@ChannelHandler.Sharable
public class VLBViaDecodeHandler
extends MessageToMessageDecoder<ByteBuf> {
    private final UserConnection user;

    public VLBViaDecodeHandler(UserConnection userConnection) {
        this.user = userConnection;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (!this.user.checkClientboundPacket()) {
            throw CancelDecoderException.generate(null);
        }
        if (!this.user.shouldTransformPacket()) {
            list.add(byteBuf.retain());
            return;
        }
        ByteBuf byteBuf2 = channelHandlerContext.alloc().buffer().writeBytes(byteBuf);
        try {
            this.user.transformClientbound(byteBuf2, CancelDecoderException::generate);
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
        if (PipelineUtil.containsCause(throwable, InformativeException.class) && this.user.getProtocolInfo().getServerState() != State.HANDSHAKE || Via.getManager().debugHandler().enabled()) {
            throwable.printStackTrace();
        }
    }
}

