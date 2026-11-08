/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.snbt.exceptions;

public class SNbtDeserializeException
extends Exception {
    private static String trim(String string, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = Math.min(string.length(), n);
        if (n2 > 35) {
            stringBuilder.append("...");
        }
        stringBuilder.append(string, Math.max(0, n2 - 35), n2).append("<--[HERE]");
        return stringBuilder.toString();
    }

    public SNbtDeserializeException(String string) {
        super(string);
    }

    public SNbtDeserializeException(String string, String string2, int n) {
        super(string + " at: " + SNbtDeserializeException.trim(string2, n));
    }
}

