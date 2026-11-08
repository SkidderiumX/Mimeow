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

public class BNDnodeTheme
extends Struct<BNDnodeTheme>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int NODESELECTEDCOLOR;
    public static final int WIRESCOLOR;
    public static final int TEXTSELECTEDCOLOR;
    public static final int ACTIVENODECOLOR;
    public static final int WIRESELECTCOLOR;
    public static final int NODEBACKDROPCOLOR;
    public static final int NOODLECURVING;

    protected BNDnodeTheme(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected BNDnodeTheme create(long l, @Nullable ByteBuffer byteBuffer) {
        return new BNDnodeTheme(l, byteBuffer);
    }

    public BNDnodeTheme(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), BNDnodeTheme.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="NVGcolor")
    public NVGColor nodeSelectedColor() {
        return BNDnodeTheme.nnodeSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor wiresColor() {
        return BNDnodeTheme.nwiresColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor textSelectedColor() {
        return BNDnodeTheme.ntextSelectedColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor activeNodeColor() {
        return BNDnodeTheme.nactiveNodeColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor wireSelectColor() {
        return BNDnodeTheme.nwireSelectColor(this.address());
    }

    @NativeType(value="NVGcolor")
    public NVGColor nodeBackdropColor() {
        return BNDnodeTheme.nnodeBackdropColor(this.address());
    }

    public int noodleCurving() {
        return BNDnodeTheme.nnoodleCurving(this.address());
    }

    public BNDnodeTheme nodeSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.nnodeSelectedColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme nodeSelectedColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.nodeSelectedColor());
        return this;
    }

    public BNDnodeTheme wiresColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.nwiresColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme wiresColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.wiresColor());
        return this;
    }

    public BNDnodeTheme textSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.ntextSelectedColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme textSelectedColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.textSelectedColor());
        return this;
    }

    public BNDnodeTheme activeNodeColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.nactiveNodeColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme activeNodeColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.activeNodeColor());
        return this;
    }

    public BNDnodeTheme wireSelectColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.nwireSelectColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme wireSelectColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.wireSelectColor());
        return this;
    }

    public BNDnodeTheme nodeBackdropColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
        BNDnodeTheme.nnodeBackdropColor(this.address(), nVGColor);
        return this;
    }

    public BNDnodeTheme nodeBackdropColor(Consumer<NVGColor> consumer) {
        consumer.accept(this.nodeBackdropColor());
        return this;
    }

    public BNDnodeTheme noodleCurving(int n) {
        BNDnodeTheme.nnoodleCurving(this.address(), n);
        return this;
    }

    public BNDnodeTheme set(NVGColor nVGColor, NVGColor nVGColor2, NVGColor nVGColor3, NVGColor nVGColor4, NVGColor nVGColor5, NVGColor nVGColor6, int n) {
        this.nodeSelectedColor(nVGColor);
        this.wiresColor(nVGColor2);
        this.textSelectedColor(nVGColor3);
        this.activeNodeColor(nVGColor4);
        this.wireSelectColor(nVGColor5);
        this.nodeBackdropColor(nVGColor6);
        this.noodleCurving(n);
        return this;
    }

    public BNDnodeTheme set(BNDnodeTheme bNDnodeTheme) {
        MemoryUtil.memCopy(bNDnodeTheme.address(), this.address(), SIZEOF);
        return this;
    }

    public static BNDnodeTheme malloc() {
        return new BNDnodeTheme(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static BNDnodeTheme calloc() {
        return new BNDnodeTheme(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static BNDnodeTheme create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new BNDnodeTheme(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static BNDnodeTheme create(long l) {
        return new BNDnodeTheme(l, null);
    }

    public static @Nullable BNDnodeTheme createSafe(long l) {
        return l == 0L ? null : new BNDnodeTheme(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(BNDnodeTheme.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = BNDnodeTheme.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static BNDnodeTheme mallocStack() {
        return BNDnodeTheme.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDnodeTheme callocStack() {
        return BNDnodeTheme.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static BNDnodeTheme mallocStack(MemoryStack memoryStack) {
        return BNDnodeTheme.malloc(memoryStack);
    }

    @Deprecated
    public static BNDnodeTheme callocStack(MemoryStack memoryStack) {
        return BNDnodeTheme.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return BNDnodeTheme.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return BNDnodeTheme.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return BNDnodeTheme.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return BNDnodeTheme.calloc(n, memoryStack);
    }

    public static BNDnodeTheme malloc(MemoryStack memoryStack) {
        return new BNDnodeTheme(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static BNDnodeTheme calloc(MemoryStack memoryStack) {
        return new BNDnodeTheme(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static NVGColor nnodeSelectedColor(long l) {
        return NVGColor.create(l + (long)NODESELECTEDCOLOR);
    }

    public static NVGColor nwiresColor(long l) {
        return NVGColor.create(l + (long)WIRESCOLOR);
    }

    public static NVGColor ntextSelectedColor(long l) {
        return NVGColor.create(l + (long)TEXTSELECTEDCOLOR);
    }

    public static NVGColor nactiveNodeColor(long l) {
        return NVGColor.create(l + (long)ACTIVENODECOLOR);
    }

    public static NVGColor nwireSelectColor(long l) {
        return NVGColor.create(l + (long)WIRESELECTCOLOR);
    }

    public static NVGColor nnodeBackdropColor(long l) {
        return NVGColor.create(l + (long)NODEBACKDROPCOLOR);
    }

    public static int nnoodleCurving(long l) {
        return MemoryUtil.memGetInt(l + (long)NOODLECURVING);
    }

    public static void nnodeSelectedColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)NODESELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nwiresColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)WIRESCOLOR, NVGColor.SIZEOF);
    }

    public static void ntextSelectedColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)TEXTSELECTEDCOLOR, NVGColor.SIZEOF);
    }

    public static void nactiveNodeColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)ACTIVENODECOLOR, NVGColor.SIZEOF);
    }

    public static void nwireSelectColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)WIRESELECTCOLOR, NVGColor.SIZEOF);
    }

    public static void nnodeBackdropColor(long l, NVGColor nVGColor) {
        MemoryUtil.memCopy(nVGColor.address(), l + (long)NODEBACKDROPCOLOR, NVGColor.SIZEOF);
    }

    public static void nnoodleCurving(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NOODLECURVING, n);
    }

    static {
        Struct.Layout layout = BNDnodeTheme.__struct(BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(NVGColor.SIZEOF, NVGColor.ALIGNOF), BNDnodeTheme.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        NODESELECTEDCOLOR = layout.offsetof(0);
        WIRESCOLOR = layout.offsetof(1);
        TEXTSELECTEDCOLOR = layout.offsetof(2);
        ACTIVENODECOLOR = layout.offsetof(3);
        WIRESELECTCOLOR = layout.offsetof(4);
        NODEBACKDROPCOLOR = layout.offsetof(5);
        NOODLECURVING = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<BNDnodeTheme, Buffer>
    implements NativeResource {
        private static final BNDnodeTheme ELEMENT_FACTORY = BNDnodeTheme.create(-1L);

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
        protected BNDnodeTheme getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="NVGcolor")
        public NVGColor nodeSelectedColor() {
            return BNDnodeTheme.nnodeSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor wiresColor() {
            return BNDnodeTheme.nwiresColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor textSelectedColor() {
            return BNDnodeTheme.ntextSelectedColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor activeNodeColor() {
            return BNDnodeTheme.nactiveNodeColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor wireSelectColor() {
            return BNDnodeTheme.nwireSelectColor(this.address());
        }

        @NativeType(value="NVGcolor")
        public NVGColor nodeBackdropColor() {
            return BNDnodeTheme.nnodeBackdropColor(this.address());
        }

        public int noodleCurving() {
            return BNDnodeTheme.nnoodleCurving(this.address());
        }

        public Buffer nodeSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.nnodeSelectedColor(this.address(), nVGColor);
            return this;
        }

        public Buffer nodeSelectedColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.nodeSelectedColor());
            return this;
        }

        public Buffer wiresColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.nwiresColor(this.address(), nVGColor);
            return this;
        }

        public Buffer wiresColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.wiresColor());
            return this;
        }

        public Buffer textSelectedColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.ntextSelectedColor(this.address(), nVGColor);
            return this;
        }

        public Buffer textSelectedColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.textSelectedColor());
            return this;
        }

        public Buffer activeNodeColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.nactiveNodeColor(this.address(), nVGColor);
            return this;
        }

        public Buffer activeNodeColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.activeNodeColor());
            return this;
        }

        public Buffer wireSelectColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.nwireSelectColor(this.address(), nVGColor);
            return this;
        }

        public Buffer wireSelectColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.wireSelectColor());
            return this;
        }

        public Buffer nodeBackdropColor(@NativeType(value="NVGcolor") NVGColor nVGColor) {
            BNDnodeTheme.nnodeBackdropColor(this.address(), nVGColor);
            return this;
        }

        public Buffer nodeBackdropColor(Consumer<NVGColor> consumer) {
            consumer.accept(this.nodeBackdropColor());
            return this;
        }

        public Buffer noodleCurving(int n) {
            BNDnodeTheme.nnoodleCurving(this.address(), n);
            return this;
        }
    }
}

