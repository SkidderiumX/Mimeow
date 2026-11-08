/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.block;

import com.viaversion.viaversion.api.minecraft.BlockChangeRecord;
import com.viaversion.viaversion.api.minecraft.BlockChangeRecord1_8;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BlockChangeRecordType
extends Type<BlockChangeRecord> {
    public BlockChangeRecordType() {
        super(BlockChangeRecord.class);
    }

    @Override
    public BlockChangeRecord read(ByteBuf byteBuf) {
        short s = Types.SHORT.readPrimitive(byteBuf);
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        return new BlockChangeRecord1_8(s >> 12 & 0xF, s & 0xFF, s >> 8 & 0xF, n);
    }

    @Override
    public void write(ByteBuf byteBuf, BlockChangeRecord blockChangeRecord) {
        Types.SHORT.writePrimitive(byteBuf, (short)(blockChangeRecord.getSectionX() << 12 | blockChangeRecord.getSectionZ() << 8 | blockChangeRecord.getY()));
        Types.VAR_INT.writePrimitive(byteBuf, blockChangeRecord.getBlockId());
    }
}

