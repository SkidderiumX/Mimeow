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
import org.lwjgl.system.windows.POINT;
import org.lwjgl.system.windows.RECT;

public class WINDOWPLACEMENT
extends Struct<WINDOWPLACEMENT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int LENGTH;
    public static final int FLAGS;
    public static final int SHOWCMD;
    public static final int PTMINPOSITION;
    public static final int PTMAXPOSITION;
    public static final int RCNORMALPOSITION;

    protected WINDOWPLACEMENT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected WINDOWPLACEMENT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new WINDOWPLACEMENT(l, byteBuffer);
    }

    public WINDOWPLACEMENT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), WINDOWPLACEMENT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="UINT")
    public int length() {
        return WINDOWPLACEMENT.nlength(this.address());
    }

    @NativeType(value="UINT")
    public int flags() {
        return WINDOWPLACEMENT.nflags(this.address());
    }

    @NativeType(value="UINT")
    public int showCmd() {
        return WINDOWPLACEMENT.nshowCmd(this.address());
    }

    public POINT ptMinPosition() {
        return WINDOWPLACEMENT.nptMinPosition(this.address());
    }

    public POINT ptMaxPosition() {
        return WINDOWPLACEMENT.nptMaxPosition(this.address());
    }

    public RECT rcNormalPosition() {
        return WINDOWPLACEMENT.nrcNormalPosition(this.address());
    }

    public WINDOWPLACEMENT length(@NativeType(value="UINT") int n) {
        WINDOWPLACEMENT.nlength(this.address(), n);
        return this;
    }

    public WINDOWPLACEMENT flags(@NativeType(value="UINT") int n) {
        WINDOWPLACEMENT.nflags(this.address(), n);
        return this;
    }

    public WINDOWPLACEMENT showCmd(@NativeType(value="UINT") int n) {
        WINDOWPLACEMENT.nshowCmd(this.address(), n);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(POINT pOINT) {
        WINDOWPLACEMENT.nptMinPosition(this.address(), pOINT);
        return this;
    }

    public WINDOWPLACEMENT ptMinPosition(Consumer<POINT> consumer) {
        consumer.accept(this.ptMinPosition());
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(POINT pOINT) {
        WINDOWPLACEMENT.nptMaxPosition(this.address(), pOINT);
        return this;
    }

    public WINDOWPLACEMENT ptMaxPosition(Consumer<POINT> consumer) {
        consumer.accept(this.ptMaxPosition());
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(RECT rECT) {
        WINDOWPLACEMENT.nrcNormalPosition(this.address(), rECT);
        return this;
    }

    public WINDOWPLACEMENT rcNormalPosition(Consumer<RECT> consumer) {
        consumer.accept(this.rcNormalPosition());
        return this;
    }

    public WINDOWPLACEMENT set(int n, int n2, int n3, POINT pOINT, POINT pOINT2, RECT rECT) {
        this.length(n);
        this.flags(n2);
        this.showCmd(n3);
        this.ptMinPosition(pOINT);
        this.ptMaxPosition(pOINT2);
        this.rcNormalPosition(rECT);
        return this;
    }

    public WINDOWPLACEMENT set(WINDOWPLACEMENT wINDOWPLACEMENT) {
        MemoryUtil.memCopy(wINDOWPLACEMENT.address(), this.address(), SIZEOF);
        return this;
    }

    public static WINDOWPLACEMENT malloc() {
        return new WINDOWPLACEMENT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static WINDOWPLACEMENT calloc() {
        return new WINDOWPLACEMENT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static WINDOWPLACEMENT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new WINDOWPLACEMENT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static WINDOWPLACEMENT create(long l) {
        return new WINDOWPLACEMENT(l, null);
    }

    public static @Nullable WINDOWPLACEMENT createSafe(long l) {
        return l == 0L ? null : new WINDOWPLACEMENT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(WINDOWPLACEMENT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = WINDOWPLACEMENT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static WINDOWPLACEMENT mallocStack() {
        return WINDOWPLACEMENT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack() {
        return WINDOWPLACEMENT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static WINDOWPLACEMENT mallocStack(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.malloc(memoryStack);
    }

    @Deprecated
    public static WINDOWPLACEMENT callocStack(MemoryStack memoryStack) {
        return WINDOWPLACEMENT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return WINDOWPLACEMENT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return WINDOWPLACEMENT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return WINDOWPLACEMENT.calloc(n, memoryStack);
    }

    public static WINDOWPLACEMENT malloc(MemoryStack memoryStack) {
        return new WINDOWPLACEMENT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static WINDOWPLACEMENT calloc(MemoryStack memoryStack) {
        return new WINDOWPLACEMENT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nlength(long l) {
        return MemoryUtil.memGetInt(l + (long)LENGTH);
    }

    public static int nflags(long l) {
        return MemoryUtil.memGetInt(l + (long)FLAGS);
    }

    public static int nshowCmd(long l) {
        return MemoryUtil.memGetInt(l + (long)SHOWCMD);
    }

    public static POINT nptMinPosition(long l) {
        return POINT.create(l + (long)PTMINPOSITION);
    }

    public static POINT nptMaxPosition(long l) {
        return POINT.create(l + (long)PTMAXPOSITION);
    }

    public static RECT nrcNormalPosition(long l) {
        return RECT.create(l + (long)RCNORMALPOSITION);
    }

    public static void nlength(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LENGTH, n);
    }

    public static void nflags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FLAGS, n);
    }

    public static void nshowCmd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SHOWCMD, n);
    }

    public static void nptMinPosition(long l, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l + (long)PTMINPOSITION, POINT.SIZEOF);
    }

    public static void nptMaxPosition(long l, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l + (long)PTMAXPOSITION, POINT.SIZEOF);
    }

    public static void nrcNormalPosition(long l, RECT rECT) {
        MemoryUtil.memCopy(rECT.address(), l + (long)RCNORMALPOSITION, RECT.SIZEOF);
    }

    static {
        Struct.Layout layout = WINDOWPLACEMENT.__struct(WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(4), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(POINT.SIZEOF, POINT.ALIGNOF), WINDOWPLACEMENT.__member(RECT.SIZEOF, RECT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        LENGTH = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        SHOWCMD = layout.offsetof(2);
        PTMINPOSITION = layout.offsetof(3);
        PTMAXPOSITION = layout.offsetof(4);
        RCNORMALPOSITION = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<WINDOWPLACEMENT, Buffer>
    implements NativeResource {
        private static final WINDOWPLACEMENT ELEMENT_FACTORY = WINDOWPLACEMENT.create(-1L);

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
        protected WINDOWPLACEMENT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="UINT")
        public int length() {
            return WINDOWPLACEMENT.nlength(this.address());
        }

        @NativeType(value="UINT")
        public int flags() {
            return WINDOWPLACEMENT.nflags(this.address());
        }

        @NativeType(value="UINT")
        public int showCmd() {
            return WINDOWPLACEMENT.nshowCmd(this.address());
        }

        public POINT ptMinPosition() {
            return WINDOWPLACEMENT.nptMinPosition(this.address());
        }

        public POINT ptMaxPosition() {
            return WINDOWPLACEMENT.nptMaxPosition(this.address());
        }

        public RECT rcNormalPosition() {
            return WINDOWPLACEMENT.nrcNormalPosition(this.address());
        }

        public Buffer length(@NativeType(value="UINT") int n) {
            WINDOWPLACEMENT.nlength(this.address(), n);
            return this;
        }

        public Buffer flags(@NativeType(value="UINT") int n) {
            WINDOWPLACEMENT.nflags(this.address(), n);
            return this;
        }

        public Buffer showCmd(@NativeType(value="UINT") int n) {
            WINDOWPLACEMENT.nshowCmd(this.address(), n);
            return this;
        }

        public Buffer ptMinPosition(POINT pOINT) {
            WINDOWPLACEMENT.nptMinPosition(this.address(), pOINT);
            return this;
        }

        public Buffer ptMinPosition(Consumer<POINT> consumer) {
            consumer.accept(this.ptMinPosition());
            return this;
        }

        public Buffer ptMaxPosition(POINT pOINT) {
            WINDOWPLACEMENT.nptMaxPosition(this.address(), pOINT);
            return this;
        }

        public Buffer ptMaxPosition(Consumer<POINT> consumer) {
            consumer.accept(this.ptMaxPosition());
            return this;
        }

        public Buffer rcNormalPosition(RECT rECT) {
            WINDOWPLACEMENT.nrcNormalPosition(this.address(), rECT);
            return this;
        }

        public Buffer rcNormalPosition(Consumer<RECT> consumer) {
            consumer.accept(this.rcNormalPosition());
            return this;
        }
    }
}

