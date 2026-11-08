/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.system.MemoryUtil;

public class oc30aea91d28 {
    public static int \u0576;

    private oc30aea91d28() {
    }

    public static void \u03d3(int n, ByteBuffer byteBuffer) {
        ARBShaderObjects.glShaderSourceARB(n, (CharSequence)MemoryUtil.memUTF8(byteBuffer));
    }

    public static void \u0537(int n, ByteBuffer byteBuffer) {
        GL20.glShaderSource(n, (CharSequence)MemoryUtil.memUTF8(byteBuffer));
    }

    public static void \u054f(int n, CharSequence charSequence) {
        GL20.glShaderSource(n, charSequence);
    }

    public static void \u0539(int n, IntBuffer intBuffer) {
        GL11.glGetIntegerv(n, intBuffer);
    }

    public static void \u0132(int n, FloatBuffer floatBuffer) {
        GL11.glGetFloatv(n, floatBuffer);
    }
}

