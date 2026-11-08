/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import org.lwjgl.PointerBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.SOFTCallbackBufferTypeI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class SOFTCallbackBuffer {
    public static final int AL_BUFFER_CALLBACK_FUNCTION_SOFT = 6560;
    public static final int AL_BUFFER_CALLBACK_USER_PARAM_SOFT = 6561;

    protected SOFTCallbackBuffer() {
        throw new UnsupportedOperationException();
    }

    public static void nalBufferCallbackSOFT(int n, int n2, int n3, long l, long l2) {
        long l3 = AL.getICD().alBufferCallbackSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l2);
        }
        JNI.invokePPV(n, n2, n3, l, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alBufferCallbackSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALsizei") int n3, @NativeType(value="ALBUFFERCALLBACKTYPESOFT") SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI, @NativeType(value="ALvoid *") long l) {
        SOFTCallbackBuffer.nalBufferCallbackSOFT(n, n2, n3, sOFTCallbackBufferTypeI.address(), l);
    }

    public static void nalBufferCallbackDirectSOFT(long l, int n, int n2, int n3, long l2, long l3) {
        long l4 = AL.getICD().alBufferCallbackDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l);
            Checks.check(l3);
        }
        JNI.invokePPPV(l, n, n2, n3, l2, l3, l4);
    }

    @NativeType(value="ALvoid")
    public static void alBufferCallbackDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALsizei") int n3, @NativeType(value="ALBUFFERCALLBACKTYPESOFT") SOFTCallbackBufferTypeI sOFTCallbackBufferTypeI, @NativeType(value="ALvoid *") long l2) {
        SOFTCallbackBuffer.nalBufferCallbackDirectSOFT(l, n, n2, n3, sOFTCallbackBufferTypeI.address(), l2);
    }

    public static void nalGetBufferPtrSOFT(int n, int n2, long l) {
        long l2 = AL.getICD().alGetBufferPtrSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferPtrSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTCallbackBuffer.nalGetBufferPtrSOFT(n, n2, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static long alGetBufferPtrSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            SOFTCallbackBuffer.nalGetBufferPtrSOFT(n, n2, MemoryUtil.memAddress(pointerBuffer));
            long l = pointerBuffer.get(0);
            return l;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalGetBufferPtrDirectSOFT(long l, int n, int n2, long l2) {
        long l3 = AL.getICD().alGetBufferPtrDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferPtrDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTCallbackBuffer.nalGetBufferPtrDirectSOFT(l, n, n2, MemoryUtil.memAddress(pointerBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static long alGetBufferPtrDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            PointerBuffer pointerBuffer = memoryStack.callocPointer(1);
            SOFTCallbackBuffer.nalGetBufferPtrDirectSOFT(l, n, n2, MemoryUtil.memAddress(pointerBuffer));
            long l2 = pointerBuffer.get(0);
            return l2;
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalGetBuffer3PtrSOFT(int n, int n2, long l, long l2, long l3) {
        long l4 = AL.getICD().alGetBuffer3PtrSOFT;
        if (Checks.CHECKS) {
            Checks.check(l4);
        }
        JNI.invokePPPV(n, n2, l, l2, l3, l4);
    }

    @NativeType(value="ALvoid")
    public static void alGetBuffer3PtrSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer3) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
            Checks.check(pointerBuffer2, 1);
            Checks.check(pointerBuffer3, 1);
        }
        SOFTCallbackBuffer.nalGetBuffer3PtrSOFT(n, n2, MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(pointerBuffer2), MemoryUtil.memAddress(pointerBuffer3));
    }

    public static void nalGetBuffer3PtrDirectSOFT(long l, int n, int n2, long l2, long l3, long l4) {
        long l5 = AL.getICD().alGetBuffer3PtrDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l5);
            Checks.check(l);
        }
        JNI.invokePPPPV(l, n, n2, l2, l3, l4, l5);
    }

    @NativeType(value="ALvoid")
    public static void alGetBuffer3PtrDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer3) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
            Checks.check(pointerBuffer2, 1);
            Checks.check(pointerBuffer3, 1);
        }
        SOFTCallbackBuffer.nalGetBuffer3PtrDirectSOFT(l, n, n2, MemoryUtil.memAddress(pointerBuffer), MemoryUtil.memAddress(pointerBuffer2), MemoryUtil.memAddress(pointerBuffer3));
    }

    public static void nalGetBufferPtrvSOFT(int n, int n2, long l) {
        long l2 = AL.getICD().alGetBufferPtrvSOFT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferPtrvSOFT(@NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTCallbackBuffer.nalGetBufferPtrvSOFT(n, n2, MemoryUtil.memAddress(pointerBuffer));
    }

    public static void nalGetBufferPtrvDirectSOFT(long l, int n, int n2, long l2) {
        long l3 = AL.getICD().alGetBufferPtrvDirectSOFT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetBufferPtrvDirectSOFT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALuint") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        SOFTCallbackBuffer.nalGetBufferPtrvDirectSOFT(l, n, n2, MemoryUtil.memAddress(pointerBuffer));
    }
}

