/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

public class MathUtil {
    public static final float EPSILON = 1.0E-5f;

    public static int ceil(float f) {
        int n = (int)f;
        return f > (float)n ? n + 1 : n;
    }

    public static int ceilLog2(int n) {
        return n > 0 ? 32 - Integer.numberOfLeadingZeros(n - 1) : 0;
    }

    public static long ceilLong(double d) {
        long l = (long)d;
        return d > (double)l ? l + 1L : l;
    }

    public static int clamp(int n, int n2, int n3) {
        if (n < n2) {
            return n2;
        }
        return n > n3 ? n3 : n;
    }

    public static double clamp(double d, double d2, double d3) {
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    public static long clamp(long l, long l2, long l3) {
        if (l < l2) {
            return l2;
        }
        return l > l3 ? l3 : l;
    }
}

