/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.fastutil.longs;

public interface LongHash {

    public static interface Strategy {
        public int hashCode(long var1);

        public boolean equals(long var1, long var3);
    }
}

