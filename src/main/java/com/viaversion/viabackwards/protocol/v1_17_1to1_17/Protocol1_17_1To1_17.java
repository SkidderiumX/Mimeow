/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_17_1to1_17;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.protocol.v1_17_1to1_17.storage.InventoryStateIds;
import com.viaversion.viabackwards.protocol.v1_17to1_16_4.storage.PlayerLastCursorItem;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;

public class Protocol1_17_1To1_17
extends BackwardsProtocol<ClientboundPackets1_17_1, ClientboundPackets1_17, ServerboundPackets1_17, ServerboundPackets1_17> {
    private static final int MAX_PAGE_LENGTH = 8192;
    private static final int MAX_TITLE_LENGTH = 128;
    private static final int MAX_PAGES = 200;

    public Protocol1_17_1To1_17() {
        super(ClientboundPackets1_17_1.class, ClientboundPackets1_17.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        this.registerClientbound(ClientboundPackets1_17_1.REMOVE_ENTITIES, null, (PacketWrapper packetWrapper) -> {
            int[] nArray = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            packetWrapper.cancel();
            for (int n : nArray) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17.REMOVE_ENTITY);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.send(Protocol1_17_1To1_17.class);
            }
        });
        this.registerClientbound(ClientboundPackets1_17_1.CONTAINER_CLOSE, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            packetWrapper.user().get(InventoryStateIds.class).removeStateId(s);
        });
        this.registerClientbound(ClientboundPackets1_17_1.CONTAINER_SET_SLOT, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.user().get(InventoryStateIds.class).setStateId(by, n);
        });
        this.registerClientbound(ClientboundPackets1_17_1.CONTAINER_SET_CONTENT, packetWrapper -> {
            short s = packetWrapper.passthrough(Types.UNSIGNED_BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.user().get(InventoryStateIds.class).setStateId(s, n);
            packetWrapper.write(Types.ITEM1_13_2_SHORT_ARRAY, packetWrapper.read(Types.ITEM1_13_2_ARRAY));
            Item item = packetWrapper.read(Types.ITEM1_13_2);
            PlayerLastCursorItem playerLastCursorItem = packetWrapper.user().get(PlayerLastCursorItem.class);
            if (playerLastCursorItem != null) {
                playerLastCursorItem.setLastCursorItem(item);
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_17.CONTAINER_SET_SLOT);
                packetWrapper2.write(Types.BYTE, (byte)-1);
                packetWrapper2.write(Types.SHORT, (short)-1);
                packetWrapper2.write(Types.ITEM1_13_2, item);
                packetWrapper2.send(Protocol1_17_1To1_17.class);
            }
        });
        this.registerServerbound(ServerboundPackets1_17.CONTAINER_CLOSE, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            packetWrapper.user().get(InventoryStateIds.class).removeStateId(by);
        });
        this.registerServerbound(ServerboundPackets1_17.CONTAINER_CLICK, packetWrapper -> {
            byte by = packetWrapper.passthrough(Types.BYTE);
            int n = packetWrapper.user().get(InventoryStateIds.class).removeStateId(by);
            packetWrapper.write(Types.VAR_INT, n == Integer.MAX_VALUE ? 0 : n);
        });
        this.registerServerbound(ServerboundPackets1_17.EDIT_BOOK, packetWrapper -> {
            ListTag<StringTag> listTag;
            Item item = packetWrapper.read(Types.ITEM1_13_2);
            boolean bl = packetWrapper.read(Types.BOOLEAN);
            packetWrapper.passthrough(Types.VAR_INT);
            if (item == null) {
                packetWrapper.write(Types.VAR_INT, 0);
                packetWrapper.write(Types.BOOLEAN, false);
                return;
            }
            CompoundTag compoundTag = item.tag();
            StringTag stringTag = null;
            if (compoundTag == null || (listTag = compoundTag.getListTag("pages", StringTag.class)) == null || bl && (stringTag = compoundTag.getStringTag("title")) == null) {
                packetWrapper.write(Types.VAR_INT, 0);
                packetWrapper.write(Types.BOOLEAN, false);
                return;
            }
            if (listTag.size() > 200) {
                listTag = new ListTag(listTag.getValue().subList(0, 200));
            }
            packetWrapper.write(Types.VAR_INT, listTag.size());
            for (StringTag stringTag2 : listTag) {
                String string = stringTag2.getValue();
                if (string.length() > 8192) {
                    string = string.substring(0, 8192);
                }
                packetWrapper.write(Types.STRING, string);
            }
            packetWrapper.write(Types.BOOLEAN, bl);
            if (bl) {
                Object object = stringTag.getValue();
                if (((String)object).length() > 128) {
                    object = ((String)object).substring(0, 128);
                }
                packetWrapper.write(Types.STRING, object);
            }
        });
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new InventoryStateIds());
    }
}

