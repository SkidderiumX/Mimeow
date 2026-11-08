/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBlockBlob
extends WorldGenerator {
    private final Block field_150545_a;
    private final int field_150544_b;

    public WorldGenBlockBlob(Block block, int n) {
        super(false);
        this.field_150545_a = block;
        this.field_150544_b = n;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        while (true) {
            Block block;
            if (blockPos.getY() <= 3 || !world2.isAirBlock(blockPos.down()) && ((block = world2.getBlockState(blockPos.down()).getBlock()) == Blocks.grass || block == Blocks.dirt || block == Blocks.stone)) {
                if (blockPos.getY() <= 3) {
                    return false;
                }
                int n = this.field_150544_b;
                for (int i = 0; n >= 0 && i < 3; ++i) {
                    int n2 = n + random.nextInt(2);
                    int n3 = n + random.nextInt(2);
                    int n4 = n + random.nextInt(2);
                    float f = (float)(n2 + n3 + n4) * 0.333f + 0.5f;
                    for (BlockPos blockPos2 : BlockPos.getAllInBox(blockPos.add(-n2, -n3, -n4), blockPos.add(n2, n3, n4))) {
                        if (!(blockPos2.distanceSq(blockPos) <= (double)(f * f))) continue;
                        world2.setBlockState(blockPos2, this.field_150545_a.getDefaultState(), 4);
                    }
                    blockPos = blockPos.add(-(n + 1) + random.nextInt(2 + n * 2), 0 - random.nextInt(2), -(n + 1) + random.nextInt(2 + n * 2));
                }
                return true;
            }
            blockPos = blockPos.down();
        }
    }
}

