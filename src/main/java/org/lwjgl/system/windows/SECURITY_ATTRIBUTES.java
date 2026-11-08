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

public class SECURITY_ATTRIBUTES
extends Struct<SECURITY_ATTRIBUTES>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NLENGTH;
    public static final int LPSECURITYDESCRIPTOR;
    public static final int BINHERITHANDLE;

    protected SECURITY_ATTRIBUTES(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected SECURITY_ATTRIBUTES create(long l, @Nullable ByteBuffer byteBuffer) {
        return new SECURITY_ATTRIBUTES(l, byteBuffer);
    }

    public SECURITY_ATTRIBUTES(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), SECURITY_ATTRIBUTES.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int nLength() {
        return SECURITY_ATTRIBUTES.nnLength(this.address());
    }

    @NativeType(value="LPVOID")
    public long lpSecurityDescriptor() {
        return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
    }

    @NativeType(value="BOOL")
    public boolean bInheritHandle() {
        return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
    }

    public SECURITY_ATTRIBUTES nLength(@NativeType(value="DWORD") int n) {
        SECURITY_ATTRIBUTES.nnLength(this.address(), n);
        return this;
    }

    public SECURITY_ATTRIBUTES lpSecurityDescriptor(@NativeType(value="LPVOID") long l) {
        SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), l);
        return this;
    }

    public SECURITY_ATTRIBUTES bInheritHandle(@NativeType(value="BOOL") boolean bl) {
        SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), bl ? 1 : 0);
        return this;
    }

    public SECURITY_ATTRIBUTES set(int n, long l, boolean bl) {
        this.nLength(n);
        this.lpSecurityDescriptor(l);
        this.bInheritHandle(bl);
        return this;
    }

    public SECURITY_ATTRIBUTES set(SECURITY_ATTRIBUTES sECURITY_ATTRIBUTES) {
        MemoryUtil.memCopy(sECURITY_ATTRIBUTES.address(), this.address(), SIZEOF);
        return this;
    }

    public static SECURITY_ATTRIBUTES malloc() {
        return new SECURITY_ATTRIBUTES(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES calloc() {
        return new SECURITY_ATTRIBUTES(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new SECURITY_ATTRIBUTES(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static SECURITY_ATTRIBUTES create(long l) {
        return new SECURITY_ATTRIBUTES(l, null);
    }

    public static @Nullable SECURITY_ATTRIBUTES createSafe(long l) {
        return l == 0L ? null : new SECURITY_ATTRIBUTES(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(SECURITY_ATTRIBUTES.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = SECURITY_ATTRIBUTES.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES mallocStack() {
        return SECURITY_ATTRIBUTES.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack() {
        return SECURITY_ATTRIBUTES.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES mallocStack(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.malloc(memoryStack);
    }

    @Deprecated
    public static SECURITY_ATTRIBUTES callocStack(MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return SECURITY_ATTRIBUTES.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return SECURITY_ATTRIBUTES.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return SECURITY_ATTRIBUTES.calloc(n, memoryStack);
    }

    public static SECURITY_ATTRIBUTES malloc(MemoryStack memoryStack) {
        return new SECURITY_ATTRIBUTES(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static SECURITY_ATTRIBUTES calloc(MemoryStack memoryStack) {
        return new SECURITY_ATTRIBUTES(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nnLength(long l) {
        return MemoryUtil.memGetInt(l + (long)NLENGTH);
    }

    public static long nlpSecurityDescriptor(long l) {
        return MemoryUtil.memGetAddress(l + (long)LPSECURITYDESCRIPTOR);
    }

    public static int nbInheritHandle(long l) {
        return MemoryUtil.memGetInt(l + (long)BINHERITHANDLE);
    }

    public static void nnLength(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NLENGTH, n);
    }

    public static void nlpSecurityDescriptor(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)LPSECURITYDESCRIPTOR, Checks.check(l2));
    }

    public static void nbInheritHandle(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BINHERITHANDLE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)LPSECURITYDESCRIPTOR));
    }

    static {
        Struct.Layout layout = SECURITY_ATTRIBUTES.__struct(SECURITY_ATTRIBUTES.__member(4), SECURITY_ATTRIBUTES.__member(POINTER_SIZE), SECURITY_ATTRIBUTES.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NLENGTH = layout.offsetof(0);
        LPSECURITYDESCRIPTOR = layout.offsetof(1);
        BINHERITHANDLE = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<SECURITY_ATTRIBUTES, Buffer>
    implements NativeResource {
        private static final SECURITY_ATTRIBUTES ELEMENT_FACTORY = SECURITY_ATTRIBUTES.create(-1L);

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
        protected SECURITY_ATTRIBUTES getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int nLength() {
            return SECURITY_ATTRIBUTES.nnLength(this.address());
        }

        @NativeType(value="LPVOID")
        public long lpSecurityDescriptor() {
            return SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address());
        }

        @NativeType(value="BOOL")
        public boolean bInheritHandle() {
            return SECURITY_ATTRIBUTES.nbInheritHandle(this.address()) != 0;
        }

        public Buffer nLength(@NativeType(value="DWORD") int n) {
            SECURITY_ATTRIBUTES.nnLength(this.address(), n);
            return this;
        }

        public Buffer lpSecurityDescriptor(@NativeType(value="LPVOID") long l) {
            SECURITY_ATTRIBUTES.nlpSecurityDescriptor(this.address(), l);
            return this;
        }

        public Buffer bInheritHandle(@NativeType(value="BOOL") boolean bl) {
            SECURITY_ATTRIBUTES.nbInheritHandle(this.address(), bl ? 1 : 0);
            return this;
        }
    }
}

