/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.platform;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaInjector;
import com.viaversion.viaversion.connection.UserConnectionImpl;
import com.viaversion.viaversion.platform.WrappedChannelInitializer;
import com.viaversion.viaversion.protocol.ProtocolPipelineImpl;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import java.lang.reflect.Method;

public abstract class ViaChannelInitializer
extends ChannelInitializer<Channel>
implements WrappedChannelInitializer {
    private static final Method INIT_CHANNEL_METHOD;
    private final ChannelInitializer<Channel> original;
    private final boolean clientSide;

    protected ViaChannelInitializer(ChannelInitializer<Channel> channelInitializer, boolean bl) {
        this.original = channelInitializer;
        this.clientSide = bl;
    }

    @Override
    protected void initChannel(Channel channel) throws Exception {
        INIT_CHANNEL_METHOD.invoke(this.original, channel);
        UserConnection userConnection = ViaChannelInitializer.createUserConnection(channel, this.clientSide);
        this.injectPipeline(channel.pipeline(), userConnection);
    }

    public static UserConnection createUserConnection(Channel channel, boolean bl) {
        UserConnectionImpl userConnectionImpl = new UserConnectionImpl(channel, bl);
        new ProtocolPipelineImpl(userConnectionImpl);
        return userConnectionImpl;
    }

    public static void reorderPipeline(ChannelPipeline channelPipeline, String string, String string2) {
        ViaInjector viaInjector = Via.getManager().getInjector();
        int n = channelPipeline.names().indexOf(string2);
        if (n == -1) {
            return;
        }
        if (n > channelPipeline.names().indexOf(viaInjector.getDecoderName())) {
            ChannelHandler channelHandler = channelPipeline.remove(viaInjector.getEncoderName());
            ChannelHandler channelHandler2 = channelPipeline.remove(viaInjector.getDecoderName());
            channelPipeline.addAfter(string, viaInjector.getEncoderName(), channelHandler);
            channelPipeline.addAfter(string2, viaInjector.getDecoderName(), channelHandler2);
        }
    }

    protected abstract void injectPipeline(ChannelPipeline var1, UserConnection var2);

    @Override
    public ChannelInitializer<Channel> original() {
        return this.original;
    }

    public boolean clientSide() {
        return this.clientSide;
    }

    static {
        try {
            INIT_CHANNEL_METHOD = ChannelInitializer.class.getDeclaredMethod("initChannel", Channel.class);
            INIT_CHANNEL_METHOD.setAccessible(true);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            throw new RuntimeException(reflectiveOperationException);
        }
    }
}

