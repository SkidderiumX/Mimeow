/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.libffi;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct ffi_type")
public class FFIType
extends Struct<FFIType>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SIZE;
    public static final int ALIGNMENT;
    public static final int TYPE;
    public static final int ELEMENTS;

    protected FFIType(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected FFIType create(long l, @Nullable ByteBuffer byteBuffer) {
        return new FFIType(l, byteBuffer);
    }

    public FFIType(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FFIType.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="size_t")
    public long size() {
        return FFIType.nsize(this.address());
    }

    @NativeType(value="unsigned short")
    public short alignment() {
        return FFIType.nalignment(this.address());
    }

    @NativeType(value="unsigned short")
    public short type() {
        return FFIType.ntype(this.address());
    }

    @NativeType(value="ffi_type *")
    public @Nullable PointerBuffer elements(int n) {
        return FFIType.nelements(this.address(), n);
    }

    public FFIType size(@NativeType(value="size_t") long l) {
        FFIType.nsize(this.address(), l);
        return this;
    }

    public FFIType alignment(@NativeType(value="unsigned short") short s) {
        FFIType.nalignment(this.address(), s);
        return this;
    }

    public FFIType type(@NativeType(value="unsigned short") short s) {
        FFIType.ntype(this.address(), s);
        return this;
    }

    public FFIType elements(@NativeType(value="ffi_type *") @Nullable PointerBuffer pointerBuffer) {
        FFIType.nelements(this.address(), pointerBuffer);
        return this;
    }

    public FFIType set(long l, short s, short s2, @Nullable PointerBuffer pointerBuffer) {
        this.size(l);
        this.alignment(s);
        this.type(s2);
        this.elements(pointerBuffer);
        return this;
    }

    public FFIType set(FFIType fFIType) {
        MemoryUtil.memCopy(fFIType.address(), this.address(), SIZEOF);
        return this;
    }

    public static FFIType malloc() {
        return new FFIType(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FFIType calloc() {
        return new FFIType(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FFIType create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new FFIType(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FFIType create(long l) {
        return new FFIType(l, null);
    }

    public static @Nullable FFIType createSafe(long l) {
        return l == 0L ? null : new FFIType(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FFIType.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = FFIType.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FFIType malloc(MemoryStack memoryStack) {
        return new FFIType(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FFIType calloc(MemoryStack memoryStack) {
        return new FFIType(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nsize(long l) {
        return MemoryUtil.memGetAddress(l + (long)SIZE);
    }

    public static short nalignment(long l) {
        return MemoryUtil.memGetShort(l + (long)ALIGNMENT);
    }

    public static short ntype(long l) {
        return MemoryUtil.memGetShort(l + (long)TYPE);
    }

    public static @Nullable PointerBuffer nelements(long l, int n) {
        return MemoryUtil.memPointerBufferSafe(MemoryUtil.memGetAddress(l + (long)ELEMENTS), n);
    }

    public static void nsize(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)SIZE, l2);
    }

    public static void nalignment(long l, short s) {
        MemoryUtil.memPutShort(l + (long)ALIGNMENT, s);
    }

    public static void ntype(long l, short s) {
        MemoryUtil.memPutShort(l + (long)TYPE, s);
    }

    public static void nelements(long l, @Nullable PointerBuffer pointerBuffer) {
        MemoryUtil.memPutAddress(l + (long)ELEMENTS, MemoryUtil.memAddressSafe(pointerBuffer));
    }

    static {
        Struct.Layout layout = FFIType.__struct(FFIType.__member(POINTER_SIZE), FFIType.__member(2), FFIType.__member(2), FFIType.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SIZE = layout.offsetof(0);
        ALIGNMENT = layout.offsetof(1);
        TYPE = layout.offsetof(2);
        ELEMENTS = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<FFIType, Buffer>
    implements NativeResource {
        private static final FFIType ELEMENT_FACTORY = FFIType.create(-1L);

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
        protected FFIType getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="size_t")
        public long size() {
            return FFIType.nsize(this.address());
        }

        @NativeType(value="unsigned short")
        public short alignment() {
            return FFIType.nalignment(this.address());
        }

        @NativeType(value="unsigned short")
        public short type() {
            return FFIType.ntype(this.address());
        }

        @NativeType(value="ffi_type *")
        public @Nullable PointerBuffer elements(int n) {
            return FFIType.nelements(this.address(), n);
        }

        public Buffer size(@NativeType(value="size_t") long l) {
            FFIType.nsize(this.address(), l);
            return this;
        }

        public Buffer alignment(@NativeType(value="unsigned short") short s) {
            FFIType.nalignment(this.address(), s);
            return this;
        }

        public Buffer type(@NativeType(value="unsigned short") short s) {
            FFIType.ntype(this.address(), s);
            return this;
        }

        public Buffer elements(@NativeType(value="ffi_type *") @Nullable PointerBuffer pointerBuffer) {
            FFIType.nelements(this.address(), pointerBuffer);
            return this;
        }
    }
}

