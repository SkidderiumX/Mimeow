/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.api.minecraft.math;

import com.viaversion.viarewind.api.minecraft.math.AABB;
import com.viaversion.viarewind.api.minecraft.math.Ray3d;
import com.viaversion.viarewind.api.minecraft.math.Vector3d;

public class RayTracing {
    public static Vector3d trace(Ray3d ray3d, AABB aABB, double d) {
        Vector3d vector3d = new Vector3d(1.0 / ray3d.dir.x, 1.0 / ray3d.dir.y, 1.0 / ray3d.dir.z);
        boolean bl = vector3d.x < 0.0;
        boolean bl2 = vector3d.y < 0.0;
        boolean bl3 = vector3d.z < 0.0;
        Vector3d vector3d2 = bl ? aABB.max : aABB.min;
        double d2 = (vector3d2.x - ray3d.start.x) * vector3d.x;
        vector3d2 = bl ? aABB.min : aABB.max;
        double d3 = (vector3d2.x - ray3d.start.x) * vector3d.x;
        vector3d2 = bl2 ? aABB.max : aABB.min;
        double d4 = (vector3d2.y - ray3d.start.y) * vector3d.y;
        vector3d2 = bl2 ? aABB.min : aABB.max;
        double d5 = (vector3d2.y - ray3d.start.y) * vector3d.y;
        if (d2 > d5 || d4 > d3) {
            return null;
        }
        if (d4 > d2) {
            d2 = d4;
        }
        if (d5 < d3) {
            d3 = d5;
        }
        vector3d2 = bl3 ? aABB.max : aABB.min;
        double d6 = (vector3d2.z - ray3d.start.z) * vector3d.z;
        vector3d2 = bl3 ? aABB.min : aABB.max;
        double d7 = (vector3d2.z - ray3d.start.z) * vector3d.z;
        if (d2 > d7 || d6 > d3) {
            return null;
        }
        if (d6 > d2) {
            d2 = d6;
        }
        if (d7 < d3) {
            d3 = d7;
        }
        return d2 <= d && d3 > 0.0 ? ray3d.start.clone().add(ray3d.dir.clone().normalize().multiply(d2)) : null;
    }
}

