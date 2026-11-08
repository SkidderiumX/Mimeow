/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class Filterable<T> {
    private final T raw;
    private final T filtered;

    protected Filterable(T t, @Nullable T t2) {
        this.raw = t;
        this.filtered = t2;
    }

    public T raw() {
        return this.raw;
    }

    public boolean isFiltered() {
        return this.filtered != null;
    }

    public @Nullable T filtered() {
        return this.filtered;
    }

    public T get() {
        return this.filtered != null ? this.filtered : this.raw;
    }

    public static abstract class FilterableType<T, F extends Filterable<T>>
    extends Type<F> {
        private final Type<T> elementType;
        private final Type<T> optionalElementType;

        protected FilterableType(Type<T> type, Type<T> type2, Class<F> clazz) {
            super(clazz);
            this.elementType = type;
            this.optionalElementType = type2;
        }

        @Override
        public F read(ByteBuf byteBuf) {
            Object t = this.elementType.read(byteBuf);
            Object t2 = this.optionalElementType.read(byteBuf);
            return this.create(t, t2);
        }

        @Override
        public void write(ByteBuf byteBuf, F f) {
            this.elementType.write(byteBuf, ((Filterable)f).raw());
            this.optionalElementType.write(byteBuf, ((Filterable)f).filtered());
        }

        @Override
        public void write(Ops ops, F f) {
            ops.writeMap(mapSerializer -> mapSerializer.write("raw", this.elementType, f.raw()).writeOptional("filtered", this.elementType, f.filtered()));
        }

        protected abstract F create(T var1, T var2);
    }
}

