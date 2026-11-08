/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import x.oc1cb76bf763;
import x.oc24a0a5bddf;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;
import x.ocaba452434e;
import x.occ99cc6cd9f;

public class oc0b01802c56
extends oc4f21845252 {
    private final oc24a0a5bddf \u03e6;
    private final occ99cc6cd9f \u0434 = new occ99cc6cd9f(0xAE0C7ED30B079498L ^ 0xAE0C7ED30B0794E5L, ocaba452434e.\u03df);
    private boolean \u023e;
    private int \u045d;
    private float \u01ce;

    oc0b01802c56(oc24a0a5bddf oc24a0a5bddf2, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        super(oc24a0a5bddf2, oc69da1aa7f52, oc1cb76bf7632);
        this.\u03e6 = oc24a0a5bddf2;
        this.\u01ce = this.\u03e6.\u0410() / 360.0f;
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 17.0f + (float)(this.\u03e6.\u0169() ? 0x38D3A394 ^ 0x38D3A3AB : 0x38D3A399 ^ 0x38D3A3AB) * this.\u0434.\u0540(this.\u023e ? 1.0f : 0.0f);
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        if (this.\u045d != 0) {
            this.\u00dc(f, f2);
        } else if (this.\u03e6.\u0457() > 0.0f) {
            this.\u01ce = this.\u03e6.\u0410() / 360.0f;
        }
        this.\u045f(oc8aaacef5d62);
        oc8aaacef5d62.\u0456("productsans-medium", oc8aaacef5d62.\u0398("productsans-medium", this.\u04b3.z$18nrktuqeiysv(), 7.0f, this.\u03c8 - 31.0f), this.\u01e7 + 5.0f, this.\u0575 + 10.5f, 7.0f, -1);
        oc8aaacef5d62.\u027e(this.\u01e7 + this.\u03c8 - 22.0f, this.\u0575 + 3.5f, 18.0f, 10.0f, 3.0f, this.\u03e6.\u0373());
        if (this.\u0434.\u047f() <= 0.0f) {
            return;
        }
        oc8aaacef5d62.\u023a(this.\u01e7, this.\u0575 + 17.0f, this.\u03c8, this.\u041a - 17.0f, () -> {
            oc8aaacef5d62.\u0419(this.\u01e7 + 5.0f, this.\u0575 + 17.0f, 65.0f, 50.0f, 0.0f, 0.0f, -1, Color.HSBtoRGB(this.\u01ce, 1.0f, 1.0f), false);
            oc8aaacef5d62.\u0419(this.\u01e7 + 5.0f, this.\u0575 + 17.0f, 65.0f, 50.0f, 0.0f, 0.0f, 0, 0xBACC2F0D ^ 0x45CC2F0D, true);
            oc8aaacef5d62.\u04ce(this.\u01e7 + 5.0f + this.\u03e6.\u0457() * 65.0f - 1.5f, this.\u0575 + 17.0f + (1.0f - this.\u03e6.\u0532()) * 50.0f - 1.5f, 3.0f, 3.0f, 1.5f, 0.75f, -1);
            for (int i = 0; i < (0x45CC2F0B ^ 0x45CC2F0D); ++i) {
                oc8aaacef5d62.\u0419(this.\u01e7 + 75.0f, this.\u0575 + 17.0f + (float)i * 50.0f / 6.0f, 8.0f, 8.433333f, 0.0f, 0.0f, Color.HSBtoRGB((float)i / 6.0f, 1.0f, 1.0f), Color.HSBtoRGB((float)(i + 1) / 6.0f, 1.0f, 1.0f), true);
            }
            oc8aaacef5d62.\u04ce(this.\u01e7 + 74.5f, this.\u0575 + 17.0f + this.\u01ce * 50.0f - 1.0f, 9.0f, 2.0f, 0.5f, 0.75f, -1);
            if (this.\u03e6.\u0169()) {
                oc8aaacef5d62.\u0419(this.\u01e7 + 5.0f, this.\u0575 + 72.0f, 78.0f, 4.0f, 2.0f, 2.0f, 0x45AC4F6D ^ 0x45CC2F0D, this.\u03e6.\u0373() | 0xBACC2F0D ^ 0x45CC2F0D, false);
                oc8aaacef5d62.\u027e(this.\u01e7 + 5.0f + (float)this.\u03e6.\u01e2() / 255.0f * 78.0f - 1.0f, this.\u0575 + 71.0f, 2.0f, 6.0f, 1.0f, -1);
            }
        });
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (f2 < this.\u0575 + 17.0f) {
            if (n != 1) {
                return false;
            }
            this.\u023e = !this.\u023e;
            this.\u0434.\u0540(this.\u023e ? 1.0f : 0.0f);
            this.\u045d = 0;
            return true;
        }
        if (!this.\u023e || n != 0) {
            return false;
        }
        if (oc4f21845252.\u0392(f, f2, this.\u01e7 + 5.0f, this.\u0575 + 17.0f, 65.0f, 50.0f)) {
            this.\u045d = 1;
        } else if (oc4f21845252.\u0392(f, f2, this.\u01e7 + 75.0f, this.\u0575 + 17.0f, 8.0f, 50.0f)) {
            this.\u045d = 0x62E98438 ^ 0x62E9843A;
        } else if (this.\u03e6.\u0169() && oc4f21845252.\u0392(f, f2, this.\u01e7 + 5.0f, this.\u0575 + 69.0f, 78.0f, 10.0f)) {
            this.\u045d = 0x62E98439 ^ 0x62E9843A;
        }
        if (this.\u045d == 0) {
            return false;
        }
        this.\u00dc(f, f2);
        return true;
    }

    private void \u00dc(float f, float f2) {
        if (this.\u045d == 1) {
            this.\u03e6.\u0205(this.\u01ce * 360.0f, oc4f21845252.\u0499((f - this.\u01e7 - 5.0f) / 65.0f), 1.0f - oc4f21845252.\u0499((f2 - this.\u0575 - 17.0f) / 50.0f));
        } else if (this.\u045d == (0xC2D2F377 ^ 0xC2D2F375)) {
            this.\u01ce = oc4f21845252.\u0499((f2 - this.\u0575 - 17.0f) / 50.0f);
            this.\u03e6.\u0205(this.\u01ce * 360.0f, this.\u03e6.\u0457(), this.\u03e6.\u0532());
        } else {
            this.\u03e6.\u0518(Math.round(oc4f21845252.\u0499((f - this.\u01e7 - 5.0f) / 78.0f) * 255.0f));
        }
        this.z$3e974bso21r1k();
    }

    @Override
    void z$jjpp51h3b2lm() {
        this.\u045d = 0;
    }

    @Override
    void z$21n2hyuutt37u() {
        this.\u045d = 0;
        super.z$21n2hyuutt37u();
    }
}

