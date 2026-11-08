/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import java.nio.CharBuffer;

public class WString
implements CharSequence,
Comparable {
    private String string;

    public WString(String string) {
        if (string == null) {
            throw new NullPointerException("String initializer must be non-null");
        }
        this.string = string;
    }

    public String toString() {
        return this.string;
    }

    public boolean equals(Object object) {
        return object instanceof WString && this.toString().equals(object.toString());
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public int compareTo(Object object) {
        return this.toString().compareTo(object.toString());
    }

    public int length() {
        return this.toString().length();
    }

    public char charAt(int n) {
        return this.toString().charAt(n);
    }

    public CharSequence subSequence(int n, int n2) {
        return CharBuffer.wrap(this.toString()).subSequence(n, n2);
    }
}

