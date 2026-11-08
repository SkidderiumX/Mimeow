/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Set;
import net.minecraft.util.BlockPos;
import x.oce6044968f8;

public class oc20f324c8eb {
    private final long \u04fc;
    private final Set<Long> \u0525;
    private final Set<Long> \u04a9;

    private oc20f324c8eb(long l, Set<Long> set, Set<Long> set2) {
        this.\u04fc = l;
        this.\u0525 = set;
        this.\u04a9 = set2;
    }

    private boolean \u0280(BlockPos blockPos) {
        boolean bl;
        block5: {
            block4: {
                boolean bl2 = oce6044968f8.\u0452;
                if (blockPos == null) break block4;
                long l = this.\u04fc - blockPos.toLong();
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

