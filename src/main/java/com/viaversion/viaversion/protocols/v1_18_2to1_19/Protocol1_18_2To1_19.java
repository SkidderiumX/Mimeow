/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19;
import com.viaversion.viaversion.api.platform.providers.ViaProviders;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_19;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ServerboundLoginPackets;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.data.MappingData1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ServerboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.provider.AckSequenceProvider;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter.ComponentRewriter1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter.EntityPacketRewriter1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter.ItemPacketRewriter1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.rewriter.WorldPacketRewriter1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.DimensionRegistryStorage;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.LoomStorage;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.NonceStorage1_19;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.storage.SequenceStorage;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.CipherUtil;
import com.viaversion.viaversion.util.ComponentUtil;
import java.util.concurrent.ThreadLocalRandom;

public class Protocol1_18_2To1_19
extends AbstractProtocol<ClientboundPackets1_18, ClientboundPackets1_19, ServerboundPackets1_17, ServerboundPackets1_19> {
    public static final MappingData1_19 MAPPINGS = new MappingData1_19();
    private final EntityPacketRewriter1_19 entityRewriter = new EntityPacketRewriter1_19(this);
    private final ItemPacketRewriter1_19 itemRewriter = new ItemPacketRewriter1_19(this);
    private final ParticleRewriter<ClientboundPackets1_18> particleRewriter = new ParticleRewriter<ClientboundPackets1_18>(this);
    private final ComponentRewriter1_19 componentRewriter = new ComponentRewriter1_19(this);
    private final TagRewriter<ClientboundPackets1_18> tagRewriter = new TagRewriter<ClientboundPackets1_18>(this);
    private final BlockRewriter<ClientboundPackets1_18> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_18_2To1_19() {
        super(ClientboundPackets1_18.class, ClientboundPackets1_19.class, ServerboundPackets1_17.class, ServerboundPackets1_19.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_19.register(this);
        this.cancelClientbound(ClientboundPackets1_18.ADD_VIBRATION_SIGNAL);
        final SoundRewriter<ClientboundPackets1_18> soundRewriter = new SoundRewriter<ClientboundPackets1_18>(this);
        this.replaceClientbound(ClientboundPackets1_18.SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> packetWrapper.write(Types.LONG, Protocol1_18_2To1_19.this.randomLong()));
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        this.replaceClientbound(ClientboundPackets1_18.SOUND_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> packetWrapper.write(Types.LONG, Protocol1_18_2To1_19.this.randomLong()));
                this.handler(soundRewriter.getSoundHandler());
            }
        });
        this.registerClientbound(ClientboundPackets1_18.CUSTOM_SOUND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.INT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> packetWrapper.write(Types.LONG, Protocol1_18_2To1_19.this.randomLong()));
            }
        });
        PacketHandler packetHandler = packetWrapper -> packetWrapper.write(Types.COMPONENT, this.mapTextComponentIfNull(packetWrapper.user(), packetWrapper.read(Types.COMPONENT)));
        this.registerClientbound(ClientboundPackets1_18.SET_TITLE_TEXT, packetHandler);
        this.registerClientbound(ClientboundPackets1_18.SET_SUBTITLE_TEXT, packetHandler);
        this.registerClientbound(ClientboundPackets1_18.SET_ACTION_BAR_TEXT, packetHandler);
        this.registerClientbound(ClientboundPackets1_18.SET_OBJECTIVE, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                packetWrapper.write(Types.COMPONENT, this.mapTextComponentIfNull(packetWrapper.user(), packetWrapper.read(Types.COMPONENT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_18.SET_PLAYER_TEAM, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 0 || by == 2) {
                packetWrapper.write(Types.COMPONENT, this.mapTextComponentIfNull(packetWrapper.user(), packetWrapper.read(Types.COMPONENT)));
                packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.write(Types.COMPONENT, this.mapTextComponentIfNull(packetWrapper.user(), packetWrapper.read(Types.COMPONENT)));
                packetWrapper.write(Types.COMPONENT, this.mapTextComponentIfNull(packetWrapper.user(), packetWrapper.read(Types.COMPONENT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_18.PLAYER_INFO, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                JsonElement jsonElement;
                packetWrapper.passthrough(Types.UUID);
                if (n == 0) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.PROFILE_PROPERTY_ARRAY);
                    packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.passthrough(Types.VAR_INT);
                    jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                    if (this.isJsonNotNull(jsonElement)) {
                        packetWrapper.write(Types.OPTIONAL_COMPONENT, jsonElement);
                    } else {
                        packetWrapper.write(Types.OPTIONAL_COMPONENT, null);
                    }
                    packetWrapper.write(Types.OPTIONAL_PROFILE_KEY, null);
                    continue;
                }
                if (n == 1 || n == 2) {
                    packetWrapper.passthrough(Types.VAR_INT);
                    continue;
                }
                if (n != 3) continue;
                jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
                if (this.isJsonNotNull(jsonElement)) {
                    packetWrapper.write(Types.OPTIONAL_COMPONENT, jsonElement);
                    continue;
                }
                packetWrapper.write(Types.OPTIONAL_COMPONENT, null);
            }
        });
        CommandRewriter<ClientboundPackets1_18> commandRewriter = new CommandRewriter<ClientboundPackets1_18>(this);
        this.registerClientbound(ClientboundPackets1_18.COMMANDS, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                int n2;
                byte by = packetWrapper.passthrough(Types.BYTE);
                packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
                if ((by & 8) != 0) {
                    packetWrapper.passthrough(Types.VAR_INT);
                }
                if ((n2 = by & 3) == 1 || n2 == 2) {
                    packetWrapper.passthrough(Types.STRING);
                }
                if (n2 != 2) continue;
                String string = packetWrapper.read(Types.STRING);
                int n3 = MAPPINGS.getArgumentTypeMappings().mappedId(string);
                if (n3 == -1) {
                    this.getLogger().warning("Unknown command argument type: " + string);
                }
                packetWrapper.write(Types.VAR_INT, n3);
                commandRewriter.handleArgument(packetWrapper, string);
                if ((by & 0x10) == 0) continue;
                packetWrapper.passthrough(Types.STRING);
            }
            packetWrapper.passthrough(Types.VAR_INT);
        });
        this.registerClientbound(ClientboundPackets1_18.CHAT, ClientboundPackets1_19.SYSTEM_CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.COMPONENT);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    packetWrapper.write(Types.VAR_INT, Integer.valueOf(by == 0 ? (byte)1 : by));
                });
                this.read(Types.UUID);
            }
        });
        this.registerServerbound(ServerboundPackets1_19.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.read(Types.LONG);
                this.read(Types.LONG);
                this.read(Types.BYTE_ARRAY_PRIMITIVE);
                this.read(Types.BOOLEAN);
            }
        });
        this.registerServerbound(ServerboundPackets1_19.CHAT_COMMAND, ServerboundPackets1_17.CHAT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.read(Types.LONG);
                this.read(Types.LONG);
                this.handler(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    packetWrapper.set(Types.STRING, 0, "/" + string);
                    int n = packetWrapper.read(Types.VAR_INT);
                    for (int i = 0; i < n; ++i) {
                        packetWrapper.read(Types.STRING);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                    }
                });
                this.read(Types.BOOLEAN);
            }
        });
        this.cancelServerbound(ServerboundPackets1_19.CHAT_PREVIEW);
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UUID);
                this.map(Types.STRING);
                this.create(Types.PROFILE_PROPERTY_ARRAY, new GameProfile.Property[0]);
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    byte[] byArray = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    byte[] byArray2 = packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    packetWrapper.user().put(new NonceStorage1_19(CipherUtil.encryptNonce(byArray, byArray2)));
                });
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.HELLO, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.read(Types.OPTIONAL_PROFILE_KEY);
            }
        });
        this.registerServerbound(State.LOGIN, ServerboundLoginPackets.ENCRYPTION_KEY, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        packetWrapper.passthrough(Types.BYTE_ARRAY_PRIMITIVE);
                    } else {
                        NonceStorage1_19 nonceStorage1_19 = packetWrapper.user().remove(NonceStorage1_19.class);
                        if (nonceStorage1_19 == null) {
                            throw new IllegalArgumentException("Server sent nonce is missing");
                        }
                        packetWrapper.read(Types.LONG);
                        packetWrapper.read(Types.BYTE_ARRAY_PRIMITIVE);
                        packetWrapper.write(Types.BYTE_ARRAY_PRIMITIVE, nonceStorage1_19.nonce());
                    }
                });
            }
        });
    }

    private long randomLong() {
        return ThreadLocalRandom.current().nextLong();
    }

    public boolean isJsonNotNull(JsonElement jsonElement) {
        return jsonElement != null && !jsonElement.isJsonNull() && (!jsonElement.isJsonArray() || !jsonElement.getAsJsonArray().isEmpty());
    }

    public JsonElement mapTextComponentIfNull(UserConnection userConnection, JsonElement jsonElement) {
        if (this.isJsonNotNull(jsonElement)) {
            this.componentRewriter.processText(userConnection, jsonElement);
            return jsonElement;
        }
        return ComponentUtil.emptyJsonComponent();
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_19.initialize(this);
        ParticleType.Fillers.fill1_19(this, Types1_19.PARTICLE);
        this.tagRewriter.removeTag(RegistryType.ITEM, "minecraft:occludes_vibration_signals");
        this.tagRewriter.renameTag(RegistryType.ITEM, "minecraft:carpets", "minecraft:wool_carpets");
        this.tagRewriter.renameTag(RegistryType.BLOCK, "minecraft:carpets", "minecraft:wool_carpets");
        this.tagRewriter.renameTag(RegistryType.BLOCK, "minecraft:polar_bears_spawnable_on_in_frozen_ocean", "minecraft:polar_bears_spawnable_on_alternate");
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:chest_boats", "minecraft:dampens_vibrations", "minecraft:mangrove_logs", "minecraft:overworld_natural_logs");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:ancient_city_replaceable", "minecraft:convertable_to_mud", "minecraft:dampens_vibrations", "minecraft:frog_prefer_jump_to", "minecraft:frogs_spawnable_on", "minecraft:mangrove_logs", "minecraft:mangrove_logs_can_grow_through", "minecraft:mangrove_roots_can_grow_through", "minecraft:nether_carver_replaceables", "minecraft:overworld_carver_replaceables", "minecraft:overworld_natural_logs", "minecraft:sculk_replaceable", "minecraft:sculk_replaceable_world_gen", "minecraft:snaps_goat_horn");
        this.tagRewriter.addEmptyTag(RegistryType.ENTITY, "minecraft:frog_food");
        this.tagRewriter.addEmptyTags(RegistryType.GAME_EVENT, "minecraft:allay_can_listen", "minecraft:shrieker_can_listen", "minecraft:warden_can_listen");
        int[] nArray = new int[34];
        for (int i = 0; i < nArray.length; ++i) {
            nArray[i] = i + 1;
        }
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:no_item_required", nArray);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/globe", 35);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/creeper", 36);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/skull", 37);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/flower", 38);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/mojang", 39);
        this.tagRewriter.addTagRaw(RegistryType.BANNER_PATTERN, "minecraft:pattern_item/piglin", 40);
        super.onMappingDataLoaded();
    }

    @Override
    public void register(ViaProviders viaProviders) {
        viaProviders.register(AckSequenceProvider.class, new AckSequenceProvider());
    }

    @Override
    public void init(UserConnection userConnection) {
        if (!userConnection.has(DimensionRegistryStorage.class)) {
            userConnection.put(new DimensionRegistryStorage());
        }
        userConnection.put(new SequenceStorage());
        userConnection.put(new LoomStorage());
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19.PLAYER));
    }

    @Override
    public MappingData1_19 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_19 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_19 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_18> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_18> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_18> getTagRewriter() {
        return this.tagRewriter;
    }
}

