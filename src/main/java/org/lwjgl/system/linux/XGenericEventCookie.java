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

public class XGenericEventCookie
extends Struct<XGenericEventCookie>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;
    public static final int COOKIE;
    public static final int DATA;

    protected XGenericEventCookie(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XGenericEventCookie create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XGenericEventCookie(l, byteBuffer);
    }

    public XGenericEventCookie(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGenericEventCookie.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEventCookie.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEventCookie.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEventCookie.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEventCookie.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEventCookie.nextension(this.address());
    }

    public int evtype() {
        return XGenericEventCookie.nevtype(this.address());
    }

    @NativeType(value="unsigned int")
    public int cookie() {
        return XGenericEventCookie.ncookie(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer data(int n) {
        return XGenericEventCookie.ndata(this.address(), n);
    }

    public XGenericEventCookie type(int n) {
        XGenericEventCookie.ntype(this.address(), n);
        return this;
    }

    public XGenericEventCookie serial(@NativeType(value="unsigned long") long l) {
        XGenericEventCookie.nserial(this.address(), l);
        return this;
    }

    public XGenericEventCookie send_event(@NativeType(value="Bool") boolean bl) {
        XGenericEventCookie.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XGenericEventCookie display(@NativeType(value="Display *") long l) {
        XGenericEventCookie.ndisplay(this.address(), l);
        return this;
    }

    public XGenericEventCookie extension(int n) {
        XGenericEventCookie.nextension(this.address(), n);
        return this;
    }

    public XGenericEventCookie evtype(int n) {
        XGenericEventCookie.nevtype(this.address(), n);
        return this;
    }

    public XGenericEventCookie cookie(@NativeType(value="unsigned int") int n) {
        XGenericEventCookie.ncookie(this.address(), n);
        return this;
    }

    public XGenericEventCookie data(@NativeType(value="void *") ByteBuffer byteBuffer) {
        XGenericEventCookie.ndata(this.address(), byteBuffer);
        return this;
    }

    public XGenericEventCookie set(int n, long l, boolean bl, long l2, int n2, int n3, int n4, ByteBuffer byteBuffer) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.extension(n2);
        this.evtype(n3);
        this.cookie(n4);
        this.data(byteBuffer);
        return this;
    }

    public XGenericEventCookie set(XGenericEventCookie xGenericEventCookie) {
        MemoryUtil.memCopy(xGenericEventCookie.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEventCookie malloc() {
        return new XGenericEventCookie(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XGenericEventCookie calloc() {
        return new XGenericEventCookie(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XGenericEventCookie create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XGenericEventCookie(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGenericEventCookie create(long l) {
        return new XGenericEventCookie(l, null);
    }

    public static @Nullable XGenericEventCookie createSafe(long l) {
        return l == 0L ? null : new XGenericEventCookie(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XGenericEventCookie.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XGenericEventCookie.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XGenericEventCookie mallocStack() {
        return XGenericEventCookie.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEventCookie callocStack() {
        return XGenericEventCookie.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEventCookie mallocStack(MemoryStack memoryStack) {
        return XGenericEventCookie.malloc(memoryStack);
    }

    @Deprecated
    public static XGenericEventCookie callocStack(MemoryStack memoryStack) {
        return XGenericEventCookie.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XGenericEventCookie.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XGenericEventCookie.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XGenericEventCookie.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XGenericEventCookie.calloc(n, memoryStack);
    }

    public static XGenericEventCookie malloc(MemoryStack memoryStack) {
        return new XGenericEventCookie(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XGenericEventCookie calloc(MemoryStack memoryStack) {
        return new XGenericEventCookie(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int nextension(long l) {
        return MemoryUtil.memGetInt(l + (long)EXTENSION);
    }

    public static int nevtype(long l) {
        return MemoryUtil.memGetInt(l + (long)EVTYPE);
    }

    public static int ncookie(long l) {
        return MemoryUtil.memGetInt(l + (long)COOKIE);
    }

    public static ByteBuffer ndata(long l, int n) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)DATA), n);
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

    public static void nextension(long l, int n) {
        MemoryUtil.memPutInt(l + (long)EXTENSION, n);
    }

    public static void nevtype(long l, int n) {
        MemoryUtil.memPutInt(l + (long)EVTYPE, n);
    }

    public static void ncookie(long l, int n) {
        MemoryUtil.memPutInt(l + (long)COOKIE, n);
    }

    public static void ndata(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)DATA, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
        Checks.check(MemoryUtil.memGetAddress(l + (long)DATA));
    }

    static {
        Struct.Layout layout = XGenericEventCookie.__struct(XGenericEventCookie.__member(4), XGenericEventCookie.__member(CLONG_SIZE), XGenericEventCookie.__member(4), XGenericEventCookie.__member(POINTER_SIZE), XGenericEventCookie.__member(4), XGenericEventCookie.__member(4), XGenericEventCookie.__member(4), XGenericEventCookie.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
        COOKIE = layout.offsetof(6);
        DATA = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<XGenericEventCookie, Buffer>
    implements NativeResource {
        private static final XGenericEventCookie ELEMENT_FACTORY = XGenericEventCookie.create(-1L);

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
        protected XGenericEventCookie getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEventCookie.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEventCookie.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEventCookie.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEventCookie.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEventCookie.nextension(this.address());
        }

        public int evtype() {
            return XGenericEventCookie.nevtype(this.address());
        }

        @NativeType(value="unsigned int")
        public int cookie() {
            return XGenericEventCookie.ncookie(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer data(int n) {
            return XGenericEventCookie.ndata(this.address(), n);
        }

        public Buffer type(int n) {
            XGenericEventCookie.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XGenericEventCookie.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XGenericEventCookie.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XGenericEventCookie.ndisplay(this.address(), l);
            return this;
        }

        public Buffer extension(int n) {
            XGenericEventCookie.nextension(this.address(), n);
            return this;
        }

        public Buffer evtype(int n) {
            XGenericEventCookie.nevtype(this.address(), n);
            return this;
        }

        public Buffer cookie(@NativeType(value="unsigned int") int n) {
            XGenericEventCookie.ncookie(this.address(), n);
            return this;
        }

        public Buffer data(@NativeType(value="void *") ByteBuffer byteBuffer) {
            XGenericEventCookie.ndata(this.address(), byteBuffer);
            return this;
        }
    }
}

