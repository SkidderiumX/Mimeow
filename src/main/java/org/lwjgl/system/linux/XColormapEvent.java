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

public class XColormapEvent
extends Struct<XColormapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int COLORMAP;
    public static final int NEW;
    public static final int STATE;

    protected XColormapEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XColormapEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XColormapEvent(l, byteBuffer);
    }

    public XColormapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XColormapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XColormapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XColormapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XColormapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XColormapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XColormapEvent.nwindow(this.address());
    }

    @NativeType(value="Colormap")
    public long colormap() {
        return XColormapEvent.ncolormap(this.address());
    }

    public int new$() {
        return XColormapEvent.nnew$(this.address());
    }

    public int state() {
        return XColormapEvent.nstate(this.address());
    }

    public XColormapEvent type(int n) {
        XColormapEvent.ntype(this.address(), n);
        return this;
    }

    public XColormapEvent serial(@NativeType(value="unsigned long") long l) {
        XColormapEvent.nserial(this.address(), l);
        return this;
    }

    public XColormapEvent send_event(@NativeType(value="Bool") boolean bl) {
        XColormapEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XColormapEvent display(@NativeType(value="Display *") long l) {
        XColormapEvent.ndisplay(this.address(), l);
        return this;
    }

    public XColormapEvent window(@NativeType(value="Window") long l) {
        XColormapEvent.nwindow(this.address(), l);
        return this;
    }

    public XColormapEvent colormap(@NativeType(value="Colormap") long l) {
        XColormapEvent.ncolormap(this.address(), l);
        return this;
    }

    public XColormapEvent new$(int n) {
        XColormapEvent.nnew$(this.address(), n);
        return this;
    }

    public XColormapEvent state(int n) {
        XColormapEvent.nstate(this.address(), n);
        return this;
    }

    public XColormapEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2, int n3) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.colormap(l4);
        this.new$(n2);
        this.state(n3);
        return this;
    }

    public XColormapEvent set(XColormapEvent xColormapEvent) {
        MemoryUtil.memCopy(xColormapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XColormapEvent malloc() {
        return new XColormapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XColormapEvent calloc() {
        return new XColormapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XColormapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XColormapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XColormapEvent create(long l) {
        return new XColormapEvent(l, null);
    }

    public static @Nullable XColormapEvent createSafe(long l) {
        return l == 0L ? null : new XColormapEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XColormapEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XColormapEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XColormapEvent mallocStack() {
        return XColormapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent callocStack() {
        return XColormapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XColormapEvent mallocStack(MemoryStack memoryStack) {
        return XColormapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XColormapEvent callocStack(MemoryStack memoryStack) {
        return XColormapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XColormapEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XColormapEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XColormapEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XColormapEvent.calloc(n, memoryStack);
    }

    public static XColormapEvent malloc(MemoryStack memoryStack) {
        return new XColormapEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XColormapEvent calloc(MemoryStack memoryStack) {
        return new XColormapEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long ncolormap(long l) {
        return MemoryUtil.memGetCLong(l + (long)COLORMAP);
    }

    public static int nnew$(long l) {
        return MemoryUtil.memGetInt(l + (long)NEW);
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

    public static void ncolormap(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)COLORMAP, l2);
    }

    public static void nnew$(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NEW, n);
    }

    public static void nstate(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STATE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XColormapEvent.__struct(XColormapEvent.__member(4), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(POINTER_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(CLONG_SIZE), XColormapEvent.__member(4), XColormapEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        COLORMAP = layout.offsetof(5);
        NEW = layout.offsetof(6);
        STATE = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XColormapEvent, Buffer>
    implements NativeResource {
        private static final XColormapEvent ELEMENT_FACTORY = XColormapEvent.create(-1L);

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
        protected XColormapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XColormapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XColormapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XColormapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XColormapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XColormapEvent.nwindow(this.address());
        }

        @NativeType(value="Colormap")
        public long colormap() {
            return XColormapEvent.ncolormap(this.address());
        }

        public int new$() {
            return XColormapEvent.nnew$(this.address());
        }

        public int state() {
            return XColormapEvent.nstate(this.address());
        }

        public Buffer type(int n) {
            XColormapEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XColormapEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XColormapEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XColormapEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XColormapEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer colormap(@NativeType(value="Colormap") long l) {
            XColormapEvent.ncolormap(this.address(), l);
            return this;
        }

        public Buffer new$(int n) {
            XColormapEvent.nnew$(this.address(), n);
            return this;
        }

        public Buffer state(int n) {
            XColormapEvent.nstate(this.address(), n);
            return this;
        }
    }
}

