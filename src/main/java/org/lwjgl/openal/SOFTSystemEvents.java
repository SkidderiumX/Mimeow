/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.SOFTSystemEventProcI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTSystemEvents {
    public static final int ALC_EVENT_TYPE_DEFAULT_DEVICE_CHANGED_SOFT = 6614;
    public static final int ALC_EVENT_TYPE_DEVICE_ADDED_SOFT = 6615;
    public static final int ALC_EVENT_TYPE_DEVICE_REMOVED_SOFT = 6616;
    public static final int ALC_PLAYBACK_DEVICE_SOFT = 6612;
    public static final int ALC_CAPTURE_DEVICE_SOFT = 6613;
    public static final int ALC_EVENT_SUPPORTED_SOFT = 6617;
    public static final int ALC_EVENT_NOT_SUPPORTED_SOFT = 6618;

    protected SOFTSystemEvents() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="ALCenum")
    public static int alcEventIsSupportedSOFT(@NativeType(value="ALCenum") int n, @NativeType(value="ALCenum") int n2) {
        long l = ALC.getICD().alcEventIsSupportedSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokeI(n, n2, l);
    }

    public static boolean nalcEventControlSOFT(int n, long l, boolean bl) {
        long l2 = ALC.getICD().alcEventControlSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.invokePZ(n, l, bl, l2);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcEventControlSOFT(@NativeType(value="ALCenum const *") @Nullable IntBuffer intBuffer, @NativeType(value="ALCboolean") boolean bl) {
        return SOFTSystemEvents.nalcEventControlSOFT(Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), bl);
    }

    public static void nalcEventCallbackSOFT(long l, long l2) {
        long l3 = ALC.getICD().alcEventCallbackSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePPV(l, l2, l3);
    }

    @NativeType(value="ALCvoid")
    public static void alcEventCallbackSOFT(@NativeType(value="ALCEVENTPROCTYPESOFT") @Nullable SOFTSystemEventProcI sOFTSystemEventProcI, @NativeType(value="ALCvoid *") long l) {
        SOFTSystemEvents.nalcEventCallbackSOFT(MemoryUtil.memAddressSafe(sOFTSystemEventProcI), l);
    }

    @NativeType(value="ALCboolean")
    public static boolean alcEventControlSOFT(@NativeType(value="ALCenum const *") int @Nullable [] nArray, @NativeType(value="ALCboolean") boolean bl) {
        long l = ALC.getICD().alcEventControlSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokePZ(Checks.lengthSafe(nArray), nArray, bl, l);
    }
}

