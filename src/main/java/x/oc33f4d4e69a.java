/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc5f2027353d;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.occc831eff22;
import x.ocebe35f25d6;

public class oc33f4d4e69a
extends oc6c12eede72 {
    public occc831eff22 \u018d;
    private ocebe35f25d6 \u0280;
    public float \u0404;
    private float \u051b;
    private float \u0121;
    public boolean \u04c4;
    private oc5f2027353d \u053e;
    private float \u050b;
    private float V;
    private float \u027b;
    private static final float \u0464 = 250.0f;

    public oc33f4d4e69a(occc831eff22 occc831eff222, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u018d = occc831eff222;
        this.\u0280 = ocebe35f25d62;
        this.\u0404 = f;
        this.\u051b = ocebe35f25d62.\u02a4.\u01a9() + ocebe35f25d62.\u02a4.\u0232();
        this.\u0121 = ocebe35f25d62.\u02a4.\u0406() + ocebe35f25d62.\u0182;
        this.\u04c4 = occc831eff222.\u01ab();
        this.V = this.\u050b = this.\u04c4 ? 1.0f : 0.0f;
        this.\u027b = this.\u050b;
    }

    public float \u042c() {
        if (this.\u053e != null) {
            if ((float)(System.currentTimeMillis() - this.\u053e.\u0445) >= 280.0f) {
                this.\u053e = null;
                this.\u050b = this.\u027b;
                this.V = this.\u027b;
            } else {
                this.\u050b = this.\u053e.\u01df(this.V, this.\u027b, 1);
                if (this.\u050b == this.\u027b) {
                    this.\u053e = null;
                    this.V = this.\u027b;
                }
            }
        }
        return this.\u050b;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        float f = this.\u042c();
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        float f2 = (this.\u0280.\u02a4.\u01a9() + 4.0f) * 2.0f + 1.0f;
        float f3 = (this.\u0280.\u02a4.\u0406() + this.\u0404 + 4.0f) * 2.0f;
        if (f > 0.0f) {
            this.\u047c(oc1378bc114d2, "[", f2, f3);
            int n = oc1378bc114d2.z$toz8pt08w0nc("[");
            int n2 = oc1378bc114d2.z$toz8pt08w0nc(">");
            int n3 = oc1378bc114d2.z$1tqmx4tpnr6lq();
            GL11.glPushMatrix();
            GL11.glTranslatef(f2, f3, 0.0f);
            float f4 = n - (0x19E2EFE0 ^ 0x19E2EFE2);
            GL11.glTranslatef(f4 + (float)n2 / 2.0f, (float)n3 / 2.0f, 0.0f);
            GL11.glRotatef(90.0f * f, 0.0f, 0.0f, 1.0f);
            GL11.glTranslatef(-((float)n2 / 2.0f), -((float)n3 / 2.0f), 0.0f);
            this.\u047c(oc1378bc114d2, ">", 0.0f, 0.0f);
            GL11.glPopMatrix();
            this.\u047c(oc1378bc114d2, "]  " + this.\u018d.z$18nrktuqeiysv(), f2 + (float)n + (float)n2, f3);
        } else {
            this.\u047c(oc1378bc114d2, "[>]  " + this.\u018d.z$18nrktuqeiysv(), f2, f3);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u0404 = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u0404;
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u0121 = this.\u0280.\u02a4.\u0523() + this.\u0404;
        this.\u051b = this.\u0280.\u02a4.\u01a9();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (this.\u03bb(n, n2) && (n3 == 0 || n3 == 1) && this.\u0280.\u0224) {
            float f;
            this.V = f = this.\u042c();
            this.\u04c4 = !this.\u04c4;
            this.\u018d.\u04f6(this.\u04c4);
            this.\u027b = this.\u04c4 ? 1.0f : 0.0f;
            this.\u053e = new oc5f2027353d(250.0f);
            this.\u053e.\u039e();
            this.\u0280.\u01e3();
            return true;
        }
        return false;
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u053e = null;
        this.V = this.\u050b = this.\u04c4 ? 1.0f : 0.0f;
        this.\u027b = this.\u050b;
    }

    public boolean \u03bb(int n, int n2) {
        return (float)n > this.\u051b && (float)n < this.\u051b + this.\u0280.\u02a4.\u0232() && (float)n2 > this.\u0121 && (float)n2 < this.\u0121 + 11.0f;
    }

    private void \u047c(oc1378bc114d oc1378bc114d2, String string, float f, float f2) {
        oc1378bc114d2.z$ao2ykh4tuw6w(string, f, f2, -1, false);
    }
}

