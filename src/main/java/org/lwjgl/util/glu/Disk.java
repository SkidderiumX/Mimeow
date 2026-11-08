/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Quadric;

public class Disk
extends Quadric {
    public void draw(float f, float f2, int n, int n2) {
        if (this.normals != 100002) {
            if (this.orientation == 100020) {
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
            } else {
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
            }
        }
        float f3 = (float)Math.PI * 2 / (float)n;
        float f4 = (f2 - f) / (float)n2;
        switch (this.drawStyle) {
            case 100012: {
                float f5 = 2.0f * f2;
                float f6 = f;
                for (int i = 0; i < n2; ++i) {
                    float f7 = f6 + f4;
                    if (this.orientation == 100020) {
                        GL11.glBegin(8);
                        for (var13_28 = 0; var13_28 <= n; ++var13_28) {
                            var14_29 = var13_28 == n ? 0.0f : (float)var13_28 * f3;
                            var8_17 = this.sin(var14_29);
                            var9_21 = this.cos(var14_29);
                            this.TXTR_COORD(0.5f + var8_17 * f7 / f5, 0.5f + var9_21 * f7 / f5);
                            GL11.glVertex2f(f7 * var8_17, f7 * var9_21);
                            this.TXTR_COORD(0.5f + var8_17 * f6 / f5, 0.5f + var9_21 * f6 / f5);
                            GL11.glVertex2f(f6 * var8_17, f6 * var9_21);
                        }
                        GL11.glEnd();
                    } else {
                        GL11.glBegin(8);
                        for (var13_28 = n; var13_28 >= 0; --var13_28) {
                            var14_29 = var13_28 == n ? 0.0f : (float)var13_28 * f3;
                            var8_17 = this.sin(var14_29);
                            var9_21 = this.cos(var14_29);
                            this.TXTR_COORD(0.5f - var8_17 * f7 / f5, 0.5f + var9_21 * f7 / f5);
                            GL11.glVertex2f(f7 * var8_17, f7 * var9_21);
                            this.TXTR_COORD(0.5f - var8_17 * f6 / f5, 0.5f + var9_21 * f6 / f5);
                            GL11.glVertex2f(f6 * var8_17, f6 * var9_21);
                        }
                        GL11.glEnd();
                    }
                    f6 = f7;
                }
                break;
            }
            case 100011: {
                float f8;
                int n3;
                float f9;
                int n4;
                for (n4 = 0; n4 <= n2; ++n4) {
                    f9 = f + (float)n4 * f4;
                    GL11.glBegin(2);
                    for (n3 = 0; n3 < n; ++n3) {
                        f8 = (float)n3 * f3;
                        GL11.glVertex2f(f9 * this.sin(f8), f9 * this.cos(f8));
                    }
                    GL11.glEnd();
                }
                for (n3 = 0; n3 < n; ++n3) {
                    f9 = (float)n3 * f3;
                    f8 = this.sin(f9);
                    float f10 = this.cos(f9);
                    GL11.glBegin(3);
                    for (n4 = 0; n4 <= n2; ++n4) {
                        float f11 = f + (float)n4 * f4;
                        GL11.glVertex2f(f11 * f8, f11 * f10);
                    }
                    GL11.glEnd();
                }
                break;
            }
            case 100010: {
                GL11.glBegin(0);
                for (int i = 0; i < n; ++i) {
                    float f12 = (float)i * f3;
                    float f13 = this.sin(f12);
                    float f14 = this.cos(f12);
                    for (int j = 0; j <= n2; ++j) {
                        float f15 = f * (float)j * f4;
                        GL11.glVertex2f(f15 * f13, f15 * f14);
                    }
                }
                GL11.glEnd();
                break;
            }
            case 100013: {
                float f16;
                float f17;
                float f18;
                if ((double)f != 0.0) {
                    GL11.glBegin(2);
                    f18 = 0.0f;
                    while ((double)f18 < 6.2831854820251465) {
                        f17 = f * this.sin(f18);
                        f16 = f * this.cos(f18);
                        GL11.glVertex2f(f17, f16);
                        f18 += f3;
                    }
                    GL11.glEnd();
                }
                GL11.glBegin(2);
                for (f18 = 0.0f; f18 < (float)Math.PI * 2; f18 += f3) {
                    f17 = f2 * this.sin(f18);
                    f16 = f2 * this.cos(f18);
                    GL11.glVertex2f(f17, f16);
                }
                GL11.glEnd();
                break;
            }
            default: {
                return;
            }
        }
    }
}

