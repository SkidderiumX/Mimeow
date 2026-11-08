/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.macosx;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct objc_method_description")
public class ObjCMethodDescription
extends Struct<ObjCMethodDescription>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int TYPES;

    protected ObjCMethodDescription(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected ObjCMethodDescription create(long l, @Nullable ByteBuffer byteBuffer) {
        return new ObjCMethodDescription(l, byteBuffer);
    }

    public ObjCMethodDescription(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), ObjCMethodDescription.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="SEL")
    public long name() {
        return ObjCMethodDescription.nname(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer types() {
        return ObjCMethodDescription.ntypes(this.address());
    }

    @NativeType(value="char *")
    public String typesString() {
        return ObjCMethodDescription.ntypesString(this.address());
    }

    public static ObjCMethodDescription malloc() {
        return new ObjCMethodDescription(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static ObjCMethodDescription calloc() {
        return new ObjCMethodDescription(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static ObjCMethodDescription create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new ObjCMethodDescription(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static ObjCMethodDescription create(long l) {
        return new ObjCMethodDescription(l, null);
    }

    public static @Nullable ObjCMethodDescription createSafe(long l) {
        return l == 0L ? null : new ObjCMethodDescription(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(ObjCMethodDescription.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = ObjCMethodDescription.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack() {
        return ObjCMethodDescription.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription callocStack() {
        return ObjCMethodDescription.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static ObjCMethodDescription mallocStack(MemoryStack memoryStack) {
        return ObjCMethodDescription.malloc(memoryStack);
    }

    @Deprecated
    public static ObjCMethodDescription callocStack(MemoryStack memoryStack) {
        return ObjCMethodDescription.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return ObjCMethodDescription.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return ObjCMethodDescription.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return ObjCMethodDescription.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return ObjCMethodDescription.calloc(n, memoryStack);
    }

    public static ObjCMethodDescription malloc(MemoryStack memoryStack) {
        return new ObjCMethodDescription(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static ObjCMethodDescription calloc(MemoryStack memoryStack) {
        return new ObjCMethodDescription(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nname(long l) {
        return MemoryUtil.memGetAddress(l + (long)NAME);
    }

    public static ByteBuffer ntypes(long l) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l + (long)TYPES));
    }

    public static String ntypesString(long l) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l + (long)TYPES));
    }

    static {
        Struct.Layout layout = ObjCMethodDescription.__struct(ObjCMethodDescription.__member(POINTER_SIZE), ObjCMethodDescription.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        TYPES = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<ObjCMethodDescription, Buffer>
    implements NativeResource {
        private static final ObjCMethodDescription ELEMENT_FACTORY = ObjCMethodDescription.create(-1L);

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
        protected ObjCMethodDescription getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="SEL")
        public long name() {
            return ObjCMethodDescription.nname(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer types() {
            return ObjCMethodDescription.ntypes(this.address());
        }

        @NativeType(value="char *")
        public String typesString() {
            return ObjCMethodDescription.ntypesString(this.address());
        }
    }
}

