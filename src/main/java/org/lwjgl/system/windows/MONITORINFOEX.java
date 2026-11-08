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
import org.lwjgl.system.windows.RECT;

public class MONITORINFOEX
extends Struct<MONITORINFOEX>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBSIZE;
    public static final int RCMONITOR;
    public static final int RCWORK;
    public static final int DWFLAGS;
    public static final int SZDEVICE;

    protected MONITORINFOEX(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected MONITORINFOEX create(long l, @Nullable ByteBuffer byteBuffer) {
        return new MONITORINFOEX(l, byteBuffer);
    }

    public MONITORINFOEX(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MONITORINFOEX.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbSize() {
        return MONITORINFOEX.ncbSize(this.address());
    }

    public RECT rcMonitor() {
        return MONITORINFOEX.nrcMonitor(this.address());
    }

    public RECT rcWork() {
        return MONITORINFOEX.nrcWork(this.address());
    }

    @NativeType(value="DWORD")
    public int dwFlags() {
        return MONITORINFOEX.ndwFlags(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer szDevice() {
        return MONITORINFOEX.nszDevice(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String szDeviceString() {
        return MONITORINFOEX.nszDeviceString(this.address());
    }

    public MONITORINFOEX cbSize(@NativeType(value="DWORD") int n) {
        MONITORINFOEX.ncbSize(this.address(), n);
        return this;
    }

    public MONITORINFOEX set(MONITORINFOEX mONITORINFOEX) {
        MemoryUtil.memCopy(mONITORINFOEX.address(), this.address(), SIZEOF);
        return this;
    }

    public static MONITORINFOEX malloc() {
        return new MONITORINFOEX(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MONITORINFOEX calloc() {
        return new MONITORINFOEX(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MONITORINFOEX create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new MONITORINFOEX(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MONITORINFOEX create(long l) {
        return new MONITORINFOEX(l, null);
    }

    public static @Nullable MONITORINFOEX createSafe(long l) {
        return l == 0L ? null : new MONITORINFOEX(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MONITORINFOEX.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = MONITORINFOEX.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static MONITORINFOEX mallocStack() {
        return MONITORINFOEX.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX callocStack() {
        return MONITORINFOEX.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MONITORINFOEX mallocStack(MemoryStack memoryStack) {
        return MONITORINFOEX.malloc(memoryStack);
    }

    @Deprecated
    public static MONITORINFOEX callocStack(MemoryStack memoryStack) {
        return MONITORINFOEX.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return MONITORINFOEX.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return MONITORINFOEX.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return MONITORINFOEX.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return MONITORINFOEX.calloc(n, memoryStack);
    }

    public static MONITORINFOEX malloc(MemoryStack memoryStack) {
        return new MONITORINFOEX(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MONITORINFOEX calloc(MemoryStack memoryStack) {
        return new MONITORINFOEX(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ncbSize(long l) {
        return MemoryUtil.memGetInt(l + (long)CBSIZE);
    }

    public static RECT nrcMonitor(long l) {
        return RECT.create(l + (long)RCMONITOR);
    }

    public static RECT nrcWork(long l) {
        return RECT.create(l + (long)RCWORK);
    }

    public static int ndwFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)DWFLAGS);
    }

    public static ByteBuffer nszDevice(long l) {
        return MemoryUtil.memByteBuffer(l + (long)SZDEVICE, 64);
    }

    public static String nszDeviceString(long l) {
        return MemoryUtil.memUTF16(l + (long)SZDEVICE);
    }

    public static void ncbSize(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CBSIZE, n);
    }

    static {
        Struct.Layout layout = MONITORINFOEX.__struct(MONITORINFOEX.__member(4), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(RECT.SIZEOF, RECT.ALIGNOF), MONITORINFOEX.__member(4), MONITORINFOEX.__array(2, 32));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBSIZE = layout.offsetof(0);
        RCMONITOR = layout.offsetof(1);
        RCWORK = layout.offsetof(2);
        DWFLAGS = layout.offsetof(3);
        SZDEVICE = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<MONITORINFOEX, Buffer>
    implements NativeResource {
        private static final MONITORINFOEX ELEMENT_FACTORY = MONITORINFOEX.create(-1L);

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
        protected MONITORINFOEX getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cbSize() {
            return MONITORINFOEX.ncbSize(this.address());
        }

        public RECT rcMonitor() {
            return MONITORINFOEX.nrcMonitor(this.address());
        }

        public RECT rcWork() {
            return MONITORINFOEX.nrcWork(this.address());
        }

        @NativeType(value="DWORD")
        public int dwFlags() {
            return MONITORINFOEX.ndwFlags(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer szDevice() {
            return MONITORINFOEX.nszDevice(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String szDeviceString() {
            return MONITORINFOEX.nszDeviceString(this.address());
        }

        public Buffer cbSize(@NativeType(value="DWORD") int n) {
            MONITORINFOEX.ncbSize(this.address(), n);
            return this;
        }
    }
}

