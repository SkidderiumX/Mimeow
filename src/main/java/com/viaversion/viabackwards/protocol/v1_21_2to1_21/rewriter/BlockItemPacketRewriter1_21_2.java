/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.BackwardsFullStructuredItemRewriter;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.Protocol1_21_2To1_21;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.InventoryStateIdStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.RecipeStorage;
import com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage.SignStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.DataPalette;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.minecraft.item.data.Consumable1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.DeathProtection;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantable;
import com.viaversion.viaversion.api.minecraft.item.data.Enchantments;
import com.viaversion.viaversion.api.minecraft.item.data.Equippable;
import com.viaversion.viaversion.api.minecraft.item.data.FoodProperties1_20_5;
import com.viaversion.viaversion.api.minecraft.item.data.Instrument1_21_2;
import com.viaversion.viaversion.api.minecraft.item.data.ItemModel;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffectData;
import com.viaversion.viaversion.api.minecraft.item.data.Repairable;
import com.viaversion.viaversion.api.minecraft.item.data.UseCooldown;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPacket1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.Unit;
import java.util.ArrayList;

public class BlockItemPacketRewriter1_21_2
extends BackwardsFullStructuredItemRewriter<ClientboundPacket1_21_2, ServerboundPacket1_20_5, Protocol1_21_2To1_21> {
    public BlockItemPacketRewriter1_21_2(Protocol1_21_2To1_21 protocol1_21_2To1_21) {
        super(protocol1_21_2To1_21);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.LEVEL_CHUNK_WITH_LIGHT, packetWrapper -> {
            Chunk chunk = ((Protocol1_21_2To1_21)this.protocol).getBlockRewriter().handleChunk1_18(packetWrapper);
            ((Protocol1_21_2To1_21)this.protocol).getBlockRewriter().handleBlockEntities(chunk, packetWrapper.user());
            if (!packetWrapper.user().getProtocolInfo().protocolVersion().equalTo(ProtocolVersion.v1_21)) {
                return;
            }
            Object t = packetWrapper.user().getEntityTracker(Protocol1_21_2To1_21.class);
            SignStorage signStorage = packetWrapper.user().get(SignStorage.class);
            signStorage.removeSigns(chunk.getX(), chunk.getZ());
            for (int i = 0; i < chunk.getSections().length; ++i) {
                ChunkSection chunkSection = chunk.getSections()[i];
                if (chunkSection.getNonAirBlocksCount() == 0) continue;
                DataPalette dataPalette = chunkSection.palette(PaletteType.BLOCKS);
                int n = i;
                dataPalette.forEachMatchingCoordinate(this::signBlockState, n2 -> signStorage.addSign(new BlockPosition(ChunkSection.xFromIndex(n2) + (chunk.getX() << 4), ChunkSection.yFromIndex(n2) + t.currentMinY() + (n << 4), ChunkSection.zFromIndex(n2) + (chunk.getZ() << 4))));
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.BLOCK_UPDATE, packetWrapper -> {
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = ((Protocol1_21_2To1_21)this.protocol).getMappingData().getNewBlockStateId(n);
            packetWrapper.write(Types.VAR_INT, n2);
            if (!packetWrapper.user().getProtocolInfo().protocolVersion().equalTo(ProtocolVersion.v1_21)) {
                return;
            }
            SignStorage signStorage = packetWrapper.user().get(SignStorage.class);
            signStorage.removeSign(blockPosition);
            if (this.signBlockState(n2)) {
                signStorage.addSign(blockPosition);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.SECTION_BLOCKS_UPDATE, packetWrapper -> {
            long l = packetWrapper.passthrough(Types.LONG);
            int n = (int)(l >> 42);
            int n2 = (int)(l << 44 >> 44);
            int n3 = (int)(l << 22 >> 42);
            SignStorage signStorage = packetWrapper.user().get(SignStorage.class);
            boolean bl = packetWrapper.user().getProtocolInfo().protocolVersion().equalTo(ProtocolVersion.v1_21);
            for (BlockChangeRecord blockChangeRecord : packetWrapper.passthrough(Types.VAR_LONG_BLOCK_CHANGE_ARRAY)) {
                blockChangeRecord.setBlockId(((Protocol1_21_2To1_21)this.protocol).getMappingData().getNewBlockStateId(blockChangeRecord.getBlockId()));
                if (!bl) continue;
                int n4 = blockChangeRecord.getSectionX() + (n << 4);
                int n5 = blockChangeRecord.getSectionY() + (n2 << 4);
                int n6 = blockChangeRecord.getSectionZ() + (n3 << 4);
                BlockPosition blockPosition = new BlockPosition(n4, n5, n6);
                if (this.signBlockState(blockChangeRecord.getBlockId())) {
                    signStorage.addSign(blockPosition);
                    continue;
                }
                signStorage.removeSign(blockPosition);
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.OPEN_SIGN_EDITOR, packetWrapper -> {
            if (!packetWrapper.user().getProtocolInfo().protocolVersion().equalTo(ProtocolVersion.v1_21)) {
                return;
            }
            BlockPosition blockPosition = packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            if (!packetWrapper.user().get(SignStorage.class).isSign(blockPosition)) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.COOLDOWN, packetWrapper -> {
            BackwardsMappingData backwardsMappingData = ((Protocol1_21_2To1_21)this.protocol).getMappingData();
            String string = packetWrapper.read(Types.STRING);
            int n = backwardsMappingData.getFullItemMappings().id(string);
            if (n != -1) {
                int n2 = backwardsMappingData.getFullItemMappings().getNewId(n);
                packetWrapper.write(Types.VAR_INT, n2);
            } else {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_CURSOR_ITEM, ClientboundPackets1_21.CONTAINER_SET_SLOT, packetWrapper -> {
            packetWrapper.write(Types.BYTE, (byte)-1);
            packetWrapper.write(Types.VAR_INT, packetWrapper.user().get(InventoryStateIdStorage.class).stateId());
            packetWrapper.write(Types.SHORT, (short)-1);
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.OPEN_SCREEN, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 21) {
                packetWrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(true);
            }
            ((ComponentRewriterBase)((Protocol1_21_2To1_21)this.protocol).getComponentRewriter()).passthroughAndProcess(packetWrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT, packetWrapper -> {
            this.varIntToUnsignedByte(packetWrapper);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.user().get(InventoryStateIdStorage.class).setStateId(n);
            Item[] itemArray = packetWrapper.read(this.itemArrayType());
            packetWrapper.write(this.mappedItemArrayType(), itemArray);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClient(packetWrapper.user(), itemArray[i]);
            }
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.CONTAINER_SET_SLOT, packetWrapper -> {
            this.varIntToByte(packetWrapper);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.user().get(InventoryStateIdStorage.class).setStateId(n);
            packetWrapper.passthrough(Types.SHORT);
            this.passthroughClientboundItem(packetWrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_SET_DATA, packetWrapper -> {
            this.varIntToUnsignedByte(packetWrapper);
            if (packetWrapper.user().get(InventoryStateIdStorage.class).smithingTableOpen()) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.CONTAINER_CLOSE, packetWrapper -> {
            this.varIntToUnsignedByte(packetWrapper);
            packetWrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(false);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_HELD_SLOT, ClientboundPackets1_21.SET_CARRIED_ITEM);
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.HORSE_SCREEN_OPEN, this::varIntToUnsignedByte);
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.CONTAINER_CLOSE, packetWrapper -> {
            this.byteToVarInt(packetWrapper);
            packetWrapper.user().get(InventoryStateIdStorage.class).setSmithingTableOpen(false);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceServerbound(ServerboundPackets1_20_5.CONTAINER_CLICK, packetWrapper -> {
            this.byteToVarInt(packetWrapper);
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
        ((Protocol1_21_2To1_21)this.protocol).replaceServerbound(ServerboundPackets1_20_5.SET_CREATIVE_MODE_SLOT, packetWrapper -> {
            if (((Protocol1_21_2To1_21)this.protocol).getEntityRewriter() != null && !((Protocol1_21_2To1_21)this.protocol).getEntityRewriter().tracker(packetWrapper.user()).canInstaBuild()) {
                packetWrapper.cancel();
                return;
            }
            short s = packetWrapper.passthrough(Types.SHORT);
            Item item = packetWrapper.read(this.mappedItemType());
            InventoryStateIdStorage inventoryStateIdStorage = packetWrapper.user().get(InventoryStateIdStorage.class);
            boolean bl = Item.isEmpty(item);
            if (bl && s == inventoryStateIdStorage.nextClearedSlot()) {
                if (s == 45) {
                    inventoryStateIdStorage.setNextClearedSlot(0);
                    this.sendEmptyInventorySlots(packetWrapper.user());
                } else {
                    inventoryStateIdStorage.setNextClearedSlot(s + 1);
                }
            } else {
                inventoryStateIdStorage.setNextClearedSlot(bl && s == 0 ? 1 : 0);
            }
            packetWrapper.write(this.itemType(), this.handleItemToServer(packetWrapper.user(), item));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.USE_ITEM_ON, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BLOCK_POSITION1_14);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.write(Types.BOOLEAN, false);
        });
        ((Protocol1_21_2To1_21)this.protocol).replaceClientbound(ClientboundPackets1_21_2.EXPLODE, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
            packetWrapper.write(Types.VAR_INT, 0);
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                d = packetWrapper.read(Types.DOUBLE);
                d2 = packetWrapper.read(Types.DOUBLE);
                d3 = packetWrapper.read(Types.DOUBLE);
            }
            packetWrapper.write(Types.FLOAT, Float.valueOf((float)d));
            packetWrapper.write(Types.FLOAT, Float.valueOf((float)d2));
            packetWrapper.write(Types.FLOAT, Float.valueOf((float)d3));
            packetWrapper.write(Types.VAR_INT, 0);
            Particle particle = packetWrapper.read(VersionedTypes.V1_21.particle());
            ((Protocol1_21_2To1_21)this.protocol).getParticleRewriter().rewriteParticle(packetWrapper.user(), particle);
            packetWrapper.write(VersionedTypes.V1_21_2.particle(), particle);
            packetWrapper.write(VersionedTypes.V1_21_2.particle(), particle);
            new SoundRewriter(this.protocol).soundHolderHandler().handle(packetWrapper);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_ADD, null, packetWrapper -> {
            int n;
            RecipeStorage recipeStorage = packetWrapper.user().get(RecipeStorage.class);
            int n2 = packetWrapper.read(Types.VAR_INT);
            for (n = 0; n < n2; ++n) {
                recipeStorage.readRecipe(packetWrapper);
            }
            n = packetWrapper.read(Types.BOOLEAN).booleanValue() ? 1 : 0;
            if (n != 0) {
                recipeStorage.clearRecipes();
            }
            recipeStorage.sendRecipes(packetWrapper.user());
            packetWrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_REMOVE, ClientboundPackets1_21.RECIPE, packetWrapper -> {
            RecipeStorage recipeStorage = packetWrapper.user().get(RecipeStorage.class);
            int[] nArray = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            recipeStorage.lockRecipes(packetWrapper, nArray);
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.RECIPE_BOOK_SETTINGS, null, packetWrapper -> {
            RecipeStorage recipeStorage = packetWrapper.user().get(RecipeStorage.class);
            boolean[] blArray = new boolean[8];
            for (int i = 0; i < 8; ++i) {
                blArray[i] = packetWrapper.read(Types.BOOLEAN);
            }
            recipeStorage.setRecipeBookSettings(blArray);
            packetWrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.UPDATE_RECIPES, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.read(Types.STRING);
                packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            }
            RecipeStorage recipeStorage = packetWrapper.user().get(RecipeStorage.class);
            recipeStorage.readStoneCutterRecipes(packetWrapper);
            packetWrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE, packetWrapper -> {
            this.varIntToByte(packetWrapper);
            packetWrapper.cancel();
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.PLACE_RECIPE, packetWrapper -> {
            this.byteToVarInt(packetWrapper);
            String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
            packetWrapper.write(Types.VAR_INT, Integer.parseInt(string));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerServerbound(ServerboundPackets1_20_5.RECIPE_BOOK_SEEN_RECIPE, packetWrapper -> {
            String string = Key.stripMinecraftNamespace(packetWrapper.read(Types.STRING));
            packetWrapper.write(Types.VAR_INT, Integer.parseInt(string));
        });
        ((Protocol1_21_2To1_21)this.protocol).registerClientbound(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY, ClientboundPackets1_21.CONTAINER_SET_SLOT, packetWrapper -> {
            packetWrapper.write(Types.BYTE, (byte)-2);
            packetWrapper.write(Types.VAR_INT, 0);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.SHORT, (short)n);
            this.passthroughClientboundItem(packetWrapper);
        });
    }

    private void sendEmptyInventorySlots(UserConnection userConnection) {
        int n = userConnection.get(InventoryStateIdStorage.class).stateId();
        for (int i = 1; i <= 45; ++i) {
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21.CONTAINER_SET_SLOT, userConnection);
            packetWrapper.write(Types.BYTE, (byte)0);
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.write(Types.SHORT, (short)i);
            packetWrapper.write(this.mappedItemType(), StructuredItem.empty());
            packetWrapper.send(Protocol1_21_2To1_21.class);
        }
    }

    private void varIntToUnsignedByte(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
        packetWrapper.write(Types.UNSIGNED_BYTE, (short)n);
    }

    private void varIntToByte(PacketWrapper packetWrapper) {
        int n = packetWrapper.read(Types.VAR_INT);
        packetWrapper.write(Types.BYTE, (byte)n);
    }

    private void byteToVarInt(PacketWrapper packetWrapper) {
        byte by = packetWrapper.read(Types.BYTE);
        packetWrapper.write(Types.VAR_INT, Integer.valueOf(by));
    }

    private boolean signBlockState(int n) {
        return n >= 4302 && n <= 4589 || n >= 4762 && n <= 5625 || n >= 19276 && n <= 19355;
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        this.backupInconvertibleData(item);
        item = super.handleItemToClient(userConnection, item);
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2.downgradeItemData(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        Enchantments enchantments;
        boolean bl;
        StructuredDataContainer structuredDataContainer = (item = super.handleItemToServer(userConnection, item)).dataContainer();
        FoodProperties1_20_5 foodProperties1_20_5 = structuredDataContainer.get(StructuredDataKey.FOOD1_21);
        if (foodProperties1_20_5 != null && foodProperties1_20_5.usingConvertsTo() != null) {
            this.handleItemToServer(userConnection, foodProperties1_20_5.usingConvertsTo());
        }
        com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter.BlockItemPacketRewriter1_21_2.updateItemData(item);
        this.restoreInconvertibleData(item);
        Enchantments enchantments2 = structuredDataContainer.get(StructuredDataKey.ENCHANTMENTS1_20_5);
        if (enchantments2 != null && (bl = enchantments2.enchantments().values().removeIf(n -> n == 0)) && enchantments2.size() == 0) {
            structuredDataContainer.set(StructuredDataKey.ENCHANTMENT_GLINT_OVERRIDE, true);
        }
        if ((enchantments = structuredDataContainer.get(StructuredDataKey.STORED_ENCHANTMENTS1_20_5)) != null) {
            enchantments.enchantments().values().removeIf(n -> n == 0);
        }
        return item;
    }

    private void backupInconvertibleData(Item item) {
        Object object;
        Object object2;
        Object object3;
        Equippable equippable;
        Object object4;
        UseCooldown useCooldown;
        Enchantable enchantable;
        Repairable repairable;
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        structuredDataContainer.setIdLookup(this.protocol, true);
        CompoundTag compoundTag = new CompoundTag();
        Holder<Instrument1_21_2> holder = structuredDataContainer.get(StructuredDataKey.INSTRUMENT1_21_2);
        if (holder != null && holder.isDirect()) {
            compoundTag.put("instrument_description", holder.value().description());
        }
        if ((repairable = structuredDataContainer.get(StructuredDataKey.REPAIRABLE)) != null) {
            compoundTag.put("repairable", this.holderSetToTag(repairable.items()));
        }
        if ((enchantable = structuredDataContainer.get(StructuredDataKey.ENCHANTABLE)) != null) {
            compoundTag.putInt("enchantable", enchantable.value());
        }
        if ((useCooldown = structuredDataContainer.get(StructuredDataKey.USE_COOLDOWN)) != null) {
            object4 = new CompoundTag();
            ((CompoundTag)object4).putFloat("seconds", useCooldown.seconds());
            if (useCooldown.cooldownGroup() != null) {
                ((CompoundTag)object4).putString("cooldown_group", useCooldown.cooldownGroup());
            }
            compoundTag.put("use_cooldown", (Tag)object4);
        }
        if ((object4 = structuredDataContainer.get(StructuredDataKey.ITEM_MODEL)) != null) {
            compoundTag.putString("item_model", ((ItemModel)object4).key().original());
        }
        if ((equippable = structuredDataContainer.get(StructuredDataKey.EQUIPPABLE1_21_2)) != null) {
            object3 = new CompoundTag();
            ((CompoundTag)object3).putInt("equipment_slot", equippable.equipmentSlot());
            this.saveSoundEventHolder((CompoundTag)object3, equippable.soundEvent());
            object2 = equippable.model();
            if (object2 != null) {
                ((CompoundTag)object3).putString("model", (String)object2);
            }
            if ((object = equippable.cameraOverlay()) != null) {
                ((CompoundTag)object3).putString("camera_overlay", (String)object);
            }
            if (equippable.allowedEntities() != null) {
                ((CompoundTag)object3).put("allowed_entities", this.holderSetToTag(equippable.allowedEntities()));
            }
            ((CompoundTag)object3).putBoolean("dispensable", equippable.dispensable());
            ((CompoundTag)object3).putBoolean("swappable", equippable.swappable());
            ((CompoundTag)object3).putBoolean("damage_on_hurt", equippable.damageOnHurt());
            compoundTag.put("equippable", (Tag)object3);
        }
        if ((object3 = structuredDataContainer.get(StructuredDataKey.GLIDER)) != null) {
            compoundTag.putBoolean("glider", true);
        }
        if ((object2 = structuredDataContainer.get(StructuredDataKey.TOOLTIP_STYLE)) != null) {
            compoundTag.putString("tooltip_style", ((Key)object2).original());
        }
        if ((object = structuredDataContainer.get(StructuredDataKey.DEATH_PROTECTION)) != null) {
            ListTag<CompoundTag> listTag = new ListTag<CompoundTag>(CompoundTag.class);
            for (Consumable1_21_2.ConsumeEffect<?> consumeEffect : ((DeathProtection)object).deathEffects()) {
                CompoundTag compoundTag2 = new CompoundTag();
                this.convertConsumableEffect(compoundTag2, consumeEffect);
                listTag.add(compoundTag2);
            }
            compoundTag.put("death_protection", listTag);
        }
        if (!compoundTag.isEmpty()) {
            this.saveTag(this.createCustomTag(item), compoundTag, "inconvertible_data");
        }
    }

    private void convertConsumableEffect(CompoundTag compoundTag, Consumable1_21_2.ConsumeEffect<?> consumeEffect) {
        Object object;
        compoundTag.putInt("id", consumeEffect.id());
        if (consumeEffect.type() == Consumable1_21_2.ApplyStatusEffects.TYPE && (object = consumeEffect.value()) instanceof Consumable1_21_2.ApplyStatusEffects) {
            Consumable1_21_2.ApplyStatusEffects applyStatusEffects = (Consumable1_21_2.ApplyStatusEffects)object;
            compoundTag.putString("type", "apply_effects");
            object = new ListTag<CompoundTag>(CompoundTag.class);
            for (PotionEffect potionEffect : applyStatusEffects.effects()) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.putInt("effect", potionEffect.effect());
                this.convertPotionEffectData(compoundTag2, potionEffect.effectData());
                ((ListTag)object).add((CompoundTag)compoundTag2);
            }
            compoundTag.put("effects", (Tag)object);
            compoundTag.putFloat("probability", applyStatusEffects.probability());
        } else if (consumeEffect.type() == Types.HOLDER_SET && (object = consumeEffect.value()) instanceof HolderSet) {
            HolderSet holderSet = (HolderSet)object;
            compoundTag.putString("type", "remove_effects");
            compoundTag.put("remove_effects", this.holderSetToTag(holderSet));
        } else if (consumeEffect.type() == Types.EMPTY) {
            compoundTag.putString("type", "clear_all_effects");
        } else if (consumeEffect.type() == Types.FLOAT) {
            compoundTag.putString("type", "teleport_randomly");
            compoundTag.putFloat("probability", ((Float)consumeEffect.value()).floatValue());
        } else if (consumeEffect.type() == Types.SOUND_EVENT && (object = consumeEffect.value()) instanceof Holder) {
            Holder holder = (Holder)object;
            compoundTag.putString("type", "play_sound");
            this.saveSoundEventHolder(compoundTag, holder);
        }
    }

    private void convertPotionEffectData(CompoundTag compoundTag, PotionEffectData potionEffectData) {
        compoundTag.putInt("amplifier", potionEffectData.amplifier());
        compoundTag.putInt("duration", potionEffectData.duration());
        compoundTag.putBoolean("ambient", potionEffectData.ambient());
        compoundTag.putBoolean("show_particles", potionEffectData.showParticles());
        compoundTag.putBoolean("show_icon", potionEffectData.showIcon());
        if (potionEffectData.hiddenEffect() != null) {
            CompoundTag compoundTag2 = new CompoundTag();
            this.convertPotionEffectData(compoundTag2, potionEffectData.hiddenEffect());
            compoundTag.put("hidden_effect", compoundTag2);
        }
    }

    private Consumable1_21_2.ConsumeEffect<?> convertConsumableEffect(CompoundTag compoundTag) {
        int n = compoundTag.getInt("id");
        String string = compoundTag.getString("type");
        if ("apply_effects".equals(string)) {
            ListTag<CompoundTag> listTag = compoundTag.getListTag("effects", CompoundTag.class);
            ArrayList<PotionEffect> arrayList = new ArrayList<PotionEffect>();
            for (int i = 0; i < listTag.size(); ++i) {
                CompoundTag compoundTag2 = listTag.get(i);
                int n2 = compoundTag2.getInt("effect");
                PotionEffectData potionEffectData = this.convertPotionEffectData(compoundTag2);
                arrayList.add(new PotionEffect(n2, potionEffectData));
            }
            float f = compoundTag.getFloat("probability");
            return new Consumable1_21_2.ConsumeEffect<Consumable1_21_2.ApplyStatusEffects>(n, Consumable1_21_2.ApplyStatusEffects.TYPE, new Consumable1_21_2.ApplyStatusEffects((PotionEffect[])arrayList.toArray(PotionEffect[]::new), f));
        }
        if ("remove_effects".equals(string)) {
            HolderSet holderSet = this.restoreHolderSet(compoundTag, "remove_effects");
            return new Consumable1_21_2.ConsumeEffect<HolderSet>(n, Types.HOLDER_SET, holderSet);
        }
        if ("clear_all_effects".equals(string)) {
            return new Consumable1_21_2.ConsumeEffect<Unit>(n, Types.EMPTY, Unit.INSTANCE);
        }
        if ("teleport_randomly".equals(string)) {
            float f = compoundTag.getFloat("probability");
            return new Consumable1_21_2.ConsumeEffect<Float>(n, Types.FLOAT, Float.valueOf(f));
        }
        if ("play_sound".equals(string)) {
            Holder<SoundEvent> holder = this.restoreSoundEventHolder(compoundTag);
            return new Consumable1_21_2.ConsumeEffect<Holder<SoundEvent>>(n, Types.SOUND_EVENT, holder);
        }
        return null;
    }

    private PotionEffectData convertPotionEffectData(CompoundTag compoundTag) {
        int n = compoundTag.getInt("amplifier");
        int n2 = compoundTag.getInt("duration");
        boolean bl = compoundTag.getBoolean("ambient");
        boolean bl2 = compoundTag.getBoolean("show_particles");
        boolean bl3 = compoundTag.getBoolean("show_icon");
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("hidden_effect");
        return new PotionEffectData(n, n2, bl, bl2, bl3, compoundTag2 != null ? this.convertPotionEffectData(compoundTag2) : null);
    }

    private void restoreInconvertibleData(Item item) {
        ByteTag byteTag;
        Object object;
        Object object2;
        Object object3;
        String string;
        Object object4;
        Object object5;
        Tag tag;
        Object object6;
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null || !((object6 = compoundTag.remove(this.nbtTagName("inconvertible_data"))) instanceof CompoundTag)) {
            return;
        }
        CompoundTag compoundTag2 = (CompoundTag)object6;
        object6 = structuredDataContainer.get(StructuredDataKey.INSTRUMENT1_21_2);
        if (object6 != null && object6.isDirect() && (tag = compoundTag2.get("instrument_description")) != null) {
            object5 = (Instrument1_21_2)object6.value();
            structuredDataContainer.set(StructuredDataKey.INSTRUMENT1_21_2, Holder.of(new Instrument1_21_2(((Instrument1_21_2)object5).soundEvent(), ((Instrument1_21_2)object5).useDuration(), ((Instrument1_21_2)object5).range(), tag)));
        }
        if (compoundTag2.contains("repairable")) {
            structuredDataContainer.set(StructuredDataKey.REPAIRABLE, new Repairable(this.restoreHolderSet(compoundTag2, "repairable")));
        }
        if ((tag = compoundTag2.getIntTag("enchantable")) != null) {
            structuredDataContainer.set(StructuredDataKey.ENCHANTABLE, new Enchantable(((IntTag)tag).asInt()));
        }
        if ((object5 = compoundTag2.getCompoundTag("use_cooldown")) != null) {
            float f = ((CompoundTag)object5).getFloat("seconds");
            object4 = ((CompoundTag)object5).getString("cooldown_group");
            structuredDataContainer.set(StructuredDataKey.USE_COOLDOWN, new UseCooldown(f, (String)object4));
        }
        if ((string = compoundTag2.getString("item_model")) != null) {
            structuredDataContainer.set(StructuredDataKey.ITEM_MODEL, new ItemModel(Key.of(string)));
        }
        if ((object4 = compoundTag2.getCompoundTag("equippable")) != null) {
            int n = ((CompoundTag)object4).getInt("equipment_slot");
            object3 = this.restoreSoundEventHolder((CompoundTag)object4);
            object2 = ((CompoundTag)object4).getString("model");
            object = ((CompoundTag)object4).getString("camera_overlay");
            HolderSet holderSet = ((CompoundTag)object4).contains("allowed_entities") ? this.restoreHolderSet((CompoundTag)object4, "allowed_entities") : null;
            boolean bl = ((CompoundTag)object4).getBoolean("dispensable");
            boolean bl2 = ((CompoundTag)object4).getBoolean("swappable");
            boolean bl3 = ((CompoundTag)object4).getBoolean("damage_on_hurt");
            structuredDataContainer.set(StructuredDataKey.EQUIPPABLE1_21_2, new Equippable(n, (Holder<SoundEvent>)object3, (String)object2, (String)object, holderSet, bl, bl2, bl3));
        }
        if ((byteTag = compoundTag2.getByteTag("glider")) != null) {
            structuredDataContainer.set(StructuredDataKey.GLIDER, Unit.INSTANCE);
        }
        if ((object3 = compoundTag2.getString("tooltip_style")) != null) {
            structuredDataContainer.set(StructuredDataKey.TOOLTIP_STYLE, Key.of((String)object3));
        }
        if ((object2 = compoundTag2.getListTag("death_protection", CompoundTag.class)) != null) {
            object = new ArrayList();
            for (int i = 0; i < ((ListTag)object2).size(); ++i) {
                Consumable1_21_2.ConsumeEffect<?> consumeEffect = this.convertConsumableEffect((CompoundTag)((ListTag)object2).get(i));
                if (consumeEffect == null) continue;
                object.add(consumeEffect);
            }
            structuredDataContainer.set(StructuredDataKey.DEATH_PROTECTION, new DeathProtection((Consumable1_21_2.ConsumeEffect[])object.toArray(Consumable1_21_2.ConsumeEffect[]::new)));
        }
        this.removeCustomTag(structuredDataContainer, compoundTag);
    }
}

