/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.lang3;

import java.util.Random;
import org.apache.commons.lang3.Validate;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static byte[] nextBytes(int n) {
        Validate.isTrue(n >= 0, "Count cannot be negative.", new Object[0]);
        byte[] byArray = new byte[n];
        RANDOM.nextBytes(byArray);
        return byArray;
    }

    public static int nextInt(int n, int n2) {
        Validate.isTrue(n2 >= n, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(n >= 0, "Both range values must be non-negative.", new Object[0]);
        if (n == n2) {
            return n;
        }
        return n + RANDOM.nextInt(n2 - n);
    }

    public static long nextLong(long l, long l2) {
        Validate.isTrue(l2 >= l, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(l >= 0L, "Both range values must be non-negative.", new Object[0]);
        if (l == l2) {
            return l;
        }
        return (long)RandomUtils.nextDouble(l, l2);
    }

    public static double nextDouble(double d, double d2) {
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d >= 0.0, "Both range values must be non-negative.", new Object[0]);
        if (d == d2) {
            return d;
        }
        return d + (d2 - d) * RANDOM.nextDouble();
    }

    public static float nextFloat(float f, float f2) {
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f >= 0.0f, "Both range values must be non-negative.", new Object[0]);
        if (f == f2) {
            return f;
        }
        return f + (f2 - f) * RANDOM.nextFloat();
    }
}

