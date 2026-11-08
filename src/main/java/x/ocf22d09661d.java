/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.input.Keyboard;
import x.oc1e2c36223e;
import x.oc321b4679dd;
import x.ocebe35f25d6;
import x.ocfd4ff6075d;

public class ocf22d09661d
extends ocfd4ff6075d {
    public final oc321b4679dd \u01f4;
    private String E;

    public ocf22d09661d(oc321b4679dd oc321b4679dd2, ocebe35f25d6 ocebe35f25d62, float f) {
        super(ocebe35f25d62, f, oc321b4679dd2.\u0574(), oc321b4679dd2.x());
        this.\u01f4 = oc321b4679dd2;
        this.\u0426().\u03f1(oc321b4679dd2.\u00ca());
    }

    @Override
    public void z$1wkvejfd36e8w() {
        if (!this.\u0503()) {
            if (this.E != null) {
                this.\u0242();
            }
            if (!this.\u0426().Q().equals(this.\u01f4.\u00ca())) {
                this.\u0426().\u03f1(this.\u01f4.\u00ca());
            }
        }
        this.\u0426().\u0432(this.\u01f4.\u00eb());
        this.\u049e(this.\u01f4.z$18nrktuqeiysv());
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!this.\u0172.\u0224 || !this.\u0172.\u047c(this) || n3 != 0) {
            return false;
        }
        oc1e2c36223e oc1e2c36223e2 = this.\u0264(true);
        if (this.\u0141(n, n2, oc1e2c36223e2)) {
            if (this.\u01f4.\u01fc() && Keyboard.isKeyDown(0xF3C5E1D5 ^ 0xF3C5E1ED)) {
                this.\u01f4.\u03ec(0x70AC6067A15522FDL ^ 0x70AC6067A1553175L);
                this.\u0426().\u0432(false);
            }
            if (!this.\u0503()) {
                this.E = this.\u01f4.\u00ca();
            }
            this.\u039a(true);
            return true;
        }
        if (this.\u0503()) {
            this.\u0242();
            this.\u039a(false);
        }
        return false;
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        if (!this.\u0172.\u0224 || !this.\u0503()) {
            return;
        }
        if (n == 1) {
            this.\u0242();
            this.\u039a(false);
            return;
        }
        if (n == (0xFC3437E2 ^ 0xFC3437FE) || n == (0xFC343762 ^ 0xFC3437FE)) {
            this.\u01f4.\u01ba();
            this.E = null;
            this.\u0426().\u03f1(this.\u01f4.\u00ca());
            this.\u039a(false);
            return;
        }
        if (this.\u0426().\u04e7(c, n)) {
            this.\u01f4.z$1bnplyl2p7uqx(this.\u0426().Q());
        }
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u01f4.\u04c0;
    }

    @Override
    public String z$181tlwmlg110c() {
        return this.\u01f4.\u01e1 != null ? this.\u01f4.\u01e1.z$18nrktuqeiysv() : "";
    }

    @Override
    public boolean z$2v3bclguk2h6z(int n, int n2) {
        return this.\u0141(n, n2, this.\u0264(true));
    }

    private void \u0242() {
        if (this.E != null) {
            this.\u0426().\u03f1(this.E);
            this.\u01f4.z$1bnplyl2p7uqx(this.E);
            this.E = null;
        }
    }
}

