/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux.liburing;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.CMsghdr;
import org.lwjgl.system.linux.EpollEvent;
import org.lwjgl.system.linux.IOVec;
import org.lwjgl.system.linux.KernelTimespec;
import org.lwjgl.system.linux.Msghdr;
import org.lwjgl.system.linux.OpenHow;
import org.lwjgl.system.linux.Sockaddr;
import org.lwjgl.system.linux.Statx;
import org.lwjgl.system.linux.liburing.IOURing;
import org.lwjgl.system.linux.liburing.IOURingBuf;
import org.lwjgl.system.linux.liburing.IOURingBufReg;
import org.lwjgl.system.linux.liburing.IOURingBufRing;
import org.lwjgl.system.linux.liburing.IOURingCQE;
import org.lwjgl.system.linux.liburing.IOURingClockRegister;
import org.lwjgl.system.linux.liburing.IOURingNAPI;
import org.lwjgl.system.linux.liburing.IOURingParams;
import org.lwjgl.system.linux.liburing.IOURingProbe;
import org.lwjgl.system.linux.liburing.IOURingRecvmsgOut;
import org.lwjgl.system.linux.liburing.IOURingRestriction;
import org.lwjgl.system.linux.liburing.IOURingSQE;
import org.lwjgl.system.linux.liburing.IOURingSyncCancelReg;

public class LibURing {
    public static final long LIBURING_UDATA_TIMEOUT = -1L;

    protected LibURing() {
        throw new UnsupportedOperationException();
    }

    public static native long nio_uring_get_probe_ring(long var0);

    @NativeType(value="struct io_uring_probe *")
    public static @Nullable IOURingProbe io_uring_get_probe_ring(@NativeType(value="struct io_uring *") IOURing iOURing) {
        long l = LibURing.nio_uring_get_probe_ring(iOURing.address());
        return IOURingProbe.createSafe(l);
    }

    public static native long nio_uring_get_probe();

    @NativeType(value="struct io_uring_probe *")
    public static @Nullable IOURingProbe io_uring_get_probe() {
        long l = LibURing.nio_uring_get_probe();
        return IOURingProbe.createSafe(l);
    }

    public static native void nio_uring_free_probe(long var0);

    public static void io_uring_free_probe(@NativeType(value="struct io_uring_probe *") IOURingProbe iOURingProbe) {
        LibURing.nio_uring_free_probe(iOURingProbe.address());
    }

    public static native int nio_uring_opcode_supported(long var0, int var2);

    public static int io_uring_opcode_supported(@NativeType(value="struct io_uring_probe const *") IOURingProbe iOURingProbe, int n) {
        return LibURing.nio_uring_opcode_supported(iOURingProbe.address(), n);
    }

    public static native int nio_uring_queue_init_mem(int var0, long var1, long var3, long var5, long var7);

    public static int io_uring_queue_init_mem(@NativeType(value="unsigned") int n, @NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams, @NativeType(value="void *") ByteBuffer byteBuffer) {
        return LibURing.nio_uring_queue_init_mem(n, iOURing.address(), iOURingParams.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static native int nio_uring_queue_init_params(int var0, long var1, long var3);

    public static int io_uring_queue_init_params(@NativeType(value="unsigned") int n, @NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams) {
        return LibURing.nio_uring_queue_init_params(n, iOURing.address(), iOURingParams.address());
    }

    public static native int nio_uring_queue_init(int var0, long var1, int var3);

    public static int io_uring_queue_init(@NativeType(value="unsigned") int n, @NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n2) {
        return LibURing.nio_uring_queue_init(n, iOURing.address(), n2);
    }

    public static native int nio_uring_queue_mmap(int var0, long var1, long var3);

    public static int io_uring_queue_mmap(int n, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams, @NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_queue_mmap(n, iOURingParams.address(), iOURing.address());
    }

    public static native int nio_uring_ring_dontfork(long var0);

    public static int io_uring_ring_dontfork(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_ring_dontfork(iOURing.address());
    }

    public static native void nio_uring_queue_exit(long var0);

    public static void io_uring_queue_exit(@NativeType(value="struct io_uring *") IOURing iOURing) {
        LibURing.nio_uring_queue_exit(iOURing.address());
    }

    public static native int nio_uring_peek_batch_cqe(long var0, long var2, int var4);

    @NativeType(value="unsigned")
    public static int io_uring_peek_batch_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        return LibURing.nio_uring_peek_batch_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining());
    }

    public static native int nio_uring_wait_cqes(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_wait_cqes(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @NativeType(value="struct __kernel_timespec *") @Nullable KernelTimespec kernelTimespec, @NativeType(value="sigset_t *") long l) {
        return LibURing.nio_uring_wait_cqes(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), l);
    }

    public static native int nio_uring_wait_cqes_min_timeout(long var0, long var2, int var4, long var5, int var7, long var8);

