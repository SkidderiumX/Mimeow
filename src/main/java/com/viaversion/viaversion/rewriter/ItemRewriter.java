/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.rewriter.ComponentRewriter;
import com.viaversion.viaversion.api.rewriter.RewriterBase;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.data.item.OriginalHashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.util.Limit;
import com.viaversion.viaversion.util.Rewritable;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends Protocol<C, ?, ?, S>>
extends RewriterBase<T>
implements com.viaversion.viaversion.api.rewriter.ItemRewriter<T> {
    private final Type<Item> itemType;
    private final Type<Item> mappedItemType;
    private final Type<Item[]> itemArrayType;
    private final Type<Item[]> mappedItemArrayType;
    private final Type<Item> itemCostType;
    private final Type<Item> itemTemplateType;
    private final Type<Item> mappedItemTemplateType;
    private final Type<Item> mappedItemCostType;
    private final Type<Item> optionalItemCostType;
    private final Type<Item> mappedOptionalItemCostType;

    public ItemRewriter(T t) {
        super(t);
        VersionedTypesHolder versionedTypesHolder = t.types();
        VersionedTypesHolder versionedTypesHolder2 = t.mappedTypes();
        this.itemType = versionedTypesHolder.item();
        this.itemArrayType = versionedTypesHolder.itemArray();
        this.mappedItemType = versionedTypesHolder2.item();
        this.mappedItemArrayType = versionedTypesHolder2.itemArray();
        this.itemTemplateType = versionedTypesHolder.itemTemplate();
        this.mappedItemTemplateType = versionedTypesHolder2.itemTemplate();
        this.itemCostType = versionedTypesHolder.itemCost();
        this.mappedItemCostType = versionedTypesHolder2.itemCost();
        this.optionalItemCostType = versionedTypesHolder.optionalItemCost();
        this.mappedOptionalItemCostType = versionedTypesHolder2.optionalItemCost();
    }

    public ItemRewriter(T t, Type<Item> type, Type<Item[]> type2, Type<Item> type3, Type<Item[]> type4) {
        super(t);
        this.itemType = type;
        this.itemArrayType = type2;
        this.mappedItemType = type3;
        this.mappedItemArrayType = type4;
        this.itemTemplateType = null;
        this.mappedItemTemplateType = null;
        this.itemCostType = null;
        this.mappedItemCostType = null;
        this.optionalItemCostType = null;
        this.mappedOptionalItemCostType = null;
    }

    public ItemRewriter(T t, Type<Item> type, Type<Item[]> type2) {
        this(t, type, type2, type, type2);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (this.protocol.getMappingData() != null && !Mappings.isIntIdIdentity(this.protocol.getMappingData().getItemMappings())) {
            item.setIdentifier(this.protocol.getMappingData().getNewItemId(item.identifier()));
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        if (item == null) {
            return null;
        }
        if (this.protocol.getMappingData() != null && !Mappings.isIntIdIdentity(this.protocol.getMappingData().getItemMappings())) {
            item.setIdentifier(this.protocol.getMappingData().getOldItemId(item.identifier()));
        }
        return item;
    }

    @Override
    public HashedItem handleHashedItem(UserConnection userConnection, HashedItem hashedItem) {
        if (hashedItem instanceof OriginalHashedItem) {
            OriginalHashedItem originalHashedItem = (OriginalHashedItem)hashedItem;
            return originalHashedItem.backupTagName().equals(this.nbtTagName()) ? originalHashedItem.asRegularItem() : hashedItem;
        }
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null) {
            return hashedItem;
        }
        FullMappings fullMappings = mappingData.getDataComponentSerializerMappings();
        if (fullMappings != null) {
            if (!fullMappings.isIdentity()) {
                this.updateHashedItemDataComponentIds(hashedItem, fullMappings.inverse());
            }
            int n = fullMappings.id("custom_data");
            if (hashedItem.dataHashesById().containsKey(n)) {
                int n2 = hashedItem.dataHashesById().get(n);
                ItemHasherBase itemHasherBase = (ItemHasherBase)this.itemHasher(userConnection);
                OriginalHashedItem originalHashedItem = itemHasherBase.originalHashedItem(n2, hashedItem);
                if (originalHashedItem != null) {
                    return originalHashedItem.backupTagName().equals(this.nbtTagName()) ? originalHashedItem.asRegularItem() : originalHashedItem;
                }
            }
        }
        if (mappingData.getItemMappings() != null) {
            hashedItem.setIdentifier(mappingData.getOldItemId(hashedItem.identifier()));
        }
        return hashedItem;
    }

    public void registerSetContent(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            Item[] itemArray = packetWrapper.passthroughAndMap(this.itemArrayType, this.mappedItemArrayType);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClient(packetWrapper.user(), itemArray[i]);
            }
        });
    }

    public void registerSetContent1_17_1(C c) {
        this.registerSetContent1_17_1(c, Types.UNSIGNED_BYTE);
    }

    public void registerSetContent1_21_2(C c) {
        this.registerSetContent1_17_1(c, Types.VAR_INT);
    }

    private void registerSetContent1_17_1(C c, Type<? extends Number> type) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(type);
            packetWrapper.passthrough(Types.VAR_INT);
            Item[] itemArray = packetWrapper.passthroughAndMap(this.itemArrayType, this.mappedItemArrayType);
            for (int i = 0; i < itemArray.length; ++i) {
                itemArray[i] = this.handleItemToClientAndTrackHash(packetWrapper.user(), itemArray[i]);
            }
            this.passthroughClientboundItemAndTrackHash(packetWrapper);
        });
    }

    public void registerOpenScreen(C c) {
        if ((this.protocol.getMappingData() == null || Mappings.isIntIdIdentity(this.protocol.getMappingData().getMenuMappings())) && this.protocol.getComponentRewriter() == null) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.read(Types.VAR_INT);
            if (this.protocol.getMappingData() != null && this.protocol.getMappingData().getMenuMappings() != null && (n = this.protocol.getMappingData().getMenuMappings().getNewId(n)) == -1) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.write(Types.VAR_INT, n);
            if (this.protocol.getComponentRewriter() != null) {
                this.protocol.getComponentRewriter().passthroughAndProcess(packetWrapper);
            }
        });
    }

    public void registerSetSlot(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.SHORT);
            this.passthroughClientboundItem(packetWrapper);
        });
    }

    public void registerSetSlot1_17_1(C c) {
        this.registerSetSlot1_17_1(c, Types.BYTE);
    }

    public void registerSetSlot1_21_2(C c) {
        this.registerSetSlot1_17_1(c, Types.VAR_INT);
    }

    private void registerSetSlot1_17_1(C c, Type<? extends Number> type) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(type);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            this.passthroughClientboundItemAndTrackHash(packetWrapper);
        });
    }

    public void registerSetEquippedItem(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            this.passthroughClientboundItem(packetWrapper);
        });
    }

    public void registerSetEquipment(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            byte by;
            packetWrapper.passthrough(Types.VAR_INT);
            do {
                by = packetWrapper.passthrough(Types.BYTE);
                this.passthroughClientboundItem(packetWrapper);
            } while (by < 0);
        });
    }

    public void registerSetCreativeModeSlot(S s) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.write(this.itemType, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType)));
        });
    }

    public void registerSetCreativeModeSlot1_20_5(S s) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            if (this.protocol.getEntityRewriter() != null && !this.protocol.getEntityRewriter().tracker(packetWrapper.user()).canInstaBuild()) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.write(this.itemType, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType)));
        });
    }

    public void registerContainerClick(S s) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(this.itemType, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType)));
        });
    }

    public void registerContainerClick1_17_1(S s) {
        this.registerContainerClick1_17_1(s, Types.BYTE);
    }

    public void registerContainerClick1_21_2(S s) {
        this.registerContainerClick1_17_1(s, Types.VAR_INT);
    }

    public void registerContainerClick1_17_1(S s, Type<? extends Number> type) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            packetWrapper.passthrough(type);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                packetWrapper.write(this.itemType, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType)));
            }
            packetWrapper.write(this.itemType, this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.mappedItemType)));
        });
    }

    public void registerContainerClick1_21_5(S s) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.SHORT);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.VAR_INT);
            int n = Limit.max(packetWrapper.passthrough(Types.VAR_INT), 128);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.SHORT);
                this.passthroughHashedItem(packetWrapper);
            }
            this.passthroughHashedItem(packetWrapper);
        });
    }

    public void registerSetPlayerInventory(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.passthroughClientboundItemAndTrackHash(packetWrapper);
        });
    }

    public void registerCooldown(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isIntIdIdentity(this.protocol.getMappingData().getItemMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, this.protocol.getMappingData().getNewItemId(n));
        });
    }

    public void registerCooldown1_21_2(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isFullIdentity(this.protocol.getMappingData().getFullItemMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            String string = packetWrapper.read(Types.STRING);
            if (string != null) {
                string = Rewritable.mappedIdentifier(this.protocol.getMappingData().getFullItemMappings(), string);
            }
            packetWrapper.write(Types.STRING, string);
        });
    }

    public void registerCustomPayloadTradeList(C c) {
        this.protocol.registerClientbound(c, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.STRING);
                this.handlerSoftFail(packetWrapper -> {
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (string.equals("MC|TrList")) {
                        ItemRewriter.this.handleTradeList(packetWrapper);
                    }
                });
            }
        });
    }

    public void handleTradeList(PacketWrapper packetWrapper) {
        packetWrapper.passthrough(Types.INT);
        int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
        for (int i = 0; i < n; ++i) {
            this.passthroughClientboundItem(packetWrapper);
            this.passthroughClientboundItem(packetWrapper);
            if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                this.passthroughClientboundItem(packetWrapper);
            }
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.INT);
            packetWrapper.passthrough(Types.INT);
        }
    }

    public void registerMerchantOffers1_14_4(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.UNSIGNED_BYTE).shortValue();
            for (int i = 0; i < n; ++i) {
                this.passthroughClientboundItem(packetWrapper);
                this.passthroughClientboundItem(packetWrapper);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    this.passthroughClientboundItem(packetWrapper);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.INT);
            }
        });
    }

    public void registerMerchantOffers1_19(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                this.passthroughClientboundItem(packetWrapper);
                this.passthroughClientboundItem(packetWrapper);
                this.passthroughClientboundItem(packetWrapper);
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.INT);
            }
        });
    }

    public void registerMerchantOffers1_20_5(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                Item item = packetWrapper.read(this.itemCostType);
                packetWrapper.write(this.mappedItemCostType, this.handleItemToClientAndTrackHash(packetWrapper.user(), item));
                this.passthroughClientboundItem(packetWrapper);
                Item item2 = packetWrapper.read(this.optionalItemCostType);
                if (item2 != null) {
                    this.handleItemToClientAndTrackHash(packetWrapper.user(), item2);
                }
                packetWrapper.write(this.mappedOptionalItemCostType, item2);
                packetWrapper.passthrough(Types.BOOLEAN);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.INT);
                packetWrapper.passthrough(Types.FLOAT);
                packetWrapper.passthrough(Types.INT);
            }
        });
    }

    public void registerAdvancements(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
                    JsonElement jsonElement2 = packetWrapper.passthrough(Types.COMPONENT);
                    ComponentRewriter componentRewriter = this.protocol.getComponentRewriter();
                    if (componentRewriter != null) {
                        componentRewriter.processText(packetWrapper.user(), jsonElement);
                        componentRewriter.processText(packetWrapper.user(), jsonElement2);
                    }
                    this.passthroughClientboundItem(packetWrapper);
                    packetWrapper.passthrough(Types.VAR_INT);
                    int n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.STRING_ARRAY);
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n3; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
            }
        });
    }

    public void registerAdvancements1_20_3(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.BOOLEAN);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            for (int i = 0; i < n; ++i) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.passthrough(Types.OPTIONAL_STRING);
                if (packetWrapper.passthrough(Types.BOOLEAN).booleanValue()) {
                    Tag tag = packetWrapper.passthrough(Types.TRUSTED_TAG);
                    Tag tag2 = packetWrapper.passthrough(Types.TRUSTED_TAG);
                    ComponentRewriter componentRewriter = this.protocol.getComponentRewriter();
                    if (componentRewriter != null) {
                        componentRewriter.processTag(packetWrapper.user(), tag);
                        componentRewriter.processTag(packetWrapper.user(), tag2);
                    }
                    this.passthroughClientboundItemTemplate(packetWrapper);
                    packetWrapper.passthrough(Types.VAR_INT);
                    int n2 = packetWrapper.passthrough(Types.INT);
                    if ((n2 & 1) != 0) {
                        packetWrapper.passthrough(Types.STRING);
                    }
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                int n3 = packetWrapper.passthrough(Types.VAR_INT);
                for (int j = 0; j < n3; ++j) {
                    packetWrapper.passthrough(Types.STRING_ARRAY);
                }
                packetWrapper.passthrough(Types.BOOLEAN);
            }
        });
    }

    public void registerSetCursorItem(C c) {
        this.protocol.registerClientbound(c, this::passthroughClientboundItemAndTrackHash);
    }

    public void registerContainerSetData(C c) {
        if (this.protocol.getMappingData() == null || Mappings.isIntIdIdentity(this.protocol.getMappingData().getEnchantmentMappings())) {
            return;
        }
        this.protocol.registerClientbound(c, packetWrapper -> {
            packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            short s = packetWrapper.passthrough(Types.SHORT);
            if (s >= 4 && s <= 6) {
                short s2 = (short)this.protocol.getMappingData().getEnchantmentMappings().getNewId(packetWrapper.read(Types.SHORT).shortValue());
                packetWrapper.write(Types.SHORT, s2);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected @Nullable Item handleItemToClientAndTrackHash(UserConnection userConnection, @Nullable Item item) {
        T t = this.itemHasher(userConnection);
        if (t == null) {
            return this.handleItemToClient(userConnection, item);
        }
        t.setProcessingClientboundInventoryPacket(true);
        try {
            Item item2 = this.handleItemToClient(userConnection, item);
            return item2;
        }
        finally {
            t.setProcessingClientboundInventoryPacket(false);
        }
    }

    protected void passthroughClientboundItemAndTrackHash(PacketWrapper packetWrapper) {
        T t = this.itemHasher(packetWrapper.user());
        if (t == null) {
            this.passthroughClientboundItem(packetWrapper);
            return;
        }
        t.setProcessingClientboundInventoryPacket(true);
        try {
            this.passthroughClientboundItem(packetWrapper);
        }
        finally {
            t.setProcessingClientboundInventoryPacket(false);
        }
    }

    protected void passthroughClientboundItem(PacketWrapper packetWrapper) {
        Item item = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(this.itemType));
        packetWrapper.write(this.mappedItemType, item);
    }

    protected void passthroughClientboundItemTemplate(PacketWrapper packetWrapper) {
        Item item = this.handleItemToClient(packetWrapper.user(), packetWrapper.read(this.itemTemplateType()));
        packetWrapper.write(this.mappedItemTemplateType(), item);
    }

    protected void passthroughHashedItem(PacketWrapper packetWrapper) {
        HashedItem hashedItem = this.handleHashedItem(packetWrapper.user(), packetWrapper.read(Types.HASHED_ITEM));
        packetWrapper.write(Types.HASHED_ITEM, hashedItem);
    }

    protected <T extends ItemHasher> @Nullable T itemHasher(UserConnection userConnection) {
        return userConnection.getItemHasher(this.protocol.getClass());
    }

    protected void updateHashedItemDataComponentIds(HashedItem hashedItem, FullMappings fullMappings) {
        int n;
        Object object;
        Int2IntMap int2IntMap = hashedItem.dataHashesById();
        if (!int2IntMap.isEmpty()) {
            object = int2IntMap.keySet().toIntArray();
            int n2 = ((Object)object).length;
            for (int i = 0; i < n2; ++i) {
                Object object2 = object[i];
                int n3 = fullMappings.getNewId((int)object2);
                if (n3 == object2) continue;
                n = int2IntMap.remove((int)object2);
                if (n3 == -1) continue;
                int2IntMap.put(n3, n);
            }
        }
        if (!(object = hashedItem.removedDataIds()).isEmpty()) {
            for (int n3 : object.toIntArray()) {
                n = fullMappings.getNewId(n3);
                if (n == n3) continue;
                object.remove(n3);
                if (n == -1) continue;
                object.add(n);
            }
        }
    }

    @Override
    public Type<Item> itemType() {
        return this.itemType;
    }

    @Override
    public Type<Item[]> itemArrayType() {
        return this.itemArrayType;
    }

    @Override
    public Type<Item> mappedItemType() {
        return this.mappedItemType;
    }

    @Override
    public Type<Item[]> mappedItemArrayType() {
        return this.mappedItemArrayType;
    }

    @Override
    public Type<Item> itemTemplateType() {
        return this.itemTemplateType;
    }

    @Override
    public Type<Item> mappedItemTemplateType() {
        return this.mappedItemTemplateType;
    }
}

