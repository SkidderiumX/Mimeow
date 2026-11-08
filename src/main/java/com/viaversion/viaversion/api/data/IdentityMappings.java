/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.Mappings;

public record IdentityMappings(int size, int mappedSize) implements Mappings
{
    @Override
    public int getNewId(int n) {
        return n >= 0 && n < this.size ? n : -1;
    }

    @Override
    public void setNewId(int n, int n2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Mappings inverse() {
        return new IdentityMappings(this.mappedSize, this.size);
    }

    @Override
    public boolean isIdentity() {
        return true;
    }
}

