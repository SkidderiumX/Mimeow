/*
 * Decompiled with CFR 0.152.
 */
package x;

public enum oce1f9789a12 {
    \u0520,
    \u0143,
    \u0269;
    private static final oce1f9789a12[] $VALUES_REF;
    static {
        $VALUES_REF = oce1f9789a12.\u03ce();
    }





    private static oce1f9789a12 \u0436(int n) {
        oce1f9789a12[] oce1f9789a12Array = oce1f9789a12.values();
        return oce1f9789a12Array[Math.max(0, Math.min(oce1f9789a12Array.length - 1, n))];
    }

    private static oce1f9789a12[] \u03ce() {
        oce1f9789a12[] oce1f9789a12Array = new oce1f9789a12[0xAC845E74 ^ 0xAC845E77];
        oce1f9789a12Array[0] = \u0520;
        oce1f9789a12Array[1] = \u0143;
        oce1f9789a12Array[0xAC845E75 ^ 0xAC845E77] = \u0269;
        return oce1f9789a12Array;
    }
}

