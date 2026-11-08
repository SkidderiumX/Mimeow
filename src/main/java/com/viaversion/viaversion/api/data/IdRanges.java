/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.nbt.tag.ByteArrayTag;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.fastutil.ints.IntOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.ints.IntSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.util.function.IntConsumer;

public class IdRanges {
    public static IntSet decode(ByteArrayTag byteArrayTag) {
        IntOpenHashSet intOpenHashSet = new IntOpenHashSet();
        IdRanges.forEachId(byteArrayTag, intOpenHashSet::add);
        return intOpenHashSet;
    }

    public static void forEachId(ByteArrayTag byteArrayTag, IntConsumer intConsumer) {
        ByteBuf byteBuf = Unpooled.wrappedBuffer(byteArrayTag.getValue());
        int n = 0;
        while (byteBuf.isReadable()) {
            int n2 = n + Types.VAR_INT.readPrimitive(byteBuf);
            int n3 = n2 + Types.VAR_INT.readPrimitive(byteBuf);
            for (int i = n2; i <= n3; ++i) {
                intConsumer.accept(i);
            }
            n = n3 + 1;
        }
    }
}

