/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.gui.Gui;
import x.oc255ab955c3;
import x.oc321b4679dd;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oca98caeda20;

public class oc300695e691
extends oc5e2e2031b5 {
    private final oc321b4679dd \u0277;
    private final oca98caeda20 \u022d;

    oc300695e691(oc321b4679dd oc321b4679dd2, oc69da1aa7f5 oc69da1aa7f52) {
        super(oc321b4679dd2, oc69da1aa7f52);
        this.\u0277 = oc321b4679dd2;
        this.\u022d = new oca98caeda20(oc321b4679dd2.\u0574().isEmpty() ? oc321b4679dd2.z$18nrktuqeiysv() : oc321b4679dd2.\u0574(), oc321b4679dd2.x());
        this.\u022d.\u039d(oc321b4679dd2.\u00ca());
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        if (!this.\u022d.\u0175() && !this.\u022d.\u01af().equals(this.\u0277.\u00ca())) {
            this.\u022d.\u039d(this.\u0277.\u00ca());
        }
        this.\u022d.\u00fd(this.\u0277.\u00eb());
        this.\u022d.\u01da(this.\u0152, this.\u0417 + 1.0f, this.\u016d - 6.0f);
        if (this.\u022d.\u0175()) {
            String string = oc255ab955c3.\u0516(this.\u0277.z$18nrktuqeiysv(), oc255ab955c3.B(), 0xBB71439A ^ 0xBB7143F4);
            int n3 = oc255ab955c3.B().z$toz8pt08w0nc(string) + (0xBB7143F0 ^ 0xBB7143F4);
            Gui.drawRect(n + (0xBB7143F1 ^ 0xBB7143F4), n2 - (0xBB7143F7 ^ 0xBB7143F4), n + (0xBB7143F1 ^ 0xBB7143F4) + n3, n2 + (0xBB7143FD ^ 0xBB7143F4), 0x44685AED ^ 0xBB7143F4);
            oc255ab955c3.B().z$ao2ykh4tuw6w(string, n + (0xBB7143F3 ^ 0xBB7143F4), n2 - (0xBB7143F6 ^ 0xBB7143F4), -1, false);
        }
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (n3 == 0 && this.\u01f7(n, n2)) {
            this.\u022d.\u04cc();
            if (this.\u0277.\u01fc()) {
                this.\u0277.\u03ec(0x9536F9830EA2CD38L ^ 0x9536F9830EA2C680L);
            }
            return true;
        }
        this.\u022d.\u02e1();
        return false;
    }

    @Override
    boolean z$3twgyf5k61sst(char c, int n) {
        if (!this.\u022d.\u0175()) {
            return false;
        }
        if (n == (0x7F28B5CA ^ 0x7F28B5D6) || n == (0x7F28B54A ^ 0x7F28B5D6)) {
            this.\u0277.z$1bnplyl2p7uqx(this.\u022d.\u01af());
            this.\u0277.\u01ba();
            this.\u022d.\u02e1();
            this.\u0416();
            return true;
        }
        boolean bl = this.\u022d.\u01dd(c, n);
        this.\u0277.z$1bnplyl2p7uqx(this.\u022d.\u01af());
        if (bl) {
            this.\u0416();
        }
        return true;
    }

    @Override
    void z$1l3ht5d17kefg() {
        if (this.\u022d.\u0175()) {
            this.\u0277.z$1bnplyl2p7uqx(this.\u022d.\u01af());
        }
        this.\u022d.\u02e1();
    }
}

