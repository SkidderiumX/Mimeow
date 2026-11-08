/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import x.oc1990c51762;
import x.oc7ab2161b9f;
import x.oc9e2e8d26de;
import x.ocab66880042;
import x.ocdf3e495c45;
import x.oce33cf14e5f;
import x.oce490879787;

public class oc3c7712a8ae
implements oc1990c51762 {
    final ocdf3e495c45 this$0;

    private oc3c7712a8ae(ocdf3e495c45 ocdf3e495c452) {
        this.this$0 = ocdf3e495c452;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$1ain9rmcif72c(String string, String string2) {
        block15: {
            oc3c7712a8ae oc3c7712a8ae2;
            block13: {
                ocdf3e495c45 ocdf3e495c452;
                boolean bl;
                block14: {
                    oc3c7712a8ae oc3c7712a8ae3;
                    block12: {
                        bl = oce490879787.\u0583;
                        oc3c7712a8ae3 = this;
                        if (bl) break block12;
                        if (!oc3c7712a8ae3.this$0.\u0198) return;
                        oc3c7712a8ae3 = this;
                    }
                    ocdf3e495c452 = oc3c7712a8ae3.this$0;
                    if (bl) break block13;
                    if (ocdf3e495c452.\u0586) break block14;
                    return;
                }
                oc3c7712a8ae2 = this;
                if (bl) break block15;
                ocdf3e495c452 = oc3c7712a8ae2.this$0;
            }
            ocdf3e495c452.\u02e1 = 0;
            if (string2.isEmpty()) return;
            oc3c7712a8ae2 = this;
        }
        oc3c7712a8ae2.this$0.\u015e = string2;
    }

    @Override
    public void z$3m9gi0rwxy1yd(String string) {
        block4: {
            oc3c7712a8ae oc3c7712a8ae2;
            block5: {
                boolean bl = oce490879787.\u0583;
                oc3c7712a8ae2 = this;
                if (bl) break block4;
                if (oc3c7712a8ae2.this$0.\u0198) break block5;
                return;
            }
            this.this$0.\u04da();
            this.this$0.\u010d = System.currentTimeMillis();
            oc3c7712a8ae2 = this;
        }
        oc3c7712a8ae2.this$0.\u0212 = "IRC authentication failed: " + string;
    }

    @Override
    public void z$1vednwtdjjo44(oce33cf14e5f oce33cf14e5f2) {
        block33: {
            ocdf3e495c45 ocdf3e495c452;
            block34: {
                boolean bl;
                block32: {
                    int n;
                    block28: {
                        block29: {
                            block30: {
                                oc3c7712a8ae oc3c7712a8ae2;
                                block31: {
                                    block26: {
                                        block27: {
                                            block25: {
                                                ocdf3e495c45 ocdf3e495c453;
                                                block24: {
                                                    bl = oce490879787.\u0583;
                                                    ocdf3e495c453 = this.this$0;
                                                    if (bl) break block24;
                                                    if (!ocdf3e495c453.\u0198) break block25;
                                                    ocdf3e495c453 = this.this$0;
                                                }
                                                n = ocdf3e495c453.\u0586;
                                                if (bl) break block26;
                                                if (n != 0) break block27;
                                            }
                                            return;
                                        }
                                        n = oce33cf14e5f2.\u0478().isEmpty();
                                    }
                                    if (bl) break block28;
                                    if (n != 0) break block29;
                                    oc3c7712a8ae2 = this;
                                    if (bl) break block30;
                                    if (oc3c7712a8ae2.this$0.\u015e.isEmpty()) break block31;
                                    n = oce33cf14e5f2.\u0478().compareTo(this.this$0.\u015e);
                                    if (bl) break block28;
                                    if (n <= 0) break block29;
                                }
                                oc3c7712a8ae2 = this;
                            }
                            oc3c7712a8ae2.this$0.\u015e = oce33cf14e5f2.\u0478();
                        }
                        ocdf3e495c452 = this.this$0;
                        if (bl) break block32;
                        n = ocdf3e495c452.\u0408;
                    }
                    if (n == 0) break block33;
                    ocdf3e495c452 = this.this$0;
                }
                if (bl) break block34;
                if (!ocdf3e495c452.\u03a0(oce33cf14e5f2.\u04ef())) break block33;
                ocdf3e495c452 = this.this$0;
            }
            ocdf3e495c452.\u03e3(oce33cf14e5f2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void z$2wpt8ptpuefzs(List<ocab66880042> list, int n) {
        block9: {
            oc3c7712a8ae oc3c7712a8ae2;
            block10: {
                boolean bl;
                block8: {
                    bl = oce490879787.\u0583;
                    oc3c7712a8ae2 = this;
                    if (bl) break block8;
                    if (!oc3c7712a8ae2.this$0.\u0198) return;
                    oc3c7712a8ae2 = this;
                }
                if (bl) break block9;
                if (oc3c7712a8ae2.this$0.\u0586) break block10;
                return;
            }
            oc3c7712a8ae2 = this;
        }
        oc3c7712a8ae2.this$0.\u0181 = n;
        oc9e2e8d26de.\u0233(list);
    }

    @Override
    public void z$4rxrffi8xyrb(String string) {
        block14: {
            boolean bl;
            block16: {
                ocdf3e495c45 ocdf3e495c452;
                boolean bl2;
                block15: {
                    oc3c7712a8ae oc3c7712a8ae2;
                    block13: {
                        bl2 = oce490879787.\u0583;
                        oc3c7712a8ae2 = this;
                        if (bl2) break block13;
                        if (!oc3c7712a8ae2.this$0.\u0198) break block14;
                        oc3c7712a8ae2 = this;
                    }
                    ocdf3e495c452 = oc3c7712a8ae2.this$0;
                    if (bl2) break block15;
                    if (!ocdf3e495c452.\u0586) break block14;
                    ocdf3e495c452 = this.this$0;
                }
                bl = ocdf3e495c452.\u0408;
                if (bl2) break block16;
                if (!bl) break block14;
                bl = oc7ab2161b9f.\u00d0();
            }
            if (bl) {
                this.this$0.\u0434(string, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void z$2o0lr31w38sle() {
        block9: {
            this.this$0.\u0181 = 0;
            oc9e2e8d26de.\u0401();
            boolean bl = oce490879787.\u0583;
            ocdf3e495c45 ocdf3e495c452 = this.this$0;
            synchronized (ocdf3e495c452) {
                block8: {
                    oc3c7712a8ae oc3c7712a8ae2 = this;
                    if (!bl) {
                        if (!oc3c7712a8ae2.this$0.\u0586) {
                            this.this$0.\u0578 = false;
                            this.this$0.\u0414 = false;
                            return;
                        }
                        oc3c7712a8ae2 = this;
                    }
                    if (bl) break block8;
                    if (!oc3c7712a8ae2.this$0.\u04e6) break block9;
                    oc3c7712a8ae2 = this;
                }
                oc3c7712a8ae2.this$0.\u0578 = true;
                return;
            }
        }
        this.this$0.\u00c8(this.this$0.\u0506());
    }
}

