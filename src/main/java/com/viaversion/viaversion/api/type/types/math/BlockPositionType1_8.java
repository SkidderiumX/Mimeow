/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BlockPositionType1_8
extends Type<BlockPosition> {
    public BlockPositionType1_8() {
        super(BlockPosition.class);
    }

    @Override
    public BlockPosition read(ByteBuf byteBuf) {
        long l = byteBuf.readLong();
        long l2 = l >> 38;
        long l3 = l << 26 >> 52;
        long l4 = l << 38 >> 38;
        return new BlockPosition((int)l2, (short)l3, (int)l4);
    }

    @Override
    public void write(ByteBuf byteBuf, BlockPosition blockPosition) {
        byteBuf.writeLong(((long)blockPosition.x() & 0x3FFFFFFL) << 38 | ((long)blockPosition.y() & 0xFFFL) << 26 | (long)blockPosition.z() & 0x3FFFFFFL);
    }

    public static final class OptionalBlockPositionType
    extends OptionalType<BlockPosition> {
        public OptionalBlockPositionType() {
            super(Types.BLOCK_POSITION1_8);
        }
    }
}

