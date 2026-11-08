/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class BNDwidgetTheme
extends Struct<BNDwidgetTheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OUTLINECOLOR;
    public static final int ITEMCOLOR;
    public static final int INNERCOLOR;
    public static final int INNERSELECTEDCOLOR;
    public static final int TEXTCOLOR;
    public static final int TEXTSELECTEDCOLOR;
    public static final int SHADETOP;
    public static final int SHADEDOWN;

    protected BNDwidgetTheme(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected BNDwidgetTheme create(long l, @Nullable ByteBuffer byteBuffer) {
        return new BNDwidgetTheme(l, byteBuffer);
    }

    public BNDwidgetTheme(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), BNDwidgetTheme.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor outlineColor() {
        return BNDwidgetTheme.noutlineColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor itemColor() {
        return BNDwidgetTheme.nitemColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerColor() {
        return BNDwidgetTheme.ninnerColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor innerSelectedColor() {
        return BNDwidgetTheme.ninnerSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textColor() {
        return BNDwidgetTheme.ntextColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textSelectedColor() {
        return BNDwidgetTheme.ntextSelectedColor(this.address());
    }

    public int shadeTop() {
        return BNDwidgetTheme.nshadeTop(this.address());
    }

    public int shadeDown() {
        return BNDwidgetTheme.nshadeDown(this.address());
    }

    public BNDwidgetTheme outlineColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.noutlineColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme outlineColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.outlineColor());
        return this;
    }

    public BNDwidgetTheme itemColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.nitemColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme itemColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.itemColor());
        return this;
    }

    public BNDwidgetTheme innerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.ninnerColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme innerColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.innerColor());
        return this;
    }

    public BNDwidgetTheme innerSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.ninnerSelectedColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme innerSelectedColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.innerSelectedColor());
        return this;
    }

    public BNDwidgetTheme textColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.ntextColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme textColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.textColor());
        return this;
    }

    public BNDwidgetTheme textSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDwidgetTheme.ntextSelectedColor(this.address(), nVGColor);
        return this;
    }

    public BNDwidgetTheme textSelectedColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.textSelectedColor());
        return this;
    }

    public BNDwidgetTheme shadeTop(int n) {
        BNDwidgetTheme.nshadeTop(this.address(), n);
        return this;
    }

    public BNDwidgetTheme shadeDown(int n) {
        BNDwidgetTheme.nshadeDown(this.address(), n);
        return this;
    }

    public BNDwidgetTheme set(NVGColor nVGColor, NVGColor nVGColor2, NVGColor nVGColor3, NVGColor nVGColor4, NVGColor nVGColor5, NVGColor nVGColor6, int n, int n2) {
        this.outlineColor(nVGColor);
        this.itemColor(nVGColor2);
        this.innerColor(nVGColor3);
        this.innerSelectedColor(nVGColor4);
        this.textColor(nVGColor5);
        this.textSelectedColor(nVGColor6);
        this.shadeTop(n);
        this.shadeDown(n2);
        return this;
    }

    public BNDwidgetTheme set(BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDwidgetTheme malloc() {
        return new BNDwidgetTheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDwidgetTheme calloc() {
        return new BNDwidgetTheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDwidgetTheme create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDwidgetTheme(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static BNDwidgetTheme create(long l) {
        return new BNDwidgetTheme(l, null);
    }

    public static @Nullable BNDwidgetTheme createSafe(long l) {
        return l == 0L ? null : new BNDwidgetTheme(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDwidgetTheme.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = BNDwidgetTheme.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static BNDwidgetTheme mallocStack() {
        return BNDwidgetTheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDwidgetTheme callocStack() {
        return BNDwidgetTheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDwidgetTheme mallocStack(MemoryStack memoryStack) {
        return BNDwidgetTheme.malloc(memoryStack);
    }

    @Deprecated
    public static BNDwidgetTheme callocStack(MemoryStack memoryStack) {
        return BNDwidgetTheme.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return BNDwidgetTheme.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return BNDwidgetTheme.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return BNDwidgetTheme.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return BNDwidgetTheme.calloc(n, memoryStack);
    }

    public static BNDwidgetTheme malloc(MemoryStack memoryStack) {
        return new BNDwidgetTheme(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDwidgetTheme calloc(MemoryStack memoryStack) {
        return new BNDwidgetTheme(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static NVGColor noutlineColor(long l) {
        return NVGColor.create(l + (long)OUTLINECOLOR);
    }

    public static NVGColor nitemColor(long l) {
        return NVGColor.create(l + (long)ITEMCOLOR);
    }

    public static NVGColor ninnerColor(long l) {
        return NVGColor.create(l + (long)INNERCOLOR);
    }

    public static NVGColor ninnerSelectedColor(long l) {
        return NVGColor.create(l + (long)INNERSELECTEDCOLOR);
    }

    public static NVGColor ntextColor(long l) {
        return NVGColor.create(l + (long)TEXTCOLOR);
    }

    public static NVGColor ntextSelectedColor(long l) {
        return NVGColor.create(l + (long)TEXTSELECTEDCOLOR);
    }

    public static int nshadeTop(long l) {
        return MemoryUtil.memGetInt(l + (long)SHADETOP);
    }

    public static int nshadeDown(long l) {
        return MemoryUtil.memGetInt(l + (long)SHADEDOWN);
    }

    public static void noutlineColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)OUTLINECOLOR, NVGColor.SIZEOF);
    }

    public static void nitemColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)ITEMCOLOR, NVGColor.SIZEOF);
    }

    public static void ninnerColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)INNERCOLOR, NVGColor.SIZEOF);
    }

    public static void ninnerSelectedColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)INNERSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)TEXTCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextSelectedColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)TEXTSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nshadeTop(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SHADETOP, n);
    }

    public static void nshadeDown(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SHADEDOWN, n);
    }

    static {
        Struct.Layout layout = BNDwidgetTheme.__struct(BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDwidgetTheme.__member(4), BNDwidgetTheme.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OUTLINECOLOR = layout.offsetof(0);
        ITEMCOLOR = layout.offsetof(1);
        INNERCOLOR = layout.offsetof(2);
        INNERSELECTEDCOLOR = layout.offsetof(3);
        TEXTCOLOR = layout.offsetof(4);
        TEXTSELECTEDCOLOR = layout.offsetof(5);
        SHADETOP = layout.offsetof(6);
        SHADEDOWN = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<BNDwidgetTheme, Buffer>
    implements NativeResource {
        private static final BNDwidgetTheme ELEMENT_FACTORY = BNDwidgetTheme.create(-1L);

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
        protected BNDwidgetTheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor outlineColor() {
            return BNDwidgetTheme.noutlineColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor itemColor() {
            return BNDwidgetTheme.nitemColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerColor() {
            return BNDwidgetTheme.ninnerColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor innerSelectedColor() {
            return BNDwidgetTheme.ninnerSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textColor() {
            return BNDwidgetTheme.ntextColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textSelectedColor() {
            return BNDwidgetTheme.ntextSelectedColor(this.address());
        }

        public int shadeTop() {
            return BNDwidgetTheme.nshadeTop(this.address());
        }

        public int shadeDown() {
            return BNDwidgetTheme.nshadeDown(this.address());
        }

        public Buffer outlineColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.noutlineColor(this.address(), nVGColor);
            return this;
        }

        public Buffer outlineColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.outlineColor());
            return this;
        }

        public Buffer itemColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.nitemColor(this.address(), nVGColor);
            return this;
        }

        public Buffer itemColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.itemColor());
            return this;
        }

        public Buffer innerColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.ninnerColor(this.address(), nVGColor);
            return this;
        }

        public Buffer innerColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.innerColor());
            return this;
        }

        public Buffer innerSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.ninnerSelectedColor(this.address(), nVGColor);
            return this;
        }

        public Buffer innerSelectedColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.innerSelectedColor());
            return this;
        }

        public Buffer textColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.ntextColor(this.address(), nVGColor);
            return this;
        }

        public Buffer textColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.textColor());
            return this;
        }

        public Buffer textSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDwidgetTheme.ntextSelectedColor(this.address(), nVGColor);
            return this;
        }

        public Buffer textSelectedColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.textSelectedColor());
            return this;
        }

        public Buffer shadeTop(int n) {
            BNDwidgetTheme.nshadeTop(this.address(), n);
            return this;
        }

        public Buffer shadeDown(int n) {
            BNDwidgetTheme.nshadeDown(this.address(), n);
            return this;
        }
    }
}

