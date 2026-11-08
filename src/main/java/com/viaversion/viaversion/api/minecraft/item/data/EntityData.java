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
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record EntityData(int type, CompoundTag tag) implements Rewritable,
Copyable
{
    public static final Type<EntityData> TYPE = new Type<EntityData>(EntityData.class){

        @Override
        public EntityData read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            CompoundTag compoundTag = (CompoundTag)Types.COMPOUND_TAG.read(byteBuf);
            return new EntityData(n, compoundTag);
        }

        @Override
        public void write(ByteBuf byteBuf, EntityData entityData) {
            Types.VAR_INT.writePrimitive(byteBuf, entityData.type);
            Types.COMPOUND_TAG.write(byteBuf, entityData.tag);
        }

        @Override
        public void write(Ops ops, EntityData entityData) {
            ops.writeMap(mapSerializer -> mapSerializer.write("id", Types.IDENTIFIER, ops.context().registryAccess().entity(entityData.type)).writeInlinedMap(Types.COMPOUND_TAG, entityData.tag));
        }
    };

    @Override
    public EntityData rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        int n = Rewritable.entityRewriteFunction(protocol, bl).applyAsInt(this.type);
        return new EntityData(n, this.tag);
    }

    @Override
    public EntityData copy() {
        return new EntityData(this.type, this.tag.copy());
    }
}

