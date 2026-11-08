/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.system.windows.WinBase;
import org.lwjgl.system.windows.WindowsUtil;

public class WindowsLibrary
extends SharedLibrary.Default {
    public static final long HINSTANCE;

    public WindowsLibrary(String string) {
        this(string, WindowsLibrary.loadLibrary(string));
    }

    public WindowsLibrary(String string, long l) {
        super(string, l);
    }

    private static long loadLibrary(String string) {
        long l;
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            l = WinBase.LoadLibrary(intBuffer, memoryStack.UTF16(string));
            if (l == 0L) {
                throw new UnsatisfiedLinkError("Failed to load library: " + string + " (error code = " + intBuffer.get(0) + ")");
            }
        }
        return l;
    }

    @Override
    public @Nullable String getPath() {
        int n = 256;
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n);
        try {
            while (true) {
                int n2;
                int n3;
                try (MemoryStack memoryStack = MemoryStack.stackPush();){
                    IntBuffer intBuffer = memoryStack.mallocInt(1);
                    n3 = WinBase.GetModuleFileName(intBuffer, this.address(), byteBuffer);
                    n2 = intBuffer.get(0);
                }
                if (n2 == 0) {
                    memoryStack = n3 == 0 ? null : MemoryUtil.memUTF16(byteBuffer, n3);
                    return memoryStack;
                }
                if (n2 != 122) {
                    memoryStack = null;
                    return memoryStack;
                }
                n = n * 3 / 2;
                byteBuffer = MemoryUtil.memRealloc(byteBuffer, n);
            }
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
        }
    }

    @Override
    public long getFunctionAddress(ByteBuffer byteBuffer) {
        return WinBase.GetProcAddress(null, this.address(), byteBuffer);
    }

    @Override
    public void free() {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            if (!WinBase.FreeLibrary(intBuffer, this.address())) {
                WindowsUtil.windowsThrowException("Failed to unload library: " + this.getName(), intBuffer);
            }
        }
    }

    static {
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            HINSTANCE = WinBase.GetModuleHandle(intBuffer, memoryStack.UTF16(Library.JNI_LIBRARY_NAME));
            if (HINSTANCE == 0L) {
                WindowsUtil.windowsThrowException("Failed to retrieve LWJGL module handle.", intBuffer);
            }
        }
    }
}

