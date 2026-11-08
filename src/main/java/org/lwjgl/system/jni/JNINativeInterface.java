/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system.jni;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.jspecify.annotations.Nullable;
import org.lwjgl.PointerBuffer;
import org.lwjgl.system.Checks;
import org.lwjgl.system.Library;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;
import org.lwjgl.system.Struct;
import org.lwjgl.system.jni.JNINativeMethod;

public class JNINativeInterface {
    public static final int JNI_VERSION_1_1 = 65537;
    public static final int JNI_VERSION_1_2 = 65538;
    public static final int JNI_VERSION_1_4 = 65540;
    public static final int JNI_VERSION_1_6 = 65542;
    public static final int JNI_VERSION_1_8 = 65544;
    public static final int JNI_VERSION_9 = 589824;
    public static final int JNI_VERSION_10 = 655360;
    public static final int JNI_VERSION_19 = 0x130000;
    public static final int JNI_VERSION_20 = 0x140000;
    public static final int JNI_VERSION_21 = 0x150000;
    public static final int JNI_VERSION_24 = 0x180000;
    public static final int JNIInvalidRefType = 0;
    public static final int JNILocalRefType = 1;
    public static final int JNIGlobalRefType = 2;
    public static final int JNIWeakGlobalRefType = 3;
    public static final int JNI_FALSE = 0;
    public static final int JNI_TRUE = 1;
    public static final int JNI_OK = 0;
    public static final int JNI_ERR = -1;
    public static final int JNI_EDETACHED = -2;
    public static final int JNI_EVERSION = -3;
    public static final int JNI_ENOMEM = -4;
    public static final int JNI_EEXIST = -5;
    public static final int JNI_EINVAL = -6;
    public static final int JNI_COMMIT = 1;
    public static final int JNI_ABORT = 2;

    protected JNINativeInterface() {
        throw new UnsupportedOperationException();
    }

    @NativeType(value="jint")
    public static native int GetVersion();

    @NativeType(value="jmethodID")
    public static native long FromReflectedMethod(@NativeType(value="jobject") Method var0);

    @NativeType(value="jfieldID")
    public static native long FromReflectedField(@NativeType(value="jobject") Field var0);

    public static native @Nullable Method nToReflectedMethod(Class<?> var0, long var1, boolean var3);

