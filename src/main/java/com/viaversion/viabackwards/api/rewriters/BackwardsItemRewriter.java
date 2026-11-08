/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.rewriters;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.MappedItem;
import com.viaversion.viabackwards.api.rewriters.BackwardsItemRewriterBase;
import com.viaversion.viabackwards.item.DataItemWithExtras;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.libs.gson.JsonElement;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BackwardsItemRewriter<C extends ClientboundPacketType, S extends ServerboundPacketType, T extends BackwardsProtocol<C, ?, ?, S>>
extends BackwardsItemRewriterBase<C, S, T> {
    public BackwardsItemRewriter(T t, Type<Item> type, Type<Item[]> type2) {
        super(t, type, type2, true);
    }

    public BackwardsItemRewriter(T t, Type<Item> type, Type<Item[]> type2, Type<Item> type3, Type<Item[]> type4) {
        super(t, type, type2, type3, type4, true);
    }

    @Override
    public @Nullable Item handleItemToClient(UserConnection userConnection, @Nullable Item item) {
        DataItemWithExtras dataItemWithExtras;
        CompoundTag compoundTag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag2 = compoundTag = item.tag() != null ? item.tag().getCompoundTag("display") : null;
        if (((BackwardsProtocol)this.protocol).getComponentRewriter() != null && compoundTag != null) {
            Object object;
            if (item instanceof DataItemWithExtras) {
                dataItemWithExtras = (DataItemWithExtras)item;
            } else {
                dataItemWithExtras = new DataItemWithExtras(item);
                item = dataItemWithExtras;
            }
            JsonElement jsonElement = dataItemWithExtras.name();
            if (jsonElement != null) {
                object = jsonElement.deepCopy();
                ((BackwardsProtocol)this.protocol).getComponentRewriter().processText(userConnection, (JsonElement)object);
                if (!object.equals(jsonElement)) {
                    StringTag stringTag = dataItemWithExtras.rawName();
                    this.saveStringTag(compoundTag, stringTag, "Name");
                    stringTag.setValue(((JsonElement)object).toString());
                }
            }
            if ((object = dataItemWithExtras.lore()) != null) {
                boolean bl = false;
                ListTag<StringTag> listTag = dataItemWithExtras.rawLore();
                for (int i = 0; i < object.size(); ++i) {
                    JsonElement jsonElement2 = (JsonElement)object.get(i);
                    JsonElement jsonElement3 = jsonElement2.deepCopy();
                    ((BackwardsProtocol)this.protocol).getComponentRewriter().processText(userConnection, jsonElement3);
                    if (jsonElement3.equals(jsonElement2)) continue;
                    if (!bl) {
                        bl = true;
                        this.saveListTag(compoundTag, listTag, "Lore");
                    }
                    StringTag stringTag = listTag.get(i);
                    stringTag.setValue(jsonElement3.toString());
                }
            }
        }
        DataItemWithExtras dataItemWithExtras2 = dataItemWithExtras = ((BackwardsProtocol)this.protocol).getMappingData() != null ? ((BackwardsProtocol)this.protocol).getMappingData().getMappedItem(item.identifier()) : null;
        if (dataItemWithExtras == null) {
            return super.handleItemToClient(userConnection, item);
        }
        if (item.tag() == null) {
            item.setTag(new CompoundTag());
        }
        item.tag().putInt(this.nbtTagName("id"), item.identifier());
        item.setIdentifier(((MappedItem)((Object)dataItemWithExtras)).id());
        if (ViaBackwards.getConfig().passOriginalItemNameToResourcePacks() && !item.tag().contains("CustomModelData")) {
            item.tag().putInt("CustomModelData", ((MappedItem)((Object)dataItemWithExtras)).customModelData());
        }
        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            item.tag().put("display", compoundTag);
        }
        if (!compoundTag.contains("Name")) {
            compoundTag.put("Name", new StringTag(((MappedItem)((Object)dataItemWithExtras)).jsonName()));
            compoundTag.put(this.nbtTagName("customName"), new ByteTag(false));
        }
        return item;
    }

    @Override
    public @Nullable Item handleItemToServer(UserConnection userConnection, @Nullable Item item) {
        Tag tag;
        if (item == null) {
            return null;
        }
        if ((item = super.handleItemToServer(userConnection, item)).tag() != null && (tag = item.tag().remove(this.nbtTagName("id"))) instanceof IntTag) {
            item.setIdentifier(((NumberTag)tag).asInt());
        }
        return item;
    }
}

