/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_11to26_1;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.version.StructuredDataKeys1_21_11;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_11;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes26_1;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType26_1;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.data.MappingData26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ClientboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPacket26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.packet.ServerboundPackets26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.BlockItemPacketRewriter26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.ComponentRewriter26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.EntityPacketRewriter26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.rewriter.RegistryDataRewriter26_1;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.storage.PlayerSneaking;
import com.viaversion.viaversion.protocols.v1_21_11to26_1.storage.TagsSent;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.block.BlockRewriter1_21_5;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.ProtocolUtil;
import java.util.Map;

public class Protocol1_21_11To26_1
extends AbstractProtocol<ClientboundPacket1_21_11, ClientboundPacket26_1, ServerboundPacket1_21_9, ServerboundPacket26_1> {
    public static final MappingData26_1 MAPPINGS = new MappingData26_1();
    private final EntityPacketRewriter26_1 entityRewriter = new EntityPacketRewriter26_1(this);
    private final BlockItemPacketRewriter26_1 itemRewriter = new BlockItemPacketRewriter26_1(this);
    private final ParticleRewriter<ClientboundPacket1_21_11> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_11>(this);
    private final TagRewriter<ClientboundPacket1_21_11> tagRewriter = new TagRewriter<ClientboundPacket1_21_11>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_11> componentRewriter = new ComponentRewriter26_1(this);
    private final RegistryDataRewriter registryDataRewriter = new RegistryDataRewriter26_1(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_11> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_11>(this);
    private final BlockRewriter<ClientboundPacket1_21_11> blockRewriter = new BlockRewriter1_21_5<ClientboundPacket1_21_11>(this, ChunkType1_21_5::new, ChunkType26_1::new);

    public Protocol1_21_11To26_1() {
        super(ClientboundPacket1_21_11.class, ClientboundPacket26_1.class, ServerboundPacket1_21_9.class, ServerboundPacket26_1.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.appendClientbound(ClientboundConfigurationPackets1_21_9.FINISH_CONFIGURATION, packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_21_9.REGISTRY_DATA);
            packetWrapper2.write(Types.STRING, "world_clock");
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, new RegistryEntry[]{new RegistryEntry("minecraft:overworld", new CompoundTag()), new RegistryEntry("minecraft:the_end", new CompoundTag())});
            packetWrapper2.send(Protocol1_21_11To26_1.class);
            this.sendSoundVariants(packetWrapper, "cat_sound_variant", MAPPINGS.catSoundVariants());
            this.sendSoundVariants(packetWrapper, "cow_sound_variant", MAPPINGS.cowSoundVariants());
            this.sendSoundVariants(packetWrapper, "pig_sound_variant", MAPPINGS.pigSoundVariants());
            this.sendSoundVariants(packetWrapper, "chicken_sound_variant", MAPPINGS.chickenSoundVariants());
            if (!packetWrapper.user().has(TagsSent.class)) {
                PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundConfigurationPackets1_21_9.UPDATE_TAGS);
                packetWrapper3.write(Types.VAR_INT, 0);
                packetWrapper3.send(Protocol1_21_11To26_1.class, false);
            }
        });
        this.addRequiredRegistryEntries();
        this.registryDataRewriter.addHandler("timeline", (string, compoundTag) -> compoundTag.putString("clock", "overworld"));
        this.registryDataRewriter.addHandler("wolf_sound_variant", (string, compoundTag) -> {
            CompoundTag compoundTag2 = new CompoundTag();
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                compoundTag2.put(entry.getKey(), entry.getValue());
            }
            compoundTag.clear();
            compoundTag2.putString("step_sound", "entity.wolf.step");
            compoundTag.put("adult_sounds", compoundTag2);
            compoundTag.put("baby_sounds", compoundTag2.copy());
        });
        this.registryDataRewriter.addHandler("wolf_variant", (string, compoundTag) -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("assets");
            CompoundTag compoundTag3 = new CompoundTag();
            for (Map.Entry<String, Tag> entry : compoundTag2.entrySet()) {
                compoundTag3.putString(entry.getKey(), String.valueOf(entry.getValue().getValue()) + "_baby");
            }
            compoundTag.put("baby_assets", compoundTag3);
        });
        this.registryDataRewriter.addHandler("frog_variant", (string, compoundTag) -> this.swapEntityNameAffix("frog", (CompoundTag)compoundTag));
        this.swapAffixAndAddAssetId("chicken_variant", "chicken");
        this.swapAffixAndAddAssetId("cow_variant", "cow");
        this.swapAffixAndAddAssetId("pig_variant", "pig");
        this.registryDataRewriter.addHandler("cat_variant", (string, compoundTag) -> {
            this.addEntityNamePrefix("cat", (CompoundTag)compoundTag);
            this.addBabyAssetId((CompoundTag)compoundTag);
        });
        this.registryDataRewriter.addHandler("dimension_type", (string, compoundTag) -> {
            compoundTag.putBoolean("has_ender_dragon_fight", Key.equals(string, "the_end"));
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("attributes");
            if (compoundTag2 == null) {
                compoundTag2 = new CompoundTag();
                compoundTag.put("attributes", compoundTag2);
            }
            int n = switch (Key.stripMinecraftNamespace(string)) {
                case "the_end" -> -12630209;
                case "the_nether" -> -13621215;
                case "overworld" -> -16119286;
                default -> this.ambientLightColor(compoundTag.getFloat("ambient_light", 0.0f));
            };
            compoundTag2.putInt("visual/ambient_light_color", n);
        });
        this.registerClientbound(ClientboundPackets1_21_11.SET_TIME, packetWrapper -> {
            packetWrapper.passthrough(Types.LONG);
            long l = packetWrapper.read(Types.LONG);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            packetWrapper.write(Types.VAR_INT, 1);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.VAR_LONG, l);
            packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(bl ? 1.0f : 0.0f));
        });
        this.replaceClientbound(ClientboundPackets1_21_11.UPDATE_TAGS, this::handleTags);
        this.replaceClientbound(ClientboundConfigurationPackets1_21_9.UPDATE_TAGS, this::handleTags);
        this.cancelServerbound(ServerboundPackets26_1.SET_GAME_RULE);
        this.registerServerbound(ServerboundPackets26_1.CLIENT_COMMAND, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 2) {
                packetWrapper.cancel();
            }
        });
    }

    private void handleTags(PacketWrapper packetWrapper) {
        this.tagRewriter.handleGeneric(packetWrapper);
        packetWrapper.user().put(new TagsSent());
    }

    private void sendSoundVariants(PacketWrapper packetWrapper, String string, CompoundTag compoundTag) {
        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_21_9.REGISTRY_DATA);
        packetWrapper2.write(Types.STRING, string);
        packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, this.registryDataRewriter.entriesFromTag(compoundTag));
        packetWrapper2.send(Protocol1_21_11To26_1.class);
    }

    private void addRequiredRegistryEntries() {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putFloat("exhaustion", 0.1f);
        compoundTag.putString("message_id", "spear");
        compoundTag.putString("scaling", "when_caused_by_living_non_player");
        this.registryDataRewriter.addEntries("damage_type", new RegistryEntry("spear", compoundTag));
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putString("asset_id", "entity/chicken/chicken_temperate");
        compoundTag2.putString("baby_asset_id", "entity/chicken/chicken_temperate_baby");
        CompoundTag compoundTag3 = new CompoundTag();
        compoundTag3.putString("asset_id", "entity/chicken/chicken_cold");
        compoundTag3.putString("baby_asset_id", "entity/chicken/chicken_cold_baby");
        compoundTag3.putString("model", "cold");
        CompoundTag compoundTag4 = new CompoundTag();
        compoundTag4.putString("asset_id", "entity/chicken/chicken_warm");
        compoundTag4.putString("baby_asset_id", "entity/chicken/chicken_warm_baby");
        this.registryDataRewriter.addEntries("chicken_variant", new RegistryEntry("temperate", compoundTag2), new RegistryEntry("cold", compoundTag3), new RegistryEntry("warm", compoundTag4));
        CompoundTag compoundTag5 = new CompoundTag();
        CompoundTag compoundTag6 = new CompoundTag();
        compoundTag6.putString("translate", "instrument.minecraft.ponder_goat_horn");
        compoundTag5.put("description", compoundTag6);
        compoundTag5.putString("sound_event", "item.goat_horn.sound.0");
        compoundTag5.putFloat("use_duration", 7.0f);
        compoundTag5.putFloat("range", 256.0f);
        this.registryDataRewriter.addEntries("instrument", new RegistryEntry("ponder_goat_horn", compoundTag5));
        this.addJukeboxPlayables("11", "13", "5", "blocks", "cat", "chirp", "far", "mall", "mellohi", "otherside", "pigstep", "relic", "stal", "strad", "wait", "ward", "creator", "creator_music_box", "lava_chicken", "tears", "precipice");
        this.addTrimMaterials("quartz", "iron", "netherite", "redstone", "copper", "gold", "emerald", "diamond", "lapis", "amethyst", "resin");
    }

    private void addTrimMaterials(String ... stringArray) {
        for (String string : stringArray) {
            CompoundTag compoundTag = new CompoundTag();
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString("translate", "trim_material.minecraft." + string);
            compoundTag.put("description", compoundTag2);
            compoundTag.putString("asset_name", string);
            this.registryDataRewriter.addEntries("trim_material", new RegistryEntry(string, compoundTag));
        }
    }

    private void addJukeboxPlayables(String ... stringArray) {
        for (String string : stringArray) {
            this.registryDataRewriter.addEntries("jukebox_song", Protocol1_21_11To26_1.createJukeboxPlayableEntry(string));
        }
    }

    public static RegistryEntry createJukeboxPlayableEntry(String string) {
        CompoundTag compoundTag = new CompoundTag();
        CompoundTag compoundTag2 = new CompoundTag();
        compoundTag2.putString("translate", "jukebox_song.minecraft." + string);
        compoundTag.put("description", compoundTag2);
        compoundTag.putString("sound_event", "music_disc." + string);
        compoundTag.putFloat("length_in_seconds", 175.0f);
        compoundTag.putInt("comparator_output", 10);
        return new RegistryEntry(string, compoundTag);
    }

    private void swapAffixAndAddAssetId(String string, String string3) {
        this.registryDataRewriter.addHandler(string, (string2, compoundTag) -> {
            this.swapEntityNameAffix(string3, (CompoundTag)compoundTag);
            this.addBabyAssetId((CompoundTag)compoundTag);
        });
    }

    private void addBabyAssetId(CompoundTag compoundTag) {
        String string = compoundTag.getString("asset_id");
        compoundTag.putString("baby_asset_id", string + "_baby");
    }

    private void addEntityNamePrefix(String string, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("asset_id");
        String string2 = stringTag.getValue();
        stringTag.setValue(string2.replace(string + "/", string + "/" + string + "_"));
    }

    private int ambientLightColor(float f) {
        int n = MathUtil.clamp(Math.round(10.0f + f * 245.0f), 10, 255);
        return 0xFF000000 | n << 16 | n << 8 | n;
    }

    private void swapEntityNameAffix(String string, CompoundTag compoundTag) {
        StringTag stringTag = compoundTag.getStringTag("asset_id");
        String string2 = stringTag.getValue();
        if (string2.endsWith("_" + string)) {
            String string3 = string2.substring(0, string2.length() - string.length() - 1).replace(string + "/", string + "/" + string + "_");
            stringTag.setValue(string3);
        }
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_11.PLAYER));
        this.addItemHasher(userConnection);
        userConnection.put(new PlayerSneaking());
    }

    @Override
    protected void onMappingDataLoaded() {
        ParticleType.Fillers.fill1_21_9(this);
        ((Types1_20_5)this.mappedTypes()).structuredData.filler(this).add(StructuredDataKey.CUSTOM_DATA, StructuredDataKey.MAX_STACK_SIZE, StructuredDataKey.MAX_DAMAGE, StructuredDataKey.UNBREAKABLE1_21_5, StructuredDataKey.RARITY, StructuredDataKey.TOOLTIP_DISPLAY, StructuredDataKey.DAMAGE_RESISTANT26_1, StructuredDataKey.CUSTOM_NAME, StructuredDataKey.LORE, StructuredDataKey.ENCHANTMENTS1_21_5, StructuredDataKey.CUSTOM_MODEL_DATA1_21_4, StructuredDataKey.BLOCKS_ATTACKS26_1, StructuredDataKey.PROVIDES_BANNER_PATTERNS26_1, StructuredDataKey.REPAIR_COST, StructuredDataKey.CREATIVE_SLOT_LOCK, StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, StructuredDataKey.INTANGIBLE_PROJECTILE, StructuredDataKey.STORED_ENCHANTMENTS1_21_5, StructuredDataKey.DYED_COLOR1_21_5, StructuredDataKey.MAP_COLOR, StructuredDataKey.MAP_ID, StructuredDataKey.MAP_DECORATIONS, StructuredDataKey.MAP_POST_PROCESSING, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.SUSPICIOUS_STEW_EFFECTS, StructuredDataKey.WRITABLE_BOOK_CONTENT, StructuredDataKey.WRITTEN_BOOK_CONTENT, StructuredDataKey.TRIM1_21_5, StructuredDataKey.DEBUG_STICK_STATE, StructuredDataKey.ENTITY_DATA1_21_9, StructuredDataKey.BUCKET_ENTITY_DATA, StructuredDataKey.BLOCK_ENTITY_DATA1_21_9, StructuredDataKey.INSTRUMENT26_1, StructuredDataKey.RECIPES, StructuredDataKey.LODESTONE_TRACKER, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.PROFILE1_21_9, StructuredDataKey.NOTE_BLOCK_SOUND, StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BASE_COLOR, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.BLOCK_STATE, StructuredDataKey.BEES1_21_9, StructuredDataKey.LOCK1_21_2, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.TOOL1_21_5, StructuredDataKey.ITEM_NAME, StructuredDataKey.OMINOUS_BOTTLE_AMPLIFIER, StructuredDataKey.FOOD1_21_2, StructuredDataKey.JUKEBOX_PLAYABLE26_1, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_6, StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.ATTACK_RANGE, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.DAMAGE, StructuredDataKey.EQUIPPABLE1_21_6, StructuredDataKey.ITEM_MODEL, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION, StructuredDataKey.WEAPON, StructuredDataKey.POTION_DURATION_SCALE, StructuredDataKey.VILLAGER_VARIANT, StructuredDataKey.WOLF_VARIANT, StructuredDataKey.WOLF_COLLAR, StructuredDataKey.FOX_VARIANT, StructuredDataKey.SALMON_SIZE, StructuredDataKey.PARROT_VARIANT, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.TROPICAL_FISH_BASE_COLOR, StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, StructuredDataKey.MOOSHROOM_VARIANT, StructuredDataKey.RABBIT_VARIANT, StructuredDataKey.PIG_VARIANT, StructuredDataKey.FROG_VARIANT, StructuredDataKey.HORSE_VARIANT, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.LLAMA_VARIANT, StructuredDataKey.AXOLOTL_VARIANT, StructuredDataKey.CAT_VARIANT, StructuredDataKey.CAT_COLLAR, StructuredDataKey.SHEEP_COLOR, StructuredDataKey.SHULKER_COLOR, StructuredDataKey.PROVIDES_TRIM_MATERIAL26_1, StructuredDataKey.BREAK_SOUND, StructuredDataKey.COW_VARIANT, StructuredDataKey.CHICKEN_VARIANT26_1, StructuredDataKey.WOLF_SOUND_VARIANT, StructuredDataKey.USE_EFFECTS, StructuredDataKey.MINIMUM_ATTACK_CHARGE, StructuredDataKey.DAMAGE_TYPE26_1, StructuredDataKey.PIERCING_WEAPON, StructuredDataKey.KINETIC_WEAPON, StructuredDataKey.SWING_ANIMATION, StructuredDataKey.ZOMBIE_NAUTILUS_VARIANT26_1, StructuredDataKey.ADDITIONAL_TRADE_COST, StructuredDataKey.DYE, StructuredDataKey.PIG_SOUND_VARIANT, StructuredDataKey.COW_SOUND_VARIANT, StructuredDataKey.CHICKEN_SOUND_VARIANT, StructuredDataKey.CAT_SOUND_VARIANT);
        this.tagRewriter.addEmptyTags(RegistryType.DAMAGE_TYPE, "damages_helmet", "bypasses_armor", "bypasses_shield", "bypasses_invulnerability", "bypasses_cooldown", "bypasses_effects", "bypasses_resistance", "bypasses_enchantments", "is_fire", "is_projectile", "witch_resistant_to", "is_explosion", "is_fall", "is_drowning", "is_freezing", "is_lightning", "no_anger", "no_impact", "always_most_significant_fall", "wither_immune_to", "ignites_armor_stands", "burns_armor_stands", "avoids_guardian_thorns", "always_triggers_silverfish", "always_hurts_ender_dragons", "no_knockback", "always_kills_armor_stands", "can_break_armor_stand", "bypasses_wolf_armor", "is_player_attack", "burn_from_stepping", "panic_causes", "panic_environmental_causes", "mace_smash");
        this.tagRewriter.addEmptyTags(RegistryType.BANNER_PATTERN, "no_item_required", "pattern_item/flower", "pattern_item/creeper", "pattern_item/skull", "pattern_item/mojang", "pattern_item/globe", "pattern_item/piglin", "pattern_item/flow", "pattern_item/guster", "pattern_item/field_masoned", "pattern_item/bordure_indented");
        super.onMappingDataLoaded();
    }

    @Override
    public MappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter26_1 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter26_1 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_11> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_11> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public RegistryDataRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_11> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_11> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_11> getComponentRewriter() {
        return this.componentRewriter;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_11, EntityDataTypes1_21_11> types() {
        return VersionedTypes.V1_21_11;
    }

    @Override
    public Types1_20_5<StructuredDataKeys1_21_11, EntityDataTypes26_1> mappedTypes() {
        return VersionedTypes.V26_1;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_11, ClientboundPacket26_1, ServerboundPacket1_21_9, ServerboundPacket26_1> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_11, ClientboundPacket26_1, ServerboundPacket1_21_9, ServerboundPacket26_1>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_11.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets26_1.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets26_1.class, ServerboundConfigurationPackets1_21_9.class));
    }
}

