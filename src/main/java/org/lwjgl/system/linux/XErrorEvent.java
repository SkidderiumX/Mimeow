/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XErrorEvent
extends Struct<XErrorEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DISPLAY;
    public static final int RESOURCEID;
    public static final int SERIAL;
    public static final int ERROR_CODE;
    public static final int REQUEST_CODE;
    public static final int MINOR_CODE;

    protected XErrorEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XErrorEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XErrorEvent(l, byteBuffer);
    }

    public XErrorEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XErrorEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XErrorEvent.ntype(this.address());
    }

    @NativeType(value="Display *")
    public long display() {
        return XErrorEvent.ndisplay(this.address());
    }

    @NativeType(value="XID")
    public long resourceid() {
        return XErrorEvent.nresourceid(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XErrorEvent.nserial(this.address());
    }

    @NativeType(value="unsigned char")
    public byte error_code() {
        return XErrorEvent.nerror_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte request_code() {
        return XErrorEvent.nrequest_code(this.address());
    }

    @NativeType(value="unsigned char")
    public byte minor_code() {
        return XErrorEvent.nminor_code(this.address());
    }

    public XErrorEvent type(int n) {
        XErrorEvent.ntype(this.address(), n);
        return this;
    }

    public XErrorEvent display(@NativeType(value="Display *") long l) {
        XErrorEvent.ndisplay(this.address(), l);
        return this;
    }

    public XErrorEvent resourceid(@NativeType(value="XID") long l) {
        XErrorEvent.nresourceid(this.address(), l);
        return this;
    }

    public XErrorEvent serial(@NativeType(value="unsigned long") long l) {
        XErrorEvent.nserial(this.address(), l);
        return this;
    }

    public XErrorEvent error_code(@NativeType(value="unsigned char") byte by) {
        XErrorEvent.nerror_code(this.address(), by);
        return this;
    }

    public XErrorEvent request_code(@NativeType(value="unsigned char") byte by) {
        XErrorEvent.nrequest_code(this.address(), by);
        return this;
    }

    public XErrorEvent minor_code(@NativeType(value="unsigned char") byte by) {
        XErrorEvent.nminor_code(this.address(), by);
        return this;
    }

    public XErrorEvent set(int n, long l, long l2, long l3, byte by, byte by2, byte by3) {
        this.type(n);
        this.display(l);
        this.resourceid(l2);
        this.serial(l3);
        this.error_code(by);
        this.request_code(by2);
        this.minor_code(by3);
        return this;
    }

    public XErrorEvent set(XErrorEvent xErrorEvent) {
        MemoryUtil.memCopy(xErrorEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XErrorEvent malloc() {
        return new XErrorEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XErrorEvent calloc() {
        return new XErrorEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XErrorEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XErrorEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XErrorEvent create(long l) {
        return new XErrorEvent(l, null);
    }

    public static @Nullable XErrorEvent createSafe(long l) {
        return l == 0L ? null : new XErrorEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XErrorEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XErrorEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XErrorEvent mallocStack() {
        return XErrorEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent callocStack() {
        return XErrorEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XErrorEvent mallocStack(MemoryStack memoryStack) {
        return XErrorEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XErrorEvent callocStack(MemoryStack memoryStack) {
        return XErrorEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XErrorEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XErrorEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XErrorEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XErrorEvent.calloc(n, memoryStack);
    }

    public static XErrorEvent malloc(MemoryStack memoryStack) {
        return new XErrorEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XErrorEvent calloc(MemoryStack memoryStack) {
        return new XErrorEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ntype(long l) {
        return MemoryUtil.memGetInt(l + (long)TYPE);
    }

    public static long ndisplay(long l) {
        return MemoryUtil.memGetAddress(l + (long)DISPLAY);
    }

    public static long nresourceid(long l) {
        return MemoryUtil.memGetCLong(l + (long)RESOURCEID);
    }

    public static long nserial(long l) {
        return MemoryUtil.memGetCLong(l + (long)SERIAL);
    }

    public static byte nerror_code(long l) {
        return MemoryUtil.memGetByte(l + (long)ERROR_CODE);
    }

    public static byte nrequest_code(long l) {
        return MemoryUtil.memGetByte(l + (long)REQUEST_CODE);
    }

    public static byte nminor_code(long l) {
        return MemoryUtil.memGetByte(l + (long)MINOR_CODE);
    }

    public static void ntype(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TYPE, n);
    }

    public static void ndisplay(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)DISPLAY, Checks.check(l2));
    }

    public static void nresourceid(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)RESOURCEID, l2);
    }

    public static void nserial(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)SERIAL, l2);
    }

    public static void nerror_code(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)ERROR_CODE, by);
    }

    public static void nrequest_code(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)REQUEST_CODE, by);
    }

    public static void nminor_code(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)MINOR_CODE, by);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XErrorEvent.__struct(XErrorEvent.__member(4), XErrorEvent.__member(POINTER_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(CLONG_SIZE), XErrorEvent.__member(1), XErrorEvent.__member(1), XErrorEvent.__member(1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DISPLAY = layout.offsetof(1);
        RESOURCEID = layout.offsetof(2);
        SERIAL = layout.offsetof(3);
        ERROR_CODE = layout.offsetof(4);
        REQUEST_CODE = layout.offsetof(5);
        MINOR_CODE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XErrorEvent, Buffer>
    implements NativeResource {
        private static final XErrorEvent ELEMENT_FACTORY = XErrorEvent.create(-1L);

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
        protected XErrorEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XErrorEvent.ntype(this.address());
        }

        @NativeType(value="Display *")
        public long display() {
            return XErrorEvent.ndisplay(this.address());
        }

        @NativeType(value="XID")
        public long resourceid() {
            return XErrorEvent.nresourceid(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XErrorEvent.nserial(this.address());
        }

        @NativeType(value="unsigned char")
        public byte error_code() {
            return XErrorEvent.nerror_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte request_code() {
            return XErrorEvent.nrequest_code(this.address());
        }

        @NativeType(value="unsigned char")
        public byte minor_code() {
            return XErrorEvent.nminor_code(this.address());
        }

        public Buffer type(int n) {
            XErrorEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XErrorEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer resourceid(@NativeType(value="XID") long l) {
            XErrorEvent.nresourceid(this.address(), l);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XErrorEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer error_code(@NativeType(value="unsigned char") byte by) {
            XErrorEvent.nerror_code(this.address(), by);
            return this;
        }

        public Buffer request_code(@NativeType(value="unsigned char") byte by) {
            XErrorEvent.nrequest_code(this.address(), by);
            return this;
        }

        public Buffer minor_code(@NativeType(value="unsigned char") byte by) {
            XErrorEvent.nminor_code(this.address(), by);
            return this;
        }
    }
}

