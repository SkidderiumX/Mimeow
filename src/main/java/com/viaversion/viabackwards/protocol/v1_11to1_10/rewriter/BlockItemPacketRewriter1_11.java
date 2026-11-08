/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_11to1_10.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.data.MappedLegacyBlockItem;
import com.viaversion.viabackwards.api.rewriters.LegacyBlockItemRewriter;
import com.viaversion.viabackwards.api.rewriters.LegacyEnchantmentRewriter;
import com.viaversion.viabackwards.protocol.v1_11to1_10.Protocol1_11To1_10;
import com.viaversion.viabackwards.protocol.v1_11to1_10.storage.ChestedHorseStorage;
import com.viaversion.viabackwards.protocol.v1_11to1_10.storage.WindowTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_11;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_9_3;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.EntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.IdAndData;
import java.util.Arrays;
import java.util.Optional;

public class BlockItemPacketRewriter1_11
extends LegacyBlockItemRewriter<ClientboundPackets1_9_3, ServerboundPackets1_9_3, Protocol1_11To1_10> {
    private LegacyEnchantmentRewriter enchantmentRewriter;

    public BlockItemPacketRewriter1_11(Protocol1_11To1_10 protocol1_11To1_10) {
        super(protocol1_11To1_10, "1.11");
    }

    @Override
    protected void registerPackets() {
        this.registerBlockChange(ClientboundPackets1_9_3.BLOCK_UPDATE);
        this.registerMultiBlockChange(ClientboundPackets1_9_3.CHUNK_BLOCKS_UPDATE);
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.CONTAINER_SET_SLOT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_11.this.handleItemToClient(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
                this.handler(packetWrapper -> {
                    if (BlockItemPacketRewriter1_11.this.isLlama(packetWrapper.user())) {
                        Optional<ChestedHorseStorage> optional = BlockItemPacketRewriter1_11.this.getChestedHorse(packetWrapper.user());
                        if (optional.isEmpty()) {
                            return;
                        }
                        ChestedHorseStorage chestedHorseStorage = optional.get();
                        int n = packetWrapper.get(Types.SHORT, 0).shortValue();
                        n = BlockItemPacketRewriter1_11.this.getNewSlotId(chestedHorseStorage, n);
                        packetWrapper.set(Types.SHORT, 0, Integer.valueOf(n).shortValue());
                        packetWrapper.set(Types.ITEM1_8, 0, BlockItemPacketRewriter1_11.this.getNewItem(chestedHorseStorage, n, packetWrapper.get(Types.ITEM1_8, 0)));
                    }
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.CONTAINER_SET_CONTENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.ITEM1_8_SHORT_ARRAY);
                this.handler(packetWrapper -> {
                    Item[] itemArray = packetWrapper.get(Types.ITEM1_8_SHORT_ARRAY, 0);
                    for (int i = 0; i < itemArray.length; ++i) {
                        itemArray[i] = BlockItemPacketRewriter1_11.this.handleItemToClient(packetWrapper.user(), itemArray[i]);
                    }
                    if (BlockItemPacketRewriter1_11.this.isLlama(packetWrapper.user())) {
                        Optional<ChestedHorseStorage> optional = BlockItemPacketRewriter1_11.this.getChestedHorse(packetWrapper.user());
                        if (optional.isEmpty()) {
                            return;
                        }
                        ChestedHorseStorage chestedHorseStorage = optional.get();
                        itemArray = Arrays.copyOf(itemArray, !chestedHorseStorage.isChested() ? 38 : 53);
                        for (int i = itemArray.length - 1; i >= 0; --i) {
                            itemArray[BlockItemPacketRewriter1_11.this.getNewSlotId((ChestedHorseStorage)chestedHorseStorage, (int)i)] = itemArray[i];
                            itemArray[i] = BlockItemPacketRewriter1_11.this.getNewItem(chestedHorseStorage, i, itemArray[i]);
                        }
                        packetWrapper.set(Types.ITEM1_8_SHORT_ARRAY, 0, itemArray);
                    }
                });
            }
        });
        this.registerSetEquippedItem(ClientboundPackets1_9_3.SET_EQUIPPED_ITEM);
        this.registerCustomPayloadTradeList(ClientboundPackets1_9_3.CUSTOM_PAYLOAD);
        ((Protocol1_11To1_10)this.protocol).registerServerbound(ServerboundPackets1_9_3.CONTAINER_CLICK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.VAR_INT);
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> BlockItemPacketRewriter1_11.this.handleItemToServer(packetWrapper.user(), packetWrapper.get(Types.ITEM1_8, 0)));
                this.handler(packetWrapper -> {
                    if (BlockItemPacketRewriter1_11.this.isLlama(packetWrapper.user())) {
                        Optional<ChestedHorseStorage> optional = BlockItemPacketRewriter1_11.this.getChestedHorse(packetWrapper.user());
                        if (optional.isEmpty()) {
                            return;
                        }
                        ChestedHorseStorage chestedHorseStorage = optional.get();
                        short s = packetWrapper.get(Types.SHORT, 0);
                        int n = BlockItemPacketRewriter1_11.this.getOldSlotId(chestedHorseStorage, s);
                        packetWrapper.set(Types.SHORT, 0, Integer.valueOf(n).shortValue());
                    }
                });
            }
        });
        this.registerSetCreativeModeSlot(ServerboundPackets1_9_3.SET_CREATIVE_MODE_SLOT);
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.LEVEL_CHUNK, packetWrapper -> {
            Object t = packetWrapper.user().getClientWorld(Protocol1_11To1_10.class);
            ChunkType1_9_3 chunkType1_9_3 = ChunkType1_9_3.forEnvironment(((ClientWorld)t).getEnvironment());
            Chunk chunk = packetWrapper.passthrough(chunkType1_9_3);
            this.handleChunk(chunk);
            for (CompoundTag compoundTag : chunk.getBlockEntities()) {
                String string;
                StringTag stringTag = compoundTag.getStringTag("id");
                if (stringTag == null || !(string = stringTag.getValue()).equals("minecraft:sign")) continue;
                stringTag.setValue("Sign");
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.BLOCK_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 10) {
                        packetWrapper.cancel();
                    }
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 1) {
                        CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                        EntityMappings1_11.toClientSpawner(compoundTag, true);
                    }
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.map(Types.COMPONENT);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    int n = -1;
                    if (packetWrapper.get(Types.STRING, 0).equals("EntityHorse")) {
                        n = packetWrapper.passthrough(Types.INT);
                    }
                    ((ComponentRewriterBase)((Protocol1_11To1_10)BlockItemPacketRewriter1_11.this.protocol).getComponentRewriter()).processText(packetWrapper.user(), packetWrapper.get(Types.COMPONENT, 0));
                    String string = packetWrapper.get(Types.STRING, 0);
                    WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
                    windowTracker.setInventory(string);
                    windowTracker.setEntityId(n);
                    if (BlockItemPacketRewriter1_11.this.isLlama(packetWrapper.user())) {
                        packetWrapper.set(Types.UNSIGNED_BYTE, 1, (short)17);
                    }
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.CONTAINER_CLOSE, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
                    windowTracker.setInventory(null);
                    windowTracker.setEntityId(-1);
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerServerbound(ServerboundPackets1_9_3.CONTAINER_CLOSE, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> {
                    WindowTracker windowTracker = packetWrapper.user().get(WindowTracker.class);
                    windowTracker.setInventory(null);
                    windowTracker.setEntityId(-1);
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).getEntityRewriter().filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.dataType().type().equals(Types.ITEM1_8)) {
                entityData.setValue(this.handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.getValue()));
            }
        });
    }

    @Override
    protected void registerRewrites() {
        MappedLegacyBlockItem mappedLegacyBlockItem = this.itemReplacements.computeIfAbsent(IdAndData.toRawData(52), n -> new MappedLegacyBlockItem(52));
        mappedLegacyBlockItem.setBlockEntityHandler((n, compoundTag) -> EntityMappings1_11.toClientSpawner(compoundTag, true));
        this.enchantmentRewriter = new LegacyEnchantmentRewriter(this.nbtTagName());
        this.enchantmentRewriter.registerEnchantment(71, "\u00a7cCurse of Vanishing");
        this.enchantmentRewriter.registerEnchantment(10, "\u00a7cCurse of Binding");
        this.enchantmentRewriter.setHideLevelForEnchants(71, 10);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        super.handleItemToClient(userConnection, item);
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return item;
        }
        EntityMappings1_11.toClientItem(item, true);
        this.enchantmentRewriter.handleToClient(item);
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = (item = super.handleItemToServer(userConnection, item)).tag();
        if (compoundTag == null) {
            return item;
        }
        EntityMappings1_11.toServerItem(item, true);
        this.enchantmentRewriter.handleToServer(item);
        return item;
    }

    private boolean isLlama(UserConnection userConnection) {
        WindowTracker windowTracker = userConnection.get(WindowTracker.class);
        if (windowTracker.getInventory() != null && windowTracker.getInventory().equals("EntityHorse")) {
            Object t = userConnection.getEntityTracker(Protocol1_11To1_10.class);
            TrackedEntity trackedEntity = t.entity(windowTracker.getEntityId());
            return trackedEntity != null && trackedEntity.entityType().is(EntityTypes1_11.EntityType.LLAMA);
        }
        return false;
    }

    private Optional<ChestedHorseStorage> getChestedHorse(UserConnection userConnection) {
        Object t;
        TrackedEntity trackedEntity;
        WindowTracker windowTracker = userConnection.get(WindowTracker.class);
        if (windowTracker.getInventory() != null && windowTracker.getInventory().equals("EntityHorse") && (trackedEntity = (t = userConnection.getEntityTracker(Protocol1_11To1_10.class)).entity(windowTracker.getEntityId())) != null) {
            return Optional.of(trackedEntity.get(ChestedHorseStorage.class));
        }
        return Optional.empty();
    }

    private int getNewSlotId(ChestedHorseStorage chestedHorseStorage, int n) {
        int n2 = !chestedHorseStorage.isChested() ? 38 : 53;
        int n3 = chestedHorseStorage.isChested() ? chestedHorseStorage.getLiamaStrength() : 0;
        int n4 = 2 + 3 * n3;
        int n5 = 15 - 3 * n3;
        if (n >= n4 && n2 > n + n5) {
            return n5 + n;
        }
        if (n == 1) {
            return 0;
        }
        return n;
    }

    private int getOldSlotId(ChestedHorseStorage chestedHorseStorage, int n) {
        int n2 = chestedHorseStorage.isChested() ? chestedHorseStorage.getLiamaStrength() : 0;
        int n3 = 2 + 3 * n2;
        int n4 = 2 + 3 * (chestedHorseStorage.isChested() ? 5 : 0);
        int n5 = n4 - n3;
        if (n == 1 || n >= n3 && n < n4) {
            return 0;
        }
        if (n >= n4) {
            return n - n5;
        }
        if (n == 0) {
            return 1;
        }
        return n;
    }

    private Item getNewItem(ChestedHorseStorage chestedHorseStorage, int n, Item item) {
        int n2 = chestedHorseStorage.isChested() ? chestedHorseStorage.getLiamaStrength() : 0;
        int n3 = 2 + 3 * n2;
        int n4 = 2 + 3 * (chestedHorseStorage.isChested() ? 5 : 0);
        if (n >= n3 && n < n4) {
            return new DataItem(166, 1, 0, this.getNamedTag("\u00a74SLOT DISABLED"));
        }
        if (n == 1) {
            return null;
        }
        return item;
    }
}

