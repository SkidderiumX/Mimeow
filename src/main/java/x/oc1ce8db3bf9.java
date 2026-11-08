/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.occ2f8dff8d8;
import x.ocebe35f25d6;

public class oc1ce8db3bf9
extends oc6c12eede72 {
    private static final int \u04a7 = new Color(0x7F0D1FA1 ^ 0x7F0D1FB5, 0x7F0D1F4A ^ 0x7F0D1FB5, 0).getRGB();
    private oc69da1aa7f5 \u021a;
    public occ2f8dff8d8 \u00dc;
    private ocebe35f25d6 \u0232;
    public float \u00ba;
    public float \u0580;
    private float \u04b2;
    public float \u0191;

    public oc1ce8db3bf9(oc69da1aa7f5 oc69da1aa7f52, occ2f8dff8d8 occ2f8dff8d82, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u021a = oc69da1aa7f52;
        this.\u00dc = occ2f8dff8d82;
        this.\u0232 = ocebe35f25d62;
        this.\u0580 = ocebe35f25d62.\u02a4.\u01a9() + ocebe35f25d62.\u02a4.\u0232();
        this.\u04b2 = ocebe35f25d62.\u02a4.\u0406() + ocebe35f25d62.\u0182;
        this.\u00ba = f;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        oc1378bc114d2.z$ao2ykh4tuw6w((this.\u00dc.\u04fd ? "[=]  " : (this.\u00dc.\u01ed() ? "[+]  " : "[-]  ")) + this.\u00dc.z$18nrktuqeiysv(), (this.\u0232.\u02a4.\u01a9() + 4.0f) * 2.0f + this.\u0191, (this.\u0232.\u02a4.\u0406() + this.\u00ba + 4.0f) * 2.0f, this.\u00dc.\u01ed() ? \u04a7 : -1, false);
        GL11.glScaled(1.0, 1.0, 1.0);
        GL11.glPopMatrix();
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u00ba = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u00ba;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u00dc.\u04c0;
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u04b2 = this.\u0232.\u02a4.\u0523() + this.\u00ba;
        this.\u0580 = this.\u0232.\u02a4.\u01a9();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (this.\u041a(n, n2) && n3 == 0 && this.\u0232.\u0224 && this.\u0232.\u047c(this)) {
            if (this.\u00dc.\u04fd) {
                this.\u00dc.\u0568();
                return false;
            }
            this.\u00dc.\u045d();
            this.\u021a.guiButtonToggled(this.\u00dc);
        }
        return false;
    }

    public boolean \u041a(int n, int n2) {
        return (float)n > this.\u0580 && (float)n < this.\u0580 + this.\u0232.\u02a4.\u0232() && (float)n2 > this.\u04b2 && (float)n2 < this.\u04b2 + 11.0f;
    }
}

