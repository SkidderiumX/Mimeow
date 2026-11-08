/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.potion.Potion;
import x.oc69da1aa7f5;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc53d95c020d
extends oc69da1aa7f5 {
    public occ2f8dff8d8 \u0144;
    public occ2f8dff8d8 \u0585;
    public occ2f8dff8d8 \u04d0;
    public static boolean \u0174;

    public oc53d95c020d() {
        super("AntiDebuff", oce4cea752dd.\u014e);
        this.\u0105("Removes selected potion effects from your view.");
        this.\u0144 = new occ2f8dff8d8("Remove blindness", true);
        this.\u028c(this.\u0144);
        this.\u0585 = new occ2f8dff8d8("Remove nausea", true);
        this.\u028c(this.\u0585);
        this.\u04d0 = new occ2f8dff8d8("Remove side effects", false);
        this.\u028c(this.\u04d0);
    }

    public boolean \u013c(Potion potion) {
        boolean bl;
        block7: {
            block6: {
                boolean bl2 = oce6044968f8.\u0452;
                if (!this.z$3rzb3dil7uydr() || potion != Potion.blindness) break block6;
                bl = this.\u0144.\u01ed();
                if (bl2) break block7;
                if (!bl) break block6;
                bl = true;
                break block7;
            }
            bl = false;
        }
        return bl;
    }

    public boolean \u03b4(Potion potion) {
        boolean bl;
        block7: {
            block6: {
                boolean bl2 = oce6044968f8.\u0452;
                if (!this.z$3rzb3dil7uydr() || potion != Potion.confusion) break block6;
                bl = this.\u0585.\u01ed();
                if (bl2) break block7;
                if (!bl) break block6;
                bl = true;
                break block7;
            }
            bl = false;
        }
        return bl;
    }
}

