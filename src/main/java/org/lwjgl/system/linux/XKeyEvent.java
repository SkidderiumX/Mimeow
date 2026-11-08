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

public class XKeyEvent
extends Struct<XKeyEvent>
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
    public static final int STATE;
    public static final int KEYCODE;
    public static final int SAME_SCREEN;

    protected XKeyEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XKeyEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XKeyEvent(l, byteBuffer);
    }

    public XKeyEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XKeyEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeyEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeyEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeyEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeyEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeyEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XKeyEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XKeyEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XKeyEvent.ntime(this.address());
    }

    public int x() {
        return XKeyEvent.nx(this.address());
    }

    public int y() {
        return XKeyEvent.ny(this.address());
    }

    public int x_root() {
        return XKeyEvent.nx_root(this.address());
    }

    public int y_root() {
        return XKeyEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XKeyEvent.nstate(this.address());
    }

    @NativeType(value="unsigned int")
    public int keycode() {
        return XKeyEvent.nkeycode(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XKeyEvent.nsame_screen(this.address()) != 0;
    }

    public XKeyEvent type(int n) {
        XKeyEvent.ntype(this.address(), n);
        return this;
    }

    public XKeyEvent serial(@NativeType(value="unsigned long") long l) {
        XKeyEvent.nserial(this.address(), l);
        return this;
    }

    public XKeyEvent send_event(@NativeType(value="Bool") boolean bl) {
        XKeyEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XKeyEvent display(@NativeType(value="Display *") long l) {
        XKeyEvent.ndisplay(this.address(), l);
        return this;
    }

    public XKeyEvent window(@NativeType(value="Window") long l) {
        XKeyEvent.nwindow(this.address(), l);
        return this;
    }

    public XKeyEvent root(@NativeType(value="Window") long l) {
        XKeyEvent.nroot(this.address(), l);
        return this;
    }

    public XKeyEvent subwindow(@NativeType(value="Window") long l) {
        XKeyEvent.nsubwindow(this.address(), l);
        return this;
    }

    public XKeyEvent time(@NativeType(value="Time") long l) {
        XKeyEvent.ntime(this.address(), l);
        return this;
    }

    public XKeyEvent x(int n) {
        XKeyEvent.nx(this.address(), n);
        return this;
    }

    public XKeyEvent y(int n) {
        XKeyEvent.ny(this.address(), n);
        return this;
    }

    public XKeyEvent x_root(int n) {
        XKeyEvent.nx_root(this.address(), n);
        return this;
    }

    public XKeyEvent y_root(int n) {
        XKeyEvent.ny_root(this.address(), n);
        return this;
    }

    public XKeyEvent state(@NativeType(value="unsigned int") int n) {
        XKeyEvent.nstate(this.address(), n);
        return this;
    }

    public XKeyEvent keycode(@NativeType(value="unsigned int") int n) {
        XKeyEvent.nkeycode(this.address(), n);
        return this;
    }

    public XKeyEvent same_screen(@NativeType(value="Bool") boolean bl) {
        XKeyEvent.nsame_screen(this.address(), bl ? 1 : 0);
        return this;
    }

    public XKeyEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, long l6, int n2, int n3, int n4, int n5, int n6, int n7, boolean bl2) {
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
        this.state(n6);
        this.keycode(n7);
        this.same_screen(bl2);
        return this;
    }

    public XKeyEvent set(XKeyEvent xKeyEvent) {
        MemoryUtil.memCopy(xKeyEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeyEvent malloc() {
        return new XKeyEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XKeyEvent calloc() {
        return new XKeyEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XKeyEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XKeyEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XKeyEvent create(long l) {
        return new XKeyEvent(l, null);
    }

    public static @Nullable XKeyEvent createSafe(long l) {
        return l == 0L ? null : new XKeyEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XKeyEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XKeyEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XKeyEvent mallocStack() {
        return XKeyEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent callocStack() {
        return XKeyEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeyEvent mallocStack(MemoryStack memoryStack) {
        return XKeyEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XKeyEvent callocStack(MemoryStack memoryStack) {
        return XKeyEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XKeyEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XKeyEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XKeyEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XKeyEvent.calloc(n, memoryStack);
    }

    public static XKeyEvent malloc(MemoryStack memoryStack) {
        return new XKeyEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XKeyEvent calloc(MemoryStack memoryStack) {
        return new XKeyEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nstate(long l) {
        return MemoryUtil.memGetInt(l + (long)STATE);
    }

    public static int nkeycode(long l) {
        return MemoryUtil.memGetInt(l + (long)KEYCODE);
    }

    public static int nsame_screen(long l) {
        return MemoryUtil.memGetInt(l + (long)SAME_SCREEN);
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

    public static void nstate(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STATE, n);
    }

    public static void nkeycode(long l, int n) {
        MemoryUtil.memPutInt(l + (long)KEYCODE, n);
    }

    public static void nsame_screen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SAME_SCREEN, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XKeyEvent.__struct(XKeyEvent.__member(4), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(POINTER_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(CLONG_SIZE), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4), XKeyEvent.__member(4));
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
        STATE = layout.offsetof(12);
        KEYCODE = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XKeyEvent, Buffer>
    implements NativeResource {
        private static final XKeyEvent ELEMENT_FACTORY = XKeyEvent.create(-1L);

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
        protected XKeyEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeyEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeyEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeyEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeyEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeyEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XKeyEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XKeyEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XKeyEvent.ntime(this.address());
        }

        public int x() {
            return XKeyEvent.nx(this.address());
        }

        public int y() {
            return XKeyEvent.ny(this.address());
        }

        public int x_root() {
            return XKeyEvent.nx_root(this.address());
        }

        public int y_root() {
            return XKeyEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XKeyEvent.nstate(this.address());
        }

        @NativeType(value="unsigned int")
        public int keycode() {
            return XKeyEvent.nkeycode(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XKeyEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int n) {
            XKeyEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XKeyEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XKeyEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XKeyEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XKeyEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l) {
            XKeyEvent.nroot(this.address(), l);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l) {
            XKeyEvent.nsubwindow(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XKeyEvent.ntime(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XKeyEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XKeyEvent.ny(this.address(), n);
            return this;
        }

        public Buffer x_root(int n) {
            XKeyEvent.nx_root(this.address(), n);
            return this;
        }

        public Buffer y_root(int n) {
            XKeyEvent.ny_root(this.address(), n);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n) {
            XKeyEvent.nstate(this.address(), n);
            return this;
        }

        public Buffer keycode(@NativeType(value="unsigned int") int n) {
            XKeyEvent.nkeycode(this.address(), n);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean bl) {
            XKeyEvent.nsame_screen(this.address(), bl ? 1 : 0);
            return this;
        }
    }
}

