/*
 * Decompiled with CFR 0.152.
 */
package x;

public class oc08592ac73b {
    private static final float \u0148 = 120.0f;
    private static final float \u0472 = 0.25f;

    private oc08592ac73b() {
    }

    public static int \u0546(int n, int n2, int n3) {
        return oc08592ac73b.\u0525(n, n2, n3);
    }

    public static int \u0493(int n, int n2, int n3) {
        int n4 = oc08592ac73b.\u0525(n, n2, n3);
        return Math.max(0, n3 - n4 - 1);
    }

    public static float \u03d0(int n) {
        if (n == 0) {
            return 0.0f;
        }
        float f = (float)n / 120.0f;
        float f2 = Math.max(0.25f, Math.abs(f));
        return Math.copySign(f2, f);
    }

    public static float \u02b5(int n, double d) {
        return oc08592ac73b.\u03d0(n) * (float)Math.max(0.0, d);
    }

    private static int \u0525(int n, int n2, int n3) {
        if (n3 <= 1 || n2 <= 1) {
            return 0;
        }
        long l = (long)Math.max(0, n) * (long)n3 / (long)n2;
        return (int)Math.max(0L, Math.min((long)n3 - 1L, l));
    }
}

