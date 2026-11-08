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

public class XCrossingEvent
extends Struct<XCrossingEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int ROOT;
    public static final int SUBWINDOW;
    public static final int TIME;
    public static final int X;
    public static final int Y;
    public static final int X_ROOT;
    public static final int Y_ROOT;
    public static final int MODE;
    public static final int DETAIL;
    public static final int SAME_SCREEN;
    public static final int FOCUS;
    public static final int STATE;

    protected XCrossingEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XCrossingEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XCrossingEvent(l, byteBuffer);
    }

    public XCrossingEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XCrossingEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XCrossingEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XCrossingEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XCrossingEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XCrossingEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XCrossingEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XCrossingEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XCrossingEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XCrossingEvent.ntime(this.address());
    }

    public int x() {
        return XCrossingEvent.nx(this.address());
    }

    public int y() {
        return XCrossingEvent.ny(this.address());
    }

    public int x_root() {
        return XCrossingEvent.nx_root(this.address());
    }

    public int y_root() {
        return XCrossingEvent.ny_root(this.address());
    }

    public int mode() {
        return XCrossingEvent.nmode(this.address());
    }

    public int detail() {
        return XCrossingEvent.ndetail(this.address());
    }

    public int same_screen() {
        return XCrossingEvent.nsame_screen(this.address());
    }

    public int focus() {
        return XCrossingEvent.nfocus(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XCrossingEvent.nstate(this.address());
    }

    public XCrossingEvent type(int n) {
        XCrossingEvent.ntype(this.address(), n);
        return this;
    }

    public XCrossingEvent serial(@NativeType(value="unsigned long") long l) {
        XCrossingEvent.nserial(this.address(), l);
        return this;
    }

    public XCrossingEvent send_event(@NativeType(value="Bool") boolean bl) {
        XCrossingEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XCrossingEvent display(@NativeType(value="Display *") long l) {
        XCrossingEvent.ndisplay(this.address(), l);
        return this;
    }

    public XCrossingEvent window(@NativeType(value="Window") long l) {
        XCrossingEvent.nwindow(this.address(), l);
        return this;
    }

    public XCrossingEvent root(@NativeType(value="Window") long l) {
        XCrossingEvent.nroot(this.address(), l);
        return this;
    }

    public XCrossingEvent subwindow(@NativeType(value="Window") long l) {
        XCrossingEvent.nsubwindow(this.address(), l);
        return this;
    }

    public XCrossingEvent time(@NativeType(value="Time") long l) {
        XCrossingEvent.ntime(this.address(), l);
        return this;
    }

    public XCrossingEvent x(int n) {
        XCrossingEvent.nx(this.address(), n);
        return this;
    }

    public XCrossingEvent y(int n) {
        XCrossingEvent.ny(this.address(), n);
        return this;
    }

    public XCrossingEvent x_root(int n) {
        XCrossingEvent.nx_root(this.address(), n);
        return this;
    }

    public XCrossingEvent y_root(int n) {
        XCrossingEvent.ny_root(this.address(), n);
        return this;
    }

    public XCrossingEvent mode(int n) {
        XCrossingEvent.nmode(this.address(), n);
        return this;
    }

    public XCrossingEvent detail(int n) {
        XCrossingEvent.ndetail(this.address(), n);
        return this;
    }

    public XCrossingEvent same_screen(int n) {
        XCrossingEvent.nsame_screen(this.address(), n);
        return this;
    }

    public XCrossingEvent focus(int n) {
        XCrossingEvent.nfocus(this.address(), n);
        return this;
    }

    public XCrossingEvent state(@NativeType(value="unsigned int") int n) {
        XCrossingEvent.nstate(this.address(), n);
        return this;
    }

    public XCrossingEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, long l6, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.root(l4);
        this.subwindow(l5);
        this.time(l6);
        this.x(n2);
        this.y(n3);
        this.x_root(n4);
        this.y_root(n5);
        this.mode(n6);
        this.detail(n7);
        this.same_screen(n8);
        this.focus(n9);
        this.state(n10);
        return this;
    }

    public XCrossingEvent set(XCrossingEvent xCrossingEvent) {
        MemoryUtil.memCopy(xCrossingEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XCrossingEvent malloc() {
        return new XCrossingEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XCrossingEvent calloc() {
        return new XCrossingEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XCrossingEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XCrossingEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XCrossingEvent create(long l) {
        return new XCrossingEvent(l, null);
    }

    public static @Nullable XCrossingEvent createSafe(long l) {
        return l == 0L ? null : new XCrossingEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XCrossingEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XCrossingEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XCrossingEvent mallocStack() {
        return XCrossingEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent callocStack() {
        return XCrossingEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XCrossingEvent mallocStack(MemoryStack memoryStack) {
        return XCrossingEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XCrossingEvent callocStack(MemoryStack memoryStack) {
        return XCrossingEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XCrossingEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XCrossingEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XCrossingEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XCrossingEvent.calloc(n, memoryStack);
    }

    public static XCrossingEvent malloc(MemoryStack memoryStack) {
        return new XCrossingEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XCrossingEvent calloc(MemoryStack memoryStack) {
        return new XCrossingEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nroot(long l) {
        return MemoryUtil.memGetCLong(l + (long)ROOT);
    }

    public static long nsubwindow(long l) {
        return MemoryUtil.memGetCLong(l + (long)SUBWINDOW);
    }

    public static long ntime(long l) {
        return MemoryUtil.memGetCLong(l + (long)TIME);
    }

    public static int nx(long l) {
        return MemoryUtil.memGetInt(l + (long)X);
    }

    public static int ny(long l) {
        return MemoryUtil.memGetInt(l + (long)Y);
    }

    public static int nx_root(long l) {
        return MemoryUtil.memGetInt(l + (long)X_ROOT);
    }

    public static int ny_root(long l) {
        return MemoryUtil.memGetInt(l + (long)Y_ROOT);
    }

    public static int nmode(long l) {
        return MemoryUtil.memGetInt(l + (long)MODE);
    }

    public static int ndetail(long l) {
        return MemoryUtil.memGetInt(l + (long)DETAIL);
    }

    public static int nsame_screen(long l) {
        return MemoryUtil.memGetInt(l + (long)SAME_SCREEN);
    }

    public static int nfocus(long l) {
        return MemoryUtil.memGetInt(l + (long)FOCUS);
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

    public static void nroot(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)ROOT, l2);
    }

    public static void nsubwindow(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)SUBWINDOW, l2);
    }

    public static void ntime(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)TIME, l2);
    }

    public static void nx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X, n);
    }

    public static void ny(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y, n);
    }

    public static void nx_root(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X_ROOT, n);
    }

    public static void ny_root(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y_ROOT, n);
    }

    public static void nmode(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MODE, n);
    }

    public static void ndetail(long l, int n) {
        MemoryUtil.memPutInt(l + (long)DETAIL, n);
    }

    public static void nsame_screen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SAME_SCREEN, n);
    }

    public static void nfocus(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FOCUS, n);
    }

    public static void nstate(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STATE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XCrossingEvent.__struct(XCrossingEvent.__member(4), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(POINTER_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(CLONG_SIZE), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4), XCrossingEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        ROOT = layout.offsetof(5);
        SUBWINDOW = layout.offsetof(6);
        TIME = layout.offsetof(7);
        X = layout.offsetof(8);
        Y = layout.offsetof(9);
        X_ROOT = layout.offsetof(10);
        Y_ROOT = layout.offsetof(11);
        MODE = layout.offsetof(12);
        DETAIL = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
        FOCUS = layout.offsetof(15);
        STATE = layout.offsetof(16);
    }

    public static class Buffer
    extends StructBuffer<XCrossingEvent, Buffer>
    implements NativeResource {
        private static final XCrossingEvent ELEMENT_FACTORY = XCrossingEvent.create(-1L);

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
        protected XCrossingEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XCrossingEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XCrossingEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XCrossingEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XCrossingEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XCrossingEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XCrossingEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XCrossingEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XCrossingEvent.ntime(this.address());
        }

        public int x() {
            return XCrossingEvent.nx(this.address());
        }

        public int y() {
            return XCrossingEvent.ny(this.address());
        }

        public int x_root() {
            return XCrossingEvent.nx_root(this.address());
        }

        public int y_root() {
            return XCrossingEvent.ny_root(this.address());
        }

        public int mode() {
            return XCrossingEvent.nmode(this.address());
        }

        public int detail() {
            return XCrossingEvent.ndetail(this.address());
        }

        public int same_screen() {
            return XCrossingEvent.nsame_screen(this.address());
        }

        public int focus() {
            return XCrossingEvent.nfocus(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XCrossingEvent.nstate(this.address());
        }

        public Buffer type(int n) {
            XCrossingEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XCrossingEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XCrossingEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XCrossingEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XCrossingEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l) {
            XCrossingEvent.nroot(this.address(), l);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l) {
            XCrossingEvent.nsubwindow(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XCrossingEvent.ntime(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XCrossingEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XCrossingEvent.ny(this.address(), n);
            return this;
        }

        public Buffer x_root(int n) {
            XCrossingEvent.nx_root(this.address(), n);
            return this;
        }

        public Buffer y_root(int n) {
            XCrossingEvent.ny_root(this.address(), n);
            return this;
        }

        public Buffer mode(int n) {
            XCrossingEvent.nmode(this.address(), n);
            return this;
        }

        public Buffer detail(int n) {
            XCrossingEvent.ndetail(this.address(), n);
            return this;
        }

        public Buffer same_screen(int n) {
            XCrossingEvent.nsame_screen(this.address(), n);
            return this;
        }

        public Buffer focus(int n) {
            XCrossingEvent.nfocus(this.address(), n);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n) {
            XCrossingEvent.nstate(this.address(), n);
            return this;
        }
    }
}

