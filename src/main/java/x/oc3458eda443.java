/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.MathHelper;
import x.oc84f20a0bc5;
import x.ocbce5ea28a3;

public class oc3458eda443 {
    final float \u03c9;
    final float \u056d;

    oc3458eda443(float f, float f2) {
        this.\u03c9 = f;
        this.\u056d = f2;
    }

    static oc3458eda443 \u01b9(float f, float f2) {
        return new oc3458eda443(f, f2);
    }

    boolean c(float f, float f2, float f3) {
        float f4;
        block8: {
            block7: {
                oc3458eda443 oc3458eda4432;
                int n;
                float f5;
                block6: {
                    f5 = Math.max(1.0E-4f, ocbce5ea28a3.\u046b(f3) * 0.51f);
                    n = oc84f20a0bc5.\u0117;
                    oc3458eda4432 = this;
                    if (n != 0) break block6;
                    if (!(Math.abs(MathHelper.wrapAngleTo180_float(oc3458eda4432.\u03c9 - f)) <= f5)) break block7;
                    oc3458eda4432 = this;
                }
                float f6 = Math.abs(oc3458eda4432.\u056d - f2) - f5;
                f4 = f6 == 0.0f ? 0 : (f6 < 0.0f ? -1 : 1);
                if (n != 0) break block8;
                if (f4 > 0) break block7;
                f4 = 1.0f;
                break block8;
            }
            f4 = 0.0f;
        }
        return (boolean)f4;
    }
}

