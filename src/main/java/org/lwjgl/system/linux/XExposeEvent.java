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

public class XExposeEvent
extends Struct<XExposeEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int COUNT;

    protected XExposeEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XExposeEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XExposeEvent(l, byteBuffer);
    }

    public XExposeEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XExposeEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XExposeEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XExposeEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XExposeEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XExposeEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XExposeEvent.nwindow(this.address());
    }

    public int x() {
        return XExposeEvent.nx(this.address());
    }

    public int y() {
        return XExposeEvent.ny(this.address());
    }

    public int width() {
        return XExposeEvent.nwidth(this.address());
    }

    public int height() {
        return XExposeEvent.nheight(this.address());
    }

    public int count() {
        return XExposeEvent.ncount(this.address());
    }

    public XExposeEvent type(int n) {
        XExposeEvent.ntype(this.address(), n);
        return this;
    }

    public XExposeEvent serial(@NativeType(value="unsigned long") long l) {
        XExposeEvent.nserial(this.address(), l);
        return this;
    }

    public XExposeEvent send_event(@NativeType(value="Bool") boolean bl) {
        XExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XExposeEvent display(@NativeType(value="Display *") long l) {
        XExposeEvent.ndisplay(this.address(), l);
        return this;
    }

    public XExposeEvent window(@NativeType(value="Window") long l) {
        XExposeEvent.nwindow(this.address(), l);
        return this;
    }

    public XExposeEvent x(int n) {
        XExposeEvent.nx(this.address(), n);
        return this;
    }

    public XExposeEvent y(int n) {
        XExposeEvent.ny(this.address(), n);
        return this;
    }

    public XExposeEvent width(int n) {
        XExposeEvent.nwidth(this.address(), n);
        return this;
    }

    public XExposeEvent height(int n) {
        XExposeEvent.nheight(this.address(), n);
        return this;
    }

    public XExposeEvent count(int n) {
        XExposeEvent.ncount(this.address(), n);
        return this;
    }

    public XExposeEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3, int n4, int n5, int n6) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.x(n2);
        this.y(n3);
        this.width(n4);
        this.height(n5);
        this.count(n6);
        return this;
    }

    public XExposeEvent set(XExposeEvent xExposeEvent) {
        MemoryUtil.memCopy(xExposeEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XExposeEvent malloc() {
        return new XExposeEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XExposeEvent calloc() {
        return new XExposeEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XExposeEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XExposeEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XExposeEvent create(long l) {
        return new XExposeEvent(l, null);
    }

    public static @Nullable XExposeEvent createSafe(long l) {
        return l == 0L ? null : new XExposeEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XExposeEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XExposeEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XExposeEvent mallocStack() {
        return XExposeEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent callocStack() {
        return XExposeEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XExposeEvent mallocStack(MemoryStack memoryStack) {
        return XExposeEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XExposeEvent callocStack(MemoryStack memoryStack) {
        return XExposeEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XExposeEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XExposeEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XExposeEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XExposeEvent.calloc(n, memoryStack);
    }

    public static XExposeEvent malloc(MemoryStack memoryStack) {
        return new XExposeEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XExposeEvent calloc(MemoryStack memoryStack) {
        return new XExposeEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nwindow(long l) {
        return MemoryUtil.memGetCLong(l + (long)WINDOW);
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

    public static void nwindow(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)WINDOW, l2);
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

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XExposeEvent.__struct(XExposeEvent.__member(4), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(POINTER_SIZE), XExposeEvent.__member(CLONG_SIZE), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4), XExposeEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        X = layout.offsetof(5);
        Y = layout.offsetof(6);
        WIDTH = layout.offsetof(7);
        HEIGHT = layout.offsetof(8);
        COUNT = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XExposeEvent, Buffer>
    implements NativeResource {
        private static final XExposeEvent ELEMENT_FACTORY = XExposeEvent.create(-1L);

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
        protected XExposeEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XExposeEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XExposeEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XExposeEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XExposeEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XExposeEvent.nwindow(this.address());
        }

        public int x() {
            return XExposeEvent.nx(this.address());
        }

        public int y() {
            return XExposeEvent.ny(this.address());
        }

        public int width() {
            return XExposeEvent.nwidth(this.address());
        }

        public int height() {
            return XExposeEvent.nheight(this.address());
        }

        public int count() {
            return XExposeEvent.ncount(this.address());
        }

        public Buffer type(int n) {
            XExposeEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XExposeEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XExposeEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XExposeEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XExposeEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XExposeEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XExposeEvent.ny(this.address(), n);
            return this;
        }

        public Buffer width(int n) {
            XExposeEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XExposeEvent.nheight(this.address(), n);
            return this;
        }

        public Buffer count(int n) {
            XExposeEvent.ncount(this.address(), n);
            return this;
        }
    }
}

