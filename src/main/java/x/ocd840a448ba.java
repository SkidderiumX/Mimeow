/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import x.oc8edd24b1ed;

public class ocd840a448ba {
    private final BlockPos \u01a3;
    private final Vec3 \u0501;
    private final boolean \u01a9;
    private final BlockPos \u04ca;
    private final Vec3 \u0195;
    private final double \u01ea;
    private final int \u00d0;
    private final double \u04ee;

    private ocd840a448ba(BlockPos blockPos, Vec3 vec3, boolean bl, BlockPos blockPos2, Vec3 vec32, double d, int n, double d2) {
        this.\u01a3 = blockPos;
        this.\u0501 = vec3;
        this.\u01a9 = bl;
        this.\u04ca = blockPos2;
        this.\u0195 = vec32;
        this.\u01ea = d;
        this.\u00d0 = n;
        this.\u04ee = d2;
    }

    private boolean y(ocd840a448ba ocd840a448ba2) {
        return oc8edd24b1ed.\u01b6(this.\u01ea, this.\u00d0, this.\u04ee, ocd840a448ba2.\u01ea, ocd840a448ba2.\u00d0, ocd840a448ba2.\u04ee);
    }
}

