/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.jspecify.annotations.Nullable;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTSourceResampler {
    public static final int AL_NUM_RESAMPLERS_SOFT = 4624;
    public static final int AL_DEFAULT_RESAMPLER_SOFT = 4625;
    public static final int AL_SOURCE_RESAMPLER_SOFT = 4626;
    public static final int AL_RESAMPLER_NAME_SOFT = 4627;

    protected SOFTSourceResampler() {
        throw new UnsupportedOperationException();
    }

    public static long nalGetStringiSOFT(int n, int n2) {
        long l = AL.getICD().alGetStringiSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokeP(n, n2, l);
    }

    @NativeType(value="ALchar const *")
    public static @Nullable String alGetStringiSOFT(@NativeType(value="ALenum") int n, @NativeType(value="ALsizei") int n2) {
        long l = SOFTSourceResampler.nalGetStringiSOFT(n, n2);
        return MemoryUtil.memUTF8Safe(l);
    }

    public static long nalGetStringiDirectSOFT(long l, int n, int n2) {
        long l2 = AL.getICD().alGetStringiDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        return JNI.invokePP(l, n, n2, l2);
    }

    @NativeType(value="ALchar const *")
    public static @Nullable String alGetStringiDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALsizei") int n2) {
        long l2 = SOFTSourceResampler.nalGetStringiDirectSOFT(l, n, n2);
        return MemoryUtil.memUTF8Safe(l2);
    }
}

