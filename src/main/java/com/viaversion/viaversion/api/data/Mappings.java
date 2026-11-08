/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.data;

import com.viaversion.viaversion.api.data.FullMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface Mappings {
    public int getNewId(int var1);

    default public int getNewIdOrDefault(int n, int n2) {
        int n3 = this.getNewId(n);
        return n3 != -1 ? n3 : n2;
    }

    default public boolean contains(int n) {
        return this.getNewId(n) != -1;
    }

    public void setNewId(int var1, int var2);

    public int size();

    public int mappedSize();

    public Mappings inverse();

    default public boolean isIdentity() {
        return false;
    }

    public static boolean isIntIdIdentity(@Nullable Mappings mappings) {
        boolean bl;
        if (mappings == null) {
            return true;
        }
        if (mappings instanceof FullMappings) {
            FullMappings fullMappings = (FullMappings)mappings;
            bl = fullMappings.isIntIdIdentity();
        } else {
            bl = mappings.isIdentity();
        }
        return bl;
    }

    public static boolean isFullIdentity(@Nullable Mappings mappings) {
        return mappings == null || mappings.isIdentity();
    }
}

