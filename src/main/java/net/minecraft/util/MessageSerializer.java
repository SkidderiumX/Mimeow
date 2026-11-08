/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MessageSerializer
extends MessageToByteEncoder<Packet> {
    private static final Logger logger = LogManager.getLogger();
    private static final Marker RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_SENT", NetworkManager.logMarkerPackets);
    private final EnumPacketDirection direction;

    public MessageSerializer(EnumPacketDirection enumPacketDirection) {
        this.direction = enumPacketDirection;
    }

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Packet packet, ByteBuf byteBuf) throws IOException, Exception {
        Integer n = channelHandlerContext.channel().attr(NetworkManager.attrKeyConnectionState).get().getPacketId(this.direction, packet);
        if (logger.isDebugEnabled()) {
            logger.debug(RECEIVED_PACKET_MARKER, "OUT: [{}:{}] {}", new Object[]{channelHandlerContext.channel().attr(NetworkManager.attrKeyConnectionState).get(), n, packet.getClass().getName()});
        }
        if (n == null) {
            throw new IOException("Can't serialize unregistered packet");
        }
        PacketBuffer packetBuffer = new PacketBuffer(byteBuf);
        packetBuffer.writeVarIntToBuffer(n);
        try {
            packet.writePacketData(packetBuffer);
        }
        catch (Throwable throwable) {
            logger.error(throwable);
        }
    }
}

