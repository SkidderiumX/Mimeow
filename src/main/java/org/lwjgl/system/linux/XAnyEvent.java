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

public class XAnyEvent
extends Struct<XAnyEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;

    protected XAnyEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XAnyEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XAnyEvent(l, byteBuffer);
    }

    public XAnyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XAnyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XAnyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XAnyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XAnyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XAnyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XAnyEvent.nwindow(this.address());
    }

    public XAnyEvent type(int n) {
        XAnyEvent.ntype(this.address(), n);
        return this;
    }

    public XAnyEvent serial(@NativeType(value="unsigned long") long l) {
        XAnyEvent.nserial(this.address(), l);
        return this;
    }

    public XAnyEvent send_event(@NativeType(value="Bool") boolean bl) {
        XAnyEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XAnyEvent display(@NativeType(value="Display *") long l) {
        XAnyEvent.ndisplay(this.address(), l);
        return this;
    }

    public XAnyEvent window(@NativeType(value="Window") long l) {
        XAnyEvent.nwindow(this.address(), l);
        return this;
    }

    public XAnyEvent set(int n, long l, boolean bl, long l2, long l3) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        return this;
    }

    public XAnyEvent set(XAnyEvent xAnyEvent) {
        MemoryUtil.memCopy(xAnyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XAnyEvent malloc() {
        return new XAnyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XAnyEvent calloc() {
        return new XAnyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XAnyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XAnyEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XAnyEvent create(long l) {
        return new XAnyEvent(l, null);
    }

    public static @Nullable XAnyEvent createSafe(long l) {
        return l == 0L ? null : new XAnyEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XAnyEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XAnyEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XAnyEvent mallocStack() {
        return XAnyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XAnyEvent callocStack() {
        return XAnyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XAnyEvent mallocStack(MemoryStack memoryStack) {
        return XAnyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XAnyEvent callocStack(MemoryStack memoryStack) {
        return XAnyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XAnyEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XAnyEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XAnyEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XAnyEvent.calloc(n, memoryStack);
    }

    public static XAnyEvent malloc(MemoryStack memoryStack) {
        return new XAnyEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XAnyEvent calloc(MemoryStack memoryStack) {
        return new XAnyEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XAnyEvent.__struct(XAnyEvent.__member(4), XAnyEvent.__member(CLONG_SIZE), XAnyEvent.__member(4), XAnyEvent.__member(POINTER_SIZE), XAnyEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<XAnyEvent, Buffer>
    implements NativeResource {
        private static final XAnyEvent ELEMENT_FACTORY = XAnyEvent.create(-1L);

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
        protected XAnyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XAnyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XAnyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XAnyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XAnyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XAnyEvent.nwindow(this.address());
        }

        public Buffer type(int n) {
            XAnyEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XAnyEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XAnyEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XAnyEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XAnyEvent.nwindow(this.address(), l);
            return this;
        }
    }
}

