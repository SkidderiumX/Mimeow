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

public class XMapEvent
extends Struct<XMapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EVENT;
    public static final int WINDOW;
    public static final int OVERRIDE_REDIRECT;

    protected XMapEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XMapEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XMapEvent(l, byteBuffer);
    }

    public XMapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long event() {
        return XMapEvent.nevent(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMapEvent.nwindow(this.address());
    }

    public int override_redirect() {
        return XMapEvent.noverride_redirect(this.address());
    }

    public XMapEvent type(int n) {
        XMapEvent.ntype(this.address(), n);
        return this;
    }

    public XMapEvent serial(@NativeType(value="unsigned long") long l) {
        XMapEvent.nserial(this.address(), l);
        return this;
    }

    public XMapEvent send_event(@NativeType(value="Bool") boolean bl) {
        XMapEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XMapEvent display(@NativeType(value="Display *") long l) {
        XMapEvent.ndisplay(this.address(), l);
        return this;
    }

    public XMapEvent event(@NativeType(value="Window") long l) {
        XMapEvent.nevent(this.address(), l);
        return this;
    }

    public XMapEvent window(@NativeType(value="Window") long l) {
        XMapEvent.nwindow(this.address(), l);
        return this;
    }

    public XMapEvent override_redirect(int n) {
        XMapEvent.noverride_redirect(this.address(), n);
        return this;
    }

    public XMapEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.event(l3);
        this.window(l4);
        this.override_redirect(n2);
        return this;
    }

    public XMapEvent set(XMapEvent xMapEvent) {
        MemoryUtil.memCopy(xMapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMapEvent malloc() {
        return new XMapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMapEvent calloc() {
        return new XMapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XMapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMapEvent create(long l) {
        return new XMapEvent(l, null);
    }

    public static @Nullable XMapEvent createSafe(long l) {
        return l == 0L ? null : new XMapEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMapEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XMapEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XMapEvent mallocStack() {
        return XMapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent callocStack() {
        return XMapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMapEvent mallocStack(MemoryStack memoryStack) {
        return XMapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMapEvent callocStack(MemoryStack memoryStack) {
        return XMapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XMapEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XMapEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XMapEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XMapEvent.calloc(n, memoryStack);
    }

    public static XMapEvent malloc(MemoryStack memoryStack) {
        return new XMapEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMapEvent calloc(MemoryStack memoryStack) {
        return new XMapEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void nevent(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)EVENT, l2);
    }

    public static void nwindow(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)WINDOW, l2);
    }

    public static void noverride_redirect(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OVERRIDE_REDIRECT, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMapEvent.__struct(XMapEvent.__member(4), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4), XMapEvent.__member(POINTER_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(CLONG_SIZE), XMapEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EVENT = layout.offsetof(4);
        WINDOW = layout.offsetof(5);
        OVERRIDE_REDIRECT = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<XMapEvent, Buffer>
    implements NativeResource {
        private static final XMapEvent ELEMENT_FACTORY = XMapEvent.create(-1L);

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
        protected XMapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long event() {
            return XMapEvent.nevent(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMapEvent.nwindow(this.address());
        }

        public int override_redirect() {
            return XMapEvent.noverride_redirect(this.address());
        }

        public Buffer type(int n) {
            XMapEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XMapEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XMapEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XMapEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer event(@NativeType(value="Window") long l) {
            XMapEvent.nevent(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XMapEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer override_redirect(int n) {
            XMapEvent.noverride_redirect(this.address(), n);
            return this;
        }
    }
}

