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

public class XGraphicsExposeEvent
extends Struct<XGraphicsExposeEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int DRAWABLE;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int COUNT;
    public static final int MAJOR_CODE;
    public static final int MINOR_CODE;

    protected XGraphicsExposeEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XGraphicsExposeEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XGraphicsExposeEvent(l, byteBuffer);
    }

    public XGraphicsExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGraphicsExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGraphicsExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGraphicsExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGraphicsExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Drawable")
    public long drawable() {
        return XGraphicsExposeEvent.ndrawable(this.address());
    }

    public int x() {
        return XGraphicsExposeEvent.nx(this.address());
    }

    public int y() {
        return XGraphicsExposeEvent.ny(this.address());
    }

    public int width() {
        return XGraphicsExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XGraphicsExposeEvent.nheight(this.address());
    }

    public int count() {
        return XGraphicsExposeEvent.ncount(this.address());
    }

    public int major_code() {
        return XGraphicsExposeEvent.nmajor_code(this.address());
    }

    public int minor_code() {
        return XGraphicsExposeEvent.nminor_code(this.address());
    }

    public XGraphicsExposeEvent type(int n) {
        XGraphicsExposeEvent.ntype(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent serial(@NativeType(value="unsigned long") long l) {
        XGraphicsExposeEvent.nserial(this.address(), l);
        return this;
    }

    public XGraphicsExposeEvent send_event(@NativeType(value="Bool") boolean bl) {
        XGraphicsExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XGraphicsExposeEvent display(@NativeType(value="Display *") long l) {
        XGraphicsExposeEvent.ndisplay(this.address(), l);
        return this;
    }

    public XGraphicsExposeEvent drawable(@NativeType(value="Drawable") long l) {
        XGraphicsExposeEvent.ndrawable(this.address(), l);
        return this;
    }

    public XGraphicsExposeEvent x(int n) {
        XGraphicsExposeEvent.nx(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent y(int n) {
        XGraphicsExposeEvent.ny(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent width(int n) {
        XGraphicsExposeEvent.nwidth(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent height(int n) {
        XGraphicsExposeEvent.nheight(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent count(int n) {
        XGraphicsExposeEvent.ncount(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent major_code(int n) {
        XGraphicsExposeEvent.nmajor_code(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent minor_code(int n) {
        XGraphicsExposeEvent.nminor_code(this.address(), n);
        return this;
    }

    public XGraphicsExposeEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.drawable(l3);
        this.x(n2);
        this.y(n3);
        this.width(n4);
        this.height(n5);
        this.count(n6);
        this.major_code(n7);
        this.minor_code(n8);
        return this;
    }

    public XGraphicsExposeEvent set(XGraphicsExposeEvent xGraphicsExposeEvent) {
        MemoryUtil.memCopy(xGraphicsExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGraphicsExposeEvent malloc() {
        return new XGraphicsExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XGraphicsExposeEvent calloc() {
        return new XGraphicsExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XGraphicsExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XGraphicsExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGraphicsExposeEvent create(long l) {
        return new XGraphicsExposeEvent(l, null);
    }

    public static @Nullable XGraphicsExposeEvent createSafe(long l) {
        return l == 0L ? null : new XGraphicsExposeEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XGraphicsExposeEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XGraphicsExposeEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XGraphicsExposeEvent mallocStack() {
        return XGraphicsExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack() {
        return XGraphicsExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGraphicsExposeEvent mallocStack(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XGraphicsExposeEvent callocStack(MemoryStack memoryStack) {
        return XGraphicsExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XGraphicsExposeEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XGraphicsExposeEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XGraphicsExposeEvent.calloc(n, memoryStack);
    }

    public static XGraphicsExposeEvent malloc(MemoryStack memoryStack) {
        return new XGraphicsExposeEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XGraphicsExposeEvent calloc(MemoryStack memoryStack) {
        return new XGraphicsExposeEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nx(long l) {
        return MemoryUtil.memGetInt(l + (long)X);
    }

    public static int ny(long l) {
        return MemoryUtil.memGetInt(l + (long)Y);
    }

    public static int nwidth(long l) {
        return MemoryUtil.memGetInt(l + (long)WIDTH);
    }

    public static int nheight(long l) {
        return MemoryUtil.memGetInt(l + (long)HEIGHT);
    }

    public static int ncount(long l) {
        return MemoryUtil.memGetInt(l + (long)COUNT);
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

    public static void nx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X, n);
    }

    public static void ny(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y, n);
    }

    public static void nwidth(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WIDTH, n);
    }

    public static void nheight(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HEIGHT, n);
    }

    public static void ncount(long l, int n) {
        MemoryUtil.memPutInt(l + (long)COUNT, n);
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
        Struct.Layout layout = XGraphicsExposeEvent.__struct(XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(POINTER_SIZE), XGraphicsExposeEvent.__member(CLONG_SIZE), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4), XGraphicsExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        DRAWABLE = layout.offsetof(4);
        X = layout.offsetof(5);
        Y = layout.offsetof(6);
        WIDTH = layout.offsetof(7);
        HEIGHT = layout.offsetof(8);
        COUNT = layout.offsetof(9);
        MAJOR_CODE = layout.offsetof(10);
        MINOR_CODE = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XGraphicsExposeEvent, Buffer>
    implements NativeResource {
        private static final XGraphicsExposeEvent ELEMENT_FACTORY = XGraphicsExposeEvent.create(-1L);

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
        protected XGraphicsExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGraphicsExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGraphicsExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGraphicsExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGraphicsExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Drawable")
        public long drawable() {
            return XGraphicsExposeEvent.ndrawable(this.address());
        }

        public int x() {
            return XGraphicsExposeEvent.nx(this.address());
        }

        public int y() {
            return XGraphicsExposeEvent.ny(this.address());
        }

        public int width() {
            return XGraphicsExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XGraphicsExposeEvent.nheight(this.address());
        }

        public int count() {
            return XGraphicsExposeEvent.ncount(this.address());
        }

        public int major_code() {
            return XGraphicsExposeEvent.nmajor_code(this.address());
        }

        public int minor_code() {
            return XGraphicsExposeEvent.nminor_code(this.address());
        }

        public Buffer type(int n) {
            XGraphicsExposeEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XGraphicsExposeEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XGraphicsExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XGraphicsExposeEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer drawable(@NativeType(value="Drawable") long l) {
            XGraphicsExposeEvent.ndrawable(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XGraphicsExposeEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XGraphicsExposeEvent.ny(this.address(), n);
            return this;
        }

        public Buffer width(int n) {
            XGraphicsExposeEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XGraphicsExposeEvent.nheight(this.address(), n);
            return this;
        }

        public Buffer count(int n) {
            XGraphicsExposeEvent.ncount(this.address(), n);
            return this;
        }

        public Buffer major_code(int n) {
            XGraphicsExposeEvent.nmajor_code(this.address(), n);
            return this;
        }

        public Buffer minor_code(int n) {
            XGraphicsExposeEvent.nminor_code(this.address(), n);
            return this;
        }
    }
}

