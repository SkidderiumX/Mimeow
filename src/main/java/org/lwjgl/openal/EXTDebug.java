/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.openal;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.openal.AL;
import org.lwjgl.openal.EXTDebugProcI;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDebug {
    public static final int ALC_CONTEXT_FLAGS_EXT = 6607;
    public static final int ALC_CONTEXT_DEBUG_BIT_EXT = 1;
    public static final int AL_CONTEXT_FLAGS_EXT = 6607;
    public static final int AL_CONTEXT_DEBUG_BIT_EXT = 1;
    public static final int AL_DEBUG_OUTPUT_EXT = 6578;
    public static final int AL_DEBUG_CALLBACK_FUNCTION_EXT = 6579;
    public static final int AL_DEBUG_CALLBACK_USER_PARAM_EXT = 6580;
    public static final int AL_DEBUG_SOURCE_API_EXT = 6581;
    public static final int AL_DEBUG_SOURCE_AUDIO_SYSTEM_EXT = 6582;
    public static final int AL_DEBUG_SOURCE_THIRD_PARTY_EXT = 6583;
    public static final int AL_DEBUG_SOURCE_APPLICATION_EXT = 6584;
    public static final int AL_DEBUG_SOURCE_OTHER_EXT = 6585;
    public static final int AL_DEBUG_TYPE_ERROR_EXT = 6586;
    public static final int AL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_EXT = 6587;
    public static final int AL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_EXT = 6588;
    public static final int AL_DEBUG_TYPE_PORTABILITY_EXT = 6589;
    public static final int AL_DEBUG_TYPE_PERFORMANCE_EXT = 6590;
    public static final int AL_DEBUG_TYPE_MARKER_EXT = 6591;
    public static final int AL_DEBUG_TYPE_OTHER_EXT = 6594;
    public static final int AL_DEBUG_TYPE_PUSH_GROUP_EXT = 6592;
    public static final int AL_DEBUG_TYPE_POP_GROUP_EXT = 6593;
    public static final int AL_DEBUG_SEVERITY_HIGH_EXT = 6595;
    public static final int AL_DEBUG_SEVERITY_MEDIUM_EXT = 6596;
    public static final int AL_DEBUG_SEVERITY_LOW_EXT = 6597;
    public static final int AL_DEBUG_SEVERITY_NOTIFICATION_EXT = 6598;
    public static final int AL_DONT_CARE_EXT = 2;
    public static final int AL_DEBUG_LOGGED_MESSAGES_EXT = 6599;
    public static final int AL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_EXT = 6600;
    public static final int AL_MAX_DEBUG_MESSAGE_LENGTH_EXT = 6601;
    public static final int AL_MAX_DEBUG_LOGGED_MESSAGES_EXT = 6602;
    public static final int AL_MAX_DEBUG_GROUP_STACK_DEPTH_EXT = 6603;
    public static final int AL_MAX_LABEL_LENGTH_EXT = 6604;
    public static final int AL_STACK_OVERFLOW_EXT = 6605;
    public static final int AL_STACK_UNDERFLOW_EXT = 6606;
    public static final int AL_BUFFER_EXT = 4105;
    public static final int AL_SOURCE_EXT = 6608;
    public static final int AL_FILTER_EXT = 6609;
    public static final int AL_EFFECT_EXT = 6610;
    public static final int AL_AUXILIARY_EFFECT_SLOT_EXT = 6611;

    protected EXTDebug() {
        throw new UnsupportedOperationException();
    }

    public static void nalDebugMessageCallbackEXT(long l, long l2) {
        long l3 = AL.getICD().alDebugMessageCallbackEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePPV(l, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageCallbackEXT(@NativeType(value="ALDEBUGPROCEXT") @Nullable EXTDebugProcI eXTDebugProcI, @NativeType(value="ALvoid *") long l) {
        EXTDebug.nalDebugMessageCallbackEXT(MemoryUtil.memAddressSafe(eXTDebugProcI), l);
    }

    public static void nalDebugMessageCallbackDirectEXT(long l, long l2, long l3) {
        long l4 = AL.getICD().alDebugMessageCallbackDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l);
        }
        JNI.invokePPPV(l, l2, l3, l4);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageCallbackDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALDEBUGPROCEXT") @Nullable EXTDebugProcI eXTDebugProcI, @NativeType(value="ALvoid *") long l2) {
        EXTDebug.nalDebugMessageCallbackDirectEXT(l, MemoryUtil.memAddressSafe(eXTDebugProcI), l2);
    }

    public static void nalDebugMessageInsertEXT(int n, int n2, int n3, int n4, int n5, long l) {
        long l2 = AL.getICD().alDebugMessageInsertEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, n3, n4, n5, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageInsertEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALuint") int n3, @NativeType(value="ALenum") int n4, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalDebugMessageInsertEXT(n, n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDebugMessageInsertEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALuint") int n3, @NativeType(value="ALenum") int n4, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            int n6 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            EXTDebug.nalDebugMessageInsertEXT(n, n2, n3, n4, n6, l);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static void nalDebugMessageInsertDirectEXT(long l, int n, int n2, int n3, int n4, int n5, long l2) {
        long l3 = AL.getICD().alDebugMessageInsertDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, n3, n4, n5, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageInsertDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALuint") int n3, @NativeType(value="ALenum") int n4, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalDebugMessageInsertDirectEXT(l, n, n2, n3, n4, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alDebugMessageInsertDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALuint") int n3, @NativeType(value="ALenum") int n4, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n5 = memoryStack.getPointer();
        try {
            int n6 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            EXTDebug.nalDebugMessageInsertDirectEXT(l, n, n2, n3, n4, n6, l2);
        }
        finally {
            memoryStack.setPointer(n5);
        }
    }

    public static void nalDebugMessageControlEXT(int n, int n2, int n3, int n4, long l, boolean bl) {
        long l2 = AL.getICD().alDebugMessageControlEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, n3, n4, l, bl, l2);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageControlEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALuint const *") @Nullable IntBuffer intBuffer, @NativeType(value="ALboolean") boolean bl) {
        EXTDebug.nalDebugMessageControlEXT(n, n2, n3, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), bl);
    }

    public static void nalDebugMessageControlDirectEXT(long l, int n, int n2, int n3, int n4, long l2, boolean bl) {
        long l3 = AL.getICD().alDebugMessageControlDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, n3, n4, l2, bl, l3);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageControlDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALuint const *") @Nullable IntBuffer intBuffer, @NativeType(value="ALboolean") boolean bl) {
        EXTDebug.nalDebugMessageControlDirectEXT(l, n, n2, n3, Checks.remainingSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer), bl);
    }

    public static void nalPushDebugGroupEXT(int n, int n2, int n3, long l) {
        long l2 = AL.getICD().alPushDebugGroupEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, n3, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alPushDebugGroupEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalPushDebugGroupEXT(n, n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alPushDebugGroupEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            EXTDebug.nalPushDebugGroupEXT(n, n2, n4, l);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalPushDebugGroupDirectEXT(long l, int n, int n2, int n3, long l2) {
        long l3 = AL.getICD().alPushDebugGroupDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alPushDebugGroupDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalPushDebugGroupDirectEXT(l, n, n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alPushDebugGroupDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            EXTDebug.nalPushDebugGroupDirectEXT(l, n, n2, n4, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    @NativeType(value="ALvoid")
    public static void alPopDebugGroupEXT() {
        long l = AL.getICD().alPopDebugGroupEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokeV(l);
    }

    @NativeType(value="ALvoid")
    public static void alPopDebugGroupDirectEXT(@NativeType(value="ALCcontext *") long l) {
        long l2 = AL.getICD().alPopDebugGroupDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePV(l, l2);
    }

    public static int nalGetDebugMessageLogEXT(int n, int n2, long l, long l2, long l3, long l4, long l5, long l6) {
        long l7 = AL.getICD().alGetDebugMessageLogEXT;
        if (Checks.CHECKS) {
            Checks.check(l7);
        }
        return JNI.invokePPPPPPI(n, n2, l, l2, l3, l4, l5, l6, l7);
    }

    @NativeType(value="ALuint")
    public static int alGetDebugMessageLogEXT(@NativeType(value="ALenum *") @Nullable IntBuffer intBuffer, @NativeType(value="ALenum *") @Nullable IntBuffer intBuffer2, @NativeType(value="ALuint *") @Nullable IntBuffer intBuffer3, @NativeType(value="ALenum *") @Nullable IntBuffer intBuffer4, @NativeType(value="ALsizei *") @Nullable IntBuffer intBuffer5, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer2, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer3, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer4, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer5, Checks.remainingSafe(intBuffer));
        }
        return EXTDebug.nalGetDebugMessageLogEXT(Checks.remainingSafe(intBuffer), Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4), MemoryUtil.memAddressSafe(intBuffer5), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static int nalGetDebugMessageLogDirectEXT(long l, int n, int n2, long l2, long l3, long l4, long l5, long l6, long l7) {
        long l8 = AL.getICD().alGetDebugMessageLogDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l8);
            Checks.check(l);
        }
        return JNI.invokePPPPPPPI(l, n, n2, l2, l3, l4, l5, l6, l7, l8);
    }

    @NativeType(value="ALuint")
    public static int alGetDebugMessageLogDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum *") @Nullable IntBuffer intBuffer, @NativeType(value="ALenum *") @Nullable IntBuffer intBuffer2, @NativeType(value="ALuint *") @Nullable IntBuffer intBuffer3, @NativeType(value="ALenum *") @Nullable IntBuffer intBuffer4, @NativeType(value="ALsizei *") @Nullable IntBuffer intBuffer5, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)intBuffer2, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer3, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer4, Checks.remainingSafe(intBuffer));
            Checks.checkSafe((Buffer)intBuffer5, Checks.remainingSafe(intBuffer));
        }
        return EXTDebug.nalGetDebugMessageLogDirectEXT(l, Checks.remainingSafe(intBuffer), Checks.remainingSafe(byteBuffer), MemoryUtil.memAddressSafe(intBuffer), MemoryUtil.memAddressSafe(intBuffer2), MemoryUtil.memAddressSafe(intBuffer3), MemoryUtil.memAddressSafe(intBuffer4), MemoryUtil.memAddressSafe(intBuffer5), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void nalObjectLabelEXT(int n, int n2, int n3, long l) {
        long l2 = AL.getICD().alObjectLabelEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, n2, n3, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alObjectLabelEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalObjectLabelEXT(n, n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alObjectLabelEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            EXTDebug.nalObjectLabelEXT(n, n2, n4, l);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalObjectLabelDirectEXT(long l, int n, int n2, int n3, long l2) {
        long l3 = AL.getICD().alObjectLabelDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, n3, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alObjectLabelDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") ByteBuffer byteBuffer) {
        EXTDebug.nalObjectLabelDirectEXT(l, n, n2, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="ALvoid")
    public static void alObjectLabelDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n3 = memoryStack.getPointer();
        try {
            int n4 = memoryStack.nUTF8(charSequence, false);
            long l2 = memoryStack.getPointerAddress();
            EXTDebug.nalObjectLabelDirectEXT(l, n, n2, n4, l2);
        }
        finally {
            memoryStack.setPointer(n3);
        }
    }

    public static void nalGetObjectLabelEXT(int n, int n2, int n3, long l, long l2) {
        long l3 = AL.getICD().alGetObjectLabelEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
        }
        JNI.invokePPV(n, n2, n3, l, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetObjectLabelEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALsizei *") IntBuffer intBuffer, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDebug.nalGetObjectLabelEXT(n, n2, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    public static void nalGetObjectLabelDirectEXT(long l, int n, int n2, int n3, long l2, long l3) {
        long l4 = AL.getICD().alGetObjectLabelDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l4);
            Checks.check(l);
        }
        JNI.invokePPPV(l, n, n2, n3, l2, l3, l4);
    }

    @NativeType(value="ALvoid")
    public static void alGetObjectLabelDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALsizei *") IntBuffer intBuffer, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)intBuffer, 1);
        }
        EXTDebug.nalGetObjectLabelDirectEXT(l, n, n2, Checks.remainingSafe(byteBuffer), MemoryUtil.memAddress(intBuffer), MemoryUtil.memAddressSafe(byteBuffer));
    }

    @NativeType(value="ALvoid *")
    public static long alGetPointerEXT(@NativeType(value="ALenum") int n) {
        long l = AL.getICD().alGetPointerEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNI.invokeP(n, l);
    }

    @NativeType(value="ALvoid *")
    public static long alGetPointerDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n) {
        long l2 = AL.getICD().alGetPointerDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        return JNI.invokePP(l, n, l2);
    }

    public static void nalGetPointervEXT(int n, long l) {
        long l2 = AL.getICD().alGetPointervEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        JNI.invokePV(n, l, l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetPointervEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDebug.nalGetPointervEXT(n, MemoryUtil.memAddress(pointerBuffer));
    }

    public static void nalGetPointervDirectEXT(long l, int n, long l2) {
        long l3 = AL.getICD().alGetPointervDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l3);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, l2, l3);
    }

    @NativeType(value="ALvoid")
    public static void alGetPointervDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALvoid **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        EXTDebug.nalGetPointervDirectEXT(l, n, MemoryUtil.memAddress(pointerBuffer));
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageControlEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALuint const *") int @Nullable [] nArray, @NativeType(value="ALboolean") boolean bl) {
        long l = AL.getICD().alDebugMessageControlEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNI.invokePV(n, n2, n3, Checks.lengthSafe(nArray), nArray, bl, l);
    }

    @NativeType(value="ALvoid")
    public static void alDebugMessageControlDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALenum") int n2, @NativeType(value="ALenum") int n3, @NativeType(value="ALuint const *") int @Nullable [] nArray, @NativeType(value="ALboolean") boolean bl) {
        long l2 = AL.getICD().alDebugMessageControlDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
        }
        JNI.invokePPV(l, n, n2, n3, Checks.lengthSafe(nArray), nArray, bl, l2);
    }

    @NativeType(value="ALuint")
    public static int alGetDebugMessageLogEXT(@NativeType(value="ALenum *") int @Nullable [] nArray, @NativeType(value="ALenum *") int @Nullable [] nArray2, @NativeType(value="ALuint *") int @Nullable [] nArray3, @NativeType(value="ALenum *") int @Nullable [] nArray4, @NativeType(value="ALsizei *") int @Nullable [] nArray5, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        long l = AL.getICD().alGetDebugMessageLogEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.checkSafe(nArray2, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray3, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray4, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray5, Checks.lengthSafe(nArray));
        }
        return JNI.invokePPPPPPI(Checks.lengthSafe(nArray), Checks.remainingSafe(byteBuffer), nArray, nArray2, nArray3, nArray4, nArray5, MemoryUtil.memAddressSafe(byteBuffer), l);
    }

    @NativeType(value="ALuint")
    public static int alGetDebugMessageLogDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum *") int @Nullable [] nArray, @NativeType(value="ALenum *") int @Nullable [] nArray2, @NativeType(value="ALuint *") int @Nullable [] nArray3, @NativeType(value="ALenum *") int @Nullable [] nArray4, @NativeType(value="ALsizei *") int @Nullable [] nArray5, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        long l2 = AL.getICD().alGetDebugMessageLogDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.checkSafe(nArray2, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray3, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray4, Checks.lengthSafe(nArray));
            Checks.checkSafe(nArray5, Checks.lengthSafe(nArray));
        }
        return JNI.invokePPPPPPPI(l, Checks.lengthSafe(nArray), Checks.remainingSafe(byteBuffer), nArray, nArray2, nArray3, nArray4, nArray5, MemoryUtil.memAddressSafe(byteBuffer), l2);
    }

    @NativeType(value="ALvoid")
    public static void alGetObjectLabelEXT(@NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALsizei *") int[] nArray, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        long l = AL.getICD().alGetObjectLabelEXT;
        if (Checks.CHECKS) {
            Checks.check(l);
            Checks.check(nArray, 1);
        }
        JNI.invokePPV(n, n2, Checks.remainingSafe(byteBuffer), nArray, MemoryUtil.memAddressSafe(byteBuffer), l);
    }

    @NativeType(value="ALvoid")
    public static void alGetObjectLabelDirectEXT(@NativeType(value="ALCcontext *") long l, @NativeType(value="ALenum") int n, @NativeType(value="ALuint") int n2, @NativeType(value="ALsizei *") int[] nArray, @NativeType(value="ALchar *") @Nullable ByteBuffer byteBuffer) {
        long l2 = AL.getICD().alGetObjectLabelDirectEXT;
        if (Checks.CHECKS) {
            Checks.check(l2);
            Checks.check(l);
            Checks.check(nArray, 1);
        }
        JNI.invokePPPV(l, n, n2, Checks.remainingSafe(byteBuffer), nArray, MemoryUtil.memAddressSafe(byteBuffer), l2);
    }
}

