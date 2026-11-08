/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import org.jspecify.annotations.Nullable;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class GLFWNativeWGL {
    protected GLFWNativeWGL() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="HGLRC")
    public static long glfwGetWGLContext(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.GetWGLContext;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWNativeWGL.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l = GLFW.getLibrary().getFunctionAddress("_glfw_opengl_library");
        if (l == 0L) {
            APIUtil.apiLog("GLFW OpenGL path override not set: Could not resolve override symbol.");
            return;
        }
        long l2 = MemoryUtil.memGetAddress(l);
        if (l2 != 0L) {
            MemoryUtil.nmemFree(l2);
        }
        MemoryUtil.memPutAddress(l, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    public static final class Functions {
        public static final long GetWGLContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetWGLContext");

        private Functions() {
        }
    }
}

