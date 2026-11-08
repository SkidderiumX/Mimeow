/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft;

import com.viaversion.viaversion.api.minecraft.BlockFace;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;

public class BlockPosition {
    protected final int x;
    protected final int y;
    protected final int z;

    public BlockPosition(int n, int n2, int n3) {
        this.x = n;
        this.y = n2;
        this.z = n3;
    }

    public BlockPosition getRelative(BlockFace blockFace) {
        return new BlockPosition(this.x + blockFace.modX(), this.y + blockFace.modY(), this.z + blockFace.modZ());
    }

    public double distanceFromCenterSquared(double d, double d2, double d3) {
        double d4 = (double)this.x + 0.5 - d;
        double d5 = (double)this.y + 0.5 - d2;
        double d6 = (double)this.z + 0.5 - d3;
        return d4 * d4 + d5 * d5 + d6 * d6;
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public GlobalBlockPosition withDimension(String string) {
        return new GlobalBlockPosition(string, this.x, this.y, this.z);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        BlockPosition blockPosition = (BlockPosition)object;
        if (this.x != blockPosition.x) {
            return false;
        }
        if (this.y != blockPosition.y) {
            return false;
        }
        return this.z == blockPosition.z;
    }

    public int hashCode() {
        int n = this.x;
        n = 31 * n + this.y;
        n = 31 * n + this.z;
        return n;
    }

    public String toString() {
        return "BlockPosition{x=" + this.x + ", y=" + this.y + ", z=" + this.z + "}";
    }
}

