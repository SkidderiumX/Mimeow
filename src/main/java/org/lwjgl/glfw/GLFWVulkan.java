/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.glfw;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProvider;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Platform;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.SharedLibrary;
import org.lwjgl.vulkan.VK;
import org.lwjgl.vulkan.VkAllocationCallbacks;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;

public class GLFWVulkan {
    protected GLFWVulkan() {
        throw new UnsupportedOperationException();
    }

    public static void glfwInitVulkanLoader(@NativeType(value="PFN_vkGetInstanceProcAddr") long l) {
        long l2 = Functions.InitVulkanLoader;
        JNI.invokePV(l, l2);
    }

    @NativeType(value="int")
    public static boolean glfwVulkanSupported() {
        long l = Functions.VulkanSupported;
        return JNI.invokeI(l) != 0;
    }

    public static long nglfwGetRequiredInstanceExtensions(long l) {
        long l2 = Functions.GetRequiredInstanceExtensions;
        return JNI.invokePP(l, l2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="char const **")
    public static @Nullable PointerBuffer glfwGetRequiredInstanceExtensions() {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        IntBuffer intBuffer = memoryStack.callocInt(1);
        try {
            long l = GLFWVulkan.nglfwGetRequiredInstanceExtensions(MemoryUtil.memAddress(intBuffer));
            PointerBuffer pointerBuffer = MemoryUtil.memPointerBufferSafe(l, intBuffer.get(0));
            return pointerBuffer;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static long nglfwGetInstanceProcAddress(long l, long l2) {
        long l3 = Functions.GetInstanceProcAddress;
        return JNI.invokePPP(l, l2, l3);
    }

    @NativeType(value="GLFWvkproc")
    public static long glfwGetInstanceProcAddress(@NativeType(value="VkInstance") @Nullable VkInstance vkInstance, @NativeType(value="char const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GLFWVulkan.nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)vkInstance), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="GLFWvkproc")
    public static long glfwGetInstanceProcAddress(@NativeType(value="VkInstance") @Nullable VkInstance vkInstance, @NativeType(value="char const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            long l2 = GLFWVulkan.nglfwGetInstanceProcAddress(MemoryUtil.memAddressSafe((Pointer)vkInstance), l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    @NativeType(value="int")
    public static boolean glfwGetPhysicalDevicePresentationSupport(VkInstance vkInstance, VkPhysicalDevice vkPhysicalDevice, @NativeType(value="uint32_t") int n) {
        long l = Functions.GetPhysicalDevicePresentationSupport;
        return JNI.invokePPI(vkInstance.address(), vkPhysicalDevice.address(), n, l) != 0;
    }

    public static int nglfwCreateWindowSurface(long l, long l2, long l3, long l4) {
        long l5 = Functions.CreateWindowSurface;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePPPPI(l, l2, l3, l4, l5);
    }

    @NativeType(value="VkResult")
    public static int glfwCreateWindowSurface(VkInstance vkInstance, @NativeType(value="GLFWwindow *") long l, @NativeType(value="VkAllocationCallbacks const *") @Nullable VkAllocationCallbacks vkAllocationCallbacks, @NativeType(value="VkSurfaceKHR *") LongBuffer longBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)longBuffer, 1);
        }
        return GLFWVulkan.nglfwCreateWindowSurface(vkInstance.address(), l, MemoryUtil.memAddressSafe((Pointer)vkAllocationCallbacks), MemoryUtil.memAddress(longBuffer));
    }

    @NativeType(value="VkResult")
    public static int glfwCreateWindowSurface(VkInstance vkInstance, @NativeType(value="GLFWwindow *") long l, @NativeType(value="VkAllocationCallbacks const *") @Nullable VkAllocationCallbacks vkAllocationCallbacks, @NativeType(value="VkSurfaceKHR *") long[] lArray) {
        long l2 = Functions.CreateWindowSurface;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(lArray, 1);
        }
        return JNI.invokePPPPI(vkInstance.address(), l, MemoryUtil.memAddressSafe((Pointer)vkAllocationCallbacks), lArray, l2);
    }

    public static void setPath(FunctionProvider functionProvider) {
        if (!(functionProvider instanceof SharedLibrary)) {
            APIUtil.apiLog("GLFW Vulkan path override not set: function provider is not a shared library.");
            return;
        }
        String string = ((SharedLibrary)functionProvider).getPath();
        if (string == null) {
            APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve the shared library path.");
            return;
        }
        GLFWVulkan.setPath(string);
    }

    public static void setPath(@Nullable String string) {
        long l = GLFW.getLibrary().getFunctionAddress("_glfw_vulkan_library");
        if (l == 0L) {
            APIUtil.apiLog("GLFW Vulkan path override not set: Could not resolve override symbol.");
            return;
        }
        long l2 = MemoryUtil.memGetAddress(l);
        if (l2 != 0L) {
            MemoryUtil.nmemFree(l2);
        }
        MemoryUtil.memPutAddress(l, string == null ? 0L : MemoryUtil.memAddress(MemoryUtil.memUTF8(string)));
    }

    static {
        if (Platform.get() == Platform.MACOSX) {
            GLFWVulkan.setPath(VK.getFunctionProvider());
        }
    }

    public static final class Functions {
        public static final long InitVulkanLoader = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwInitVulkanLoader");
        public static final long VulkanSupported = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwVulkanSupported");
        public static final long GetRequiredInstanceExtensions = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetRequiredInstanceExtensions");
        public static final long GetInstanceProcAddress = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetInstanceProcAddress");
        public static final long GetPhysicalDevicePresentationSupport = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwGetPhysicalDevicePresentationSupport");
        public static final long CreateWindowSurface = APIUtil.apiGetFunctionAddress(GLFW.getLibrary(), "glfwCreateWindowSurface");

        private Functions() {
        }
    }
}

