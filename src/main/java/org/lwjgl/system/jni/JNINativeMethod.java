/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jni;

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

public class JNINativeMethod
extends Struct<JNINativeMethod>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NAME;
    public static final int SIGNATURE;
    public static final int FNPTR;

    protected JNINativeMethod(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected JNINativeMethod create(long l, @Nullable ByteBuffer byteBuffer) {
        return new JNINativeMethod(l, byteBuffer);
    }

    public JNINativeMethod(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), JNINativeMethod.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="char *")
    public ByteBuffer name() {
        return JNINativeMethod.nname(this.address());
    }

    @NativeType(value="char *")
    public String nameString() {
        return JNINativeMethod.nnameString(this.address());
    }

    @NativeType(value="char *")
    public ByteBuffer signature() {
        return JNINativeMethod.nsignature(this.address());
    }

    @NativeType(value="char *")
    public String signatureString() {
        return JNINativeMethod.nsignatureString(this.address());
    }

    @NativeType(value="void *")
    public long fnPtr() {
        return JNINativeMethod.nfnPtr(this.address());
    }

    public JNINativeMethod name(@NativeType(value="char *") ByteBuffer byteBuffer) {
        JNINativeMethod.nname(this.address(), byteBuffer);
        return this;
    }

    public JNINativeMethod signature(@NativeType(value="char *") ByteBuffer byteBuffer) {
        JNINativeMethod.nsignature(this.address(), byteBuffer);
        return this;
    }

    public JNINativeMethod fnPtr(@NativeType(value="void *") long l) {
        JNINativeMethod.nfnPtr(this.address(), l);
        return this;
    }

    public JNINativeMethod set(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, long l) {
        this.name(byteBuffer);
        this.signature(byteBuffer2);
        this.fnPtr(l);
        return this;
    }

    public JNINativeMethod set(JNINativeMethod jNINativeMethod) {
        MemoryUtil.memCopy(jNINativeMethod.address(), this.address(), SIZEOF);
        return this;
    }

    public static JNINativeMethod malloc() {
        return new JNINativeMethod(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static JNINativeMethod calloc() {
        return new JNINativeMethod(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static JNINativeMethod create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new JNINativeMethod(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static JNINativeMethod create(long l) {
        return new JNINativeMethod(l, null);
    }

    public static @Nullable JNINativeMethod createSafe(long l) {
        return l == 0L ? null : new JNINativeMethod(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(JNINativeMethod.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = JNINativeMethod.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static JNINativeMethod mallocStack() {
        return JNINativeMethod.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod callocStack() {
        return JNINativeMethod.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static JNINativeMethod mallocStack(MemoryStack memoryStack) {
        return JNINativeMethod.malloc(memoryStack);
    }

    @Deprecated
    public static JNINativeMethod callocStack(MemoryStack memoryStack) {
        return JNINativeMethod.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return JNINativeMethod.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return JNINativeMethod.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return JNINativeMethod.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return JNINativeMethod.calloc(n, memoryStack);
    }

    public static JNINativeMethod malloc(MemoryStack memoryStack) {
        return new JNINativeMethod(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static JNINativeMethod calloc(MemoryStack memoryStack) {
        return new JNINativeMethod(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static ByteBuffer nname(long l) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l + (long)NAME));
    }

    public static String nnameString(long l) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l + (long)NAME));
    }

    public static ByteBuffer nsignature(long l) {
        return MemoryUtil.memByteBufferNT1(MemoryUtil.memGetAddress(l + (long)SIGNATURE));
    }

    public static String nsignatureString(long l) {
        return MemoryUtil.memUTF8(MemoryUtil.memGetAddress(l + (long)SIGNATURE));
    }

    public static long nfnPtr(long l) {
        return MemoryUtil.memGetAddress(l + (long)FNPTR);
    }

    public static void nname(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l + (long)NAME, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nsignature(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        MemoryUtil.memPutAddress(l + (long)SIGNATURE, MemoryUtil.memAddress(byteBuffer));
    }

    public static void nfnPtr(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)FNPTR, Checks.check(l2));
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)NAME));
        Checks.check(MemoryUtil.memGetAddress(l + (long)SIGNATURE));
        Checks.check(MemoryUtil.memGetAddress(l + (long)FNPTR));
    }

    static {
        Struct.Layout layout = JNINativeMethod.__struct(JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE), JNINativeMethod.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NAME = layout.offsetof(0);
        SIGNATURE = layout.offsetof(1);
        FNPTR = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<JNINativeMethod, Buffer>
    implements NativeResource {
        private static final JNINativeMethod ELEMENT_FACTORY = JNINativeMethod.create(-1L);

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
        protected JNINativeMethod getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="char *")
        public ByteBuffer name() {
            return JNINativeMethod.nname(this.address());
        }

        @NativeType(value="char *")
        public String nameString() {
            return JNINativeMethod.nnameString(this.address());
        }

        @NativeType(value="char *")
        public ByteBuffer signature() {
            return JNINativeMethod.nsignature(this.address());
        }

        @NativeType(value="char *")
        public String signatureString() {
            return JNINativeMethod.nsignatureString(this.address());
        }

        @NativeType(value="void *")
        public long fnPtr() {
            return JNINativeMethod.nfnPtr(this.address());
        }

        public Buffer name(@NativeType(value="char *") ByteBuffer byteBuffer) {
            JNINativeMethod.nname(this.address(), byteBuffer);
            return this;
        }

        public Buffer signature(@NativeType(value="char *") ByteBuffer byteBuffer) {
            JNINativeMethod.nsignature(this.address(), byteBuffer);
            return this;
        }

        public Buffer fnPtr(@NativeType(value="void *") long l) {
            JNINativeMethod.nfnPtr(this.address(), l);
            return this;
        }
    }
}

