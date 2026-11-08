/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.nanovg;

import org.jspecify.annotations.Nullable;
import org.lwjgl.nanovg.NVGLUFramebufferBGFX;
import org.lwjgl.nanovg.NanoVG;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.SharedLibrary;

public class NanoVGBGFX {
    public static final int NVG_IMAGE_NODELETE = 65536;

    protected NanoVGBGFX() {
        throw new UnsupportedOperationException();
    }

    public static long nnvgCreate(int n, short s, long l) {
        long l2 = Functions.Create;
        return JNI.invokeCPP(n, s, l, l2);
    }

    @NativeType(value="NVGcontext *")
    public static long nvgCreate(@NativeType(value="int32_t") boolean bl, @NativeType(value="bgfx_view_id_t") int n, @NativeType(value="bgfx_allocator_interface_t *") long l) {
        return NanoVGBGFX.nnvgCreate(bl ? 1 : 0, (short)n, l);
    }

    public static void nvgDelete(@NativeType(value="NVGcontext *") long l) {
        long l2 = Functions.Delete;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static void nnvgSetViewId(long l, short s) {
        long l2 = Functions.SetViewId;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePCV(l, s, l2);
    }

    public static void nvgSetViewId(@NativeType(value="NVGcontext *") long l, @NativeType(value="bgfx_view_id_t") int n) {
        NanoVGBGFX.nnvgSetViewId(l, (short)n);
    }

    @NativeType(value="uint16_t")
    public static short nvgGetViewId(@NativeType(value="NVGcontext *") long l) {
        long l2 = Functions.GetViewId;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePC(l, l2);
    }

    public static long nnvgluCreateFramebuffer(long l, int n, int n2, int n3) {
        long l2 = Functions.luCreateFramebuffer;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePP(l, n, n2, n3, l2);
    }

    @NativeType(value="NVGLUframebuffer *")
    public static @Nullable NVGLUFramebufferBGFX nvgluCreateFramebuffer(@NativeType(value="NVGcontext *") long l, @NativeType(value="int32_t") int n, @NativeType(value="int32_t") int n2, @NativeType(value="int32_t") int n3) {
        long l2 = NanoVGBGFX.nnvgluCreateFramebuffer(l, n, n2, n3);
        return NVGLUFramebufferBGFX.createSafe(l2);
    }

    public static void nnvgluBindFramebuffer(long l) {
        long l2 = Functions.luBindFramebuffer;
        JNI.invokePV(l, l2);
    }

    public static void nvgluBindFramebuffer(@NativeType(value="NVGLUframebuffer *") @Nullable NVGLUFramebufferBGFX nVGLUFramebufferBGFX) {
        NanoVGBGFX.nnvgluBindFramebuffer(MemoryUtil.memAddressSafe(nVGLUFramebufferBGFX));
    }

    public static void nnvgluDeleteFramebuffer(long l) {
        long l2 = Functions.luDeleteFramebuffer;
        JNI.invokePV(l, l2);
    }

    public static void nvgluDeleteFramebuffer(@NativeType(value="NVGLUframebuffer *") NVGLUFramebufferBGFX nVGLUFramebufferBGFX) {
        NanoVGBGFX.nnvgluDeleteFramebuffer(nVGLUFramebufferBGFX.address());
    }

    public static void nnvgluSetViewFramebuffer(short s, long l) {
        long l2 = Functions.luSetViewFramebuffer;
        JNI.invokeCPV(s, l, l2);
    }

    public static void nvgluSetViewFramebuffer(@NativeType(value="bgfx_view_id_t") int n, @NativeType(value="NVGLUframebuffer *") NVGLUFramebufferBGFX nVGLUFramebufferBGFX) {
        NanoVGBGFX.nnvgluSetViewFramebuffer((short)n, nVGLUFramebufferBGFX.address());
    }

    public static void nvgCreateBgfxTexture(@NativeType(value="NVGcontext *") long l, @NativeType(value="bgfx_texture_handle_t") short s, int n, int n2, int n3) {
        long l2 = Functions.CreateBgfxTexture;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePCV(l, s, n, n2, n3, l2);
    }

    private static void org_lwjgl_nanovg_setup(@NativeType(value="void *") long l, @NativeType(value="void *") long l2, @NativeType(value="void *") long l3, @NativeType(value="void *") long l4, @NativeType(value="void *") long l5) {
        long l6 = Functions.org_lwjgl_nanovg_setup;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(l2);
            Checks.check(l3);
            Checks.check(l4);
            Checks.check(l5);
        }
        JNI.invokePPPPPV(l, l2, l3, l4, l5, l6);
    }

    static {
        MemoryUtil.MemoryAllocator memoryAllocator = MemoryUtil.getAllocator(Configuration.DEBUG_MEMORY_ALLOCATOR_INTERNAL.get(true));
        NanoVGBGFX.org_lwjgl_nanovg_setup(memoryAllocator.getRealloc(), memoryAllocator.getFree(), NanoVG.nvgCreateInternal, NanoVG.nvgInternalParams, NanoVG.nvgDeleteInternal);
    }

    private static class BGFX {
        private static final SharedLibrary library;

        private BGFX() {
        }

        static SharedLibrary getLibrary() {
            return library;
        }

        static {
            try {
                library = (SharedLibrary)Class.forName("org.lwjgl.bgfx.BGFX").getMethod("getLibrary", new Class[0]).invoke(null, new Object[0]);
            }
            catch (Exception exception) {
                throw new RuntimeException(exception);
            }
        }
    }

    public static final class Functions {
        public static final long Create = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgCreate");
        public static final long Delete = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgDelete");
        public static final long SetViewId = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgSetViewId");
        public static final long GetViewId = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgGetViewId");
        public static final long luCreateFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluCreateFramebuffer");
        public static final long luBindFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluBindFramebuffer");
        public static final long luDeleteFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluDeleteFramebuffer");
        public static final long luSetViewFramebuffer = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgluSetViewFramebuffer");
        public static final long CreateBgfxTexture = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "nvgCreateBgfxTexture");
        public static final long org_lwjgl_nanovg_setup = APIUtil.apiGetFunctionAddress(BGFX.getLibrary(), "org_lwjgl_nanovg_setup");

        private Functions() {
        }
    }
}

