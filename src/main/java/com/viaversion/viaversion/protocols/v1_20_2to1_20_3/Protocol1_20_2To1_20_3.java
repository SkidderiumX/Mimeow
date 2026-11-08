/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_2to1_20_3;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_3;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.BlockItemPacketRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.EntityPacketRewriter1_20_3;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.UUID;

public class Protocol1_20_2To1_20_3
extends AbstractProtocol<ClientboundPacket1_20_2, ClientboundPacket1_20_3, ServerboundPacket1_20_2, ServerboundPacket1_20_3> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.20.2", "1.20.3");
    private final BlockItemPacketRewriter1_20_3 itemRewriter = new BlockItemPacketRewriter1_20_3(this);
    private final ParticleRewriter<ClientboundPacket1_20_2> particleRewriter = new ParticleRewriter<ClientboundPacket1_20_2>(this);
    private final EntityPacketRewriter1_20_3 entityRewriter = new EntityPacketRewriter1_20_3(this);
    private final TagRewriter<ClientboundPacket1_20_2> tagRewriter = new TagRewriter<ClientboundPacket1_20_2>(this);
    private final BlockRewriter<ClientboundPacket1_20_2> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_20_2::new);

    public Protocol1_20_2To1_20_3() {
        super(ClientboundPacket1_20_2.class, ClientboundPacket1_20_3.class, ServerboundPacket1_20_2.class, ServerboundPacket1_20_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.cancelServerbound(ServerboundPackets1_20_3.CONTAINER_SLOT_STATE_CHANGED);
        this.registerClientbound(ClientboundPackets1_20_2.SET_SCORE, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            int n = packetWrapper.read(Types.VAR_INT);
            String string = packetWrapper.read(Types.STRING);
            if (n == 1) {
                packetWrapper.write(Types.OPTIONAL_STRING, string.isEmpty() ? null : string);
                packetWrapper.setPacketType(ClientboundPackets1_20_3.RESET_SCORE);
                return;
            }
            packetWrapper.write(Types.STRING, string);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.TRUSTED_OPTIONAL_TAG, null);
            packetWrapper.write(Types.BOOLEAN, false);
        });
        this.registerClientbound(ClientboundPackets1_20_2.SET_OBJECTIVE, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.convertComponent(packetWrapper);
                int n = packetWrapper.passthrough(Types.VAR_INT);
                if (n == 0 && Via.getConfig().hideScoreboardNumbers()) {
                    packetWrapper.write(Types.BOOLEAN, true);
                    packetWrapper.write(Types.VAR_INT, 0);
                } else {
                    packetWrapper.write(Types.BOOLEAN, false);
                }
            }
        });
        this.registerServerbound(ServerboundPackets1_20_3.SET_JIGSAW_BLOCK, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.read(Types.VAR_INT);
            packetWrapper.read(Types.VAR_INT);
        });
        this.replaceClientbound(ClientboundPackets1_20_2.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    this.convertComponent(packetWrapper);
                    this.convertComponent(packetWrapper);
                    this.itemRewriter.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_20_2));
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                n2 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n2; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
        this.registerClientbound(ClientboundPackets1_20_2.COMMAND_SUGGESTIONS, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                this.convertOptionalComponent(packetWrapper);
            }
        });
        this.registerClientbound(ClientboundPackets1_20_2.MAP_ITEM_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                int n = packetWrapper.passthrough(Types.VAR_INT);
                for (int i = 0; i < n; ++i) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    packetWrapper.passthrough(Types.BYTE);
                    this.convertOptionalComponent(packetWrapper);
                }
            }
        });
        this.registerClientbound(ClientboundPackets1_20_2.BOSS_EVENT, packetWrapper -> {
            packetWrapper.passthrough(Types.UUID);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0 || n == 3) {
                this.convertComponent(packetWrapper);
            }
        });
        this.registerClientbound(ClientboundPackets1_20_2.PLAYER_CHAT, packetWrapper -> {
            int n;
            packetWrapper.passthrough(Types.UUID);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.OPTIONAL_SIGNATURE_BYTES);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.LONG);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (n = 0; n < n2; ++n) {
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                if (n3 != 0) continue;
                packetWrapper.passthrough(Types.SIGNATURE_BYTES);
            }
            this.convertOptionalComponent(packetWrapper);
            n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 2) {
                packetWrapper.passthrough(Types.LONG_ARRAY_PRIMITIVE);
            }
            packetWrapper.passthrough(Types.VAR_INT);
            this.convertComponent(packetWrapper);
            this.convertOptionalComponent(packetWrapper);
        });
        this.registerClientbound(ClientboundPackets1_20_2.SET_PLAYER_TEAM, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.convertComponent(packetWrapper);
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                this.convertComponent(packetWrapper);
                this.convertComponent(packetWrapper);
            }
        });
        this.registerClientbound(ClientboundConfigurationPackets1_20_2.DISCONNECT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.DISCONNECT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.RESOURCE_PACK, ClientboundPackets1_20_3.RESOURCE_PACK_PUSH, this.resourcePackHandler(ClientboundPackets1_20_3.RESOURCE_PACK_POP));
        this.registerClientbound(ClientboundPackets1_20_2.SERVER_DATA, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.SET_ACTION_BAR_TEXT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.SET_TITLE_TEXT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.SET_SUBTITLE_TEXT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_2.DISGUISED_CHAT, packetWrapper -> {
            this.convertComponent(packetWrapper);
            packetWrapper.passthrough(Types.VAR_INT);
            this.convertComponent(packetWrapper);
            this.convertOptionalComponent(packetWrapper);
        });
        this.registerClientbound(ClientboundPackets1_20_2.SYSTEM_CHAT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_2.OPEN_SCREEN, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, MAPPINGS.getMenuMappings().getNewId(n));
            this.convertComponent(packetWrapper);
        });
        this.registerClientbound(ClientboundPackets1_20_2.TAB_LIST, packetWrapper -> {
            this.convertComponent(packetWrapper);
            this.convertComponent(packetWrapper);
        });
        this.registerClientbound(ClientboundPackets1_20_2.PLAYER_COMBAT_KILL, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> Protocol1_20_2To1_20_3.this.convertComponent(packetWrapper));
            }
        });
        this.registerClientbound(ClientboundPackets1_20_2.PLAYER_INFO_UPDATE, packetWrapper -> {
            BitSet bitSet = packetWrapper.passthrough(Types.PROFILE_ACTIONS_ENUM1_19_3);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.UUID);
                if (bitSet.get(0)) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                }
                if (bitSet.get(1) && packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    packetWrapper.passthrough(Types.UUID);
                    packetWrapper.passthrough(Types.PROFILE_KEY);
                }
                if (bitSet.get(2)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (bitSet.get(3)) {
                    packetWrapper.passthrough(Types.BOOLEAN);
                }
                if (bitSet.get(4)) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if (!bitSet.get(5)) continue;
                this.convertOptionalComponent(packetWrapper);
            }
        });
        this.registerServerbound(ServerboundPackets1_20_3.RESOURCE_PACK, this.resourcePackStatusHandler());
        this.registerServerbound(ServerboundConfigurationPackets1_20_2.RESOURCE_PACK, this.resourcePackStatusHandler());
        this.registerClientbound(ClientboundConfigurationPackets1_20_2.RESOURCE_PACK, ClientboundConfigurationPackets1_20_3.RESOURCE_PACK_PUSH, this.resourcePackHandler(ClientboundConfigurationPackets1_20_3.RESOURCE_PACK_POP));
    }

    private PacketHandler resourcePackStatusHandler() {
        return packetWrapper -> {
            packetWrapper.read(Types.UUID);
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 4) {
                packetWrapper.cancel();
            } else if (n > 4) {
                packetWrapper.write(Types.VAR_INT, 2);
            } else {
                packetWrapper.write(Types.VAR_INT, n);
            }
        };
    }

    private PacketHandler resourcePackHandler(ClientboundPacketType clientboundPacketType) {
        return packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(clientboundPacketType);
            packetWrapper2.write(Types.OPTIONAL_UUID, null);
            packetWrapper2.send(Protocol1_20_2To1_20_3.class);
            String string = packetWrapper.read(Types.STRING);
            String string2 = packetWrapper.read(Types.STRING);
            packetWrapper.write(Types.UUID, UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)));
            packetWrapper.write(Types.STRING, string);
            packetWrapper.write(Types.STRING, string2);
            packetWrapper.passthrough(Types.BOOLEAN);
            this.convertOptionalComponent(packetWrapper);
        };
    }

    private void convertComponent(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.TRUSTED_TAG, ComponentUtil.jsonToTag(packetWrapper.read(Types.COMPONENT)));
    }

    private void convertOptionalComponent(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.TRUSTED_OPTIONAL_TAG, ComponentUtil.jsonToTag(packetWrapper.read(Types.OPTIONAL_COMPONENT)));
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_20_3.initialize(this);
        ParticleType.Fillers.fill1_20_3(this, Types1_20_3.PARTICLE);
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_3.PLAYER));
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public BlockItemPacketRewriter1_20_3 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_20_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_20_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    public EntityPacketRewriter1_20_3 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_2> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_2, ClientboundPacket1_20_3, ServerboundPacket1_20_2, ServerboundPacket1_20_3> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_2, ClientboundPacket1_20_3, ServerboundPacket1_20_2, ServerboundPacket1_20_3>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_2.class, ClientboundConfigurationPackets1_20_2.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_20_3.class, ClientboundConfigurationPackets1_20_3.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_2.class, ServerboundConfigurationPackets1_20_2.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_3.class, ServerboundConfigurationPackets1_20_2.class));
    }
}

