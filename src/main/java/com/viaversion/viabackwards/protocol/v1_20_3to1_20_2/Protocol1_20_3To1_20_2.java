/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_3to1_20_2;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.rewriter.BlockItemPacketRewriter1_20_3;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.rewriter.BlockPacketRewriter1_20_3;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.rewriter.EntityPacketRewriter1_20_3;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.storage.ResourcepackIDStorage;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.storage.SpawnPositionStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_3;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.Pair;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.Protocol1_20_2To1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.BitSet;
import java.util.UUID;

public class Protocol1_20_3To1_20_2
extends BackwardsProtocol<ClientboundPacket1_20_3, ClientboundPacket1_20_2, ServerboundPacket1_20_3, ServerboundPacket1_20_2> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.20.3", "1.20.2", Protocol1_20_2To1_20_3.class);
    private final EntityPacketRewriter1_20_3 entityRewriter = new EntityPacketRewriter1_20_3(this);
    private final BlockItemPacketRewriter1_20_3 itemRewriter = new BlockItemPacketRewriter1_20_3(this);
    private final ParticleRewriter<ClientboundPacket1_20_3> particleRewriter = new ParticleRewriter<ClientboundPacket1_20_3>(this);
    private final JsonNBTComponentRewriter<ClientboundPacket1_20_3> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPacket1_20_3>(this, ComponentRewriterBase.ReadType.NBT);
    private final TagRewriter<ClientboundPacket1_20_3> tagRewriter = new TagRewriter<ClientboundPacket1_20_3>(this);
    private final BlockRewriter<ClientboundPacket1_20_3> blockRewriter = new BlockPacketRewriter1_20_3(this);

    public Protocol1_20_3To1_20_2() {
        super(ClientboundPacket1_20_3.class, ClientboundPacket1_20_2.class, ServerboundPacket1_20_3.class, ServerboundPacket1_20_2.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        CommandRewriter1_19_4<ClientboundPacket1_20_3> commandRewriter1_19_4 = new CommandRewriter1_19_4<ClientboundPacket1_20_3>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                if (string.equals("minecraft:style")) {
                    packetWrapper.write(Types.VAR_INT, 1);
                } else {
                    super.handleArgument(packetWrapper, string);
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_20_3.COMMANDS, commandRewriter1_19_4::handle1_19);
        this.registerClientbound(ClientboundPackets1_20_3.RESET_SCORE, ClientboundPackets1_20_2.SET_SCORE, (PacketWrapper packetWrapper) -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.VAR_INT, 1);
            String string = packetWrapper.read(Types.OPTIONAL_STRING);
            packetWrapper.write(Types.STRING, string != null ? string : "");
        });
        this.replaceClientbound(ClientboundPackets1_20_3.SET_SCORE, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.clearInputBuffer();
        });
        this.replaceClientbound(ClientboundPackets1_20_3.SET_OBJECTIVE, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                this.convertComponent(packetWrapper);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.clearInputBuffer();
            }
        });
        this.cancelClientbound(ClientboundPackets1_20_3.TICKING_STATE);
        this.cancelClientbound(ClientboundPackets1_20_3.TICKING_STEP);
        this.registerServerbound(ServerboundPackets1_20_2.SET_JIGSAW_BLOCK, packetWrapper -> {
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.VAR_INT, 0);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.UPDATE_ADVANCEMENTS, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    this.convertComponent(packetWrapper);
                    this.convertComponent(packetWrapper);
                    Item item = this.itemRewriter.handleItemToClient(packetWrapper.user(), packetWrapper.read(Types.ITEM1_20_2));
                    packetWrapper.write(Types.ITEM1_20_2, item);
                    packetWrapper.passthrough(Types.VAR_INT);
                    n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (n2 = 0; n2 < n3; ++n2) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
        this.registerClientbound(ClientboundPackets1_20_3.COMMAND_SUGGESTIONS, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                this.convertOptionalComponent(packetWrapper);
            }
        });
        this.registerClientbound(ClientboundPackets1_20_3.MAP_ITEM_DATA, packetWrapper -> {
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
        this.replaceClientbound(ClientboundPackets1_20_3.BOSS_EVENT, packetWrapper -> {
            packetWrapper.passthrough(Types.UUID);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0 || n == 3) {
                this.convertComponent(packetWrapper);
            }
        });
        this.replaceClientbound(ClientboundPackets1_20_3.PLAYER_CHAT, packetWrapper -> {
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
        this.replaceClientbound(ClientboundPackets1_20_3.SET_PLAYER_TEAM, packetWrapper -> {
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
        this.replaceClientbound(ClientboundConfigurationPackets1_20_3.DISCONNECT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.DISCONNECT, this::convertComponent);
        this.registerClientbound(ClientboundPackets1_20_3.RESOURCE_PACK_PUSH, ClientboundPackets1_20_2.RESOURCE_PACK, this.resourcePackHandler());
        this.replaceClientbound(ClientboundPackets1_20_3.SERVER_DATA, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.SET_ACTION_BAR_TEXT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.SET_TITLE_TEXT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.SET_SUBTITLE_TEXT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.DISGUISED_CHAT, packetWrapper -> {
            this.convertComponent(packetWrapper);
            packetWrapper.passthrough(Types.VAR_INT);
            this.convertComponent(packetWrapper);
            this.convertOptionalComponent(packetWrapper);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.SYSTEM_CHAT, this::convertComponent);
        this.replaceClientbound(ClientboundPackets1_20_3.OPEN_SCREEN, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = MAPPINGS.getMenuMappings().getNewId(n);
            if (n2 == -1) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.VAR_INT, n2);
            this.convertComponent(packetWrapper);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.TAB_LIST, packetWrapper -> {
            this.convertComponent(packetWrapper);
            this.convertComponent(packetWrapper);
        });
        this.replaceClientbound(ClientboundPackets1_20_3.PLAYER_COMBAT_KILL, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> Protocol1_20_3To1_20_2.this.convertComponent(packetWrapper));
            }
        });
        this.replaceClientbound(ClientboundPackets1_20_3.PLAYER_INFO_UPDATE, packetWrapper -> {
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
        this.registerClientbound(ClientboundPackets1_20_3.SET_DEFAULT_SPAWN_POSITION, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            packetWrapper.user().get(SpawnPositionStorage.class).setSpawnPosition(Pair.of(blockPosition, Float.valueOf(f)));
        });
        this.registerClientbound(ClientboundPackets1_20_3.GAME_EVENT, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            if (s == 13) {
                packetWrapper.cancel();
                Pair<BlockPosition, Float> pair = packetWrapper.user().get(SpawnPositionStorage.class).getSpawnPosition();
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_20_2.SET_DEFAULT_SPAWN_POSITION);
                packetWrapper2.write(Types.BLOCK_POSITION1_14, pair.first());
                packetWrapper2.write(Types.FLOAT, pair.second());
                packetWrapper2.send(Protocol1_20_3To1_20_2.class, true);
            }
        });
        this.cancelClientbound(ClientboundPackets1_20_3.RESOURCE_PACK_POP);
        this.registerServerbound(ServerboundPackets1_20_2.RESOURCE_PACK, this.resourcePackStatusHandler());
        this.cancelClientbound(ClientboundConfigurationPackets1_20_3.RESOURCE_PACK_POP);
        this.registerServerbound(ServerboundConfigurationPackets1_20_2.RESOURCE_PACK, this.resourcePackStatusHandler());
        this.registerClientbound(ClientboundConfigurationPackets1_20_3.RESOURCE_PACK_PUSH, ClientboundConfigurationPackets1_20_2.RESOURCE_PACK, this.resourcePackHandler());
    }

    private PacketHandler resourcePackStatusHandler() {
        return packetWrapper -> {
            ResourcepackIDStorage resourcepackIDStorage = packetWrapper.user().get(ResourcepackIDStorage.class);
            packetWrapper.write(Types.UUID, resourcepackIDStorage != null ? resourcepackIDStorage.uuid() : UUID.randomUUID());
        };
    }

    private PacketHandler resourcePackHandler() {
        return packetWrapper -> {
            UUID uUID = packetWrapper.read(Types.UUID);
            packetWrapper.user().put(new ResourcepackIDStorage(uUID));
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.BOOLEAN);
            this.convertOptionalComponent(packetWrapper);
        };
    }

    private void convertComponent(PacketWrapper packetWrapper) {
        Tag tag = packetWrapper.read(Types.TRUSTED_TAG);
        this.translatableRewriter.processTag(packetWrapper.user(), tag);
        packetWrapper.write(Types.COMPONENT, ComponentUtil.tagToJson(tag));
    }

    private void convertOptionalComponent(PacketWrapper packetWrapper) {
        Tag tag = packetWrapper.read(Types.TRUSTED_OPTIONAL_TAG);
        this.translatableRewriter.processTag(packetWrapper.user(), tag);
        packetWrapper.write(Types.OPTIONAL_COMPONENT, ComponentUtil.tagToJson(tag));
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new SpawnPositionStorage());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_20_3.PLAYER));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public BlockItemPacketRewriter1_20_3 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_20_3> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_20_3> getParticleRewriter() {
        return this.particleRewriter;
    }

    public EntityPacketRewriter1_20_3 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPacket1_20_3> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_20_3> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_20_3, ClientboundPacket1_20_2, ServerboundPacket1_20_3, ServerboundPacket1_20_2> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_20_3, ClientboundPacket1_20_2, ServerboundPacket1_20_3, ServerboundPacket1_20_2>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_20_3.class, ClientboundConfigurationPackets1_20_3.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_20_2.class, ClientboundConfigurationPackets1_20_2.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_20_3.class, ServerboundConfigurationPackets1_20_2.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_20_2.class, ServerboundConfigurationPackets1_20_2.class));
    }
}

