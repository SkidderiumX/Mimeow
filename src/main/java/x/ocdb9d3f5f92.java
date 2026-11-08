/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.N;
import x.oc205fefdaba;
import x.oc25aa89b91f;
import x.oc2f61de30bc;
import x.oc4ac72a2961;
import x.oc55585a6f85;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.oca9cc61aada;
import x.ocb610dcdc6f;
import x.ocbab3c9954b;
import x.occ394b37227;
import x.oce0f81dea63;
import x.oce4cea752dd;
import x.oce79181588d;

public abstract class ocdb9d3f5f92
extends oc69da1aa7f5 {
    private final oca9cc61aada \u01e0;
    private final String[] \u01cc;
    private final oc4ac72a2961[] \u0414;
    private int \u029b;
    public static int \u0390;

    protected ocdb9d3f5f92() {
        super("Disabler", oce4cea752dd.\u04a6);
        String[] stringArray = new String[0x64181FCD ^ 0x64181FCE];
        stringArray[0] = "VulcanScaffold";
        stringArray[1] = "DelayedTransaction";
        stringArray[0x64181FCC ^ 0x64181FCE] = "Miniblox";
        this.\u01cc = stringArray;
        this.\u0105("Use packets to try disable some AntiCheat checks.");
        this.\u01e0 = new oca9cc61aada("Mode", 0, this.\u01cc);
        this.\u028c(this.\u01e0);
        oc4ac72a2961[] oc4ac72a2961Array = new oc4ac72a2961[0x64181FCD ^ 0x64181FCE];
        oc4ac72a2961Array[0] = new occ394b37227(this);
        oc4ac72a2961Array[1] = new ocb610dcdc6f(this);
        oc4ac72a2961Array[0x64181FCC ^ 0x64181FCE] = new oce0f81dea63(this);
        this.\u0414 = oc4ac72a2961Array;
        this.\u029b = this.\u03ab();
        this.\u0181();
    }

    @Override
    public String getInfo() {
        String string;
        block6: {
            ocdb9d3f5f92 ocdb9d3f5f922;
            block4: {
                block5: {
                    boolean bl = oc4ac72a2961.\u01fe;
                    ocdb9d3f5f922 = this;
                    if (bl) break block4;
                    ocdb9d3f5f922.\u04f0();
                    if (!(this.\u0454() instanceof occ394b37227)) break block5;
                    string = "VulcanScaffold (retired)";
                    break block6;
                }
                ocdb9d3f5f922 = this;
            }
            string = ocdb9d3f5f922.\u0454().\u0405();
        }
        return string;
    }

    @Override
    public void z$2u87utkr1isxg() {
        this.\u04f0();
        this.\u0181();
    }

    @Override
    public void z$1sehylui0i4ix(oca9cc61aada oca9cc61aada2) {
        if (oca9cc61aada2 == this.\u01e0) {
            this.\u04f0();
            this.\u0181();
        }
    }

    @Override
    public void z$3tl278wzjcayb(N n) {
        this.\u04f0();
        this.\u0181();
    }

    @Override
    public void onEnable() {
        this.\u029b = this.\u03ab();
        this.\u0454().z$lg1k3tz4etot();
    }

    @Override
    public void onDisable() {
        this.\u0454().z$38kb8b9ql2ia2();
    }

    @oc66fa4f2195
    public void \u013b(oc2f61de30bc oc2f61de30bc2) {
        this.\u04f0();
        this.\u0454().z$2d31hhf4p6ldv(oc2f61de30bc2);
    }

    @oc66fa4f2195
    public void \u0540(oc25aa89b91f oc25aa89b91f2) {
        this.\u04f0();
        this.\u0454().z$gcybqtfqaji6(oc25aa89b91f2);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u00e4(oc205fefdaba oc205fefdaba2) {
        this.\u04f0();
        this.\u0454().z$3k8mdtemx7z2b(oc205fefdaba2);
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0288(oce79181588d oce79181588d2) {
        this.\u04f0();
        this.\u0454().z$clicwfc40ajs(oce79181588d2);
    }

    @oc66fa4f2195
    public void \u02ac(oc55585a6f85 oc55585a6f852) {
        this.\u04f0();
        this.\u0454().\u03b2(oc55585a6f852);
    }

    @oc66fa4f2195
    public void \u00e5(oc9d4393f3ce oc9d4393f3ce2) {
        this.\u04f0();
        this.\u0454().z$1ea7s7sj3pbka(oc9d4393f3ce2);
    }

    @oc66fa4f2195
    public void u(ocbab3c9954b ocbab3c9954b2) {
        block5: {
            boolean bl;
            block7: {
                block6: {
                    oc4ac72a2961[] oc4ac72a2961Array = this.\u0414;
                    int n = oc4ac72a2961Array.length;
                    boolean bl2 = oc4ac72a2961.\u01fe;
                    for (int i = 0; i < n; ++i) {
                        oc4ac72a2961 oc4ac72a29612 = oc4ac72a2961Array[i];
                        oc4ac72a29612.z$wf8ltemaqp1d(ocbab3c9954b2);
                        if (!bl2) continue;
                    }
                    if (!false) break block5;
                    if (!bl2) break block6;
                    bl = false;
                    break block7;
                }
                bl = true;
            }
            oc4ac72a2961.\u01fe = bl;
        }
    }

    private int \u03ab() {
        int n;
        int n2;
        block6: {
            ocdb9d3f5f92 ocdb9d3f5f922;
            block4: {
                block5: {
                    n2 = (int)this.\u01e0.\u04c1();
                    boolean bl = oc4ac72a2961.\u01fe;
                    ocdb9d3f5f922 = this;
                    if (bl) break block4;
                    if (ocdb9d3f5f922.\u0414 != null) break block5;
                    n = this.\u01cc.length - 1;
                    break block6;
                }
                ocdb9d3f5f922 = this;
            }
            n = ocdb9d3f5f922.\u0414.length - 1;
        }
        int n3 = n;
        return Math.max(0, Math.min(n2, n3));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void \u04f0() {
        ocdb9d3f5f92 ocdb9d3f5f922;
        block27: {
            ocdb9d3f5f92 ocdb9d3f5f923;
            block26: {
                int n;
                int n2;
                boolean bl;
                block24: {
                    block25: {
                        ocdb9d3f5f92 ocdb9d3f5f924;
                        block22: {
                            block23: {
                                block21: {
                                    bl = oc4ac72a2961.\u01fe;
                                    ocdb9d3f5f924 = this;
                                    if (bl) break block21;
                                    if (ocdb9d3f5f924.\u0414 == null) return;
                                    ocdb9d3f5f924 = this;
                                }
                                if (bl) break block22;
                                if (ocdb9d3f5f924.\u0414.length != 0) break block23;
                                return;
                            }
                            ocdb9d3f5f924 = this;
                        }
                        n2 = ocdb9d3f5f924.\u03ab();
                        n = n2;
                        if (bl) break block24;
                        if (n != this.\u029b) break block25;
                        return;
                    }
                    ocdb9d3f5f923 = this;
                    if (bl) break block26;
                    n = ocdb9d3f5f923.z$3rzb3dil7uydr() ? 1 : 0;
                }
                if (n != 0) {
                    this.\u0454().z$38kb8b9ql2ia2();
                }
                ocdb9d3f5f922 = this;
                if (bl) break block27;
                ocdb9d3f5f922.\u029b = n2;
                this.\u0181();
                ocdb9d3f5f923 = this;
            }
            if (!ocdb9d3f5f923.z$3rzb3dil7uydr()) return;
            ocdb9d3f5f922 = this;
        }
        ocdb9d3f5f922.\u0454().z$lg1k3tz4etot();
    }

    private oc4ac72a2961 \u0454() {
        return this.\u0414[this.\u029b];
    }

    final boolean \u00e6(oc4ac72a2961 oc4ac72a29612) {
        boolean bl;
        block8: {
            block7: {
                ocdb9d3f5f92 ocdb9d3f5f922;
                block6: {
                    boolean bl2 = oc4ac72a2961.\u01fe;
                    ocdb9d3f5f922 = this;
                    if (bl2) break block6;
                    if (ocdb9d3f5f922.\u0414 == null) break block7;
                    ocdb9d3f5f922 = this;
                }
                if (ocdb9d3f5f922.\u0454() != oc4ac72a29612) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }

    private void \u0181() {
        ocdb9d3f5f92 ocdb9d3f5f922;
        boolean bl;
        block5: {
            block6: {
                bl = oc4ac72a2961.\u01fe;
                ocdb9d3f5f922 = this;
                if (bl) break block5;
                if (ocdb9d3f5f922.\u0414 != null) break block6;
                return;
            }
            ocdb9d3f5f922 = this;
        }
        for (oc4ac72a2961 oc4ac72a29612 : ocdb9d3f5f922.\u0414) {
            oc4ac72a29612.z$3hx9xwukabx4k();
            if (!bl) continue;
        }
    }
}

