/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Quadric;

public class Cylinder
extends Quadric {
    public void draw(float f, float f2, float f3, int n, int n2) {
        float f4 = this.orientation == 100021 ? -1.0f : 1.0f;
        float f5 = (float)Math.PI * 2 / (float)n;
        float f6 = (f2 - f) / (float)n2;
        float f7 = f3 / (float)n2;
        float f8 = (f - f2) / f3;
        if (this.drawStyle == 100010) {
            GL11.glBegin(0);
            for (int i = 0; i < n; ++i) {
                float f9 = this.cos((float)i * f5);
                float f10 = this.sin((float)i * f5);
                this.normal3f(f9 * f4, f10 * f4, f8 * f4);
                float f11 = 0.0f;
                float f12 = f;
                for (int j = 0; j <= n2; ++j) {
                    GL11.glVertex3f(f9 * f12, f10 * f12, f11);
                    f11 += f7;
                    f12 += f6;
                }
            }
            GL11.glEnd();
        } else if (this.drawStyle == 100011 || this.drawStyle == 100013) {
            float f13;
            float f14;
            int n3;
            if (this.drawStyle == 100011) {
                float f15 = 0.0f;
                float f16 = f;
                for (int i = 0; i <= n2; ++i) {
                    GL11.glBegin(2);
                    for (n3 = 0; n3 < n; ++n3) {
                        f14 = this.cos((float)n3 * f5);
                        f13 = this.sin((float)n3 * f5);
                        this.normal3f(f14 * f4, f13 * f4, f8 * f4);
                        GL11.glVertex3f(f14 * f16, f13 * f16, f15);
                    }
                    GL11.glEnd();
                    f15 += f7;
                    f16 += f6;
                }
            } else if ((double)f != 0.0) {
                GL11.glBegin(2);
                for (n3 = 0; n3 < n; ++n3) {
                    f14 = this.cos((float)n3 * f5);
                    f13 = this.sin((float)n3 * f5);
                    this.normal3f(f14 * f4, f13 * f4, f8 * f4);
                    GL11.glVertex3f(f14 * f, f13 * f, 0.0f);
                }
                GL11.glEnd();
                GL11.glBegin(2);
                for (n3 = 0; n3 < n; ++n3) {
                    f14 = this.cos((float)n3 * f5);
                    f13 = this.sin((float)n3 * f5);
                    this.normal3f(f14 * f4, f13 * f4, f8 * f4);
                    GL11.glVertex3f(f14 * f2, f13 * f2, f3);
                }
                GL11.glEnd();
            }
            GL11.glBegin(1);
            for (n3 = 0; n3 < n; ++n3) {
                f14 = this.cos((float)n3 * f5);
                f13 = this.sin((float)n3 * f5);
                this.normal3f(f14 * f4, f13 * f4, f8 * f4);
                GL11.glVertex3f(f14 * f, f13 * f, 0.0f);
                GL11.glVertex3f(f14 * f2, f13 * f2, f3);
            }
            GL11.glEnd();
        } else if (this.drawStyle == 100012) {
            float f17 = 1.0f / (float)n;
            float f18 = 1.0f / (float)n2;
            float f19 = 0.0f;
            float f20 = 0.0f;
            float f21 = f;
            for (int i = 0; i < n2; ++i) {
                float f22 = 0.0f;
                GL11.glBegin(8);
                for (int j = 0; j <= n; ++j) {
                    float f23;
                    float f24;
                    if (j == n) {
                        f24 = this.sin(0.0f);
                        f23 = this.cos(0.0f);
                    } else {
                        f24 = this.sin((float)j * f5);
                        f23 = this.cos((float)j * f5);
                    }
                    if (f4 == 1.0f) {
                        this.normal3f(f24 * f4, f23 * f4, f8 * f4);
                        this.TXTR_COORD(f22, f19);
                        GL11.glVertex3f(f24 * f21, f23 * f21, f20);
                        this.normal3f(f24 * f4, f23 * f4, f8 * f4);
                        this.TXTR_COORD(f22, f19 + f18);
                        GL11.glVertex3f(f24 * (f21 + f6), f23 * (f21 + f6), f20 + f7);
                    } else {
                        this.normal3f(f24 * f4, f23 * f4, f8 * f4);
                        this.TXTR_COORD(f22, f19);
                        GL11.glVertex3f(f24 * f21, f23 * f21, f20);
                        this.normal3f(f24 * f4, f23 * f4, f8 * f4);
                        this.TXTR_COORD(f22, f19 + f18);
                        GL11.glVertex3f(f24 * (f21 + f6), f23 * (f21 + f6), f20 + f7);
                    }
                    f22 += f17;
                }
                GL11.glEnd();
                f21 += f6;
                f19 += f18;
                f20 += f7;
            }
        }
    }
}

