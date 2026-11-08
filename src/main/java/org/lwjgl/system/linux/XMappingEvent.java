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

public class XMappingEvent
extends Struct<XMappingEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int REQUEST;
    public static final int FIRST_KEYCODE;
    public static final int COUNT;

    protected XMappingEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XMappingEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XMappingEvent(l, byteBuffer);
    }

    public XMappingEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMappingEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMappingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMappingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMappingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMappingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMappingEvent.nwindow(this.address());
    }

    public int request() {
        return XMappingEvent.nrequest(this.address());
    }

    public int first_keycode() {
        return XMappingEvent.nfirst_keycode(this.address());
    }

    public int count() {
        return XMappingEvent.ncount(this.address());
    }

    public XMappingEvent type(int n) {
        XMappingEvent.ntype(this.address(), n);
        return this;
    }

    public XMappingEvent serial(@NativeType(value="unsigned long") long l) {
        XMappingEvent.nserial(this.address(), l);
        return this;
    }

    public XMappingEvent send_event(@NativeType(value="Bool") boolean bl) {
        XMappingEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XMappingEvent display(@NativeType(value="Display *") long l) {
        XMappingEvent.ndisplay(this.address(), l);
        return this;
    }

    public XMappingEvent window(@NativeType(value="Window") long l) {
        XMappingEvent.nwindow(this.address(), l);
        return this;
    }

    public XMappingEvent request(int n) {
        XMappingEvent.nrequest(this.address(), n);
        return this;
    }

    public XMappingEvent first_keycode(int n) {
        XMappingEvent.nfirst_keycode(this.address(), n);
        return this;
    }

    public XMappingEvent count(int n) {
        XMappingEvent.ncount(this.address(), n);
        return this;
    }

    public XMappingEvent set(int n, long l, boolean bl, long l2, long l3, int n2, int n3, int n4) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.request(n2);
        this.first_keycode(n3);
        this.count(n4);
        return this;
    }

    public XMappingEvent set(XMappingEvent xMappingEvent) {
        MemoryUtil.memCopy(xMappingEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMappingEvent malloc() {
        return new XMappingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMappingEvent calloc() {
        return new XMappingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMappingEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XMappingEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMappingEvent create(long l) {
        return new XMappingEvent(l, null);
    }

    public static @Nullable XMappingEvent createSafe(long l) {
        return l == 0L ? null : new XMappingEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMappingEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XMappingEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XMappingEvent mallocStack() {
        return XMappingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent callocStack() {
        return XMappingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMappingEvent mallocStack(MemoryStack memoryStack) {
        return XMappingEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMappingEvent callocStack(MemoryStack memoryStack) {
        return XMappingEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XMappingEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XMappingEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XMappingEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XMappingEvent.calloc(n, memoryStack);
    }

    public static XMappingEvent malloc(MemoryStack memoryStack) {
        return new XMappingEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMappingEvent calloc(MemoryStack memoryStack) {
        return new XMappingEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nrequest(long l) {
        return MemoryUtil.memGetInt(l + (long)REQUEST);
    }

    public static int nfirst_keycode(long l) {
        return MemoryUtil.memGetInt(l + (long)FIRST_KEYCODE);
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

    public static void nrequest(long l, int n) {
        MemoryUtil.memPutInt(l + (long)REQUEST, n);
    }

    public static void nfirst_keycode(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FIRST_KEYCODE, n);
    }

    public static void ncount(long l, int n) {
        MemoryUtil.memPutInt(l + (long)COUNT, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMappingEvent.__struct(XMappingEvent.__member(4), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(POINTER_SIZE), XMappingEvent.__member(CLONG_SIZE), XMappingEvent.__member(4), XMappingEvent.__member(4), XMappingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        REQUEST = layout.offsetof(5);
        FIRST_KEYCODE = layout.offsetof(6);
        COUNT = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XMappingEvent, Buffer>
    implements NativeResource {
        private static final XMappingEvent ELEMENT_FACTORY = XMappingEvent.create(-1L);

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
        protected XMappingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMappingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMappingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMappingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMappingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMappingEvent.nwindow(this.address());
        }

        public int request() {
            return XMappingEvent.nrequest(this.address());
        }

        public int first_keycode() {
            return XMappingEvent.nfirst_keycode(this.address());
        }

        public int count() {
            return XMappingEvent.ncount(this.address());
        }

        public Buffer type(int n) {
            XMappingEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XMappingEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XMappingEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XMappingEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XMappingEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer request(int n) {
            XMappingEvent.nrequest(this.address(), n);
            return this;
        }

        public Buffer first_keycode(int n) {
            XMappingEvent.nfirst_keycode(this.address(), n);
            return this;
        }

        public Buffer count(int n) {
            XMappingEvent.ncount(this.address(), n);
            return this;
        }
    }
}

