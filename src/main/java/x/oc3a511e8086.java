/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc161f4adba4;
import x.oc17aaf5d285;
import x.oc7ab2161b9f;
import x.ocaae9de8508;
import x.ocda171fe5d8;
import x.oce17079d3a9;

public class oc3a511e8086
extends oc161f4adba4 {
    public static int \u03f9;

    public oc3a511e8086() {
        super("name", "Copy your current username.", oc17aaf5d285.\u01e5, new String[]{"name"}, "ign");
    }

    @Override
    public void z$2uoow1halcq2f(ocaae9de8508 ocaae9de85082) {
        if (!oc7ab2161b9f.\u00d0()) {
            return;
        }
        oce17079d3a9.\u04b3(ocda171fe5d8.\u01d4.thePlayer.getName());
        this.\u0247("&7Copied &b" + ocda171fe5d8.\u01d4.thePlayer.getName() + " &7to clipboard");
    }
}

