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

@NativeType(value="struct cmsghdr")
public class CMsghdr
extends Struct<CMsghdr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int CMSG_LEN;
    public static final int CMSG_LEVEL;
    public static final int CMSG_TYPE;
    public static final int CMSG_DATA;

    protected CMsghdr(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected CMsghdr create(long l, @Nullable ByteBuffer byteBuffer) {
        return new CMsghdr(l, byteBuffer);
    }

    public CMsghdr(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), CMsghdr.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="socklen_t")
    public int cmsg_len() {
        return CMsghdr.ncmsg_len(this.address());
    }

    public int cmsg_level() {
        return CMsghdr.ncmsg_level(this.address());
    }

    public int cmsg_type() {
        return CMsghdr.ncmsg_type(this.address());
    }

    @NativeType(value="char[0]")
    public ByteBuffer cmsg_data() {
        return CMsghdr.ncmsg_data(this.address());
    }

    @NativeType(value="char")
    public byte cmsg_data(int n) {
        return CMsghdr.ncmsg_data(this.address(), n);
    }

    public CMsghdr cmsg_len(@NativeType(value="socklen_t") int n) {
        CMsghdr.ncmsg_len(this.address(), n);
        return this;
    }

    public CMsghdr cmsg_level(int n) {
        CMsghdr.ncmsg_level(this.address(), n);
        return this;
    }

    public CMsghdr cmsg_type(int n) {
        CMsghdr.ncmsg_type(this.address(), n);
        return this;
    }

    public CMsghdr cmsg_data(@NativeType(value="char[0]") ByteBuffer byteBuffer) {
        CMsghdr.ncmsg_data(this.address(), byteBuffer);
        return this;
    }

    public CMsghdr cmsg_data(int n, @NativeType(value="char") byte by) {
        CMsghdr.ncmsg_data(this.address(), n, by);
        return this;
    }

    public CMsghdr set(int n, int n2, int n3, ByteBuffer byteBuffer) {
        this.cmsg_len(n);
        this.cmsg_level(n2);
        this.cmsg_type(n3);
        this.cmsg_data(byteBuffer);
        return this;
    }

    public CMsghdr set(CMsghdr cMsghdr) {
        MemoryUtil.memCopy(cMsghdr.address(), this.address(), SIZEOF);
        return this;
    }

    public static CMsghdr malloc() {
        return new CMsghdr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static CMsghdr calloc() {
        return new CMsghdr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static CMsghdr create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new CMsghdr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static CMsghdr create(long l) {
        return new CMsghdr(l, null);
    }

    public static @Nullable CMsghdr createSafe(long l) {
        return l == 0L ? null : new CMsghdr(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(CMsghdr.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = CMsghdr.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static CMsghdr malloc(MemoryStack memoryStack) {
        return new CMsghdr(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static CMsghdr calloc(MemoryStack memoryStack) {
        return new CMsghdr(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int ncmsg_len(long l) {
        return MemoryUtil.memGetInt(l + (long)CMSG_LEN);
    }

    public static int ncmsg_level(long l) {
        return MemoryUtil.memGetInt(l + (long)CMSG_LEVEL);
    }

    public static int ncmsg_type(long l) {
        return MemoryUtil.memGetInt(l + (long)CMSG_TYPE);
    }

    public static ByteBuffer ncmsg_data(long l) {
        return MemoryUtil.memByteBuffer(l + (long)CMSG_DATA, 0);
    }

    public static byte ncmsg_data(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)CMSG_DATA + Checks.check(n, 0) * 1L);
    }

    public static void ncmsg_len(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CMSG_LEN, n);
    }

    public static void ncmsg_level(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CMSG_LEVEL, n);
    }

    public static void ncmsg_type(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CMSG_TYPE, n);
    }

    public static void ncmsg_data(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)CMSG_DATA, byteBuffer.remaining() * 1);
    }

    public static void ncmsg_data(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)CMSG_DATA + Checks.check(n, 0) * 1L, by);
    }

    static {
        Struct.Layout layout = CMsghdr.__struct(CMsghdr.__member(4), CMsghdr.__member(4), CMsghdr.__member(4), CMsghdr.__array(1, 0));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        CMSG_LEN = layout.offsetof(0);
        CMSG_LEVEL = layout.offsetof(1);
        CMSG_TYPE = layout.offsetof(2);
        CMSG_DATA = layout.offsetof(3);
    }

    public static class Buffer
    extends StructBuffer<CMsghdr, Buffer>
    implements NativeResource {
        private static final CMsghdr ELEMENT_FACTORY = CMsghdr.create(-1L);

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
        protected CMsghdr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="socklen_t")
        public int cmsg_len() {
            return CMsghdr.ncmsg_len(this.address());
        }

        public int cmsg_level() {
            return CMsghdr.ncmsg_level(this.address());
        }

        public int cmsg_type() {
            return CMsghdr.ncmsg_type(this.address());
        }

        @NativeType(value="char[0]")
        public ByteBuffer cmsg_data() {
            return CMsghdr.ncmsg_data(this.address());
        }

        @NativeType(value="char")
        public byte cmsg_data(int n) {
            return CMsghdr.ncmsg_data(this.address(), n);
        }

        public Buffer cmsg_len(@NativeType(value="socklen_t") int n) {
            CMsghdr.ncmsg_len(this.address(), n);
            return this;
        }

        public Buffer cmsg_level(int n) {
            CMsghdr.ncmsg_level(this.address(), n);
            return this;
        }

        public Buffer cmsg_type(int n) {
            CMsghdr.ncmsg_type(this.address(), n);
            return this;
        }

        public Buffer cmsg_data(@NativeType(value="char[0]") ByteBuffer byteBuffer) {
            CMsghdr.ncmsg_data(this.address(), byteBuffer);
            return this;
        }

        public Buffer cmsg_data(int n, @NativeType(value="char") byte by) {
            CMsghdr.ncmsg_data(this.address(), n, by);
            return this;
        }
    }
}

