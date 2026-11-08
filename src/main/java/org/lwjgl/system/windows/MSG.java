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

public class MSG
extends Struct<MSG>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int HWND;
    public static final int MESSAGE;
    public static final int WPARAM;
    public static final int LPARAM;
    public static final int TIME;
    public static final int PT;

    protected MSG(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected MSG create(long l, @Nullable ByteBuffer byteBuffer) {
        return new MSG(l, byteBuffer);
    }

    public MSG(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), MSG.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="HWND")
    public long hwnd() {
        return MSG.nhwnd(this.address());
    }

    @NativeType(value="UINT")
    public int message() {
        return MSG.nmessage(this.address());
    }

    @NativeType(value="WPARAM")
    public long wParam() {
        return MSG.nwParam(this.address());
    }

    @NativeType(value="LPARAM")
    public long lParam() {
        return MSG.nlParam(this.address());
    }

    @NativeType(value="DWORD")
    public int time() {
        return MSG.ntime(this.address());
    }

    public POINT pt() {
        return MSG.npt(this.address());
    }

    public MSG hwnd(@NativeType(value="HWND") long l) {
        MSG.nhwnd(this.address(), l);
        return this;
    }

    public MSG message(@NativeType(value="UINT") int n) {
        MSG.nmessage(this.address(), n);
        return this;
    }

    public MSG wParam(@NativeType(value="WPARAM") long l) {
        MSG.nwParam(this.address(), l);
        return this;
    }

    public MSG lParam(@NativeType(value="LPARAM") long l) {
        MSG.nlParam(this.address(), l);
        return this;
    }

    public MSG time(@NativeType(value="DWORD") int n) {
        MSG.ntime(this.address(), n);
        return this;
    }

    public MSG pt(POINT pOINT) {
        MSG.npt(this.address(), pOINT);
        return this;
    }

    public MSG pt(Consumer<POINT> consumer) {
        consumer.accept(this.pt());
        return this;
    }

    public MSG set(long l, int n, long l2, long l3, int n2, POINT pOINT) {
        this.hwnd(l);
        this.message(n);
        this.wParam(l2);
        this.lParam(l3);
        this.time(n2);
        this.pt(pOINT);
        return this;
    }

    public MSG set(MSG mSG) {
        MemoryUtil.memCopy(mSG.address(), this.address(), SIZEOF);
        return this;
    }

    public static MSG malloc() {
        return new MSG(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static MSG calloc() {
        return new MSG(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static MSG create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new MSG(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static MSG create(long l) {
        return new MSG(l, null);
    }

    public static @Nullable MSG createSafe(long l) {
        return l == 0L ? null : new MSG(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(MSG.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = MSG.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static MSG mallocStack() {
        return MSG.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG callocStack() {
        return MSG.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static MSG mallocStack(MemoryStack memoryStack) {
        return MSG.malloc(memoryStack);
    }

    @Deprecated
    public static MSG callocStack(MemoryStack memoryStack) {
        return MSG.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return MSG.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return MSG.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return MSG.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return MSG.calloc(n, memoryStack);
    }

    public static MSG malloc(MemoryStack memoryStack) {
        return new MSG(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static MSG calloc(MemoryStack memoryStack) {
        return new MSG(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long nhwnd(long l) {
        return MemoryUtil.memGetAddress(l + (long)HWND);
    }

    public static int nmessage(long l) {
        return MemoryUtil.memGetInt(l + (long)MESSAGE);
    }

    public static long nwParam(long l) {
        return MemoryUtil.memGetAddress(l + (long)WPARAM);
    }

    public static long nlParam(long l) {
        return MemoryUtil.memGetAddress(l + (long)LPARAM);
    }

    public static int ntime(long l) {
        return MemoryUtil.memGetInt(l + (long)TIME);
    }

    public static POINT npt(long l) {
        return POINT.create(l + (long)PT);
    }

    public static void nhwnd(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)HWND, l2);
    }

    public static void nmessage(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MESSAGE, n);
    }

    public static void nwParam(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)WPARAM, l2);
    }

    public static void nlParam(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)LPARAM, l2);
    }

    public static void ntime(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TIME, n);
    }

    public static void npt(long l, POINT pOINT) {
        MemoryUtil.memCopy(pOINT.address(), l + (long)PT, POINT.SIZEOF);
    }

    static {
        Struct.Layout layout = MSG.__struct(MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINTER_SIZE), MSG.__member(POINTER_SIZE), MSG.__member(4), MSG.__member(POINT.SIZEOF, POINT.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        HWND = layout.offsetof(0);
        MESSAGE = layout.offsetof(1);
        WPARAM = layout.offsetof(2);
        LPARAM = layout.offsetof(3);
        TIME = layout.offsetof(4);
        PT = layout.offsetof(5);
    }

    public static class Buffer
    extends StructBuffer<MSG, Buffer>
    implements NativeResource {
        private static final MSG ELEMENT_FACTORY = MSG.create(-1L);

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
        protected MSG getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="HWND")
        public long hwnd() {
            return MSG.nhwnd(this.address());
        }

        @NativeType(value="UINT")
        public int message() {
            return MSG.nmessage(this.address());
        }

        @NativeType(value="WPARAM")
        public long wParam() {
            return MSG.nwParam(this.address());
        }

        @NativeType(value="LPARAM")
        public long lParam() {
            return MSG.nlParam(this.address());
        }

        @NativeType(value="DWORD")
        public int time() {
            return MSG.ntime(this.address());
        }

        public POINT pt() {
            return MSG.npt(this.address());
        }

        public Buffer hwnd(@NativeType(value="HWND") long l) {
            MSG.nhwnd(this.address(), l);
            return this;
        }

        public Buffer message(@NativeType(value="UINT") int n) {
            MSG.nmessage(this.address(), n);
            return this;
        }

        public Buffer wParam(@NativeType(value="WPARAM") long l) {
            MSG.nwParam(this.address(), l);
            return this;
        }

        public Buffer lParam(@NativeType(value="LPARAM") long l) {
            MSG.nlParam(this.address(), l);
            return this;
        }

        public Buffer time(@NativeType(value="DWORD") int n) {
            MSG.ntime(this.address(), n);
            return this;
        }

        public Buffer pt(POINT pOINT) {
            MSG.npt(this.address(), pOINT);
            return this;
        }

        public Buffer pt(Consumer<POINT> consumer) {
            consumer.accept(this.pt());
            return this;
        }
    }
}

