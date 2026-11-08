/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import net.minecraft.client.gui.Gui;
import x.oc24a0a5bddf;
import x.oc255ab955c3;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.ocbd4917c4b1;

public class occ876d93e01
extends oc5e2e2031b5 {
    private final oc24a0a5bddf \u00c2;
    private boolean \u056d;
    private boolean \u0126;
    private boolean \u00e7;

    occ876d93e01(oc24a0a5bddf oc24a0a5bddf2, oc69da1aa7f5 oc69da1aa7f52) {
        super(oc24a0a5bddf2, oc69da1aa7f52);
        this.\u00c2 = oc24a0a5bddf2;
    }

    @Override
    int z$ag4eb8ubl7je() {
        return this.\u00c2.\u0169() ? 0x6D838A75 ^ 0x6D838AFD : 0x6D838A80 ^ 0x6D838AFD;
    }

    @Override
    void z$1v7hdj78iia5d(int n, int n2) {
        float f;
        float f2 = this.\u0152 + 2.0f;
        float f3 = this.\u0417 + 4.0f;
        float f4 = Math.max(20.0f, this.\u016d - 10.0f);
        float f5 = 96.0f;
        float f6 = f3 + f5 + 8.0f;
        int n3 = Color.HSBtoRGB(this.\u00c2.\u0410() / 360.0f, 1.0f, 1.0f);
        ocbd4917c4b1.\u014e(f2, f3, f2 + f4, f3 + f5, -1, 0xB9C9B742 ^ 0x46C9B742 | n3);
        ocbd4917c4b1.\u01ba(f2, f3, f2 + f4, f3 + f5, 0, 0xB9C9B742 ^ 0x46C9B742);
        occ876d93e01.\u0584(f2, f6, f4, 8.0f);
        float f7 = f2 + this.\u00c2.\u0457() * f4;
        float f8 = f3 + (1.0f - this.\u00c2.\u0532()) * f5;
        occ876d93e01.\u039e(f7, f8);
        occ876d93e01.\u04b2(f2 + this.\u00c2.\u0410() / 360.0f * f4, f6, 8.0f);
        if (this.\u00c2.\u0169()) {
            f = f6 + 12.0f;
            Gui.drawRect((int)f2, (int)f, (int)(f2 + f4), (int)(f + 8.0f), 0xB9D0AE5B ^ 0x46C9B742);
            ocbd4917c4b1.\u014e(f2, f, f2 + f4, f + 8.0f, this.\u00c2.\u01d0(), this.\u00c2.\u0373());
            occ876d93e01.\u04b2(f2 + (float)this.\u00c2.\u01e2() / 255.0f * f4, f, 8.0f);
        }
        if (this.\u056d) {
            f = occ876d93e01.u(((float)n - f2) / f4);
            float f9 = 1.0f - occ876d93e01.u(((float)n2 - f3) / f5);
            this.\u00c2.\u0205(this.\u00c2.\u0410(), f, f9);
            this.\u0416();
        }
        if (this.\u0126) {
            this.\u00c2.\u0266(occ876d93e01.u(((float)n - f2) / f4) * 360.0f);
            this.\u0416();
        }
        if (this.\u00e7 && this.\u00c2.\u0169()) {
            this.\u00c2.\u0518(Math.round(occ876d93e01.u(((float)n - f2) / f4) * 255.0f));
            this.\u0416();
        }
        if (this.\u01f7(n, n2)) {
            String string = oc255ab955c3.\u0516(this.\u00c2.z$18nrktuqeiysv(), oc255ab955c3.B(), 0x46C9B72C ^ 0x46C9B742);
            int n4 = oc255ab955c3.B().z$toz8pt08w0nc(string) + (0x46C9B746 ^ 0x46C9B742);
            Gui.drawRect(n + (0x46C9B747 ^ 0x46C9B742), n2 - (0x46C9B741 ^ 0x46C9B742), n + (0x46C9B747 ^ 0x46C9B742) + n4, n2 + (0x46C9B74B ^ 0x46C9B742), 0xB9D0AE5B ^ 0x46C9B742);
            oc255ab955c3.B().z$ao2ykh4tuw6w(string, n + (0x46C9B745 ^ 0x46C9B742), n2 - (0x46C9B740 ^ 0x46C9B742), -1, false);
        }
    }

    @Override
    boolean z$1u23iokff6gve(int n, int n2, int n3) {
        if (n3 != 0 || !this.\u01f7(n, n2)) {
            return false;
        }
        float f = this.\u0152 + 2.0f;
        float f2 = this.\u0417 + 4.0f;
        float f3 = Math.max(20.0f, this.\u016d - 10.0f);
        float f4 = f2 + 104.0f;
        this.\u056d = oc255ab955c3.\u050e(f, f2, f3, 96.0f, n, n2);
        this.\u0126 = oc255ab955c3.\u050e(f, f4, f3, 8.0f, n, n2);
        this.\u00e7 = this.\u00c2.\u0169() && oc255ab955c3.\u050e(f, f4 + 12.0f, f3, 8.0f, n, n2);
        return this.\u056d || this.\u0126 || this.\u00e7;
    }

    @Override
    void z$rq44izq02hqg(int n, int n2, int n3) {
        if (n3 == 0) {
            this.\u056d = false;
            this.\u0126 = false;
            this.\u00e7 = false;
        }
    }

    @Override
    void z$3hwl7t34zws09() {
        this.\u056d = false;
        this.\u0126 = false;
        this.\u00e7 = false;
    }

    private static void \u0584(float f, float f2, float f3, float f4) {
        for (int i = 0; i < (0xDD3E1300 ^ 0xDD3E1306); ++i) {
            float f5 = (float)i / 6.0f;
            float f6 = (float)(i + 1) / 6.0f;
            ocbd4917c4b1.\u014e(f + f3 * f5, f2, f + f3 * f6, f2 + f4, 0x223E1306 ^ 0xDD3E1306 | Color.HSBtoRGB(f5, 1.0f, 1.0f), 0x223E1306 ^ 0xDD3E1306 | Color.HSBtoRGB(f6, 1.0f, 1.0f));
        }
    }

    private static void \u039e(float f, float f2) {
        Gui.drawRect((int)f - (0x68BF67A9 ^ 0x68BF67AB), (int)f2 - (0x68BF67A9 ^ 0x68BF67AB), (int)f + (0x68BF67A8 ^ 0x68BF67AB), (int)f2 - 1, -1);
        Gui.drawRect((int)f - (0x68BF67A9 ^ 0x68BF67AB), (int)f2 + (0x68BF67A9 ^ 0x68BF67AB), (int)f + (0x68BF67A8 ^ 0x68BF67AB), (int)f2 + (0x68BF67A8 ^ 0x68BF67AB), -1);
        Gui.drawRect((int)f - (0x68BF67A9 ^ 0x68BF67AB), (int)f2 - (0x68BF67A9 ^ 0x68BF67AB), (int)f - 1, (int)f2 + (0x68BF67A8 ^ 0x68BF67AB), -1);
        Gui.drawRect((int)f + (0x68BF67A9 ^ 0x68BF67AB), (int)f2 - (0x68BF67A9 ^ 0x68BF67AB), (int)f + (0x68BF67A8 ^ 0x68BF67AB), (int)f2 + (0x68BF67A8 ^ 0x68BF67AB), -1);
    }

    private static void \u04b2(float f, float f2, float f3) {
        Gui.drawRect((int)f - 1, (int)f2 - 1, (int)f + (0xEA52D1BC ^ 0xEA52D1BE), (int)(f2 + f3 + 1.0f), -1);
        Gui.drawRect((int)f, (int)f2, (int)f + 1, (int)(f2 + f3), 0x154BC8A7 ^ 0xEA52D1BE);
    }

    private static float u(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }
}

