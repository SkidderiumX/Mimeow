/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.Gui;
import x.oc1378bc114d;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oc7ab2161b9f;
import x.ocb04604c003;
import x.ocf1568fef75;

public class oc9b1cbd3b8d
extends oc5e2e2031b5 {
    private final ocf1568fef75 \u0257;
    private ocb04604c003 \u03cc;

    oc9b1cbd3b8d(ocf1568fef75 ocf1568fef752, oc69da1aa7f5 oc69da1aa7f52) {
        super(ocf1568fef752, oc69da1aa7f52);
        this.\u0257 = ocf1568fef752;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        String string;
        if (this.\u01f7(n, n2)) {
            Gui.drawRect((int)(this.\u0152 - 3.0f), (int)this.\u0417, (int)(this.\u0152 - 3.0f + this.\u016d), (int)(this.\u0417 + 15.0f), 0x60C59F59 ^ 0xF6DC8640);
        }
        if (this.\u03cc != null) {
            this.\u0160(n);
        }
        double d = Math.max(1.0E-6, this.\u0257.\u0276() - this.\u0257.\u03b8());
        double d2 = (this.\u0257.\u00f6() - this.\u0257.\u03b8()) / d;
        double d3 = (this.\u0257.\u0456() - this.\u0257.\u03b8()) / d;
        float f = (float)((double)(this.\u0152 - 3.0f) + (double)this.\u016d * d2);
        float f2 = (float)((double)(this.\u0152 - 3.0f) + (double)this.\u016d * d3);
        Gui.drawRect((int)f, (int)this.\u0417, (int)f2, (int)(this.\u0417 + 15.0f), oc255ab955c3.\u0515(oc255ab955c3.\u01ea((double)this.\u0152 + (double)this.\u016d * 0.5, (double)this.\u0417 + 7.5), 0xF6DC862E ^ 0xF6DC8640));
        String string2 = string = this.\u0257.\u041c() != null ? this.\u0257.\u041c() : "";
        String string3 = oc7ab2161b9f.\u0251(this.\u0257.\u0456());
        String string4 = oc7ab2161b9f.\u0251(this.\u0257.\u00f6());
        String string5 = this.\u0257.z$18nrktuqeiysv() + ": " + string4 + " - " + string3 + string2;
        oc1378bc114d oc1378bc114d2 = oc255ab955c3.\u0117();
        oc1378bc114d2.z$ao2ykh4tuw6w(oc255ab955c3.\u0516(string5, oc1378bc114d2, (int)this.\u016d - (0xF6DC8646 ^ 0xF6DC8640)), this.\u0152 + 2.0f, oc255ab955c3.\u0544((int)this.\u0417, 0xF6DC864F ^ 0xF6DC8640, oc1378bc114d2), -1, false);
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (!this.\u01f7(n, n2) || n3 != 0) {
            return false;
        }
        double d = this.\u04fa(n);
        this.\u03cc = this.\u0257.\u00f6() == this.\u0257.\u0456() ? (d < this.\u0257.\u00f6() ? ocb04604c003.\u043d : ocb04604c003.\u013d) : (Math.abs(d - this.\u0257.\u00f6()) <= Math.abs(d - this.\u0257.\u0456()) ? ocb04604c003.\u043d : ocb04604c003.\u013d);
        this.\u0160(n);
        return true;
    }

    @Override
    void z$rq44izq02hqg(int n, int n2, int n3) {
        if (this.\u03cc == null || n3 != 0) {
            return;
        }
        this.\u03cc = null;
        this.\u0273.z$3tl278wzjcayb(this.\u0257);
        this.\u0416();
    }

    @Override
    void z$3hwl7t34zws09() {
        this.\u03cc = null;
    }

    private void \u0160(int n) {
        double d = this.\u04fa(n);
        if (this.\u03cc == ocb04604c003.\u043d) {
            this.\u0257.\u01f9(d);
        } else {
            this.\u0257.\u0437(d);
        }
        this.\u0416();
    }

    private double \u04fa(int n) {
        double d = Math.max(0.0, (double)Math.min(this.\u016d, (float)n - (this.\u0152 - 3.0f)));
        return this.\u0257.\u03b8() + d / (double)this.\u016d * (this.\u0257.\u0276() - this.\u0257.\u03b8());
    }
}

