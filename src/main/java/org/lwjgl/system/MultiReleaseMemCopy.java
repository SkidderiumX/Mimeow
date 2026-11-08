/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.libc.LibCString;

public class MultiReleaseMemCopy {
    private MultiReleaseMemCopy() {
    }

    static void copy(long l, long l2, long l3) {
        if (l3 <= 160L) {
            if (Pointer.BITS64 && ((l | l2) & 7L) == 0L) {
                MemoryUtil.memCopyAligned64(l, l2, (int)l3 & 0xFF);
            } else {
                MemoryUtil.UNSAFE.copyMemory(null, l, null, l2, l3);
            }
            return;
        }
        LibCString.nmemcpy(l2, l, l3);
    }
}

