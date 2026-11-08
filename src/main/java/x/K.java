/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc25aa89b91f;
import x.oc2f61de30bc;
import x.oc3ffd24d7f4;
import x.oc55585a6f85;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc70db705765;
import x.oc86de9e2892;
import x.oc8ce2882092;
import x.oca9cc61aada;
import x.ocbb69a39dee;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce79181588d;

public abstract class K
extends oc69da1aa7f5 {
    private static final String[] \u04c9 = new String[]{"Legit"};
    public final oca9cc61aada \u046b;
    private final ocbb69a39dee[] \u04f7;
    private int \u011a;
    private boolean \u0271;
    public static int \u0276;

    protected K() {
        super("Speed", oce4cea752dd.\u0495, 0);
        this.\u0105("Bhop.");
        this.\u046b = new oca9cc61aada("Speed", 0, \u04c9);
        this.\u028c(this.\u046b);
        this.\u04f7 = new ocbb69a39dee[]{new oc3ffd24d7f4(this)};
        this.\u011a = this.\u0422();
        this.z$2u87utkr1isxg();
    }

    public final boolean \u0440(String string) {
        return this.\u043f().\u01b9().equals(string);
    }

    @Override
    public String getInfo() {
        this.\u04fb();
        return this.\u043f().\u01b9();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void z$2u87utkr1isxg() {
        this.\u04fb();
        ocbb69a39dee[] ocbb69a39deeArray = this.\u04f7;
        int n = ocbb69a39deeArray.length;
        int n2 = 0;
        boolean bl = ocbb69a39dee.\u0410;
        do {
            if (n2 >= n) return;
            ocbb69a39dee ocbb69a39dee2 = ocbb69a39deeArray[n2];
            ocbb69a39dee2.z$3p2wgqhd145z0();
            ++n2;
        } while (!bl);
    }

    @Override
    public void guiButtonToggled(occ2f8dff8d8 occ2f8dff8d82) {
        block4: {
            super.guiButtonToggled(occ2f8dff8d82);
            boolean bl = ocbb69a39dee.\u0410;
            for (ocbb69a39dee ocbb69a39dee2 : this.\u04f7) {
                if (!bl) {
                    ocbb69a39dee2.\u0181(occ2f8dff8d82);
                    if (!bl) continue;
                    break;
                }
                break block4;
            }
            this.z$2u87utkr1isxg();
        }
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        if (oca9cc61aada2 == this.\u046b) {
            this.\u04fb();
        }
        this.z$2u87utkr1isxg();
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        block8: {
            boolean bl = ocbb69a39dee.\u0410;
            if (n == this.\u046b) {
                this.\u04fb();
            }
            for (ocbb69a39dee ocbb69a39dee2 : this.\u04f7) {
                ocbb69a39dee2.\u0158(n);
                if (bl) break block8;
                if (!bl) continue;
                boolean bl2 = !false;
                oc69da1aa7f5.\u04ac = bl2;
                break;
            }
            this.z$2u87utkr1isxg();
        }
    }

    @Override
    public void onEnable() {
        this.\u04fb();
        this.\u0271 = true;
        this.\u043f().\u00ec();
        this.z$2u87utkr1isxg();
    }

    @Override
    public void onDisable() {
        this.\u043f().\u0292();
        this.\u0271 = false;
    }

    @oc66fa4f2195
    public void \u049f(oc2f61de30bc oc2f61de30bc2) {
        this.\u04fb();
        this.\u043f().\u039f(oc2f61de30bc2);
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u0286(oc86de9e2892 oc86de9e28922) {
        this.\u04fb();
        this.\u043f().\u0421(oc86de9e28922);
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u0289(oc70db705765 oc70db7057652) {
        this.\u04fb();
        this.\u043f().\u049c(oc70db7057652);
    }

    @oc66fa4f2195
    public void \u0103(oc25aa89b91f oc25aa89b91f2) {
        this.\u04fb();
        this.\u043f().z$232m1q68rrkqe(oc25aa89b91f2);
    }

    @oc66fa4f2195
    public void \u0249(oc55585a6f85 oc55585a6f852) {
        this.\u04fb();
        this.\u043f().m(oc55585a6f852);
    }

    @oc66fa4f2195(receiveCanceled=true)
    public void \u0468(oce79181588d oce79181588d2) {
        this.\u04fb();
        this.\u043f().\u01ae(oce79181588d2);
    }

    private void \u04fb() {
        block23: {
            K k;
            block22: {
                K k2;
                block21: {
                    int n;
                    int n2;
                    boolean bl;
                    block19: {
                        block20: {
                            K k3;
                            block17: {
                                block18: {
                                    bl = ocbb69a39dee.\u0410;
                                    k3 = this;
                                    if (bl) break block17;
                                    if (k3.\u04f7 != null) break block18;
                                    return;
                                }
                                k3 = this;
                            }
                            n2 = k3.\u0422();
                            n = n2;
                            if (bl) break block19;
                            if (n != this.\u011a) break block20;
                            return;
                        }
                        k2 = this;
                        if (bl) break block21;
                        n = k2.\u0271 ? 1 : 0;
                    }
                    if (n != 0) {
                        this.\u04f7[this.\u011a].\u0292();
                    }
                    k = this;
                    if (bl) break block22;
                    k.\u011a = n2;
                    k2 = this;
                }
                if (!k2.\u0271) break block23;
                k = this;
            }
            k.\u04f7[this.\u011a].\u00ec();
        }
    }

    private ocbb69a39dee \u043f() {
        return this.\u04f7[this.\u011a];
    }

    private int \u0422() {
        return Math.max(0, Math.min((int)this.\u046b.\u04c1(), this.\u04f7.length - 1));
    }
}

