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

@NativeType(value="struct UIrect")
public class UIRect
extends Struct<UIRect>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int V;
    public static final int X;
    public static final int Y;
    public static final int W;
    public static final int H;

    protected UIRect(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected UIRect create(long l, @Nullable ByteBuffer byteBuffer) {
        return new UIRect(l, byteBuffer);
    }

    public UIRect(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), UIRect.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="int[4]")
    public IntBuffer v() {
        return UIRect.nv(this.address());
    }

    public int v(int n) {
        return UIRect.nv(this.address(), n);
    }

    public int x() {
        return UIRect.nx(this.address());
    }

    public int y() {
        return UIRect.ny(this.address());
    }

    public int w() {
        return UIRect.nw(this.address());
    }

    public int h() {
        return UIRect.nh(this.address());
    }

    public UIRect v(@NativeType(value="int[4]") IntBuffer intBuffer) {
        UIRect.nv(this.address(), intBuffer);
        return this;
    }

    public UIRect v(int n, int n2) {
        UIRect.nv(this.address(), n, n2);
        return this;
    }

    public UIRect x(int n) {
        UIRect.nx(this.address(), n);
        return this;
    }

    public UIRect y(int n) {
        UIRect.ny(this.address(), n);
        return this;
    }

    public UIRect w(int n) {
        UIRect.nw(this.address(), n);
        return this;
    }

    public UIRect h(int n) {
        UIRect.nh(this.address(), n);
        return this;
    }

    public UIRect set(UIRect uIRect) {
        MemoryUtil.memCopy(uIRect.address(), this.address(), SIZEOF);
        return this;
    }

    public static UIRect malloc() {
        return new UIRect(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static UIRect calloc() {
        return new UIRect(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static UIRect create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new UIRect(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static UIRect create(long l) {
        return new UIRect(l, null);
    }

    public static @Nullable UIRect createSafe(long l) {
        return l == 0L ? null : new UIRect(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(UIRect.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = UIRect.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static UIRect mallocStack() {
        return UIRect.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIRect callocStack() {
        return UIRect.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static UIRect mallocStack(MemoryStack memoryStack) {
        return UIRect.malloc(memoryStack);
    }

    @Deprecated
    public static UIRect callocStack(MemoryStack memoryStack) {
        return UIRect.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return UIRect.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return UIRect.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return UIRect.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return UIRect.calloc(n, memoryStack);
    }

    public static UIRect malloc(MemoryStack memoryStack) {
        return new UIRect(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static UIRect calloc(MemoryStack memoryStack) {
        return new UIRect(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static IntBuffer nv(long l) {
        return MemoryUtil.memIntBuffer(l + (long)V, 4);
    }

    public static int nv(long l, int n) {
        return MemoryUtil.memGetInt(l + (long)V + Checks.check(n, 4) * 4L);
    }

    public static int nx(long l) {
        return MemoryUtil.memGetInt(l + (long)X);
    }

    public static int ny(long l) {
        return MemoryUtil.memGetInt(l + (long)Y);
    }

    public static int nw(long l) {
        return MemoryUtil.memGetInt(l + (long)W);
    }

    public static int nh(long l) {
        return MemoryUtil.memGetInt(l + (long)H);
    }

    public static void nv(long l, IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(intBuffer, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(intBuffer), l + (long)V, intBuffer.remaining() * 4);
    }

    public static void nv(long l, int n, int n2) {
        MemoryUtil.memPutInt(l + (long)V + Checks.check(n, 4) * 4L, n2);
    }

    public static void nx(long l, int n) {
        MemoryUtil.memPutInt(l + (long)X, n);
    }

    public static void ny(long l, int n) {
        MemoryUtil.memPutInt(l + (long)Y, n);
    }

    public static void nw(long l, int n) {
        MemoryUtil.memPutInt(l + (long)W, n);
    }

    public static void nh(long l, int n) {
        MemoryUtil.memPutInt(l + (long)H, n);
    }

    static {
        Struct.Layout layout = UIRect.__struct(UIRect.__union(UIRect.__array(4, 4), UIRect.__struct(UIRect.__member(4), UIRect.__member(4), UIRect.__member(4), UIRect.__member(4))));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        V = layout.offsetof(1);
        X = layout.offsetof(3);
        Y = layout.offsetof(4);
        W = layout.offsetof(5);
        H = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<UIRect, Buffer>
    implements NativeResource {
        private static final UIRect ELEMENT_FACTORY = UIRect.create(-1L);

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
        protected UIRect getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="int[4]")
        public IntBuffer v() {
            return UIRect.nv(this.address());
        }

        public int v(int n) {
            return UIRect.nv(this.address(), n);
        }

        public int x() {
            return UIRect.nx(this.address());
        }

        public int y() {
            return UIRect.ny(this.address());
        }

        public int w() {
            return UIRect.nw(this.address());
        }

        public int h() {
            return UIRect.nh(this.address());
        }

        public Buffer v(@NativeType(value="int[4]") IntBuffer intBuffer) {
            UIRect.nv(this.address(), intBuffer);
            return this;
        }

        public Buffer v(int n, int n2) {
            UIRect.nv(this.address(), n, n2);
            return this;
        }

        public Buffer x(int n) {
            UIRect.nx(this.address(), n);
            return this;
        }

        public Buffer y(int n) {
            UIRect.ny(this.address(), n);
            return this;
        }

        public Buffer w(int n) {
            UIRect.nw(this.address(), n);
            return this;
        }

        public Buffer h(int n) {
            UIRect.nh(this.address(), n);
            return this;
        }
    }
}

