/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WinBase {
    public static final int FALSE = 0;
    public static final int TRUE = 1;

    protected WinBase() {
        throw new UnsupportedOperationException();
    }

    public static native long nLocalFree(long var0, long var2);

    @NativeType(value="HLOCAL")
    public static long LocalFree(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HLOCAL") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
        }
        return WinBase.nLocalFree(MemoryUtil.memAddressSafe(intBuffer), l);
    }

    @NativeType(value="DWORD")
    public static native int GetLastError();

    public static native long nGetModuleHandle(long var0, long var2);

    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCTSTR") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkNT2Safe(byteBuffer);
        }
        return WinBase.nGetModuleHandle(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long GetModuleHandle(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCTSTR") @Nullable CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF16Safe(charSequence, true);
            long l = charSequence == null ? 0L : memoryStack.getPointerAddress();
            long l2 = WinBase.nGetModuleHandle(MemoryUtil.memAddressSafe(intBuffer), l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nGetModuleFileName(long var0, long var2, long var4, int var6);

    @NativeType(value="DWORD")
    public static int GetModuleFileName(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HMODULE") long l, @NativeType(value="LPTSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WinBase.nGetModuleFileName(MemoryUtil.memAddressSafe(intBuffer), l, MemoryUtil.memAddress(byteBuffer), byteBuffer.remaining() >> 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="DWORD")
    public static String GetModuleFileName(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HMODULE") long l, @NativeType(value="DWORD") int n) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n2 = memoryStack.getPointer();
        try {
            ByteBuffer byteBuffer = memoryStack.malloc(n << 1);
            int n3 = WinBase.nGetModuleFileName(MemoryUtil.memAddressSafe(intBuffer), l, MemoryUtil.memAddress(byteBuffer), n);
            String string = MemoryUtil.memUTF16(byteBuffer, n3);
            return string;
        }
        finally {
            memoryStack.setPointer(n2);
        }
    }

    public static native long nLoadLibrary(long var0, long var2);

    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCTSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkNT2(byteBuffer);
        }
        return WinBase.nLoadLibrary(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="HMODULE")
    public static long LoadLibrary(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCTSTR") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF16(charSequence, true);
            long l = memoryStack.getPointerAddress();
            long l2 = WinBase.nLoadLibrary(MemoryUtil.memAddressSafe(intBuffer), l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native long nGetProcAddress(long var0, long var2, long var4);

    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HMODULE") long l, @NativeType(value="LPCSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
            Checks.checkNT1(byteBuffer);
        }
        return WinBase.nGetProcAddress(MemoryUtil.memAddressSafe(intBuffer), l, MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="FARPROC")
    public static long GetProcAddress(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HMODULE") long l, @NativeType(value="LPCSTR") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            long l3 = WinBase.nGetProcAddress(MemoryUtil.memAddressSafe(intBuffer), l, l2);
            return l3;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nFreeLibrary(long var0, long var2);

    @NativeType(value="BOOL")
    public static boolean FreeLibrary(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HMODULE") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
        }
        return WinBase.nFreeLibrary(MemoryUtil.memAddressSafe(intBuffer), l) != 0;
    }

    static {
        Library.initialize();
    }
}

