/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.security.SecureRandom;

public class oca6eae151db {
    public static final oca6eae151db \u0151 = oca6eae151db.\u00c4();
    private int \u0587;
    private int \u03f3;
    private int \u0112;
    private int \u039f;
    public static boolean \u0237;

    public oca6eae151db(int n, int n2, int n3, int n4) {
        if ((n | n2 | n3 | n4) == 0) {
            throw new IllegalArgumentException("zero random state");
        }
        this.\u0587 = n;
        this.\u03f3 = n2;
        this.\u0112 = n3;
        this.\u039f = n4;
    }

    private static oca6eae151db \u00c4() {
        int n;
        int n2;
        int n3;
        SecureRandom secureRandom = new SecureRandom();
        int n4 = secureRandom.nextInt();
        if ((n4 | (n3 = secureRandom.nextInt()) | (n2 = secureRandom.nextInt()) | (n = secureRandom.nextInt())) == 0) {
            n = 1;
        }
        return new oca6eae151db(n4, n3, n2, n);
    }

    public static double \u03ea() {
        return (double)System.nanoTime() / 1.0E9;
    }

    private int \u020f() {
        int n = this.\u039f + this.\u0587;
        int n2 = Integer.rotateLeft(this.\u03f3 ^ this.\u039f, 0xF258DE78 ^ 0xF258DE73);
        int n3 = this.\u0112 ^ this.\u0587 ^ this.\u03f3;
        int n4 = this.\u0587 ^ this.\u03f3 ^ this.\u039f;
        int n5 = this.\u0112 ^ this.\u0587 ^ this.\u03f3 << (0xF258DE7A ^ 0xF258DE73);
        this.\u0587 = n4;
        this.\u03f3 = n3;
        this.\u0112 = n5;
        this.\u039f = n2;
        return n;
    }

    public float \u015d(float f, float f2) {
        float f3 = f2 - f;
        float f4 = this.\u020f() >>> (0xED2C03D0 ^ 0xED2C03D8);
        f4 *= 5.9604645E-8f;
        return (f4 *= f3) + f;
    }

    public boolean \u03ec(float f) {
        float f2;
        block2: {
            block3: {
                boolean bl = \u0237;
                float f3 = f - this.\u015d(0.0f, 1.0f);
                f2 = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                if (bl) break block2;
                if (f2 <= 0) break block3;
                f2 = 1.0f;
                break block2;
            }
            f2 = 0.0f;
        }
        return (boolean)f2;
    }

    public int[] \u020e() {
        int[] nArray = new int[0xA7A6D0F3 ^ 0xA7A6D0F7];
        nArray[0] = this.\u0587;
        nArray[1] = this.\u03f3;
        nArray[0xA7A6D0F5 ^ 0xA7A6D0F7] = this.\u0112;
        nArray[0xA7A6D0F4 ^ 0xA7A6D0F7] = this.\u039f;
        return nArray;
    }
}

