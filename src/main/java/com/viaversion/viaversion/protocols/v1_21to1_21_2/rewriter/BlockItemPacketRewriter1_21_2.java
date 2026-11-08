/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ChunkPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.DamageResistant1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.LockCode;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.RecipeRewriter1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ChunkLoadTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.LastExplosionPowerStorage;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BlockItemPacketRewriter1_21_2
extends StructuredItemRewriter<ClientboundPacket1_21, ServerboundPacket1_21_2, Protocol1_21To1_21_2> {
    public static final List<StructuredDataKey<?>> NEW_DATA_TO_REMOVE = List.of(StructuredDataKey.REPAIRABLE, StructuredDataKey.ENCHANTABLE, StructuredDataKey.CONSUMABLE1_21_2, StructuredDataKey.V1_21_2.useRemainder, StructuredDataKey.USE_COOLDOWN, StructuredDataKey.ITEM_MODEL, StructuredDataKey.EQUIPPABLE1_21_2, StructuredDataKey.GLIDER, StructuredDataKey.TOOLTIP_STYLE, StructuredDataKey.DEATH_PROTECTION);
    private static final int RECIPE_NOTIFICATION_FLAG = 1;
    private static final int RECIPE_HIGHLIGHT_FLAG = 2;
    private static final int RECIPE_INIT = 0;
    private static final int RECIPE_ADD = 1;
    private static final int RECIPE_REMOVE = 2;

    public BlockItemPacketRewriter1_21_2(Protocol1_21To1_21_2 protocol1_21To1_21_2) {
        super(protocol1_21To1_21_2);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.COOLDOWN, packetWrapper -> {
            MappingData mappingData = ((Protocol1_21To1_21_2)this.protocol).getMappingData();
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = mappingData.getNewItemId(n);
            packetWrapper.write(Types.STRING, mappingData.getFullItemMappings().mappedIdentifier(n2));
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.CONTAINER_SET_CONTENT, packetWrapper -> {
            this.unsignedByteToVarInt(packetWrapper);
            packetWrapper.passthrough(Types.VAR_INT);
            Item[] itemArray = packetWrapper.read(this.itemArrayType());
            packetWrapper.write(this.mappedItemArrayType(), itemArray);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClient(packetWrapper.user(), itemArray[i]);
            }
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.CONTAINER_SET_SLOT, packetWrapper -> {
            this.byteToVarInt(packetWrapper);
            int n = packetWrapper.get(Types.VAR_INT, 0);
            if (n == -1) {
                packetWrapper.setPacketType(ClientboundPackets1_21_2.SET_CURSOR_ITEM);
                packetWrapper.resetReader();
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.read(Types.SHORT);
            } else if (n == -2) {
                packetWrapper.setPacketType(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY);
                packetWrapper.resetReader();
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.read(Types.VAR_INT);
                packetWrapper.write(Types.VAR_INT, Integer.valueOf(packetWrapper.read(Types.SHORT).shortValue()));
            } else {
                packetWrapper.passthrough(Types.VAR_INT);
                packetWrapper.passthrough(Types.SHORT);
            }
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.CONTAINER_CLOSE, this::unsignedByteToVarInt);
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.CONTAINER_SET_DATA, this::unsignedByteToVarInt);
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.HORSE_SCREEN_OPEN, this::unsignedByteToVarInt);
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.SET_CARRIED_ITEM, ClientboundPackets1_21_2.SET_HELD_SLOT);
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.CONTAINER_CLOSE, this::varIntToByte);
        ((Protocol1_21To1_21_2)this.protocol).replaceServerbound(ServerboundPackets1_21_2.CONTAINER_CLICK, packetWrapper -> {
            this.varIntToByte(packetWrapper);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                packetWrapper.write(this.itemType(), this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType())));
            }
            packetWrapper.write(this.itemType(), this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType())));
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.PLACE_GHOST_RECIPE, packetWrapper -> {
            this.byteToVarInt(packetWrapper);
            String string = packetWrapper.read(Types.STRING);
            RecipeRewriter1_21_2.Recipe recipe = packetWrapper.user().get(RecipeRewriter1_21_2.class).recipe(string);
            if (recipe == null) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.VAR_INT, recipe.recipeDisplayId());
            recipe.writeRecipeDisplay(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.PLACE_RECIPE, packetWrapper -> {
            this.varIntToByte(packetWrapper);
            this.convertServerboundRecipeDisplayId(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.RECIPE_BOOK_SEEN_RECIPE, this::convertServerboundRecipeDisplayId);
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.USE_ITEM_ON, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.read(Types.BOOLEAN);
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.EXPLODE, packetWrapper -> {
            int n = (int)Math.floor(packetWrapper.passthrough(Types.DOUBLE));
            int n2 = (int)Math.floor(packetWrapper.passthrough(Types.DOUBLE));
            int n3 = (int)Math.floor(packetWrapper.passthrough(Types.DOUBLE));
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            ArrayList<BlockPosition> arrayList = new ArrayList<BlockPosition>();
            int n4 = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n4; ++i) {
                int n5 = n + packetWrapper.read(Types.BYTE);
                int n6 = n2 + packetWrapper.read(Types.BYTE);
                int n7 = n3 + packetWrapper.read(Types.BYTE);
                arrayList.add(new BlockPosition(n5, n6, n7));
            }
            LastExplosionPowerStorage lastExplosionPowerStorage = packetWrapper.user().get(LastExplosionPowerStorage.class);
            if (lastExplosionPowerStorage != null) {
                lastExplosionPowerStorage.setPower(f);
                lastExplosionPowerStorage.setAffectedBlocks(arrayList.size());
            }
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            float f3 = packetWrapper.read(Types.FLOAT).floatValue();
            float f4 = packetWrapper.read(Types.FLOAT).floatValue();
            if (f2 != 0.0f || f3 != 0.0f || f4 != 0.0f) {
                packetWrapper.write(Types.BOOLEAN, true);
                packetWrapper.write(Types.DOUBLE, Double.valueOf(f2));
                packetWrapper.write(Types.DOUBLE, Double.valueOf(f3));
                packetWrapper.write(Types.DOUBLE, Double.valueOf(f4));
            } else {
                packetWrapper.write(Types.BOOLEAN, false);
            }
            int n8 = packetWrapper.read(Types.VAR_INT);
            if (n8 == 1 || n8 == 2) {
                for (BlockPosition object2 : arrayList) {
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_2.BLOCK_UPDATE, packetWrapper.user());
                    packetWrapper2.write(Types.BLOCK_POSITION1_14, object2);
                    packetWrapper2.write(Types.VAR_INT, 0);
                    packetWrapper2.send(Protocol1_21To1_21_2.class);
                }
            }
            Particle particle = packetWrapper.read(VersionedTypes.V1_21.particle);
            Particle particle2 = packetWrapper.read(VersionedTypes.V1_21.particle);
            if (f >= 2.0f && n8 != 0) {
                ((Protocol1_21To1_21_2)this.protocol).getParticleRewriter().rewriteParticle(packetWrapper.user(), particle2);
                packetWrapper.write(VersionedTypes.V1_21_2.particle, particle2);
            } else {
                ((Protocol1_21To1_21_2)this.protocol).getParticleRewriter().rewriteParticle(packetWrapper.user(), particle);
                packetWrapper.write(VersionedTypes.V1_21_2.particle, particle);
            }
            ((Protocol1_21To1_21_2)this.protocol).getSoundRewriter().soundHolderHandler().handle(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.UPDATE_RECIPES, packetWrapper -> {
            FullMappings fullMappings = ((Protocol1_21To1_21_2)this.protocol).getMappingData().getRecipeSerializerMappings();
            RecipeRewriter1_21_2 recipeRewriter1_21_2 = new RecipeRewriter1_21_2(this.protocol);
            packetWrapper.user().put(recipeRewriter1_21_2);
            int n = packetWrapper.read(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                String string = packetWrapper.read(Types.STRING);
                int n2 = packetWrapper.read(Types.VAR_INT);
                String string2 = fullMappings.identifier(n2);
                recipeRewriter1_21_2.setCurrentRecipeIdentifier(string);
                recipeRewriter1_21_2.handleRecipeType(packetWrapper, string2);
            }
            recipeRewriter1_21_2.finalizeRecipes();
            recipeRewriter1_21_2.writeUpdateRecipeInputs(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.RECIPE, ClientboundPackets1_21_2.RECIPE_BOOK_ADD, packetWrapper -> {
            Object object;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.RECIPE_BOOK_SETTINGS);
            for (int i = 0; i < 8; ++i) {
                packetWrapper2.write(Types.BOOLEAN, packetWrapper.read(Types.BOOLEAN));
            }
            packetWrapper2.send(Protocol1_21To1_21_2.class);
            String[] stringArray = packetWrapper.read(Types.STRING_ARRAY);
            Set<Object> set = Set.of();
            if (n == 0) {
                object = packetWrapper.read(Types.STRING_ARRAY);
                set = Set.of(object);
            }
            if ((object = packetWrapper.user().get(RecipeRewriter1_21_2.class)) == null) {
                ((Protocol1_21To1_21_2)this.protocol).getLogger().severe("Recipes not yet sent for recipe add packet");
                packetWrapper.cancel();
                return;
            }
            packetWrapper.clearPacket();
            if (n == 2) {
                packetWrapper.setPacketType(ClientboundPackets1_21_2.RECIPE_BOOK_REMOVE);
                int[] nArray = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; ++i) {
                    String string = stringArray[i];
                    RecipeRewriter1_21_2.Recipe recipe = ((RecipeRewriter1_21_2)object).recipe(string);
                    if (recipe == null) {
                        ((Protocol1_21To1_21_2)this.protocol).getLogger().severe("Recipe not found for key " + string);
                        packetWrapper.cancel();
                        return;
                    }
                    nArray[i] = recipe.index();
                }
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, nArray);
                return;
            }
            int n2 = stringArray.length;
            packetWrapper.write(Types.VAR_INT, n2);
            for (String string : stringArray) {
                RecipeRewriter1_21_2.Recipe recipe = ((RecipeRewriter1_21_2)object).recipe(string);
                if (recipe == null) {
                    --n2;
                    continue;
                }
                packetWrapper.write(Types.VAR_INT, recipe.index());
                packetWrapper.write(Types.VAR_INT, recipe.recipeDisplayId());
                recipe.writeRecipeDisplay(packetWrapper);
                packetWrapper.write(Types.OPTIONAL_VAR_INT, recipe.group() != -1 ? Integer.valueOf(recipe.group()) : null);
                packetWrapper.write(Types.VAR_INT, recipe.category());
                Item[][] itemArray2 = recipe.ingredients();
                if (itemArray2 != null) {
                    packetWrapper.write(Types.BOOLEAN, true);
                    List<HolderSet> list = Arrays.stream(itemArray2).filter(itemArray -> ((Item[])itemArray).length > 0).map(((RecipeRewriter1_21_2)object)::toHolderSet).toList();
                    packetWrapper.write(Types.VAR_INT, list.size());
                    for (HolderSet holderSet : list) {
                        packetWrapper.write(Types.HOLDER_SET, holderSet);
                    }
                } else {
                    packetWrapper.write(Types.BOOLEAN, false);
                }
                byte by = 0;
                if (n == 1) {
                    if (recipe.showNotification()) {
                        by = (byte)(by | 1);
                    }
                    by = (byte)(by | 2);
                } else if (set.contains(string)) {
                    by = (byte)(by | 2);
                }
                packetWrapper.write(Types.BYTE, by);
            }
            packetWrapper.set(Types.VAR_INT, 0, n2);
            packetWrapper.write(Types.BOOLEAN, n == 0);
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Object object;
            int n;
            Object object2;
            Chunk chunk = ((Protocol1_21To1_21_2)this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
            FullMappings fullMappings = ((Protocol1_21To1_21_2)this.protocol).getMappingData().getBlockEntityMappings();
            if (fullMappings != null) {
                object2 = chunk.blockEntities();
                for (n = 0; n < object2.size(); ++n) {
                    int n2;
                    object = (BlockEntity)object2.get(n);
                    int n3 = object.typeId();
                    if (n3 == (n2 = fullMappings.getNewIdOrDefault(n3, n3))) continue;
                    object2.set(n, object.withTypeId(n2));
                }
            }
            if ((object2 = packetWrapper.user().get(ChunkLoadTracker.class)) == null) {
                return;
            }
            if (((ChunkLoadTracker)object2).isChunkLoaded(chunk.getX(), chunk.getZ())) {
                n = packetWrapper.user().get(BundleStateTracker.class).isBundling() ? 1 : 0;
                if (n == 0) {
                    object = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    object.send(Protocol1_21To1_21_2.class);
                }
                object = packetWrapper.create(ClientboundPackets1_21_2.FORGET_LEVEL_CHUNK);
                object.write(Types.CHUNK_POSITION, new ChunkPosition(chunk.getX(), chunk.getZ()));
                object.send(Protocol1_21To1_21_2.class);
                packetWrapper.send(Protocol1_21To1_21_2.class);
                packetWrapper.cancel();
                if (n == 0) {
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    packetWrapper2.send(Protocol1_21To1_21_2.class);
                }
            } else {
                ((ChunkLoadTracker)object2).addChunk(chunk.getX(), chunk.getZ());
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.FORGET_LEVEL_CHUNK, packetWrapper -> {
            ChunkPosition chunkPosition = packetWrapper.passthrough(Types.CHUNK_POSITION);
            ChunkLoadTracker chunkLoadTracker = packetWrapper.user().get(ChunkLoadTracker.class);
            if (chunkLoadTracker != null) {
                chunkLoadTracker.removeChunk(chunkPosition.chunkX(), chunkPosition.chunkZ());
            }
        });
    }

    private void convertServerboundRecipeDisplayId(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
        RecipeRewriter1_21_2.Recipe recipe = packetWrapper.user().get(RecipeRewriter1_21_2.class).recipe(n);
        if (recipe == null) {
            packetWrapper.cancel();
            return;
        }
        packetWrapper.write(Types.STRING, recipe.identifier());
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        int n;
        Tag tag;
        if (item.isEmpty()) {
            return item;
        }
        super.handleItemToClient(userConnection, item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        FoodProperties1_20_5 foodProperties1_20_5 = structuredDataContainer.get(StructuredDataKey.FOOD1_21);
        if (foodProperties1_20_5 != null && foodProperties1_20_5.usingConvertsTo() != null) {
            this.handleItemToClient(userConnection, foodProperties1_20_5.usingConvertsTo());
        }
        BlockItemPacketRewriter1_21_2.updateItemData(item);
        Enchantments enchantments = structuredDataContainer.get(StructuredDataKey.ENCHANTMENTS1_20_5);
        if (enchantments != null && enchantments.size() != 0) {
            IntArrayList intArrayList = new IntArrayList();
            enchantments.enchantments().int2IntEntrySet().removeIf(entry -> {
                if (entry.getIntValue() == 0) {
                    intArrayList.add(entry.getIntKey());
                    return true;
                }
                return false;
            });
            if (!intArrayList.isEmpty()) {
                tag = new IntArrayTag(intArrayList.toIntArray());
                this.saveTag(this.createCustomTag(item), tag, "0_enchants");
            }
            if (enchantments.size() == 0 && !structuredDataContainer.has(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE)) {
                structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
                this.saveTag(this.createCustomTag(item), new ByteTag(true), "remove_glint");
            }
        }
        if (!((n = item.identifier()) != 952 && n != 1147 && n != 1039 && n != 1203 && n != 1200 && n != 1204 && n != 1202 || (tag = structuredDataContainer.get(StructuredDataKey.ITEM_NAME)) == null || structuredDataContainer.has(StructuredDataKey.CUSTOM_NAME))) {
            CompoundTag compoundTag = new CompoundTag();
            compoundTag.putBoolean("italic", false);
            compoundTag.putString("text", "");
            compoundTag.put("extra", new ListTag<Tag>(Collections.singletonList(tag)));
            structuredDataContainer.set(StructuredDataKey.CUSTOM_NAME, compoundTag);
            this.saveTag(this.createCustomTag(item), new ByteTag(true), "remove_custom_name");
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        IntArrayTag intArrayTag;
        if (item.isEmpty()) {
            return item;
        }
        super.handleItemToServer(userConnection, item);
        BlockItemPacketRewriter1_21_2.downgradeItemData(item);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null) {
            return item;
        }
        if (compoundTag.remove(this.nbtTagName("remove_custom_name")) != null) {
            structuredDataContainer.remove(StructuredDataKey.CUSTOM_NAME);
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        if ((intArrayTag = compoundTag.getIntArrayTag(this.nbtTagName("0_enchants"))) != null) {
            Enchantments enchantments = structuredDataContainer.get(StructuredDataKey.ENCHANTMENTS1_20_5);
            if (enchantments == null) {
                enchantments = new Enchantments(true);
                structuredDataContainer.set(StructuredDataKey.ENCHANTMENTS1_20_5, enchantments);
            }
            for (int n : intArrayTag.getValue()) {
                enchantments.enchantments().put(n, 0);
            }
            compoundTag.remove(this.nbtTagName("0_enchants"));
            if (compoundTag.remove(this.nbtTagName("remove_glint")) != null) {
                structuredDataContainer.remove(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE);
            }
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
        return item;
    }

    private void unsignedByteToVarInt(PacketWrapper packetWrapper) {
        short s = packetWrapper.read(Types.UNSIGNED_BYTE);
        packetWrapper.write(Types.VAR_INT, Integer.valueOf(s));
    }

    private void byteToVarInt(PacketWrapper packetWrapper) {
        byte by = packetWrapper.read(Types.BYTE);
        packetWrapper.write(Types.VAR_INT, Integer.valueOf(by));
    }

    private void varIntToByte(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
        packetWrapper.write(Types.BYTE, (byte)n);
    }

    public static void updateItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT1_20_5, StructuredDataKey.INSTRUMENT1_21_2, holder -> {
            if (holder.hasId()) {
                return Holder.of(holder.id());
            }
            Instrument1_20_5 instrument1_20_5 = (Instrument1_20_5)holder.value();
            return Holder.of(new Instrument1_21_2(instrument1_20_5.soundEvent(), (float)instrument1_20_5.useDuration() / 20.0f, instrument1_20_5.range(), new StringTag("")));
        });
        structuredDataContainer.replace(StructuredDataKey.FOOD1_21, StructuredDataKey.FOOD1_21_2, foodProperties1_20_5 -> {
            Holder<SoundEvent> holder = Holder.of(new SoundEvent("minecraft:entity.generic.eat", null));
            Consumable1_21_2.ConsumeEffect[] consumeEffectArray = new Consumable1_21_2.ConsumeEffect[foodProperties1_20_5.possibleEffects().length];
            for (int i = 0; i < consumeEffectArray.length; ++i) {
                FoodProperties1_20_5.FoodEffect foodEffect = foodProperties1_20_5.possibleEffects()[i];
                Consumable1_21_2.ApplyStatusEffects applyStatusEffects = new Consumable1_21_2.ApplyStatusEffects(new PotionEffect[]{foodEffect.effect()}, foodEffect.probability());
                consumeEffectArray[i] = new Consumable1_21_2.ConsumeEffect<Consumable1_21_2.ApplyStatusEffects>(0, Consumable1_21_2.ApplyStatusEffects.TYPE, applyStatusEffects);
            }
            structuredDataContainer.set(StructuredDataKey.CONSUMABLE1_21_2, new Consumable1_21_2(foodProperties1_20_5.eatSeconds(), 1, holder, true, consumeEffectArray));
            if (foodProperties1_20_5.usingConvertsTo() != null) {
                structuredDataContainer.set(StructuredDataKey.V1_21_2.useRemainder, foodProperties1_20_5.usingConvertsTo());
            }
            return new FoodProperties1_21_2(foodProperties1_20_5.nutrition(), foodProperties1_20_5.saturationModifier(), foodProperties1_20_5.canAlwaysEat());
        }, () -> {
            structuredDataContainer.setEmpty(StructuredDataKey.CONSUMABLE1_21_2);
            structuredDataContainer.setEmpty(StructuredDataKey.V1_21_2.useRemainder);
        });
        structuredDataContainer.replaceKey(StructuredDataKey.POTION_CONTENTS1_20_5, StructuredDataKey.POTION_CONTENTS1_21_2);
        structuredDataContainer.replace(StructuredDataKey.FIRE_RESISTANT, StructuredDataKey.DAMAGE_RESISTANT1_21_2, unit -> new DamageResistant1_21_2(Key.of("minecraft:is_fire")));
        structuredDataContainer.replace(StructuredDataKey.LOCK1_20_5, StructuredDataKey.LOCK1_21_2, tag -> {
            String string = ((StringTag)tag).getValue();
            CompoundTag compoundTag = new CompoundTag();
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag.put("components", compoundTag2);
            compoundTag2.putString("custom_name", ComponentUtil.plainToJson(string).toString());
            return new LockCode(compoundTag);
        });
        structuredDataContainer.replace(StructuredDataKey.TRIM1_20_5, StructuredDataKey.TRIM1_21_2, armorTrim -> {
            if (armorTrim.material().isDirect()) {
                armorTrim.material().value().overrideArmorMaterials().clear();
            }
            return armorTrim;
        });
    }

    public static void downgradeItemData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.replace(StructuredDataKey.LOCK1_21_2, StructuredDataKey.LOCK1_20_5, lockCode -> {
            CompoundTag compoundTag = lockCode.tag();
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("components");
            if (compoundTag2 == null) {
                return null;
            }
            StringTag stringTag = TagUtil.getNamespacedStringTag(compoundTag2, "custom_name");
            if (stringTag == null || stringTag.getValue().equals("null")) {
                return null;
            }
            return new StringTag(SerializerVersion.V1_20_5.toComponent(stringTag.getValue()).asUnformattedString());
        });
        structuredDataContainer.replace(StructuredDataKey.INSTRUMENT1_21_2, StructuredDataKey.INSTRUMENT1_20_5, holder -> {
            if (holder.hasId()) {
                return Holder.of(holder.id());
            }
            Instrument1_21_2 instrument1_21_2 = (Instrument1_21_2)holder.value();
            return Holder.of(new Instrument1_20_5(instrument1_21_2.soundEvent(), (int)(instrument1_21_2.useDuration() * 20.0f), instrument1_21_2.range()));
        });
        structuredDataContainer.replace(StructuredDataKey.FOOD1_21_2, StructuredDataKey.FOOD1_21, foodProperties1_21_2 -> {
            Consumable1_21_2 consumable1_21_2 = structuredDataContainer.get(StructuredDataKey.CONSUMABLE1_21_2);
            Item item = structuredDataContainer.get(StructuredDataKey.V1_21_2.useRemainder);
            float f = consumable1_21_2 != null ? consumable1_21_2.consumeSeconds() : 1.6f;
            ArrayList<FoodProperties1_20_5.FoodEffect> arrayList = new ArrayList<FoodProperties1_20_5.FoodEffect>();
            if (consumable1_21_2 != null) {
                for (Consumable1_21_2.ConsumeEffect<?> consumeEffect : consumable1_21_2.consumeEffects()) {
                    Object obj = consumeEffect.value();
                    if (!(obj instanceof Consumable1_21_2.ApplyStatusEffects)) continue;
                    Consumable1_21_2.ApplyStatusEffects applyStatusEffects = (Consumable1_21_2.ApplyStatusEffects)obj;
                    for (PotionEffect potionEffect : applyStatusEffects.effects()) {
                        arrayList.add(new FoodProperties1_20_5.FoodEffect(potionEffect, applyStatusEffects.probability()));
                    }
                }
            }
            return new FoodProperties1_20_5(foodProperties1_21_2.nutrition(), foodProperties1_21_2.saturationModifier(), foodProperties1_21_2.canAlwaysEat(), f, item, arrayList.toArray(new FoodProperties1_20_5.FoodEffect[0]));
        });
        structuredDataContainer.replace(StructuredDataKey.TRIM1_21_2, StructuredDataKey.TRIM1_20_5, armorTrim -> {
            if (armorTrim.material().isDirect()) {
                armorTrim.material().value().overrideArmorMaterials().clear();
            }
            return armorTrim;
        });
        structuredDataContainer.replaceKey(StructuredDataKey.POTION_CONTENTS1_21_2, StructuredDataKey.POTION_CONTENTS1_20_5);
        structuredDataContainer.replace(StructuredDataKey.DAMAGE_RESISTANT1_21_2, StructuredDataKey.FIRE_RESISTANT, damageResistant1_21_2 -> {
            if (damageResistant1_21_2.typesTagKey().equals("is_fire")) {
                return Unit.INSTANCE;
            }
            return null;
        });
        structuredDataContainer.remove(NEW_DATA_TO_REMOVE);
    }
}

