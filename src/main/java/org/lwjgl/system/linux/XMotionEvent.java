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

public class XMotionEvent
extends Struct<XMotionEvent>
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
    public static final int IS_HINT;
    public static final int SAME_SCREEN;

    protected XMotionEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XMotionEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XMotionEvent(l, byteBuffer);
    }

    public XMotionEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XMotionEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XMotionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XMotionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XMotionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XMotionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XMotionEvent.nwindow(this.address());
    }

    @NativeType(value="Window")
    public long root() {
        return XMotionEvent.nroot(this.address());
    }

    @NativeType(value="Window")
    public long subwindow() {
        return XMotionEvent.nsubwindow(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XMotionEvent.ntime(this.address());
    }

    public int x() {
        return XMotionEvent.nx(this.address());
    }

    public int y() {
        return XMotionEvent.ny(this.address());
    }

    public int x_root() {
        return XMotionEvent.nx_root(this.address());
    }

    public int y_root() {
        return XMotionEvent.ny_root(this.address());
    }

    @NativeType(value="unsigned int")
    public int state() {
        return XMotionEvent.nstate(this.address());
    }

    @NativeType(value="char")
    public byte is_hint() {
        return XMotionEvent.nis_hint(this.address());
    }

    @NativeType(value="Bool")
    public boolean same_screen() {
        return XMotionEvent.nsame_screen(this.address()) != 0;
    }

    public XMotionEvent type(int n) {
        XMotionEvent.ntype(this.address(), n);
        return this;
    }

    public XMotionEvent serial(@NativeType(value="unsigned long") long l) {
        XMotionEvent.nserial(this.address(), l);
        return this;
    }

    public XMotionEvent send_event(@NativeType(value="Bool") boolean bl) {
        XMotionEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XMotionEvent display(@NativeType(value="Display *") long l) {
        XMotionEvent.ndisplay(this.address(), l);
        return this;
    }

    public XMotionEvent window(@NativeType(value="Window") long l) {
        XMotionEvent.nwindow(this.address(), l);
        return this;
    }

    public XMotionEvent root(@NativeType(value="Window") long l) {
        XMotionEvent.nroot(this.address(), l);
        return this;
    }

    public XMotionEvent subwindow(@NativeType(value="Window") long l) {
        XMotionEvent.nsubwindow(this.address(), l);
        return this;
    }

    public XMotionEvent time(@NativeType(value="Time") long l) {
        XMotionEvent.ntime(this.address(), l);
        return this;
    }

    public XMotionEvent x(int n) {
        XMotionEvent.nx(this.address(), n);
        return this;
    }

    public XMotionEvent y(int n) {
        XMotionEvent.ny(this.address(), n);
        return this;
    }

    public XMotionEvent x_root(int n) {
        XMotionEvent.nx_root(this.address(), n);
        return this;
    }

    public XMotionEvent y_root(int n) {
        XMotionEvent.ny_root(this.address(), n);
        return this;
    }

    public XMotionEvent state(@NativeType(value="unsigned int") int n) {
        XMotionEvent.nstate(this.address(), n);
        return this;
    }

    public XMotionEvent is_hint(@NativeType(value="char") byte by) {
        XMotionEvent.nis_hint(this.address(), by);
        return this;
    }

    public XMotionEvent same_screen(@NativeType(value="Bool") boolean bl) {
        XMotionEvent.nsame_screen(this.address(), bl ? 1 : 0);
        return this;
    }

    public XMotionEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, long l6, int n2, int n3, int n4, int n5, int n6, byte by, boolean bl2) {
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
        this.is_hint(by);
        this.same_screen(bl2);
        return this;
    }

    public XMotionEvent set(XMotionEvent xMotionEvent) {
        MemoryUtil.memCopy(xMotionEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XMotionEvent malloc() {
        return new XMotionEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XMotionEvent calloc() {
        return new XMotionEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XMotionEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XMotionEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XMotionEvent create(long l) {
        return new XMotionEvent(l, null);
    }

    public static @Nullable XMotionEvent createSafe(long l) {
        return l == 0L ? null : new XMotionEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XMotionEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XMotionEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XMotionEvent mallocStack() {
        return XMotionEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent callocStack() {
        return XMotionEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XMotionEvent mallocStack(MemoryStack memoryStack) {
        return XMotionEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XMotionEvent callocStack(MemoryStack memoryStack) {
        return XMotionEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XMotionEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XMotionEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XMotionEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XMotionEvent.calloc(n, memoryStack);
    }

    public static XMotionEvent malloc(MemoryStack memoryStack) {
        return new XMotionEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XMotionEvent calloc(MemoryStack memoryStack) {
        return new XMotionEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static byte nis_hint(long l) {
        return MemoryUtil.memGetByte(l + (long)IS_HINT);
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

    public static void nis_hint(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)IS_HINT, by);
    }

    public static void nsame_screen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SAME_SCREEN, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XMotionEvent.__struct(XMotionEvent.__member(4), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(POINTER_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(CLONG_SIZE), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(4), XMotionEvent.__member(1), XMotionEvent.__member(4));
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
        IS_HINT = layout.offsetof(13);
        SAME_SCREEN = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<XMotionEvent, Buffer>
    implements NativeResource {
        private static final XMotionEvent ELEMENT_FACTORY = XMotionEvent.create(-1L);

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
        protected XMotionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XMotionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XMotionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XMotionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XMotionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XMotionEvent.nwindow(this.address());
        }

        @NativeType(value="Window")
        public long root() {
            return XMotionEvent.nroot(this.address());
        }

        @NativeType(value="Window")
        public long subwindow() {
            return XMotionEvent.nsubwindow(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XMotionEvent.ntime(this.address());
        }

        public int x() {
            return XMotionEvent.nx(this.address());
        }

        public int y() {
            return XMotionEvent.ny(this.address());
        }

        public int x_root() {
            return XMotionEvent.nx_root(this.address());
        }

        public int y_root() {
            return XMotionEvent.ny_root(this.address());
        }

        @NativeType(value="unsigned int")
        public int state() {
            return XMotionEvent.nstate(this.address());
        }

        @NativeType(value="char")
        public byte is_hint() {
            return XMotionEvent.nis_hint(this.address());
        }

        @NativeType(value="Bool")
        public boolean same_screen() {
            return XMotionEvent.nsame_screen(this.address()) != 0;
        }

        public Buffer type(int n) {
            XMotionEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XMotionEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XMotionEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XMotionEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XMotionEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer root(@NativeType(value="Window") long l) {
            XMotionEvent.nroot(this.address(), l);
            return this;
        }

        public Buffer subwindow(@NativeType(value="Window") long l) {
            XMotionEvent.nsubwindow(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XMotionEvent.ntime(this.address(), l);
            return this;
        }

        public Buffer x(int n) {
            XMotionEvent.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            XMotionEvent.ny(this.address(), n);
            return this;
        }

        public Buffer x_root(int n) {
            XMotionEvent.nx_root(this.address(), n);
            return this;
        }

        public Buffer y_root(int n) {
            XMotionEvent.ny_root(this.address(), n);
            return this;
        }

        public Buffer state(@NativeType(value="unsigned int") int n) {
            XMotionEvent.nstate(this.address(), n);
            return this;
        }

        public Buffer is_hint(@NativeType(value="char") byte by) {
            XMotionEvent.nis_hint(this.address(), by);
            return this;
        }

        public Buffer same_screen(@NativeType(value="Bool") boolean bl) {
            XMotionEvent.nsame_screen(this.address(), bl ? 1 : 0);
            return this;
        }
    }
}

