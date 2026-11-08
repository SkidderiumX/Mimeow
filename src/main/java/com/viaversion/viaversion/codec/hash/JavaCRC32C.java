/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.codec.hash;

import com.viaversion.viaversion.codec.hash.HashFunction;
import java.util.zip.CRC32C;

public class JavaCRC32C
implements HashFunction {
    private final CRC32C crc = new CRC32C();

    JavaCRC32C() {
    }

    @Override
    public int hashBytes(byte[] byArray, int n) {
        this.crc.reset();
        this.crc.update(byArray, 0, n);
        return (int)this.crc.getValue();
    }
}

