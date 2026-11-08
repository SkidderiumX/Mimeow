/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc1e2c36223e;
import x.oc3542cefbeb;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc8f0e20dbc2;
import x.oca06105b17f;
import x.ocebe35f25d6;

public abstract class ocfd4ff6075d
extends oc6c12eede72
implements oc8f0e20dbc2 {
    protected static final float \u01b6 = 12.0f;
    protected static final float \u00c4 = 0.5f;
    protected static final int \u01ba = 128;
    protected final ocebe35f25d6 \u0172;
    public float \u04e0;
    public float \u043a;
    private final oca06105b17f \u03ea;

    protected ocfd4ff6075d(ocebe35f25d6 ocebe35f25d62, float f, String string, int n) {
        this.\u0172 = ocebe35f25d62;
        this.\u04e0 = f;
        this.\u03ea = new oca06105b17f(string, n, 0.5f);
    }

    protected final oca06105b17f \u0426() {
        return this.\u03ea;
    }

    protected final oc1e2c36223e \u0264(boolean bl) {
        oc1e2c36223e oc1e2c36223e2 = new oc1e2c36223e();
        oc1e2c36223e2.\u0568 = this.\u0172.\u02a4.\u01a9();
        oc1e2c36223e2.\u0124 = bl ? this.\u0172.\u02a4.\u0523() : this.\u0172.\u02a4.\u0406();
        oc1e2c36223e2.\u048e = this.\u0172.\u02a4.\u0232();
        oc1e2c36223e2.\u043a = oc1e2c36223e2.\u0568 + 4.0f + this.\u043a / 2.0f;
        oc1e2c36223e2.\u0146 = oc1e2c36223e2.\u0568 + oc1e2c36223e2.\u048e - 4.0f;
        oc1e2c36223e2.\u053d = oc1e2c36223e2.\u0124 + this.\u04e0 + 12.0f;
        oc1e2c36223e2.N = oc1e2c36223e2.\u0124 + this.\u04e0 + 24.0f;
        return oc1e2c36223e2;
    }

    protected final void \u049e(String string) {
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(false);
        this.\u0522(oc1e2c36223e2, string);
        this.\u026c(oc1e2c36223e2);
    }

    protected final void \u0522(oc1e2c36223e oc1e2c36223e2, String string) {
        ocfd4ff6075d.\u0408(string, oc1e2c36223e2.\u043a, ocfd4ff6075d.\u0400(oc1e2c36223e2.\u0124 + this.\u04e0, 12.0f), oc3542cefbeb.\u0189(oc3542cefbeb.\u0197[0], oc3542cefbeb.\u0197[1], 0.0));
    }

    protected final void \u026c(oc1e2c36223e oc1e2c36223e2) {
        float f = oc1e2c36223e2.\u053d + 1.0f;
        float f2 = oc1e2c36223e2.\u053d + 12.0f - 1.0f;
        this.\u03ea.\u01e0(oc1e2c36223e2.\u043a, f, oc1e2c36223e2.\u0146, f2);
    }

    protected final boolean \u0141(int n, int n2, oc1e2c36223e oc1e2c36223e2) {
        float f = oc1e2c36223e2.\u053d + 1.0f;
        float f2 = oc1e2c36223e2.\u053d + 12.0f - 1.0f;
        return this.\u03ea.\u0438(n, n2, oc1e2c36223e2.\u043a, f, oc1e2c36223e2.\u0146, f2);
    }

    protected final float \u01ee(oc1e2c36223e oc1e2c36223e2) {
        return oc1e2c36223e2.\u053d + 1.0f;
    }

    protected final float \u0110(oc1e2c36223e oc1e2c36223e2) {
        return oc1e2c36223e2.\u053d + 12.0f - 1.0f;
    }

    protected final void \u039a(boolean bl) {
        this.\u03ea.B(bl);
    }

    protected final boolean \u0503() {
        return this.\u03ea.\u04b2();
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u03ea.\u01d9();
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u04e0 = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u04e0;
    }

    @Override
    public float z$2rmsdj781vrn2() {
        return 24.0f;
    }

    @Override
    public boolean z$z2u2v5j2dveu() {
        return this.\u0503();
    }

    @Override
    public boolean z$2v3bclguk2h6z(int n, int n2) {
        return this.\u0141(n, n2, this.\u0264(true));
    }

    @Override
    public void z$qv3ekpvnclzq() {
        this.\u039a(false);
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u039a(false);
    }

    public void \u0463(float f) {
        this.\u043a = f;
    }

    public abstract String z$181tlwmlg110c();

    protected static float \u0400(float f, float f2) {
        return ocfd4ff6075d.\u039a(f, f2, 0.5f);
    }

    protected static float \u039a(float f, float f2, float f3) {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        float f4 = Math.max(1.0f, (float)(oc1378bc114d2.z$w1h9nvoglpkn() - oc1378bc114d2.z$g5bxucc1j700()) * f3);
        return f + (f2 - f4) / 2.0f - (float)oc1378bc114d2.z$g5bxucc1j700() * f3;
    }

    protected static void \u0408(String string, float f, float f2, int n) {
        ocfd4ff6075d.\u018e(string, f, f2, n, 0.5f);
    }

    protected static void \u018e(String string, float f, float f2, int n, float f3) {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(f3, f3, f3);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, f / f3, f2 / f3, n, false);
        GL11.glPopMatrix();
    }
}

