/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.block.Block;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import x.oc68d6b191af;

public class oc58525a3389
extends oc68d6b191af {
    public final BlockPos \u0463;
    public final Block \u0167;
    public AxisAlignedBB \u0173;
    public static int \u0552;

    public oc58525a3389(BlockPos blockPos, Block block, AxisAlignedBB axisAlignedBB) {
        this.\u0463 = blockPos;
        this.\u0167 = block;
        this.\u0173 = axisAlignedBB;
    }

    public BlockPos \u0134() {
        return this.\u0463;
    }

    public Block \u03d4() {
        return this.\u0167;
    }

    public AxisAlignedBB \u041e() {
        return this.\u0173;
    }

    public void \u011b(AxisAlignedBB axisAlignedBB) {
        this.\u0173 = axisAlignedBB;
    }
}

