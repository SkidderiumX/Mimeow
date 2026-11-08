/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

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

public class GPU_DEVICE
extends Struct<GPU_DEVICE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CB;
    public static final int DEVICENAME;
    public static final int DEVICESTRING;
    public static final int FLAGS;
    public static final int RCVIRTUALSCREEN;

    protected GPU_DEVICE(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected GPU_DEVICE create(long l, @Nullable ByteBuffer byteBuffer) {
        return new GPU_DEVICE(l, byteBuffer);
    }

    public GPU_DEVICE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GPU_DEVICE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cb() {
        return GPU_DEVICE.ncb(this.address());
    }

    @NativeType(value="CHAR[32]")
    public ByteBuffer DeviceName() {
        return GPU_DEVICE.nDeviceName(this.address());
    }

    @NativeType(value="CHAR[32]")
    public String DeviceNameString() {
        return GPU_DEVICE.nDeviceNameString(this.address());
    }

    @NativeType(value="CHAR[128]")
    public ByteBuffer DeviceString() {
        return GPU_DEVICE.nDeviceString(this.address());
    }

    @NativeType(value="CHAR[128]")
    public String DeviceStringString() {
        return GPU_DEVICE.nDeviceStringString(this.address());
    }

    @NativeType(value="DWORD")
    public int Flags() {
        return GPU_DEVICE.nFlags(this.address());
    }

    public RECT rcVirtualScreen() {
        return GPU_DEVICE.nrcVirtualScreen(this.address());
    }

    public static GPU_DEVICE malloc() {
        return new GPU_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static GPU_DEVICE calloc() {
        return new GPU_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static GPU_DEVICE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new GPU_DEVICE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GPU_DEVICE create(long l) {
        return new GPU_DEVICE(l, null);
    }

    public static @Nullable GPU_DEVICE createSafe(long l) {
        return l == 0L ? null : new GPU_DEVICE(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(GPU_DEVICE.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = GPU_DEVICE.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static GPU_DEVICE mallocStack() {
        return GPU_DEVICE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GPU_DEVICE callocStack() {
        return GPU_DEVICE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GPU_DEVICE mallocStack(MemoryStack memoryStack) {
        return GPU_DEVICE.malloc(memoryStack);
    }

    @Deprecated
    public static GPU_DEVICE callocStack(MemoryStack memoryStack) {
        return GPU_DEVICE.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return GPU_DEVICE.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return GPU_DEVICE.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return GPU_DEVICE.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return GPU_DEVICE.calloc(n, memoryStack);
    }

    public static GPU_DEVICE malloc(MemoryStack memoryStack) {
        return new GPU_DEVICE(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static GPU_DEVICE calloc(MemoryStack memoryStack) {
        return new GPU_DEVICE(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ncb(long l) {
        return MemoryUtil.memGetInt(l + (long)CB);
    }

    public static ByteBuffer nDeviceName(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DEVICENAME, 32);
    }

    public static String nDeviceNameString(long l) {
        return MemoryUtil.memASCII(l + (long)DEVICENAME);
    }

    public static ByteBuffer nDeviceString(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DEVICESTRING, 128);
    }

    public static String nDeviceStringString(long l) {
        return MemoryUtil.memASCII(l + (long)DEVICESTRING);
    }

    public static int nFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static RECT nrcVirtualScreen(long l) {
        return RECT.create(l + (long)RCVIRTUALSCREEN);
    }

    static {
        Struct.Layout layout = GPU_DEVICE.__struct(GPU_DEVICE.__member(4), GPU_DEVICE.__array(1, 32), GPU_DEVICE.__array(1, 128), GPU_DEVICE.__member(4), GPU_DEVICE.__member(RECT.SIZEOF, RECT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CB = layout.offsetof(0);
        DEVICENAME = layout.offsetof(1);
        DEVICESTRING = layout.offsetof(2);
        FLAGS = layout.offsetof(3);
        RCVIRTUALSCREEN = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<GPU_DEVICE, Buffer>
    implements NativeResource {
        private static final GPU_DEVICE ELEMENT_FACTORY = GPU_DEVICE.create(-1L);

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
        protected GPU_DEVICE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cb() {
            return GPU_DEVICE.ncb(this.address());
        }

        @NativeType(value="CHAR[32]")
        public ByteBuffer DeviceName() {
            return GPU_DEVICE.nDeviceName(this.address());
        }

        @NativeType(value="CHAR[32]")
        public String DeviceNameString() {
            return GPU_DEVICE.nDeviceNameString(this.address());
        }

        @NativeType(value="CHAR[128]")
        public ByteBuffer DeviceString() {
            return GPU_DEVICE.nDeviceString(this.address());
        }

        @NativeType(value="CHAR[128]")
        public String DeviceStringString() {
            return GPU_DEVICE.nDeviceStringString(this.address());
        }

        @NativeType(value="DWORD")
        public int Flags() {
            return GPU_DEVICE.nFlags(this.address());
        }

        public RECT rcVirtualScreen() {
            return GPU_DEVICE.nrcVirtualScreen(this.address());
        }
    }
}

