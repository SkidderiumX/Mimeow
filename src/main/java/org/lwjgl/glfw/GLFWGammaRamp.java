/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWgammaramp")
public class GLFWGammaRamp
extends Struct<GLFWGammaRamp>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RED;
    public static final int GREEN;
    public static final int BLUE;
    public static final int SIZE;

    protected GLFWGammaRamp(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected GLFWGammaRamp create(long l, @Nullable ByteBuffer byteBuffer) {
        return new GLFWGammaRamp(l, byteBuffer);
    }

    public GLFWGammaRamp(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWGammaRamp.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer red() {
        return GLFWGammaRamp.nred(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer green() {
        return GLFWGammaRamp.ngreen(this.address());
    }

    @NativeType(value="unsigned short *")
    public ShortBuffer blue() {
        return GLFWGammaRamp.nblue(this.address());
    }

    @NativeType(value="unsigned int")
    public int size() {
        return GLFWGammaRamp.nsize(this.address());
    }

    public GLFWGammaRamp red(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.nred(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp green(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.ngreen(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp blue(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        GLFWGammaRamp.nblue(this.address(), shortBuffer);
        return this;
    }

    public GLFWGammaRamp size(@NativeType(value="unsigned int") int n) {
        GLFWGammaRamp.nsize(this.address(), n);
        return this;
    }

    public GLFWGammaRamp set(ShortBuffer shortBuffer, ShortBuffer shortBuffer2, ShortBuffer shortBuffer3, int n) {
        this.red(shortBuffer);
        this.green(shortBuffer2);
        this.blue(shortBuffer3);
        this.size(n);
        return this;
    }

    public GLFWGammaRamp set(GLFWGammaRamp gLFWGammaRamp) {
        MemoryUtil.memCopy(gLFWGammaRamp.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWGammaRamp malloc() {
        return new GLFWGammaRamp(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static GLFWGammaRamp calloc() {
        return new GLFWGammaRamp(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static GLFWGammaRamp create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new GLFWGammaRamp(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWGammaRamp create(long l) {
        return new GLFWGammaRamp(l, null);
    }

    public static @Nullable GLFWGammaRamp createSafe(long l) {
        return l == 0L ? null : new GLFWGammaRamp(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(GLFWGammaRamp.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = GLFWGammaRamp.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static GLFWGammaRamp mallocStack() {
        return GLFWGammaRamp.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGammaRamp callocStack() {
        return GLFWGammaRamp.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWGammaRamp mallocStack(MemoryStack memoryStack) {
        return GLFWGammaRamp.malloc(memoryStack);
    }

    @Deprecated
    public static GLFWGammaRamp callocStack(MemoryStack memoryStack) {
        return GLFWGammaRamp.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return GLFWGammaRamp.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return GLFWGammaRamp.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return GLFWGammaRamp.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return GLFWGammaRamp.calloc(n, memoryStack);
    }

    public static GLFWGammaRamp malloc(MemoryStack memoryStack) {
        return new GLFWGammaRamp(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static GLFWGammaRamp calloc(MemoryStack memoryStack) {
        return new GLFWGammaRamp(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static ShortBuffer nred(long l) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l + (long)RED), GLFWGammaRamp.nsize(l));
    }

    public static ShortBuffer ngreen(long l) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l + (long)GREEN), GLFWGammaRamp.nsize(l));
    }

    public static ShortBuffer nblue(long l) {
        return MemoryUtil.memShortBuffer(MemoryUtil.memGetAddress(l + (long)BLUE), GLFWGammaRamp.nsize(l));
    }

    public static int nsize(long l) {
        return MemoryUtil.memGetInt(l + (long)SIZE);
    }

    public static void nred(long l, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l + (long)RED, MemoryUtil.memAddress(shortBuffer));
    }

    public static void ngreen(long l, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l + (long)GREEN, MemoryUtil.memAddress(shortBuffer));
    }

    public static void nblue(long l, ShortBuffer shortBuffer) {
        MemoryUtil.memPutAddress(l + (long)BLUE, MemoryUtil.memAddress(shortBuffer));
    }

    public static void nsize(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SIZE, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)RED));
        Checks.check(MemoryUtil.memGetAddress(l + (long)GREEN));
        Checks.check(MemoryUtil.memGetAddress(l + (long)BLUE));
    }

    static {
        Struct.Layout layout = GLFWGammaRamp.__struct(GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(POINTER_SIZE), GLFWGammaRamp.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RED = layout.offsetof(0);
        GREEN = layout.offsetof(1);
        BLUE = layout.offsetof(2);
        SIZE = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<GLFWGammaRamp, Buffer>
    implements NativeResource {
        private static final GLFWGammaRamp ELEMENT_FACTORY = GLFWGammaRamp.create(-1L);

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
        protected GLFWGammaRamp getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer red() {
            return GLFWGammaRamp.nred(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer green() {
            return GLFWGammaRamp.ngreen(this.address());
        }

        @NativeType(value="unsigned short *")
        public ShortBuffer blue() {
            return GLFWGammaRamp.nblue(this.address());
        }

        @NativeType(value="unsigned int")
        public int size() {
            return GLFWGammaRamp.nsize(this.address());
        }

        public Buffer red(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.nred(this.address(), shortBuffer);
            return this;
        }

        public Buffer green(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.ngreen(this.address(), shortBuffer);
            return this;
        }

        public Buffer blue(@NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
            GLFWGammaRamp.nblue(this.address(), shortBuffer);
            return this;
        }

        public Buffer size(@NativeType(value="unsigned int") int n) {
            GLFWGammaRamp.nsize(this.address(), n);
            return this;
        }
    }
}

