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

public class XMapRequestEvent
extends Struct<XMapRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int PARENT;
    public static final int WINDOW;

    protected XMapRequestEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XMapRequestEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XMapRequestEvent(l, byteBuffer);
    }

    public XMapRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMapRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long parent() {
        return XMapRequestEvent.nparent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapRequestEvent.nwindow(this.address());
    }

    public XMapRequestEvent type(int n) {
        XMapRequestEvent.ntype(this.address(), n);
        return this;
    }

    public XMapRequestEvent serial(@NativeType(value="unsigned long") long l) {
        XMapRequestEvent.nserial(this.address(), l);
        return this;
    }

    public XMapRequestEvent send_event(@NativeType(value="Bool") boolean bl) {
        XMapRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XMapRequestEvent display(@NativeType(value="Display *") long l) {
        XMapRequestEvent.ndisplay(this.address(), l);
        return this;
    }

    public XMapRequestEvent parent(@NativeType(value="Window") long l) {
        XMapRequestEvent.nparent(this.address(), l);
        return this;
    }

    public XMapRequestEvent window(@NativeType(value="Window") long l) {
        XMapRequestEvent.nwindow(this.address(), l);
        return this;
    }

    public XMapRequestEvent set(int n, long l, boolean bl, long l2, long l3, long l4) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.parent(l3);
        this.window(l4);
        return this;
    }

    public XMapRequestEvent set(XMapRequestEvent xMapRequestEvent) {
        MemoryUtil.memCopy(xMapRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapRequestEvent malloc() {
        return new XMapRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMapRequestEvent calloc() {
        return new XMapRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMapRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XMapRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMapRequestEvent create(long l) {
        return new XMapRequestEvent(l, null);
    }

    public static @Nullable XMapRequestEvent createSafe(long l) {
        return l == 0L ? null : new XMapRequestEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMapRequestEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XMapRequestEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XMapRequestEvent mallocStack() {
        return XMapRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent callocStack() {
        return XMapRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapRequestEvent mallocStack(MemoryStack memoryStack) {
        return XMapRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMapRequestEvent callocStack(MemoryStack memoryStack) {
        return XMapRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XMapRequestEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XMapRequestEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XMapRequestEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XMapRequestEvent.calloc(n, memoryStack);
    }

    public static XMapRequestEvent malloc(MemoryStack memoryStack) {
        return new XMapRequestEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMapRequestEvent calloc(MemoryStack memoryStack) {
        return new XMapRequestEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMapRequestEvent.__struct(XMapRequestEvent.__member(4), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(4), XMapRequestEvent.__member(POINTER_SIZE), XMapRequestEvent.__member(CLONG_SIZE), XMapRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        PARENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XMapRequestEvent, Buffer>
    implements NativeResource {
        private static final XMapRequestEvent ELEMENT_FACTORY = XMapRequestEvent.create(-1L);

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
        protected XMapRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long parent() {
            return XMapRequestEvent.nparent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapRequestEvent.nwindow(this.address());
        }

        public Buffer type(int n) {
            XMapRequestEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XMapRequestEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XMapRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XMapRequestEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer parent(@NativeType(value="Window") long l) {
            XMapRequestEvent.nparent(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XMapRequestEvent.nwindow(this.address(), l);
            return this;
        }
    }
}

