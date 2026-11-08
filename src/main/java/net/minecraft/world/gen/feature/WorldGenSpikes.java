/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSpikes
extends WorldGenerator {
    private Block baseBlockRequired;

    public WorldGenSpikes(Block block) {
        this.baseBlockRequired = block;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        if (world2.isAirBlock(blockPos) && world2.getBlockState(blockPos.down()).getBlock() == this.baseBlockRequired) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5 = random.nextInt(32) + 6;
            int n6 = random.nextInt(4) + 1;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (n4 = blockPos.getX() - n6; n4 <= blockPos.getX() + n6; ++n4) {
                for (n3 = blockPos.getZ() - n6; n3 <= blockPos.getZ() + n6; ++n3) {
                    n2 = n4 - blockPos.getX();
                    if (n2 * n2 + (n = n3 - blockPos.getZ()) * n > n6 * n6 + 1 || world2.getBlockState(mutableBlockPos.set(n4, blockPos.getY() - 1, n3)).getBlock() == this.baseBlockRequired) continue;
                    return false;
                }
            }
            for (n4 = blockPos.getY(); n4 < blockPos.getY() + n5 && n4 < 256; ++n4) {
                for (n3 = blockPos.getX() - n6; n3 <= blockPos.getX() + n6; ++n3) {
                    for (n2 = blockPos.getZ() - n6; n2 <= blockPos.getZ() + n6; ++n2) {
                        int n7;
                        n = n3 - blockPos.getX();
                        if (n * n + (n7 = n2 - blockPos.getZ()) * n7 > n6 * n6 + 1) continue;
                        world2.setBlockState(new BlockPos(n3, n4, n2), Blocks.obsidian.getDefaultState(), 2);
                    }
                }
            }
            EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal(world2);
            entityEnderCrystal.setLocationAndAngles((float)blockPos.getX() + 0.5f, blockPos.getY() + n5, (float)blockPos.getZ() + 0.5f, random.nextFloat() * 360.0f, 0.0f);
            world2.spawnEntityInWorld(entityEnderCrystal);
            world2.setBlockState(blockPos.up(n5), Blocks.bedrock.getDefaultState(), 2);
            return true;
        }
        return false;
    }
}

