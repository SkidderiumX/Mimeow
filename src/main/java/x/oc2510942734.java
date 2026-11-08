/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc24b4725b15;
import x.ocaae9de8508;
import x.ocda171fe5d8;
import x.oced29a282d7;

public class oc2510942734
extends oc161f4adba4 {
    public static int \u04e2;

    public oc2510942734() {
        super("nick", "Set the nickname used by minigame chat matching.", oc17aaf5d285.\u0572, new String[]{"nick <name/reset>"}, new String[0]);
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        block13: {
            String string;
            block14: {
                ocaae9de8508 ocaae9de85083;
                int n;
                block10: {
                    block11: {
                        block12: {
                            n = oc24b4725b15.\u0395;
                            ocaae9de85083 = ocaae9de85082;
                            if (n != 0) break block10;
                            if (ocaae9de85083.\u04fe() != 0) break block11;
                            if (ocda171fe5d8.\u01d4 == null) break block12;
                            this.\u01fb();
                        }
                        return;
                    }
                    ocaae9de85083 = ocaae9de85082;
                }
                string = ocaae9de85083.\u037a(0);
                if (n != 0) break block13;
                if (!"reset".equalsIgnoreCase(string)) break block14;
                oced29a282d7.\u0440();
                this.\u027c("&aNick reset to Name Hider's default:");
                this.\u027c("\"" + oced29a282d7.\u024e + "\"");
                return;
            }
            oced29a282d7.\u00db(string);
            this.\u027c("&aNick has been set to:");
            this.\u027c("\"" + oced29a282d7.\u024e + "\"");
        }
    }

    private void \u027c(String string) {
        if (ocda171fe5d8.\u01d4 != null) {
            this.\u00e5(string);
        }
    }
}

