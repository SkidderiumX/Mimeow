/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.settings.KeyBinding;
import x.oc1378bc114d;
import x.oc7ab2161b9f;
import x.oc99b8eeba10;
import x.ocbd4917c4b1;
import x.oce6044968f8;

public class oc5dc0fabda3 {
    private final String \u04e2;
    private final KeyBinding \u00d2;
    private final float \u0154;
    private final float \u04d7;
    private final float \u0555;
    private final float \u0189;
    private float \u04d0;

    public oc5dc0fabda3(String string, KeyBinding keyBinding, float f, float f2, float f3, float f4) {
        this.\u04e2 = string;
        this.\u00d2 = keyBinding;
        this.\u0154 = f;
        this.\u04d7 = f2;
        this.\u0555 = f3;
        this.\u0189 = f4;
    }

    public oc99b8eeba10 \u0491(float f, float f2, float f3, oc1378bc114d oc1378bc114d2) {
        boolean bl;
        float f4;
        block2: {
            block3: {
                boolean bl2 = oce6044968f8.\u0452;
                oc5dc0fabda3 oc5dc0fabda32 = this;
                oc5dc0fabda3 oc5dc0fabda33 = oc5dc0fabda32;
                f4 = oc5dc0fabda32.\u04d0;
                bl = this.\u00d2.isKeyDown();
                if (bl2) break block2;
                if (!bl) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        oc5dc0fabda33.\u04d0 = f4 + ((float)bl - this.\u04d0) * 0.2f;
        float f5 = f + this.\u0154 * f3;
        float f6 = f2 + this.\u04d7 * f3;
        float f7 = this.\u0555 * f3;
        float f8 = this.\u0189 * f3;
        return new oc99b8eeba10(f5, f6, f7, f8, 1.0f, () -> this.q13kze75qwqcbc(oc1378bc114d2, f5, f7, f6, f8), () -> this.q1a9d0w7fbh5t8(f5, f6, f7, f8));
    }

    private void q1a9d0w7fbh5t8(float f, float f2, float f3, float f4) {
        block5: {
            float f5;
            block4: {
                boolean bl = oce6044968f8.\u0452;
                f5 = this.\u04d0;
                if (bl) break block4;
                if (!(f5 > 0.01f)) break block5;
                f5 = f;
            }
            ocbd4917c4b1.\u04da(f5, f2, f + f3, f2 + f4, oce6044968f8.\u0401(), oc7ab2161b9f.\u04ac(-1, Math.round(this.\u04d0 * 90.0f)));
        }
    }

    private void q13kze75qwqcbc(oc1378bc114d oc1378bc114d2, float f, float f2, float f3, float f4) {
        oc1378bc114d2.z$ao2ykh4tuw6w(this.\u04e2, f + (f2 - (float)oc1378bc114d2.z$toz8pt08w0nc(this.\u04e2)) / 2.0f, f3 + (f4 - (float)oc1378bc114d2.z$1tqmx4tpnr6lq()) / 2.0f, -1, false);
    }
}

