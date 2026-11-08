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

public class XNoExposeEvent
extends Struct<XNoExposeEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    protected XNoExposeEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XNoExposeEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XNoExposeEvent(l, byteBuffer);
    }

    public XNoExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XNoExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XNoExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XNoExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XNoExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XNoExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XNoExposeEvent.ndrawable(this.address());
    }

    public int major_code() {
        return XNoExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XNoExposeEvent.nminor_code(this.address());
    }

    public XNoExposeEvent type(int n) {
        XNoExposeEvent.ntype(this.address(), n);
        return this;
    }

    public XNoExposeEvent serial(@NativeType(value="unsigned long") long l) {
        XNoExposeEvent.nserial(this.address(), l);
        return this;
    }

    public XNoExposeEvent send_event(@NativeType(value="Bool") boolean bl) {
        XNoExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XNoExposeEvent display(@NativeType(value="Display *") long l) {
        XNoExposeEvent.ndisplay(this.address(), l);
        return this;
    }

    public XNoExposeEvent drawable(@NativeType(value="Drawable") long l) {
        XNoExposeEvent.ndrawable(this.address(), l);
        return this;
    }

    public XNoExposeEvent major_code(int n) {
        XNoExposeEvent.nmajor_code(this.address(), n);
        return this;
    }

    public XNoExposeEvent minor_code(int n) {
        XNoExposeEvent.nminor_code(this.address(), n);
        return this;
    }

    public XNoExposeEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.drawable(l3);
        this.major_code(n2);
        this.minor_code(n3);
        return this;
    }

    public XNoExposeEvent set(XNoExposeEvent xNoExposeEvent) {
        MemoryUtil.memCopy(xNoExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XNoExposeEvent malloc() {
        return new XNoExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XNoExposeEvent calloc() {
        return new XNoExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XNoExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XNoExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XNoExposeEvent create(long l) {
        return new XNoExposeEvent(l, null);
    }

    public static @Nullable XNoExposeEvent createSafe(long l) {
        return l == 0L ? null : new XNoExposeEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XNoExposeEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XNoExposeEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XNoExposeEvent mallocStack() {
        return XNoExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent callocStack() {
        return XNoExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XNoExposeEvent mallocStack(MemoryStack memoryStack) {
        return XNoExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XNoExposeEvent callocStack(MemoryStack memoryStack) {
        return XNoExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XNoExposeEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XNoExposeEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XNoExposeEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XNoExposeEvent.calloc(n, memoryStack);
    }

    public static XNoExposeEvent malloc(MemoryStack memoryStack) {
        return new XNoExposeEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XNoExposeEvent calloc(MemoryStack memoryStack) {
        return new XNoExposeEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nserial(long l) {
        return MemoryUtil.memGetCLong(l + (long)SERIAL);
    }

    public static int nsend_event(long l) {
        return MemoryUtil.memGetInt(l + (long)SEND_EVENT);
    }

    public static long ndisplay(long l) {
        return MemoryUtil.memGetAddress(l + (long)DISPLAY);
    }

    public static long ndrawable(long l) {
        return MemoryUtil.memGetCLong(l + (long)DRAWABLE);
    }

    public static int nmajor_code(long l) {
        return MemoryUtil.memGetInt(l + (long)MAJOR_CODE);
    }

    public static int nminor_code(long l) {
        return MemoryUtil.memGetInt(l + (long)MINOR_CODE);
    }

    public static void ntype(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TYPE, n);
    }

    public static void nserial(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)SERIAL, l2);
    }

    public static void nsend_event(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SEND_EVENT, n);
    }

    public static void ndisplay(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)DISPLAY, Checks.check(l2));
    }

    public static void ndrawable(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)DRAWABLE, l2);
    }

    public static void nmajor_code(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MAJOR_CODE, n);
    }

    public static void nminor_code(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MINOR_CODE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XNoExposeEvent.__struct(XNoExposeEvent.__member(4), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(POINTER_SIZE), XNoExposeEvent.__member(CLONG_SIZE), XNoExposeEvent.__member(4), XNoExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        DRAWABLE = layout.offsetof(4);
        MAJOR_CODE = layout.offsetof(5);
        MINOR_CODE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XNoExposeEvent, Buffer>
    implements NativeResource {
        private static final XNoExposeEvent ELEMENT_FACTORY = XNoExposeEvent.create(-1L);

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
        protected XNoExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XNoExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XNoExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XNoExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XNoExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XNoExposeEvent.ndrawable(this.address());
        }

        public int major_code() {
            return XNoExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XNoExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int n) {
            XNoExposeEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XNoExposeEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XNoExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XNoExposeEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long l) {
            XNoExposeEvent.ndrawable(this.address(), l);
            return this;
        }

        public Buffer major_code(int n) {
            XNoExposeEvent.nmajor_code(this.address(), n);
            return this;
        }

        public Buffer minor_code(int n) {
            XNoExposeEvent.nminor_code(this.address(), n);
            return this;
        }
    }
}

