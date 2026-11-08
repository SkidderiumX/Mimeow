/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.binary;

import java.io.InputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodecInputStream;

public class Base64InputStream
extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream2) {
        this(inputStream2, false);
    }

    public Base64InputStream(InputStream inputStream2, boolean bl) {
        super(inputStream2, new Base64(false), bl);
    }

    public Base64InputStream(InputStream inputStream2, boolean bl, int n, byte[] byArray) {
        super(inputStream2, new Base64(n, byArray), bl);
    }
}

