/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.util.Set;
import java.util.function.IntFunction;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.FunctionProviderLocal;
import org.lwjgl.system.ThreadLocalUtil;

public class ALCCapabilities {
    public final long alcOpenDevice;
    public final long alcCloseDevice;
    public final long alcCreateContext;
    public final long alcMakeContextCurrent;
    public final long alcProcessContext;
    public final long alcSuspendContext;
    public final long alcDestroyContext;
    public final long alcGetCurrentContext;
    public final long alcGetContextsDevice;
    public final long alcIsExtensionPresent;
    public final long alcGetProcAddress;
    public final long alcGetEnumValue;
    public final long alcGetError;
    public final long alcGetString;
    public final long alcGetIntegerv;
    public final long alcCaptureOpenDevice;
    public final long alcCaptureCloseDevice;
    public final long alcCaptureStart;
    public final long alcCaptureStop;
    public final long alcCaptureSamples;
    public final long alcGetProcAddress2;
    public final long alcSetThreadContext;
    public final long alcGetThreadContext;
    public final long alcGetInteger64vSOFT;
    public final long alcGetStringiSOFT;
    public final long alcResetDeviceSOFT;
    public final long alcLoopbackOpenDeviceSOFT;
    public final long alcIsRenderFormatSupportedSOFT;
    public final long alcRenderSamplesSOFT;
    public final long alcDevicePauseSOFT;
    public final long alcDeviceResumeSOFT;
    public final long alcReopenDeviceSOFT;
    public final long alcEventIsSupportedSOFT;
    public final long alcEventControlSOFT;
    public final long alcEventCallbackSOFT;
    public final boolean OpenALC10;
    public final boolean OpenALC11;
    public final boolean OpenALC_SOFT_loopback_bformat;
    public final boolean ALC_ENUMERATE_ALL_EXT;
    public final boolean ALC_ENUMERATION_EXT;
    public final boolean ALC_EXT_CAPTURE;
    public final boolean ALC_EXT_debug;
    public final boolean ALC_EXT_DEDICATED;
    public final boolean ALC_EXT_DEFAULT_FILTER_ORDER;
    public final boolean ALC_EXT_direct_context;
    public final boolean ALC_EXT_disconnect;
    public final boolean ALC_EXT_EFX;
    public final boolean ALC_EXT_thread_local_context;
    public final boolean ALC_LOKI_audio_channel;
    public final boolean ALC_SOFT_device_clock;
    public final boolean ALC_SOFT_HRTF;
    public final boolean ALC_SOFT_loopback;
    public final boolean ALC_SOFT_output_limiter;
    public final boolean ALC_SOFT_output_mode;
    public final boolean ALC_SOFT_pause_device;
    public final boolean ALC_SOFT_reopen_device;
    public final boolean ALC_SOFT_system_events;
    final long device;
    final PointerBuffer addresses;

