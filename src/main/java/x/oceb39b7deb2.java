/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Vec3;

public class oceb39b7deb2 {
    final double \u00e7;
    final double \u02a4;
    final double \u019e;
    final boolean \u0506;

    oceb39b7deb2(double d, double d2, double d3, boolean bl) {
        this.\u00e7 = d;
        this.\u02a4 = d2;
        this.\u019e = d3;
        this.\u0506 = bl;
    }

    Vec3 \u024c() {
        Vec3 vec3;
        Vec3 vec32 = vec3;
        Vec3 vec33 = vec3;
        double d = this.\u00e7;
        double d2 = this.\u02a4;
        double d3 = this.\u0506 ? 1.54 : 1.62;
        vec32(d, d2 + d3, this.\u019e);
        return vec33;
    }
}

