/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.chunk.IRenderChunkFactory;
import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.optifine.render.VboRegion;

public class ViewFrustum {
    protected final RenderGlobal renderGlobal;
    protected final World world;
    protected int countChunksY;
    protected int countChunksX;
    protected int countChunksZ;
    public RenderChunk[] renderChunks;
    private Map<ChunkCoordIntPair, VboRegion[]> mapVboRegions = new HashMap<ChunkCoordIntPair, VboRegion[]>();

    public ViewFrustum(World world2, int n, RenderGlobal renderGlobal, IRenderChunkFactory iRenderChunkFactory) {
        this.renderGlobal = renderGlobal;
        this.world = world2;
        this.setCountChunksXYZ(n);
        this.createRenderChunks(iRenderChunkFactory);
    }

    protected void createRenderChunks(IRenderChunkFactory iRenderChunkFactory) {
        BlockPos blockPos;
        int n;
        int n2;
        int n3 = this.countChunksX * this.countChunksY * this.countChunksZ;
        this.renderChunks = new RenderChunk[n3];
        int n4 = 0;
        for (n2 = 0; n2 < this.countChunksX; ++n2) {
            for (int i = 0; i < this.countChunksY; ++i) {
                for (n = 0; n < this.countChunksZ; ++n) {
                    int n5 = (n * this.countChunksY + i) * this.countChunksX + n2;
                    blockPos = new BlockPos(n2 * 16, i * 16, n * 16);
                    this.renderChunks[n5] = iRenderChunkFactory.makeRenderChunk(this.world, this.renderGlobal, blockPos, n4++);
                    if (!Config.isVbo() || !Config.isRenderRegions()) continue;
                    this.updateVboRegion(this.renderChunks[n5]);
                }
            }
        }
        for (n2 = 0; n2 < this.renderChunks.length; ++n2) {
            RenderChunk renderChunk = this.renderChunks[n2];
            for (n = 0; n < EnumFacing.VALUES.length; ++n) {
                EnumFacing enumFacing = EnumFacing.VALUES[n];
                blockPos = renderChunk.getBlockPosOffset16(enumFacing);
                RenderChunk renderChunk2 = this.getRenderChunk(blockPos);
                renderChunk.setRenderChunkNeighbour(enumFacing, renderChunk2);
            }
        }
    }

    public void deleteGlResources() {
        for (RenderChunk renderChunk : this.renderChunks) {
            renderChunk.deleteGlResources();
        }
        this.deleteVboRegions();
    }

    protected void setCountChunksXYZ(int n) {
        int n2;
        this.countChunksX = n2 = n * 2 + 1;
        this.countChunksY = 16;
        this.countChunksZ = n2;
    }

    public void updateChunkPositions(double d, double d2) {
        int n = MathHelper.floor_double(d) - 8;
        int n2 = MathHelper.floor_double(d2) - 8;
        int n3 = this.countChunksX * 16;
        for (int i = 0; i < this.countChunksX; ++i) {
            int n4 = this.func_178157_a(n, n3, i);
            for (int j = 0; j < this.countChunksZ; ++j) {
                int n5 = this.func_178157_a(n2, n3, j);
                for (int k = 0; k < this.countChunksY; ++k) {
                    BlockPos blockPos;
                    int n6 = k * 16;
                    RenderChunk renderChunk = this.renderChunks[(j * this.countChunksY + k) * this.countChunksX + i];
                    BlockPos blockPos2 = renderChunk.getPosition();
                    if (blockPos2.getX() == n4 && blockPos2.getY() == n6 && blockPos2.getZ() == n5 || (blockPos = new BlockPos(n4, n6, n5)).equals(renderChunk.getPosition())) continue;
                    renderChunk.setPosition(blockPos);
                }
            }
        }
    }

    private int func_178157_a(int n, int n2, int n3) {
        int n4 = n3 * 16;
        int n5 = n4 - n + n2 / 2;
        if (n5 < 0) {
            n5 -= n2 - 1;
        }
        return n4 - n5 / n2 * n2;
    }

    public void markBlocksForUpdate(int n, int n2, int n3, int n4, int n5, int n6) {
        int n7 = MathHelper.bucketInt(n, 16);
        int n8 = MathHelper.bucketInt(n2, 16);
        int n9 = MathHelper.bucketInt(n3, 16);
        int n10 = MathHelper.bucketInt(n4, 16);
        int n11 = MathHelper.bucketInt(n5, 16);
        int n12 = MathHelper.bucketInt(n6, 16);
        for (int i = n7; i <= n10; ++i) {
            int n13 = i % this.countChunksX;
            if (n13 < 0) {
                n13 += this.countChunksX;
            }
            for (int j = n8; j <= n11; ++j) {
                int n14 = j % this.countChunksY;
                if (n14 < 0) {
                    n14 += this.countChunksY;
                }
                for (int k = n9; k <= n12; ++k) {
                    int n15 = k % this.countChunksZ;
                    if (n15 < 0) {
                        n15 += this.countChunksZ;
                    }
                    int n16 = (n15 * this.countChunksY + n14) * this.countChunksX + n13;
                    RenderChunk renderChunk = this.renderChunks[n16];
                    renderChunk.setNeedsUpdate(true);
                }
            }
        }
    }

    public RenderChunk getRenderChunk(BlockPos blockPos) {
        int n = blockPos.getX() >> 4;
        int n2 = blockPos.getY() >> 4;
        int n3 = blockPos.getZ() >> 4;
        if (n2 >= 0 && n2 < this.countChunksY) {
            if ((n %= this.countChunksX) < 0) {
                n += this.countChunksX;
            }
            if ((n3 %= this.countChunksZ) < 0) {
                n3 += this.countChunksZ;
            }
            int n4 = (n3 * this.countChunksY + n2) * this.countChunksX + n;
            return this.renderChunks[n4];
        }
        return null;
    }

    private void updateVboRegion(RenderChunk renderChunk) {
        int n;
        BlockPos blockPos = renderChunk.getPosition();
        int n2 = blockPos.getX() >> 8 << 8;
        int n3 = blockPos.getZ() >> 8 << 8;
        ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(n2, n3);
        EnumWorldBlockLayer[] enumWorldBlockLayerArray = RenderChunk.ENUM_WORLD_BLOCK_LAYERS;
        VboRegion[] vboRegionArray = this.mapVboRegions.get(chunkCoordIntPair);
        if (vboRegionArray == null) {
            vboRegionArray = new VboRegion[enumWorldBlockLayerArray.length];
            for (n = 0; n < enumWorldBlockLayerArray.length; ++n) {
                vboRegionArray[n] = new VboRegion(enumWorldBlockLayerArray[n]);
            }
            this.mapVboRegions.put(chunkCoordIntPair, vboRegionArray);
        }
        for (n = 0; n < enumWorldBlockLayerArray.length; ++n) {
            VboRegion vboRegion = vboRegionArray[n];
            if (vboRegion == null) continue;
            renderChunk.getVertexBufferByLayer(n).setVboRegion(vboRegion);
        }
    }

    public void deleteVboRegions() {
        for (ChunkCoordIntPair chunkCoordIntPair : this.mapVboRegions.keySet()) {
            VboRegion[] vboRegionArray = this.mapVboRegions.get(chunkCoordIntPair);
            for (int i = 0; i < vboRegionArray.length; ++i) {
                VboRegion vboRegion = vboRegionArray[i];
                if (vboRegion != null) {
                    vboRegion.deleteGlBuffers();
                }
                vboRegionArray[i] = null;
            }
        }
        this.mapVboRegions.clear();
    }
}

