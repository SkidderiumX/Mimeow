/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import x.oc5ef74a250d;
import x.oc952209182e;
import x.ocbcb3051b58;
import x.oceac7116ccd;

public class oc01be0c7606 {
    public static final String \u039c = "0x13cfd0: ucrtbase.dll!hypot";
    public static final String \u0454 = "0x13cfb0: ucrtbase.dll!atan2";
    public static final String \u0114 = "0x13cfa0: ucrtbase.dll!acos";
    public static final String \u0467 = "0x13cfc0: ucrtbase.dll!atan2f";
    public static final String \u01b5 = "0x13d190: ucrtbase.dll!acosf";
    public static final String \u0510 = "0x13cfe0: ucrtbase.dll!powf";
    private static volatile ocbcb3051b58 \u049a = StrictMath::hypot;
    private static volatile ocbcb3051b58 \u050c = StrictMath::atan2;
    private static volatile oc5ef74a250d \u022c = StrictMath::acos;
    private static volatile oc952209182e \u010d = (f, f2) -> (float)StrictMath.atan2(f, f2);
    private static volatile oceac7116ccd \u021e = f -> (float)StrictMath.acos(f);
    private static volatile oc952209182e \u0172 = (f, f2) -> (float)StrictMath.pow(f, f2);
    public static int \u017a;

    private oc01be0c7606() {
    }

    public static double \u01d8(double d, double d2) {
        return \u049a.z$1e5sn8e4kqgkm(d, d2);
    }

    public static double \u03f5(double d, double d2) {
        return \u050c.z$1e5sn8e4kqgkm(d, d2);
    }

    public static double \u0133(double d) {
        return \u022c.z$2bwdju55lw81d(d);
    }

    public static float \u04ad(float f, float f2) {
        return \u010d.z$2b5pisbcrrcwy(f, f2);
    }

    public static float \u0431(float f) {
        return \u021e.z$yv9fy6586vg6(f);
    }

    public static float \u0156(float f, float f2) {
        return \u0172.z$2b5pisbcrrcwy(f, f2);
    }

    public static ocbcb3051b58 \u0574(ocbcb3051b58 ocbcb3051b582) {
        ocbcb3051b58 ocbcb3051b583 = \u049a;
        \u049a = Objects.requireNonNull(ocbcb3051b582);
        return ocbcb3051b583;
    }

    public static ocbcb3051b58 \u04dc(ocbcb3051b58 ocbcb3051b582) {
        ocbcb3051b58 ocbcb3051b583 = \u050c;
        \u050c = Objects.requireNonNull(ocbcb3051b582);
        return ocbcb3051b583;
    }

    public static oc5ef74a250d \u03d3(oc5ef74a250d oc5ef74a250d2) {
        oc5ef74a250d oc5ef74a250d3 = \u022c;
        \u022c = Objects.requireNonNull(oc5ef74a250d2);
        return oc5ef74a250d3;
    }

    public static oc952209182e \u0149(oc952209182e oc952209182e2) {
        oc952209182e oc952209182e3 = \u010d;
        \u010d = Objects.requireNonNull(oc952209182e2);
        return oc952209182e3;
    }

    public static oceac7116ccd \u00eb(oceac7116ccd oceac7116ccd2) {
        oceac7116ccd oceac7116ccd3 = \u021e;
        \u021e = Objects.requireNonNull(oceac7116ccd2);
        return oceac7116ccd3;
    }

    public static oc952209182e \u04aa(oc952209182e oc952209182e2) {
        oc952209182e oc952209182e3 = \u0172;
        \u0172 = Objects.requireNonNull(oc952209182e2);
        return oc952209182e3;
    }
}

