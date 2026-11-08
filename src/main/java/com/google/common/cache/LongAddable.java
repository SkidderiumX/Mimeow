/*
 * Decompiled with CFR 0.152.
 */
package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface LongAddable {
    public void increment();

    public void add(long var1);

    public long sum();
}

