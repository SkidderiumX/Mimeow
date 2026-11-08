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

public class XKeymapEvent
extends Struct<XKeymapEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int KEY_VECTOR;

    protected XKeymapEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XKeymapEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XKeymapEvent(l, byteBuffer);
    }

    public XKeymapEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XKeymapEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XKeymapEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XKeymapEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XKeymapEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XKeymapEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XKeymapEvent.nwindow(this.address());
    }

    @NativeType(value="char[32]")
    public ByteBuffer key_vector() {
        return XKeymapEvent.nkey_vector(this.address());
    }

    @NativeType(value="char")
    public byte key_vector(int n) {
        return XKeymapEvent.nkey_vector(this.address(), n);
    }

    public XKeymapEvent type(int n) {
        XKeymapEvent.ntype(this.address(), n);
        return this;
    }

    public XKeymapEvent serial(@NativeType(value="unsigned long") long l) {
        XKeymapEvent.nserial(this.address(), l);
        return this;
    }

    public XKeymapEvent send_event(@NativeType(value="Bool") boolean bl) {
        XKeymapEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XKeymapEvent display(@NativeType(value="Display *") long l) {
        XKeymapEvent.ndisplay(this.address(), l);
        return this;
    }

    public XKeymapEvent window(@NativeType(value="Window") long l) {
        XKeymapEvent.nwindow(this.address(), l);
        return this;
    }

    public XKeymapEvent key_vector(@NativeType(value="char[32]") ByteBuffer byteBuffer) {
        XKeymapEvent.nkey_vector(this.address(), byteBuffer);
        return this;
    }

    public XKeymapEvent key_vector(int n, @NativeType(value="char") byte by) {
        XKeymapEvent.nkey_vector(this.address(), n, by);
        return this;
    }

    public XKeymapEvent set(int n, long l, boolean bl, long l2, long l3, ByteBuffer byteBuffer) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.key_vector(byteBuffer);
        return this;
    }

    public XKeymapEvent set(XKeymapEvent xKeymapEvent) {
        MemoryUtil.memCopy(xKeymapEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XKeymapEvent malloc() {
        return new XKeymapEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XKeymapEvent calloc() {
        return new XKeymapEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XKeymapEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XKeymapEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XKeymapEvent create(long l) {
        return new XKeymapEvent(l, null);
    }

    public static @Nullable XKeymapEvent createSafe(long l) {
        return l == 0L ? null : new XKeymapEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XKeymapEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XKeymapEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XKeymapEvent mallocStack() {
        return XKeymapEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent callocStack() {
        return XKeymapEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XKeymapEvent mallocStack(MemoryStack memoryStack) {
        return XKeymapEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XKeymapEvent callocStack(MemoryStack memoryStack) {
        return XKeymapEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XKeymapEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XKeymapEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XKeymapEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XKeymapEvent.calloc(n, memoryStack);
    }

    public static XKeymapEvent malloc(MemoryStack memoryStack) {
        return new XKeymapEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XKeymapEvent calloc(MemoryStack memoryStack) {
        return new XKeymapEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static ByteBuffer nkey_vector(long l) {
        return MemoryUtil.memByteBuffer(l + (long)KEY_VECTOR, 32);
    }

    public static byte nkey_vector(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)KEY_VECTOR + Checks.check(n, 32) * 1L);
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

    public static void nkey_vector(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 32);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)KEY_VECTOR, byteBuffer.remaining() * 1);
    }

    public static void nkey_vector(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)KEY_VECTOR + Checks.check(n, 32) * 1L, by);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XKeymapEvent.__struct(XKeymapEvent.__member(4), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__member(4), XKeymapEvent.__member(POINTER_SIZE), XKeymapEvent.__member(CLONG_SIZE), XKeymapEvent.__array(1, 32));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        KEY_VECTOR = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XKeymapEvent, Buffer>
    implements NativeResource {
        private static final XKeymapEvent ELEMENT_FACTORY = XKeymapEvent.create(-1L);

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
        protected XKeymapEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XKeymapEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XKeymapEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XKeymapEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XKeymapEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XKeymapEvent.nwindow(this.address());
        }

        @NativeType(value="char[32]")
        public ByteBuffer key_vector() {
            return XKeymapEvent.nkey_vector(this.address());
        }

        @NativeType(value="char")
        public byte key_vector(int n) {
            return XKeymapEvent.nkey_vector(this.address(), n);
        }

        public Buffer type(int n) {
            XKeymapEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XKeymapEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XKeymapEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XKeymapEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XKeymapEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer key_vector(@NativeType(value="char[32]") ByteBuffer byteBuffer) {
            XKeymapEvent.nkey_vector(this.address(), byteBuffer);
            return this;
        }

        public Buffer key_vector(int n, @NativeType(value="char") byte by) {
            XKeymapEvent.nkey_vector(this.address(), n, by);
            return this;
        }
    }
}

