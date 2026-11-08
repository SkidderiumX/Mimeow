/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc24a0a5bddf;
import x.oc2cf3d80e17;
import x.oc5f2027353d;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.ocbd4917c4b1;
import x.ocebe35f25d6;

public class oc74d4657d04
extends oc6c12eede72 {
    public oc24a0a5bddf \u0565;
    private ocebe35f25d6 \u0474;
    public float \u0507;
    public float \u0447;
    private float \u04c9;
    public float \u04d9;
    public boolean \u0583;
    private int \u03a9;
    private float \u054e;
    private float \u045e;
    private float x;
    private oc5f2027353d \u0293;
    private float \u03e5;
    private float \u053f;
    private float \u03a1;
    private static final float \u053c = 250.0f;
    private static final float \u01b4 = 12.0f;
    private static final float \u0537 = 50.0f;
    private static final float \u03d6 = 10.0f;
    private static final float \u01bc = 4.0f;
    private static final float \u0455 = 0.001f;
    private static final float \u0197 = 0.001f;
    private static final float \u0423 = 10.0f;
    private static final float \u0480 = 4.0f;
    private static final float \u0267 = 2.0f;
    private static final float \u0280 = 2.0f;
    private static final int \u0392 = 20;
    private static final float \u051a = 5.0f;

    public oc74d4657d04(oc24a0a5bddf oc24a0a5bddf2, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u0565 = oc24a0a5bddf2;
        this.\u0474 = ocebe35f25d62;
        this.\u0507 = f;
        this.\u03e5 = 0.0f;
        this.\u053f = 0.0f;
        this.\u03a1 = 0.0f;
    }

    public float \u019d() {
        return 66.0f;
    }

    public float \u01e2() {
        if (this.\u0293 != null) {
            if ((float)(System.currentTimeMillis() - this.\u0293.\u0445) >= 280.0f) {
                this.\u0293 = null;
                this.\u03e5 = this.\u03a1;
                this.\u053f = this.\u03a1;
            } else {
                this.\u03e5 = this.\u0293.\u01df(this.\u053f, this.\u03a1, 1);
                if (this.\u03e5 == this.\u03a1) {
                    this.\u0293 = null;
                    this.\u053f = this.\u03a1;
                }
            }
        }
        return this.\u03e5;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        float f;
        float f2;
        float f3 = this.\u0474.\u02a4.\u01a9();
        float f4 = this.\u0474.\u02a4.\u0406();
        float f5 = this.\u0474.\u02a4.\u0232();
        float f6 = f3 + 4.0f + this.\u04d9 / 2.0f;
        float f7 = f4 + this.\u0507 + 3.0f;
        ocbd4917c4b1.\u0109((double)f6 - 0.5, (double)f7 - 0.5, (double)(f6 + 5.0f) + 0.5, (double)(f7 + 5.0f) + 0.5, 0x45F0C15B ^ 0xBACCFD1D);
        if (this.\u0565.\u0169()) {
            int n = 0xBACCFD1F ^ 0xBACCFD1D;
            for (f2 = f6; f2 < f6 + 5.0f; f2 += (float)n) {
                for (f = f7; f < f7 + 5.0f; f += (float)n) {
                    int n2 = ((int)((f2 - f6) / (float)n) + (int)((f - f7) / (float)n)) % (0xBACCFD1F ^ 0xBACCFD1D) == 0 ? 0x45AA9B7B ^ 0xBACCFD1D : 0x45556484 ^ 0xBACCFD1D;
                    ocbd4917c4b1.\u0109(f2, f, Math.min(f2 + (float)n, f6 + 5.0f), Math.min(f + (float)n, f7 + 5.0f), n2);
                }
            }
        }
        ocbd4917c4b1.\u0109(f6, f7, f6 + 5.0f, f7 + 5.0f, this.\u0565.\u0373());
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        f2 = oc1378bc114d2.z$toz8pt08w0nc("[+]  ");
        oc1378bc114d2.z$ao2ykh4tuw6w(this.\u0565.z$18nrktuqeiysv(), (f3 + 4.0f) * 2.0f + this.\u04d9 + f2, (f4 + this.\u0507 + 4.0f) * 2.0f, -1, true);
        GL11.glPopMatrix();
        f = this.\u01e2();
        if (f <= 0.0f) {
            return;
        }
        float f8 = this.\u0474.\u02a4.\u0248 - f4;
        float f9 = f4 + this.\u0507 + 12.0f + f8;
        float f10 = (this.\u019d() - 12.0f) * f;
        ocbd4917c4b1.\u010e(f3, f9, f5, f10);
        this.\u0522(f3, f4);
        ocbd4917c4b1.\u01df();
    }

    private void \u0522(float f, float f2) {
        int n;
        float f3;
        float f4;
        boolean bl;
        float f5 = f + 4.0f + this.\u04d9 / 2.0f;
        float f6 = f2 + this.\u0507 + 12.0f + 2.0f;
        float f7 = f5 + 50.0f;
        float f8 = f6 + 50.0f;
        float f9 = this.\u03a9 != 0 ? this.x : this.\u0565.\u0532();
        float f10 = this.\u03a9 != 0 ? this.\u045e : this.\u0565.\u0457();
        boolean bl2 = f9 < 0.001f;
        boolean bl3 = bl = f10 < 0.001f;
        if (this.\u03a9 == 0 && !bl2) {
            this.x = f9;
            this.\u045e = this.\u0565.\u0457();
            if (!bl) {
                this.\u054e = this.\u0565.\u0410();
            }
        }
        boolean bl4 = this.\u03a9 != 0 || bl2 || bl;
        float f11 = bl4 ? this.\u054e / 360.0f : this.\u0565.\u0410() / 360.0f;
        float f12 = this.\u03a9 != 0 || bl2 ? this.\u045e : f10;
        int n2 = Color.HSBtoRGB(f11, 1.0f, 1.0f) | 0xB07CC975 ^ 0x4F7CC975;
        ocbd4917c4b1.\u0109(f5, f6, f7, f8, n2);
        ocbd4917c4b1.\u014e(f5, f6, f7, f8, -1, 0x4F83368A ^ 0x4F7CC975);
        ocbd4917c4b1.\u01ba(f5, f6, f7, f8, 0, 0xB07CC975 ^ 0x4F7CC975);
        ocbd4917c4b1.\u03d8(f5 - 1.0f, f6 - 1.0f, f7 + 1.0f, f8 + 1.0f, 1.0f, 0xB040F533 ^ 0x4F7CC975);
        float f13 = f5 + f12 * 50.0f;
        float f14 = f6 + (1.0f - f9) * 50.0f;
        ocbd4917c4b1.\u0109(f13 - 2.0f, f14, f13 + 3.0f, f14 + 1.0f, -1);
        ocbd4917c4b1.\u0109(f13, f14 - 2.0f, f13 + 1.0f, f14 + 3.0f, -1);
        float f15 = f7 + 4.0f;
        float f16 = f15 + 10.0f;
        float f17 = 2.5f;
        for (int i = 0; i < (0x4F7CC961 ^ 0x4F7CC975); ++i) {
            f4 = (float)i / 20.0f;
            f3 = (float)(i + 1) / 20.0f;
            n = Color.HSBtoRGB(f4, 1.0f, 1.0f) | 0xB07CC975 ^ 0x4F7CC975;
            int n3 = Color.HSBtoRGB(f3, 1.0f, 1.0f) | 0xB07CC975 ^ 0x4F7CC975;
            ocbd4917c4b1.\u01ba(f15, f6 + (float)i * f17, f16, f6 + (float)(i + 1) * f17, n, n3);
        }
        ocbd4917c4b1.\u03d8(f15 - 1.0f, f6 - 1.0f, f16 + 1.0f, f8 + 1.0f, 1.0f, 0xB040F533 ^ 0x4F7CC975);
        float f18 = f6 + Math.max(0.0f, Math.min(1.0f, f11)) * 50.0f;
        ocbd4917c4b1.\u0109(f15 - 1.0f, f18 - 1.0f, f16 + 1.0f, f18 + 2.0f, -1);
        if (this.\u0565.\u0169()) {
            float f19;
            f4 = f16 + 4.0f;
            f3 = f4 + 10.0f;
            n = 0x4F7CC971 ^ 0x4F7CC975;
            for (float f20 = f4; f20 < f3; f20 += (float)n) {
                for (f19 = f6; f19 < f8; f19 += (float)n) {
                    int n4 = ((int)((f20 - f4) / (float)n) + (int)((f19 - f6) / (float)n)) % (0x4F7CC977 ^ 0x4F7CC975) == 0 ? 0xB01AAF13 ^ 0x4F7CC975 : 0xB0E550EC ^ 0x4F7CC975;
                    ocbd4917c4b1.\u0109(f20, f19, Math.min(f20 + (float)n, f3), Math.min(f19 + (float)n, f8), n4);
                }
            }
            int n5 = this.\u0565.\u01d0();
            ocbd4917c4b1.\u01ba(f4, f6, f3, f8, n5 & (0x4F83368A ^ 0x4F7CC975), n5 | 0xB07CC975 ^ 0x4F7CC975);
            ocbd4917c4b1.\u03d8(f4 - 1.0f, f6 - 1.0f, f3 + 1.0f, f8 + 1.0f, 1.0f, 0xB040F533 ^ 0x4F7CC975);
            f19 = (float)this.\u0565.\u01e2() / 255.0f;
            float f21 = f6 + f19 * 50.0f;
            ocbd4917c4b1.\u0109(f4 - 1.0f, f21 - 1.0f, f3 + 1.0f, f21 + 2.0f, -1);
        }
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u04c9 = this.\u0474.\u02a4.\u0523() + this.\u0507;
        this.\u0447 = this.\u0474.\u02a4.\u01a9();
        if (this.\u03a9 == 0 || this.\u01e2() < 1.0f) {
            return;
        }
        float f = this.\u0447 + 4.0f + this.\u04d9 / 2.0f;
        float f2 = this.\u04c9 + 12.0f + 2.0f;
        float f3 = f + 50.0f;
        float f4 = f2 + 50.0f;
        float f5 = f3 + 4.0f;
        float f6 = f5 + 10.0f;
        if (this.\u03a9 == 1) {
            this.\u045e = Math.max(0.0f, Math.min(1.0f, ((float)n - f) / 50.0f));
            this.x = Math.max(0.0f, Math.min(1.0f, 1.0f - ((float)n2 - f2) / 50.0f));
            this.\u0565.\u0205(this.\u054e, this.\u045e, this.x);
            this.\u0388();
        } else if (this.\u03a9 == (0x8BFA3BD5 ^ 0x8BFA3BD7)) {
            this.\u054e = Math.max(0.0f, Math.min(360.0f, ((float)n2 - f2) / 50.0f * 360.0f));
            this.\u0565.\u0205(this.\u054e, this.\u045e, this.x);
            this.\u0388();
        } else if (this.\u03a9 == (0x8BFA3BD4 ^ 0x8BFA3BD7) && this.\u0565.\u0169()) {
            float f7 = Math.max(0.0f, Math.min(1.0f, ((float)n2 - f2) / 50.0f));
            this.\u0565.\u0518((int)(f7 * 255.0f));
            this.\u0388();
        }
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!this.\u0474.\u0224 || !this.\u0474.\u047c(this)) {
            return false;
        }
        float f = this.\u0474.\u02a4.\u0232();
        if ((float)n > this.\u0447 && (float)n < this.\u0447 + f && (float)n2 > this.\u04c9 && (float)n2 < this.\u04c9 + 12.0f && (n3 == 0 || n3 == 1)) {
            float f2;
            this.\u053f = f2 = this.\u01e2();
            this.\u0583 = !this.\u0583;
            this.\u03a1 = this.\u0583 ? 1.0f : 0.0f;
            this.\u0293 = new oc5f2027353d(250.0f);
            this.\u0293.\u039e();
            this.\u0474.\u01e3();
            return true;
        }
        if (n3 != 0) {
            return false;
        }
        if (this.\u01e2() < 1.0f) {
            return false;
        }
        float f3 = this.\u0447 + 4.0f + this.\u04d9 / 2.0f;
        float f4 = this.\u04c9 + 12.0f + 2.0f;
        float f5 = f3 + 50.0f;
        float f6 = f4 + 50.0f;
        float f7 = f5 + 4.0f;
        float f8 = f7 + 10.0f;
        if ((float)n >= f3 && (float)n <= f5 && (float)n2 >= f4 && (float)n2 <= f6) {
            this.\u03ac();
            this.\u03a9 = 1;
            return false;
        }
        if ((float)n >= f7 - 2.0f && (float)n <= f8 + 2.0f && (float)n2 >= f4 && (float)n2 <= f6) {
            this.\u03ac();
            this.\u03a9 = 0xD5CF4CEE ^ 0xD5CF4CEC;
            return false;
        }
        if (this.\u0565.\u0169()) {
            float f9 = f8 + 4.0f;
            float f10 = f9 + 10.0f;
            if ((float)n >= f9 - 2.0f && (float)n <= f10 + 2.0f && (float)n2 >= f4 && (float)n2 <= f6) {
                this.\u03ac();
                this.\u03a9 = 0xD5CF4CEF ^ 0xD5CF4CEC;
                return false;
            }
        }
        return false;
    }

    @Override
    public void z$1n0m425nu1zvd(int n, int n2, int n3) {
        this.\u03a9 = 0;
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u03a9 = 0;
        this.\u0293 = null;
        this.\u053f = this.\u03e5 = this.\u0583 ? 1.0f : 0.0f;
        this.\u03a1 = this.\u03e5;
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u0507 = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u0507;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u0565.\u04c0;
    }

    public void \u0506(boolean bl) {
        this.\u0583 = bl;
        this.\u0293 = null;
        this.\u053f = this.\u03e5 = bl ? 1.0f : 0.0f;
        this.\u03a1 = this.\u03e5;
    }

    private void \u03ac() {
        float f = this.\u0565.\u0532();
        float f2 = this.\u0565.\u0457();
        this.x = f;
        if (f >= 0.001f) {
            this.\u045e = f2;
            if (f2 >= 0.001f) {
                this.\u054e = this.\u0565.\u0410();
            }
        }
    }

    private void \u0388() {
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }
}

