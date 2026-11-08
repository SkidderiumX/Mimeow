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

@NativeType(value="struct io_uring_rsrc_update2")
public class IOURingRSRCUpdate2
extends Struct<IOURingRSRCUpdate2>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OFFSET;
    public static final int RESV;
    public static final int DATA;
    public static final int TAGS;
    public static final int NR;
    public static final int RESV2;

    protected IOURingRSRCUpdate2(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingRSRCUpdate2 create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingRSRCUpdate2(l, byteBuffer);
    }

    public IOURingRSRCUpdate2(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingRSRCUpdate2.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int offset() {
        return IOURingRSRCUpdate2.noffset(this.address());
    }

    @NativeType(value="__u64")
    public long data() {
        return IOURingRSRCUpdate2.ndata(this.address());
    }

    @NativeType(value="__u64")
    public long tags() {
        return IOURingRSRCUpdate2.ntags(this.address());
    }

    @NativeType(value="__u32")
    public int nr() {
        return IOURingRSRCUpdate2.nnr(this.address());
    }

    public IOURingRSRCUpdate2 offset(@NativeType(value="__u32") int n) {
        IOURingRSRCUpdate2.noffset(this.address(), n);
        return this;
    }

    public IOURingRSRCUpdate2 data(@NativeType(value="__u64") long l) {
        IOURingRSRCUpdate2.ndata(this.address(), l);
        return this;
    }

    public IOURingRSRCUpdate2 tags(@NativeType(value="__u64") long l) {
        IOURingRSRCUpdate2.ntags(this.address(), l);
        return this;
    }

    public IOURingRSRCUpdate2 nr(@NativeType(value="__u32") int n) {
        IOURingRSRCUpdate2.nnr(this.address(), n);
        return this;
    }

    public IOURingRSRCUpdate2 set(int n, long l, long l2, int n2) {
        this.offset(n);
        this.data(l);
        this.tags(l2);
        this.nr(n2);
        return this;
    }

    public IOURingRSRCUpdate2 set(IOURingRSRCUpdate2 iOURingRSRCUpdate2) {
        MemoryUtil.memCopy(iOURingRSRCUpdate2.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingRSRCUpdate2 malloc() {
        return new IOURingRSRCUpdate2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 calloc() {
        return new IOURingRSRCUpdate2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingRSRCUpdate2(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingRSRCUpdate2 create(long l) {
        return new IOURingRSRCUpdate2(l, null);
    }

    public static @Nullable IOURingRSRCUpdate2 createSafe(long l) {
        return l == 0L ? null : new IOURingRSRCUpdate2(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingRSRCUpdate2.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingRSRCUpdate2.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingRSRCUpdate2 malloc(MemoryStack memoryStack) {
        return new IOURingRSRCUpdate2(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingRSRCUpdate2 calloc(MemoryStack memoryStack) {
        return new IOURingRSRCUpdate2(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static long ntags(long l) {
        return MemoryUtil.memGetLong(l + (long)TAGS);
    }

    public static int nnr(long l) {
        return MemoryUtil.memGetInt(l + (long)NR);
    }

    public static int nresv2(long l) {
        return MemoryUtil.memGetInt(l + (long)RESV2);
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

    public static void ntags(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)TAGS, l2);
    }

    public static void nnr(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NR, n);
    }

    public static void nresv2(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RESV2, n);
    }

    static {
        Struct.Layout layout = IOURingRSRCUpdate2.__struct(IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(8), IOURingRSRCUpdate2.__member(4), IOURingRSRCUpdate2.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OFFSET = layout.offsetof(0);
        RESV = layout.offsetof(1);
        DATA = layout.offsetof(2);
        TAGS = layout.offsetof(3);
        NR = layout.offsetof(4);
        RESV2 = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<IOURingRSRCUpdate2, Buffer>
    implements NativeResource {
        private static final IOURingRSRCUpdate2 ELEMENT_FACTORY = IOURingRSRCUpdate2.create(-1L);

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
        protected IOURingRSRCUpdate2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int offset() {
            return IOURingRSRCUpdate2.noffset(this.address());
        }

        @NativeType(value="__u64")
        public long data() {
            return IOURingRSRCUpdate2.ndata(this.address());
        }

        @NativeType(value="__u64")
        public long tags() {
            return IOURingRSRCUpdate2.ntags(this.address());
        }

        @NativeType(value="__u32")
        public int nr() {
            return IOURingRSRCUpdate2.nnr(this.address());
        }

        public Buffer offset(@NativeType(value="__u32") int n) {
            IOURingRSRCUpdate2.noffset(this.address(), n);
            return this;
        }

        public Buffer data(@NativeType(value="__u64") long l) {
            IOURingRSRCUpdate2.ndata(this.address(), l);
            return this;
        }

        public Buffer tags(@NativeType(value="__u64") long l) {
            IOURingRSRCUpdate2.ntags(this.address(), l);
            return this;
        }

        public Buffer nr(@NativeType(value="__u32") int n) {
            IOURingRSRCUpdate2.nnr(this.address(), n);
            return this;
        }
    }
}

