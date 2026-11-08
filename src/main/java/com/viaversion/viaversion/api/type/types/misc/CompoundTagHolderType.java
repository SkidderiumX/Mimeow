/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import io.netty.buffer.ByteBuf;

public class CompoundTagHolderType
extends HolderType<CompoundTag> {
    @Override
    public CompoundTag readDirect(ByteBuf byteBuf) {
        return (CompoundTag)Types.TRUSTED_COMPOUND_TAG.read(byteBuf);
    }

    @Override
    public void writeDirect(ByteBuf byteBuf, CompoundTag compoundTag) {
        Types.TRUSTED_COMPOUND_TAG.write(byteBuf, compoundTag);
    }
}

