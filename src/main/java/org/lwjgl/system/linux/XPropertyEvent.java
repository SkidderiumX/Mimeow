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

public class XPropertyEvent
extends Struct<XPropertyEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ATOM;
    public static final int TIME;
    public static final int STATE;

    protected XPropertyEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XPropertyEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XPropertyEvent(l, byteBuffer);
    }

    public XPropertyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XPropertyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XPropertyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XPropertyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XPropertyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XPropertyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XPropertyEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long atom() {
        return XPropertyEvent.natom(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XPropertyEvent.ntime(this.address());
    }

    public int state() {
        return XPropertyEvent.nstate(this.address());
    }

    public XPropertyEvent type(int n) {
        XPropertyEvent.ntype(this.address(), n);
        return this;
    }

    public XPropertyEvent serial(@NativeType(value="unsigned long") long l) {
        XPropertyEvent.nserial(this.address(), l);
        return this;
    }

    public XPropertyEvent send_event(@NativeType(value="Bool") boolean bl) {
        XPropertyEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XPropertyEvent display(@NativeType(value="Display *") long l) {
        XPropertyEvent.ndisplay(this.address(), l);
        return this;
    }

    public XPropertyEvent window(@NativeType(value="Window") long l) {
        XPropertyEvent.nwindow(this.address(), l);
        return this;
    }

    public XPropertyEvent atom(@NativeType(value="Atom") long l) {
        XPropertyEvent.natom(this.address(), l);
        return this;
    }

    public XPropertyEvent time(@NativeType(value="Time") long l) {
        XPropertyEvent.ntime(this.address(), l);
        return this;
    }

    public XPropertyEvent state(int n) {
        XPropertyEvent.nstate(this.address(), n);
        return this;
    }

    public XPropertyEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, int n2) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.atom(l4);
        this.time(l5);
        this.state(n2);
        return this;
    }

    public XPropertyEvent set(XPropertyEvent xPropertyEvent) {
        MemoryUtil.memCopy(xPropertyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XPropertyEvent malloc() {
        return new XPropertyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XPropertyEvent calloc() {
        return new XPropertyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XPropertyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XPropertyEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XPropertyEvent create(long l) {
        return new XPropertyEvent(l, null);
    }

    public static @Nullable XPropertyEvent createSafe(long l) {
        return l == 0L ? null : new XPropertyEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XPropertyEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XPropertyEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XPropertyEvent mallocStack() {
        return XPropertyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent callocStack() {
        return XPropertyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XPropertyEvent mallocStack(MemoryStack memoryStack) {
        return XPropertyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XPropertyEvent callocStack(MemoryStack memoryStack) {
        return XPropertyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XPropertyEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XPropertyEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XPropertyEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XPropertyEvent.calloc(n, memoryStack);
    }

    public static XPropertyEvent malloc(MemoryStack memoryStack) {
        return new XPropertyEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XPropertyEvent calloc(MemoryStack memoryStack) {
        return new XPropertyEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long natom(long l) {
        return MemoryUtil.memGetCLong(l + (long)ATOM);
    }

    public static long ntime(long l) {
        return MemoryUtil.memGetCLong(l + (long)TIME);
    }

    public static int nstate(long l) {
        return MemoryUtil.memGetInt(l + (long)STATE);
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

    public static void natom(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)ATOM, l2);
    }

    public static void ntime(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)TIME, l2);
    }

    public static void nstate(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STATE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XPropertyEvent.__struct(XPropertyEvent.__member(4), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4), XPropertyEvent.__member(POINTER_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(CLONG_SIZE), XPropertyEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ATOM = layout.offsetof(5);
        TIME = layout.offsetof(6);
        STATE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XPropertyEvent, Buffer>
    implements NativeResource {
        private static final XPropertyEvent ELEMENT_FACTORY = XPropertyEvent.create(-1L);

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
        protected XPropertyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XPropertyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XPropertyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XPropertyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XPropertyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XPropertyEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long atom() {
            return XPropertyEvent.natom(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XPropertyEvent.ntime(this.address());
        }

        public int state() {
            return XPropertyEvent.nstate(this.address());
        }

        public Buffer type(int n) {
            XPropertyEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XPropertyEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XPropertyEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XPropertyEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XPropertyEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer atom(@NativeType(value="Atom") long l) {
            XPropertyEvent.natom(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XPropertyEvent.ntime(this.address(), l);
            return this;
        }

        public Buffer state(int n) {
            XPropertyEvent.nstate(this.address(), n);
            return this;
        }
    }
}

