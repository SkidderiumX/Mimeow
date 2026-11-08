/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGL {
    public static final int WGL_FONT_LINES = 0;
    public static final int WGL_FONT_POLYGONS = 1;
    public static final int WGL_SWAP_MAIN_PLANE = 1;
    public static final int WGL_SWAP_OVERLAY1 = 2;
    public static final int WGL_SWAP_OVERLAY2 = 4;
    public static final int WGL_SWAP_OVERLAY3 = 8;
    public static final int WGL_SWAP_OVERLAY4 = 16;
    public static final int WGL_SWAP_OVERLAY5 = 32;
    public static final int WGL_SWAP_OVERLAY6 = 64;
    public static final int WGL_SWAP_OVERLAY7 = 128;
    public static final int WGL_SWAP_OVERLAY8 = 256;
    public static final int WGL_SWAP_OVERLAY9 = 512;
    public static final int WGL_SWAP_OVERLAY10 = 1024;
    public static final int WGL_SWAP_OVERLAY11 = 2048;
    public static final int WGL_SWAP_OVERLAY12 = 4096;
    public static final int WGL_SWAP_OVERLAY13 = 8192;
    public static final int WGL_SWAP_OVERLAY14 = 16384;
    public static final int WGL_SWAP_OVERLAY15 = 32768;
    public static final int WGL_SWAP_UNDERLAY1 = 65536;
    public static final int WGL_SWAP_UNDERLAY2 = 131072;
    public static final int WGL_SWAP_UNDERLAY3 = 262144;
    public static final int WGL_SWAP_UNDERLAY4 = 524288;
    public static final int WGL_SWAP_UNDERLAY5 = 0x100000;
    public static final int WGL_SWAP_UNDERLAY6 = 0x200000;
    public static final int WGL_SWAP_UNDERLAY7 = 0x400000;
    public static final int WGL_SWAP_UNDERLAY8 = 0x800000;
    public static final int WGL_SWAP_UNDERLAY9 = 0x1000000;
    public static final int WGL_SWAP_UNDERLAY10 = 0x2000000;
    public static final int WGL_SWAP_UNDERLAY11 = 0x4000000;
    public static final int WGL_SWAP_UNDERLAY12 = 0x8000000;
    public static final int WGL_SWAP_UNDERLAY13 = 0x10000000;
    public static final int WGL_SWAP_UNDERLAY14 = 0x20000000;
    public static final int WGL_SWAP_UNDERLAY15 = 0x40000000;

    protected WGL() {
        throw new UnsupportedOperationException();
    }

    public static native long nwglCreateContext(long var0, long var2, long var4);

    public static long nwglCreateContext(long l, long l2) {
        long l3 = Functions.CreateContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return WGL.nwglCreateContext(l, l2, l3);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateContext(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HDC") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglCreateContext(MemoryUtil.memAddressSafe(intBuffer), l);
    }

    public static native long nwglCreateLayerContext(long var0, long var2, int var4, long var5);

    public static long nwglCreateLayerContext(long l, long l2, int n) {
        long l3 = Functions.CreateLayerContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return WGL.nwglCreateLayerContext(l, l2, n, l3);
    }

    @NativeType(value="HGLRC")
    public static long wglCreateLayerContext(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HDC") long l, int n) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglCreateLayerContext(MemoryUtil.memAddressSafe(intBuffer), l, n);
    }

    public static native int nwglCopyContext(long var0, long var2, long var4, int var6, long var7);

    public static int nwglCopyContext(long l, long l2, long l3, int n) {
        long l4 = Functions.CopyContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return WGL.nwglCopyContext(l, l2, l3, n, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglCopyContext(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HGLRC") long l, @NativeType(value="HGLRC") long l2, @NativeType(value="UINT") int n) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglCopyContext(MemoryUtil.memAddressSafe(intBuffer), l, l2, n) != 0;
    }

    public static native int nwglDeleteContext(long var0, long var2, long var4);

    public static int nwglDeleteContext(long l, long l2) {
        long l3 = Functions.DeleteContext;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return WGL.nwglDeleteContext(l, l2, l3);
    }

    @NativeType(value="BOOL")
    public static boolean wglDeleteContext(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HGLRC") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglDeleteContext(MemoryUtil.memAddressSafe(intBuffer), l) != 0;
    }

    public static native long nwglGetCurrentContext(long var0, long var2);

    public static long nwglGetCurrentContext(long l) {
        long l2 = Functions.GetCurrentContext;
        return WGL.nwglGetCurrentContext(l, l2);
    }

    @NativeType(value="HGLRC")
    public static long wglGetCurrentContext(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglGetCurrentContext(MemoryUtil.memAddressSafe(intBuffer));
    }

    @NativeType(value="HDC")
    public static long wglGetCurrentDC() {
        long l = Functions.GetCurrentDC;
        return JNI.callP(l);
    }

    public static native long nwglGetProcAddress(long var0, long var2, long var4);

    public static long nwglGetProcAddress(long l, long l2) {
        long l3 = Functions.GetProcAddress;
        return WGL.nwglGetProcAddress(l, l2, l3);
    }

    @NativeType(value="PROC")
    public static long wglGetProcAddress(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCSTR") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkNT1(byteBuffer);
        }
        return WGL.nwglGetProcAddress(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="PROC")
    public static long wglGetProcAddress(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="LPCSTR") CharSequence charSequence) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            long l2 = WGL.nwglGetProcAddress(MemoryUtil.memAddressSafe(intBuffer), l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nwglMakeCurrent(long var0, long var2, long var4, long var6);

    public static int nwglMakeCurrent(long l, long l2, long l3) {
        long l4 = Functions.MakeCurrent;
        return WGL.nwglMakeCurrent(l, l2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglMakeCurrent(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HDC") long l, @NativeType(value="HGLRC") long l2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglMakeCurrent(MemoryUtil.memAddressSafe(intBuffer), l, l2) != 0;
    }

    public static native int nwglShareLists(long var0, long var2, long var4, long var6);

    public static int nwglShareLists(long l, long l2, long l3) {
        long l4 = Functions.ShareLists;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l3);
        }
        return WGL.nwglShareLists(l, l2, l3, l4);
    }

    @NativeType(value="BOOL")
    public static boolean wglShareLists(@NativeType(value="DWORD *") @Nullable IntBuffer intBuffer, @NativeType(value="HGLRC") long l, @NativeType(value="HGLRC") long l2) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return WGL.nwglShareLists(MemoryUtil.memAddressSafe(intBuffer), l, l2) != 0;
    }

    static {
        GL.initialize();
    }

    public static final class Functions {
        public static final long CreateContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateContext");
        public static final long CreateLayerContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCreateLayerContext");
        public static final long CopyContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglCopyContext");
        public static final long DeleteContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglDeleteContext");
        public static final long GetCurrentContext = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentContext");
        public static final long GetCurrentDC = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetCurrentDC");
        public static final long GetProcAddress = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglGetProcAddress");
        public static final long MakeCurrent = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglMakeCurrent");
        public static final long ShareLists = APIUtil.apiGetFunctionAddress(GL.getFunctionProvider(), "wglShareLists");

        private Functions() {
        }
    }
}

