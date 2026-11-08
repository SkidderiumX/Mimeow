/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

public class Assert {
    public static void fail(Exception exception) {
        Assert.fail(exception.toString());
    }

    public static void fail(String string) {
        throw new IllegalStateException("failure '" + string + "'");
    }

    public static void assrt(boolean bl) {
        if (!bl) {
            throw new IllegalStateException("assert failed");
        }
    }

    public static void assrt(String string, boolean bl) {
        if (!bl) {
            throw new IllegalStateException("assert '" + string + "' failed");
        }
    }
}

