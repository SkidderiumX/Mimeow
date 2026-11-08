/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.NSVGGradientStop;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGgradient")
public class NSVGGradient
extends Struct<NSVGGradient> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int XFORM;
    public static final int SPREAD;
    public static final int FX;
    public static final int FY;
    public static final int NSTOPS;
    public static final int PSTOPS;

    protected NSVGGradient(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NSVGGradient create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NSVGGradient(l, byteBuffer);
    }

    public NSVGGradient(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NSVGGradient.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="float[6]")
    public FloatBuffer xform() {
        return NSVGGradient.nxform(this.address());
    }

    public float xform(int n) {
        return NSVGGradient.nxform(this.address(), n);
    }

    @NativeType(value="char")
    public byte spread() {
        return NSVGGradient.nspread(this.address());
    }

    public float fx() {
        return NSVGGradient.nfx(this.address());
    }

    public float fy() {
        return NSVGGradient.nfy(this.address());
    }

    public int nstops() {
        return NSVGGradient.nnstops(this.address());
    }

    @NativeType(value="NSVGgradientStop[1]")
    public NSVGGradientStop.Buffer pstops() {
        return NSVGGradient.npstops(this.address());
    }

    @NativeType(value="NSVGgradientStop")
    public NSVGGradientStop pstops(int n) {
        return NSVGGradient.npstops(this.address(), n);
    }

    public static NSVGGradient create(long l) {
        return new NSVGGradient(l, null);
    }

    public static @Nullable NSVGGradient createSafe(long l) {
        return l == 0L ? null : new NSVGGradient(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FloatBuffer nxform(long l) {
        return MemoryUtil.memFloatBuffer(l + (long)XFORM, 6);
    }

    public static float nxform(long l, int n) {
        return MemoryUtil.memGetFloat(l + (long)XFORM + Checks.check(n, 6) * 4L);
    }

    public static byte nspread(long l) {
        return MemoryUtil.memGetByte(l + (long)SPREAD);
    }

    public static float nfx(long l) {
        return MemoryUtil.memGetFloat(l + (long)FX);
    }

    public static float nfy(long l) {
        return MemoryUtil.memGetFloat(l + (long)FY);
    }

    public static int nnstops(long l) {
        return MemoryUtil.memGetInt(l + (long)NSTOPS);
    }

    public static NSVGGradientStop.Buffer npstops(long l) {
        return NSVGGradientStop.create(l + (long)PSTOPS, NSVGGradient.nnstops(l));
    }

    public static NSVGGradientStop npstops(long l, int n) {
        return NSVGGradientStop.create(l + (long)PSTOPS + Checks.check(n, NSVGGradient.nnstops(l)) * (long)NSVGGradientStop.SIZEOF);
    }

    static {
        Struct.Layout layout = NSVGGradient.__struct(NSVGGradient.__array(4, 6), NSVGGradient.__member(1), NSVGGradient.__member(4), NSVGGradient.__member(4), NSVGGradient.__member(4), NSVGGradient.__array(NSVGGradientStop.SIZEOF, NSVGGradientStop.ALIGNOF, 1));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        XFORM = layout.offsetof(0);
        SPREAD = layout.offsetof(1);
        FX = layout.offsetof(2);
        FY = layout.offsetof(3);
        NSTOPS = layout.offsetof(4);
        PSTOPS = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<NSVGGradient, Buffer> {
        private static final NSVGGradient ELEMENT_FACTORY = NSVGGradient.create(-1L);

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
        protected NSVGGradient getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="float[6]")
        public FloatBuffer xform() {
            return NSVGGradient.nxform(this.address());
        }

        public float xform(int n) {
            return NSVGGradient.nxform(this.address(), n);
        }

        @NativeType(value="char")
        public byte spread() {
            return NSVGGradient.nspread(this.address());
        }

        public float fx() {
            return NSVGGradient.nfx(this.address());
        }

        public float fy() {
            return NSVGGradient.nfy(this.address());
        }

        public int nstops() {
            return NSVGGradient.nnstops(this.address());
        }

        @NativeType(value="NSVGgradientStop[1]")
        public NSVGGradientStop.Buffer pstops() {
            return NSVGGradient.npstops(this.address());
        }

        @NativeType(value="NSVGgradientStop")
        public NSVGGradientStop pstops(int n) {
            return NSVGGradient.npstops(this.address(), n);
        }
    }
}

