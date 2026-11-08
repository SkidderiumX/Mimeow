/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.pathfinding;

import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class PathNavigate {
    protected EntityLiving theEntity;
    protected World worldObj;
    protected PathEntity currentPath;
    protected double speed;
    private final IAttributeInstance pathSearchRange;
    private int totalTicks;
    private int ticksAtLastPos;
    private Vec3 lastPosCheck = new Vec3(0.0, 0.0, 0.0);
    private float heightRequirement = 1.0f;
    private final PathFinder pathFinder;

    public PathNavigate(EntityLiving entityLiving, World world2) {
        this.theEntity = entityLiving;
        this.worldObj = world2;
        this.pathSearchRange = entityLiving.getEntityAttribute(SharedMonsterAttributes.followRange);
        this.pathFinder = this.getPathFinder();
    }

    protected abstract PathFinder getPathFinder();

    public void setSpeed(double d) {
        this.speed = d;
    }

    public float getPathSearchRange() {
        return (float)this.pathSearchRange.getAttributeValue();
    }

    public final PathEntity getPathToXYZ(double d, double d2, double d3) {
        return this.getPathToPos(new BlockPos(MathHelper.floor_double(d), (int)d2, MathHelper.floor_double(d3)));
    }

    public PathEntity getPathToPos(BlockPos blockPos) {
        if (!this.canNavigate()) {
            return null;
        }
        float f = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        BlockPos blockPos2 = new BlockPos(this.theEntity);
        int n = (int)(f + 8.0f);
        ChunkCache chunkCache = new ChunkCache(this.worldObj, blockPos2.add(-n, -n, -n), blockPos2.add(n, n, n), 0);
        PathEntity pathEntity = this.pathFinder.createEntityPathTo((IBlockAccess)chunkCache, (Entity)this.theEntity, blockPos, f);
        this.worldObj.theProfiler.endSection();
        return pathEntity;
    }

    public boolean tryMoveToXYZ(double d, double d2, double d3, double d4) {
        PathEntity pathEntity = this.getPathToXYZ(MathHelper.floor_double(d), (int)d2, MathHelper.floor_double(d3));
        return this.setPath(pathEntity, d4);
    }

    public void setHeightRequirement(float f) {
        this.heightRequirement = f;
    }

    public PathEntity getPathToEntityLiving(Entity entity) {
        if (!this.canNavigate()) {
            return null;
        }
        float f = this.getPathSearchRange();
        this.worldObj.theProfiler.startSection("pathfind");
        BlockPos blockPos = new BlockPos(this.theEntity).up();
        int n = (int)(f + 16.0f);
        ChunkCache chunkCache = new ChunkCache(this.worldObj, blockPos.add(-n, -n, -n), blockPos.add(n, n, n), 0);
        PathEntity pathEntity = this.pathFinder.createEntityPathTo((IBlockAccess)chunkCache, (Entity)this.theEntity, entity, f);
        this.worldObj.theProfiler.endSection();
        return pathEntity;
    }

    public boolean tryMoveToEntityLiving(Entity entity, double d) {
        PathEntity pathEntity = this.getPathToEntityLiving(entity);
        return pathEntity != null ? this.setPath(pathEntity, d) : false;
    }

    public boolean setPath(PathEntity pathEntity, double d) {
        if (pathEntity == null) {
            this.currentPath = null;
            return false;
        }
        if (!pathEntity.isSamePath(this.currentPath)) {
            this.currentPath = pathEntity;
        }
        this.removeSunnyPath();
        if (this.currentPath.getCurrentPathLength() == 0) {
            return false;
        }
        this.speed = d;
        Vec3 vec3 = this.getEntityPosition();
        this.ticksAtLastPos = this.totalTicks;
        this.lastPosCheck = vec3;
        return true;
    }

    public PathEntity getPath() {
        return this.currentPath;
    }

    public void onUpdateNavigation() {
        ++this.totalTicks;
        if (!this.noPath()) {
            Object object;
            Vec3 vec3;
            if (this.canNavigate()) {
                this.pathFollow();
            } else if (this.currentPath != null && this.currentPath.getCurrentPathIndex() < this.currentPath.getCurrentPathLength()) {
                vec3 = this.getEntityPosition();
                object = this.currentPath.getVectorFromIndex(this.theEntity, this.currentPath.getCurrentPathIndex());
                if (vec3.yCoord > ((Vec3)object).yCoord && !this.theEntity.onGround && MathHelper.floor_double(vec3.xCoord) == MathHelper.floor_double(((Vec3)object).xCoord) && MathHelper.floor_double(vec3.zCoord) == MathHelper.floor_double(((Vec3)object).zCoord)) {
                    this.currentPath.setCurrentPathIndex(this.currentPath.getCurrentPathIndex() + 1);
                }
            }
            if (!this.noPath() && (vec3 = this.currentPath.getPosition(this.theEntity)) != null) {
                object = new AxisAlignedBB(vec3.xCoord, vec3.yCoord, vec3.zCoord, vec3.xCoord, vec3.yCoord, vec3.zCoord).expand(0.5, 0.5, 0.5);
                List<AxisAlignedBB> list = this.worldObj.getCollidingBoundingBoxes(this.theEntity, ((AxisAlignedBB)object).addCoord(0.0, -1.0, 0.0));
                double d = -1.0;
                object = ((AxisAlignedBB)object).offset(0.0, 1.0, 0.0);
                for (AxisAlignedBB axisAlignedBB : list) {
                    d = axisAlignedBB.calculateYOffset((AxisAlignedBB)object, d);
                }
                this.theEntity.getMoveHelper().setMoveTo(vec3.xCoord, vec3.yCoord + d, vec3.zCoord, this.speed);
            }
        }
    }

    protected void pathFollow() {
        int n;
        Vec3 vec3 = this.getEntityPosition();
        int n2 = this.currentPath.getCurrentPathLength();
        for (int i = this.currentPath.getCurrentPathIndex(); i < this.currentPath.getCurrentPathLength(); ++i) {
            if (this.currentPath.getPathPointFromIndex((int)i).yCoord == (int)vec3.yCoord) continue;
            n2 = i;
            break;
        }
        float f = this.theEntity.width * this.theEntity.width * this.heightRequirement;
        for (n = this.currentPath.getCurrentPathIndex(); n < n2; ++n) {
            Vec3 vec32 = this.currentPath.getVectorFromIndex(this.theEntity, n);
            if (!(vec3.squareDistanceTo(vec32) < (double)f)) continue;
            this.currentPath.setCurrentPathIndex(n + 1);
        }
        n = MathHelper.ceiling_float_int(this.theEntity.width);
        int n3 = (int)this.theEntity.height + 1;
        int n4 = n;
        for (int i = n2 - 1; i >= this.currentPath.getCurrentPathIndex(); --i) {
            if (!this.isDirectPathBetweenPoints(vec3, this.currentPath.getVectorFromIndex(this.theEntity, i), n, n3, n4)) continue;
            this.currentPath.setCurrentPathIndex(i);
            break;
        }
        this.checkForStuck(vec3);
    }

    protected void checkForStuck(Vec3 vec3) {
        if (this.totalTicks - this.ticksAtLastPos > 100) {
            if (vec3.squareDistanceTo(this.lastPosCheck) < 2.25) {
                this.clearPathEntity();
            }
            this.ticksAtLastPos = this.totalTicks;
            this.lastPosCheck = vec3;
        }
    }

    public boolean noPath() {
        return this.currentPath == null || this.currentPath.isFinished();
    }

    public void clearPathEntity() {
        this.currentPath = null;
    }

    protected abstract Vec3 getEntityPosition();

    protected abstract boolean canNavigate();

    protected boolean isInLiquid() {
        return this.theEntity.isInWater() || this.theEntity.isInLava();
    }

    protected void removeSunnyPath() {
    }

    protected abstract boolean isDirectPathBetweenPoints(Vec3 var1, Vec3 var2, int var3, int var4, int var5);
}

