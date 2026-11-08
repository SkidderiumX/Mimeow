/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.feature;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldGenDungeons
extends WorldGenerator {
    private static final Logger field_175918_a = LogManager.getLogger();
    private static final String[] SPAWNERTYPES = new String[]{"Skeleton", "Zombie", "Zombie", "Spider"};
    private static final List<WeightedRandomChestContent> CHESTCONTENT = Lists.newArrayList(new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 10), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 1, 10), new WeightedRandomChestContent(Items.wheat, 0, 1, 4, 10), new WeightedRandomChestContent(Items.gunpowder, 0, 1, 4, 10), new WeightedRandomChestContent(Items.string, 0, 1, 4, 10), new WeightedRandomChestContent(Items.bucket, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 1), new WeightedRandomChestContent(Items.redstone, 0, 1, 4, 10), new WeightedRandomChestContent(Items.record_13, 0, 1, 1, 4), new WeightedRandomChestContent(Items.record_cat, 0, 1, 1, 4), new WeightedRandomChestContent(Items.name_tag, 0, 1, 1, 10), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 2), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 5), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1));

    @Override
    public boolean generate(World world2, Random random, BlockPos blockPos) {
        BlockPos blockPos2;
        int n;
        int n2;
        int n3;
        int n4 = 3;
        int n5 = random.nextInt(2) + 2;
        int n6 = -n5 - 1;
        int n7 = n5 + 1;
        int n8 = -1;
        int n9 = 4;
        int n10 = random.nextInt(2) + 2;
        int n11 = -n10 - 1;
        int n12 = n10 + 1;
        int n13 = 0;
        for (n3 = n6; n3 <= n7; ++n3) {
            for (n2 = -1; n2 <= 4; ++n2) {
                for (n = n11; n <= n12; ++n) {
                    blockPos2 = blockPos.add(n3, n2, n);
                    Material material = world2.getBlockState(blockPos2).getBlock().getMaterial();
                    boolean bl = material.isSolid();
                    if (n2 == -1 && !bl) {
                        return false;
                    }
                    if (n2 == 4 && !bl) {
                        return false;
                    }
                    if (n3 != n6 && n3 != n7 && n != n11 && n != n12 || n2 != 0 || !world2.isAirBlock(blockPos2) || !world2.isAirBlock(blockPos2.up())) continue;
                    ++n13;
                }
            }
        }
        if (n13 >= 1 && n13 <= 5) {
            for (n3 = n6; n3 <= n7; ++n3) {
                for (n2 = 3; n2 >= -1; --n2) {
                    for (n = n11; n <= n12; ++n) {
                        blockPos2 = blockPos.add(n3, n2, n);
                        if (n3 != n6 && n2 != -1 && n != n11 && n3 != n7 && n2 != 4 && n != n12) {
                            if (world2.getBlockState(blockPos2).getBlock() == Blocks.chest) continue;
                            world2.setBlockToAir(blockPos2);
                            continue;
                        }
                        if (blockPos2.getY() >= 0 && !world2.getBlockState(blockPos2.down()).getBlock().getMaterial().isSolid()) {
                            world2.setBlockToAir(blockPos2);
                            continue;
                        }
                        if (!world2.getBlockState(blockPos2).getBlock().getMaterial().isSolid() || world2.getBlockState(blockPos2).getBlock() == Blocks.chest) continue;
                        if (n2 == -1 && random.nextInt(4) != 0) {
                            world2.setBlockState(blockPos2, Blocks.mossy_cobblestone.getDefaultState(), 2);
                            continue;
                        }
                        world2.setBlockState(blockPos2, Blocks.cobblestone.getDefaultState(), 2);
                    }
                }
            }
            block6: for (n3 = 0; n3 < 2; ++n3) {
                for (n2 = 0; n2 < 3; ++n2) {
                    Object object2;
                    int n14;
                    int n15;
                    n = blockPos.getX() + random.nextInt(n5 * 2 + 1) - n5;
                    BlockPos blockPos3 = new BlockPos(n, n15 = blockPos.getY(), n14 = blockPos.getZ() + random.nextInt(n10 * 2 + 1) - n10);
                    if (!world2.isAirBlock(blockPos3)) continue;
                    int n16 = 0;
                    for (Object object2 : EnumFacing.Plane.HORIZONTAL) {
                        if (!world2.getBlockState(blockPos3.offset((EnumFacing)object2)).getBlock().getMaterial().isSolid()) continue;
                        ++n16;
                    }
                    if (n16 != true) continue;
                    world2.setBlockState(blockPos3, Blocks.chest.correctFacing(world2, blockPos3, Blocks.chest.getDefaultState()), 2);
                    List<WeightedRandomChestContent> list = WeightedRandomChestContent.func_177629_a(CHESTCONTENT, Items.enchanted_book.getRandom(random));
                    object2 = world2.getTileEntity(blockPos3);
                    if (!(object2 instanceof TileEntityChest)) continue block6;
                    WeightedRandomChestContent.generateChestContents(random, list, (TileEntityChest)object2, 8);
                    continue block6;
                }
            }
            world2.setBlockState(blockPos, Blocks.mob_spawner.getDefaultState(), 2);
            TileEntity tileEntity = world2.getTileEntity(blockPos);
            if (tileEntity instanceof TileEntityMobSpawner) {
                ((TileEntityMobSpawner)tileEntity).getSpawnerBaseLogic().setEntityName(this.pickMobSpawner(random));
            } else {
                field_175918_a.error("Failed to fetch mob spawner entity at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")");
            }
            return true;
        }
        return false;
    }

    private String pickMobSpawner(Random random) {
        return SPAWNERTYPES[random.nextInt(SPAWNERTYPES.length)];
    }
}

