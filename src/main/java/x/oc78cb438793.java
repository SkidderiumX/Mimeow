/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.ThreadLocalRandom;
import x.oc75d51ec7eb;

public class oc78cb438793 {
    private static final int[] \u0418 = oc78cb438793.\u0392();
    public static boolean Z;

    private oc78cb438793() {
    }

    private static int[] \u0392() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int[] nArray = new int[0xA1F320DD ^ 0xA1F320D9];
        nArray[0] = threadLocalRandom.nextInt();
        nArray[1] = threadLocalRandom.nextInt();
        nArray[0xA1F320DB ^ 0xA1F320D9] = threadLocalRandom.nextInt();
        nArray[0xA1F320DA ^ 0xA1F320D9] = threadLocalRandom.nextInt();
        int[] nArray2 = nArray;
        if ((nArray2[0] | nArray2[1] | nArray2[0xA1F320DB ^ 0xA1F320D9] | nArray2[0xA1F320DA ^ 0xA1F320D9]) == 0) {
            nArray2[0] = 0x3FC45960 ^ 0xA1F320D9;
        }
        return nArray2;
    }

    public static synchronized float \u04ad() {
        int n = \u0418[0];
        int n2 = \u0418[1];
        int n3 = \u0418[0xB1091465 ^ 0xB1091467];
        int n4 = \u0418[0xB1091464 ^ 0xB1091467];
        int n5 = n + n4;
        int n6 = n2 << (0xB109146E ^ 0xB1091467);
        int n7 = n ^ n3;
        int n8 = n2 ^ n4;
        oc78cb438793.\u0418[1] = n7 ^ n2;
        oc78cb438793.\u0418[0] = n ^ n8;
        oc78cb438793.\u0418[0xB1091465 ^ 0xB1091467] = n6 ^ n7;
        oc78cb438793.\u0418[0xB1091464 ^ 0xB1091467] = Integer.rotateLeft(n8, 0xB109146C ^ 0xB1091467);
        return (float)(n5 >>> (0xB109146F ^ 0xB1091467)) * 5.9604645E-8f;
    }

    public static synchronized boolean \u04ea(float f) {
        float f2;
        block2: {
            block3: {
                float f3 = oc78cb438793.\u04ad();
                int n = oc75d51ec7eb.\u03e9;
                f2 = f == f3 ? 0 : (f > f3 ? 1 : -1);
                if (n != 0) break block2;
                if (f2 <= 0) break block3;
                f2 = 1.0f;
                break block2;
            }
            f2 = 0.0f;
        }
        return (boolean)f2;
    }
}

