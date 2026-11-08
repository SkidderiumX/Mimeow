/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.linux.IOVec;

public class UIO {
    public static final int UIO_FASTIOV = 8;
    public static final int UIO_MAXIOV = 1024;
    public static final int RWF_HIPRI = 1;
    public static final int RWF_DSYNC = 2;
    public static final int RWF_SYNC = 4;
    public static final int RWF_NOWAIT = 8;
    public static final int RWF_APPEND = 16;

    protected UIO() {
        throw new UnsupportedOperationException();
    }

    public static native long nreadv(long var0, int var2, long var3, int var5);

    @NativeType(value="ssize_t")
    public static long readv(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, @NativeType(value="struct iovec const *") IOVec iOVec, int n2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.nreadv(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), n2);
    }

    public static native long nwritev(long var0, int var2, long var3, int var5);

    @NativeType(value="ssize_t")
    public static long writev(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, @NativeType(value="struct iovec const *") IOVec iOVec, int n2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.nwritev(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), n2);
    }

    public static native long npreadv(long var0, int var2, long var3, int var5, long var6);

    @NativeType(value="ssize_t")
    public static long preadv(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, @NativeType(value="struct iovec const *") IOVec iOVec, int n2, @NativeType(value="off_t") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.npreadv(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), n2, l);
    }

    public static native long npwritev(long var0, int var2, long var3, int var5, long var6);

    @NativeType(value="ssize_t")
    public static long pwritev(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, @NativeType(value="struct iovec const *") IOVec iOVec, int n2, @NativeType(value="off_t") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.npwritev(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), n2, l);
    }

    public static native long nprocess_vm_readv(long var0, int var2, long var3, long var5, long var7, long var9, long var11);

    @NativeType(value="ssize_t")
    public static long process_vm_readv(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="pid_t") int n, @NativeType(value="struct iovec const *") IOVec iOVec, @NativeType(value="unsigned long int") long l, @NativeType(value="struct iovec const *") IOVec iOVec2, @NativeType(value="unsigned long int") long l2, @NativeType(value="unsigned long int") long l3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.nprocess_vm_readv(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), l, iOVec2.address(), l2, l3);
    }

    public static native long nprocess_vm_writev(long var0, int var2, long var3, long var5, long var7, long var9, long var11);

    @NativeType(value="ssize_t")
    public static long process_vm_writev(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="pid_t") int n, @NativeType(value="struct iovec const *") IOVec iOVec, @NativeType(value="unsigned long int") long l, @NativeType(value="struct iovec const *") IOVec iOVec2, @NativeType(value="unsigned long int") long l2, @NativeType(value="unsigned long int") long l3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return UIO.nprocess_vm_writev(MemoryUtil.memAddressSafe(intBuffer), n, iOVec.address(), l, iOVec2.address(), l2, l3);
    }

    static {
        Library.initialize();
    }
}

