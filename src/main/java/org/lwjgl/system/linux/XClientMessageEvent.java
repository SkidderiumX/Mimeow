/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.CLongBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XClientMessageEvent
extends Struct<XClientMessageEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int WINDOW;
    public static final int MESSAGE_TYPE;
    public static final int FORMAT;
    public static final int DATA;
    public static final int DATA_B;
    public static final int DATA_S;
    public static final int DATA_L;

    protected XClientMessageEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XClientMessageEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XClientMessageEvent(l, byteBuffer);
    }

    public XClientMessageEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XClientMessageEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XClientMessageEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XClientMessageEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XClientMessageEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XClientMessageEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long window() {
        return XClientMessageEvent.nwindow(this.address());
    }

    @NativeType(value="Atom")
    public long message_type() {
        return XClientMessageEvent.nmessage_type(this.address());
    }

    public int format() {
        return XClientMessageEvent.nformat(this.address());
    }

    @NativeType(value="char[20]")
    public ByteBuffer data_b() {
        return XClientMessageEvent.ndata_b(this.address());
    }

    @NativeType(value="char")
    public byte data_b(int n) {
        return XClientMessageEvent.ndata_b(this.address(), n);
    }

    @NativeType(value="short[10]")
    public ShortBuffer data_s() {
        return XClientMessageEvent.ndata_s(this.address());
    }

    public short data_s(int n) {
        return XClientMessageEvent.ndata_s(this.address(), n);
    }

    @NativeType(value="long[5]")
    public CLongBuffer data_l() {
        return XClientMessageEvent.ndata_l(this.address());
    }

    public long data_l(int n) {
        return XClientMessageEvent.ndata_l(this.address(), n);
    }

    public XClientMessageEvent type(int n) {
        XClientMessageEvent.ntype(this.address(), n);
        return this;
    }

    public XClientMessageEvent serial(@NativeType(value="unsigned long") long l) {
        XClientMessageEvent.nserial(this.address(), l);
        return this;
    }

    public XClientMessageEvent send_event(@NativeType(value="Bool") boolean bl) {
        XClientMessageEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XClientMessageEvent display(@NativeType(value="Display *") long l) {
        XClientMessageEvent.ndisplay(this.address(), l);
        return this;
    }

    public XClientMessageEvent window(@NativeType(value="Window") long l) {
        XClientMessageEvent.nwindow(this.address(), l);
        return this;
    }

    public XClientMessageEvent message_type(@NativeType(value="Atom") long l) {
        XClientMessageEvent.nmessage_type(this.address(), l);
        return this;
    }

    public XClientMessageEvent format(int n) {
        XClientMessageEvent.nformat(this.address(), n);
        return this;
    }

    public XClientMessageEvent data_b(@NativeType(value="char[20]") ByteBuffer byteBuffer) {
        XClientMessageEvent.ndata_b(this.address(), byteBuffer);
        return this;
    }

    public XClientMessageEvent data_b(int n, @NativeType(value="char") byte by) {
        XClientMessageEvent.ndata_b(this.address(), n, by);
        return this;
    }

    public XClientMessageEvent data_s(@NativeType(value="short[10]") ShortBuffer shortBuffer) {
        XClientMessageEvent.ndata_s(this.address(), shortBuffer);
        return this;
    }

    public XClientMessageEvent data_s(int n, short s) {
        XClientMessageEvent.ndata_s(this.address(), n, s);
        return this;
    }

    public XClientMessageEvent data_l(@NativeType(value="long[5]") CLongBuffer cLongBuffer) {
        XClientMessageEvent.ndata_l(this.address(), cLongBuffer);
        return this;
    }

    public XClientMessageEvent data_l(int n, long l) {
        XClientMessageEvent.ndata_l(this.address(), n, l);
        return this;
    }

    public XClientMessageEvent set(int n, long l, boolean bl, long l2, long l3, long l4, int n2, ByteBuffer byteBuffer, ShortBuffer shortBuffer, CLongBuffer cLongBuffer) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.window(l3);
        this.message_type(l4);
        this.format(n2);
        this.data_b(byteBuffer);
        this.data_s(shortBuffer);
        this.data_l(cLongBuffer);
        return this;
    }

    public XClientMessageEvent set(XClientMessageEvent xClientMessageEvent) {
        MemoryUtil.memCopy(xClientMessageEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XClientMessageEvent malloc() {
        return new XClientMessageEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XClientMessageEvent calloc() {
        return new XClientMessageEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XClientMessageEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XClientMessageEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XClientMessageEvent create(long l) {
        return new XClientMessageEvent(l, null);
    }

    public static @Nullable XClientMessageEvent createSafe(long l) {
        return l == 0L ? null : new XClientMessageEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XClientMessageEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XClientMessageEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XClientMessageEvent mallocStack() {
        return XClientMessageEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent callocStack() {
        return XClientMessageEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XClientMessageEvent mallocStack(MemoryStack memoryStack) {
        return XClientMessageEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XClientMessageEvent callocStack(MemoryStack memoryStack) {
        return XClientMessageEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XClientMessageEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XClientMessageEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XClientMessageEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XClientMessageEvent.calloc(n, memoryStack);
    }

    public static XClientMessageEvent malloc(MemoryStack memoryStack) {
        return new XClientMessageEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XClientMessageEvent calloc(MemoryStack memoryStack) {
        return new XClientMessageEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nmessage_type(long l) {
        return MemoryUtil.memGetCLong(l + (long)MESSAGE_TYPE);
    }

    public static int nformat(long l) {
        return MemoryUtil.memGetInt(l + (long)FORMAT);
    }

    public static ByteBuffer ndata_b(long l) {
        return MemoryUtil.memByteBuffer(l + (long)DATA_B, 20);
    }

    public static byte ndata_b(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)DATA_B + Checks.check(n, 20) * 1L);
    }

    public static ShortBuffer ndata_s(long l) {
        return MemoryUtil.memShortBuffer(l + (long)DATA_S, 10);
    }

    public static short ndata_s(long l, int n) {
        return MemoryUtil.memGetShort(l + (long)DATA_S + Checks.check(n, 10) * 2L);
    }

    public static CLongBuffer ndata_l(long l) {
        return MemoryUtil.memCLongBuffer(l + (long)DATA_L, 5);
    }

    public static long ndata_l(long l, int n) {
        return MemoryUtil.memGetCLong(l + (long)DATA_L + Checks.check(n, 5) * (long)CLONG_SIZE);
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

    public static void nmessage_type(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)MESSAGE_TYPE, l2);
    }

    public static void nformat(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FORMAT, n);
    }

    public static void ndata_b(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 20);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)DATA_B, byteBuffer.remaining() * 1);
    }

    public static void ndata_b(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)DATA_B + Checks.check(n, 20) * 1L, by);
    }

    public static void ndata_s(long l, ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(shortBuffer, 10);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(shortBuffer), l + (long)DATA_S, shortBuffer.remaining() * 2);
    }

    public static void ndata_s(long l, int n, short s) {
        MemoryUtil.memPutShort(l + (long)DATA_S + Checks.check(n, 10) * 2L, s);
    }

    public static void ndata_l(long l, CLongBuffer cLongBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(cLongBuffer, 5);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(cLongBuffer), l + (long)DATA_L, cLongBuffer.remaining() * CLONG_SIZE);
    }

    public static void ndata_l(long l, int n, long l2) {
        MemoryUtil.memPutCLong(l + (long)DATA_L + Checks.check(n, 5) * (long)CLONG_SIZE, l2);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XClientMessageEvent.__struct(XClientMessageEvent.__member(4), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__member(POINTER_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(CLONG_SIZE), XClientMessageEvent.__member(4), XClientMessageEvent.__struct(XClientMessageEvent.__array(1, 20), XClientMessageEvent.__array(2, 10), XClientMessageEvent.__array(CLONG_SIZE, 5)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        WINDOW = layout.offsetof(4);
        MESSAGE_TYPE = layout.offsetof(5);
        FORMAT = layout.offsetof(6);
        DATA = layout.offsetof(7);
        DATA_B = layout.offsetof(8);
        DATA_S = layout.offsetof(9);
        DATA_L = layout.offsetof(10);
    }

    public static class Buffer
    extends StructBuffer<XClientMessageEvent, Buffer>
    implements NativeResource {
        private static final XClientMessageEvent ELEMENT_FACTORY = XClientMessageEvent.create(-1L);

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
        protected XClientMessageEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XClientMessageEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XClientMessageEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XClientMessageEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XClientMessageEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long window() {
            return XClientMessageEvent.nwindow(this.address());
        }

        @NativeType(value="Atom")
        public long message_type() {
            return XClientMessageEvent.nmessage_type(this.address());
        }

        public int format() {
            return XClientMessageEvent.nformat(this.address());
        }

        @NativeType(value="char[20]")
        public ByteBuffer data_b() {
            return XClientMessageEvent.ndata_b(this.address());
        }

        @NativeType(value="char")
        public byte data_b(int n) {
            return XClientMessageEvent.ndata_b(this.address(), n);
        }

        @NativeType(value="short[10]")
        public ShortBuffer data_s() {
            return XClientMessageEvent.ndata_s(this.address());
        }

        public short data_s(int n) {
            return XClientMessageEvent.ndata_s(this.address(), n);
        }

        @NativeType(value="long[5]")
        public CLongBuffer data_l() {
            return XClientMessageEvent.ndata_l(this.address());
        }

        public long data_l(int n) {
            return XClientMessageEvent.ndata_l(this.address(), n);
        }

        public Buffer type(int n) {
            XClientMessageEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XClientMessageEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XClientMessageEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XClientMessageEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer window(@NativeType(value="Window") long l) {
            XClientMessageEvent.nwindow(this.address(), l);
            return this;
        }

        public Buffer message_type(@NativeType(value="Atom") long l) {
            XClientMessageEvent.nmessage_type(this.address(), l);
            return this;
        }

        public Buffer format(int n) {
            XClientMessageEvent.nformat(this.address(), n);
            return this;
        }

        public Buffer data_b(@NativeType(value="char[20]") ByteBuffer byteBuffer) {
            XClientMessageEvent.ndata_b(this.address(), byteBuffer);
            return this;
        }

        public Buffer data_b(int n, @NativeType(value="char") byte by) {
            XClientMessageEvent.ndata_b(this.address(), n, by);
            return this;
        }

        public Buffer data_s(@NativeType(value="short[10]") ShortBuffer shortBuffer) {
            XClientMessageEvent.ndata_s(this.address(), shortBuffer);
            return this;
        }

        public Buffer data_s(int n, short s) {
            XClientMessageEvent.ndata_s(this.address(), n, s);
            return this;
        }

        public Buffer data_l(@NativeType(value="long[5]") CLongBuffer cLongBuffer) {
            XClientMessageEvent.ndata_l(this.address(), cLongBuffer);
            return this;
        }

        public Buffer data_l(int n, long l) {
            XClientMessageEvent.ndata_l(this.address(), n, l);
            return this;
        }
    }
}

