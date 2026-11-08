/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.rewriter;

import com.google.common.base.Preconditions;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.FullMappings;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataContainer;
import com.viaversion.viaversion.api.minecraft.data.StructuredDataKey;
import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.data.FilterableComponent;
import com.viaversion.viaversion.api.minecraft.item.data.WrittenBook;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypesHolder;
import com.viaversion.viaversion.data.item.ItemHasherBase;
import com.viaversion.viaversion.data.item.OriginalHashedItem;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.util.Rewritable;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class StructuredItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends Protocol<C, ?, ?, S>>
extends ItemRewriter<C, S, T> {
    public static final String MARKER_KEY = "VV|custom_data";
    protected static final String ORIGINAL_HASHES_KEY = "VV|original_hashes";

    public StructuredItemRewriter(T t) {
        super(t);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        MappingData mappingData;
        if (Item.isEmpty(item)) {
            return item;
        }
        ItemHasherBase itemHasherBase = (ItemHasherBase)this.itemHasher(userConnection);
        HashedItem hashedItem = this.hashItemIfNeeded(userConnection, item, itemHasherBase);
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        this.updateItemDataComponentTypeIds(structuredDataContainer, true);
        CompoundTag compoundTag = new CompoundTag();
        this.backupInconvertibleData(userConnection, item, structuredDataContainer, compoundTag);
        if (!compoundTag.isEmpty()) {
            this.saveTag(this.createCustomTag(item), compoundTag, "backup");
        }
        if ((mappingData = this.protocol.getMappingData()) != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getNewItemId(item.identifier()));
        }
        this.handleRewritablesToClient(userConnection, structuredDataContainer, itemHasherBase);
        this.handleItemDataComponentsToClient(userConnection, item, structuredDataContainer);
        if (hashedItem != null) {
            this.storeOriginalHashedItemIfNeeded(userConnection, item, itemHasherBase, hashedItem);
        }
        return item;
    }

    protected @Nullable HashedItem hashItemIfNeeded(UserConnection userConnection, Item item, @Nullable ItemHasherBase itemHasherBase) {
        CompoundTag compoundTag;
        if (itemHasherBase == null || !itemHasherBase.isProcessingClientboundInventoryPacket()) {
            return null;
        }
        CompoundTag compoundTag2 = item.dataContainer().get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag2 != null && (compoundTag = compoundTag2.getCompoundTag(ORIGINAL_HASHES_KEY)) != null) {
            if (this.isFirstServerbound(userConnection)) {
                return this.backedUpOriginalHashes(compoundTag, item);
            }
            return null;
        }
        return itemHasherBase.toHashedItem(item, false);
    }

    protected void storeOriginalHashedItemIfNeeded(UserConnection userConnection, Item item, ItemHasherBase itemHasherBase, HashedItem hashedItem) {
        if (hashedItem == null || hashedItem.dataHashesById().isEmpty() && hashedItem.removedDataIds().isEmpty()) {
            return;
        }
        if (hashedItem instanceof OriginalHashedItem) {
            OriginalHashedItem originalHashedItem = (OriginalHashedItem)hashedItem;
            itemHasherBase.trackOriginalHashedItem(item.dataContainer().get(StructuredDataKey.CUSTOM_DATA), hashedItem, originalHashedItem.backupTagName());
            return;
        }
        HashedItem hashedItem2 = itemHasherBase.toHashedItem(item, true);
        this.normalizeHashedItemToServer(hashedItem2);
        if (hashedItem2.dataHashesById().equals(hashedItem.dataHashesById()) && hashedItem2.removedDataIds().equals(hashedItem.removedDataIds())) {
            return;
        }
        this.storeOriginalHashedItemInTag(userConnection, item, itemHasherBase, hashedItem);
    }

    protected void storeOriginalHashedItemInTag(UserConnection userConnection, Item item, ItemHasherBase itemHasherBase, HashedItem hashedItem) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putInt("id", hashedItem.identifier());
        compoundTag.putString("backup_tag", this.nbtTagName());
        for (Int2IntMap.Entry entry : hashedItem.dataHashesById().int2IntEntrySet()) {
            compoundTag.putInt(Integer.toString(entry.getIntKey()), entry.getIntValue());
        }
        compoundTag.put("removed", new IntArrayTag(hashedItem.removedDataIds().toIntArray()));
        CompoundTag compoundTag2 = this.createCustomTag(item);
        compoundTag2.put(ORIGINAL_HASHES_KEY, compoundTag);
        if (this.isFirstServerbound(userConnection)) {
            itemHasherBase.trackOriginalHashedItem(compoundTag2, hashedItem, this.nbtTagName());
        }
    }

    private void normalizeHashedItemToServer(HashedItem hashedItem) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null || Mappings.isIntIdIdentity(mappingData.getDataComponentSerializerMappings())) {
            return;
        }
        this.updateHashedItemDataComponentIds(hashedItem, mappingData.getDataComponentSerializerMappings().inverse());
    }

    protected boolean isFirstServerbound(UserConnection userConnection) {
        for (Protocol protocol : userConnection.getProtocolInfo().getPipeline().pipes()) {
            if (!(userConnection.getItemHasher(protocol.getClass()) instanceof ItemHasherBase)) continue;
            return protocol.getClass() == this.protocol.getClass();
        }
        return false;
    }

    protected @Nullable OriginalHashedItem backedUpOriginalHashes(CompoundTag compoundTag, Item item) {
        IntTag intTag = compoundTag.getIntTag("id");
        String string = compoundTag.getString("backup_tag");
        if (intTag == null || string == null) {
            return null;
        }
        OriginalHashedItem originalHashedItem = new OriginalHashedItem(intTag.asInt(), item.amount(), string);
        try {
            for (Map.Entry<String, Tag> entry : compoundTag.entrySet()) {
                Object object = entry.getValue();
                if (!(object instanceof IntTag)) continue;
                IntTag intTag2 = (IntTag)object;
                object = (String)entry.getKey();
                if (((String)object).equals("id")) continue;
                originalHashedItem.dataHashesById().put(Integer.parseInt((String)object), intTag2.asInt());
            }
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        IntArrayTag intArrayTag = compoundTag.getIntArrayTag("removed");
        if (intArrayTag != null) {
            for (Object object : (Map.Entry<String, Tag>)intArrayTag.getValue()) {
                originalHashedItem.removedDataIds().add((int)object);
            }
        }
        return originalHashedItem;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (Item.isEmpty(item)) {
            return item;
        }
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData != null && mappingData.getItemMappings() != null) {
            item.setIdentifier(mappingData.getOldItemId(item.identifier()));
        }
        this.updateItemDataComponentTypeIds(item.dataContainer(), false);
        this.handleRewritablesToServer(userConnection, item.dataContainer());
        this.restoreBackupData(item);
        this.handleItemDataComponentsToServer(userConnection, item, item.dataContainer());
        return item;
    }

    protected void updateItemDataComponentTypeIds(StructuredDataContainer structuredDataContainer, boolean bl) {
        MappingData mappingData = this.protocol.getMappingData();
        if (mappingData == null) {
            return;
        }
        FullMappings fullMappings = mappingData.getDataComponentSerializerMappings();
        if (fullMappings == null) {
            return;
        }
        if (!bl) {
            fullMappings = fullMappings.inverse();
        }
        structuredDataContainer.setIdLookup(this.protocol, bl);
        structuredDataContainer.updateIds(this.protocol, fullMappings::getNewId);
    }

    protected void handleItemDataComponentsToClient(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        if (this.protocol.getComponentRewriter() != null) {
            Object object;
            this.updateTextComponent(userConnection, item, StructuredDataKey.ITEM_NAME, "item_name");
            this.updateTextComponent(userConnection, item, StructuredDataKey.CUSTOM_NAME, "custom_name");
            Tag[] tagArray = structuredDataContainer.get(StructuredDataKey.LORE);
            if (tagArray != null) {
                object = tagArray;
                int n = ((Tag[])object).length;
                for (int i = 0; i < n; ++i) {
                    Object object2 = object[i];
                    this.protocol.getComponentRewriter().processTag(userConnection, (Tag)object2);
                }
            }
            if ((object = structuredDataContainer.get(StructuredDataKey.WRITTEN_BOOK_CONTENT)) != null) {
                for (FilterableComponent filterableComponent : ((WrittenBook)object).pages()) {
                    this.protocol.getComponentRewriter().processTag(userConnection, (Tag)filterableComponent.raw());
                    if (!filterableComponent.isFiltered()) continue;
                    this.protocol.getComponentRewriter().processTag(userConnection, (Tag)filterableComponent.filtered());
                }
            }
        }
        this.replaceAnnoyingKeys(structuredDataContainer, this.protocol.types(), this.protocol.mappedTypes());
    }

    protected void handleItemDataComponentsToServer(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer) {
        this.replaceAnnoyingKeys(structuredDataContainer, this.protocol.mappedTypes(), this.protocol.types());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void handleRewritablesToClient(UserConnection userConnection, StructuredDataContainer structuredDataContainer, @Nullable ItemHasher itemHasher) {
        if (itemHasher == null || !itemHasher.isProcessingClientboundInventoryPacket()) {
            this.handleRewritables(userConnection, true, structuredDataContainer, this::handleItemToClient);
            return;
        }
        itemHasher.setProcessingClientboundInventoryPacket(false);
        try {
            this.handleRewritables(userConnection, true, structuredDataContainer, this::handleItemToClient);
        }
        finally {
            itemHasher.setProcessingClientboundInventoryPacket(true);
        }
    }

    protected void handleRewritablesToServer(UserConnection userConnection, StructuredDataContainer structuredDataContainer) {
        this.handleRewritables(userConnection, false, structuredDataContainer, this::handleItemToServer);
    }

    private void handleRewritables(UserConnection userConnection, boolean bl, StructuredDataContainer structuredDataContainer, ItemHandler itemHandler) {
        for (StructuredData<?> structuredData : structuredDataContainer.data().values()) {
            StructuredData<?> structuredData2;
            if (structuredData.isEmpty()) continue;
            Object obj = structuredData.value();
            if (obj instanceof Item) {
                Item item = (Item)obj;
                structuredData2 = structuredData;
                structuredData2.setValue(itemHandler.rewrite(userConnection, item));
                continue;
            }
            if (obj instanceof Item[]) {
                Item[] itemArray = (Item[])obj;
                for (int i = 0; i < itemArray.length; ++i) {
                    itemArray[i] = itemHandler.rewrite(userConnection, itemArray[i]);
                }
                continue;
            }
            if (obj instanceof Rewritable) {
                Rewritable rewritable = (Rewritable)obj;
                this.setDataUnchecked(structuredData, rewritable.rewrite(userConnection, this.protocol, bl));
                continue;
            }
            if (obj instanceof Holder) {
                Holder holder = (Holder)obj;
                structuredData2 = structuredData;
                if (!holder.isDirect() || !(holder.value() instanceof Rewritable)) continue;
                structuredData2.setValue(this.updateHolderUnchecked(holder, userConnection, bl));
                continue;
            }
            if (!(obj instanceof EitherHolder)) continue;
            EitherHolder eitherHolder = (EitherHolder)obj;
            structuredData2 = structuredData;
            if (!eitherHolder.hasHolder() || !eitherHolder.holder().isDirect() || !(eitherHolder.holder().value() instanceof Rewritable)) continue;
            structuredData2.setValue(EitherHolder.of(this.updateHolderUnchecked(eitherHolder.holder(), userConnection, bl)));
        }
    }

    private <V> void setDataUnchecked(StructuredData<V> structuredData, Object object) {
        structuredData.setValue(object);
    }

    private <V> Holder<V> updateHolderUnchecked(Holder<V> holder, UserConnection userConnection, boolean bl) {
        return holder.updateValue(object -> {
            Object object2;
            if (object instanceof Rewritable) {
                Rewritable rewritable = (Rewritable)object;
                object2 = rewritable.rewrite(userConnection, this.protocol, bl);
            } else {
                object2 = object;
            }
            return object2;
        });
    }

    protected void updateTextComponent(UserConnection userConnection, Item item, StructuredDataKey<Tag> structuredDataKey, String string) {
        Tag tag = item.dataContainer().get(structuredDataKey);
        if (!(tag instanceof CompoundTag) && !(tag instanceof ListTag)) {
            return;
        }
        Tag tag2 = tag.copy();
        this.protocol.getComponentRewriter().processTag(userConnection, tag);
        if (!tag.equals(tag2)) {
            this.saveTag(this.createCustomTag(item), tag2, string);
        }
    }

    protected void restoreBackupData(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag != null) {
            this.restoreBackupData(item, structuredDataContainer, compoundTag);
            this.removeCustomTag(structuredDataContainer, compoundTag);
        }
    }

    protected void backupInconvertibleData(UserConnection userConnection, Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
    }

    protected void restoreBackupData(Item item, StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        compoundTag.remove(ORIGINAL_HASHES_KEY);
        if (this.removeBackupTag(compoundTag, "added_custom_name") != null) {
            structuredDataContainer.remove(StructuredDataKey.CUSTOM_NAME);
        } else {
            Tag tag;
            Tag tag2 = this.removeBackupTag(compoundTag, "custom_name");
            if (tag2 != null) {
                structuredDataContainer.set(StructuredDataKey.CUSTOM_NAME, tag2);
            }
            if ((tag = this.removeBackupTag(compoundTag, "item_name")) != null) {
                structuredDataContainer.set(StructuredDataKey.ITEM_NAME, tag);
            }
        }
    }

    protected CompoundTag createCustomTag(Item item) {
        StructuredDataContainer structuredDataContainer = item.dataContainer();
        CompoundTag compoundTag = structuredDataContainer.get(StructuredDataKey.CUSTOM_DATA);
        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            compoundTag.putBoolean(MARKER_KEY, true);
            structuredDataContainer.set(StructuredDataKey.CUSTOM_DATA, compoundTag);
        }
        return compoundTag;
    }

    protected void saveTag(CompoundTag compoundTag, Tag tag, String string) {
        String string2 = this.nbtTagName(string);
        if (!compoundTag.contains(string2)) {
            compoundTag.put(string2, tag);
        }
    }

    protected @Nullable Tag removeBackupTag(CompoundTag compoundTag, String string) {
        return compoundTag.remove(this.nbtTagName(string));
    }

    protected void removeCustomTag(StructuredDataContainer structuredDataContainer, CompoundTag compoundTag) {
        if (compoundTag.size() == 1 && compoundTag.contains(MARKER_KEY)) {
            structuredDataContainer.remove(StructuredDataKey.CUSTOM_DATA);
        }
    }

    protected void passthroughLengthPrefixedItem(PacketWrapper packetWrapper) {
        Item item = this.handleItemToServer(packetWrapper.user(), packetWrapper.read(this.protocol.mappedTypes().lengthPrefixedItem()));
        packetWrapper.write(this.protocol.types().lengthPrefixedItem(), item);
    }

    private void replaceAnnoyingKeys(StructuredDataContainer structuredDataContainer, VersionedTypesHolder versionedTypesHolder, VersionedTypesHolder versionedTypesHolder2) {
        List<StructuredDataKey<?>> list = versionedTypesHolder.structuredDataKeys().keys();
        List<StructuredDataKey<?>> list2 = versionedTypesHolder2.structuredDataKeys().keys();
        int n = Math.min(list.size(), list2.size());
        for (int i = 0; i < n; ++i) {
            StructuredDataKey<?> structuredDataKey = list.get(i);
            StructuredDataKey<?> structuredDataKey2 = list2.get(i);
            StructuredItemRewriter.replaceKeyUnchecked(structuredDataContainer, structuredDataKey, structuredDataKey2);
        }
    }

    private static <T> void replaceKeyUnchecked(StructuredDataContainer structuredDataContainer, StructuredDataKey<T> structuredDataKey, StructuredDataKey<?> structuredDataKey2) {
        Preconditions.checkArgument(structuredDataKey.type().getOutputClass() == structuredDataKey2.type().getOutputClass(), "Type mismatch: %s vs %s", structuredDataKey, structuredDataKey2);
        structuredDataContainer.replaceKey(structuredDataKey, structuredDataKey2);
    }

    public void registerSetCreativeModeSlot1_21_5(S s) {
        this.protocol.registerServerbound(s, packetWrapper -> {
            if (!this.protocol.getEntityRewriter().tracker(packetWrapper.user()).canInstaBuild()) {
                packetWrapper.cancel();
                return;
            }
            packetWrapper.passthrough(Types.SHORT);
            this.passthroughLengthPrefixedItem(packetWrapper);
        });
    }

    public void registerShowDialog(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            Holder holder = (Holder)((Object)packetWrapper.passthrough(Types.TRUSTED_COMPOUND_TAG_HOLDER));
            if (holder.isDirect()) {
                this.protocol.getRegistryDataRewriter().updateDialog(packetWrapper.user(), (CompoundTag)holder.value());
            }
        });
    }

    public void registerShowDialogDirect(C c) {
        this.protocol.registerClientbound(c, packetWrapper -> {
            CompoundTag compoundTag = packetWrapper.passthrough(Types.TRUSTED_COMPOUND_TAG);
            this.protocol.getRegistryDataRewriter().updateDialog(packetWrapper.user(), compoundTag);
        });
    }

    @FunctionalInterface
    private static interface ItemHandler {
        public Item rewrite(UserConnection var1, Item var2);
    }
}

