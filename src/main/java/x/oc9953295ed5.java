/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import x.oc1378bc114d;
import x.oc2cf3d80e17;
import x.oc3542cefbeb;
import x.oc6a43806f12;
import x.oc6c12eede72;
import x.ocb23d192a35;
import x.ocbd4917c4b1;
import x.oce4cea752dd;
import x.ocebe35f25d6;

public class oc9953295ed5
extends oc6c12eede72 {
    private static final String \u01d9 = "/assets/idle.miau/textures/gui/eye.png";
    private static final String \u0439 = "/assets/idle.miau/textures/gui/eye_off.png";
    private static final int \u0233 = 2;
    public boolean \u04d3;
    public ocebe35f25d6 \u01d5;
    public float \u0241;
    public float \u049c;
    private float \u0220;
    public ocb23d192a35 \u0565;
    public float \u042e;

    public oc9953295ed5(ocebe35f25d6 ocebe35f25d62, float f) {
        this.\u01d5 = ocebe35f25d62;
        this.\u049c = ocebe35f25d62.\u02a4.\u01a9() + ocebe35f25d62.\u02a4.\u0232();
        this.\u0220 = ocebe35f25d62.\u02a4.\u0406() + ocebe35f25d62.\u0182;
        this.\u0241 = f;
    }

    public oc9953295ed5(ocebe35f25d6 ocebe35f25d62, ocb23d192a35 ocb23d192a352, float f) {
        this.\u01d5 = ocebe35f25d62;
        this.\u049c = ocebe35f25d62.\u02a4.\u01a9() + ocebe35f25d62.\u02a4.\u0232();
        this.\u0220 = ocebe35f25d62.\u02a4.\u0406() + ocebe35f25d62.\u0182;
        this.\u0565 = ocb23d192a352;
        this.\u0241 = f;
    }

    @Override
    public void z$18gzyyc94suow(float f) {
        this.\u0241 = f;
    }

    @Override
    public float z$d6ehueststre() {
        return this.\u0241;
    }

    @Override
    public boolean z$2c04w2bvpwmu9() {
        return this.\u0565 == null || this.\u0565.\u04c0;
    }

    @Override
    public void z$1wkvejfd36e8w() {
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        GL11.glPushMatrix();
        GL11.glScaled(0.5, 0.5, 0.5);
        if (this.\u0565 == null) {
            this.\u04b0(oc1378bc114d2, (String)(!this.\u01d5.\u0523.canBeEnabled() ? "Module cannot be bound." : (this.\u04d3 ? "Press a key..." : "Current bind: '\u00a7e" + this.\u01d9(false) + "\u00a7r'")));
        } else {
            oc1378bc114d2.z$ao2ykh4tuw6w((String)(this.\u04d3 ? "Press a key..." : this.\u0565.z$18nrktuqeiysv() + ": '\u00a7e" + this.\u01d9(true) + "\u00a7r'"), (this.\u01d5.\u02a4.\u01a9() + 4.0f) * 2.0f + this.\u042e, (this.\u01d5.\u02a4.\u0406() + this.\u0241 + (float)(this.\u0565 == null ? 0x377DD78 ^ 0x377DD7B : 0x377DD7F ^ 0x377DD7B)) * 2.0f, oc3542cefbeb.\u0189(oc3542cefbeb.\u0197[0], oc3542cefbeb.\u0197[1], 0.0), true);
        }
        GL11.glPopMatrix();
        if (this.\u0565 == null && this.\u01d5.\u0523.\u044a() != oce4cea752dd.\u051d) {
            int n = this.\u043c();
            float f = this.\u021f(n);
            float f2 = (float)oc6a43806f12.\u044e().z$1tqmx4tpnr6lq() * 0.5f;
            float f3 = this.F() + (f2 - (float)n) / 2.0f;
            int n2 = !this.\u01d5.\u0523.\u00ea ? oc3542cefbeb.\u0189(oc3542cefbeb.\u0197[0], oc3542cefbeb.\u0197[1], 0.0) : oc3542cefbeb.\u0189(oc3542cefbeb.\u039d[0], oc3542cefbeb.\u039d[1], 0.0);
            String string = this.\u01d5.\u0523.\u056c() ? "/assets/idle.miau/textures/gui/eye_off.png" : "/assets/idle.miau/textures/gui/eye.png";
            ocbd4917c4b1.\u00ec(ocbd4917c4b1.\u02b8(string), f, f3, n, n2);
        }
    }

    @Override
    public void z$3dv8qdlj15ex7(int n, int n2) {
        this.\u0220 = this.\u01d5.\u02a4.\u0523() + this.\u0241;
        this.\u049c = this.\u01d5.\u02a4.\u01a9();
    }

    @Override
    public boolean z$1qf5sz783tgla(int n, int n2, int n3) {
        if (!(this.V(n, n2) && this.\u01d5.\u0224 && this.\u01d5.\u047c(this))) {
            return false;
        }
        if (n3 == 0 && this.\u01d5.\u0523.\u044a() != oce4cea752dd.\u051d && this.\u0190(n, n2)) {
            this.\u01d5.\u0523.\u01e4(!this.\u01d5.\u0523.\u056c());
            if (oc2cf3d80e17.\u0115 != null) {
                oc2cf3d80e17.\u0115.\u01da().\u018b = false;
            }
            return true;
        }
        if (this.\u01d5.\u0523.canBeEnabled() && n3 == 0 && this.\u03c5(n, n2)) {
            this.\u04d3 = !this.\u04d3;
            return true;
        }
        if (this.\u01d5.\u0523.canBeEnabled() && n3 > 1 && this.\u04d3) {
            if (this.\u0565 != null) {
                this.\u0565.\u00c8(n3 + (0x5B3C093F ^ 0x5B3C0AD7));
            } else {
                this.\u01d5.\u0523.\u04dd(n3 + (0x5B3C093F ^ 0x5B3C0AD7));
            }
            if (oc2cf3d80e17.\u0115 != null) {
                oc2cf3d80e17.\u0115.\u01da().\u018b = false;
            }
            this.\u04d3 = false;
            return true;
        }
        return false;
    }

    private boolean \u0190(int n, int n2) {
        int n3 = this.\u043c();
        float f = this.\u021f(n3);
        float f2 = this.\u03ca(n3);
        return (float)n >= f && (float)n < f + (float)n3 && (float)n2 >= f2 && (float)n2 < f2 + (float)n3;
    }

    private float \u02b0() {
        return this.\u01d5.\u02a4.\u01a9() + 4.0f + this.\u042e * 0.5f;
    }

    private float N() {
        return this.\u01d5.\u02a4.\u0523() + this.\u0241 + (this.\u0565 == null ? 3.0f : 4.0f);
    }

    private float F() {
        return this.\u01d5.\u02a4.\u0406() + this.\u0241 + (this.\u0565 == null ? 3.0f : 4.0f);
    }

    private String \u01af() {
        if (this.\u0565 == null) {
            return !this.\u01d5.\u0523.canBeEnabled() ? "Module cannot be bound." : (this.\u04d3 ? "Press a key..." : "Current bind: '\u00a7e" + this.\u01d9(false) + "\u00a7r'");
        }
        return this.\u04d3 ? "Press a key..." : this.\u0565.z$18nrktuqeiysv() + ": '\u00a7e" + this.\u01d9(true) + "\u00a7r'";
    }

    private boolean \u03c5(int n, int n2) {
        String string = this.\u01af();
        oc1378bc114d oc1378bc114d2 = oc6a43806f12.\u044e();
        float f = this.\u02b0();
        float f2 = this.N();
        float f3 = (float)oc1378bc114d2.z$toz8pt08w0nc(string) * 0.5f;
        float f4 = (float)oc1378bc114d2.z$1tqmx4tpnr6lq() * 0.5f;
        return (float)n >= f && (float)n < f + f3 && (float)n2 >= f2 && (float)n2 < f2 + f4;
    }

    private int \u043c() {
        int n = Math.round((float)oc6a43806f12.\u044e().z$1tqmx4tpnr6lq() * 0.5f);
        return Math.max(0xC4B2608E ^ 0xC4B26088, n - 1);
    }

    private float \u021f(int n) {
        return this.\u01d5.\u02a4.\u01a9() + this.\u01d5.\u02a4.\u0232() - (float)n - 2.0f;
    }

    private float \u03ca(int n) {
        float f = this.N();
        float f2 = (float)oc6a43806f12.\u044e().z$1tqmx4tpnr6lq() * 0.5f;
        return f + (f2 - (float)n) / 2.0f;
    }

    @Override
    public void z$vm4dmbdypoel(int n) {
        if (!this.\u04d3 || n == 0) {
            return;
        }
        if (this.\u0565 != null) {
            this.\u0565.\u00c8(n > 0 ? 0xA22CE5BB ^ 0xA22CE196 : 0xA22CE5B8 ^ 0xA22CE196);
        } else {
            this.\u01d5.\u0523.\u04dd(n > 0 ? 0xA22CE5BB ^ 0xA22CE196 : 0xA22CE5B8 ^ 0xA22CE196);
        }
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
        this.\u04d3 = false;
    }

    @Override
    public void z$zr5dl604ndgu(char c, int n) {
        if (!this.\u04d3) {
            return;
        }
        if (n == (0x1F3AF81F ^ 0x1F3AF814) || n == 1) {
            if (this.\u01d5.\u0523 instanceof oc6a43806f12) {
                this.\u01d5.\u0523.\u04dd(0x1F3AF822 ^ 0x1F3AF814);
            } else if (this.\u0565 != null) {
                this.\u0565.\u00c8(0);
            } else {
                this.\u01d5.\u0523.\u04dd(0);
            }
        } else if (this.\u0565 != null) {
            this.\u0565.\u00c8(n);
        } else {
            this.\u01d5.\u0523.\u04dd(n);
        }
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
        this.\u04d3 = false;
    }

    public boolean V(int n, int n2) {
        float f = this.\u01d5.\u02a4.\u01a9();
        float f2 = this.\u01d5.\u02a4.\u0523() + this.\u0241;
        float f3 = this.\u01d5.\u02a4.\u0232();
        return (float)n > f && (float)n < f + f3 && (float)n2 > f2 - 1.0f && (float)n2 < f2 + 12.0f;
    }

    public String \u01d9(boolean bl) {
        int n;
        int n2 = n = bl ? this.\u0565.\u01fa() : this.\u01d5.\u0523.\u027d();
        return n >= (0x37D00AC6 ^ 0x37D0092E) ? (n == (0x37D00D03 ^ 0x37D0092E) || n == (0x37D00D00 ^ 0x37D0092E) ? this.\u011b(n) : "M" + (n - (0x37D00AC6 ^ 0x37D0092E))) : Keyboard.getKeyName(n);
    }

    public String \u011b(int n) {
        if (n == (0x9FE322A0 ^ 0x9FE3268D)) {
            return "MScrollUp";
        }
        if (n == (0x9FE322A3 ^ 0x9FE3268D)) {
            return "MScrollDown";
        }
        return "&cERROR";
    }

    @Override
    public float z$2rmsdj781vrn2() {
        return this.\u0565 != null ? 0.0f : 16.0f;
    }

    @Override
    public int z$1lb9sjzihunat() {
        return Math.round(this.z$2rmsdj781vrn2());
    }

    private void \u04b0(oc1378bc114d oc1378bc114d2, String string) {
        oc1378bc114d2.z$ao2ykh4tuw6w(string, (this.\u01d5.\u02a4.\u01a9() + 4.0f) * 2.0f + this.\u042e, (this.\u01d5.\u02a4.\u0406() + this.\u0241 + (float)(this.\u0565 == null ? 0x30CE1FD2 ^ 0x30CE1FD1 : 0x30CE1FD5 ^ 0x30CE1FD1)) * 2.0f, oc3542cefbeb.\u0189(oc3542cefbeb.\u0197[0], oc3542cefbeb.\u0197[1], 0.0), true);
    }

    @Override
    public void z$19sxbvum8v80h() {
        this.\u04d3 = false;
    }
}

