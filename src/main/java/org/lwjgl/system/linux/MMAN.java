/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.linux;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class MMAN {
    public static final long MAP_FAILED = -1L;
    public static final int PROT_EXEC = 4;
    public static final int PROT_READ = 1;
    public static final int PROT_WRITE = 2;
    public static final int PROT_NONE = 0;
    public static final int PROT_GROWSDOWN = 0x1000000;
    public static final int PROT_GROWSUP = 0x2000000;
    public static final int MAP_SHARED = 1;
    public static final int MAP_SHARED_VALIDATE = 3;
    public static final int MAP_PRIVATE = 2;
    public static final int MAP_HUGE_SHIFT = 26;
    public static final int MAP_HUGE_MASK = 63;
    public static final int MAP_32BIT = 64;
    public static final int MAP_ANONYMOUS = 32;
    public static final int MAP_ANON = 32;
    public static final int MAP_DENYWRITE = 2048;
    public static final int MAP_EXECUTABLE = 4096;
    public static final int MAP_FILE = 0;
    public static final int MAP_FIXED = 16;
    public static final int MAP_FIXED_NOREPLACE = 0x100000;
    public static final int MAP_GROWSDOWN = 256;
    public static final int MAP_HUGETLB = 262144;
    public static final int MAP_HUGE_2MB = 0x54000000;
    public static final int MAP_HUGE_1GB = 0x78000000;
    public static final int MAP_LOCKED = 8192;
    public static final int MAP_NONBLOCK = 65536;
    public static final int MAP_NORESERVE = 16384;
    public static final int MAP_POPULATE = 32768;
    public static final int MAP_STACK = 131072;
    public static final int MAP_SYNC = 524288;
    public static final int MAP_UNINITIALIZED = 0x4000000;

    protected MMAN() {
        throw new UnsupportedOperationException();
    }

    public static native long nmmap(long var0, long var2, long var4, int var6, int var7, int var8, long var9);

    @NativeType(value="void *")
    public static long mmap(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="void *") long l, @NativeType(value="size_t") long l2, int n, int n2, int n3, @NativeType(value="off_t") long l3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return MMAN.nmmap(MemoryUtil.memAddressSafe(intBuffer), l, l2, n, n2, n3, l3);
    }

    public static native int nmunmap(long var0, long var2, long var4);

    public static int munmap(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="void *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return MMAN.nmunmap(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining());
    }

    static {
        Library.initialize();
    }
}

