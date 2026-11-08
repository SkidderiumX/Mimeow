/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.chunk;

import com.google.common.collect.Sets;
import java.nio.FloatBuffer;
import java.util.BitSet;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockRedstoneWire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RegionRenderCache;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.ViewFrustum;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.chunk.ChunkCompileTaskGenerator;
import net.minecraft.client.renderer.chunk.CompiledChunk;
import net.minecraft.client.renderer.chunk.VisGraph;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.optifine.BlockPosM;
import net.optifine.CustomBlockLayers;
import net.optifine.override.ChunkCacheOF;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.render.AabbFrame;
import net.optifine.render.RenderEnv;
import net.optifine.shaders.SVertexBuilder;

public class RenderChunk {
    private final World world;
    private final RenderGlobal renderGlobal;
    public static int renderChunksUpdated;
    private BlockPos position;
    public CompiledChunk compiledChunk = CompiledChunk.DUMMY;
    private final ReentrantLock lockCompileTask = new ReentrantLock();
    private final ReentrantLock lockCompiledChunk = new ReentrantLock();
    private ChunkCompileTaskGenerator compileTask = null;
    private final Set<TileEntity> setTileEntities = Sets.newHashSet();
    private final int index;
    private final FloatBuffer modelviewMatrix = GLAllocation.createDirectFloatBuffer(16);
    private final VertexBuffer[] vertexBuffers = new VertexBuffer[EnumWorldBlockLayer.values().length];
    public AxisAlignedBB boundingBox;
    private int frameIndex = -1;
    private boolean needsUpdate = true;
    private EnumMap<EnumFacing, BlockPos> mapEnumFacing = null;
    private BlockPos[] positionOffsets16 = new BlockPos[EnumFacing.VALUES.length];
    public static final EnumWorldBlockLayer[] ENUM_WORLD_BLOCK_LAYERS;
    private final EnumWorldBlockLayer[] blockLayersSingle = new EnumWorldBlockLayer[1];
    private final boolean isMipmaps = Config.isMipmaps();
    private final boolean fixBlockLayer = !Reflector.BetterFoliageClient.exists();
    private boolean playerUpdate = false;
    public int regionX;
    public int regionZ;
    private final RenderChunk[] renderChunksOfset16 = new RenderChunk[6];
    private boolean renderChunksOffset16Updated = false;
    private Chunk chunk;
    private RenderChunk[] renderChunkNeighbours = new RenderChunk[EnumFacing.VALUES.length];
    private RenderChunk[] renderChunkNeighboursValid = new RenderChunk[EnumFacing.VALUES.length];
    private boolean renderChunkNeighboursUpated = false;
    private RenderGlobal.ContainerLocalRenderInformation renderInfo = new RenderGlobal.ContainerLocalRenderInformation(this, null, 0);
    public AabbFrame boundingBoxParent;

    public RenderChunk(World world2, RenderGlobal renderGlobal, BlockPos blockPos, int n) {
        this.world = world2;
        this.renderGlobal = renderGlobal;
        this.index = n;
        if (!blockPos.equals(this.getPosition())) {
            this.setPosition(blockPos);
        }
        if (OpenGlHelper.useVbo()) {
            for (int i = 0; i < EnumWorldBlockLayer.values().length; ++i) {
                this.vertexBuffers[i] = new VertexBuffer(DefaultVertexFormats.BLOCK);
            }
        }
    }

    public boolean setFrameIndex(int n) {
        if (this.frameIndex == n) {
            return false;
        }
        this.frameIndex = n;
        return true;
    }

    public VertexBuffer getVertexBufferByLayer(int n) {
        return this.vertexBuffers[n];
    }

    public void setPosition(BlockPos blockPos) {
        int n;
        this.stopCompileTask();
        this.position = blockPos;
        int n2 = 8;
        this.regionX = blockPos.getX() >> n2 << n2;
        this.regionZ = blockPos.getZ() >> n2 << n2;
        this.boundingBox = new AxisAlignedBB(blockPos, blockPos.add(16, 16, 16));
        this.initModelviewMatrix();
        for (n = 0; n < this.positionOffsets16.length; ++n) {
            this.positionOffsets16[n] = null;
        }
        this.renderChunksOffset16Updated = false;
        this.renderChunkNeighboursUpated = false;
        for (n = 0; n < this.renderChunkNeighbours.length; ++n) {
            RenderChunk renderChunk = this.renderChunkNeighbours[n];
            if (renderChunk == null) continue;
            renderChunk.renderChunkNeighboursUpated = false;
        }
        this.chunk = null;
        this.boundingBoxParent = null;
    }

