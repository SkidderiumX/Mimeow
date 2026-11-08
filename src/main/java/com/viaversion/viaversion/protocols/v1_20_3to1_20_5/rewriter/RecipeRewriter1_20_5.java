/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.rewriter;

import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.minecraft.item.StructuredItem;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter.RecipeRewriter1_20_3;
import java.util.ArrayList;

public class RecipeRewriter1_20_5<C extends ClientboundPacketType>
extends RecipeRewriter1_20_3<C> {
    public RecipeRewriter1_20_5(Protocol<C, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    protected void handleIngredient(PacketWrapper packetWrapper) {
        Item[] itemArray = packetWrapper.read(this.itemArrayType());
        ArrayList<Item> arrayList = new ArrayList<Item>(itemArray.length);
        for (Item item : itemArray) {
            if (item == null || item.isEmpty()) continue;
            arrayList.add(this.rewrite(packetWrapper.user(), item));
        }
        packetWrapper.write(this.mappedItemArrayType(), arrayList.toArray(new Item[0]));
    }

    @Override
    protected void handleResult(PacketWrapper packetWrapper) {
        Item item = this.rewrite(packetWrapper.user(), packetWrapper.read(this.itemType()));
        if (item == null || item.isEmpty()) {
            item = new StructuredItem(1, 1);
        }
        packetWrapper.write(this.mappedItemType(), item);
    }
}

