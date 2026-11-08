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

public class XCirculateEvent
extends Struct<XCirculateEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int PLACE;

    protected XCirculateEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XCirculateEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XCirculateEvent(l, byteBuffer);
    }

    public XCirculateEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCirculateEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCirculateEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCirculateEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCirculateEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCirculateEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XCirculateEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCirculateEvent.nwindow(this.address());
    }

    public int place() {
        return XCirculateEvent.nplace(this.address());
    }

    public XCirculateEvent type(int n) {
        XCirculateEvent.ntype(this.address(), n);
        return this;
    }

    public XCirculateEvent serial(@NativeType(value="unsigned long") long l) {
        XCirculateEvent.nserial(this.address(), l);
        return this;
    }

    public XCirculateEvent send_event(@NativeType(value="Bool") boolean bl) {
        XCirculateEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XCirculateEvent display(@NativeType(value="Display *") long l) {
        XCirculateEvent.ndisplay(this.address(), l);
        return this;
    }

    public XCirculateEvent event(@NativeType(value="Window") long l) {
        XCirculateEvent.nevent(this.address(), l);
        return this;
    }

    public XCirculateEvent window(@NativeType(value="Window") long l) {
        XCirculateEvent.nwindow(this.address(), l);
        return this;
    }

    public XCirculateEvent place(int n) {
        XCirculateEvent.nplace(this.address(), n);
        return this;
    }

    public XCirculateEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.event(l3);
        this.window(l4);
        this.place(n2);
        return this;
    }

    public XCirculateEvent set(XCirculateEvent xCirculateEvent) {
        MemoryUtil.memCopy(xCirculateEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCirculateEvent malloc() {
        return new XCirculateEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XCirculateEvent calloc() {
        return new XCirculateEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XCirculateEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XCirculateEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCirculateEvent create(long l) {
        return new XCirculateEvent(l, null);
    }

    public static @Nullable XCirculateEvent createSafe(long l) {
        return l == 0L ? null : new XCirculateEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XCirculateEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XCirculateEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XCirculateEvent mallocStack() {
        return XCirculateEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCirculateEvent callocStack() {
        return XCirculateEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCirculateEvent mallocStack(MemoryStack memoryStack) {
        return XCirculateEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCirculateEvent callocStack(MemoryStack memoryStack) {
        return XCirculateEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XCirculateEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XCirculateEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XCirculateEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XCirculateEvent.calloc(n, memoryStack);
    }

    public static XCirculateEvent malloc(MemoryStack memoryStack) {
        return new XCirculateEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XCirculateEvent calloc(MemoryStack memoryStack) {
        return new XCirculateEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nevent(long l) {
        return MemoryUtil.memGetCLong(l + (long)EVENT);
    }

    public static long nwindow(long l) {
        return MemoryUtil.memGetCLong(l + (long)WINDOW);
    }

    public static int nplace(long l) {
        return MemoryUtil.memGetInt(l + (long)PLACE);
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

    public static void nevent(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)EVENT, l2);
    }

    public static void nwindow(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)WINDOW, l2);
    }

    public static void nplace(long l, int n) {
        MemoryUtil.memPutInt(l + (long)PLACE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCirculateEvent.__struct(XCirculateEvent.__member(4), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4), XCirculateEvent.__member(POINTER_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(CLONG_SIZE), XCirculateEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        PLACE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XCirculateEvent, Buffer>
    implements NativeResource {
        private static final XCirculateEvent ELEMENT_FACTORY = XCirculateEvent.create(-1L);

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
        protected XCirculateEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCirculateEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCirculateEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCirculateEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCirculateEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XCirculateEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCirculateEvent.nwindow(this.address());
        }

        public int place() {
            return XCirculateEvent.nplace(this.address());
        }

        public Buffer type(int n) {
            XCirculateEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XCirculateEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XCirculateEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XCirculateEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long l) {
            XCirculateEvent.nevent(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XCirculateEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer place(int n) {
            XCirculateEvent.nplace(this.address(), n);
            return this;
        }
    }
}

