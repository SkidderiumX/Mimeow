/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import java.nio.ByteBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.PixelStoreState;
import org.lwjgl.util.glu.Util;

public class MipMap
extends Util {
    public static int gluBuild2DMipmaps(int n, int n2, int n3, int n4, int n5, int n6, ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int n7;
        if (n3 < 1 || n4 < 1) {
            return 100901;
        }
        int n8 = MipMap.bytesPerPixel(n5, n6);
        if (n8 == 0) {
            return 100900;
        }
        int n9 = MipMap.glGetIntegerv(3379);
        int n10 = MipMap.nearestPower(n3);
        if (n10 > n9) {
            n10 = n9;
        }
        if ((n7 = MipMap.nearestPower(n4)) > n9) {
            n7 = n9;
        }
        PixelStoreState pixelStoreState = new PixelStoreState();
        GL11.glPixelStorei(3330, 0);
        GL11.glPixelStorei(3333, 1);
        GL11.glPixelStorei(3331, 0);
        GL11.glPixelStorei(3332, 0);
        int n11 = 0;
        boolean bl = false;
        if (n10 != n3 || n7 != n4) {
            byteBuffer2 = BufferUtils.createByteBuffer((n10 + 4) * n7 * n8);
            int n12 = MipMap.gluScaleImage(n5, n3, n4, n6, byteBuffer, n10, n7, n6, byteBuffer2);
            if (n12 != 0) {
                n11 = n12;
                bl = true;
            }
            GL11.glPixelStorei(3314, 0);
            GL11.glPixelStorei(3317, 1);
            GL11.glPixelStorei(3315, 0);
            GL11.glPixelStorei(3316, 0);
        } else {
            byteBuffer2 = byteBuffer;
        }
        ByteBuffer byteBuffer3 = null;
        ByteBuffer byteBuffer4 = null;
        int n13 = 0;
        while (!bl) {
            int n14;
            if (byteBuffer2 != byteBuffer) {
                GL11.glPixelStorei(3314, 0);
                GL11.glPixelStorei(3317, 1);
                GL11.glPixelStorei(3315, 0);
                GL11.glPixelStorei(3316, 0);
            }
            GL11.glTexImage2D(n, n13, n2, n10, n7, 0, n5, n6, byteBuffer2);
            if (n10 == 1 && n7 == 1) break;
            int n15 = n10 < 2 ? 1 : n10 >> 1;
            int n16 = n14 = n7 < 2 ? 1 : n7 >> 1;
            ByteBuffer byteBuffer5 = byteBuffer3 == null ? (byteBuffer3 = BufferUtils.createByteBuffer((n15 + 4) * n14 * n8)) : (byteBuffer4 == null ? (byteBuffer4 = BufferUtils.createByteBuffer((n15 + 4) * n14 * n8)) : byteBuffer4);
            int n17 = MipMap.gluScaleImage(n5, n10, n7, n6, byteBuffer2, n15, n14, n6, byteBuffer5);
            if (n17 != 0) {
                n11 = n17;
                bl = true;
            }
            byteBuffer2 = byteBuffer5;
            if (byteBuffer4 != null) {
                byteBuffer4 = byteBuffer3;
            }
            n10 = n15;
            n7 = n14;
            ++n13;
        }
        pixelStoreState.save();
        return n11;
    }

    public static int gluScaleImage(int n, int n2, int n3, int n4, ByteBuffer byteBuffer, int n5, int n6, int n7, ByteBuffer byteBuffer2) {
        int n8;
        int n9;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14 = MipMap.compPerPix(n);
        if (n14 == -1) {
            return 100900;
        }
        float[] fArray = new float[n2 * n3 * n14];
        float[] fArray2 = new float[n5 * n6 * n14];
        switch (n4) {
            case 5121: {
                n13 = 1;
                break;
            }
            case 5126: {
                n13 = 4;
                break;
            }
            default: {
                return 1280;
            }
        }
        switch (n7) {
            case 5121: {
                n12 = 1;
                break;
            }
            case 5126: {
                n12 = 4;
                break;
            }
            default: {
                return 1280;
            }
        }
        PixelStoreState pixelStoreState = new PixelStoreState();
        int n15 = pixelStoreState.unpackRowLength > 0 ? pixelStoreState.unpackRowLength : n2;
        int n16 = n13 >= pixelStoreState.unpackAlignment ? n14 * n15 : pixelStoreState.unpackAlignment / n13 * MipMap.ceil(n14 * n15 * n13, pixelStoreState.unpackAlignment);
        switch (n4) {
            case 5121: {
                int n17;
                n11 = 0;
                byteBuffer.rewind();
                for (n10 = 0; n10 < n3; ++n10) {
                    n17 = n10 * n16 + pixelStoreState.unpackSkipRows * n16 + pixelStoreState.unpackSkipPixels * n14;
                    for (n9 = 0; n9 < n2 * n14; ++n9) {
                        fArray[n11++] = byteBuffer.get(n17++) & 0xFF;
                    }
                }
                break;
            }
            case 5126: {
                int n17;
                n11 = 0;
                byteBuffer.rewind();
                for (n10 = 0; n10 < n3; ++n10) {
                    n17 = 4 * (n10 * n16 + pixelStoreState.unpackSkipRows * n16 + pixelStoreState.unpackSkipPixels * n14);
                    for (n9 = 0; n9 < n2 * n14; ++n9) {
                        fArray[n11++] = byteBuffer.getFloat(n17);
                        n17 += 4;
                    }
                }
                break;
            }
            default: {
                return 100900;
            }
        }
        float f = (float)n2 / (float)n5;
        float f2 = (float)n3 / (float)n6;
        float[] fArray3 = new float[n14];
        for (n8 = 0; n8 < n6; ++n8) {
            for (int i = 0; i < n5; ++i) {
                int n18;
                int n19;
                int n20 = (int)((float)i * f);
                int n21 = (int)((float)(i + 1) * f);
                int n22 = (int)((float)n8 * f2);
                int n23 = (int)((float)(n8 + 1) * f2);
                int n24 = 0;
                for (n19 = 0; n19 < n14; ++n19) {
                    fArray3[n19] = 0.0f;
                }
                for (n19 = n20; n19 < n21; ++n19) {
                    for (int j = n22; j < n23; ++j) {
                        n18 = (j * n2 + n19) * n14;
                        for (int k = 0; k < n14; ++k) {
                            int n25 = k;
                            fArray3[n25] = fArray3[n25] + fArray[n18 + k];
                        }
                        ++n24;
                    }
                }
                int n26 = (n8 * n5 + i) * n14;
                if (n24 == 0) {
                    n18 = (n22 * n2 + n20) * n14;
                    for (n19 = 0; n19 < n14; ++n19) {
                        fArray2[n26++] = fArray[n18 + n19];
                    }
                    continue;
                }
                for (n11 = 0; n11 < n14; ++n11) {
                    fArray2[n26++] = fArray3[n11] / (float)n24;
                }
            }
        }
        n15 = pixelStoreState.packRowLength > 0 ? pixelStoreState.packRowLength : n5;
        n16 = n12 >= pixelStoreState.packAlignment ? n14 * n15 : pixelStoreState.packAlignment / n12 * MipMap.ceil(n14 * n15 * n12, pixelStoreState.packAlignment);
        switch (n7) {
            case 5121: {
                n11 = 0;
                for (n10 = 0; n10 < n6; ++n10) {
                    n8 = n10 * n16 + pixelStoreState.packSkipRows * n16 + pixelStoreState.packSkipPixels * n14;
                    for (n9 = 0; n9 < n5 * n14; ++n9) {
                        byteBuffer2.put(n8++, (byte)fArray2[n11++]);
                    }
                }
                break;
            }
            case 5126: {
                n11 = 0;
                for (n10 = 0; n10 < n6; ++n10) {
                    n8 = 4 * (n10 * n16 + pixelStoreState.unpackSkipRows * n16 + pixelStoreState.unpackSkipPixels * n14);
                    for (n9 = 0; n9 < n5 * n14; ++n9) {
                        byteBuffer2.putFloat(n8, fArray2[n11++]);
                        n8 += 4;
                    }
                }
                break;
            }
            default: {
                return 100900;
            }
        }
        return 0;
    }
}

