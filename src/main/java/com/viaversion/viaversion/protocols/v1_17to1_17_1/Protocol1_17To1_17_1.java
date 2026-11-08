/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17to1_17_1;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.StringType;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ClientboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.rewriter.ItemPacketRewriter1_17_1;

public class Protocol1_17To1_17_1
extends AbstractProtocol<ClientboundPackets1_17, ClientboundPackets1_17_1, ServerboundPackets1_17, ServerboundPackets1_17> {
    private static final StringType PAGE_STRING_TYPE = new StringType(8192);
    private static final StringType TITLE_STRING_TYPE = new StringType(128);
    private final ItemPacketRewriter1_17_1 itemRewriter = new ItemPacketRewriter1_17_1(this);

    public Protocol1_17To1_17_1() {
        super(ClientboundPackets1_17.class, ClientboundPackets1_17_1.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_17.REMOVE_ENTITY, ClientboundPackets1_17_1.REMOVE_ENTITIES, (PacketWrapper packetWrapper) -> {
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{n});
        });
        this.registerServerbound(ServerboundPackets1_17.EDIT_BOOK, packetWrapper -> {
            CompoundTag compoundTag = new CompoundTag();
            DataItem dataItem = new DataItem(942, 1, compoundTag);
            packetWrapper.write(Types.ITEM1_13_2, dataItem);
            int n = packetWrapper.read(Types.VAR_INT);
            int n2 = packetWrapper.read(Types.VAR_INT);
            ListTag<StringTag> listTag = new ListTag<StringTag>(StringTag.class);
            for (int i = 0; i < n2; ++i) {
                String string = packetWrapper.read(PAGE_STRING_TYPE);
                if (i >= 200) continue;
                listTag.add(new StringTag(string));
            }
            if (listTag.isEmpty()) {
                listTag.add(new StringTag(""));
            }
            compoundTag.put("pages", listTag);
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                String string = packetWrapper.read(TITLE_STRING_TYPE);
                compoundTag.put("title", new StringTag(string));
                compoundTag.put("author", new StringTag(packetWrapper.user().getProtocolInfo().getUsername()));
                packetWrapper.write(Types.BOOLEAN, true);
            } else {
                packetWrapper.write(Types.BOOLEAN, false);
            }
            packetWrapper.write(Types.VAR_INT, n);
        });
    }

    public ItemPacketRewriter1_17_1 getItemRewriter() {
        return this.itemRewriter;
    }
}

