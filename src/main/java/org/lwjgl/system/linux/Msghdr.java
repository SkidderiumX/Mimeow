/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.IOVec;

@NativeType(value="struct msghdr")
public class Msghdr
extends Struct<Msghdr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int MSG_NAME;
    public static final int MSG_NAMELEN;
    public static final int MSG_IOV;
    public static final int MSG_IOVLEN;
    public static final int MSG_CONTROL;
    public static final int MSG_CONTROLLEN;
    public static final int MSG_FLAGS;

    protected Msghdr(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected Msghdr create(long l, @Nullable ByteBuffer byteBuffer) {
        return new Msghdr(l, byteBuffer);
    }

    public Msghdr(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Msghdr.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public ByteBuffer msg_name() {
        return Msghdr.nmsg_name(this.address());
    }

    @NativeType(value="socklen_t")
    public int msg_namelen() {
        return Msghdr.nmsg_namelen(this.address());
    }

    @NativeType(value="struct iovec *")
    public IOVec.Buffer msg_iov() {
        return Msghdr.nmsg_iov(this.address());
    }

    @NativeType(value="size_t")
    public long msg_iovlen() {
        return Msghdr.nmsg_iovlen(this.address());
    }

    @NativeType(value="void *")
    public ByteBuffer msg_control() {
        return Msghdr.nmsg_control(this.address());
    }

    @NativeType(value="size_t")
    public long msg_controllen() {
        return Msghdr.nmsg_controllen(this.address());
    }

    public int msg_flags() {
        return Msghdr.nmsg_flags(this.address());
    }

    public Msghdr msg_name(@NativeType(value="void *") ByteBuffer byteBuffer) {
        Msghdr.nmsg_name(this.address(), byteBuffer);
        return this;
    }

    public Msghdr msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer buffer) {
        Msghdr.nmsg_iov(this.address(), buffer);
        return this;
    }

    public Msghdr msg_control(@NativeType(value="void *") ByteBuffer byteBuffer) {
        Msghdr.nmsg_control(this.address(), byteBuffer);
        return this;
    }

    public Msghdr msg_flags(int n) {
        Msghdr.nmsg_flags(this.address(), n);
        return this;
    }

    public Msghdr set(ByteBuffer byteBuffer, IOVec.Buffer buffer, ByteBuffer byteBuffer2, int n) {
        this.msg_name(byteBuffer);
        this.msg_iov(buffer);
        this.msg_control(byteBuffer2);
        this.msg_flags(n);
        return this;
    }

    public Msghdr set(Msghdr msghdr) {
        MemoryUtil.memCopy(msghdr.address(), this.address(), SIZEOF);
        return this;
    }

    public static Msghdr malloc() {
        return new Msghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Msghdr calloc() {
        return new Msghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Msghdr create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new Msghdr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Msghdr create(long l) {
        return new Msghdr(l, null);
    }

    public static @Nullable Msghdr createSafe(long l) {
        return l == 0L ? null : new Msghdr(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Msghdr.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = Msghdr.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static Msghdr malloc(MemoryStack memoryStack) {
        return new Msghdr(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Msghdr calloc(MemoryStack memoryStack) {
        return new Msghdr(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static ByteBuffer nmsg_name(long l) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)MSG_NAME), Msghdr.nmsg_namelen(l));
    }

    public static int nmsg_namelen(long l) {
        return MemoryUtil.memGetInt(l + (long)MSG_NAMELEN);
    }

    public static IOVec.Buffer nmsg_iov(long l) {
        return IOVec.create(MemoryUtil.memGetAddress(l + (long)MSG_IOV), (int)Msghdr.nmsg_iovlen(l));
    }

    public static long nmsg_iovlen(long l) {
        return MemoryUtil.memGetAddress(l + (long)MSG_IOVLEN);
    }

    public static ByteBuffer nmsg_control(long l) {
        return MemoryUtil.memByteBuffer(MemoryUtil.memGetAddress(l + (long)MSG_CONTROL), (int)Msghdr.nmsg_controllen(l));
    }

    public static long nmsg_controllen(long l) {
        return MemoryUtil.memGetAddress(l + (long)MSG_CONTROLLEN);
    }

    public static int nmsg_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)MSG_FLAGS);
    }

    public static void nmsg_name(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)MSG_NAME, MemoryUtil.memAddress(byteBuffer));
        Msghdr.nmsg_namelen(l, byteBuffer.remaining());
    }

    public static void nmsg_namelen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MSG_NAMELEN, n);
    }

    public static void nmsg_iov(long l, IOVec.Buffer buffer) {
        MemoryUtil.memPutAddress(l + (long)MSG_IOV, buffer.address());
        Msghdr.nmsg_iovlen(l, buffer.remaining());
    }

    public static void nmsg_iovlen(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)MSG_IOVLEN, l2);
    }

    public static void nmsg_control(long l, ByteBuffer byteBuffer) {
        MemoryUtil.memPutAddress(l + (long)MSG_CONTROL, MemoryUtil.memAddress(byteBuffer));
        Msghdr.nmsg_controllen(l, byteBuffer.remaining());
    }

    public static void nmsg_controllen(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)MSG_CONTROLLEN, l2);
    }

    public static void nmsg_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MSG_FLAGS, n);
    }

    public static void validate(long l) {
        Checks.check(MemoryUtil.memGetAddress(l + (long)MSG_NAME));
        Checks.check(MemoryUtil.memGetAddress(l + (long)MSG_IOV));
        Checks.check(MemoryUtil.memGetAddress(l + (long)MSG_CONTROL));
    }

    static {
        Struct.Layout layout = Msghdr.__struct(Msghdr.__member(POINTER_SIZE), Msghdr.__member(4), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(POINTER_SIZE), Msghdr.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        MSG_NAME = layout.offsetof(0);
        MSG_NAMELEN = layout.offsetof(1);
        MSG_IOV = layout.offsetof(2);
        MSG_IOVLEN = layout.offsetof(3);
        MSG_CONTROL = layout.offsetof(4);
        MSG_CONTROLLEN = layout.offsetof(5);
        MSG_FLAGS = layout.offsetof(6);
    }

    public static class Buffer
    extends StructBuffer<Msghdr, Buffer>
    implements NativeResource {
        private static final Msghdr ELEMENT_FACTORY = Msghdr.create(-1L);

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
        protected Msghdr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public ByteBuffer msg_name() {
            return Msghdr.nmsg_name(this.address());
        }

        @NativeType(value="socklen_t")
        public int msg_namelen() {
            return Msghdr.nmsg_namelen(this.address());
        }

        @NativeType(value="struct iovec *")
        public IOVec.Buffer msg_iov() {
            return Msghdr.nmsg_iov(this.address());
        }

        @NativeType(value="size_t")
        public long msg_iovlen() {
            return Msghdr.nmsg_iovlen(this.address());
        }

        @NativeType(value="void *")
        public ByteBuffer msg_control() {
            return Msghdr.nmsg_control(this.address());
        }

        @NativeType(value="size_t")
        public long msg_controllen() {
            return Msghdr.nmsg_controllen(this.address());
        }

        public int msg_flags() {
            return Msghdr.nmsg_flags(this.address());
        }

        public Buffer msg_name(@NativeType(value="void *") ByteBuffer byteBuffer) {
            Msghdr.nmsg_name(this.address(), byteBuffer);
            return this;
        }

        public Buffer msg_iov(@NativeType(value="struct iovec *") IOVec.Buffer buffer) {
            Msghdr.nmsg_iov(this.address(), buffer);
            return this;
        }

        public Buffer msg_control(@NativeType(value="void *") ByteBuffer byteBuffer) {
            Msghdr.nmsg_control(this.address(), byteBuffer);
            return this;
        }

        public Buffer msg_flags(int n) {
            Msghdr.nmsg_flags(this.address(), n);
            return this;
        }
    }
}

