/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import java.util.Arrays;

public class NibbleArray {
    private static final byte[] ZERO = new byte[2048];
    private static final byte[] FULL = new byte[2048];
    private byte[] data;

    public NibbleArray() {
        this.data = ZERO;
    }

    public NibbleArray(byte[] byArray) {
        if (byArray.length != 2048) {
            throw new IllegalArgumentException("ChunkNibbleArrays should be 2048 bytes not: " + byArray.length);
        }
        this.data = byArray;
        this.compact();
    }

    public int get(int n, int n2, int n3) {
        return this.getFromIndex(this.getCoordinateIndex(n, n2, n3));
    }

    public void set(int n, int n2, int n3, int n4) {
        this.setIndex(this.getCoordinateIndex(n, n2, n3), n4);
    }

    private int getCoordinateIndex(int n, int n2, int n3) {
        return n2 << 8 | n3 << 4 | n;
    }

    public int getFromIndex(int n) {
        int n2 = this.getNibbleIndex(n);
        return this.isLowerNibble(n) ? this.data[n2] & 0xF : this.data[n2] >> 4 & 0xF;
    }

    public void setIndex(int n, int n2) {
        if (this.getFromIndex(n) == (n2 &= 0xF)) {
            return;
        }
        if (this.data == ZERO || this.data == FULL) {
            this.data = (byte[])this.data.clone();
        }
        int n3 = this.getNibbleIndex(n);
        this.data[n3] = this.isLowerNibble(n) ? (byte)(this.data[n3] & 0xF0 | n2 & 0xF) : (byte)(this.data[n3] & 0xF | (n2 & 0xF) << 4);
    }

    private boolean isLowerNibble(int n) {
        return (n & 1) == 0;
    }

    private int getNibbleIndex(int n) {
        return n >> 1;
    }

    public byte[] getData() {
        if (this.data == ZERO || this.data == FULL) {
            this.data = (byte[])this.data.clone();
        }
        return this.data;
    }

    public byte[] getReadOnlyData() {
        return this.data;
    }

    public void compact() {
        if (this.data != ZERO && Arrays.equals(this.data, ZERO)) {
            this.data = ZERO;
        } else if (this.data != FULL && Arrays.equals(this.data, FULL)) {
            this.data = FULL;
        }
    }

    static {
        Arrays.fill(FULL, (byte)-1);
    }
}

