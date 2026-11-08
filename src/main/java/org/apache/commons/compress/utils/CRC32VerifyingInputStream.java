/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.compress.utils;

import java.io.InputStream;
import java.util.zip.CRC32;
import org.apache.commons.compress.utils.ChecksumVerifyingInputStream;

public class CRC32VerifyingInputStream
extends ChecksumVerifyingInputStream {
    public CRC32VerifyingInputStream(InputStream inputStream2, long l, int n) {
        this(inputStream2, l, (long)n & 0xFFFFFFFFL);
    }

    public CRC32VerifyingInputStream(InputStream inputStream2, long l, long l2) {
        super(new CRC32(), inputStream2, l, l2);
    }
}

