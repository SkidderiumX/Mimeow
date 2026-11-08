/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.io.output;

import java.io.Writer;

public class NullWriter
extends Writer {
    public static final NullWriter NULL_WRITER = new NullWriter();

    @Override
    public Writer append(char c) {
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence, int n, int n2) {
        return this;
    }

    @Override
    public Writer append(CharSequence charSequence) {
        return this;
    }

    @Override
    public void write(int n) {
    }

    @Override
    public void write(char[] cArray) {
    }

    @Override
    public void write(char[] cArray, int n, int n2) {
    }

    @Override
    public void write(String string) {
    }

    @Override
    public void write(String string, int n, int n2) {
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }
}

