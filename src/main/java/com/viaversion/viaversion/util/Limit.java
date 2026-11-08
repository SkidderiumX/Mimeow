/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

public class Limit {
    public static int max(int n, int n2) {
        if (n > n2) {
            throw new IllegalArgumentException("Value " + n + " is higher than the maximum " + n2);
        }
        return n;
    }
}

