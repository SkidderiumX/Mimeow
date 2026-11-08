/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct UIvec2")
public class UIVec2
extends Struct<UIVec2>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int V;
    public static final int X;
    public static final int Y;

    protected UIVec2(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected UIVec2 create(long l, @Nullable ByteBuffer byteBuffer) {
        return new UIVec2(l, byteBuffer);
    }

    public UIVec2(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), UIVec2.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int[2]")
    public IntBuffer v() {
        return UIVec2.nv(this.address());
    }

    public int v(int n) {
        return UIVec2.nv(this.address(), n);
    }

    public int x() {
        return UIVec2.nx(this.address());
    }

    public int y() {
        return UIVec2.ny(this.address());
    }

    public UIVec2 v(@NativeType(value="int[2]") IntBuffer intBuffer) {
        UIVec2.nv(this.address(), intBuffer);
        return this;
    }

    public UIVec2 v(int n, int n2) {
        UIVec2.nv(this.address(), n, n2);
        return this;
    }

    public UIVec2 x(int n) {
        UIVec2.nx(this.address(), n);
        return this;
    }

    public UIVec2 y(int n) {
        UIVec2.ny(this.address(), n);
        return this;
    }

    public UIVec2 set(UIVec2 uIVec2) {
        MemoryUtil.memCopy(uIVec2.address(), this.address(), SIZEOF);
        return this;
    }

    public static UIVec2 malloc() {
        return new UIVec2(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static UIVec2 calloc() {
        return new UIVec2(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static UIVec2 create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new UIVec2(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static UIVec2 create(long l) {
        return new UIVec2(l, null);
    }

    public static @Nullable UIVec2 createSafe(long l) {
        return l == 0L ? null : new UIVec2(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(UIVec2.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = UIVec2.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static UIVec2 mallocStack() {
        return UIVec2.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIVec2 callocStack() {
        return UIVec2.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIVec2 mallocStack(MemoryStack memoryStack) {
        return UIVec2.malloc(memoryStack);
    }

    @Deprecated
    public static UIVec2 callocStack(MemoryStack memoryStack) {
        return UIVec2.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return UIVec2.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return UIVec2.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return UIVec2.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return UIVec2.calloc(n, memoryStack);
    }

    public static UIVec2 malloc(MemoryStack memoryStack) {
        return new UIVec2(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static UIVec2 calloc(MemoryStack memoryStack) {
        return new UIVec2(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static IntBuffer nv(long l) {
        return MemoryUtil.memIntBuffer(l + (long)V, 2);
    }

    public static int nv(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)V + Checks.check(n, 2) * 4L);
    }

    public static int nx(long l) {
        return MemoryUtil.memGetInt(l + (long)X);
    }

    public static int ny(long l) {
        return MemoryUtil.memGetInt(l + (long)Y);
    }

    public static void nv(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)V, intBuffer.remaining() * 4);
    }

    public static void nv(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)V + Checks.check(n, 2) * 4L, n2);
    }

    public static void nx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X, n);
    }

    public static void ny(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y, n);
    }

    static {
        Struct.Layout layout = UIVec2.__struct(UIVec2.__union(UIVec2.__array(4, 2), UIVec2.__struct(UIVec2.__member(4), UIVec2.__member(4))));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        V = layout.offsetof(1);
        X = layout.offsetof(3);
        Y = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<UIVec2, Buffer>
    implements NativeResource {
        private static final UIVec2 ELEMENT_FACTORY = UIVec2.create(-1L);

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
        protected UIVec2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int[2]")
        public IntBuffer v() {
            return UIVec2.nv(this.address());
        }

        public int v(int n) {
            return UIVec2.nv(this.address(), n);
        }

        public int x() {
            return UIVec2.nx(this.address());
        }

        public int y() {
            return UIVec2.ny(this.address());
        }

        public Buffer v(@NativeType(value="int[2]") IntBuffer intBuffer) {
            UIVec2.nv(this.address(), intBuffer);
            return this;
        }

        public Buffer v(int n, int n2) {
            UIVec2.nv(this.address(), n, n2);
            return this;
        }

        public Buffer x(int n) {
            UIVec2.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            UIVec2.ny(this.address(), n);
            return this;
        }
    }
}

