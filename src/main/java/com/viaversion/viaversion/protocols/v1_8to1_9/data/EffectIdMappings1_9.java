/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.data;

import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntOpenHashMap;

public class EffectIdMappings1_9 {
    private static final Int2IntMap EFFECTS = new Int2IntOpenHashMap(19);

    public static int getNewId(int n) {
        return EFFECTS.getOrDefault(n, n);
    }

    public static boolean contains(int n) {
        return EFFECTS.containsKey(n);
    }

    private static void addRewrite(int n, int n2) {
        EFFECTS.put(n, n2);
    }

    static {
        EffectIdMappings1_9.addRewrite(1005, 1010);
        EffectIdMappings1_9.addRewrite(1003, 1005);
        EffectIdMappings1_9.addRewrite(1006, 1011);
        EffectIdMappings1_9.addRewrite(1004, 1009);
        EffectIdMappings1_9.addRewrite(1007, 1015);
        EffectIdMappings1_9.addRewrite(1008, 1016);
        EffectIdMappings1_9.addRewrite(1009, 1016);
        EffectIdMappings1_9.addRewrite(1010, 1019);
        EffectIdMappings1_9.addRewrite(1011, 1020);
        EffectIdMappings1_9.addRewrite(1012, 1021);
        EffectIdMappings1_9.addRewrite(1014, 1024);
        EffectIdMappings1_9.addRewrite(1015, 1025);
        EffectIdMappings1_9.addRewrite(1016, 1026);
        EffectIdMappings1_9.addRewrite(1017, 1027);
        EffectIdMappings1_9.addRewrite(1020, 1029);
        EffectIdMappings1_9.addRewrite(1021, 1030);
        EffectIdMappings1_9.addRewrite(1022, 1031);
        EffectIdMappings1_9.addRewrite(1013, 1023);
        EffectIdMappings1_9.addRewrite(1018, 1028);
    }
}

