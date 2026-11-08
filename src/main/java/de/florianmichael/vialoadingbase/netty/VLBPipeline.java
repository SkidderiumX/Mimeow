/*
 * Decompiled with CFR 0.152.
 */
package de.florianmichael.vialoadingbase.netty;

import com.viaversion.viaversion.api.connection.UserConnection;
import de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent;
import de.florianmichael.vialoadingbase.netty.handler.VLBViaDecodeHandler;
import de.florianmichael.vialoadingbase.netty.handler.VLBViaEncodeHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public abstract class VLBPipeline
extends ChannelInboundHandlerAdapter {
    public static final String VIA_DECODER_HANDLER_NAME = "via-decoder";
    public static final String VIA_ENCODER_HANDLER_NAME = "via-encoder";
    private final UserConnection user;

    public VLBPipeline(UserConnection userConnection) {
        this.user = userConnection;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerAdded(channelHandlerContext);
        channelHandlerContext.pipeline().addBefore(this.z$2k9bvms96uf74(), VIA_DECODER_HANDLER_NAME, this.createVLBViaDecodeHandler());
        channelHandlerContext.pipeline().addBefore(this.z$3hf8gmbusm194(), VIA_ENCODER_HANDLER_NAME, this.createVLBViaEncodeHandler());
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object object) throws Exception {
        super.userEventTriggered(channelHandlerContext, object);
        if (object instanceof CompressionReorderEvent) {
            int n = channelHandlerContext.pipeline().names().indexOf(this.z$1xjrefqy4f2y0());
            if (n == -1) {
                return;
            }
            if (n > channelHandlerContext.pipeline().names().indexOf(VIA_DECODER_HANDLER_NAME)) {
                ChannelHandler channelHandler = channelHandlerContext.pipeline().get(VIA_DECODER_HANDLER_NAME);
                ChannelHandler channelHandler2 = channelHandlerContext.pipeline().get(VIA_ENCODER_HANDLER_NAME);
                channelHandlerContext.pipeline().remove(channelHandler);
                channelHandlerContext.pipeline().remove(channelHandler2);
                channelHandlerContext.pipeline().addAfter(this.z$1xjrefqy4f2y0(), VIA_DECODER_HANDLER_NAME, channelHandler);
                channelHandlerContext.pipeline().addAfter(this.z$eywqmm9wigl3(), VIA_ENCODER_HANDLER_NAME, channelHandler2);
            }
        }
    }

    public VLBViaDecodeHandler createVLBViaDecodeHandler() {
        return new VLBViaDecodeHandler(this.user);
    }

    public VLBViaEncodeHandler createVLBViaEncodeHandler() {
        return new VLBViaEncodeHandler(this.user);
    }

    public abstract String z$2k9bvms96uf74();

    public abstract String z$3hf8gmbusm194();

    public abstract String z$1xjrefqy4f2y0();

    public abstract String z$eywqmm9wigl3();

    public UserConnection getUser() {
        return this.user;
    }
}

