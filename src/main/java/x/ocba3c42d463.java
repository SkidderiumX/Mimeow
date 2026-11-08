/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Objects;
import x.oc1c3cf9b9ef;
import x.oc6261414a28;
import x.oc6972cf8b4b;
import x.oc9545d9ef48;

public class ocba3c42d463 {
    public static final String \u020c = "0x13cfd0: ucrtbase.dll!hypot";
    public static final String \u00cc = "0x13cfb0: ucrtbase.dll!atan2";
    public static final String \u039e = "0x13cfa0: ucrtbase.dll!acos";
    public static final String \u0186 = "0x13cfc0: ucrtbase.dll!atan2f";
    public static final String \u0405 = "0x13d190: ucrtbase.dll!acosf";
    public static final String \u026d = "0x13cfe0: ucrtbase.dll!powf";
    private static volatile oc6972cf8b4b \u027f = StrictMath::hypot;
    private static volatile oc6972cf8b4b \u0116 = StrictMath::atan2;
    private static volatile oc9545d9ef48 y = StrictMath::acos;
    private static volatile oc6261414a28 \u02af = (f, f2) -> (float)StrictMath.atan2(f, f2);
    private static volatile oc1c3cf9b9ef \u03d5 = f -> (float)StrictMath.acos(f);
    private static volatile oc6261414a28 \u03c3 = (f, f2) -> (float)StrictMath.pow(f, f2);

    private ocba3c42d463() {
    }

    public static double \u0236(double d, double d2) {
        return \u027f.z$2b43608yrzjem(d, d2);
    }

    public static double \u010a(double d, double d2) {
        return \u0116.z$2b43608yrzjem(d, d2);
    }

    public static double g(double d) {
        return y.z$3co5u52dxc0je(d);
    }

    public static float \u038c(float f, float f2) {
        return \u02af.z$11wqeiaykwznu(f, f2);
    }

    public static float \u02ae(float f) {
        return \u03d5.z$92xl56fx7wnk(f);
    }

    public static float \u00f1(float f, float f2) {
        return \u03c3.z$11wqeiaykwznu(f, f2);
    }

    public static oc6972cf8b4b \u0295(oc6972cf8b4b oc6972cf8b4b2) {
        oc6972cf8b4b oc6972cf8b4b3 = \u027f;
        \u027f = Objects.requireNonNull(oc6972cf8b4b2);
        return oc6972cf8b4b3;
    }

    public static oc6972cf8b4b \u0151(oc6972cf8b4b oc6972cf8b4b2) {
        oc6972cf8b4b oc6972cf8b4b3 = \u0116;
        \u0116 = Objects.requireNonNull(oc6972cf8b4b2);
        return oc6972cf8b4b3;
    }

    public static oc9545d9ef48 \u0110(oc9545d9ef48 oc9545d9ef482) {
        oc9545d9ef48 oc9545d9ef483 = y;
        y = Objects.requireNonNull(oc9545d9ef482);
        return oc9545d9ef483;
    }

    public static oc6261414a28 \u0412(oc6261414a28 oc6261414a282) {
        oc6261414a28 oc6261414a283 = \u02af;
        \u02af = Objects.requireNonNull(oc6261414a282);
        return oc6261414a283;
    }

    public static oc1c3cf9b9ef \u03a9(oc1c3cf9b9ef oc1c3cf9b9ef2) {
        oc1c3cf9b9ef oc1c3cf9b9ef3 = \u03d5;
        \u03d5 = Objects.requireNonNull(oc1c3cf9b9ef2);
        return oc1c3cf9b9ef3;
    }

    public static oc6261414a28 \u03c9(oc6261414a28 oc6261414a282) {
        oc6261414a28 oc6261414a283 = \u03c3;
        \u03c3 = Objects.requireNonNull(oc6261414a282);
        return oc6261414a283;
    }
}

