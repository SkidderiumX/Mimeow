/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Collections;
import java.util.List;
import x.N;
import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.oca7b33a0538;
import x.ocaae9de8508;
import x.oced29a282d7;

public class ocebf11740c1
extends oc161f4adba4 {
    public static int \u0466;

    public ocebf11740c1() {
        super("namehider", "Set the replacement name used by Name Hider.", oc17aaf5d285.\u0127, new String[]{"namehider <name>"}, new String[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        ocaae9de8508 ocaae9de85083;
        block18: {
            int n;
            block17: {
                int n2;
                block14: {
                    oced29a282d7 oced29a282d72;
                    block16: {
                        block15: {
                            oced29a282d72 = this.\u02a9();
                            n2 = oc24b4725b15.\u0395;
                            if (oced29a282d72 == null) break block14;
                            n = ocaae9de85082.\u04fe();
                            if (n2 != 0) break block15;
                            if (n == 0) break block16;
                            n = this.\u03f4(oced29a282d72, ocaae9de85082) ? 1 : 0;
                        }
                        if (n2 != 0) break block17;
                        if (n == 0) break block14;
                    }
                    new oca7b33a0538(oced29a282d72).z$2uoow1halcq2f(ocaae9de85082);
                    return;
                }
                ocaae9de85083 = ocaae9de85082;
                if (n2 != 0) break block18;
                n = ocaae9de85083.\u04fe();
            }
            if (n == 0) {
                this.\u01fb();
                return;
            }
            ocaae9de85083 = ocaae9de85082;
        }
        oced29a282d7.\u00db(ocaae9de85083.\u037a(0));
        this.\u0247("&7Name has been set to &b" + oced29a282d7.\u024e + "&7.");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public List<String> z$9ofids0wyz4j(ocaae9de8508 ocaae9de85082) {
        int n;
        oced29a282d7 oced29a282d72;
        block8: {
            oced29a282d72 = this.\u02a9();
            int n2 = oc24b4725b15.\u0395;
            if (oced29a282d72 == null) return Collections.emptyList();
            n = ocaae9de85082.\u04fe();
            if (n2 != 0) break block8;
            if (n <= 1) return new oca7b33a0538(oced29a282d72).z$9ofids0wyz4j(ocaae9de85082);
            n = this.\u03f4(oced29a282d72, ocaae9de85082) ? 1 : 0;
        }
        if (n == 0) return Collections.emptyList();
        return new oca7b33a0538(oced29a282d72).z$9ofids0wyz4j(ocaae9de85082);
    }

    @Override
    public int z$7k2utc7u0w8s(ocaae9de8508 ocaae9de85082) {
        int n;
        block4: {
            block5: {
                int n2 = oc24b4725b15.\u0395;
                n = ocaae9de85082.\u04fe();
                if (n2 != 0) break block4;
                if (n > 1) break block5;
                n = 0;
                break block4;
            }
            n = 1;
        }
        return n;
    }

    private oced29a282d7 \u02a9() {
        int n;
        block8: {
            oced29a282d7 oced29a282d72;
            block7: {
                n = oc24b4725b15.\u0395;
                oced29a282d72 = oc9755810e45.\u03c8;
                if (n != 0) break block7;
                if (oced29a282d72 == null) break block8;
                oced29a282d72 = oc9755810e45.\u03c8;
            }
            return oced29a282d72;
        }
        for (oc69da1aa7f5 oc69da1aa7f52 : oc9755810e45.\u0154) {
            block10: {
                oc69da1aa7f5 oc69da1aa7f53;
                block9: {
                    oc69da1aa7f53 = oc69da1aa7f52;
                    if (n != 0) break block9;
                    if (!(oc69da1aa7f53 instanceof oced29a282d7)) break block10;
                    oc69da1aa7f53 = oc69da1aa7f52;
                }
                return (oced29a282d7)oc69da1aa7f53;
            }
            if (n == 0) continue;
        }
        return null;
    }

    private boolean \u03f4(oced29a282d7 oced29a282d72, ocaae9de8508 ocaae9de85082) {
        boolean bl;
        block17: {
            ocaae9de8508 ocaae9de85083;
            int n;
            block15: {
                block16: {
                    n = oc24b4725b15.\u0395;
                    ocaae9de85083 = ocaae9de85082;
                    if (n != 0) break block15;
                    if (ocaae9de85083.\u04fe() != 0) break block16;
                    return true;
                }
                ocaae9de85083 = ocaae9de85082;
            }
            String string = oca7b33a0538.\u00d8(ocaae9de85083.\u044c(0));
            for (N n2 : oced29a282d72.\u0260()) {
                block18: {
                    block19: {
                        bl = oca7b33a0538.\u00d8(n2.z$18nrktuqeiysv()).equals(string);
                        if (n != 0) break block17;
                        if (n != 0) break block18;
                        if (bl) break block19;
                        bl = oca7b33a0538.\u00d8(n2.z$3lm3x0je4b2zv()).equals(string);
                        if (n != 0) break block18;
                        if (bl) break block19;
                        if (n == 0) continue;
                    }
                    bl = true;
                }
                return bl;
            }
            bl = false;
        }
        return bl;
    }
}

