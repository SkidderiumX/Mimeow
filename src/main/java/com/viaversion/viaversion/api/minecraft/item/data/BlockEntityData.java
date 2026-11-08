/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record BlockEntityData(int type, CompoundTag tag) implements Rewritable
{
    public static final Type<BlockEntityData> TYPE = new Type<BlockEntityData>(BlockEntityData.class){

        @Override
        public BlockEntityData read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            CompoundTag compoundTag = (CompoundTag)Types.COMPOUND_TAG.read(byteBuf);
            return new BlockEntityData(n, compoundTag);
        }

        @Override
        public void write(ByteBuf byteBuf, BlockEntityData blockEntityData) {
            Types.VAR_INT.writePrimitive(byteBuf, blockEntityData.type);
            Types.COMPOUND_TAG.write(byteBuf, blockEntityData.tag);
        }

        @Override
        public void write(Ops ops, BlockEntityData blockEntityData) {
            ops.writeMap(mapSerializer -> mapSerializer.write("id", Types.IDENTIFIER, ops.context().registryAccess().blockEntity(blockEntityData.type)).writeInlinedMap(Types.COMPOUND_TAG, blockEntityData.tag));
        }
    };

    @Override
    public BlockEntityData rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        int n = protocol.getMappingData().getBlockEntityMappings().getNewId(this.type);
        return new BlockEntityData(n != -1 ? n : 0, this.tag);
    }
}

