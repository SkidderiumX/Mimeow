/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.LongHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.WorldServer;

public class Teleporter {
    private final WorldServer worldServerInstance;
    private final Random random;
    private final LongHashMap<PortalPosition> destinationCoordinateCache = new LongHashMap();
    private final List<Long> destinationCoordinateKeys = Lists.newArrayList();

    public Teleporter(WorldServer worldServer) {
        this.worldServerInstance = worldServer;
        this.random = new Random(worldServer.getSeed());
    }

    public void placeInPortal(Entity entity, float f) {
        if (this.worldServerInstance.provider.getDimensionId() != 1) {
            if (!this.placeInExistingPortal(entity, f)) {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, f);
            }
        } else {
            int n = MathHelper.floor_double(entity.posX);
            int n2 = MathHelper.floor_double(entity.posY) - 1;
            int n3 = MathHelper.floor_double(entity.posZ);
            int n4 = 1;
            int n5 = 0;
            for (int i = -2; i <= 2; ++i) {
                for (int j = -2; j <= 2; ++j) {
                    for (int k = -1; k < 3; ++k) {
                        int n6 = n + j * n4 + i * n5;
                        int n7 = n2 + k;
                        int n8 = n3 + j * n5 - i * n4;
                        boolean bl = k < 0;
                        this.worldServerInstance.setBlockState(new BlockPos(n6, n7, n8), bl ? Blocks.obsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
            entity.setLocationAndAngles(n, n2, n3, entity.rotationYaw, 0.0f);
            entity.motionZ = 0.0;
            entity.motionY = 0.0;
            entity.motionX = 0.0;
        }
    }

    public boolean placeInExistingPortal(Entity entity, float f) {
        int n = 128;
        double d = -1.0;
        int n2 = MathHelper.floor_double(entity.posX);
        int n3 = MathHelper.floor_double(entity.posZ);
        boolean bl = true;
        BlockPos blockPos = BlockPos.ORIGIN;
        long l = ChunkCoordIntPair.chunkXZ2Int(n2, n3);
        if (this.destinationCoordinateCache.containsItem(l)) {
            var12_10 = this.destinationCoordinateCache.getValueByKey(l);
            d = 0.0;
            blockPos = var12_10;
            ((PortalPosition)var12_10).lastUpdateTime = this.worldServerInstance.getTotalWorldTime();
            bl = false;
        } else {
            var12_10 = new BlockPos(entity);
            for (int i = -128; i <= 128; ++i) {
                for (int j = -128; j <= 128; ++j) {
                    BlockPos blockPos2 = var12_10.add(i, this.worldServerInstance.getActualHeight() - 1 - var12_10.getY(), j);
                    while (blockPos2.getY() >= 0) {
                        BlockPos blockPos3 = blockPos2.down();
                        if (this.worldServerInstance.getBlockState(blockPos2).getBlock() == Blocks.portal) {
                            while (this.worldServerInstance.getBlockState(blockPos3 = blockPos2.down()).getBlock() == Blocks.portal) {
                                blockPos2 = blockPos3;
                            }
                            double d2 = blockPos2.distanceSq(var12_10);
                            if (d < 0.0 || d2 < d) {
                                d = d2;
                                blockPos = blockPos2;
                            }
                        }
                        blockPos2 = blockPos3;
                    }
                }
            }
        }
        if (d >= 0.0) {
            if (bl) {
                this.destinationCoordinateCache.add(l, new PortalPosition(blockPos, this.worldServerInstance.getTotalWorldTime()));
                this.destinationCoordinateKeys.add(l);
            }
            double d3 = (double)blockPos.getX() + 0.5;
            double d4 = (double)blockPos.getY() + 0.5;
            double d5 = (double)blockPos.getZ() + 0.5;
            BlockPattern.PatternHelper patternHelper = Blocks.portal.func_181089_f(this.worldServerInstance, blockPos);
            boolean bl2 = patternHelper.getFinger().rotateY().getAxisDirection() == EnumFacing.AxisDirection.NEGATIVE;
            double d6 = patternHelper.getFinger().getAxis() == EnumFacing.Axis.X ? (double)patternHelper.getPos().getZ() : (double)patternHelper.getPos().getX();
            d4 = (double)(patternHelper.getPos().getY() + 1) - entity.func_181014_aG().yCoord * (double)patternHelper.func_181119_e();
            if (bl2) {
                d6 += 1.0;
            }
            if (patternHelper.getFinger().getAxis() == EnumFacing.Axis.X) {
                d5 = d6 + (1.0 - entity.func_181014_aG().xCoord) * (double)patternHelper.func_181118_d() * (double)patternHelper.getFinger().rotateY().getAxisDirection().getOffset();
            } else {
                d3 = d6 + (1.0 - entity.func_181014_aG().xCoord) * (double)patternHelper.func_181118_d() * (double)patternHelper.getFinger().rotateY().getAxisDirection().getOffset();
            }
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = 0.0f;
            if (patternHelper.getFinger().getOpposite() == entity.getTeleportDirection()) {
                f2 = 1.0f;
                f3 = 1.0f;
            } else if (patternHelper.getFinger().getOpposite() == entity.getTeleportDirection().getOpposite()) {
                f2 = -1.0f;
                f3 = -1.0f;
            } else if (patternHelper.getFinger().getOpposite() == entity.getTeleportDirection().rotateY()) {
                f4 = 1.0f;
                f5 = -1.0f;
            } else {
                f4 = -1.0f;
                f5 = 1.0f;
            }
            double d7 = entity.motionX;
            double d8 = entity.motionZ;
            entity.motionX = d7 * (double)f2 + d8 * (double)f5;
            entity.motionZ = d7 * (double)f4 + d8 * (double)f3;
            entity.rotationYaw = f - (float)(entity.getTeleportDirection().getOpposite().getHorizontalIndex() * 90) + (float)(patternHelper.getFinger().getHorizontalIndex() * 90);
            entity.setLocationAndAngles(d3, d4, d5, entity.rotationYaw, entity.rotationPitch);
            return true;
        }
        return false;
    }

    public boolean makePortal(Entity entity) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        double d;
        int n9;
        double d2;
        int n10;
        int n11 = 16;
        double d3 = -1.0;
        int n12 = MathHelper.floor_double(entity.posX);
        int n13 = MathHelper.floor_double(entity.posY);
        int n14 = MathHelper.floor_double(entity.posZ);
        int n15 = n12;
        int n16 = n13;
        int n17 = n14;
        int n18 = 0;
        int n19 = this.random.nextInt(4);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (n10 = n12 - n11; n10 <= n12 + n11; ++n10) {
            d2 = (double)n10 + 0.5 - entity.posX;
            for (n9 = n14 - n11; n9 <= n14 + n11; ++n9) {
                d = (double)n9 + 0.5 - entity.posZ;
                block2: for (n8 = this.worldServerInstance.getActualHeight() - 1; n8 >= 0; --n8) {
                    if (!this.worldServerInstance.isAirBlock(mutableBlockPos.set(n10, n8, n9))) continue;
                    while (n8 > 0 && this.worldServerInstance.isAirBlock(mutableBlockPos.set(n10, n8 - 1, n9))) {
                        --n8;
                    }
                    for (n7 = n19; n7 < n19 + 4; ++n7) {
                        n6 = n7 % 2;
                        n5 = 1 - n6;
                        if (n7 % 4 >= 2) {
                            n6 = -n6;
                            n5 = -n5;
                        }
                        for (n4 = 0; n4 < 3; ++n4) {
                            for (n3 = 0; n3 < 4; ++n3) {
                                for (int i = -1; i < 4; ++i) {
                                    n2 = n10 + (n3 - 1) * n6 + n4 * n5;
                                    n = n8 + i;
                                    int n20 = n9 + (n3 - 1) * n5 - n4 * n6;
                                    mutableBlockPos.set(n2, n, n20);
                                    if (i < 0 && !this.worldServerInstance.getBlockState(mutableBlockPos).getBlock().getMaterial().isSolid() || i >= 0 && !this.worldServerInstance.isAirBlock(mutableBlockPos)) continue block2;
                                }
                            }
                        }
                        double d4 = (double)n8 + 0.5 - entity.posY;
                        double d5 = d2 * d2 + d4 * d4 + d * d;
                        if (!(d3 < 0.0) && !(d5 < d3)) continue;
                        d3 = d5;
                        n15 = n10;
                        n16 = n8;
                        n17 = n9;
                        n18 = n7 % 4;
                    }
                }
            }
        }
        if (d3 < 0.0) {
            for (n10 = n12 - n11; n10 <= n12 + n11; ++n10) {
                d2 = (double)n10 + 0.5 - entity.posX;
                for (n9 = n14 - n11; n9 <= n14 + n11; ++n9) {
                    d = (double)n9 + 0.5 - entity.posZ;
                    block10: for (n8 = this.worldServerInstance.getActualHeight() - 1; n8 >= 0; --n8) {
                        if (!this.worldServerInstance.isAirBlock(mutableBlockPos.set(n10, n8, n9))) continue;
                        while (n8 > 0 && this.worldServerInstance.isAirBlock(mutableBlockPos.set(n10, n8 - 1, n9))) {
                            --n8;
                        }
                        for (n7 = n19; n7 < n19 + 2; ++n7) {
                            n6 = n7 % 2;
                            n5 = 1 - n6;
                            for (int i = 0; i < 4; ++i) {
                                for (n3 = -1; n3 < 4; ++n3) {
                                    int n21 = n10 + (i - 1) * n6;
                                    n2 = n8 + n3;
                                    n = n9 + (i - 1) * n5;
                                    mutableBlockPos.set(n21, n2, n);
                                    if (n3 < 0 && !this.worldServerInstance.getBlockState(mutableBlockPos).getBlock().getMaterial().isSolid() || n3 >= 0 && !this.worldServerInstance.isAirBlock(mutableBlockPos)) continue block10;
                                }
                            }
                            double d6 = (double)n8 + 0.5 - entity.posY;
                            double d7 = d2 * d2 + d6 * d6 + d * d;
                            if (!(d3 < 0.0) && !(d7 < d3)) continue;
                            d3 = d7;
                            n15 = n10;
                            n16 = n8;
                            n17 = n9;
                            n18 = n7 % 2;
                        }
                    }
                }
            }
        }
        n10 = n15;
        int n22 = n16;
        int n23 = n17;
        n9 = n18 % 2;
        int n24 = 1 - n9;
        if (n18 % 4 >= 2) {
            n9 = -n9;
            n24 = -n24;
        }
        if (d3 < 0.0) {
            n22 = n16 = MathHelper.clamp_int(n16, 70, this.worldServerInstance.getActualHeight() - 10);
            for (int i = -1; i <= 1; ++i) {
                for (n8 = 1; n8 < 3; ++n8) {
                    for (n7 = -1; n7 < 3; ++n7) {
                        n6 = n10 + (n8 - 1) * n9 + i * n24;
                        n5 = n22 + n7;
                        n4 = n23 + (n8 - 1) * n24 - i * n9;
                        n3 = n7 < 0 ? 1 : 0;
                        this.worldServerInstance.setBlockState(new BlockPos(n6, n5, n4), n3 != 0 ? Blocks.obsidian.getDefaultState() : Blocks.air.getDefaultState());
                    }
                }
            }
        }
        IBlockState iBlockState = Blocks.portal.getDefaultState().withProperty(BlockPortal.AXIS, n9 != 0 ? EnumFacing.Axis.X : EnumFacing.Axis.Z);
        for (n8 = 0; n8 < 4; ++n8) {
            for (n7 = 0; n7 < 4; ++n7) {
                for (n6 = -1; n6 < 4; ++n6) {
                    n5 = n10 + (n7 - 1) * n9;
                    n4 = n22 + n6;
                    n3 = n23 + (n7 - 1) * n24;
                    boolean bl = n7 == 0 || n7 == 3 || n6 == -1 || n6 == 3;
                    this.worldServerInstance.setBlockState(new BlockPos(n5, n4, n3), bl ? Blocks.obsidian.getDefaultState() : iBlockState, 2);
                }
            }
            for (n7 = 0; n7 < 4; ++n7) {
                for (n6 = -1; n6 < 4; ++n6) {
                    n5 = n10 + (n7 - 1) * n9;
                    n4 = n22 + n6;
                    n3 = n23 + (n7 - 1) * n24;
                    BlockPos blockPos = new BlockPos(n5, n4, n3);
                    this.worldServerInstance.notifyNeighborsOfStateChange(blockPos, this.worldServerInstance.getBlockState(blockPos).getBlock());
                }
            }
        }
        return true;
    }

    public void removeStalePortalLocations(long l) {
        if (l % 100L == 0L) {
            Iterator<Long> iterator2 = this.destinationCoordinateKeys.iterator();
            long l2 = l - 300L;
            while (iterator2.hasNext()) {
                Long l3 = iterator2.next();
                PortalPosition portalPosition = this.destinationCoordinateCache.getValueByKey(l3);
                if (portalPosition != null && portalPosition.lastUpdateTime >= l2) continue;
                iterator2.remove();
                this.destinationCoordinateCache.remove(l3);
            }
        }
    }

    public class PortalPosition
    extends BlockPos {
        public long lastUpdateTime;

        public PortalPosition(BlockPos blockPos, long l) {
            super(blockPos.getX(), blockPos.getY(), blockPos.getZ());
            this.lastUpdateTime = l;
        }
    }
}

