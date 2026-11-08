/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import java.nio.CharBuffer;

public class NativeString
implements CharSequence,
Comparable {
    private Pointer pointer;
    private boolean wide;

    public NativeString(String string) {
        this(string, false);
    }

    public NativeString(String string, boolean bl) {
        if (string == null) {
            throw new NullPointerException("String must not be null");
        }
        this.wide = bl;
        if (bl) {
            int n = (string.length() + 1) * Native.WCHAR_SIZE;
            this.pointer = new Memory(n);
            this.pointer.setString(0L, string, true);
        } else {
            byte[] byArray = Native.getBytes(string);
            this.pointer = new Memory(byArray.length + 1);
            this.pointer.write(0L, byArray, 0, byArray.length);
            this.pointer.setByte(byArray.length, (byte)0);
        }
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof CharSequence) {
            return this.compareTo(object) == 0;
        }
        return false;
    }

    public String toString() {
        String string = this.wide ? "const wchar_t*" : "const char*";
        string = string + "(" + this.pointer.getString(0L, this.wide) + ")";
        return string;
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    public char charAt(int n) {
        return this.toString().charAt(n);
    }

    public int length() {
        return this.toString().length();
    }

    public CharSequence subSequence(int n, int n2) {
        return CharBuffer.wrap(this.toString()).subSequence(n, n2);
    }

    public int compareTo(Object object) {
        if (object == null) {
            return 1;
        }
        return this.toString().compareTo(object.toString());
    }
}

