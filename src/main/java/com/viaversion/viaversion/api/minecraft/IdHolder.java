/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public record IdHolder<T>(int id) implements Holder<T>
{
    IdHolder {
        Preconditions.checkArgument(n >= 0, "id cannot be negative");
    }

    @Override
    public boolean isDirect() {
        return false;
    }

    @Override
    public boolean hasId() {
        return true;
    }

    @Override
    public T value() {
        throw new IllegalArgumentException("Holder is not direct");
    }

    @Override
    public Holder<T> updateId(Int2IntFunction int2IntFunction, Supplier<Holder<T>> supplier) {
        int n = int2IntFunction.applyAsInt(this.id);
        if (n == this.id) {
            return this;
        }
        if (n == -1) {
            if (supplier != null) {
                return supplier.get();
            }
            throw new IllegalArgumentException("Received invalid id in updateId");
        }
        return Holder.of(n);
    }

    @Override
    public Holder<T> updateValue(Function<T, T> function) {
        return this;
    }
}

