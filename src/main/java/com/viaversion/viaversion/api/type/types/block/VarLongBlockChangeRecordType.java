/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.block;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_16_2;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class VarLongBlockChangeRecordType
extends Type<BlockChangeRecord> {
    public VarLongBlockChangeRecordType() {
        super(BlockChangeRecord.class);
    }

    @Override
    public BlockChangeRecord read(ByteBuf byteBuf) {
        long l = Types.VAR_LONG.readPrimitive(byteBuf);
        short s = (short)(l & 0xFFFL);
        return new BlockChangeRecord1_16_2(s >>> 8 & 0xF, s & 0xF, s >>> 4 & 0xF, (int)(l >>> 12));
    }

    @Override
    public void write(ByteBuf byteBuf, BlockChangeRecord blockChangeRecord) {
        short s = (short)(blockChangeRecord.getSectionX() << 8 | blockChangeRecord.getSectionZ() << 4 | blockChangeRecord.getSectionY());
        Types.VAR_LONG.writePrimitive(byteBuf, (long)blockChangeRecord.getBlockId() << 12 | (long)s);
    }
}

