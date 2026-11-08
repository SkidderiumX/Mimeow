/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.util.ArrayDeque;
import java.util.Arrays;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.optifine.DynamicLights;

public class RegionRenderCache
extends ChunkCache {
    private static final IBlockState DEFAULT_STATE = Blocks.air.getDefaultState();
    private final BlockPos position;
    private int[] combinedLights;
    private IBlockState[] blockStates;
    private static ArrayDeque<int[]> cacheLights = new ArrayDeque();
    private static ArrayDeque<IBlockState[]> cacheStates = new ArrayDeque();
    private static int maxCacheSize = Config.limit(Runtime.getRuntime().availableProcessors(), 1, 32);

    public RegionRenderCache(World world2, BlockPos blockPos, BlockPos blockPos2, int n) {
        super(world2, blockPos, blockPos2, n);
        this.position = blockPos.subtract(new Vec3i(n, n, n));
        int n2 = 8000;
        this.combinedLights = RegionRenderCache.allocateLights(8000);
        Arrays.fill(this.combinedLights, -1);
        this.blockStates = RegionRenderCache.allocateStates(8000);
    }

    @Override
    public TileEntity getTileEntity(BlockPos blockPos) {
        int n = (blockPos.getX() >> 4) - this.chunkX;
        int n2 = (blockPos.getZ() >> 4) - this.chunkZ;
        return this.chunkArray[n][n2].getTileEntity(blockPos, Chunk.EnumCreateEntityType.QUEUED);
    }

    @Override
    public int getCombinedLight(BlockPos blockPos, int n) {
        int n2 = this.getPositionIndex(blockPos);
        int n3 = this.combinedLights[n2];
        if (n3 == -1) {
            n3 = super.getCombinedLight(blockPos, n);
            if (Config.isDynamicLights() && !this.getBlockState(blockPos).getBlock().isOpaqueCube()) {
                n3 = DynamicLights.getCombinedLight(blockPos, n3);
            }
            this.combinedLights[n2] = n3;
        }
        return n3;
    }

    @Override
    public IBlockState getBlockState(BlockPos blockPos) {
        int n = this.getPositionIndex(blockPos);
        IBlockState iBlockState = this.blockStates[n];
        if (iBlockState == null) {
            this.blockStates[n] = iBlockState = this.getBlockStateRaw(blockPos);
        }
        return iBlockState;
    }

    private IBlockState getBlockStateRaw(BlockPos blockPos) {
        return super.getBlockState(blockPos);
    }

    private int getPositionIndex(BlockPos blockPos) {
        int n = blockPos.getX() - this.position.getX();
        int n2 = blockPos.getY() - this.position.getY();
        int n3 = blockPos.getZ() - this.position.getZ();
        return n * 400 + n3 * 20 + n2;
    }

    public void freeBuffers() {
        RegionRenderCache.freeLights(this.combinedLights);
        RegionRenderCache.freeStates(this.blockStates);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static int[] allocateLights(int n) {
        ArrayDeque<int[]> arrayDeque = cacheLights;
        synchronized (arrayDeque) {
            int[] nArray = cacheLights.pollLast();
            if (nArray == null || nArray.length < n) {
                nArray = new int[n];
            }
            return nArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void freeLights(int[] nArray) {
        ArrayDeque<int[]> arrayDeque = cacheLights;
        synchronized (arrayDeque) {
            if (cacheLights.size() < maxCacheSize) {
                cacheLights.add(nArray);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static IBlockState[] allocateStates(int n) {
        ArrayDeque<IBlockState[]> arrayDeque = cacheStates;
        synchronized (arrayDeque) {
            Object[] objectArray = cacheStates.pollLast();
            if (objectArray != null && objectArray.length >= n) {
                Arrays.fill(objectArray, null);
            } else {
                objectArray = new IBlockState[n];
            }
            return objectArray;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void freeStates(IBlockState[] iBlockStateArray) {
        ArrayDeque<IBlockState[]> arrayDeque = cacheStates;
        synchronized (arrayDeque) {
            if (cacheStates.size() < maxCacheSize) {
                cacheStates.add(iBlockStateArray);
            }
        }
    }
}

