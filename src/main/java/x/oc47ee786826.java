/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

public class oc47ee786826 {
    private final double \u0171;
    private final double \u01bc;
    private final double \u03cf;
    private final long \u015c;
    public static boolean \u021b;

    public oc47ee786826(double d, double d2, double d3, long l) {
        this.\u0171 = d;
        this.\u01bc = d2;
        this.\u03cf = d3;
        this.\u015c = l;
    }

    public double \u00f4() {
        return this.\u0171;
    }

    public double \u027a() {
        return this.\u01bc;
    }

    public double \u04a8() {
        return this.\u03cf;
    }

    public long r() {
        return this.\u015c;
    }

    public Vec3 \u0189() {
        return new Vec3(this.\u0171, this.\u01bc, this.\u03cf);
    }

    public AxisAlignedBB \u0511(AxisAlignedBB axisAlignedBB, Vec3 vec3) {
        return axisAlignedBB.offset(this.\u0171 - vec3.xCoord, this.\u01bc - vec3.yCoord, this.\u03cf - vec3.zCoord);
    }
}

