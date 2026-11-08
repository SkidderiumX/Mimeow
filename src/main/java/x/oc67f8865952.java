/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayList;
import java.util.List;
import keystrokesmod.script.Manager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Keyboard;
import x.N;
import x.oc255ab955c3;
import x.oc2cf3d80e17;
import x.oc5e2e2031b5;
import x.oc69da1aa7f5;
import x.oc6a43806f12;
import x.ocbd4917c4b1;
import x.ocd935250e5d;
import x.oce4cea752dd;
import x.ocf65052963e;

public class oc67f8865952 {
    private static final long \u04e4 = 220L;
    private final oc69da1aa7f5 \u0116;
    private final List<oc5e2e2031b5> \u04d2 = new ArrayList<oc5e2e2031b5>();
    private final ocd935250e5d \u0169 = new ocd935250e5d(15.0f);
    private int \u00c2;
    private int \u0459;
    private int \u00aa;
    private int \u0134;
    private boolean \u0543;
    private boolean \u014b;

    oc67f8865952(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u0116 = oc69da1aa7f52;
        this.\u03f3();
    }

    void \u0376(int n, int n2) {
        float f;
        float f2;
        boolean bl = oc255ab955c3.\u050e(this.\u00c2, this.\u0459, this.\u00aa, 15.0f, n, n2);
        int n3 = oc255ab955c3.\u01ea((double)this.\u00c2 + (double)this.\u00aa * 0.5, (double)this.\u0459 + 7.5);
        int n4 = this.\u0116.z$3rzb3dil7uydr() ? 0xE4E1EB7E ^ 0x1BC8C257 : oc255ab955c3.\u0432(this.\u0134);
        Gui.drawRect(this.\u00c2, this.\u0459, this.\u00c2 + this.\u00aa, this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257), n4);
        if (this.\u0116.z$3rzb3dil7uydr()) {
            Gui.drawRect(this.\u00c2, this.\u0459, this.\u00c2 + this.\u00aa, this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257), oc255ab955c3.\u0515(n3, bl ? 0x1BC8C2D5 ^ 0x1BC8C257 : 0x1BC8C20D ^ 0x1BC8C257));
            Gui.drawRect(this.\u00c2, this.\u0459, this.\u00c2 + (0x1BC8C255 ^ 0x1BC8C257), this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257), n3);
        } else if (bl) {
            Gui.drawRect(this.\u00c2, this.\u0459, this.\u00c2 + this.\u00aa, this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257), 0x8DD1DB4E ^ 0x1BC8C257);
        }
        boolean bl2 = oc67f8865952.\u01d1();
        Object object = this.\u0116.getDisplayName();
        if (this.\u014b) {
            object = (String)object + " [Binding...]";
        } else if (bl2 && this.\u0116.\u056c()) {
            object = (String)object + " [Hidden]";
        } else if (!bl2 && this.\u0116.\u027d() != 0) {
            object = (String)object + " [" + oc67f8865952.\u017f(this.\u0116.\u027d()) + "]";
        }
        object = oc255ab955c3.\u0516((String)object, oc255ab955c3.B(), this.\u00aa - (this.\u041f() ? 0x1BC8C245 ^ 0x1BC8C257 : 0x1BC8C251 ^ 0x1BC8C257));
        oc255ab955c3.B().z$ao2ykh4tuw6w((String)object, this.\u00c2 + (0x1BC8C252 ^ 0x1BC8C257), oc255ab955c3.\u0544(this.\u0459, 0x1BC8C258 ^ 0x1BC8C257, oc255ab955c3.B()), -1, true);
        if (this.\u041f()) {
            this.\u0440(this.\u0543 ? n3 : (this.\u0116.z$3rzb3dil7uydr() ? n3 : 0xE4565CC9 ^ 0x1BC8C257));
        }
        if ((f2 = Math.max(0.0f, (f = this.\u0231()) - 15.0f)) <= 0.0f) {
            return;
        }
        ocbd4917c4b1.\u010e(this.\u00c2, this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257), this.\u00aa, f2);
        this.\u0466(n3);
        int n5 = this.\u0459 + (0x1BC8C258 ^ 0x1BC8C257);
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.\u00ce()) continue;
            oc5e2e2031b52.\u02b8(this.\u00c2 + (0x1BC8C254 ^ 0x1BC8C257), n5, this.\u00aa - (0x1BC8C254 ^ 0x1BC8C257));
            oc5e2e2031b52.z$1v7hdj78iia5d(n, n2);
            n5 += oc5e2e2031b52.z$ag4eb8ubl7je();
        }
        ocbd4917c4b1.\u01df();
    }

    boolean \u0290(int n, int n2, int n3) {
        if (oc255ab955c3.\u050e(this.\u00c2, this.\u0459, this.\u00aa, 15.0f, n, n2)) {
            this.\u04df();
            if (this.\u014b && n3 > 1) {
                this.\u0116.\u04dd(n3 + (0xBFB7BBA ^ 0xBFB7852));
                this.\u014b = false;
                this.\u046f();
                return true;
            }
            if (n3 == 0 && this.\u0116.canBeEnabled() && !(this.\u0116 instanceof oc6a43806f12)) {
                this.\u0116.z$11p1yfisf2riw();
            } else if (n3 == 1 && this.\u041f()) {
                boolean bl = this.\u0543 = !this.\u0543;
                if (!this.\u0543) {
                    this.\u04df();
                }
            } else if (n3 == (0xBFB7850 ^ 0xBFB7852) && this.\u0116.\u044a() != oce4cea752dd.\u051d) {
                if (this.\u0116.\u044a() == oce4cea752dd.\u057c && !(this.\u0116 instanceof Manager)) {
                    Minecraft minecraft = Minecraft.getMinecraft();
                    minecraft.displayGuiScreen(new ocf65052963e(minecraft.currentScreen, this.\u0116.z$3i8m9vxwuvqj0() + ".java"));
                    return true;
                }
                if (Keyboard.isKeyDown(0xBFB7878 ^ 0xBFB7852) || Keyboard.isKeyDown(0xBFB7864 ^ 0xBFB7852)) {
                    this.\u0116.\u01e4(!this.\u0116.\u056c());
                    this.\u046f();
                } else if (this.\u0116.canBeEnabled()) {
                    this.\u014b = true;
                }
            }
            return true;
        }
        if (!this.\u0543 || !oc255ab955c3.\u050e(this.\u00c2, this.\u0459 + (0xBFB785D ^ 0xBFB7852), this.\u00aa, Math.max(0.0f, this.\u0231() - 15.0f), n, n2)) {
            return false;
        }
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.\u00ce() || !oc5e2e2031b52.z$1u23iokff6gve(n, n2, n3)) continue;
            for (oc5e2e2031b5 oc5e2e2031b53 : this.\u04d2) {
                if (oc5e2e2031b53 == oc5e2e2031b52) continue;
                oc5e2e2031b53.z$1l3ht5d17kefg();
            }
            return true;
        }
        return false;
    }

    void c(int n, int n2, int n3) {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            oc5e2e2031b52.z$rq44izq02hqg(n, n2, n3);
        }
    }

    boolean \u0586(char c, int n) {
        if (this.\u014b) {
            if (n == 1 || n == (0x36E9D10C ^ 0x36E9D107)) {
                this.\u0116.\u04dd(this.\u0116 instanceof oc6a43806f12 ? 0x36E9D131 ^ 0x36E9D107 : 0);
            } else {
                this.\u0116.\u04dd(n);
            }
            this.\u014b = false;
            this.\u046f();
            return true;
        }
        if (!this.\u0543) {
            return false;
        }
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.z$3twgyf5k61sst(c, n)) continue;
            return true;
        }
        return false;
    }

    boolean \u04df(int n, int n2, int n3) {
        if (this.\u014b) {
            this.\u0116.\u04dd(n3 > 0 ? 0x2D9EAC2E ^ 0x2D9EA803 : 0x2D9EAC2D ^ 0x2D9EA803);
            this.\u014b = false;
            this.\u046f();
            return true;
        }
        if (!this.\u0543) {
            return false;
        }
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.\u00ce() || !oc5e2e2031b52.z$3kj7psbv4c9hb(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    void \u04df() {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            oc5e2e2031b52.z$1l3ht5d17kefg();
        }
    }

    void \u0564() {
        this.\u014b = false;
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            oc5e2e2031b52.z$3hwl7t34zws09();
        }
        this.\u0169.\u04ca(this.\u0131());
    }

    int \u04b8() {
        return Math.max(0x1D5BDDEB ^ 0x1D5BDDE4, Math.round(this.\u0231()));
    }

    void \u0214(int n, int n2, int n3) {
        this.\u00c2 = n;
        this.\u0459 = n2;
        this.\u00aa = n3;
    }

    void \u0476(int n) {
        this.\u0134 = n;
    }

    oc69da1aa7f5 \u040d() {
        return this.\u0116;
    }

    void \u0405(oc67f8865952 oc67f88659522) {
        this.\u0543 = oc67f88659522.\u0543;
        this.\u0169.\u04ca(this.\u0131());
    }

    private void \u03f3() {
        this.\u04d2.clear();
        for (N n : this.\u0116.\u02b7()) {
            if (oc5e2e2031b5.\u0194(n) != null) continue;
            this.\u04d2.add(oc5e2e2031b5.\u0208(n, this.\u0116, this.\u0116.\u0260()));
        }
    }

    private boolean \u041f() {
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.\u00ce()) continue;
            return true;
        }
        return false;
    }

    float \u0231() {
        this.\u0169.\u0392(this.\u0131(), 0xBFDE36F1FE0EE1ABL ^ 0xBFDE36F1FE0EE177L);
        return this.\u0169.\u02b1();
    }

    private float \u0131() {
        float f = 15.0f;
        if (!this.\u0543) {
            return f;
        }
        for (oc5e2e2031b5 oc5e2e2031b52 : this.\u04d2) {
            if (!oc5e2e2031b52.\u00ce()) continue;
            f += (float)oc5e2e2031b52.z$ag4eb8ubl7je();
        }
        return f;
    }

    private void \u0440(int n) {
        if (!oc255ab955c3.\u01ca(this.\u0543 ? "expand" : "collapse", this.\u00c2 + this.\u00aa - (0x7A95A0F ^ 0x7A95A03), this.\u0459 + (0x7A95A06 ^ 0x7A95A03), 0x7A95A0B ^ 0x7A95A03, 0x7A95A06 ^ 0x7A95A03, n)) {
            oc255ab955c3.B().z$ao2ykh4tuw6w(this.\u0543 ? "-" : "+", this.\u00c2 + this.\u00aa - (0x7A95A09 ^ 0x7A95A03), this.\u0459 + (0x7A95A00 ^ 0x7A95A03), n, false);
        }
    }

    private void \u0466(int n) {
        int n2 = this.\u0459 + (0x8A2D330D ^ 0x8A2D3302);
        int n3 = Math.max(0, Math.round(this.\u0131() - 15.0f));
        Gui.drawRect(this.\u00c2, n2, this.\u00c2 + this.\u00aa, n2 + n3, 0x75392716 ^ 0x8A2D3302);
        int n4 = 0;
        int n5 = 0;
        while (n4 < n3) {
            int n6 = Math.min(n2 + n3, n2 + n4 + (0x8A2D330D ^ 0x8A2D3302));
            Gui.drawRect(this.\u00c2 + (0x8A2D3300 ^ 0x8A2D3302), n2 + n4, this.\u00c2 + this.\u00aa, n6, oc255ab955c3.\u0269(n5));
            n4 += 15;
            ++n5;
        }
        n4 = this.\u0116.z$3rzb3dil7uydr() ? n : 0x75110F3E ^ 0x8A2D3302;
        Gui.drawRect(this.\u00c2, n2, this.\u00c2 + (0x8A2D3300 ^ 0x8A2D3302), n2 + n3, n4);
        Gui.drawRect(this.\u00c2, n2, this.\u00c2 + this.\u00aa, n2 + 1, 0x753D2312 ^ 0x8A2D3302);
        Gui.drawRect(this.\u00c2, n2 + n3 - 1, this.\u00c2 + this.\u00aa, n2 + n3, 0x753D2312 ^ 0x8A2D3302);
    }

    private void \u046f() {
        if (oc2cf3d80e17.\u0115 != null) {
            oc2cf3d80e17.\u0115.\u01da().\u018b = false;
        }
    }

    static String \u017f(int n) {
        if (n == (0xCD3DE117 ^ 0xCD3DE53A)) {
            return "MScrollUp";
        }
        if (n == (0xCD3DE114 ^ 0xCD3DE53A)) {
            return "MScrollDown";
        }
        if (n >= (0xCD3DE6D2 ^ 0xCD3DE53A)) {
            return "M" + (n - (0xCD3DE6D2 ^ 0xCD3DE53A));
        }
        String string = Keyboard.getKeyName(n);
        return string == null ? "None" : string;
    }

    private static boolean \u01d1() {
        return Keyboard.isKeyDown(0x8C6BBBDC ^ 0x8C6BBBC1) || Keyboard.isKeyDown(0x8C6BBB5C ^ 0x8C6BBBC1);
    }
}

