/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import com.ibm.icu.text.UCharacterIterator;

public class BOCU {
    private static final int SLOPE_MIN_ = 3;
    private static final int SLOPE_MAX_ = 255;
    private static final int SLOPE_MIDDLE_ = 129;
    private static final int SLOPE_TAIL_COUNT_ = 253;
    private static final int SLOPE_SINGLE_ = 80;
    private static final int SLOPE_LEAD_2_ = 42;
    private static final int SLOPE_LEAD_3_ = 3;
    private static final int SLOPE_REACH_POS_1_ = 80;
    private static final int SLOPE_REACH_NEG_1_ = -80;
    private static final int SLOPE_REACH_POS_2_ = 10667;
    private static final int SLOPE_REACH_NEG_2_ = -10668;
    private static final int SLOPE_REACH_POS_3_ = 192785;
    private static final int SLOPE_REACH_NEG_3_ = -192786;
    private static final int SLOPE_START_POS_2_ = 210;
    private static final int SLOPE_START_POS_3_ = 252;
    private static final int SLOPE_START_NEG_2_ = 49;
    private static final int SLOPE_START_NEG_3_ = 7;

    public static int compress(String string, byte[] byArray, int n) {
        int n2 = 0;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(string);
        int n3 = uCharacterIterator.nextCodePoint();
        while (n3 != -1) {
            n2 = n2 < 19968 || n2 >= 40960 ? (n2 & 0xFFFFFF80) - -80 : 30292;
            n = BOCU.writeDiff(n3 - n2, byArray, n);
            n2 = n3;
            n3 = uCharacterIterator.nextCodePoint();
        }
        return n;
    }

    public static int getCompressionLength(String string) {
        int n = 0;
        int n2 = 0;
        UCharacterIterator uCharacterIterator = UCharacterIterator.getInstance(string);
        int n3 = uCharacterIterator.nextCodePoint();
        while (n3 != -1) {
            n = n < 19968 || n >= 40960 ? (n & 0xFFFFFF80) - -80 : 30292;
            n3 = uCharacterIterator.nextCodePoint();
            n2 += BOCU.lengthOfDiff(n3 - n);
            n = n3;
        }
        return n2;
    }

    private BOCU() {
    }

    private static final long getNegDivMod(int n, int n2) {
        int n3 = n % n2;
        long l = n / n2;
        if (n3 < 0) {
            --l;
            n3 += n2;
        }
        return l << 32 | (long)n3;
    }

    private static final int writeDiff(int n, byte[] byArray, int n2) {
        if (n >= -80) {
            if (n <= 80) {
                byArray[n2++] = (byte)(129 + n);
            } else if (n <= 10667) {
                byArray[n2++] = (byte)(210 + n / 253);
                byArray[n2++] = (byte)(3 + n % 253);
            } else if (n <= 192785) {
                byArray[n2 + 2] = (byte)(3 + n % 253);
                byArray[n2 + 1] = (byte)(3 + (n /= 253) % 253);
                byArray[n2] = (byte)(252 + n / 253);
                n2 += 3;
            } else {
                byArray[n2 + 3] = (byte)(3 + n % 253);
                byArray[n2] = (byte)(3 + (n /= 253) % 253);
                byArray[n2 + 1] = (byte)(3 + (n /= 253) % 253);
                byArray[n2] = -1;
                n2 += 4;
            }
        } else {
            long l = BOCU.getNegDivMod(n, 253);
            int n3 = (int)l;
            if (n >= -10668) {
                n = (int)(l >> 32);
                byArray[n2++] = (byte)(49 + n);
                byArray[n2++] = (byte)(3 + n3);
            } else if (n >= -192786) {
                byArray[n2 + 2] = (byte)(3 + n3);
                n = (int)(l >> 32);
                l = BOCU.getNegDivMod(n, 253);
                n3 = (int)l;
                n = (int)(l >> 32);
                byArray[n2 + 1] = (byte)(3 + n3);
                byArray[n2] = (byte)(7 + n);
                n2 += 3;
            } else {
                byArray[n2 + 3] = (byte)(3 + n3);
                n = (int)(l >> 32);
                l = BOCU.getNegDivMod(n, 253);
                n3 = (int)l;
                n = (int)(l >> 32);
                byArray[n2 + 2] = (byte)(3 + n3);
                l = BOCU.getNegDivMod(n, 253);
                n3 = (int)l;
                byArray[n2 + 1] = (byte)(3 + n3);
                byArray[n2] = 3;
                n2 += 4;
            }
        }
        return n2;
    }

    private static final int lengthOfDiff(int n) {
        if (n >= -80) {
            if (n <= 80) {
                return 1;
            }
            if (n <= 10667) {
                return 2;
            }
            if (n <= 192785) {
                return 3;
            }
            return 4;
        }
        if (n >= -10668) {
            return 2;
        }
        if (n >= -192786) {
            return 3;
        }
        return 4;
    }
}

