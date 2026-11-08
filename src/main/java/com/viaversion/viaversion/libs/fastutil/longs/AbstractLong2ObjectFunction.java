/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

import com.viaversion.viaversion.libs.fastutil.longs.Long2ObjectFunction;
import java.io.Serializable;

public abstract class AbstractLong2ObjectFunction<V>
implements Long2ObjectFunction<V>,
Serializable {
    private static final long serialVersionUID = -4940583368468432370L;
    protected V defRetValue;

    protected AbstractLong2ObjectFunction() {
    }

    @Override
    public void defaultReturnValue(V v) {
        this.defRetValue = v;
    }

    @Override
    public V defaultReturnValue() {
        return this.defRetValue;
    }
}

