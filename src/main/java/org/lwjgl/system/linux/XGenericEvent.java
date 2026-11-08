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

public class XGenericEvent
extends Struct<XGenericEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int EXTENSION;
    public static final int EVTYPE;

    protected XGenericEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XGenericEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XGenericEvent(l, byteBuffer);
    }

    public XGenericEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XGenericEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XGenericEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XGenericEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XGenericEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XGenericEvent.ndisplay(this.address());
    }

    public int extension() {
        return XGenericEvent.nextension(this.address());
    }

    public int evtype() {
        return XGenericEvent.nevtype(this.address());
    }

    public XGenericEvent type(int n) {
        XGenericEvent.ntype(this.address(), n);
        return this;
    }

    public XGenericEvent serial(@NativeType(value="unsigned long") long l) {
        XGenericEvent.nserial(this.address(), l);
        return this;
    }

    public XGenericEvent send_event(@NativeType(value="Bool") boolean bl) {
        XGenericEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XGenericEvent display(@NativeType(value="Display *") long l) {
        XGenericEvent.ndisplay(this.address(), l);
        return this;
    }

    public XGenericEvent extension(int n) {
        XGenericEvent.nextension(this.address(), n);
        return this;
    }

    public XGenericEvent evtype(int n) {
        XGenericEvent.nevtype(this.address(), n);
        return this;
    }

    public XGenericEvent set(int n, long l, boolean bl, long l2, int n2, int n3) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.extension(n2);
        this.evtype(n3);
        return this;
    }

    public XGenericEvent set(XGenericEvent xGenericEvent) {
        MemoryUtil.memCopy(xGenericEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XGenericEvent malloc() {
        return new XGenericEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XGenericEvent calloc() {
        return new XGenericEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XGenericEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XGenericEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XGenericEvent create(long l) {
        return new XGenericEvent(l, null);
    }

    public static @Nullable XGenericEvent createSafe(long l) {
        return l == 0L ? null : new XGenericEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XGenericEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XGenericEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XGenericEvent mallocStack() {
        return XGenericEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent callocStack() {
        return XGenericEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XGenericEvent mallocStack(MemoryStack memoryStack) {
        return XGenericEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XGenericEvent callocStack(MemoryStack memoryStack) {
        return XGenericEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XGenericEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XGenericEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XGenericEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XGenericEvent.calloc(n, memoryStack);
    }

    public static XGenericEvent malloc(MemoryStack memoryStack) {
        return new XGenericEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XGenericEvent calloc(MemoryStack memoryStack) {
        return new XGenericEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XGenericEvent.__struct(XGenericEvent.__member(4), XGenericEvent.__member(CLONG_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(POINTER_SIZE), XGenericEvent.__member(4), XGenericEvent.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        EXTENSION = layout.offsetof(4);
        EVTYPE = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<XGenericEvent, Buffer>
    implements NativeResource {
        private static final XGenericEvent ELEMENT_FACTORY = XGenericEvent.create(-1L);

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
        protected XGenericEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XGenericEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XGenericEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XGenericEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XGenericEvent.ndisplay(this.address());
        }

        public int extension() {
            return XGenericEvent.nextension(this.address());
        }

        public int evtype() {
            return XGenericEvent.nevtype(this.address());
        }

        public Buffer type(int n) {
            XGenericEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XGenericEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XGenericEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XGenericEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer extension(int n) {
            XGenericEvent.nextension(this.address(), n);
            return this;
        }

        public Buffer evtype(int n) {
            XGenericEvent.nevtype(this.address(), n);
            return this;
        }
    }
}

