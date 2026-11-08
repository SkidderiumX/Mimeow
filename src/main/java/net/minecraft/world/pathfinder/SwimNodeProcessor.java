/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.pathfinder;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.pathfinder.NodeProcessor;

public class SwimNodeProcessor
extends NodeProcessor {
    @Override
    public void initProcessor(IBlockAccess iBlockAccess, Entity entity) {
        super.initProcessor(iBlockAccess, entity);
    }

    @Override
    public void postProcess() {
        super.postProcess();
    }

    @Override
    public PathPoint getPathPointTo(Entity entity) {
        return this.openPoint(MathHelper.floor_double(entity.getEntityBoundingBox().minX), MathHelper.floor_double(entity.getEntityBoundingBox().minY + 0.5), MathHelper.floor_double(entity.getEntityBoundingBox().minZ));
    }

    @Override
    public PathPoint getPathPointToCoords(Entity entity, double d, double d2, double d3) {
        return this.openPoint(MathHelper.floor_double(d - (double)(entity.width / 2.0f)), MathHelper.floor_double(d2 + 0.5), MathHelper.floor_double(d3 - (double)(entity.width / 2.0f)));
    }

    @Override
    public int findPathOptions(PathPoint[] pathPointArray, Entity entity, PathPoint pathPoint, PathPoint pathPoint2, float f) {
        int n = 0;
        for (EnumFacing enumFacing : EnumFacing.values()) {
            PathPoint pathPoint3 = this.getSafePoint(entity, pathPoint.xCoord + enumFacing.getFrontOffsetX(), pathPoint.yCoord + enumFacing.getFrontOffsetY(), pathPoint.zCoord + enumFacing.getFrontOffsetZ());
            if (pathPoint3 == null || pathPoint3.visited || !(pathPoint3.distanceTo(pathPoint2) < f)) continue;
            pathPointArray[n++] = pathPoint3;
        }
        return n;
    }

    private PathPoint getSafePoint(Entity entity, int n, int n2, int n3) {
        int n4 = this.func_176186_b(entity, n, n2, n3);
        return n4 == -1 ? this.openPoint(n, n2, n3) : null;
    }

    private int func_176186_b(Entity entity, int n, int n2, int n3) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i < n + this.entitySizeX; ++i) {
            for (int j = n2; j < n2 + this.entitySizeY; ++j) {
                for (int k = n3; k < n3 + this.entitySizeZ; ++k) {
                    Block block = this.blockaccess.getBlockState(mutableBlockPos.set(i, j, k)).getBlock();
                    if (block.getMaterial() == Material.water) continue;
                    return 0;
                }
            }
        }
        return -1;
    }
}

