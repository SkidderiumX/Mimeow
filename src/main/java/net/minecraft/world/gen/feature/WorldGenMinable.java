/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import com.google.common.base.Predicate;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMinable
extends WorldGenerator {
    private final IBlockState oreBlock;
    private final int numberOfBlocks;
    private final Predicate<IBlockState> predicate;

    public WorldGenMinable(IBlockState iBlockState, int n) {
        this(iBlockState, n, BlockHelper.forBlock(Blocks.stone));
    }

    public WorldGenMinable(IBlockState iBlockState, int n, Predicate<IBlockState> predicate) {
        this.oreBlock = iBlockState;
        this.numberOfBlocks = n;
        this.predicate = predicate;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        float f = random.nextFloat() * (float)Math.PI;
        double d = (float)(blockPos.getX() + 8) + MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0f;
        double d2 = (float)(blockPos.getX() + 8) - MathHelper.sin(f) * (float)this.numberOfBlocks / 8.0f;
        double d3 = (float)(blockPos.getZ() + 8) + MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0f;
        double d4 = (float)(blockPos.getZ() + 8) - MathHelper.cos(f) * (float)this.numberOfBlocks / 8.0f;
        double d5 = blockPos.getY() + random.nextInt(3) - 2;
        double d6 = blockPos.getY() + random.nextInt(3) - 2;
        for (int i = 0; i < this.numberOfBlocks; ++i) {
            float f2 = (float)i / (float)this.numberOfBlocks;
            double d7 = d + (d2 - d) * (double)f2;
            double d8 = d5 + (d6 - d5) * (double)f2;
            double d9 = d3 + (d4 - d3) * (double)f2;
            double d10 = random.nextDouble() * (double)this.numberOfBlocks / 16.0;
            double d11 = (double)(MathHelper.sin((float)Math.PI * f2) + 1.0f) * d10 + 1.0;
            double d12 = (double)(MathHelper.sin((float)Math.PI * f2) + 1.0f) * d10 + 1.0;
            int n = MathHelper.floor_double(d7 - d11 / 2.0);
            int n2 = MathHelper.floor_double(d8 - d12 / 2.0);
            int n3 = MathHelper.floor_double(d9 - d11 / 2.0);
            int n4 = MathHelper.floor_double(d7 + d11 / 2.0);
            int n5 = MathHelper.floor_double(d8 + d12 / 2.0);
            int n6 = MathHelper.floor_double(d9 + d11 / 2.0);
            for (int j = n; j <= n4; ++j) {
                double d13 = ((double)j + 0.5 - d7) / (d11 / 2.0);
                if (!(d13 * d13 < 1.0)) continue;
                for (int k = n2; k <= n5; ++k) {
                    double d14 = ((double)k + 0.5 - d8) / (d12 / 2.0);
                    if (!(d13 * d13 + d14 * d14 < 1.0)) continue;
                    for (int i2 = n3; i2 <= n6; ++i2) {
                        BlockPos blockPos2;
                        double d15 = ((double)i2 + 0.5 - d9) / (d11 / 2.0);
                        if (!(d13 * d13 + d14 * d14 + d15 * d15 < 1.0) || !this.predicate.apply(world2.getBlockState(blockPos2 = new BlockPos(j, k, i2)))) continue;
                        world2.setBlockState(blockPos2, this.oreBlock, 2);
                    }
                }
            }
        }
        return true;
    }
}

