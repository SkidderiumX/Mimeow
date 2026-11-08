/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20to1_20_2;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.BlockItemPacketRewriter1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.BlockRewriter1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.rewriter.EntityPacketRewriter1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.storage.ConfigurationState;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.storage.LastResourcePack;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.storage.LastTags;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.Key;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_20To1_20_2
extends AbstractProtocol<ClientboundPackets1_19_4, ClientboundPackets1_20_2, ServerboundPackets1_19_4, ServerboundPackets1_20_2> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.20", "1.20.2");
    private final EntityPacketRewriter1_20_2 entityPacketRewriter = new EntityPacketRewriter1_20_2(this);
    private final BlockItemPacketRewriter1_20_2 itemPacketRewriter = new BlockItemPacketRewriter1_20_2(this);
    private final ParticleRewriter<ClientboundPackets1_19_4> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_4>(this);
    private final TagRewriter<ClientboundPackets1_19_4> tagRewriter = new TagRewriter<ClientboundPackets1_19_4>(this);
    private final BlockRewriter<ClientboundPackets1_19_4> blockRewriter = new BlockRewriter1_20_2(this);

    public Protocol1_20To1_20_2() {
        super(ClientboundPackets1_19_4.class, ClientboundPackets1_20_2.class, ServerboundPackets1_19_4.class, ServerboundPackets1_20_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_19_4.CUSTOM_PAYLOAD, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(Protocol1_20To1_20_2::sanitizeCustomPayload);
            }
        });
        this.registerServerbound(ServerboundPackets1_20_2.CUSTOM_PAYLOAD, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            Protocol1_20To1_20_2.sanitizeCustomPayload(packetWrapper);
        });
        this.registerClientbound(ClientboundPackets1_19_4.SYSTEM_CHAT, packetWrapper -> {
            JsonElement jsonElement;
            JsonObject jsonObject;
            if (packetWrapper.user().isClientSide() || Via.getPlatform().isProxy()) {
                return;
            }
            JsonElement jsonElement2 = packetWrapper.passthrough(Types.COMPONENT);
            if (jsonElement2 instanceof JsonObject && (jsonObject = (JsonObject)jsonElement2).has("translate") && (jsonElement = jsonObject.get("translate")) != null && jsonElement.getAsString().equals("multiplayer.message_not_delivered")) {
                packetWrapper.cancel();
            }
        });
        this.registerClientbound(ClientboundPackets1_19_4.RESOURCE_PACK, packetWrapper -> {
            String string = packetWrapper.passthrough(Types.STRING);
            String string2 = packetWrapper.passthrough(Types.STRING);
            boolean bl = packetWrapper.passthrough(Types.BOOLEAN);
            JsonElement jsonElement = packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
            packetWrapper.user().put(new LastResourcePack(string, string2, bl, jsonElement));
        });
        this.replaceClientbound(ClientboundPackets1_19_4.UPDATE_TAGS, packetWrapper -> {
            this.tagRewriter.handleGeneric(packetWrapper);
            packetWrapper.resetReader();
            packetWrapper.user().put(new LastTags(packetWrapper));
        });
        this.registerClientbound(State.CONFIGURATION, ClientboundConfigurationPackets1_20_2.UPDATE_TAGS, this::handleConfigTags);
        this.registerClientbound(ClientboundPackets1_19_4.SET_DISPLAY_OBJECTIVE, packetWrapper -> {
            byte by = packetWrapper.read(Types.BYTE);
            packetWrapper.write(Types.VAR_INT, Integer.valueOf(by));
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.STRING);
            UUID uUID = packetWrapper.read(Types.UUID);
            packetWrapper.write(Types.OPTIONAL_UUID, uUID);
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            packetWrapper.user().get(ConfigurationState.class).setBridgePhase(ConfigurationState.BridgePhase.PROFILE_SENT);
            packetWrapper.user().getProtocolInfo().setServerState(State.PLAY);
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.LOGIN_ACKNOWLEDGED.getId(), -1, packetWrapper -> {
            packetWrapper.cancel();
            packetWrapper.user().getProtocolInfo().setServerState(State.PLAY);
            ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
            configurationState.setBridgePhase(ConfigurationState.BridgePhase.CONFIGURATION);
            configurationState.sendQueuedPackets(packetWrapper.user());
        });
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.FINISH_CONFIGURATION.getId(), -1, packetWrapper -> {
            packetWrapper.cancel();
            packetWrapper.user().getProtocolInfo().setClientState(State.PLAY);
            ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
            configurationState.setBridgePhase(ConfigurationState.BridgePhase.NONE);
            configurationState.sendQueuedPackets(packetWrapper.user());
            configurationState.clear();
        });
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.CLIENT_INFORMATION.getId(), -1, packetWrapper -> {
            ConfigurationState.ClientInformation clientInformation = new ConfigurationState.ClientInformation(packetWrapper.read(Types.STRING), packetWrapper.read(Types.BYTE), packetWrapper.read(Types.VAR_INT), packetWrapper.read(Types.BOOLEAN), packetWrapper.read(Types.UNSIGNED_BYTE), packetWrapper.read(Types.VAR_INT), packetWrapper.read(Types.BOOLEAN), packetWrapper.read(Types.BOOLEAN));
            ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
            configurationState.setClientInformation(clientInformation);
            packetWrapper.cancel();
        });
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.CUSTOM_PAYLOAD.getId(), -1, this.queueServerboundPacket(ServerboundPackets1_20_2.CUSTOM_PAYLOAD));
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.KEEP_ALIVE.getId(), -1, this.queueServerboundPacket(ServerboundPackets1_20_2.KEEP_ALIVE));
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.PONG.getId(), -1, this.queueServerboundPacket(ServerboundPackets1_20_2.PONG));
        this.registerServerbound(State.CONFIGURATION, ServerboundConfigurationPackets1_20_2.RESOURCE_PACK.getId(), -1, PacketWrapper::cancel);
        this.cancelClientbound(ClientboundPackets1_19_4.UPDATE_ENABLED_FEATURES);
        this.registerServerbound(ServerboundPackets1_20_2.CONFIGURATION_ACKNOWLEDGED, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
            if (configurationState.bridgePhase() != ConfigurationState.BridgePhase.REENTERING_CONFIGURATION) {
                return;
            }
            packetWrapper.user().getProtocolInfo().setClientState(State.CONFIGURATION);
            configurationState.setBridgePhase(ConfigurationState.BridgePhase.CONFIGURATION);
            LastResourcePack lastResourcePack = packetWrapper.user().get(LastResourcePack.class);
            Protocol1_20To1_20_2.sendConfigurationPackets(packetWrapper.user(), configurationState.lastDimensionRegistry(), lastResourcePack);
        });
        this.cancelServerbound(ServerboundPackets1_20_2.CHUNK_BATCH_RECEIVED);
        this.registerServerbound(ServerboundPackets1_20_2.PING_REQUEST, null, (PacketWrapper packetWrapper) -> {
            packetWrapper.cancel();
            long l = packetWrapper.read(Types.LONG);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_20_2.PONG_RESPONSE);
            packetWrapper2.write(Types.LONG, l);
            packetWrapper2.sendFuture(Protocol1_20To1_20_2.class);
        });
    }

    private void handleConfigTags(PacketWrapper packetWrapper) {
        this.tagRewriter.handleGeneric(packetWrapper);
        packetWrapper.resetReader();
        LastTags lastTags = new LastTags(packetWrapper);
        lastTags.setSentDuringConfigPhase(true);
        packetWrapper.user().put(lastTags);
    }

    private static void sanitizeCustomPayload(PacketWrapper packetWrapper) {
        String string = Key.namespaced(packetWrapper.get(Types.STRING, 0));
        if (string.equals("minecraft:brand")) {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.clearInputBuffer();
        } else if (string.equals("minecraft:debug/game_test_add_marker")) {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.INT);
            packetWrapper.clearInputBuffer();
        } else if (string.equals("minecraft:debug/game_test_clear")) {
            packetWrapper.clearInputBuffer();
        }
    }

    @Override
    public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws InformativeException, CancelException {
        if (direction == Direction.SERVERBOUND) {
            super.transform(direction, state, packetWrapper);
            return;
        }
        ConfigurationState configurationState = packetWrapper.user().get(ConfigurationState.class);
        if (configurationState == null) {
            return;
        }
        ConfigurationState.BridgePhase bridgePhase = configurationState.bridgePhase();
        if (bridgePhase == ConfigurationState.BridgePhase.NONE) {
            super.transform(direction, state, packetWrapper);
            return;
        }
        int n = packetWrapper.getId();
        if (bridgePhase == ConfigurationState.BridgePhase.PROFILE_SENT || bridgePhase == ConfigurationState.BridgePhase.REENTERING_CONFIGURATION) {
            if (n == ClientboundPackets1_19_4.UPDATE_TAGS.getId()) {
                packetWrapper.user().remove(LastTags.class);
            }
            configurationState.addClientboundPacketToQueue(packetWrapper);
            throw CancelException.generate();
        }
        if (packetWrapper.getPacketType() == null || packetWrapper.getPacketType().state() != State.CONFIGURATION) {
            if (n == ClientboundPackets1_19_4.LOGIN.getId()) {
                super.transform(direction, State.PLAY, packetWrapper);
                return;
            }
            if (configurationState.queuedOrSentJoinGame()) {
                ProtocolVersion protocolVersion = Via.getAPI().getServerVersion().lowestSupportedProtocolVersion();
                if (protocolVersion.newerThanOrEqualTo(ProtocolVersion.v1_13) && !packetWrapper.user().isClientSide() && !Via.getPlatform().isProxy() && n == ClientboundPackets1_19_4.SYSTEM_CHAT.getId()) {
                    super.transform(direction, State.PLAY, packetWrapper);
                    return;
                }
                configurationState.addClientboundPacketToQueue(packetWrapper);
                throw CancelException.generate();
            }
            if (n == ClientboundPackets1_19_4.CUSTOM_PAYLOAD.getId()) {
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.CUSTOM_PAYLOAD);
            } else if (n == ClientboundPackets1_19_4.DISCONNECT.getId()) {
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.DISCONNECT);
            } else if (n == ClientboundPackets1_19_4.KEEP_ALIVE.getId()) {
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.KEEP_ALIVE);
            } else if (n == ClientboundPackets1_19_4.PING.getId()) {
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.PING);
            } else if (n == ClientboundPackets1_19_4.UPDATE_ENABLED_FEATURES.getId()) {
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.UPDATE_ENABLED_FEATURES);
            } else if (n == ClientboundPackets1_19_4.UPDATE_TAGS.getId()) {
                this.handleConfigTags(packetWrapper);
                packetWrapper.setPacketType(ClientboundConfigurationPackets1_20_2.UPDATE_TAGS);
            } else {
                configurationState.addClientboundPacketToQueue(packetWrapper);
                throw CancelException.generate();
            }
            return;
        }
        super.transform(direction, State.CONFIGURATION, packetWrapper);
    }

    public static void sendConfigurationPackets(UserConnection userConnection, CompoundTag compoundTag, @Nullable LastResourcePack lastResourcePack) {
        PacketWrapper packetWrapper;
        ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
        protocolInfo.setServerState(State.CONFIGURATION);
        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.REGISTRY_DATA, userConnection);
        packetWrapper2.write(Types.COMPOUND_TAG, compoundTag);
        packetWrapper2.send(Protocol1_20To1_20_2.class);
        LastTags lastTags = userConnection.get(LastTags.class);
        boolean bl = false;
        if (lastTags != null) {
            if (lastTags.sentDuringConfigPhase()) {
                lastTags.setSentDuringConfigPhase(false);
                bl = true;
            } else {
                bl = lastTags.sendLastTags(userConnection);
            }
        }
        if (!bl) {
            packetWrapper = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.UPDATE_TAGS, userConnection);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.send(Protocol1_20To1_20_2.class);
        }
        if (lastResourcePack != null && userConnection.getProtocolInfo().protocolVersion() == ProtocolVersion.v1_20_2) {
            packetWrapper = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.RESOURCE_PACK, userConnection);
            packetWrapper.write(Types.STRING, lastResourcePack.url());
            packetWrapper.write(Types.STRING, lastResourcePack.hash());
            packetWrapper.write(Types.BOOLEAN, lastResourcePack.required());
            packetWrapper.write(Types.OPTIONAL_COMPONENT, lastResourcePack.prompt());
            packetWrapper.send(Protocol1_20To1_20_2.class);
        }
        packetWrapper = PacketWrapper.create(ClientboundConfigurationPackets1_20_2.FINISH_CONFIGURATION, userConnection);
        packetWrapper.send(Protocol1_20To1_20_2.class);
        protocolInfo.setServerState(State.PLAY);
    }

    private PacketHandler queueServerboundPacket(ServerboundPackets1_20_2 serverboundPackets1_20_2) {
        return packetWrapper -> {
            packetWrapper.setPacketType(serverboundPackets1_20_2);
            packetWrapper.user().get(ConfigurationState.class).addServerboundPacketToQueue(packetWrapper);
            packetWrapper.cancel();
        };
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new ConfigurationState());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_4.PLAYER));
    }

    public EntityPacketRewriter1_20_2 getEntityRewriter() {
        return this.entityPacketRewriter;
    }

    public BlockItemPacketRewriter1_20_2 getItemRewriter() {
        return this.itemPacketRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_4> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_4> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_4> getTagRewriter() {
        return this.tagRewriter;
    }
}

