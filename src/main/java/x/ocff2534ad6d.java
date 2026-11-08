/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc24a0a5bddf;
import x.oc69da1aa7f5;
import x.occ2f8dff8d8;
import x.oce6044968f8;

public class ocff2534ad6d {
    private final occ2f8dff8d8 \u04b6;
    private final oc24a0a5bddf \u00e8;
    private final occ2f8dff8d8 \u01e7;
    private final oc24a0a5bddf \u037a;
    private final occ2f8dff8d8 \u0424;
    private final occ2f8dff8d8 \u04c2;

    private ocff2534ad6d(occ2f8dff8d8 occ2f8dff8d82, oc24a0a5bddf oc24a0a5bddf2, occ2f8dff8d8 occ2f8dff8d83, oc24a0a5bddf oc24a0a5bddf3, occ2f8dff8d8 occ2f8dff8d84, occ2f8dff8d8 occ2f8dff8d85) {
        this.\u04b6 = occ2f8dff8d82;
        this.\u00e8 = oc24a0a5bddf2;
        this.\u01e7 = occ2f8dff8d83;
        this.\u037a = oc24a0a5bddf3;
        this.\u0424 = occ2f8dff8d84;
        this.\u04c2 = occ2f8dff8d85;
    }

    private void \u04b6(oc69da1aa7f5 oc69da1aa7f52) {
        this.\u00e8.\u0209(this.\u04b6.\u01ed(), oc69da1aa7f52);
        this.\u037a.\u0209(this.\u01e7.\u01ed(), oc69da1aa7f52);
    }

    private boolean \u049b() {
        boolean bl;
        block6: {
            block8: {
                block7: {
                    boolean bl2 = oce6044968f8.\u0452;
                    bl = this.\u0176();
                    if (bl2) break block6;
                    if (bl) break block7;
                    bl = this.\u03e6();
                    if (bl2) break block6;
                    if (!bl) break block8;
                }
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    private boolean \u0176() {
        return this.\u04b6.\u01ed();
    }

    private int \u027b() {
        return this.\u00e8.\u0373();
    }

    private boolean \u03e6() {
        return this.\u01e7.\u01ed();
    }

    private int l() {
        return this.\u037a.\u0373();
    }

    private boolean \u0166() {
        return this.\u0424.\u01ed();
    }

    private boolean \u02b7() {
        return this.\u04c2.\u01ed();
    }
}

