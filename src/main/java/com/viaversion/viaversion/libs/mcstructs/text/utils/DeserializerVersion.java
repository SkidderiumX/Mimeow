/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.utils;

public enum DeserializerVersion {
    V1_6,
    V1_7,
    V1_8,
    V1_9,
    V1_12,
    V1_14,
    V1_15,
    V1_16,
    V1_17,
    V1_18,
    V1_19_4,
    V1_20_3,
    V1_20_5,
    V1_21_2,
    V1_21_4,
    V1_21_5;


    public boolean isIn(DeserializerVersion ... deserializerVersionArray) {
        for (DeserializerVersion deserializerVersion : deserializerVersionArray) {
            if (this != deserializerVersion) continue;
            return true;
        }
        return false;
    }

    public static DeserializerVersion[] ranged(DeserializerVersion deserializerVersion, DeserializerVersion deserializerVersion2) {
        int n;
        int n2 = deserializerVersion == null ? 0 : deserializerVersion.ordinal();
        int n3 = n = deserializerVersion2 == null ? DeserializerVersion.values().length - 1 : deserializerVersion2.ordinal();
        if (n2 > n) {
            throw new IllegalArgumentException("The 'from' version must be lower than the 'to' version");
        }
        DeserializerVersion[] deserializerVersionArray = new DeserializerVersion[n - n2 + 1];
        System.arraycopy(DeserializerVersion.values(), n2, deserializerVersionArray, 0, deserializerVersionArray.length);
        return deserializerVersionArray;
    }
}

