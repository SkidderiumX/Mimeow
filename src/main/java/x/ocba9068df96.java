/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc076cd42cc3;
import x.oc1131978c8d;
import x.oc2bb55dd668;
import x.oc43a44da81e;
import x.oc5395d7bb80;
import x.ocbb1bc27172;

public class ocba9068df96
implements oc2bb55dd668 {
    private final oc43a44da81e \u01f6;
    private final oc076cd42cc3 \u0211;
    private volatile boolean \u044e;
    private volatile long \u051a;
    public static boolean \u0148;

    public ocba9068df96(oc43a44da81e oc43a44da81e2, oc076cd42cc3 oc076cd42cc32) {
        this.\u01f6 = oc43a44da81e2;
        this.\u0211 = oc076cd42cc32;
    }

    @Override
    public void z$2uy6urhda6qc2() {
        ocba9068df96 ocba9068df962;
        block4: {
            block5: {
                int n = ocbb1bc27172.\u050d;
                ocba9068df962 = this;
                if (n != 0) break block4;
                if (!ocba9068df962.\u044e) break block5;
                return;
            }
            this.\u044e = true;
            this.\u01f6.z$2uy6urhda6qc2();
            ocba9068df962 = this;
        }
        ocba9068df962.\u0211.z$2uy6urhda6qc2();
    }

    @Override
    public void z$kdc1k1k7jgxc() {
        this.\u044e = false;
        this.\u01f6.z$kdc1k1k7jgxc();
        this.\u0211.z$kdc1k1k7jgxc();
    }

    private boolean \u0535() {
        block14: {
            block16: {
                ocba9068df96 ocba9068df962;
                block15: {
                    long l;
                    block19: {
                        block20: {
                            long l2;
                            int n;
                            block17: {
                                block18: {
                                    n = ocbb1bc27172.\u050d;
                                    oc5395d7bb80 oc5395d7bb802 = this.\u01f6.z$2x2pifjatcjkd();
                                    if (n != 0) break block14;
                                    if (!oc5395d7bb802.\u048a()) break block15;
                                    ocba9068df962 = this;
                                    if (n != 0) break block16;
                                    if (!ocba9068df962.\u01f6.z$26y7m47raszk().\u04dc()) break block15;
                                    l2 = this.\u051a;
                                    if (n != 0) break block17;
                                    if (l2 != 0L) break block18;
                                    this.\u051a = System.currentTimeMillis();
                                }
                                l2 = System.currentTimeMillis() - this.\u051a;
                            }
                            long l3 = l2 - (0x553CB2B7C3887598L ^ 0x553CB2B7C3887E20L);
                            l = l3 == 0L ? 0 : (l3 < 0L ? -1 : 1);
                            if (n != 0) break block19;
                            if (l <= 0) break block20;
                            l = 1;
                            break block19;
                        }
                        l = 0;
                    }
                    return (boolean)l;
                }
                ocba9068df962 = this;
            }
            ocba9068df962.\u051a = 0L;
        }
        return false;
    }

    @Override
    public ocbb1bc27172 z$26y7m47raszk() {
        ocbb1bc27172 ocbb1bc271722;
        block6: {
            ocba9068df96 ocba9068df962;
            block4: {
                block5: {
                    int n = ocbb1bc27172.\u050d;
                    ocba9068df962 = this;
                    if (n != 0) break block4;
                    if (!ocba9068df962.\u0535()) break block5;
                    ocbb1bc271722 = this.\u01f6.z$26y7m47raszk();
                    break block6;
                }
                ocba9068df962 = this;
            }
            ocbb1bc271722 = ocba9068df962.\u0211.z$26y7m47raszk();
        }
        return ocbb1bc271722;
    }

    @Override
    public oc5395d7bb80 z$2x2pifjatcjkd() {
        ocba9068df96 ocba9068df962;
        block4: {
            block5: {
                int n = ocbb1bc27172.\u050d;
                ocba9068df962 = this;
                if (n != 0) break block4;
                if (!ocba9068df962.\u0535()) break block5;
                return this.\u01f6.z$2x2pifjatcjkd();
            }
            ocba9068df962 = this;
        }
        oc5395d7bb80 oc5395d7bb802 = ocba9068df962.\u0211.z$2x2pifjatcjkd();
        return new oc5395d7bb80(oc1131978c8d.\u0490, "Spotify unavailable; using Last.fm", oc5395d7bb802.\u03e2(), oc5395d7bb802.\u04ca());
    }

    @Override
    public String z$eij0v3yu6as3() {
        return "Auto";
    }

    @Override
    public boolean z$3c74bdt0l3yea() {
        return this.\u044e;
    }

    public oc43a44da81e \u0202() {
        return this.\u01f6;
    }
}

