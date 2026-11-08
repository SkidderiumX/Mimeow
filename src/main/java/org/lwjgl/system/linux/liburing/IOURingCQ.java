/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.liburing.IOURingCQE;

@NativeType(value="struct io_uring_cq")
public class IOURingCQ
extends Struct<IOURingCQ>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KOVERFLOW;
    public static final int CQES;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int PAD;

    protected IOURingCQ(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingCQ create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingCQ(l, byteBuffer);
    }

    public IOURingCQ(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingCQ.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int n) {
        return IOURingCQ.nkhead(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int n) {
        return IOURingCQ.nktail(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int n) {
        return IOURingCQ.nkring_mask(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int n) {
        return IOURingCQ.nkring_entries(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int n) {
        return IOURingCQ.nkflags(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer koverflow(int n) {
        return IOURingCQ.nkoverflow(this.address(), n);
    }

    @NativeType(value="struct io_uring_cqe *")
    public IOURingCQE cqes() {
        return IOURingCQ.ncqes(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingCQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingCQ.nring_ptr(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_mask() {
        return IOURingCQ.nring_mask(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_entries() {
        return IOURingCQ.nring_entries(this.address());
    }

    public IOURingCQ khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkhead(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nktail(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkring_mask(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkring_entries(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkflags(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ koverflow(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingCQ.nkoverflow(this.address(), intBuffer);
        return this;
    }

    public IOURingCQ cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
        IOURingCQ.ncqes(this.address(), iOURingCQE);
        return this;
    }

    public IOURingCQ ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
        IOURingCQ.nring_ptr(this.address(), byteBuffer);
        return this;
    }

    public IOURingCQ ring_mask(@NativeType(value="unsigned") int n) {
        IOURingCQ.nring_mask(this.address(), n);
        return this;
    }

    public IOURingCQ ring_entries(@NativeType(value="unsigned") int n) {
        IOURingCQ.nring_entries(this.address(), n);
        return this;
    }

    public IOURingCQ set(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, IntBuffer intBuffer6, IOURingCQE iOURingCQE, ByteBuffer byteBuffer, int n, int n2) {
        this.khead(intBuffer);
        this.ktail(intBuffer2);
        this.kring_mask(intBuffer3);
        this.kring_entries(intBuffer4);
        this.kflags(intBuffer5);
        this.koverflow(intBuffer6);
        this.cqes(iOURingCQE);
        this.ring_ptr(byteBuffer);
        this.ring_mask(n);
        this.ring_entries(n2);
        return this;
    }

    public IOURingCQ set(IOURingCQ iOURingCQ) {
        MemoryUtil.memCopy(iOURingCQ.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingCQ malloc() {
        return new IOURingCQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingCQ calloc() {
        return new IOURingCQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingCQ create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingCQ(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingCQ create(long l) {
        return new IOURingCQ(l, null);
    }

    public static @Nullable IOURingCQ createSafe(long l) {
        return l == 0L ? null : new IOURingCQ(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingCQ.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingCQ.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingCQ malloc(MemoryStack memoryStack) {
        return new IOURingCQ(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingCQ calloc(MemoryStack memoryStack) {
        return new IOURingCQ(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static IntBuffer nkhead(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KHEAD), n);
    }

    public static IntBuffer nktail(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KTAIL), n);
    }

    public static IntBuffer nkring_mask(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KRING_MASK), n);
    }

    public static IntBuffer nkring_entries(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KRING_ENTRIES), n);
    }

    public static IntBuffer nkflags(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KFLAGS), n);
    }

    public static IntBuffer nkoverflow(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KOVERFLOW), n);
    }

    public static IOURingCQE ncqes(long l) {
        return IOURingCQE.create(MemoryUtil.memGetAddress(l + (long)CQES));
    }

    public static long nring_sz(long l) {
        return MemoryUtil.memGetAddress(l + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long l) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)RING_PTR), (int)IOURingCQ.nring_sz(l));
    }

    public static int nring_mask(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_MASK);
    }

    public static int nring_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)RING_ENTRIES);
    }

    public static IntBuffer npad(long l) {
        return MemoryUtil.memIntBuffer(l + (long)PAD, 2);
    }

    public static int npad(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)PAD + Checks.check(n, 2) * 4L);
    }

    public static void nkhead(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KHEAD, MemoryUtil.memAddress(intBuffer));
    }

    public static void nktail(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KTAIL, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkring_mask(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KRING_MASK, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkring_entries(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KRING_ENTRIES, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkflags(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KFLAGS, MemoryUtil.memAddress(intBuffer));
    }

    public static void nkoverflow(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KOVERFLOW, MemoryUtil.memAddress(intBuffer));
    }

    public static void ncqes(long l, IOURingCQE iOURingCQE) {
        MemoryUtil.memPutAddress(l + (long)CQES, iOURingCQE.address());
    }

    public static void nring_sz(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)RING_SZ, l2);
    }

    public static void nring_ptr(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)RING_PTR, MemoryUtil.memAddress(byteBuffer));
        IOURingCQ.nring_sz(l, byteBuffer.remaining());
    }

    public static void nring_mask(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_MASK, n);
    }

    public static void nring_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RING_ENTRIES, n);
    }

    public static void npad(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)PAD, intBuffer.remaining() * 4);
    }

    public static void npad(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)PAD + Checks.check(n, 2) * 4L, n2);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)KHEAD));
        Checks.check(MemoryUtil.memGetAddress(l + (long)KTAIL));
        Checks.check(MemoryUtil.memGetAddress(l + (long)KRING_MASK));
        Checks.check(MemoryUtil.memGetAddress(l + (long)KRING_ENTRIES));
        Checks.check(MemoryUtil.memGetAddress(l + (long)KFLAGS));
        Checks.check(MemoryUtil.memGetAddress(l + (long)KOVERFLOW));
        Checks.check(MemoryUtil.memGetAddress(l + (long)CQES));
        Checks.check(MemoryUtil.memGetAddress(l + (long)RING_PTR));
    }

    static {
        Struct.Layout layout = IOURingCQ.__struct(IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(POINTER_SIZE), IOURingCQ.__member(4), IOURingCQ.__member(4), IOURingCQ.__array(4, 2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        KHEAD = layout.offsetof(0);
        KTAIL = layout.offsetof(1);
        KRING_MASK = layout.offsetof(2);
        KRING_ENTRIES = layout.offsetof(3);
        KFLAGS = layout.offsetof(4);
        KOVERFLOW = layout.offsetof(5);
        CQES = layout.offsetof(6);
        RING_SZ = layout.offsetof(7);
        RING_PTR = layout.offsetof(8);
        RING_MASK = layout.offsetof(9);
        RING_ENTRIES = layout.offsetof(10);
        PAD = layout.offsetof(11);
    }

    public static class Buffer
    extends StructBuffer<IOURingCQ, Buffer>
    implements NativeResource {
        private static final IOURingCQ ELEMENT_FACTORY = IOURingCQ.create(-1L);

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
        protected IOURingCQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int n) {
            return IOURingCQ.nkhead(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int n) {
            return IOURingCQ.nktail(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int n) {
            return IOURingCQ.nkring_mask(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int n) {
            return IOURingCQ.nkring_entries(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int n) {
            return IOURingCQ.nkflags(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer koverflow(int n) {
            return IOURingCQ.nkoverflow(this.address(), n);
        }

        @NativeType(value="struct io_uring_cqe *")
        public IOURingCQE cqes() {
            return IOURingCQ.ncqes(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingCQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingCQ.nring_ptr(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_mask() {
            return IOURingCQ.nring_mask(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_entries() {
            return IOURingCQ.nring_entries(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkhead(this.address(), intBuffer);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nktail(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkring_mask(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkring_entries(this.address(), intBuffer);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkflags(this.address(), intBuffer);
            return this;
        }

        public Buffer koverflow(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingCQ.nkoverflow(this.address(), intBuffer);
            return this;
        }

        public Buffer cqes(@NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
            IOURingCQ.ncqes(this.address(), iOURingCQE);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
            IOURingCQ.nring_ptr(this.address(), byteBuffer);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="unsigned") int n) {
            IOURingCQ.nring_mask(this.address(), n);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="unsigned") int n) {
            IOURingCQ.nring_entries(this.address(), n);
            return this;
        }
    }
}

