/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.NSVGGradient;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGpaint")
public class NSVGPaint
extends Struct<NSVGPaint> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int COLOR;
    public static final int GRADIENT;

    protected NSVGPaint(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NSVGPaint create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NSVGPaint(l, byteBuffer);
    }

    public NSVGPaint(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NSVGPaint.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="signed char")
    public byte type() {
        return NSVGPaint.ntype(this.address());
    }

    @NativeType(value="unsigned int")
    public int color() {
        return NSVGPaint.ncolor(this.address());
    }

    @NativeType(value="NSVGgradient *")
    public NSVGGradient gradient() {
        return NSVGPaint.ngradient(this.address());
    }

    public static NSVGPaint create(long l) {
        return new NSVGPaint(l, null);
    }

    public static @Nullable NSVGPaint createSafe(long l) {
        return l == 0L ? null : new NSVGPaint(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static byte ntype(long l) {
        return MemoryUtil.memGetByte(l + (long)TYPE);
    }

    public static int ncolor(long l) {
        return MemoryUtil.memGetInt(l + (long)COLOR);
    }

    public static NSVGGradient ngradient(long l) {
        return NSVGGradient.create(MemoryUtil.memGetAddress(l + (long)GRADIENT));
    }

    static {
        Struct.Layout layout = NSVGPaint.__struct(NSVGPaint.__member(1), NSVGPaint.__union(NSVGPaint.__member(4), NSVGPaint.__member(POINTER_SIZE)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        COLOR = layout.offsetof(2);
        GRADIENT = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<NSVGPaint, Buffer> {
        private static final NSVGPaint ELEMENT_FACTORY = NSVGPaint.create(-1L);

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
        protected NSVGPaint getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="signed char")
        public byte type() {
            return NSVGPaint.ntype(this.address());
        }

        @NativeType(value="unsigned int")
        public int color() {
            return NSVGPaint.ncolor(this.address());
        }

        @NativeType(value="NSVGgradient *")
        public NSVGGradient gradient() {
            return NSVGPaint.ngradient(this.address());
        }
    }
}

