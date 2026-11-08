/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.nanovg.BNDnodeTheme;
import org.lwjgl.nanovg.BNDwidgetTheme;
import org.lwjgl.nanovg.NVGColor;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class BNDtheme
extends Struct<BNDtheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int BACKGROUNDCOLOR;
    public static final int REGULARTHEME;
    public static final int TOOLTHEME;
    public static final int RADIOTHEME;
    public static final int TEXTFIELDTHEME;
    public static final int OPTIONTHEME;
    public static final int CHOICETHEME;
    public static final int NUMBERFIELDTHEME;
    public static final int SLIDERTHEME;
    public static final int SCROLLBARTHEME;
    public static final int TOOLTIPTHEME;
    public static final int MENUTHEME;
    public static final int MENUITEMTHEME;
    public static final int NODETHEME;

    protected BNDtheme(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected BNDtheme create(long l, @Nullable ByteBuffer byteBuffer) {
        return new BNDtheme(l, byteBuffer);
    }

    public BNDtheme(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), BNDtheme.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor backgroundColor() {
        return BNDtheme.nbackgroundColor(this.address());
    }

    public BNDwidgetTheme regularTheme() {
        return BNDtheme.nregularTheme(this.address());
    }

    public BNDwidgetTheme toolTheme() {
        return BNDtheme.ntoolTheme(this.address());
    }

    public BNDwidgetTheme radioTheme() {
        return BNDtheme.nradioTheme(this.address());
    }

    public BNDwidgetTheme textFieldTheme() {
        return BNDtheme.ntextFieldTheme(this.address());
    }

    public BNDwidgetTheme optionTheme() {
        return BNDtheme.noptionTheme(this.address());
    }

    public BNDwidgetTheme choiceTheme() {
        return BNDtheme.nchoiceTheme(this.address());
    }

    public BNDwidgetTheme numberFieldTheme() {
        return BNDtheme.nnumberFieldTheme(this.address());
    }

    public BNDwidgetTheme sliderTheme() {
        return BNDtheme.nsliderTheme(this.address());
    }

    public BNDwidgetTheme scrollBarTheme() {
        return BNDtheme.nscrollBarTheme(this.address());
    }

    public BNDwidgetTheme tooltipTheme() {
        return BNDtheme.ntooltipTheme(this.address());
    }

    public BNDwidgetTheme menuTheme() {
        return BNDtheme.nmenuTheme(this.address());
    }

    public BNDwidgetTheme menuItemTheme() {
        return BNDtheme.nmenuItemTheme(this.address());
    }

    public BNDnodeTheme nodeTheme() {
        return BNDtheme.nnodeTheme(this.address());
    }

    public BNDtheme backgroundColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDtheme.nbackgroundColor(this.address(), nVGColor);
        return this;
    }

    public BNDtheme backgroundColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.backgroundColor());
        return this;
    }

    public BNDtheme regularTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nregularTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme regularTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.regularTheme());
        return this;
    }

    public BNDtheme toolTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.ntoolTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme toolTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.toolTheme());
        return this;
    }

    public BNDtheme radioTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nradioTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme radioTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.radioTheme());
        return this;
    }

    public BNDtheme textFieldTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.ntextFieldTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme textFieldTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.textFieldTheme());
        return this;
    }

    public BNDtheme optionTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.noptionTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme optionTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.optionTheme());
        return this;
    }

    public BNDtheme choiceTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nchoiceTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme choiceTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.choiceTheme());
        return this;
    }

    public BNDtheme numberFieldTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nnumberFieldTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme numberFieldTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.numberFieldTheme());
        return this;
    }

    public BNDtheme sliderTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nsliderTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme sliderTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.sliderTheme());
        return this;
    }

    public BNDtheme scrollBarTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nscrollBarTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme scrollBarTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.scrollBarTheme());
        return this;
    }

    public BNDtheme tooltipTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.ntooltipTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme tooltipTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.tooltipTheme());
        return this;
    }

    public BNDtheme menuTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nmenuTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme menuTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.menuTheme());
        return this;
    }

    public BNDtheme menuItemTheme(BNDwidgetTheme bNDwidgetTheme) {
        BNDtheme.nmenuItemTheme(this.address(), bNDwidgetTheme);
        return this;
    }

    public BNDtheme menuItemTheme(Consumer<BNDwidgetTheme> consumer) {
        consumer.accept(this.menuItemTheme());
        return this;
    }

    public BNDtheme nodeTheme(BNDnodeTheme bNDnodeTheme) {
        BNDtheme.nnodeTheme(this.address(), bNDnodeTheme);
        return this;
    }

    public BNDtheme nodeTheme(Consumer<BNDnodeTheme> consumer) {
        consumer.accept(this.nodeTheme());
        return this;
    }

    public BNDtheme set(NVGColor nVGColor, BNDwidgetTheme bNDwidgetTheme, BNDwidgetTheme bNDwidgetTheme2, BNDwidgetTheme bNDwidgetTheme3, BNDwidgetTheme bNDwidgetTheme4, BNDwidgetTheme bNDwidgetTheme5, BNDwidgetTheme bNDwidgetTheme6, BNDwidgetTheme bNDwidgetTheme7, BNDwidgetTheme bNDwidgetTheme8, BNDwidgetTheme bNDwidgetTheme9, BNDwidgetTheme bNDwidgetTheme10, BNDwidgetTheme bNDwidgetTheme11, BNDwidgetTheme bNDwidgetTheme12, BNDnodeTheme bNDnodeTheme) {
        this.backgroundColor(nVGColor);
        this.regularTheme(bNDwidgetTheme);
        this.toolTheme(bNDwidgetTheme2);
        this.radioTheme(bNDwidgetTheme3);
        this.textFieldTheme(bNDwidgetTheme4);
        this.optionTheme(bNDwidgetTheme5);
        this.choiceTheme(bNDwidgetTheme6);
        this.numberFieldTheme(bNDwidgetTheme7);
        this.sliderTheme(bNDwidgetTheme8);
        this.scrollBarTheme(bNDwidgetTheme9);
        this.tooltipTheme(bNDwidgetTheme10);
        this.menuTheme(bNDwidgetTheme11);
        this.menuItemTheme(bNDwidgetTheme12);
        this.nodeTheme(bNDnodeTheme);
        return this;
    }

    public BNDtheme set(BNDtheme bNDtheme) {
        MemoryUtil.memCopy(bNDtheme.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDtheme malloc() {
        return new BNDtheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDtheme calloc() {
        return new BNDtheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDtheme create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDtheme(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static BNDtheme create(long l) {
        return new BNDtheme(l, null);
    }

    public static @Nullable BNDtheme createSafe(long l) {
        return l == 0L ? null : new BNDtheme(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDtheme.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = BNDtheme.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static BNDtheme mallocStack() {
        return BNDtheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDtheme callocStack() {
        return BNDtheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDtheme mallocStack(MemoryStack memoryStack) {
        return BNDtheme.malloc(memoryStack);
    }

    @Deprecated
    public static BNDtheme callocStack(MemoryStack memoryStack) {
        return BNDtheme.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return BNDtheme.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return BNDtheme.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return BNDtheme.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return BNDtheme.calloc(n, memoryStack);
    }

    public static BNDtheme malloc(MemoryStack memoryStack) {
        return new BNDtheme(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDtheme calloc(MemoryStack memoryStack) {
        return new BNDtheme(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static NVGColor nbackgroundColor(long l) {
        return NVGColor.create(l + (long)BACKGROUNDCOLOR);
    }

    public static BNDwidgetTheme nregularTheme(long l) {
        return BNDwidgetTheme.create(l + (long)REGULARTHEME);
    }

    public static BNDwidgetTheme ntoolTheme(long l) {
        return BNDwidgetTheme.create(l + (long)TOOLTHEME);
    }

    public static BNDwidgetTheme nradioTheme(long l) {
        return BNDwidgetTheme.create(l + (long)RADIOTHEME);
    }

    public static BNDwidgetTheme ntextFieldTheme(long l) {
        return BNDwidgetTheme.create(l + (long)TEXTFIELDTHEME);
    }

    public static BNDwidgetTheme noptionTheme(long l) {
        return BNDwidgetTheme.create(l + (long)OPTIONTHEME);
    }

    public static BNDwidgetTheme nchoiceTheme(long l) {
        return BNDwidgetTheme.create(l + (long)CHOICETHEME);
    }

    public static BNDwidgetTheme nnumberFieldTheme(long l) {
        return BNDwidgetTheme.create(l + (long)NUMBERFIELDTHEME);
    }

    public static BNDwidgetTheme nsliderTheme(long l) {
        return BNDwidgetTheme.create(l + (long)SLIDERTHEME);
    }

    public static BNDwidgetTheme nscrollBarTheme(long l) {
        return BNDwidgetTheme.create(l + (long)SCROLLBARTHEME);
    }

    public static BNDwidgetTheme ntooltipTheme(long l) {
        return BNDwidgetTheme.create(l + (long)TOOLTIPTHEME);
    }

    public static BNDwidgetTheme nmenuTheme(long l) {
        return BNDwidgetTheme.create(l + (long)MENUTHEME);
    }

    public static BNDwidgetTheme nmenuItemTheme(long l) {
        return BNDwidgetTheme.create(l + (long)MENUITEMTHEME);
    }

    public static BNDnodeTheme nnodeTheme(long l) {
        return BNDnodeTheme.create(l + (long)NODETHEME);
    }

    public static void nbackgroundColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)BACKGROUNDCOLOR, NVGColor.SIZEOF);
    }

    public static void nregularTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)REGULARTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntoolTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)TOOLTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nradioTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)RADIOTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntextFieldTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)TEXTFIELDTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void noptionTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)OPTIONTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nchoiceTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)CHOICETHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nnumberFieldTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)NUMBERFIELDTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nsliderTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)SLIDERTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nscrollBarTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)SCROLLBARTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void ntooltipTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)TOOLTIPTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nmenuTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)MENUTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nmenuItemTheme(long l, BNDwidgetTheme bNDwidgetTheme) {
        MemoryUtil.memCopy(bNDwidgetTheme.address(), l + (long)MENUITEMTHEME, BNDwidgetTheme.SIZEOF);
    }

    public static void nnodeTheme(long l, BNDnodeTheme bNDnodeTheme) {
        MemoryUtil.memCopy(bNDnodeTheme.address(), l + (long)NODETHEME, BNDnodeTheme.SIZEOF);
    }

    static {
        Struct.Layout layout = BNDtheme.__struct(BNDtheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDwidgetTheme.SIZEOF, BNDwidgetTheme.ALIGNOF), BNDtheme.__member(BNDnodeTheme.SIZEOF, BNDnodeTheme.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        BACKGROUNDCOLOR = layout.offsetof(0);
        REGULARTHEME = layout.offsetof(1);
        TOOLTHEME = layout.offsetof(2);
        RADIOTHEME = layout.offsetof(3);
        TEXTFIELDTHEME = layout.offsetof(4);
        OPTIONTHEME = layout.offsetof(5);
        CHOICETHEME = layout.offsetof(6);
        NUMBERFIELDTHEME = layout.offsetof(7);
        SLIDERTHEME = layout.offsetof(8);
        SCROLLBARTHEME = layout.offsetof(9);
        TOOLTIPTHEME = layout.offsetof(10);
        MENUTHEME = layout.offsetof(11);
        MENUITEMTHEME = layout.offsetof(12);
        NODETHEME = layout.offsetof(13);
    }

    public static class Buffer
    extends StructBuffer<BNDtheme, Buffer>
    implements NativeResource {
        private static final BNDtheme ELEMENT_FACTORY = BNDtheme.create(-1L);

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
        protected BNDtheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor backgroundColor() {
            return BNDtheme.nbackgroundColor(this.address());
        }

        public BNDwidgetTheme regularTheme() {
            return BNDtheme.nregularTheme(this.address());
        }

        public BNDwidgetTheme toolTheme() {
            return BNDtheme.ntoolTheme(this.address());
        }

        public BNDwidgetTheme radioTheme() {
            return BNDtheme.nradioTheme(this.address());
        }

        public BNDwidgetTheme textFieldTheme() {
            return BNDtheme.ntextFieldTheme(this.address());
        }

        public BNDwidgetTheme optionTheme() {
            return BNDtheme.noptionTheme(this.address());
        }

        public BNDwidgetTheme choiceTheme() {
            return BNDtheme.nchoiceTheme(this.address());
        }

        public BNDwidgetTheme numberFieldTheme() {
            return BNDtheme.nnumberFieldTheme(this.address());
        }

        public BNDwidgetTheme sliderTheme() {
            return BNDtheme.nsliderTheme(this.address());
        }

        public BNDwidgetTheme scrollBarTheme() {
            return BNDtheme.nscrollBarTheme(this.address());
        }

        public BNDwidgetTheme tooltipTheme() {
            return BNDtheme.ntooltipTheme(this.address());
        }

        public BNDwidgetTheme menuTheme() {
            return BNDtheme.nmenuTheme(this.address());
        }

        public BNDwidgetTheme menuItemTheme() {
            return BNDtheme.nmenuItemTheme(this.address());
        }

        public BNDnodeTheme nodeTheme() {
            return BNDtheme.nnodeTheme(this.address());
        }

        public Buffer backgroundColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDtheme.nbackgroundColor(this.address(), nVGColor);
            return this;
        }

        public Buffer backgroundColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.backgroundColor());
            return this;
        }

        public Buffer regularTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nregularTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer regularTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.regularTheme());
            return this;
        }

        public Buffer toolTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.ntoolTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer toolTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.toolTheme());
            return this;
        }

        public Buffer radioTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nradioTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer radioTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.radioTheme());
            return this;
        }

        public Buffer textFieldTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.ntextFieldTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer textFieldTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.textFieldTheme());
            return this;
        }

        public Buffer optionTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.noptionTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer optionTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.optionTheme());
            return this;
        }

        public Buffer choiceTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nchoiceTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer choiceTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.choiceTheme());
            return this;
        }

        public Buffer numberFieldTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nnumberFieldTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer numberFieldTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.numberFieldTheme());
            return this;
        }

        public Buffer sliderTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nsliderTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer sliderTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.sliderTheme());
            return this;
        }

        public Buffer scrollBarTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nscrollBarTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer scrollBarTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.scrollBarTheme());
            return this;
        }

        public Buffer tooltipTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.ntooltipTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer tooltipTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.tooltipTheme());
            return this;
        }

        public Buffer menuTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nmenuTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer menuTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.menuTheme());
            return this;
        }

        public Buffer menuItemTheme(BNDwidgetTheme bNDwidgetTheme) {
            BNDtheme.nmenuItemTheme(this.address(), bNDwidgetTheme);
            return this;
        }

        public Buffer menuItemTheme(Consumer<BNDwidgetTheme> consumer) {
            consumer.accept(this.menuItemTheme());
            return this;
        }

        public Buffer nodeTheme(BNDnodeTheme bNDnodeTheme) {
            BNDtheme.nnodeTheme(this.address(), bNDnodeTheme);
            return this;
        }

        public Buffer nodeTheme(Consumer<BNDnodeTheme> consumer) {
            consumer.accept(this.nodeTheme());
            return this;
        }
    }
}

