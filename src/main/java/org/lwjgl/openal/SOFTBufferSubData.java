/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTBufferSubData {
    public static final int AL_BYTE_RW_OFFSETS_SOFT = 4145;
    public static final int AL_SAMPLE_RW_OFFSETS_SOFT = 4146;

    protected SOFTBufferSubData() {
        throw new UnsupportedOperationException();
    }

    public static void nalBufferSubDataSOFT(int n, int n2, long l, int n3, int n4) {
        long l2 = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, l, n3, n4, l2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") ByteBuffer byteBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n, n2, MemoryUtil.memAddress(byteBuffer), n3, byteBuffer.remaining());
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") ShortBuffer shortBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n, n2, MemoryUtil.memAddress(shortBuffer), n3, shortBuffer.remaining() << 1);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") IntBuffer intBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n, n2, MemoryUtil.memAddress(intBuffer), n3, intBuffer.remaining() << 2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") FloatBuffer floatBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataSOFT(n, n2, MemoryUtil.memAddress(floatBuffer), n3, floatBuffer.remaining() << 2);
    }

    public static void nalBufferSubDataDirectSOFT(long l, int n, int n2, long l2, int n3, int n4) {
        long l3 = AL.getICD().alBufferSubDataDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, l2, n3, n4, l3);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") ByteBuffer byteBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataDirectSOFT(l, n, n2, MemoryUtil.memAddress(byteBuffer), n3, byteBuffer.remaining());
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") ShortBuffer shortBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataDirectSOFT(l, n, n2, MemoryUtil.memAddress(shortBuffer), n3, shortBuffer.remaining() << 1);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") IntBuffer intBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataDirectSOFT(l, n, n2, MemoryUtil.memAddress(intBuffer), n3, intBuffer.remaining() << 2);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") FloatBuffer floatBuffer, @NativeType(value="ALsizei") int n3) {
        SOFTBufferSubData.nalBufferSubDataDirectSOFT(l, n, n2, MemoryUtil.memAddress(floatBuffer), n3, floatBuffer.remaining() << 2);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") short[] sArray, @NativeType(value="ALsizei") int n3) {
        long l = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, n2, sArray, n3, sArray.length << 1, l);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") int[] nArray, @NativeType(value="ALsizei") int n3) {
        long l = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, n2, nArray, n3, nArray.length << 2, l);
    }

    public static void alBufferSubDataSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") float[] fArray, @NativeType(value="ALsizei") int n3) {
        long l = AL.getICD().alBufferSubDataSOFT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, n2, fArray, n3, fArray.length << 2, l);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") short[] sArray, @NativeType(value="ALsizei") int n3) {
        long l2 = AL.getICD().alBufferSubDataDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, sArray, n3, sArray.length << 1, l2);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") int[] nArray, @NativeType(value="ALsizei") int n3) {
        long l2 = AL.getICD().alBufferSubDataDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, nArray, n3, nArray.length << 2, l2);
    }

    public static void alBufferSubDataDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid const *") float[] fArray, @NativeType(value="ALsizei") int n3) {
        long l2 = AL.getICD().alBufferSubDataDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, fArray, n3, fArray.length << 2, l2);
    }
}

