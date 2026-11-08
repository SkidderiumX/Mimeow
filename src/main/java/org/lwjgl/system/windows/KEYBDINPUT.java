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

public class KEYBDINPUT
extends Struct<KEYBDINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WVK;
    public static final int WSCAN;
    public static final int DWFLAGS;
    public static final int TIME;
    public static final int DWEXTRAINFO;

    protected KEYBDINPUT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected KEYBDINPUT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new KEYBDINPUT(l, byteBuffer);
    }

    public KEYBDINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), KEYBDINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="WORD")
    public short wVk() {
        return KEYBDINPUT.nwVk(this.address());
    }

    @NativeType(value="WORD")
    public short wScan() {
        return KEYBDINPUT.nwScan(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return KEYBDINPUT.ndwFlags(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return KEYBDINPUT.ntime(this.address());
    }

    @NativeType(value="ULONG_PTR")
    public long dwExtraInfo() {
        return KEYBDINPUT.ndwExtraInfo(this.address());
    }

    public KEYBDINPUT wVk(@NativeType(value="WORD") short s) {
        KEYBDINPUT.nwVk(this.address(), s);
        return this;
    }

    public KEYBDINPUT wScan(@NativeType(value="WORD") short s) {
        KEYBDINPUT.nwScan(this.address(), s);
        return this;
    }

    public KEYBDINPUT dwFlags(@NativeType(value="DWORD") int n) {
        KEYBDINPUT.ndwFlags(this.address(), n);
        return this;
    }

    public KEYBDINPUT time(@NativeType(value="DWORD") int n) {
        KEYBDINPUT.ntime(this.address(), n);
        return this;
    }

    public KEYBDINPUT dwExtraInfo(@NativeType(value="ULONG_PTR") long l) {
        KEYBDINPUT.ndwExtraInfo(this.address(), l);
        return this;
    }

    public KEYBDINPUT set(short s, short s2, int n, int n2, long l) {
        this.wVk(s);
        this.wScan(s2);
        this.dwFlags(n);
        this.time(n2);
        this.dwExtraInfo(l);
        return this;
    }

    public KEYBDINPUT set(KEYBDINPUT kEYBDINPUT) {
        MemoryUtil.memCopy(kEYBDINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static KEYBDINPUT malloc() {
        return new KEYBDINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static KEYBDINPUT calloc() {
        return new KEYBDINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static KEYBDINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new KEYBDINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static KEYBDINPUT create(long l) {
        return new KEYBDINPUT(l, null);
    }

    public static @Nullable KEYBDINPUT createSafe(long l) {
        return l == 0L ? null : new KEYBDINPUT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(KEYBDINPUT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = KEYBDINPUT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static KEYBDINPUT mallocStack() {
        return KEYBDINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT callocStack() {
        return KEYBDINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static KEYBDINPUT mallocStack(MemoryStack memoryStack) {
        return KEYBDINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static KEYBDINPUT callocStack(MemoryStack memoryStack) {
        return KEYBDINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return KEYBDINPUT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return KEYBDINPUT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return KEYBDINPUT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return KEYBDINPUT.calloc(n, memoryStack);
    }

    public static KEYBDINPUT malloc(MemoryStack memoryStack) {
        return new KEYBDINPUT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static KEYBDINPUT calloc(MemoryStack memoryStack) {
        return new KEYBDINPUT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static short nwVk(long l) {
        return MemoryUtil.memGetShort(l + (long)WVK);
    }

    public static short nwScan(long l) {
        return MemoryUtil.memGetShort(l + (long)WSCAN);
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

    public static void nwVk(long l, short s) {
        MemoryUtil.memPutShort(l + (long)WVK, s);
    }

    public static void nwScan(long l, short s) {
        MemoryUtil.memPutShort(l + (long)WSCAN, s);
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
        Struct.Layout layout = KEYBDINPUT.__struct(KEYBDINPUT.__member(2), KEYBDINPUT.__member(2), KEYBDINPUT.__member(4), KEYBDINPUT.__member(4), KEYBDINPUT.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WVK = layout.offsetof(0);
        WSCAN = layout.offsetof(1);
        DWFLAGS = layout.offsetof(2);
        TIME = layout.offsetof(3);
        DWEXTRAINFO = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<KEYBDINPUT, Buffer>
    implements NativeResource {
        private static final KEYBDINPUT ELEMENT_FACTORY = KEYBDINPUT.create(-1L);

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
        protected KEYBDINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="WORD")
        public short wVk() {
            return KEYBDINPUT.nwVk(this.address());
        }

        @NativeType(value="WORD")
        public short wScan() {
            return KEYBDINPUT.nwScan(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return KEYBDINPUT.ndwFlags(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return KEYBDINPUT.ntime(this.address());
        }

        @NativeType(value="ULONG_PTR")
        public long dwExtraInfo() {
            return KEYBDINPUT.ndwExtraInfo(this.address());
        }

        public Buffer wVk(@NativeType(value="WORD") short s) {
            KEYBDINPUT.nwVk(this.address(), s);
            return this;
        }

        public Buffer wScan(@NativeType(value="WORD") short s) {
            KEYBDINPUT.nwScan(this.address(), s);
            return this;
        }

        public Buffer dwFlags(@NativeType(value="DWORD") int n) {
            KEYBDINPUT.ndwFlags(this.address(), n);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n) {
            KEYBDINPUT.ntime(this.address(), n);
            return this;
        }

        public Buffer dwExtraInfo(@NativeType(value="ULONG_PTR") long l) {
            KEYBDINPUT.ndwExtraInfo(this.address(), l);
            return this;
        }
    }
}

