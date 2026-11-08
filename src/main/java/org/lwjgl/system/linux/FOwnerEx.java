/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct f_owner_ex")
public class FOwnerEx
extends Struct<FOwnerEx>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TYPE;
    public static final int PID;

    protected FOwnerEx(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected FOwnerEx create(long l, @Nullable ByteBuffer byteBuffer) {
        return new FOwnerEx(l, byteBuffer);
    }

    public FOwnerEx(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), FOwnerEx.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public int type() {
        return FOwnerEx.ntype(this.address());
    }

    @NativeType(value="pid_t")
    public int pid() {
        return FOwnerEx.npid(this.address());
    }

    public FOwnerEx type(int n) {
        FOwnerEx.ntype(this.address(), n);
        return this;
    }

    public FOwnerEx pid(@NativeType(value="pid_t") int n) {
        FOwnerEx.npid(this.address(), n);
        return this;
    }

    public FOwnerEx set(int n, int n2) {
        this.type(n);
        this.pid(n2);
        return this;
    }

    public FOwnerEx set(FOwnerEx fOwnerEx) {
        MemoryUtil.memCopy(fOwnerEx.address(), this.address(), SIZEOF);
        return this;
    }

    public static FOwnerEx malloc() {
        return new FOwnerEx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static FOwnerEx calloc() {
        return new FOwnerEx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static FOwnerEx create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new FOwnerEx(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static FOwnerEx create(long l) {
        return new FOwnerEx(l, null);
    }

    public static @Nullable FOwnerEx createSafe(long l) {
        return l == 0L ? null : new FOwnerEx(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(FOwnerEx.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = FOwnerEx.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static FOwnerEx malloc(MemoryStack memoryStack) {
        return new FOwnerEx(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static FOwnerEx calloc(MemoryStack memoryStack) {
        return new FOwnerEx(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
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

    public static int npid(long l) {
        return MemoryUtil.memGetInt(l + (long)PID);
    }

    public static void ntype(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TYPE, n);
    }

    public static void npid(long l, int n) {
        MemoryUtil.memPutInt(l + (long)PID, n);
    }

    static {
        Struct.Layout layout = FOwnerEx.__struct(FOwnerEx.__member(4), FOwnerEx.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TYPE = layout.offsetof(0);
        PID = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<FOwnerEx, Buffer>
    implements NativeResource {
        private static final FOwnerEx ELEMENT_FACTORY = FOwnerEx.create(-1L);

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
        protected FOwnerEx getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public int type() {
            return FOwnerEx.ntype(this.address());
        }

        @NativeType(value="pid_t")
        public int pid() {
            return FOwnerEx.npid(this.address());
        }

        public Buffer type(int n) {
            FOwnerEx.ntype(this.address(), n);
            return this;
        }

        public Buffer pid(@NativeType(value="pid_t") int n) {
            FOwnerEx.npid(this.address(), n);
            return this;
        }
    }
}

