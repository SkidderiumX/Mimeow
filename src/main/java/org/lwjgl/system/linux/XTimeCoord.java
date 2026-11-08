/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

public class XTimeCoord
extends Struct<XTimeCoord> {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int TIME;
    public static final int X;
    public static final int Y;

    protected XTimeCoord(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected XTimeCoord create(long l, @Nullable ByteBuffer byteBuffer) {
        return new XTimeCoord(l, byteBuffer);
    }

    public XTimeCoord(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), XTimeCoord.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="Time")
    public long time() {
        return XTimeCoord.ntime(this.address());
    }

    public short x() {
        return XTimeCoord.nx(this.address());
    }

    public short y() {
        return XTimeCoord.ny(this.address());
    }

    public static XTimeCoord create(long l) {
        return new XTimeCoord(l, null);
    }

    public static @Nullable XTimeCoord createSafe(long l) {
        return l == 0L ? null : new XTimeCoord(l, null);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static long ntime(long l) {
        return MemoryUtil.memGetCLong(l + (long)TIME);
    }

    public static short nx(long l) {
        return MemoryUtil.memGetShort(l + (long)X);
    }

    public static short ny(long l) {
        return MemoryUtil.memGetShort(l + (long)Y);
    }

    static {
        Struct.Layout layout = XTimeCoord.__struct(XTimeCoord.__member(CLONG_SIZE), XTimeCoord.__member(2), XTimeCoord.__member(2));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        TIME = layout.offsetof(0);
        X = layout.offsetof(1);
        Y = layout.offsetof(2);
    }

    public static class Buffer
    extends StructBuffer<XTimeCoord, Buffer> {
        private static final XTimeCoord ELEMENT_FACTORY = XTimeCoord.create(-1L);

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
        protected XTimeCoord getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="Time")
        public long time() {
            return XTimeCoord.ntime(this.address());
        }

        public short x() {
            return XTimeCoord.nx(this.address());
        }

        public short y() {
            return XTimeCoord.ny(this.address());
        }
    }
}

