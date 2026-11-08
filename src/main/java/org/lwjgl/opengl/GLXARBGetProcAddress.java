/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.Checks;
import org.lwjgl.system.JNI;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GLXARBGetProcAddress {
    protected GLXARBGetProcAddress() {
        throw new UnsupportedOperationException();
    }

    public static long nglXGetProcAddressARB(long l) {
        long l2 = GL.getCapabilitiesGLXClient().glXGetProcAddressARB;
        if (Checks.CHECKS) {
            Checks.check(l2);
        }
        return JNI.callPP(l, l2);
    }

    @NativeType(value="void *")
    public static long glXGetProcAddressARB(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        if (Checks.CHECKS) {
            Checks.checkNT1(byteBuffer);
        }
        return GLXARBGetProcAddress.nglXGetProcAddressARB(MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @NativeType(value="void *")
    public static long glXGetProcAddressARB(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            memoryStack.nASCII(charSequence, true);
            long l = memoryStack.getPointerAddress();
            long l2 = GLXARBGetProcAddress.nglXGetProcAddressARB(l);
            return l2;
        }
        finally {
            memoryStack.setPointer(n);
        }
    }
}

