/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public record ValueHolder<T>(T value) implements Holder<T>
{
    @Override
    public boolean isDirect() {
        return true;
    }

    @Override
    public boolean hasId() {
        return false;
    }

    @Override
    public int id() {
        return -1;
    }

    @Override
    public Holder<T> updateId(Int2IntFunction int2IntFunction, Supplier<Holder<T>> supplier) {
        return this;
    }

    @Override
    public Holder<T> updateValue(Function<T, T> function) {
        T t = function.apply(this.value);
        return t != this.value ? Holder.of(t) : this;
    }
}

