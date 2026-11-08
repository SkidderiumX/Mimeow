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

@NativeType(value="union epoll_data_t")
public class EpollData
extends Struct<EpollData>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int PTR;
    public static final int FD;
    public static final int U32;
    public static final int U64;

    protected EpollData(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected EpollData create(long l, @Nullable ByteBuffer byteBuffer) {
        return new EpollData(l, byteBuffer);
    }

    public EpollData(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), EpollData.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ptr() {
        return EpollData.nptr(this.address());
    }

    public int fd() {
        return EpollData.nfd(this.address());
    }

    @NativeType(value="uint32_t")
    public int u32() {
        return EpollData.nu32(this.address());
    }

    @NativeType(value="uint64_t")
    public long u64() {
        return EpollData.nu64(this.address());
    }

    public EpollData ptr(@NativeType(value="void *") long l) {
        EpollData.nptr(this.address(), l);
        return this;
    }

    public EpollData fd(int n) {
        EpollData.nfd(this.address(), n);
        return this;
    }

    public EpollData u32(@NativeType(value="uint32_t") int n) {
        EpollData.nu32(this.address(), n);
        return this;
    }

    public EpollData u64(@NativeType(value="uint64_t") long l) {
        EpollData.nu64(this.address(), l);
        return this;
    }

    public EpollData set(EpollData epollData) {
        MemoryUtil.memCopy(epollData.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollData malloc() {
        return new EpollData(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static EpollData calloc() {
        return new EpollData(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static EpollData create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new EpollData(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static EpollData create(long l) {
        return new EpollData(l, null);
    }

    public static @Nullable EpollData createSafe(long l) {
        return l == 0L ? null : new EpollData(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(EpollData.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = EpollData.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static EpollData malloc(MemoryStack memoryStack) {
        return new EpollData(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static EpollData calloc(MemoryStack memoryStack) {
        return new EpollData(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nptr(long l) {
        return MemoryUtil.memGetAddress(l + (long)PTR);
    }

    public static int nfd(long l) {
        return MemoryUtil.memGetInt(l + (long)FD);
    }

    public static int nu32(long l) {
        return MemoryUtil.memGetInt(l + (long)U32);
    }

    public static long nu64(long l) {
        return MemoryUtil.memGetLong(l + (long)U64);
    }

    public static void nptr(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)PTR, Checks.check(l2));
    }

    public static void nfd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FD, n);
    }

    public static void nu32(long l, int n) {
        MemoryUtil.memPutInt(l + (long)U32, n);
    }

    public static void nu64(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)U64, l2);
    }

    static {
        Struct.Layout layout = EpollData.__union(EpollData.__member(POINTER_SIZE), EpollData.__member(4), EpollData.__member(4), EpollData.__member(8));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        PTR = layout.offsetof(0);
        FD = layout.offsetof(1);
        U32 = layout.offsetof(2);
        U64 = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<EpollData, Buffer>
    implements NativeResource {
        private static final EpollData ELEMENT_FACTORY = EpollData.create(-1L);

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
        protected EpollData getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ptr() {
            return EpollData.nptr(this.address());
        }

        public int fd() {
            return EpollData.nfd(this.address());
        }

        @NativeType(value="uint32_t")
        public int u32() {
            return EpollData.nu32(this.address());
        }

        @NativeType(value="uint64_t")
        public long u64() {
            return EpollData.nu64(this.address());
        }

        public Buffer ptr(@NativeType(value="void *") long l) {
            EpollData.nptr(this.address(), l);
            return this;
        }

        public Buffer fd(int n) {
            EpollData.nfd(this.address(), n);
            return this;
        }

        public Buffer u32(@NativeType(value="uint32_t") int n) {
            EpollData.nu32(this.address(), n);
            return this;
        }

        public Buffer u64(@NativeType(value="uint64_t") long l) {
            EpollData.nu64(this.address(), l);
            return this;
        }
    }
}

