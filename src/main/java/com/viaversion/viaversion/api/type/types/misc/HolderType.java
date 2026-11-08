/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class HolderType<T>
extends Type<Holder<T>> {
    private final MappingData.MappingType mappingType;

    protected HolderType() {
        this((MappingData.MappingType)null);
    }

    protected HolderType(MappingData.MappingType mappingType) {
        super(Holder.class);
        this.mappingType = mappingType;
    }

    @Override
    public Holder<T> read(ByteBuf byteBuf) {
        int n = Types.VAR_INT.readPrimitive(byteBuf) - 1;
        if (n == -1) {
            return Holder.of(this.readDirect(byteBuf));
        }
        return Holder.of(n);
    }

    @Override
    public void write(ByteBuf byteBuf, Holder<T> holder) {
        if (holder.hasId()) {
            Types.VAR_INT.writePrimitive(byteBuf, holder.id() + 1);
        } else {
            Types.VAR_INT.writePrimitive(byteBuf, 0);
            this.writeDirect(byteBuf, holder.value());
        }
    }

    public abstract T readDirect(ByteBuf var1);

    public abstract void writeDirect(ByteBuf var1, T var2);

    @Override
    public void write(Ops ops, Holder<T> holder) {
        if (holder.hasId()) {
            ops.write(Types.IDENTIFIER, this.identifier(ops, holder.id()));
        } else {
            this.writeDirect(ops, holder.value());
        }
    }

    protected Key identifier(Ops ops, int n) {
        Preconditions.checkArgument(this.mappingType != null, "Mapping type is not defined for this HolderType: " + this.getClass().getName());
        return ops.context().registryAccess().key(this.mappingType, n);
    }

    public void writeDirect(Ops ops, T t) {
        throw new UnsupportedOperationException("Write operation not supported for type: " + this.getTypeName());
    }

    public static abstract class OptionalHolderType<T>
    extends HolderType<T> {
        private final HolderType<T> type;

        protected OptionalHolderType(HolderType<T> holderType) {
            this.type = holderType;
        }

        @Override
        public Holder<T> read(ByteBuf byteBuf) {
            return byteBuf.readBoolean() ? super.read(byteBuf) : null;
        }

        @Override
        public void write(ByteBuf byteBuf, Holder<T> holder) {
            if (holder != null) {
                byteBuf.writeBoolean(true);
                super.write(byteBuf, holder);
            } else {
                byteBuf.writeBoolean(false);
            }
        }

        @Override
        public @Nullable T readDirect(ByteBuf byteBuf) {
            return this.type.readDirect(byteBuf);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, @Nullable T t) {
            this.type.writeDirect(byteBuf, t);
        }
    }
}

