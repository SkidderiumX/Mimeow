/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.base.Predicate;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.Vec3i;
import net.minecraft.world.World;

public class BlockPumpkin
extends BlockDirectional {
    private BlockPattern snowmanBasePattern;
    private BlockPattern snowmanPattern;
    private BlockPattern golemBasePattern;
    private BlockPattern golemPattern;
    private static final Predicate<IBlockState> field_181085_Q = new Predicate<IBlockState>(){

        @Override
        public boolean apply(IBlockState iBlockState) {
            return iBlockState != null && (iBlockState.getBlock() == Blocks.pumpkin || iBlockState.getBlock() == Blocks.lit_pumpkin);
        }
    };

    protected BlockPumpkin() {
        super(Material.gourd, MapColor.adobeColor);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        super.onBlockAdded(world2, blockPos, iBlockState);
        this.trySpawnGolem(world2, blockPos);
    }

    public boolean canDispenserPlace(World world2, BlockPos blockPos) {
        return this.getSnowmanBasePattern().match(world2, blockPos) != null || this.getGolemBasePattern().match(world2, blockPos) != null;
    }

    private void trySpawnGolem(World world2, BlockPos blockPos) {
        block9: {
            int n;
            BlockPattern.PatternHelper patternHelper;
            block8: {
                int n2;
                Object object;
                patternHelper = this.getSnowmanPattern().match(world2, blockPos);
                if (patternHelper == null) break block8;
                for (int i = 0; i < this.getSnowmanPattern().getThumbLength(); ++i) {
                    object = patternHelper.translateOffset(0, i, 0);
                    world2.setBlockState(((BlockWorldState)object).getPos(), Blocks.air.getDefaultState(), 2);
                }
                EntitySnowman entitySnowman = new EntitySnowman(world2);
                object = patternHelper.translateOffset(0, 2, 0).getPos();
                entitySnowman.setLocationAndAngles((double)((Vec3i)object).getX() + 0.5, (double)((Vec3i)object).getY() + 0.05, (double)((Vec3i)object).getZ() + 0.5, 0.0f, 0.0f);
                world2.spawnEntityInWorld(entitySnowman);
                for (n2 = 0; n2 < 120; ++n2) {
                    world2.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, (double)((Vec3i)object).getX() + world2.rand.nextDouble(), (double)((Vec3i)object).getY() + world2.rand.nextDouble() * 2.5, (double)((Vec3i)object).getZ() + world2.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
                }
                for (n2 = 0; n2 < this.getSnowmanPattern().getThumbLength(); ++n2) {
                    BlockWorldState blockWorldState = patternHelper.translateOffset(0, n2, 0);
                    world2.notifyNeighborsRespectDebug(blockWorldState.getPos(), Blocks.air);
                }
                break block9;
            }
            patternHelper = this.getGolemPattern().match(world2, blockPos);
            if (patternHelper == null) break block9;
            for (int i = 0; i < this.getGolemPattern().getPalmLength(); ++i) {
                for (int j = 0; j < this.getGolemPattern().getThumbLength(); ++j) {
                    world2.setBlockState(patternHelper.translateOffset(i, j, 0).getPos(), Blocks.air.getDefaultState(), 2);
                }
            }
            BlockPos blockPos2 = patternHelper.translateOffset(1, 2, 0).getPos();
            EntityIronGolem entityIronGolem = new EntityIronGolem(world2);
            entityIronGolem.setPlayerCreated(true);
            entityIronGolem.setLocationAndAngles((double)blockPos2.getX() + 0.5, (double)blockPos2.getY() + 0.05, (double)blockPos2.getZ() + 0.5, 0.0f, 0.0f);
            world2.spawnEntityInWorld(entityIronGolem);
            for (n = 0; n < 120; ++n) {
                world2.spawnParticle(EnumParticleTypes.SNOWBALL, (double)blockPos2.getX() + world2.rand.nextDouble(), (double)blockPos2.getY() + world2.rand.nextDouble() * 3.9, (double)blockPos2.getZ() + world2.rand.nextDouble(), 0.0, 0.0, 0.0, new int[0]);
            }
            for (n = 0; n < this.getGolemPattern().getPalmLength(); ++n) {
                for (int i = 0; i < this.getGolemPattern().getThumbLength(); ++i) {
                    BlockWorldState blockWorldState = patternHelper.translateOffset(n, i, 0);
                    world2.notifyNeighborsRespectDebug(blockWorldState.getPos(), Blocks.air);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return world2.getBlockState((BlockPos)blockPos).getBlock().blockMaterial.isReplaceable() && World.doesBlockHaveSolidTopSurface(world2, blockPos.down());
    }

    @Override
    public IBlockState onBlockPlaced(World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3, int n, EntityLivingBase entityLivingBase) {
        return this.getDefaultState().withProperty(FACING, entityLivingBase.getHorizontalFacing().getOpposite());
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(n));
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(FACING).getHorizontalIndex();
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, FACING);
    }

    protected BlockPattern getSnowmanBasePattern() {
        if (this.snowmanBasePattern == null) {
            this.snowmanBasePattern = FactoryBlockPattern.start().aisle(" ", "#", "#").where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }
        return this.snowmanBasePattern;
    }

    protected BlockPattern getSnowmanPattern() {
        if (this.snowmanPattern == null) {
            this.snowmanPattern = FactoryBlockPattern.start().aisle("^", "#", "#").where('^', BlockWorldState.hasState(field_181085_Q)).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.snow))).build();
        }
        return this.snowmanPattern;
    }

    protected BlockPattern getGolemBasePattern() {
        if (this.golemBasePattern == null) {
            this.golemBasePattern = FactoryBlockPattern.start().aisle("~ ~", "###", "~#~").where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.golemBasePattern;
    }

    protected BlockPattern getGolemPattern() {
        if (this.golemPattern == null) {
            this.golemPattern = FactoryBlockPattern.start().aisle("~^~", "###", "~#~").where('^', BlockWorldState.hasState(field_181085_Q)).where('#', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.iron_block))).where('~', BlockWorldState.hasState(BlockStateHelper.forBlock(Blocks.air))).build();
        }
        return this.golemPattern;
    }
}

