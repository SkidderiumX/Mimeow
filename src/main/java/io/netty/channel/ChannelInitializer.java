/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

@ChannelHandler.Sharable
public abstract class ChannelInitializer<C extends Channel>
extends ChannelInboundHandlerAdapter {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ChannelInitializer.class);

    protected abstract void initChannel(C var1) throws Exception;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final void channelRegistered(ChannelHandlerContext channelHandlerContext) throws Exception {
        ChannelPipeline channelPipeline = channelHandlerContext.pipeline();
        boolean bl = false;
        try {
            this.initChannel(channelHandlerContext.channel());
            channelPipeline.remove(this);
            channelHandlerContext.fireChannelRegistered();
            bl = true;
        }
        catch (Throwable throwable) {
            logger.warn("Failed to initialize a channel. Closing: " + channelHandlerContext.channel(), throwable);
        }
        finally {
            if (channelPipeline.context(this) != null) {
                channelPipeline.remove(this);
            }
            if (!bl) {
                channelHandlerContext.close();
            }
        }
    }
}

