/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import org.lwjgl.system.MemoryUtil;

public class BufferCasts {
    public static ByteBuffer toByteBuffer(CharBuffer charBuffer) {
        return MemoryUtil.memByteBuffer(charBuffer);
    }

    public static ByteBuffer toByteBuffer(ShortBuffer shortBuffer) {
        return MemoryUtil.memByteBuffer(shortBuffer);
    }

    public static ByteBuffer toByteBuffer(IntBuffer intBuffer) {
        return MemoryUtil.memByteBuffer(intBuffer);
    }

    public static ByteBuffer toByteBuffer(LongBuffer longBuffer) {
        return MemoryUtil.memByteBuffer(longBuffer);
    }

    public static ByteBuffer toByteBuffer(FloatBuffer floatBuffer) {
        return MemoryUtil.memByteBuffer(floatBuffer);
    }

    public static ByteBuffer toByteBuffer(DoubleBuffer doubleBuffer) {
        return MemoryUtil.memByteBuffer(doubleBuffer);
    }

    public static void updateBuffer(CharBuffer charBuffer, ByteBuffer byteBuffer) {
    }

    public static void updateBuffer(ShortBuffer shortBuffer, ByteBuffer byteBuffer) {
    }

    public static void updateBuffer(IntBuffer intBuffer, ByteBuffer byteBuffer) {
    }

    public static void updateBuffer(LongBuffer longBuffer, ByteBuffer byteBuffer) {
    }

    public static void updateBuffer(FloatBuffer floatBuffer, ByteBuffer byteBuffer) {
    }

    public static void updateBuffer(DoubleBuffer doubleBuffer, ByteBuffer byteBuffer) {
    }

    public static CharSequence bufferToCharSeq(ByteBuffer byteBuffer) {
        return MemoryUtil.memUTF8(byteBuffer);
    }
}

