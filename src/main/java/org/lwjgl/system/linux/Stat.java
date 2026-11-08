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
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class Stat {
    protected Stat() {
        throw new UnsupportedOperationException();
    }

    public static native int nstat(long var0, long var2, long var4);

    public static int stat(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="char const *") ByteBuffer byteBuffer, @NativeType(value="struct stat *") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkNT1(byteBuffer);
            Checks.check(l);
        }
        return Stat.nstat(MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddress(byteBuffer), l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int stat(@NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="char const *") CharSequence charSequence, @NativeType(value="struct stat *") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
        }
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nUTF8(charSequence, true);
            long l2 = memoryStack.getPointerAddress();
            int n2 = Stat.nstat(MemoryUtil.memAddressSafe(intBuffer), l2, l);
            return n2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native int nfstat(long var0, int var2, long var3);

    public static int fstat(@NativeType(value="int *") @Nullable IntBuffer intBuffer, int n, @NativeType(value="struct stat *") long l) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.check(l);
        }
        return Stat.nfstat(MemoryUtil.memAddressSafe(intBuffer), n, l);
    }

    static {
        Library.initialize();
    }
}