    @NativeType(value="jobject")
    public static @Nullable Method ToReflectedMethod(@NativeType(value="jclass") Class<?> clazz, @NativeType(value="jmethodID") long l, @NativeType(value="jboolean") boolean bl) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNINativeInterface.nToReflectedMethod(clazz, l, bl);
    }

    public static native @Nullable Field nToReflectedField(Class<?> var0, long var1, boolean var3);

    @NativeType(value="jobject")
    public static @Nullable Field ToReflectedField(@NativeType(value="jclass") Class<?> clazz, @NativeType(value="jfieldID") long l, @NativeType(value="jboolean") boolean bl) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNINativeInterface.nToReflectedField(clazz, l, bl);
    }

    @NativeType(value="void *")
    public static native long NewGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteGlobalRef(long var0);

    public static void DeleteGlobalRef(@NativeType(value="void *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNINativeInterface.nDeleteGlobalRef(l);
    }

    public static native long nGetBooleanArrayElements(byte[] var0, long var1);

    @NativeType(value="jboolean *")
    public static @Nullable ByteBuffer GetBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] byArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetBooleanArrayElements(byArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memByteBufferSafe(l, byArray.length);
    }

    public static native void nReleaseBooleanArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseBooleanArrayElements(@NativeType(value="jbooleanArray") byte[] byArray, @NativeType(value="jboolean *") ByteBuffer byteBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseBooleanArrayElements(byArray, MemoryUtil.memAddress(byteBuffer), n);
    }

    public static native long nGetByteArrayElements(byte[] var0, long var1);

    @NativeType(value="jbyte *")
    public static @Nullable ByteBuffer GetByteArrayElements(@NativeType(value="jbyteArray") byte[] byArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetByteArrayElements(byArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memByteBufferSafe(l, byArray.length);
    }

    public static native void nReleaseByteArrayElements(byte[] var0, long var1, int var3);

    public static void ReleaseByteArrayElements(@NativeType(value="jbyteArray") byte[] byArray, @NativeType(value="jbyte *") ByteBuffer byteBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseByteArrayElements(byArray, MemoryUtil.memAddress(byteBuffer), n);
    }

    public static native long nGetCharArrayElements(char[] var0, long var1);

    @NativeType(value="jchar *")
    public static @Nullable ShortBuffer GetCharArrayElements(@NativeType(value="jcharArray") char[] cArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetCharArrayElements(cArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memShortBufferSafe(l, cArray.length);
    }

    public static native void nReleaseCharArrayElements(char[] var0, long var1, int var3);

    public static void ReleaseCharArrayElements(@NativeType(value="jcharArray") char[] cArray, @NativeType(value="jchar *") ShortBuffer shortBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseCharArrayElements(cArray, MemoryUtil.memAddress(shortBuffer), n);
    }

    public static native long nGetShortArrayElements(short[] var0, long var1);

    @NativeType(value="jshort *")
    public static @Nullable ShortBuffer GetShortArrayElements(@NativeType(value="jshortArray") short[] sArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetShortArrayElements(sArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memShortBufferSafe(l, sArray.length);
    }

    public static native void nReleaseShortArrayElements(short[] var0, long var1, int var3);

    public static void ReleaseShortArrayElements(@NativeType(value="jshortArray") short[] sArray, @NativeType(value="jshort *") ShortBuffer shortBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseShortArrayElements(sArray, MemoryUtil.memAddress(shortBuffer), n);
    }

    public static native long nGetIntArrayElements(int[] var0, long var1);

    @NativeType(value="jint *")
    public static @Nullable IntBuffer GetIntArrayElements(@NativeType(value="jintArray") int[] nArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetIntArrayElements(nArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memIntBufferSafe(l, nArray.length);
    }

    public static native void nReleaseIntArrayElements(int[] var0, long var1, int var3);

    public static void ReleaseIntArrayElements(@NativeType(value="jintArray") int[] nArray, @NativeType(value="jint *") IntBuffer intBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseIntArrayElements(nArray, MemoryUtil.memAddress(intBuffer), n);
    }

    public static native long nGetLongArrayElements(long[] var0, long var1);

    @NativeType(value="jlong *")
    public static @Nullable LongBuffer GetLongArrayElements(@NativeType(value="jlongArray") long[] lArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetLongArrayElements(lArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memLongBufferSafe(l, lArray.length);
    }

    public static native void nReleaseLongArrayElements(long[] var0, long var1, int var3);

    public static void ReleaseLongArrayElements(@NativeType(value="jlongArray") long[] lArray, @NativeType(value="jlong *") LongBuffer longBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseLongArrayElements(lArray, MemoryUtil.memAddress(longBuffer), n);
    }

    public static native long nGetFloatArrayElements(float[] var0, long var1);

    @NativeType(value="jfloat *")
    public static @Nullable FloatBuffer GetFloatArrayElements(@NativeType(value="jfloatArray") float[] fArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetFloatArrayElements(fArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memFloatBufferSafe(l, fArray.length);
    }

    public static native void nReleaseFloatArrayElements(float[] var0, long var1, int var3);

    public static void ReleaseFloatArrayElements(@NativeType(value="jfloatArray") float[] fArray, @NativeType(value="jfloat *") FloatBuffer floatBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseFloatArrayElements(fArray, MemoryUtil.memAddress(floatBuffer), n);
    }

    public static native long nGetDoubleArrayElements(double[] var0, long var1);

    @NativeType(value="jdouble *")
    public static @Nullable DoubleBuffer GetDoubleArrayElements(@NativeType(value="jdoubleArray") double[] dArray, @NativeType(value="jboolean *") @Nullable ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkSafe((Buffer)byteBuffer, 1);
        }
        long l = JNINativeInterface.nGetDoubleArrayElements(dArray, MemoryUtil.memAddressSafe(byteBuffer));
        return MemoryUtil.memDoubleBufferSafe(l, dArray.length);
    }

    public static native void nReleaseDoubleArrayElements(double[] var0, long var1, int var3);

    public static void ReleaseDoubleArrayElements(@NativeType(value="jdoubleArray") double[] dArray, @NativeType(value="jdouble *") DoubleBuffer doubleBuffer, @NativeType(value="jint") int n) {
        JNINativeInterface.nReleaseDoubleArrayElements(dArray, MemoryUtil.memAddress(doubleBuffer), n);
    }

    public static native void nGetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] byArray, @NativeType(value="jsize") int n, @NativeType(value="jboolean *") ByteBuffer byteBuffer) {
        JNINativeInterface.nGetBooleanArrayRegion(byArray, n, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nSetBooleanArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetBooleanArrayRegion(@NativeType(value="jbooleanArray") byte[] byArray, @NativeType(value="jsize") int n, @NativeType(value="jboolean const *") ByteBuffer byteBuffer) {
        JNINativeInterface.nSetBooleanArrayRegion(byArray, n, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nGetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void GetByteArrayRegion(@NativeType(value="jbyteArray") byte[] byArray, @NativeType(value="jsize") int n, @NativeType(value="jbyte *") ByteBuffer byteBuffer) {
        JNINativeInterface.nGetByteArrayRegion(byArray, n, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nSetByteArrayRegion(byte[] var0, int var1, int var2, long var3);

    public static void SetByteArrayRegion(@NativeType(value="jbyteArray") byte[] byArray, @NativeType(value="jsize") int n, @NativeType(value="jbyte const *") ByteBuffer byteBuffer) {
        JNINativeInterface.nSetByteArrayRegion(byArray, n, byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nGetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void GetCharArrayRegion(@NativeType(value="jcharArray") char[] cArray, @NativeType(value="jsize") int n, @NativeType(value="jchar *") ShortBuffer shortBuffer) {
        JNINativeInterface.nGetCharArrayRegion(cArray, n, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nSetCharArrayRegion(char[] var0, int var1, int var2, long var3);

    public static void SetCharArrayRegion(@NativeType(value="jcharArray") char[] cArray, @NativeType(value="jsize") int n, @NativeType(value="jchar const *") ShortBuffer shortBuffer) {
        JNINativeInterface.nSetCharArrayRegion(cArray, n, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nGetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void GetShortArrayRegion(@NativeType(value="jshortArray") short[] sArray, @NativeType(value="jsize") int n, @NativeType(value="jshort *") ShortBuffer shortBuffer) {
        JNINativeInterface.nGetShortArrayRegion(sArray, n, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nSetShortArrayRegion(short[] var0, int var1, int var2, long var3);

    public static void SetShortArrayRegion(@NativeType(value="jshortArray") short[] sArray, @NativeType(value="jsize") int n, @NativeType(value="jshort const *") ShortBuffer shortBuffer) {
        JNINativeInterface.nSetShortArrayRegion(sArray, n, shortBuffer.remaining(), MemoryUtil.memAddress(shortBuffer));
    }

    public static native void nGetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void GetIntArrayRegion(@NativeType(value="jintArray") int[] nArray, @NativeType(value="jsize") int n, @NativeType(value="jint *") IntBuffer intBuffer) {
        JNINativeInterface.nGetIntArrayRegion(nArray, n, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nSetIntArrayRegion(int[] var0, int var1, int var2, long var3);

    public static void SetIntArrayRegion(@NativeType(value="jintArray") int[] nArray, @NativeType(value="jsize") int n, @NativeType(value="jint const *") IntBuffer intBuffer) {
        JNINativeInterface.nSetIntArrayRegion(nArray, n, intBuffer.remaining(), MemoryUtil.memAddress(intBuffer));
    }

    public static native void nGetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void GetLongArrayRegion(@NativeType(value="jlongArray") long[] lArray, @NativeType(value="jsize") int n, @NativeType(value="jlong *") LongBuffer longBuffer) {
        JNINativeInterface.nGetLongArrayRegion(lArray, n, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void nSetLongArrayRegion(long[] var0, int var1, int var2, long var3);

    public static void SetLongArrayRegion(@NativeType(value="jlongArray") long[] lArray, @NativeType(value="jsize") int n, @NativeType(value="jlong const *") LongBuffer longBuffer) {
        JNINativeInterface.nSetLongArrayRegion(lArray, n, longBuffer.remaining(), MemoryUtil.memAddress(longBuffer));
    }

    public static native void nGetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void GetFloatArrayRegion(@NativeType(value="jfloatArray") float[] fArray, @NativeType(value="jsize") int n, @NativeType(value="jfloat *") FloatBuffer floatBuffer) {
        JNINativeInterface.nGetFloatArrayRegion(fArray, n, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nSetFloatArrayRegion(float[] var0, int var1, int var2, long var3);

    public static void SetFloatArrayRegion(@NativeType(value="jfloatArray") float[] fArray, @NativeType(value="jsize") int n, @NativeType(value="jfloat const *") FloatBuffer floatBuffer) {
        JNINativeInterface.nSetFloatArrayRegion(fArray, n, floatBuffer.remaining(), MemoryUtil.memAddress(floatBuffer));
    }

    public static native void nGetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void GetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] dArray, @NativeType(value="jsize") int n, @NativeType(value="jdouble *") DoubleBuffer doubleBuffer) {
        JNINativeInterface.nGetDoubleArrayRegion(dArray, n, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    public static native void nSetDoubleArrayRegion(double[] var0, int var1, int var2, long var3);

    public static void SetDoubleArrayRegion(@NativeType(value="jdoubleArray") double[] dArray, @NativeType(value="jsize") int n, @NativeType(value="jdouble const *") DoubleBuffer doubleBuffer) {
        JNINativeInterface.nSetDoubleArrayRegion(dArray, n, doubleBuffer.remaining(), MemoryUtil.memAddress(doubleBuffer));
    }

    public static native int nRegisterNatives(Class<?> var0, long var1, int var3);

    @NativeType(value="jint")
    public static int RegisterNatives(@NativeType(value="jclass") Class<?> clazz, @NativeType(value="JNINativeMethod const *") JNINativeMethod.Buffer buffer) {
        if (Checks.CHECKS) {
            Struct.validate(buffer.address(), buffer.remaining(), JNINativeMethod.SIZEOF, JNINativeMethod::validate);
        }
        return JNINativeInterface.nRegisterNatives(clazz, buffer.address(), buffer.remaining());
    }

    @NativeType(value="jint")
    public static native int UnregisterNatives(@NativeType(value="jclass") Class<?> var0);

    public static native int nGetJavaVM(long var0);

    @NativeType(value="jint")
    public static int GetJavaVM(@NativeType(value="JavaVM **") PointerBuffer pointerBuffer) {
        if (Checks.CHECKS) {
            Checks.check(pointerBuffer, 1);
        }
        return JNINativeInterface.nGetJavaVM(MemoryUtil.memAddress(pointerBuffer));
    }

    public static native void nGetStringRegion(String var0, int var1, int var2, long var3);

    public static void GetStringRegion(@NativeType(value="jstring") String string, @NativeType(value="jsize") int n, @NativeType(value="jchar *") ByteBuffer byteBuffer) {
        JNINativeInterface.nGetStringRegion(string, n, byteBuffer.remaining() >> 1, MemoryUtil.memAddress(byteBuffer));
    }

    public static native void nGetStringUTFRegion(String var0, int var1, int var2, long var3);

    public static void GetStringUTFRegion(@NativeType(value="jstring") String string, @NativeType(value="jsize") int n, @NativeType(value="jsize") int n2, @NativeType(value="char *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.check((Buffer)byteBuffer, n2);
        }
        JNINativeInterface.nGetStringUTFRegion(string, n, n2, MemoryUtil.memAddress(byteBuffer));
    }

    @NativeType(value="void *")
    public static native long NewWeakGlobalRef(@NativeType(value="jobject") Object var0);

    public static native void nDeleteWeakGlobalRef(long var0);

    public static void DeleteWeakGlobalRef(@NativeType(value="void *") long l) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        JNINativeInterface.nDeleteWeakGlobalRef(l);
    }

    public static native @Nullable ByteBuffer nNewDirectByteBuffer(long var0, long var2);

    @NativeType(value="jobject")
    public static @Nullable ByteBuffer NewDirectByteBuffer(@NativeType(value="void *") long l, @NativeType(value="jlong") long l2) {
        if (Checks.CHECKS) {
            Checks.check(l);
        }
        return JNINativeInterface.nNewDirectByteBuffer(l, l2);
    }

    @NativeType(value="void *")
    public static native long GetDirectBufferAddress(@NativeType(value="jobject") Buffer var0);

    @NativeType(value="jobjectRefType")
    public static native int GetObjectRefType(@NativeType(value="jobject") Object var0);

    public static native void noop();

    static {
        Library.initialize();
    }
}

