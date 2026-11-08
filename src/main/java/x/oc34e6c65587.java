/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.Gui;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.oc7ab2161b9f;
import x.oca9cc61aada;

public class oc34e6c65587
extends oc5e2e2031b5 {
    private final oca9cc61aada \u039a;
    private final boolean \u04a4;
    private boolean \u01ac;
    private double \u00c6;

    oc34e6c65587(oca9cc61aada oca9cc61aada2, oc69da1aa7f5 oc69da1aa7f52) {
        super(oca9cc61aada2, oc69da1aa7f52);
        this.\u039a = oca9cc61aada2;
        this.\u04a4 = oc69da1aa7f52 instanceof oc6a43806f12 && oca9cc61aada2 == oc6a43806f12.\u0413;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        boolean bl = this.\u01f7(n, n2);
        if (bl) {
            Gui.drawRect((int)(this.\u0152 - 3.0f), (int)this.\u0417, (int)(this.\u0152 - 3.0f + this.\u016d), (int)(this.\u0417 + 15.0f), 0xEC220126 ^ 0x7A3B183F);
        }
        if (this.\u01ac) {
            this.\u021e(n);
        }
        double d = this.\u04a4 && this.\u01ac ? this.\u00c6 : this.\u039a.\u04c1();
        double d2 = d == -1.0 && this.\u039a.\u01fb ? 0.0 : (d - this.\u039a.\u0515()) / Math.max(1.0E-6, this.\u039a.\u0236() - this.\u039a.\u0515());
        d2 = Math.max(0.0, Math.min(1.0, d2));
        Gui.drawRect((int)(this.\u0152 - 3.0f), (int)this.\u0417, (int)((double)(this.\u0152 - 3.0f) + (double)this.\u016d * d2), (int)(this.\u0417 + 15.0f), oc255ab955c3.\u0515(oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5), 0x7A3B1851 ^ 0x7A3B183F));
        Object object = d == -1.0 && this.\u039a.\u01fb ? "Disabled" : (this.\u039a.\u0505() != null && d == this.\u039a.\u0515() ? this.\u039a.\u0505() : oc7ab2161b9f.\u0251(d) + this.\u039a.\u011c());
        String string = oc255ab955c3.\u0516(this.\u039a.z$18nrktuqeiysv() + ": " + (String)object, oc1378bc114d2, (int)this.\u016d - (0x7A3B1839 ^ 0x7A3B183F));
        oc1378bc114d2.z$ao2ykh4tuw6w(string, this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0x7A3B1830 ^ 0x7A3B183F, oc1378bc114d2), -1, false);
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (!this.\u01f7(n, n2) || n3 != 0) {
            return false;
        }
        this.\u01ac = true;
        this.\u021e(n);
        return true;
    }

    @Override
    void z$rq44izq02hqg(int n, int n2, int n3) {
        if (!this.\u01ac || n3 != 0) {
            return;
        }
        this.\u021e(n);
        this.\u01ac = false;
        this.\u039a.\u02ab(this.\u04a4 ? this.\u00c6 : this.\u039a.\u04c1());
        this.\u0273.z$1sehylui0i4ix(this.\u039a);
        this.\u0416();
    }

    @Override
    void z$3hwl7t34zws09() {
        this.\u01ac = false;
    }

    private void \u021e(int n) {
        double d = Math.max(0.0, (double)Math.min(this.\u016d, (float)n - (this.\u0152 - 3.0f)));
        if (d == 0.0 && this.\u039a.\u01fb) {
            if (this.\u04a4) {
                this.\u00c6 = -1.0;
            } else {
                this.\u039a.\u0459(-1.0);
            }
        } else {
            double d2 = this.\u039a.\u0515() + d / (double)this.\u016d * (this.\u039a.\u0236() - this.\u039a.\u0515());
            if (this.\u04a4) {
                double d3 = this.\u039a.\u03d3();
                this.\u00c6 = (double)Math.round(d2 / d3) * d3;
            } else {
                this.\u039a.\u021e(d2);
            }
        }
        if (!this.\u04a4) {
            this.\u0416();
        }
    }
}

