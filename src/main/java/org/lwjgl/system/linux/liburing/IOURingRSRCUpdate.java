/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_rsrc_update")
public class IOURingRSRCUpdate
extends Struct<IOURingRSRCUpdate>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFFSET;
    public static final int RESV;
    public static final int DATA;

    protected IOURingRSRCUpdate(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingRSRCUpdate create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingRSRCUpdate(l, byteBuffer);
    }

    public IOURingRSRCUpdate(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCUpdate.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int offset() {
        return IOURingRSRCUpdate.noffset(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCUpdate.ndata(this.address());
    }

    public IOURingRSRCUpdate offset(@NativeType(value="__u32") int n) {
        IOURingRSRCUpdate.noffset(this.address(), n);
        return this;
    }

    public IOURingRSRCUpdate data(@NativeType(value="__u64") long l) {
        IOURingRSRCUpdate.ndata(this.address(), l);
        return this;
    }

    public IOURingRSRCUpdate set(int n, long l) {
        this.offset(n);
        this.data(l);
        return this;
    }

    public IOURingRSRCUpdate set(IOURingRSRCUpdate iOURingRSRCUpdate) {
        MemoryUtil.memCopy(iOURingRSRCUpdate.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCUpdate malloc() {
        return new IOURingRSRCUpdate(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRSRCUpdate calloc() {
        return new IOURingRSRCUpdate(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRSRCUpdate create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRSRCUpdate(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCUpdate create(long l) {
        return new IOURingRSRCUpdate(l, null);
    }

    public static @Nullable IOURingRSRCUpdate createSafe(long l) {
        return l == 0L ? null : new IOURingRSRCUpdate(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRSRCUpdate.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingRSRCUpdate.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingRSRCUpdate malloc(MemoryStack memoryStack) {
        return new IOURingRSRCUpdate(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRSRCUpdate calloc(MemoryStack memoryStack) {
        return new IOURingRSRCUpdate(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int noffset(long l) {
        return MemoryUtil.memGetInt(l + (long)OFFSET);
    }

    public static int nresv(long l) {
        return MemoryUtil.memGetInt(l + (long)RESV);
    }

    public static long ndata(long l) {
        return MemoryUtil.memGetLong(l + (long)DATA);
    }

    public static void noffset(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OFFSET, n);
    }

    public static void nresv(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV, n);
    }

    public static void ndata(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)DATA, l2);
    }

    static {
        Struct.Layout layout = IOURingRSRCUpdate.__struct(IOURingRSRCUpdate.__member(4), IOURingRSRCUpdate.__member(4), IOURingRSRCUpdate.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OFFSET = layout.offsetof(0);
        RESV = layout.offsetof(1);
        DATA = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCUpdate, Buffer>
    implements NativeResource {
        private static final IOURingRSRCUpdate ELEMENT_FACTORY = IOURingRSRCUpdate.create(-1L);

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
        protected IOURingRSRCUpdate getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int offset() {
            return IOURingRSRCUpdate.noffset(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCUpdate.ndata(this.address());
        }

        public Buffer offset(@NativeType(value="__u32") int n) {
            IOURingRSRCUpdate.noffset(this.address(), n);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l) {
            IOURingRSRCUpdate.ndata(this.address(), l);
            return this;
        }
    }
}

