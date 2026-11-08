/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc69da1aa7f5;

public class oc5f6ebca44f {
    private static final int[] \u0198 = new int[0x1EFACB4E ^ 0x1EFA8B4F];
    private static float \u03ef;
    public static int \u03f4;

    private oc5f6ebca44f() {
    }

    public static void \u0539(float[] fArray) {
        int n;
        for (n = 0; n < \u0198.length; ++n) {
            oc5f6ebca44f.\u0198[n] = Float.floatToRawIntBits(fArray[n]);
        }
        \u03ef = fArray[fArray.length / (0x95EBE0BF ^ 0x95EBE0BD)];
        n = 0;
        while (true) {
            block8: {
                if (n >= fArray.length) break;
                if (fArray[n] == oc5f6ebca44f.\u040d(n)) break block8;
                throw new IllegalStateException("Sine lookup mismatch at index " + n);
            }
            ++n;
        }
    }

    public static float \u03c1(float f) {
        int n = \u03f4;
        float f2 = oc5f6ebca44f.\u040d((int)(f * 10430.378f) & (0x1D6D96E8 ^ 0x1D6D6917));
        if (false) {
            \u03f4 = ++n;
        }
        return f2;
    }

    public static float \u024a(float f) {
        float f2;
        block4: {
            boolean bl;
            block6: {
                block5: {
                    int n = \u03f4;
                    f2 = oc5f6ebca44f.\u040d((int)(f * 10430.378f + 16384.0f) & (0xDB255C45 ^ 0xDB25A3BA));
                    if (n == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
        return f2;
    }

    private static float \u040d(int n) {
        if (n == (0x6545F11D ^ 0x6545711D)) {
            return \u03ef;
        }
        int n2 = (n & (0x6545F11D ^ 0x6545711D)) << (0x6545710D ^ 0x6545711D);
        int n3 = n << (0x6545710C ^ 0x6545711D) >> (0x65457102 ^ 0x6545711D);
        int n4 = ((0x6545F11C ^ 0x6545711D) & n3) + (n ^ n3);
        return Float.intBitsToFloat(\u0198[n4 & (0x65450EE2 ^ 0x6545711D)] ^ n2);
    }
}

