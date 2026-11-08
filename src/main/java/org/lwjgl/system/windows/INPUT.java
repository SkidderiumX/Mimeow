/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.windows.HARDWAREINPUT;
import org.lwjgl.system.windows.KEYBDINPUT;
import org.lwjgl.system.windows.MOUSEINPUT;

public class INPUT
extends Struct<INPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int DUMMYUNIONNAME;
    public static final int DUMMYUNIONNAME_MI;
    public static final int DUMMYUNIONNAME_KI;
    public static final int DUMMYUNIONNAME_HI;

    protected INPUT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected INPUT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new INPUT(l, byteBuffer);
    }

    public INPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), INPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int type() {
        return INPUT.ntype(this.address());
    }

    public MOUSEINPUT DUMMYUNIONNAME_mi() {
        return INPUT.nDUMMYUNIONNAME_mi(this.address());
    }

    public KEYBDINPUT DUMMYUNIONNAME_ki() {
        return INPUT.nDUMMYUNIONNAME_ki(this.address());
    }

    public HARDWAREINPUT DUMMYUNIONNAME_hi() {
        return INPUT.nDUMMYUNIONNAME_hi(this.address());
    }

    public INPUT type(@NativeType(value="DWORD") int n) {
        INPUT.ntype(this.address(), n);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(MOUSEINPUT mOUSEINPUT) {
        INPUT.nDUMMYUNIONNAME_mi(this.address(), mOUSEINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_mi());
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(KEYBDINPUT kEYBDINPUT) {
        INPUT.nDUMMYUNIONNAME_ki(this.address(), kEYBDINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_ki());
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(HARDWAREINPUT hARDWAREINPUT) {
        INPUT.nDUMMYUNIONNAME_hi(this.address(), hARDWAREINPUT);
        return this;
    }

    public INPUT DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
        consumer.accept(this.DUMMYUNIONNAME_hi());
        return this;
    }

    public INPUT set(INPUT iNPUT) {
        MemoryUtil.memCopy(iNPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static INPUT malloc() {
        return new INPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static INPUT calloc() {
        return new INPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static INPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new INPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static INPUT create(long l) {
        return new INPUT(l, null);
    }

    public static @Nullable INPUT createSafe(long l) {
        return l == 0L ? null : new INPUT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(INPUT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = INPUT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static INPUT mallocStack() {
        return INPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT callocStack() {
        return INPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static INPUT mallocStack(MemoryStack memoryStack) {
        return INPUT.malloc(memoryStack);
    }

    @Deprecated
    public static INPUT callocStack(MemoryStack memoryStack) {
        return INPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return INPUT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return INPUT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return INPUT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return INPUT.calloc(n, memoryStack);
    }

    public static INPUT malloc(MemoryStack memoryStack) {
        return new INPUT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static INPUT calloc(MemoryStack memoryStack) {
        return new INPUT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ntype(long l) {
        return MemoryUtil.memGetInt(l + (long)TYPE);
    }

    public static MOUSEINPUT nDUMMYUNIONNAME_mi(long l) {
        return MOUSEINPUT.create(l + (long)DUMMYUNIONNAME_MI);
    }

    public static KEYBDINPUT nDUMMYUNIONNAME_ki(long l) {
        return KEYBDINPUT.create(l + (long)DUMMYUNIONNAME_KI);
    }

    public static HARDWAREINPUT nDUMMYUNIONNAME_hi(long l) {
        return HARDWAREINPUT.create(l + (long)DUMMYUNIONNAME_HI);
    }

    public static void ntype(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TYPE, n);
    }

    public static void nDUMMYUNIONNAME_mi(long l, MOUSEINPUT mOUSEINPUT) {
        MemoryUtil.memCopy(mOUSEINPUT.address(), l + (long)DUMMYUNIONNAME_MI, MOUSEINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_ki(long l, KEYBDINPUT kEYBDINPUT) {
        MemoryUtil.memCopy(kEYBDINPUT.address(), l + (long)DUMMYUNIONNAME_KI, KEYBDINPUT.SIZEOF);
    }

    public static void nDUMMYUNIONNAME_hi(long l, HARDWAREINPUT hARDWAREINPUT) {
        MemoryUtil.memCopy(hARDWAREINPUT.address(), l + (long)DUMMYUNIONNAME_HI, HARDWAREINPUT.SIZEOF);
    }

    static {
        Struct.Layout layout = INPUT.__struct(INPUT.__member(4), INPUT.__union(INPUT.__member(MOUSEINPUT.SIZEOF, MOUSEINPUT.ALIGNOF), INPUT.__member(KEYBDINPUT.SIZEOF, KEYBDINPUT.ALIGNOF), INPUT.__member(HARDWAREINPUT.SIZEOF, HARDWAREINPUT.ALIGNOF)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        DUMMYUNIONNAME = layout.offsetof(1);
        DUMMYUNIONNAME_MI = layout.offsetof(2);
        DUMMYUNIONNAME_KI = layout.offsetof(3);
        DUMMYUNIONNAME_HI = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<INPUT, Buffer>
    implements NativeResource {
        private static final INPUT ELEMENT_FACTORY = INPUT.create(-1L);

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
        protected INPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int type() {
            return INPUT.ntype(this.address());
        }

        public MOUSEINPUT DUMMYUNIONNAME_mi() {
            return INPUT.nDUMMYUNIONNAME_mi(this.address());
        }

        public KEYBDINPUT DUMMYUNIONNAME_ki() {
            return INPUT.nDUMMYUNIONNAME_ki(this.address());
        }

        public HARDWAREINPUT DUMMYUNIONNAME_hi() {
            return INPUT.nDUMMYUNIONNAME_hi(this.address());
        }

        public Buffer type(@NativeType(value="DWORD") int n) {
            INPUT.ntype(this.address(), n);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(MOUSEINPUT mOUSEINPUT) {
            INPUT.nDUMMYUNIONNAME_mi(this.address(), mOUSEINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_mi(Consumer<MOUSEINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_mi());
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(KEYBDINPUT kEYBDINPUT) {
            INPUT.nDUMMYUNIONNAME_ki(this.address(), kEYBDINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_ki(Consumer<KEYBDINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_ki());
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(HARDWAREINPUT hARDWAREINPUT) {
            INPUT.nDUMMYUNIONNAME_hi(this.address(), hARDWAREINPUT);
            return this;
        }

        public Buffer DUMMYUNIONNAME_hi(Consumer<HARDWAREINPUT> consumer) {
            consumer.accept(this.DUMMYUNIONNAME_hi());
            return this;
        }
    }
}

