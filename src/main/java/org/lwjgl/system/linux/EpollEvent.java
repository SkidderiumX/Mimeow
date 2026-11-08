/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

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
import org.lwjgl.system.linux.EpollData;

@NativeType(value="struct epoll_event")
public class EpollEvent
extends Struct<EpollEvent>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EVENTS;
    public static final int DATA;

    protected EpollEvent(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected EpollEvent create(long l, @Nullable ByteBuffer byteBuffer) {
        return new EpollEvent(l, byteBuffer);
    }

    public EpollEvent(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), EpollEvent.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="uint32_t")
    public int events() {
        return EpollEvent.nevents(this.address());
    }

    @NativeType(value="epoll_data_t")
    public EpollData data() {
        return EpollEvent.ndata(this.address());
    }

    public EpollEvent events(@NativeType(value="uint32_t") int n) {
        EpollEvent.nevents(this.address(), n);
        return this;
    }

    public EpollEvent data(@NativeType(value="epoll_data_t") EpollData epollData) {
        EpollEvent.ndata(this.address(), epollData);
        return this;
    }

    public EpollEvent data(Consumer<EpollData> consumer) {
        consumer.accept(this.data());
        return this;
    }

    public EpollEvent set(int n, EpollData epollData) {
        this.events(n);
        this.data(epollData);
        return this;
    }

    public EpollEvent set(EpollEvent epollEvent) {
        MemoryUtil.memCopy(epollEvent.address(), this.address(), SIZEOF);
        return this;
    }

    public static EpollEvent malloc() {
        return new EpollEvent(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static EpollEvent calloc() {
        return new EpollEvent(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static EpollEvent create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new EpollEvent(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static EpollEvent create(long l) {
        return new EpollEvent(l, null);
    }

    public static @Nullable EpollEvent createSafe(long l) {
        return l == 0L ? null : new EpollEvent(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(EpollEvent.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = EpollEvent.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static EpollEvent malloc(MemoryStack memoryStack) {
        return new EpollEvent(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static EpollEvent calloc(MemoryStack memoryStack) {
        return new EpollEvent(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nevents(long l) {
        return MemoryUtil.memGetInt(l + (long)EVENTS);
    }

    public static EpollData ndata(long l) {
        return EpollData.create(l + (long)DATA);
    }

    public static void nevents(long l, int n) {
        MemoryUtil.memPutInt(l + (long)EVENTS, n);
    }

    public static void ndata(long l, EpollData epollData) {
        MemoryUtil.memCopy(epollData.address(), l + (long)DATA, EpollData.SIZEOF);
    }

    static {
        Struct.Layout layout = EpollEvent.__struct(EpollEvent.__member(4), EpollEvent.__member(EpollData.SIZEOF, EpollData.ALIGNOF));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EVENTS = layout.offsetof(0);
        DATA = layout.offsetof(1);
    }

    public static class Buffer
    extends StructBuffer<EpollEvent, Buffer>
    implements NativeResource {
        private static final EpollEvent ELEMENT_FACTORY = EpollEvent.create(-1L);

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
        protected EpollEvent getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="uint32_t")
        public int events() {
            return EpollEvent.nevents(this.address());
        }

        @NativeType(value="epoll_data_t")
        public EpollData data() {
            return EpollEvent.ndata(this.address());
        }

        public Buffer events(@NativeType(value="uint32_t") int n) {
            EpollEvent.nevents(this.address(), n);
            return this;
        }

        public Buffer data(@NativeType(value="epoll_data_t") EpollData epollData) {
            EpollEvent.ndata(this.address(), epollData);
            return this;
        }

        public Buffer data(Consumer<EpollData> consumer) {
            consumer.accept(this.data());
            return this;
        }
    }
}

