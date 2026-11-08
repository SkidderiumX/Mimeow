/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Quadric;

public class PartialDisk
extends Quadric {
    private static final int CACHE_SIZE = 240;

    public void draw(float f, float f2, int n, int n2, float f3, float f4) {
        int n3;
        float[] fArray = new float[240];
        float[] fArray2 = new float[240];
        float f5 = 0.0f;
        float f6 = 0.0f;
        if (n >= 240) {
            n = 239;
        }
        if (n < 2 || n2 < 1 || f2 <= 0.0f || f < 0.0f || f > f2) {
            System.err.println("PartialDisk: GLU_INVALID_VALUE");
            return;
        }
        if (f4 < -360.0f) {
            f4 = 360.0f;
        }
        if (f4 > 360.0f) {
            f4 = 360.0f;
        }
        if (f4 < 0.0f) {
            f3 += f4;
            f4 = -f4;
        }
        int n4 = f4 == 360.0f ? n : n + 1;
        float f7 = f2 - f;
        float f8 = f3 / 180.0f * (float)Math.PI;
        for (n3 = 0; n3 <= n; ++n3) {
            float f9 = f8 + (float)Math.PI * f4 / 180.0f * (float)n3 / (float)n;
            fArray[n3] = this.sin(f9);
            fArray2[n3] = this.cos(f9);
        }
        if (f4 == 360.0f) {
            fArray[n] = fArray[0];
            fArray2[n] = fArray2[0];
        }
        switch (this.normals) {
            case 100000: 
            case 100001: {
                if (this.orientation == 100020) {
                    GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                    break;
                }
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                break;
            }
        }
        block3 : switch (this.drawStyle) {
            case 100012: {
                float f10;
                int n5;
                if (f == 0.0f) {
                    n5 = n2 - 1;
                    GL11.glBegin(6);
                    if (this.textureFlag) {
                        GL11.glTexCoord2f(0.5f, 0.5f);
                    }
                    GL11.glVertex3f(0.0f, 0.0f, 0.0f);
                    f10 = f2 - f7 * ((float)(n2 - 1) / (float)n2);
                    if (this.textureFlag) {
                        f5 = f10 / f2 / 2.0f;
                    }
                    if (this.orientation == 100020) {
                        for (n3 = n; n3 >= 0; --n3) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                            }
                            GL11.glVertex3f(f10 * fArray[n3], f10 * fArray2[n3], 0.0f);
                        }
                    } else {
                        for (n3 = 0; n3 <= n; ++n3) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                            }
                            GL11.glVertex3f(f10 * fArray[n3], f10 * fArray2[n3], 0.0f);
                        }
                    }
                    GL11.glEnd();
                } else {
                    n5 = n2;
                }
                for (int i = 0; i < n5; ++i) {
                    f10 = f2 - f7 * ((float)i / (float)n2);
                    float f11 = f2 - f7 * ((float)(i + 1) / (float)n2);
                    if (this.textureFlag) {
                        f5 = f10 / f2 / 2.0f;
                        f6 = f11 / f2 / 2.0f;
                    }
                    GL11.glBegin(8);
                    for (n3 = 0; n3 <= n; ++n3) {
                        if (this.orientation == 100020) {
                            if (this.textureFlag) {
                                GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                            }
                            GL11.glVertex3f(f10 * fArray[n3], f10 * fArray2[n3], 0.0f);
                            if (this.textureFlag) {
                                GL11.glTexCoord2f(f6 * fArray[n3] + 0.5f, f6 * fArray2[n3] + 0.5f);
                            }
                            GL11.glVertex3f(f11 * fArray[n3], f11 * fArray2[n3], 0.0f);
                            continue;
                        }
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(f6 * fArray[n3] + 0.5f, f6 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f11 * fArray[n3], f11 * fArray2[n3], 0.0f);
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f10 * fArray[n3], f10 * fArray2[n3], 0.0f);
                    }
                    GL11.glEnd();
                }
                break;
            }
            case 100010: {
                GL11.glBegin(0);
                for (n3 = 0; n3 < n4; ++n3) {
                    float f12 = fArray[n3];
                    float f13 = fArray2[n3];
                    for (int i = 0; i <= n2; ++i) {
                        float f14 = f2 - f7 * ((float)i / (float)n2);
                        if (this.textureFlag) {
                            f5 = f14 / f2 / 2.0f;
                            GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f14 * f12, f14 * f13, 0.0f);
                    }
                }
                GL11.glEnd();
                break;
            }
            case 100011: {
                float f15;
                int n6;
                if (f == f2) {
                    GL11.glBegin(3);
                    for (n3 = 0; n3 <= n; ++n3) {
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(fArray[n3] / 2.0f + 0.5f, fArray2[n3] / 2.0f + 0.5f);
                        }
                        GL11.glVertex3f(f * fArray[n3], f * fArray2[n3], 0.0f);
                    }
                    GL11.glEnd();
                    break;
                }
                for (n6 = 0; n6 <= n2; ++n6) {
                    f15 = f2 - f7 * ((float)n6 / (float)n2);
                    if (this.textureFlag) {
                        f5 = f15 / f2 / 2.0f;
                    }
                    GL11.glBegin(3);
                    for (n3 = 0; n3 <= n; ++n3) {
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f15 * fArray[n3], f15 * fArray2[n3], 0.0f);
                    }
                    GL11.glEnd();
                }
                for (n3 = 0; n3 < n4; ++n3) {
                    float f16 = fArray[n3];
                    float f17 = fArray2[n3];
                    GL11.glBegin(3);
                    for (n6 = 0; n6 <= n2; ++n6) {
                        f15 = f2 - f7 * ((float)n6 / (float)n2);
                        if (this.textureFlag) {
                            f5 = f15 / f2 / 2.0f;
                        }
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f15 * f16, f15 * f17, 0.0f);
                    }
                    GL11.glEnd();
                }
                break;
            }
            case 100013: {
                float f18;
                int n7;
                if (f4 < 360.0f) {
                    for (n3 = 0; n3 <= n; n3 += n) {
                        float f19 = fArray[n3];
                        float f20 = fArray2[n3];
                        GL11.glBegin(3);
                        for (n7 = 0; n7 <= n2; ++n7) {
                            f18 = f2 - f7 * ((float)n7 / (float)n2);
                            if (this.textureFlag) {
                                f5 = f18 / f2 / 2.0f;
                                GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                            }
                            GL11.glVertex3f(f18 * f19, f18 * f20, 0.0f);
                        }
                        GL11.glEnd();
                    }
                }
                for (n7 = 0; n7 <= n2; n7 += n2) {
                    f18 = f2 - f7 * ((float)n7 / (float)n2);
                    if (this.textureFlag) {
                        f5 = f18 / f2 / 2.0f;
                    }
                    GL11.glBegin(3);
                    for (n3 = 0; n3 <= n; ++n3) {
                        if (this.textureFlag) {
                            GL11.glTexCoord2f(f5 * fArray[n3] + 0.5f, f5 * fArray2[n3] + 0.5f);
                        }
                        GL11.glVertex3f(f18 * fArray[n3], f18 * fArray2[n3], 0.0f);
                    }
                    GL11.glEnd();
                    if (f == f2) break block3;
                }
                break;
            }
        }
    }
}

