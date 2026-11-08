/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.optifine.DynamicLights;

public class DynamicLight {
    private Entity entity = null;
    private double offsetY = 0.0;
    private double lastPosX = -2.147483648E9;
    private double lastPosY = -2.147483648E9;
    private double lastPosZ = -2.147483648E9;
    private int lastLightLevel = 0;
    private boolean underwater = false;
    private long timeCheckMs = 0L;
    private Set<BlockPos> setLitChunkPos = new HashSet<BlockPos>();
    private BlockPos.MutableBlockPos blockPosMutable = new BlockPos.MutableBlockPos();

    public DynamicLight(Entity entity) {
        this.entity = entity;
        this.offsetY = entity.getEyeHeight();
    }

    public void update(RenderGlobal renderGlobal) {
        if (Config.isDynamicLightsFast()) {
            long l = System.currentTimeMillis();
            if (l < this.timeCheckMs + 500L) {
                return;
            }
            this.timeCheckMs = l;
        }
        double d = this.entity.posX - 0.5;
        double d2 = this.entity.posY - 0.5 + this.offsetY;
        double d3 = this.entity.posZ - 0.5;
        int n = DynamicLights.getLightLevel(this.entity);
        double d4 = d - this.lastPosX;
        double d5 = d2 - this.lastPosY;
        double d6 = d3 - this.lastPosZ;
        double d7 = 0.1;
        if (Math.abs(d4) > d7 || Math.abs(d5) > d7 || Math.abs(d6) > d7 || this.lastLightLevel != n) {
            Object object;
            Object object2;
            this.lastPosX = d;
            this.lastPosY = d2;
            this.lastPosZ = d3;
            this.lastLightLevel = n;
            this.underwater = false;
            WorldClient worldClient = renderGlobal.getWorld();
            if (worldClient != null) {
                this.blockPosMutable.set(MathHelper.floor_double(d), MathHelper.floor_double(d2), MathHelper.floor_double(d3));
                object2 = worldClient.getBlockState(this.blockPosMutable);
                object = object2.getBlock();
                this.underwater = object == Blocks.water;
            }
            object2 = new HashSet<BlockPos>();
            if (n > 0) {
                object = (MathHelper.floor_double(d) & 0xF) >= 8 ? EnumFacing.EAST : EnumFacing.WEST;
                EnumFacing enumFacing = (MathHelper.floor_double(d2) & 0xF) >= 8 ? EnumFacing.UP : EnumFacing.DOWN;
                EnumFacing enumFacing2 = (MathHelper.floor_double(d3) & 0xF) >= 8 ? EnumFacing.SOUTH : EnumFacing.NORTH;
                BlockPos blockPos = new BlockPos(d, d2, d3);
                RenderChunk renderChunk = renderGlobal.getRenderChunk(blockPos);
                BlockPos blockPos2 = this.getChunkPos(renderChunk, blockPos, (EnumFacing)object);
                RenderChunk renderChunk2 = renderGlobal.getRenderChunk(blockPos2);
                BlockPos blockPos3 = this.getChunkPos(renderChunk, blockPos, enumFacing2);
                RenderChunk renderChunk3 = renderGlobal.getRenderChunk(blockPos3);
                BlockPos blockPos4 = this.getChunkPos(renderChunk2, blockPos2, enumFacing2);
                RenderChunk renderChunk4 = renderGlobal.getRenderChunk(blockPos4);
                BlockPos blockPos5 = this.getChunkPos(renderChunk, blockPos, enumFacing);
                RenderChunk renderChunk5 = renderGlobal.getRenderChunk(blockPos5);
                BlockPos blockPos6 = this.getChunkPos(renderChunk5, blockPos5, (EnumFacing)object);
                RenderChunk renderChunk6 = renderGlobal.getRenderChunk(blockPos6);
                BlockPos blockPos7 = this.getChunkPos(renderChunk5, blockPos5, enumFacing2);
                RenderChunk renderChunk7 = renderGlobal.getRenderChunk(blockPos7);
                BlockPos blockPos8 = this.getChunkPos(renderChunk6, blockPos6, enumFacing2);
                RenderChunk renderChunk8 = renderGlobal.getRenderChunk(blockPos8);
                this.updateChunkLight(renderChunk, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk2, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk3, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk4, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk5, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk6, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk7, this.setLitChunkPos, (Set<BlockPos>)object2);
                this.updateChunkLight(renderChunk8, this.setLitChunkPos, (Set<BlockPos>)object2);
            }
            this.updateLitChunks(renderGlobal);
            this.setLitChunkPos = object2;
        }
    }

    private BlockPos getChunkPos(RenderChunk renderChunk, BlockPos blockPos, EnumFacing enumFacing) {
        return renderChunk != null ? renderChunk.getBlockPosOffset16(enumFacing) : blockPos.offset(enumFacing, 16);
    }

    private void updateChunkLight(RenderChunk renderChunk, Set<BlockPos> set, Set<BlockPos> set2) {
        if (renderChunk != null) {
            CompiledChunk compiledChunk = renderChunk.getCompiledChunk();
            if (compiledChunk != null && !compiledChunk.isEmpty()) {
                renderChunk.setNeedsUpdate(true);
            }
            BlockPos blockPos = renderChunk.getPosition();
            if (set != null) {
                set.remove(blockPos);
            }
            if (set2 != null) {
                set2.add(blockPos);
            }
        }
    }

    public void updateLitChunks(RenderGlobal renderGlobal) {
        for (BlockPos blockPos : this.setLitChunkPos) {
            RenderChunk renderChunk = renderGlobal.getRenderChunk(blockPos);
            this.updateChunkLight(renderChunk, null, null);
        }
    }

    public Entity getEntity() {
        return this.entity;
    }

    public double getLastPosX() {
        return this.lastPosX;
    }

    public double getLastPosY() {
        return this.lastPosY;
    }

    public double getLastPosZ() {
        return this.lastPosZ;
    }

    public int getLastLightLevel() {
        return this.lastLightLevel;
    }

    public boolean isUnderwater() {
        return this.underwater;
    }

    public double getOffsetY() {
        return this.offsetY;
    }

    public String toString() {
        return "Entity: " + String.valueOf(this.entity) + ", offsetY: " + this.offsetY;
    }
}

