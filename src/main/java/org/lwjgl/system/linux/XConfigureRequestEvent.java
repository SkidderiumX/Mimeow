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

public class XConfigureRequestEvent
extends Struct<XConfigureRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;
    public static final int X;
    public static final int Y;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int DETAIL;
    public static final int VALUE_MASK;

    protected XConfigureRequestEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XConfigureRequestEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XConfigureRequestEvent(l, byteBuffer);
    }

    public XConfigureRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XConfigureRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XConfigureRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureRequestEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureRequestEvent.nx(this.address());
    }

    public int y() {
        return XConfigureRequestEvent.ny(this.address());
    }

    public int width() {
        return XConfigureRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureRequestEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureRequestEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureRequestEvent.nabove(this.address());
    }

    public int detail() {
        return XConfigureRequestEvent.ndetail(this.address());
    }

    @NativeType(value="unsigned long")
    public long value_mask() {
        return XConfigureRequestEvent.nvalue_mask(this.address());
    }

    public XConfigureRequestEvent type(int n) {
        XConfigureRequestEvent.ntype(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent serial(@NativeType(value="unsigned long") long l) {
        XConfigureRequestEvent.nserial(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent send_event(@NativeType(value="Bool") boolean bl) {
        XConfigureRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XConfigureRequestEvent display(@NativeType(value="Display *") long l) {
        XConfigureRequestEvent.ndisplay(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent parent(@NativeType(value="Window") long l) {
        XConfigureRequestEvent.nparent(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent window(@NativeType(value="Window") long l) {
        XConfigureRequestEvent.nwindow(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent x(int n) {
        XConfigureRequestEvent.nx(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent y(int n) {
        XConfigureRequestEvent.ny(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent width(int n) {
        XConfigureRequestEvent.nwidth(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent height(int n) {
        XConfigureRequestEvent.nheight(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent border_width(int n) {
        XConfigureRequestEvent.nborder_width(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent above(@NativeType(value="Window") long l) {
        XConfigureRequestEvent.nabove(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent detail(int n) {
        XConfigureRequestEvent.ndetail(this.address(), n);
        return this;
    }

    public XConfigureRequestEvent value_mask(@NativeType(value="unsigned long") long l) {
        XConfigureRequestEvent.nvalue_mask(this.address(), l);
        return this;
    }

    public XConfigureRequestEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2, int n3, int n4, int n5, int n6, long l5, int n7, long l6) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.parent(l3);
        this.window(l4);
        this.x(n2);
        this.y(n3);
        this.width(n4);
        this.height(n5);
        this.border_width(n6);
        this.above(l5);
        this.detail(n7);
        this.value_mask(l6);
        return this;
    }

    public XConfigureRequestEvent set(XConfigureRequestEvent xConfigureRequestEvent) {
        MemoryUtil.memCopy(xConfigureRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureRequestEvent malloc() {
        return new XConfigureRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XConfigureRequestEvent calloc() {
        return new XConfigureRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XConfigureRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XConfigureRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XConfigureRequestEvent create(long l) {
        return new XConfigureRequestEvent(l, null);
    }

    public static @Nullable XConfigureRequestEvent createSafe(long l) {
        return l == 0L ? null : new XConfigureRequestEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XConfigureRequestEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XConfigureRequestEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XConfigureRequestEvent mallocStack() {
        return XConfigureRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack() {
        return XConfigureRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureRequestEvent mallocStack(MemoryStack memoryStack) {
        return XConfigureRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XConfigureRequestEvent callocStack(MemoryStack memoryStack) {
        return XConfigureRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XConfigureRequestEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XConfigureRequestEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XConfigureRequestEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XConfigureRequestEvent.calloc(n, memoryStack);
    }

    public static XConfigureRequestEvent malloc(MemoryStack memoryStack) {
        return new XConfigureRequestEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XConfigureRequestEvent calloc(MemoryStack memoryStack) {
        return new XConfigureRequestEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nparent(long l) {
        return MemoryUtil.memGetCLong(l + (long)PARENT);
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

    public static int nborder_width(long l) {
        return MemoryUtil.memGetInt(l + (long)BORDER_WIDTH);
    }

    public static long nabove(long l) {
        return MemoryUtil.memGetCLong(l + (long)ABOVE);
    }

    public static int ndetail(long l) {
        return MemoryUtil.memGetInt(l + (long)DETAIL);
    }

    public static long nvalue_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)VALUE_MASK);
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

    public static void nparent(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)PARENT, l2);
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

    public static void nborder_width(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BORDER_WIDTH, n);
    }

    public static void nabove(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)ABOVE, l2);
    }

    public static void ndetail(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DETAIL, n);
    }

    public static void nvalue_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)VALUE_MASK, l2);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XConfigureRequestEvent.__struct(XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(POINTER_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE), XConfigureRequestEvent.__member(4), XConfigureRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        PARENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        X = layout.offsetof(6);
        Y = layout.offsetof(7);
        WIDTH = layout.offsetof(8);
        HEIGHT = layout.offsetof(9);
        BORDER_WIDTH = layout.offsetof(10);
        ABOVE = layout.offsetof(11);
        DETAIL = layout.offsetof(12);
        VALUE_MASK = layout.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<XConfigureRequestEvent, Buffer>
    implements NativeResource {
        private static final XConfigureRequestEvent ELEMENT_FACTORY = XConfigureRequestEvent.create(-1L);

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
        protected XConfigureRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XConfigureRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureRequestEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureRequestEvent.nx(this.address());
        }

        public int y() {
            return XConfigureRequestEvent.ny(this.address());
        }

        public int width() {
            return XConfigureRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureRequestEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureRequestEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureRequestEvent.nabove(this.address());
        }

        public int detail() {
            return XConfigureRequestEvent.ndetail(this.address());
        }

        @NativeType(value="unsigned long")
        public long value_mask() {
            return XConfigureRequestEvent.nvalue_mask(this.address());
        }

        public Buffer type(int n) {
            XConfigureRequestEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XConfigureRequestEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XConfigureRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XConfigureRequestEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l) {
            XConfigureRequestEvent.nparent(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XConfigureRequestEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XConfigureRequestEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XConfigureRequestEvent.ny(this.address(), n);
            return this;
        }

        public Buffer width(int n) {
            XConfigureRequestEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XConfigureRequestEvent.nheight(this.address(), n);
            return this;
        }

        public Buffer border_width(int n) {
            XConfigureRequestEvent.nborder_width(this.address(), n);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long l) {
            XConfigureRequestEvent.nabove(this.address(), l);
            return this;
        }

        public Buffer detail(int n) {
            XConfigureRequestEvent.ndetail(this.address(), n);
            return this;
        }

        public Buffer value_mask(@NativeType(value="unsigned long") long l) {
            XConfigureRequestEvent.nvalue_mask(this.address(), l);
            return this;
        }
    }
}

