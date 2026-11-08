/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import java.util.Arrays;

public record TagData(String identifier, int[] entries) {
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        TagData tagData = (TagData)object;
        if (!this.identifier.equals(tagData.identifier)) {
            return false;
        }
        return Arrays.equals(this.entries, tagData.entries);
    }

    @Override
    public int hashCode() {
        int n = this.identifier.hashCode();
        n = 31 * n + Arrays.hashCode(this.entries);
        return n;
    }
}

