/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class EXTDebugMarker {
    protected EXTDebugMarker() {
        throw new UnsupportedOperationException();
    }

    public static native void nglInsertEventMarkerEXT(int var0, long var1);

    public static void glInsertEventMarkerEXT(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        EXTDebugMarker.nglInsertEventMarkerEXT(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glInsertEventMarkerEXT(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            EXTDebugMarker.nglInsertEventMarkerEXT(n2, l);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void nglPushGroupMarkerEXT(int var0, long var1);

    public static void glPushGroupMarkerEXT(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        EXTDebugMarker.nglPushGroupMarkerEXT(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glPushGroupMarkerEXT(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            EXTDebugMarker.nglPushGroupMarkerEXT(n2, l);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    public static native void glPopGroupMarkerEXT();

    static {
        GL.initialize();
    }
}

