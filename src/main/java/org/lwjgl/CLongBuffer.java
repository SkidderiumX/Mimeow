/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.CheckIntrinsics;
import org.lwjgl.system.Checks;
import org.lwjgl.system.CustomBuffer;
import org.lwjgl.system.MemoryUtil;

public class CLongBuffer
extends CustomBuffer<CLongBuffer>
implements Comparable<CLongBuffer> {
    protected CLongBuffer(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
        super(l, byteBuffer, n, n2, n3, n4);
    }

    public static CLongBuffer allocateDirect(int n) {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(n, CLONG_SHIFT));
        return new CLongBuffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static CLongBuffer create(long l, int n) {
        return new CLongBuffer(l, null, -1, 0, n, n);
    }

    public static CLongBuffer create(ByteBuffer byteBuffer) {
        int n = byteBuffer.remaining() >> CLONG_SHIFT;
        return new CLongBuffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    @Override
    protected CLongBuffer self() {
        return this;
    }

    @Override
    protected CLongBuffer create(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
        return new CLongBuffer(l, byteBuffer, n, n2, n3, n4);
    }

    @Override
    public int sizeof() {
        return CLONG_SIZE;
    }

    public long get() {
        return MemoryUtil.memGetCLong(this.address + Integer.toUnsignedLong(this.nextGetIndex()) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < CLONG_SIZE) {
            throw new BufferUnderflowException();
        }
        try {
            long l = MemoryUtil.memGetCLong(MemoryUtil.memAddress(byteBuffer));
            return l;
        }
        finally {
            byteBuffer.position(byteBuffer.position() + CLONG_SIZE);
        }
    }

    @Override
    public CLongBuffer put(long l) {
        MemoryUtil.memPutCLong(this.address + Integer.toUnsignedLong(this.nextPutIndex()) * (long)CLONG_SIZE, l);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, long l) {
        if (byteBuffer.remaining() < CLONG_SIZE) {
            throw new BufferOverflowException();
        }
        try {
            MemoryUtil.memPutCLong(MemoryUtil.memAddress(byteBuffer), l);
        }
        finally {
            byteBuffer.position(byteBuffer.position() + CLONG_SIZE);
        }
    }

    public long get(int n) {
        return MemoryUtil.memGetCLong(this.address + Checks.check(n, this.limit) * (long)CLONG_SIZE);
    }

    public static long get(ByteBuffer byteBuffer, int n) {
        CheckIntrinsics.checkFromIndexSize(n, CLONG_SIZE, byteBuffer.limit());
        return MemoryUtil.memGetCLong(MemoryUtil.memAddress0(byteBuffer) + (long)n);
    }

    public CLongBuffer put(int n, long l) {
        MemoryUtil.memPutCLong(this.address + Checks.check(n, this.limit) * (long)CLONG_SIZE, l);
        return this;
    }

    public static void put(ByteBuffer byteBuffer, int n, long l) {
        CheckIntrinsics.checkFromIndexSize(n, CLONG_SIZE, byteBuffer.limit());
        MemoryUtil.memPutCLong(MemoryUtil.memAddress0(byteBuffer) + (long)n, l);
    }

    public CLongBuffer get(long[] lArray) {
        return this.get(lArray, 0, lArray.length);
    }

    public CLongBuffer get(long[] lArray, int n, int n2) {
        if (CLONG_SIZE == 8) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).get(lArray, n, n2);
            this.position(this.position() + n2);
        } else {
            this.get32(lArray, n, n2);
        }
        return this;
    }

    private void get32(long[] lArray, int n, int n2) {
        CheckIntrinsics.checkFromIndexSize(n, n2, lArray.length);
        if (this.remaining() < n2) {
            throw new BufferUnderflowException();
        }
        int n3 = n + n2;
        for (int i = n; i < n3; ++i) {
            lArray[i] = this.get();
        }
    }

    @Override
    public CLongBuffer put(long[] lArray) {
        return this.put(lArray, 0, lArray.length);
    }

    public CLongBuffer put(long[] lArray, int n, int n2) {
        if (CLONG_SIZE == 8) {
            MemoryUtil.memLongBuffer(this.address(), this.remaining()).put(lArray, n, n2);
            this.position(this.position() + n2);
        } else {
            this.put32(lArray, n, n2);
        }
        return this;
    }

    private void put32(long[] lArray, int n, int n2) {
        CheckIntrinsics.checkFromIndexSize(n, n2, lArray.length);
        if (this.remaining() < n2) {
            throw new BufferOverflowException();
        }
        int n3 = n + n2;
        for (int i = n; i < n3; ++i) {
            this.put(lArray[i]);
        }
    }

    @Override
    public int hashCode() {
        int n = 1;
        int n2 = this.position();
        for (int i = this.limit() - 1; i >= n2; --i) {
            n = 31 * n + (int)this.get(i);
        }
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CLongBuffer)) {
            return false;
        }
        CLongBuffer cLongBuffer = (CLongBuffer)object;
        if (this.remaining() != cLongBuffer.remaining()) {
            return false;
        }
        int n = this.position();
        int n2 = this.limit() - 1;
        int n3 = cLongBuffer.limit() - 1;
        while (n2 >= n) {
            long l;
            long l2 = this.get(n2);
            if (l2 != (l = cLongBuffer.get(n3))) {
                return false;
            }
            --n2;
            --n3;
        }
        return true;
    }

    @Override
    public int compareTo(CLongBuffer cLongBuffer) {
        int n = this.position() + Math.min(this.remaining(), cLongBuffer.remaining());
        int n2 = this.position();
        int n3 = cLongBuffer.position();
        while (n2 < n) {
            long l;
            long l2 = this.get(n2);
            if (l2 != (l = cLongBuffer.get(n3))) {
                if (l2 < l) {
                    return -1;
                }
                return 1;
            }
            ++n2;
            ++n3;
        }
        return this.remaining() - cLongBuffer.remaining();
    }
}

