/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.AxisAlignedBB;

public class oce673b272fb {
    private final double \u04e4;
    private final double \u010f;
    private final double \u0373;
    private final boolean \u0441;
    private final boolean \u0388;
    private final boolean \u03df;
    private final boolean \u0400;
    private final boolean \u047f;
    private final boolean \u00e0;
    private final AxisAlignedBB \u0117;
    public static boolean \u0512;

    public oce673b272fb(double d, double d2, double d3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, AxisAlignedBB axisAlignedBB) {
        this.\u04e4 = d;
        this.\u010f = d2;
        this.\u0373 = d3;
        this.\u0441 = bl;
        this.\u0388 = bl2;
        this.\u03df = bl3;
        this.\u0400 = bl4;
        this.\u047f = bl5;
        this.\u00e0 = bl6;
        this.\u0117 = axisAlignedBB;
    }

    public double \u0574() {
        return this.\u04e4;
    }

    public double \u04b2() {
        return this.\u010f;
    }

    public double b() {
        return this.\u0373;
    }

    public boolean w() {
        return this.\u0441;
    }

    public boolean \u0254() {
        return this.\u0388;
    }

    public boolean \u046d() {
        return this.\u03df;
    }

    public boolean \u047a() {
        return this.\u0400;
    }

    public boolean \u00d6() {
        return this.\u047f;
    }

    public boolean \u03ea() {
        return this.\u00e0;
    }

    public AxisAlignedBB \u011a() {
        return this.\u0117;
    }

    public double \u03e0() {
        return (this.\u0117.maxX + this.\u0117.minX) * 0.5;
    }

    public double \u01b5() {
        return this.\u0117.minY;
    }

    public double \u00d5() {
        return (this.\u0117.maxZ + this.\u0117.minZ) * 0.5;
    }
}

