/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.windows;

import java.nio.IntBuffer;

public class WindowsUtil {
    private WindowsUtil() {
    }

    public static void windowsThrowException(String string, IntBuffer intBuffer) {
        throw new RuntimeException(string + " (error code = " + intBuffer.get(intBuffer.position()) + ")");
    }
}

