/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityMinecartChest;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureMineshaftPieces {
    private static final List<WeightedRandomChestContent> CHEST_CONTENT_WEIGHT_LIST = Lists.newArrayList(new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 5, 10), new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 3, 5), new WeightedRandomChestContent(Items.redstone, 0, 4, 9, 5), new WeightedRandomChestContent(Items.dye, EnumDyeColor.BLUE.getDyeDamage(), 4, 9, 5), new WeightedRandomChestContent(Items.diamond, 0, 1, 2, 3), new WeightedRandomChestContent(Items.coal, 0, 3, 8, 10), new WeightedRandomChestContent(Items.bread, 0, 1, 3, 15), new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 1), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 4, 8, 1), new WeightedRandomChestContent(Items.melon_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.pumpkin_seeds, 0, 2, 4, 10), new WeightedRandomChestContent(Items.saddle, 0, 1, 1, 3), new WeightedRandomChestContent(Items.iron_horse_armor, 0, 1, 1, 1));

    public static void registerStructurePieces() {
        MapGenStructureIO.registerStructureComponent(Corridor.class, "MSCorridor");
        MapGenStructureIO.registerStructureComponent(Cross.class, "MSCrossing");
        MapGenStructureIO.registerStructureComponent(Room.class, "MSRoom");
        MapGenStructureIO.registerStructureComponent(Stairs.class, "MSStairs");
    }

    private static StructureComponent func_175892_a(List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        int n5 = random.nextInt(100);
        if (n5 >= 80) {
            StructureBoundingBox structureBoundingBox = Cross.func_175813_a(list, random, n, n2, n3, enumFacing);
            if (structureBoundingBox != null) {
                return new Cross(n4, random, structureBoundingBox, enumFacing);
            }
        } else if (n5 >= 70) {
            StructureBoundingBox structureBoundingBox = Stairs.func_175812_a(list, random, n, n2, n3, enumFacing);
            if (structureBoundingBox != null) {
                return new Stairs(n4, random, structureBoundingBox, enumFacing);
            }
        } else {
            StructureBoundingBox structureBoundingBox = Corridor.func_175814_a(list, random, n, n2, n3, enumFacing);
            if (structureBoundingBox != null) {
                return new Corridor(n4, random, structureBoundingBox, enumFacing);
            }
        }
        return null;
    }

    private static StructureComponent func_175890_b(StructureComponent structureComponent, List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing, int n4) {
        if (n4 > 8) {
            return null;
        }
        if (Math.abs(n - structureComponent.getBoundingBox().minX) <= 80 && Math.abs(n3 - structureComponent.getBoundingBox().minZ) <= 80) {
            StructureComponent structureComponent2 = StructureMineshaftPieces.func_175892_a(list, random, n, n2, n3, enumFacing, n4 + 1);
            if (structureComponent2 != null) {
                list.add(structureComponent2);
                structureComponent2.buildComponent(structureComponent, list, random);
            }
            return structureComponent2;
        }
        return null;
    }

    public static class Corridor
    extends StructureComponent {
        private boolean hasRails;
        private boolean hasSpiders;
        private boolean spawnerPlaced;
        private int sectionCount;

        public Corridor() {
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound.setBoolean("hr", this.hasRails);
            nBTTagCompound.setBoolean("sc", this.hasSpiders);
            nBTTagCompound.setBoolean("hps", this.spawnerPlaced);
            nBTTagCompound.setInteger("Num", this.sectionCount);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            this.hasRails = nBTTagCompound.getBoolean("hr");
            this.hasSpiders = nBTTagCompound.getBoolean("sc");
            this.spawnerPlaced = nBTTagCompound.getBoolean("hps");
            this.sectionCount = nBTTagCompound.getInteger("Num");
        }

        public Corridor(int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.hasRails = random.nextInt(3) == 0;
            this.hasSpiders = !this.hasRails && random.nextInt(23) == 0;
            this.sectionCount = this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH ? structureBoundingBox.getXSize() / 5 : structureBoundingBox.getZSize() / 5;
        }

        public static StructureBoundingBox func_175814_a(List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing) {
            int n4;
            StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2, n3, n, n2 + 2, n3);
            for (n4 = random.nextInt(3) + 2; n4 > 0; --n4) {
                int n5 = n4 * 5;
                switch (enumFacing) {
                    case NORTH: {
                        structureBoundingBox.maxX = n + 2;
                        structureBoundingBox.minZ = n3 - (n5 - 1);
                        break;
                    }
                    case SOUTH: {
                        structureBoundingBox.maxX = n + 2;
                        structureBoundingBox.maxZ = n3 + (n5 - 1);
                        break;
                    }
                    case WEST: {
                        structureBoundingBox.minX = n - (n5 - 1);
                        structureBoundingBox.maxZ = n3 + 2;
                        break;
                    }
                    case EAST: {
                        structureBoundingBox.maxX = n + (n5 - 1);
                        structureBoundingBox.maxZ = n3 + 2;
                    }
                }
                if (StructureComponent.findIntersecting(list, structureBoundingBox) == null) break;
            }
            return n4 > 0 ? structureBoundingBox : null;
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            block25: {
                int n = this.getComponentType();
                int n2 = random.nextInt(4);
                if (this.coordBaseMode != null) {
                    switch (this.coordBaseMode) {
                        case NORTH: {
                            if (n2 <= 1) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, this.coordBaseMode, n);
                                break;
                            }
                            if (n2 == 2) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, EnumFacing.WEST, n);
                                break;
                            }
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, EnumFacing.EAST, n);
                            break;
                        }
                        case SOUTH: {
                            if (n2 <= 1) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, this.coordBaseMode, n);
                                break;
                            }
                            if (n2 == 2) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.WEST, n);
                                break;
                            }
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ - 3, EnumFacing.EAST, n);
                            break;
                        }
                        case WEST: {
                            if (n2 <= 1) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, n);
                                break;
                            }
                            if (n2 == 2) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                                break;
                            }
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                            break;
                        }
                        case EAST: {
                            if (n2 <= 1) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ, this.coordBaseMode, n);
                                break;
                            }
                            if (n2 == 2) {
                                StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                                break;
                            }
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX - 3, this.boundingBox.minY - 1 + random.nextInt(3), this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                        }
                    }
                }
                if (n >= 8) break block25;
                if (this.coordBaseMode != EnumFacing.NORTH && this.coordBaseMode != EnumFacing.SOUTH) {
                    int n3 = this.boundingBox.minX + 3;
                    while (n3 + 3 <= this.boundingBox.maxX) {
                        int n4 = random.nextInt(5);
                        if (n4 == 0) {
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, n3, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, n + 1);
                        } else if (n4 == 1) {
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, n3, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n + 1);
                        }
                        n3 += 5;
                    }
                } else {
                    int n5 = this.boundingBox.minZ + 3;
                    while (n5 + 3 <= this.boundingBox.maxZ) {
                        int n6 = random.nextInt(5);
                        if (n6 == 0) {
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, n5, EnumFacing.WEST, n + 1);
                        } else if (n6 == 1) {
                            StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, n5, EnumFacing.EAST, n + 1);
                        }
                        n5 += 5;
                    }
                }
            }
        }

        @Override
        protected boolean generateChestContents(World world2, StructureBoundingBox structureBoundingBox, Random random, int n, int n2, int n3, List<WeightedRandomChestContent> list, int n4) {
            BlockPos blockPos = new BlockPos(this.getXWithOffset(n, n3), this.getYWithOffset(n2), this.getZWithOffset(n, n3));
            if (structureBoundingBox.isVecInside(blockPos) && world2.getBlockState(blockPos).getBlock().getMaterial() == Material.air) {
                int n5 = random.nextBoolean() ? 1 : 0;
                world2.setBlockState(blockPos, Blocks.rail.getStateFromMeta(this.getMetadataWithOffset(Blocks.rail, n5)), 2);
                EntityMinecartChest entityMinecartChest = new EntityMinecartChest(world2, (float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f);
                WeightedRandomChestContent.generateChestContents(random, list, entityMinecartChest, n4);
                world2.spawnEntityInWorld(entityMinecartChest);
                return true;
            }
            return false;
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            int n;
            int n2;
            int n3;
            int n4;
            if (this.isLiquidInStructureBoundingBox(world2, structureBoundingBox)) {
                return false;
            }
            boolean bl = false;
            int n5 = 2;
            boolean bl2 = false;
            int n6 = 2;
            int n7 = this.sectionCount * 5 - 1;
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 0, 2, 1, n7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.func_175805_a(world2, structureBoundingBox, random, 0.8f, 0, 2, 0, 2, 2, n7, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            if (this.hasSpiders) {
                this.func_175805_a(world2, structureBoundingBox, random, 0.6f, 0, 0, 0, 2, 1, n7, Blocks.web.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            for (n4 = 0; n4 < this.sectionCount; ++n4) {
                n3 = 2 + n4 * 5;
                this.fillWithBlocks(world2, structureBoundingBox, 0, 0, n3, 0, 1, n3, Blocks.oak_fence.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, 2, 0, n3, 2, 1, n3, Blocks.oak_fence.getDefaultState(), Blocks.air.getDefaultState(), false);
                if (random.nextInt(4) == 0) {
                    this.fillWithBlocks(world2, structureBoundingBox, 0, 2, n3, 0, 2, n3, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                    this.fillWithBlocks(world2, structureBoundingBox, 2, 2, n3, 2, 2, n3, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                } else {
                    this.fillWithBlocks(world2, structureBoundingBox, 0, 2, n3, 2, 2, n3, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
                }
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.1f, 0, 2, n3 - 1, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.1f, 2, 2, n3 - 1, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.1f, 0, 2, n3 + 1, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.1f, 2, 2, n3 + 1, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 0, 2, n3 - 2, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 2, 2, n3 - 2, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 0, 2, n3 + 2, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 2, 2, n3 + 2, Blocks.web.getDefaultState());
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 1, 2, n3 - 1, Blocks.torch.getStateFromMeta(EnumFacing.UP.getIndex()));
                this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.05f, 1, 2, n3 + 1, Blocks.torch.getStateFromMeta(EnumFacing.UP.getIndex()));
                if (random.nextInt(100) == 0) {
                    this.generateChestContents(world2, structureBoundingBox, random, 2, 0, n3 - 1, WeightedRandomChestContent.func_177629_a(CHEST_CONTENT_WEIGHT_LIST, Items.enchanted_book.getRandom(random)), 3 + random.nextInt(4));
                }
                if (random.nextInt(100) == 0) {
                    this.generateChestContents(world2, structureBoundingBox, random, 0, 0, n3 + 1, WeightedRandomChestContent.func_177629_a(CHEST_CONTENT_WEIGHT_LIST, Items.enchanted_book.getRandom(random)), 3 + random.nextInt(4));
                }
                if (!this.hasSpiders || this.spawnerPlaced) continue;
                n2 = this.getYWithOffset(0);
                int n8 = n3 - 1 + random.nextInt(3);
                n = this.getXWithOffset(1, n8);
                BlockPos blockPos = new BlockPos(n, n2, n8 = this.getZWithOffset(1, n8));
                if (!structureBoundingBox.isVecInside(blockPos)) continue;
                this.spawnerPlaced = true;
                world2.setBlockState(blockPos, Blocks.mob_spawner.getDefaultState(), 2);
                TileEntity tileEntity = world2.getTileEntity(blockPos);
                if (!(tileEntity instanceof TileEntityMobSpawner)) continue;
                ((TileEntityMobSpawner)tileEntity).getSpawnerBaseLogic().setEntityName("CaveSpider");
            }
            for (n4 = 0; n4 <= 2; ++n4) {
                for (n3 = 0; n3 <= n7; ++n3) {
                    n2 = -1;
                    IBlockState iBlockState = this.getBlockStateFromPos(world2, n4, n2, n3, structureBoundingBox);
                    if (iBlockState.getBlock().getMaterial() != Material.air) continue;
                    n = -1;
                    this.setBlockState(world2, Blocks.planks.getDefaultState(), n4, n, n3, structureBoundingBox);
                }
            }
            if (this.hasRails) {
                for (n4 = 0; n4 <= n7; ++n4) {
                    IBlockState iBlockState = this.getBlockStateFromPos(world2, 1, -1, n4, structureBoundingBox);
                    if (iBlockState.getBlock().getMaterial() == Material.air || !iBlockState.getBlock().isFullBlock()) continue;
                    this.randomlyPlaceBlock(world2, structureBoundingBox, random, 0.7f, 1, 0, n4, Blocks.rail.getStateFromMeta(this.getMetadataWithOffset(Blocks.rail, 0)));
                }
            }
            return true;
        }
    }

    public static class Cross
    extends StructureComponent {
        private EnumFacing corridorDirection;
        private boolean isMultipleFloors;

        public Cross() {
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            nBTTagCompound.setBoolean("tf", this.isMultipleFloors);
            nBTTagCompound.setInteger("D", this.corridorDirection.getHorizontalIndex());
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            this.isMultipleFloors = nBTTagCompound.getBoolean("tf");
            this.corridorDirection = EnumFacing.getHorizontal(nBTTagCompound.getInteger("D"));
        }

        public Cross(int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(n);
            this.corridorDirection = enumFacing;
            this.boundingBox = structureBoundingBox;
            this.isMultipleFloors = structureBoundingBox.getYSize() > 3;
        }

        public static StructureBoundingBox func_175813_a(List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing) {
            StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2, n3, n, n2 + 2, n3);
            if (random.nextInt(4) == 0) {
                structureBoundingBox.maxY += 4;
            }
            switch (enumFacing) {
                case NORTH: {
                    structureBoundingBox.minX = n - 1;
                    structureBoundingBox.maxX = n + 3;
                    structureBoundingBox.minZ = n3 - 4;
                    break;
                }
                case SOUTH: {
                    structureBoundingBox.minX = n - 1;
                    structureBoundingBox.maxX = n + 3;
                    structureBoundingBox.maxZ = n3 + 4;
                    break;
                }
                case WEST: {
                    structureBoundingBox.minX = n - 4;
                    structureBoundingBox.minZ = n3 - 1;
                    structureBoundingBox.maxZ = n3 + 3;
                    break;
                }
                case EAST: {
                    structureBoundingBox.maxX = n + 4;
                    structureBoundingBox.minZ = n3 - 1;
                    structureBoundingBox.maxZ = n3 + 3;
                }
            }
            return StructureComponent.findIntersecting(list, structureBoundingBox) != null ? null : structureBoundingBox;
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            int n = this.getComponentType();
            switch (this.corridorDirection) {
                case NORTH: {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, n);
                    break;
                }
                case SOUTH: {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, n);
                    break;
                }
                case WEST: {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.WEST, n);
                    break;
                }
                case EAST: {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, EnumFacing.EAST, n);
                }
            }
            if (this.isMultipleFloors) {
                if (random.nextBoolean()) {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                }
                if (random.nextBoolean()) {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.WEST, n);
                }
                if (random.nextBoolean()) {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.minZ + 1, EnumFacing.EAST, n);
                }
                if (random.nextBoolean()) {
                    StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + 1, this.boundingBox.minY + 3 + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                }
            }
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.isLiquidInStructureBoundingBox(world2, structureBoundingBox)) {
                return false;
            }
            if (this.isMultipleFloors) {
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.minY + 3 - 1, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.maxY - 2, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.maxY - 2, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY + 3, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.minY + 3, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            } else {
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
                this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX + 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.minX + 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.minZ + 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.minZ + 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.maxX - 1, this.boundingBox.minY, this.boundingBox.maxZ - 1, this.boundingBox.maxX - 1, this.boundingBox.maxY, this.boundingBox.maxZ - 1, Blocks.planks.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (int i = this.boundingBox.minX; i <= this.boundingBox.maxX; ++i) {
                for (int j = this.boundingBox.minZ; j <= this.boundingBox.maxZ; ++j) {
                    if (this.getBlockStateFromPos(world2, i, this.boundingBox.minY - 1, j, structureBoundingBox).getBlock().getMaterial() != Material.air) continue;
                    this.setBlockState(world2, Blocks.planks.getDefaultState(), i, this.boundingBox.minY - 1, j, structureBoundingBox);
                }
            }
            return true;
        }
    }

    public static class Room
    extends StructureComponent {
        private List<StructureBoundingBox> roomsLinkedToTheRoom = Lists.newLinkedList();

        public Room() {
        }

        public Room(int n, Random random, int n2, int n3) {
            super(n);
            this.boundingBox = new StructureBoundingBox(n2, 50, n3, n2 + 7 + random.nextInt(6), 54 + random.nextInt(6), n3 + 7 + random.nextInt(6));
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            Object object;
            int n;
            int n2 = this.getComponentType();
            int n3 = this.boundingBox.getYSize() - 3 - 1;
            if (n3 <= 0) {
                n3 = 1;
            }
            boolean bl = false;
            for (n = 0; n < this.boundingBox.getXSize() && (n += random.nextInt(this.boundingBox.getXSize())) + 3 <= this.boundingBox.getXSize(); n += 4) {
                object = StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + n, this.boundingBox.minY + random.nextInt(n3) + 1, this.boundingBox.minZ - 1, EnumFacing.NORTH, n2);
                if (object == null) continue;
                StructureBoundingBox structureBoundingBox = ((StructureComponent)object).getBoundingBox();
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(structureBoundingBox.minX, structureBoundingBox.minY, this.boundingBox.minZ, structureBoundingBox.maxX, structureBoundingBox.maxY, this.boundingBox.minZ + 1));
            }
            for (n = 0; n < this.boundingBox.getXSize() && (n += random.nextInt(this.boundingBox.getXSize())) + 3 <= this.boundingBox.getXSize(); n += 4) {
                StructureComponent structureComponent2 = StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX + n, this.boundingBox.minY + random.nextInt(n3) + 1, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n2);
                if (structureComponent2 == null) continue;
                object = structureComponent2.getBoundingBox();
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(((StructureBoundingBox)object).minX, ((StructureBoundingBox)object).minY, this.boundingBox.maxZ - 1, ((StructureBoundingBox)object).maxX, ((StructureBoundingBox)object).maxY, this.boundingBox.maxZ));
            }
            for (n = 0; n < this.boundingBox.getZSize() && (n += random.nextInt(this.boundingBox.getZSize())) + 3 <= this.boundingBox.getZSize(); n += 4) {
                StructureComponent structureComponent3 = StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY + random.nextInt(n3) + 1, this.boundingBox.minZ + n, EnumFacing.WEST, n2);
                if (structureComponent3 == null) continue;
                object = structureComponent3.getBoundingBox();
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.minX, ((StructureBoundingBox)object).minY, ((StructureBoundingBox)object).minZ, this.boundingBox.minX + 1, ((StructureBoundingBox)object).maxY, ((StructureBoundingBox)object).maxZ));
            }
            for (n = 0; n < this.boundingBox.getZSize() && (n += random.nextInt(this.boundingBox.getZSize())) + 3 <= this.boundingBox.getZSize(); n += 4) {
                StructureComponent structureComponent4 = StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY + random.nextInt(n3) + 1, this.boundingBox.minZ + n, EnumFacing.EAST, n2);
                if (structureComponent4 == null) continue;
                object = structureComponent4.getBoundingBox();
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(this.boundingBox.maxX - 1, ((StructureBoundingBox)object).minY, ((StructureBoundingBox)object).minZ, this.boundingBox.maxX, ((StructureBoundingBox)object).maxY, ((StructureBoundingBox)object).maxZ));
            }
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.isLiquidInStructureBoundingBox(world2, structureBoundingBox)) {
                return false;
            }
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.minY, this.boundingBox.maxZ, Blocks.dirt.getDefaultState(), Blocks.air.getDefaultState(), true);
            this.fillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 1, this.boundingBox.minZ, this.boundingBox.maxX, Math.min(this.boundingBox.minY + 3, this.boundingBox.maxY), this.boundingBox.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (StructureBoundingBox structureBoundingBox2 : this.roomsLinkedToTheRoom) {
                this.fillWithBlocks(world2, structureBoundingBox, structureBoundingBox2.minX, structureBoundingBox2.maxY - 2, structureBoundingBox2.minZ, structureBoundingBox2.maxX, structureBoundingBox2.maxY, structureBoundingBox2.maxZ, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            this.randomlyRareFillWithBlocks(world2, structureBoundingBox, this.boundingBox.minX, this.boundingBox.minY + 4, this.boundingBox.minZ, this.boundingBox.maxX, this.boundingBox.maxY, this.boundingBox.maxZ, Blocks.air.getDefaultState(), false);
            return true;
        }

        @Override
        public void func_181138_a(int n, int n2, int n3) {
            super.func_181138_a(n, n2, n3);
            for (StructureBoundingBox structureBoundingBox : this.roomsLinkedToTheRoom) {
                structureBoundingBox.offset(n, n2, n3);
            }
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
            NBTTagList nBTTagList = new NBTTagList();
            for (StructureBoundingBox structureBoundingBox : this.roomsLinkedToTheRoom) {
                nBTTagList.appendTag(structureBoundingBox.toNBTTagIntArray());
            }
            nBTTagCompound.setTag("Entrances", nBTTagList);
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
            NBTTagList nBTTagList = nBTTagCompound.getTagList("Entrances", 11);
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                this.roomsLinkedToTheRoom.add(new StructureBoundingBox(nBTTagList.getIntArrayAt(i)));
            }
        }
    }

    public static class Stairs
    extends StructureComponent {
        public Stairs() {
        }

        public Stairs(int n, Random random, StructureBoundingBox structureBoundingBox, EnumFacing enumFacing) {
            super(n);
            this.coordBaseMode = enumFacing;
            this.boundingBox = structureBoundingBox;
        }

        @Override
        protected void writeStructureToNBT(NBTTagCompound nBTTagCompound) {
        }

        @Override
        protected void readStructureFromNBT(NBTTagCompound nBTTagCompound) {
        }

        public static StructureBoundingBox func_175812_a(List<StructureComponent> list, Random random, int n, int n2, int n3, EnumFacing enumFacing) {
            StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2 - 5, n3, n, n2 + 2, n3);
            switch (enumFacing) {
                case NORTH: {
                    structureBoundingBox.maxX = n + 2;
                    structureBoundingBox.minZ = n3 - 8;
                    break;
                }
                case SOUTH: {
                    structureBoundingBox.maxX = n + 2;
                    structureBoundingBox.maxZ = n3 + 8;
                    break;
                }
                case WEST: {
                    structureBoundingBox.minX = n - 8;
                    structureBoundingBox.maxZ = n3 + 2;
                    break;
                }
                case EAST: {
                    structureBoundingBox.maxX = n + 8;
                    structureBoundingBox.maxZ = n3 + 2;
                }
            }
            return StructureComponent.findIntersecting(list, structureBoundingBox) != null ? null : structureBoundingBox;
        }

        @Override
        public void buildComponent(StructureComponent structureComponent, List<StructureComponent> list, Random random) {
            int n = this.getComponentType();
            if (this.coordBaseMode != null) {
                switch (this.coordBaseMode) {
                    case NORTH: {
                        StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ - 1, EnumFacing.NORTH, n);
                        break;
                    }
                    case SOUTH: {
                        StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.maxZ + 1, EnumFacing.SOUTH, n);
                        break;
                    }
                    case WEST: {
                        StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.minX - 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.WEST, n);
                        break;
                    }
                    case EAST: {
                        StructureMineshaftPieces.func_175890_b(structureComponent, list, random, this.boundingBox.maxX + 1, this.boundingBox.minY, this.boundingBox.minZ, EnumFacing.EAST, n);
                    }
                }
            }
        }

        @Override
        public boolean addComponentParts(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (this.isLiquidInStructureBoundingBox(world2, structureBoundingBox)) {
                return false;
            }
            this.fillWithBlocks(world2, structureBoundingBox, 0, 5, 0, 2, 7, 1, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            this.fillWithBlocks(world2, structureBoundingBox, 0, 0, 7, 2, 2, 8, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            for (int i = 0; i < 5; ++i) {
                this.fillWithBlocks(world2, structureBoundingBox, 0, 5 - i - (i < 4 ? 1 : 0), 2 + i, 2, 7 - i, 2 + i, Blocks.air.getDefaultState(), Blocks.air.getDefaultState(), false);
            }
            return true;
        }
    }
}

