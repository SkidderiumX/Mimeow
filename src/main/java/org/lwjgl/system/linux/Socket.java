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

public class Socket {
    public static final int SHUT_RD = 0;
    public static final int SHUT_WR = 1;
    public static final int SHUT_RDWR = 2;

    protected Socket() {
        throw new UnsupportedOperationException();
    }

    public static native int nsocket(long var0, int var2, int var3, int var4);

    public static int socket(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, int n2, int n3) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
        }
        return Socket.nsocket(MemoryUtil.memAddressSafe(intBuffer), n, n2, n3);
    }

    static {
        Library.initialize();
    }
}

