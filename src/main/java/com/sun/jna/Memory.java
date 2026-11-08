/*
 * Decompiled with CFR 0.152.
 */
package com.sun.jna;

import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.WeakIdentityHashMap;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Memory
extends Pointer {
    private static final Map buffers = Collections.synchronizedMap(Platform.HAS_BUFFERS ? new WeakIdentityHashMap() : new HashMap());
    protected long size;

    public static void purge() {
        buffers.size();
    }

    public Memory(long l) {
        this.size = l;
        if (l <= 0L) {
            throw new IllegalArgumentException("Allocation size must be greater than zero");
        }
        this.peer = Memory.malloc(l);
        if (this.peer == 0L) {
            throw new OutOfMemoryError("Cannot allocate " + l + " bytes");
        }
    }

    protected Memory() {
    }

    public Pointer share(long l) {
        return this.share(l, this.getSize() - l);
    }

    public Pointer share(long l, long l2) {
        if (l == 0L && l2 == this.getSize()) {
            return this;
        }
        this.boundsCheck(l, l2);
        return new SharedMemory(l);
    }

    public Memory align(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + n);
        }
        for (int i = 0; i < 32; ++i) {
            if (n != 1 << i) continue;
            long l = (long)n - 1L ^ 0xFFFFFFFFFFFFFFFFL;
            if ((this.peer & l) != this.peer) {
                long l2 = this.peer + (long)n - 1L & l;
                long l3 = this.peer + this.size - l2;
                if (l3 <= 0L) {
                    throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
                }
                return (Memory)this.share(l2 - this.peer, l3);
            }
            return this;
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void finalize() {
        this.dispose();
    }

    protected synchronized void dispose() {
        Memory.free(this.peer);
        this.peer = 0L;
    }

    public void clear() {
        this.clear(this.size);
    }

    public boolean isValid() {
        return this.valid();
    }

    public boolean valid() {
        return this.peer != 0L;
    }

    public long size() {
        return this.size;
    }

    public long getSize() {
        return this.size();
    }

    protected void boundsCheck(long l, long l2) {
        if (l < 0L) {
            throw new IndexOutOfBoundsException("Invalid offset: " + l);
        }
        if (l + l2 > this.size) {
            String string = "Bounds exceeds available space : size=" + this.size + ", offset=" + (l + l2);
            throw new IndexOutOfBoundsException(string);
        }
    }

    public void read(long l, byte[] byArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 1L);
        super.read(l, byArray, n, n2);
    }

    public void read(long l, short[] sArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 2L);
        super.read(l, sArray, n, n2);
    }

    public void read(long l, char[] cArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 2L);
        super.read(l, cArray, n, n2);
    }

    public void read(long l, int[] nArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 4L);
        super.read(l, nArray, n, n2);
    }

    public void read(long l, long[] lArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 8L);
        super.read(l, lArray, n, n2);
    }

    public void read(long l, float[] fArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 4L);
        super.read(l, fArray, n, n2);
    }

    public void read(long l, double[] dArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 8L);
        super.read(l, dArray, n, n2);
    }

    public void write(long l, byte[] byArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 1L);
        super.write(l, byArray, n, n2);
    }

    public void write(long l, short[] sArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 2L);
        super.write(l, sArray, n, n2);
    }

    public void write(long l, char[] cArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 2L);
        super.write(l, cArray, n, n2);
    }

    public void write(long l, int[] nArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 4L);
        super.write(l, nArray, n, n2);
    }

    public void write(long l, long[] lArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 8L);
        super.write(l, lArray, n, n2);
    }

    public void write(long l, float[] fArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 4L);
        super.write(l, fArray, n, n2);
    }

    public void write(long l, double[] dArray, int n, int n2) {
        this.boundsCheck(l, (long)n2 * 8L);
        super.write(l, dArray, n, n2);
    }

    public byte getByte(long l) {
        this.boundsCheck(l, 1L);
        return super.getByte(l);
    }

    public char getChar(long l) {
        this.boundsCheck(l, 1L);
        return super.getChar(l);
    }

    public short getShort(long l) {
        this.boundsCheck(l, 2L);
        return super.getShort(l);
    }

    public int getInt(long l) {
        this.boundsCheck(l, 4L);
        return super.getInt(l);
    }

    public long getLong(long l) {
        this.boundsCheck(l, 8L);
        return super.getLong(l);
    }

    public float getFloat(long l) {
        this.boundsCheck(l, 4L);
        return super.getFloat(l);
    }

    public double getDouble(long l) {
        this.boundsCheck(l, 8L);
        return super.getDouble(l);
    }

    public Pointer getPointer(long l) {
        this.boundsCheck(l, Pointer.SIZE);
        return super.getPointer(l);
    }

    public ByteBuffer getByteBuffer(long l, long l2) {
        this.boundsCheck(l, l2);
        ByteBuffer byteBuffer = super.getByteBuffer(l, l2);
        buffers.put(byteBuffer, this);
        return byteBuffer;
    }

    public String getString(long l, boolean bl) {
        this.boundsCheck(l, 0L);
        return super.getString(l, bl);
    }

    public void setByte(long l, byte by) {
        this.boundsCheck(l, 1L);
        super.setByte(l, by);
    }

    public void setChar(long l, char c) {
        this.boundsCheck(l, Native.WCHAR_SIZE);
        super.setChar(l, c);
    }

    public void setShort(long l, short s) {
        this.boundsCheck(l, 2L);
        super.setShort(l, s);
    }

    public void setInt(long l, int n) {
        this.boundsCheck(l, 4L);
        super.setInt(l, n);
    }

    public void setLong(long l, long l2) {
        this.boundsCheck(l, 8L);
        super.setLong(l, l2);
    }

    public void setFloat(long l, float f) {
        this.boundsCheck(l, 4L);
        super.setFloat(l, f);
    }

    public void setDouble(long l, double d) {
        this.boundsCheck(l, 8L);
        super.setDouble(l, d);
    }

    public void setPointer(long l, Pointer pointer) {
        this.boundsCheck(l, Pointer.SIZE);
        super.setPointer(l, pointer);
    }

    public void setString(long l, String string, boolean bl) {
        if (bl) {
            this.boundsCheck(l, ((long)string.length() + 1L) * (long)Native.WCHAR_SIZE);
        } else {
            this.boundsCheck(l, (long)string.getBytes().length + 1L);
        }
        super.setString(l, string, bl);
    }

    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    protected static void free(long l) {
        Native.free(l);
    }

    protected static long malloc(long l) {
        return Native.malloc(l);
    }

    private class SharedMemory
    extends Memory {
        public SharedMemory(long l) {
            this.size = Memory.this.size - l;
            this.peer = Memory.this.peer + l;
        }

        protected void finalize() {
        }

        protected void boundsCheck(long l, long l2) {
            Memory.this.boundsCheck(this.peer - Memory.this.peer + l, l2);
        }

        public String toString() {
            return super.toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }
}

