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

@NativeType(value="struct sockaddr")
public class Sockaddr
extends Struct<Sockaddr>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int SA_FAMILY;
    public static final int SA_DATA;

    protected Sockaddr(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected Sockaddr create(long l, @Nullable ByteBuffer byteBuffer) {
        return new Sockaddr(l, byteBuffer);
    }

    public Sockaddr(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Sockaddr.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="sa_family_t")
    public short sa_family() {
        return Sockaddr.nsa_family(this.address());
    }

    @NativeType(value="char[14]")
    public ByteBuffer sa_data() {
        return Sockaddr.nsa_data(this.address());
    }

    @NativeType(value="char")
    public byte sa_data(int n) {
        return Sockaddr.nsa_data(this.address(), n);
    }

    public Sockaddr sa_family(@NativeType(value="sa_family_t") short s) {
        Sockaddr.nsa_family(this.address(), s);
        return this;
    }

    public Sockaddr sa_data(@NativeType(value="char[14]") ByteBuffer byteBuffer) {
        Sockaddr.nsa_data(this.address(), byteBuffer);
        return this;
    }

    public Sockaddr sa_data(int n, @NativeType(value="char") byte by) {
        Sockaddr.nsa_data(this.address(), n, by);
        return this;
    }

    public Sockaddr set(short s, ByteBuffer byteBuffer) {
        this.sa_family(s);
        this.sa_data(byteBuffer);
        return this;
    }

    public Sockaddr set(Sockaddr sockaddr) {
        MemoryUtil.memCopy(sockaddr.address(), this.address(), SIZEOF);
        return this;
    }

    public static Sockaddr malloc() {
        return new Sockaddr(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Sockaddr calloc() {
        return new Sockaddr(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Sockaddr create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new Sockaddr(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Sockaddr create(long l) {
        return new Sockaddr(l, null);
    }

    public static @Nullable Sockaddr createSafe(long l) {
        return l == 0L ? null : new Sockaddr(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Sockaddr.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = Sockaddr.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static Sockaddr malloc(MemoryStack memoryStack) {
        return new Sockaddr(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Sockaddr calloc(MemoryStack memoryStack) {
        return new Sockaddr(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static short nsa_family(long l) {
        return MemoryUtil.memGetShort(l + (long)SA_FAMILY);
    }

    public static ByteBuffer nsa_data(long l) {
        return MemoryUtil.memByteBuffer(l + (long)SA_DATA, 14);
    }

    public static byte nsa_data(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)SA_DATA + Checks.check(n, 14) * 1L);
    }

    public static void nsa_family(long l, short s) {
        MemoryUtil.memPutShort(l + (long)SA_FAMILY, s);
    }

    public static void nsa_data(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 14);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)SA_DATA, byteBuffer.remaining() * 1);
    }

    public static void nsa_data(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)SA_DATA + Checks.check(n, 14) * 1L, by);
    }

    static {
        Struct.Layout layout = Sockaddr.__struct(Sockaddr.__member(2), Sockaddr.__array(1, 14));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        SA_FAMILY = layout.offsetof(0);
        SA_DATA = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<Sockaddr, Buffer>
    implements NativeResource {
        private static final Sockaddr ELEMENT_FACTORY = Sockaddr.create(-1L);

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
        protected Sockaddr getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="sa_family_t")
        public short sa_family() {
            return Sockaddr.nsa_family(this.address());
        }

        @NativeType(value="char[14]")
        public ByteBuffer sa_data() {
            return Sockaddr.nsa_data(this.address());
        }

        @NativeType(value="char")
        public byte sa_data(int n) {
            return Sockaddr.nsa_data(this.address(), n);
        }

        public Buffer sa_family(@NativeType(value="sa_family_t") short s) {
            Sockaddr.nsa_family(this.address(), s);
            return this;
        }

        public Buffer sa_data(@NativeType(value="char[14]") ByteBuffer byteBuffer) {
            Sockaddr.nsa_data(this.address(), byteBuffer);
            return this;
        }

        public Buffer sa_data(int n, @NativeType(value="char") byte by) {
            Sockaddr.nsa_data(this.address(), n, by);
            return this;
        }
    }
}

