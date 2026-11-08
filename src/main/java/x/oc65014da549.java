/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import org.lwjgl.opengl.GL11;
import x.N;
import x.oc1378bc114d;
import x.oc2cf3d80e17;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocada7dda290;
import x.ocbd4917c4b1;
import x.ocebe35f25d6;

public class oc65014da549
extends oc6c12eede72 {
    private static final float \u0208 = 16.0f;
    private static final float \u0399 = 12.0f;
    private final ocebe35f25d6 \u0260;
    private final oca9cc61aada \u01bd;
    private final ocada7dda290 \u0295;
    public final N \u0502;
    public float \u04bf;
    public float \u057a;
    public boolean \u0150;
    private float \u0189;
    private float \u02a7;

    public oc65014da549(oca9cc61aada oca9cc61aada2, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u0502 = oca9cc61aada2;
        this.\u01bd = oca9cc61aada2;
        this.\u0295 = null;
        this.\u0260 = ocebe35f25d62;
        this.\u04bf = f;
    }

    public oc65014da549(ocada7dda290 ocada7dda2902, ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u0502 = ocada7dda2902;
        this.\u01bd = null;
        this.\u0295 = ocada7dda2902;
        this.\u0260 = ocebe35f25d62;
        this.\u04bf = f;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        float f = this.\u0260.\u02a4.\u01a9() + 4.0f + this.\u057a / 2.0f;
        float f2 = this.\u0260.\u02a4.\u0406() + this.\u04bf;
        float f3 = this.\u0260.\u02a4.\u01a9() + this.\u0260.\u02a4.\u0232() - 4.0f;
        ocbd4917c4b1.\u0109(f, f2 + 1.0f, f3, f2 + 16.0f - 1.0f, 0x38416E77 ^ 0x78614E5F);
        String string = this.\u021a();
        String string2 = this.\u0502.z$18nrktuqeiysv();
        String string3 = this.\u0150 ? "v" : ">";
        this.\u050c("[" + string3 + "] " + string2 + ": " + string, f + 1.0f, f2 + 4.0f, -1);
        if (!this.\u0150) {
            return;
        }
        String[] stringArray = this.\u02b8();
        for (int i = 0; i < stringArray.length; ++i) {
            float f4 = f2 + 16.0f + (float)i * 12.0f;
            boolean bl = this.\u0538(i, stringArray[i]);
            if (bl) {
                int n = Color.getHSBColor((float)(System.currentTimeMillis() % (0xEEF69FD823B5CEC8L ^ 0xEEF69FD823B5E430L)) / 11000.0f, 0.65f, 0.9f).getRGB();
                ocbd4917c4b1.\u0109(f + 2.0f, f4, f3, f4 + 12.0f, oc7ab2161b9f.\u04ac(n, 0x78614E0A ^ 0x78614E5F));
            }
            String string4 = this.\u0295 == null ? (bl ? "(*) " : "( ) ") : (bl ? "[x] " : "[ ] ");
            this.\u050c(string4 + stringArray[i].replace((char)(0x78614E00 ^ 0x78614E5F), (char)(0x78614E7F ^ 0x78614E5F)), f + 4.0f, f4 + 2.0f, bl ? -1 : 0x87A68998 ^ 0x78614E5F);
        }
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u0189 = this.\u0260.\u02a4.\u01a9();
        this.\u02a7 = this.\u0260.\u02a4.\u0523() + this.\u04bf;
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!this.\u0260.\u0224 || !this.\u0260.\u047c(this) || n3 != 0) {
            return false;
        }
        float f = this.\u0260.\u02a4.\u0232();
        if ((float)n > this.\u0189 && (float)n < this.\u0189 + f && (float)n2 > this.\u02a7 && (float)n2 < this.\u02a7 + 16.0f) {
            this.\u0150 = !this.\u0150;
            this.\u0260.\u01e3();
            return true;
        }
        if (!this.\u0150 || (float)n <= this.\u0189 || (float)n >= this.\u0189 + f) {
            return false;
        }
        String[] stringArray = this.\u02b8();
        for (int i = 0; i < stringArray.length; ++i) {
            float f2 = this.\u02a7 + 16.0f + (float)i * 12.0f;
            if ((float)n2 <= f2 || (float)n2 >= f2 + 12.0f) continue;
            if (this.\u01bd != null) {
                this.\u01bd.\u02ab(i);
                this.\u0260.\u0523.z$1sehylui0i4ix(this.\u01bd);
                this.\u0150 = false;
                this.\u0260.\u01e3();
            } else {
                this.\u0295.\u0465(stringArray[i]);
                this.\u0260.\u0523.z$3tl278wzjcayb(this.\u0295);
                this.\u0260.\u0523.z$2u87utkr1isxg();
            }
            this.\u00c4();
            return true;
        }
        return false;
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u04bf = f;
    }

    @Override
    public float z$2rmsdj781vrn2() {
        return 16.0f + (this.\u0150 ? (float)this.\u02b8().length * 12.0f : 0.0f);
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u04bf;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u0502.\u04c0;
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u0150 = false;
    }

    public void \u03c6(boolean bl) {
        this.\u0150 = bl;
    }

    private String[] \u02b8() {
        return this.\u01bd != null ? this.\u01bd.\u04be() : this.\u0295.\u01e5();
    }

    private boolean \u0538(int n, String string) {
        return this.\u01bd != null ? (int)this.\u01bd.\u04c1() == n : this.\u0295.\u01e9(string);
    }

    private String \u021a() {
        if (this.\u01bd != null) {
            String[] stringArray = this.\u01bd.\u04be();
            if (stringArray.length == 0) {
                return "None";
            }
            int n = Math.max(0, Math.min(stringArray.length - 1, (int)this.\u01bd.\u04c1()));
            return stringArray[n].replace((char)(0x4FF59F59 ^ 0x4FF59F06), (char)(0x4FF59F26 ^ 0x4FF59F06));
        }
        int n = this.\u0295.\u0507().size();
        if (n == 0) {
            return "None";
        }
        if (n == 1) {
            return this.\u0295.\u0507().get(0).replace((char)(0x4FF59F59 ^ 0x4FF59F06), (char)(0x4FF59F26 ^ 0x4FF59F06));
        }
        return n + " selected";
    }

    private void \u050c(String string, float f, float f2, int n) {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        oc1378bc114d2.z$ao2ykh4tuw6w(string, f * 2.0f, f2 * 2.0f, n, true);
        GL11.glPopMatrix();
    }

    private void \u00c4() {
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }
}

