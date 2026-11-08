/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc3542cefbeb;
import x.oc4d46a99983;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.ocebe35f25d6;

public class oc5b72b56d37
extends oc6c12eede72 {
    public oc4d46a99983 \u00e3;
    private ocebe35f25d6 \u01dc;
    public float W;
    public float \u04b2;
    public float \u026c;

    public oc5b72b56d37(oc4d46a99983 oc4d46a999832, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u00e3 = oc4d46a999832;
        this.\u01dc = ocebe35f25d62;
        this.\u04b2 = ocebe35f25d62.\u02a4.\u01a9() + ocebe35f25d62.\u02a4.\u0232();
        this.\u026c = ocebe35f25d62.\u02a4.\u0406() + ocebe35f25d62.\u0182;
        this.W = f;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        oc1378bc114d2.z$ao2ykh4tuw6w(this.\u00e3.\u03f5(), (this.\u01dc.\u02a4.\u01a9() + 4.0f) * 2.0f, (this.\u01dc.\u02a4.\u0406() + this.W + 4.0f) * 2.0f, oc3542cefbeb.\u0189(oc3542cefbeb.\u0197[0], oc3542cefbeb.\u0197[1], 0.0), true);
        GL11.glPopMatrix();
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.W = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.W;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u00e3.\u04c0;
    }
}

