/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodecInputStream;

public class Base32InputStream
extends BaseNCodecInputStream {
    public Base32InputStream(InputStream inputStream2) {
        this(inputStream2, false);
    }

    public Base32InputStream(InputStream inputStream2, boolean bl) {
        super(inputStream2, new Base32(false), bl);
    }

    public Base32InputStream(InputStream inputStream2, boolean bl, int n, byte[] byArray) {
        super(inputStream2, new Base32(n, byArray), bl);
    }
}

