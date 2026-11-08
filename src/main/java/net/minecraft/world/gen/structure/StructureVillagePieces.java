/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureVillagePieces {
    public static void registerVillagePieces() {
        MapGenStructureIO.registerStructureComponent(House1.class, "ViBH");
        MapGenStructureIO.registerStructureComponent(Field1.class, "ViDF");
        MapGenStructureIO.registerStructureComponent(Field2.class, "ViF");
        MapGenStructureIO.registerStructureComponent(Torch.class, "ViL");
        MapGenStructureIO.registerStructureComponent(Hall.class, "ViPH");
        MapGenStructureIO.registerStructureComponent(House4Garden.class, "ViSH");
        MapGenStructureIO.registerStructureComponent(WoodHut.class, "ViSmH");
        MapGenStructureIO.registerStructureComponent(Church.class, "ViST");
        MapGenStructureIO.registerStructureComponent(House2.class, "ViS");
        MapGenStructureIO.registerStructureComponent(Start.class, "ViStart");
        MapGenStructureIO.registerStructureComponent(Path.class, "ViSR");
        MapGenStructureIO.registerStructureComponent(House3.class, "ViTRH");
        MapGenStructureIO.registerStructureComponent(Well.class, "ViW");
    }

    public static List<PieceWeight> getStructureVillageWeightedPieceList(Random random, int n) {
        ArrayList<PieceWeight> arrayList = Lists.newArrayList();
        arrayList.add(new PieceWeight(House4Garden.class, 4, MathHelper.getRandomIntegerInRange(random, 2 + n, 4 + n * 2)));
        arrayList.add(new PieceWeight(Church.class, 20, MathHelper.getRandomIntegerInRange(random, 0 + n, 1 + n)));
        arrayList.add(new PieceWeight(House1.class, 20, MathHelper.getRandomIntegerInRange(random, 0 + n, 2 + n)));
        arrayList.add(new PieceWeight(WoodHut.class, 3, MathHelper.getRandomIntegerInRange(random, 2 + n, 5 + n * 3)));
        arrayList.add(new PieceWeight(Hall.class, 15, MathHelper.getRandomIntegerInRange(random, 0 + n, 2 + n)));
        arrayList.add(new PieceWeight(Field1.class, 3, MathHelper.getRandomIntegerInRange(random, 1 + n, 4 + n)));
        arrayList.add(new PieceWeight(Field2.class, 3, MathHelper.getRandomIntegerInRange(random, 2 + n, 4 + n * 2)));
        arrayList.add(new PieceWeight(House2.class, 15, MathHelper.getRandomIntegerInRange(random, 0, 1 + n)));
        arrayList.add(new PieceWeight(House3.class, 8, MathHelper.getRandomIntegerInRange(random, 0 + n, 3 + n * 2)));
        Iterator iterator2 = arrayList.iterator();
        while (iterator2.hasNext()) {
            if (((PieceWeight)iterator2.next()).villagePiecesLimit != 0) continue;
            iterator2.remove();
        }
        return arrayList;
    }

    private static int func_75079_a(List<PieceWeight> list) {
        boolean bl = false;
        int n = 0;
        for (PieceWeight pieceWeight : list) {
            if (pieceWeight.villagePiecesLimit > 0 && pieceWeight.villagePiecesSpawned < pieceWeight.villagePiecesLimit) {
                bl = true;
            }
            n += pieceWeight.villagePieceWeight;
        }
        return bl ? n : -1;
    }

    private static Village func_176065_a(Start start, PieceWeight pieceWeight, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        Class<? extends Village> clazz = pieceWeight.villagePieceClass;
        Village village = null;
        if (clazz == House4Garden.class) {
            village = House4Garden.func_175858_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == Church.class) {
            village = Church.func_175854_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == House1.class) {
            village = House1.func_175850_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == WoodHut.class) {
            village = WoodHut.func_175853_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == Hall.class) {
            village = Hall.func_175857_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == Field1.class) {
            village = Field1.func_175851_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == Field2.class) {
            village = Field2.func_175852_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == House2.class) {
            village = House2.func_175855_a(start, list, random, n, n2, n3, enumFacing, n4);
        } else if (clazz == House3.class) {
            village = House3.func_175849_a(start, list, random, n, n2, n3, enumFacing, n4);
        }
        return village;
    }

    private static Village func_176067_c(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        int n5 = StructureVillagePieces.func_75079_a(start.structureVillageWeightedPieceList);
        if (n5 <= 0) {
            return null;
        }
        int n6 = 0;
        block0: while (n6 < 5) {
            ++n6;
            int n7 = random.nextInt(n5);
            for (PieceWeight pieceWeight : start.structureVillageWeightedPieceList) {
                if ((n7 -= pieceWeight.villagePieceWeight) >= 0) continue;
                if (!pieceWeight.canSpawnMoreVillagePiecesOfType(n4) || pieceWeight == start.structVillagePieceWeight && start.structureVillageWeightedPieceList.size() > 1) continue block0;
                Village village = StructureVillagePieces.func_176065_a(start, pieceWeight, list, random, n, n2, n3, enumFacing, n4);
                if (village == null) continue;
                ++pieceWeight.villagePiecesSpawned;
                start.structVillagePieceWeight = pieceWeight;
                if (!pieceWeight.canSpawnMoreVillagePieces()) {
                    start.structureVillageWeightedPieceList.remove(pieceWeight);
                }
                return village;
            }
        }
        StructureBoundingBox structureBoundingBox = Torch.func_175856_a(start, list, random, n, n2, n3, enumFacing);
        if (structureBoundingBox != null) {
            return new Torch(start, n4, random, structureBoundingBox, enumFacing);
        }
        return null;
    }

    private static StructureComponent func_176066_d(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        if (n4 > 50) {
            return null;
        }
        if (Math.abs(n - start.getBoundingBox().minX) <= 112 && Math.abs(n3 - start.getBoundingBox().minZ) <= 112) {
            Village village = StructureVillagePieces.func_176067_c(start, list, random, n, n2, n3, enumFacing, n4 + 1);
            if (village != null) {
                int n5;
                int n6 = (village.boundingBox.minX + village.boundingBox.maxX) / 2;
                int n7 = (village.boundingBox.minZ + village.boundingBox.maxZ) / 2;
                int n8 = village.boundingBox.maxX - village.boundingBox.minX;
                int n9 = village.boundingBox.maxZ - village.boundingBox.minZ;
                int n10 = n5 = n8 > n9 ? n8 : n9;
                if (start.getWorldChunkManager().areBiomesViable(n6, n7, n5 / 2 + 4, MapGenVillage.villageSpawnBiomes)) {
                    list.add(village);
                    start.field_74932_i.add(village);
                    return village;
                }
            }
            return null;
        }
        return null;
    }

    private static StructureComponent func_176069_e(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        if (n4 > 3 + start.terrainType) {
            return null;
        }
        if (Math.abs(n - start.getBoundingBox().minX) <= 112 && Math.abs(n3 - start.getBoundingBox().minZ) <= 112) {
            StructureBoundingBox structureBoundingBox = Path.func_175848_a(start, list, random, n, n2, n3, enumFacing);
            if (structureBoundingBox != null && structureBoundingBox.minY > 10) {
                int n5;
                Path path = new Path(start, n4, random, structureBoundingBox, enumFacing);
                int n6 = (path.boundingBox.minX + path.boundingBox.maxX) / 2;
                int n7 = (path.boundingBox.minZ + path.boundingBox.maxZ) / 2;
                int n8 = path.boundingBox.maxX - path.boundingBox.minX;
                int n9 = path.boundingBox.maxZ - path.boundingBox.minZ;
                int n10 = n5 = n8 > n9 ? n8 : n9;
                if (start.getWorldChunkManager().areBiomesViable(n6, n7, n5 / 2 + 4, MapGenVillage.villageSpawnBiomes)) {
                    list.add(path);
                    start.field_74930_j.add(path);
                    return path;
                }
            }
            return null;
        }
        return null;
    }

    public static class House1
    extends Village {
        public House1() {
        }

        public House1(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static House1 func_175850_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 9, 9, 6, enumFacing);
            return House1.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new House1(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 9 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 7, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 8, 0, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 5, 0, 8, 5, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 6, 1, 8, 6, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 7, 2, 8, 7, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            int n3 = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            int n4 = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (n2 = -1; n2 <= 2; ++n2) {
                for (n = 0; n <= 8; ++n) {
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n3), n, 6 + n2, n2, structureBoundingBox);
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n4), n, 6 + n2, 5 - n2, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 0, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 5, 8, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 1, 0, 8, 1, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 1, 0, 7, 1, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 2, 0, 0, 4, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 2, 5, 0, 4, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 2, 5, 8, 4, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 2, 0, 8, 4, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 2, 1, 0, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 5, 7, 4, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 2, 1, 8, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 0, 7, 4, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 6, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 6, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 3, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 3, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 3, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 6, 2, 5, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 4, 1, 7, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 4, 4, 7, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 3, 4, 7, 3, 4, Blocks.bookshelf.getDefaultState(), Blocks.bookshelf.getDefaultState(), false);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 7, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 0)), 7, 1, 3, structureBoundingBox);
            n2 = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n2), 6, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n2), 5, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n2), 4, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n2), 3, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 6, 1, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.wooden_pressure_plate.getDefaultState(), 6, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 1, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.wooden_pressure_plate.getDefaultState(), 4, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.crafting_table.getDefaultState(), 7, 1, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 2, 0, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.getBlockStateFromPos(world2, 1, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 1, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 0, -1, structureBoundingBox);
            }
            for (n = 0; n < 6; ++n) {
                for (int i = 0; i < 9; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 9, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 2, 1, 2, 1);
            return true;
        }

        @Override
        protected int func_180779_c(int n, int n2) {
            return 1;
        }
    }

    public static class Field1
    extends Village {
        private Block cropTypeA;
        private Block cropTypeB;
        private Block cropTypeC;
        private Block cropTypeD;

        public Field1() {
        }

        public Field1(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.cropTypeA = this.func_151559_a(random);
            this.cropTypeB = this.func_151559_a(random);
            this.cropTypeC = this.func_151559_a(random);
            this.cropTypeD = this.func_151559_a(random);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            nBTTagCompound.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
            nBTTagCompound.setInteger("CC", Block.blockRegistry.getIDForObject(this.cropTypeC));
            nBTTagCompound.setInteger("CD", Block.blockRegistry.getIDForObject(this.cropTypeD));
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.cropTypeA = Block.getBlockById(nBTTagCompound.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(nBTTagCompound.getInteger("CB"));
            this.cropTypeC = Block.getBlockById(nBTTagCompound.getInteger("CC"));
            this.cropTypeD = Block.getBlockById(nBTTagCompound.getInteger("CD"));
        }

        private Block func_151559_a(Random random) {
            switch (random.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
            }
            return Blocks.wheat;
        }

        public static Field1 func_175851_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 13, 4, 9, enumFacing);
            return Field1.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new Field1(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 12, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 7, 0, 1, 8, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 10, 0, 1, 11, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 12, 0, 0, 12, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 0, 11, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 8, 11, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 9, 0, 1, 9, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            for (n = 1; n <= 7; ++n) {
                this.setBlockState(world2, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 1, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 2, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 4, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 5, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 7, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeC.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 8, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 10, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeD.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 11, 1, n, structureBoundingBox);
            }
            for (n = 0; n < 9; ++n) {
                for (int i = 0; i < 13; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 4, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.dirt.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            return true;
        }
    }

    public static class Field2
    extends Village {
        private Block cropTypeA;
        private Block cropTypeB;

        public Field2() {
        }

        public Field2(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.cropTypeA = this.func_151560_a(random);
            this.cropTypeB = this.func_151560_a(random);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setInteger("CA", Block.blockRegistry.getIDForObject(this.cropTypeA));
            nBTTagCompound.setInteger("CB", Block.blockRegistry.getIDForObject(this.cropTypeB));
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.cropTypeA = Block.getBlockById(nBTTagCompound.getInteger("CA"));
            this.cropTypeB = Block.getBlockById(nBTTagCompound.getInteger("CB"));
        }

        private Block func_151560_a(Random random) {
            switch (random.nextInt(5)) {
                case 0: {
                    return Blocks.carrots;
                }
                case 1: {
                    return Blocks.potatoes;
                }
            }
            return Blocks.wheat;
        }

        public static Field2 func_175852_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 7, 4, 9, enumFacing);
            return Field2.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new Field2(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 6, 4, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.farmland.getDefaultState(), Blocks.farmland.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 0, 5, 0, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 8, 5, 0, 8, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.water.getDefaultState(), Blocks.water.getDefaultState(), false);
            for (n = 1; n <= 7; ++n) {
                this.setBlockState(world2, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 1, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeA.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 2, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 4, 1, n, structureBoundingBox);
                this.setBlockState(world2, this.cropTypeB.getStateFromMeta(MathHelper.getRandomIntegerInRange(random, 2, 7)), 5, 1, n, structureBoundingBox);
            }
            for (n = 0; n < 9; ++n) {
                for (int i = 0; i < 7; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 4, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.dirt.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            return true;
        }
    }

    public static class Torch
    extends Village {
        public Torch() {
        }

        public Torch(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static StructureBoundingBox func_175856_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 3, 4, 2, enumFacing);
            return StructureComponent.findIntersecting(list, structureBoundingBox) != null ? null : structureBoundingBox;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 4 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 2, 3, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 0, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.wool.getStateFromMeta(EnumDyeColor.WHITE.getDyeDamage()), 1, 3, 0, structureBoundingBox);
            boolean bl = this.coordBaseMode == EnumFacing.EAST || this.coordBaseMode == EnumFacing.NORTH;
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), bl ? 2 : 0, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 1, 3, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), bl ? 0 : 2, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 1, 3, -1, structureBoundingBox);
            return true;
        }
    }

    public static class Hall
    extends Village {
        public Hall() {
        }

        public Hall(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static Hall func_175857_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 9, 7, 11, enumFacing);
            return Hall.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new Hall(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 0, 6, 8, 0, 10, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 6, 0, 6, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 1, 6, 2, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 1, 6, 8, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 10, 7, 1, 10, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 0, 0, 8, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 0, 7, 1, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 5, 7, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 5, 7, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 1, 8, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 4, 8, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 5, 2, 8, 5, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 0, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 0, 4, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 4, 3, structureBoundingBox);
            int n3 = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            int n4 = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (n2 = -1; n2 <= 2; ++n2) {
                for (n = 0; n <= 8; ++n) {
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n3), n, 4 + n2, n2, structureBoundingBox);
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n4), n, 4 + n2, 5 - n2, structureBoundingBox);
                }
            }
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 3, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 6, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 2, 1, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 1, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 3)), 2, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 1)), 1, 1, 3, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 0, 1, 7, 0, 3, Blocks.double_stone_slab.getDefaultState(), Blocks.double_stone_slab.getDefaultState(), false);
            this.setBlockState(world2, Blocks.double_stone_slab.getDefaultState(), 6, 1, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.double_stone_slab.getDefaultState(), 6, 1, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.getBlockStateFromPos(world2, 2, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 2, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, structureBoundingBox);
            }
            this.setBlockState(world2, Blocks.air.getDefaultState(), 6, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 6, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 6, 3, 4, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 6, 1, 5, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            for (n2 = 0; n2 < 5; ++n2) {
                for (n = 0; n < 9; ++n) {
                    this.clearCurrentPositionBlocksUpwards(world2, n, 7, n2, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), n, -1, n2, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 4, 1, 2, 2);
            return true;
        }

        @Override
        protected int func_180779_c(int n, int n2) {
            return n == 0 ? 4 : super.func_180779_c(n, n2);
        }
    }

    public static class House4Garden
    extends Village {
        private boolean isRoofAccessible;

        public House4Garden() {
        }

        public House4Garden(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.isRoofAccessible = random.nextBoolean();
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setBoolean("Terrace", this.isRoofAccessible);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.isRoofAccessible = nBTTagCompound.getBoolean("Terrace");
        }

        public static House4Garden func_175858_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 5, 6, 5, enumFacing);
            return StructureComponent.findIntersecting(list, structureBoundingBox) != null ? null : new House4Garden(start, n4, random, structureBoundingBox, enumFacing);
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 4, 0, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 0, 4, 4, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 4, 1, 3, 4, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 3, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 3, 4, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 1, 1, 4, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 4, 3, 3, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 1, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 1, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 1, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 2, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 3, 3, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 3, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 3, 1, 0, structureBoundingBox);
            if (this.getBlockStateFromPos(world2, 2, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 2, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, structureBoundingBox);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 3, 3, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.isRoofAccessible) {
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 0, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 2, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 3, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 5, 0, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 0, 5, 4, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 5, 4, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 2, 5, 4, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 3, 5, 4, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 5, 4, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 5, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 5, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 5, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 0, 5, 1, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 0, 5, 2, structureBoundingBox);
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 0, 5, 3, structureBoundingBox);
            }
            if (this.isRoofAccessible) {
                n = this.getMetadataWithOffset(Blocks.ladder, 3);
                this.setBlockState(world2, Blocks.ladder.getStateFromMeta(n), 3, 1, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.ladder.getStateFromMeta(n), 3, 2, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.ladder.getStateFromMeta(n), 3, 3, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.ladder.getStateFromMeta(n), 3, 4, 3, structureBoundingBox);
            }
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, structureBoundingBox);
            for (n = 0; n < 5; ++n) {
                for (int i = 0; i < 5; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 6, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 1, 1, 2, 1);
            return true;
        }
    }

    public static class WoodHut
    extends Village {
        private boolean isTallHouse;
        private int tablePosition;

        public WoodHut() {
        }

        public WoodHut(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.isTallHouse = random.nextBoolean();
            this.tablePosition = random.nextInt(3);
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setInteger("T", this.tablePosition);
            nBTTagCompound.setBoolean("C", this.isTallHouse);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.tablePosition = nBTTagCompound.getInteger("T");
            this.isTallHouse = nBTTagCompound.getBoolean("C");
        }

        public static WoodHut func_175853_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 4, 6, 5, enumFacing);
            return WoodHut.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new WoodHut(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 3, 5, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 3, 0, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 2, 0, 3, Blocks.dirt.getDefaultState(), Blocks.dirt.getDefaultState(), false);
            if (this.isTallHouse) {
                this.fillWithBlocks(world2, structureBoundingBox, 1, 4, 1, 2, 4, 3, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            } else {
                this.fillWithBlocks(world2, structureBoundingBox, 1, 5, 1, 2, 5, 3, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            }
            this.setBlockState(world2, Blocks.log.getDefaultState(), 1, 4, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 2, 4, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 1, 4, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 2, 4, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 4, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 4, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 3, 4, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 3, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 3, 4, 3, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 0, 3, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 0, 3, 3, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 4, 0, 3, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 4, 3, 3, 4, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 1, 0, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 1, 3, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 0, 2, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 4, 2, 3, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 3, 2, 2, structureBoundingBox);
            if (this.tablePosition > 0) {
                this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), this.tablePosition, 1, 3, structureBoundingBox);
                this.setBlockState(world2, Blocks.wooden_pressure_plate.getDefaultState(), this.tablePosition, 2, 3, structureBoundingBox);
            }
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 1, 2, 0, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 1, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.getBlockStateFromPos(world2, 1, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 1, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 0, -1, structureBoundingBox);
            }
            for (int i = 0; i < 5; ++i) {
                for (int j = 0; j < 4; ++j) {
                    this.clearCurrentPositionBlocksUpwards(world2, j, 6, i, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), j, -1, i, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 1, 1, 2, 1);
            return true;
        }
    }

    public static class Church
    extends Village {
        public Church() {
        }

        public Church(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static Church func_175854_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 5, 12, 9, enumFacing);
            return Church.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new Church(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 12 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 3, 3, 7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 5, 1, 3, 9, 3, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 0, 3, 0, 8, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 0, 3, 10, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 1, 0, 10, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 1, 1, 4, 10, 3, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 4, 0, 4, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 0, 4, 4, 4, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 8, 3, 4, 8, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 5, 4, 3, 10, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 5, 5, 3, 5, 7, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 9, 0, 4, 9, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 0, 4, 4, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 0, 11, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 4, 11, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 2, 11, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 2, 11, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 1, 1, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 1, 1, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 2, 1, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 3, 1, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 3, 1, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 1, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 1, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 3, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 1)), 1, 2, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 0)), 3, 2, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 3, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 6, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 7, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 6, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 7, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 6, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 7, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 6, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 7, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 3, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 3, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 3, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 2, 4, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), 1, 4, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), 3, 4, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 4, 5, structureBoundingBox);
            int n2 = this.getMetadataWithOffset(Blocks.ladder, 4);
            for (n = 1; n <= 9; ++n) {
                this.setBlockState(world2, Blocks.ladder.getStateFromMeta(n2), 3, n, 3, structureBoundingBox);
            }
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 2, 0, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            if (this.getBlockStateFromPos(world2, 2, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 2, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, structureBoundingBox);
            }
            for (n = 0; n < 9; ++n) {
                for (int i = 0; i < 5; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 12, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 2, 1, 2, 1);
            return true;
        }

        @Override
        protected int func_180779_c(int n, int n2) {
            return 2;
        }
    }

    public static class House2
    extends Village {
        private static final List<WeightedRandomChestContent> villageBlacksmithChestContents = Lists.newArrayList(new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 3), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.apple, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 5), new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.obsidian), 0, 3, 7, 5), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 3, 7, 5), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.golden_horse_armor, 0, 1, 1, 1), new WeightedRandomChestContent(Items.diamond_horse_armor, 0, 1, 1, 1));
        private boolean hasMadeChest;

        public House2() {
        }

        public House2(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static House2 func_175855_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 10, 6, 7, enumFacing);
            return House2.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new House2(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setBoolean("Chest", this.hasMadeChest);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.hasMadeChest = nBTTagCompound.getBoolean("Chest");
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 6 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 9, 4, 6, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 9, 0, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 0, 9, 4, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 5, 0, 9, 5, 6, Blocks.stone_slab.getDefaultState(), Blocks.stone_slab.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 5, 1, 8, 5, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 0, 2, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 0, 0, 4, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 0, 3, 4, 0, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 6, 0, 4, 6, Blocks.log.getDefaultState(), Blocks.log.getDefaultState(), false);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 3, 3, 1, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 1, 2, 3, 3, 2, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 1, 3, 5, 3, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 1, 1, 0, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 6, 5, 3, 6, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 1, 0, 5, 3, 0, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 9, 1, 0, 9, 3, 0, Blocks.oak_fence.getDefaultState(), Blocks.oak_fence.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 1, 4, 9, 4, 6, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.setBlockState(world2, Blocks.flowing_lava.getDefaultState(), 7, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.flowing_lava.getDefaultState(), 8, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.iron_bars.getDefaultState(), 9, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.iron_bars.getDefaultState(), 9, 2, 4, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 7, 2, 4, 8, 2, 5, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.setBlockState(world2, Blocks.cobblestone.getDefaultState(), 6, 1, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.furnace.getDefaultState(), 6, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.furnace.getDefaultState(), 6, 3, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.double_stone_slab.getDefaultState(), 8, 1, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 4, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 2, 1, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.wooden_pressure_plate.getDefaultState(), 2, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 1, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 3)), 2, 1, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.oak_stairs, 1)), 1, 1, 4, structureBoundingBox);
            if (!this.hasMadeChest && structureBoundingBox.isVecInside(new BlockPos(this.getXWithOffset(5, 5), this.getYWithOffset(1), this.getZWithOffset(5, 5)))) {
                this.hasMadeChest = true;
                this.generateChestContents(world2, structureBoundingBox, random, 5, 1, 5, villageBlacksmithChestContents, 3 + random.nextInt(6));
            }
            for (n = 6; n <= 8; ++n) {
                if (this.getBlockStateFromPos(world2, n, 0, -1, structureBoundingBox).getBlock().getMaterial() != Material.air || this.getBlockStateFromPos(world2, n, -1, -1, structureBoundingBox).getBlock().getMaterial() == Material.air) continue;
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), n, 0, -1, structureBoundingBox);
            }
            for (n = 0; n < 7; ++n) {
                for (int i = 0; i < 10; ++i) {
                    this.clearCurrentPositionBlocksUpwards(world2, i, 6, n, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), i, -1, n, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 7, 1, 1, 1);
            return true;
        }

        @Override
        protected int func_180779_c(int n, int n2) {
            return 3;
        }
    }

    public static class Start
    extends Well {
        public WorldChunkManager worldChunkMngr;
        public boolean inDesert;
        public int terrainType;
        public PieceWeight structVillagePieceWeight;
        public List<PieceWeight> structureVillageWeightedPieceList;
        public List<StructureComponent> field_74932_i = Lists.newArrayList();
        public List<StructureComponent> field_74930_j = Lists.newArrayList();

        public Start() {
        }

        public Start(WorldChunkManager worldChunkManager, int n, Random random, int n2, int n3, List<PieceWeight> list, int n4) {
            super(null, 0, random, n2, n3);
            this.worldChunkMngr = worldChunkManager;
            this.structureVillageWeightedPieceList = list;
            this.terrainType = n4;
            BiomeGenBase biomeGenBase = worldChunkManager.getBiomeGenerator(new BlockPos(n2, 0, n3), BiomeGenBase.field_180279_ad);
            this.inDesert = biomeGenBase == BiomeGenBase.desert || biomeGenBase == BiomeGenBase.desertHills;
            this.func_175846_a(this.inDesert);
        }

        public WorldChunkManager getWorldChunkManager() {
            return this.worldChunkMngr;
        }
    }

    public static class Path
    extends Road {
        private int length;

        public Path() {
        }

        public Path(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.length = Math.max(structureBoundingBox.getXSize(), structureBoundingBox.getZSize());
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            super.writeStructureToNBT(nBTTagCompound);
            nBTTagCompound.setInteger("Length", this.length);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            super.readStructureFromNBT(nBTTagCompound);
            this.length = nBTTagCompound.getInteger("Length");
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            StructureComponent structureComponent2;
            int n;
            boolean bl = false;
            for (n = random.nextInt(5); n < this.length - 8; n += 2 + random.nextInt(5)) {
                structureComponent2 = this.getNextComponentNN((Start)structureComponent, list, random, 0, n);
                if (structureComponent2 == null) continue;
                n += Math.max(structureComponent2.boundingBox.getXSize(), structureComponent2.boundingBox.getZSize());
                bl = true;
            }
            for (n = random.nextInt(5); n < this.length - 8; n += 2 + random.nextInt(5)) {
                structureComponent2 = this.getNextComponentPP((Start)structureComponent, list, random, 0, n);
                if (structureComponent2 == null) continue;
                n += Math.max(structureComponent2.boundingBox.getXSize(), structureComponent2.boundingBox.getZSize());
                bl = true;
            }
            if (bl && random.nextInt(3) > 0 && this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case SOUTH: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.WEST, this.getComponentType());
                        break;
                    }
                    case WEST: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                        break;
                    }
                    case EAST: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            if (bl && random.nextInt(3) > 0 && this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case SOUTH: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 2, EnumFacing.EAST, this.getComponentType());
                        break;
                    }
                    case WEST: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                        break;
                    }
                    case EAST: {
                        StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.maxX - 2, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
        }

        public static StructureBoundingBox func_175848_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing) {
            for (int i = 7 * MathHelper.getRandomIntegerInRange(random, 3, 5); i >= 7; i -= 7) {
                StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 3, 3, i, enumFacing);
                if (StructureComponent.findIntersecting(list, structureBoundingBox) != null) continue;
                return structureBoundingBox;
            }
            return null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            IBlockState iBlockState = this.func_175847_a(Blocks.gravel.getDefaultState());
            IBlockState iBlockState2 = this.func_175847_a(Blocks.cobblestone.getDefaultState());
            for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i) {
                for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j) {
                    BlockPos blockPos = new BlockPos(i, 64, j);
                    if (!structureBoundingBox.isVecInside(blockPos)) continue;
                    blockPos = world2.getTopSolidOrLiquidBlock(blockPos).down();
                    world2.setBlockState(blockPos, iBlockState, 2);
                    world2.setBlockState(blockPos.down(), iBlockState2, 2);
                }
            }
            return true;
        }
    }

    public static class House3
    extends Village {
        public House3() {
        }

        public House3(Start start, int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(start, n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        public static House3 func_175849_a(Start start, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
            StructureBoundingBox structureBoundingBox = StructureBoundingBox.getComponentToAddBoundingBox(n, n2, n3, 0, 0, 0, 9, 7, 12, enumFacing);
            return House3.canVillageGoDeeper(structureBoundingBox) && StructureComponent.findIntersecting(list, structureBoundingBox) == null ? new House3(start, n4, random, structureBoundingBox, enumFacing) : null;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            int n3;
            int n4;
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 0, 5, 8, 0, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 8, 0, 0, 8, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 0, 7, 2, 0, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 5, 2, 1, 5, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 2, 0, 6, 2, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 3, 0, 10, 7, 3, 10, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 2, 5, 2, 3, 5, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 1, 8, 4, 1, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 4, 4, 3, 4, 4, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 5, 2, 8, 5, 3, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 0, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 0, 4, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 4, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 4, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 4, 4, structureBoundingBox);
            int n5 = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
            int n6 = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
            for (n4 = -1; n4 <= 2; ++n4) {
                for (n3 = 0; n3 <= 8; ++n3) {
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n5), n3, 4 + n4, n4, structureBoundingBox);
                    if (n4 <= -1 && n3 > 1 || n4 <= 0 && n3 > 3 || n4 <= 1 && n3 > 4 && n3 < 6) continue;
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n6), n3, 4 + n4, 5 - n4, structureBoundingBox);
                }
            }
            this.fillWithBlocks(world2, structureBoundingBox, 3, 4, 5, 3, 4, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 7, 4, 2, 7, 4, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 4, 5, 4, 4, 5, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 6, 5, 4, 6, 5, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 5, 6, 3, 5, 6, 10, Blocks.planks.getDefaultState(), Blocks.planks.getDefaultState(), false);
            n4 = this.getMetadataWithOffset(Blocks.oak_stairs, 0);
            for (n3 = 4; n3 >= 1; --n3) {
                this.setBlockState(world2, Blocks.planks.getDefaultState(), n3, 2 + n3, 7 - n3, structureBoundingBox);
                for (n2 = 8 - n3; n2 <= 10; ++n2) {
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n4), n3, 2 + n3, n2, structureBoundingBox);
                }
            }
            n3 = this.getMetadataWithOffset(Blocks.oak_stairs, 1);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 6, 6, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 7, 5, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n3), 6, 6, 4, structureBoundingBox);
            for (n2 = 6; n2 <= 8; ++n2) {
                for (n = 5; n <= 10; ++n) {
                    this.setBlockState(world2, Blocks.oak_stairs.getStateFromMeta(n3), n2, 12 - n2, n, structureBoundingBox);
                }
            }
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 0, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 0, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 4, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 6, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 8, 2, 5, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 8, 2, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 8, 2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 2, 2, 6, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 7, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 2, 2, 8, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 2, 2, 9, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 4, 4, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.glass_pane.getDefaultState(), 5, 4, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.log.getDefaultState(), 6, 4, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.planks.getDefaultState(), 5, 5, 10, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 1, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 2, 0, structureBoundingBox);
            this.setBlockState(world2, Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, 3, 1, structureBoundingBox);
            this.placeDoorCurrentPosition(world2, structureBoundingBox, random, 2, 1, 0, EnumFacing.getHorizontal(this.getMetadataWithOffset(Blocks.oak_door, 1)));
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, -1, 3, 2, -1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.getBlockStateFromPos(world2, 2, 0, -1, structureBoundingBox).getBlock().getMaterial() == Material.air && this.getBlockStateFromPos(world2, 2, -1, -1, structureBoundingBox).getBlock().getMaterial() != Material.air) {
                this.setBlockState(world2, Blocks.stone_stairs.getStateFromMeta(this.getMetadataWithOffset(Blocks.stone_stairs, 3)), 2, 0, -1, structureBoundingBox);
            }
            for (n2 = 0; n2 < 5; ++n2) {
                for (n = 0; n < 9; ++n) {
                    this.clearCurrentPositionBlocksUpwards(world2, n, 7, n2, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), n, -1, n2, structureBoundingBox);
                }
            }
            for (n2 = 5; n2 < 11; ++n2) {
                for (n = 2; n < 9; ++n) {
                    this.clearCurrentPositionBlocksUpwards(world2, n, 7, n2, structureBoundingBox);
                    this.replaceAirAndLiquidDownwards(world2, Blocks.cobblestone.getDefaultState(), n, -1, n2, structureBoundingBox);
                }
            }
            this.spawnVillagers(world2, structureBoundingBox, 4, 1, 2, 2);
            return true;
        }
    }

    public static class Well
    extends Village {
        public Well() {
        }

        public Well(Start start, int n, Random random, int n2, int n3) {
            super(start, n);
            this.coordBaseMode = EnumFacing.Plane.HORIZONTAL.random(random);
            switch (this.coordBaseMode) {
                case NORTH: 
                case SOUTH: {
                    this.boundingBox = new StructureBoundingBox(n2, 64, n3, n2 + 6 - 1, 78, n3 + 6 - 1);
                    break;
                }
                default: {
                    this.boundingBox = new StructureBoundingBox(n2, 64, n3, n2 + 6 - 1, 78, n3 + 6 - 1);
                }
            }
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.WEST, this.getComponentType());
            StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ + 1, EnumFacing.EAST, this.getComponentType());
            StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
            StructureVillagePieces.func_176069_e((Start)structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.maxY - 4, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.field_143015_k < 0) {
                this.field_143015_k = this.getAverageGroundLevel(world2, structureBoundingBox);
                if (this.field_143015_k < 0) {
                    return true;
                }
                this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 3, 0);
            }
            this.fillWithBlocks(world2, structureBoundingBox, 1, 0, 1, 4, 12, 4, Blocks.cobblestone.getDefaultState(), Blocks.flowing_water.getDefaultState(), false);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 12, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 3, 12, 2, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 2, 12, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.air.getDefaultState(), 3, 12, 3, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 13, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 14, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 13, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 14, 1, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 13, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 1, 14, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 13, 4, structureBoundingBox);
            this.setBlockState(world2, Blocks.oak_fence.getDefaultState(), 4, 14, 4, structureBoundingBox);
            this.fillWithBlocks(world2, structureBoundingBox, 1, 15, 1, 4, 15, 4, Blocks.cobblestone.getDefaultState(), Blocks.cobblestone.getDefaultState(), false);
            for (int i = 0; i <= 5; ++i) {
                for (int j = 0; j <= 5; ++j) {
                    if (j != 0 && j != 5 && i != 0 && i != 5) continue;
                    this.setBlockState(world2, Blocks.gravel.getDefaultState(), j, 11, i, structureBoundingBox);
                    this.clearCurrentPositionBlocksUpwards(world2, j, 12, i, structureBoundingBox);
                }
            }
            return true;
        }
    }

    public static class PieceWeight {
        public Class<? extends Village> villagePieceClass;
        public final int villagePieceWeight;
        public int villagePiecesSpawned;
        public int villagePiecesLimit;

        public PieceWeight(Class<? extends Village> clazz, int n, int n2) {
            this.villagePieceClass = clazz;
            this.villagePieceWeight = n;
            this.villagePiecesLimit = n2;
        }

        public boolean canSpawnMoreVillagePiecesOfType(int n) {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }

        public boolean canSpawnMoreVillagePieces() {
            return this.villagePiecesLimit == 0 || this.villagePiecesSpawned < this.villagePiecesLimit;
        }
    }

    public static abstract class Village
    extends StructureComponent {
        protected int field_143015_k = -1;
        private int villagersSpawned;
        private boolean isDesertVillage;

        public Village() {
        }

        protected Village(Start start, int n) {
            super(n);
            if (start != null) {
                this.isDesertVillage = start.inDesert;
            }
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound.setInteger("HPos", this.field_143015_k);
            nBTTagCompound.setInteger("VCount", this.villagersSpawned);
            nBTTagCompound.setBoolean("Desert", this.isDesertVillage);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            this.field_143015_k = nBTTagCompound.getInteger("HPos");
            this.villagersSpawned = nBTTagCompound.getInteger("VCount");
            this.isDesertVillage = nBTTagCompound.getBoolean("Desert");
        }

        protected StructureComponent getNextComponentNN(Start start, List<StructureComponent> list, Random random, int n, int n2) {
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, EnumFacing.WEST, this.getComponentType());
                    }
                    case SOUTH: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, EnumFacing.WEST, this.getComponentType());
                    }
                    case WEST: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                    case EAST: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.minZ - 1, EnumFacing.NORTH, this.getComponentType());
                    }
                }
            }
            return null;
        }

        protected StructureComponent getNextComponentPP(Start start, List<StructureComponent> list, Random random, int n, int n2) {
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, EnumFacing.EAST, this.getComponentType());
                    }
                    case SOUTH: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + n, this.boundingBox.minZ + n2, EnumFacing.EAST, this.getComponentType());
                    }
                    case WEST: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                    case EAST: {
                        return StructureVillagePieces.func_176066_d(start, list, random, this.boundingBox.minX + n2, this.boundingBox.minY + n, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, this.getComponentType());
                    }
                }
            }
            return null;
        }

        protected int getAverageGroundLevel(World world2, StructureBoundingBox structureBoundingBox) {
            int n = 0;
            int n2 = 0;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i = this.boundingBox.minZ; i <= this.boundingBox.maxZ; ++i) {
                for (int j = this.boundingBox.minX; j <= this.boundingBox.maxX; ++j) {
                    mutableBlockPos.set(j, 64, i);
                    if (!structureBoundingBox.isVecInside(mutableBlockPos)) continue;
                    n += Math.max(world2.getTopSolidOrLiquidBlock(mutableBlockPos).getY(), world2.provider.getAverageGroundLevel());
                    ++n2;
                }
            }
            if (n2 == 0) {
                return -1;
            }
            return n / n2;
        }

        protected static boolean canVillageGoDeeper(StructureBoundingBox structureBoundingBox) {
            return structureBoundingBox != null && structureBoundingBox.minY > 10;
        }

        protected void spawnVillagers(World world2, StructureBoundingBox structureBoundingBox, int n, int n2, int n3, int n4) {
            if (this.villagersSpawned < n4) {
                int n5;
                int n6;
                int n7;
                for (int i = this.villagersSpawned; i < n4 && structureBoundingBox.isVecInside(new BlockPos(n7 = this.getXWithOffset(n + i, n3), n6 = this.getYWithOffset(n2), n5 = this.getZWithOffset(n + i, n3))); ++i) {
                    ++this.villagersSpawned;
                    EntityVillager entityVillager = new EntityVillager(world2);
                    entityVillager.setLocationAndAngles((double)n7 + 0.5, n6, (double)n5 + 0.5, 0.0f, 0.0f);
                    entityVillager.onInitialSpawn(world2.getDifficultyForLocation(new BlockPos(entityVillager)), null);
                    entityVillager.setProfession(this.func_180779_c(i, entityVillager.getProfession()));
                    world2.spawnEntityInWorld(entityVillager);
                }
            }
        }

        protected int func_180779_c(int n, int n2) {
            return n2;
        }

        protected IBlockState func_175847_a(IBlockState iBlockState) {
            if (this.isDesertVillage) {
                if (iBlockState.getBlock() == Blocks.log || iBlockState.getBlock() == Blocks.log2) {
                    return Blocks.sandstone.getDefaultState();
                }
                if (iBlockState.getBlock() == Blocks.cobblestone) {
                    return Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata());
                }
                if (iBlockState.getBlock() == Blocks.planks) {
                    return Blocks.sandstone.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata());
                }
                if (iBlockState.getBlock() == Blocks.oak_stairs) {
                    return Blocks.sandstone_stairs.getDefaultState().withProperty(BlockStairs.FACING, iBlockState.getValue(BlockStairs.FACING));
                }
                if (iBlockState.getBlock() == Blocks.stone_stairs) {
                    return Blocks.sandstone_stairs.getDefaultState().withProperty(BlockStairs.FACING, iBlockState.getValue(BlockStairs.FACING));
                }
                if (iBlockState.getBlock() == Blocks.gravel) {
                    return Blocks.sandstone.getDefaultState();
                }
            }
            return iBlockState;
        }

        @Override
        protected void setBlockState(World world2, IBlockState iBlockState, int n, int n2, int n3, StructureBoundingBox structureBoundingBox) {
            IBlockState iBlockState2 = this.func_175847_a(iBlockState);
            super.setBlockState(world2, iBlockState2, n, n2, n3, structureBoundingBox);
        }

        @Override
        protected void fillWithBlocks(World world2, StructureBoundingBox structureBoundingBox, int n, int n2, int n3, int n4, int n5, int n6, IBlockState iBlockState, IBlockState iBlockState2, boolean bl) {
            IBlockState iBlockState3 = this.func_175847_a(iBlockState);
            IBlockState iBlockState4 = this.func_175847_a(iBlockState2);
            super.fillWithBlocks(world2, structureBoundingBox, n, n2, n3, n4, n5, n6, iBlockState3, iBlockState4, bl);
        }

        @Override
        protected void replaceAirAndLiquidDownwards(World world2, IBlockState iBlockState, int n, int n2, int n3, StructureBoundingBox structureBoundingBox) {
            IBlockState iBlockState2 = this.func_175847_a(iBlockState);
            super.replaceAirAndLiquidDownwards(world2, iBlockState2, n, n2, n3, structureBoundingBox);
        }

        protected void func_175846_a(boolean bl) {
            this.isDesertVillage = bl;
        }
    }

    public static abstract class Road
    extends Village {
        public Road() {
        }

        protected Road(Start start, int n) {
            super(start, n);
        }
    }
}

