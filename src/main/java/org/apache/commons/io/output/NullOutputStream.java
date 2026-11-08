/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.IOException;
import java.io.OutputStream;

public class NullOutputStream
extends OutputStream {
    public static final NullOutputStream NULL_OUTPUT_STREAM = new NullOutputStream();

    @Override
    public void write(byte[] byArray, int n, int n2) {
    }

    @Override
    public void write(int n) {
    }

    @Override
    public void write(byte[] byArray) throws IOException {
    }
}

