/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_15_2to1_16.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.IntArrayTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.Protocol1_15_2To1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.data.AttributeMappings1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.storage.InventoryTracker1_16;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.RecipeRewriter;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.UUIDUtil;
import java.util.UUID;

public class ItemPacketRewriter1_16
extends ItemRewriter<ClientboundPackets1_15, ServerboundPackets1_16, Protocol1_15_2To1_16> {
    public ItemPacketRewriter1_16(Protocol1_15_2To1_16 protocol1_15_2To1_16) {
        super(protocol1_15_2To1_16, Types.ITEM1_13_2, Types.ITEM1_13_2_SHORT_ARRAY);
    }

    @Override
    public void registerPackets() {
        final PacketHandler packetHandler = packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_16.CONTAINER_SET_SLOT);
            packetWrapper2.write(Types.BYTE, (byte)-1);
            packetWrapper2.write(Types.SHORT, (short)-1);
            packetWrapper2.write(Types.ITEM1_13_2, null);
            packetWrapper2.send(Protocol1_15_2To1_16.class);
        };
        ((Protocol1_15_2To1_16)this.protocol).replaceClientbound(ClientboundPackets1_15.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.COMPONENT);
                this.handler(packetHandler);
                this.handler(packetWrapper -> {
                    InventoryTracker1_16 inventoryTracker1_16 = packetWrapper.user().get(InventoryTracker1_16.class);
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n >= 20) {
                        packetWrapper.set(Types.VAR_INT, 1, ++n);
                    }
                    inventoryTracker1_16.setInventoryOpen(true);
                });
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.CONTAINER_CLOSE, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetHandler);
                this.handler(packetWrapper -> {
                    InventoryTracker1_16 inventoryTracker1_16 = packetWrapper.user().get(InventoryTracker1_16.class);
                    inventoryTracker1_16.setInventoryOpen(false);
                });
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.CONTAINER_SET_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    short s;
                    short s2 = packetWrapper.get(Types.SHORT, 0);
                    if (s2 >= 4 && s2 <= 6 && (s = packetWrapper.get(Types.SHORT, 1).shortValue()) >= 11) {
                        s = (short)(s + 1);
                        packetWrapper.set(Types.SHORT, 1, s);
                    }
                });
            }
        });
        ((Protocol1_15_2To1_16)this.protocol).registerClientbound(ClientboundPackets1_15.SET_EQUIPPED_ITEM, ClientboundPackets1_16.SET_EQUIPMENT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.read(Types.VAR_INT);
                    packetWrapper.write(Types.BYTE, (byte)n);
                    ItemPacketRewriter1_16.this.handleItemToClient(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2));
                });
            }
        });
        new RecipeRewriter<ClientboundPackets1_15>(this.protocol).register(ClientboundPackets1_15.UPDATE_RECIPES);
        ((Protocol1_15_2To1_16)this.protocol).registerServerbound(ServerboundPackets1_16.CONTAINER_CLOSE, packetWrapper -> {
            InventoryTracker1_16 inventoryTracker1_16 = packetWrapper.user().get(InventoryTracker1_16.class);
            inventoryTracker1_16.setInventoryOpen(false);
        });
        ((Protocol1_15_2To1_16)this.protocol).registerServerbound(ServerboundPackets1_16.EDIT_BOOK, packetWrapper -> this.handleItemToServer(packetWrapper.user(), packetWrapper.passthrough(Types.ITEM1_13_2)));
    }

    @Override
    public Item handleItemToClient(UserConnection userConnection, Item item) {
        ListTag<StringTag> listTag;
        if (item == null) {
            return null;
        }
        CompoundTag compoundTag = item.tag();
        if (item.identifier() == 771 && compoundTag != null) {
            StringTag stringTag;
            CompoundTag compoundTag2 = compoundTag.getCompoundTag("SkullOwner");
            if (compoundTag2 != null && (stringTag = compoundTag2.getStringTag("Id")) != null) {
                UUID uUID = UUID.fromString(stringTag.getValue());
                compoundTag2.put("Id", new IntArrayTag(UUIDUtil.toIntArray(uUID)));
            }
        } else if (item.identifier() == 759 && compoundTag != null && (listTag = compoundTag.getListTag("pages", StringTag.class)) != null) {
            for (StringTag stringTag : listTag) {
                stringTag.setValue(((Protocol1_15_2To1_16)this.protocol).getComponentRewriter().processText(userConnection, stringTag.getValue()).toString());
            }
        }
        ItemPacketRewriter1_16.oldToNewAttributes(item);
        item.setIdentifier(Protocol1_15_2To1_16.MAPPINGS.getNewItemId(item.identifier()));
        return item;
    }

    @Override
    public Item handleItemToServer(UserConnection userConnection, Item item) {
        IntArrayTag intArrayTag;
        CompoundTag compoundTag;
        CompoundTag compoundTag2;
        if (item == null) {
            return null;
        }
        item.setIdentifier(Protocol1_15_2To1_16.MAPPINGS.getOldItemId(item.identifier()));
        if (item.identifier() == 771 && item.tag() != null && (compoundTag2 = (compoundTag = item.tag()).getCompoundTag("SkullOwner")) != null && (intArrayTag = compoundTag2.getIntArrayTag("Id")) != null) {
            UUID uUID = UUIDUtil.fromIntArray(intArrayTag.getValue());
            compoundTag2.putString("Id", uUID.toString());
        }
        ItemPacketRewriter1_16.newToOldAttributes(item);
        return item;
    }

    public static void oldToNewAttributes(Item item) {
        if (item.tag() == null) {
            return;
        }
        ListTag<CompoundTag> listTag = item.tag().getListTag("AttributeModifiers", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag : listTag) {
            ItemPacketRewriter1_16.rewriteAttributeName(compoundTag, "AttributeName", false);
            ItemPacketRewriter1_16.rewriteAttributeName(compoundTag, "Name", false);
            NumberTag numberTag = compoundTag.getNumberTag("UUIDLeast");
            NumberTag numberTag2 = compoundTag.getNumberTag("UUIDMost");
            if (numberTag == null || numberTag2 == null) continue;
            int[] nArray = UUIDUtil.toIntArray(numberTag2.asLong(), numberTag.asLong());
            compoundTag.put("UUID", new IntArrayTag(nArray));
            compoundTag.remove("UUIDLeast");
            compoundTag.remove("UUIDMost");
        }
    }

    public static void newToOldAttributes(Item item) {
        if (item.tag() == null) {
            return;
        }
        ListTag<CompoundTag> listTag = item.tag().getListTag("AttributeModifiers", CompoundTag.class);
        if (listTag == null) {
            return;
        }
        for (CompoundTag compoundTag : listTag) {
            ItemPacketRewriter1_16.rewriteAttributeName(compoundTag, "AttributeName", true);
            ItemPacketRewriter1_16.rewriteAttributeName(compoundTag, "Name", true);
            IntArrayTag intArrayTag = compoundTag.getIntArrayTag("UUID");
            if (intArrayTag == null || intArrayTag.getValue().length != 4) continue;
            UUID uUID = UUIDUtil.fromIntArray(intArrayTag.getValue());
            compoundTag.putLong("UUIDLeast", uUID.getLeastSignificantBits());
            compoundTag.putLong("UUIDMost", uUID.getMostSignificantBits());
            compoundTag.remove("UUID");
        }
    }

    public static void rewriteAttributeName(CompoundTag compoundTag, String string, boolean bl) {
        String string2;
        StringTag stringTag = compoundTag.getStringTag(string);
        if (stringTag == null) {
            return;
        }
        String string3 = stringTag.getValue();
        if (bl) {
            string3 = Key.namespaced(string3);
        }
        if ((string2 = (String)(bl ? AttributeMappings1_16.attributeIdentifierMappings().inverse() : AttributeMappings1_16.attributeIdentifierMappings()).get(string3)) == null) {
            return;
        }
        stringTag.setValue(string2);
    }
}

