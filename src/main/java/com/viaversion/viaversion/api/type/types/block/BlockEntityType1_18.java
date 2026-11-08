/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.block;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntity;
import com.viaversion.viaversion.api.minecraft.blockentity.BlockEntityImpl;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class BlockEntityType1_18
extends Type<BlockEntity> {
    public BlockEntityType1_18() {
        super(BlockEntity.class);
    }

    @Override
    public BlockEntity read(ByteBuf byteBuf) {
        byte by = byteBuf.readByte();
        short s = byteBuf.readShort();
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        CompoundTag compoundTag = (CompoundTag)Types.NAMED_COMPOUND_TAG.read(byteBuf);
        return new BlockEntityImpl(by, s, n, compoundTag);
    }

    @Override
    public void write(ByteBuf byteBuf, BlockEntity blockEntity) {
        byteBuf.writeByte(blockEntity.packedXZ());
        byteBuf.writeShort(blockEntity.y());
        Types.VAR_INT.writePrimitive(byteBuf, blockEntity.typeId());
        Types.NAMED_COMPOUND_TAG.write(byteBuf, blockEntity.tag());
    }
}

