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

public class XConfigureEvent
extends Struct<XConfigureEvent>
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
    public static final int BORDER_WIDTH;
    public static final int ABOVE;
    public static final int OVERRIDE_REDIRECT;

    protected XConfigureEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XConfigureEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XConfigureEvent(l, byteBuffer);
    }

    public XConfigureEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XConfigureEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XConfigureEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XConfigureEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XConfigureEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XConfigureEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XConfigureEvent.nwindow(this.address());
    }

    public int x() {
        return XConfigureEvent.nx(this.address());
    }

    public int y() {
        return XConfigureEvent.ny(this.address());
    }

    public int width() {
        return XConfigureEvent.nwidth(this.address());
    }

    public int height() {
        return XConfigureEvent.nheight(this.address());
    }

    public int border_width() {
        return XConfigureEvent.nborder_width(this.address());
    }

    @NativeType(value="Window")
    public long above() {
        return XConfigureEvent.nabove(this.address());
    }

    @NativeType(value="Bool")
    public boolean override_redirect() {
        return XConfigureEvent.noverride_redirect(this.address()) != 0;
    }

    public XConfigureEvent type(int n) {
        XConfigureEvent.ntype(this.address(), n);
        return this;
    }

    public XConfigureEvent serial(@NativeType(value="unsigned long") long l) {
        XConfigureEvent.nserial(this.address(), l);
        return this;
    }

    public XConfigureEvent send_event(@NativeType(value="Bool") boolean bl) {
        XConfigureEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XConfigureEvent display(@NativeType(value="Display *") long l) {
        XConfigureEvent.ndisplay(this.address(), l);
        return this;
    }

    public XConfigureEvent window(@NativeType(value="Window") long l) {
        XConfigureEvent.nwindow(this.address(), l);
        return this;
    }

    public XConfigureEvent x(int n) {
        XConfigureEvent.nx(this.address(), n);
        return this;
    }

    public XConfigureEvent y(int n) {
        XConfigureEvent.ny(this.address(), n);
        return this;
    }

    public XConfigureEvent width(int n) {
        XConfigureEvent.nwidth(this.address(), n);
        return this;
    }

    public XConfigureEvent height(int n) {
        XConfigureEvent.nheight(this.address(), n);
        return this;
    }

    public XConfigureEvent border_width(int n) {
        XConfigureEvent.nborder_width(this.address(), n);
        return this;
    }

    public XConfigureEvent above(@NativeType(value="Window") long l) {
        XConfigureEvent.nabove(this.address(), l);
        return this;
    }

    public XConfigureEvent override_redirect(@NativeType(value="Bool") boolean bl) {
        XConfigureEvent.noverride_redirect(this.address(), bl ? 1 : 0);
        return this;
    }

    public XConfigureEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3, int n4, int n5, int n6, long l4, boolean bl2) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.x(n2);
        this.y(n3);
        this.width(n4);
        this.height(n5);
        this.border_width(n6);
        this.above(l4);
        this.override_redirect(bl2);
        return this;
    }

    public XConfigureEvent set(XConfigureEvent xConfigureEvent) {
        MemoryUtil.memCopy(xConfigureEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XConfigureEvent malloc() {
        return new XConfigureEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XConfigureEvent calloc() {
        return new XConfigureEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XConfigureEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XConfigureEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XConfigureEvent create(long l) {
        return new XConfigureEvent(l, null);
    }

    public static @Nullable XConfigureEvent createSafe(long l) {
        return l == 0L ? null : new XConfigureEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XConfigureEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XConfigureEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XConfigureEvent mallocStack() {
        return XConfigureEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent callocStack() {
        return XConfigureEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XConfigureEvent mallocStack(MemoryStack memoryStack) {
        return XConfigureEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XConfigureEvent callocStack(MemoryStack memoryStack) {
        return XConfigureEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XConfigureEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XConfigureEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XConfigureEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XConfigureEvent.calloc(n, memoryStack);
    }

    public static XConfigureEvent malloc(MemoryStack memoryStack) {
        return new XConfigureEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XConfigureEvent calloc(MemoryStack memoryStack) {
        return new XConfigureEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nborder_width(long l) {
        return MemoryUtil.memGetInt(l + (long)BORDER_WIDTH);
    }

    public static long nabove(long l) {
        return MemoryUtil.memGetCLong(l + (long)ABOVE);
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

    public static void noverride_redirect(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OVERRIDE_REDIRECT, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XConfigureEvent.__struct(XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(POINTER_SIZE), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(4), XConfigureEvent.__member(CLONG_SIZE), XConfigureEvent.__member(4));
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
        BORDER_WIDTH = layout.offsetof(9);
        ABOVE = layout.offsetof(10);
        OVERRIDE_REDIRECT = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<XConfigureEvent, Buffer>
    implements NativeResource {
        private static final XConfigureEvent ELEMENT_FACTORY = XConfigureEvent.create(-1L);

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
        protected XConfigureEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XConfigureEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XConfigureEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XConfigureEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XConfigureEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XConfigureEvent.nwindow(this.address());
        }

        public int x() {
            return XConfigureEvent.nx(this.address());
        }

        public int y() {
            return XConfigureEvent.ny(this.address());
        }

        public int width() {
            return XConfigureEvent.nwidth(this.address());
        }

        public int height() {
            return XConfigureEvent.nheight(this.address());
        }

        public int border_width() {
            return XConfigureEvent.nborder_width(this.address());
        }

        @NativeType(value="Window")
        public long above() {
            return XConfigureEvent.nabove(this.address());
        }

        @NativeType(value="Bool")
        public boolean override_redirect() {
            return XConfigureEvent.noverride_redirect(this.address()) != 0;
        }

        public Buffer type(int n) {
            XConfigureEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XConfigureEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XConfigureEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XConfigureEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XConfigureEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XConfigureEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XConfigureEvent.ny(this.address(), n);
            return this;
        }

        public Buffer width(int n) {
            XConfigureEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XConfigureEvent.nheight(this.address(), n);
            return this;
        }

        public Buffer border_width(int n) {
            XConfigureEvent.nborder_width(this.address(), n);
            return this;
        }

        public Buffer above(@NativeType(value="Window") long l) {
            XConfigureEvent.nabove(this.address(), l);
            return this;
        }

        public Buffer override_redirect(@NativeType(value="Bool") boolean bl) {
            XConfigureEvent.noverride_redirect(this.address(), bl ? 1 : 0);
            return this;
        }
    }
}

