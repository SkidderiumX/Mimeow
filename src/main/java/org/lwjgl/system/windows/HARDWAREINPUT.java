/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class HARDWAREINPUT
extends Struct<HARDWAREINPUT>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int UMSG;
    public static final int WPARAML;
    public static final int WPARAMH;

    protected HARDWAREINPUT(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected HARDWAREINPUT create(long l, @Nullable ByteBuffer byteBuffer) {
        return new HARDWAREINPUT(l, byteBuffer);
    }

    public HARDWAREINPUT(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), HARDWAREINPUT.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="DWORD")
    public int uMsg() {
        return HARDWAREINPUT.nuMsg(this.address());
    }

    @NativeType(value="WORD")
    public short wParamL() {
        return HARDWAREINPUT.nwParamL(this.address());
    }

    @NativeType(value="WORD")
    public short wParamH() {
        return HARDWAREINPUT.nwParamH(this.address());
    }

    public HARDWAREINPUT uMsg(@NativeType(value="DWORD") int n) {
        HARDWAREINPUT.nuMsg(this.address(), n);
        return this;
    }

    public HARDWAREINPUT wParamL(@NativeType(value="WORD") short s) {
        HARDWAREINPUT.nwParamL(this.address(), s);
        return this;
    }

    public HARDWAREINPUT wParamH(@NativeType(value="WORD") short s) {
        HARDWAREINPUT.nwParamH(this.address(), s);
        return this;
    }

    public HARDWAREINPUT set(int n, short s, short s2) {
        this.uMsg(n);
        this.wParamL(s);
        this.wParamH(s2);
        return this;
    }

    public HARDWAREINPUT set(HARDWAREINPUT hARDWAREINPUT) {
        MemoryUtil.memCopy(hARDWAREINPUT.address(), this.address(), SIZEOF);
        return this;
    }

    public static HARDWAREINPUT malloc() {
        return new HARDWAREINPUT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static HARDWAREINPUT calloc() {
        return new HARDWAREINPUT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static HARDWAREINPUT create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new HARDWAREINPUT(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static HARDWAREINPUT create(long l) {
        return new HARDWAREINPUT(l, null);
    }

    public static @Nullable HARDWAREINPUT createSafe(long l) {
        return l == 0L ? null : new HARDWAREINPUT(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(HARDWAREINPUT.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = HARDWAREINPUT.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static HARDWAREINPUT mallocStack() {
        return HARDWAREINPUT.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT callocStack() {
        return HARDWAREINPUT.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static HARDWAREINPUT mallocStack(MemoryStack memoryStack) {
        return HARDWAREINPUT.malloc(memoryStack);
    }

    @Deprecated
    public static HARDWAREINPUT callocStack(MemoryStack memoryStack) {
        return HARDWAREINPUT.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return HARDWAREINPUT.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return HARDWAREINPUT.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return HARDWAREINPUT.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return HARDWAREINPUT.calloc(n, memoryStack);
    }

    public static HARDWAREINPUT malloc(MemoryStack memoryStack) {
        return new HARDWAREINPUT(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static HARDWAREINPUT calloc(MemoryStack memoryStack) {
        return new HARDWAREINPUT(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nuMsg(long l) {
        return MemoryUtil.memGetInt(l + (long)UMSG);
    }

    public static short nwParamL(long l) {
        return MemoryUtil.memGetShort(l + (long)WPARAML);
    }

    public static short nwParamH(long l) {
        return MemoryUtil.memGetShort(l + (long)WPARAMH);
    }

    public static void nuMsg(long l, int n) {
        MemoryUtil.memPutInt(l + (long)UMSG, n);
    }

    public static void nwParamL(long l, short s) {
        MemoryUtil.memPutShort(l + (long)WPARAML, s);
    }

    public static void nwParamH(long l, short s) {
        MemoryUtil.memPutShort(l + (long)WPARAMH, s);
    }

    static {
        Struct.Layout layout = HARDWAREINPUT.__struct(HARDWAREINPUT.__member(4), HARDWAREINPUT.__member(2), HARDWAREINPUT.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        UMSG = layout.offsetof(0);
        WPARAML = layout.offsetof(1);
        WPARAMH = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<HARDWAREINPUT, Buffer>
    implements NativeResource {
        private static final HARDWAREINPUT ELEMENT_FACTORY = HARDWAREINPUT.create(-1L);

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
        protected HARDWAREINPUT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="DWORD")
        public int uMsg() {
            return HARDWAREINPUT.nuMsg(this.address());
        }

        @NativeType(value="WORD")
        public short wParamL() {
            return HARDWAREINPUT.nwParamL(this.address());
        }

        @NativeType(value="WORD")
        public short wParamH() {
            return HARDWAREINPUT.nwParamH(this.address());
        }

        public Buffer uMsg(@NativeType(value="DWORD") int n) {
            HARDWAREINPUT.nuMsg(this.address(), n);
            return this;
        }

        public Buffer wParamL(@NativeType(value="WORD") short s) {
            HARDWAREINPUT.nwParamL(this.address(), s);
            return this;
        }

        public Buffer wParamH(@NativeType(value="WORD") short s) {
            HARDWAREINPUT.nwParamH(this.address(), s);
            return this;
        }
    }
}

