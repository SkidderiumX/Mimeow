/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.HashFunction;

@Deprecated
public class FallbackCRC32C
implements HashFunction {
    private static final int[] CRC32C_TABLE = new int[256];

    FallbackCRC32C() {
    }

    @Override
    public int hashBytes(byte[] byArray, int n) {
        int n2 = -1;
        for (int i = 0; i < n; ++i) {
            byte by = byArray[i];
            int n3 = (n2 ^ by) & 0xFF;
            n2 = n2 >>> 8 ^ CRC32C_TABLE[n3];
        }
        return ~n2;
    }

    static {
        for (int i = 0; i < 256; ++i) {
            int n = i;
            for (int j = 0; j < 8; ++j) {
                if ((n & 1) == 1) {
                    n = n >>> 1 ^ 0x82F63B78;
                    continue;
                }
                n >>>= 1;
            }
            FallbackCRC32C.CRC32C_TABLE[i] = n;
        }
    }
}

