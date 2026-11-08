/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2.storage;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ConfigurationState
implements StorableObject {
    private static final int MAX_SERVERBOUND_QUEUED_PACKETS = Integer.getInteger("viaversion.maxQueuedServerboundConfigPackets", 1000);
    private static final int MAX_SERVERBOUND_QUEUED_BYTES = Integer.getInteger("viaversion.maxQueuedServerboundConfigPacketBytes", 0x100000);
    private static final QueuedPacket[] EMPTY_PACKET_ARRAY = new QueuedPacket[0];
    private final List<QueuedPacket> packetQueue = new ArrayList<QueuedPacket>();
    private BridgePhase bridgePhase = BridgePhase.NONE;
    private QueuedPacket joinGamePacket;
    private boolean queuedJoinGame;
    private CompoundTag lastDimensionRegistry;
    private ClientInformation clientInformation;
    private int queuedServerboundBytes;
    private int queuedServerboundPackets;

    public BridgePhase bridgePhase() {
        return this.bridgePhase;
    }

    public void setBridgePhase(BridgePhase bridgePhase) {
        this.bridgePhase = bridgePhase;
    }

    public @Nullable CompoundTag lastDimensionRegistry() {
        return this.lastDimensionRegistry;
    }

    public boolean setLastDimensionRegistry(CompoundTag compoundTag) {
        boolean bl = Objects.equals(this.lastDimensionRegistry, compoundTag);
        this.lastDimensionRegistry = compoundTag;
        return !bl;
    }

    public void setClientInformation(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public void addClientboundPacketToQueue(PacketWrapper packetWrapper) {
        this.packetQueue.add(this.toQueuedPacket(packetWrapper, true, false));
    }

    public void addServerboundPacketToQueue(PacketWrapper packetWrapper) {
        QueuedPacket queuedPacket = this.toQueuedPacket(packetWrapper, false, false);
        int n = queuedPacket.buf().readableBytes();
        if (this.queuedServerboundPackets >= MAX_SERVERBOUND_QUEUED_PACKETS || this.queuedServerboundBytes + n > MAX_SERVERBOUND_QUEUED_BYTES) {
            packetWrapper.user().disconnect("Sent too many packets during config phase");
            return;
        }
        ++this.queuedServerboundPackets;
        this.queuedServerboundBytes += n;
        this.packetQueue.add(queuedPacket);
    }

    private QueuedPacket toQueuedPacket(PacketWrapper packetWrapper, boolean bl, boolean bl2) {
        ByteBuf byteBuf = Unpooled.buffer();
        PacketType packetType = packetWrapper.getPacketType();
        int n = packetWrapper.getId();
        packetWrapper.setId(-1);
        packetWrapper.writeToBuffer(byteBuf);
        return new QueuedPacket(byteBuf, bl, packetType, n, bl2);
    }

    public void setJoinGamePacket(PacketWrapper packetWrapper) {
        this.joinGamePacket = this.toQueuedPacket(packetWrapper, true, true);
        this.queuedJoinGame = true;
    }

    @Override
    public void onRemove() {
        for (QueuedPacket queuedPacket : this.packetQueue) {
            queuedPacket.buf().release();
        }
        if (this.joinGamePacket != null) {
            this.joinGamePacket.buf().release();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendQueuedPackets(UserConnection userConnection) {
        PacketWrapper packetWrapper;
        boolean bl;
        boolean bl2 = bl = this.joinGamePacket != null;
        if (bl) {
            this.packetQueue.add(0, this.joinGamePacket);
            this.joinGamePacket = null;
        }
        if ((packetWrapper = this.clientInformationPacket(userConnection)) != null) {
            this.packetQueue.add(bl ? 1 : 0, this.toQueuedPacket(packetWrapper, false, true));
        }
        QueuedPacket[] queuedPacketArray = this.packetQueue.toArray(EMPTY_PACKET_ARRAY);
        this.packetQueue.clear();
        for (QueuedPacket queuedPacket : queuedPacketArray) {
            try {
                PacketWrapper packetWrapper2 = queuedPacket.packetType() != null ? PacketWrapper.create(queuedPacket.packetType(), queuedPacket.buf(), userConnection) : PacketWrapper.create(queuedPacket.packetId(), queuedPacket.buf(), userConnection);
                if (queuedPacket.clientbound()) {
                    packetWrapper2.send(Protocol1_20To1_20_2.class, queuedPacket.skipCurrentPipeline());
                    continue;
                }
                packetWrapper2.sendToServer(Protocol1_20To1_20_2.class, queuedPacket.skipCurrentPipeline());
            }
            finally {
                queuedPacket.buf().release();
            }
        }
    }

    public void clear() {
        this.packetQueue.clear();
        this.bridgePhase = BridgePhase.NONE;
        this.queuedJoinGame = false;
        this.queuedServerboundBytes = 0;
    }

    public boolean queuedOrSentJoinGame() {
        return this.queuedJoinGame;
    }

    public @Nullable PacketWrapper clientInformationPacket(UserConnection userConnection) {
        if (this.clientInformation == null) {
            return null;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_19_4.CLIENT_INFORMATION, userConnection);
        packetWrapper.write(Types.STRING, this.clientInformation.language);
        packetWrapper.write(Types.BYTE, this.clientInformation.viewDistance);
        packetWrapper.write(Types.VAR_INT, this.clientInformation.chatVisibility);
        packetWrapper.write(Types.BOOLEAN, this.clientInformation.showChatColors);
        packetWrapper.write(Types.UNSIGNED_BYTE, this.clientInformation.modelCustomization);
        packetWrapper.write(Types.VAR_INT, this.clientInformation.mainHand);
        packetWrapper.write(Types.BOOLEAN, this.clientInformation.textFiltering);
        packetWrapper.write(Types.BOOLEAN, this.clientInformation.allowListing);
        return packetWrapper;
    }

    public static enum BridgePhase {
        NONE,
        PROFILE_SENT,
        CONFIGURATION,
        REENTERING_CONFIGURATION;

    }

    public static final class ClientInformation {
        private final String language;
        private final byte viewDistance;
        private final int chatVisibility;
        private final boolean showChatColors;
        private final short modelCustomization;
        private final int mainHand;
        private final boolean textFiltering;
        private final boolean allowListing;

        public ClientInformation(String string, byte by, int n, boolean bl, short s, int n2, boolean bl2, boolean bl3) {
            this.language = string;
            this.viewDistance = by;
            this.chatVisibility = n;
            this.showChatColors = bl;
            this.modelCustomization = s;
            this.mainHand = n2;
            this.textFiltering = bl2;
            this.allowListing = bl3;
        }
    }

    public static final class QueuedPacket {
        private final ByteBuf buf;
        private final boolean clientbound;
        private final PacketType packetType;
        private final int packetId;
        private final boolean skipCurrentPipeline;

        private QueuedPacket(ByteBuf byteBuf, boolean bl, @Nullable PacketType packetType, int n, boolean bl2) {
            this.buf = byteBuf;
            this.clientbound = bl;
            this.packetType = packetType;
            this.packetId = n;
            this.skipCurrentPipeline = bl2;
        }

        public ByteBuf buf() {
            return this.buf;
        }

        public boolean clientbound() {
            return this.clientbound;
        }

        public int packetId() {
            return this.packetId;
        }

        public @Nullable PacketType packetType() {
            return this.packetType;
        }

        public boolean skipCurrentPipeline() {
            return this.skipCurrentPipeline;
        }
    }
}

