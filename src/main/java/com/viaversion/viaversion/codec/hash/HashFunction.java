/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.FallbackCRC32C;
import com.viaversion.viaversion.codec.hash.JavaCRC32C;

@FunctionalInterface
public interface HashFunction {
    public static HashFunction crc32c() {
        return Runtime.version().feature() < 9 ? new FallbackCRC32C() : new JavaCRC32C();
    }

    public int hashBytes(byte[] var1, int var2);

    default public int hashBytes(byte[] byArray) {
        return this.hashBytes(byArray, byArray.length);
    }
}

