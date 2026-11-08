/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import x.oc2cf3d80e17;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc7ab2161b9f;
import x.ocbd4917c4b1;
import x.oce0df46c57e;
import x.ocebe35f25d6;
import x.ocf1568fef75;

public class oc5bc92c04e9
extends oc6c12eede72 {
    public final ocf1568fef75 \u03ff;
    private final ocebe35f25d6 \u00e8;
    private float \u056d;
    private float \u0191;
    private float \u051c;
    public float \u0169;
    private oce0df46c57e \u00ca;

    public oc5bc92c04e9(ocf1568fef75 ocf1568fef752, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u03ff = ocf1568fef752;
        this.\u00e8 = ocebe35f25d62;
        this.\u056d = f;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        String string;
        float f = this.\u0388();
        float f2 = this.\u0180();
        float f3 = this.\u00e8.\u02a4.\u0406() + this.\u056d + 11.0f;
        float f4 = f3 + 4.0f;
        ocbd4917c4b1.\u04da(f, f3, f2, f4, 4.0f, 0xE4979131 ^ 0x1BD3D776);
        float f5 = this.\u0148(this.\u03ff.\u00f6());
        float f6 = this.\u0148(this.\u03ff.\u0456());
        int n = Color.getHSBColor((float)(System.currentTimeMillis() % (0x5024E2FDE528AC31L ^ 0x5024E2FDE52886C9L)) / 11000.0f, 0.75f, 0.9f).getRGB();
        ocbd4917c4b1.\u04da(f5, f3, Math.max(f5 + 1.0f, f6), f4, 4.0f, n);
        ocbd4917c4b1.\u04da(f5 - 1.0f, f3 - 1.0f, f5 + 1.0f, f4 + 1.0f, 2.0f, n);
        ocbd4917c4b1.\u04da(f6 - 1.0f, f3 - 1.0f, f6 + 1.0f, f4 + 1.0f, 2.0f, n);
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        String string2 = string = this.\u03ff.\u041c() != null ? this.\u03ff.\u041c() : "";
        String string3 = oc7ab2161b9f.\u0251(this.\u03ff.\u0456());
        String string4 = oc7ab2161b9f.\u0251(this.\u03ff.\u00f6()) + " - " + string3 + string2;
        oc6a43806f12.\u044e().z$ao2ykh4tuw6w(this.\u03ff.z$18nrktuqeiysv() + ": \u00a7b" + string4, (this.\u00e8.\u02a4.\u01a9() + 4.0f) * 2.0f + this.\u0169, (this.\u00e8.\u02a4.\u0406() + this.\u056d + 3.0f) * 2.0f, -1, true);
        GL11.glPopMatrix();
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u0191 = this.\u00e8.\u02a4.\u01a9();
        this.\u051c = this.\u00e8.\u02a4.\u0523() + this.\u056d;
        if (this.\u00ca != null) {
            this.\u0265(n);
            if (oc2cf3d80e17.\u0115 != null) {
                oc2cf3d80e17.\u0115.\u01da().\u018b = false;
            }
        }
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (n3 != 0 || !this.\u00e8.\u0224 || !this.\u00e8.\u047c(this) || (float)n <= this.\u0191 || (float)n >= this.\u0191 + this.\u00e8.\u02a4.\u0232() || (float)n2 <= this.\u051c || (float)n2 >= this.\u051c + 16.0f) {
            return false;
        }
        double d = this.\u04bc(n);
        this.\u00ca = this.\u03ff.\u00f6() == this.\u03ff.\u0456() ? (d < this.\u03ff.\u00f6() ? oce0df46c57e.\u0449 : oce0df46c57e.\u0225) : (Math.abs(d - this.\u03ff.\u00f6()) <= Math.abs(d - this.\u03ff.\u0456()) ? oce0df46c57e.\u0449 : oce0df46c57e.\u0225);
        this.\u0265(n);
        return true;
    }

    @Override
    public void z$1n0m425nu1zvd(int n, int n2, int n3) {
        if (n3 != 0 || this.\u00ca == null) {
            return;
        }
        this.\u00ca = null;
        this.\u00e8.\u0523.z$3tl278wzjcayb(this.\u03ff);
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u00ca = null;
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u056d = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u056d;
    }

    @Override
    public float z$2rmsdj781vrn2() {
        return 16.0f;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u03ff.\u04c0;
    }

    private void \u0265(int n) {
        double d = this.\u04bc(n);
        if (this.\u00ca == oce0df46c57e.\u0449) {
            this.\u03ff.\u01f9(d);
        } else {
            this.\u03ff.\u0437(d);
        }
    }

    private double \u04bc(int n) {
        double d = this.\u0388();
        double d2 = Math.max(1.0, (double)this.\u0180() - d);
        double d3 = Math.max(0.0, Math.min(d2, (double)n - d));
        return this.\u03ff.\u03b8() + d3 / d2 * (this.\u03ff.\u0276() - this.\u03ff.\u03b8());
    }

    private float \u0148(double d) {
        double d2 = Math.max(1.0E-6, this.\u03ff.\u0276() - this.\u03ff.\u03b8());
        return this.\u0388() + (float)((d - this.\u03ff.\u03b8()) / d2) * (this.\u0180() - this.\u0388());
    }

    private float \u0388() {
        return this.\u00e8.\u02a4.\u01a9() + 4.0f + this.\u0169 / 2.0f;
    }

    private float \u0180() {
        return this.\u00e8.\u02a4.\u01a9() + this.\u00e8.\u02a4.\u0232() - 4.0f;
    }
}

