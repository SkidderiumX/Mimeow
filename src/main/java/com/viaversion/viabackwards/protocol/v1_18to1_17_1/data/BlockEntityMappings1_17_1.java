/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_18to1_17_1.data;

import com.viaversion.viaversion.protocols.v1_17_1to1_18.data.BlockEntityMappings1_18;
import java.util.Arrays;

public class BlockEntityMappings1_17_1 {
    private static final int[] IDS;

    public static int mappedId(int n) {
        if (n < 0 || n > IDS.length) {
            return -1;
        }
        return IDS[n];
    }

    static {
        int[] nArray = BlockEntityMappings1_18.getIds();
        IDS = new int[Arrays.stream(nArray).max().getAsInt() + 1];
        Arrays.fill(IDS, -1);
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            if (n == -1) continue;
            BlockEntityMappings1_17_1.IDS[n] = i;
        }
    }
}

