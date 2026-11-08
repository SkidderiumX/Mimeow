/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.nbt.limiter;

import com.viaversion.nbt.limiter.TagLimiter;

public class TagLimiterImpl
implements TagLimiter {
    private final int maxBytes;
    private final int maxLevels;
    private int bytes;

    TagLimiterImpl(int n, int n2) {
        this.maxBytes = n;
        this.maxLevels = n2;
    }

    @Override
    public void countBytes(int n) {
        this.bytes += n;
        if (this.bytes >= this.maxBytes) {
            throw new IllegalArgumentException("NBT data larger than expected (capped at " + this.maxBytes + ")");
        }
    }

    @Override
    public void checkLevel(int n) {
        if (n >= this.maxLevels) {
            throw new IllegalArgumentException("Nesting level higher than expected (capped at " + this.maxLevels + ")");
        }
    }

    @Override
    public int maxBytes() {
        return this.maxBytes;
    }

    @Override
    public int maxLevels() {
        return this.maxLevels;
    }

    @Override
    public int bytes() {
        return this.bytes;
    }

    @Override
    public void reset() {
        this.bytes = 0;
    }
}

