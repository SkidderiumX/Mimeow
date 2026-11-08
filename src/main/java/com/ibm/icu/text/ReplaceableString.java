/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.icu.text;

import com.ibm.icu.text.Replaceable;
import com.ibm.icu.text.UTF16;

public class ReplaceableString
implements Replaceable {
    private StringBuffer buf;

    public ReplaceableString(String string) {
        this.buf = new StringBuffer(string);
    }

    public ReplaceableString(StringBuffer stringBuffer) {
        this.buf = stringBuffer;
    }

    public ReplaceableString() {
        this.buf = new StringBuffer();
    }

    public String toString() {
        return this.buf.toString();
    }

    public String substring(int n, int n2) {
        return this.buf.substring(n, n2);
    }

    public int length() {
        return this.buf.length();
    }

    public char charAt(int n) {
        return this.buf.charAt(n);
    }

    public int char32At(int n) {
        return UTF16.charAt(this.buf, n);
    }

    public void getChars(int n, int n2, char[] cArray, int n3) {
        if (n != n2) {
            this.buf.getChars(n, n2, cArray, n3);
        }
    }

    public void replace(int n, int n2, String string) {
        this.buf.replace(n, n2, string);
    }

    public void replace(int n, int n2, char[] cArray, int n3, int n4) {
        this.buf.delete(n, n2);
        this.buf.insert(n, cArray, n3, n4);
    }

    public void copy(int n, int n2, int n3) {
        if (n == n2 && n >= 0 && n <= this.buf.length()) {
            return;
        }
        char[] cArray = new char[n2 - n];
        this.getChars(n, n2, cArray, 0);
        this.replace(n3, n3, cArray, 0, n2 - n);
    }

    public boolean hasMetaData() {
        return false;
    }
}

