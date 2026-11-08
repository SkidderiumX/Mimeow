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

public class DISPLAY_DEVICE
extends Struct<DISPLAY_DEVICE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CB;
    public static final int DEVICENAME;
    public static final int DEVICESTRING;
    public static final int STATEFLAGS;
    public static final int DEVICEID;
    public static final int DEVICEKEY;

    protected DISPLAY_DEVICE(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected DISPLAY_DEVICE create(long l, @Nullable ByteBuffer byteBuffer) {
        return new DISPLAY_DEVICE(l, byteBuffer);
    }

    public DISPLAY_DEVICE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), DISPLAY_DEVICE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cb() {
        return DISPLAY_DEVICE.ncb(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public ByteBuffer DeviceName() {
        return DISPLAY_DEVICE.nDeviceName(this.address());
    }

    @NativeType(value="TCHAR[32]")
    public String DeviceNameString() {
        return DISPLAY_DEVICE.nDeviceNameString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceString() {
        return DISPLAY_DEVICE.nDeviceString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceStringString() {
        return DISPLAY_DEVICE.nDeviceStringString(this.address());
    }

    @NativeType(value="DWORD")
    public int StateFlags() {
        return DISPLAY_DEVICE.nStateFlags(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceID() {
        return DISPLAY_DEVICE.nDeviceID(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceIDString() {
        return DISPLAY_DEVICE.nDeviceIDString(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public ByteBuffer DeviceKey() {
        return DISPLAY_DEVICE.nDeviceKey(this.address());
    }

    @NativeType(value="TCHAR[128]")
    public String DeviceKeyString() {
        return DISPLAY_DEVICE.nDeviceKeyString(this.address());
    }

    public DISPLAY_DEVICE cb(@NativeType(value="DWORD") int n) {
        DISPLAY_DEVICE.ncb(this.address(), n);
        return this;
    }

    public DISPLAY_DEVICE set(DISPLAY_DEVICE dISPLAY_DEVICE) {
        MemoryUtil.memCopy(dISPLAY_DEVICE.address(), this.address(), SIZEOF);
        return this;
    }

    public static DISPLAY_DEVICE malloc() {
        return new DISPLAY_DEVICE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DISPLAY_DEVICE calloc() {
        return new DISPLAY_DEVICE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DISPLAY_DEVICE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new DISPLAY_DEVICE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static DISPLAY_DEVICE create(long l) {
        return new DISPLAY_DEVICE(l, null);
    }

    public static @Nullable DISPLAY_DEVICE createSafe(long l) {
        return l == 0L ? null : new DISPLAY_DEVICE(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DISPLAY_DEVICE.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = DISPLAY_DEVICE.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static DISPLAY_DEVICE mallocStack() {
        return DISPLAY_DEVICE.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack() {
        return DISPLAY_DEVICE.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static DISPLAY_DEVICE mallocStack(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.malloc(memoryStack);
    }

    @Deprecated
    public static DISPLAY_DEVICE callocStack(MemoryStack memoryStack) {
        return DISPLAY_DEVICE.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return DISPLAY_DEVICE.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return DISPLAY_DEVICE.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return DISPLAY_DEVICE.calloc(n, memoryStack);
    }

    public static DISPLAY_DEVICE malloc(MemoryStack memoryStack) {
        return new DISPLAY_DEVICE(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DISPLAY_DEVICE calloc(MemoryStack memoryStack) {
        return new DISPLAY_DEVICE(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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
        return MemoryUtil.memByteBuffer(l + (long)DEVICENAME, 64);
    }

    public static String nDeviceNameString(long l) {
        return MemoryUtil.memUTF16(l + (long)DEVICENAME);
    }

    public static ByteBuffer nDeviceString(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DEVICESTRING, 256);
    }

    public static String nDeviceStringString(long l) {
        return MemoryUtil.memUTF16(l + (long)DEVICESTRING);
    }

    public static int nStateFlags(long l) {
        return MemoryUtil.memGetInt(l + (long)STATEFLAGS);
    }

    public static ByteBuffer nDeviceID(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DEVICEID, 256);
    }

    public static String nDeviceIDString(long l) {
        return MemoryUtil.memUTF16(l + (long)DEVICEID);
    }

    public static ByteBuffer nDeviceKey(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DEVICEKEY, 256);
    }

    public static String nDeviceKeyString(long l) {
        return MemoryUtil.memUTF16(l + (long)DEVICEKEY);
    }

    public static void ncb(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CB, n);
    }

    static {
        Struct.Layout layout = DISPLAY_DEVICE.__struct(DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 32), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__member(4), DISPLAY_DEVICE.__array(2, 128), DISPLAY_DEVICE.__array(2, 128));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CB = layout.offsetof(0);
        DEVICENAME = layout.offsetof(1);
        DEVICESTRING = layout.offsetof(2);
        STATEFLAGS = layout.offsetof(3);
        DEVICEID = layout.offsetof(4);
        DEVICEKEY = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<DISPLAY_DEVICE, Buffer>
    implements NativeResource {
        private static final DISPLAY_DEVICE ELEMENT_FACTORY = DISPLAY_DEVICE.create(-1L);

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
        protected DISPLAY_DEVICE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cb() {
            return DISPLAY_DEVICE.ncb(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public ByteBuffer DeviceName() {
            return DISPLAY_DEVICE.nDeviceName(this.address());
        }

        @NativeType(value="TCHAR[32]")
        public String DeviceNameString() {
            return DISPLAY_DEVICE.nDeviceNameString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceString() {
            return DISPLAY_DEVICE.nDeviceString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceStringString() {
            return DISPLAY_DEVICE.nDeviceStringString(this.address());
        }

        @NativeType(value="DWORD")
        public int StateFlags() {
            return DISPLAY_DEVICE.nStateFlags(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceID() {
            return DISPLAY_DEVICE.nDeviceID(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceIDString() {
            return DISPLAY_DEVICE.nDeviceIDString(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public ByteBuffer DeviceKey() {
            return DISPLAY_DEVICE.nDeviceKey(this.address());
        }

        @NativeType(value="TCHAR[128]")
        public String DeviceKeyString() {
            return DISPLAY_DEVICE.nDeviceKeyString(this.address());
        }

        public Buffer cb(@NativeType(value="DWORD") int n) {
            DISPLAY_DEVICE.ncb(this.address(), n);
            return this;
        }
    }
}

