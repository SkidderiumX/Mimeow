/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

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

@NativeType(value="struct GLFWimage")
public class GLFWImage
extends Struct<GLFWImage>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int PIXELS;

    protected GLFWImage(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected GLFWImage create(long l, @Nullable ByteBuffer byteBuffer) {
        return new GLFWImage(l, byteBuffer);
    }

    public GLFWImage(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWImage.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int width() {
        return GLFWImage.nwidth(this.address());
    }

    public int height() {
        return GLFWImage.nheight(this.address());
    }

    @NativeType(value="unsigned char *")
    public ByteBuffer pixels(int n) {
        return GLFWImage.npixels(this.address(), n);
    }

    public GLFWImage width(int n) {
        GLFWImage.nwidth(this.address(), n);
        return this;
    }

    public GLFWImage height(int n) {
        GLFWImage.nheight(this.address(), n);
        return this;
    }

    public GLFWImage pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
        GLFWImage.npixels(this.address(), byteBuffer);
        return this;
    }

    public GLFWImage set(int n, int n2, ByteBuffer byteBuffer) {
        this.width(n);
        this.height(n2);
        this.pixels(byteBuffer);
        return this;
    }

    public GLFWImage set(GLFWImage gLFWImage) {
        MemoryUtil.memCopy(gLFWImage.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWImage malloc() {
        return new GLFWImage(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static GLFWImage calloc() {
        return new GLFWImage(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static GLFWImage create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new GLFWImage(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWImage create(long l) {
        return new GLFWImage(l, null);
    }

    public static @Nullable GLFWImage createSafe(long l) {
        return l == 0L ? null : new GLFWImage(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(GLFWImage.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = GLFWImage.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static GLFWImage mallocStack() {
        return GLFWImage.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWImage callocStack() {
        return GLFWImage.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static GLFWImage mallocStack(MemoryStack memoryStack) {
        return GLFWImage.malloc(memoryStack);
    }

    @Deprecated
    public static GLFWImage callocStack(MemoryStack memoryStack) {
        return GLFWImage.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return GLFWImage.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return GLFWImage.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return GLFWImage.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return GLFWImage.calloc(n, memoryStack);
    }

    public static GLFWImage malloc(MemoryStack memoryStack) {
        return new GLFWImage(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static GLFWImage calloc(MemoryStack memoryStack) {
        return new GLFWImage(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nwidth(long l) {
        return MemoryUtil.memGetInt(l + (long)WIDTH);
    }

    public static int nheight(long l) {
        return MemoryUtil.memGetInt(l + (long)HEIGHT);
    }

    public static ByteBuffer npixels(long l, int n) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)PIXELS), n);
    }

    public static void nwidth(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WIDTH, n);
    }

    public static void nheight(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HEIGHT, n);
    }

    public static void npixels(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)PIXELS, MemoryUtil.memAddress(byteBuffer));
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)PIXELS));
    }

    static {
        Struct.Layout layout = GLFWImage.__struct(GLFWImage.__member(4), GLFWImage.__member(4), GLFWImage.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        PIXELS = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<GLFWImage, Buffer>
    implements NativeResource {
        private static final GLFWImage ELEMENT_FACTORY = GLFWImage.create(-1L);

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
        protected GLFWImage getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int width() {
            return GLFWImage.nwidth(this.address());
        }

        public int height() {
            return GLFWImage.nheight(this.address());
        }

        @NativeType(value="unsigned char *")
        public ByteBuffer pixels(int n) {
            return GLFWImage.npixels(this.address(), n);
        }

        public Buffer width(int n) {
            GLFWImage.nwidth(this.address(), n);
            return this;
        }

        public Buffer height(int n) {
            GLFWImage.nheight(this.address(), n);
            return this;
        }

        public Buffer pixels(@NativeType(value="unsigned char *") ByteBuffer byteBuffer) {
            GLFWImage.npixels(this.address(), byteBuffer);
            return this;
        }
    }
}

