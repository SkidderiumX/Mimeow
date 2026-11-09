/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc2cf3d80e17;
import x.oc3ebac73392;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocbd4917c4b1;
import x.ocd2958dac48;
import x.oce4cea752dd;
import x.ocebe35f25d6;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class oc6beef1c60b
extends oc6c12eede72 {
    public oca9cc61aada \u050d;
    private ocebe35f25d6 \u041b;
    public float \u0548;
    public float \u050e;
    private float \u0555;
    public boolean \u0161 = false;
    private double \u021d;
    public float \u03cc;
    private double \u0464;
    private double \u0509;
    private static final double \u03fb = 0.6;

    public oc6beef1c60b(oca9cc61aada oca9cc61aada2, ocebe35f25d6 ocebe35f25d62, float f) {
        double d;
        this.\u050d = oca9cc61aada2;
        this.\u041b = ocebe35f25d62;
        this.\u0548 = f;
        this.\u0464 = d = oca9cc61aada2.\u04c1() == -1.0 && oca9cc61aada2.\u01fb ? -1.0 : oca9cc61aada2.\u04c1();
        this.\u0509 = d;
        this.\u021d = this.\u050d.\u04c1() == -1.0 ? 0.0 : (double)(this.\u041b.\u02a4.\u0232() - 8.0f) * (this.\u050d.\u04c1() - this.\u050d.\u0515()) / (this.\u050d.\u0236() - this.\u050d.\u0515());
    }

    @Override
    public void z$1wkvejfd36e8w() {
        String string;
        ocbd4917c4b1.\u04da(this.\u041b.\u02a4.\u01a9() + 4.0f + this.\u03cc / 2.0f, this.\u041b.\u02a4.\u0406() + this.\u0548 + 11.0f, this.\u041b.\u02a4.\u01a9() + 4.0f + this.\u041b.\u02a4.\u0232() - 8.0f, this.\u041b.\u02a4.\u0406() + this.\u0548 + 15.0f, 4.0f, 0x19AB8F75 ^ 0xE6EFC932);
        float f = this.\u041b.\u02a4.\u01a9() + 4.0f + this.\u03cc / 2.0f;
        float f2 = (float)((double)f + this.\u021d);
        if (f2 - f > 84.0f) {
            f2 = f + 84.0f;
        }
        ocbd4917c4b1.\u04da(f, this.\u041b.\u02a4.\u0406() + this.\u0548 + 11.0f, f2, this.\u041b.\u02a4.\u0406() + this.\u0548 + 15.0f, 4.0f, Color.getHSBColor((float)(System.currentTimeMillis() % (0x29E81D9226214F7CL ^ 0x29E81D9226216584L)) / 11000.0f, 0.75f, 0.9f).getRGB());
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        double d = this.\u04d0Value();
        Object object = this.\u050d.\u011c();
        if (d == -1.0 && this.\u050d.\u01fb) {
            string = "\u00a7cDisabled";
            object = "";
        } else if (this.\u050d.\u0505() != null && d == this.\u050d.\u0515()) {
            string = this.\u050d.\u0505();
            object = "";
        } else {
            if (d != 1.0 && (((String)object).equals(" second") || ((String)object).equals(" block") || ((String)object).equals(" tick")) && this.\u041b.\u0523.\u044a() != oce4cea752dd.\u057c) {
                object = (String)object + "s";
            }
            if (this.\u050d.\u00c6) {
                int n = (int)Math.round(d);
                n = Math.max(0, Math.min(n, this.\u050d.\u04be().length - 1));
                string = this.\u050d.\u04be()[n];
            } else {
                string = oc7ab2161b9f.\u0251(d);
            }
        }
        float f3 = (this.\u041b.\u02a4.\u01a9() + 4.0f) * 2.0f + this.\u03cc;
        float f4 = (this.\u041b.\u02a4.\u0406() + this.\u0548 + 3.0f) * 2.0f;
        if (this.\u04d0()) {
            this.\u038a(f3, f4, string, (String)object);
        } else {
            Object object2 = object;
            String string2 = string;
            String string3 = this.\u050d.\u00c6 ? "\u00a7e" : "\u00a7b";
            oc6a43806f12.\u044e().z$ao2ykh4tuw6w(this.\u050d.z$18nrktuqeiysv() + ": " + string3 + string2 + (String)object2, f3, f4, -1, true);
        }
        GL11.glPopMatrix();
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u0555 = this.\u041b.\u02a4.\u0523() + this.\u0548;
        this.\u050e = this.\u041b.\u02a4.\u01a9();
        if (this.\u0161) {
            double d;
            double d2 = Math.min(this.\u041b.\u02a4.\u0232() - 8.0f, Math.max(0.0f, (float)n - this.\u050e));
            this.\u0464 = d2 == 0.0 && this.\u050d.\u01fb ? -1.0 : (d = oc6beef1c60b.\u04c2(d2 / (double)(this.\u041b.\u02a4.\u0232() - 8.0f) * (this.\u050d.\u0236() - this.\u050d.\u0515()) + this.\u050d.\u0515(), 0x56A42BC4 ^ 0x56A42BC0));
            this.\u0509 += (this.\u0464 - this.\u0509) * 0.6;
            if (!this.\u03b0()) {
                if (this.\u0464 == -1.0) {
                    this.\u050d.\u0459(-1.0);
                } else {
                    this.\u050d.\u021e(this.\u0464);
                }
            }
            if (this.\u0509 == -1.0) {
                this.\u021d = 0.0;
            } else {
                d = this.\u050d.\u0236() - this.\u050d.\u0515();
                double d3 = (this.\u0509 - this.\u050d.\u0515()) / d;
                this.\u021d = (double)(this.\u041b.\u02a4.\u0232() - 8.0f) * d3;
            }
            if (oc2cf3d80e17.\u0115 != null) {
                oc2cf3d80e17.\u0115.\u01da().\u018b = false;
            }
        }
    }

    public void \u0215() {
        double d;
        this.\u0464 = d = this.\u050d.\u04c1() == -1.0 && this.\u050d.\u01fb ? -1.0 : this.\u050d.\u04c1();
        this.\u0509 = d;
        this.\u021d = this.\u050d.\u04c1() == -1.0 ? 0.0 : (double)(this.\u041b.\u02a4.\u0232() - 8.0f) * (this.\u050d.\u04c1() - this.\u050d.\u0515()) / (this.\u050d.\u0236() - this.\u050d.\u0515());
    }

    private static double \u04c2(double d, int n) {
        if (n < 0) {
            return 0.0;
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if ((this.\u03ba(n, n2) || this.\u03ff(n, n2)) && n3 == 0 && this.\u041b.\u0224 && this.\u041b.\u047c(this)) {
            this.\u0161 = true;
        }
        return false;
    }

    @Override
    public void z$1n0m425nu1zvd(int n, int n2, int n3) {
        boolean bl = this.\u0161;
        this.\u0161 = false;
        if (n3 == 0 && bl && this.\u03b0()) {
            if (this.\u0464 == -1.0) {
                this.\u050d.\u0459(-1.0);
            } else {
                this.\u050d.\u021e(this.\u0464);
            }
            this.\u0215();
            oc2cf3d80e17.V.c();
        }
    }

    public boolean \u03ba(int n, int n2) {
        return (float)n > this.\u050e && (float)n < this.\u050e + this.\u041b.\u02a4.\u0232() / 2.0f + 1.0f && (float)n2 > this.\u0555 && (float)n2 < this.\u0555 + 16.0f;
    }

    public boolean \u03ff(int n, int n2) {
        return (float)n > this.\u050e + this.\u041b.\u02a4.\u0232() / 2.0f && (float)n < this.\u050e + this.\u041b.\u02a4.\u0232() && (float)n2 > this.\u0555 && (float)n2 < this.\u0555 + 16.0f;
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u0161 = false;
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u0548 = f;
    }

    private boolean \u04d0() {
        return this.\u050d.\u00c6 && (this.\u041b.\u0523 instanceof ocd2958dac48 && this.\u050d == ocd2958dac48.\u04ef || this.\u041b.\u0523 instanceof oc6a43806f12 && this.\u050d == oc6a43806f12.\u03a1);
    }

    private boolean \u03b0() {
        return this.\u041b.\u0523 instanceof oc6a43806f12 && this.\u050d == oc6a43806f12.\u0413;
    }

    private double \u04d0Value() {
        return this.\u03b0() && this.\u0161 ? this.\u0464 : this.\u050d.\u04c1();
    }

    private void \u038a(float f, float f2, String string, String string2) {
        String string3 = this.\u050d.z$18nrktuqeiysv() + ": ";
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.fontRendererObj.drawStringWithShadow(string3, f, f2, -1);
        oc1378bc114d oc1378bc114d2 = oc3ebac73392.\u013a(string);
        float f3 = f + (float)minecraft.fontRendererObj.getStringWidth(string3);
        float f4 = f2 - (float)(oc1378bc114d2.z$1tqmx4tpnr6lq() - minecraft.fontRendererObj.FONT_HEIGHT) / 2.0f;
        oc1378bc114d2.z$ao2ykh4tuw6w(string + string2, f3, f4, 0xED1F7928 ^ 0xEDE086D7, true);
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u0548;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u050d.\u04c0;
    }
}

