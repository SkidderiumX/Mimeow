/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_3to1_20_5.data;

import com.viaversion.viaversion.util.KeyMappings;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ArmorMaterials1_20_5 {
    private static final KeyMappings MATERIALS = new KeyMappings("leather", "chainmail", "iron", "gold", "diamond", "turtle", "netherite", "armadillo");

    public static @Nullable String idToKey(int n) {
        return MATERIALS.idToKey(n);
    }

    public static int keyToId(String string) {
        return MATERIALS.keyToId(string);
    }
}

