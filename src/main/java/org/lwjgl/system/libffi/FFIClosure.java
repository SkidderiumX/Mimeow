/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.libffi.FFICIF;

@NativeType(value="struct ffi_closure")
public class FFIClosure
extends Struct<FFIClosure>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CIF;
    public static final int FUN;
    public static final int USER_DATA;

    private static native int offsets(long var0);

    protected FFIClosure(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected FFIClosure create(long l, @Nullable ByteBuffer byteBuffer) {
        return new FFIClosure(l, byteBuffer);
    }

    public FFIClosure(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFIClosure.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="ffi_cif *")
    public FFICIF cif() {
        return FFIClosure.ncif(this.address());
    }

    @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
    public long fun() {
        return FFIClosure.nfun(this.address());
    }

    @NativeType(value="void *")
    public long user_data() {
        return FFIClosure.nuser_data(this.address());
    }

    public static FFIClosure malloc() {
        return new FFIClosure(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFIClosure calloc() {
        return new FFIClosure(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFIClosure create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new FFIClosure(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFIClosure create(long l) {
        return new FFIClosure(l, null);
    }

    public static @Nullable FFIClosure createSafe(long l) {
        return l == 0L ? null : new FFIClosure(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFIClosure.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = FFIClosure.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FFIClosure malloc(MemoryStack memoryStack) {
        return new FFIClosure(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFIClosure calloc(MemoryStack memoryStack) {
        return new FFIClosure(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static FFICIF ncif(long l) {
        return FFICIF.create(MemoryUtil.memGetAddress(l + (long)CIF));
    }

    public static long nfun(long l) {
        return MemoryUtil.memGetAddress(l + (long)FUN);
    }

    public static long nuser_data(long l) {
        return MemoryUtil.memGetAddress(l + (long)USER_DATA);
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(4);
            SIZEOF = FFIClosure.offsets(MemoryUtil.memAddress(intBuffer));
            CIF = intBuffer.get(0);
            FUN = intBuffer.get(1);
            USER_DATA = intBuffer.get(2);
            ALIGNOF = intBuffer.get(3);
        }
    }

    public static class Buffer
    extends StructBuffer<FFIClosure, Buffer>
    implements NativeResource {
        private static final FFIClosure ELEMENT_FACTORY = FFIClosure.create(-1L);

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
        protected FFIClosure getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="ffi_cif *")
        public FFICIF cif() {
            return FFIClosure.ncif(this.address());
        }

        @NativeType(value="void (*)(ffi_cif*,void*,void**,void*)")
        public long fun() {
            return FFIClosure.nfun(this.address());
        }

        @NativeType(value="void *")
        public long user_data() {
            return FFIClosure.nuser_data(this.address());
        }
    }
}

