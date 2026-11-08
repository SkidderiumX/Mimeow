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

public class XCreateWindowEvent
extends Struct<XCreateWindowEvent>
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
    public static final int OVERRIDE_REDIRECT;

    protected XCreateWindowEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XCreateWindowEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XCreateWindowEvent(l, byteBuffer);
    }

    public XCreateWindowEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCreateWindowEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCreateWindowEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCreateWindowEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCreateWindowEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCreateWindowEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XCreateWindowEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCreateWindowEvent.nwindow(this.address());
    }

    public int x() {
        return XCreateWindowEvent.nx(this.address());
    }

    public int y() {
        return XCreateWindowEvent.ny(this.address());
    }

    public int width() {
        return XCreateWindowEvent.nwidth(this.address());
    }

    public int height() {
        return XCreateWindowEvent.nheight(this.address());
    }

    public int border_width() {
        return XCreateWindowEvent.nborder_width(this.address());
    }

    public int override_redirect() {
        return XCreateWindowEvent.noverride_redirect(this.address());
    }

    public XCreateWindowEvent type(int n) {
        XCreateWindowEvent.ntype(this.address(), n);
        return this;
    }

    public XCreateWindowEvent serial(@NativeType(value="unsigned long") long l) {
        XCreateWindowEvent.nserial(this.address(), l);
        return this;
    }

    public XCreateWindowEvent send_event(@NativeType(value="Bool") boolean bl) {
        XCreateWindowEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XCreateWindowEvent display(@NativeType(value="Display *") long l) {
        XCreateWindowEvent.ndisplay(this.address(), l);
        return this;
    }

    public XCreateWindowEvent parent(@NativeType(value="Window") long l) {
        XCreateWindowEvent.nparent(this.address(), l);
        return this;
    }

    public XCreateWindowEvent window(@NativeType(value="Window") long l) {
        XCreateWindowEvent.nwindow(this.address(), l);
        return this;
    }

    public XCreateWindowEvent x(int n) {
        XCreateWindowEvent.nx(this.address(), n);
        return this;
    }

    public XCreateWindowEvent y(int n) {
        XCreateWindowEvent.ny(this.address(), n);
        return this;
    }

    public XCreateWindowEvent width(int n) {
        XCreateWindowEvent.nwidth(this.address(), n);
        return this;
    }

    public XCreateWindowEvent height(int n) {
        XCreateWindowEvent.nheight(this.address(), n);
        return this;
    }

    public XCreateWindowEvent border_width(int n) {
        XCreateWindowEvent.nborder_width(this.address(), n);
        return this;
    }

    public XCreateWindowEvent override_redirect(int n) {
        XCreateWindowEvent.noverride_redirect(this.address(), n);
        return this;
    }

    public XCreateWindowEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2, int n3, int n4, int n5, int n6, int n7) {
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
        this.override_redirect(n7);
        return this;
    }

    public XCreateWindowEvent set(XCreateWindowEvent xCreateWindowEvent) {
        MemoryUtil.memCopy(xCreateWindowEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCreateWindowEvent malloc() {
        return new XCreateWindowEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XCreateWindowEvent calloc() {
        return new XCreateWindowEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XCreateWindowEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XCreateWindowEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCreateWindowEvent create(long l) {
        return new XCreateWindowEvent(l, null);
    }

    public static @Nullable XCreateWindowEvent createSafe(long l) {
        return l == 0L ? null : new XCreateWindowEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XCreateWindowEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XCreateWindowEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XCreateWindowEvent mallocStack() {
        return XCreateWindowEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent callocStack() {
        return XCreateWindowEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCreateWindowEvent mallocStack(MemoryStack memoryStack) {
        return XCreateWindowEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCreateWindowEvent callocStack(MemoryStack memoryStack) {
        return XCreateWindowEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XCreateWindowEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XCreateWindowEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XCreateWindowEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XCreateWindowEvent.calloc(n, memoryStack);
    }

    public static XCreateWindowEvent malloc(MemoryStack memoryStack) {
        return new XCreateWindowEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XCreateWindowEvent calloc(MemoryStack memoryStack) {
        return new XCreateWindowEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int noverride_redirect(long l) {
        return MemoryUtil.memGetInt(l + (long)OVERRIDE_REDIRECT);
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

    public static void noverride_redirect(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OVERRIDE_REDIRECT, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCreateWindowEvent.__struct(XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(POINTER_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(CLONG_SIZE), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4), XCreateWindowEvent.__member(4));
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
        OVERRIDE_REDIRECT = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XCreateWindowEvent, Buffer>
    implements NativeResource {
        private static final XCreateWindowEvent ELEMENT_FACTORY = XCreateWindowEvent.create(-1L);

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
        protected XCreateWindowEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCreateWindowEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCreateWindowEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCreateWindowEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCreateWindowEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XCreateWindowEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCreateWindowEvent.nwindow(this.address());
        }

        public int x() {
            return XCreateWindowEvent.nx(this.address());
        }

        public int y() {
            return XCreateWindowEvent.ny(this.address());
        }

        public int width() {
            return XCreateWindowEvent.nwidth(this.address());
        }

        public int height() {
            return XCreateWindowEvent.nheight(this.address());
        }

        public int border_width() {
            return XCreateWindowEvent.nborder_width(this.address());
        }

        public int override_redirect() {
            return XCreateWindowEvent.noverride_redirect(this.address());
        }

        public Buffer type(int n) {
            XCreateWindowEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XCreateWindowEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XCreateWindowEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XCreateWindowEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l) {
            XCreateWindowEvent.nparent(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XCreateWindowEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XCreateWindowEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XCreateWindowEvent.ny(this.address(), n);
            return this;
        }

        public Buffer width(int n) {
            XCreateWindowEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XCreateWindowEvent.nheight(this.address(), n);
            return this;
        }

        public Buffer border_width(int n) {
            XCreateWindowEvent.nborder_width(this.address(), n);
            return this;
        }

        public Buffer override_redirect(int n) {
            XCreateWindowEvent.noverride_redirect(this.address(), n);
            return this;
        }
    }
}

