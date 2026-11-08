/*
 * Decompiled with CFR 0.152.
 */
package org.lwjgl.util.glu;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Quadric;

public class Sphere
extends Quadric {
    public void draw(float f, int n, int n2) {
        boolean bl = this.normals != 100002;
        float f2 = this.orientation == 100021 ? -1.0f : 1.0f;
        float f3 = (float)Math.PI / (float)n2;
        float f4 = (float)Math.PI * 2 / (float)n;
        if (this.drawStyle == 100012) {
            float f5;
            float f6;
            int n3;
            float f7;
            float f8;
            float f9;
            float f10;
            int n4;
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, 1.0f);
                GL11.glVertex3f(0.0f, 0.0f, f2 * f);
                for (n4 = 0; n4 <= n; ++n4) {
                    f10 = n4 == n ? 0.0f : (float)n4 * f4;
                    f9 = -this.sin(f10) * this.sin(f3);
                    f8 = this.cos(f10) * this.sin(f3);
                    f7 = f2 * this.cos(f3);
                    if (bl) {
                        GL11.glNormal3f(f9 * f2, f8 * f2, f7 * f2);
                    }
                    GL11.glVertex3f(f9 * f, f8 * f, f7 * f);
                }
                GL11.glEnd();
            }
            float f11 = 1.0f / (float)n;
            float f12 = 1.0f / (float)n2;
            float f13 = 1.0f;
            if (this.textureFlag) {
                var17_26 = 0;
                n3 = n2;
            } else {
                var17_26 = 1;
                n3 = n2 - 1;
            }
            for (int i = var17_26; i < n3; ++i) {
                f6 = (float)i * f3;
                GL11.glBegin(8);
                f5 = 0.0f;
                for (n4 = 0; n4 <= n; ++n4) {
                    f10 = n4 == n ? 0.0f : (float)n4 * f4;
                    f9 = -this.sin(f10) * this.sin(f6);
                    f8 = this.cos(f10) * this.sin(f6);
                    f7 = f2 * this.cos(f6);
                    if (bl) {
                        GL11.glNormal3f(f9 * f2, f8 * f2, f7 * f2);
                    }
                    this.TXTR_COORD(f5, f13);
                    GL11.glVertex3f(f9 * f, f8 * f, f7 * f);
                    f9 = -this.sin(f10) * this.sin(f6 + f3);
                    f8 = this.cos(f10) * this.sin(f6 + f3);
                    f7 = f2 * this.cos(f6 + f3);
                    if (bl) {
                        GL11.glNormal3f(f9 * f2, f8 * f2, f7 * f2);
                    }
                    this.TXTR_COORD(f5, f13 - f12);
                    f5 += f11;
                    GL11.glVertex3f(f9 * f, f8 * f, f7 * f);
                }
                GL11.glEnd();
                f13 -= f12;
            }
            if (!this.textureFlag) {
                GL11.glBegin(6);
                GL11.glNormal3f(0.0f, 0.0f, -1.0f);
                GL11.glVertex3f(0.0f, 0.0f, -f * f2);
                f6 = (float)Math.PI - f3;
                f5 = 1.0f;
                for (n4 = n; n4 >= 0; --n4) {
                    f10 = n4 == n ? 0.0f : (float)n4 * f4;
                    f9 = -this.sin(f10) * this.sin(f6);
                    f8 = this.cos(f10) * this.sin(f6);
                    f7 = f2 * this.cos(f6);
                    if (bl) {
                        GL11.glNormal3f(f9 * f2, f8 * f2, f7 * f2);
                    }
                    f5 -= f11;
                    GL11.glVertex3f(f9 * f, f8 * f, f7 * f);
                }
                GL11.glEnd();
            }
        } else if (this.drawStyle == 100011 || this.drawStyle == 100013) {
            float f14;
            float f15;
            float f16;
            float f17;
            int n5;
            float f18;
            int n6;
            for (n6 = 1; n6 < n2; ++n6) {
                f18 = (float)n6 * f3;
                GL11.glBegin(2);
                for (n5 = 0; n5 < n; ++n5) {
                    f17 = (float)n5 * f4;
                    f16 = this.cos(f17) * this.sin(f18);
                    f15 = this.sin(f17) * this.sin(f18);
                    f14 = this.cos(f18);
                    if (bl) {
                        GL11.glNormal3f(f16 * f2, f15 * f2, f14 * f2);
                    }
                    GL11.glVertex3f(f16 * f, f15 * f, f14 * f);
                }
                GL11.glEnd();
            }
            for (n5 = 0; n5 < n; ++n5) {
                f17 = (float)n5 * f4;
                GL11.glBegin(3);
                for (n6 = 0; n6 <= n2; ++n6) {
                    f18 = (float)n6 * f3;
                    f16 = this.cos(f17) * this.sin(f18);
                    f15 = this.sin(f17) * this.sin(f18);
                    f14 = this.cos(f18);
                    if (bl) {
                        GL11.glNormal3f(f16 * f2, f15 * f2, f14 * f2);
                    }
                    GL11.glVertex3f(f16 * f, f15 * f, f14 * f);
                }
                GL11.glEnd();
            }
        } else if (this.drawStyle == 100010) {
            GL11.glBegin(0);
            if (bl) {
                GL11.glNormal3f(0.0f, 0.0f, f2);
            }
            GL11.glVertex3f(0.0f, 0.0f, f);
            if (bl) {
                GL11.glNormal3f(0.0f, 0.0f, -f2);
            }
            GL11.glVertex3f(0.0f, 0.0f, -f);
            for (int i = 1; i < n2 - 1; ++i) {
                float f19 = (float)i * f3;
                for (int j = 0; j < n; ++j) {
                    float f20 = (float)j * f4;
                    float f21 = this.cos(f20) * this.sin(f19);
                    float f22 = this.sin(f20) * this.sin(f19);
                    float f23 = this.cos(f19);
                    if (bl) {
                        GL11.glNormal3f(f21 * f2, f22 * f2, f23 * f2);
                    }
                    GL11.glVertex3f(f21 * f, f22 * f, f23 * f);
                }
            }
            GL11.glEnd();
        }
    }
}

