/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColorHelper;

public abstract class BlockLeaves
extends BlockLeavesBase {
    public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
    public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");
    int[] surroundings;
    protected int iconIndex;
    protected boolean isTransparent;

    public BlockLeaves() {
        super(Material.leaves, false);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(0.2f);
        this.setLightOpacity(1);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public int getBlockColor() {
        return ColorizerFoliage.getFoliageColor(0.5, 1.0);
    }

    @Override
    public int getRenderColor(IBlockState iBlockState) {
        return ColorizerFoliage.getFoliageColorBasic();
    }

    @Override
    public int colorMultiplier(IBlockAccess iBlockAccess, BlockPos blockPos, int n) {
        return BiomeColorHelper.getFoliageColorAtPos(iBlockAccess, blockPos);
    }

    @Override
    public void breakBlock(World world2, BlockPos blockPos, IBlockState iBlockState) {
        int n;
        int n2;
        int n3 = 1;
        int n4 = n3 + 1;
        int n5 = blockPos.getX();
        if (world2.isAreaLoaded(new BlockPos(n5 - n4, (n2 = blockPos.getY()) - n4, (n = blockPos.getZ()) - n4), new BlockPos(n5 + n4, n2 + n4, n + n4))) {
            for (int i = -n3; i <= n3; ++i) {
                for (int j = -n3; j <= n3; ++j) {
                    for (int k = -n3; k <= n3; ++k) {
                        BlockPos blockPos2 = blockPos.add(i, j, k);
                        IBlockState iBlockState2 = world2.getBlockState(blockPos2);
                        if (iBlockState2.getBlock().getMaterial() != Material.leaves || iBlockState2.getValue(CHECK_DECAY).booleanValue()) continue;
                        world2.setBlockState(blockPos2, iBlockState2.withProperty(CHECK_DECAY, true), 4);
                    }
                }
            }
        }
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (!world2.isRemote && iBlockState.getValue(CHECK_DECAY).booleanValue() && iBlockState.getValue(DECAYABLE).booleanValue()) {
            int n;
            int n2 = 4;
            int n3 = n2 + 1;
            int n4 = blockPos.getX();
            int n5 = blockPos.getY();
            int n6 = blockPos.getZ();
            int n7 = 32;
            int n8 = n7 * n7;
            int n9 = n7 / 2;
            if (this.surroundings == null) {
                this.surroundings = new int[n7 * n7 * n7];
            }
            if (world2.isAreaLoaded(new BlockPos(n4 - n3, n5 - n3, n6 - n3), new BlockPos(n4 + n3, n5 + n3, n6 + n3))) {
                int n10;
                int n11;
                int n12;
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (n12 = -n2; n12 <= n2; ++n12) {
                    for (n11 = -n2; n11 <= n2; ++n11) {
                        for (n10 = -n2; n10 <= n2; ++n10) {
                            Block block = world2.getBlockState(mutableBlockPos.set(n4 + n12, n5 + n11, n6 + n10)).getBlock();
                            if (block != Blocks.log && block != Blocks.log2) {
                                if (block.getMaterial() == Material.leaves) {
                                    this.surroundings[(n12 + n9) * n8 + (n11 + n9) * n7 + n10 + n9] = -2;
                                    continue;
                                }
                                this.surroundings[(n12 + n9) * n8 + (n11 + n9) * n7 + n10 + n9] = -1;
                                continue;
                            }
                            this.surroundings[(n12 + n9) * n8 + (n11 + n9) * n7 + n10 + n9] = 0;
                        }
                    }
                }
                for (n12 = 1; n12 <= 4; ++n12) {
                    for (n11 = -n2; n11 <= n2; ++n11) {
                        for (n10 = -n2; n10 <= n2; ++n10) {
                            for (int i = -n2; i <= n2; ++i) {
                                if (this.surroundings[(n11 + n9) * n8 + (n10 + n9) * n7 + i + n9] != n12 - 1) continue;
                                if (this.surroundings[(n11 + n9 - 1) * n8 + (n10 + n9) * n7 + i + n9] == -2) {
                                    this.surroundings[(n11 + n9 - 1) * n8 + (n10 + n9) * n7 + i + n9] = n12;
                                }
                                if (this.surroundings[(n11 + n9 + 1) * n8 + (n10 + n9) * n7 + i + n9] == -2) {
                                    this.surroundings[(n11 + n9 + 1) * n8 + (n10 + n9) * n7 + i + n9] = n12;
                                }
                                if (this.surroundings[(n11 + n9) * n8 + (n10 + n9 - 1) * n7 + i + n9] == -2) {
                                    this.surroundings[(n11 + n9) * n8 + (n10 + n9 - 1) * n7 + i + n9] = n12;
                                }
                                if (this.surroundings[(n11 + n9) * n8 + (n10 + n9 + 1) * n7 + i + n9] == -2) {
                                    this.surroundings[(n11 + n9) * n8 + (n10 + n9 + 1) * n7 + i + n9] = n12;
                                }
                                if (this.surroundings[(n11 + n9) * n8 + (n10 + n9) * n7 + (i + n9 - 1)] == -2) {
                                    this.surroundings[(n11 + n9) * n8 + (n10 + n9) * n7 + (i + n9 - 1)] = n12;
                                }
                                if (this.surroundings[(n11 + n9) * n8 + (n10 + n9) * n7 + i + n9 + 1] != -2) continue;
                                this.surroundings[(n11 + n9) * n8 + (n10 + n9) * n7 + i + n9 + 1] = n12;
                            }
                        }
                    }
                }
            }
            if ((n = this.surroundings[n9 * n8 + n9 * n7 + n9]) >= 0) {
                world2.setBlockState(blockPos, iBlockState.withProperty(CHECK_DECAY, false), 4);
            } else {
                this.destroy(world2, blockPos);
            }
        }
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (world2.isRainingAt(blockPos.up()) && !World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) && random.nextInt(15) == 1) {
            double d = (float)blockPos.getX() + random.nextFloat();
            double d2 = (double)blockPos.getY() - 0.05;
            double d3 = (float)blockPos.getZ() + random.nextFloat();
            world2.spawnParticle(EnumParticleTypes.DRIP_WATER, d, d2, d3, 0.0, 0.0, 0.0, new int[0]);
        }
    }

    private void destroy(World world2, BlockPos blockPos) {
        this.dropBlockAsItem(world2, blockPos, world2.getBlockState(blockPos), 0);
        world2.setBlockToAir(blockPos);
    }

    @Override
    public int quantityDropped(Random random) {
        return random.nextInt(20) == 0 ? 1 : 0;
    }

    @Override
    public Item getItemDropped(IBlockState iBlockState, Random random, int n) {
        return Item.getItemFromBlock(Blocks.sapling);
    }

    @Override
    public void dropBlockAsItemWithChance(World world2, BlockPos blockPos, IBlockState iBlockState, float f, int n) {
        if (!world2.isRemote) {
            int n2 = this.getSaplingDropChance(iBlockState);
            if (n > 0 && (n2 -= 2 << n) < 10) {
                n2 = 10;
            }
            if (world2.rand.nextInt(n2) == 0) {
                Item item = this.getItemDropped(iBlockState, world2.rand, n);
                BlockLeaves.spawnAsEntity(world2, blockPos, new ItemStack(item, 1, this.damageDropped(iBlockState)));
            }
            n2 = 200;
            if (n > 0 && (n2 -= 10 << n) < 40) {
                n2 = 40;
            }
            this.dropApple(world2, blockPos, iBlockState, n2);
        }
    }

    protected void dropApple(World world2, BlockPos blockPos, IBlockState iBlockState, int n) {
    }

    protected int getSaplingDropChance(IBlockState iBlockState) {
        return 20;
    }

    @Override
    public boolean isOpaqueCube() {
        return !this.fancyGraphics;
    }

    public void setGraphicsLevel(boolean bl) {
        this.isTransparent = bl;
        this.fancyGraphics = bl;
        this.iconIndex = bl ? 0 : 1;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return this.isTransparent ? EnumWorldBlockLayer.CUTOUT_MIPPED : EnumWorldBlockLayer.SOLID;
    }

    @Override
    public boolean isVisuallyOpaque() {
        return false;
    }

    public abstract BlockPlanks.EnumType getWoodType(int var1);
}

