/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockFlowerPot;
import net.minecraft.block.BlockLever;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStoneBrick;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockTripWire;
import net.minecraft.block.BlockTripWireHook;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class ComponentScatteredFeaturePieces {
    public static void registerScatteredFeaturePieces() {
        MapGenStructureIO.registerStructureComponent(DesertPyramid.class, "TeDP");
        MapGenStructureIO.registerStructureComponent(JunglePyramid.class, "TeJP");
        MapGenStructureIO.registerStructureComponent(SwampHut.class, "TeSH");
    }

    public static class DesertPyramid
    extends Feature {
        private boolean[] hasPlacedChest = new boolean[4];
        private static final List<WeightedRandomChestContent> itemsToGenerateInTemple = Lists.newArrayList(new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 7, 15), new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 2), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1));

        public DesertPyramid() {
        }

        public DesertPyramid(Random random, int n, int n2) {
            super(random, n, 64, n2, 21, 15, 21);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setBoolean("hasPlacedChest0", this.hasPlacedChest[0]);
            nBTTagCompound.setBoolean("hasPlacedChest1", this.hasPlacedChest[1]);
            nBTTagCompound.setBoolean("hasPlacedChest2", this.hasPlacedChest[2]);
            nBTTagCompound.setBoolean("hasPlacedChest3", this.hasPlacedChest[3]);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.hasPlacedChest[0] = nBTTagCompound.getBoolean("hasPlacedChest0");
            this.hasPlacedChest[1] = nBTTagCompound.getBoolean("hasPlacedChest1");
            this.hasPlacedChest[2] = nBTTagCompound.getBoolean("hasPlacedChest2");
            this.hasPlacedChest[3] = nBTTagCompound.getBoolean("hasPlacedChest3");
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            int n3;
            int n4;
            this.fillWithBlocks(world2, structureBoundingBox, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            for (n4 = 1; n4 <= 9; ++n4) {
                this.fillWithBlocks(world2, structureBoundingBox, n4, n4, n4, this.scatteredFeatureSizeX - 1 - n4, n4, this.scatteredFeatureSizeZ - 1 - n4, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, n4 + 1, n4, n4 + 1, this.scatteredFeatureSizeX - 2 - n4, n4, this.scatteredFeatureSizeZ - 2 - n4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            for (n4 = 0; n4 < this.scatteredFeatureSizeX; ++n4) {
                for (n3 = 0; n3 < this.scatteredFeatureSizeZ; ++n3) {
                    n2 = -5;
                    this.replaceAirAndLiquidDownwards(world2, Blocks.sandstone.getDefaultState(), n4, n2, n3, structureBoundingBox);
                }
            }
            n4 = this.getMetadataWithOffset(Blocks.sandstone_stairs, 3);
            n3 = this.getMetadataWithOffset(Blocks.sandstone_stairs, 2);
            n2 = this.getMetadataWithOffset(Blocks.sandstone_stairs, 0);
            int n5 = this.getMetadataWithOffset(Blocks.sandstone_stairs, 1);
            int n6 = ~EnumDyeColor.ORANGE.getDyeDamage() & 0xF;
            int n7 = ~EnumDyeColor.BLUE.getDyeDamage() & 0xF;
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 4, 9, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 10, 1, 3, 10, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), 2, 10, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n3), 2, 10, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n2), 0, 10, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n5), 4, 10, 2, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 5, 0, 0, this.scatteredFeatureSizeX - 1, 9, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 4, 10, 1, this.scatteredFeatureSizeX - 2, 10, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), this.scatteredFeatureSizeX - 3, 10, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n3), this.scatteredFeatureSizeX - 3, 10, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n2), this.scatteredFeatureSizeX - 5, 10, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n5), this.scatteredFeatureSizeX - 1, 10, 2, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 0, 0, 12, 4, 4, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 9, 1, 0, 11, 3, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 1, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 9, 3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, 3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 11, 1, 1, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 1, 1, 8, 3, 3, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 1, 2, 8, 2, 2, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 12, 1, 1, 16, 3, 3, Blocks.sandstone.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 12, 1, 2, 16, 2, 2, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 4, 5, this.scatteredFeatureSizeX - 6, 4, this.scatteredFeatureSizeZ - 6, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 9, 4, 9, 11, 4, 11, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 1, 8, 8, 3, 8, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 12, 1, 8, 12, 3, 8, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 1, 12, 8, 3, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 12, 1, 12, 12, 3, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 5, 4, 4, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 5, 1, 5, this.scatteredFeatureSizeX - 2, 4, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 7, 9, 6, 7, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 7, 7, 9, this.scatteredFeatureSizeX - 7, 7, 11, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 5, 9, 5, 7, 11, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 6, 5, 9, this.scatteredFeatureSizeX - 6, 7, 11, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 5, 5, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 5, 6, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 6, 6, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 6, 5, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 6, 6, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), this.scatteredFeatureSizeX - 7, 6, 10, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 4, 4, 2, 6, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 3, 4, 4, this.scatteredFeatureSizeX - 3, 6, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), 2, 4, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), 2, 3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), this.scatteredFeatureSizeX - 3, 4, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n4), this.scatteredFeatureSizeX - 3, 3, 4, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 3, 2, 2, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 3, 1, 3, this.scatteredFeatureSizeX - 2, 2, 3, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.setBlockState(world2, Blocks.sandstone_stairs.getDefaultState(), 1, 1, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getDefaultState(), this.scatteredFeatureSizeX - 2, 1, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), 1, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_slab.getStateFromMeta(BlockStoneSlab.EnumType.SAND.getMetadata()), this.scatteredFeatureSizeX - 2, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n5), 2, 1, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone_stairs.getStateFromMeta(n2), this.scatteredFeatureSizeX - 3, 1, 2, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 3, 5, 4, 3, 18, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 5, 3, 5, this.scatteredFeatureSizeX - 5, 3, 17, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 5, 4, 2, 16, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.scatteredFeatureSizeX - 6, 1, 5, this.scatteredFeatureSizeX - 5, 2, 16, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (n = 5; n <= 17; n += 2) {
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 4, 1, n, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 4, 2, n, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), this.scatteredFeatureSizeX - 5, 1, n, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), this.scatteredFeatureSizeX - 5, 2, n, structureBoundingBox);
            }
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 10, 0, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 10, 0, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 9, 0, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 11, 0, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 8, 0, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 12, 0, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 7, 0, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 13, 0, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 9, 0, 11, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 11, 0, 11, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 10, 0, 12, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 10, 0, 13, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n7), 10, 0, 10, structureBoundingBox);
            for (n = 0; n <= this.scatteredFeatureSizeX - 1; n += this.scatteredFeatureSizeX - 1) {
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 2, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 2, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 2, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 3, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 3, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 3, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 4, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), n, 4, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 4, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 5, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 5, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 5, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 6, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), n, 6, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 6, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 7, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 7, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 7, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 8, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 8, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 8, 3, structureBoundingBox);
            }
            for (n = 2; n <= this.scatteredFeatureSizeX - 3; n += this.scatteredFeatureSizeX - 3 - 2) {
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n - 1, 2, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 2, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n + 1, 2, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n - 1, 3, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 3, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n + 1, 3, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n - 1, 4, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), n, 4, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n + 1, 4, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n - 1, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n + 1, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n - 1, 6, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), n, 6, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n + 1, 6, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n - 1, 7, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n, 7, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), n + 1, 7, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n - 1, 8, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n, 8, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), n + 1, 8, 0, structureBoundingBox);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 8, 4, 0, 12, 6, 0, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 8, 6, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 12, 6, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 9, 5, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, 5, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stained_hardened_clay.getStateFromMeta(n6), 11, 5, 0, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 8, -14, 8, 12, -11, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, -10, 8, 12, -10, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, -9, 8, 12, -9, 12, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, -8, 8, 12, -1, 12, Blocks.sandstone.getDefaultState(), Blocks.sandstone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 9, -11, 9, 11, -1, 11, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.stone_pressure_plate.getDefaultState(), 10, -11, 10, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 9, -13, 9, 11, -13, 11, Blocks.tnt.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 8, -11, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 8, -10, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 7, -10, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 7, -11, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 12, -11, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 12, -10, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 13, -10, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 13, -11, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, -11, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, -10, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, -11, 12, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, -10, 12, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.CHISELED.getMetadata()), 10, -10, 13, structureBoundingBox);
            this.setBlockState(world2, Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata()), 10, -11, 13, structureBoundingBox);
            for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                if (this.hasPlacedChest[enumFacing.getHorizontalIndex()]) continue;
                int n8 = enumFacing.getFrontOffsetX() * 2;
                int n9 = enumFacing.getFrontOffsetZ() * 2;
                this.hasPlacedChest[enumFacing.getHorizontalIndex()] = this.generateChestContents(world2, structureBoundingBox, random, 10 + n8, -11, 10 + n9, WeightedRandomChestContent.func_177629_a(itemsToGenerateInTemple, Items.enchanted_book.getRandom(random)), 2 + random.nextInt(5));
            }
            return true;
        }
    }

    public static class JunglePyramid
    extends Feature {
        private boolean placedMainChest;
        private boolean placedHiddenChest;
        private boolean placedTrap1;
        private boolean placedTrap2;
        private static final List<WeightedRandomChestContent> field_175816_i = Lists.newArrayList(new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 2, 7, 15), new WeightedRandomChestContent(Items.emerald, 0, 1, 3, 2), new WeightedRandomChestContent(Items.bone, 0, 4, 6, 20), new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 7, 16), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1));
        private static final List<WeightedRandomChestContent> field_175815_j = Lists.newArrayList(new WeightedRandomChestContent(Items.arrow, 0, 2, 7, 30));
        private static Stones junglePyramidsRandomScatteredStones = new Stones();

        public JunglePyramid() {
        }

        public JunglePyramid(Random random, int n, int n2) {
            super(random, n, 64, n2, 12, 10, 15);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setBoolean("placedMainChest", this.placedMainChest);
            nBTTagCompound.setBoolean("placedHiddenChest", this.placedHiddenChest);
            nBTTagCompound.setBoolean("placedTrap1", this.placedTrap1);
            nBTTagCompound.setBoolean("placedTrap2", this.placedTrap2);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.placedMainChest = nBTTagCompound.getBoolean("placedMainChest");
            this.placedHiddenChest = nBTTagCompound.getBoolean("placedHiddenChest");
            this.placedTrap1 = nBTTagCompound.getBoolean("placedTrap1");
            this.placedTrap2 = nBTTagCompound.getBoolean("placedTrap2");
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (!this.func_74935_a(world2, structureBoundingBox, 0)) {
                return false;
            }
            int n2 = this.getMetadataWithOffset(Blocks.stone_stairs, 3);
            int n3 = this.getMetadataWithOffset(Blocks.stone_stairs, 2);
            int n4 = this.getMetadataWithOffset(Blocks.stone_stairs, 0);
            int n5 = this.getMetadataWithOffset(Blocks.stone_stairs, 1);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 0, -4, 0, this.scatteredFeatureSizeX - 1, 0, this.scatteredFeatureSizeZ - 1, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 1, 2, 9, 2, 2, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 1, 12, 9, 2, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 1, 3, 2, 2, 11, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 9, 1, 3, 9, 2, 11, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 1, 3, 1, 10, 6, 1, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 1, 3, 13, 10, 6, 13, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 1, 3, 2, 1, 6, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 10, 3, 2, 10, 6, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 3, 2, 9, 3, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 6, 2, 9, 6, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 3, 7, 3, 8, 7, 11, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 8, 4, 7, 8, 10, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithAir(world2, structureBoundingBox, 3, 1, 3, 8, 2, 11);
            this.fillWithAir(world2, structureBoundingBox, 4, 3, 6, 7, 3, 9);
            this.fillWithAir(world2, structureBoundingBox, 2, 4, 2, 9, 5, 12);
            this.fillWithAir(world2, structureBoundingBox, 4, 6, 5, 7, 6, 9);
            this.fillWithAir(world2, structureBoundingBox, 5, 7, 6, 6, 7, 8);
            this.fillWithAir(world2, structureBoundingBox, 5, 1, 2, 6, 2, 2);
            this.fillWithAir(world2, structureBoundingBox, 5, 2, 12, 6, 2, 12);
            this.fillWithAir(world2, structureBoundingBox, 5, 5, 1, 6, 5, 1);
            this.fillWithAir(world2, structureBoundingBox, 5, 5, 13, 6, 5, 13);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 5, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, 5, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 5, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 10, 5, 9, structureBoundingBox);
            for (n = 0; n <= 14; n += 14) {
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 4, n, 2, 5, n, false, random, junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 4, n, 4, 5, n, false, random, junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 7, 4, n, 7, 5, n, false, random, junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 9, 4, n, 9, 5, n, false, random, junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 5, 6, 0, 6, 6, 0, false, random, junglePyramidsRandomScatteredStones);
            for (n = 0; n <= 11; n += 11) {
                for (int i = 2; i <= 12; i += 2) {
                    this.fillWithRandomizedBlocks(world2, structureBoundingBox, n, 4, i, n, 5, i, false, random, junglePyramidsRandomScatteredStones);
                }
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, n, 6, 5, n, 6, 5, false, random, junglePyramidsRandomScatteredStones);
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, n, 6, 9, n, 6, 9, false, random, junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 7, 2, 2, 9, 2, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 9, 7, 2, 9, 9, 2, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, 7, 12, 2, 9, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 9, 7, 12, 9, 9, 12, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 9, 4, 4, 9, 4, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 7, 9, 4, 7, 9, 4, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 9, 10, 4, 9, 10, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 7, 9, 10, 7, 9, 10, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 5, 9, 7, 6, 9, 7, false, random, junglePyramidsRandomScatteredStones);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 5, 9, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 6, 9, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n3), 5, 9, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n3), 6, 9, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 4, 0, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 5, 0, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 6, 0, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 7, 0, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 4, 1, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 4, 2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 4, 3, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 7, 1, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 7, 2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n2), 7, 3, 10, structureBoundingBox);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 1, 9, 4, 1, 9, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 7, 1, 9, 7, 1, 9, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 4, 1, 10, 7, 2, 10, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 5, 4, 5, 6, 4, 5, false, random, junglePyramidsRandomScatteredStones);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n4), 4, 4, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n5), 7, 4, 5, structureBoundingBox);
            for (n = 0; n < 4; ++n) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n3), 5, 0 - n, 6 + n, structureBoundingBox);
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(n3), 6, 0 - n, 6 + n, structureBoundingBox);
                this.fillWithAir(world2, structureBoundingBox, 5, 0 - n, 7 + n, 6, 0 - n, 9 + n);
            }
            this.fillWithAir(world2, structureBoundingBox, 1, -3, 12, 10, -1, 13);
            this.fillWithAir(world2, structureBoundingBox, 1, -3, 1, 3, -1, 13);
            this.fillWithAir(world2, structureBoundingBox, 1, -3, 1, 9, -1, 5);
            for (n = 1; n <= 13; n += 2) {
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 1, -3, n, 1, -2, n, false, random, junglePyramidsRandomScatteredStones);
            }
            for (n = 2; n <= 12; n += 2) {
                this.fillWithRandomizedBlocks(world2, structureBoundingBox, 1, -1, n, 3, -1, n, false, random, junglePyramidsRandomScatteredStones);
            }
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 2, -2, 1, 5, -2, 1, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 7, -2, 1, 9, -2, 1, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 6, -3, 1, 6, -3, 1, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 6, -1, 1, 6, -1, 1, false, random, junglePyramidsRandomScatteredStones);
            this.setBlockState(world2, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.EAST.getHorizontalIndex())).withProperty(BlockTripWireHook.ATTACHED, true), 1, -3, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.WEST.getHorizontalIndex())).withProperty(BlockTripWireHook.ATTACHED, true), 4, -3, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.ATTACHED, true), 2, -3, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.ATTACHED, true), 3, -3, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 5, -3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 4, -3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 3, -3, 1, structureBoundingBox);
            if (!this.placedTrap1) {
                this.placedTrap1 = this.generateDispenserContents(world2, structureBoundingBox, random, 3, -2, 1, EnumFacing.NORTH.getIndex(), field_175815_j, 2);
            }
            this.setBlockState(world2, Blocks.vine.getStateFromMeta(15), 3, -2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.NORTH.getHorizontalIndex())).withProperty(BlockTripWireHook.ATTACHED, true), 7, -3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire_hook.getStateFromMeta(this.getMetadataWithOffset(Blocks.tripwire_hook, EnumFacing.SOUTH.getHorizontalIndex())).withProperty(BlockTripWireHook.ATTACHED, true), 7, -3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.ATTACHED, true), 7, -3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.ATTACHED, true), 7, -3, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.tripwire.getDefaultState().withProperty(BlockTripWire.ATTACHED, true), 7, -3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 8, -3, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 9, -3, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 9, -3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 9, -3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 9, -2, 4, structureBoundingBox);
            if (!this.placedTrap2) {
                this.placedTrap2 = this.generateDispenserContents(world2, structureBoundingBox, random, 9, -2, 3, EnumFacing.WEST.getIndex(), field_175815_j, 2);
            }
            this.setBlockState(world2, Blocks.vine.getStateFromMeta(15), 8, -1, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.vine.getStateFromMeta(15), 8, -2, 3, structureBoundingBox);
            if (!this.placedMainChest) {
                this.placedMainChest = this.generateChestContents(world2, structureBoundingBox, random, 8, -3, 3, WeightedRandomChestContent.func_177629_a(field_175816_i, Items.enchanted_book.getRandom(random)), 2 + random.nextInt(5));
            }
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 9, -3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 8, -3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 4, -3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 5, -2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 5, -1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 6, -3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 7, -2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 7, -1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 8, -3, 5, structureBoundingBox);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 9, -1, 1, 9, -1, 5, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithAir(world2, structureBoundingBox, 8, -3, 8, 10, -1, 10);
            this.setBlockState(world2, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 8, -2, 11, structureBoundingBox);
            this.setBlockState(world2, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 9, -2, 11, structureBoundingBox);
            this.setBlockState(world2, Blocks.stonebrick.getStateFromMeta(BlockStoneBrick.CHISELED_META), 10, -2, 11, structureBoundingBox);
            this.setBlockState(world2, Blocks.lever.getStateFromMeta(BlockLever.getMetadataForFacing(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 8, -2, 12, structureBoundingBox);
            this.setBlockState(world2, Blocks.lever.getStateFromMeta(BlockLever.getMetadataForFacing(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 9, -2, 12, structureBoundingBox);
            this.setBlockState(world2, Blocks.lever.getStateFromMeta(BlockLever.getMetadataForFacing(EnumFacing.getFront(this.getMetadataWithOffset(Blocks.lever, EnumFacing.NORTH.getIndex())))), 10, -2, 12, structureBoundingBox);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 8, -3, 8, 8, -3, 10, false, random, junglePyramidsRandomScatteredStones);
            this.fillWithRandomizedBlocks(world2, structureBoundingBox, 10, -3, 8, 10, -3, 10, false, random, junglePyramidsRandomScatteredStones);
            this.setBlockState(world2, Blocks.mossy_cobblestone.getDefaultState(), 10, -2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 8, -2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 8, -2, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.redstone_wire.getDefaultState(), 10, -1, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.sticky_piston.getStateFromMeta(EnumFacing.UP.getIndex()), 9, -2, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.sticky_piston.getStateFromMeta(this.getMetadataWithOffset(Blocks.sticky_piston, EnumFacing.WEST.getIndex())), 10, -2, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.sticky_piston.getStateFromMeta(this.getMetadataWithOffset(Blocks.sticky_piston, EnumFacing.WEST.getIndex())), 10, -1, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.unpowered_repeater.getStateFromMeta(this.getMetadataWithOffset(Blocks.unpowered_repeater, EnumFacing.NORTH.getHorizontalIndex())), 10, -2, 10, structureBoundingBox);
            if (!this.placedHiddenChest) {
                this.placedHiddenChest = this.generateChestContents(world2, structureBoundingBox, random, 9, -3, 10, WeightedRandomChestContent.func_177629_a(field_175816_i, Items.enchanted_book.getRandom(random)), 2 + random.nextInt(5));
            }
            return true;
        }

        public static class Stones
        extends StructureComponent.BlockSelector {
            private Stones() {
            }

            @Override
            public void selectBlocks(Random random, int n, int n2, int n3, boolean bl) {
                this.blockstate = random.nextFloat() < 0.4f ? Blocks.cobblestone.getDefaultState() : Blocks.mossy_cobblestone.getDefaultState();
            }
        }
    }

    public static class SwampHut
    extends Feature {
        private boolean hasWitch;

        public SwampHut() {
        }

        public SwampHut(Random random, int n, int n2) {
            super(random, n, 64, n2, 7, 7, 9);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setBoolean("Witch", this.hasWitch);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.hasWitch = nBTTagCompound.getBoolean("Witch");
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            int n3;
            if (!this.func_74935_a(world2, structureBoundingBox, 0)) {
                return false;
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 5, 1, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 4, 2, 5, 4, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 1, 0, 4, 1, 0, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 2, 2, 3, 3, 2, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 3, 1, 3, 6, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 2, 3, 5, 3, 6, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 2, 7, 4, 3, 7, Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), Blocks.planks.getStateFromMeta(BlockPlanks.EnumType.SPRUCE.getMetadata()), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 2, 1, 3, 2, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 0, 2, 5, 3, 2, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 7, 1, 3, 7, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 0, 7, 5, 3, 7, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 2, 3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 3, 3, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 5, 3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 5, 3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.flower_pot.getDefaultState().withProperty(BlockFlowerPot.CONTENTS, BlockFlowerPot.EnumFlowerType.MUSHROOM_RED), 1, 3, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.crafting_table.getDefaultState(), 3, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.cauldron.getDefaultState(), 4, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 5, 2, 1, structureBoundingBox);
            int n4 = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            int n5 = this.getMetadataWithOffset(Blocks.oak_stairs, 1);
            int n6 = this.getMetadataWithOffset(Blocks.oak_stairs, 0);
            int n7 = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 1, 6, 4, 1, Blocks.spruce_stairs.getStateFromMeta(n4), Blocks.spruce_stairs.getStateFromMeta(n4), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 2, 0, 4, 7, Blocks.spruce_stairs.getStateFromMeta(n6), Blocks.spruce_stairs.getStateFromMeta(n6), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 4, 2, 6, 4, 7, Blocks.spruce_stairs.getStateFromMeta(n5), Blocks.spruce_stairs.getStateFromMeta(n5), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 8, 6, 4, 8, Blocks.spruce_stairs.getStateFromMeta(n7), Blocks.spruce_stairs.getStateFromMeta(n7), false);
            for (n3 = 2; n3 <= 7; n3 += 5) {
                for (n2 = 1; n2 <= 5; n2 += 4) {
                    this.replaceAirAndLiquidDownwards(world2, Blocks.log.getDefaultState(), n2, -1, n3, structureBoundingBox);
                }
            }
            if (!this.hasWitch && structureBoundingBox.isVecInside(new BlockPos(n3 = this.getXWithOffset(2, 5), n2 = this.getYWithOffset(2), n = this.getZWithOffset(2, 5)))) {
                this.hasWitch = true;
                EntityWitch entityWitch = new EntityWitch(world2);
                entityWitch.setLocationAndAngles((double)n3 + 0.5, n2, (double)n + 0.5, 0.0f, 0.0f);
                entityWitch.onInitialSpawn(world2.getDifficultyForLocation(new BlockPos(n3, n2, n)), null);
                world2.spawnEntityInWorld(entityWitch);
            }
            return true;
        }
    }

    public static abstract class Feature
    extends StructureComponent {
        protected int scatteredFeatureSizeX;
        protected int scatteredFeatureSizeY;
        protected int scatteredFeatureSizeZ;
        protected int field_74936_d = -1;

        public Feature() {
        }

        protected Feature(Random random, int n, int n2, int n3, int n4, int n5, int n6) {
            super(0);
            this.scatteredFeatureSizeX = n4;
            this.scatteredFeatureSizeY = n5;
            this.scatteredFeatureSizeZ = n6;
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(random);
            switch (this.coordBaseMode) {
                case NORTH: 
                case SOUTH: {
                    this.boundingBox = new StructureBoundingBox(n, n2, n3, n + n4 - 1, n2 + n5 - 1, n3 + n6 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(n, n2, n3, n + n6 - 1, n2 + n5 - 1, n3 + n4 - 1);
                }
            }
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound.setInteger("Width", this.scatteredFeatureSizeX);
            nBTTagCompound.setInteger("Height", this.scatteredFeatureSizeY);
            nBTTagCompound.setInteger("Depth", this.scatteredFeatureSizeZ);
            nBTTagCompound.setInteger("HPos", this.field_74936_d);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            this.scatteredFeatureSizeX = nBTTagCompound.getInteger("Width");
            this.scatteredFeatureSizeY = nBTTagCompound.getInteger("Height");
            this.scatteredFeatureSizeZ = nBTTagCompound.getInteger("Depth");
            this.field_74936_d = nBTTagCompound.getInteger("HPos");
        }

        protected boolean func_74935_a(World world2, StructureBoundingBox structureBoundingBox, int n) {
            if (this.field_74936_d >= 0) {
                return true;
            }
            int n2 = 0;
            int n3 = 0;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i = this.boundingBox.minZ; i <= this.boundingBox.maxZ; ++i) {
                for (int j = this.boundingBox.minX; j <= this.boundingBox.maxX; ++j) {
                    mutableBlockPos.set(j, 64, i);
                    if (!structureBoundingBox.isVecInside(mutableBlockPos)) continue;
                    n2 += Math.max(world2.getTopSolidOrLiquidBlock(mutableBlockPos).getY(), world2.provider.getAverageGroundLevel());
                    ++n3;
                }
            }
            if (n3 == 0) {
                return false;
            }
            this.field_74936_d = n2 / n3;
            this.boundingBox.offset(0, this.field_74936_d - this.boundingBox.minY + n, 0);
            return true;
        }
    }
}

