/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_2to1_20;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.provider.AdvancementCriteriaProvider;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter.BlockItemPacketRewriter1_20_2;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter.BlockRewriter1_20_2;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.rewriter.EntityPacketRewriter1_20_2;
import com.viaversion.viabackwards.protocol.v1_20_2to1_20.storage.ConfigurationPacketStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.Protocol1_20To1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import java.util.UUID;

public class Protocol1_20_2To1_20
extends BackwardsProtocol<ClientboundPackets1_20_2, ClientboundPackets1_19_4, ServerboundPackets1_20_2, ServerboundPackets1_19_4> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.20.2", "1.20", Protocol1_20To1_20_2.class);
    private final EntityPacketRewriter1_20_2 entityPacketRewriter = new EntityPacketRewriter1_20_2(this);
    private final BlockItemPacketRewriter1_20_2 itemPacketRewriter = new BlockItemPacketRewriter1_20_2(this);
    private final ParticleRewriter<ClientboundPackets1_20_2> particleRewriter = new ParticleRewriter<ClientboundPackets1_20_2>(this);
    private final TagRewriter<ClientboundPackets1_20_2> tagRewriter = new TagRewriter<ClientboundPackets1_20_2>(this);
    private final BlockRewriter<ClientboundPackets1_20_2> blockRewriter = new BlockRewriter1_20_2(this);

    public Protocol1_20_2To1_20() {
        super(ClientboundPackets1_20_2.class, ClientboundPackets1_19_4.class, ServerboundPackets1_20_2.class, ServerboundPackets1_19_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_20_2.SET_DISPLAY_OBJECTIVE, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.BYTE, (byte)n);
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.user().put(new ConfigurationPacketStorage());
            packetWrapper.user().getProtocolInfo().setClientState(State.LOGIN);
            packetWrapper.create(ServerboundLoginPackets.LOGIN_ACKNOWLEDGED).scheduleSendToServer(Protocol1_20_2To1_20.class);
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.FINISH_CONFIGURATION, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            packetWrapper.user().getProtocolInfo().setServerState(State.PLAY);
            packetWrapper.user().get(ConfigurationPacketStorage.class).setFinished(true);
            packetWrapper.create(ServerboundConfigurationPackets1_20_2.FINISH_CONFIGURATION).sendToServer(Protocol1_20_2To1_20.class);
            packetWrapper.user().getProtocolInfo().setClientState(State.PLAY);
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.STRING);
            UUID uUID = packetWrapper.read(Types.OPTIONAL_UUID);
            packetWrapper.write(Types.UUID, uUID != null ? uUID : new UUID(0L, 0L));
        });
        this.registerClientbound(ClientboundPackets1_20_2.START_CONFIGURATION, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            packetWrapper.user().getProtocolInfo().setServerState(State.CONFIGURATION);
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_20_2.CONFIGURATION_ACKNOWLEDGED);
            packetWrapper2.sendToServer(Protocol1_20_2To1_20.class);
            packetWrapper.user().getProtocolInfo().setClientState(State.CONFIGURATION);
            packetWrapper.user().put(new ConfigurationPacketStorage());
        });
        this.cancelClientbound(ClientboundPackets1_20_2.PONG_RESPONSE);
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.DISCONNECT.getId(), -1, packetWrapper -> packetWrapper.setPacketType(ClientboundPackets1_19_4.DISCONNECT));
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.KEEP_ALIVE.getId(), -1, packetWrapper -> packetWrapper.setPacketType(ClientboundPackets1_19_4.KEEP_ALIVE));
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.PING.getId(), -1, packetWrapper -> packetWrapper.setPacketType(ClientboundPackets1_19_4.PING));
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.RESOURCE_PACK.getId(), -1, packetWrapper -> {
            packetWrapper.user().get(ConfigurationPacketStorage.class).setResourcePack(packetWrapper);
            packetWrapper.cancel();
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundConfigurationPackets1_20_2.RESOURCE_PACK);
            packetWrapper2.write(Types.VAR_INT, 3);
            packetWrapper2.sendToServer(Protocol1_20_2To1_20.class);
            PacketWrapper packetWrapper3 = packetWrapper.create(ServerboundConfigurationPackets1_20_2.RESOURCE_PACK);
            packetWrapper3.write(Types.VAR_INT, 0);
            packetWrapper3.sendToServer(Protocol1_20_2To1_20.class);
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.REGISTRY_DATA.getId(), -1, packetWrapper -> {
            packetWrapper.cancel();
            CompoundTag compoundTag = packetWrapper.read(Types.COMPOUND_TAG);
            this.entityPacketRewriter.trackBiomeSize(packetWrapper.user(), compoundTag);
            this.entityPacketRewriter.cacheDimensionData(packetWrapper.user(), compoundTag);
            packetWrapper.user().get(ConfigurationPacketStorage.class).setRegistry(compoundTag);
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.UPDATE_ENABLED_FEATURES.getId(), -1, packetWrapper -> {
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            packetWrapper.user().get(ConfigurationPacketStorage.class).setEnabledFeatures(stringArray);
            packetWrapper.cancel();
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.UPDATE_TAGS.getId(), -1, packetWrapper -> {
            this.tagRewriter.handleGeneric(packetWrapper);
            packetWrapper.user().get(ConfigurationPacketStorage.class).addRawPacket(packetWrapper, ClientboundPackets1_19_4.UPDATE_TAGS);
            packetWrapper.cancel();
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.CUSTOM_PAYLOAD.getId(), -1, packetWrapper -> {
            packetWrapper.user().get(ConfigurationPacketStorage.class).addRawPacket(packetWrapper, ClientboundPackets1_19_4.CUSTOM_PAYLOAD);
            packetWrapper.cancel();
        });
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(AdvancementCriteriaProvider.class, new AdvancementCriteriaProvider());
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws InformativeException, CancelException {
        ConfigurationPacketStorage configurationPacketStorage = packetWrapper.user().get(ConfigurationPacketStorage.class);
        if (configurationPacketStorage == null || configurationPacketStorage.isFinished()) {
            super.transform(direction, state, packetWrapper);
            return;
        }
        if (direction == Direction.CLIENTBOUND) {
            super.transform(direction, State.CONFIGURATION, packetWrapper);
            return;
        }
        int n = packetWrapper.getId();
        if (n == ServerboundPackets1_19_4.CLIENT_INFORMATION.getId()) {
            packetWrapper.setPacketType(ServerboundConfigurationPackets1_20_2.CLIENT_INFORMATION);
        } else if (n == ServerboundPackets1_19_4.CUSTOM_PAYLOAD.getId()) {
            packetWrapper.setPacketType(ServerboundConfigurationPackets1_20_2.CUSTOM_PAYLOAD);
        } else if (n == ServerboundPackets1_19_4.KEEP_ALIVE.getId()) {
            packetWrapper.setPacketType(ServerboundConfigurationPackets1_20_2.KEEP_ALIVE);
        } else if (n == ServerboundPackets1_19_4.PONG.getId()) {
            packetWrapper.setPacketType(ServerboundConfigurationPackets1_20_2.PONG);
        } else if (n == ServerboundPackets1_19_4.RESOURCE_PACK.getId()) {
            packetWrapper.setPacketType(ServerboundConfigurationPackets1_20_2.RESOURCE_PACK);
        } else {
            throw CancelException.generate();
        }
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_4.PLAYER));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_20_2 getEntityRewriter() {
        return this.entityPacketRewriter;
    }

    public BlockItemPacketRewriter1_20_2 getItemRewriter() {
        return this.itemPacketRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_20_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_20_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_20_2> getTagRewriter() {
        return this.tagRewriter;
    }
}

