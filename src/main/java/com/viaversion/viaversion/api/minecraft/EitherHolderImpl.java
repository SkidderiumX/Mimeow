/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.util.EitherImpl;

public class EitherHolderImpl<T>
extends EitherImpl<Holder<T>, String>
implements EitherHolder<T> {
    EitherHolderImpl(Holder<T> holder, String string) {
        super(holder, string);
    }

    @Override
    public boolean hasHolder() {
        return this.isLeft();
    }

    @Override
    public boolean hasKey() {
        return this.isRight();
    }

    @Override
    public Holder<T> holder() {
        Preconditions.checkArgument(this.hasHolder(), "Either does not have a holder");
        return (Holder)this.left();
    }

    @Override
    public String key() {
        Preconditions.checkArgument(this.hasKey(), "Either does not have a key");
        return (String)this.right();
    }
}

