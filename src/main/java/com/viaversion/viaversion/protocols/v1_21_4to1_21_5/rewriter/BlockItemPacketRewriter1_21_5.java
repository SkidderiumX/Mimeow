/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_21_5;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentMatchers;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.AdventureModePredicate;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrim;
import com.viaversion.viaversion.api.minecraft.item.data.AttributeModifiers1_21;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.DyedColor;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.JukeboxPlayable;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.minecraft.item.data.TropicalFishPattern;
import com.viaversion.viaversion.api.minecraft.item.data.Unbreakable;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_19_4;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.Protocol1_21_4To1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.storage.ItemHashStorage1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.MathUtil;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_21_5
extends StructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_21_5, Protocol1_21_4To1_21_5> {
    public static final List<StructuredDataKey<?>> HIDE_ADDITIONAL_KEYS = List.of(StructuredDataKey.BANNER_PATTERNS, StructuredDataKey.BEES1_20_5, StructuredDataKey.BLOCK_ENTITY_DATA1_20_5, StructuredDataKey.BLOCK_STATE, StructuredDataKey.V1_21_5.bundleContents, StructuredDataKey.V1_21_5.chargedProjectiles, StructuredDataKey.V1_21_5.container, StructuredDataKey.CONTAINER_LOOT, StructuredDataKey.FIREWORK_EXPLOSION, StructuredDataKey.FIREWORKS, StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.MAP_ID, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.POT_DECORATIONS, StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.WRITTEN_BOOK_CONTENT);
    public static final List<StructuredDataKey<?>> NEW_DATA_TO_REMOVE = List.of(StructuredDataKey.TOOLTIP_DISPLAY, StructuredDataKey.POTION_DURATION_SCALE, StructuredDataKey.WEAPON, StructuredDataKey.VILLAGER_VARIANT, StructuredDataKey.WOLF_VARIANT, StructuredDataKey.WOLF_COLLAR, StructuredDataKey.FOX_VARIANT, StructuredDataKey.SALMON_SIZE, StructuredDataKey.PARROT_VARIANT, StructuredDataKey.TROPICAL_FISH_PATTERN, StructuredDataKey.TROPICAL_FISH_BASE_COLOR, StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, StructuredDataKey.MOOSHROOM_VARIANT, StructuredDataKey.RABBIT_VARIANT, StructuredDataKey.COW_VARIANT, StructuredDataKey.PIG_VARIANT, StructuredDataKey.CHICKEN_VARIANT1_21_5, StructuredDataKey.FROG_VARIANT, StructuredDataKey.HORSE_VARIANT, StructuredDataKey.PAINTING_VARIANT, StructuredDataKey.LLAMA_VARIANT, StructuredDataKey.AXOLOTL_VARIANT, StructuredDataKey.CAT_VARIANT, StructuredDataKey.CAT_COLLAR, StructuredDataKey.SHEEP_COLOR, StructuredDataKey.SHULKER_COLOR, StructuredDataKey.BLOCKS_ATTACKS1_21_5, StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5, StructuredDataKey.BREAK_SOUND, StructuredDataKey.WOLF_SOUND_VARIANT, StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5);
    private static final DataComponentMatchers EMPTY_DATA_MATCHERS = new DataComponentMatchers(new StructuredData[0], new DataComponentPredicate[0]);
    private static final Heightmap[] EMPTY_HEIGHTMAPS = new Heightmap[0];

    public BlockItemPacketRewriter1_21_5(Protocol1_21_4To1_21_5 protocol1_21_4To1_21_5) {
        super(protocol1_21_4To1_21_5);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_4To1_21_5)this.protocol).replaceClientbound(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Object e = ((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
            Mappings mappings = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData().getBlockStateMappings();
            ChunkType1_20_2 chunkType1_20_2 = new ChunkType1_20_2(e.currentWorldSectionHeight(), MathUtil.ceilLog2(mappings.size()), MathUtil.ceilLog2(e.biomesSent()));
            Chunk chunk = packetWrapper.read(chunkType1_20_2);
            ((Protocol1_21_4To1_21_5)this.protocol).getBlockRewriter().handleChunk(chunk);
            ChunkType1_21_5 chunkType1_21_5 = new ChunkType1_21_5(e.currentWorldSectionHeight(), MathUtil.ceilLog2(mappings.mappedSize()), MathUtil.ceilLog2(e.biomesSent()));
            ArrayList<Heightmap> arrayList = new ArrayList<Heightmap>();
            for (Map.Entry<String, Tag> entry : chunk.getHeightMap().entrySet()) {
                int n = this.heightmapType(entry.getKey());
                if (n == -1) {
                    ((Protocol1_21_4To1_21_5)this.protocol).getLogger().warning("Unknown heightmap type: " + entry.getKey());
                    continue;
                }
                Tag tag = entry.getValue();
                if (!(tag instanceof LongArrayTag)) continue;
                LongArrayTag longArrayTag = (LongArrayTag)tag;
                arrayList.add(new Heightmap(n, longArrayTag.getValue()));
            }
            Chunk1_21_5 chunk1_21_5 = new Chunk1_21_5(chunk.getX(), chunk.getZ(), chunk.getSections(), arrayList.toArray(EMPTY_HEIGHTMAPS), chunk.blockEntities());
            ((Protocol1_21_4To1_21_5)this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
            packetWrapper.write(chunkType1_21_5, chunk1_21_5);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).registerClientbound(ClientboundPackets1_21_2.CHUNKS_BIOMES, packetWrapper -> {
            Object e = ((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
            int n = MathUtil.ceilLog2(e.biomesSent());
            ChunkBiomesType1_19_4 chunkBiomesType1_19_4 = new ChunkBiomesType1_19_4(e.currentWorldSectionHeight(), n);
            ChunkBiomesType1_21_5 chunkBiomesType1_21_5 = new ChunkBiomesType1_21_5(e.currentWorldSectionHeight(), n);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                packetWrapper.passthrough(Types.CHUNK_POSITION);
                packetWrapper.passthroughAndMap(chunkBiomesType1_19_4, chunkBiomesType1_21_5);
            }
        });
        ((Protocol1_21_4To1_21_5)this.protocol).replaceServerbound(ServerboundPackets1_21_5.SET_CREATIVE_MODE_SLOT, packetWrapper -> {
            if (!((Protocol1_21_4To1_21_5)this.protocol).getEntityRewriter().tracker(packetWrapper.user()).canInstaBuild()) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.passthrough(Types.SHORT);
            Item item = this.handleItemToServer(packetWrapper.user(), packetWrapper.read(VersionedTypes.V1_21_5.lengthPrefixedItem()));
            packetWrapper.write(this.itemType(), item);
        });
        ((Protocol1_21_4To1_21_5)this.protocol).replaceServerbound(ServerboundPackets1_21_5.CONTAINER_CLICK, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                HashedItem hashedItem = packetWrapper.read(Types.HASHED_ITEM);
                packetWrapper.write(VersionedTypes.V1_21_5.item, this.handleItemToServer(packetWrapper.user(), this.convertHashedItemToStructuredItem(packetWrapper.user(), hashedItem)));
            }
            HashedItem hashedItem = packetWrapper.read(Types.HASHED_ITEM);
            packetWrapper.write(VersionedTypes.V1_21_5.item, this.handleItemToServer(packetWrapper.user(), this.convertHashedItemToStructuredItem(packetWrapper.user(), hashedItem)));
        });
        ((Protocol1_21_4To1_21_5)this.protocol).replaceClientbound(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS, packetWrapper -> {
            int n;
            int n2;
            int n3;
            packetWrapper.passthrough(Types.BOOLEAN);
            int n4 = packetWrapper.passthrough(Types.VAR_INT);
            for (n3 = 0; n3 < n4; ++n3) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    Tag tag = packetWrapper.passthrough(Types.TRUSTED_TAG);
                    Tag tag2 = packetWrapper.passthrough(Types.TRUSTED_TAG);
                    ComponentRewriter1_21_5 componentRewriter1_21_5 = ((Protocol1_21_4To1_21_5)this.protocol).getComponentRewriter();
                    if (componentRewriter1_21_5 != null) {
                        componentRewriter1_21_5.processTag(packetWrapper.user(), tag);
                        componentRewriter1_21_5.processTag(packetWrapper.user(), tag2);
                    }
                    this.passthroughClientboundItem(packetWrapper);
                    packetWrapper.passthrough(Types.VAR_INT);
                    int n5 = packetWrapper.passthrough(Types.INT);
                    if ((n5 & 1) != 0) {
                        this.convertClientAsset(packetWrapper);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                n2 = packetWrapper.passthrough(Types.VAR_INT);
                for (n = 0; n < n2; ++n) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
            packetWrapper.passthrough(Types.STRING_ARRAY);
            n3 = packetWrapper.passthrough(Types.VAR_INT);
            for (n2 = 0; n2 < n3; ++n2) {
                packetWrapper.passthrough(Types.STRING);
                n = packetWrapper.passthrough(Types.VAR_INT);
                for (int i = 0; i < n; ++i) {
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.passthrough(Types.OPTIONAL_LONG);
                }
            }
            packetWrapper.write(Types.BOOLEAN, true);
        });
    }

    private void convertClientAsset(PacketWrapper packetWrapper) {
        String string = packetWrapper.read(Types.STRING);
        String string2 = Key.namespace(string);
        String string3 = Key.stripNamespace(string);
        if (string3.startsWith("textures/") && string3.endsWith(".png")) {
            String string4 = string3.substring("textures/".length(), string3.length() - ".png".length());
            packetWrapper.write(Types.STRING, string2 + ":" + string4);
        } else {
            packetWrapper.write(Types.STRING, string2 + ":" + string3);
        }
    }

    private int heightmapType(String string) {
        return switch (string) {
            case "WORLD_SURFACE_WG" -> 0;
            case "WORLD_SURFACE" -> 1;
            case "OCEAN_FLOOR_WG" -> 2;
            case "OCEAN_FLOOR" -> 3;
            case "MOTION_BLOCKING" -> 4;
            case "MOTION_BLOCKING_NO_LEAVES" -> 5;
            default -> -1;
        };
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item.isEmpty()) {
            return item;
        }
        MappingData mappingData = ((Protocol1_21_4To1_21_5)this.protocol).getMappingData();
        if (mappingData != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getNewItemId(item.identifier()));
        }
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        this.updateItemDataComponentTypeIds(structuredDataContainer, true);
        this.handleRewritablesToClient(userConnection, structuredDataContainer, null);
        BlockItemPacketRewriter1_21_5.updateItemData(item);
        this.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        this.appendItemDataFixComponents(userConnection, item);
        ItemHashStorage1_21_5 itemHashStorage1_21_5 = (ItemHashStorage1_21_5)this.itemHasher(userConnection);
        if (itemHashStorage1_21_5.isProcessingClientboundInventoryPacket()) {
            for (StructuredData<?> structuredData : structuredDataContainer.data().values()) {
                itemHashStorage1_21_5.trackStructuredData(structuredData);
            }
        }
        return item;
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        BlockItemPacketRewriter1_21_5.downgradeItemData(item);
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
    }

    public static void updateItemData(Item item) {
        StructuredData<JukeboxPlayable> structuredData;
        StructuredData<Enchantments> structuredData2;
        StructuredData<Enchantments> structuredData3;
        StructuredData<ArmorTrim> structuredData4;
        StructuredData<AttributeModifiers1_21> structuredData5;
        StructuredData<DyedColor> structuredData6;
        Object object;
        Object object2;
        Object object3;
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.TOOL1_20_5, StructuredDataKey.TOOL1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.EQUIPPABLE1_21_5);
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.INSTRUMENT1_21_5, EitherHolder::of);
        IntLinkedOpenHashSet intLinkedOpenHashSet = new IntLinkedOpenHashSet(4);
        boolean bl = structuredDataContainer.hasValue(StructuredDataKey.HIDE_TOOLTIP);
        if (structuredDataContainer.hasValue(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP)) {
            object3 = Protocol1_21_4To1_21_5.MAPPINGS.getDataComponentSerializerMappings();
            object2 = HIDE_ADDITIONAL_KEYS.iterator();
            while (object2.hasNext()) {
                object = object2.next();
                intLinkedOpenHashSet.add(object3.mappedId(((StructuredDataKey)object).identifier()));
            }
        }
        if ((object3 = structuredDataContainer.getNonEmptyData(StructuredDataKey.UNBREAKABLE1_20_5)) != null && !((Unbreakable)object3.value()).showInTooltip()) {
            intLinkedOpenHashSet.add(object3.id());
        }
        if ((object2 = structuredDataContainer.getNonEmptyData(StructuredDataKey.CAN_PLACE_ON1_20_5)) != null && !((AdventureModePredicate)object2.value()).showInTooltip()) {
            intLinkedOpenHashSet.add(object2.id());
        }
        if ((object = structuredDataContainer.getNonEmptyData(StructuredDataKey.CAN_BREAK1_20_5)) != null && !((AdventureModePredicate)object.value()).showInTooltip()) {
            intLinkedOpenHashSet.add(object.id());
        }
        if ((structuredData6 = structuredDataContainer.getNonEmptyData(StructuredDataKey.DYED_COLOR1_20_5)) != null && !structuredData6.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData6.id());
        }
        if ((structuredData5 = structuredDataContainer.getNonEmptyData(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21)) != null && !structuredData5.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData5.id());
        }
        if ((structuredData4 = structuredDataContainer.getNonEmptyData(StructuredDataKey.TRIM1_21_4)) != null && !structuredData4.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData4.id());
        }
        if ((structuredData3 = structuredDataContainer.getNonEmptyData(StructuredDataKey.ENCHANTMENTS1_20_5)) != null && !structuredData3.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData3.id());
        }
        if ((structuredData2 = structuredDataContainer.getNonEmptyData(StructuredDataKey.STORED_ENCHANTMENTS1_20_5)) != null && !structuredData2.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData2.id());
        }
        if ((structuredData = structuredDataContainer.getNonEmptyData(StructuredDataKey.JUKEBOX_PLAYABLE1_21)) != null && !structuredData.value().showInTooltip()) {
            intLinkedOpenHashSet.add(structuredData.id());
        }
        if (!(!bl && intLinkedOpenHashSet.isEmpty() || structuredDataContainer.has(StructuredDataKey.TOOLTIP_DISPLAY))) {
            structuredDataContainer.set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(bl, intLinkedOpenHashSet));
        }
        BlockItemPacketRewriter1_21_5.updateBucketVariant(structuredDataContainer);
        structuredDataContainer.replace(StructuredDataKey.UNBREAKABLE1_20_5, StructuredDataKey.UNBREAKABLE1_21_5, unbreakable -> Unit.INSTANCE);
        structuredDataContainer.replace(StructuredDataKey.CAN_PLACE_ON1_20_5, StructuredDataKey.V1_21_5.canPlaceOn, BlockItemPacketRewriter1_21_5::updateAdventureModePredicate);
        structuredDataContainer.replace(StructuredDataKey.CAN_BREAK1_20_5, StructuredDataKey.V1_21_5.canBreak, BlockItemPacketRewriter1_21_5::updateAdventureModePredicate);
        structuredDataContainer.replaceKey(StructuredDataKey.JUKEBOX_PLAYABLE1_21, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.DYED_COLOR1_20_5, StructuredDataKey.DYED_COLOR1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.TRIM1_21_4, StructuredDataKey.TRIM1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.ENCHANTMENTS1_20_5, StructuredDataKey.ENCHANTMENTS1_21_5);
        structuredDataContainer.replaceKey(StructuredDataKey.STORED_ENCHANTMENTS1_20_5, StructuredDataKey.STORED_ENCHANTMENTS1_21_5);
        structuredDataContainer.remove(StructuredDataKey.HIDE_TOOLTIP);
        structuredDataContainer.remove(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP);
    }

    private static AdventureModePredicate updateAdventureModePredicate(AdventureModePredicate adventureModePredicate) {
        BlockPredicate[] blockPredicateArray = new BlockPredicate[adventureModePredicate.predicates().length];
        for (int i = 0; i < adventureModePredicate.predicates().length; ++i) {
            BlockPredicate blockPredicate = adventureModePredicate.predicates()[i];
            blockPredicateArray[i] = new BlockPredicate(blockPredicate.holderSet(), blockPredicate.propertyMatchers(), blockPredicate.tag(), EMPTY_DATA_MATCHERS);
        }
        return new AdventureModePredicate(blockPredicateArray);
    }

    private static void updateBucketVariant(StructuredDataContainer structuredDataContainer) {
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.BUCKET_ENTITY_DATA);
        if (compoundTag == null) {
            return;
        }
        IntTag intTag = (IntTag)compoundTag.removeUnchecked("BucketVariantTag");
        if (intTag == null) {
            return;
        }
        int n = intTag.asInt();
        structuredDataContainer.set(StructuredDataKey.TROPICAL_FISH_BASE_COLOR, n >> 16 & 0xFF);
        structuredDataContainer.set(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, n >> 24 & 0xFF);
        structuredDataContainer.set(StructuredDataKey.TROPICAL_FISH_PATTERN, new TropicalFishPattern(n & 0xFFFF));
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replaceKey(StructuredDataKey.TOOL1_21_5, StructuredDataKey.TOOL1_20_5);
        structuredDataContainer.replaceKey(StructuredDataKey.EQUIPPABLE1_21_5, StructuredDataKey.EQUIPPABLE1_21_2);
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT1_21_5, StructuredDataKey.INSTRUMENT1_21_2, eitherHolder -> eitherHolder.hasHolder() ? eitherHolder.holder() : null);
        TooltipDisplay tooltipDisplay = structuredDataContainer.get(StructuredDataKey.TOOLTIP_DISPLAY);
        if (tooltipDisplay != null) {
            if (tooltipDisplay.hideTooltip()) {
                structuredDataContainer.set(StructuredDataKey.HIDE_TOOLTIP);
            }
            FullMappings fullMappings = Protocol1_21_4To1_21_5.MAPPINGS.getDataComponentSerializerMappings();
            if (tooltipDisplay.hiddenComponents().containsAll(HIDE_ADDITIONAL_KEYS.stream().map(structuredDataKey -> fullMappings.id(structuredDataKey.identifier())).toList())) {
                structuredDataContainer.set(StructuredDataKey.HIDE_ADDITIONAL_TOOLTIP);
            }
        }
        BlockItemPacketRewriter1_21_5.downgradeBucketVariant(structuredDataContainer);
        structuredDataContainer.replace(StructuredDataKey.UNBREAKABLE1_21_5, StructuredDataKey.UNBREAKABLE1_20_5, unit -> new Unbreakable(BlockItemPacketRewriter1_21_5.shouldShowToServer(tooltipDisplay, StructuredDataKey.UNBREAKABLE1_20_5)));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.DYED_COLOR1_21_5, StructuredDataKey.DYED_COLOR1_20_5, dyedColor -> new DyedColor(dyedColor.rgb(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21_5, StructuredDataKey.ATTRIBUTE_MODIFIERS1_21, attributeModifiers1_21 -> new AttributeModifiers1_21(attributeModifiers1_21.modifiers(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.TRIM1_21_5, StructuredDataKey.TRIM1_21_4, armorTrim -> new ArmorTrim(armorTrim.material(), armorTrim.pattern(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.ENCHANTMENTS1_21_5, StructuredDataKey.ENCHANTMENTS1_20_5, enchantments -> new Enchantments(enchantments.enchantments(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.STORED_ENCHANTMENTS1_21_5, StructuredDataKey.STORED_ENCHANTMENTS1_20_5, enchantments -> new Enchantments(enchantments.enchantments(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.V1_21_5.canPlaceOn, StructuredDataKey.CAN_PLACE_ON1_20_5, adventureModePredicate -> new AdventureModePredicate(adventureModePredicate.predicates(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.V1_21_5.canBreak, StructuredDataKey.CAN_BREAK1_20_5, adventureModePredicate -> new AdventureModePredicate(adventureModePredicate.predicates(), false));
        BlockItemPacketRewriter1_21_5.updateShowInTooltip(structuredDataContainer, tooltipDisplay, StructuredDataKey.JUKEBOX_PLAYABLE1_21_5, StructuredDataKey.JUKEBOX_PLAYABLE1_21, jukeboxPlayable -> new JukeboxPlayable(jukeboxPlayable.song(), false));
        structuredDataContainer.remove(NEW_DATA_TO_REMOVE);
    }

    private static void downgradeBucketVariant(StructuredDataContainer structuredDataContainer) {
        TropicalFishPattern tropicalFishPattern = structuredDataContainer.get(StructuredDataKey.TROPICAL_FISH_PATTERN);
        if (tropicalFishPattern == null) {
            return;
        }
        Integer n = structuredDataContainer.get(StructuredDataKey.TROPICAL_FISH_BASE_COLOR);
        Integer n2 = structuredDataContainer.get(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR);
        int n3 = n != null ? n : 0xFFFFFF;
        int n4 = n2 != null ? n2 : 0xFFFFFF;
        int n5 = (n4 & 0xFF) << 24 | (n3 & 0xFF) << 16 | tropicalFishPattern.packedId() & 0xFFFF;
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.BUCKET_ENTITY_DATA);
        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            structuredDataContainer.set(StructuredDataKey.BUCKET_ENTITY_DATA, compoundTag);
        }
        compoundTag.put("BucketVariantTag", new IntTag(n5));
    }

    private StructuredItem convertHashedItemToStructuredItem(UserConnection userConnection, HashedItem hashedItem) {
        StructuredData<?> structuredData;
        StructuredItem structuredItem = new StructuredItem(hashedItem.identifier(), hashedItem.amount());
        ItemHashStorage1_21_5 itemHashStorage1_21_5 = (ItemHashStorage1_21_5)this.itemHasher(userConnection);
        Map<StructuredDataKey<?>, StructuredData<?>> map = structuredItem.dataContainer().data();
        for (Int2IntMap.Entry entry : hashedItem.dataHashesById().int2IntEntrySet()) {
            structuredData = itemHashStorage1_21_5.dataFromHash(entry.getIntKey(), entry.getIntValue());
            if (structuredData == null) continue;
            map.put(structuredData.key(), structuredData);
        }
        Iterator iterator2 = hashedItem.removedDataIds().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            structuredData = VersionedTypes.V1_21_5.structuredData.key(n);
            map.put((StructuredDataKey<?>)((Object)structuredData), StructuredData.empty(structuredData, n));
        }
        return structuredItem;
    }

    private void appendItemDataFixComponents(UserConnection userConnection, Item item) {
        ProtocolVersion protocolVersion = userConnection.getProtocolInfo().serverProtocolVersion();
        if (protocolVersion.olderThanOrEqualTo(ProtocolVersion.v1_8) && (item.identifier() == 858 || item.identifier() == 863 || item.identifier() == 873 || item.identifier() == 868 || item.identifier() == 878)) {
            item.dataContainer().remove(StructuredDataKey.CONSUMABLE1_21_2);
            item.dataContainer().set(StructuredDataKey.BLOCKS_ATTACKS1_21_5, new BlocksAttacks(0.0f, 0.0f, new BlocksAttacks.DamageReduction[]{new BlocksAttacks.DamageReduction(90.0f, null, -0.5f, 0.5f)}, new BlocksAttacks.ItemDamageFunction(0.0f, 0.0f, 0.0f), null, null, null));
        }
    }

    private static <T> void updateShowInTooltip(StructuredDataContainer structuredDataContainer, @Nullable TooltipDisplay tooltipDisplay, StructuredDataKey<T> structuredDataKey, StructuredDataKey<T> structuredDataKey2, Function<T, T> function) {
        if (BlockItemPacketRewriter1_21_5.shouldShowToServer(tooltipDisplay, structuredDataKey)) {
            structuredDataContainer.replaceKey(structuredDataKey, structuredDataKey2);
        } else {
            structuredDataContainer.replace(structuredDataKey, structuredDataKey2, function);
        }
    }

    private static boolean shouldShowToServer(@Nullable TooltipDisplay tooltipDisplay, StructuredDataKey<?> structuredDataKey) {
        if (tooltipDisplay == null) {
            return true;
        }
        int n = Protocol1_21_4To1_21_5.MAPPINGS.getDataComponentSerializerMappings().id(structuredDataKey.identifier());
        return !tooltipDisplay.hiddenComponents().contains(n);
    }
}

