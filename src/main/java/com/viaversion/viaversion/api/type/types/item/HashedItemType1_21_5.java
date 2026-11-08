/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.item;

import com.viaversion.viaversion.api.minecraft.item.HashedItem;
import com.viaversion.viaversion.api.minecraft.item.HashedStructuredItem;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.util.Limit;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;

public class HashedItemType1_21_5
extends Type<HashedItem> {
    public HashedItemType1_21_5() {
        super(HashedItem.class);
    }

    @Override
    public HashedItem read(ByteBuf byteBuf) {
        int n;
        int n2;
        if (!byteBuf.readBoolean()) {
            return HashedStructuredItem.empty();
        }
        int n3 = Types.VAR_INT.readPrimitive(byteBuf);
        int n4 = Types.VAR_INT.readPrimitive(byteBuf);
        int n5 = Limit.max(Types.VAR_INT.readPrimitive(byteBuf), 256);
        Int2IntOpenHashMap int2IntOpenHashMap = new Int2IntOpenHashMap(n5);
        for (n2 = 0; n2 < n5; ++n2) {
            int n6 = Types.VAR_INT.readPrimitive(byteBuf);
            n = Types.INT.readPrimitive(byteBuf);
            int2IntOpenHashMap.put(n6, n);
        }
        n2 = Limit.max(Types.VAR_INT.readPrimitive(byteBuf), 256);
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet(n2);
        for (n = 0; n < n2; ++n) {
            int n7 = Types.VAR_INT.readPrimitive(byteBuf);
            intOpenHashSet.add(n7);
        }
        return new HashedStructuredItem(n3, n4, int2IntOpenHashMap, intOpenHashSet);
    }

    @Override
    public void write(ByteBuf byteBuf, HashedItem hashedItem) {
        if (hashedItem.isEmpty()) {
            byteBuf.writeBoolean(false);
            return;
        }
        byteBuf.writeBoolean(true);
        Types.VAR_INT.writePrimitive(byteBuf, hashedItem.identifier());
        Types.VAR_INT.writePrimitive(byteBuf, hashedItem.amount());
        Types.VAR_INT.writePrimitive(byteBuf, hashedItem.dataHashesById().size());
        for (Int2IntMap.Entry entry : hashedItem.dataHashesById().int2IntEntrySet()) {
            Types.VAR_INT.writePrimitive(byteBuf, entry.getIntKey());
            Types.INT.writePrimitive(byteBuf, entry.getIntValue());
        }
        Types.VAR_INT.writePrimitive(byteBuf, hashedItem.removedDataIds().size());
        Iterator iterator2 = hashedItem.removedDataIds().iterator();
        while (iterator2.hasNext()) {
            int n = (Integer)iterator2.next();
            Types.VAR_INT.writePrimitive(byteBuf, n);
        }
    }
}

