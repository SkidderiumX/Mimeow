/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.minecraft.netty.EmptyChannelHandler;
import com.viaversion.viarewind.api.minecraft.netty.ForwardMessageToByteEncoder;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.CompressionHandlerProvider;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.CompressionDecoder;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider.compression.CompressionEncoder;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelPipeline;

public class TrackingCompressionHandlerProvider
extends CompressionHandlerProvider {
    @Override
    public void setCompressionThreshold(UserConnection userConnection, int n) {
        ChannelPipeline channelPipeline = userConnection.getChannel().pipeline();
        if (!userConnection.isClientSide() || n < 0) {
            this.setRemoveCompression(userConnection, true);
            return;
        }
        String string = ViaRewind.getPlatform().compressHandlerName();
        CompressionEncoder compressionEncoder = (CompressionEncoder)channelPipeline.get(string);
        if (compressionEncoder != null) {
            compressionEncoder.setThreshold(n);
        } else {
            channelPipeline.addBefore(Via.getManager().getInjector().getEncoderName(), string, new CompressionEncoder(n));
        }
        String string2 = ViaRewind.getPlatform().decompressHandlerName();
        CompressionDecoder compressionDecoder = (CompressionDecoder)channelPipeline.get(string2);
        if (compressionDecoder != null) {
            compressionDecoder.setThreshold(n);
        } else {
            channelPipeline.addBefore(Via.getManager().getInjector().getDecoderName(), string2, new CompressionDecoder(n));
        }
    }

    @Override
    public void onTransformPacket(UserConnection userConnection) {
        if (this.isRemoveCompression(userConnection)) {
            ChannelPipeline channelPipeline = userConnection.getChannel().pipeline();
            String string = null;
            String string2 = null;
            if (channelPipeline.get(ViaRewind.getPlatform().compressHandlerName()) != null) {
                string = ViaRewind.getPlatform().compressHandlerName();
                string2 = ViaRewind.getPlatform().decompressHandlerName();
            }
            if (string == null) {
                throw new IllegalStateException("Couldn't remove compression for 1.7!");
            }
            channelPipeline.replace(string2, string2, (ChannelHandler)new EmptyChannelHandler());
            channelPipeline.replace(string, string, (ChannelHandler)new ForwardMessageToByteEncoder());
            this.setRemoveCompression(userConnection, false);
        }
    }
}

