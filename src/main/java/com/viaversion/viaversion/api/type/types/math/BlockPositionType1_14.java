/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BlockPositionType1_14
extends Type<BlockPosition> {
    public BlockPositionType1_14() {
        super(BlockPosition.class);
    }

    @Override
    public BlockPosition read(ByteBuf byteBuf) {
        long l = byteBuf.readLong();
        long l2 = l >> 38;
        long l3 = l << 52 >> 52;
        long l4 = l << 26 >> 38;
        return new BlockPosition((int)l2, (int)l3, (int)l4);
    }

    @Override
    public void write(ByteBuf byteBuf, BlockPosition blockPosition) {
        byteBuf.writeLong(((long)blockPosition.x() & 0x3FFFFFFL) << 38 | (long)(blockPosition.y() & 0xFFF) | ((long)blockPosition.z() & 0x3FFFFFFL) << 12);
    }

    @Override
    public void write(Ops ops, BlockPosition blockPosition) {
        ops.write(Types.INT_ARRAY_PRIMITIVE, new int[]{blockPosition.x(), blockPosition.y(), blockPosition.z()});
    }

    public static final class OptionalBlockPositionType
    extends OptionalType<BlockPosition> {
        public OptionalBlockPositionType() {
            super(Types.BLOCK_POSITION1_14);
        }
    }
}

