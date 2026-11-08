/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.libs.mcstructs.converter.hash;

public class HashCode {
    private static final String HEX_CHARS = "0123456789abcdef";
    private final int hashCode;

    public static HashCode of(int n) {
        return new HashCode(n);
    }

    private HashCode(int n) {
        this.hashCode = n;
    }

    public byte[] asBytes() {
        return new byte[]{(byte)this.hashCode, (byte)(this.hashCode >> 8), (byte)(this.hashCode >> 16), (byte)(this.hashCode >> 24)};
    }

    public int asInt() {
        return this.hashCode;
    }

    public long asLong() {
        return (long)this.hashCode & 0xFFFFFFFFL;
    }

    public String toString() {
        byte[] byArray = this.asBytes();
        char[] cArray = new char[byArray.length * 2];
        for (int i = 0; i < byArray.length; ++i) {
            byte by = byArray[i];
            cArray[i * 2] = HEX_CHARS.charAt(by >> 4 & 0xF);
            cArray[i * 2 + 1] = HEX_CHARS.charAt(by & 0xF);
        }
        return new String(cArray);
    }
}

