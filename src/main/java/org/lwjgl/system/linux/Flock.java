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

@NativeType(value="struct flock64")
public class Flock
extends Struct<Flock>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int L_TYPE;
    public static final int L_WHENCE;
    public static final int L_START;
    public static final int L_LEN;
    public static final int L_PID;

    protected Flock(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected Flock create(long l, @Nullable ByteBuffer byteBuffer) {
        return new Flock(l, byteBuffer);
    }

    public Flock(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Flock.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    public short l_type() {
        return Flock.nl_type(this.address());
    }

    public short l_whence() {
        return Flock.nl_whence(this.address());
    }

    @NativeType(value="off_t")
    public long l_start() {
        return Flock.nl_start(this.address());
    }

    @NativeType(value="off_t")
    public long l_len() {
        return Flock.nl_len(this.address());
    }

    @NativeType(value="pid_t")
    public int l_pid() {
        return Flock.nl_pid(this.address());
    }

    public Flock l_type(short s) {
        Flock.nl_type(this.address(), s);
        return this;
    }

    public Flock l_whence(short s) {
        Flock.nl_whence(this.address(), s);
        return this;
    }

    public Flock l_start(@NativeType(value="off_t") long l) {
        Flock.nl_start(this.address(), l);
        return this;
    }

    public Flock l_len(@NativeType(value="off_t") long l) {
        Flock.nl_len(this.address(), l);
        return this;
    }

    public Flock l_pid(@NativeType(value="pid_t") int n) {
        Flock.nl_pid(this.address(), n);
        return this;
    }

    public Flock set(short s, short s2, long l, long l2, int n) {
        this.l_type(s);
        this.l_whence(s2);
        this.l_start(l);
        this.l_len(l2);
        this.l_pid(n);
        return this;
    }

    public Flock set(Flock flock) {
        MemoryUtil.memCopy(flock.address(), this.address(), SIZEOF);
        return this;
    }

    public static Flock malloc() {
        return new Flock(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Flock calloc() {
        return new Flock(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Flock create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new Flock(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Flock create(long l) {
        return new Flock(l, null);
    }

    public static @Nullable Flock createSafe(long l) {
        return l == 0L ? null : new Flock(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Flock.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = Flock.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static Flock malloc(MemoryStack memoryStack) {
        return new Flock(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Flock calloc(MemoryStack memoryStack) {
        return new Flock(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static short nl_type(long l) {
        return MemoryUtil.memGetShort(l + (long)L_TYPE);
    }

    public static short nl_whence(long l) {
        return MemoryUtil.memGetShort(l + (long)L_WHENCE);
    }

    public static long nl_start(long l) {
        return MemoryUtil.memGetLong(l + (long)L_START);
    }

    public static long nl_len(long l) {
        return MemoryUtil.memGetLong(l + (long)L_LEN);
    }

    public static int nl_pid(long l) {
        return MemoryUtil.memGetInt(l + (long)L_PID);
    }

    public static void nl_type(long l, short s) {
        MemoryUtil.memPutShort(l + (long)L_TYPE, s);
    }

    public static void nl_whence(long l, short s) {
        MemoryUtil.memPutShort(l + (long)L_WHENCE, s);
    }

    public static void nl_start(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)L_START, l2);
    }

    public static void nl_len(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)L_LEN, l2);
    }

    public static void nl_pid(long l, int n) {
        MemoryUtil.memPutInt(l + (long)L_PID, n);
    }

    static {
        Struct.Layout layout = Flock.__struct(Flock.__member(2), Flock.__member(2), Flock.__member(8), Flock.__member(8), Flock.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        L_TYPE = layout.offsetof(0);
        L_WHENCE = layout.offsetof(1);
        L_START = layout.offsetof(2);
        L_LEN = layout.offsetof(3);
        L_PID = layout.offsetof(4);
    }

    public static class Buffer
    extends StructBuffer<Flock, Buffer>
    implements NativeResource {
        private static final Flock ELEMENT_FACTORY = Flock.create(-1L);

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
        protected Flock getElementFactory() {
            return ELEMENT_FACTORY;
        }

        public short l_type() {
            return Flock.nl_type(this.address());
        }

        public short l_whence() {
            return Flock.nl_whence(this.address());
        }

        @NativeType(value="off_t")
        public long l_start() {
            return Flock.nl_start(this.address());
        }

        @NativeType(value="off_t")
        public long l_len() {
            return Flock.nl_len(this.address());
        }

        @NativeType(value="pid_t")
        public int l_pid() {
            return Flock.nl_pid(this.address());
        }

        public Buffer l_type(short s) {
            Flock.nl_type(this.address(), s);
            return this;
        }

        public Buffer l_whence(short s) {
            Flock.nl_whence(this.address(), s);
            return this;
        }

        public Buffer l_start(@NativeType(value="off_t") long l) {
            Flock.nl_start(this.address(), l);
            return this;
        }

        public Buffer l_len(@NativeType(value="off_t") long l) {
            Flock.nl_len(this.address(), l);
            return this;
        }

        public Buffer l_pid(@NativeType(value="pid_t") int n) {
            Flock.nl_pid(this.address(), n);
            return this;
        }
    }
}

