/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import java.util.Random;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDoublePlant
extends WorldGenerator {
    private BlockDoublePlant.EnumPlantType field_150549_a;

    public void setPlantType(BlockDoublePlant.EnumPlantType enumPlantType) {
        this.field_150549_a = enumPlantType;
    }

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        boolean bl = false;
        for (int i = 0; i < 64; ++i) {
            BlockPos blockPos2 = blockPos.add(random.nextInt(8) - random.nextInt(8), random.nextInt(4) - random.nextInt(4), random.nextInt(8) - random.nextInt(8));
            if (!world2.isAirBlock(blockPos2) || world2.provider.getHasNoSky() && blockPos2.getY() >= 254 || !Blocks.double_plant.canPlaceBlockAt(world2, blockPos2)) continue;
            Blocks.double_plant.placeAt(world2, blockPos2, this.field_150549_a, 2);
            bl = true;
        }
        return bl;
    }
}

