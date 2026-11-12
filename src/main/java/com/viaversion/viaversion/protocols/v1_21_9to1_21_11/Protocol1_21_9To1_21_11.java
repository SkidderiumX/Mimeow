/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_9to1_21_11;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_5;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_9;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.data.MappingData1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter.BlockItemPacketRewriter1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter.ComponentRewriter1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.rewriter.EntityPacketRewriter1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.storage.GameTimeStorage;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_21_9To1_21_11
extends AbstractProtocol<ClientboundPacket1_21_9, ClientboundPacket1_21_11, ServerboundPacket1_21_9, ServerboundPacket1_21_9> {
    public static final MappingData1_21_11 MAPPINGS = new MappingData1_21_11();
    private static final Set<String> REMOVE_SKY_COLOR_FROM_BIOMES = Set.of("warped_forest", "basalt_deltas", "nether_wastes", "soul_sand_valley", "crimson_forest");
    private final EntityPacketRewriter1_21_11 entityRewriter = new EntityPacketRewriter1_21_11(this);
    private final BlockItemPacketRewriter1_21_11 itemRewriter = new BlockItemPacketRewriter1_21_11(this);
    private final BlockRewriter<ClientboundPacket1_21_9> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket1_21_9>(this, ChunkType1_21_5::new);
    private final ParticleRewriter<ClientboundPacket1_21_9> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_9>(this);
    private final TagRewriter<ClientboundPacket1_21_9> tagRewriter = new TagRewriter<ClientboundPacket1_21_9>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_9> componentRewriter = new ComponentRewriter1_21_11(this);
    private final RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_9> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_9>(this);

    public Protocol1_21_9To1_21_11() {
        super(ClientboundPacket1_21_9.class, ClientboundPacket1_21_11.class, ServerboundPacket1_21_9.class, ServerboundPacket1_21_9.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.appendClientbound(ClientboundConfigurationPackets1_21_9.FINISH_CONFIGURATION, packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_21_9.REGISTRY_DATA);
            packetWrapper2.write(Types.STRING, "zombie_nautilus_variant");
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putString("asset_id", "entity/zombie_nautilus/temperate");
            compoundTag.put("spawn_conditions", new ListTag<CompoundTag>(CompoundTag.class));
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{new RegistryEntry("minecraft:pale", compoundTag)});
            packetWrapper2.send(Protocol1_21_9To1_21_11.class);
            PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundConfigurationPackets1_21_9.REGISTRY_DATA);
            packetWrapper3.write(Types.STRING, "timeline");
            RegistryEntry[] registryEntryArray = new RegistryEntry[MAPPINGS.timelineRegistry().size()];
            int n = 0;
            for (Map.Entry<String, Tag> entry : MAPPINGS.timelineRegistry().entrySet()) {
                registryEntryArray[n++] = new RegistryEntry(entry.getKey(), entry.getValue());
            }
            packetWrapper3.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
            packetWrapper3.send(Protocol1_21_9To1_21_11.class);
        });
        this.registryDataRewriter.addHandler("dimension_type", (string, compoundTag) -> {
            CompoundTag compoundTag2;
            Tag tag2;
            ByteTag byteTag = new ByteTag((byte)1);
            CompoundTag compoundTag3 = new CompoundTag();
            compoundTag.put("attributes", compoundTag3);
            if (Key.equals(string, "the_nether")) {
                compoundTag.put("timelines", new ListTag<StringTag>(List.of(new StringTag("villager_schedule"))));
                compoundTag.putString("skybox", "none");
                compoundTag.putString("cardinal_light", "nether");
                compoundTag3.putString("visual/sky_light_color", "#7a7aff");
                compoundTag3.putFloat("visual/fog_start_distance", 10.0f);
                compoundTag3.putFloat("visual/fog_end_distance", 96.0f);
                compoundTag3.putFloat("gameplay/sky_light_level", 4.0f);
            } else if (Key.equals(string, "the_end")) {
                compoundTag.put("timelines", new ListTag<StringTag>(List.of(new StringTag("villager_schedule"))));
                compoundTag.putString("skybox", "end");
                compoundTag3.putString("visual/fog_color", "#181318");
                compoundTag3.putString("visual/sky_color", "#000000");
                compoundTag3.putString("visual/sky_light_color", "#ac60cd");
                this.addAmbientCaveSound(compoundTag3);
                tag2 = new CompoundTag();
                ((CompoundTag)tag2).put("default", this.backgroundMusicEntry("music.end", true, 6000));
                compoundTag3.put("audio/background_music", tag2);
            } else {
                tag2 = new ListTag<StringTag>(List.of(new StringTag("day"), new StringTag("moon"), new StringTag("early_game")));
                compoundTag.put("timelines", tag2);
                compoundTag3.putString("visual/fog_color", "#c0d8ff");
                compoundTag3.putString("visual/sky_color", "#78a7ff");
                this.addAmbientCaveSound(compoundTag3);
                compoundTag2 = new CompoundTag();
                compoundTag2.put("default", this.backgroundMusicEntry("music.game", false, 12000));
                compoundTag2.put("creative", this.backgroundMusicEntry("music.creative", false, 12000));
                compoundTag3.put("audio/background_music", compoundTag2);
            }
            tag2 = compoundTag.remove("fixed_time");
            if (tag2 != null) {
                compoundTag.putBoolean("has_fixed_time", true);
            }
            if (!compoundTag.getBoolean("natural")) {
                compoundTag3.putFloat("visual/sky_light_factor", 0.0f);
            }
            if (compoundTag.getBoolean("ultrawarm")) {
                compoundTag2 = new CompoundTag();
                compoundTag2.putString("type", "dripping_dripstone_lava");
                compoundTag3.put("visual/default_dripstone_particle", compoundTag2);
            }
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "cloud_height", "visual/cloud_height", tag -> {
                if (tag instanceof NumberTag) {
                    NumberTag numberTag = (NumberTag)tag;
                    compoundTag3.putString("visual/cloud_color", "#ccffffff");
                    return new FloatTag(numberTag.asFloat());
                }
                return null;
            }, null);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "has_raids", "gameplay/can_start_raid", Function.identity(), byteTag);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "piglin_safe", "gameplay/piglins_zombify", tag -> ((NumberTag)tag).asBoolean() ? ByteTag.ZERO : byteTag, ByteTag.ZERO);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "respawn_anchor_works", "gameplay/respawn_anchor_works", Function.identity(), byteTag);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "ultrawarm", "gameplay/fast_lava", Function.identity(), ByteTag.ZERO);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag3, "ultrawarm", "gameplay/water_evaporates", Function.identity(), ByteTag.ZERO);
        });
        this.registryDataRewriter.addHandler("worldgen/biome", (string, compoundTag) -> {
            CompoundTag compoundTag2;
            Tag tag;
            Tag tag2;
            Tag tag3;
            Tag tag4;
            CompoundTag compoundTag3;
            ListTag<CompoundTag> listTag;
            CompoundTag compoundTag4 = compoundTag.getCompoundTag("effects");
            CompoundTag compoundTag5 = new CompoundTag();
            compoundTag.put("attributes", compoundTag5);
            if (!REMOVE_SKY_COLOR_FROM_BIOMES.contains(Key.stripMinecraftNamespace(string))) {
                this.moveAttribute(compoundTag4, compoundTag5, "sky_color", "visual/sky_color", Function.identity(), new IntTag(0));
            }
            if (!Key.equals(string, "the_end")) {
                this.moveAttribute(compoundTag4, compoundTag5, "water_fog_color", "visual/water_fog_color", Function.identity(), new IntTag(-16448205));
                this.moveAttribute(compoundTag4, compoundTag5, "fog_color", "visual/fog_color", Function.identity(), new IntTag(0));
            }
            if ((listTag = compoundTag4.getListTag("music", CompoundTag.class)) != null && !listTag.isEmpty() && (compoundTag3 = listTag.get(0).getCompoundTag("data")) != null) {
                tag4 = new CompoundTag();
                tag3 = compoundTag3.get("max_delay");
                tag2 = compoundTag3.get("min_delay");
                tag = compoundTag3.get("sound");
                if (tag3 != null) {
                    ((CompoundTag)tag4).put("max_delay", tag3);
                }
                if (tag2 != null) {
                    ((CompoundTag)tag4).put("min_delay", tag2);
                }
                if (tag != null) {
                    ((CompoundTag)tag4).put("sound", tag);
                }
                compoundTag2 = new CompoundTag();
                compoundTag2.put("default", tag4);
                compoundTag5.put("audio/background_music", compoundTag2);
            }
            compoundTag3 = new CompoundTag();
            tag4 = compoundTag4.get("mood_sound");
            if (tag4 != null) {
                compoundTag3.put("mood", tag4);
            }
            if ((tag3 = compoundTag4.get("additions_sound")) != null) {
                compoundTag3.put("additions", tag3);
            }
            if ((tag2 = compoundTag4.get("ambient_sound")) != null) {
                compoundTag3.put("loop", tag2);
            }
            if (!compoundTag3.isEmpty()) {
                compoundTag5.put("audio/ambient_sounds", compoundTag3);
            }
            if ((tag = compoundTag4.getCompoundTag("particle")) != null) {
                compoundTag2 = new CompoundTag();
                compoundTag2.put("probability", ((CompoundTag)tag).get("probability"));
                compoundTag2.put("particle", ((CompoundTag)tag).get("options"));
                ListTag<CompoundTag> listTag2 = new ListTag<CompoundTag>(CompoundTag.class);
                listTag2.add(compoundTag2);
                compoundTag5.put("visual/ambient_particles", listTag2);
            }
        });
    }

    private void addAmbientCaveSound(CompoundTag compoundTag) {
        CompoundTag compoundTag2 = new CompoundTag();
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag3.putInt("tick_delay", 6000);
        compoundTag3.putFloat("offset", 2.0f);
        compoundTag3.putString("sound", "ambient.cave");
        compoundTag3.putInt("block_search_extent", 8);
        compoundTag2.put("mood", compoundTag3);
        compoundTag.put("audio/ambient_sounds", compoundTag2);
    }

    private CompoundTag backgroundMusicEntry(String string, boolean bl, int n) {
        CompoundTag compoundTag = new CompoundTag();
        if (bl) {
            compoundTag.putBoolean("replace_current_music", true);
        }
        compoundTag.putInt("max_delay", 24000);
        compoundTag.putString("sound", string);
        compoundTag.putInt("min_delay", n);
        return compoundTag;
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_21_11.initialize(this);
        ParticleType.Fillers.fill1_21_9(this);
        ((Types1_20_5)this.mappedTypes()).structuredData.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE, StructuredDataKey.UNBREAKABLE1_21_5, StructuredDataKey.RARITY, StructuredDataKey.TOOLTIP_DISPLAY, StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS1_21_5, StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, StructuredDataKey.BLOCKS_ATTACKS1_21_5, StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5, StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS1_21_5, StructuredDataKey.DYED_COLOR1_21_5, StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT, StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_5, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA1_21_9, StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA1_21_9, StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.PROFILE1_21_9, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES1_21_9, StructuredDataKey.LOCK1_21_2, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL1_21_5, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.ATTACK_RANGE, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE1_21_6, StructuredDataKey.ITEM_MODEL, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION, StructuredDataKey.WEAPON, StructuredDataKey.POTION_DURATION_SCALE, StructuredDataKey.VILLAGER_VARIANT, StructuredDataKey.WOLF_VARIANT, StructuredDataKey.WOLF_COLLAR, StructuredDataKey.FOX_VARIANT, StructuredDataKey.SALMON_SIZE, StructuredDataKey.PARROT_VARIANT, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.TROPICAL_FISH_BASE_COLOR, StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, StructuredDataKey.MOOSHROOM_VARIANT, StructuredDataKey.RABBIT_VARIANT, StructuredDataKey.PIG_VARIANT, StructuredDataKey.FROG_VARIANT, StructuredDataKey.HORSE_VARIANT, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.LLAMA_VARIANT, StructuredDataKey.AXOLOTL_VARIANT, StructuredDataKey.CAT_VARIANT, StructuredDataKey.CAT_COLLAR, StructuredDataKey.SHEEP_COLOR, StructuredDataKey.SHULKER_COLOR, StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5, StructuredDataKey.BREAK_SOUND, StructuredDataKey.COW_VARIANT, StructuredDataKey.CHICKEN_VARIANT1_21_5, StructuredDataKey.WOLF_SOUND_VARIANT, StructuredDataKey.USE_EFFECTS, StructuredDataKey.MINIMUM_ATTACK_CHARGE, StructuredDataKey.DAMAGE_TYPE1_21_11, StructuredDataKey.PIERCING_WEAPON, StructuredDataKey.KINETIC_WEAPON, StructuredDataKey.SWING_ANIMATION, StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT1_21_11);
        super.onMappingDataLoaded();
    }

    private void moveAttribute(CompoundTag compoundTag, CompoundTag compoundTag2, String string, String string2, Function<Tag, Tag> function, @Nullable Tag tag) {
        Tag tag2 = compoundTag.get(string);
        if (tag2 != null) {
            compoundTag2.put(string2, function.apply(tag2));
        } else if (tag != null) {
            compoundTag2.put(string2, tag);
        }
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_11.PLAYER));
        this.addItemHasher(userConnection);
        userConnection.put(new GameTimeStorage());
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_11 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_11 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_9> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_9> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public RegistryDataRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_9> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_9> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_9> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_5, EntityDataTypes1_21_9> types() {
        return VersionedTypes.V1_21_9;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_11, EntityDataTypes1_21_11> mappedTypes() {
        return VersionedTypes.V1_21_11;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_9, ClientboundPacket1_21_11, ServerboundPacket1_21_9, ServerboundPacket1_21_9> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_9, ClientboundPacket1_21_11, ServerboundPacket1_21_9, ServerboundPacket1_21_9>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_9.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_11.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class));
    }
}

