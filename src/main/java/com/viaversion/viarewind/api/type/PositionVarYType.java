/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.type;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.util.function.IntFunction;

public class PositionVarYType<T extends Number>
extends Type<BlockPosition> {
    private final Type<T> yType;
    private final IntFunction<T> toY;

    public PositionVarYType(Type<T> type, IntFunction<T> intFunction) {
        super(BlockPosition.class);
        this.yType = type;
        this.toY = intFunction;
    }

    @Override
    public BlockPosition read(ByteBuf byteBuf) {
        int n = byteBuf.readInt();
        int n2 = ((Number)this.yType.read(byteBuf)).intValue();
        int n3 = byteBuf.readInt();
        return new BlockPosition(n, n2, n3);
    }

    @Override
    public void write(ByteBuf byteBuf, BlockPosition blockPosition) {
        byteBuf.writeInt(blockPosition.x());
        this.yType.write(byteBuf, (Number)this.toY.apply(blockPosition.y()));
        byteBuf.writeInt(blockPosition.z());
    }
}

