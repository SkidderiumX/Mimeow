/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.entity.Entity;
import x.ocd296000981;

public enum oc210a0247ba {
    \u027e,
    \u045f,
    \u010f,
    \u0191;
    private static final oc210a0247ba[] $VALUES_REF;
    static {
        $VALUES_REF = oc210a0247ba.\u048a();
    }




public static boolean \u0291;



    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public double \u0443(Entity entity) {
        switch (ocd296000981.\u018d[this.ordinal()]) {
            case 1: 
            case 2: {
                return entity.getEyeHeight();
            }
            case 3: {
                return entity.height / 2.0f;
            }
            case 4: {
                return 0.0;
            }
        }
        return entity.getEyeHeight();
    }

    private static oc210a0247ba[] \u048a() {
        oc210a0247ba[] oc210a0247baArray = new oc210a0247ba[0x8836F73 ^ 0x8836F77];
        oc210a0247baArray[0] = \u027e;
        oc210a0247baArray[1] = \u045f;
        oc210a0247baArray[0x8836F75 ^ 0x8836F77] = \u010f;
        oc210a0247baArray[0x8836F74 ^ 0x8836F77] = \u0191;
        return oc210a0247baArray;
    }
}

