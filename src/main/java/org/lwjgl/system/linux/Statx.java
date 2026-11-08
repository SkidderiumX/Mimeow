/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;
import org.lwjgl.system.linux.StatxTimestamp;

@NativeType(value="struct statx")
public class Statx
extends Struct<Statx>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int STX_MASK;
    public static final int STX_BLKSIZE;
    public static final int STX_ATTRIBUTES;
    public static final int STX_NLINK;
    public static final int STX_UID;
    public static final int STX_GID;
    public static final int STX_MODE;
    public static final int __SPARE0;
    public static final int STX_INO;
    public static final int STX_SIZE;
    public static final int STX_BLOCKS;
    public static final int STX_ATTRIBUTES_MASK;
    public static final int STX_ATIME;
    public static final int STX_BTIME;
    public static final int STX_CTIME;
    public static final int STX_MTIME;
    public static final int STX_RDEV_MAJOR;
    public static final int STX_RDEV_MINOR;
    public static final int STX_DEV_MAJOR;
    public static final int STX_DEV_MINOR;
    public static final int STX_MNT_ID;
    public static final int __SPARE2;
    public static final int __SPARE3;

    protected Statx(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected Statx create(long l, @Nullable ByteBuffer byteBuffer) {
        return new Statx(l, byteBuffer);
    }

    public Statx(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), Statx.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u32")
    public int stx_mask() {
        return Statx.nstx_mask(this.address());
    }

    @NativeType(value="__u32")
    public int stx_blksize() {
        return Statx.nstx_blksize(this.address());
    }

    @NativeType(value="__u64")
    public long stx_attributes() {
        return Statx.nstx_attributes(this.address());
    }

    @NativeType(value="__u32")
    public int stx_nlink() {
        return Statx.nstx_nlink(this.address());
    }

    @NativeType(value="__u32")
    public int stx_uid() {
        return Statx.nstx_uid(this.address());
    }

    @NativeType(value="__u32")
    public int stx_gid() {
        return Statx.nstx_gid(this.address());
    }

    @NativeType(value="__u16")
    public short stx_mode() {
        return Statx.nstx_mode(this.address());
    }

    @NativeType(value="__u64")
    public long stx_ino() {
        return Statx.nstx_ino(this.address());
    }

    @NativeType(value="__u64")
    public long stx_size() {
        return Statx.nstx_size(this.address());
    }

    @NativeType(value="__u64")
    public long stx_blocks() {
        return Statx.nstx_blocks(this.address());
    }

    @NativeType(value="__u64")
    public long stx_attributes_mask() {
        return Statx.nstx_attributes_mask(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_atime() {
        return Statx.nstx_atime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_btime() {
        return Statx.nstx_btime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_ctime() {
        return Statx.nstx_ctime(this.address());
    }

    @NativeType(value="struct statx_timestamp")
    public StatxTimestamp stx_mtime() {
        return Statx.nstx_mtime(this.address());
    }

    @NativeType(value="__u32")
    public int stx_rdev_major() {
        return Statx.nstx_rdev_major(this.address());
    }

    @NativeType(value="__u32")
    public int stx_rdev_minor() {
        return Statx.nstx_rdev_minor(this.address());
    }

    @NativeType(value="__u32")
    public int stx_dev_major() {
        return Statx.nstx_dev_major(this.address());
    }

    @NativeType(value="__u32")
    public int stx_dev_minor() {
        return Statx.nstx_dev_minor(this.address());
    }

    @NativeType(value="__u64")
    public long stx_mnt_id() {
        return Statx.nstx_mnt_id(this.address());
    }

    public Statx stx_mask(@NativeType(value="__u32") int n) {
        Statx.nstx_mask(this.address(), n);
        return this;
    }

    public Statx stx_blksize(@NativeType(value="__u32") int n) {
        Statx.nstx_blksize(this.address(), n);
        return this;
    }

    public Statx stx_attributes(@NativeType(value="__u64") long l) {
        Statx.nstx_attributes(this.address(), l);
        return this;
    }

    public Statx stx_nlink(@NativeType(value="__u32") int n) {
        Statx.nstx_nlink(this.address(), n);
        return this;
    }

    public Statx stx_uid(@NativeType(value="__u32") int n) {
        Statx.nstx_uid(this.address(), n);
        return this;
    }

    public Statx stx_gid(@NativeType(value="__u32") int n) {
        Statx.nstx_gid(this.address(), n);
        return this;
    }

    public Statx stx_mode(@NativeType(value="__u16") short s) {
        Statx.nstx_mode(this.address(), s);
        return this;
    }

    public Statx stx_ino(@NativeType(value="__u64") long l) {
        Statx.nstx_ino(this.address(), l);
        return this;
    }

    public Statx stx_size(@NativeType(value="__u64") long l) {
        Statx.nstx_size(this.address(), l);
        return this;
    }

    public Statx stx_blocks(@NativeType(value="__u64") long l) {
        Statx.nstx_blocks(this.address(), l);
        return this;
    }

    public Statx stx_attributes_mask(@NativeType(value="__u64") long l) {
        Statx.nstx_attributes_mask(this.address(), l);
        return this;
    }

    public Statx stx_atime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
        Statx.nstx_atime(this.address(), statxTimestamp);
        return this;
    }

    public Statx stx_atime(Consumer<StatxTimestamp> consumer) {
        consumer.accept(this.stx_atime());
        return this;
    }

    public Statx stx_btime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
        Statx.nstx_btime(this.address(), statxTimestamp);
        return this;
    }

    public Statx stx_btime(Consumer<StatxTimestamp> consumer) {
        consumer.accept(this.stx_btime());
        return this;
    }

    public Statx stx_ctime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
        Statx.nstx_ctime(this.address(), statxTimestamp);
        return this;
    }

    public Statx stx_ctime(Consumer<StatxTimestamp> consumer) {
        consumer.accept(this.stx_ctime());
        return this;
    }

    public Statx stx_mtime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
        Statx.nstx_mtime(this.address(), statxTimestamp);
        return this;
    }

    public Statx stx_mtime(Consumer<StatxTimestamp> consumer) {
        consumer.accept(this.stx_mtime());
        return this;
    }

    public Statx stx_rdev_major(@NativeType(value="__u32") int n) {
        Statx.nstx_rdev_major(this.address(), n);
        return this;
    }

    public Statx stx_rdev_minor(@NativeType(value="__u32") int n) {
        Statx.nstx_rdev_minor(this.address(), n);
        return this;
    }

    public Statx stx_dev_major(@NativeType(value="__u32") int n) {
        Statx.nstx_dev_major(this.address(), n);
        return this;
    }

    public Statx stx_dev_minor(@NativeType(value="__u32") int n) {
        Statx.nstx_dev_minor(this.address(), n);
        return this;
    }

    public Statx stx_mnt_id(@NativeType(value="__u64") long l) {
        Statx.nstx_mnt_id(this.address(), l);
        return this;
    }

    public Statx set(int n, int n2, long l, int n3, int n4, int n5, short s, long l2, long l3, long l4, long l5, StatxTimestamp statxTimestamp, StatxTimestamp statxTimestamp2, StatxTimestamp statxTimestamp3, StatxTimestamp statxTimestamp4, int n6, int n7, int n8, int n9, long l6) {
        this.stx_mask(n);
        this.stx_blksize(n2);
        this.stx_attributes(l);
        this.stx_nlink(n3);
        this.stx_uid(n4);
        this.stx_gid(n5);
        this.stx_mode(s);
        this.stx_ino(l2);
        this.stx_size(l3);
        this.stx_blocks(l4);
        this.stx_attributes_mask(l5);
        this.stx_atime(statxTimestamp);
        this.stx_btime(statxTimestamp2);
        this.stx_ctime(statxTimestamp3);
        this.stx_mtime(statxTimestamp4);
        this.stx_rdev_major(n6);
        this.stx_rdev_minor(n7);
        this.stx_dev_major(n8);
        this.stx_dev_minor(n9);
        this.stx_mnt_id(l6);
        return this;
    }

    public Statx set(Statx statx) {
        MemoryUtil.memCopy(statx.address(), this.address(), SIZEOF);
        return this;
    }

    public static Statx malloc() {
        return new Statx(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static Statx calloc() {
        return new Statx(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static Statx create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new Statx(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static Statx create(long l) {
        return new Statx(l, null);
    }

    public static @Nullable Statx createSafe(long l) {
        return l == 0L ? null : new Statx(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(Statx.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = Statx.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static Statx malloc(MemoryStack memoryStack) {
        return new Statx(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static Statx calloc(MemoryStack memoryStack) {
        return new Statx(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static int nstx_mask(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_MASK);
    }

    public static int nstx_blksize(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_BLKSIZE);
    }

    public static long nstx_attributes(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_ATTRIBUTES);
    }

    public static int nstx_nlink(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_NLINK);
    }

    public static int nstx_uid(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_UID);
    }

    public static int nstx_gid(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_GID);
    }

    public static short nstx_mode(long l) {
        return MemoryUtil.memGetShort(l + (long)STX_MODE);
    }

    public static ShortBuffer n__spare0(long l) {
        return MemoryUtil.memShortBuffer(l + (long)__SPARE0, 1);
    }

    public static short n__spare0(long l, int n) {
        return MemoryUtil.memGetShort(l + (long)__SPARE0 + Checks.check(n, 1) * 2L);
    }

    public static long nstx_ino(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_INO);
    }

    public static long nstx_size(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_SIZE);
    }

    public static long nstx_blocks(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_BLOCKS);
    }

    public static long nstx_attributes_mask(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_ATTRIBUTES_MASK);
    }

    public static StatxTimestamp nstx_atime(long l) {
        return StatxTimestamp.create(l + (long)STX_ATIME);
    }

    public static StatxTimestamp nstx_btime(long l) {
        return StatxTimestamp.create(l + (long)STX_BTIME);
    }

    public static StatxTimestamp nstx_ctime(long l) {
        return StatxTimestamp.create(l + (long)STX_CTIME);
    }

    public static StatxTimestamp nstx_mtime(long l) {
        return StatxTimestamp.create(l + (long)STX_MTIME);
    }

    public static int nstx_rdev_major(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_RDEV_MAJOR);
    }

    public static int nstx_rdev_minor(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_RDEV_MINOR);
    }

    public static int nstx_dev_major(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_DEV_MAJOR);
    }

    public static int nstx_dev_minor(long l) {
        return MemoryUtil.memGetInt(l + (long)STX_DEV_MINOR);
    }

    public static long nstx_mnt_id(long l) {
        return MemoryUtil.memGetLong(l + (long)STX_MNT_ID);
    }

    public static long n__spare2(long l) {
        return MemoryUtil.memGetLong(l + (long)__SPARE2);
    }

    public static LongBuffer n__spare3(long l) {
        return MemoryUtil.memLongBuffer(l + (long)__SPARE3, 12);
    }

    public static long n__spare3(long l, int n) {
        return MemoryUtil.memGetLong(l + (long)__SPARE3 + Checks.check(n, 12) * 8L);
    }

    public static void nstx_mask(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_MASK, n);
    }

    public static void nstx_blksize(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_BLKSIZE, n);
    }

    public static void nstx_attributes(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_ATTRIBUTES, l2);
    }

    public static void nstx_nlink(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_NLINK, n);
    }

    public static void nstx_uid(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_UID, n);
    }

    public static void nstx_gid(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_GID, n);
    }

    public static void nstx_mode(long l, short s) {
        MemoryUtil.memPutShort(l + (long)STX_MODE, s);
    }

    public static void n__spare0(long l, ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(shortBuffer, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(shortBuffer), l + (long)__SPARE0, shortBuffer.remaining() * 2);
    }

    public static void n__spare0(long l, int n, short s) {
        MemoryUtil.memPutShort(l + (long)__SPARE0 + Checks.check(n, 1) * 2L, s);
    }

    public static void nstx_ino(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_INO, l2);
    }

    public static void nstx_size(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_SIZE, l2);
    }

    public static void nstx_blocks(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_BLOCKS, l2);
    }

    public static void nstx_attributes_mask(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_ATTRIBUTES_MASK, l2);
    }

    public static void nstx_atime(long l, StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), l + (long)STX_ATIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_btime(long l, StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), l + (long)STX_BTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_ctime(long l, StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), l + (long)STX_CTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_mtime(long l, StatxTimestamp statxTimestamp) {
        MemoryUtil.memCopy(statxTimestamp.address(), l + (long)STX_MTIME, StatxTimestamp.SIZEOF);
    }

    public static void nstx_rdev_major(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_RDEV_MAJOR, n);
    }

    public static void nstx_rdev_minor(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_RDEV_MINOR, n);
    }

    public static void nstx_dev_major(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_DEV_MAJOR, n);
    }

    public static void nstx_dev_minor(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STX_DEV_MINOR, n);
    }

    public static void nstx_mnt_id(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)STX_MNT_ID, l2);
    }

    public static void n__spare2(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)__SPARE2, l2);
    }

    public static void n__spare3(long l, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 12);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l + (long)__SPARE3, longBuffer.remaining() * 8);
    }

    public static void n__spare3(long l, int n, long l2) {
        MemoryUtil.memPutLong(l + (long)__SPARE3 + Checks.check(n, 12) * 8L, l2);
    }

    static {
        Struct.Layout layout = Statx.__struct(Statx.__member(4), Statx.__member(4), Statx.__member(8), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(2), Statx.__array(2, 1), Statx.__member(8), Statx.__member(8), Statx.__member(8), Statx.__member(8), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(StatxTimestamp.SIZEOF, StatxTimestamp.ALIGNOF), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(4), Statx.__member(8), Statx.__member(8), Statx.__array(8, 12));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        STX_MASK = layout.offsetof(0);
        STX_BLKSIZE = layout.offsetof(1);
        STX_ATTRIBUTES = layout.offsetof(2);
        STX_NLINK = layout.offsetof(3);
        STX_UID = layout.offsetof(4);
        STX_GID = layout.offsetof(5);
        STX_MODE = layout.offsetof(6);
        __SPARE0 = layout.offsetof(7);
        STX_INO = layout.offsetof(8);
        STX_SIZE = layout.offsetof(9);
        STX_BLOCKS = layout.offsetof(10);
        STX_ATTRIBUTES_MASK = layout.offsetof(11);
        STX_ATIME = layout.offsetof(12);
        STX_BTIME = layout.offsetof(13);
        STX_CTIME = layout.offsetof(14);
        STX_MTIME = layout.offsetof(15);
        STX_RDEV_MAJOR = layout.offsetof(16);
        STX_RDEV_MINOR = layout.offsetof(17);
        STX_DEV_MAJOR = layout.offsetof(18);
        STX_DEV_MINOR = layout.offsetof(19);
        STX_MNT_ID = layout.offsetof(20);
        __SPARE2 = layout.offsetof(21);
        __SPARE3 = layout.offsetof(22);
    }

    public static class Buffer
    extends StructBuffer<Statx, Buffer>
    implements NativeResource {
        private static final Statx ELEMENT_FACTORY = Statx.create(-1L);

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
        protected Statx getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u32")
        public int stx_mask() {
            return Statx.nstx_mask(this.address());
        }

        @NativeType(value="__u32")
        public int stx_blksize() {
            return Statx.nstx_blksize(this.address());
        }

        @NativeType(value="__u64")
        public long stx_attributes() {
            return Statx.nstx_attributes(this.address());
        }

        @NativeType(value="__u32")
        public int stx_nlink() {
            return Statx.nstx_nlink(this.address());
        }

        @NativeType(value="__u32")
        public int stx_uid() {
            return Statx.nstx_uid(this.address());
        }

        @NativeType(value="__u32")
        public int stx_gid() {
            return Statx.nstx_gid(this.address());
        }

        @NativeType(value="__u16")
        public short stx_mode() {
            return Statx.nstx_mode(this.address());
        }

        @NativeType(value="__u64")
        public long stx_ino() {
            return Statx.nstx_ino(this.address());
        }

        @NativeType(value="__u64")
        public long stx_size() {
            return Statx.nstx_size(this.address());
        }

        @NativeType(value="__u64")
        public long stx_blocks() {
            return Statx.nstx_blocks(this.address());
        }

        @NativeType(value="__u64")
        public long stx_attributes_mask() {
            return Statx.nstx_attributes_mask(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_atime() {
            return Statx.nstx_atime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_btime() {
            return Statx.nstx_btime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_ctime() {
            return Statx.nstx_ctime(this.address());
        }

        @NativeType(value="struct statx_timestamp")
        public StatxTimestamp stx_mtime() {
            return Statx.nstx_mtime(this.address());
        }

        @NativeType(value="__u32")
        public int stx_rdev_major() {
            return Statx.nstx_rdev_major(this.address());
        }

        @NativeType(value="__u32")
        public int stx_rdev_minor() {
            return Statx.nstx_rdev_minor(this.address());
        }

        @NativeType(value="__u32")
        public int stx_dev_major() {
            return Statx.nstx_dev_major(this.address());
        }

        @NativeType(value="__u32")
        public int stx_dev_minor() {
            return Statx.nstx_dev_minor(this.address());
        }

        @NativeType(value="__u64")
        public long stx_mnt_id() {
            return Statx.nstx_mnt_id(this.address());
        }

        public Buffer stx_mask(@NativeType(value="__u32") int n) {
            Statx.nstx_mask(this.address(), n);
            return this;
        }

        public Buffer stx_blksize(@NativeType(value="__u32") int n) {
            Statx.nstx_blksize(this.address(), n);
            return this;
        }

        public Buffer stx_attributes(@NativeType(value="__u64") long l) {
            Statx.nstx_attributes(this.address(), l);
            return this;
        }

        public Buffer stx_nlink(@NativeType(value="__u32") int n) {
            Statx.nstx_nlink(this.address(), n);
            return this;
        }

        public Buffer stx_uid(@NativeType(value="__u32") int n) {
            Statx.nstx_uid(this.address(), n);
            return this;
        }

        public Buffer stx_gid(@NativeType(value="__u32") int n) {
            Statx.nstx_gid(this.address(), n);
            return this;
        }

        public Buffer stx_mode(@NativeType(value="__u16") short s) {
            Statx.nstx_mode(this.address(), s);
            return this;
        }

        public Buffer stx_ino(@NativeType(value="__u64") long l) {
            Statx.nstx_ino(this.address(), l);
            return this;
        }

        public Buffer stx_size(@NativeType(value="__u64") long l) {
            Statx.nstx_size(this.address(), l);
            return this;
        }

        public Buffer stx_blocks(@NativeType(value="__u64") long l) {
            Statx.nstx_blocks(this.address(), l);
            return this;
        }

        public Buffer stx_attributes_mask(@NativeType(value="__u64") long l) {
            Statx.nstx_attributes_mask(this.address(), l);
            return this;
        }

        public Buffer stx_atime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
            Statx.nstx_atime(this.address(), statxTimestamp);
            return this;
        }

        public Buffer stx_atime(Consumer<StatxTimestamp> consumer) {
            consumer.accept(this.stx_atime());
            return this;
        }

        public Buffer stx_btime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
            Statx.nstx_btime(this.address(), statxTimestamp);
            return this;
        }

        public Buffer stx_btime(Consumer<StatxTimestamp> consumer) {
            consumer.accept(this.stx_btime());
            return this;
        }

        public Buffer stx_ctime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
            Statx.nstx_ctime(this.address(), statxTimestamp);
            return this;
        }

        public Buffer stx_ctime(Consumer<StatxTimestamp> consumer) {
            consumer.accept(this.stx_ctime());
            return this;
        }

        public Buffer stx_mtime(@NativeType(value="struct statx_timestamp") StatxTimestamp statxTimestamp) {
            Statx.nstx_mtime(this.address(), statxTimestamp);
            return this;
        }

        public Buffer stx_mtime(Consumer<StatxTimestamp> consumer) {
            consumer.accept(this.stx_mtime());
            return this;
        }

        public Buffer stx_rdev_major(@NativeType(value="__u32") int n) {
            Statx.nstx_rdev_major(this.address(), n);
            return this;
        }

        public Buffer stx_rdev_minor(@NativeType(value="__u32") int n) {
            Statx.nstx_rdev_minor(this.address(), n);
            return this;
        }

        public Buffer stx_dev_major(@NativeType(value="__u32") int n) {
            Statx.nstx_dev_major(this.address(), n);
            return this;
        }

        public Buffer stx_dev_minor(@NativeType(value="__u32") int n) {
            Statx.nstx_dev_minor(this.address(), n);
            return this;
        }

        public Buffer stx_mnt_id(@NativeType(value="__u64") long l) {
            Statx.nstx_mnt_id(this.address(), l);
            return this;
        }
    }
}

