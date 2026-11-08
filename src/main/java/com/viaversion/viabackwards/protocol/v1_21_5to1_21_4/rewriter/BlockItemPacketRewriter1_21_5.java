/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.FloatTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.LongArrayTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.BackwardsStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.Protocol1_21_5To1_21_4;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.rewriter.ComponentRewriter1_21_5;
import com.viaversion.viabackwards.protocol.v1_21_5to1_21_4.storage.HorseDataStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.PaintingVariant;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk1_18;
import com.viaversion.viaversion.api.minecraft.chunks.Heightmap;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.BlocksAttacks;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.minecraft.item.data.ProvidesTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ToolProperties;
import com.viaversion.viaversion.api.minecraft.item.data.TooltipDisplay;
import com.viaversion.viaversion.api.minecraft.item.data.TropicalFishPattern;
import com.viaversion.viaversion.api.minecraft.item.data.Weapon;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_19_4;
import com.viaversion.viaversion.api.type.types.chunk.ChunkBiomesType1_21_5;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_20_2;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_21_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.data.item.OriginalHashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.fastutil.ints.IntLinkedOpenHashSet;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPacket1_21_4;
import com.viaversion.viaversion.protocols.v1_21_2to1_21_4.packet.ServerboundPackets1_21_4;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPacket1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.util.Either;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.MathUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockItemPacketRewriter1_21_5
extends BackwardsStructuredItemRewriter<ClientboundPacket1_21_5, ServerboundPacket1_21_4, Protocol1_21_5To1_21_4> {
    private static final int SADDLE_EQUIPMENT_SLOT = 7;
    static final byte SADDLED_FLAG = 4;

    public BlockItemPacketRewriter1_21_5(Protocol1_21_5To1_21_4 protocol1_21_5To1_21_4) {
        super(protocol1_21_5To1_21_4);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_5To1_21_4)this.protocol).replaceClientbound(ClientboundPackets1_21_5.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Object e = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
            Mappings mappings = ((Protocol1_21_5To1_21_4)this.protocol).getMappingData().getBlockStateMappings();
            ChunkType1_21_5 chunkType1_21_5 = new ChunkType1_21_5(e.currentWorldSectionHeight(), MathUtil.ceilLog2(mappings.size()), MathUtil.ceilLog2(e.biomesSent()));
            Chunk chunk = packetWrapper.read(chunkType1_21_5);
            ((Protocol1_21_5To1_21_4)this.protocol).getBlockRewriter().handleChunk(chunk);
            ((Protocol1_21_5To1_21_4)this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
            ChunkType1_20_2 chunkType1_20_2 = new ChunkType1_20_2(e.currentWorldSectionHeight(), MathUtil.ceilLog2(mappings.mappedSize()), MathUtil.ceilLog2(e.biomesSent()));
            CompoundTag compoundTag = new CompoundTag();
            for (Heightmap heightmap : chunk.heightmaps()) {
                String string = this.heightmapType(heightmap.type());
                if (string == null) {
                    ((Protocol1_21_5To1_21_4)this.protocol).getLogger().warning("Unknown heightmap type id: " + heightmap.type());
                    continue;
                }
                compoundTag.put(string, new LongArrayTag(heightmap.data()));
            }
            Chunk1_18 chunk1_18 = new Chunk1_18(chunk.getX(), chunk.getZ(), chunk.getSections(), compoundTag, chunk.blockEntities());
            packetWrapper.write(chunkType1_20_2, chunk1_18);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).registerClientbound(ClientboundPackets1_21_5.CHUNKS_BIOMES, packetWrapper -> {
            Object e = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(packetWrapper.user());
            int n = MathUtil.ceilLog2(e.biomesSent());
            ChunkBiomesType1_21_5 chunkBiomesType1_21_5 = new ChunkBiomesType1_21_5(e.currentWorldSectionHeight(), n);
            ChunkBiomesType1_19_4 chunkBiomesType1_19_4 = new ChunkBiomesType1_19_4(e.currentWorldSectionHeight(), n);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n2; ++i) {
                packetWrapper.passthrough(Types.CHUNK_POSITION);
                packetWrapper.passthroughAndMap(chunkBiomesType1_21_5, chunkBiomesType1_19_4);
            }
        });
        ((Protocol1_21_5To1_21_4)this.protocol).replaceServerbound(ServerboundPackets1_21_4.SET_CREATIVE_MODE_SLOT, packetWrapper -> {
            packetWrapper.passthrough(Types.SHORT);
            Item item = this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType()));
            packetWrapper.write(VersionedTypes.V1_21_5.lengthPrefixedItem(), item);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).replaceServerbound(ServerboundPackets1_21_4.CONTAINER_CLICK, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                this.itemToHashedItem(packetWrapper);
            }
            this.itemToHashedItem(packetWrapper);
        });
        ((Protocol1_21_5To1_21_4)this.protocol).replaceClientbound(ClientboundPackets1_21_5.SET_EQUIPMENT, packetWrapper -> {
            int n;
            byte by;
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            TrackedEntity trackedEntity = ((Protocol1_21_5To1_21_4)this.protocol).getEntityRewriter().tracker(packetWrapper.user()).entity(n2);
            IntArrayList intArrayList = new IntArrayList();
            ArrayList<Item> arrayList = new ArrayList<Item>();
            do {
                by = packetWrapper.read(Types.BYTE);
                n = by & 0x7F;
                Item item = packetWrapper.read(this.itemType());
                if (n == 7) {
                    if (trackedEntity == null || !trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.ABSTRACT_HORSE) && !trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.PIG) && !trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.STRIDER)) continue;
                    this.sendSaddledEntityData(packetWrapper.user(), trackedEntity, n2, item.identifier() == 800);
                    continue;
                }
                intArrayList.add(n);
                arrayList.add(this.handleItemToClient(packetWrapper.user(), item));
            } while (by < 0);
            if (intArrayList.isEmpty()) {
                packetWrapper.cancel();
                return;
            }
            for (n = 0; n < intArrayList.size(); ++n) {
                int n3 = intArrayList.getInt(n);
                boolean bl = n < intArrayList.size() - 1;
                packetWrapper.write(Types.BYTE, (byte)(bl ? n3 | 0xFFFFFF80 : n3));
                packetWrapper.write(this.mappedItemType(), (Item)arrayList.get(n));
            }
        });
        ((Protocol1_21_5To1_21_4)this.protocol).replaceClientbound(ClientboundPackets1_21_5.UPDATE_ADVANCEMENTS, packetWrapper -> {
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
                    ComponentRewriter1_21_5 componentRewriter1_21_5 = ((Protocol1_21_5To1_21_4)this.protocol).getComponentRewriter();
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
            packetWrapper.read(Types.BOOLEAN);
        });
    }

    @Override
    protected void storeOriginalHashedItemIfNeeded(UserConnection userConnection, Item item, ItemHasherBase itemHasherBase, HashedItem hashedItem) {
        if (hashedItem == null) {
            return;
        }
        if (hashedItem instanceof OriginalHashedItem) {
            OriginalHashedItem originalHashedItem = (OriginalHashedItem)hashedItem;
            itemHasherBase.trackOriginalHashedItem(item.dataContainer().get(StructuredDataKey.CUSTOM_DATA), hashedItem, originalHashedItem.backupTagName());
            return;
        }
        this.storeOriginalHashedItemInTag(userConnection, item, itemHasherBase, hashedItem);
    }

    @Override
    protected boolean isFirstServerbound(UserConnection userConnection) {
        return true;
    }

    private void itemToHashedItem(PacketWrapper packetWrapper) {
        Item item = packetWrapper.read(this.mappedItemType());
        if (Item.isEmpty(item)) {
            packetWrapper.write(Types.HASHED_ITEM, HashedStructuredItem.empty());
            return;
        }
        HashedItem hashedItem = this.originalHashedItemFromBackup(item);
        if (hashedItem != null) {
            packetWrapper.write(Types.HASHED_ITEM, hashedItem);
        } else {
            item.dataContainer().data().clear();
            Item item2 = this.handleItemToServer(packetWrapper.user(), item);
            packetWrapper.write(Types.HASHED_ITEM, new HashedStructuredItem(item2.identifier(), item2.amount()));
        }
    }

    private @Nullable HashedItem originalHashedItemFromBackup(Item item) {
        CompoundTag compoundTag;
        CompoundTag compoundTag2 = item.dataContainer().get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag2 == null || (compoundTag = compoundTag2.getCompoundTag("VV|original_hashes")) == null) {
            return null;
        }
        OriginalHashedItem originalHashedItem = this.backedUpOriginalHashes(compoundTag, item);
        return originalHashedItem.backupTagName().equals(this.nbtTagName()) ? originalHashedItem.asRegularItem() : originalHashedItem;
    }

    private void convertClientAsset(PacketWrapper packetWrapper) {
        String string = packetWrapper.read(Types.STRING);
        String string2 = Key.namespace(string);
        String string3 = Key.stripNamespace(string);
        packetWrapper.write(Types.STRING, string2 + ":textures/" + string3 + ".png");
    }

    private void sendSaddledEntityData(UserConnection userConnection, TrackedEntity trackedEntity, int n, boolean bl) {
        Object object;
        EntityData entityData = null;
        if (trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.ABSTRACT_HORSE)) {
            byte by = 0;
            object = trackedEntity.get(HorseDataStorage.class);
            if (object != null) {
                if (((HorseDataStorage)object).saddled() == bl) {
                    return;
                }
                by = ((HorseDataStorage)object).data();
            }
            trackedEntity.put(new HorseDataStorage(by, bl));
            if (bl) {
                by = (byte)(by | 4);
            }
            entityData = new EntityData(17, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).byteType, by);
        } else if (trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.PIG)) {
            entityData = new EntityData(17, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).booleanType, bl);
        } else if (trackedEntity.entityType().isOrHasParent(EntityTypes1_21_5.STRIDER)) {
            entityData = new EntityData(19, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_4.entityDataTypes).booleanType, bl);
        }
        if (entityData != null) {
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA, userConnection);
            object = new ArrayList();
            object.add(entityData);
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.write(VersionedTypes.V1_21_4.entityDataList, object);
            packetWrapper.send(Protocol1_21_5To1_21_4.class);
        }
    }

    private String heightmapType(int n) {
        return switch (n) {
            case 0 -> "WORLD_SURFACE_WG";
            case 1 -> "WORLD_SURFACE";
            case 2 -> "OCEAN_FLOOR_WG";
            case 3 -> "OCEAN_FLOOR";
            case 4 -> "MOTION_BLOCKING";
            case 5 -> "MOTION_BLOCKING_NO_LEAVES";
            default -> null;
        };
    }

    @Override
    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Weapon weapon;
        Equippable equippable;
        super.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag2);
        ToolProperties toolProperties = structuredDataContainer.get(StructuredDataKey.TOOL1_21_5);
        if (toolProperties != null && toolProperties.canDestroyBlocksInCreative()) {
            compoundTag2.putBoolean("tool", true);
        }
        if ((equippable = structuredDataContainer.get(StructuredDataKey.EQUIPPABLE1_21_5)) != null && equippable.equipOnInteract()) {
            compoundTag2.putBoolean("equippable", true);
        }
        if ((weapon = structuredDataContainer.get(StructuredDataKey.WEAPON)) != null) {
            object5 = new CompoundTag();
            compoundTag2.put("weapon", (Tag)object5);
            ((CompoundTag)object5).putInt("item_damage_per_attack", weapon.itemDamagePerAttack());
            ((CompoundTag)object5).putFloat("disable_blocking_for_seconds", weapon.disableBlockingForSeconds());
        }
        if ((object5 = structuredDataContainer.get(StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5)) != null) {
            object4 = this.eitherHolderToTag(((ProvidesTrimMaterial)object5).material(), (armorTrimMaterial, compoundTag) -> {
                compoundTag.putString("asset_name", armorTrimMaterial.assetName());
                compoundTag.putInt("item_id", armorTrimMaterial.itemId());
                compoundTag.putFloat("item_model_index", armorTrimMaterial.itemModelIndex());
                CompoundTag compoundTag2 = new CompoundTag();
                armorTrimMaterial.overrideArmorMaterials().forEach(compoundTag2::putString);
                compoundTag.put("override_armor_materials", compoundTag2);
                compoundTag.put("description", armorTrimMaterial.description());
            });
            compoundTag2.put("provides_trim_material", (Tag)object4);
        }
        if ((object4 = structuredDataContainer.get(StructuredDataKey.BLOCKS_ATTACKS1_21_5)) != null) {
            object3 = new CompoundTag();
            compoundTag2.put("blocks_attack", (Tag)object3);
            ((CompoundTag)object3).putFloat("block_delay_seconds", ((BlocksAttacks)object4).blockDelaySeconds());
            ((CompoundTag)object3).putFloat("disable_cooldown_scale", ((BlocksAttacks)object4).disableCooldownScale());
            object2 = new ListTag<CompoundTag>(CompoundTag.class);
            ((CompoundTag)object3).put("damage_reductions", (Tag)object2);
            for (BlocksAttacks.DamageReduction damageReduction : ((BlocksAttacks)object4).damageReductions()) {
                CompoundTag compoundTag3 = new CompoundTag();
                compoundTag3.putFloat("horizontal_blocking_angle", damageReduction.horizontalBlockingAngle());
                if (damageReduction.type() != null) {
                    compoundTag3.put("type", this.holderSetToTag(damageReduction.type()));
                }
                compoundTag3.putFloat("base", damageReduction.base());
                compoundTag3.putFloat("factor", damageReduction.factor());
                ((ListTag)object2).add(compoundTag3);
            }
            object = new CompoundTag();
            ((CompoundTag)object3).put("item_damage", (Tag)object);
            ((CompoundTag)object).putFloat("threshold", ((BlocksAttacks)object4).itemDamage().threshold());
            ((CompoundTag)object).putFloat("base", ((BlocksAttacks)object4).itemDamage().base());
            ((CompoundTag)object).putFloat("factor", ((BlocksAttacks)object4).itemDamage().factor());
            if (((BlocksAttacks)object4).bypassedBy() != null) {
                ((CompoundTag)object).putString("bypassed_by", ((BlocksAttacks)object4).bypassedBy().tagKey());
            }
            if (((BlocksAttacks)object4).blockSound() != null) {
                ((CompoundTag)object3).put("block_sound", this.holderToTag(((BlocksAttacks)object4).blockSound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
            if (((BlocksAttacks)object4).disableSound() != null) {
                ((CompoundTag)object3).put("disable_sound", this.holderToTag(((BlocksAttacks)object4).disableSound(), (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag)));
            }
        }
        if ((object3 = structuredDataContainer.get(StructuredDataKey.TOOLTIP_DISPLAY)) != null) {
            compoundTag2.put("hidden_components", new IntArrayTag(((TooltipDisplay)object3).hiddenComponents().toIntArray()));
        }
        if ((object2 = structuredDataContainer.get(StructuredDataKey.TROPICAL_FISH_PATTERN)) != null) {
            compoundTag2.putInt("tropical_fish_pattern", ((TropicalFishPattern)object2).packedId());
        }
        this.saveKeyData(StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5, structuredDataContainer, compoundTag2);
        this.saveFloatData(StructuredDataKey.POTION_DURATION_SCALE, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.VILLAGER_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.FOX_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.SALMON_SIZE, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.PARROT_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.TROPICAL_FISH_BASE_COLOR, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.MOOSHROOM_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.RABBIT_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.FROG_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.HORSE_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.LLAMA_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.AXOLOTL_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.CAT_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.CAT_COLLAR, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.SHEEP_COLOR, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.SHULKER_COLOR, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.WOLF_SOUND_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.COW_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.PIG_VARIANT, structuredDataContainer, compoundTag2);
        this.saveIntData(StructuredDataKey.WOLF_VARIANT, structuredDataContainer, compoundTag2);
        object = structuredDataContainer.get(StructuredDataKey.CHICKEN_VARIANT1_21_5);
        if (object != null) {
            if (object.isLeft()) {
                compoundTag2.putInt("chicken_variant", (Integer)object.left());
            } else {
                compoundTag2.putString("chicken_variant", (String)object.right());
            }
        }
        this.saveHolderData(StructuredDataKey.PAINTING_VARIANT, structuredDataContainer, compoundTag2, (paintingVariant, compoundTag) -> {
            compoundTag.putInt("width", paintingVariant.width());
            compoundTag.putInt("height", paintingVariant.height());
            compoundTag.putString("asset_id", paintingVariant.assetId());
            if (paintingVariant.title() != null) {
                compoundTag.put("title", paintingVariant.title());
            }
            if (paintingVariant.author() != null) {
                compoundTag.put("author", paintingVariant.author());
            }
        });
        this.saveHolderData(StructuredDataKey.BREAK_SOUND, structuredDataContainer, compoundTag2, (soundEvent, compoundTag) -> this.saveSoundEvent((SoundEvent)soundEvent, (CompoundTag)compoundTag));
    }

    @Override
    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5.downgradeItemData(item);
    }

    @Override
    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        super.handleItemDataComponentsToServer(userConnection, item, structuredDataContainer);
        com.viaversion.viaversion.protocols.v1_21_4to1_21_5.rewriter.BlockItemPacketRewriter1_21_5.updateItemData(item);
    }

    @Override
    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag2) {
        IntTag intTag;
        CompoundTag compoundTag3;
        Tag tag;
        CompoundTag compoundTag4;
        super.restoreBackupData(item, structuredDataContainer, compoundTag2);
        Tag tag2 = compoundTag2.remove(this.nbtTagName("backup"));
        if (!(tag2 instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag5 = (CompoundTag)tag2;
        tag2 = compoundTag5.getIntArrayTag("hidden_components");
        if (tag2 != null) {
            structuredDataContainer.set(StructuredDataKey.TOOLTIP_DISPLAY, new TooltipDisplay(structuredDataContainer.has(StructuredDataKey.HIDE_TOOLTIP), new IntLinkedOpenHashSet(((IntArrayTag)tag2).getValue())));
        }
        if (compoundTag5.getBoolean("tool")) {
            structuredDataContainer.replace(StructuredDataKey.TOOL1_20_5, StructuredDataKey.TOOL1_21_5, toolProperties -> new ToolProperties(toolProperties.rules(), toolProperties.defaultMiningSpeed(), toolProperties.damagePerBlock(), true));
        }
        if (compoundTag5.getBoolean("equippable")) {
            structuredDataContainer.replace(StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.EQUIPPABLE1_21_5, equippable -> new Equippable(equippable.equipmentSlot(), equippable.soundEvent(), equippable.model(), equippable.cameraOverlay(), equippable.allowedEntities(), equippable.dispensable(), equippable.swappable(), equippable.damageOnHurt(), true));
        }
        if ((compoundTag4 = compoundTag5.getCompoundTag("weapon")) != null) {
            structuredDataContainer.set(StructuredDataKey.WEAPON, new Weapon(compoundTag4.getInt("item_damage_per_attack"), compoundTag4.getFloat("disable_blocking_for_seconds")));
        }
        if ((tag = compoundTag5.get("provides_trim_material")) != null) {
            structuredDataContainer.set(StructuredDataKey.PROVIDES_TRIM_MATERIAL1_21_5, new ProvidesTrimMaterial(this.restoreEitherHolder(compoundTag5, "provides_trim_material", compoundTag -> {
                String string = compoundTag.getString("asset_name");
                int n = compoundTag.getInt("item_id");
                float f = compoundTag.getFloat("item_model_index");
                CompoundTag compoundTag2 = compoundTag.getCompoundTag("override_armor_materials");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                for (String string2 : compoundTag2.keySet()) {
                    hashMap.put(string2, compoundTag2.getString(string2));
                }
                Tag tag = compoundTag.get("description");
                return new ArmorTrimMaterial(string, n, f, hashMap, tag);
            })));
        }
        if ((compoundTag3 = compoundTag5.getCompoundTag("blocks_attack")) != null) {
            float f = compoundTag3.getFloat("block_delay_seconds");
            float f2 = compoundTag3.getFloat("disable_cooldown_scale");
            CompoundTag compoundTag6 = compoundTag3.getCompoundTag("item_damage");
            BlocksAttacks.ItemDamageFunction itemDamageFunction = new BlocksAttacks.ItemDamageFunction(compoundTag6.getFloat("threshold"), compoundTag6.getFloat("base"), compoundTag6.getFloat("factor"));
            String string = compoundTag3.getString("bypassed_by");
            Holder<SoundEvent> holder = compoundTag3.contains("block_sound") ? this.restoreHolder(compoundTag3, "block_sound", this::tagToSound) : null;
            Holder<SoundEvent> holder2 = compoundTag3.contains("disable_sound") ? this.restoreHolder(compoundTag3, "disable_sound", this::tagToSound) : null;
            ArrayList<BlocksAttacks.DamageReduction> arrayList = new ArrayList<BlocksAttacks.DamageReduction>();
            for (CompoundTag compoundTag7 : compoundTag3.getListTag("damage_reductions", CompoundTag.class)) {
                float f3 = compoundTag7.getFloat("horizontal_blocking_angle");
                HolderSet holderSet = compoundTag7.contains("type") ? this.restoreHolderSet(compoundTag7, "type") : null;
                float f4 = compoundTag7.getFloat("base");
                float f5 = compoundTag7.getFloat("factor");
                arrayList.add(new BlocksAttacks.DamageReduction(f3, holderSet, f4, f5));
            }
            structuredDataContainer.set(StructuredDataKey.BLOCKS_ATTACKS1_21_5, new BlocksAttacks(f, f2, arrayList.toArray(new BlocksAttacks.DamageReduction[0]), itemDamageFunction, string != null ? HolderSet.of(string) : null, holder, holder2));
        }
        if ((intTag = compoundTag5.getIntTag("chicken_variant")) != null) {
            structuredDataContainer.set(StructuredDataKey.CHICKEN_VARIANT1_21_5, Either.left(intTag.asInt()));
        } else {
            String string = compoundTag5.getString("chicken_variant");
            if (string != null) {
                structuredDataContainer.set(StructuredDataKey.CHICKEN_VARIANT1_21_5, Either.right(string));
            }
        }
        IntTag intTag2 = compoundTag5.getIntTag("tropical_fish_pattern");
        if (intTag2 != null) {
            structuredDataContainer.set(StructuredDataKey.TROPICAL_FISH_PATTERN, new TropicalFishPattern(intTag2.asInt()));
        }
        this.restoreKeyData(StructuredDataKey.PROVIDES_BANNER_PATTERNS1_21_5, structuredDataContainer, compoundTag5);
        this.restoreFloatData(StructuredDataKey.POTION_DURATION_SCALE, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.VILLAGER_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.FOX_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.SALMON_SIZE, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.PARROT_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.TROPICAL_FISH_BASE_COLOR, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.TROPICAL_FISH_PATTERN_COLOR, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.MOOSHROOM_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.RABBIT_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.FROG_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.HORSE_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.LLAMA_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.AXOLOTL_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.CAT_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.CAT_COLLAR, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.SHEEP_COLOR, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.SHULKER_COLOR, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.WOLF_SOUND_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.COW_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.PIG_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreIntData(StructuredDataKey.WOLF_VARIANT, structuredDataContainer, compoundTag5);
        this.restoreHolderData(StructuredDataKey.BREAK_SOUND, structuredDataContainer, compoundTag5, this::tagToSound);
        this.restoreHolderData(StructuredDataKey.PAINTING_VARIANT, structuredDataContainer, compoundTag5, compoundTag -> {
            int n = compoundTag.getInt("width");
            int n2 = compoundTag.getInt("height");
            String string = compoundTag.getString("asset_id");
            Tag tag = compoundTag.get("title");
            Tag tag2 = compoundTag.get("author");
            return new PaintingVariant(n, n2, string, tag, tag2);
        });
        this.removeCustomTag(structuredDataContainer, compoundTag2);
    }

    private SoundEvent tagToSound(CompoundTag compoundTag) {
        String string = compoundTag.getString("identifier");
        FloatTag floatTag = compoundTag.getFloatTag("fixed_range");
        return new SoundEvent(string, floatTag != null ? Float.valueOf(floatTag.asFloat()) : null);
    }
}

