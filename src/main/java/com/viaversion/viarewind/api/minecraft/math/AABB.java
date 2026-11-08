/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.minecraft.math;

import com.viaversion.viarewind.api.minecraft.math.Vector3d;

public class AABB {
    Vector3d min;
    Vector3d max;

    public AABB(Vector3d vector3d, Vector3d vector3d2) {
        this.min = vector3d;
        this.max = vector3d2;
    }

    public Vector3d getMin() {
        return this.min;
    }

    public Vector3d getMax() {
        return this.max;
    }
}

