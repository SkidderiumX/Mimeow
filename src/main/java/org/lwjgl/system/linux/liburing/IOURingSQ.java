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
import org.lwjgl.system.linux.liburing.IOURingSQE;

@NativeType(value="struct io_uring_sq")
public class IOURingSQ
extends Struct<IOURingSQ>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int KHEAD;
    public static final int KTAIL;
    public static final int KRING_MASK;
    public static final int KRING_ENTRIES;
    public static final int KFLAGS;
    public static final int KDROPPED;
    public static final int ARRAY;
    public static final int SQES;
    public static final int SQE_HEAD;
    public static final int SQE_TAIL;
    public static final int RING_SZ;
    public static final int RING_PTR;
    public static final int RING_MASK;
    public static final int RING_ENTRIES;
    public static final int PAD;

    protected IOURingSQ(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingSQ create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingSQ(l, byteBuffer);
    }

    public IOURingSQ(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingSQ.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned *")
    public IntBuffer khead(int n) {
        return IOURingSQ.nkhead(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer ktail(int n) {
        return IOURingSQ.nktail(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_mask(int n) {
        return IOURingSQ.nkring_mask(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kring_entries(int n) {
        return IOURingSQ.nkring_entries(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kflags(int n) {
        return IOURingSQ.nkflags(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer kdropped(int n) {
        return IOURingSQ.nkdropped(this.address(), n);
    }

    @NativeType(value="unsigned *")
    public IntBuffer array(int n) {
        return IOURingSQ.narray(this.address(), n);
    }

    @NativeType(value="struct io_uring_sqe *")
    public IOURingSQE sqes() {
        return IOURingSQ.nsqes(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_head() {
        return IOURingSQ.nsqe_head(this.address());
    }

    @NativeType(value="unsigned")
    public int sqe_tail() {
        return IOURingSQ.nsqe_tail(this.address());
    }

    @NativeType(value="size_t")
    public long ring_sz() {
        return IOURingSQ.nring_sz(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer ring_ptr() {
        return IOURingSQ.nring_ptr(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_mask() {
        return IOURingSQ.nring_mask(this.address());
    }

    @NativeType(value="unsigned")
    public int ring_entries() {
        return IOURingSQ.nring_entries(this.address());
    }

    public IOURingSQ khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkhead(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nktail(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkring_mask(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkring_entries(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkflags(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ kdropped(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.nkdropped(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ array(@NativeType(value="unsigned *") IntBuffer intBuffer) {
        IOURingSQ.narray(this.address(), intBuffer);
        return this;
    }

    public IOURingSQ sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
        IOURingSQ.nsqes(this.address(), iOURingSQE);
        return this;
    }

    public IOURingSQ sqe_head(@NativeType(value="unsigned") int n) {
        IOURingSQ.nsqe_head(this.address(), n);
        return this;
    }

    public IOURingSQ sqe_tail(@NativeType(value="unsigned") int n) {
        IOURingSQ.nsqe_tail(this.address(), n);
        return this;
    }

    public IOURingSQ ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
        IOURingSQ.nring_ptr(this.address(), byteBuffer);
        return this;
    }

    public IOURingSQ ring_mask(@NativeType(value="unsigned") int n) {
        IOURingSQ.nring_mask(this.address(), n);
        return this;
    }

    public IOURingSQ ring_entries(@NativeType(value="unsigned") int n) {
        IOURingSQ.nring_entries(this.address(), n);
        return this;
    }

    public IOURingSQ set(IntBuffer intBuffer, IntBuffer intBuffer2, IntBuffer intBuffer3, IntBuffer intBuffer4, IntBuffer intBuffer5, IntBuffer intBuffer6, IntBuffer intBuffer7, IOURingSQE iOURingSQE, int n, int n2, ByteBuffer byteBuffer, int n3, int n4) {
        this.khead(intBuffer);
        this.ktail(intBuffer2);
        this.kring_mask(intBuffer3);
        this.kring_entries(intBuffer4);
        this.kflags(intBuffer5);
        this.kdropped(intBuffer6);
        this.array(intBuffer7);
        this.sqes(iOURingSQE);
        this.sqe_head(n);
        this.sqe_tail(n2);
        this.ring_ptr(byteBuffer);
        this.ring_mask(n3);
        this.ring_entries(n4);
        return this;
    }

    public IOURingSQ set(IOURingSQ iOURingSQ) {
        MemoryUtil.memCopy(iOURingSQ.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQ malloc() {
        return new IOURingSQ(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSQ calloc() {
        return new IOURingSQ(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSQ create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSQ(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingSQ create(long l) {
        return new IOURingSQ(l, null);
    }

    public static @Nullable IOURingSQ createSafe(long l) {
        return l == 0L ? null : new IOURingSQ(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSQ.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingSQ.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingSQ malloc(MemoryStack memoryStack) {
        return new IOURingSQ(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSQ calloc(MemoryStack memoryStack) {
        return new IOURingSQ(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static IntBuffer nkdropped(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)KDROPPED), n);
    }

    public static IntBuffer narray(long l, int n) {
        return MemoryUtil.memIntBuffer(MemoryUtil.memGetAddress(l + (long)ARRAY), n);
    }

    public static IOURingSQE nsqes(long l) {
        return IOURingSQE.create(MemoryUtil.memGetAddress(l + (long)SQES));
    }

    public static int nsqe_head(long l) {
        return MemoryUtil.memGetInt(l + (long)SQE_HEAD);
    }

    public static int nsqe_tail(long l) {
        return MemoryUtil.memGetInt(l + (long)SQE_TAIL);
    }

    public static long nring_sz(long l) {
        return MemoryUtil.memGetAddress(l + (long)RING_SZ);
    }

    public static ByteBuffer nring_ptr(long l) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)RING_PTR), (int)IOURingSQ.nring_sz(l));
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

    public static void nkdropped(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)KDROPPED, MemoryUtil.memAddress(intBuffer));
    }

    public static void narray(long l, IntBuffer intBuffer) {
        MemoryUtil.memPutAddress(l + (long)ARRAY, MemoryUtil.memAddress(intBuffer));
    }

    public static void nsqes(long l, IOURingSQE iOURingSQE) {
        MemoryUtil.memPutAddress(l + (long)SQES, iOURingSQE.address());
    }

    public static void nsqe_head(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SQE_HEAD, n);
    }

    public static void nsqe_tail(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SQE_TAIL, n);
    }

    public static void nring_sz(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)RING_SZ, l2);
    }

    public static void nring_ptr(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)RING_PTR, MemoryUtil.memAddress(byteBuffer));
        IOURingSQ.nring_sz(l, byteBuffer.remaining());
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
        Checks.check(MemoryUtil.memGetAddress(l + (long)KDROPPED));
        Checks.check(MemoryUtil.memGetAddress(l + (long)ARRAY));
        Checks.check(MemoryUtil.memGetAddress(l + (long)SQES));
        Checks.check(MemoryUtil.memGetAddress(l + (long)RING_PTR));
    }

    static {
        Struct.Layout layout = IOURingSQ.__struct(IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(4), IOURingSQ.__member(4), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(POINTER_SIZE), IOURingSQ.__member(4), IOURingSQ.__member(4), IOURingSQ.__array(4, 2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        KHEAD = layout.offsetof(0);
        KTAIL = layout.offsetof(1);
        KRING_MASK = layout.offsetof(2);
        KRING_ENTRIES = layout.offsetof(3);
        KFLAGS = layout.offsetof(4);
        KDROPPED = layout.offsetof(5);
        ARRAY = layout.offsetof(6);
        SQES = layout.offsetof(7);
        SQE_HEAD = layout.offsetof(8);
        SQE_TAIL = layout.offsetof(9);
        RING_SZ = layout.offsetof(10);
        RING_PTR = layout.offsetof(11);
        RING_MASK = layout.offsetof(12);
        RING_ENTRIES = layout.offsetof(13);
        PAD = layout.offsetof(14);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQ, Buffer>
    implements NativeResource {
        private static final IOURingSQ ELEMENT_FACTORY = IOURingSQ.create(-1L);

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
        protected IOURingSQ getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned *")
        public IntBuffer khead(int n) {
            return IOURingSQ.nkhead(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer ktail(int n) {
            return IOURingSQ.nktail(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_mask(int n) {
            return IOURingSQ.nkring_mask(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kring_entries(int n) {
            return IOURingSQ.nkring_entries(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kflags(int n) {
            return IOURingSQ.nkflags(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer kdropped(int n) {
            return IOURingSQ.nkdropped(this.address(), n);
        }

        @NativeType(value="unsigned *")
        public IntBuffer array(int n) {
            return IOURingSQ.narray(this.address(), n);
        }

        @NativeType(value="struct io_uring_sqe *")
        public IOURingSQE sqes() {
            return IOURingSQ.nsqes(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_head() {
            return IOURingSQ.nsqe_head(this.address());
        }

        @NativeType(value="unsigned")
        public int sqe_tail() {
            return IOURingSQ.nsqe_tail(this.address());
        }

        @NativeType(value="size_t")
        public long ring_sz() {
            return IOURingSQ.nring_sz(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer ring_ptr() {
            return IOURingSQ.nring_ptr(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_mask() {
            return IOURingSQ.nring_mask(this.address());
        }

        @NativeType(value="unsigned")
        public int ring_entries() {
            return IOURingSQ.nring_entries(this.address());
        }

        public Buffer khead(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkhead(this.address(), intBuffer);
            return this;
        }

        public Buffer ktail(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nktail(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_mask(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkring_mask(this.address(), intBuffer);
            return this;
        }

        public Buffer kring_entries(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkring_entries(this.address(), intBuffer);
            return this;
        }

        public Buffer kflags(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkflags(this.address(), intBuffer);
            return this;
        }

        public Buffer kdropped(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.nkdropped(this.address(), intBuffer);
            return this;
        }

        public Buffer array(@NativeType(value="unsigned *") IntBuffer intBuffer) {
            IOURingSQ.narray(this.address(), intBuffer);
            return this;
        }

        public Buffer sqes(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
            IOURingSQ.nsqes(this.address(), iOURingSQE);
            return this;
        }

        public Buffer sqe_head(@NativeType(value="unsigned") int n) {
            IOURingSQ.nsqe_head(this.address(), n);
            return this;
        }

        public Buffer sqe_tail(@NativeType(value="unsigned") int n) {
            IOURingSQ.nsqe_tail(this.address(), n);
            return this;
        }

        public Buffer ring_ptr(@NativeType(value="void *") ByteBuffer byteBuffer) {
            IOURingSQ.nring_ptr(this.address(), byteBuffer);
            return this;
        }

        public Buffer ring_mask(@NativeType(value="unsigned") int n) {
            IOURingSQ.nring_mask(this.address(), n);
            return this;
        }

        public Buffer ring_entries(@NativeType(value="unsigned") int n) {
            IOURingSQ.nring_entries(this.address(), n);
            return this;
        }
    }
}

