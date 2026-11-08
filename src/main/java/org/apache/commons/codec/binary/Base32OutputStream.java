/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.BaseNCodecOutputStream;

public class Base32OutputStream
extends BaseNCodecOutputStream {
    public Base32OutputStream(OutputStream outputStream2) {
        this(outputStream2, true);
    }

    public Base32OutputStream(OutputStream outputStream2, boolean bl) {
        super(outputStream2, new Base32(false), bl);
    }

    public Base32OutputStream(OutputStream outputStream2, boolean bl, int n, byte[] byArray) {
        super(outputStream2, new Base32(n, byArray), bl);
    }
}

