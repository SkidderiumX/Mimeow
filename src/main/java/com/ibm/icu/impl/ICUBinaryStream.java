/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.impl;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ICUBinaryStream
extends DataInputStream {
    public ICUBinaryStream(InputStream inputStream2, int n) {
        super(inputStream2);
        this.mark(n);
    }

    public ICUBinaryStream(byte[] byArray) {
        this(new ByteArrayInputStream(byArray), byArray.length);
    }

    public void seek(int n) throws IOException {
        this.reset();
        int n2 = this.skipBytes(n);
        if (n2 != n) {
            throw new IllegalStateException("Skip(" + n + ") only skipped " + n2 + " bytes");
        }
    }
}

