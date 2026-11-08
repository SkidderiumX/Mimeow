/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NVGpaint")
public class NVGPaint
extends Struct<NVGPaint>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int XFORM;
    public static final int EXTENT;
    public static final int RADIUS;
    public static final int FEATHER;
    public static final int INNERCOLOR;
    public static final int OUTERCOLOR;
    public static final int IMAGE;

    protected NVGPaint(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NVGPaint create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NVGPaint(l, byteBuffer);
    }

    public NVGPaint(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NVGPaint.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NVGPaint.nxform(this.address());
    }

    public float xform(int n) {
        return NVGPaint.nxform(this.address(), n);
    }

    @NativeType(value="float[2]")
    public FloatBuffer extent() {
        return NVGPaint.nextent(this.address());
    }

    public float extent(int n) {
        return NVGPaint.nextent(this.address(), n);
    }

    public float radius() {
        return NVGPaint.nradius(this.address());
    }

    public float feather() {
        return NVGPaint.nfeather(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerColor() {
        return NVGPaint.ninnerColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor outerColor() {
        return NVGPaint.nouterColor(this.address());
    }

    public int image() {
        return NVGPaint.nimage(this.address());
    }

    public NVGPaint xform(@NativeType(value="float[6]") FloatBuffer floatBuffer) {
        NVGPaint.nxform(this.address(), floatBuffer);
        return this;
    }

    public NVGPaint xform(int n, float f) {
        NVGPaint.nxform(this.address(), n, f);
        return this;
    }

    public NVGPaint extent(@NativeType(value="float[2]") FloatBuffer floatBuffer) {
        NVGPaint.nextent(this.address(), floatBuffer);
        return this;
    }

    public NVGPaint extent(int n, float f) {
        NVGPaint.nextent(this.address(), n, f);
        return this;
    }

    public NVGPaint radius(float f) {
        NVGPaint.nradius(this.address(), f);
        return this;
    }

    public NVGPaint feather(float f) {
        NVGPaint.nfeather(this.address(), f);
        return this;
    }

    public NVGPaint innerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        NVGPaint.ninnerColor(this.address(), nVGColor);
        return this;
    }

    public NVGPaint innerColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.innerColor());
        return this;
    }

    public NVGPaint outerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        NVGPaint.nouterColor(this.address(), nVGColor);
        return this;
    }

    public NVGPaint outerColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.outerColor());
        return this;
    }

    public NVGPaint image(int n) {
        NVGPaint.nimage(this.address(), n);
        return this;
    }

    public NVGPaint set(FloatBuffer floatBuffer, FloatBuffer floatBuffer2, float f, float f2, NVGColor nVGColor, NVGColor nVGColor2, int n) {
        this.xform(floatBuffer);
        this.extent(floatBuffer2);
        this.radius(f);
        this.feather(f2);
        this.innerColor(nVGColor);
        this.outerColor(nVGColor2);
        this.image(n);
        return this;
    }

    public NVGPaint set(NVGPaint nVGPaint) {
        MemoryUtil.memCopy(nVGPaint.address(), this.address(), SIZEOF);
        return this;
    }

    public static NVGPaint malloc() {
        return new NVGPaint(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static NVGPaint calloc() {
        return new NVGPaint(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static NVGPaint create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new NVGPaint(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static NVGPaint create(long l) {
        return new NVGPaint(l, null);
    }

    public static @Nullable NVGPaint createSafe(long l) {
        return l == 0L ? null : new NVGPaint(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(NVGPaint.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = NVGPaint.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static NVGPaint mallocStack() {
        return NVGPaint.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGPaint callocStack() {
        return NVGPaint.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static NVGPaint mallocStack(MemoryStack memoryStack) {
        return NVGPaint.malloc(memoryStack);
    }

    @Deprecated
    public static NVGPaint callocStack(MemoryStack memoryStack) {
        return NVGPaint.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return NVGPaint.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return NVGPaint.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return NVGPaint.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return NVGPaint.calloc(n, memoryStack);
    }

    public static NVGPaint malloc(MemoryStack memoryStack) {
        return new NVGPaint(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static NVGPaint calloc(MemoryStack memoryStack) {
        return new NVGPaint(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static FloatBuffer nxform(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)XFORM, 6);
    }

    public static float nxform(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)XFORM + Checks.check(n, 6) * 4L);
    }

    public static FloatBuffer nextent(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)EXTENT, 2);
    }

    public static float nextent(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)EXTENT + Checks.check(n, 2) * 4L);
    }

    public static float nradius(long l) {
        return MemoryUtil.memGetFloat(l + (long)RADIUS);
    }

    public static float nfeather(long l) {
        return MemoryUtil.memGetFloat(l + (long)FEATHER);
    }

    public static NVGColor ninnerColor(long l) {
        return NVGColor.create(l + (long)INNERCOLOR);
    }

    public static NVGColor nouterColor(long l) {
        return NVGColor.create(l + (long)OUTERCOLOR);
    }

    public static int nimage(long l) {
        return MemoryUtil.memGetInt(l + (long)IMAGE);
    }

    public static void nxform(long l, FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(floatBuffer, 6);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(floatBuffer), l + (long)XFORM, floatBuffer.remaining() * 4);
    }

    public static void nxform(long l, int n, float f) {
        MemoryUtil.memPutFloat(l + (long)XFORM + Checks.check(n, 6) * 4L, f);
    }

    public static void nextent(long l, FloatBuffer floatBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(floatBuffer, 2);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(floatBuffer), l + (long)EXTENT, floatBuffer.remaining() * 4);
    }

    public static void nextent(long l, int n, float f) {
        MemoryUtil.memPutFloat(l + (long)EXTENT + Checks.check(n, 2) * 4L, f);
    }

    public static void nradius(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)RADIUS, f);
    }

    public static void nfeather(long l, float f) {
        MemoryUtil.memPutFloat(l + (long)FEATHER, f);
    }

    public static void ninnerColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)INNERCOLOR, NVGColor.SIZEOF);
    }

    public static void nouterColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)OUTERCOLOR, NVGColor.SIZEOF);
    }

    public static void nimage(long l, int n) {
        MemoryUtil.memPutInt(l + (long)IMAGE, n);
    }

    static {
        Struct.Layout layout = NVGPaint.__struct(NVGPaint.__array(4, 6), NVGPaint.__array(4, 2), NVGPaint.__member(4), NVGPaint.__member(4), NVGPaint.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), NVGPaint.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), NVGPaint.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        XFORM = layout.offsetof(0);
        EXTENT = layout.offsetof(1);
        RADIUS = layout.offsetof(2);
        FEATHER = layout.offsetof(3);
        INNERCOLOR = layout.offsetof(4);
        OUTERCOLOR = layout.offsetof(5);
        IMAGE = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<NVGPaint, Buffer>
    implements NativeResource {
        private static final NVGPaint ELEMENT_FACTORY = NVGPaint.create(-1L);

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
        protected NVGPaint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NVGPaint.nxform(this.address());
        }

        public float xform(int n) {
            return NVGPaint.nxform(this.address(), n);
        }

        @NativeType(value="float[2]")
        public FloatBuffer extent() {
            return NVGPaint.nextent(this.address());
        }

        public float extent(int n) {
            return NVGPaint.nextent(this.address(), n);
        }

        public float radius() {
            return NVGPaint.nradius(this.address());
        }

        public float feather() {
            return NVGPaint.nfeather(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerColor() {
            return NVGPaint.ninnerColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor outerColor() {
            return NVGPaint.nouterColor(this.address());
        }

        public int image() {
            return NVGPaint.nimage(this.address());
        }

        public Buffer xform(@NativeType(value="float[6]") FloatBuffer floatBuffer) {
            NVGPaint.nxform(this.address(), floatBuffer);
            return this;
        }

        public Buffer xform(int n, float f) {
            NVGPaint.nxform(this.address(), n, f);
            return this;
        }

        public Buffer extent(@NativeType(value="float[2]") FloatBuffer floatBuffer) {
            NVGPaint.nextent(this.address(), floatBuffer);
            return this;
        }

        public Buffer extent(int n, float f) {
            NVGPaint.nextent(this.address(), n, f);
            return this;
        }

        public Buffer radius(float f) {
            NVGPaint.nradius(this.address(), f);
            return this;
        }

        public Buffer feather(float f) {
            NVGPaint.nfeather(this.address(), f);
            return this;
        }

        public Buffer innerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            NVGPaint.ninnerColor(this.address(), nVGColor);
            return this;
        }

        public Buffer innerColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.innerColor());
            return this;
        }

        public Buffer outerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            NVGPaint.nouterColor(this.address(), nVGColor);
            return this;
        }

        public Buffer outerColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.outerColor());
            return this;
        }

        public Buffer image(int n) {
            NVGPaint.nimage(this.address(), n);
            return this;
        }
    }
}

