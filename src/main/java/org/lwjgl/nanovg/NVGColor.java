/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGcolor")
public class NVGColor
extends Struct<NVGColor>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int RGBA;
    public static final int R;
    public static final int G;
    public static final int B;
    public static final int A;

    protected NVGColor(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGColor create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGColor(l, byteBuffer);
    }

    public NVGColor(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGColor.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[4]")
    public FloatBuffer rgba() {
        return NVGColor.nrgba(this.address());
    }

    public float rgba(int n) {
        return NVGColor.nrgba(this.address(), n);
    }

    public float r() {
        return NVGColor.nr(this.address());
    }

    public float g() {
        return NVGColor.ng(this.address());
    }

    public float b() {
        return NVGColor.nb(this.address());
    }

    public float a() {
        return NVGColor.na(this.address());
    }

    public NVGColor rgba(@NativeType(value="float[4]") FloatBuffer floatBuffer) {
        NVGColor.nrgba(this.address(), floatBuffer);
        return this;
    }

    public NVGColor rgba(int n, float f) {
        NVGColor.nrgba(this.address(), n, f);
        return this;
    }

    public NVGColor r(float f) {
        NVGColor.nr(this.address(), f);
        return this;
    }

    public NVGColor g(float f) {
        NVGColor.ng(this.address(), f);
        return this;
    }

    public NVGColor b(float f) {
        NVGColor.nb(this.address(), f);
        return this;
    }

    public NVGColor a(float f) {
        NVGColor.na(this.address(), f);
        return this;
    }

    public NVGColor set(NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), this.address(), SIZEOF);
        return this;
    }

    public static NVGColor malloc() {
        return new NVGColor(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGColor calloc() {
        return new NVGColor(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGColor create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGColor(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static NVGColor create(long l) {
        return new NVGColor(l, null);
    }

    public static @Nullable NVGColor createSafe(long l) {
        return l == 0L ? null : new NVGColor(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGColor.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = NVGColor.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static NVGColor mallocStack() {
        return NVGColor.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGColor callocStack() {
        return NVGColor.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGColor mallocStack(MemoryStack memoryStack) {
        return NVGColor.malloc(memoryStack);
    }

    @Deprecated
    public static NVGColor callocStack(MemoryStack memoryStack) {
        return NVGColor.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return NVGColor.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return NVGColor.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return NVGColor.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return NVGColor.calloc(n, memoryStack);
    }

    public static NVGColor malloc(MemoryStack memoryStack) {
        return new NVGColor(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGColor calloc(MemoryStack memoryStack) {
        return new NVGColor(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static FloatBuffer nrgba(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)RGBA, 4);
    }

    public static float nrgba(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)RGBA + Checks.check(n, 4) * 4L);
    }

    public static float nr(long l) {
        return MemoryUtil.memGetFloat(l + (long)R);
    }

    public static float ng(long l) {
        return MemoryUtil.memGetFloat(l + (long)G);
    }

    public static float nb(long l) {
        return MemoryUtil.memGetFloat(l + (long)B);
    }

    public static float na(long l) {
        return MemoryUtil.memGetFloat(l + (long)A);
    }

    public static void nrgba(long l, FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(floatBuffer, 4);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(floatBuffer), l + (long)RGBA, floatBuffer.remaining() * 4);
    }

    public static void nrgba(long l, int n, float f) {
        MemoryUtil.memPutFloat(l + (long)RGBA + Checks.check(n, 4) * 4L, f);
    }

    public static void nr(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)R, f);
    }

    public static void ng(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)G, f);
    }

    public static void nb(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)B, f);
    }

    public static void na(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)A, f);
    }

    static {
        Struct.Layout layout = NVGColor.__struct(NVGColor.__union(NVGColor.__array(4, 4), NVGColor.__struct(NVGColor.__member(4), NVGColor.__member(4), NVGColor.__member(4), NVGColor.__member(4))));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        RGBA = layout.offsetof(1);
        R = layout.offsetof(3);
        G = layout.offsetof(4);
        B = layout.offsetof(5);
        A = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<NVGColor, Buffer>
    implements NativeResource {
        private static final NVGColor ELEMENT_FACTORY = NVGColor.create(-1L);

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
        protected NVGColor getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[4]")
        public FloatBuffer rgba() {
            return NVGColor.nrgba(this.address());
        }

        public float rgba(int n) {
            return NVGColor.nrgba(this.address(), n);
        }

        public float r() {
            return NVGColor.nr(this.address());
        }

        public float g() {
            return NVGColor.ng(this.address());
        }

        public float b() {
            return NVGColor.nb(this.address());
        }

        public float a() {
            return NVGColor.na(this.address());
        }

        public Buffer rgba(@NativeType(value="float[4]") FloatBuffer floatBuffer) {
            NVGColor.nrgba(this.address(), floatBuffer);
            return this;
        }

        public Buffer rgba(int n, float f) {
            NVGColor.nrgba(this.address(), n, f);
            return this;
        }

        public Buffer r(float f) {
            NVGColor.nr(this.address(), f);
            return this;
        }

        public Buffer g(float f) {
            NVGColor.ng(this.address(), f);
            return this;
        }

        public Buffer b(float f) {
            NVGColor.nb(this.address(), f);
            return this;
        }

        public Buffer a(float f) {
            NVGColor.na(this.address(), f);
            return this;
        }
    }
}

