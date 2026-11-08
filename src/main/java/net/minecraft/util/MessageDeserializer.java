/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.util;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.io.IOException;
import java.util.List;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class MessageDeserializer
extends ByteToMessageDecoder {
    private static final Logger logger = LogManager.getLogger();
    private static final Marker RECEIVED_PACKET_MARKER = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.logMarkerPackets);
    private final EnumPacketDirection direction;

    public MessageDeserializer(EnumPacketDirection enumPacketDirection) {
        this.direction = enumPacketDirection;
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws IOException, InstantiationException, IllegalAccessException, Exception {
        if (byteBuf.readableBytes() != 0) {
            PacketBuffer packetBuffer = new PacketBuffer(byteBuf);
            int n = packetBuffer.readVarIntFromBuffer();
            Packet packet = channelHandlerContext.channel().attr(NetworkManager.attrKeyConnectionState).get().getPacket(this.direction, n);
            if (packet == null) {
                throw new IOException("Bad packet id " + n);
            }
            packet.readPacketData(packetBuffer);
            if (packetBuffer.readableBytes() > 0) {
                throw new IOException("Packet " + channelHandlerContext.channel().attr(NetworkManager.attrKeyConnectionState).get().getId() + "/" + n + " (" + packet.getClass().getSimpleName() + ") was larger than I expected, found " + packetBuffer.readableBytes() + " bytes extra whilst reading packet " + n);
            }
            list.add(packet);
            if (logger.isDebugEnabled()) {
                logger.debug(RECEIVED_PACKET_MARKER, " IN: [{}:{}] {}", new Object[]{channelHandlerContext.channel().attr(NetworkManager.attrKeyConnectionState).get(), n, packet.getClass().getName()});
            }
        }
    }
}

