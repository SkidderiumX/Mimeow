/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.math.BigInteger;

public class ocf2ca791e23 {
    private static final BigInteger C = BigInteger.ONE.shiftLeft(0x926D545A ^ 0x926D541A);

    private ocf2ca791e23() {
    }

    private static BigInteger \u0548(long l) {
        BigInteger bigInteger = BigInteger.valueOf(l);
        return l < 0L ? bigInteger.add(C) : bigInteger;
    }

    public static long \u0490(long l, long l2) {
        return ocf2ca791e23.\u0548(l).multiply(ocf2ca791e23.\u0548(l2)).shiftRight(0x516D1FC1 ^ 0x516D1F81).longValue();
    }

    public static long \u020f(long l, long l2) {
        return BigInteger.valueOf(l).multiply(BigInteger.valueOf(l2)).shiftRight(0x6814DCA2 ^ 0x6814DCE2).longValue();
    }
}

