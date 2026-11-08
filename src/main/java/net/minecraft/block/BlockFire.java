/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.block;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTNT;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldProviderEnd;

public class BlockFire
extends Block {
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 15);
    public static final PropertyBool FLIP = PropertyBool.create("flip");
    public static final PropertyBool ALT = PropertyBool.create("alt");
    public static final PropertyBool NORTH = PropertyBool.create("north");
    public static final PropertyBool EAST = PropertyBool.create("east");
    public static final PropertyBool SOUTH = PropertyBool.create("south");
    public static final PropertyBool WEST = PropertyBool.create("west");
    public static final PropertyInteger UPPER = PropertyInteger.create("upper", 0, 2);
    private final Map<Block, Integer> encouragements = Maps.newIdentityHashMap();
    private final Map<Block, Integer> flammabilities = Maps.newIdentityHashMap();

    @Override
    public IBlockState getActualState(IBlockState iBlockState, IBlockAccess iBlockAccess, BlockPos blockPos) {
        int n = blockPos.getX();
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ();
        if (!World.doesBlockHaveSolidTopSurface(iBlockAccess, blockPos.down()) && !Blocks.fire.canCatchFire(iBlockAccess, blockPos.down())) {
            boolean bl = (n + n2 + n3 & 1) == 1;
            boolean bl2 = (n / 2 + n2 / 2 + n3 / 2 & 1) == 1;
            int n4 = 0;
            if (this.canCatchFire(iBlockAccess, blockPos.up())) {
                n4 = bl ? 1 : 2;
            }
            return iBlockState.withProperty(NORTH, this.canCatchFire(iBlockAccess, blockPos.north())).withProperty(EAST, this.canCatchFire(iBlockAccess, blockPos.east())).withProperty(SOUTH, this.canCatchFire(iBlockAccess, blockPos.south())).withProperty(WEST, this.canCatchFire(iBlockAccess, blockPos.west())).withProperty(UPPER, n4).withProperty(FLIP, bl2).withProperty(ALT, bl);
        }
        return this.getDefaultState();
    }

    protected BlockFire() {
        super(Material.fire);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, 0).withProperty(FLIP, false).withProperty(ALT, false).withProperty(NORTH, false).withProperty(EAST, false).withProperty(SOUTH, false).withProperty(WEST, false).withProperty(UPPER, 0));
        this.setTickRandomly(true);
    }

    public static void init() {
        Blocks.fire.setFireInfo(Blocks.planks, 5, 20);
        Blocks.fire.setFireInfo(Blocks.double_wooden_slab, 5, 20);
        Blocks.fire.setFireInfo(Blocks.wooden_slab, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.dark_oak_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.acacia_fence_gate, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.dark_oak_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.acacia_fence, 5, 20);
        Blocks.fire.setFireInfo(Blocks.oak_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.birch_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.spruce_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.jungle_stairs, 5, 20);
        Blocks.fire.setFireInfo(Blocks.log, 5, 5);
        Blocks.fire.setFireInfo(Blocks.log2, 5, 5);
        Blocks.fire.setFireInfo(Blocks.leaves, 30, 60);
        Blocks.fire.setFireInfo(Blocks.leaves2, 30, 60);
        Blocks.fire.setFireInfo(Blocks.bookshelf, 30, 20);
        Blocks.fire.setFireInfo(Blocks.tnt, 15, 100);
        Blocks.fire.setFireInfo(Blocks.tallgrass, 60, 100);
        Blocks.fire.setFireInfo(Blocks.double_plant, 60, 100);
        Blocks.fire.setFireInfo(Blocks.yellow_flower, 60, 100);
        Blocks.fire.setFireInfo(Blocks.red_flower, 60, 100);
        Blocks.fire.setFireInfo(Blocks.deadbush, 60, 100);
        Blocks.fire.setFireInfo(Blocks.wool, 30, 60);
        Blocks.fire.setFireInfo(Blocks.vine, 15, 100);
        Blocks.fire.setFireInfo(Blocks.coal_block, 5, 5);
        Blocks.fire.setFireInfo(Blocks.hay_block, 60, 20);
        Blocks.fire.setFireInfo(Blocks.carpet, 60, 20);
    }

    public void setFireInfo(Block block, int n, int n2) {
        this.encouragements.put(block, n);
        this.flammabilities.put(block, n2);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBox(World world2, BlockPos blockPos, IBlockState iBlockState) {
        return null;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    public int tickRate(World world2) {
        return 30;
    }

    @Override
    public void updateTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        if (world2.getGameRules().getBoolean("doFireTick")) {
            Block block;
            boolean bl;
            if (!this.canPlaceBlockAt(world2, blockPos)) {
                world2.setBlockToAir(blockPos);
            }
            boolean bl2 = bl = (block = world2.getBlockState(blockPos.down()).getBlock()) == Blocks.netherrack;
            if (world2.provider instanceof WorldProviderEnd && block == Blocks.bedrock) {
                bl = true;
            }
            if (!bl && world2.isRaining() && this.canDie(world2, blockPos)) {
                world2.setBlockToAir(blockPos);
            } else {
                int n = iBlockState.getValue(AGE);
                if (n < 15) {
                    iBlockState = iBlockState.withProperty(AGE, n + random.nextInt(3) / 2);
                    world2.setBlockState(blockPos, iBlockState, 4);
                }
                world2.scheduleUpdate(blockPos, this, this.tickRate(world2) + random.nextInt(10));
                if (!bl) {
                    if (!this.canNeighborCatchFire(world2, blockPos)) {
                        if (!World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) || n > 3) {
                            world2.setBlockToAir(blockPos);
                        }
                        return;
                    }
                    if (!this.canCatchFire(world2, blockPos.down()) && n == 15 && random.nextInt(4) == 0) {
                        world2.setBlockToAir(blockPos);
                        return;
                    }
                }
                boolean bl3 = world2.isBlockinHighHumidity(blockPos);
                int n2 = 0;
                if (bl3) {
                    n2 = -50;
                }
                this.catchOnFire(world2, blockPos.east(), 300 + n2, random, n);
                this.catchOnFire(world2, blockPos.west(), 300 + n2, random, n);
                this.catchOnFire(world2, blockPos.down(), 250 + n2, random, n);
                this.catchOnFire(world2, blockPos.up(), 250 + n2, random, n);
                this.catchOnFire(world2, blockPos.north(), 300 + n2, random, n);
                this.catchOnFire(world2, blockPos.south(), 300 + n2, random, n);
                for (int i = -1; i <= 1; ++i) {
                    for (int j = -1; j <= 1; ++j) {
                        for (int k = -1; k <= 4; ++k) {
                            BlockPos blockPos2;
                            int n3;
                            if (i == 0 && k == 0 && j == 0) continue;
                            int n4 = 100;
                            if (k > 1) {
                                n4 += (k - 1) * 100;
                            }
                            if ((n3 = this.getNeighborEncouragement(world2, blockPos2 = blockPos.add(i, k, j))) <= 0) continue;
                            int n5 = (n3 + 40 + world2.getDifficulty().getDifficultyId() * 7) / (n + 30);
                            if (bl3) {
                                n5 /= 2;
                            }
                            if (n5 <= 0 || random.nextInt(n4) > n5 || world2.isRaining() && this.canDie(world2, blockPos2)) continue;
                            int n6 = n + random.nextInt(5) / 4;
                            if (n6 > 15) {
                                n6 = 15;
                            }
                            world2.setBlockState(blockPos2, iBlockState.withProperty(AGE, n6), 3);
                        }
                    }
                }
            }
        }
    }

    protected boolean canDie(World world2, BlockPos blockPos) {
        return world2.isRainingAt(blockPos) || world2.isRainingAt(blockPos.west()) || world2.isRainingAt(blockPos.east()) || world2.isRainingAt(blockPos.north()) || world2.isRainingAt(blockPos.south());
    }

    @Override
    public boolean requiresUpdates() {
        return false;
    }

    private int getFlammability(Block block) {
        Integer n = this.flammabilities.get(block);
        return n == null ? 0 : n;
    }

    private int getEncouragement(Block block) {
        Integer n = this.encouragements.get(block);
        return n == null ? 0 : n;
    }

    private void catchOnFire(World world2, BlockPos blockPos, int n, Random random, int n2) {
        int n3 = this.getFlammability(world2.getBlockState(blockPos).getBlock());
        if (random.nextInt(n) < n3) {
            IBlockState iBlockState = world2.getBlockState(blockPos);
            if (random.nextInt(n2 + 10) < 5 && !world2.isRainingAt(blockPos)) {
                int n4 = n2 + random.nextInt(5) / 4;
                if (n4 > 15) {
                    n4 = 15;
                }
                world2.setBlockState(blockPos, this.getDefaultState().withProperty(AGE, n4), 3);
            } else {
                world2.setBlockToAir(blockPos);
            }
            if (iBlockState.getBlock() == Blocks.tnt) {
                Blocks.tnt.onBlockDestroyedByPlayer(world2, blockPos, iBlockState.withProperty(BlockTNT.EXPLODE, true));
            }
        }
    }

    private boolean canNeighborCatchFire(World world2, BlockPos blockPos) {
        for (EnumFacing enumFacing : EnumFacing.values()) {
            if (!this.canCatchFire(world2, blockPos.offset(enumFacing))) continue;
            return true;
        }
        return false;
    }

    private int getNeighborEncouragement(World world2, BlockPos blockPos) {
        if (!world2.isAirBlock(blockPos)) {
            return 0;
        }
        int n = 0;
        for (EnumFacing enumFacing : EnumFacing.values()) {
            n = Math.max(this.getEncouragement(world2.getBlockState(blockPos.offset(enumFacing)).getBlock()), n);
        }
        return n;
    }

    @Override
    public boolean isCollidable() {
        return false;
    }

    public boolean canCatchFire(IBlockAccess iBlockAccess, BlockPos blockPos) {
        return this.getEncouragement(iBlockAccess.getBlockState(blockPos).getBlock()) > 0;
    }

    @Override
    public boolean canPlaceBlockAt(World world2, BlockPos blockPos) {
        return World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) || this.canNeighborCatchFire(world2, blockPos);
    }

    @Override
    public void onNeighborBlockChange(World world2, BlockPos blockPos, IBlockState iBlockState, Block block) {
        if (!World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) && !this.canNeighborCatchFire(world2, blockPos)) {
            world2.setBlockToAir(blockPos);
        }
    }

    @Override
    public void onBlockAdded(World world2, BlockPos blockPos, IBlockState iBlockState) {
        if (world2.provider.getDimensionId() > 0 || !Blocks.portal.func_176548_d(world2, blockPos)) {
            if (!World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) && !this.canNeighborCatchFire(world2, blockPos)) {
                world2.setBlockToAir(blockPos);
            } else {
                world2.scheduleUpdate(blockPos, this, this.tickRate(world2) + world2.rand.nextInt(10));
            }
        }
    }

    @Override
    public void randomDisplayTick(World world2, BlockPos blockPos, IBlockState iBlockState, Random random) {
        block12: {
            block11: {
                double d;
                double d2;
                double d3;
                int n;
                if (random.nextInt(24) == 0) {
                    world2.playSound((float)blockPos.getX() + 0.5f, (float)blockPos.getY() + 0.5f, (float)blockPos.getZ() + 0.5f, "fire.fire", 1.0f + random.nextFloat(), random.nextFloat() * 0.7f + 0.3f, false);
                }
                if (World.doesBlockHaveSolidTopSurface(world2, blockPos.down()) || Blocks.fire.canCatchFire(world2, blockPos.down())) break block11;
                if (Blocks.fire.canCatchFire(world2, blockPos.west())) {
                    for (n = 0; n < 2; ++n) {
                        d3 = (double)blockPos.getX() + random.nextDouble() * (double)0.1f;
                        d2 = (double)blockPos.getY() + random.nextDouble();
                        d = (double)blockPos.getZ() + random.nextDouble();
                        world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d2, d, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                if (Blocks.fire.canCatchFire(world2, blockPos.east())) {
                    for (n = 0; n < 2; ++n) {
                        d3 = (double)(blockPos.getX() + 1) - random.nextDouble() * (double)0.1f;
                        d2 = (double)blockPos.getY() + random.nextDouble();
                        d = (double)blockPos.getZ() + random.nextDouble();
                        world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d2, d, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                if (Blocks.fire.canCatchFire(world2, blockPos.north())) {
                    for (n = 0; n < 2; ++n) {
                        d3 = (double)blockPos.getX() + random.nextDouble();
                        d2 = (double)blockPos.getY() + random.nextDouble();
                        d = (double)blockPos.getZ() + random.nextDouble() * (double)0.1f;
                        world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d2, d, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                if (Blocks.fire.canCatchFire(world2, blockPos.south())) {
                    for (n = 0; n < 2; ++n) {
                        d3 = (double)blockPos.getX() + random.nextDouble();
                        d2 = (double)blockPos.getY() + random.nextDouble();
                        d = (double)(blockPos.getZ() + 1) - random.nextDouble() * (double)0.1f;
                        world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d2, d, 0.0, 0.0, 0.0, new int[0]);
                    }
                }
                if (!Blocks.fire.canCatchFire(world2, blockPos.up())) break block12;
                for (n = 0; n < 2; ++n) {
                    d3 = (double)blockPos.getX() + random.nextDouble();
                    d2 = (double)(blockPos.getY() + 1) - random.nextDouble() * (double)0.1f;
                    d = (double)blockPos.getZ() + random.nextDouble();
                    world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d3, d2, d, 0.0, 0.0, 0.0, new int[0]);
                }
                break block12;
            }
            for (int i = 0; i < 3; ++i) {
                double d = (double)blockPos.getX() + random.nextDouble();
                double d4 = (double)blockPos.getY() + random.nextDouble() * 0.5 + 0.5;
                double d5 = (double)blockPos.getZ() + random.nextDouble();
                world2.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d, d4, d5, 0.0, 0.0, 0.0, new int[0]);
            }
        }
    }

    @Override
    public MapColor getMapColor(IBlockState iBlockState) {
        return MapColor.tntColor;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer() {
        return EnumWorldBlockLayer.CUTOUT;
    }

    @Override
    public IBlockState getStateFromMeta(int n) {
        return this.getDefaultState().withProperty(AGE, n);
    }

    @Override
    public int getMetaFromState(IBlockState iBlockState) {
        return iBlockState.getValue(AGE);
    }

    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, AGE, NORTH, EAST, SOUTH, WEST, UPPER, FLIP, ALT);
    }
}

