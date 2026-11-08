/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFIType;

@NativeType(value="struct ffi_cif")
public class FFICIF
extends Struct<FFICIF>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ABI;
    public static final int NARGS;
    public static final int ARG_TYPES;
    public static final int RTYPE;
    public static final int BYTES;
    public static final int FLAGS;

    private static native int offsets(long var0);

    protected FFICIF(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected FFICIF create(long l, @Nullable ByteBuffer byteBuffer) {
        return new FFICIF(l, byteBuffer);
    }

    public FFICIF(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFICIF.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_abi")
    public int abi() {
        return FFICIF.nabi(this.address());
    }

    @NativeType(value="unsigned")
    public int nargs() {
        return FFICIF.nnargs(this.address());
    }

    @NativeType(value="ffi_type **")
    public PointerBuffer arg_types(int n) {
        return FFICIF.narg_types(this.address(), n);
    }

    @NativeType(value="ffi_type *")
    public FFIType rtype() {
        return FFICIF.nrtype(this.address());
    }

    @NativeType(value="unsigned")
    public int bytes() {
        return FFICIF.nbytes(this.address());
    }

    @NativeType(value="unsigned")
    public int flags() {
        return FFICIF.nflags(this.address());
    }

    public static FFICIF malloc() {
        return new FFICIF(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFICIF calloc() {
        return new FFICIF(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFICIF create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new FFICIF(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFICIF create(long l) {
        return new FFICIF(l, null);
    }

    public static @Nullable FFICIF createSafe(long l) {
        return l == 0L ? null : new FFICIF(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFICIF.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = FFICIF.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FFICIF malloc(MemoryStack memoryStack) {
        return new FFICIF(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFICIF calloc(MemoryStack memoryStack) {
        return new FFICIF(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nabi(long l) {
        return MemoryUtil.memGetInt(l + (long)ABI);
    }

    public static int nnargs(long l) {
        return MemoryUtil.memGetInt(l + (long)NARGS);
    }

    public static PointerBuffer narg_types(long l, int n) {
        return MemoryUtil.memPointerBuffer(MemoryUtil.memGetAddress(l + (long)ARG_TYPES), n);
    }

    public static FFIType nrtype(long l) {
        return FFIType.create(MemoryUtil.memGetAddress(l + (long)RTYPE));
    }

    public static int nbytes(long l) {
        return MemoryUtil.memGetInt(l + (long)BYTES);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(7);
            SIZEOF = FFICIF.offsets(MemoryUtil.memAddress(intBuffer));
            ABI = intBuffer.get(0);
            NARGS = intBuffer.get(1);
            ARG_TYPES = intBuffer.get(2);
            RTYPE = intBuffer.get(3);
            BYTES = intBuffer.get(4);
            FLAGS = intBuffer.get(5);
            ALIGNOF = intBuffer.get(6);
        }
    }

    public static class Buffer
    extends StructBuffer<FFICIF, Buffer>
    implements NativeResource {
        private static final FFICIF ELEMENT_FACTORY = FFICIF.create(-1L);

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
        protected FFICIF getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_abi")
        public int abi() {
            return FFICIF.nabi(this.address());
        }

        @NativeType(value="unsigned")
        public int nargs() {
            return FFICIF.nnargs(this.address());
        }

        @NativeType(value="ffi_type **")
        public PointerBuffer arg_types(int n) {
            return FFICIF.narg_types(this.address(), n);
        }

        @NativeType(value="ffi_type *")
        public FFIType rtype() {
            return FFICIF.nrtype(this.address());
        }

        @NativeType(value="unsigned")
        public int bytes() {
            return FFICIF.nbytes(this.address());
        }

        @NativeType(value="unsigned")
        public int flags() {
            return FFICIF.nflags(this.address());
        }
    }
}

