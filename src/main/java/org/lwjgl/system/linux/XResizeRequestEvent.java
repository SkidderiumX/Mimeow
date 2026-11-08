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

public class XResizeRequestEvent
extends Struct<XResizeRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int WIDTH;
    public static final int HEIGHT;

    protected XResizeRequestEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XResizeRequestEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XResizeRequestEvent(l, byteBuffer);
    }

    public XResizeRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XResizeRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XResizeRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XResizeRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XResizeRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XResizeRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XResizeRequestEvent.nwindow(this.address());
    }

    public int width() {
        return XResizeRequestEvent.nwidth(this.address());
    }

    public int height() {
        return XResizeRequestEvent.nheight(this.address());
    }

    public XResizeRequestEvent type(int n) {
        XResizeRequestEvent.ntype(this.address(), n);
        return this;
    }

    public XResizeRequestEvent serial(@NativeType(value="unsigned long") long l) {
        XResizeRequestEvent.nserial(this.address(), l);
        return this;
    }

    public XResizeRequestEvent send_event(@NativeType(value="Bool") boolean bl) {
        XResizeRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XResizeRequestEvent display(@NativeType(value="Display *") long l) {
        XResizeRequestEvent.ndisplay(this.address(), l);
        return this;
    }

    public XResizeRequestEvent window(@NativeType(value="Window") long l) {
        XResizeRequestEvent.nwindow(this.address(), l);
        return this;
    }

    public XResizeRequestEvent width(int n) {
        XResizeRequestEvent.nwidth(this.address(), n);
        return this;
    }

    public XResizeRequestEvent height(int n) {
        XResizeRequestEvent.nheight(this.address(), n);
        return this;
    }

    public XResizeRequestEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.width(n2);
        this.height(n3);
        return this;
    }

    public XResizeRequestEvent set(XResizeRequestEvent xResizeRequestEvent) {
        MemoryUtil.memCopy(xResizeRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XResizeRequestEvent malloc() {
        return new XResizeRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XResizeRequestEvent calloc() {
        return new XResizeRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XResizeRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XResizeRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XResizeRequestEvent create(long l) {
        return new XResizeRequestEvent(l, null);
    }

    public static @Nullable XResizeRequestEvent createSafe(long l) {
        return l == 0L ? null : new XResizeRequestEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XResizeRequestEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XResizeRequestEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XResizeRequestEvent mallocStack() {
        return XResizeRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XResizeRequestEvent callocStack() {
        return XResizeRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XResizeRequestEvent mallocStack(MemoryStack memoryStack) {
        return XResizeRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XResizeRequestEvent callocStack(MemoryStack memoryStack) {
        return XResizeRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XResizeRequestEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XResizeRequestEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XResizeRequestEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XResizeRequestEvent.calloc(n, memoryStack);
    }

    public static XResizeRequestEvent malloc(MemoryStack memoryStack) {
        return new XResizeRequestEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XResizeRequestEvent calloc(MemoryStack memoryStack) {
        return new XResizeRequestEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nwidth(long l) {
        return MemoryUtil.memGetInt(l + (long)WIDTH);
    }

    public static int nheight(long l) {
        return MemoryUtil.memGetInt(l + (long)HEIGHT);
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

    public static void nwidth(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WIDTH, n);
    }

    public static void nheight(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HEIGHT, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XResizeRequestEvent.__struct(XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(POINTER_SIZE), XResizeRequestEvent.__member(CLONG_SIZE), XResizeRequestEvent.__member(4), XResizeRequestEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        WIDTH = layout.offsetof(5);
        HEIGHT = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XResizeRequestEvent, Buffer>
    implements NativeResource {
        private static final XResizeRequestEvent ELEMENT_FACTORY = XResizeRequestEvent.create(-1L);

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
        protected XResizeRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XResizeRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XResizeRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XResizeRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XResizeRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XResizeRequestEvent.nwindow(this.address());
        }

        public int width() {
            return XResizeRequestEvent.nwidth(this.address());
        }

        public int height() {
            return XResizeRequestEvent.nheight(this.address());
        }

        public Buffer type(int n) {
            XResizeRequestEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XResizeRequestEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XResizeRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XResizeRequestEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XResizeRequestEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer width(int n) {
            XResizeRequestEvent.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            XResizeRequestEvent.nheight(this.address(), n);
            return this;
        }
    }
}

