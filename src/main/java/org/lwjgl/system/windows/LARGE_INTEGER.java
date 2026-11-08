/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class LARGE_INTEGER
extends Struct<LARGE_INTEGER>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int U;
    public static final int U_LOWPART;
    public static final int U_HIGHPART;
    public static final int QUADPART;

    protected LARGE_INTEGER(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected LARGE_INTEGER create(long l, @Nullable ByteBuffer byteBuffer) {
        return new LARGE_INTEGER(l, byteBuffer);
    }

    public LARGE_INTEGER(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), LARGE_INTEGER.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int u_LowPart() {
        return LARGE_INTEGER.nu_LowPart(this.address());
    }

    @NativeType(value="LONG")
    public int u_HighPart() {
        return LARGE_INTEGER.nu_HighPart(this.address());
    }

    @NativeType(value="LONGLONG")
    public long QuadPart() {
        return LARGE_INTEGER.nQuadPart(this.address());
    }

    public LARGE_INTEGER u_LowPart(@NativeType(value="DWORD") int n) {
        LARGE_INTEGER.nu_LowPart(this.address(), n);
        return this;
    }

    public LARGE_INTEGER u_HighPart(@NativeType(value="LONG") int n) {
        LARGE_INTEGER.nu_HighPart(this.address(), n);
        return this;
    }

    public LARGE_INTEGER QuadPart(@NativeType(value="LONGLONG") long l) {
        LARGE_INTEGER.nQuadPart(this.address(), l);
        return this;
    }

    public LARGE_INTEGER set(LARGE_INTEGER lARGE_INTEGER) {
        MemoryUtil.memCopy(lARGE_INTEGER.address(), this.address(), SIZEOF);
        return this;
    }

    public static LARGE_INTEGER malloc() {
        return new LARGE_INTEGER(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static LARGE_INTEGER calloc() {
        return new LARGE_INTEGER(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static LARGE_INTEGER create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new LARGE_INTEGER(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static LARGE_INTEGER create(long l) {
        return new LARGE_INTEGER(l, null);
    }

    public static @Nullable LARGE_INTEGER createSafe(long l) {
        return l == 0L ? null : new LARGE_INTEGER(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(LARGE_INTEGER.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = LARGE_INTEGER.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static LARGE_INTEGER malloc(MemoryStack memoryStack) {
        return new LARGE_INTEGER(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static LARGE_INTEGER calloc(MemoryStack memoryStack) {
        return new LARGE_INTEGER(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nu_LowPart(long l) {
        return MemoryUtil.memGetInt(l + (long)U_LOWPART);
    }

    public static int nu_HighPart(long l) {
        return MemoryUtil.memGetInt(l + (long)U_HIGHPART);
    }

    public static long nQuadPart(long l) {
        return MemoryUtil.memGetLong(l + (long)QUADPART);
    }

    public static void nu_LowPart(long l, int n) {
        MemoryUtil.memPutInt(l + (long)U_LOWPART, n);
    }

    public static void nu_HighPart(long l, int n) {
        MemoryUtil.memPutInt(l + (long)U_HIGHPART, n);
    }

    public static void nQuadPart(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)QUADPART, l2);
    }

    static {
        Struct.Layout layout = LARGE_INTEGER.__union(LARGE_INTEGER.__struct(LARGE_INTEGER.__member(4), LARGE_INTEGER.__member(4)), LARGE_INTEGER.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        U = layout.offsetof(0);
        U_LOWPART = layout.offsetof(1);
        U_HIGHPART = layout.offsetof(2);
        QUADPART = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<LARGE_INTEGER, Buffer>
    implements NativeResource {
        private static final LARGE_INTEGER ELEMENT_FACTORY = LARGE_INTEGER.create(-1L);

        public Buffer(ByteBuffer byteBuffer) {
            super(byteBuffer, byteBuffer.remaining() / SIZEOF);
        }

        public Buffer(long l, int n) {
            super(l, null, -1, 0, n, n);
        }

        Buffer(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            super(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer create(long l, @Nullable ByteBuffer byteBuffer, int n, int n2, int n3, int n4) {
            return new Buffer(l, byteBuffer, n, n2, n3, n4);
        }

        @Override
        protected LARGE_INTEGER getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int u_LowPart() {
            return LARGE_INTEGER.nu_LowPart(this.address());
        }

        @NativeType(value="LONG")
        public int u_HighPart() {
            return LARGE_INTEGER.nu_HighPart(this.address());
        }

        @NativeType(value="LONGLONG")
        public long QuadPart() {
            return LARGE_INTEGER.nQuadPart(this.address());
        }

        public Buffer u_LowPart(@NativeType(value="DWORD") int n) {
            LARGE_INTEGER.nu_LowPart(this.address(), n);
            return this;
        }

        public Buffer u_HighPart(@NativeType(value="LONG") int n) {
            LARGE_INTEGER.nu_HighPart(this.address(), n);
            return this;
        }

        public Buffer QuadPart(@NativeType(value="LONGLONG") long l) {
            LARGE_INTEGER.nQuadPart(this.address(), l);
            return this;
        }
    }
}

