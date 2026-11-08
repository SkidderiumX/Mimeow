/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import x.oc75d51ec7eb;

public class ocee6aeb382f {
    public final BlockPos \u03a7;
    public final Vec3 \u03e5;
    public final double \u04e9;
    public final int \u01af;
    public static boolean \u03ef;

    ocee6aeb382f(BlockPos blockPos, Vec3 vec3, double d, int n) {
        this.\u03a7 = blockPos;
        this.\u03e5 = vec3;
        this.\u04e9 = d;
        this.\u01af = n;
    }

    public boolean \u0546() {
        boolean bl;
        block2: {
            block3: {
                int n = oc75d51ec7eb.\u03e9;
                bl = this.\u01af;
                if (n != 0) break block2;
                if (bl <= false) break block3;
                bl = true;
                break block2;
            }
            bl = false;
        }
        return bl;
    }
}