    public static int io_uring_wait_cqes_min_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @NativeType(value="struct __kernel_timespec *") @Nullable KernelTimespec kernelTimespec, @NativeType(value="unsigned int") int n, @NativeType(value="sigset_t *") long l) {
        return LibURing.nio_uring_wait_cqes_min_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), n, l);
    }

    public static native int nio_uring_wait_cqe_timeout(long var0, long var2, long var4);

    public static int io_uring_wait_cqe_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @NativeType(value="struct __kernel_timespec *") @Nullable KernelTimespec kernelTimespec) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_wait_cqe_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddressSafe(kernelTimespec));
    }

    public static native int nio_uring_submit(long var0);

    public static int io_uring_submit(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_submit(iOURing.address());
    }

    public static native int nio_uring_submit_and_wait(long var0, int var2);

    public static int io_uring_submit_and_wait(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n) {
        return LibURing.nio_uring_submit_and_wait(iOURing.address(), n);
    }

    public static native int nio_uring_submit_and_wait_timeout(long var0, long var2, int var4, long var5, long var7);

    public static int io_uring_submit_and_wait_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @NativeType(value="struct __kernel_timespec *") @Nullable KernelTimespec kernelTimespec, @NativeType(value="sigset_t *") long l) {
        return LibURing.nio_uring_submit_and_wait_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), l);
    }

    public static native int nio_uring_submit_and_wait_min_timeout(long var0, long var2, int var4, long var5, int var7, long var8);

    public static int io_uring_submit_and_wait_min_timeout(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer, @NativeType(value="struct __kernel_timespec *") @Nullable KernelTimespec kernelTimespec, @NativeType(value="unsigned") int n, @NativeType(value="sigset_t *") long l) {
        return LibURing.nio_uring_submit_and_wait_min_timeout(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), MemoryUtil.memAddressSafe(kernelTimespec), n, l);
    }

    public static native int nio_uring_clone_buffers(long var0, long var2);

    public static int io_uring_clone_buffers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring *") IOURing iOURing2) {
        return LibURing.nio_uring_clone_buffers(iOURing.address(), iOURing2.address());
    }

    public static native int nio_uring_register_buffers(long var0, long var2, int var4);

    public static int io_uring_register_buffers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct iovec const *") IOVec.Buffer buffer) {
        return LibURing.nio_uring_register_buffers(iOURing.address(), buffer.address(), buffer.remaining());
    }

    public static native int nio_uring_register_buffers_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_buffers_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_tags(iOURing.address(), buffer.address(), MemoryUtil.memAddress(longBuffer), buffer.remaining());
    }

    public static native int nio_uring_register_buffers_sparse(long var0, int var2);

    public static int io_uring_register_buffers_sparse(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n) {
        return LibURing.nio_uring_register_buffers_sparse(iOURing.address(), n);
    }

    public static native int nio_uring_register_buffers_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_buffers_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, buffer.remaining());
        }
        return LibURing.nio_uring_register_buffers_update_tag(iOURing.address(), n, buffer.address(), MemoryUtil.memAddress(longBuffer), buffer.remaining());
    }

    public static native int nio_uring_unregister_buffers(long var0);

    public static int io_uring_unregister_buffers(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_buffers(iOURing.address());
    }

    public static native int nio_uring_register_files(long var0, long var2, int var4);

    public static int io_uring_register_files(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") IntBuffer intBuffer) {
        return LibURing.nio_uring_register_files(iOURing.address(), MemoryUtil.memAddress(intBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_files_tags(long var0, long var2, long var4, int var6);

    public static int io_uring_register_files_tags(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="int const *") IntBuffer intBuffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        return LibURing.nio_uring_register_files_tags(iOURing.address(), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_files_sparse(long var0, int var2);

    public static int io_uring_register_files_sparse(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n) {
        return LibURing.nio_uring_register_files_sparse(iOURing.address(), n);
    }

    public static native int nio_uring_register_files_update_tag(long var0, int var2, long var3, long var5, int var7);

    public static int io_uring_register_files_update_tag(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n, @NativeType(value="int const *") IntBuffer intBuffer, @NativeType(value="__u64 const *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, intBuffer.remaining());
        }
        return LibURing.nio_uring_register_files_update_tag(iOURing.address(), n, MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddress(longBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_unregister_files(long var0);

    public static int io_uring_unregister_files(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_files(iOURing.address());
    }

    public static native int nio_uring_register_files_update(long var0, int var2, long var3, int var5);

    public static int io_uring_register_files_update(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n, @NativeType(value="int const *") IntBuffer intBuffer) {
        return LibURing.nio_uring_register_files_update(iOURing.address(), n, MemoryUtil.memAddress(intBuffer), intBuffer.remaining());
    }

    public static native int nio_uring_register_eventfd(long var0, int var2);

    public static int io_uring_register_eventfd(@NativeType(value="struct io_uring *") IOURing iOURing, int n) {
        return LibURing.nio_uring_register_eventfd(iOURing.address(), n);
    }

    public static native int nio_uring_register_eventfd_async(long var0, int var2);

    public static int io_uring_register_eventfd_async(@NativeType(value="struct io_uring *") IOURing iOURing, int n) {
        return LibURing.nio_uring_register_eventfd_async(iOURing.address(), n);
    }

    public static native int nio_uring_unregister_eventfd(long var0);

    public static int io_uring_unregister_eventfd(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_eventfd(iOURing.address());
    }

    public static native int nio_uring_register_probe(long var0, long var2, int var4);

    public static int io_uring_register_probe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_probe *") IOURingProbe iOURingProbe, @NativeType(value="unsigned") int n) {
        return LibURing.nio_uring_register_probe(iOURing.address(), iOURingProbe.address(), n);
    }

    public static native int nio_uring_register_personality(long var0);

    public static int io_uring_register_personality(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_register_personality(iOURing.address());
    }

    public static native int nio_uring_unregister_personality(long var0, int var2);

    public static int io_uring_unregister_personality(@NativeType(value="struct io_uring *") IOURing iOURing, int n) {
        return LibURing.nio_uring_unregister_personality(iOURing.address(), n);
    }

    public static native int nio_uring_register_restrictions(long var0, long var2, int var4);

    public static int io_uring_register_restrictions(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_restriction *") IOURingRestriction.Buffer buffer) {
        return LibURing.nio_uring_register_restrictions(iOURing.address(), buffer.address(), buffer.remaining());
    }

    public static native int nio_uring_enable_rings(long var0);

    public static int io_uring_enable_rings(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_enable_rings(iOURing.address());
    }

    public static native int n__io_uring_sqring_wait(long var0);

    public static int __io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.n__io_uring_sqring_wait(iOURing.address());
    }

    public static native int nio_uring_register_iowq_aff(long var0, long var2, long var4);

    public static int io_uring_register_iowq_aff(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="size_t") long l, @NativeType(value="cpu_set_t const *") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return LibURing.nio_uring_register_iowq_aff(iOURing.address(), l, l2);
    }

    public static native int nio_uring_unregister_iowq_aff(long var0);

    public static int io_uring_unregister_iowq_aff(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_iowq_aff(iOURing.address());
    }

    public static native int nio_uring_register_iowq_max_workers(long var0, long var2);

    public static int io_uring_register_iowq_max_workers(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 2);
        }
        return LibURing.nio_uring_register_iowq_max_workers(iOURing.address(), MemoryUtil.memAddress(intBuffer));
    }

    public static native int nio_uring_register_ring_fd(long var0);

    public static int io_uring_register_ring_fd(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_register_ring_fd(iOURing.address());
    }

    public static native int nio_uring_unregister_ring_fd(long var0);

    public static int io_uring_unregister_ring_fd(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_unregister_ring_fd(iOURing.address());
    }

    public static native int nio_uring_close_ring_fd(long var0);

    public static int io_uring_close_ring_fd(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_close_ring_fd(iOURing.address());
    }

    public static native int nio_uring_register_buf_ring(long var0, long var2, int var4);

    public static int io_uring_register_buf_ring(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_buf_reg *") IOURingBufReg iOURingBufReg, @NativeType(value="unsigned int") int n) {
        return LibURing.nio_uring_register_buf_ring(iOURing.address(), iOURingBufReg.address(), n);
    }

    public static native int nio_uring_unregister_buf_ring(long var0, int var2);

    public static int io_uring_unregister_buf_ring(@NativeType(value="struct io_uring *") IOURing iOURing, int n) {
        return LibURing.nio_uring_unregister_buf_ring(iOURing.address(), n);
    }

    public static native int nio_uring_buf_ring_head(long var0, int var2, long var3);

    public static int io_uring_buf_ring_head(@NativeType(value="struct io_uring *") IOURing iOURing, int n, @NativeType(value="unsigned short *") ShortBuffer shortBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)shortBuffer, 1);
        }
        return LibURing.nio_uring_buf_ring_head(iOURing.address(), n, MemoryUtil.memAddress(shortBuffer));
    }

    public static native int nio_uring_register_sync_cancel(long var0, long var2);

    public static int io_uring_register_sync_cancel(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_sync_cancel_reg *") IOURingSyncCancelReg iOURingSyncCancelReg) {
        return LibURing.nio_uring_register_sync_cancel(iOURing.address(), iOURingSyncCancelReg.address());
    }

    public static native int nio_uring_register_file_alloc_range(long var0, int var2, int var3);

    public static int io_uring_register_file_alloc_range(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned") int n, @NativeType(value="unsigned") int n2) {
        return LibURing.nio_uring_register_file_alloc_range(iOURing.address(), n, n2);
    }

    public static native int nio_uring_register_napi(long var0, long var2);

    public static int io_uring_register_napi(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_napi *") IOURingNAPI iOURingNAPI) {
        return LibURing.nio_uring_register_napi(iOURing.address(), iOURingNAPI.address());
    }

    public static native int nio_uring_unregister_napi(long var0, long var2);

    public static int io_uring_unregister_napi(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_napi *") IOURingNAPI iOURingNAPI) {
        return LibURing.nio_uring_unregister_napi(iOURing.address(), iOURingNAPI.address());
    }

    public static native int nio_uring_register_clock(long var0, long var2);

    public static int io_uring_register_clock(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_clock_register *") IOURingClockRegister iOURingClockRegister) {
        return LibURing.nio_uring_register_clock(iOURing.address(), iOURingClockRegister.address());
    }

    public static native int nio_uring_get_events(long var0);

    public static int io_uring_get_events(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_get_events(iOURing.address());
    }

    public static native int nio_uring_submit_and_get_events(long var0);

    public static int io_uring_submit_and_get_events(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_submit_and_get_events(iOURing.address());
    }

    public static native int nio_uring_enter(int var0, int var1, int var2, int var3, long var4);

    public static int io_uring_enter(@NativeType(value="unsigned int") int n, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="sigset_t *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return LibURing.nio_uring_enter(n, n2, n3, n4, l);
    }

    public static native int nio_uring_enter2(int var0, int var1, int var2, int var3, long var4, long var6);

    public static int io_uring_enter2(@NativeType(value="unsigned int") int n, @NativeType(value="unsigned int") int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="sigset_t *") long l, @NativeType(value="size_t") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return LibURing.nio_uring_enter2(n, n2, n3, n4, l, l2);
    }

    public static native int nio_uring_setup(int var0, long var1);

    public static int io_uring_setup(@NativeType(value="unsigned int") int n, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams) {
        return LibURing.nio_uring_setup(n, iOURingParams.address());
    }

    public static native int io_uring_register(@NativeType(value="unsigned int") int var0, @NativeType(value="unsigned int") int var1, @NativeType(value="void *") long var2, @NativeType(value="unsigned int") int var4);

    public static native long nio_uring_setup_buf_ring(long var0, int var2, int var3, int var4, long var5);

    @NativeType(value="struct io_uring_buf_ring *")
    public static @Nullable IOURingBufRing io_uring_setup_buf_ring(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="unsigned int") int n, int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="int *") IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        long l = LibURing.nio_uring_setup_buf_ring(iOURing.address(), n, n2, n3, MemoryUtil.memAddress(intBuffer));
        return IOURingBufRing.createSafe(l);
    }

    public static native int nio_uring_free_buf_ring(long var0, long var2, int var4, int var5);

    public static int io_uring_free_buf_ring(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing, @NativeType(value="unsigned int") int n, int n2) {
        return LibURing.nio_uring_free_buf_ring(iOURing.address(), iOURingBufRing.address(), n, n2);
    }

    public static native void nio_uring_cqe_seen(long var0, long var2);

    public static void io_uring_cqe_seen(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe *") IOURingCQE iOURingCQE) {
        LibURing.nio_uring_cqe_seen(iOURing.address(), iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_data(long var0, long var2);

    public static void io_uring_sqe_set_data(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        LibURing.nio_uring_sqe_set_data(iOURingSQE.address(), l);
    }

    public static native long nio_uring_cqe_get_data(long var0);

    @NativeType(value="void *")
    public static long io_uring_cqe_get_data(@NativeType(value="struct io_uring_cqe const *") IOURingCQE iOURingCQE) {
        return LibURing.nio_uring_cqe_get_data(iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_data64(long var0, long var2);

    public static void io_uring_sqe_set_data64(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l) {
        LibURing.nio_uring_sqe_set_data64(iOURingSQE.address(), l);
    }

    public static native long nio_uring_cqe_get_data64(long var0);

    @NativeType(value="__u64")
    public static long io_uring_cqe_get_data64(@NativeType(value="struct io_uring_cqe const *") IOURingCQE iOURingCQE) {
        return LibURing.nio_uring_cqe_get_data64(iOURingCQE.address());
    }

    public static native void nio_uring_sqe_set_flags(long var0, int var2);

    public static void io_uring_sqe_set_flags(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_sqe_set_flags(iOURingSQE.address(), n);
    }

    public static native void nio_uring_prep_splice(long var0, int var2, long var3, int var5, long var6, int var8, int var9);

    public static void io_uring_prep_splice(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="int64_t") long l, int n2, @NativeType(value="int64_t") long l2, @NativeType(value="unsigned int") int n3, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_splice(iOURingSQE.address(), n, l, n2, l2, n3, n4);
    }

    public static native void nio_uring_prep_tee(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_tee(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_tee(iOURingSQE.address(), n, n2, n3, n4);
    }

    public static native void nio_uring_prep_readv(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_readv(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n2) {
        LibURing.nio_uring_prep_readv(iOURingSQE.address(), n, buffer.address(), buffer.remaining(), n2);
    }

    public static native void nio_uring_prep_readv2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_readv2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n2, int n3) {
        LibURing.nio_uring_prep_readv2(iOURingSQE.address(), n, buffer.address(), buffer.remaining(), n2, n3);
    }

    public static native void nio_uring_prep_read_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_read_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void *") ByteBuffer byteBuffer, int n2, int n3) {
        LibURing.nio_uring_prep_read_fixed(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, n3);
    }

    public static native void nio_uring_prep_writev(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_writev(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n2) {
        LibURing.nio_uring_prep_writev(iOURingSQE.address(), n, buffer.address(), buffer.remaining(), n2);
    }

    public static native void nio_uring_prep_writev2(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_writev2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct iovec const *") IOVec.Buffer buffer, int n2, int n3) {
        LibURing.nio_uring_prep_writev2(iOURingSQE.address(), n, buffer.address(), buffer.remaining(), n2, n3);
    }

    public static native void nio_uring_prep_write_fixed(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_write_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2, int n3) {
        LibURing.nio_uring_prep_write_fixed(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, n3);
    }

    public static native void nio_uring_prep_recvmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_recvmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct msghdr *") Msghdr msghdr, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_recvmsg(iOURingSQE.address(), n, msghdr.address(), n2);
    }

    public static native void nio_uring_prep_recvmsg_multishot(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_recvmsg_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct msghdr *") Msghdr msghdr, @NativeType(value="unsigned") int n2) {
        LibURing.nio_uring_prep_recvmsg_multishot(iOURingSQE.address(), n, msghdr.address(), n2);
    }

    public static native void nio_uring_prep_sendmsg(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_sendmsg(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct msghdr const *") Msghdr msghdr, @NativeType(value="unsigned int") int n2) {
        if (Checks.CHECKS) {
            Msghdr.validate(msghdr.address());
        }
        LibURing.nio_uring_prep_sendmsg(iOURingSQE.address(), n, msghdr.address(), n2);
    }

    public static native void nio_uring_prep_poll_add(long var0, int var2, int var3);

    public static void io_uring_prep_poll_add(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_poll_add(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_poll_multishot(long var0, int var2, int var3);

    public static void io_uring_prep_poll_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_poll_multishot(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_poll_remove(long var0, long var2);

    public static void io_uring_prep_poll_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l) {
        LibURing.nio_uring_prep_poll_remove(iOURingSQE.address(), l);
    }

    public static native void nio_uring_prep_poll_update(long var0, long var2, long var4, int var6, int var7);

    public static void io_uring_prep_poll_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l, @NativeType(value="__u64") long l2, @NativeType(value="unsigned int") int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_poll_update(iOURingSQE.address(), l, l2, n, n2);
    }

    public static native void nio_uring_prep_fsync(long var0, int var2, int var3);

    public static void io_uring_prep_fsync(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_fsync(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_nop(long var0);

    public static void io_uring_prep_nop(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE) {
        LibURing.nio_uring_prep_nop(iOURingSQE.address());
    }

    public static native void nio_uring_prep_timeout(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="unsigned int") int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_timeout(iOURingSQE.address(), kernelTimespec.address(), n, n2);
    }

    public static native void nio_uring_prep_timeout_remove(long var0, long var2, int var4);

    public static void io_uring_prep_timeout_remove(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_prep_timeout_remove(iOURingSQE.address(), l, n);
    }

    public static native void nio_uring_prep_timeout_update(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_timeout_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_prep_timeout_update(iOURingSQE.address(), kernelTimespec.address(), l, n);
    }

    public static native void nio_uring_prep_accept(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_accept(iOURingSQE.address(), n, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n2);
    }

    public static native void nio_uring_prep_accept_direct(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n2, @NativeType(value="unsigned int") int n3) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_accept_direct(iOURingSQE.address(), n, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n2, n3);
    }

    public static native void nio_uring_prep_multishot_accept(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_multishot_accept(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_multishot_accept(iOURingSQE.address(), n, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n2);
    }

    public static native void nio_uring_prep_multishot_accept_direct(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_multishot_accept_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t *") IntBuffer intBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_multishot_accept_direct(iOURingSQE.address(), n, sockaddr.address(), MemoryUtil.memAddress(intBuffer), n2);
    }

    public static native void nio_uring_prep_cancel64(long var0, long var2, int var4);

    public static void io_uring_prep_cancel64(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="__u64") long l, int n) {
        LibURing.nio_uring_prep_cancel64(iOURingSQE.address(), l, n);
    }

    public static native void nio_uring_prep_cancel(long var0, long var2, int var4);

    public static void io_uring_prep_cancel(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") long l, int n) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        LibURing.nio_uring_prep_cancel(iOURingSQE.address(), l, n);
    }

    public static native void nio_uring_prep_cancel_fd(long var0, int var2, int var3);

    public static void io_uring_prep_cancel_fd(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_cancel_fd(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_link_timeout(long var0, long var2, int var4);

    public static void io_uring_prep_link_timeout(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct __kernel_timespec *") KernelTimespec kernelTimespec, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_prep_link_timeout(iOURingSQE.address(), kernelTimespec.address(), n);
    }

    public static native void nio_uring_prep_connect(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_connect(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr const *") Sockaddr sockaddr, @NativeType(value="socklen_t") int n2) {
        LibURing.nio_uring_prep_connect(iOURingSQE.address(), n, sockaddr.address(), n2);
    }

    public static native void nio_uring_prep_bind(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_bind(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct sockaddr *") Sockaddr sockaddr, @NativeType(value="socklen_t") int n2) {
        LibURing.nio_uring_prep_bind(iOURingSQE.address(), n, sockaddr.address(), n2);
    }

    public static native void nio_uring_prep_listen(long var0, int var2, int var3);

    public static void io_uring_prep_listen(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2) {
        LibURing.nio_uring_prep_listen(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_files_update(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_files_update(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="int *") IntBuffer intBuffer, int n) {
        LibURing.nio_uring_prep_files_update(iOURingSQE.address(), MemoryUtil.memAddress(intBuffer), intBuffer.remaining(), n);
    }

    public static native void nio_uring_prep_fallocate(long var0, int var2, int var3, long var4, long var6);

    public static void io_uring_prep_fallocate(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, @NativeType(value="off_t") long l, @NativeType(value="off_t") long l2) {
        LibURing.nio_uring_prep_fallocate(iOURingSQE.address(), n, n2, l, l2);
    }

    public static native void nio_uring_prep_openat(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2, int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat(iOURingSQE.address(), n, l, n2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_openat_direct(long var0, int var2, long var3, int var5, int var6, int var7);

    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, int n3, @NativeType(value="unsigned int") int n4) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat_direct(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2, n3, n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2, int n3, @NativeType(value="unsigned int") int n4) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat_direct(iOURingSQE.address(), n, l, n2, n3, n4);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static native void nio_uring_prep_open(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_open(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n, @NativeType(value="mode_t") int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_open(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_open(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n, @NativeType(value="mode_t") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_open(iOURingSQE.address(), l, n, n2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_open_direct(long var0, long var2, int var4, int var5, int var6);

    public static void io_uring_prep_open_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n, @NativeType(value="mode_t") int n2, @NativeType(value="unsigned") int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_open_direct(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n, n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_open_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n, @NativeType(value="mode_t") int n2, @NativeType(value="unsigned") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_open_direct(iOURingSQE.address(), l, n, n2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_close(long var0, int var2);

    public static void io_uring_prep_close(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n) {
        LibURing.nio_uring_prep_close(iOURingSQE.address(), n);
    }

    public static native void nio_uring_prep_close_direct(long var0, int var2);

    public static void io_uring_prep_close_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_prep_close_direct(iOURingSQE.address(), n);
    }

    public static native void nio_uring_prep_read(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_read(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_read(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_read_multishot(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_read_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2, @NativeType(value="__u64") long l, int n3) {
        LibURing.nio_uring_prep_read_multishot(iOURingSQE.address(), n, n2, l, n3);
    }

    public static native void nio_uring_prep_write(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_write(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_write(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_statx(long var0, int var2, long var3, int var5, int var6, long var7);

    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="struct statx *") Statx statx) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_statx(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2, n3, statx.address());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_statx(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2, @NativeType(value="unsigned int") int n3, @NativeType(value="struct statx *") Statx statx) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_statx(iOURingSQE.address(), n, l, n2, n3, statx.address());
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_fadvise(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_fadvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="__u64") long l, @NativeType(value="__u32") int n2, int n3) {
        LibURing.nio_uring_prep_fadvise(iOURingSQE.address(), n, l, n2, n3);
    }

    public static native void nio_uring_prep_madvise(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_madvise(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") ByteBuffer byteBuffer, int n) {
        LibURing.nio_uring_prep_madvise(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n);
    }

    public static native void nio_uring_prep_fadvise64(long var0, int var2, long var3, int var5, int var6);

    public static void io_uring_prep_fadvise64(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="__u64") long l, @NativeType(value="__u32") int n2, int n3) {
        LibURing.nio_uring_prep_fadvise64(iOURingSQE.address(), n, l, n2, n3);
    }

    public static native void nio_uring_prep_madvise64(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_madvise64(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") ByteBuffer byteBuffer, int n) {
        LibURing.nio_uring_prep_madvise64(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n);
    }

    public static native void nio_uring_prep_send(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_send(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_send(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_send_bundle(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_send_bundle(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="size_t") long l, int n2) {
        LibURing.nio_uring_prep_send_bundle(iOURingSQE.address(), n, l, n2);
    }

    public static native void nio_uring_prep_send_set_addr(long var0, long var2, short var4);

    public static void io_uring_prep_send_set_addr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct sockaddr const *") Sockaddr sockaddr, @NativeType(value="__u16") short s) {
        LibURing.nio_uring_prep_send_set_addr(iOURingSQE.address(), sockaddr.address(), s);
    }

    public static native void nio_uring_prep_sendto(long var0, int var2, long var3, long var5, int var7, long var8, int var10);

    public static void io_uring_prep_sendto(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2, @NativeType(value="struct sockaddr const *") Sockaddr sockaddr, @NativeType(value="socklen_t") int n3) {
        LibURing.nio_uring_prep_sendto(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, sockaddr.address(), n3);
    }

    public static native void nio_uring_prep_send_zc(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_send_zc(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2, @NativeType(value="unsigned") int n3) {
        LibURing.nio_uring_prep_send_zc(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, n3);
    }

    public static native void nio_uring_prep_send_zc_fixed(long var0, int var2, long var3, long var5, int var7, int var8, int var9);

    public static void io_uring_prep_send_zc_fixed(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void const *") ByteBuffer byteBuffer, int n2, @NativeType(value="unsigned") int n3, @NativeType(value="unsigned") int n4) {
        LibURing.nio_uring_prep_send_zc_fixed(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2, n3, n4);
    }

    public static native void nio_uring_prep_sendmsg_zc(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_sendmsg_zc(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="struct msghdr const *") Msghdr msghdr, @NativeType(value="unsigned") int n2) {
        if (Checks.CHECKS) {
            Msghdr.validate(msghdr.address());
        }
        LibURing.nio_uring_prep_sendmsg_zc(iOURingSQE.address(), n, msghdr.address(), n2);
    }

    public static native void nio_uring_prep_recv(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_recv(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_recv(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native void nio_uring_prep_recv_multishot(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_recv_multishot(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="void *") ByteBuffer byteBuffer, int n2) {
        LibURing.nio_uring_prep_recv_multishot(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n2);
    }

    public static native long nio_uring_recvmsg_validate(long var0, int var2, long var3);

    @NativeType(value="struct io_uring_recvmsg_out *")
    public static @Nullable IOURingRecvmsgOut io_uring_recvmsg_validate(@NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="struct msghdr *") Msghdr msghdr) {
        long l = LibURing.nio_uring_recvmsg_validate(MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), msghdr.address());
        return IOURingRecvmsgOut.createSafe(l);
    }

    public static native long nio_uring_recvmsg_name(long var0);

    @NativeType(value="void *")
    public static long io_uring_recvmsg_name(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut iOURingRecvmsgOut) {
        return LibURing.nio_uring_recvmsg_name(iOURingRecvmsgOut.address());
    }

    public static native long nio_uring_recvmsg_cmsg_firsthdr(long var0, long var2);

    @NativeType(value="struct cmsghdr *")
    public static @Nullable CMsghdr io_uring_recvmsg_cmsg_firsthdr(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut iOURingRecvmsgOut, @NativeType(value="struct msghdr *") Msghdr msghdr) {
        long l = LibURing.nio_uring_recvmsg_cmsg_firsthdr(iOURingRecvmsgOut.address(), msghdr.address());
        return CMsghdr.createSafe(l);
    }

    public static native long nio_uring_recvmsg_cmsg_nexthdr(long var0, long var2, long var4);

    @NativeType(value="struct cmsghdr *")
    public static @Nullable CMsghdr io_uring_recvmsg_cmsg_nexthdr(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut iOURingRecvmsgOut, @NativeType(value="struct msghdr *") Msghdr msghdr, @NativeType(value="struct cmsghdr *") CMsghdr cMsghdr) {
        long l = LibURing.nio_uring_recvmsg_cmsg_nexthdr(iOURingRecvmsgOut.address(), msghdr.address(), cMsghdr.address());
        return CMsghdr.createSafe(l);
    }

    public static native long nio_uring_recvmsg_payload(long var0, long var2);

    @NativeType(value="void *")
    public static long io_uring_recvmsg_payload(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut iOURingRecvmsgOut, @NativeType(value="struct msghdr *") Msghdr msghdr) {
        return LibURing.nio_uring_recvmsg_payload(iOURingRecvmsgOut.address(), msghdr.address());
    }

    public static native int nio_uring_recvmsg_payload_length(long var0, int var2, long var3);

    @NativeType(value="unsigned int")
    public static int io_uring_recvmsg_payload_length(@NativeType(value="struct io_uring_recvmsg_out *") IOURingRecvmsgOut iOURingRecvmsgOut, int n, @NativeType(value="struct msghdr *") Msghdr msghdr) {
        return LibURing.nio_uring_recvmsg_payload_length(iOURingRecvmsgOut.address(), n, msghdr.address());
    }

    public static native void nio_uring_prep_openat2(long var0, int var2, long var3, long var5);

    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct open_how *") OpenHow openHow) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat2(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), openHow.address());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat2(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct open_how *") OpenHow openHow) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat2(iOURingSQE.address(), n, l, openHow.address());
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_openat2_direct(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct open_how *") OpenHow openHow, @NativeType(value="unsigned int") int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_openat2_direct(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), openHow.address(), n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_openat2_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct open_how *") OpenHow openHow, @NativeType(value="unsigned int") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_openat2_direct(iOURingSQE.address(), n, l, openHow.address(), n2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_epoll_ctl(long var0, int var2, int var3, int var4, long var5);

    public static void io_uring_prep_epoll_ctl(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, @NativeType(value="struct epoll_event *") EpollEvent epollEvent) {
        LibURing.nio_uring_prep_epoll_ctl(iOURingSQE.address(), n, n2, n3, epollEvent.address());
    }

    public static native void nio_uring_prep_provide_buffers(long var0, long var2, int var4, int var5, int var6, int var7);

    public static void io_uring_prep_provide_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="void *") ByteBuffer byteBuffer, int n, int n2, int n3) {
        LibURing.nio_uring_prep_provide_buffers(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n, n2, n3);
    }

    public static native void nio_uring_prep_remove_buffers(long var0, int var2, int var3);

    public static void io_uring_prep_remove_buffers(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2) {
        LibURing.nio_uring_prep_remove_buffers(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_shutdown(long var0, int var2, int var3);

    public static void io_uring_prep_shutdown(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2) {
        LibURing.nio_uring_prep_shutdown(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_unlinkat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_unlinkat(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_unlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_unlinkat(iOURingSQE.address(), n, l, n2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_unlink(long var0, long var2, int var4);

    public static void io_uring_prep_unlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_unlink(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_unlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_unlink(iOURingSQE.address(), l, n);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_renameat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer2, @NativeType(value="unsigned int") int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_renameat(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2, MemoryUtil.memAddress(byteBuffer2), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_renameat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2, @NativeType(value="char const *") CharSequence charSequence2, @NativeType(value="unsigned int") int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_renameat(iOURingSQE.address(), n, l, n2, l2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_rename(long var0, long var2, long var4);

    public static void io_uring_prep_rename(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_rename(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_rename(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_rename(iOURingSQE.address(), l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nio_uring_prep_sync_file_range(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_sync_file_range(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2, int n3, int n4) {
        LibURing.nio_uring_prep_sync_file_range(iOURingSQE.address(), n, n2, n3, n4);
    }

    public static native void nio_uring_prep_mkdirat(long var0, int var2, long var3, int var5);

    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_mkdirat(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_mkdirat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_mkdirat(iOURingSQE.address(), n, l, n2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_mkdir(long var0, long var2, int var4);

    public static void io_uring_prep_mkdir(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_mkdir(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_mkdir(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_mkdir(iOURingSQE.address(), l, n);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_symlinkat(long var0, long var2, int var4, long var5);

    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, int n, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_symlinkat(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), n, MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_symlinkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, int n, @NativeType(value="char const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_symlinkat(iOURingSQE.address(), l, n, l2);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_symlink(long var0, long var2, long var4);

    public static void io_uring_prep_symlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_symlink(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_symlink(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_symlink(iOURingSQE.address(), l, l2);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nio_uring_prep_linkat(long var0, int var2, long var3, int var5, long var6, int var8);

    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_linkat(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), n2, MemoryUtil.memAddress(byteBuffer2), n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_linkat(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, int n2, @NativeType(value="char const *") CharSequence charSequence2, int n3) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n4 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_linkat(iOURingSQE.address(), n, l, n2, l2, n3);
        }
        finally {
            memoryStack.setPointer(n4);
        }
    }

    public static native void nio_uring_prep_link(long var0, long var2, long var4, int var6);

    public static void io_uring_prep_link(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer2);
        }
        LibURing.nio_uring_prep_link(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_link(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") CharSequence charSequence2, int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_link(iOURingSQE.address(), l, l2, n);
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_msg_ring_cqe_flags(long var0, int var2, int var3, long var4, int var6, int var7);

    public static void io_uring_prep_msg_ring_cqe_flags(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n3, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_msg_ring_cqe_flags(iOURingSQE.address(), n, n2, l, n3, n4);
    }

    public static native void nio_uring_prep_msg_ring(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_msg_ring(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_msg_ring(iOURingSQE.address(), n, n2, l, n3);
    }

    public static native void nio_uring_prep_msg_ring_fd(long var0, int var2, int var3, int var4, long var5, int var7);

    public static void io_uring_prep_msg_ring_fd(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_msg_ring_fd(iOURingSQE.address(), n, n2, n3, l, n4);
    }

    public static native void nio_uring_prep_msg_ring_fd_alloc(long var0, int var2, int var3, long var4, int var6);

    public static void io_uring_prep_msg_ring_fd_alloc(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, @NativeType(value="__u64") long l, @NativeType(value="unsigned int") int n3) {
        LibURing.nio_uring_prep_msg_ring_fd_alloc(iOURingSQE.address(), n, n2, l, n3);
    }

    public static native void nio_uring_prep_getxattr(long var0, long var2, long var4, long var6, int var8);

    public static void io_uring_prep_getxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char *") ByteBuffer byteBuffer2, @NativeType(value="char const *") ByteBuffer byteBuffer3) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer3);
        }
        LibURing.nio_uring_prep_getxattr(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), MemoryUtil.memAddress(byteBuffer3), byteBuffer2.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_getxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char *") ByteBuffer byteBuffer, @NativeType(value="char const *") CharSequence charSequence2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_getxattr(iOURingSQE.address(), l, MemoryUtil.memAddress(byteBuffer), l2, byteBuffer.remaining());
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nio_uring_prep_setxattr(long var0, long var2, long var4, long var6, int var8, int var9);

    public static void io_uring_prep_setxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, @NativeType(value="char const *") ByteBuffer byteBuffer3, int n) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
            Checks.checkNT1(byteBuffer3);
        }
        LibURing.nio_uring_prep_setxattr(iOURingSQE.address(), MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), MemoryUtil.memAddress(byteBuffer3), n, byteBuffer2.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_setxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") CharSequence charSequence2, int n) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            memoryStack.nUTF8(charSequence2, true);
            long l2 = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_setxattr(iOURingSQE.address(), l, MemoryUtil.memAddress(byteBuffer), l2, n, byteBuffer.remaining());
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_fgetxattr(long var0, int var2, long var3, long var5, int var7);

    public static void io_uring_prep_fgetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char *") ByteBuffer byteBuffer2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_fgetxattr(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), byteBuffer2.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_fgetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char *") ByteBuffer byteBuffer) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_fgetxattr(iOURingSQE.address(), n, l, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native void nio_uring_prep_fsetxattr(long var0, int var2, long var3, long var5, int var7, int var8);

    public static void io_uring_prep_fsetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer2, int n2) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        LibURing.nio_uring_prep_fsetxattr(iOURingSQE.address(), n, MemoryUtil.memAddress(byteBuffer), MemoryUtil.memAddress(byteBuffer2), n2, byteBuffer2.remaining());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void io_uring_prep_fsetxattr(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="char const *") ByteBuffer byteBuffer, int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l = memoryStack.getPointerAddress();
            LibURing.nio_uring_prep_fsetxattr(iOURingSQE.address(), n, l, MemoryUtil.memAddress(byteBuffer), n2, byteBuffer.remaining());
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static native void nio_uring_prep_socket(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_socket(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_socket(iOURingSQE.address(), n, n2, n3, n4);
    }

    public static native void nio_uring_prep_socket_direct(long var0, int var2, int var3, int var4, int var5, int var6);

    public static void io_uring_prep_socket_direct(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, @NativeType(value="unsigned int") int n4, @NativeType(value="unsigned int") int n5) {
        LibURing.nio_uring_prep_socket_direct(iOURingSQE.address(), n, n2, n3, n4, n5);
    }

    public static native void nio_uring_prep_socket_direct_alloc(long var0, int var2, int var3, int var4, int var5);

    public static void io_uring_prep_socket_direct_alloc(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, @NativeType(value="unsigned int") int n4) {
        LibURing.nio_uring_prep_socket_direct_alloc(iOURingSQE.address(), n, n2, n3, n4);
    }

    public static native void nio_uring_prep_cmd_sock(long var0, int var2, int var3, int var4, int var5, long var6, int var8);

    public static void io_uring_prep_cmd_sock(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, int n2, int n3, int n4, @NativeType(value="void *") ByteBuffer byteBuffer) {
        LibURing.nio_uring_prep_cmd_sock(iOURingSQE.address(), n, n2, n3, n4, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    public static native void nio_uring_prep_waitid(long var0, int var2, int var3, long var4, int var6, int var7);

    public static void io_uring_prep_waitid(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="idtype_t") int n, @NativeType(value="id_t") int n2, @NativeType(value="siginfo_t *") long l, int n3, @NativeType(value="unsigned int") int n4) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        LibURing.nio_uring_prep_waitid(iOURingSQE.address(), n, n2, l, n3, n4);
    }

    public static native void nio_uring_prep_futex_wake(long var0, long var2, long var4, long var6, int var8, int var9);

    public static void io_uring_prep_futex_wake(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="uint32_t *") IntBuffer intBuffer, @NativeType(value="uint64_t") long l, @NativeType(value="uint64_t") long l2, @NativeType(value="uint32_t") int n, @NativeType(value="unsigned int") int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_futex_wake(iOURingSQE.address(), MemoryUtil.memAddress(intBuffer), l, l2, n, n2);
    }

    public static native void nio_uring_prep_futex_wait(long var0, long var2, long var4, long var6, int var8, int var9);

    public static void io_uring_prep_futex_wait(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="uint32_t *") IntBuffer intBuffer, @NativeType(value="uint64_t") long l, @NativeType(value="uint64_t") long l2, @NativeType(value="uint32_t") int n, @NativeType(value="unsigned int") int n2) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        LibURing.nio_uring_prep_futex_wait(iOURingSQE.address(), MemoryUtil.memAddress(intBuffer), l, l2, n, n2);
    }

    public static native void nio_uring_prep_futex_waitv(long var0, long var2, int var4, int var5);

    public static void io_uring_prep_futex_waitv(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, @NativeType(value="struct futex_waitv *") PointerBuffer pointerBuffer, @NativeType(value="unsigned int") int n) {
        LibURing.nio_uring_prep_futex_waitv(iOURingSQE.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining(), n);
    }

    public static native void nio_uring_prep_fixed_fd_install(long var0, int var2, int var3);

    public static void io_uring_prep_fixed_fd_install(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="unsigned int") int n2) {
        LibURing.nio_uring_prep_fixed_fd_install(iOURingSQE.address(), n, n2);
    }

    public static native void nio_uring_prep_ftruncate(long var0, int var2, long var3);

    public static void io_uring_prep_ftruncate(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="loff_t") long l) {
        LibURing.nio_uring_prep_ftruncate(iOURingSQE.address(), n, l);
    }

    public static native void nio_uring_prep_cmd_discard(long var0, int var2, long var3, long var5);

    public static void io_uring_prep_cmd_discard(@NativeType(value="struct io_uring_sqe *") IOURingSQE iOURingSQE, int n, @NativeType(value="uint64_t") long l, @NativeType(value="uint64_t") long l2) {
        LibURing.nio_uring_prep_cmd_discard(iOURingSQE.address(), n, l, l2);
    }

    public static native int nio_uring_sq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_ready(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_sq_ready(iOURing.address());
    }

    public static native int nio_uring_sq_space_left(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_sq_space_left(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_sq_space_left(iOURing.address());
    }

    public static native int nio_uring_sqring_wait(long var0);

    public static int io_uring_sqring_wait(@NativeType(value="struct io_uring *") IOURing iOURing) {
        return LibURing.nio_uring_sqring_wait(iOURing.address());
    }

    public static native int nio_uring_cq_ready(long var0);

    @NativeType(value="unsigned int")
    public static int io_uring_cq_ready(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_cq_ready(iOURing.address());
    }

    public static native boolean nio_uring_cq_has_overflow(long var0);

    @NativeType(value="bool")
    public static boolean io_uring_cq_has_overflow(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_cq_has_overflow(iOURing.address());
    }

    public static native boolean nio_uring_cq_eventfd_enabled(long var0);

    @NativeType(value="bool")
    public static boolean io_uring_cq_eventfd_enabled(@NativeType(value="struct io_uring const *") IOURing iOURing) {
        if (Checks.CHECKS) {
            IOURing.validate(iOURing.address());
        }
        return LibURing.nio_uring_cq_eventfd_enabled(iOURing.address());
    }

    public static native int nio_uring_cq_eventfd_toggle(long var0, boolean var2);

    public static int io_uring_cq_eventfd_toggle(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="bool") boolean bl) {
        return LibURing.nio_uring_cq_eventfd_toggle(iOURing.address(), bl);
    }

    public static native int nio_uring_wait_cqe_nr(long var0, long var2, int var4);

    public static int io_uring_wait_cqe_nr(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        return LibURing.nio_uring_wait_cqe_nr(iOURing.address(), MemoryUtil.memAddress(pointerBuffer), pointerBuffer.remaining());
    }

    public static native int nio_uring_peek_cqe(long var0, long var2);

    public static int io_uring_peek_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_peek_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer));
    }

    public static native int nio_uring_wait_cqe(long var0, long var2);

    public static int io_uring_wait_cqe(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_cqe **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return LibURing.nio_uring_wait_cqe(iOURing.address(), MemoryUtil.memAddress(pointerBuffer));
    }

    public static native void nio_uring_buf_ring_advance(long var0, int var2);

    public static void io_uring_buf_ring_advance(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing, int n) {
        LibURing.nio_uring_buf_ring_advance(iOURingBufRing.address(), n);
    }

    public static native void nio_uring_buf_ring_cq_advance(long var0, long var2, int var4);

    public static void io_uring_buf_ring_cq_advance(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing, int n) {
        LibURing.nio_uring_buf_ring_cq_advance(iOURing.address(), iOURingBufRing.address(), n);
    }

    public static native int nio_uring_buf_ring_available(long var0, long var2, short var4);

    public static int io_uring_buf_ring_available(@NativeType(value="struct io_uring *") IOURing iOURing, @NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing, @NativeType(value="unsigned short") short s) {
        return LibURing.nio_uring_buf_ring_available(iOURing.address(), iOURingBufRing.address(), s);
    }

    public static native long nio_uring_get_sqe(long var0);

    @NativeType(value="struct io_uring_sqe *")
    public static @Nullable IOURingSQE io_uring_get_sqe(@NativeType(value="struct io_uring *") IOURing iOURing) {
        long l = LibURing.nio_uring_get_sqe(iOURing.address());
        return IOURingSQE.createSafe(l);
    }

    public static native int io_uring_mlock_size(@NativeType(value="unsigned") int var0, @NativeType(value="unsigned") int var1);

    public static native int nio_uring_mlock_size_params(int var0, long var1);

    public static int io_uring_mlock_size_params(@NativeType(value="unsigned") int n, @NativeType(value="struct io_uring_params *") IOURingParams iOURingParams) {
        return LibURing.nio_uring_mlock_size_params(n, iOURingParams.address());
    }

    public static native int io_uring_major_version();

    public static native int io_uring_minor_version();

    @NativeType(value="bool")
    public static native boolean io_uring_check_version(int var0, int var1);

    public static int io_uring_buf_ring_mask(@NativeType(value="__u32") int n) {
        return n - 1;
    }

    public static void io_uring_buf_ring_init(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing) {
        iOURingBufRing.tail((short)0);
    }

    public static void io_uring_buf_ring_add(@NativeType(value="struct io_uring_buf_ring *") IOURingBufRing iOURingBufRing, @NativeType(value="void *") ByteBuffer byteBuffer, @NativeType(value="unsigned short") short s, int n, int n2) {
        IOURingBuf iOURingBuf = iOURingBufRing.bufs(iOURingBufRing.tail() + n2 & n);
        iOURingBuf.addr(MemoryUtil.memAddress(byteBuffer));
        iOURingBuf.len(byteBuffer.remaining());
        iOURingBuf.bid(s);
    }

    static {
        Library.initialize();
    }
}

