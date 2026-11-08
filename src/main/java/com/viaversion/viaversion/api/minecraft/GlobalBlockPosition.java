/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.BlockPosition;

public class GlobalBlockPosition
extends BlockPosition {
    private final String dimension;

    public GlobalBlockPosition(String string, int n, int n2, int n3) {
        super(n, n2, n3);
        this.dimension = string;
    }

    public String dimension() {
        return this.dimension;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        GlobalBlockPosition globalBlockPosition = (GlobalBlockPosition)object;
        if (this.x != globalBlockPosition.x) {
            return false;
        }
        if (this.y != globalBlockPosition.y) {
            return false;
        }
        if (this.z != globalBlockPosition.z) {
            return false;
        }
        return this.dimension.equals(globalBlockPosition.dimension);
    }

    @Override
    public int hashCode() {
        int n = this.dimension.hashCode();
        n = 31 * n + this.x;
        n = 31 * n + this.y;
        n = 31 * n + this.z;
        return n;
    }

    @Override
    public String toString() {
        return "GlobalBlockPosition{dimension='" + this.dimension + "', x=" + this.x + ", y=" + this.y + ", z=" + this.z + "}";
    }
}

