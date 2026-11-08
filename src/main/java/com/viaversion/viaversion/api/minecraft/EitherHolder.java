/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.EitherHolderImpl;
import com.viaversion.viaversion.api.minecraft.Holder;

public interface EitherHolder<T> {
    public static <T> EitherHolder<T> of(Holder<T> holder) {
        return new EitherHolderImpl<T>(holder, null);
    }

    public static <T> EitherHolder<T> of(String string) {
        return new EitherHolderImpl(null, string);
    }

    public boolean hasHolder();

    public boolean hasKey();

    public Holder<T> holder();

    public String key();
}

