/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import java.nio.ByteBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.system.MemoryUtil;

public class SharedLibraryUtil {
    private static native int getLibraryPath(long var0, long var2, int var4);

    public static @Nullable String getLibraryPath(long l) {
        int n = 256;
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(n);
        try {
            while (true) {
                int n2;
                if ((n2 = SharedLibraryUtil.getLibraryPath(l, MemoryUtil.memAddress(byteBuffer), n)) == 0) {
                    String string = null;
                    return string;
                }
                if (n2 < n) {
                    String string = MemoryUtil.memUTF8(byteBuffer, n2 - 1);
                    return string;
                }
                n = n * 3 / 2;
                byteBuffer = MemoryUtil.memRealloc(byteBuffer, n);
            }
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
        }
    }
}

