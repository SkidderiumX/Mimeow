/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.SOFTEventProcI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTEvents {
    public static final int AL_EVENT_CALLBACK_FUNCTION_SOFT = 6562;
    public static final int AL_EVENT_CALLBACK_USER_PARAM_SOFT = 6563;
    public static final int AL_EVENT_TYPE_BUFFER_COMPLETED_SOFT = 6564;
    public static final int AL_EVENT_TYPE_SOURCE_STATE_CHANGED_SOFT = 6565;
    public static final int AL_EVENT_TYPE_DISCONNECTED_SOFT = 6566;

    protected SOFTEvents() {
        throw new UnsupportedOperationException();
    }

    public static void nalEventControlSOFT(int n, long l, boolean bl) {
        long l2 = AL.getICD().alEventControlSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, l, bl, l2);
    }

    public static void alEventControlSOFT(@NativeType(value="ALenum const *") IntBuffer intBuffer, @NativeType(value="ALboolean") boolean bl) {
        SOFTEvents.nalEventControlSOFT(intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), bl);
    }

    public static void nalEventControlDirectSOFT(long l, int n, long l2, boolean bl) {
        long l3 = AL.getICD().alEventControlDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, l2, bl, l3);
    }

    public static void alEventControlDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum const *") IntBuffer intBuffer, @NativeType(value="ALboolean") boolean bl) {
        SOFTEvents.nalEventControlDirectSOFT(l, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer), bl);
    }

    public static void nalEventCallbackSOFT(long l, long l2) {
        long l3 = AL.getICD().alEventCallbackSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePPV(l, l2, l3);
    }

    public static void alEventCallbackSOFT(@NativeType(value="ALEVENTPROCSOFT") @Nullable SOFTEventProcI sOFTEventProcI, @NativeType(value="ALvoid *") long l) {
        SOFTEvents.nalEventCallbackSOFT(MemoryUtil.memAddressSafe(sOFTEventProcI), l);
    }

    public static void nalEventCallbackDirectSOFT(long l, long l2, long l3) {
        long l4 = AL.getICD().alEventCallbackDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    public static void alEventCallbackDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALEVENTPROCSOFT") @Nullable SOFTEventProcI sOFTEventProcI, @NativeType(value="ALvoid *") long l2) {
        SOFTEvents.nalEventCallbackDirectSOFT(l, MemoryUtil.memAddressSafe(sOFTEventProcI), l2);
    }

    @NativeType(value="ALvoid *")
    public static long alGetPointerSOFT(@NativeType(value="ALenum") int n) {
        long l = AL.getICD().alGetPointerSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokeP(n, l);
    }

    @NativeType(value="ALvoid *")
    public static long alGetPointerDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n) {
        long l2 = AL.getICD().alGetPointerDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        return JNI.invokePP(l, n, l2);
    }

    public static void nalGetPointervSOFT(int n, long l) {
        long l2 = AL.getICD().alGetPointervSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, l, l2);
    }

    public static void alGetPointervSOFT(@NativeType(value="ALenum") int n, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTEvents.nalGetPointervSOFT(n, MemoryUtil.memAddress(pointerBuffer));
    }

    public static void nalGetPointervDirectSOFT(long l, int n, long l2) {
        long l3 = AL.getICD().alGetPointervDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, l2, l3);
    }

    public static void alGetPointervDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTEvents.nalGetPointervDirectSOFT(l, n, MemoryUtil.memAddress(pointerBuffer));
    }

    public static void alEventControlSOFT(@NativeType(value="ALenum const *") int[] nArray, @NativeType(value="ALboolean") boolean bl) {
        long l = AL.getICD().alEventControlSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(nArray.length, nArray, bl, l);
    }

    public static void alEventControlDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum const *") int[] nArray, @NativeType(value="ALboolean") boolean bl) {
        long l2 = AL.getICD().alEventControlDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePPV(l, nArray.length, nArray, bl, l2);
    }
}

