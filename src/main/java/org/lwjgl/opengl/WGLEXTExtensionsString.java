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

public class WGLEXTExtensionsString {
    protected WGLEXTExtensionsString() {
        throw new UnsupportedOperationException();
    }

    public static long nwglGetExtensionsStringEXT() {
        long l = GL.getCapabilitiesWGL().wglGetExtensionsStringEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.callP(l);
    }

    @NativeType(value="char const *")
    public static @Nullable String wglGetExtensionsStringEXT() {
        long l = WGLEXTExtensionsString.nwglGetExtensionsStringEXT();
        return MemoryUtil.memASCIISafe(l);
    }
}

