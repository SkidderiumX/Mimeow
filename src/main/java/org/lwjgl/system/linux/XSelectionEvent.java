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

public class XSelectionEvent
extends Struct<XSelectionEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int REQUESTOR;
    public static final int SELECTION;
    public static final int TARGET;
    public static final int PROPERTY;
    public static final int TIME;

    protected XSelectionEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XSelectionEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XSelectionEvent(l, byteBuffer);
    }

    public XSelectionEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSelectionEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long requestor() {
        return XSelectionEvent.nrequestor(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionEvent.nselection(this.address());
    }

    @NativeType(value="Atom")
    public long target() {
        return XSelectionEvent.ntarget(this.address());
    }

    @NativeType(value="Atom")
    public long property() {
        return XSelectionEvent.nproperty(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionEvent.ntime(this.address());
    }

    public XSelectionEvent type(int n) {
        XSelectionEvent.ntype(this.address(), n);
        return this;
    }

    public XSelectionEvent serial(@NativeType(value="unsigned long") long l) {
        XSelectionEvent.nserial(this.address(), l);
        return this;
    }

    public XSelectionEvent send_event(@NativeType(value="Bool") boolean bl) {
        XSelectionEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XSelectionEvent display(@NativeType(value="Display *") long l) {
        XSelectionEvent.ndisplay(this.address(), l);
        return this;
    }

    public XSelectionEvent requestor(@NativeType(value="Window") long l) {
        XSelectionEvent.nrequestor(this.address(), l);
        return this;
    }

    public XSelectionEvent selection(@NativeType(value="Atom") long l) {
        XSelectionEvent.nselection(this.address(), l);
        return this;
    }

    public XSelectionEvent target(@NativeType(value="Atom") long l) {
        XSelectionEvent.ntarget(this.address(), l);
        return this;
    }

    public XSelectionEvent property(@NativeType(value="Atom") long l) {
        XSelectionEvent.nproperty(this.address(), l);
        return this;
    }

    public XSelectionEvent time(@NativeType(value="Time") long l) {
        XSelectionEvent.ntime(this.address(), l);
        return this;
    }

    public XSelectionEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, long l6, long l7) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.requestor(l3);
        this.selection(l4);
        this.target(l5);
        this.property(l6);
        this.time(l7);
        return this;
    }

    public XSelectionEvent set(XSelectionEvent xSelectionEvent) {
        MemoryUtil.memCopy(xSelectionEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionEvent malloc() {
        return new XSelectionEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XSelectionEvent calloc() {
        return new XSelectionEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XSelectionEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XSelectionEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSelectionEvent create(long l) {
        return new XSelectionEvent(l, null);
    }

    public static @Nullable XSelectionEvent createSafe(long l) {
        return l == 0L ? null : new XSelectionEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XSelectionEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XSelectionEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XSelectionEvent mallocStack() {
        return XSelectionEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionEvent callocStack() {
        return XSelectionEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionEvent mallocStack(MemoryStack memoryStack) {
        return XSelectionEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XSelectionEvent callocStack(MemoryStack memoryStack) {
        return XSelectionEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XSelectionEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XSelectionEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XSelectionEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XSelectionEvent.calloc(n, memoryStack);
    }

    public static XSelectionEvent malloc(MemoryStack memoryStack) {
        return new XSelectionEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XSelectionEvent calloc(MemoryStack memoryStack) {
        return new XSelectionEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nrequestor(long l) {
        return MemoryUtil.memGetCLong(l + (long)REQUESTOR);
    }

    public static long nselection(long l) {
        return MemoryUtil.memGetCLong(l + (long)SELECTION);
    }

    public static long ntarget(long l) {
        return MemoryUtil.memGetCLong(l + (long)TARGET);
    }

    public static long nproperty(long l) {
        return MemoryUtil.memGetCLong(l + (long)PROPERTY);
    }

    public static long ntime(long l) {
        return MemoryUtil.memGetCLong(l + (long)TIME);
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

    public static void nrequestor(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)REQUESTOR, l2);
    }

    public static void nselection(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)SELECTION, l2);
    }

    public static void ntarget(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)TARGET, l2);
    }

    public static void nproperty(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)PROPERTY, l2);
    }

    public static void ntime(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)TIME, l2);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)DISPLAY));
    }

    static {
        Struct.Layout layout = XSelectionEvent.__struct(XSelectionEvent.__member(4), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(4), XSelectionEvent.__member(POINTER_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE), XSelectionEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        REQUESTOR = layout.offsetof(4);
        SELECTION = layout.offsetof(5);
        TARGET = layout.offsetof(6);
        PROPERTY = layout.offsetof(7);
        TIME = layout.offsetof(8);
    }

    public static class Buffer
    extends StructBuffer<XSelectionEvent, Buffer>
    implements NativeResource {
        private static final XSelectionEvent ELEMENT_FACTORY = XSelectionEvent.create(-1L);

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
        protected XSelectionEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long requestor() {
            return XSelectionEvent.nrequestor(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionEvent.nselection(this.address());
        }

        @NativeType(value="Atom")
        public long target() {
            return XSelectionEvent.ntarget(this.address());
        }

        @NativeType(value="Atom")
        public long property() {
            return XSelectionEvent.nproperty(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionEvent.ntime(this.address());
        }

        public Buffer type(int n) {
            XSelectionEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XSelectionEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XSelectionEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XSelectionEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer requestor(@NativeType(value="Window") long l) {
            XSelectionEvent.nrequestor(this.address(), l);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long l) {
            XSelectionEvent.nselection(this.address(), l);
            return this;
        }

        public Buffer target(@NativeType(value="Atom") long l) {
            XSelectionEvent.ntarget(this.address(), l);
            return this;
        }

        public Buffer property(@NativeType(value="Atom") long l) {
            XSelectionEvent.nproperty(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XSelectionEvent.ntime(this.address(), l);
            return this;
        }
    }
}

