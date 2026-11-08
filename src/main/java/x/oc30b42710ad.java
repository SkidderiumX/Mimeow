/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.BlockPos;
import x.oc23ff80be39;
import x.oceb7a9b9a85;

public class oc30b42710ad {
    final oc23ff80be39 \u0147;
    final BlockPos \u0549;
    final oceb7a9b9a85 \u00f1;
    final double \u01d0;
    final double \u03d0;
    final double \u020e;
    final double U;
    final float \u03e1;
    final float \u0539;
    final float \u0448;
    final float \u00ec;

    oc30b42710ad(oc23ff80be39 oc23ff80be392, BlockPos blockPos, oceb7a9b9a85 oceb7a9b9a852, double d, double d2, double d3, double d4, float f, float f2, float f3, float f4) {
        this.\u0147 = oc23ff80be392;
        this.\u0549 = blockPos;
        this.\u00f1 = oceb7a9b9a852;
        this.\u01d0 = d;
        this.\u03d0 = d2;
        this.\u020e = d3;
        this.U = d4;
        this.\u03e1 = f;
        this.\u0539 = f2;
        this.\u0448 = f3;
        this.\u00ec = f4;
    }

    oc30b42710ad \u0370(boolean bl) {
        oceb7a9b9a85 oceb7a9b9a852 = new oceb7a9b9a85(this.\u00f1.\u0113, this.\u00f1.\u04e5, this.\u00f1.\u0187, this.\u00f1.\u0110, this.\u00f1.\u03bb, this.\u00f1.\u04c4, this.\u00f1.\u00da, bl);
        return new oc30b42710ad(this.\u0147, this.\u0549, oceb7a9b9a852, this.\u01d0, this.\u03d0, this.\u020e, this.U, this.\u03e1, this.\u0539, this.\u0448, this.\u00ec);
    }
}

