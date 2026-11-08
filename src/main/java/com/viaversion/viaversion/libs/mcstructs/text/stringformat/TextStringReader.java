/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.text.stringformat;

public class TextStringReader {
    private final String s;
    private int index;
    private int mark;

    public TextStringReader(String string) {
        this.s = string;
    }

    public int getIndex() {
        return this.index;
    }

    public int getLength() {
        return this.s.length();
    }

    public TextStringReader mark() {
        this.mark = this.index;
        return this;
    }

    public TextStringReader reset() {
        this.index = this.mark;
        return this;
    }

    public String getMark() {
        return this.s.substring(this.mark, this.index);
    }

    public boolean canRead() {
        return this.canRead(1);
    }

    public boolean canRead(int n) {
        return this.index + n <= this.s.length();
    }

    public char peek() {
        this.verifyIndex(1);
        return this.s.charAt(this.index);
    }

    public String peek(int n) {
        this.verifyIndex(n);
        return this.s.substring(this.index, Math.min(this.index + n, this.s.length()));
    }

    public char peekAt(int n) {
        this.verifyIndex(n);
        return this.s.charAt(this.index + n);
    }

    public TextStringReader skip() {
        this.verifyIndex(1);
        ++this.index;
        return this;
    }

    public TextStringReader skip(int n) {
        this.verifyIndex(n);
        this.index += n;
        return this;
    }

    public char read() {
        this.verifyIndex(1);
        return this.s.charAt(this.index++);
    }

    public String read(int n) {
        this.verifyIndex(n);
        String string = this.s.substring(this.index, Math.min(this.index + n, this.s.length()));
        this.index += n;
        return string;
    }

    public String readUntil(char c) {
        char c2;
        StringBuilder stringBuilder = new StringBuilder();
        while (this.canRead() && (c2 = this.peek()) != c) {
            this.skip();
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    private void verifyIndex(int n) {
        if (!this.canRead(n)) {
            throw new IndexOutOfBoundsException("Index " + (this.index + n + 1) + " out of bounds for length " + this.s.length());
        }
    }
}

