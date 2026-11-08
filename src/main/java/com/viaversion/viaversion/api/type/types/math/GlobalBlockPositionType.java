/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.math;

import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class GlobalBlockPositionType
extends Type<GlobalBlockPosition> {
    public GlobalBlockPositionType() {
        super(GlobalBlockPosition.class);
    }

    @Override
    public GlobalBlockPosition read(ByteBuf byteBuf) {
        String string = (String)Types.STRING.read(byteBuf);
        return ((BlockPosition)Types.BLOCK_POSITION1_14.read(byteBuf)).withDimension(string);
    }

    @Override
    public void write(ByteBuf byteBuf, GlobalBlockPosition globalBlockPosition) {
        Types.STRING.write(byteBuf, globalBlockPosition.dimension());
        Types.BLOCK_POSITION1_14.write(byteBuf, (BlockPosition)globalBlockPosition);
    }

    @Override
    public void write(Ops ops, GlobalBlockPosition globalBlockPosition) {
        ops.writeMap(mapSerializer -> mapSerializer.write("dimension", Types.IDENTIFIER, Key.of(globalBlockPosition.dimension())).write("pos", Types.BLOCK_POSITION1_14, globalBlockPosition));
    }

    public static final class OptionalGlobalPositionType
    extends OptionalType<GlobalBlockPosition> {
        public OptionalGlobalPositionType() {
            super(Types.GLOBAL_POSITION);
        }
    }
}

