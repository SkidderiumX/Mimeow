/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.glfw.GLFWAllocateCallback;
import org.lwjgl.glfw.GLFWAllocateCallbackI;
import org.lwjgl.glfw.GLFWDeallocateCallback;
import org.lwjgl.glfw.GLFWDeallocateCallbackI;
import org.lwjgl.glfw.GLFWReallocateCallback;
import org.lwjgl.glfw.GLFWReallocateCallbackI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct GLFWallocator")
public class GLFWAllocator
extends Struct<GLFWAllocator>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int ALLOCATE;
    public static final int REALLOCATE;
    public static final int DEALLOCATE;
    public static final int USER;

    protected GLFWAllocator(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected GLFWAllocator create(long l, @Nullable ByteBuffer byteBuffer) {
        return new GLFWAllocator(l, byteBuffer);
    }

    public GLFWAllocator(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), GLFWAllocator.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="GLFWallocatefun")
    public GLFWAllocateCallback allocate() {
        return GLFWAllocator.nallocate(this.address());
    }

    @NativeType(value="GLFWreallocatefun")
    public GLFWReallocateCallback reallocate() {
        return GLFWAllocator.nreallocate(this.address());
    }

    @NativeType(value="GLFWdeallocatefun")
    public GLFWDeallocateCallback deallocate() {
        return GLFWAllocator.ndeallocate(this.address());
    }

    @NativeType(value="void *")
    public long user() {
        return GLFWAllocator.nuser(this.address());
    }

    public GLFWAllocator allocate(@NativeType(value="GLFWallocatefun") GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        GLFWAllocator.nallocate(this.address(), gLFWAllocateCallbackI);
        return this;
    }

    public GLFWAllocator reallocate(@NativeType(value="GLFWreallocatefun") GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        GLFWAllocator.nreallocate(this.address(), gLFWReallocateCallbackI);
        return this;
    }

    public GLFWAllocator deallocate(@NativeType(value="GLFWdeallocatefun") GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        GLFWAllocator.ndeallocate(this.address(), gLFWDeallocateCallbackI);
        return this;
    }

    public GLFWAllocator user(@NativeType(value="void *") long l) {
        GLFWAllocator.nuser(this.address(), l);
        return this;
    }

    public GLFWAllocator set(GLFWAllocateCallbackI gLFWAllocateCallbackI, GLFWReallocateCallbackI gLFWReallocateCallbackI, GLFWDeallocateCallbackI gLFWDeallocateCallbackI, long l) {
        this.allocate(gLFWAllocateCallbackI);
        this.reallocate(gLFWReallocateCallbackI);
        this.deallocate(gLFWDeallocateCallbackI);
        this.user(l);
        return this;
    }

    public GLFWAllocator set(GLFWAllocator gLFWAllocator) {
        MemoryUtil.memCopy(gLFWAllocator.address(), this.address(), SIZEOF);
        return this;
    }

    public static GLFWAllocator malloc() {
        return new GLFWAllocator(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static GLFWAllocator calloc() {
        return new GLFWAllocator(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static GLFWAllocator create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new GLFWAllocator(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static GLFWAllocator create(long l) {
        return new GLFWAllocator(l, null);
    }

    public static @Nullable GLFWAllocator createSafe(long l) {
        return l == 0L ? null : new GLFWAllocator(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(GLFWAllocator.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = GLFWAllocator.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static GLFWAllocator malloc(MemoryStack memoryStack) {
        return new GLFWAllocator(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static GLFWAllocator calloc(MemoryStack memoryStack) {
        return new GLFWAllocator(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static GLFWAllocateCallback nallocate(long l) {
        return GLFWAllocateCallback.create(MemoryUtil.memGetAddress(l + (long)ALLOCATE));
    }

    public static GLFWReallocateCallback nreallocate(long l) {
        return GLFWReallocateCallback.create(MemoryUtil.memGetAddress(l + (long)REALLOCATE));
    }

    public static GLFWDeallocateCallback ndeallocate(long l) {
        return GLFWDeallocateCallback.create(MemoryUtil.memGetAddress(l + (long)DEALLOCATE));
    }

    public static long nuser(long l) {
        return MemoryUtil.memGetAddress(l + (long)USER);
    }

    public static void nallocate(long l, GLFWAllocateCallbackI gLFWAllocateCallbackI) {
        MemoryUtil.memPutAddress(l + (long)ALLOCATE, gLFWAllocateCallbackI.address());
    }

    public static void nreallocate(long l, GLFWReallocateCallbackI gLFWReallocateCallbackI) {
        MemoryUtil.memPutAddress(l + (long)REALLOCATE, gLFWReallocateCallbackI.address());
    }

    public static void ndeallocate(long l, GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
        MemoryUtil.memPutAddress(l + (long)DEALLOCATE, gLFWDeallocateCallbackI.address());
    }

    public static void nuser(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)USER, l2);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)ALLOCATE));
        Checks.check(MemoryUtil.memGetAddress(l + (long)REALLOCATE));
        Checks.check(MemoryUtil.memGetAddress(l + (long)DEALLOCATE));
    }

    static {
        Struct.Layout layout = GLFWAllocator.__struct(GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE), GLFWAllocator.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        ALLOCATE = layout.offsetof(0);
        REALLOCATE = layout.offsetof(1);
        DEALLOCATE = layout.offsetof(2);
        USER = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<GLFWAllocator, Buffer>
    implements NativeResource {
        private static final GLFWAllocator ELEMENT_FACTORY = GLFWAllocator.create(-1L);

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
        protected GLFWAllocator getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="GLFWallocatefun")
        public GLFWAllocateCallback allocate() {
            return GLFWAllocator.nallocate(this.address());
        }

        @NativeType(value="GLFWreallocatefun")
        public GLFWReallocateCallback reallocate() {
            return GLFWAllocator.nreallocate(this.address());
        }

        @NativeType(value="GLFWdeallocatefun")
        public GLFWDeallocateCallback deallocate() {
            return GLFWAllocator.ndeallocate(this.address());
        }

        @NativeType(value="void *")
        public long user() {
            return GLFWAllocator.nuser(this.address());
        }

        public Buffer allocate(@NativeType(value="GLFWallocatefun") GLFWAllocateCallbackI gLFWAllocateCallbackI) {
            GLFWAllocator.nallocate(this.address(), gLFWAllocateCallbackI);
            return this;
        }

        public Buffer reallocate(@NativeType(value="GLFWreallocatefun") GLFWReallocateCallbackI gLFWReallocateCallbackI) {
            GLFWAllocator.nreallocate(this.address(), gLFWReallocateCallbackI);
            return this;
        }

        public Buffer deallocate(@NativeType(value="GLFWdeallocatefun") GLFWDeallocateCallbackI gLFWDeallocateCallbackI) {
            GLFWAllocator.ndeallocate(this.address(), gLFWDeallocateCallbackI);
            return this;
        }

        public Buffer user(@NativeType(value="void *") long l) {
            GLFWAllocator.nuser(this.address(), l);
            return this;
        }
    }
}