    public void resortTransparency(float f, float f2, float f3, ChunkCompileTaskGenerator chunkCompileTaskGenerator) {
        CompiledChunk compiledChunk = chunkCompileTaskGenerator.getCompiledChunk();
        if (compiledChunk.getState() != null && !compiledChunk.isLayerEmpty(EnumWorldBlockLayer.TRANSLUCENT)) {
            WorldRenderer worldRenderer = chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayer(EnumWorldBlockLayer.TRANSLUCENT);
            this.preRenderBlocks(worldRenderer, this.position);
            worldRenderer.setVertexState(compiledChunk.getState());
            this.postRenderBlocks(EnumWorldBlockLayer.TRANSLUCENT, f, f2, f3, worldRenderer, compiledChunk);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void rebuildChunk(float f, float f2, float f3, ChunkCompileTaskGenerator chunkCompileTaskGenerator) {
        Object object;
        Object object2;
        CompiledChunk compiledChunk = new CompiledChunk();
        boolean bl = true;
        BlockPos blockPos = new BlockPos(this.position);
        chunkCompileTaskGenerator.getLock().lock();
        try {
            if (chunkCompileTaskGenerator.getStatus() != ChunkCompileTaskGenerator.Status.COMPILING) {
                return;
            }
            chunkCompileTaskGenerator.setCompiledChunk(compiledChunk);
        }
        finally {
            chunkCompileTaskGenerator.getLock().unlock();
        }
        VisGraph visGraph = new VisGraph();
        HashSet<EnumWorldBlockLayer[]> hashSet = Sets.newHashSet();
        if (!this.isChunkRegionEmpty(blockPos)) {
            ++renderChunksUpdated;
            object2 = this.makeChunkCacheOF(blockPos);
            ((ChunkCacheOF)object2).renderStart();
            object = new boolean[ENUM_WORLD_BLOCK_LAYERS.length];
            BlockRendererDispatcher blockRendererDispatcher = Minecraft.getMinecraft().getBlockRendererDispatcher();
            boolean bl2 = Reflector.CompatBlock_canRenderInLayer.exists();
            boolean bl3 = Reflector.CompatHooksClient_setRenderLayer.exists();
            ExtendedBlockStorage extendedBlockStorage = this.getChunk(blockPos).getBlockStorageArray()[blockPos.getY() >> 4];
            char[] cArray = extendedBlockStorage == null ? null : extendedBlockStorage.getData();
            int n = Block.BLOCK_STATE_IDS.get(Blocks.air.getDefaultState());
            BlockPosM blockPosM = new BlockPosM(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 3);
            if (cArray != null) {
                for (int i = 0; i < 16; ++i) {
                    for (int j = 0; j < 16; ++j) {
                        int n2;
                        int n3 = j << 8 | i << 4;
                        int n4 = 0;
                        for (n2 = 0; n2 < 16; ++n2) {
                            if (cArray[n3 + n2] == n) continue;
                            n4 |= 1 << n2;
                        }
                        while (n4 != 0) {
                            Object object3;
                            n2 = Integer.numberOfTrailingZeros(n4);
                            n4 &= n4 - 1;
                            blockPosM.setXyz(blockPos.getX() + n2, blockPos.getY() + j, blockPos.getZ() + i);
                            IBlockState iBlockState = ((ChunkCacheOF)object2).getBlockState(blockPosM);
                            Block block = iBlockState.getBlock();
                            if (block.isOpaqueCube()) {
                                visGraph.func_178606_a(blockPosM);
                            }
                            if (ReflectorCompat.blockHasTileEntity(iBlockState)) {
                                object3 = ((ChunkCacheOF)object2).getTileEntity(new BlockPos(blockPosM));
                                TileEntitySpecialRenderer tileEntitySpecialRenderer = TileEntityRendererDispatcher.instance.getSpecialRenderer((TileEntity)object3);
                                if (object3 != null && tileEntitySpecialRenderer != null) {
                                    compiledChunk.addTileEntity((TileEntity)object3);
                                    if (tileEntitySpecialRenderer.forceTileEntityRender()) {
                                        hashSet.add((EnumWorldBlockLayer[])object3);
                                    }
                                }
                            }
                            if (bl2) {
                                object3 = ENUM_WORLD_BLOCK_LAYERS;
                            } else {
                                object3 = this.blockLayersSingle;
                                object3[0] = block.getBlockLayer();
                            }
                            for (int k = 0; k < ((EnumWorldBlockLayer[])object3).length; ++k) {
                                int n5;
                                EnumWorldBlockLayer enumWorldBlockLayer = object3[k];
                                if (bl2 && (n5 = Reflector.callBoolean(block, Reflector.CompatBlock_canRenderInLayer, new Object[]{enumWorldBlockLayer})) == 0) continue;
                                if (bl3) {
                                    Reflector.callVoid(Reflector.CompatHooksClient_setRenderLayer, new Object[]{enumWorldBlockLayer});
                                }
                                enumWorldBlockLayer = this.fixBlockLayer(iBlockState, enumWorldBlockLayer);
                                n5 = enumWorldBlockLayer.ordinal();
                                if (block.getRenderType() == -1) continue;
                                WorldRenderer worldRenderer = chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayerId(n5);
                                worldRenderer.setBlockLayer(enumWorldBlockLayer);
                                RenderEnv renderEnv = worldRenderer.getRenderEnv(iBlockState, blockPosM);
                                renderEnv.setRegionRenderCacheBuilder(chunkCompileTaskGenerator.getRegionRenderCacheBuilder());
                                if (!compiledChunk.isLayerStarted(enumWorldBlockLayer)) {
                                    compiledChunk.setLayerStarted(enumWorldBlockLayer);
                                    this.preRenderBlocks(worldRenderer, blockPos);
                                }
                                Object object4 = object;
                                int n6 = n5;
                                object4[n6] = object4[n6] | blockRendererDispatcher.renderBlock(iBlockState, blockPosM, (IBlockAccess)object2, worldRenderer);
                                if (!renderEnv.isOverlaysRendered()) continue;
                                this.postRenderOverlays(chunkCompileTaskGenerator.getRegionRenderCacheBuilder(), compiledChunk, (boolean[])object);
                                renderEnv.setOverlaysRendered(false);
                            }
                            if (!bl3) continue;
                            Reflector.callVoid(Reflector.CompatHooksClient_setRenderLayer, new Object[]{null});
                        }
                    }
                }
            }
            for (EnumWorldBlockLayer enumWorldBlockLayer : ENUM_WORLD_BLOCK_LAYERS) {
                if (object[enumWorldBlockLayer.ordinal()] != false) {
                    compiledChunk.setLayerUsed(enumWorldBlockLayer);
                }
                if (compiledChunk.isLayerStarted(enumWorldBlockLayer)) {
                    if (Config.isShaders()) {
                        SVertexBuilder.calcNormalChunkLayer(chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayer(enumWorldBlockLayer));
                    }
                    WorldRenderer worldRenderer = chunkCompileTaskGenerator.getRegionRenderCacheBuilder().getWorldRendererByLayer(enumWorldBlockLayer);
                    this.postRenderBlocks(enumWorldBlockLayer, f, f2, f3, worldRenderer, compiledChunk);
                    if (worldRenderer.animatedSprites == null) continue;
                    compiledChunk.setAnimatedSprites(enumWorldBlockLayer, (BitSet)worldRenderer.animatedSprites.clone());
                    continue;
                }
                compiledChunk.setAnimatedSprites(enumWorldBlockLayer, null);
            }
            ((ChunkCacheOF)object2).renderFinish();
        }
        compiledChunk.setVisibility(visGraph.computeVisibility());
        this.lockCompileTask.lock();
        try {
            object2 = Sets.newHashSet(hashSet);
            object = Sets.newHashSet(this.setTileEntities);
            object2.removeAll(this.setTileEntities);
            object.removeAll(hashSet);
            this.setTileEntities.clear();
            this.setTileEntities.addAll(hashSet);
            this.renderGlobal.updateTileEntities((Collection<TileEntity>)object, (Collection<TileEntity>)object2);
        }
        finally {
            this.lockCompileTask.unlock();
        }
    }

    protected void finishCompileTask() {
        this.lockCompileTask.lock();
        try {
            if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
                this.compileTask.finish();
                this.compileTask = null;
            }
        }
        finally {
            this.lockCompileTask.unlock();
        }
    }

    public ReentrantLock getLockCompileTask() {
        return this.lockCompileTask;
    }

    public ChunkCompileTaskGenerator makeCompileTaskChunk() {
        ChunkCompileTaskGenerator chunkCompileTaskGenerator;
        this.lockCompileTask.lock();
        try {
            this.finishCompileTask();
            chunkCompileTaskGenerator = this.compileTask = new ChunkCompileTaskGenerator(this, ChunkCompileTaskGenerator.Type.REBUILD_CHUNK);
        }
        finally {
            this.lockCompileTask.unlock();
        }
        return chunkCompileTaskGenerator;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ChunkCompileTaskGenerator makeCompileTaskTransparency() {
        ChunkCompileTaskGenerator chunkCompileTaskGenerator;
        this.lockCompileTask.lock();
        try {
            ChunkCompileTaskGenerator chunkCompileTaskGenerator2;
            if (this.compileTask != null && this.compileTask.getStatus() == ChunkCompileTaskGenerator.Status.PENDING) {
                ChunkCompileTaskGenerator chunkCompileTaskGenerator3;
                ChunkCompileTaskGenerator chunkCompileTaskGenerator4 = chunkCompileTaskGenerator3 = null;
                return chunkCompileTaskGenerator4;
            }
            if (this.compileTask != null && this.compileTask.getStatus() != ChunkCompileTaskGenerator.Status.DONE) {
                this.compileTask.finish();
                this.compileTask = null;
            }
            this.compileTask = new ChunkCompileTaskGenerator(this, ChunkCompileTaskGenerator.Type.RESORT_TRANSPARENCY);
            this.compileTask.setCompiledChunk(this.compiledChunk);
            chunkCompileTaskGenerator = chunkCompileTaskGenerator2 = this.compileTask;
        }
        finally {
            this.lockCompileTask.unlock();
        }
        return chunkCompileTaskGenerator;
    }

    private void preRenderBlocks(WorldRenderer worldRenderer, BlockPos blockPos) {
        worldRenderer.begin(7, DefaultVertexFormats.BLOCK);
        if (Config.isRenderRegions()) {
            int n = 8;
            int n2 = blockPos.getX() >> n << n;
            int n3 = blockPos.getY() >> n << n;
            int n4 = blockPos.getZ() >> n << n;
            n2 = this.regionX;
            n4 = this.regionZ;
            worldRenderer.setTranslation(-n2, -n3, -n4);
        } else {
            worldRenderer.setTranslation(-blockPos.getX(), -blockPos.getY(), -blockPos.getZ());
        }
    }

    private void postRenderBlocks(EnumWorldBlockLayer enumWorldBlockLayer, float f, float f2, float f3, WorldRenderer worldRenderer, CompiledChunk compiledChunk) {
        if (enumWorldBlockLayer == EnumWorldBlockLayer.TRANSLUCENT && !compiledChunk.isLayerEmpty(enumWorldBlockLayer)) {
            worldRenderer.sortVertexData(f, f2, f3);
            compiledChunk.setState(worldRenderer.getVertexState());
        }
        worldRenderer.finishDrawing();
    }

    private void initModelviewMatrix() {
        GlStateManager.pushMatrix();
        GlStateManager.loadIdentity();
        float f = 1.000001f;
        GlStateManager.translate(-8.0f, -8.0f, -8.0f);
        GlStateManager.scale(f, f, f);
        GlStateManager.translate(8.0f, 8.0f, 8.0f);
        GlStateManager.getFloat(2982, this.modelviewMatrix);
        GlStateManager.popMatrix();
    }

    public void multModelviewMatrix() {
        GlStateManager.multMatrix(this.modelviewMatrix);
    }

    public CompiledChunk getCompiledChunk() {
        return this.compiledChunk;
    }

    public void setCompiledChunk(CompiledChunk compiledChunk) {
        this.lockCompiledChunk.lock();
        try {
            this.compiledChunk = compiledChunk;
        }
        finally {
            this.lockCompiledChunk.unlock();
        }
    }

    public void stopCompileTask() {
        this.finishCompileTask();
        this.compiledChunk = CompiledChunk.DUMMY;
    }

    public void deleteGlResources() {
        this.stopCompileTask();
        for (int i = 0; i < EnumWorldBlockLayer.values().length; ++i) {
            if (this.vertexBuffers[i] == null) continue;
            this.vertexBuffers[i].deleteGlBuffers();
        }
    }

    public BlockPos getPosition() {
        return this.position;
    }

    public void setNeedsUpdate(boolean bl) {
        this.needsUpdate = bl;
        if (bl) {
            if (this.isWorldPlayerUpdate()) {
                this.playerUpdate = true;
            }
        } else {
            this.playerUpdate = false;
        }
    }

    public boolean isNeedsUpdate() {
        return this.needsUpdate;
    }

    public BlockPos getBlockPosOffset16(EnumFacing enumFacing) {
        return this.getPositionOffset16(enumFacing);
    }

    public BlockPos getPositionOffset16(EnumFacing enumFacing) {
        int n = enumFacing.getIndex();
        BlockPos blockPos = this.positionOffsets16[n];
        if (blockPos == null) {
            this.positionOffsets16[n] = blockPos = this.getPosition().offset(enumFacing, 16);
        }
        return blockPos;
    }

    private boolean isWorldPlayerUpdate() {
        if (this.world instanceof WorldClient) {
            WorldClient worldClient = (WorldClient)this.world;
            return worldClient.isPlayerUpdate();
        }
        return false;
    }

    public boolean isPlayerUpdate() {
        return this.playerUpdate;
    }

    protected RegionRenderCache createRegionRenderCache(World world2, BlockPos blockPos, BlockPos blockPos2, int n) {
        return new RegionRenderCache(world2, blockPos, blockPos2, n);
    }

    private EnumWorldBlockLayer fixBlockLayer(IBlockState iBlockState, EnumWorldBlockLayer enumWorldBlockLayer) {
        Object object;
        if (CustomBlockLayers.isActive() && (object = CustomBlockLayers.getRenderLayer(iBlockState)) != null) {
            return object;
        }
        if (!this.fixBlockLayer) {
            return enumWorldBlockLayer;
        }
        if (this.isMipmaps) {
            if (enumWorldBlockLayer == EnumWorldBlockLayer.CUTOUT) {
                object = iBlockState.getBlock();
                if (object instanceof BlockRedstoneWire) {
                    return enumWorldBlockLayer;
                }
                if (object instanceof BlockCactus) {
                    return enumWorldBlockLayer;
                }
                return EnumWorldBlockLayer.CUTOUT_MIPPED;
            }
        } else if (enumWorldBlockLayer == EnumWorldBlockLayer.CUTOUT_MIPPED) {
            return EnumWorldBlockLayer.CUTOUT;
        }
        return enumWorldBlockLayer;
    }

    private void postRenderOverlays(RegionRenderCacheBuilder regionRenderCacheBuilder, CompiledChunk compiledChunk, boolean[] blArray) {
        this.postRenderOverlay(EnumWorldBlockLayer.CUTOUT, regionRenderCacheBuilder, compiledChunk, blArray);
        this.postRenderOverlay(EnumWorldBlockLayer.CUTOUT_MIPPED, regionRenderCacheBuilder, compiledChunk, blArray);
        this.postRenderOverlay(EnumWorldBlockLayer.TRANSLUCENT, regionRenderCacheBuilder, compiledChunk, blArray);
    }

    private void postRenderOverlay(EnumWorldBlockLayer enumWorldBlockLayer, RegionRenderCacheBuilder regionRenderCacheBuilder, CompiledChunk compiledChunk, boolean[] blArray) {
        WorldRenderer worldRenderer = regionRenderCacheBuilder.getWorldRendererByLayer(enumWorldBlockLayer);
        if (worldRenderer.isDrawing()) {
            compiledChunk.setLayerStarted(enumWorldBlockLayer);
            blArray[enumWorldBlockLayer.ordinal()] = true;
        }
    }

    private ChunkCacheOF makeChunkCacheOF(BlockPos blockPos) {
        BlockPos blockPos2 = blockPos.add(-1, -1, -1);
        BlockPos blockPos3 = blockPos.add(16, 16, 16);
        RegionRenderCache regionRenderCache = this.createRegionRenderCache(this.world, blockPos2, blockPos3, 1);
        if (Reflector.MinecraftCompatClient_onRebuildChunk.exists()) {
            Reflector.call(Reflector.MinecraftCompatClient_onRebuildChunk, this.world, blockPos, regionRenderCache);
        }
        ChunkCacheOF chunkCacheOF = new ChunkCacheOF(regionRenderCache, blockPos2, blockPos3, 1);
        return chunkCacheOF;
    }

    public RenderChunk getRenderChunkOffset16(ViewFrustum viewFrustum, EnumFacing enumFacing) {
        if (!this.renderChunksOffset16Updated) {
            for (int i = 0; i < EnumFacing.VALUES.length; ++i) {
                EnumFacing enumFacing2 = EnumFacing.VALUES[i];
                BlockPos blockPos = this.getBlockPosOffset16(enumFacing2);
                this.renderChunksOfset16[i] = viewFrustum.getRenderChunk(blockPos);
            }
            this.renderChunksOffset16Updated = true;
        }
        return this.renderChunksOfset16[enumFacing.ordinal()];
    }

    public Chunk getChunk() {
        return this.getChunk(this.position);
    }

    private Chunk getChunk(BlockPos blockPos) {
        Chunk chunk = this.chunk;
        if (chunk != null && chunk.isLoaded()) {
            return chunk;
        }
        this.chunk = chunk = this.world.getChunkFromBlockCoords(blockPos);
        return chunk;
    }

    public boolean isChunkRegionEmpty() {
        return this.isChunkRegionEmpty(this.position);
    }

    private boolean isChunkRegionEmpty(BlockPos blockPos) {
        int n = blockPos.getY();
        int n2 = n + 15;
        return this.getChunk(blockPos).getAreLevelsEmpty(n, n2);
    }

    public void setRenderChunkNeighbour(EnumFacing enumFacing, RenderChunk renderChunk) {
        this.renderChunkNeighbours[enumFacing.ordinal()] = renderChunk;
        this.renderChunkNeighboursValid[enumFacing.ordinal()] = renderChunk;
    }

    public RenderChunk getRenderChunkNeighbour(EnumFacing enumFacing) {
        if (!this.renderChunkNeighboursUpated) {
            this.updateRenderChunkNeighboursValid();
        }
        return this.renderChunkNeighboursValid[enumFacing.ordinal()];
    }

    public RenderGlobal.ContainerLocalRenderInformation getRenderInfo() {
        return this.renderInfo;
    }

    private void updateRenderChunkNeighboursValid() {
        int n = this.getPosition().getX();
        int n2 = this.getPosition().getZ();
        int n3 = EnumFacing.NORTH.ordinal();
        int n4 = EnumFacing.SOUTH.ordinal();
        int n5 = EnumFacing.WEST.ordinal();
        int n6 = EnumFacing.EAST.ordinal();
        this.renderChunkNeighboursValid[n3] = this.renderChunkNeighbours[n3].getPosition().getZ() == n2 - 16 ? this.renderChunkNeighbours[n3] : null;
        this.renderChunkNeighboursValid[n4] = this.renderChunkNeighbours[n4].getPosition().getZ() == n2 + 16 ? this.renderChunkNeighbours[n4] : null;
        this.renderChunkNeighboursValid[n5] = this.renderChunkNeighbours[n5].getPosition().getX() == n - 16 ? this.renderChunkNeighbours[n5] : null;
        this.renderChunkNeighboursValid[n6] = this.renderChunkNeighbours[n6].getPosition().getX() == n + 16 ? this.renderChunkNeighbours[n6] : null;
        this.renderChunkNeighboursUpated = true;
    }

    public boolean isBoundingBoxInFrustum(ICamera iCamera, int n) {
        return this.getBoundingBoxParent().isBoundingBoxInFrustumFully(iCamera, n) ? true : iCamera.isBoundingBoxInFrustum(this.boundingBox);
    }

    public AabbFrame getBoundingBoxParent() {
        if (this.boundingBoxParent == null) {
            AabbFrame aabbFrame;
            BlockPos blockPos = this.getPosition();
            int n = blockPos.getX();
            int n2 = blockPos.getY();
            int n3 = blockPos.getZ();
            int n4 = 5;
            int n5 = n >> n4 << n4;
            int n6 = n2 >> n4 << n4;
            int n7 = n3 >> n4 << n4;
            if ((n5 != n || n6 != n2 || n7 != n3) && (aabbFrame = this.renderGlobal.getRenderChunk(new BlockPos(n5, n6, n7)).getBoundingBoxParent()) != null && aabbFrame.minX == (double)n5 && aabbFrame.minY == (double)n6 && aabbFrame.minZ == (double)n7) {
                this.boundingBoxParent = aabbFrame;
            }
            if (this.boundingBoxParent == null) {
                int n8 = 1 << n4;
                this.boundingBoxParent = new AabbFrame(n5, n6, n7, n5 + n8, n6 + n8, n7 + n8);
            }
        }
        return this.boundingBoxParent;
    }

    public String toString() {
        return "pos: " + String.valueOf(this.getPosition()) + ", frameIndex: " + this.frameIndex;
    }

    static {
        ENUM_WORLD_BLOCK_LAYERS = EnumWorldBlockLayer.values();
    }
}

