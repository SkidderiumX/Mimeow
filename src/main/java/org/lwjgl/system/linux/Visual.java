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
public class Visual
extends Struct<Visual>
implements NativeResource {

    static /* synthetic */ Class class$(String x0) {
        try {
            return Class.forName(x0);
        }
        catch (ClassNotFoundException x1) {
            throw new NoClassDefFoundError(x1.getMessage());
        }
    }

    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int EXT_DATA;
    public static final int VISUALID;
    public static final int CLASS;
    public static final int RED_MASK;
    public static final int GREEN_MASK;
    public static final int BLUE_MASK;
    public static final int BITS_PER_RGB;
    public static final int MAP_ENTRIES;

    protected Visual(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected Visual create(long l, @Nullable ByteBuffer byteBuffer) {
        return new Visual(l, byteBuffer);
    }

    public Visual(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Visual.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="void *")
    public long ext_data() {
        return Visual.next_data(this.address());
    }

    @NativeType(value="VisualID")
    public long visualid() {
        return Visual.nvisualid(this.address());
    }

    public int class$() {
        return Visual.nclass$(this.address());
    }

    @NativeType(value="unsigned long")
    public long red_mask() {
        return Visual.nred_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long green_mask() {
        return Visual.ngreen_mask(this.address());
    }

    @NativeType(value="unsigned long")
    public long blue_mask() {
        return Visual.nblue_mask(this.address());
    }

    public int bits_per_rgb() {
        return Visual.nbits_per_rgb(this.address());
    }

    public int map_entries() {
        return Visual.nmap_entries(this.address());
    }

    public Visual ext_data(@NativeType(value="void *") long l) {
        Visual.next_data(this.address(), l);
        return this;
    }

    public Visual visualid(@NativeType(value="VisualID") long l) {
        Visual.nvisualid(this.address(), l);
        return this;
    }

    public Visual class$(int n) {
        Visual.nclass$(this.address(), n);
        return this;
    }

    public Visual red_mask(@NativeType(value="unsigned long") long l) {
        Visual.nred_mask(this.address(), l);
        return this;
    }

    public Visual green_mask(@NativeType(value="unsigned long") long l) {
        Visual.ngreen_mask(this.address(), l);
        return this;
    }

    public Visual blue_mask(@NativeType(value="unsigned long") long l) {
        Visual.nblue_mask(this.address(), l);
        return this;
    }

    public Visual bits_per_rgb(int n) {
        Visual.nbits_per_rgb(this.address(), n);
        return this;
    }

    public Visual map_entries(int n) {
        Visual.nmap_entries(this.address(), n);
        return this;
    }

    public Visual set(long l, long l2, int n, long l3, long l4, long l5, int n2, int n3) {
        this.ext_data(l);
        this.visualid(l2);
        this.class$(n);
        this.red_mask(l3);
        this.green_mask(l4);
        this.blue_mask(l5);
        this.bits_per_rgb(n2);
        this.map_entries(n3);
        return this;
    }

    public Visual set(Visual visual) {
        MemoryUtil.memCopy(visual.address(), this.address(), SIZEOF);
        return this;
    }

    public static Visual malloc() {
        return new Visual(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Visual calloc() {
        return new Visual(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Visual create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new Visual(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Visual create(long l) {
        return new Visual(l, null);
    }

    public static @Nullable Visual createSafe(long l) {
        return l == 0L ? null : new Visual(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Visual.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = Visual.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    @Deprecated
    public static Visual mallocStack() {
        return Visual.malloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual callocStack() {
        return Visual.calloc(MemoryStack.stackGet());
    }

    @Deprecated
    public static Visual mallocStack(MemoryStack memoryStack) {
        return Visual.malloc(memoryStack);
    }

    @Deprecated
    public static Visual callocStack(MemoryStack memoryStack) {
        return Visual.calloc(memoryStack);
    }

    @Deprecated
    public static Buffer mallocStack(int n) {
        return Visual.malloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer callocStack(int n) {
        return Visual.calloc(n, MemoryStack.stackGet());
    }

    @Deprecated
    public static Buffer mallocStack(int n, MemoryStack memoryStack) {
        return Visual.malloc(n, memoryStack);
    }

    @Deprecated
    public static Buffer callocStack(int n, MemoryStack memoryStack) {
        return Visual.calloc(n, memoryStack);
    }

    public static Visual malloc(MemoryStack memoryStack) {
        return new Visual(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Visual calloc(MemoryStack memoryStack) {
        return new Visual(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static long next_data(long l) {
        return MemoryUtil.memGetAddress(l + (long)EXT_DATA);
    }

    public static long nvisualid(long l) {
        return MemoryUtil.memGetCLong(l + (long)VISUALID);
    }

    public static int nclass$(long l) {
        return MemoryUtil.memGetInt(l + (long)CLASS);
    }

    public static long nred_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)RED_MASK);
    }

    public static long ngreen_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)GREEN_MASK);
    }

    public static long nblue_mask(long l) {
        return MemoryUtil.memGetCLong(l + (long)BLUE_MASK);
    }

    public static int nbits_per_rgb(long l) {
        return MemoryUtil.memGetInt(l + (long)BITS_PER_RGB);
    }

    public static int nmap_entries(long l) {
        return MemoryUtil.memGetInt(l + (long)MAP_ENTRIES);
    }

    public static void next_data(long l, long l2) {
        MemoryUtil.memPutAddress(l + (long)EXT_DATA, l2);
    }

    public static void nvisualid(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)VISUALID, l2);
    }

    public static void nclass$(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CLASS, n);
    }

    public static void nred_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)RED_MASK, l2);
    }

    public static void ngreen_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)GREEN_MASK, l2);
    }

    public static void nblue_mask(long l, long l2) {
        MemoryUtil.memPutCLong(l + (long)BLUE_MASK, l2);
    }

    public static void nbits_per_rgb(long l, int n) {
        MemoryUtil.memPutInt(l + (long)BITS_PER_RGB, n);
    }

    public static void nmap_entries(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MAP_ENTRIES, n);
    }

    static {
        Struct.Layout layout = Visual.__struct(Visual.__member(POINTER_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(CLONG_SIZE), Visual.__member(4), Visual.__member(4));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        EXT_DATA = layout.offsetof(0);
        VISUALID = layout.offsetof(1);
        CLASS = layout.offsetof(2);
        RED_MASK = layout.offsetof(3);
        GREEN_MASK = layout.offsetof(4);
        BLUE_MASK = layout.offsetof(5);
        BITS_PER_RGB = layout.offsetof(6);
        MAP_ENTRIES = layout.offsetof(7);
    }

    public static class Buffer
    extends StructBuffer<Visual, Buffer>
    implements NativeResource {
        private static final Visual ELEMENT_FACTORY = Visual.create(-1L);

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
        protected Visual getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="void *")
        public long ext_data() {
            return Visual.next_data(this.address());
        }

        @NativeType(value="VisualID")
        public long visualid() {
            return Visual.nvisualid(this.address());
        }

        public int class$() {
            return Visual.nclass$(this.address());
        }

        @NativeType(value="unsigned long")
        public long red_mask() {
            return Visual.nred_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long green_mask() {
            return Visual.ngreen_mask(this.address());
        }

        @NativeType(value="unsigned long")
        public long blue_mask() {
            return Visual.nblue_mask(this.address());
        }

        public int bits_per_rgb() {
            return Visual.nbits_per_rgb(this.address());
        }

        public int map_entries() {
            return Visual.nmap_entries(this.address());
        }

        public Buffer ext_data(@NativeType(value="void *") long l) {
            Visual.next_data(this.address(), l);
            return this;
        }

        public Buffer visualid(@NativeType(value="VisualID") long l) {
            Visual.nvisualid(this.address(), l);
            return this;
        }

        public Buffer class$(int n) {
            Visual.nclass$(this.address(), n);
            return this;
        }

        public Buffer red_mask(@NativeType(value="unsigned long") long l) {
            Visual.nred_mask(this.address(), l);
            return this;
        }

        public Buffer green_mask(@NativeType(value="unsigned long") long l) {
            Visual.ngreen_mask(this.address(), l);
            return this;
        }

        public Buffer blue_mask(@NativeType(value="unsigned long") long l) {
            Visual.nblue_mask(this.address(), l);
            return this;
        }

        public Buffer bits_per_rgb(int n) {
            Visual.nbits_per_rgb(this.address(), n);
            return this;
        }

        public Buffer map_entries(int n) {
            Visual.nmap_entries(this.address(), n);
            return this;
        }
    }
}