    ALCCapabilities(FunctionProviderLocal functionProviderLocal, long l, Set<String> set, IntFunction<PointerBuffer> intFunction) {
        this.device = l;
        PointerBuffer pointerBuffer = intFunction.apply(35);
        this.OpenALC10 = ALCCapabilities.check_ALC10(functionProviderLocal, l, pointerBuffer, set);
        this.OpenALC11 = ALCCapabilities.check_ALC11(functionProviderLocal, l, pointerBuffer, set);
        this.OpenALC_SOFT_loopback_bformat = set.contains("OpenALC_SOFT_loopback_bformat");
        this.ALC_ENUMERATE_ALL_EXT = set.contains("ALC_ENUMERATE_ALL_EXT");
        this.ALC_ENUMERATION_EXT = set.contains("ALC_ENUMERATION_EXT");
        this.ALC_EXT_CAPTURE = ALCCapabilities.check_EXT_CAPTURE(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_EXT_debug = set.contains("ALC_EXT_debug");
        this.ALC_EXT_DEDICATED = set.contains("ALC_EXT_DEDICATED");
        this.ALC_EXT_DEFAULT_FILTER_ORDER = set.contains("ALC_EXT_DEFAULT_FILTER_ORDER");
        this.ALC_EXT_direct_context = ALCCapabilities.check_EXT_direct_context(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_EXT_disconnect = set.contains("ALC_EXT_disconnect");
        this.ALC_EXT_EFX = set.contains("ALC_EXT_EFX");
        this.ALC_EXT_thread_local_context = ALCCapabilities.check_EXT_thread_local_context(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_LOKI_audio_channel = set.contains("ALC_LOKI_audio_channel");
        this.ALC_SOFT_device_clock = ALCCapabilities.check_SOFT_device_clock(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_SOFT_HRTF = ALCCapabilities.check_SOFT_HRTF(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_SOFT_loopback = ALCCapabilities.check_SOFT_loopback(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_SOFT_output_limiter = set.contains("ALC_SOFT_output_limiter");
        this.ALC_SOFT_output_mode = set.contains("ALC_SOFT_output_mode");
        this.ALC_SOFT_pause_device = ALCCapabilities.check_SOFT_pause_device(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_SOFT_reopen_device = ALCCapabilities.check_SOFT_reopen_device(functionProviderLocal, l, pointerBuffer, set);
        this.ALC_SOFT_system_events = ALCCapabilities.check_SOFT_system_events(functionProviderLocal, l, pointerBuffer, set);
        this.alcOpenDevice = pointerBuffer.get(0);
        this.alcCloseDevice = pointerBuffer.get(1);
        this.alcCreateContext = pointerBuffer.get(2);
        this.alcMakeContextCurrent = pointerBuffer.get(3);
        this.alcProcessContext = pointerBuffer.get(4);
        this.alcSuspendContext = pointerBuffer.get(5);
        this.alcDestroyContext = pointerBuffer.get(6);
        this.alcGetCurrentContext = pointerBuffer.get(7);
        this.alcGetContextsDevice = pointerBuffer.get(8);
        this.alcIsExtensionPresent = pointerBuffer.get(9);
        this.alcGetProcAddress = pointerBuffer.get(10);
        this.alcGetEnumValue = pointerBuffer.get(11);
        this.alcGetError = pointerBuffer.get(12);
        this.alcGetString = pointerBuffer.get(13);
        this.alcGetIntegerv = pointerBuffer.get(14);
        this.alcCaptureOpenDevice = pointerBuffer.get(15);
        this.alcCaptureCloseDevice = pointerBuffer.get(16);
        this.alcCaptureStart = pointerBuffer.get(17);
        this.alcCaptureStop = pointerBuffer.get(18);
        this.alcCaptureSamples = pointerBuffer.get(19);
        this.alcGetProcAddress2 = pointerBuffer.get(20);
        this.alcSetThreadContext = pointerBuffer.get(21);
        this.alcGetThreadContext = pointerBuffer.get(22);
        this.alcGetInteger64vSOFT = pointerBuffer.get(23);
        this.alcGetStringiSOFT = pointerBuffer.get(24);
        this.alcResetDeviceSOFT = pointerBuffer.get(25);
        this.alcLoopbackOpenDeviceSOFT = pointerBuffer.get(26);
        this.alcIsRenderFormatSupportedSOFT = pointerBuffer.get(27);
        this.alcRenderSamplesSOFT = pointerBuffer.get(28);
        this.alcDevicePauseSOFT = pointerBuffer.get(29);
        this.alcDeviceResumeSOFT = pointerBuffer.get(30);
        this.alcReopenDeviceSOFT = pointerBuffer.get(31);
        this.alcEventIsSupportedSOFT = pointerBuffer.get(32);
        this.alcEventControlSOFT = pointerBuffer.get(33);
        this.alcEventCallbackSOFT = pointerBuffer.get(34);
        this.addresses = ThreadLocalUtil.setupAddressBuffer(pointerBuffer);
    }

    public PointerBuffer getAddressBuffer() {
        return this.addresses;
    }

    private static boolean check_ALC10(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenALC10")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, "alcOpenDevice", "alcCloseDevice", "alcCreateContext", "alcMakeContextCurrent", "alcProcessContext", "alcSuspendContext", "alcDestroyContext", "alcGetCurrentContext", "alcGetContextsDevice", "alcIsExtensionPresent", "alcGetProcAddress", "alcGetEnumValue", "alcGetError", "alcGetString", "alcGetIntegerv") || Checks.reportMissing("ALC", "OpenALC10");
    }

    private static boolean check_ALC11(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("OpenALC11")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{15, 16, 17, 18, 19}, "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples") || Checks.reportMissing("ALC", "OpenALC11");
    }

    private static boolean check_EXT_CAPTURE(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_CAPTURE")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{15, 16, 17, 18, 19}, "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples") || Checks.reportMissing("ALC", "ALC_EXT_CAPTURE");
    }

    private static boolean check_EXT_direct_context(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_direct_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{20}, "alcGetProcAddress2") || Checks.reportMissing("ALC", "ALC_EXT_direct_context");
    }

    private static boolean check_EXT_thread_local_context(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_EXT_thread_local_context")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{21, 22}, "alcSetThreadContext", "alcGetThreadContext") || Checks.reportMissing("ALC", "ALC_EXT_thread_local_context");
    }

    private static boolean check_SOFT_device_clock(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_device_clock")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{23}, "alcGetInteger64vSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_device_clock");
    }

    private static boolean check_SOFT_HRTF(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_HRTF")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{24, 25}, "alcGetStringiSOFT", "alcResetDeviceSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_HRTF");
    }

    private static boolean check_SOFT_loopback(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_loopback")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{26, 27, 28}, "alcLoopbackOpenDeviceSOFT", "alcIsRenderFormatSupportedSOFT", "alcRenderSamplesSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_loopback");
    }

    private static boolean check_SOFT_pause_device(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_pause_device")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{29, 30}, "alcDevicePauseSOFT", "alcDeviceResumeSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_pause_device");
    }

    private static boolean check_SOFT_reopen_device(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_reopen_device")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{31}, "alcReopenDeviceSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_reopen_device");
    }

    private static boolean check_SOFT_system_events(FunctionProviderLocal functionProviderLocal, long l, PointerBuffer pointerBuffer, Set<String> set) {
        if (!set.contains("ALC_SOFT_system_events")) {
            return false;
        }
        return Checks.checkFunctions(functionProviderLocal, l, pointerBuffer, new int[]{32, 33, 34}, "alcEventIsSupportedSOFT", "alcEventControlSOFT", "alcEventCallbackSOFT") || Checks.reportMissing("ALC", "ALC_SOFT_system_events");
    }
}

