/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.NSVGShape;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct NSVGimage")
public class NSVGImage
extends Struct<NSVGImage> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int WIDTH;
    public static final int HEIGHT;
    public static final int SHAPES;

    protected NSVGImage(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected NSVGImage create(long l, @Nullable ByteBuffer byteBuffer) {
        return new NSVGImage(l, byteBuffer);
    }

    public NSVGImage(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), NSVGImage.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public float width() {
        return NSVGImage.nwidth(this.address());
    }

    public float height() {
        return NSVGImage.nheight(this.address());
    }

    @NativeType(value="NSVGshape *")
    public NSVGShape shapes() {
        return NSVGImage.nshapes(this.address());
    }

    public static NSVGImage create(long l) {
        return new NSVGImage(l, null);
    }

    public static @Nullable NSVGImage createSafe(long l) {
        return l == 0L ? null : new NSVGImage(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static float nwidth(long l) {
        return MemoryUtil.memGetFloat(l + (long)WIDTH);
    }

    public static float nheight(long l) {
        return MemoryUtil.memGetFloat(l + (long)HEIGHT);
    }

    public static NSVGShape nshapes(long l) {
        return NSVGShape.create(MemoryUtil.memGetAddress(l + (long)SHAPES));
    }

    static {
        Struct.Layout layout = NSVGImage.__struct(NSVGImage.__member(4), NSVGImage.__member(4), NSVGImage.__member(POINTER_SIZE));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        WIDTH = layout.offsetof(0);
        HEIGHT = layout.offsetof(1);
        SHAPES = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<NSVGImage, Buffer> {
        private static final NSVGImage ELEMENT_FACTORY = NSVGImage.create(-1L);

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
        protected NSVGImage getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public float width() {
            return NSVGImage.nwidth(this.address());
        }

        public float height() {
            return NSVGImage.nheight(this.address());
        }

        @NativeType(value="NSVGshape *")
        public NSVGShape shapes() {
            return NSVGImage.nshapes(this.address());
        }
    }
}

