/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_11to1_21_9;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsRegistryRewriter;
import com.viaversion.viabackwards.api.rewriters.text.NBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter.BlockItemPacketRewriter1_21_11;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter.ComponentRewriter1_21_11;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.rewriter.EntityPacketRewriter1_21_11;
import com.viaversion.viabackwards.protocol.v1_21_11to1_21_9.storage.GameTimeStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_11;
import com.viaversion.viaversion.api.protocol.packet.provider.PacketTypesProvider;
import com.viaversion.viaversion.api.protocol.packet.provider.SimplePacketTypesProvider;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.RecipeDisplayRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundConfigurationPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ServerboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.Protocol1_21_9To1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPacket1_21_11;
import com.viaversion.viaversion.protocols.v1_21_9to1_21_11.packet.ClientboundPackets1_21_11;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.ProtocolUtil;
import com.viaversion.viaversion.util.TagUtil;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_21_11To1_21_9
extends BackwardsProtocol<ClientboundPacket1_21_11, ClientboundPacket1_21_9, ServerboundPacket1_21_9, ServerboundPacket1_21_9> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.21.11", "1.21.9", Protocol1_21_9To1_21_11.class);
    private static final int END_FOG_COLOR = 0xA080A0;
    private static final int OVERWORLD_FOG_COLOR = -4138753;
    private final EntityPacketRewriter1_21_11 entityRewriter = new EntityPacketRewriter1_21_11(this);
    private final BlockItemPacketRewriter1_21_11 itemRewriter = new BlockItemPacketRewriter1_21_11(this);
    private final ParticleRewriter<ClientboundPacket1_21_11> particleRewriter = new ParticleRewriter<ClientboundPacket1_21_11>(this);
    private final NBTComponentRewriter<ClientboundPacket1_21_11> translatableRewriter = new ComponentRewriter1_21_11(this);
    private final TagRewriter<ClientboundPacket1_21_11> tagRewriter = new TagRewriter<ClientboundPacket1_21_11>(this);
    private final RecipeDisplayRewriter<ClientboundPacket1_21_11> recipeRewriter = new RecipeDisplayRewriter1_21_5<ClientboundPacket1_21_11>(this);
    private final BlockRewriter<ClientboundPacket1_21_11> blockRewriter = BlockRewriter.for1_20_2(this, ChunkType1_21_5::new);
    private final BackwardsRegistryRewriter registryDataRewriter = new BackwardsRegistryRewriter(this){

        @Override
        protected void updateType(CompoundTag compoundTag, String string, FullMappings fullMappings) {
            Tag tag;
            super.updateType(compoundTag, string, fullMappings);
            if (string.equals("sound") && (tag = compoundTag.get(string)) instanceof ListTag) {
                ListTag listTag = (ListTag)tag;
                tag = listTag.isEmpty() ? new StringTag(fullMappings.mappedIdentifier(0)) : listTag.get(0);
                compoundTag.put(string, tag);
            }
        }
    };

    public Protocol1_21_11To1_21_9() {
        super(ClientboundPacket1_21_11.class, ClientboundPacket1_21_9.class, ServerboundPacket1_21_9.class, ServerboundPacket1_21_9.class);
    }

    private void moveAttribute(CompoundTag compoundTag, @Nullable CompoundTag compoundTag2, String string, String string2, Function<Tag, Tag> function, @Nullable Tag tag) {
        Tag tag2;
        if (compoundTag2 != null && (tag2 = TagUtil.getNamespacedTag(compoundTag2, string)) != null) {
            compoundTag.put(string2, function.apply(tag2));
        } else if (tag != null) {
            compoundTag.put(string2, tag);
        }
    }

    private int floatsToARGB(float f, float f2, float f3) {
        return 0xFF000000 | (int)(f * 255.0f) << 16 | (int)(f2 * 255.0f) << 8 | (int)(f3 * 255.0f);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registryDataRewriter.removeEnchantmentEffects("apply_exhaustion", "apply_impulse");
        this.registryDataRewriter.addHandler("dimension_type", (string, compoundTag) -> {
            if (Key.equals(string, "the_nether")) {
                compoundTag.putString("effects", "minecraft:the_nether");
                compoundTag.putBoolean("natural", false);
            } else if (Key.equals(string, "the_end")) {
                compoundTag.putString("effects", "minecraft:the_end");
                compoundTag.putBoolean("natural", false);
            } else {
                compoundTag.putString("effects", "minecraft:overworld");
                compoundTag.putBoolean("natural", true);
            }
            ByteTag byteTag = new ByteTag(1);
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("attributes");
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "visual/cloud_height", "cloud_height", Function.identity(), null);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "gameplay/can_start_raid", "has_raids", Function.identity(), byteTag);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "gameplay/piglins_zombify", "piglin_safe", tag -> ((NumberTag)tag).asBoolean() ? ByteTag.ZERO : byteTag, ByteTag.ZERO);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "gameplay/respawn_anchor_works", "respawn_anchor_works", Function.identity(), byteTag);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "gameplay/bed_rule", "bed_works", tag -> {
                Object compoundTag = (CompoundTag)tag;
                return compoundTag.getBoolean("can_sleep") || compoundTag.getBoolean("can_set_spawn") ? byteTag : ByteTag.ZERO;
            }, byteTag);
            this.moveAttribute((CompoundTag)compoundTag, compoundTag2, "gameplay/fast_lava", "ultrawarm", Function.identity(), ByteTag.ZERO);
        });
        this.registryDataRewriter.addHandler("worldgen/biome", (string, compoundTag) -> {
            CompoundTag compoundTag2;
            Tag tag;
            Tag tag2;
            Tag tag3;
            Tag tag4;
            CompoundTag compoundTag3;
            CompoundTag compoundTag4 = compoundTag.getCompoundTag("effects");
            this.moveAttribute(compoundTag4, compoundTag4, "water_color", "water_color", this::mapColor, new IntTag(4159204));
            this.moveAttribute(compoundTag4, compoundTag4, "foliage_color", "foliage_color", this::mapColor, null);
            this.moveAttribute(compoundTag4, compoundTag4, "dry_foliage_color", "dry_foliage_color", this::mapColor, null);
            this.moveAttribute(compoundTag4, compoundTag4, "grass_color", "grass_color", this::mapColor, null);
            CompoundTag compoundTag5 = (CompoundTag)compoundTag.removeUnchecked("attributes");
            this.moveAttribute(compoundTag4, compoundTag5, "visual/sky_color", "sky_color", this::mapColor, new IntTag(0));
            this.moveAttribute(compoundTag4, compoundTag5, "visual/water_fog_color", "water_fog_color", this::mapColor, new IntTag(-16448205));
            this.moveAttribute(compoundTag4, compoundTag5, "visual/fog_color", "fog_color", this::mapColor, new IntTag(Key.equals(string, "the_end") ? 0xA080A0 : -4138753));
            if (compoundTag5 == null) {
                return;
            }
            CompoundTag compoundTag6 = TagUtil.getNamespacedCompoundTag(compoundTag5, "audio/background_music");
            if (compoundTag6 != null && (compoundTag3 = compoundTag6.getCompoundTag("default")) != null) {
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
                if (!((CompoundTag)tag4).contains("replace_current_music")) {
                    ((CompoundTag)tag4).putBoolean("replace_current_music", false);
                }
                compoundTag2 = new CompoundTag();
                compoundTag2.put("data", tag4);
                compoundTag2.putInt("weight", 1);
                ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
                listTag.add(compoundTag2);
                compoundTag4.put("music", listTag);
            }
            if ((compoundTag3 = TagUtil.getNamespacedCompoundTag(compoundTag5, "audio/ambient_sounds")) != null) {
                tag4 = compoundTag3.get("loop");
                if (tag4 != null) {
                    compoundTag4.put("ambient_sound", tag4);
                }
                if ((tag3 = compoundTag3.get("mood")) != null) {
                    compoundTag4.put("mood_sound", tag3);
                }
                if ((tag2 = compoundTag3.get("additions")) != null) {
                    compoundTag4.put("additions_sound", tag2);
                }
            }
            if ((tag4 = TagUtil.getNamespacedCompoundTagList(compoundTag5, "visual/ambient_particles")) != null && !((ListTag)tag4).isEmpty()) {
                tag3 = (CompoundTag)((ListTag)tag4).get(0);
                tag2 = ((CompoundTag)tag3).get("probability");
                tag = ((CompoundTag)tag3).getCompoundTag("particle");
                compoundTag2 = new CompoundTag();
                compoundTag2.put("probability", tag2);
                compoundTag2.put("options", tag);
                compoundTag4.put("particle", compoundTag2);
            }
        });
        this.registryDataRewriter.addHandler("enchantment", (string, compoundTag) -> {
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("effects");
            if (compoundTag2 != null) {
                TagUtil.removeNamespaced(compoundTag2, "post_piercing_attack");
            }
        });
        this.registryDataRewriter.remove("zombie_nautilus_variant");
        this.registryDataRewriter.remove("timeline");
        this.tagRewriter.removeTags("timeline");
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_21_11.PLAYER));
        userConnection.addItemHasher(this.getClass(), new ItemHasherBase(this, userConnection));
        userConnection.put(new GameTimeStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_21_11 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_21_11 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPacket1_21_11> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public BackwardsRegistryRewriter getRegistryDataRewriter() {
        return this.registryDataRewriter;
    }

    @Override
    public RecipeDisplayRewriter<ClientboundPacket1_21_11> getRecipeRewriter() {
        return this.recipeRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPacket1_21_11> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public NBTComponentRewriter<ClientboundPacket1_21_11> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPacket1_21_11> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public VersionedTypesHolder types() {
        return VersionedTypes.V1_21_11;
    }

    @Override
    public VersionedTypesHolder mappedTypes() {
        return VersionedTypes.V1_21_9;
    }

    @Override
    protected PacketTypesProvider<ClientboundPacket1_21_11, ClientboundPacket1_21_9, ServerboundPacket1_21_9, ServerboundPacket1_21_9> createPacketTypesProvider() {
        return new SimplePacketTypesProvider<ClientboundPacket1_21_11, ClientboundPacket1_21_9, ServerboundPacket1_21_9, ServerboundPacket1_21_9>(ProtocolUtil.packetTypeMap(this.unmappedClientboundPacketType, ClientboundPackets1_21_11.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedClientboundPacketType, ClientboundPackets1_21_9.class, ClientboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.mappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class), ProtocolUtil.packetTypeMap(this.unmappedServerboundPacketType, ServerboundPackets1_21_6.class, ServerboundConfigurationPackets1_21_9.class));
    }

    private Tag mapColor(Tag tag) {
        if (tag instanceof ListTag) {
            ListTag listTag = (ListTag)tag;
            NumberTag numberTag = (NumberTag)listTag.get(0);
            NumberTag numberTag2 = (NumberTag)listTag.get(1);
            NumberTag numberTag3 = (NumberTag)listTag.get(2);
            return new IntTag(this.floatsToARGB(numberTag.asFloat(), numberTag2.asFloat(), numberTag3.asFloat()));
        }
        if (tag instanceof StringTag) {
            StringTag stringTag = (StringTag)tag;
            return new IntTag(Integer.parseInt(stringTag.getValue().substring(1), 16));
        }
        return tag;
    }
}

