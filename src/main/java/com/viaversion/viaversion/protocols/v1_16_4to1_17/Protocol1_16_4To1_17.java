/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_16_4to1_17;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.MappingDataBase;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_17;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter.ComponentRewriter1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter.EntityPacketRewriter1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter.ItemPacketRewriter1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.rewriter.WorldPacketRewriter1_17;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;

public class Protocol1_16_4To1_17
extends AbstractProtocol<ClientboundPackets1_16_2, ClientboundPackets1_17, ServerboundPackets1_16_2, ServerboundPackets1_17> {
    public static final MappingData MAPPINGS = new MappingDataBase("1.16.2", "1.17");
    private final EntityPacketRewriter1_17 entityRewriter = new EntityPacketRewriter1_17(this);
    private final ItemPacketRewriter1_17 itemRewriter = new ItemPacketRewriter1_17(this);
    private final ParticleRewriter<ClientboundPackets1_16_2> particleRewriter = new ParticleRewriter<ClientboundPackets1_16_2>(this);
    private final ComponentRewriter1_17 componentRewriter = new ComponentRewriter1_17(this);
    private final TagRewriter<ClientboundPackets1_16_2> tagRewriter = new TagRewriter<ClientboundPackets1_16_2>(this);
    private final BlockRewriter<ClientboundPackets1_16_2> blockRewriter = BlockRewriter.for1_14(this);

    public Protocol1_16_4To1_17() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_17.class, ServerboundPackets1_16_2.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        this.entityRewriter.register();
        this.itemRewriter.register();
        WorldPacketRewriter1_17.register(this);
        this.registerClientbound(ClientboundPackets1_16_2.UPDATE_TAGS, packetWrapper -> {
            packetWrapper.write(Types.VAR_INT, 5);
            for (RegistryType registryType : RegistryType.getValues()) {
                packetWrapper.write(Types.STRING, registryType.identifier());
                this.tagRewriter.handle(packetWrapper, registryType);
                if (registryType == RegistryType.ENTITY) break;
            }
            packetWrapper.write(Types.STRING, RegistryType.GAME_EVENT.identifier());
            this.tagRewriter.appendNewTags(packetWrapper, RegistryType.GAME_EVENT);
        });
        this.registerClientbound(ClientboundPackets1_16_2.RESOURCE_PACK, packetWrapper -> {
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.STRING);
            packetWrapper.write(Types.BOOLEAN, Via.getConfig().isForcedUse1_17ResourcePack());
            packetWrapper.write(Types.OPTIONAL_COMPONENT, Via.getConfig().get1_17ResourcePackPrompt());
        });
        this.registerClientbound(ClientboundPackets1_16_2.MAP_ITEM_DATA, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.read(Types.VAR_INT);
            if (n != 0) {
                packetWrapper.write(Types.BOOLEAN, true);
                packetWrapper.write(Types.VAR_INT, n);
            } else {
                packetWrapper.write(Types.BOOLEAN, false);
            }
        });
        this.registerClientbound(ClientboundPackets1_16_2.SET_TITLES, null, (PacketWrapper packetWrapper) -> {
            ClientboundPackets1_17 clientboundPackets1_17;
            int n = packetWrapper.read(Types.VAR_INT);
            switch (n) {
                case 0: {
                    clientboundPackets1_17 = ClientboundPackets1_17.SET_TITLE_TEXT;
                    break;
                }
                case 1: {
                    clientboundPackets1_17 = ClientboundPackets1_17.SET_SUBTITLE_TEXT;
                    break;
                }
                case 2: {
                    clientboundPackets1_17 = ClientboundPackets1_17.SET_ACTION_BAR_TEXT;
                    break;
                }
                case 3: {
                    clientboundPackets1_17 = ClientboundPackets1_17.SET_TITLES_ANIMATION;
                    break;
                }
                case 4: {
                    clientboundPackets1_17 = ClientboundPackets1_17.CLEAR_TITLES;
                    packetWrapper.write(Types.BOOLEAN, false);
                    break;
                }
                case 5: {
                    clientboundPackets1_17 = ClientboundPackets1_17.CLEAR_TITLES;
                    packetWrapper.write(Types.BOOLEAN, true);
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Invalid title type received: " + n);
                }
            }
            if (n < 3) {
                this.componentRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
            }
            packetWrapper.setPacketType(clientboundPackets1_17);
        });
        this.registerClientbound(ClientboundPackets1_16_2.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> packetWrapper.write(Types.VAR_INT, packetWrapper.read(Types.INT)));
            }
        });
        this.registerClientbound(ClientboundPackets1_16_2.SET_DEFAULT_SPAWN_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14);
                this.handler(packetWrapper -> packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f)));
            }
        });
        this.registerServerbound(ServerboundPackets1_17.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.read(Types.BOOLEAN);
            }
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_17.initialize(this);
        ParticleType.Fillers.fill1_17(this, Types1_17.PARTICLE);
        this.tagRewriter.addEmptyTags(RegistryType.ITEM, "minecraft:axolotl_tempt_items", "minecraft:candles", "minecraft:cluster_max_harvestables", "minecraft:copper_ores", "minecraft:freeze_immune_wearables", "minecraft:occludes_vibration_signals");
        this.tagRewriter.addEmptyTags(RegistryType.BLOCK, "minecraft:candle_cakes", "minecraft:candles", "minecraft:cave_vines", "minecraft:copper_ores", "minecraft:crystal_sound_blocks", "minecraft:deepslate_ore_replaceables", "minecraft:dripstone_replaceable_blocks", "minecraft:geode_invalid_blocks", "minecraft:lush_ground_replaceable", "minecraft:moss_replaceable", "minecraft:occludes_vibration_signals", "minecraft:small_dripleaf_placeable");
        this.tagRewriter.addEmptyTags(RegistryType.ENTITY, "minecraft:axolotl_always_hostiles", "minecraft:axolotl_hunt_targets", "minecraft:freeze_hurts_extra_types", "minecraft:freeze_immune_entity_types", "minecraft:powder_snow_walkable_mobs");
        this.tagRewriter.addEmptyTags(RegistryType.GAME_EVENT, "minecraft:ignore_vibrations_sneaking", "minecraft:vibrations");
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_17.PLAYER));
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_17 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_17 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_16_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_16_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public ComponentRewriter1_17 getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_16_2> getTagRewriter() {
        return this.tagRewriter;
    }
}

