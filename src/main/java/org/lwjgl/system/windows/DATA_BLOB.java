/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

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

public class DATA_BLOB
extends Struct<DATA_BLOB>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CBDATA;
    public static final int PBDATA;

    protected DATA_BLOB(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected DATA_BLOB create(long l, @Nullable ByteBuffer byteBuffer) {
        return new DATA_BLOB(l, byteBuffer);
    }

    public DATA_BLOB(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), DATA_BLOB.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int cbData() {
        return DATA_BLOB.ncbData(this.address());
    }

    @NativeType(value="BYTE *")
    public ByteBuffer pbData() {
        return DATA_BLOB.npbData(this.address());
    }

    public DATA_BLOB pbData(@NativeType(value="BYTE *") ByteBuffer byteBuffer) {
        DATA_BLOB.npbData(this.address(), byteBuffer);
        return this;
    }

    public DATA_BLOB set(DATA_BLOB dATA_BLOB) {
        MemoryUtil.memCopy(dATA_BLOB.address(), this.address(), SIZEOF);
        return this;
    }

    public static DATA_BLOB malloc() {
        return new DATA_BLOB(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static DATA_BLOB calloc() {
        return new DATA_BLOB(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static DATA_BLOB create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new DATA_BLOB(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static DATA_BLOB create(long l) {
        return new DATA_BLOB(l, null);
    }

    public static @Nullable DATA_BLOB createSafe(long l) {
        return l == 0L ? null : new DATA_BLOB(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(DATA_BLOB.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = DATA_BLOB.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static DATA_BLOB malloc(MemoryStack memoryStack) {
        return new DATA_BLOB(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static DATA_BLOB calloc(MemoryStack memoryStack) {
        return new DATA_BLOB(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ncbData(long l) {
        return MemoryUtil.memGetInt(l + (long)CBDATA);
    }

    public static ByteBuffer npbData(long l) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)PBDATA), DATA_BLOB.ncbData(l));
    }

    public static void ncbData(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CBDATA, n);
    }

    public static void npbData(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)PBDATA, MemoryUtil.memAddress(byteBuffer));
        DATA_BLOB.ncbData(l, byteBuffer.remaining());
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)PBDATA));
    }

    static {
        Struct.Layout layout = DATA_BLOB.__struct(DATA_BLOB.__member(4), DATA_BLOB.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CBDATA = layout.offsetof(0);
        PBDATA = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<DATA_BLOB, Buffer>
    implements NativeResource {
        private static final DATA_BLOB ELEMENT_FACTORY = DATA_BLOB.create(-1L);

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
        protected DATA_BLOB getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int cbData() {
            return DATA_BLOB.ncbData(this.address());
        }

        @NativeType(value="BYTE *")
        public ByteBuffer pbData() {
            return DATA_BLOB.npbData(this.address());
        }

        public Buffer pbData(@NativeType(value="BYTE *") ByteBuffer byteBuffer) {
            DATA_BLOB.npbData(this.address(), byteBuffer);
            return this;
        }
    }
}

