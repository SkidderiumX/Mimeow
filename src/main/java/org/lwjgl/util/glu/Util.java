/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Util {
    private static IntBuffer scratch = BufferUtils.createIntBuffer(16);

    protected static int ceil(int n, int n2) {
        return n % n2 == 0 ? n / n2 : n / n2 + 1;
    }

    protected static float[] normalize(float[] fArray) {
        float f = (float)Math.sqrt(fArray[0] * fArray[0] + fArray[1] * fArray[1] + fArray[2] * fArray[2]);
        if ((double)f == 0.0) {
            return fArray;
        }
        f = 1.0f / f;
        fArray[0] = fArray[0] * f;
        fArray[1] = fArray[1] * f;
        fArray[2] = fArray[2] * f;
        return fArray;
    }

    protected static void cross(float[] fArray, float[] fArray2, float[] fArray3) {
        fArray3[0] = fArray[1] * fArray2[2] - fArray[2] * fArray2[1];
        fArray3[1] = fArray[2] * fArray2[0] - fArray[0] * fArray2[2];
        fArray3[2] = fArray[0] * fArray2[1] - fArray[1] * fArray2[0];
    }

    protected static int compPerPix(int n) {
        switch (n) {
            case 6400: 
            case 6401: 
            case 6402: 
            case 6403: 
            case 6404: 
            case 6405: 
            case 6406: 
            case 6409: {
                return 1;
            }
            case 6410: {
                return 2;
            }
            case 6407: 
            case 32992: {
                return 3;
            }
            case 6408: 
            case 32993: {
                return 4;
            }
        }
        return -1;
    }

    protected static int nearestPower(int n) {
        int n2 = 1;
        if (n == 0) {
            return -1;
        }
        while (n != 1) {
            if (n == 3) {
                return n2 << 2;
            }
            n >>= 1;
            n2 <<= 1;
        }
        return n2;
    }

    protected static int bytesPerPixel(int n, int n2) {
        return (switch (n) {
            case 6400, 6401, 6402, 6403, 6404, 6405, 6406, 6409 -> 1;
            case 6410 -> 2;
            case 6407, 32992 -> 3;
            case 6408, 32993 -> 4;
            default -> 0;
        }) * (switch (n2) {
            case 5121 -> 1;
            case 5120 -> 1;
            case 6656 -> 1;
            case 5123 -> 2;
            case 5122 -> 2;
            case 5125 -> 4;
            case 5124 -> 4;
            case 5126 -> 4;
            default -> 0;
        });
    }

    protected static int glGetIntegerv(int n) {
        scratch.rewind();
        GL11.glGetIntegerv(n, scratch);
        return scratch.get();
    }
}

