/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.utility;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import x.occb1ed1ed8f;
import x.ocda171fe5d8;

public class BlockUtils
extends occb1ed1ed8f {
    public static Block getBlock(BlockPos blockPos) {
        return BlockUtils.getBlockState(blockPos).getBlock();
    }

    public static Block getBlock(double d, double d2, double d3) {
        return BlockUtils.getBlockState(new BlockPos(d, d2, d3)).getBlock();
    }

    public static Block getBlock(Vec3 vec3) {
        return BlockUtils.getBlockState(new BlockPos(vec3.xCoord, vec3.yCoord, vec3.zCoord)).getBlock();
    }

    public static IBlockState getBlockState(BlockPos blockPos) {
        if (ocda171fe5d8.\u01d4.theWorld == null || blockPos == null) {
            return Blocks.air.getDefaultState();
        }
        return ocda171fe5d8.\u01d4.theWorld.getBlockState(blockPos);
    }
}

