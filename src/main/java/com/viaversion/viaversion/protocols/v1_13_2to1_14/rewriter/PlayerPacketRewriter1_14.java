/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.Protocol1_13_2To1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;

public class PlayerPacketRewriter1_14 {
    public static void register(Protocol1_13_2To1_14 protocol1_13_2To1_14) {
        protocol1_13_2To1_14.registerClientbound(ClientboundPackets1_13.OPEN_SIGN_EDITOR, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_8, Types.BLOCK_POSITION1_14);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.BLOCK_ENTITY_TAG_QUERY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.EDIT_BOOK, packetWrapper -> {
            Item item = packetWrapper.passthrough(Types.ITEM1_13_2);
            protocol1_13_2To1_14.getItemRewriter().handleItemToServer(packetWrapper.user(), item);
            if (item == null) {
                return;
            }
            CompoundTag compoundTag = item.tag();
            if (compoundTag == null) {
                return;
            }
            ListTag<StringTag> listTag = compoundTag.getListTag("pages", StringTag.class);
            if (listTag == null) {
                listTag = new ListTag<StringTag>(StringTag.class);
                listTag.add(new StringTag());
                compoundTag.put("pages", listTag);
                return;
            }
            if (Via.getConfig().isTruncate1_14Books() && listTag.size() > 50) {
                listTag.setValue(listTag.getValue().subList(0, 50));
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.PLAYER_ACTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.RECIPE_BOOK_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 0) {
                        packetWrapper.passthrough(Types.STRING);
                    } else if (n == 1) {
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.passthrough(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                        packetWrapper.read(Types.BOOLEAN);
                    }
                });
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.SET_COMMAND_BLOCK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.SET_STRUCTURE_BLOCK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.SIGN_UPDATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
            }
        });
        protocol1_13_2To1_14.registerServerbound(ServerboundPackets1_14.USE_ITEM_ON, packetWrapper -> {
            int n = packetWrapper.read(Types.VAR_INT);
            BlockPosition blockPosition = packetWrapper.read(Types.BLOCK_POSITION1_14);
            int n2 = packetWrapper.read(Types.VAR_INT);
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            float f3 = packetWrapper.read(Types.FLOAT).floatValue();
            packetWrapper.read(Types.BOOLEAN);
            packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
            packetWrapper.write(Types.VAR_INT, n2);
            packetWrapper.write(Types.VAR_INT, n);
            packetWrapper.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f2));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f3));
        });
    }
}

