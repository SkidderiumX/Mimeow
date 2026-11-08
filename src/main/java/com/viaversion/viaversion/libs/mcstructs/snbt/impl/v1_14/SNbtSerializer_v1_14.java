/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_14;

import com.viaversion.viaversion.libs.mcstructs.snbt.impl.v1_12.SNbtSerializer_v1_12;

public class SNbtSerializer_v1_14
extends SNbtSerializer_v1_12 {
    @Override
    protected String escape(String string) {
        char[] cArray;
        StringBuilder stringBuilder = new StringBuilder(" ");
        int n = 0;
        for (int n2 : cArray = string.toCharArray()) {
            if (n2 == 92) {
                stringBuilder.append("\\");
            } else if (n2 == 34 || n2 == 39) {
                if (n == 0) {
                    n = n2 == 34 ? 39 : 34;
                }
                if (n == n2) {
                    stringBuilder.append("\\");
                }
            }
            stringBuilder.append((char)n2);
        }
        if (n == 0) {
            n = 34;
        }
        stringBuilder.setCharAt(0, (char)n);
        stringBuilder.append((char)n);
        return stringBuilder.toString();
    }
}

