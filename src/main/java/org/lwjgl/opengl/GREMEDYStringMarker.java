/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.system.NativeType;

public class GREMEDYStringMarker {
    protected GREMEDYStringMarker() {
        throw new UnsupportedOperationException();
    }

    public static native void nglStringMarkerGREMEDY(int var0, long var1);

    public static void glStringMarkerGREMEDY(@NativeType(value="GLchar const *") ByteBuffer byteBuffer) {
        GREMEDYStringMarker.nglStringMarkerGREMEDY(byteBuffer.remaining(), MemoryUtil.memAddress(byteBuffer));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void glStringMarkerGREMEDY(@NativeType(value="GLchar const *") CharSequence charSequence) {
        MemoryStack memoryStack = MemoryStack.stackGet();
        int n = memoryStack.getPointer();
        try {
            int n2 = memoryStack.nUTF8(charSequence, false);
            long l = memoryStack.getPointerAddress();
            GREMEDYStringMarker.nglStringMarkerGREMEDY(n2, l);
        }
        finally {
            memoryStack.setPointer(n);
        }
    }

    static {
        GL.initialize();
    }
}

