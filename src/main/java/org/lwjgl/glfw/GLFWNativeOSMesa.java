/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class GLFWNativeOSMesa {
    protected GLFWNativeOSMesa() {
        throw new UnsupportedOperationException();
    }

    public static int nglfwGetOSMesaColorBuffer(long l, long l2, long l3, long l4, long l5) {
        long l6 = Functions.GetOSMesaColorBuffer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPPPPI(l, l2, l3, l4, l5, l6);
    }

    @NativeType(value="int")
    public static boolean glfwGetOSMesaColorBuffer(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3, @NativeType(value="void **") @Nullable PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return GLFWNativeOSMesa.nglfwGetOSMesaColorBuffer(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(pointerBuffer)) != 0;
    }

    public static int nglfwGetOSMesaDepthBuffer(long l, long l2, long l3, long l4, long l5) {
        long l6 = Functions.GetOSMesaDepthBuffer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePPPPPI(l, l2, l3, l4, l5, l6);
    }

    public static int glfwGetOSMesaDepthBuffer(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") @Nullable IntBuffer intBuffer, @NativeType(value="int *") @Nullable IntBuffer intBuffer2, @NativeType(value="int *") @Nullable IntBuffer intBuffer3, @NativeType(value="void **") @Nullable PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer, 1);
            Checks.checkSafe((Buffer)intBuffer2, 1);
            Checks.checkSafe((Buffer)intBuffer3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return GLFWNativeOSMesa.nglfwGetOSMesaDepthBuffer(l, MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(pointerBuffer));
    }

    @NativeType(value="OSMesaContext")
    public static long glfwGetOSMesaContext(@NativeType(value="GLFWwindow *") long l) {
        long l2 = Functions.GetOSMesaContext;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwGetOSMesaColorBuffer(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3, @NativeType(value="void **") @Nullable PointerBuffer pointerBuffer) {
        long l2 = Functions.GetOSMesaColorBuffer;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return JNI.invokePPPPPI(l, nArray, nArray2, nArray3, MemoryUtil.memAddressSafe(pointerBuffer), l2) != 0;
    }

    public static int glfwGetOSMesaDepthBuffer(@NativeType(value="GLFWwindow *") long l, @NativeType(value="int *") int @Nullable [] nArray, @NativeType(value="int *") int @Nullable [] nArray2, @NativeType(value="int *") int @Nullable [] nArray3, @NativeType(value="void **") @Nullable PointerBuffer pointerBuffer) {
        long l2 = Functions.GetOSMesaDepthBuffer;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray, 1);
            Checks.checkSafe(nArray2, 1);
            Checks.checkSafe(nArray3, 1);
            Checks.checkSafe(pointerBuffer, 1);
        }
        return JNI.invokePPPPPI(l, nArray, nArray2, nArray3, MemoryUtil.memAddressSafe(pointerBuffer), l2);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve the OSMesa shared library path.");
            return;
        }
        GLFWNativeOSMesa.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l = GLFW.getLibrary().getFunctionAddress("_glfw_mesa_library");
        if (l == 0L) {
            APIUtil.apiLog("GLFW OSMesa path override not set: Could not resolve override symbol.");
            return;
        }
        long l2 = MemoryUtil.memGetAddress(l);
        if (l2 != 0L) {
            MemoryUtil.nmemFree(l2);
        }
        MemoryUtil.memPutAddress(l, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    public static final class Functions {
        public static final long GetOSMesaColorBuffer = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaColorBuffer");
        public static final long GetOSMesaDepthBuffer = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaDepthBuffer");
        public static final long GetOSMesaContext = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetOSMesaContext");

        private Functions() {
        }
    }
}

