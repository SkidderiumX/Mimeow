/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import org.jspecify.annotations.Nullable;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class WGLARBExtensionsString {
    protected WGLARBExtensionsString() {
        throw new UnsupportedOperationException();
    }

    public static long nwglGetExtensionsStringARB(long l) {
        long l2 = GL.getCapabilitiesWGL().wglGetExtensionsStringARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        return JNI.callPP(l, l2);
    }

    @NativeType(value="char const *")
    public static @Nullable String wglGetExtensionsStringARB(@NativeType(value="HDC") long l) {
        long l2 = WGLARBExtensionsString.nwglGetExtensionsStringARB(l);
        return MemoryUtil.memASCIISafe(l2);
    }
}

