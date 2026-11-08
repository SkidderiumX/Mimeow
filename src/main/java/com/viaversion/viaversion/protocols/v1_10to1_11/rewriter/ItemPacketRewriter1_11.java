/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_10to1_11.rewriter;

import com.viaversion.nbt.tag.ByteTag;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_10to1_11.Protocol1_10To1_11;
import com.viaversion.viaversion.protocols.v1_10to1_11.data.EntityMappings1_11;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ServerboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.ItemRewriter;

public class ItemPacketRewriter1_11
extends ItemRewriter<ClientboundPackets1_9_3, ServerboundPackets1_9_3, Protocol1_10To1_11> {
    public ItemPacketRewriter1_11(Protocol1_10To1_11 protocol1_10To1_11) {
        super(protocol1_10To1_11, Types.ITEM1_8, Types.ITEM1_8_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        this.registerSetSlot(ClientboundPackets1_9_3.CONTAINER_SET_SLOT);
        this.registerSetContent(ClientboundPackets1_9_3.CONTAINER_SET_CONTENT);
        this.registerSetEquippedItem(ClientboundPackets1_9_3.SET_EQUIPPED_ITEM);
        this.registerCustomPayloadTradeList(ClientboundPackets1_9_3.CUSTOM_PAYLOAD);
        this.registerContainerClick(ServerboundPackets1_9_3.CONTAINER_CLICK);
        this.registerSetCreativeModeSlot(ServerboundPackets1_9_3.SET_CREATIVE_MODE_SLOT);
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        CompoundTag compoundTag;
        if (item != null && item.amount() <= 0) {
            compoundTag = item.tag();
            if (compoundTag == null) {
                compoundTag = new CompoundTag();
                item.setTag(compoundTag);
            }
            compoundTag.putByte(this.nbtTagName(), (byte)item.amount());
            item.setAmount(1);
        }
        EntityMappings1_11.toClientItem(item);
        if (item == null || item.tag() == null) {
            return item;
        }
        compoundTag = item.tag();
        ListTag<?> listTag = compoundTag.getListTag("ench");
        if (listTag != null && listTag.isEmpty()) {
            compoundTag.putBoolean(this.nbtTagName("clearEnch"), true);
            listTag.add(new CompoundTag());
        }
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (compoundTag != null) {
            if (compoundTag.contains(this.nbtTagName())) {
                item.setAmount(((ByteTag)compoundTag.removeUnchecked(this.nbtTagName())).asByte());
                if (compoundTag.isEmpty()) {
                    item.setTag(null);
                }
            }
            if (compoundTag.remove(this.nbtTagName("clearEnch")) != null) {
                compoundTag.put("ench", new ListTag());
            }
        }
        EntityMappings1_11.toServerItem(item);
        boolean bl = item.identifier() >= 218 && item.identifier() <= 234;
        if (bl |= item.identifier() == 449 || item.identifier() == 450) {
            item.setIdentifier(1);
            item.setData((short)0);
        }
        return item;
    }
}

