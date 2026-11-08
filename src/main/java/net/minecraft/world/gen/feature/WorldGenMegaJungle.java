/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.BlockVine;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;

public class WorldGenMegaJungle
extends WorldGenHugeTrees {
    public WorldGenMegaJungle(boolean bl, int n, int n2, IBlockState iBlockState, IBlockState iBlockState2) {
        super(bl, n, n2, iBlockState, iBlockState2);
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        int n;
        int n2 = this.func_150533_a(random);
        if (!this.func_175929_a(world2, random, blockPos, n2)) {
            return false;
        }
        this.func_175930_c(world2, blockPos.up(n2), 2);
        for (n = blockPos.getY() + n2 - 2 - random.nextInt(4); n > blockPos.getY() + n2 / 2; n -= 2 + random.nextInt(4)) {
            int n3;
            float f = random.nextFloat() * (float)Math.PI * 2.0f;
            int n4 = blockPos.getX() + (int)(0.5f + MathHelper.cos(f) * 4.0f);
            int n5 = blockPos.getZ() + (int)(0.5f + MathHelper.sin(f) * 4.0f);
            for (n3 = 0; n3 < 5; ++n3) {
                n4 = blockPos.getX() + (int)(1.5f + MathHelper.cos(f) * (float)n3);
                n5 = blockPos.getZ() + (int)(1.5f + MathHelper.sin(f) * (float)n3);
                this.setBlockAndNotifyAdequately(world2, new BlockPos(n4, n - 3 + n3 / 2, n5), this.woodMetadata);
            }
            n3 = 1 + random.nextInt(2);
            int n6 = n;
            for (int i = n - n3; i <= n6; ++i) {
                int n7 = i - n6;
                this.func_175928_b(world2, new BlockPos(n4, i, n5), 1 - n7);
            }
        }
        for (n = 0; n < n2; ++n) {
            BlockPos blockPos2;
            BlockPos blockPos3;
            BlockPos blockPos4 = blockPos.up(n);
            if (this.func_150523_a(world2.getBlockState(blockPos4).getBlock())) {
                this.setBlockAndNotifyAdequately(world2, blockPos4, this.woodMetadata);
                if (n > 0) {
                    this.func_181632_a(world2, random, blockPos4.west(), BlockVine.EAST);
                    this.func_181632_a(world2, random, blockPos4.north(), BlockVine.SOUTH);
                }
            }
            if (n >= n2 - 1) continue;
            BlockPos blockPos5 = blockPos4.east();
            if (this.func_150523_a(world2.getBlockState(blockPos5).getBlock())) {
                this.setBlockAndNotifyAdequately(world2, blockPos5, this.woodMetadata);
                if (n > 0) {
                    this.func_181632_a(world2, random, blockPos5.east(), BlockVine.WEST);
                    this.func_181632_a(world2, random, blockPos5.north(), BlockVine.SOUTH);
                }
            }
            if (this.func_150523_a(world2.getBlockState(blockPos3 = blockPos4.south().east()).getBlock())) {
                this.setBlockAndNotifyAdequately(world2, blockPos3, this.woodMetadata);
                if (n > 0) {
                    this.func_181632_a(world2, random, blockPos3.east(), BlockVine.WEST);
                    this.func_181632_a(world2, random, blockPos3.south(), BlockVine.NORTH);
                }
            }
            if (!this.func_150523_a(world2.getBlockState(blockPos2 = blockPos4.south()).getBlock())) continue;
            this.setBlockAndNotifyAdequately(world2, blockPos2, this.woodMetadata);
            if (n <= 0) continue;
            this.func_181632_a(world2, random, blockPos2.west(), BlockVine.EAST);
            this.func_181632_a(world2, random, blockPos2.south(), BlockVine.NORTH);
        }
        return true;
    }

    private void func_181632_a(World world2, Random random, BlockPos blockPos, PropertyBool propertyBool) {
        if (random.nextInt(3) > 0 && world2.isAirBlock(blockPos)) {
            this.setBlockAndNotifyAdequately(world2, blockPos, Blocks.vine.getDefaultState().withProperty(propertyBool, true));
        }
    }

    private void func_175930_c(World world2, BlockPos blockPos, int n) {
        int n2 = 2;
        for (int i = -n2; i <= 0; ++i) {
            this.func_175925_a(world2, blockPos.up(i), n + 1 - i);
        }
    }
}

