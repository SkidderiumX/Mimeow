/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash.function;

import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashCode;
import com.viaversion.viaversion.libs.mcstructs.converter.hash.HashFunction;

public class CRC32C
extends HashFunction {
    private static final int[] CRC32C_TABLE = new int[256];

    @Override
    public HashCode hash(byte[] byArray) {
        int n = -1;
        for (byte by : byArray) {
            int n2 = (n ^ by) & 0xFF;
            n = n >>> 8 ^ CRC32C_TABLE[n2];
        }
        return HashCode.of(~n);
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
            com.viaversion.viaversion.libs.mcstructs.converter.hash.function.CRC32C.CRC32C_TABLE[i] = n;
        }
    }
}

