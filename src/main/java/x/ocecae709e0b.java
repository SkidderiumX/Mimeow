/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.List;
import net.minecraft.util.BlockPos;
import x.oc8c33630684;
import x.oce6044968f8;

public class ocecae709e0b {
    private final long \u014f;
    private final List<oc8c33630684> \u0583;

    private ocecae709e0b(BlockPos blockPos, List<oc8c33630684> list) {
        this.\u014f = blockPos.toLong();
        this.\u0583 = list;
    }

    private boolean \u0110(BlockPos blockPos) {
        boolean bl;
        block5: {
            block4: {
                boolean bl2 = oce6044968f8.\u0452;
                if (blockPos == null) break block4;
                long l = this.\u014f - blockPos.toLong();
                bl = l == 0L ? 0 : (l < 0L ? -1 : 1);
                if (bl2) break block5;
                if (bl) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }
}

