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

public class MOUSEINPUT
extends Struct<MOUSEINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int DX;
    public static final int DY;
    public static final int MOUSEDATA;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    protected MOUSEINPUT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected MOUSEINPUT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new MOUSEINPUT(l, byteBuffer);
    }

    public MOUSEINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MOUSEINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="LONG")
    public int dx() {
        return MOUSEINPUT.ndx(this.address());
    }

    @NativeType(value="LONG")
    public int dy() {
        return MOUSEINPUT.ndy(this.address());
    }

    @NativeType(value="DWORD")
    public int mouseData() {
        return MOUSEINPUT.nmouseData(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MOUSEINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MOUSEINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return MOUSEINPUT.ndwExtraInfo(this.address());
    }

    public MOUSEINPUT dx(@NativeType(value="LONG") int n) {
        MOUSEINPUT.ndx(this.address(), n);
        return this;
    }

    public MOUSEINPUT dy(@NativeType(value="LONG") int n) {
        MOUSEINPUT.ndy(this.address(), n);
        return this;
    }

    public MOUSEINPUT mouseData(@NativeType(value="DWORD") int n) {
        MOUSEINPUT.nmouseData(this.address(), n);
        return this;
    }

    public MOUSEINPUT dwFlags(@NativeType(value="DWORD") int n) {
        MOUSEINPUT.ndwFlags(this.address(), n);
        return this;
    }

    public MOUSEINPUT time(@NativeType(value="DWORD") int n) {
        MOUSEINPUT.ntime(this.address(), n);
        return this;
    }

    public MOUSEINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long l) {
        MOUSEINPUT.ndwExtraInfo(this.address(), l);
        return this;
    }

    public MOUSEINPUT set(int n, int n2, int n3, int n4, int n5, long l) {
        this.dx(n);
        this.dy(n2);
        this.mouseData(n3);
        this.dwFlags(n4);
        this.time(n5);
        this.dwExtraInfo(l);
        return this;
    }

    public MOUSEINPUT set(MOUSEINPUT mOUSEINPUT) {
        MemoryUtil.memCopy(mOUSEINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static MOUSEINPUT malloc() {
        return new MOUSEINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MOUSEINPUT calloc() {
        return new MOUSEINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MOUSEINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new MOUSEINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MOUSEINPUT create(long l) {
        return new MOUSEINPUT(l, null);
    }

    public static @Nullable MOUSEINPUT createSafe(long l) {
        return l == 0L ? null : new MOUSEINPUT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MOUSEINPUT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = MOUSEINPUT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static MOUSEINPUT mallocStack() {
        return MOUSEINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT callocStack() {
        return MOUSEINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MOUSEINPUT mallocStack(MemoryStack memoryStack) {
        return MOUSEINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static MOUSEINPUT callocStack(MemoryStack memoryStack) {
        return MOUSEINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return MOUSEINPUT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return MOUSEINPUT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return MOUSEINPUT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return MOUSEINPUT.calloc(n, memoryStack);
    }

    public static MOUSEINPUT malloc(MemoryStack memoryStack) {
        return new MOUSEINPUT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MOUSEINPUT calloc(MemoryStack memoryStack) {
        return new MOUSEINPUT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ndx(long l) {
        return MemoryUtil.memGetInt(l + (long)DX);
    }

    public static int ndy(long l) {
        return MemoryUtil.memGetInt(l + (long)DY);
    }

    public static int nmouseData(long l) {
        return MemoryUtil.memGetInt(l + (long)MOUSEDATA);
    }

    public static int ndwFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)DWFLAGS);
    }

    public static int ntime(long l) {
        return MemoryUtil.memGetInt(l + (long)TIME);
    }

    public static long ndwExtraInfo(long l) {
        return MemoryUtil.memGetAddress(l + (long)DWEXTRAINFO);
    }

    public static void ndx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DX, n);
    }

    public static void ndy(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DY, n);
    }

    public static void nmouseData(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MOUSEDATA, n);
    }

    public static void ndwFlags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DWFLAGS, n);
    }

    public static void ntime(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TIME, n);
    }

    public static void ndwExtraInfo(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)DWEXTRAINFO, l2);
    }

    static {
        Struct.Layout layout = MOUSEINPUT.__struct(MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(4), MOUSEINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        DX = layout.offsetof(0);
        DY = layout.offsetof(1);
        MOUSEDATA = layout.offsetof(2);
        DWFLAGS = layout.offsetof(3);
        TIME = layout.offsetof(4);
        DWEXTRAINFO = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MOUSEINPUT, Buffer>
    implements NativeResource {
        private static final MOUSEINPUT ELEMENT_FACTORY = MOUSEINPUT.create(-1L);

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
        protected MOUSEINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="LONG")
        public int dx() {
            return MOUSEINPUT.ndx(this.address());
        }

        @NativeType(value="LONG")
        public int dy() {
            return MOUSEINPUT.ndy(this.address());
        }

        @NativeType(value="DWORD")
        public int mouseData() {
            return MOUSEINPUT.nmouseData(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MOUSEINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MOUSEINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return MOUSEINPUT.ndwExtraInfo(this.address());
        }

        public Buffer dx(@NativeType(value="LONG") int n) {
            MOUSEINPUT.ndx(this.address(), n);
            return this;
        }

        public Buffer dy(@NativeType(value="LONG") int n) {
            MOUSEINPUT.ndy(this.address(), n);
            return this;
        }

        public Buffer mouseData(@NativeType(value="DWORD") int n) {
            MOUSEINPUT.nmouseData(this.address(), n);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int n) {
            MOUSEINPUT.ndwFlags(this.address(), n);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n) {
            MOUSEINPUT.ntime(this.address(), n);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long l) {
            MOUSEINPUT.ndwExtraInfo(this.address(), l);
            return this;
        }
    }
}

