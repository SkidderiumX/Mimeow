/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.Checks;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeResource;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.StructBuffer;

@NativeType(value="struct io_uring_sqe")
public class IOURingSQE
extends Struct<IOURingSQE>
implements NativeResource {
    public static final int SIZEOF;
    public static final int ALIGNOF;
    public static final int OPCODE;
    public static final int FLAGS;
    public static final int IOPRIO;
    public static final int FD;
    public static final int OFF;
    public static final int ADDR2;
    public static final int CMD_OP;
    public static final int __PAD1;
    public static final int ADDR;
    public static final int SPLICE_OFF_IN;
    public static final int LEVEL;
    public static final int OPTNAME;
    public static final int LEN;
    public static final int RW_FLAGS;
    public static final int FSYNC_FLAGS;
    public static final int POLL_EVENTS;
    public static final int POLL32_EVENTS;
    public static final int SYNC_RANGE_FLAGS;
    public static final int MSG_FLAGS;
    public static final int TIMEOUT_FLAGS;
    public static final int ACCEPT_FLAGS;
    public static final int CANCEL_FLAGS;
    public static final int OPEN_FLAGS;
    public static final int STATX_FLAGS;
    public static final int FADVISE_ADVICE;
    public static final int SPLICE_FLAGS;
    public static final int RENAME_FLAGS;
    public static final int UNLINK_FLAGS;
    public static final int HARDLINK_FLAGS;
    public static final int XATTR_FLAGS;
    public static final int MSG_RING_FLAGS;
    public static final int URING_CMD_FLAGS;
    public static final int WAITID_FLAGS;
    public static final int FUTEX_FLAGS;
    public static final int INSTALL_FD_FLAGS;
    public static final int NOP_FLAGS;
    public static final int USER_DATA;
    public static final int BUF_INDEX;
    public static final int BUF_GROUP;
    public static final int PERSONALITY;
    public static final int SPLICE_FD_IN;
    public static final int FILE_INDEX;
    public static final int OPTLEN;
    public static final int ADDR_LEN;
    public static final int __PAD3;
    public static final int ADDR3;
    public static final int __PAD2;
    public static final int OPTVAL;
    public static final int CMD;

    protected IOURingSQE(long l, @Nullable ByteBuffer byteBuffer) {
        super(l, byteBuffer);
    }

    @Override
    protected IOURingSQE create(long l, @Nullable ByteBuffer byteBuffer) {
        return new IOURingSQE(l, byteBuffer);
    }

    public IOURingSQE(ByteBuffer byteBuffer) {
        super(MemoryUtil.memAddress(byteBuffer), IOURingSQE.__checkContainer(byteBuffer, SIZEOF));
    }

    @Override
    public int sizeof() {
        return SIZEOF;
    }

    @NativeType(value="__u8")
    public byte opcode() {
        return IOURingSQE.nopcode(this.address());
    }

    @NativeType(value="__u8")
    public byte flags() {
        return IOURingSQE.nflags(this.address());
    }

    @NativeType(value="__u16")
    public short ioprio() {
        return IOURingSQE.nioprio(this.address());
    }

    @NativeType(value="__s32")
    public int fd() {
        return IOURingSQE.nfd(this.address());
    }

    @NativeType(value="__u64")
    public long off() {
        return IOURingSQE.noff(this.address());
    }

    @NativeType(value="__u64")
    public long addr2() {
        return IOURingSQE.naddr2(this.address());
    }

    @NativeType(value="__u32")
    public int cmd_op() {
        return IOURingSQE.ncmd_op(this.address());
    }

    @NativeType(value="__u32")
    public int __pad1() {
        return IOURingSQE.n__pad1(this.address());
    }

    @NativeType(value="__u64")
    public long addr() {
        return IOURingSQE.naddr(this.address());
    }

    @NativeType(value="__u64")
    public long splice_off_in() {
        return IOURingSQE.nsplice_off_in(this.address());
    }

    @NativeType(value="__u32")
    public int level() {
        return IOURingSQE.nlevel(this.address());
    }

    @NativeType(value="__u32")
    public int optname() {
        return IOURingSQE.noptname(this.address());
    }

    @NativeType(value="__u32")
    public int len() {
        return IOURingSQE.nlen(this.address());
    }

    @NativeType(value="__kernel_rwf_t")
    public int rw_flags() {
        return IOURingSQE.nrw_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fsync_flags() {
        return IOURingSQE.nfsync_flags(this.address());
    }

    @NativeType(value="__u16")
    public short poll_events() {
        return IOURingSQE.npoll_events(this.address());
    }

    @NativeType(value="__u32")
    public int poll32_events() {
        return IOURingSQE.npoll32_events(this.address());
    }

    @NativeType(value="__u32")
    public int sync_range_flags() {
        return IOURingSQE.nsync_range_flags(this.address());
    }

    @NativeType(value="__u32")
    public int msg_flags() {
        return IOURingSQE.nmsg_flags(this.address());
    }

    @NativeType(value="__u32")
    public int timeout_flags() {
        return IOURingSQE.ntimeout_flags(this.address());
    }

    @NativeType(value="__u32")
    public int accept_flags() {
        return IOURingSQE.naccept_flags(this.address());
    }

    @NativeType(value="__u32")
    public int cancel_flags() {
        return IOURingSQE.ncancel_flags(this.address());
    }

    @NativeType(value="__u32")
    public int open_flags() {
        return IOURingSQE.nopen_flags(this.address());
    }

    @NativeType(value="__u32")
    public int statx_flags() {
        return IOURingSQE.nstatx_flags(this.address());
    }

    @NativeType(value="__u32")
    public int fadvise_advice() {
        return IOURingSQE.nfadvise_advice(this.address());
    }

    @NativeType(value="__u32")
    public int splice_flags() {
        return IOURingSQE.nsplice_flags(this.address());
    }

    @NativeType(value="__u32")
    public int rename_flags() {
        return IOURingSQE.nrename_flags(this.address());
    }

    @NativeType(value="__u32")
    public int unlink_flags() {
        return IOURingSQE.nunlink_flags(this.address());
    }

    @NativeType(value="__u32")
    public int hardlink_flags() {
        return IOURingSQE.nhardlink_flags(this.address());
    }

    @NativeType(value="__u32")
    public int xattr_flags() {
        return IOURingSQE.nxattr_flags(this.address());
    }

    @NativeType(value="__u32")
    public int msg_ring_flags() {
        return IOURingSQE.nmsg_ring_flags(this.address());
    }

    @NativeType(value="__u32")
    public int uring_cmd_flags() {
        return IOURingSQE.nuring_cmd_flags(this.address());
    }

    @NativeType(value="__u32")
    public int waitid_flags() {
        return IOURingSQE.nwaitid_flags(this.address());
    }

    @NativeType(value="__u32")
    public int futex_flags() {
        return IOURingSQE.nfutex_flags(this.address());
    }

    @NativeType(value="__u32")
    public int install_fd_flags() {
        return IOURingSQE.ninstall_fd_flags(this.address());
    }

    @NativeType(value="__u32")
    public int nop_flags() {
        return IOURingSQE.nnop_flags(this.address());
    }

    @NativeType(value="__u64")
    public long user_data() {
        return IOURingSQE.nuser_data(this.address());
    }

    @NativeType(value="__u16")
    public short buf_index() {
        return IOURingSQE.nbuf_index(this.address());
    }

    @NativeType(value="__u16")
    public short buf_group() {
        return IOURingSQE.nbuf_group(this.address());
    }

    @NativeType(value="__u16")
    public short personality() {
        return IOURingSQE.npersonality(this.address());
    }

    @NativeType(value="__s32")
    public int splice_fd_in() {
        return IOURingSQE.nsplice_fd_in(this.address());
    }

    @NativeType(value="__u32")
    public int file_index() {
        return IOURingSQE.nfile_index(this.address());
    }

    @NativeType(value="__u32")
    public int optlen() {
        return IOURingSQE.noptlen(this.address());
    }

    @NativeType(value="__u16")
    public short addr_len() {
        return IOURingSQE.naddr_len(this.address());
    }

    @NativeType(value="__u16[1]")
    public ShortBuffer __pad3() {
        return IOURingSQE.n__pad3(this.address());
    }

    @NativeType(value="__u16")
    public short __pad3(int n) {
        return IOURingSQE.n__pad3(this.address(), n);
    }

    @NativeType(value="__u64")
    public long addr3() {
        return IOURingSQE.naddr3(this.address());
    }

    @NativeType(value="__u64[1]")
    public LongBuffer __pad2() {
        return IOURingSQE.n__pad2(this.address());
    }

    @NativeType(value="__u64")
    public long __pad2(int n) {
        return IOURingSQE.n__pad2(this.address(), n);
    }

    @NativeType(value="__u64")
    public long optval() {
        return IOURingSQE.noptval(this.address());
    }

    @NativeType(value="__u8[0]")
    public ByteBuffer cmd() {
        return IOURingSQE.ncmd(this.address());
    }

    @NativeType(value="__u8")
    public byte cmd(int n) {
        return IOURingSQE.ncmd(this.address(), n);
    }

    public IOURingSQE opcode(@NativeType(value="__u8") byte by) {
        IOURingSQE.nopcode(this.address(), by);
        return this;
    }

    public IOURingSQE flags(@NativeType(value="__u8") byte by) {
        IOURingSQE.nflags(this.address(), by);
        return this;
    }

    public IOURingSQE ioprio(@NativeType(value="__u16") short s) {
        IOURingSQE.nioprio(this.address(), s);
        return this;
    }

    public IOURingSQE fd(@NativeType(value="__s32") int n) {
        IOURingSQE.nfd(this.address(), n);
        return this;
    }

    public IOURingSQE off(@NativeType(value="__u64") long l) {
        IOURingSQE.noff(this.address(), l);
        return this;
    }

    public IOURingSQE addr2(@NativeType(value="__u64") long l) {
        IOURingSQE.naddr2(this.address(), l);
        return this;
    }

    public IOURingSQE cmd_op(@NativeType(value="__u32") int n) {
        IOURingSQE.ncmd_op(this.address(), n);
        return this;
    }

    public IOURingSQE __pad1(@NativeType(value="__u32") int n) {
        IOURingSQE.n__pad1(this.address(), n);
        return this;
    }

    public IOURingSQE addr(@NativeType(value="__u64") long l) {
        IOURingSQE.naddr(this.address(), l);
        return this;
    }

    public IOURingSQE splice_off_in(@NativeType(value="__u64") long l) {
        IOURingSQE.nsplice_off_in(this.address(), l);
        return this;
    }

    public IOURingSQE level(@NativeType(value="__u32") int n) {
        IOURingSQE.nlevel(this.address(), n);
        return this;
    }

    public IOURingSQE optname(@NativeType(value="__u32") int n) {
        IOURingSQE.noptname(this.address(), n);
        return this;
    }

    public IOURingSQE len(@NativeType(value="__u32") int n) {
        IOURingSQE.nlen(this.address(), n);
        return this;
    }

    public IOURingSQE rw_flags(@NativeType(value="__kernel_rwf_t") int n) {
        IOURingSQE.nrw_flags(this.address(), n);
        return this;
    }

    public IOURingSQE fsync_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nfsync_flags(this.address(), n);
        return this;
    }

    public IOURingSQE poll_events(@NativeType(value="__u16") short s) {
        IOURingSQE.npoll_events(this.address(), s);
        return this;
    }

    public IOURingSQE poll32_events(@NativeType(value="__u32") int n) {
        IOURingSQE.npoll32_events(this.address(), n);
        return this;
    }

    public IOURingSQE sync_range_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nsync_range_flags(this.address(), n);
        return this;
    }

    public IOURingSQE msg_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nmsg_flags(this.address(), n);
        return this;
    }

    public IOURingSQE timeout_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.ntimeout_flags(this.address(), n);
        return this;
    }

    public IOURingSQE accept_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.naccept_flags(this.address(), n);
        return this;
    }

    public IOURingSQE cancel_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.ncancel_flags(this.address(), n);
        return this;
    }

    public IOURingSQE open_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nopen_flags(this.address(), n);
        return this;
    }

    public IOURingSQE statx_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nstatx_flags(this.address(), n);
        return this;
    }

    public IOURingSQE fadvise_advice(@NativeType(value="__u32") int n) {
        IOURingSQE.nfadvise_advice(this.address(), n);
        return this;
    }

    public IOURingSQE splice_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nsplice_flags(this.address(), n);
        return this;
    }

    public IOURingSQE rename_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nrename_flags(this.address(), n);
        return this;
    }

    public IOURingSQE unlink_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nunlink_flags(this.address(), n);
        return this;
    }

    public IOURingSQE hardlink_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nhardlink_flags(this.address(), n);
        return this;
    }

    public IOURingSQE xattr_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nxattr_flags(this.address(), n);
        return this;
    }

    public IOURingSQE msg_ring_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nmsg_ring_flags(this.address(), n);
        return this;
    }

    public IOURingSQE uring_cmd_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nuring_cmd_flags(this.address(), n);
        return this;
    }

    public IOURingSQE waitid_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nwaitid_flags(this.address(), n);
        return this;
    }

    public IOURingSQE futex_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nfutex_flags(this.address(), n);
        return this;
    }

    public IOURingSQE install_fd_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.ninstall_fd_flags(this.address(), n);
        return this;
    }

    public IOURingSQE nop_flags(@NativeType(value="__u32") int n) {
        IOURingSQE.nnop_flags(this.address(), n);
        return this;
    }

    public IOURingSQE user_data(@NativeType(value="__u64") long l) {
        IOURingSQE.nuser_data(this.address(), l);
        return this;
    }

    public IOURingSQE buf_index(@NativeType(value="__u16") short s) {
        IOURingSQE.nbuf_index(this.address(), s);
        return this;
    }

    public IOURingSQE buf_group(@NativeType(value="__u16") short s) {
        IOURingSQE.nbuf_group(this.address(), s);
        return this;
    }

    public IOURingSQE personality(@NativeType(value="__u16") short s) {
        IOURingSQE.npersonality(this.address(), s);
        return this;
    }

    public IOURingSQE splice_fd_in(@NativeType(value="__s32") int n) {
        IOURingSQE.nsplice_fd_in(this.address(), n);
        return this;
    }

    public IOURingSQE file_index(@NativeType(value="__u32") int n) {
        IOURingSQE.nfile_index(this.address(), n);
        return this;
    }

    public IOURingSQE optlen(@NativeType(value="__u32") int n) {
        IOURingSQE.noptlen(this.address(), n);
        return this;
    }

    public IOURingSQE addr_len(@NativeType(value="__u16") short s) {
        IOURingSQE.naddr_len(this.address(), s);
        return this;
    }

    public IOURingSQE __pad3(@NativeType(value="__u16[1]") ShortBuffer shortBuffer) {
        IOURingSQE.n__pad3(this.address(), shortBuffer);
        return this;
    }

    public IOURingSQE __pad3(int n, @NativeType(value="__u16") short s) {
        IOURingSQE.n__pad3(this.address(), n, s);
        return this;
    }

    public IOURingSQE addr3(@NativeType(value="__u64") long l) {
        IOURingSQE.naddr3(this.address(), l);
        return this;
    }

    public IOURingSQE __pad2(@NativeType(value="__u64[1]") LongBuffer longBuffer) {
        IOURingSQE.n__pad2(this.address(), longBuffer);
        return this;
    }

    public IOURingSQE __pad2(int n, @NativeType(value="__u64") long l) {
        IOURingSQE.n__pad2(this.address(), n, l);
        return this;
    }

    public IOURingSQE optval(@NativeType(value="__u64") long l) {
        IOURingSQE.noptval(this.address(), l);
        return this;
    }

    public IOURingSQE cmd(@NativeType(value="__u8[0]") ByteBuffer byteBuffer) {
        IOURingSQE.ncmd(this.address(), byteBuffer);
        return this;
    }

    public IOURingSQE cmd(int n, @NativeType(value="__u8") byte by) {
        IOURingSQE.ncmd(this.address(), n, by);
        return this;
    }

    public IOURingSQE set(IOURingSQE iOURingSQE) {
        MemoryUtil.memCopy(iOURingSQE.address(), this.address(), SIZEOF);
        return this;
    }

    public static IOURingSQE malloc() {
        return new IOURingSQE(MemoryUtil.nmemAllocChecked(SIZEOF), null);
    }

    public static IOURingSQE calloc() {
        return new IOURingSQE(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
    }

    public static IOURingSQE create() {
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer(SIZEOF);
        return new IOURingSQE(MemoryUtil.memAddress(byteBuffer), byteBuffer);
    }

    public static IOURingSQE create(long l) {
        return new IOURingSQE(l, null);
    }

    public static @Nullable IOURingSQE createSafe(long l) {
        return l == 0L ? null : new IOURingSQE(l, null);
    }

    public static Buffer malloc(int n) {
        return new Buffer(MemoryUtil.nmemAllocChecked(IOURingSQE.__checkMalloc(n, SIZEOF)), n);
    }

    public static Buffer calloc(int n) {
        return new Buffer(MemoryUtil.nmemCallocChecked(n, SIZEOF), n);
    }

    public static Buffer create(int n) {
        ByteBuffer byteBuffer = IOURingSQE.__create(n, SIZEOF);
        return new Buffer(MemoryUtil.memAddress(byteBuffer), byteBuffer, -1, 0, n, n);
    }

    public static Buffer create(long l, int n) {
        return new Buffer(l, n);
    }

    public static @Nullable Buffer createSafe(long l, int n) {
        return l == 0L ? null : new Buffer(l, n);
    }

    public static IOURingSQE malloc(MemoryStack memoryStack) {
        return new IOURingSQE(memoryStack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    public static IOURingSQE calloc(MemoryStack memoryStack) {
        return new IOURingSQE(memoryStack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    public static Buffer malloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.nmalloc(ALIGNOF, n * SIZEOF), n);
    }

    public static Buffer calloc(int n, MemoryStack memoryStack) {
        return new Buffer(memoryStack.ncalloc(ALIGNOF, n, SIZEOF), n);
    }

    public static byte nopcode(long l) {
        return MemoryUtil.memGetByte(l + (long)OPCODE);
    }

    public static byte nflags(long l) {
        return MemoryUtil.memGetByte(l + (long)FLAGS);
    }

    public static short nioprio(long l) {
        return MemoryUtil.memGetShort(l + (long)IOPRIO);
    }

    public static int nfd(long l) {
        return MemoryUtil.memGetInt(l + (long)FD);
    }

    public static long noff(long l) {
        return MemoryUtil.memGetLong(l + (long)OFF);
    }

    public static long naddr2(long l) {
        return MemoryUtil.memGetLong(l + (long)ADDR2);
    }

    public static int ncmd_op(long l) {
        return MemoryUtil.memGetInt(l + (long)CMD_OP);
    }

    public static int n__pad1(long l) {
        return MemoryUtil.memGetInt(l + (long)__PAD1);
    }

    public static long naddr(long l) {
        return MemoryUtil.memGetLong(l + (long)ADDR);
    }

    public static long nsplice_off_in(long l) {
        return MemoryUtil.memGetLong(l + (long)SPLICE_OFF_IN);
    }

    public static int nlevel(long l) {
        return MemoryUtil.memGetInt(l + (long)LEVEL);
    }

    public static int noptname(long l) {
        return MemoryUtil.memGetInt(l + (long)OPTNAME);
    }

    public static int nlen(long l) {
        return MemoryUtil.memGetInt(l + (long)LEN);
    }

    public static int nrw_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)RW_FLAGS);
    }

    public static int nfsync_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)FSYNC_FLAGS);
    }

    public static short npoll_events(long l) {
        return MemoryUtil.memGetShort(l + (long)POLL_EVENTS);
    }

    public static int npoll32_events(long l) {
        return MemoryUtil.memGetInt(l + (long)POLL32_EVENTS);
    }

    public static int nsync_range_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)SYNC_RANGE_FLAGS);
    }

    public static int nmsg_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)MSG_FLAGS);
    }

    public static int ntimeout_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)TIMEOUT_FLAGS);
    }

    public static int naccept_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)ACCEPT_FLAGS);
    }

    public static int ncancel_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)CANCEL_FLAGS);
    }

    public static int nopen_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)OPEN_FLAGS);
    }

    public static int nstatx_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)STATX_FLAGS);
    }

    public static int nfadvise_advice(long l) {
        return MemoryUtil.memGetInt(l + (long)FADVISE_ADVICE);
    }

    public static int nsplice_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)SPLICE_FLAGS);
    }

    public static int nrename_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)RENAME_FLAGS);
    }

    public static int nunlink_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)UNLINK_FLAGS);
    }

    public static int nhardlink_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)HARDLINK_FLAGS);
    }

    public static int nxattr_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)XATTR_FLAGS);
    }

    public static int nmsg_ring_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)MSG_RING_FLAGS);
    }

    public static int nuring_cmd_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)URING_CMD_FLAGS);
    }

    public static int nwaitid_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)WAITID_FLAGS);
    }

    public static int nfutex_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)FUTEX_FLAGS);
    }

    public static int ninstall_fd_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)INSTALL_FD_FLAGS);
    }

    public static int nnop_flags(long l) {
        return MemoryUtil.memGetInt(l + (long)NOP_FLAGS);
    }

    public static long nuser_data(long l) {
        return MemoryUtil.memGetLong(l + (long)USER_DATA);
    }

    public static short nbuf_index(long l) {
        return MemoryUtil.memGetShort(l + (long)BUF_INDEX);
    }

    public static short nbuf_group(long l) {
        return MemoryUtil.memGetShort(l + (long)BUF_GROUP);
    }

    public static short npersonality(long l) {
        return MemoryUtil.memGetShort(l + (long)PERSONALITY);
    }

    public static int nsplice_fd_in(long l) {
        return MemoryUtil.memGetInt(l + (long)SPLICE_FD_IN);
    }

    public static int nfile_index(long l) {
        return MemoryUtil.memGetInt(l + (long)FILE_INDEX);
    }

    public static int noptlen(long l) {
        return MemoryUtil.memGetInt(l + (long)OPTLEN);
    }

    public static short naddr_len(long l) {
        return MemoryUtil.memGetShort(l + (long)ADDR_LEN);
    }

    public static ShortBuffer n__pad3(long l) {
        return MemoryUtil.memShortBuffer(l + (long)__PAD3, 1);
    }

    public static short n__pad3(long l, int n) {
        return MemoryUtil.memGetShort(l + (long)__PAD3 + Checks.check(n, 1) * 2L);
    }

    public static long naddr3(long l) {
        return MemoryUtil.memGetLong(l + (long)ADDR3);
    }

    public static LongBuffer n__pad2(long l) {
        return MemoryUtil.memLongBuffer(l + (long)__PAD2, 1);
    }

    public static long n__pad2(long l, int n) {
        return MemoryUtil.memGetLong(l + (long)__PAD2 + Checks.check(n, 1) * 8L);
    }

    public static long noptval(long l) {
        return MemoryUtil.memGetLong(l + (long)OPTVAL);
    }

    public static ByteBuffer ncmd(long l) {
        return MemoryUtil.memByteBuffer(l + (long)CMD, 0);
    }

    public static byte ncmd(long l, int n) {
        return MemoryUtil.memGetByte(l + (long)CMD + Checks.check(n, 0) * 1L);
    }

    public static void nopcode(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)OPCODE, by);
    }

    public static void nflags(long l, byte by) {
        MemoryUtil.memPutByte(l + (long)FLAGS, by);
    }

    public static void nioprio(long l, short s) {
        MemoryUtil.memPutShort(l + (long)IOPRIO, s);
    }

    public static void nfd(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FD, n);
    }

    public static void noff(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)OFF, l2);
    }

    public static void naddr2(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)ADDR2, l2);
    }

    public static void ncmd_op(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CMD_OP, n);
    }

    public static void n__pad1(long l, int n) {
        MemoryUtil.memPutInt(l + (long)__PAD1, n);
    }

    public static void naddr(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)ADDR, l2);
    }

    public static void nsplice_off_in(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)SPLICE_OFF_IN, l2);
    }

    public static void nlevel(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LEVEL, n);
    }

    public static void noptname(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OPTNAME, n);
    }

    public static void nlen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)LEN, n);
    }

    public static void nrw_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RW_FLAGS, n);
    }

    public static void nfsync_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FSYNC_FLAGS, n);
    }

    public static void npoll_events(long l, short s) {
        MemoryUtil.memPutShort(l + (long)POLL_EVENTS, s);
    }

    public static void npoll32_events(long l, int n) {
        MemoryUtil.memPutInt(l + (long)POLL32_EVENTS, n);
    }

    public static void nsync_range_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SYNC_RANGE_FLAGS, n);
    }

    public static void nmsg_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MSG_FLAGS, n);
    }

    public static void ntimeout_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)TIMEOUT_FLAGS, n);
    }

    public static void naccept_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)ACCEPT_FLAGS, n);
    }

    public static void ncancel_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)CANCEL_FLAGS, n);
    }

    public static void nopen_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OPEN_FLAGS, n);
    }

    public static void nstatx_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)STATX_FLAGS, n);
    }

    public static void nfadvise_advice(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FADVISE_ADVICE, n);
    }

    public static void nsplice_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SPLICE_FLAGS, n);
    }

    public static void nrename_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)RENAME_FLAGS, n);
    }

    public static void nunlink_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)UNLINK_FLAGS, n);
    }

    public static void nhardlink_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)HARDLINK_FLAGS, n);
    }

    public static void nxattr_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)XATTR_FLAGS, n);
    }

    public static void nmsg_ring_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)MSG_RING_FLAGS, n);
    }

    public static void nuring_cmd_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)URING_CMD_FLAGS, n);
    }

    public static void nwaitid_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)WAITID_FLAGS, n);
    }

    public static void nfutex_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FUTEX_FLAGS, n);
    }

    public static void ninstall_fd_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)INSTALL_FD_FLAGS, n);
    }

    public static void nnop_flags(long l, int n) {
        MemoryUtil.memPutInt(l + (long)NOP_FLAGS, n);
    }

    public static void nuser_data(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)USER_DATA, l2);
    }

    public static void nbuf_index(long l, short s) {
        MemoryUtil.memPutShort(l + (long)BUF_INDEX, s);
    }

    public static void nbuf_group(long l, short s) {
        MemoryUtil.memPutShort(l + (long)BUF_GROUP, s);
    }

    public static void npersonality(long l, short s) {
        MemoryUtil.memPutShort(l + (long)PERSONALITY, s);
    }

    public static void nsplice_fd_in(long l, int n) {
        MemoryUtil.memPutInt(l + (long)SPLICE_FD_IN, n);
    }

    public static void nfile_index(long l, int n) {
        MemoryUtil.memPutInt(l + (long)FILE_INDEX, n);
    }

    public static void noptlen(long l, int n) {
        MemoryUtil.memPutInt(l + (long)OPTLEN, n);
    }

    public static void naddr_len(long l, short s) {
        MemoryUtil.memPutShort(l + (long)ADDR_LEN, s);
    }

    public static void n__pad3(long l, ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(shortBuffer, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(shortBuffer), l + (long)__PAD3, shortBuffer.remaining() * 2);
    }

    public static void n__pad3(long l, int n, short s) {
        MemoryUtil.memPutShort(l + (long)__PAD3 + Checks.check(n, 1) * 2L, s);
    }

    public static void naddr3(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)ADDR3, l2);
    }

    public static void n__pad2(long l, LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(longBuffer, 1);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(longBuffer), l + (long)__PAD2, longBuffer.remaining() * 8);
    }

    public static void n__pad2(long l, int n, long l2) {
        MemoryUtil.memPutLong(l + (long)__PAD2 + Checks.check(n, 1) * 8L, l2);
    }

    public static void noptval(long l, long l2) {
        MemoryUtil.memPutLong(l + (long)OPTVAL, l2);
    }

    public static void ncmd(long l, ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkGT(byteBuffer, 0);
        }
        MemoryUtil.memCopy(MemoryUtil.memAddress(byteBuffer), l + (long)CMD, byteBuffer.remaining() * 1);
    }

    public static void ncmd(long l, int n, byte by) {
        MemoryUtil.memPutByte(l + (long)CMD + Checks.check(n, 0) * 1L, by);
    }

    static {
        Struct.Layout layout = IOURingSQE.__struct(IOURingSQE.__member(1), IOURingSQE.__member(1), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8), IOURingSQE.__struct(IOURingSQE.__member(4), IOURingSQE.__member(4))), IOURingSQE.__union(IOURingSQE.__member(8), IOURingSQE.__member(8), IOURingSQE.__struct(IOURingSQE.__member(4), IOURingSQE.__member(4))), IOURingSQE.__member(4), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(2), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4)), IOURingSQE.__member(8), IOURingSQE.__union(IOURingSQE.__member(2), IOURingSQE.__member(2)), IOURingSQE.__member(2), IOURingSQE.__union(IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__member(4), IOURingSQE.__struct(IOURingSQE.__member(2), IOURingSQE.__array(2, 1))), IOURingSQE.__union(IOURingSQE.__struct(IOURingSQE.__member(8), IOURingSQE.__array(8, 1)), IOURingSQE.__member(8), IOURingSQE.__array(1, 0)));
        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();
        OPCODE = layout.offsetof(0);
        FLAGS = layout.offsetof(1);
        IOPRIO = layout.offsetof(2);
        FD = layout.offsetof(3);
        OFF = layout.offsetof(5);
        ADDR2 = layout.offsetof(6);
        CMD_OP = layout.offsetof(8);
        __PAD1 = layout.offsetof(9);
        ADDR = layout.offsetof(11);
        SPLICE_OFF_IN = layout.offsetof(12);
        LEVEL = layout.offsetof(14);
        OPTNAME = layout.offsetof(15);
        LEN = layout.offsetof(16);
        RW_FLAGS = layout.offsetof(18);
        FSYNC_FLAGS = layout.offsetof(19);
        POLL_EVENTS = layout.offsetof(20);
        POLL32_EVENTS = layout.offsetof(21);
        SYNC_RANGE_FLAGS = layout.offsetof(22);
        MSG_FLAGS = layout.offsetof(23);
        TIMEOUT_FLAGS = layout.offsetof(24);
        ACCEPT_FLAGS = layout.offsetof(25);
        CANCEL_FLAGS = layout.offsetof(26);
        OPEN_FLAGS = layout.offsetof(27);
        STATX_FLAGS = layout.offsetof(28);
        FADVISE_ADVICE = layout.offsetof(29);
        SPLICE_FLAGS = layout.offsetof(30);
        RENAME_FLAGS = layout.offsetof(31);
        UNLINK_FLAGS = layout.offsetof(32);
        HARDLINK_FLAGS = layout.offsetof(33);
        XATTR_FLAGS = layout.offsetof(34);
        MSG_RING_FLAGS = layout.offsetof(35);
        URING_CMD_FLAGS = layout.offsetof(36);
        WAITID_FLAGS = layout.offsetof(37);
        FUTEX_FLAGS = layout.offsetof(38);
        INSTALL_FD_FLAGS = layout.offsetof(39);
        NOP_FLAGS = layout.offsetof(40);
        USER_DATA = layout.offsetof(41);
        BUF_INDEX = layout.offsetof(43);
        BUF_GROUP = layout.offsetof(44);
        PERSONALITY = layout.offsetof(45);
        SPLICE_FD_IN = layout.offsetof(47);
        FILE_INDEX = layout.offsetof(48);
        OPTLEN = layout.offsetof(49);
        ADDR_LEN = layout.offsetof(51);
        __PAD3 = layout.offsetof(52);
        ADDR3 = layout.offsetof(55);
        __PAD2 = layout.offsetof(56);
        OPTVAL = layout.offsetof(57);
        CMD = layout.offsetof(58);
    }

    public static class Buffer
    extends StructBuffer<IOURingSQE, Buffer>
    implements NativeResource {
        private static final IOURingSQE ELEMENT_FACTORY = IOURingSQE.create(-1L);

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
        protected IOURingSQE getElementFactory() {
            return ELEMENT_FACTORY;
        }

        @NativeType(value="__u8")
        public byte opcode() {
            return IOURingSQE.nopcode(this.address());
        }

        @NativeType(value="__u8")
        public byte flags() {
            return IOURingSQE.nflags(this.address());
        }

        @NativeType(value="__u16")
        public short ioprio() {
            return IOURingSQE.nioprio(this.address());
        }

        @NativeType(value="__s32")
        public int fd() {
            return IOURingSQE.nfd(this.address());
        }

        @NativeType(value="__u64")
        public long off() {
            return IOURingSQE.noff(this.address());
        }

        @NativeType(value="__u64")
        public long addr2() {
            return IOURingSQE.naddr2(this.address());
        }

        @NativeType(value="__u32")
        public int cmd_op() {
            return IOURingSQE.ncmd_op(this.address());
        }

        @NativeType(value="__u32")
        public int __pad1() {
            return IOURingSQE.n__pad1(this.address());
        }

        @NativeType(value="__u64")
        public long addr() {
            return IOURingSQE.naddr(this.address());
        }

        @NativeType(value="__u64")
        public long splice_off_in() {
            return IOURingSQE.nsplice_off_in(this.address());
        }

        @NativeType(value="__u32")
        public int level() {
            return IOURingSQE.nlevel(this.address());
        }

        @NativeType(value="__u32")
        public int optname() {
            return IOURingSQE.noptname(this.address());
        }

        @NativeType(value="__u32")
        public int len() {
            return IOURingSQE.nlen(this.address());
        }

        @NativeType(value="__kernel_rwf_t")
        public int rw_flags() {
            return IOURingSQE.nrw_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fsync_flags() {
            return IOURingSQE.nfsync_flags(this.address());
        }

        @NativeType(value="__u16")
        public short poll_events() {
            return IOURingSQE.npoll_events(this.address());
        }

        @NativeType(value="__u32")
        public int poll32_events() {
            return IOURingSQE.npoll32_events(this.address());
        }

        @NativeType(value="__u32")
        public int sync_range_flags() {
            return IOURingSQE.nsync_range_flags(this.address());
        }

        @NativeType(value="__u32")
        public int msg_flags() {
            return IOURingSQE.nmsg_flags(this.address());
        }

        @NativeType(value="__u32")
        public int timeout_flags() {
            return IOURingSQE.ntimeout_flags(this.address());
        }

        @NativeType(value="__u32")
        public int accept_flags() {
            return IOURingSQE.naccept_flags(this.address());
        }

        @NativeType(value="__u32")
        public int cancel_flags() {
            return IOURingSQE.ncancel_flags(this.address());
        }

        @NativeType(value="__u32")
        public int open_flags() {
            return IOURingSQE.nopen_flags(this.address());
        }

        @NativeType(value="__u32")
        public int statx_flags() {
            return IOURingSQE.nstatx_flags(this.address());
        }

        @NativeType(value="__u32")
        public int fadvise_advice() {
            return IOURingSQE.nfadvise_advice(this.address());
        }

        @NativeType(value="__u32")
        public int splice_flags() {
            return IOURingSQE.nsplice_flags(this.address());
        }

        @NativeType(value="__u32")
        public int rename_flags() {
            return IOURingSQE.nrename_flags(this.address());
        }

        @NativeType(value="__u32")
        public int unlink_flags() {
            return IOURingSQE.nunlink_flags(this.address());
        }

        @NativeType(value="__u32")
        public int hardlink_flags() {
            return IOURingSQE.nhardlink_flags(this.address());
        }

        @NativeType(value="__u32")
        public int xattr_flags() {
            return IOURingSQE.nxattr_flags(this.address());
        }

        @NativeType(value="__u32")
        public int msg_ring_flags() {
            return IOURingSQE.nmsg_ring_flags(this.address());
        }

        @NativeType(value="__u32")
        public int uring_cmd_flags() {
            return IOURingSQE.nuring_cmd_flags(this.address());
        }

        @NativeType(value="__u32")
        public int waitid_flags() {
            return IOURingSQE.nwaitid_flags(this.address());
        }

        @NativeType(value="__u32")
        public int futex_flags() {
            return IOURingSQE.nfutex_flags(this.address());
        }

        @NativeType(value="__u32")
        public int install_fd_flags() {
            return IOURingSQE.ninstall_fd_flags(this.address());
        }

        @NativeType(value="__u32")
        public int nop_flags() {
            return IOURingSQE.nnop_flags(this.address());
        }

        @NativeType(value="__u64")
        public long user_data() {
            return IOURingSQE.nuser_data(this.address());
        }

        @NativeType(value="__u16")
        public short buf_index() {
            return IOURingSQE.nbuf_index(this.address());
        }

        @NativeType(value="__u16")
        public short buf_group() {
            return IOURingSQE.nbuf_group(this.address());
        }

        @NativeType(value="__u16")
        public short personality() {
            return IOURingSQE.npersonality(this.address());
        }

        @NativeType(value="__s32")
        public int splice_fd_in() {
            return IOURingSQE.nsplice_fd_in(this.address());
        }

        @NativeType(value="__u32")
        public int file_index() {
            return IOURingSQE.nfile_index(this.address());
        }

        @NativeType(value="__u32")
        public int optlen() {
            return IOURingSQE.noptlen(this.address());
        }

        @NativeType(value="__u16")
        public short addr_len() {
            return IOURingSQE.naddr_len(this.address());
        }

        @NativeType(value="__u16[1]")
        public ShortBuffer __pad3() {
            return IOURingSQE.n__pad3(this.address());
        }

        @NativeType(value="__u16")
        public short __pad3(int n) {
            return IOURingSQE.n__pad3(this.address(), n);
        }

        @NativeType(value="__u64")
        public long addr3() {
            return IOURingSQE.naddr3(this.address());
        }

        @NativeType(value="__u64[1]")
        public LongBuffer __pad2() {
            return IOURingSQE.n__pad2(this.address());
        }

        @NativeType(value="__u64")
        public long __pad2(int n) {
            return IOURingSQE.n__pad2(this.address(), n);
        }

        @NativeType(value="__u64")
        public long optval() {
            return IOURingSQE.noptval(this.address());
        }

        @NativeType(value="__u8[0]")
        public ByteBuffer cmd() {
            return IOURingSQE.ncmd(this.address());
        }

        @NativeType(value="__u8")
        public byte cmd(int n) {
            return IOURingSQE.ncmd(this.address(), n);
        }

        public Buffer opcode(@NativeType(value="__u8") byte by) {
            IOURingSQE.nopcode(this.address(), by);
            return this;
        }

        public Buffer flags(@NativeType(value="__u8") byte by) {
            IOURingSQE.nflags(this.address(), by);
            return this;
        }

        public Buffer ioprio(@NativeType(value="__u16") short s) {
            IOURingSQE.nioprio(this.address(), s);
            return this;
        }

        public Buffer fd(@NativeType(value="__s32") int n) {
            IOURingSQE.nfd(this.address(), n);
            return this;
        }

        public Buffer off(@NativeType(value="__u64") long l) {
            IOURingSQE.noff(this.address(), l);
            return this;
        }

        public Buffer addr2(@NativeType(value="__u64") long l) {
            IOURingSQE.naddr2(this.address(), l);
            return this;
        }

        public Buffer cmd_op(@NativeType(value="__u32") int n) {
            IOURingSQE.ncmd_op(this.address(), n);
            return this;
        }

        public Buffer __pad1(@NativeType(value="__u32") int n) {
            IOURingSQE.n__pad1(this.address(), n);
            return this;
        }

        public Buffer addr(@NativeType(value="__u64") long l) {
            IOURingSQE.naddr(this.address(), l);
            return this;
        }

        public Buffer splice_off_in(@NativeType(value="__u64") long l) {
            IOURingSQE.nsplice_off_in(this.address(), l);
            return this;
        }

        public Buffer level(@NativeType(value="__u32") int n) {
            IOURingSQE.nlevel(this.address(), n);
            return this;
        }

        public Buffer optname(@NativeType(value="__u32") int n) {
            IOURingSQE.noptname(this.address(), n);
            return this;
        }

        public Buffer len(@NativeType(value="__u32") int n) {
            IOURingSQE.nlen(this.address(), n);
            return this;
        }

        public Buffer rw_flags(@NativeType(value="__kernel_rwf_t") int n) {
            IOURingSQE.nrw_flags(this.address(), n);
            return this;
        }

        public Buffer fsync_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nfsync_flags(this.address(), n);
            return this;
        }

        public Buffer poll_events(@NativeType(value="__u16") short s) {
            IOURingSQE.npoll_events(this.address(), s);
            return this;
        }

        public Buffer poll32_events(@NativeType(value="__u32") int n) {
            IOURingSQE.npoll32_events(this.address(), n);
            return this;
        }

        public Buffer sync_range_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nsync_range_flags(this.address(), n);
            return this;
        }

        public Buffer msg_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nmsg_flags(this.address(), n);
            return this;
        }

        public Buffer timeout_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.ntimeout_flags(this.address(), n);
            return this;
        }

        public Buffer accept_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.naccept_flags(this.address(), n);
            return this;
        }

        public Buffer cancel_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.ncancel_flags(this.address(), n);
            return this;
        }

        public Buffer open_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nopen_flags(this.address(), n);
            return this;
        }

        public Buffer statx_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nstatx_flags(this.address(), n);
            return this;
        }

        public Buffer fadvise_advice(@NativeType(value="__u32") int n) {
            IOURingSQE.nfadvise_advice(this.address(), n);
            return this;
        }

        public Buffer splice_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nsplice_flags(this.address(), n);
            return this;
        }

        public Buffer rename_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nrename_flags(this.address(), n);
            return this;
        }

        public Buffer unlink_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nunlink_flags(this.address(), n);
            return this;
        }

        public Buffer hardlink_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nhardlink_flags(this.address(), n);
            return this;
        }

        public Buffer xattr_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nxattr_flags(this.address(), n);
            return this;
        }

        public Buffer msg_ring_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nmsg_ring_flags(this.address(), n);
            return this;
        }

        public Buffer uring_cmd_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nuring_cmd_flags(this.address(), n);
            return this;
        }

        public Buffer waitid_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nwaitid_flags(this.address(), n);
            return this;
        }

        public Buffer futex_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nfutex_flags(this.address(), n);
            return this;
        }

        public Buffer install_fd_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.ninstall_fd_flags(this.address(), n);
            return this;
        }

        public Buffer nop_flags(@NativeType(value="__u32") int n) {
            IOURingSQE.nnop_flags(this.address(), n);
            return this;
        }

        public Buffer user_data(@NativeType(value="__u64") long l) {
            IOURingSQE.nuser_data(this.address(), l);
            return this;
        }

        public Buffer buf_index(@NativeType(value="__u16") short s) {
            IOURingSQE.nbuf_index(this.address(), s);
            return this;
        }

        public Buffer buf_group(@NativeType(value="__u16") short s) {
            IOURingSQE.nbuf_group(this.address(), s);
            return this;
        }

        public Buffer personality(@NativeType(value="__u16") short s) {
            IOURingSQE.npersonality(this.address(), s);
            return this;
        }

        public Buffer splice_fd_in(@NativeType(value="__s32") int n) {
            IOURingSQE.nsplice_fd_in(this.address(), n);
            return this;
        }

        public Buffer file_index(@NativeType(value="__u32") int n) {
            IOURingSQE.nfile_index(this.address(), n);
            return this;
        }

        public Buffer optlen(@NativeType(value="__u32") int n) {
            IOURingSQE.noptlen(this.address(), n);
            return this;
        }

        public Buffer addr_len(@NativeType(value="__u16") short s) {
            IOURingSQE.naddr_len(this.address(), s);
            return this;
        }

        public Buffer __pad3(@NativeType(value="__u16[1]") ShortBuffer shortBuffer) {
            IOURingSQE.n__pad3(this.address(), shortBuffer);
            return this;
        }

        public Buffer __pad3(int n, @NativeType(value="__u16") short s) {
            IOURingSQE.n__pad3(this.address(), n, s);
            return this;
        }

        public Buffer addr3(@NativeType(value="__u64") long l) {
            IOURingSQE.naddr3(this.address(), l);
            return this;
        }

        public Buffer __pad2(@NativeType(value="__u64[1]") LongBuffer longBuffer) {
            IOURingSQE.n__pad2(this.address(), longBuffer);
            return this;
        }

        public Buffer __pad2(int n, @NativeType(value="__u64") long l) {
            IOURingSQE.n__pad2(this.address(), n, l);
            return this;
        }

        public Buffer optval(@NativeType(value="__u64") long l) {
            IOURingSQE.noptval(this.address(), l);
            return this;
        }

        public Buffer cmd(@NativeType(value="__u8[0]") ByteBuffer byteBuffer) {
            IOURingSQE.ncmd(this.address(), byteBuffer);
            return this;
        }

        public Buffer cmd(int n, @NativeType(value="__u8") byte by) {
            IOURingSQE.ncmd(this.address(), n, by);
            return this;
        }
    }
}

