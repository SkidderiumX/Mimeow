/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.CRYPTPROTECT_PROMPTSTRUCT;
import org.lwjgl.system.windows.DATA_BLOB;

public class Crypt32 {
    private static final SharedLibrary CRYPT32 = Library.loadNative(Crypt32.class, "org.lwjgl", "crypt32");
    public static final int CRYPTPROTECT_UI_FORBIDDEN = 1;
    public static final int CRYPTPROTECT_LOCAL_MACHINE = 4;
    public static final int CRYPTPROTECT_AUDIT = 16;
    public static final int CRYPTPROTECT_VERIFY_PROTECTION = 64;
    public static final int CRYPTPROTECTMEMORY_SAME_PROCESS = 0;
    public static final int CRYPTPROTECTMEMORY_CROSS_PROCESS = 1;
    public static final int CRYPTPROTECTMEMORY_SAME_LOGON = 2;
    public static final int CRYPTPROTECT_PROMPT_ON_UNPROTECT = 1;
    public static final int CRYPTPROTECT_PROMPT_ON_PROTECT = 2;
    public static final int CRYPTPROTECTMEMORY_BLOCK_SIZE = 16;

    public static SharedLibrary getLibrary() {
        return CRYPT32;
    }

    protected Crypt32() {
        throw new UnsupportedOperationException();
    }

    public static native int nCryptProtectData(long var0, long var2, long var4, long var6, long var8, long var10, int var12, long var13, long var15);

    public static int nCryptProtectData(long l, long l2, long l3, long l4, long l5, long l6, int n, long l7) {
        long l8 = Functions.CryptProtectData;
        return Crypt32.nCryptProtectData(l, l2, l3, l4, l5, l6, n, l7, l8);
    }

    @NativeType(value="BOOL")
    public static boolean CryptProtectData(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB, @NativeType(value="LPCWSTR") @Nullable ByteBuffer byteBuffer, @NativeType(value="DATA_BLOB *") @Nullable DATA_BLOB dATA_BLOB2, @NativeType(value="PVOID") long l, @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") @Nullable CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT, @NativeType(value="DWORD") int n, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkNT2Safe(byteBuffer);
        }
        return Crypt32.nCryptProtectData(MemoryUtil.memAddressSafe(intBuffer), dATA_BLOB.address(), MemoryUtil.memAddressSafe(byteBuffer), MemoryUtil.memAddressSafe(dATA_BLOB2), l, MemoryUtil.memAddressSafe(cRYPTPROTECT_PROMPTSTRUCT), n, dATA_BLOB3.address()) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="BOOL")
    public static boolean CryptProtectData(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB, @NativeType(value="LPCWSTR") @Nullable CharSequence charSequence, @NativeType(value="DATA_BLOB *") @Nullable DATA_BLOB dATA_BLOB2, @NativeType(value="PVOID") long l, @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") @Nullable CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT, @NativeType(value="DWORD") int n, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            memoryStack.nUTF16Safe(charSequence, true);
            long l2 = charSequence == null ? 0L : memoryStack.getPointerAddress();
            boolean bl = Crypt32.nCryptProtectData(MemoryUtil.memAddressSafe(intBuffer), dATA_BLOB.address(), l2, MemoryUtil.memAddressSafe(dATA_BLOB2), l, MemoryUtil.memAddressSafe(cRYPTPROTECT_PROMPTSTRUCT), n, dATA_BLOB3.address()) != 0;
            return bl;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native int nCryptProtectMemory(long var0, long var2, int var4, int var5, long var6);

    public static int nCryptProtectMemory(long l, long l2, int n, int n2) {
        long l3 = Functions.CryptProtectMemory;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return Crypt32.nCryptProtectMemory(l, l2, n, n2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean CryptProtectMemory(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPVOID") ByteBuffer byteBuffer, @NativeType(value="DWORD") int n) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return Crypt32.nCryptProtectMemory(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n) != 0;
    }

    public static native int nCryptUnprotectData(long var0, long var2, long var4, long var6, long var8, long var10, int var12, long var13, long var15);

    public static int nCryptUnprotectData(long l, long l2, long l3, long l4, long l5, long l6, int n, long l7) {
        long l8 = Functions.CryptUnprotectData;
        return Crypt32.nCryptUnprotectData(l, l2, l3, l4, l5, l6, n, l7, l8);
    }

    @NativeType(value="BOOL")
    public static boolean CryptUnprotectData(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB, @NativeType(value="LPWSTR *") @Nullable PointerBuffer pointerBuffer, @NativeType(value="DATA_BLOB *") @Nullable DATA_BLOB dATA_BLOB2, @NativeType(value="PVOID") long l, @NativeType(value="CRYPTPROTECT_PROMPTSTRUCT *") @Nullable CRYPTPROTECT_PROMPTSTRUCT cRYPTPROTECT_PROMPTSTRUCT, @NativeType(value="DWORD") int n, @NativeType(value="DATA_BLOB *") DATA_BLOB dATA_BLOB3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return Crypt32.nCryptUnprotectData(MemoryUtil.memAddressSafe(intBuffer), dATA_BLOB.address(), MemoryUtil.memAddressSafe(pointerBuffer), MemoryUtil.memAddressSafe(dATA_BLOB2), l, MemoryUtil.memAddressSafe(cRYPTPROTECT_PROMPTSTRUCT), n, dATA_BLOB3.address()) != 0;
    }

    public static native int nCryptUnprotectMemory(long var0, long var2, int var4, int var5, long var6);

    public static int nCryptUnprotectMemory(long l, long l2, int n, int n2) {
        long l3 = Functions.CryptUnprotectMemory;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        return Crypt32.nCryptUnprotectMemory(l, l2, n, n2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean CryptUnprotectMemory(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPVOID") ByteBuffer byteBuffer, @NativeType(value="DWORD") int n) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return Crypt32.nCryptUnprotectMemory(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining(), n) != 0;
    }

    static /* synthetic */ SharedLibrary access$000() {
        return CRYPT32;
    }

    public static final class Functions {
        public static final long CryptProtectData = APIUtil.apiGetFunctionAddress(Crypt32.access$000(), "CryptProtectData");
        public static final long CryptProtectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.access$000(), "CryptProtectMemory");
        public static final long CryptUnprotectData = APIUtil.apiGetFunctionAddress(Crypt32.access$000(), "CryptUnprotectData");
        public static final long CryptUnprotectMemory = APIUtil.apiGetFunctionAddressOptional(Crypt32.access$000(), "CryptUnprotectMemory");

        private Functions() {
        }
    }
}

