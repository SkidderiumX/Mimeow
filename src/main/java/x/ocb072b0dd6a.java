/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import x.N;
import x.oc1cb76bf763;
import x.oc321b4679dd;
import x.oc4f21845252;
import x.oc69da1aa7f5;
import x.oc8aaacef5d6;

public class ocb072b0dd6a
extends oc4f21845252 {
    final GuiTextField \u0180;
    private final oc321b4679dd \u04e0;
    private float \u013e;
    private oc8aaacef5d6 \u0266;

    ocb072b0dd6a(oc321b4679dd oc321b4679dd2, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632) {
        this(oc321b4679dd2, oc69da1aa7f52, oc1cb76bf7632, oc321b4679dd2.x());
    }

    ocb072b0dd6a(N n, oc69da1aa7f5 oc69da1aa7f52, oc1cb76bf763 oc1cb76bf7632, int n2) {
        super(n, oc69da1aa7f52, oc1cb76bf7632);
        oc321b4679dd oc321b4679dd2;
        this.\u04e0 = n instanceof oc321b4679dd ? (oc321b4679dd2 = (oc321b4679dd)n) : null;
        this.\u0180 = new GuiTextField(0, Minecraft.getMinecraft().fontRendererObj, 0, 0, 0x18DF8234 ^ 0x18DF8250, 0x18DF825A ^ 0x18DF8250);
        this.\u0180.setMaxStringLength(n2);
        this.\u0180.setText(this.\u04e0 == null ? "" : this.\u04e0.\u00ca());
    }

    @Override
    float z$3i1zpd5rao25t(oc8aaacef5d6 oc8aaacef5d62) {
        return 26.0f;
    }

    @Override
    void z$28tc36an9xevp(oc8aaacef5d6 oc8aaacef5d62, float f, float f2) {
        this.\u045f(oc8aaacef5d62);
        this.\u0548(oc8aaacef5d62, 8.5f);
        this.o(oc8aaacef5d62, this.\u0575 + 13.0f);
    }

    void o(oc8aaacef5d6 oc8aaacef5d62, float f) {
        this.\u0266 = oc8aaacef5d62;
        if (this.\u04e0 != null && !this.\u049a.\u04d1(this) && !this.\u04e0.\u00ca().equals(this.\u0180.getText())) {
            this.\u0180.setText(this.\u04e0.\u00ca());
        }
        oc8aaacef5d62.\u04ce(this.\u01e7 + 5.0f, f, this.\u03c8 - 10.0f, 10.0f, 2.5f, 1.5f, 0xF5D2D8A5 ^ 0xA8288F5);
        oc8aaacef5d62.\u027e(this.\u01e7 + 5.0f, f, this.\u03c8 - 10.0f, 10.0f, 2.5f, 0xF59B91EC ^ 0xA8288F5);
        String string = this.\u04e0 != null && this.\u04e0.\u00eb() ? "\u2022".repeat(this.\u0180.getText().length()) : this.\u0180.getText();
        int n = Math.min(this.\u0180.getCursorPosition(), string.length());
        float f2 = oc8aaacef5d62.\u01f1("productsans-medium", string.substring(0, n), 7.0f);
        if (this.\u049a.\u04d1(this)) {
            if (f2 - this.\u013e > this.\u03c8 - 17.0f) {
                this.\u013e = f2 - this.\u03c8 + 17.0f;
            }
            if (f2 < this.\u013e) {
                this.\u013e = f2;
            }
        } else {
            this.\u013e = 0.0f;
        }
        oc8aaacef5d62.\u023a(this.\u01e7 + 6.0f, f, this.\u03c8 - 12.0f, 10.0f, () -> {
            int n2 = Math.min(this.\u0180.getSelectionEnd(), string.length());
            if (this.\u049a.\u04d1(this) && n != n2) {
                float f3 = oc8aaacef5d62.\u01f1("productsans-medium", string.substring(0, Math.min(n, n2)), 7.0f);
                float f4 = oc8aaacef5d62.\u01f1("productsans-medium", string.substring(0, Math.max(n, n2)), 7.0f);
                oc8aaacef5d62.\u027e(this.\u01e7 + 7.0f + f3 - this.\u013e, f + 1.5f, f4 - f3, 7.0f, 0.0f, 0x4E40C059 ^ 0xB16492CB);
            }
            String string2 = string.isEmpty() && this.\u04e0 != null && !this.\u049a.\u04d1(this) ? this.\u04e0.\u0574() : string;
            oc8aaacef5d62.\u0456("productsans-medium", string2, this.\u01e7 + 7.0f - this.\u013e, f + 7.0f, 7.0f, 0x4EE4124B ^ 0xB16492CB);
            if (this.\u049a.\u04d1(this) && n == n2 && System.currentTimeMillis() % (0x5F0DE1740CB6A56FL ^ 0x5F0DE1740CB6A687L) > (0x5F0DE1740CB6A717L ^ 0x5F0DE1740CB6A687L)) {
                oc8aaacef5d62.\u027e(this.\u01e7 + 7.5f + f2 - this.\u013e, f + 1.5f, 0.5f, 7.0f, 0.0f, -1);
            }
        });
    }

    @Override
    boolean z$3iwy342velf2h(float f, float f2, int n) {
        if (n != 0) {
            return false;
        }
        this.\u013d(f);
        return true;
    }

    void \u013d(float f) {
        float f2;
        float f3;
        this.\u049a.\u04a6(this);
        this.\u0180.setFocused(true);
        if (this.\u0266 == null) {
            return;
        }
        String string = this.\u04e0 != null && this.\u04e0.\u00eb() ? "\u2022".repeat(this.\u0180.getText().length()) : this.\u0180.getText();
        float f4 = f - this.\u01e7 - 7.0f + this.\u013e;
        int n = 0;
        int n2 = 1;
        while (n2 <= string.length() && !(f4 < ((f3 = this.\u0266.\u01f1("productsans-medium", string.substring(0, n2 - 1), 7.0f)) + (f2 = this.\u0266.\u01f1("productsans-medium", string.substring(0, n2), 7.0f))) / 2.0f)) {
            n = n2++;
        }
        this.\u0180.setCursorPosition(n);
    }

    @Override
    boolean z$16m0yo633oydp(char c, int n) {
        if (n == 1) {
            this.z$21n2hyuutt37u();
            return true;
        }
        if (n == (0x6D8D052F ^ 0x6D8D0533) || n == (0x6D8D05AF ^ 0x6D8D0533)) {
            if (this.\u04e0 != null) {
                this.\u04e0.\u01ba();
            }
            this.z$21n2hyuutt37u();
            return true;
        }
        if (this.\u04e0 != null && this.\u04e0.\u01fc() && GuiScreen.isCtrlKeyDown() && (n == (0x6D8D051D ^ 0x6D8D0533) || n == (0x6D8D051E ^ 0x6D8D0533))) {
            return true;
        }
        if (this.\u0180.textboxKeyTyped(c, n)) {
            if (this.\u04e0 != null) {
                this.\u04e0.z$1bnplyl2p7uqx(this.\u0180.getText());
                this.z$3e974bso21r1k();
            }
            return true;
        }
        return true;
    }

    @Override
    void z$21n2hyuutt37u() {
        this.\u0180.setFocused(false);
        super.z$21n2hyuutt37u();
    }
}

