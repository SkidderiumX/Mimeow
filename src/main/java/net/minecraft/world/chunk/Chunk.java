/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.chunk;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraft.world.gen.ChunkProviderDebug;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chunk {
    private static final Logger logger = LogManager.getLogger();
    private final ExtendedBlockStorage[] storageArrays = new ExtendedBlockStorage[16];
    private final byte[] blockBiomeArray = new byte[256];
    private final int[] precipitationHeightMap = new int[256];
    private final boolean[] updateSkylightColumns = new boolean[256];
    private boolean isChunkLoaded;
    private final World worldObj;
    private final int[] heightMap;
    public final int xPosition;
    public final int zPosition;
    private boolean isGapLightingUpdated;
    private final Map<BlockPos, TileEntity> chunkTileEntityMap = Maps.newHashMap();
    private final ClassInheritanceMultiMap<Entity>[] entityLists;
    private boolean isTerrainPopulated;
    private boolean isLightPopulated;
    private boolean field_150815_m;
    private boolean isModified;
    private boolean hasEntities;
    private long lastSaveTime;
    private int heightMapMinimum;
    private long inhabitedTime;
    private int queuedLightChecks = 4096;
    private ConcurrentLinkedQueue<BlockPos> tileEntityPosQueue = Queues.newConcurrentLinkedQueue();

    public Chunk(World world2, int n, int n2) {
        this.entityLists = new ClassInheritanceMultiMap[16];
        this.worldObj = world2;
        this.xPosition = n;
        this.zPosition = n2;
        this.heightMap = new int[256];
        for (int i = 0; i < this.entityLists.length; ++i) {
            this.entityLists[i] = new ClassInheritanceMultiMap<Entity>(Entity.class);
        }
        Arrays.fill(this.precipitationHeightMap, -999);
        Arrays.fill(this.blockBiomeArray, (byte)-1);
    }

    public Chunk(World world2, ChunkPrimer chunkPrimer, int n, int n2) {
        this(world2, n, n2);
        int n3 = 256;
        boolean bl = !world2.provider.getHasNoSky();
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < n3; ++k) {
                    int n4 = i * n3 * 16 | j * n3 | k;
                    IBlockState iBlockState = chunkPrimer.getBlockState(n4);
                    if (iBlockState.getBlock().getMaterial() == Material.air) continue;
                    int n5 = k >> 4;
                    if (this.storageArrays[n5] == null) {
                        this.storageArrays[n5] = new ExtendedBlockStorage(n5 << 4, bl);
                    }
                    this.storageArrays[n5].set(i, k & 0xF, j, iBlockState);
                }
            }
        }
    }

    public boolean isAtLocation(int n, int n2) {
        return n == this.xPosition && n2 == this.zPosition;
    }

    public int getHeight(BlockPos blockPos) {
        return this.getHeightValue(blockPos.getX() & 0xF, blockPos.getZ() & 0xF);
    }

    public int getHeightValue(int n, int n2) {
        return this.heightMap[n2 << 4 | n];
    }

    public int getTopFilledSegment() {
        for (int i = this.storageArrays.length - 1; i >= 0; --i) {
            if (this.storageArrays[i] == null) continue;
            return this.storageArrays[i].getYLocation();
        }
        return 0;
    }

    public ExtendedBlockStorage[] getBlockStorageArray() {
        return this.storageArrays;
    }

    protected void generateHeightMap() {
        int n = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int i = 0; i < 16; ++i) {
            block1: for (int j = 0; j < 16; ++j) {
                this.precipitationHeightMap[i + (j << 4)] = -999;
                for (int k = n + 16; k > 0; --k) {
                    Block block = this.getBlock0(i, k - 1, j);
                    if (block.getLightOpacity() == 0) continue;
                    this.heightMap[j << 4 | i] = k;
                    if (k >= this.heightMapMinimum) continue block1;
                    this.heightMapMinimum = k;
                    continue block1;
                }
            }
        }
        this.isModified = true;
    }

    public void generateSkylightMap() {
        int n = this.getTopFilledSegment();
        this.heightMapMinimum = Integer.MAX_VALUE;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n2;
                this.precipitationHeightMap[i + (j << 4)] = -999;
                for (n2 = n + 16; n2 > 0; --n2) {
                    if (this.getBlockLightOpacity(i, n2 - 1, j) == 0) continue;
                    this.heightMap[j << 4 | i] = n2;
                    if (n2 >= this.heightMapMinimum) break;
                    this.heightMapMinimum = n2;
                    break;
                }
                if (this.worldObj.provider.getHasNoSky()) continue;
                n2 = 15;
                int n3 = n + 16 - 1;
                do {
                    ExtendedBlockStorage extendedBlockStorage;
                    int n4;
                    if ((n4 = this.getBlockLightOpacity(i, n3, j)) == 0 && n2 != 15) {
                        n4 = 1;
                    }
                    if ((n2 -= n4) <= 0 || (extendedBlockStorage = this.storageArrays[n3 >> 4]) == null) continue;
                    extendedBlockStorage.setExtSkylightValue(i, n3 & 0xF, j, n2);
                    this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + i, n3, (this.zPosition << 4) + j));
                } while (--n3 > 0 && n2 > 0);
            }
        }
        this.isModified = true;
    }

    private void propagateSkylightOcclusion(int n, int n2) {
        this.updateSkylightColumns[n + n2 * 16] = true;
        this.isGapLightingUpdated = true;
    }

    private void recheckGaps(boolean bl) {
        this.worldObj.theProfiler.startSection("recheckGaps");
        if (this.worldObj.isAreaLoaded(new BlockPos(this.xPosition * 16 + 8, 0, this.zPosition * 16 + 8), 16)) {
            for (int i = 0; i < 16; ++i) {
                for (int j = 0; j < 16; ++j) {
                    if (!this.updateSkylightColumns[i + j * 16]) continue;
                    this.updateSkylightColumns[i + j * 16] = false;
                    int n = this.getHeightValue(i, j);
                    int n2 = this.xPosition * 16 + i;
                    int n3 = this.zPosition * 16 + j;
                    int n4 = Integer.MAX_VALUE;
                    for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                        n4 = Math.min(n4, this.worldObj.getChunksLowestHorizon(n2 + enumFacing.getFrontOffsetX(), n3 + enumFacing.getFrontOffsetZ()));
                    }
                    this.checkSkylightNeighborHeight(n2, n3, n4);
                    for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                        this.checkSkylightNeighborHeight(n2 + enumFacing.getFrontOffsetX(), n3 + enumFacing.getFrontOffsetZ(), n);
                    }
                    if (!bl) continue;
                    this.worldObj.theProfiler.endSection();
                    return;
                }
            }
            this.isGapLightingUpdated = false;
        }
        this.worldObj.theProfiler.endSection();
    }

    private void checkSkylightNeighborHeight(int n, int n2, int n3) {
        int n4 = this.worldObj.getHeight(new BlockPos(n, 0, n2)).getY();
        if (n4 > n3) {
            this.updateSkylightNeighborHeight(n, n2, n3, n4 + 1);
        } else if (n4 < n3) {
            this.updateSkylightNeighborHeight(n, n2, n4, n3 + 1);
        }
    }

    private void updateSkylightNeighborHeight(int n, int n2, int n3, int n4) {
        if (n4 > n3 && this.worldObj.isAreaLoaded(new BlockPos(n, 0, n2), 16)) {
            for (int i = n3; i < n4; ++i) {
                this.worldObj.checkLightFor(EnumSkyBlock.SKY, new BlockPos(n, i, n2));
            }
            this.isModified = true;
        }
    }

    private void relightBlock(int n, int n2, int n3) {
        int n4;
        int n5 = n4 = this.heightMap[n3 << 4 | n] & 0xFF;
        if (n2 > n4) {
            n5 = n2;
        }
        while (n5 > 0 && this.getBlockLightOpacity(n, n5 - 1, n3) == 0) {
            --n5;
        }
        if (n5 != n4) {
            int n6;
            this.worldObj.markBlocksDirtyVertical(n + this.xPosition * 16, n3 + this.zPosition * 16, n5, n4);
            this.heightMap[n3 << 4 | n] = n5;
            int n7 = this.xPosition * 16 + n;
            int n8 = this.zPosition * 16 + n3;
            if (!this.worldObj.provider.getHasNoSky()) {
                if (n5 < n4) {
                    for (n6 = n5; n6 < n4; ++n6) {
                        var9_9 = this.storageArrays[n6 >> 4];
                        if (var9_9 == null) continue;
                        var9_9.setExtSkylightValue(n, n6 & 0xF, n3, 15);
                        this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + n, n6, (this.zPosition << 4) + n3));
                    }
                } else {
                    for (n6 = n4; n6 < n5; ++n6) {
                        var9_9 = this.storageArrays[n6 >> 4];
                        if (var9_9 == null) continue;
                        var9_9.setExtSkylightValue(n, n6 & 0xF, n3, 0);
                        this.worldObj.notifyLightSet(new BlockPos((this.xPosition << 4) + n, n6, (this.zPosition << 4) + n3));
                    }
                }
                n6 = 15;
                while (n5 > 0 && n6 > 0) {
                    ExtendedBlockStorage extendedBlockStorage;
                    int n9;
                    if ((n9 = this.getBlockLightOpacity(n, --n5, n3)) == 0) {
                        n9 = 1;
                    }
                    if ((n6 -= n9) < 0) {
                        n6 = 0;
                    }
                    if ((extendedBlockStorage = this.storageArrays[n5 >> 4]) == null) continue;
                    extendedBlockStorage.setExtSkylightValue(n, n5 & 0xF, n3, n6);
                }
            }
            n6 = this.heightMap[n3 << 4 | n];
            int n10 = n4;
            int n11 = n6;
            if (n6 < n4) {
                n10 = n6;
                n11 = n4;
            }
            if (n6 < this.heightMapMinimum) {
                this.heightMapMinimum = n6;
            }
            if (!this.worldObj.provider.getHasNoSky()) {
                for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                    this.updateSkylightNeighborHeight(n7 + enumFacing.getFrontOffsetX(), n8 + enumFacing.getFrontOffsetZ(), n10, n11);
                }
                this.updateSkylightNeighborHeight(n7, n8, n10, n11);
            }
            this.isModified = true;
        }
    }

    public int getBlockLightOpacity(BlockPos blockPos) {
        return this.getBlock(blockPos).getLightOpacity();
    }

    private int getBlockLightOpacity(int n, int n2, int n3) {
        return this.getBlock0(n, n2, n3).getLightOpacity();
    }

    private Block getBlock0(int n, int n2, int n3) {
        ExtendedBlockStorage extendedBlockStorage;
        Block block = Blocks.air;
        if (n2 >= 0 && n2 >> 4 < this.storageArrays.length && (extendedBlockStorage = this.storageArrays[n2 >> 4]) != null) {
            try {
                block = extendedBlockStorage.getBlockByExtId(n, n2 & 0xF, n3);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Getting block");
                throw new ReportedException(crashReport);
            }
        }
        return block;
    }

    public Block getBlock(final int n, final int n2, final int n3) {
        try {
            return this.getBlock0(n & 0xF, n2, n3 & 0xF);
        }
        catch (ReportedException reportedException) {
            CrashReportCategory crashReportCategory = reportedException.getCrashReport().makeCategory("Block being got");
            crashReportCategory.addCrashSectionCallable("Location", new Callable<String>(){

                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(new BlockPos(Chunk.this.xPosition * 16 + n, n2, Chunk.this.zPosition * 16 + n3));
                }
            });
            throw reportedException;
        }
    }

    public Block getBlock(final BlockPos blockPos) {
        try {
            return this.getBlock0(blockPos.getX() & 0xF, blockPos.getY(), blockPos.getZ() & 0xF);
        }
        catch (ReportedException reportedException) {
            CrashReportCategory crashReportCategory = reportedException.getCrashReport().makeCategory("Block being got");
            crashReportCategory.addCrashSectionCallable("Location", new Callable<String>(){

                @Override
                public String call() throws Exception {
                    return CrashReportCategory.getCoordinateInfo(blockPos);
                }
            });
            throw reportedException;
        }
    }

    public IBlockState getBlockState(BlockPos blockPos) {
        ExtendedBlockStorage extendedBlockStorage;
        if (this.worldObj.getWorldType() == WorldType.DEBUG_WORLD) {
            IBlockState iBlockState = null;
            if (blockPos.getY() == 60) {
                iBlockState = Blocks.barrier.getDefaultState();
            }
            if (blockPos.getY() == 70) {
                iBlockState = ChunkProviderDebug.func_177461_b(blockPos.getX(), blockPos.getZ());
            }
            return iBlockState == null ? Blocks.air.getDefaultState() : iBlockState;
        }
        int n = blockPos.getY();
        if (n >= 0 && n >> 4 < this.storageArrays.length && (extendedBlockStorage = this.storageArrays[n >> 4]) != null) {
            return extendedBlockStorage.get(blockPos.getX() & 0xF, n & 0xF, blockPos.getZ() & 0xF);
        }
        return Blocks.air.getDefaultState();
    }

    private int getBlockMetadata(int n, int n2, int n3) {
        if (n2 >> 4 >= this.storageArrays.length) {
            return 0;
        }
        ExtendedBlockStorage extendedBlockStorage = this.storageArrays[n2 >> 4];
        return extendedBlockStorage != null ? extendedBlockStorage.getExtBlockMetadata(n, n2 & 0xF, n3) : 0;
    }

    public int getBlockMetadata(BlockPos blockPos) {
        return this.getBlockMetadata(blockPos.getX() & 0xF, blockPos.getY(), blockPos.getZ() & 0xF);
    }

    public IBlockState setBlockState(BlockPos blockPos, IBlockState iBlockState) {
        TileEntity tileEntity;
        int n;
        int n2;
        int n3 = blockPos.getX() & 0xF;
        int n4 = blockPos.getY();
        if (n4 >= this.precipitationHeightMap[n2 = (n = blockPos.getZ() & 0xF) << 4 | n3] - 1) {
            this.precipitationHeightMap[n2] = -999;
        }
        int n5 = this.heightMap[n2];
        IBlockState iBlockState2 = this.getBlockState(blockPos);
        if (iBlockState2 == iBlockState) {
            return null;
        }
        Block block = iBlockState.getBlock();
        Block block2 = iBlockState2.getBlock();
        ExtendedBlockStorage extendedBlockStorage = this.storageArrays[n4 >> 4];
        boolean bl = false;
        if (extendedBlockStorage == null) {
            if (block == Blocks.air) {
                return null;
            }
            ExtendedBlockStorage extendedBlockStorage2 = new ExtendedBlockStorage(n4 >> 4 << 4, !this.worldObj.provider.getHasNoSky());
            this.storageArrays[n4 >> 4] = extendedBlockStorage2;
            extendedBlockStorage = extendedBlockStorage2;
            bl = n4 >= n5;
        }
        extendedBlockStorage.set(n3, n4 & 0xF, n, iBlockState);
        if (block2 != block) {
            if (!this.worldObj.isRemote) {
                block2.breakBlock(this.worldObj, blockPos, iBlockState2);
            } else if (block2 instanceof ITileEntityProvider) {
                this.worldObj.removeTileEntity(blockPos);
            }
        }
        if (extendedBlockStorage.getBlockByExtId(n3, n4 & 0xF, n) != block) {
            return null;
        }
        if (bl) {
            this.generateSkylightMap();
        } else {
            int n6 = block.getLightOpacity();
            int n7 = block2.getLightOpacity();
            if (n6 > 0) {
                if (n4 >= n5) {
                    this.relightBlock(n3, n4 + 1, n);
                }
            } else if (n4 == n5 - 1) {
                this.relightBlock(n3, n4, n);
            }
            if (n6 != n7 && (n6 < n7 || this.getLightFor(EnumSkyBlock.SKY, blockPos) > 0 || this.getLightFor(EnumSkyBlock.BLOCK, blockPos) > 0)) {
                this.propagateSkylightOcclusion(n3, n);
            }
        }
        if (block2 instanceof ITileEntityProvider && (tileEntity = this.getTileEntity(blockPos, EnumCreateEntityType.CHECK)) != null) {
            tileEntity.updateContainingBlockInfo();
        }
        if (!this.worldObj.isRemote && block2 != block) {
            block.onBlockAdded(this.worldObj, blockPos, iBlockState);
        }
        if (block instanceof ITileEntityProvider) {
            TileEntity tileEntity2 = this.getTileEntity(blockPos, EnumCreateEntityType.CHECK);
            if (tileEntity2 == null) {
                tileEntity2 = ((ITileEntityProvider)((Object)block)).createNewTileEntity(this.worldObj, block.getMetaFromState(iBlockState));
                this.worldObj.setTileEntity(blockPos, tileEntity2);
            }
            if (tileEntity2 != null) {
                tileEntity2.updateContainingBlockInfo();
            }
        }
        this.isModified = true;
        return iBlockState2;
    }

    public int getLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos) {
        int n = blockPos.getX() & 0xF;
        int n2 = blockPos.getY();
        int n3 = blockPos.getZ() & 0xF;
        ExtendedBlockStorage extendedBlockStorage = this.storageArrays[n2 >> 4];
        return extendedBlockStorage == null ? (this.canSeeSky(blockPos) ? enumSkyBlock.defaultLightValue : 0) : (enumSkyBlock == EnumSkyBlock.SKY ? (this.worldObj.provider.getHasNoSky() ? 0 : extendedBlockStorage.getExtSkylightValue(n, n2 & 0xF, n3)) : (enumSkyBlock == EnumSkyBlock.BLOCK ? extendedBlockStorage.getExtBlocklightValue(n, n2 & 0xF, n3) : enumSkyBlock.defaultLightValue));
    }

    public void setLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos, int n) {
        int n2 = blockPos.getX() & 0xF;
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ() & 0xF;
        ExtendedBlockStorage extendedBlockStorage = this.storageArrays[n3 >> 4];
        if (extendedBlockStorage == null) {
            ExtendedBlockStorage extendedBlockStorage2 = new ExtendedBlockStorage(n3 >> 4 << 4, !this.worldObj.provider.getHasNoSky());
            this.storageArrays[n3 >> 4] = extendedBlockStorage2;
            extendedBlockStorage = extendedBlockStorage2;
            this.generateSkylightMap();
        }
        this.isModified = true;
        if (enumSkyBlock == EnumSkyBlock.SKY) {
            if (!this.worldObj.provider.getHasNoSky()) {
                extendedBlockStorage.setExtSkylightValue(n2, n3 & 0xF, n4, n);
            }
        } else if (enumSkyBlock == EnumSkyBlock.BLOCK) {
            extendedBlockStorage.setExtBlocklightValue(n2, n3 & 0xF, n4, n);
        }
    }

    public int getLightSubtracted(BlockPos blockPos, int n) {
        int n2 = blockPos.getX() & 0xF;
        int n3 = blockPos.getY();
        int n4 = blockPos.getZ() & 0xF;
        ExtendedBlockStorage extendedBlockStorage = this.storageArrays[n3 >> 4];
        if (extendedBlockStorage == null) {
            return !this.worldObj.provider.getHasNoSky() && n < EnumSkyBlock.SKY.defaultLightValue ? EnumSkyBlock.SKY.defaultLightValue - n : 0;
        }
        int n5 = this.worldObj.provider.getHasNoSky() ? 0 : extendedBlockStorage.getExtSkylightValue(n2, n3 & 0xF, n4);
        int n6 = extendedBlockStorage.getExtBlocklightValue(n2, n3 & 0xF, n4);
        if (n6 > (n5 -= n)) {
            n5 = n6;
        }
        return n5;
    }

    public void addEntity(Entity entity) {
        int n;
        this.hasEntities = true;
        int n2 = MathHelper.floor_double(entity.posX / 16.0);
        int n3 = MathHelper.floor_double(entity.posZ / 16.0);
        if (n2 != this.xPosition || n3 != this.zPosition) {
            logger.warn("Wrong location! (" + n2 + ", " + n3 + ") should be (" + this.xPosition + ", " + this.zPosition + "), " + String.valueOf(entity), entity);
            entity.setDead();
        }
        if ((n = MathHelper.floor_double(entity.posY / 16.0)) < 0) {
            n = 0;
        }
        if (n >= this.entityLists.length) {
            n = this.entityLists.length - 1;
        }
        entity.addedToChunk = true;
        entity.chunkCoordX = this.xPosition;
        entity.chunkCoordY = n;
        entity.chunkCoordZ = this.zPosition;
        this.entityLists[n].add(entity);
    }

    public void removeEntity(Entity entity) {
        this.removeEntityAtIndex(entity, entity.chunkCoordY);
    }

    public void removeEntityAtIndex(Entity entity, int n) {
        if (n < 0) {
            n = 0;
        }
        if (n >= this.entityLists.length) {
            n = this.entityLists.length - 1;
        }
        this.entityLists[n].remove(entity);
    }

    public boolean canSeeSky(BlockPos blockPos) {
        int n;
        int n2 = blockPos.getX() & 0xF;
        int n3 = blockPos.getY();
        return n3 >= this.heightMap[(n = blockPos.getZ() & 0xF) << 4 | n2];
    }

    private TileEntity createNewTileEntity(BlockPos blockPos) {
        Block block = this.getBlock(blockPos);
        return !block.hasTileEntity() ? null : ((ITileEntityProvider)((Object)block)).createNewTileEntity(this.worldObj, this.getBlockMetadata(blockPos));
    }

    public TileEntity getTileEntity(BlockPos blockPos, EnumCreateEntityType enumCreateEntityType) {
        TileEntity tileEntity = this.chunkTileEntityMap.get(blockPos);
        if (tileEntity == null) {
            if (enumCreateEntityType == EnumCreateEntityType.IMMEDIATE) {
                tileEntity = this.createNewTileEntity(blockPos);
                this.worldObj.setTileEntity(blockPos, tileEntity);
            } else if (enumCreateEntityType == EnumCreateEntityType.QUEUED) {
                this.tileEntityPosQueue.add(blockPos);
            }
        } else if (tileEntity.isInvalid()) {
            this.chunkTileEntityMap.remove(blockPos);
            return null;
        }
        return tileEntity;
    }

    public void addTileEntity(TileEntity tileEntity) {
        this.addTileEntity(tileEntity.getPos(), tileEntity);
        if (this.isChunkLoaded) {
            this.worldObj.addTileEntity(tileEntity);
        }
    }

    public void addTileEntity(BlockPos blockPos, TileEntity tileEntity) {
        tileEntity.setWorldObj(this.worldObj);
        tileEntity.setPos(blockPos);
        if (this.getBlock(blockPos) instanceof ITileEntityProvider) {
            if (this.chunkTileEntityMap.containsKey(blockPos)) {
                this.chunkTileEntityMap.get(blockPos).invalidate();
            }
            tileEntity.validate();
            this.chunkTileEntityMap.put(blockPos, tileEntity);
        }
    }

    public void removeTileEntity(BlockPos blockPos) {
        TileEntity tileEntity;
        if (this.isChunkLoaded && (tileEntity = this.chunkTileEntityMap.remove(blockPos)) != null) {
            tileEntity.invalidate();
        }
    }

    public void onChunkLoad() {
        this.isChunkLoaded = true;
        this.worldObj.addTileEntities(this.chunkTileEntityMap.values());
        for (int i = 0; i < this.entityLists.length; ++i) {
            for (Entity entity : this.entityLists[i]) {
                entity.onChunkLoad();
            }
            this.worldObj.loadEntities(this.entityLists[i]);
        }
    }

    public void onChunkUnload() {
        this.isChunkLoaded = false;
        for (TileEntity tileEntity : this.chunkTileEntityMap.values()) {
            this.worldObj.markTileEntityForRemoval(tileEntity);
        }
        for (int i = 0; i < this.entityLists.length; ++i) {
            this.worldObj.unloadEntities(this.entityLists[i]);
        }
    }

    public void setChunkModified() {
        this.isModified = true;
    }

    public void addEntityCollisionBoxes(Entity entity, AxisAlignedBB axisAlignedBB, AxisAlignedBB axisAlignedBB2, List<AxisAlignedBB> list) {
        int n = MathHelper.clamp_int(MathHelper.floor_double((axisAlignedBB.minY - 2.0) / 16.0), 0, this.entityLists.length - 1);
        int n2 = MathHelper.clamp_int(MathHelper.floor_double((axisAlignedBB.maxY + 2.0) / 16.0), 0, this.entityLists.length - 1);
        for (int i = n; i <= n2; ++i) {
            for (Entity entity2 : this.entityLists[i]) {
                if (entity2 == entity || !entity2.getEntityBoundingBox().intersectsWith(axisAlignedBB)) continue;
                Chunk.addEntityCollisionBox(entity, entity2, axisAlignedBB2, list);
                Entity[] entityArray = entity2.getParts();
                if (entityArray == null) continue;
                for (Entity entity3 : entityArray) {
                    if (entity3 == entity || !entity3.getEntityBoundingBox().intersectsWith(axisAlignedBB)) continue;
                    Chunk.addEntityCollisionBox(entity, entity3, axisAlignedBB2, list);
                }
            }
        }
    }

    private static void addEntityCollisionBox(Entity entity, Entity entity2, AxisAlignedBB axisAlignedBB, List<AxisAlignedBB> list) {
        if (!EntitySelectors.NOT_SPECTATING.apply(entity2) || entity.ridingEntity == entity2 || entity.riddenByEntity == entity2) {
            return;
        }
        AxisAlignedBB axisAlignedBB2 = entity2.getCollisionBoundingBox();
        if (axisAlignedBB2 != null && axisAlignedBB2.intersectsWith(axisAlignedBB)) {
            list.add(axisAlignedBB2);
        }
        if ((axisAlignedBB2 = entity.getCollisionBox(entity2)) != null && axisAlignedBB2.intersectsWith(axisAlignedBB)) {
            list.add(axisAlignedBB2);
        }
    }

    public void getEntitiesWithinAABBForEntity(Entity entity, AxisAlignedBB axisAlignedBB, List<Entity> list, Predicate<? super Entity> predicate) {
        int n = MathHelper.floor_double((axisAlignedBB.minY - 2.0) / 16.0);
        int n2 = MathHelper.floor_double((axisAlignedBB.maxY + 2.0) / 16.0);
        n = MathHelper.clamp_int(n, 0, this.entityLists.length - 1);
        n2 = MathHelper.clamp_int(n2, 0, this.entityLists.length - 1);
        for (int i = n; i <= n2; ++i) {
            if (this.entityLists[i].isEmpty()) continue;
            for (Entity entity2 : this.entityLists[i]) {
                Entity[] entityArray;
                if (!entity2.getEntityBoundingBox().intersectsWith(axisAlignedBB) || entity2 == entity) continue;
                if (predicate == null || predicate.apply(entity2)) {
                    list.add(entity2);
                }
                if ((entityArray = entity2.getParts()) == null) continue;
                for (int j = 0; j < entityArray.length; ++j) {
                    entity2 = entityArray[j];
                    if (entity2 == entity || !entity2.getEntityBoundingBox().intersectsWith(axisAlignedBB) || predicate != null && !predicate.apply(entity2)) continue;
                    list.add(entity2);
                }
            }
        }
    }

    public <T extends Entity> void getEntitiesOfTypeWithinAAAB(Class<? extends T> clazz, AxisAlignedBB axisAlignedBB, List<T> list, Predicate<? super T> predicate) {
        int n = MathHelper.floor_double((axisAlignedBB.minY - 2.0) / 16.0);
        int n2 = MathHelper.floor_double((axisAlignedBB.maxY + 2.0) / 16.0);
        n = MathHelper.clamp_int(n, 0, this.entityLists.length - 1);
        n2 = MathHelper.clamp_int(n2, 0, this.entityLists.length - 1);
        for (int i = n; i <= n2; ++i) {
            for (Entity entity : this.entityLists[i].getByClass(clazz)) {
                if (!entity.getEntityBoundingBox().intersectsWith(axisAlignedBB) || predicate != null && !predicate.apply(entity)) continue;
                list.add(entity);
            }
        }
    }

    public boolean needsSaving(boolean bl) {
        if (bl ? this.hasEntities && this.worldObj.getTotalWorldTime() != this.lastSaveTime || this.isModified : this.hasEntities && this.worldObj.getTotalWorldTime() >= this.lastSaveTime + 600L) {
            return true;
        }
        return this.isModified;
    }

    public Random getRandomWithSeed(long l) {
        return new Random(this.worldObj.getSeed() + (long)(this.xPosition * this.xPosition * 4987142) + (long)(this.xPosition * 5947611) + (long)(this.zPosition * this.zPosition) * 4392871L + (long)(this.zPosition * 389711) ^ l);
    }

    public boolean isEmpty() {
        return false;
    }

    public void populateChunk(IChunkProvider iChunkProvider, IChunkProvider iChunkProvider2, int n, int n2) {
        Chunk chunk;
        boolean bl = iChunkProvider.chunkExists(n, n2 - 1);
        boolean bl2 = iChunkProvider.chunkExists(n + 1, n2);
        boolean bl3 = iChunkProvider.chunkExists(n, n2 + 1);
        boolean bl4 = iChunkProvider.chunkExists(n - 1, n2);
        boolean bl5 = iChunkProvider.chunkExists(n - 1, n2 - 1);
        boolean bl6 = iChunkProvider.chunkExists(n + 1, n2 + 1);
        boolean bl7 = iChunkProvider.chunkExists(n - 1, n2 + 1);
        boolean bl8 = iChunkProvider.chunkExists(n + 1, n2 - 1);
        if (bl2 && bl3 && bl6) {
            if (!this.isTerrainPopulated) {
                iChunkProvider.populate(iChunkProvider2, n, n2);
            } else {
                iChunkProvider.populateChunk(iChunkProvider2, this, n, n2);
            }
        }
        if (bl4 && bl3 && bl7) {
            chunk = iChunkProvider.provideChunk(n - 1, n2);
            if (!chunk.isTerrainPopulated) {
                iChunkProvider.populate(iChunkProvider2, n - 1, n2);
            } else {
                iChunkProvider.populateChunk(iChunkProvider2, chunk, n - 1, n2);
            }
        }
        if (bl && bl2 && bl8) {
            chunk = iChunkProvider.provideChunk(n, n2 - 1);
            if (!chunk.isTerrainPopulated) {
                iChunkProvider.populate(iChunkProvider2, n, n2 - 1);
            } else {
                iChunkProvider.populateChunk(iChunkProvider2, chunk, n, n2 - 1);
            }
        }
        if (bl5 && bl && bl4) {
            chunk = iChunkProvider.provideChunk(n - 1, n2 - 1);
            if (!chunk.isTerrainPopulated) {
                iChunkProvider.populate(iChunkProvider2, n - 1, n2 - 1);
            } else {
                iChunkProvider.populateChunk(iChunkProvider2, chunk, n - 1, n2 - 1);
            }
        }
    }

    public BlockPos getPrecipitationHeight(BlockPos blockPos) {
        int n = blockPos.getX() & 0xF;
        int n2 = blockPos.getZ() & 0xF;
        int n3 = n | n2 << 4;
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), this.precipitationHeightMap[n3], blockPos.getZ());
        if (blockPos2.getY() == -999) {
            int n4 = this.getTopFilledSegment() + 15;
            blockPos2 = new BlockPos(blockPos.getX(), n4, blockPos.getZ());
            int n5 = -1;
            while (blockPos2.getY() > 0 && n5 == -1) {
                Block block = this.getBlock(blockPos2);
                Material material = block.getMaterial();
                if (!material.blocksMovement() && !material.isLiquid()) {
                    blockPos2 = blockPos2.down();
                    continue;
                }
                n5 = blockPos2.getY() + 1;
            }
            this.precipitationHeightMap[n3] = n5;
        }
        return new BlockPos(blockPos.getX(), this.precipitationHeightMap[n3], blockPos.getZ());
    }

    public void func_150804_b(boolean bl) {
        if (this.isGapLightingUpdated && !this.worldObj.provider.getHasNoSky() && !bl) {
            this.recheckGaps(this.worldObj.isRemote);
        }
        this.field_150815_m = true;
        if (!this.isLightPopulated && this.isTerrainPopulated) {
            this.func_150809_p();
        }
        while (!this.tileEntityPosQueue.isEmpty()) {
            BlockPos blockPos = this.tileEntityPosQueue.poll();
            if (this.getTileEntity(blockPos, EnumCreateEntityType.CHECK) != null || !this.getBlock(blockPos).hasTileEntity()) continue;
            TileEntity tileEntity = this.createNewTileEntity(blockPos);
            this.worldObj.setTileEntity(blockPos, tileEntity);
            this.worldObj.markBlockRangeForRenderUpdate(blockPos, blockPos);
        }
    }

    public boolean isPopulated() {
        return this.field_150815_m && this.isTerrainPopulated && this.isLightPopulated;
    }

    public ChunkCoordIntPair getChunkCoordIntPair() {
        return new ChunkCoordIntPair(this.xPosition, this.zPosition);
    }

    public boolean getAreLevelsEmpty(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 >= 256) {
            n2 = 255;
        }
        for (int i = n; i <= n2; i += 16) {
            ExtendedBlockStorage extendedBlockStorage = this.storageArrays[i >> 4];
            if (extendedBlockStorage == null || extendedBlockStorage.isEmpty()) continue;
            return false;
        }
        return true;
    }

    public void setStorageArrays(ExtendedBlockStorage[] extendedBlockStorageArray) {
        if (this.storageArrays.length != extendedBlockStorageArray.length) {
            logger.warn("Could not set level chunk sections, array length is " + extendedBlockStorageArray.length + " instead of " + this.storageArrays.length);
        } else {
            for (int i = 0; i < this.storageArrays.length; ++i) {
                this.storageArrays[i] = extendedBlockStorageArray[i];
            }
        }
    }

    public void fillChunk(byte[] byArray, int n, boolean bl) {
        int n2;
        int n3;
        if (byArray == null) {
            return;
        }
        int n4 = 0;
        boolean bl2 = !this.worldObj.provider.getHasNoSky();
        boolean bl3 = byArray.length == 256;
        for (n3 = 0; n3 < this.storageArrays.length; ++n3) {
            if (!bl3 && (n & 1 << n3) != 0 && n4 + 8192 <= byArray.length) {
                if (this.storageArrays[n3] == null) {
                    this.storageArrays[n3] = new ExtendedBlockStorage(n3 << 4, bl2);
                }
                char[] object2 = this.storageArrays[n3].getData();
                for (n2 = 0; n2 < object2.length; ++n2) {
                    object2[n2] = (char)((byArray[n4 + 1] & 0xFF) << 8 | byArray[n4] & 0xFF);
                    n4 += 2;
                }
                continue;
            }
            if (!bl || this.storageArrays[n3] == null) continue;
            this.storageArrays[n3] = null;
        }
        if (!bl3) {
            for (n3 = 0; n3 < this.storageArrays.length; ++n3) {
                NibbleArray nibbleArray;
                if ((n & 1 << n3) == 0 || this.storageArrays[n3] == null || n4 + (n2 = (nibbleArray = this.storageArrays[n3].getBlocklightArray()).getReadOnlyData().length) > byArray.length) continue;
                System.arraycopy(byArray, n4, nibbleArray.getData(), 0, n2);
                nibbleArray.compact();
                n4 += n2;
            }
            if (bl2) {
                for (n3 = 0; n3 < this.storageArrays.length; ++n3) {
                    NibbleArray nibbleArray;
                    if ((n & 1 << n3) == 0 || this.storageArrays[n3] == null || n4 + (n2 = (nibbleArray = this.storageArrays[n3].getSkylightArray()).getReadOnlyData().length) > byArray.length) continue;
                    System.arraycopy(byArray, n4, nibbleArray.getData(), 0, n2);
                    nibbleArray.compact();
                    n4 += n2;
                }
            }
        }
        if (bl) {
            if (bl3) {
                System.arraycopy(byArray, 0, this.blockBiomeArray, 0, this.blockBiomeArray.length);
            } else if (n4 + this.blockBiomeArray.length <= byArray.length) {
                System.arraycopy(byArray, n4, this.blockBiomeArray, 0, this.blockBiomeArray.length);
            } else if (byArray.length >= this.blockBiomeArray.length) {
                System.arraycopy(byArray, byArray.length - this.blockBiomeArray.length, this.blockBiomeArray, 0, this.blockBiomeArray.length);
            }
        }
        for (n3 = 0; n3 < this.storageArrays.length; ++n3) {
            if (this.storageArrays[n3] == null || (n & 1 << n3) == 0) continue;
            this.storageArrays[n3].removeInvalidBlocks();
        }
        this.isLightPopulated = true;
        this.isTerrainPopulated = true;
        this.generateHeightMap();
        for (TileEntity tileEntity : this.chunkTileEntityMap.values()) {
            tileEntity.updateContainingBlockInfo();
        }
    }

    public BiomeGenBase getBiome(BlockPos blockPos, WorldChunkManager worldChunkManager) {
        BiomeGenBase biomeGenBase;
        int n = blockPos.getX() & 0xF;
        int n2 = blockPos.getZ() & 0xF;
        int n3 = this.blockBiomeArray[n2 << 4 | n] & 0xFF;
        if (n3 == 255) {
            biomeGenBase = worldChunkManager.getBiomeGenerator(blockPos, BiomeGenBase.plains);
            n3 = biomeGenBase.biomeID;
            this.blockBiomeArray[n2 << 4 | n] = (byte)(n3 & 0xFF);
        }
        return (biomeGenBase = BiomeGenBase.getBiome(n3)) == null ? BiomeGenBase.plains : biomeGenBase;
    }

    public byte[] getBiomeArray() {
        return this.blockBiomeArray;
    }

    public void setBiomeArray(byte[] byArray) {
        if (this.blockBiomeArray.length != byArray.length) {
            logger.warn("Could not set level chunk biomes, array length is " + byArray.length + " instead of " + this.blockBiomeArray.length);
        } else {
            for (int i = 0; i < this.blockBiomeArray.length; ++i) {
                this.blockBiomeArray[i] = byArray[i];
            }
        }
    }

    public void resetRelightChecks() {
        this.queuedLightChecks = 0;
    }

    public void enqueueRelightChecks() {
        BlockPos blockPos = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        for (int i = 0; i < 8; ++i) {
            if (this.queuedLightChecks >= 4096) {
                return;
            }
            int n = this.queuedLightChecks % 16;
            int n2 = this.queuedLightChecks / 16 % 16;
            int n3 = this.queuedLightChecks / 256;
            ++this.queuedLightChecks;
            for (int j = 0; j < 16; ++j) {
                boolean bl;
                BlockPos blockPos2 = blockPos.add(n2, (n << 4) + j, n3);
                boolean bl2 = bl = j == 0 || j == 15 || n2 == 0 || n2 == 15 || n3 == 0 || n3 == 15;
                if ((this.storageArrays[n] != null || !bl) && (this.storageArrays[n] == null || this.storageArrays[n].getBlockByExtId(n2, j, n3).getMaterial() != Material.air)) continue;
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    BlockPos blockPos3 = blockPos2.offset(enumFacing);
                    if (this.worldObj.getBlockState(blockPos3).getBlock().getLightValue() <= 0) continue;
                    this.worldObj.checkLight(blockPos3);
                }
                this.worldObj.checkLight(blockPos2);
            }
        }
    }

    public void func_150809_p() {
        this.isTerrainPopulated = true;
        this.isLightPopulated = true;
        BlockPos blockPos = new BlockPos(this.xPosition << 4, 0, this.zPosition << 4);
        if (!this.worldObj.provider.getHasNoSky()) {
            if (this.worldObj.isAreaLoaded(blockPos.add(-1, 0, -1), blockPos.add(16, this.worldObj.getSeaLevel(), 16))) {
                block0: for (int i = 0; i < 16; ++i) {
                    for (int j = 0; j < 16; ++j) {
                        if (this.func_150811_f(i, j)) continue;
                        this.isLightPopulated = false;
                        break block0;
                    }
                }
                if (this.isLightPopulated) {
                    for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
                        int n = enumFacing.getAxisDirection() == EnumFacing.AxisDirection.POSITIVE ? 16 : 1;
                        this.worldObj.getChunkFromBlockCoords(blockPos.offset(enumFacing, n)).func_180700_a(enumFacing.getOpposite());
                    }
                    this.func_177441_y();
                }
            } else {
                this.isLightPopulated = false;
            }
        }
    }

    private void func_177441_y() {
        for (int i = 0; i < this.updateSkylightColumns.length; ++i) {
            this.updateSkylightColumns[i] = true;
        }
        this.recheckGaps(false);
    }

    private void func_180700_a(EnumFacing enumFacing) {
        block4: {
            block7: {
                block6: {
                    block5: {
                        if (!this.isTerrainPopulated) break block4;
                        if (enumFacing != EnumFacing.EAST) break block5;
                        for (int i = 0; i < 16; ++i) {
                            this.func_150811_f(15, i);
                        }
                        break block4;
                    }
                    if (enumFacing != EnumFacing.WEST) break block6;
                    for (int i = 0; i < 16; ++i) {
                        this.func_150811_f(0, i);
                    }
                    break block4;
                }
                if (enumFacing != EnumFacing.SOUTH) break block7;
                for (int i = 0; i < 16; ++i) {
                    this.func_150811_f(i, 15);
                }
                break block4;
            }
            if (enumFacing != EnumFacing.NORTH) break block4;
            for (int i = 0; i < 16; ++i) {
                this.func_150811_f(i, 0);
            }
        }
    }

    private boolean func_150811_f(int n, int n2) {
        int n3;
        int n4 = this.getTopFilledSegment();
        boolean bl = false;
        boolean bl2 = false;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos((this.xPosition << 4) + n, 0, (this.zPosition << 4) + n2);
        for (n3 = n4 + 16 - 1; n3 > this.worldObj.getSeaLevel() || n3 > 0 && !bl2; --n3) {
            mutableBlockPos.set(mutableBlockPos.getX(), n3, mutableBlockPos.getZ());
            int n5 = this.getBlockLightOpacity(mutableBlockPos);
            if (n5 == 255 && mutableBlockPos.getY() < this.worldObj.getSeaLevel()) {
                bl2 = true;
            }
            if (!bl && n5 > 0) {
                bl = true;
                continue;
            }
            if (!bl || n5 != 0 || this.worldObj.checkLight(mutableBlockPos)) continue;
            return false;
        }
        for (n3 = mutableBlockPos.getY(); n3 > 0; --n3) {
            mutableBlockPos.set(mutableBlockPos.getX(), n3, mutableBlockPos.getZ());
            if (this.getBlock(mutableBlockPos).getLightValue() <= 0) continue;
            this.worldObj.checkLight(mutableBlockPos);
        }
        return true;
    }

    public boolean isLoaded() {
        return this.isChunkLoaded;
    }

    public void setChunkLoaded(boolean bl) {
        this.isChunkLoaded = bl;
    }

    public World getWorld() {
        return this.worldObj;
    }

    public int[] getHeightMap() {
        return this.heightMap;
    }

    public void setHeightMap(int[] nArray) {
        if (this.heightMap.length != nArray.length) {
            logger.warn("Could not set level chunk heightmap, array length is " + nArray.length + " instead of " + this.heightMap.length);
        } else {
            for (int i = 0; i < this.heightMap.length; ++i) {
                this.heightMap[i] = nArray[i];
            }
        }
    }

    public Map<BlockPos, TileEntity> getTileEntityMap() {
        return this.chunkTileEntityMap;
    }

    public ClassInheritanceMultiMap<Entity>[] getEntityLists() {
        return this.entityLists;
    }

    public boolean isTerrainPopulated() {
        return this.isTerrainPopulated;
    }

    public void setTerrainPopulated(boolean bl) {
        this.isTerrainPopulated = bl;
    }

    public boolean isLightPopulated() {
        return this.isLightPopulated;
    }

    public void setLightPopulated(boolean bl) {
        this.isLightPopulated = bl;
    }

    public void setModified(boolean bl) {
        this.isModified = bl;
    }

    public void setHasEntities(boolean bl) {
        this.hasEntities = bl;
    }

    public void setLastSaveTime(long l) {
        this.lastSaveTime = l;
    }

    public int getLowestHeight() {
        return this.heightMapMinimum;
    }

    public long getInhabitedTime() {
        return this.inhabitedTime;
    }

    public void setInhabitedTime(long l) {
        this.inhabitedTime = l;
    }

    public static enum EnumCreateEntityType {
        IMMEDIATE,
        QUEUED,
        CHECK;

    }
}

