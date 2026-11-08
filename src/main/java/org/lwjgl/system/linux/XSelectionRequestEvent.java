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

public class XSelectionRequestEvent
extends Struct<XSelectionRequestEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int SERIAL;
    public static final int SEND_EVENT;
    public static final int DISPLAY;
    public static final int OWNER;
    public static final int REQUESTOR;
    public static final int SELECTION;
    public static final int TARGET;
    public static final int PROPERTY;
    public static final int TIME;

    protected XSelectionRequestEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XSelectionRequestEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XSelectionRequestEvent(l, byteBuffer);
    }

    public XSelectionRequestEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XSelectionRequestEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return XSelectionRequestEvent.ntype(this.address());
    }

    @NativeType(value="unsigned long")
    public long serial() {
        return XSelectionRequestEvent.nserial(this.address());
    }

    @NativeType(value="Bool")
    public boolean send_event() {
        return XSelectionRequestEvent.nsend_event(this.address()) != 0;
    }

    @NativeType(value="Display *")
    public long display() {
        return XSelectionRequestEvent.ndisplay(this.address());
    }

    @NativeType(value="Window")
    public long owner() {
        return XSelectionRequestEvent.nowner(this.address());
    }

    @NativeType(value="Window")
    public long requestor() {
        return XSelectionRequestEvent.nrequestor(this.address());
    }

    @NativeType(value="Atom")
    public long selection() {
        return XSelectionRequestEvent.nselection(this.address());
    }

    @NativeType(value="Atom")
    public long target() {
        return XSelectionRequestEvent.ntarget(this.address());
    }

    @NativeType(value="Atom")
    public long property() {
        return XSelectionRequestEvent.nproperty(this.address());
    }

    @NativeType(value="Time")
    public long time() {
        return XSelectionRequestEvent.ntime(this.address());
    }

    public XSelectionRequestEvent type(int n) {
        XSelectionRequestEvent.ntype(this.address(), n);
        return this;
    }

    public XSelectionRequestEvent serial(@NativeType(value="unsigned long") long l) {
        XSelectionRequestEvent.nserial(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent send_event(@NativeType(value="Bool") boolean bl) {
        XSelectionRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
        return this;
    }

    public XSelectionRequestEvent display(@NativeType(value="Display *") long l) {
        XSelectionRequestEvent.ndisplay(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent owner(@NativeType(value="Window") long l) {
        XSelectionRequestEvent.nowner(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent requestor(@NativeType(value="Window") long l) {
        XSelectionRequestEvent.nrequestor(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent selection(@NativeType(value="Atom") long l) {
        XSelectionRequestEvent.nselection(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent target(@NativeType(value="Atom") long l) {
        XSelectionRequestEvent.ntarget(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent property(@NativeType(value="Atom") long l) {
        XSelectionRequestEvent.nproperty(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent time(@NativeType(value="Time") long l) {
        XSelectionRequestEvent.ntime(this.address(), l);
        return this;
    }

    public XSelectionRequestEvent set(int n, long l, boolean bl, long l2, long l3, long l4, long l5, long l6, long l7, long l8) {
        this.type(n);
        this.serial(l);
        this.send_event(bl);
        this.display(l2);
        this.owner(l3);
        this.requestor(l4);
        this.selection(l5);
        this.target(l6);
        this.property(l7);
        this.time(l8);
        return this;
    }

    public XSelectionRequestEvent set(XSelectionRequestEvent xSelectionRequestEvent) {
        MemoryUtil.memCopy(xSelectionRequestEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static XSelectionRequestEvent malloc() {
        return new XSelectionRequestEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static XSelectionRequestEvent calloc() {
        return new XSelectionRequestEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static XSelectionRequestEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new XSelectionRequestEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static XSelectionRequestEvent create(long l) {
        return new XSelectionRequestEvent(l, null);
    }

    public static @Nullable XSelectionRequestEvent createSafe(long l) {
        return l == 0L ? null : new XSelectionRequestEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(XSelectionRequestEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = XSelectionRequestEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static XSelectionRequestEvent mallocStack() {
        return XSelectionRequestEvent.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionRequestEvent callocStack() {
        return XSelectionRequestEvent.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static XSelectionRequestEvent mallocStack(MemoryStack memoryStack) {
        return XSelectionRequestEvent.malloc(memoryStack);
    }

    @Deprecated
    public static XSelectionRequestEvent callocStack(MemoryStack memoryStack) {
        return XSelectionRequestEvent.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return XSelectionRequestEvent.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return XSelectionRequestEvent.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return XSelectionRequestEvent.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return XSelectionRequestEvent.calloc(n, memoryStack);
    }

    public static XSelectionRequestEvent malloc(MemoryStack memoryStack) {
        return new XSelectionRequestEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static XSelectionRequestEvent calloc(MemoryStack memoryStack) {
        return new XSelectionRequestEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long nowner(long l) {
        return MemoryUtil.memGetCLong(l + (long)OWNER);
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

    public static void nowner(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)OWNER, l2);
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
        Struct.Layout layout = XSelectionRequestEvent.__struct(XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(4), XSelectionRequestEvent.__member(POINTER_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE), XSelectionRequestEvent.__member(CLONG_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        SERIAL = layout.offsetof(1);
        SEND_EVENT = layout.offsetof(2);
        DISPLAY = layout.offsetof(3);
        OWNER = layout.offsetof(4);
        REQUESTOR = layout.offsetof(5);
        SELECTION = layout.offsetof(6);
        TARGET = layout.offsetof(7);
        PROPERTY = layout.offsetof(8);
        TIME = layout.offsetof(9);
    }

    public static class Buffer
    extends StructBuffer<XSelectionRequestEvent, Buffer>
    implements NativeResource {
        private static final XSelectionRequestEvent ELEMENT_FACTORY = XSelectionRequestEvent.create(-1L);

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
        protected XSelectionRequestEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return XSelectionRequestEvent.ntype(this.address());
        }

        @NativeType(value="unsigned long")
        public long serial() {
            return XSelectionRequestEvent.nserial(this.address());
        }

        @NativeType(value="Bool")
        public boolean send_event() {
            return XSelectionRequestEvent.nsend_event(this.address()) != 0;
        }

        @NativeType(value="Display *")
        public long display() {
            return XSelectionRequestEvent.ndisplay(this.address());
        }

        @NativeType(value="Window")
        public long owner() {
            return XSelectionRequestEvent.nowner(this.address());
        }

        @NativeType(value="Window")
        public long requestor() {
            return XSelectionRequestEvent.nrequestor(this.address());
        }

        @NativeType(value="Atom")
        public long selection() {
            return XSelectionRequestEvent.nselection(this.address());
        }

        @NativeType(value="Atom")
        public long target() {
            return XSelectionRequestEvent.ntarget(this.address());
        }

        @NativeType(value="Atom")
        public long property() {
            return XSelectionRequestEvent.nproperty(this.address());
        }

        @NativeType(value="Time")
        public long time() {
            return XSelectionRequestEvent.ntime(this.address());
        }

        public Buffer type(int n) {
            XSelectionRequestEvent.ntype(this.address(), n);
            return this;
        }

        public Buffer serial(@NativeType(value="unsigned long") long l) {
            XSelectionRequestEvent.nserial(this.address(), l);
            return this;
        }

        public Buffer send_event(@NativeType(value="Bool") boolean bl) {
            XSelectionRequestEvent.nsend_event(this.address(), bl ? 1 : 0);
            return this;
        }

        public Buffer display(@NativeType(value="Display *") long l) {
            XSelectionRequestEvent.ndisplay(this.address(), l);
            return this;
        }

        public Buffer owner(@NativeType(value="Window") long l) {
            XSelectionRequestEvent.nowner(this.address(), l);
            return this;
        }

        public Buffer requestor(@NativeType(value="Window") long l) {
            XSelectionRequestEvent.nrequestor(this.address(), l);
            return this;
        }

        public Buffer selection(@NativeType(value="Atom") long l) {
            XSelectionRequestEvent.nselection(this.address(), l);
            return this;
        }

        public Buffer target(@NativeType(value="Atom") long l) {
            XSelectionRequestEvent.ntarget(this.address(), l);
            return this;
        }

        public Buffer property(@NativeType(value="Atom") long l) {
            XSelectionRequestEvent.nproperty(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="Time") long l) {
            XSelectionRequestEvent.ntime(this.address(), l);
            return this;
        }
    }
}

