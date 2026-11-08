/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.system;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.APIUtil;
import org.lwjgl.system.Configuration;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.Pointer;
import org.lwjgl.system.jni.JNINativeInterface;

public class ThreadLocalUtil {
    private static final long JNI_NATIVE_INTERFACE;
    private static final int CAPABILITIES_OFFSET;
    private static final long RESERVED_NULL;
    private static final int JNI_NATIVE_INTERFACE_FUNCTION_COUNT;
    private static final long FUNCTION_MISSING_ABORT;
    private static long FUNCTION_MISSING_ABORT_TABLE;

    private ThreadLocalUtil() {
    }

    private static native long getThreadJNIEnv();

    private static native long getFunctionMissingAbort();

    private static native long setupEnvData(int var0);

    public static void setCapabilities(long l) {
        long l2 = ThreadLocalUtil.getThreadJNIEnv();
        long l3 = MemoryUtil.memGetAddress(l2);
        if (l == 0L) {
            if (l3 != JNI_NATIVE_INTERFACE) {
                MemoryUtil.memPutAddress(l3 + (long)CAPABILITIES_OFFSET, FUNCTION_MISSING_ABORT_TABLE);
            }
        } else {
            if (l3 == JNI_NATIVE_INTERFACE) {
                ThreadLocalUtil.setupEnvData(JNI_NATIVE_INTERFACE_FUNCTION_COUNT);
                l3 = MemoryUtil.memGetAddress(l2);
            }
            MemoryUtil.memPutAddress(l3 + (long)CAPABILITIES_OFFSET, l);
        }
    }

    public static void setFunctionMissingAddresses(int n) {
        long l = JNI_NATIVE_INTERFACE + (long)CAPABILITIES_OFFSET;
        long l2 = MemoryUtil.memGetAddress(l);
        if (n == 0) {
            if (l2 == FUNCTION_MISSING_ABORT_TABLE && FUNCTION_MISSING_ABORT_TABLE != 0L) {
                FUNCTION_MISSING_ABORT_TABLE = 0L;
                MemoryUtil.getAllocator().free(l2);
                MemoryUtil.memPutAddress(l, RESERVED_NULL);
            }
        } else {
            if (l2 != RESERVED_NULL) {
                throw new IllegalStateException("setFunctionMissingAddresses has been called already");
            }
            if (l2 != 0L) {
                if (MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE) == RESERVED_NULL) {
                    return;
                }
                System.err.println("[LWJGL] [ThreadLocalUtil] Unsupported JVM detected, this may result in a crash. Please inform LWJGL developers.");
            }
            FUNCTION_MISSING_ABORT_TABLE = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(n) * (long)Pointer.POINTER_SIZE);
            for (int i = 0; i < n; ++i) {
                MemoryUtil.memPutAddress(FUNCTION_MISSING_ABORT_TABLE + Integer.toUnsignedLong(i) * (long)Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
            }
            MemoryUtil.memPutAddress(l, FUNCTION_MISSING_ABORT_TABLE);
        }
    }

    public static PointerBuffer setupAddressBuffer(PointerBuffer pointerBuffer) {
        for (int i = pointerBuffer.position(); i < pointerBuffer.limit(); ++i) {
            if (pointerBuffer.get(i) != 0L) continue;
            pointerBuffer.put(i, FUNCTION_MISSING_ABORT);
        }
        return pointerBuffer;
    }

    public static boolean areCapabilitiesDifferent(PointerBuffer pointerBuffer, PointerBuffer pointerBuffer2) {
        for (int i = 0; i < pointerBuffer.remaining(); ++i) {
            if (pointerBuffer.get(i) == pointerBuffer2.get(i) || pointerBuffer2.get(i) == 0L) continue;
            return true;
        }
        return false;
    }

    static {
        int n;
        int n2;
        JNI_NATIVE_INTERFACE = MemoryUtil.memGetAddress(ThreadLocalUtil.getThreadJNIEnv());
        CAPABILITIES_OFFSET = 3 * Pointer.POINTER_SIZE;
        RESERVED_NULL = MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE + (long)CAPABILITIES_OFFSET);
        FUNCTION_MISSING_ABORT = ThreadLocalUtil.getFunctionMissingAbort();
        FUNCTION_MISSING_ABORT_TABLE = 0L;
        int n3 = JNINativeInterface.GetVersion();
        switch (n3) {
            case 65537: {
                n2 = 12;
                break;
            }
            default: {
                n2 = 4;
            }
        }
        switch (n3) {
            case 65537: {
                n = 208;
                break;
            }
            case 65538: {
                n = 225;
                break;
            }
            case 65540: {
                n = 228;
                break;
            }
            case 65542: 
            case 65544: {
                n = 229;
                break;
            }
            case 589824: 
            case 655360: {
                n = 230;
                break;
            }
            case 0x130000: 
            case 0x140000: {
                n = 231;
                break;
            }
            case 0x150000: {
                n = 232;
                break;
            }
            case 0x180000: {
                n = 233;
                break;
            }
            default: {
                n = 233;
                APIUtil.DEBUG_STREAM.println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers.");
            }
        }
        JNI_NATIVE_INTERFACE_FUNCTION_COUNT = n2 + Configuration.JNI_NATIVE_INTERFACE_FUNCTION_COUNT.get(n);
    }
}

