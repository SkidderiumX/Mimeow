/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.codec.binary;

import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.BaseNCodecOutputStream;

public class Base64OutputStream
extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream2) {
        this(outputStream2, true);
    }

    public Base64OutputStream(OutputStream outputStream2, boolean bl) {
        super(outputStream2, new Base64(false), bl);
    }

    public Base64OutputStream(OutputStream outputStream2, boolean bl, int n, byte[] byArray) {
        super(outputStream2, new Base64(n, byArray), bl);
    }
}

