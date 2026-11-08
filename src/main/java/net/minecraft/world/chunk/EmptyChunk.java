/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class EmptyChunk
extends Chunk {
    public EmptyChunk(World world2, int n, int n2) {
        super(world2, n, n2);
    }

    @Override
    public boolean isAtLocation(int n, int n2) {
        return n == this.xPosition && n2 == this.zPosition;
    }

    @Override
    public int getHeightValue(int n, int n2) {
        return 0;
    }

    @Override
    public void generateHeightMap() {
    }

    @Override
    public void generateSkylightMap() {
    }

    @Override
    public Block getBlock(BlockPos blockPos) {
        return Blocks.air;
    }

    @Override
    public int getBlockLightOpacity(BlockPos blockPos) {
        return 255;
    }

    @Override
    public int getBlockMetadata(BlockPos blockPos) {
        return 0;
    }

    @Override
    public int getLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos) {
        return enumSkyBlock.defaultLightValue;
    }

    @Override
    public void setLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos, int n) {
    }

    @Override
    public int getLightSubtracted(BlockPos blockPos, int n) {
        return 0;
    }

    @Override
    public void addEntity(Entity entity) {
    }

    @Override
    public void removeEntity(Entity entity) {
    }

    @Override
    public void removeEntityAtIndex(Entity entity, int n) {
    }

    @Override
    public boolean canSeeSky(BlockPos blockPos) {
        return false;
    }

    @Override
    public TileEntity getTileEntity(BlockPos blockPos, Chunk.EnumCreateEntityType enumCreateEntityType) {
        return null;
    }

    @Override
    public void addTileEntity(TileEntity tileEntity) {
    }

    @Override
    public void addTileEntity(BlockPos blockPos, TileEntity tileEntity) {
    }

    @Override
    public void removeTileEntity(BlockPos blockPos) {
    }

    @Override
    public void onChunkLoad() {
    }

    @Override
    public void onChunkUnload() {
    }

    @Override
    public void setChunkModified() {
    }

    @Override
    public void getEntitiesWithinAABBForEntity(Entity entity, AxisAlignedBB axisAlignedBB, List<Entity> list, Predicate<? super Entity> predicate) {
    }

    @Override
    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(Class<? extends T> clazz, AxisAlignedBB axisAlignedBB, List<T> list, Predicate<? super T> predicate) {
    }

    @Override
    public boolean needsSaving(boolean bl) {
        return false;
    }

    @Override
    public Random getRandomWithSeed(long l) {
        return new Random(this.getWorld().getSeed() + (long)(this.xPosition * this.xPosition * 4987142) + (long)(this.xPosition * 5947611) + (long)(this.zPosition * this.zPosition) * 4392871L + (long)(this.zPosition * 389711) ^ l);
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean getAreLevelsEmpty(int n, int n2) {
        return true;
    }
}

