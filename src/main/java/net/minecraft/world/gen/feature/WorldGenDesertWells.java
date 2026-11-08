/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import com.google.common.base.Predicates;
import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDesertWells
extends WorldGenerator {
    private static final BlockStateHelper field_175913_a = BlockStateHelper.forBlock(Blocks.sand).where(BlockSand.VARIANT, Predicates.equalTo(BlockSand.EnumType.SAND));
    private final IBlockState field_175911_b = Blocks.stone_slab.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SAND).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
    private final IBlockState field_175912_c = Blocks.sandstone.getDefaultState();
    private final IBlockState field_175910_d = Blocks.flowing_water.getDefaultState();

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n;
        int n2;
        int n3;
        while (world2.isAirBlock(blockPos) && blockPos.getY() > 2) {
            blockPos = blockPos.down();
        }
        if (!field_175913_a.apply(world2.getBlockState(blockPos))) {
            return false;
        }
        for (n3 = -2; n3 <= 2; ++n3) {
            for (n2 = -2; n2 <= 2; ++n2) {
                if (!world2.isAirBlock(blockPos.add(n3, -1, n2)) || !world2.isAirBlock(blockPos.add(n3, -2, n2))) continue;
                return false;
            }
        }
        for (n3 = -1; n3 <= 0; ++n3) {
            for (n2 = -2; n2 <= 2; ++n2) {
                for (int i = -2; i <= 2; ++i) {
                    world2.setBlockState(blockPos.add(n2, n3, i), this.field_175912_c, 2);
                }
            }
        }
        world2.setBlockState(blockPos, this.field_175910_d, 2);
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            world2.setBlockState(blockPos.offset(enumFacing), this.field_175910_d, 2);
        }
        for (n = -2; n <= 2; ++n) {
            for (int i = -2; i <= 2; ++i) {
                if (n != -2 && n != 2 && i != -2 && i != 2) continue;
                world2.setBlockState(blockPos.add(n, 1, i), this.field_175912_c, 2);
            }
        }
        world2.setBlockState(blockPos.add(2, 1, 0), this.field_175911_b, 2);
        world2.setBlockState(blockPos.add(-2, 1, 0), this.field_175911_b, 2);
        world2.setBlockState(blockPos.add(0, 1, 2), this.field_175911_b, 2);
        world2.setBlockState(blockPos.add(0, 1, -2), this.field_175911_b, 2);
        for (n = -1; n <= 1; ++n) {
            for (int i = -1; i <= 1; ++i) {
                if (n == 0 && i == 0) {
                    world2.setBlockState(blockPos.add(n, 4, i), this.field_175912_c, 2);
                    continue;
                }
                world2.setBlockState(blockPos.add(n, 4, i), this.field_175911_b, 2);
            }
        }
        for (n = 1; n <= 3; ++n) {
            world2.setBlockState(blockPos.add(-1, n, -1), this.field_175912_c, 2);
            world2.setBlockState(blockPos.add(-1, n, 1), this.field_175912_c, 2);
            world2.setBlockState(blockPos.add(1, n, -1), this.field_175912_c, 2);
            world2.setBlockState(blockPos.add(1, n, 1), this.field_175912_c, 2);
        }
        return true;
    }
}

