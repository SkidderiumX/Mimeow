/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import de.florianmichael.viamcp.fixes.FixedSoundEngine;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHopper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSnow;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.profiler.Profiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.IntHashMap;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ReportedException;
import net.minecraft.util.Vec3;
import net.minecraft.village.VillageCollection;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldInfo;
import x.oc9755810e45;
import x.ocbb7e5a42d7;
import x.occ52191e479;

public abstract class World
implements IBlockAccess {
    private int seaLevel = 63;
    protected boolean scheduledUpdatesAreImmediate;
    public final List<Entity> loadedEntityList = Lists.newArrayList();
    protected final List<Entity> unloadedEntityList = Lists.newArrayList();
    public final List<TileEntity> loadedTileEntityList = Lists.newArrayList();
    public final List<TileEntity> tickableTileEntities = Lists.newArrayList();
    private final List<TileEntity> addedTileEntityList = Lists.newArrayList();
    private final List<TileEntity> tileEntitiesToBeRemoved = Lists.newArrayList();
    public final List<EntityPlayer> playerEntities = Lists.newArrayList();
    public final List<Entity> weatherEffects = Lists.newArrayList();
    protected final IntHashMap<Entity> entitiesById = new IntHashMap();
    private long cloudColour = 0xFFFFFFL;
    private int skylightSubtracted;
    protected int updateLCG = new Random().nextInt();
    protected final int DIST_HASH_MAGIC = 1013904223;
    protected float prevRainingStrength;
    protected float rainingStrength;
    protected float prevThunderingStrength;
    protected float thunderingStrength;
    private int lastLightningBolt;
    public final Random rand = new ocbb7e5a42d7();
    public final WorldProvider provider;
    protected List<IWorldAccess> worldAccesses = Lists.newArrayList();
    protected IChunkProvider chunkProvider;
    protected final ISaveHandler saveHandler;
    protected WorldInfo worldInfo;
    protected boolean findingSpawnPoint;
    protected MapStorage mapStorage;
    protected VillageCollection villageCollectionObj;
    public final Profiler theProfiler;
    private final Calendar theCalendar = Calendar.getInstance();
    protected Scoreboard worldScoreboard = new Scoreboard();
    public final boolean isRemote;
    protected Set<ChunkCoordIntPair> activeChunkSet = Sets.newHashSet();
    private int activeChunkX = Integer.MIN_VALUE;
    private int activeChunkZ = Integer.MIN_VALUE;
    private int activeChunkDistance = Integer.MIN_VALUE;
    private int[] activePlayerChunkXs = new int[0];
    private int[] activePlayerChunkZs = new int[0];
    private int ambientTickCountdown = this.rand.nextInt(12000);
    protected boolean spawnHostileMobs = true;
    protected boolean spawnPeacefulMobs = true;
    private boolean processingLoadedTiles;
    private final WorldBorder worldBorder;
    int[] lightUpdateBlockList = new int[32768];

    protected World(ISaveHandler iSaveHandler, WorldInfo worldInfo, WorldProvider worldProvider, Profiler profiler, boolean bl) {
        this.saveHandler = iSaveHandler;
        this.theProfiler = profiler;
        this.worldInfo = worldInfo;
        this.provider = worldProvider;
        this.isRemote = bl;
        this.worldBorder = worldProvider.getWorldBorder();
    }

    public World init() {
        return this;
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(final BlockPos blockPos) {
        if (this.isBlockLoaded(blockPos)) {
            Chunk chunk = this.getChunkFromBlockCoords(blockPos);
            try {
                return chunk.getBiome(blockPos, this.provider.getWorldChunkManager());
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Getting biome");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Coordinates of biome request");
                crashReportCategory.addCrashSectionCallable("Location", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return CrashReportCategory.getCoordinateInfo(blockPos);
                    }
                });
                throw new ReportedException(crashReport);
            }
        }
        return this.provider.getWorldChunkManager().getBiomeGenerator(blockPos, BiomeGenBase.plains);
    }

    public WorldChunkManager getWorldChunkManager() {
        return this.provider.getWorldChunkManager();
    }

    protected abstract IChunkProvider createChunkProvider();

    public void initialize(WorldSettings worldSettings) {
        this.worldInfo.setServerInitialized(true);
    }

    public void setInitialSpawnLocation() {
        this.setSpawnPoint(new BlockPos(8, 64, 8));
    }

    public Block getGroundAboveSeaLevel(BlockPos blockPos) {
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), this.getSeaLevel(), blockPos.getZ());
        while (!this.isAirBlock(blockPos2.up())) {
            blockPos2 = blockPos2.up();
        }
        return this.getBlockState(blockPos2).getBlock();
    }

    private boolean isValid(BlockPos blockPos) {
        return blockPos.getX() >= -30000000 && blockPos.getZ() >= -30000000 && blockPos.getX() < 30000000 && blockPos.getZ() < 30000000 && blockPos.getY() >= 0 && blockPos.getY() < 256;
    }

    @Override
    public boolean isAirBlock(BlockPos blockPos) {
        return this.getBlockState(blockPos).getBlock().getMaterial() == Material.air;
    }

    public boolean isBlockLoaded(BlockPos blockPos) {
        return this.isBlockLoaded(blockPos, true);
    }

    public boolean isBlockLoaded(BlockPos blockPos, boolean bl) {
        return !this.isValid(blockPos) ? false : this.isChunkLoaded(blockPos.getX() >> 4, blockPos.getZ() >> 4, bl);
    }

    public boolean isAreaLoaded(BlockPos blockPos, int n) {
        return this.isAreaLoaded(blockPos, n, true);
    }

    public boolean isAreaLoaded(BlockPos blockPos, int n, boolean bl) {
        return this.isAreaLoaded(blockPos.getX() - n, blockPos.getY() - n, blockPos.getZ() - n, blockPos.getX() + n, blockPos.getY() + n, blockPos.getZ() + n, bl);
    }

    public boolean isAreaLoaded(BlockPos blockPos, BlockPos blockPos2) {
        return this.isAreaLoaded(blockPos, blockPos2, true);
    }

    public boolean isAreaLoaded(BlockPos blockPos, BlockPos blockPos2, boolean bl) {
        return this.isAreaLoaded(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ(), bl);
    }

    public boolean isAreaLoaded(StructureBoundingBox structureBoundingBox) {
        return this.isAreaLoaded(structureBoundingBox, true);
    }

    public boolean isAreaLoaded(StructureBoundingBox structureBoundingBox, boolean bl) {
        return this.isAreaLoaded(structureBoundingBox.minX, structureBoundingBox.minY, structureBoundingBox.minZ, structureBoundingBox.maxX, structureBoundingBox.maxY, structureBoundingBox.maxZ, bl);
    }

    private boolean isAreaLoaded(int n, int n2, int n3, int n4, int n5, int n6, boolean bl) {
        if (n5 >= 0 && n2 < 256) {
            n3 >>= 4;
            n4 >>= 4;
            n6 >>= 4;
            for (int i = n >>= 4; i <= n4; ++i) {
                for (int j = n3; j <= n6; ++j) {
                    if (this.isChunkLoaded(i, j, bl)) continue;
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    protected boolean isChunkLoaded(int n, int n2, boolean bl) {
        return this.chunkProvider.chunkExists(n, n2) && (bl || !this.chunkProvider.provideChunk(n, n2).isEmpty());
    }

    public Chunk getChunkFromBlockCoords(BlockPos blockPos) {
        return this.getChunkFromChunkCoords(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }

    public Chunk getChunkFromChunkCoords(int n, int n2) {
        return this.chunkProvider.provideChunk(n, n2);
    }

    public boolean setBlockState(BlockPos blockPos, IBlockState iBlockState, int n) {
        if (!this.isValid(blockPos)) {
            return false;
        }
        if (!this.isRemote && this.worldInfo.getTerrainType() == WorldType.DEBUG_WORLD) {
            return false;
        }
        Chunk chunk = this.getChunkFromBlockCoords(blockPos);
        Block block = iBlockState.getBlock();
        IBlockState iBlockState2 = chunk.setBlockState(blockPos, iBlockState);
        if (iBlockState2 == null) {
            return false;
        }
        Block block2 = iBlockState2.getBlock();
        if (block.getLightOpacity() != block2.getLightOpacity() || block.getLightValue() != block2.getLightValue()) {
            this.theProfiler.startSection("checkLight");
            this.checkLight(blockPos);
            this.theProfiler.endSection();
        }
        if ((n & 2) != 0 && (!this.isRemote || (n & 4) == 0) && chunk.isPopulated()) {
            this.markBlockForUpdate(blockPos);
        }
        if (!this.isRemote && (n & 1) != 0) {
            this.notifyNeighborsRespectDebug(blockPos, iBlockState2.getBlock());
            if (block.hasComparatorInputOverride()) {
                this.updateComparatorOutputLevel(blockPos, block);
            }
        }
        return true;
    }

    public boolean setBlockToAir(BlockPos blockPos) {
        return this.setBlockState(blockPos, Blocks.air.getDefaultState(), 3);
    }

    public boolean destroyBlock(BlockPos blockPos, boolean bl) {
        return FixedSoundEngine.destroyBlock(this, blockPos, bl);
    }

    public boolean setBlockState(BlockPos blockPos, IBlockState iBlockState) {
        return this.setBlockState(blockPos, iBlockState, 3);
    }

    public void markBlockForUpdate(BlockPos blockPos) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).markBlockForUpdate(blockPos);
        }
    }

    public void notifyNeighborsRespectDebug(BlockPos blockPos, Block block) {
        if (this.worldInfo.getTerrainType() != WorldType.DEBUG_WORLD) {
            this.notifyNeighborsOfStateChange(blockPos, block);
        }
    }

    public void markBlocksDirtyVertical(int n, int n2, int n3, int n4) {
        int n5;
        if (n3 > n4) {
            n5 = n4;
            n4 = n3;
            n3 = n5;
        }
        if (!this.provider.getHasNoSky()) {
            for (n5 = n3; n5 <= n4; ++n5) {
                this.checkLightFor(EnumSkyBlock.SKY, new BlockPos(n, n5, n2));
            }
        }
        this.markBlockRangeForRenderUpdate(n, n3, n2, n, n4, n2);
    }

    public void markBlockRangeForRenderUpdate(BlockPos blockPos, BlockPos blockPos2) {
        this.markBlockRangeForRenderUpdate(blockPos.getX(), blockPos.getY(), blockPos.getZ(), blockPos2.getX(), blockPos2.getY(), blockPos2.getZ());
    }

    public void markBlockRangeForRenderUpdate(int n, int n2, int n3, int n4, int n5, int n6) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).markBlockRangeForRenderUpdate(n, n2, n3, n4, n5, n6);
        }
    }

    public void notifyNeighborsOfStateChange(BlockPos blockPos, Block block) {
        this.notifyBlockOfStateChange(blockPos.west(), block);
        this.notifyBlockOfStateChange(blockPos.east(), block);
        this.notifyBlockOfStateChange(blockPos.down(), block);
        this.notifyBlockOfStateChange(blockPos.up(), block);
        this.notifyBlockOfStateChange(blockPos.north(), block);
        this.notifyBlockOfStateChange(blockPos.south(), block);
    }

    public void notifyNeighborsOfStateExcept(BlockPos blockPos, Block block, EnumFacing enumFacing) {
        if (enumFacing != EnumFacing.WEST) {
            this.notifyBlockOfStateChange(blockPos.west(), block);
        }
        if (enumFacing != EnumFacing.EAST) {
            this.notifyBlockOfStateChange(blockPos.east(), block);
        }
        if (enumFacing != EnumFacing.DOWN) {
            this.notifyBlockOfStateChange(blockPos.down(), block);
        }
        if (enumFacing != EnumFacing.UP) {
            this.notifyBlockOfStateChange(blockPos.up(), block);
        }
        if (enumFacing != EnumFacing.NORTH) {
            this.notifyBlockOfStateChange(blockPos.north(), block);
        }
        if (enumFacing != EnumFacing.SOUTH) {
            this.notifyBlockOfStateChange(blockPos.south(), block);
        }
    }

    public void notifyBlockOfStateChange(BlockPos blockPos, final Block block) {
        if (!this.isRemote) {
            IBlockState iBlockState = this.getBlockState(blockPos);
            try {
                iBlockState.getBlock().onNeighborBlockChange(this, blockPos, iBlockState, block);
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception while updating neighbours");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Block being updated");
                crashReportCategory.addCrashSectionCallable("Source block type", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        try {
                            return String.format("ID #%d (%s // %s)", Block.getIdFromBlock(block), block.getUnlocalizedName(), block.getClass().getCanonicalName());
                        }
                        catch (Throwable throwable) {
                            return "ID #" + Block.getIdFromBlock(block);
                        }
                    }
                });
                CrashReportCategory.addBlockInfo(crashReportCategory, blockPos, iBlockState);
                throw new ReportedException(crashReport);
            }
        }
    }

    public boolean isBlockTickPending(BlockPos blockPos, Block block) {
        return false;
    }

    public boolean canSeeSky(BlockPos blockPos) {
        return this.getChunkFromBlockCoords(blockPos).canSeeSky(blockPos);
    }

    public boolean canBlockSeeSky(BlockPos blockPos) {
        if (blockPos.getY() >= this.getSeaLevel()) {
            return this.canSeeSky(blockPos);
        }
        BlockPos blockPos2 = new BlockPos(blockPos.getX(), this.getSeaLevel(), blockPos.getZ());
        if (!this.canSeeSky(blockPos2)) {
            return false;
        }
        blockPos2 = blockPos2.down();
        while (blockPos2.getY() > blockPos.getY()) {
            Block block = this.getBlockState(blockPos2).getBlock();
            if (block.getLightOpacity() > 0 && !block.getMaterial().isLiquid()) {
                return false;
            }
            blockPos2 = blockPos2.down();
        }
        return true;
    }

    public int getLight(BlockPos blockPos) {
        if (blockPos.getY() < 0) {
            return 0;
        }
        if (blockPos.getY() >= 256) {
            blockPos = new BlockPos(blockPos.getX(), 255, blockPos.getZ());
        }
        return this.getChunkFromBlockCoords(blockPos).getLightSubtracted(blockPos, 0);
    }

    public int getLightFromNeighbors(BlockPos blockPos) {
        return this.getLight(blockPos, true);
    }

    public int getLight(BlockPos blockPos, boolean bl) {
        if (blockPos.getX() >= -30000000 && blockPos.getZ() >= -30000000 && blockPos.getX() < 30000000 && blockPos.getZ() < 30000000) {
            if (bl && this.getBlockState(blockPos).getBlock().getUseNeighborBrightness()) {
                int n = blockPos.getX();
                int n2 = blockPos.getY();
                int n3 = blockPos.getZ();
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                int n4 = this.getLight(mutableBlockPos.set(n, n2 + 1, n3), false);
                int n5 = this.getLight(mutableBlockPos.set(n + 1, n2, n3), false);
                int n6 = this.getLight(mutableBlockPos.set(n - 1, n2, n3), false);
                int n7 = this.getLight(mutableBlockPos.set(n, n2, n3 + 1), false);
                int n8 = this.getLight(mutableBlockPos.set(n, n2, n3 - 1), false);
                if (n5 > n4) {
                    n4 = n5;
                }
                if (n6 > n4) {
                    n4 = n6;
                }
                if (n7 > n4) {
                    n4 = n7;
                }
                if (n8 > n4) {
                    n4 = n8;
                }
                return n4;
            }
            if (blockPos.getY() < 0) {
                return 0;
            }
            if (blockPos.getY() >= 256) {
                blockPos = new BlockPos(blockPos.getX(), 255, blockPos.getZ());
            }
            Chunk chunk = this.getChunkFromBlockCoords(blockPos);
            return chunk.getLightSubtracted(blockPos, this.skylightSubtracted);
        }
        return 15;
    }

    public BlockPos getHeight(BlockPos blockPos) {
        int n = blockPos.getX() >= -30000000 && blockPos.getZ() >= -30000000 && blockPos.getX() < 30000000 && blockPos.getZ() < 30000000 ? (this.isChunkLoaded(blockPos.getX() >> 4, blockPos.getZ() >> 4, true) ? this.getChunkFromChunkCoords(blockPos.getX() >> 4, blockPos.getZ() >> 4).getHeightValue(blockPos.getX() & 0xF, blockPos.getZ() & 0xF) : 0) : this.getSeaLevel() + 1;
        return new BlockPos(blockPos.getX(), n, blockPos.getZ());
    }

    public int getChunksLowestHorizon(int n, int n2) {
        if (n >= -30000000 && n2 >= -30000000 && n < 30000000 && n2 < 30000000) {
            if (!this.isChunkLoaded(n >> 4, n2 >> 4, true)) {
                return 0;
            }
            Chunk chunk = this.getChunkFromChunkCoords(n >> 4, n2 >> 4);
            return chunk.getLowestHeight();
        }
        return this.getSeaLevel() + 1;
    }

    public int getLightFromNeighborsFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos) {
        if (this.provider.getHasNoSky() && enumSkyBlock == EnumSkyBlock.SKY) {
            return 0;
        }
        if (blockPos.getY() < 0) {
            blockPos = new BlockPos(blockPos.getX(), 0, blockPos.getZ());
        }
        if (!this.isValid(blockPos)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (!this.isBlockLoaded(blockPos)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (this.getBlockState(blockPos).getBlock().getUseNeighborBrightness()) {
            int n = blockPos.getX();
            int n2 = blockPos.getY();
            int n3 = blockPos.getZ();
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            int n4 = this.getLightFor(enumSkyBlock, mutableBlockPos.set(n, n2 + 1, n3));
            int n5 = this.getLightFor(enumSkyBlock, mutableBlockPos.set(n + 1, n2, n3));
            int n6 = this.getLightFor(enumSkyBlock, mutableBlockPos.set(n - 1, n2, n3));
            int n7 = this.getLightFor(enumSkyBlock, mutableBlockPos.set(n, n2, n3 + 1));
            int n8 = this.getLightFor(enumSkyBlock, mutableBlockPos.set(n, n2, n3 - 1));
            if (n5 > n4) {
                n4 = n5;
            }
            if (n6 > n4) {
                n4 = n6;
            }
            if (n7 > n4) {
                n4 = n7;
            }
            if (n8 > n4) {
                n4 = n8;
            }
            return n4;
        }
        Chunk chunk = this.getChunkFromBlockCoords(blockPos);
        return chunk.getLightFor(enumSkyBlock, blockPos);
    }

    public int getLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos) {
        if (blockPos.getY() < 0) {
            blockPos = new BlockPos(blockPos.getX(), 0, blockPos.getZ());
        }
        if (!this.isValid(blockPos)) {
            return enumSkyBlock.defaultLightValue;
        }
        if (!this.isBlockLoaded(blockPos)) {
            return enumSkyBlock.defaultLightValue;
        }
        Chunk chunk = this.getChunkFromBlockCoords(blockPos);
        return chunk.getLightFor(enumSkyBlock, blockPos);
    }

    public void setLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos, int n) {
        if (this.isValid(blockPos) && this.isBlockLoaded(blockPos)) {
            Chunk chunk = this.getChunkFromBlockCoords(blockPos);
            chunk.setLightFor(enumSkyBlock, blockPos, n);
            this.notifyLightSet(blockPos);
        }
    }

    public void notifyLightSet(BlockPos blockPos) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).notifyLightSet(blockPos);
        }
    }

    @Override
    public int getCombinedLight(BlockPos blockPos, int n) {
        int n2 = this.getLightFromNeighborsFor(EnumSkyBlock.SKY, blockPos);
        int n3 = this.getLightFromNeighborsFor(EnumSkyBlock.BLOCK, blockPos);
        if (n3 < n) {
            n3 = n;
        }
        return n2 << 20 | n3 << 4;
    }

    public float getLightBrightness(BlockPos blockPos) {
        return this.provider.getLightBrightnessTable()[this.getLightFromNeighbors(blockPos)];
    }

    @Override
    public IBlockState getBlockState(BlockPos blockPos) {
        if (!this.isValid(blockPos)) {
            return Blocks.air.getDefaultState();
        }
        Chunk chunk = this.getChunkFromBlockCoords(blockPos);
        return chunk.getBlockState(blockPos);
    }

    public boolean isDaytime() {
        return this.skylightSubtracted < 4;
    }

    public MovingObjectPosition rayTraceBlocks(Vec3 vec3, Vec3 vec32) {
        return this.rayTraceBlocks(vec3, vec32, false, false, false);
    }

    public MovingObjectPosition rayTraceBlocks(Vec3 vec3, Vec3 vec32, boolean bl) {
        return this.rayTraceBlocks(vec3, vec32, bl, false, false);
    }

    public MovingObjectPosition rayTraceBlocks(Vec3 vec3, Vec3 vec32, boolean bl, boolean bl2, boolean bl3) {
        if (!(Double.isNaN(vec3.xCoord) || Double.isNaN(vec3.yCoord) || Double.isNaN(vec3.zCoord))) {
            if (!(Double.isNaN(vec32.xCoord) || Double.isNaN(vec32.yCoord) || Double.isNaN(vec32.zCoord))) {
                MovingObjectPosition movingObjectPosition;
                int n = MathHelper.floor_double(vec32.xCoord);
                int n2 = MathHelper.floor_double(vec32.yCoord);
                int n3 = MathHelper.floor_double(vec32.zCoord);
                int n4 = MathHelper.floor_double(vec3.xCoord);
                int n5 = MathHelper.floor_double(vec3.yCoord);
                int n6 = MathHelper.floor_double(vec3.zCoord);
                BlockPos blockPos = new BlockPos(n4, n5, n6);
                IBlockState iBlockState = this.getBlockState(blockPos);
                Block block = iBlockState.getBlock();
                if ((!bl2 || block.getCollisionBoundingBox(this, blockPos, iBlockState) != null) && block.canCollideCheck(iBlockState, bl) && (movingObjectPosition = block.collisionRayTrace(this, blockPos, vec3, vec32)) != null) {
                    return movingObjectPosition;
                }
                movingObjectPosition = null;
                int n7 = 200;
                while (n7-- >= 0) {
                    EnumFacing enumFacing;
                    if (Double.isNaN(vec3.xCoord) || Double.isNaN(vec3.yCoord) || Double.isNaN(vec3.zCoord)) {
                        return null;
                    }
                    if (n4 == n && n5 == n2 && n6 == n3) {
                        return bl3 ? movingObjectPosition : null;
                    }
                    boolean bl4 = true;
                    boolean bl5 = true;
                    boolean bl6 = true;
                    double d = 999.0;
                    double d2 = 999.0;
                    double d3 = 999.0;
                    if (n > n4) {
                        d = (double)n4 + 1.0;
                    } else if (n < n4) {
                        d = (double)n4 + 0.0;
                    } else {
                        bl4 = false;
                    }
                    if (n2 > n5) {
                        d2 = (double)n5 + 1.0;
                    } else if (n2 < n5) {
                        d2 = (double)n5 + 0.0;
                    } else {
                        bl5 = false;
                    }
                    if (n3 > n6) {
                        d3 = (double)n6 + 1.0;
                    } else if (n3 < n6) {
                        d3 = (double)n6 + 0.0;
                    } else {
                        bl6 = false;
                    }
                    double d4 = 999.0;
                    double d5 = 999.0;
                    double d6 = 999.0;
                    double d7 = vec32.xCoord - vec3.xCoord;
                    double d8 = vec32.yCoord - vec3.yCoord;
                    double d9 = vec32.zCoord - vec3.zCoord;
                    if (bl4) {
                        d4 = (d - vec3.xCoord) / d7;
                    }
                    if (bl5) {
                        d5 = (d2 - vec3.yCoord) / d8;
                    }
                    if (bl6) {
                        d6 = (d3 - vec3.zCoord) / d9;
                    }
                    if (d4 == -0.0) {
                        d4 = -1.0E-4;
                    }
                    if (d5 == -0.0) {
                        d5 = -1.0E-4;
                    }
                    if (d6 == -0.0) {
                        d6 = -1.0E-4;
                    }
                    if (d4 < d5 && d4 < d6) {
                        enumFacing = n > n4 ? EnumFacing.WEST : EnumFacing.EAST;
                        vec3 = new Vec3(d, vec3.yCoord + d8 * d4, vec3.zCoord + d9 * d4);
                    } else if (d5 < d6) {
                        enumFacing = n2 > n5 ? EnumFacing.DOWN : EnumFacing.UP;
                        vec3 = new Vec3(vec3.xCoord + d7 * d5, d2, vec3.zCoord + d9 * d5);
                    } else {
                        enumFacing = n3 > n6 ? EnumFacing.NORTH : EnumFacing.SOUTH;
                        vec3 = new Vec3(vec3.xCoord + d7 * d6, vec3.yCoord + d8 * d6, d3);
                    }
                    n4 = MathHelper.floor_double(vec3.xCoord) - (enumFacing == EnumFacing.EAST ? 1 : 0);
                    n5 = MathHelper.floor_double(vec3.yCoord) - (enumFacing == EnumFacing.UP ? 1 : 0);
                    n6 = MathHelper.floor_double(vec3.zCoord) - (enumFacing == EnumFacing.SOUTH ? 1 : 0);
                    blockPos = new BlockPos(n4, n5, n6);
                    IBlockState iBlockState2 = this.getBlockState(blockPos);
                    Block block2 = iBlockState2.getBlock();
                    if (bl2 && block2.getCollisionBoundingBox(this, blockPos, iBlockState2) == null) continue;
                    if (block2.canCollideCheck(iBlockState2, bl)) {
                        MovingObjectPosition movingObjectPosition2 = block2.collisionRayTrace(this, blockPos, vec3, vec32);
                        if (movingObjectPosition2 == null) continue;
                        return movingObjectPosition2;
                    }
                    movingObjectPosition = new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec3, enumFacing, blockPos);
                }
                return bl3 ? movingObjectPosition : null;
            }
            return null;
        }
        return null;
    }

    public void playSoundAtEntity(Entity entity, String string, float f, float f2) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).playSound(string, entity.posX, entity.posY, entity.posZ, f, f2);
        }
    }

    public void playSoundToNearExcept(EntityPlayer entityPlayer, String string, float f, float f2) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).playSoundToNearExcept(entityPlayer, string, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, f, f2);
        }
    }

    public void playSoundEffect(double d, double d2, double d3, String string, float f, float f2) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).playSound(string, d, d2, d3, f, f2);
        }
    }

    public void playSound(double d, double d2, double d3, String string, float f, float f2, boolean bl) {
    }

    public void playRecord(BlockPos blockPos, String string) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).playRecord(string, blockPos);
        }
    }

    public void spawnParticle(EnumParticleTypes enumParticleTypes, double d, double d2, double d3, double d4, double d5, double d6, int ... nArray) {
        this.spawnParticle(enumParticleTypes.getParticleID(), enumParticleTypes.getShouldIgnoreRange(), d, d2, d3, d4, d5, d6, nArray);
    }

    public void spawnParticle(EnumParticleTypes enumParticleTypes, boolean bl, double d, double d2, double d3, double d4, double d5, double d6, int ... nArray) {
        this.spawnParticle(enumParticleTypes.getParticleID(), enumParticleTypes.getShouldIgnoreRange() | bl, d, d2, d3, d4, d5, d6, nArray);
    }

    private void spawnParticle(int n, boolean bl, double d, double d2, double d3, double d4, double d5, double d6, int ... nArray) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).spawnParticle(n, bl, d, d2, d3, d4, d5, d6, nArray);
        }
    }

    public boolean addWeatherEffect(Entity entity) {
        this.weatherEffects.add(entity);
        return true;
    }

    public boolean spawnEntityInWorld(Entity entity) {
        int n = MathHelper.floor_double(entity.posX / 16.0);
        int n2 = MathHelper.floor_double(entity.posZ / 16.0);
        boolean bl = entity.forceSpawn;
        if (entity instanceof EntityPlayer) {
            bl = true;
        }
        if (!bl && !this.isChunkLoaded(n, n2, true)) {
            return false;
        }
        if (entity instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer)entity;
            this.playerEntities.add(entityPlayer);
            this.updateAllPlayersSleepingFlag();
        }
        this.getChunkFromChunkCoords(n, n2).addEntity(entity);
        this.loadedEntityList.add(entity);
        this.onEntityAdded(entity);
        return true;
    }

    protected void onEntityAdded(Entity entity) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).onEntityAdded(entity);
        }
    }

    protected void onEntityRemoved(Entity entity) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).onEntityRemoved(entity);
        }
    }

    public void removeEntity(Entity entity) {
        if (entity.riddenByEntity != null) {
            entity.riddenByEntity.mountEntity(null);
        }
        if (entity.ridingEntity != null) {
            entity.mountEntity(null);
        }
        entity.setDead();
        if (entity instanceof EntityPlayer) {
            this.playerEntities.remove(entity);
            this.updateAllPlayersSleepingFlag();
            this.onEntityRemoved(entity);
        }
    }

    public void removePlayerEntityDangerously(Entity entity) {
        entity.setDead();
        if (entity instanceof EntityPlayer) {
            this.playerEntities.remove(entity);
            this.updateAllPlayersSleepingFlag();
        }
        int n = entity.chunkCoordX;
        int n2 = entity.chunkCoordZ;
        if (entity.addedToChunk && this.isChunkLoaded(n, n2, true)) {
            this.getChunkFromChunkCoords(n, n2).removeEntity(entity);
        }
        this.loadedEntityList.remove(entity);
        this.onEntityRemoved(entity);
    }

    public void addWorldAccess(IWorldAccess iWorldAccess) {
        this.worldAccesses.add(iWorldAccess);
    }

    public void removeWorldAccess(IWorldAccess iWorldAccess) {
        this.worldAccesses.remove(iWorldAccess);
    }

    public List<AxisAlignedBB> getCollidingBoundingBoxes(Entity entity, AxisAlignedBB axisAlignedBB) {
        int n;
        int n2;
        ArrayList<AxisAlignedBB> arrayList = Lists.newArrayList();
        int n3 = MathHelper.floor_double(axisAlignedBB.minX);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n5 = MathHelper.floor_double(axisAlignedBB.minY);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n7 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n8 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
        WorldBorder worldBorder = this.getWorldBorder();
        boolean bl = entity.isOutsideBorder();
        boolean bl2 = this.isInsideBorder(worldBorder, entity);
        IBlockState iBlockState = Blocks.stone.getDefaultState();
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n3; i < n4; ++i) {
            for (n2 = n7; n2 < n8; ++n2) {
                if (!this.isBlockLoaded(mutableBlockPos.set(i, 64, n2))) continue;
                for (n = n5 - 1; n < n6; ++n) {
                    mutableBlockPos.set(i, n, n2);
                    if (bl && bl2) {
                        entity.setOutsideBorder(false);
                    } else if (!bl && !bl2) {
                        entity.setOutsideBorder(true);
                    }
                    IBlockState iBlockState2 = iBlockState;
                    if (worldBorder.contains(mutableBlockPos) || !bl2) {
                        iBlockState2 = this.getBlockState(mutableBlockPos);
                    }
                    iBlockState2.getBlock().addCollisionBoxesToList(this, mutableBlockPos, iBlockState2, axisAlignedBB, arrayList, entity);
                }
            }
        }
        if (entity instanceof EntityTNTPrimed || entity instanceof EntityFallingBlock || entity instanceof EntityItem || entity instanceof EntityFX) {
            return arrayList;
        }
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB.expand(0.25, 0.25, 0.25);
        n2 = MathHelper.floor_double((axisAlignedBB2.minX - 2.0) / 16.0);
        n = MathHelper.floor_double((axisAlignedBB2.maxX + 2.0) / 16.0);
        int n9 = MathHelper.floor_double((axisAlignedBB2.minZ - 2.0) / 16.0);
        int n10 = MathHelper.floor_double((axisAlignedBB2.maxZ + 2.0) / 16.0);
        for (int i = n2; i <= n; ++i) {
            for (int j = n9; j <= n10; ++j) {
                if (!this.isChunkLoaded(i, j, true)) continue;
                this.getChunkFromChunkCoords(i, j).addEntityCollisionBoxes(entity, axisAlignedBB2, axisAlignedBB, arrayList);
            }
        }
        return arrayList;
    }

    public boolean isInsideBorder(WorldBorder worldBorder, Entity entity) {
        double d = worldBorder.minX();
        double d2 = worldBorder.minZ();
        double d3 = worldBorder.maxX();
        double d4 = worldBorder.maxZ();
        if (entity.isOutsideBorder()) {
            d += 1.0;
            d2 += 1.0;
            d3 -= 1.0;
            d4 -= 1.0;
        } else {
            d -= 1.0;
            d2 -= 1.0;
            d3 += 1.0;
            d4 += 1.0;
        }
        return entity.posX > d && entity.posX < d3 && entity.posZ > d2 && entity.posZ < d4;
    }

    public List<AxisAlignedBB> getCollisionBoxes(AxisAlignedBB axisAlignedBB) {
        ArrayList<AxisAlignedBB> arrayList = Lists.newArrayList();
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i < n2; ++i) {
            for (int j = n5; j < n6; ++j) {
                if (!this.isBlockLoaded(mutableBlockPos.set(i, 64, j))) continue;
                for (int k = n3 - 1; k < n4; ++k) {
                    mutableBlockPos.set(i, k, j);
                    IBlockState iBlockState = i >= -30000000 && i < 30000000 && j >= -30000000 && j < 30000000 ? this.getBlockState(mutableBlockPos) : Blocks.bedrock.getDefaultState();
                    iBlockState.getBlock().addCollisionBoxesToList(this, mutableBlockPos, iBlockState, axisAlignedBB, arrayList, null);
                }
            }
        }
        return arrayList;
    }

    public int calculateSkylightSubtracted(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (MathHelper.cos(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.5f);
        f3 = MathHelper.clamp_float(f3, 0.0f, 1.0f);
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.getRainStrength(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.getThunderStrength(f) * 5.0f) / 16.0));
        f3 = 1.0f - f3;
        return (int)(f3 * 11.0f);
    }

    public float getSunBrightness(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (MathHelper.cos(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.2f);
        f3 = MathHelper.clamp_float(f3, 0.0f, 1.0f);
        f3 = 1.0f - f3;
        f3 = (float)((double)f3 * (1.0 - (double)(this.getRainStrength(f) * 5.0f) / 16.0));
        f3 = (float)((double)f3 * (1.0 - (double)(this.getThunderStrength(f) * 5.0f) / 16.0));
        return f3 * 0.8f + 0.2f;
    }

    public Vec3 getSkyColor(Entity entity, float f) {
        float f2;
        float f3;
        float f4 = this.getCelestialAngle(f);
        float f5 = MathHelper.cos(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        f5 = MathHelper.clamp_float(f5, 0.0f, 1.0f);
        int n = MathHelper.floor_double(entity.posX);
        int n2 = MathHelper.floor_double(entity.posY);
        int n3 = MathHelper.floor_double(entity.posZ);
        BlockPos blockPos = new BlockPos(n, n2, n3);
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(blockPos);
        float f6 = biomeGenBase.getFloatTemperature(blockPos);
        int n4 = biomeGenBase.getSkyColorByTemp(f6);
        float f7 = (float)(n4 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n4 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n4 & 0xFF) / 255.0f;
        f7 *= f5;
        f8 *= f5;
        f9 *= f5;
        float f10 = this.getRainStrength(f);
        if (f10 > 0.0f) {
            f3 = (f7 * 0.3f + f8 * 0.59f + f9 * 0.11f) * 0.6f;
            f2 = 1.0f - f10 * 0.75f;
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
            f9 = f9 * f2 + f3 * (1.0f - f2);
        }
        if ((f3 = this.getThunderStrength(f)) > 0.0f) {
            f2 = (f7 * 0.3f + f8 * 0.59f + f9 * 0.11f) * 0.2f;
            float f11 = 1.0f - f3 * 0.75f;
            f7 = f7 * f11 + f2 * (1.0f - f11);
            f8 = f8 * f11 + f2 * (1.0f - f11);
            f9 = f9 * f11 + f2 * (1.0f - f11);
        }
        if (this.lastLightningBolt > 0) {
            f2 = (float)this.lastLightningBolt - f;
            if (f2 > 1.0f) {
                f2 = 1.0f;
            }
            f7 = f7 * (1.0f - (f2 *= 0.45f)) + 0.8f * f2;
            f8 = f8 * (1.0f - f2) + 0.8f * f2;
            f9 = f9 * (1.0f - f2) + 1.0f * f2;
        }
        return new Vec3(f7, f8, f9);
    }

    public float getCelestialAngle(float f) {
        WorldInfo worldInfo = this.worldInfo;
        return this.provider.calculateCelestialAngle(this.mimeow$redirect$setTimeForMoonPhase(worldInfo), f);
    }

    public int getMoonPhase() {
        WorldInfo worldInfo = this.worldInfo;
        return this.provider.getMoonPhase(this.mimeow$redirect$setTimeForMoonPhase(worldInfo));
    }

    public float getCurrentMoonPhaseFactor() {
        return WorldProvider.moonPhaseFactors[this.provider.getMoonPhase(this.worldInfo.getWorldTime())];
    }

    public float getCelestialAngleRadians(float f) {
        float f2 = this.getCelestialAngle(f);
        return f2 * (float)Math.PI * 2.0f;
    }

    public Vec3 getCloudColour(float f) {
        float f2;
        float f3;
        float f4 = this.getCelestialAngle(f);
        float f5 = MathHelper.cos(f4 * (float)Math.PI * 2.0f) * 2.0f + 0.5f;
        f5 = MathHelper.clamp_float(f5, 0.0f, 1.0f);
        float f6 = (float)(this.cloudColour >> 16 & 0xFFL) / 255.0f;
        float f7 = (float)(this.cloudColour >> 8 & 0xFFL) / 255.0f;
        float f8 = (float)(this.cloudColour & 0xFFL) / 255.0f;
        float f9 = this.getRainStrength(f);
        if (f9 > 0.0f) {
            f3 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.6f;
            f2 = 1.0f - f9 * 0.95f;
            f6 = f6 * f2 + f3 * (1.0f - f2);
            f7 = f7 * f2 + f3 * (1.0f - f2);
            f8 = f8 * f2 + f3 * (1.0f - f2);
        }
        f6 *= f5 * 0.9f + 0.1f;
        f7 *= f5 * 0.9f + 0.1f;
        f8 *= f5 * 0.85f + 0.15f;
        f3 = this.getThunderStrength(f);
        if (f3 > 0.0f) {
            f2 = (f6 * 0.3f + f7 * 0.59f + f8 * 0.11f) * 0.2f;
            float f10 = 1.0f - f3 * 0.95f;
            f6 = f6 * f10 + f2 * (1.0f - f10);
            f7 = f7 * f10 + f2 * (1.0f - f10);
            f8 = f8 * f10 + f2 * (1.0f - f10);
        }
        return new Vec3(f6, f7, f8);
    }

    public Vec3 getFogColor(float f) {
        float f2 = this.getCelestialAngle(f);
        return this.provider.getFogColor(f2, f);
    }

    public BlockPos getPrecipitationHeight(BlockPos blockPos) {
        return this.getChunkFromBlockCoords(blockPos).getPrecipitationHeight(blockPos);
    }

    public BlockPos getTopSolidOrLiquidBlock(BlockPos blockPos) {
        BlockPos blockPos2;
        Material material;
        Chunk chunk = this.getChunkFromBlockCoords(blockPos);
        BlockPos blockPos3 = new BlockPos(blockPos.getX(), chunk.getTopFilledSegment() + 16, blockPos.getZ());
        while (!(blockPos3.getY() < 0 || (material = chunk.getBlock(blockPos2 = blockPos3.down()).getMaterial()).blocksMovement() && material != Material.leaves)) {
            blockPos3 = blockPos2;
        }
        return blockPos3;
    }

    public float getStarBrightness(float f) {
        float f2 = this.getCelestialAngle(f);
        float f3 = 1.0f - (MathHelper.cos(f2 * (float)Math.PI * 2.0f) * 2.0f + 0.25f);
        f3 = MathHelper.clamp_float(f3, 0.0f, 1.0f);
        return f3 * f3 * 0.5f;
    }

    public void scheduleUpdate(BlockPos blockPos, Block block, int n) {
    }

    public void updateBlockTick(BlockPos blockPos, Block block, int n, int n2) {
    }

    public void scheduleBlockUpdate(BlockPos blockPos, Block block, int n, int n2) {
    }

    public void updateEntities() {
        int n;
        int n2;
        Object object;
        int n3;
        this.theProfiler.startSection("entities");
        this.theProfiler.startSection("global");
        for (n3 = 0; n3 < this.weatherEffects.size(); ++n3) {
            object = this.weatherEffects.get(n3);
            try {
                ++((Entity)object).ticksExisted;
                ((Entity)object).onUpdate();
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking entity");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being ticked");
                if (object == null) {
                    crashReportCategory.addCrashSection("Entity", "~~NULL~~");
                } else {
                    ((Entity)object).addEntityCrashInfo(crashReportCategory);
                }
                throw new ReportedException(crashReport);
            }
            if (!((Entity)object).isDead) continue;
            this.weatherEffects.remove(n3--);
        }
        this.theProfiler.endStartSection("remove");
        this.loadedEntityList.removeAll(this.unloadedEntityList);
        for (n3 = 0; n3 < this.unloadedEntityList.size(); ++n3) {
            object = this.unloadedEntityList.get(n3);
            n2 = ((Entity)object).chunkCoordX;
            n = ((Entity)object).chunkCoordZ;
            if (!((Entity)object).addedToChunk || !this.isChunkLoaded(n2, n, true)) continue;
            this.getChunkFromChunkCoords(n2, n).removeEntity((Entity)object);
        }
        for (n3 = 0; n3 < this.unloadedEntityList.size(); ++n3) {
            this.onEntityRemoved(this.unloadedEntityList.get(n3));
        }
        this.unloadedEntityList.clear();
        this.theProfiler.endStartSection("regular");
        for (n3 = 0; n3 < this.loadedEntityList.size(); ++n3) {
            object = this.loadedEntityList.get(n3);
            if (((Entity)object).ridingEntity != null) {
                if (!((Entity)object).ridingEntity.isDead && ((Entity)object).ridingEntity.riddenByEntity == object) continue;
                ((Entity)object).ridingEntity.riddenByEntity = null;
                ((Entity)object).ridingEntity = null;
            }
            this.theProfiler.startSection("tick");
            if (!((Entity)object).isDead) {
                try {
                    this.updateEntity((Entity)object);
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking entity");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Entity being ticked");
                    ((Entity)object).addEntityCrashInfo(crashReportCategory);
                    throw new ReportedException(crashReport);
                }
            }
            this.theProfiler.endSection();
            this.theProfiler.startSection("remove");
            if (((Entity)object).isDead) {
                n2 = ((Entity)object).chunkCoordX;
                n = ((Entity)object).chunkCoordZ;
                if (((Entity)object).addedToChunk && this.isChunkLoaded(n2, n, true)) {
                    this.getChunkFromChunkCoords(n2, n).removeEntity((Entity)object);
                }
                this.loadedEntityList.remove(n3--);
                this.onEntityRemoved((Entity)object);
            }
            this.theProfiler.endSection();
        }
        this.theProfiler.endStartSection("blockEntities");
        this.processingLoadedTiles = true;
        Iterator<TileEntity> iterator2 = this.tickableTileEntities.iterator();
        while (iterator2.hasNext()) {
            BlockPos blockPos;
            object = iterator2.next();
            if (!((TileEntity)object).isInvalid() && ((TileEntity)object).hasWorldObj() && this.isBlockLoaded(blockPos = ((TileEntity)object).getPos()) && this.worldBorder.contains(blockPos)) {
                try {
                    ((ITickable)object).update();
                }
                catch (Throwable throwable) {
                    CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Ticking block entity");
                    CrashReportCategory crashReportCategory = crashReport.makeCategory("Block entity being ticked");
                    ((TileEntity)object).addInfoToCrashReport(crashReportCategory);
                    throw new ReportedException(crashReport);
                }
            }
            if (!((TileEntity)object).isInvalid()) continue;
            iterator2.remove();
            this.loadedTileEntityList.remove(object);
            if (!this.isBlockLoaded(((TileEntity)object).getPos())) continue;
            this.getChunkFromBlockCoords(((TileEntity)object).getPos()).removeTileEntity(((TileEntity)object).getPos());
        }
        this.processingLoadedTiles = false;
        if (!this.tileEntitiesToBeRemoved.isEmpty()) {
            this.tickableTileEntities.removeAll(this.tileEntitiesToBeRemoved);
            this.loadedTileEntityList.removeAll(this.tileEntitiesToBeRemoved);
            this.tileEntitiesToBeRemoved.clear();
        }
        this.theProfiler.endStartSection("pendingBlockEntities");
        if (!this.addedTileEntityList.isEmpty()) {
            for (int i = 0; i < this.addedTileEntityList.size(); ++i) {
                TileEntity tileEntity = this.addedTileEntityList.get(i);
                if (tileEntity.isInvalid()) continue;
                if (!this.loadedTileEntityList.contains(tileEntity)) {
                    this.addTileEntity(tileEntity);
                }
                if (this.isBlockLoaded(tileEntity.getPos())) {
                    this.getChunkFromBlockCoords(tileEntity.getPos()).addTileEntity(tileEntity.getPos(), tileEntity);
                }
                this.markBlockForUpdate(tileEntity.getPos());
            }
            this.addedTileEntityList.clear();
        }
        this.theProfiler.endSection();
        this.theProfiler.endSection();
    }

    public boolean addTileEntity(TileEntity tileEntity) {
        boolean bl = this.loadedTileEntityList.add(tileEntity);
        if (bl && tileEntity instanceof ITickable) {
            this.tickableTileEntities.add(tileEntity);
        }
        return bl;
    }

    public void addTileEntities(Collection<TileEntity> collection) {
        if (this.processingLoadedTiles) {
            this.addedTileEntityList.addAll(collection);
        } else {
            for (TileEntity tileEntity : collection) {
                this.loadedTileEntityList.add(tileEntity);
                if (!(tileEntity instanceof ITickable)) continue;
                this.tickableTileEntities.add(tileEntity);
            }
        }
    }

    public void updateEntity(Entity entity) {
        this.updateEntityWithOptionalForce(entity, true);
    }

    public void updateEntityWithOptionalForce(Entity entity, boolean bl) {
        int n = MathHelper.floor_double(entity.posX);
        int n2 = MathHelper.floor_double(entity.posZ);
        boolean bl2 = bl && !this.isRemote;
        int n3 = 32;
        if (!bl2 || this.isAreaLoaded(n - n3, 0, n2 - n3, n + n3, 0, n2 + n3, true)) {
            entity.lastTickPosX = entity.posX;
            entity.lastTickPosY = entity.posY;
            entity.lastTickPosZ = entity.posZ;
            entity.prevRotationYaw = entity.rotationYaw;
            entity.prevRotationPitch = entity.rotationPitch;
            if (bl && entity.addedToChunk) {
                ++entity.ticksExisted;
                if (entity.ridingEntity != null) {
                    entity.updateRidden();
                } else {
                    entity.onUpdate();
                }
            }
            this.theProfiler.startSection("chunkCheck");
            if (Double.isNaN(entity.posX) || Double.isInfinite(entity.posX)) {
                entity.posX = entity.lastTickPosX;
            }
            if (Double.isNaN(entity.posY) || Double.isInfinite(entity.posY)) {
                entity.posY = entity.lastTickPosY;
            }
            if (Double.isNaN(entity.posZ) || Double.isInfinite(entity.posZ)) {
                entity.posZ = entity.lastTickPosZ;
            }
            if (Double.isNaN(entity.rotationPitch) || Double.isInfinite(entity.rotationPitch)) {
                entity.rotationPitch = entity.prevRotationPitch;
            }
            if (Double.isNaN(entity.rotationYaw) || Double.isInfinite(entity.rotationYaw)) {
                entity.rotationYaw = entity.prevRotationYaw;
            }
            int n4 = MathHelper.floor_double(entity.posX / 16.0);
            int n5 = MathHelper.floor_double(entity.posY / 16.0);
            int n6 = MathHelper.floor_double(entity.posZ / 16.0);
            if (!entity.addedToChunk || entity.chunkCoordX != n4 || entity.chunkCoordY != n5 || entity.chunkCoordZ != n6) {
                if (entity.addedToChunk && this.isChunkLoaded(entity.chunkCoordX, entity.chunkCoordZ, true)) {
                    this.getChunkFromChunkCoords(entity.chunkCoordX, entity.chunkCoordZ).removeEntityAtIndex(entity, entity.chunkCoordY);
                }
                if (this.isChunkLoaded(n4, n6, true)) {
                    entity.addedToChunk = true;
                    this.getChunkFromChunkCoords(n4, n6).addEntity(entity);
                } else {
                    entity.addedToChunk = false;
                }
            }
            this.theProfiler.endSection();
            if (bl && entity.addedToChunk && entity.riddenByEntity != null) {
                if (!entity.riddenByEntity.isDead && entity.riddenByEntity.ridingEntity == entity) {
                    this.updateEntity(entity.riddenByEntity);
                } else {
                    entity.riddenByEntity.ridingEntity = null;
                    entity.riddenByEntity = null;
                }
            }
        }
    }

    public boolean checkNoEntityCollision(AxisAlignedBB axisAlignedBB) {
        return this.checkNoEntityCollision(axisAlignedBB, null);
    }

    public boolean checkNoEntityCollision(AxisAlignedBB axisAlignedBB, Entity entity) {
        List<Entity> list = this.getEntitiesWithinAABBExcludingEntity(null, axisAlignedBB);
        for (int i = 0; i < list.size(); ++i) {
            Entity entity2 = list.get(i);
            if (entity2.isDead || !entity2.preventEntitySpawning || entity2 == entity || entity != null && (entity.ridingEntity == entity2 || entity.riddenByEntity == entity2)) continue;
            return false;
        }
        return true;
    }

    public boolean checkBlockCollision(AxisAlignedBB axisAlignedBB) {
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    Block block = this.getBlockState(mutableBlockPos.set(i, j, k)).getBlock();
                    if (block.getMaterial() == Material.air) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAnyLiquid(AxisAlignedBB axisAlignedBB) {
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    Block block = this.getBlockState(mutableBlockPos.set(i, j, k)).getBlock();
                    if (!block.getMaterial().isLiquid()) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFlammableWithin(AxisAlignedBB axisAlignedBB) {
        int n;
        int n2 = MathHelper.floor_double(axisAlignedBB.minX);
        int n3 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n4 = MathHelper.floor_double(axisAlignedBB.minY);
        int n5 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n6 = MathHelper.floor_double(axisAlignedBB.minZ);
        if (this.isAreaLoaded(n2, n4, n6, n3, n5, n = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0), true)) {
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
            for (int i = n2; i < n3; ++i) {
                for (int j = n4; j < n5; ++j) {
                    for (int k = n6; k < n; ++k) {
                        Block block = this.getBlockState(mutableBlockPos.set(i, j, k)).getBlock();
                        if (block != Blocks.fire && block != Blocks.flowing_lava && block != Blocks.lava) continue;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean handleMaterialAcceleration(AxisAlignedBB axisAlignedBB, Material material, Entity entity) {
        int n;
        int n2 = MathHelper.floor_double(axisAlignedBB.minX);
        int n3 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n4 = MathHelper.floor_double(axisAlignedBB.minY);
        int n5 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n6 = MathHelper.floor_double(axisAlignedBB.minZ);
        if (!this.isAreaLoaded(n2, n4, n6, n3, n5, n = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0), true)) {
            return false;
        }
        boolean bl = false;
        Vec3 vec3 = new Vec3(0.0, 0.0, 0.0);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n2; i < n3; ++i) {
            for (int j = n4; j < n5; ++j) {
                for (int k = n6; k < n; ++k) {
                    double d;
                    mutableBlockPos.set(i, j, k);
                    IBlockState iBlockState = this.getBlockState(mutableBlockPos);
                    Block block = iBlockState.getBlock();
                    if (block.getMaterial() != material || !((double)n5 >= (d = (double)((float)(j + 1) - BlockLiquid.getLiquidHeightPercent(iBlockState.getValue(BlockLiquid.LEVEL)))))) continue;
                    bl = true;
                    vec3 = block.modifyAcceleration(this, mutableBlockPos, entity, vec3);
                }
            }
        }
        if (vec3.lengthVector() > 0.0 && entity.isPushedByWater()) {
            vec3 = vec3.normalize();
            double d = 0.014;
            entity.motionX += vec3.xCoord * d;
            entity.motionY += vec3.yCoord * d;
            entity.motionZ += vec3.zCoord * d;
        }
        return bl;
    }

    public boolean isMaterialInBB(AxisAlignedBB axisAlignedBB, Material material) {
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    if (this.getBlockState(mutableBlockPos.set(i, j, k)).getBlock().getMaterial() != material) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAABBInMaterial(AxisAlignedBB axisAlignedBB, Material material) {
        int n = MathHelper.floor_double(axisAlignedBB.minX);
        int n2 = MathHelper.floor_double(axisAlignedBB.maxX + 1.0);
        int n3 = MathHelper.floor_double(axisAlignedBB.minY);
        int n4 = MathHelper.floor_double(axisAlignedBB.maxY + 1.0);
        int n5 = MathHelper.floor_double(axisAlignedBB.minZ);
        int n6 = MathHelper.floor_double(axisAlignedBB.maxZ + 1.0);
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = n; i < n2; ++i) {
            for (int j = n3; j < n4; ++j) {
                for (int k = n5; k < n6; ++k) {
                    IBlockState iBlockState = this.getBlockState(mutableBlockPos.set(i, j, k));
                    Block block = iBlockState.getBlock();
                    if (block.getMaterial() != material) continue;
                    int n7 = iBlockState.getValue(BlockLiquid.LEVEL);
                    double d = j + 1;
                    if (n7 < 8) {
                        d = (double)(j + 1) - (double)n7 / 8.0;
                    }
                    if (!(d >= axisAlignedBB.minY)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public Explosion createExplosion(Entity entity, double d, double d2, double d3, float f, boolean bl) {
        return this.newExplosion(entity, d, d2, d3, f, false, bl);
    }

    public Explosion newExplosion(Entity entity, double d, double d2, double d3, float f, boolean bl, boolean bl2) {
        Explosion explosion = new Explosion(this, entity, d, d2, d3, f, bl, bl2);
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }

    public float getBlockDensity(Vec3 vec3, AxisAlignedBB axisAlignedBB) {
        double d = 1.0 / ((axisAlignedBB.maxX - axisAlignedBB.minX) * 2.0 + 1.0);
        double d2 = 1.0 / ((axisAlignedBB.maxY - axisAlignedBB.minY) * 2.0 + 1.0);
        double d3 = 1.0 / ((axisAlignedBB.maxZ - axisAlignedBB.minZ) * 2.0 + 1.0);
        double d4 = (1.0 - Math.floor(1.0 / d) * d) / 2.0;
        double d5 = (1.0 - Math.floor(1.0 / d3) * d3) / 2.0;
        if (d >= 0.0 && d2 >= 0.0 && d3 >= 0.0) {
            int n = 0;
            int n2 = 0;
            float f = 0.0f;
            while (f <= 1.0f) {
                float f2 = 0.0f;
                while (f2 <= 1.0f) {
                    float f3 = 0.0f;
                    while (f3 <= 1.0f) {
                        double d6 = axisAlignedBB.minX + (axisAlignedBB.maxX - axisAlignedBB.minX) * (double)f;
                        double d7 = axisAlignedBB.minY + (axisAlignedBB.maxY - axisAlignedBB.minY) * (double)f2;
                        double d8 = axisAlignedBB.minZ + (axisAlignedBB.maxZ - axisAlignedBB.minZ) * (double)f3;
                        if (this.rayTraceBlocks(new Vec3(d6 + d4, d7, d8 + d5), vec3) == null) {
                            ++n;
                        }
                        ++n2;
                        f3 = (float)((double)f3 + d3);
                    }
                    f2 = (float)((double)f2 + d2);
                }
                f = (float)((double)f + d);
            }
            return (float)n / (float)n2;
        }
        return 0.0f;
    }

    public boolean extinguishFire(EntityPlayer entityPlayer, BlockPos blockPos, EnumFacing enumFacing) {
        if (this.getBlockState(blockPos = blockPos.offset(enumFacing)).getBlock() == Blocks.fire) {
            this.playAuxSFXAtEntity(entityPlayer, 1004, blockPos, 0);
            this.setBlockToAir(blockPos);
            return true;
        }
        return false;
    }

    public String getDebugLoadedEntities() {
        return "All: " + this.loadedEntityList.size();
    }

    public String getProviderName() {
        return this.chunkProvider.makeString();
    }

    @Override
    public TileEntity getTileEntity(BlockPos blockPos) {
        TileEntity tileEntity;
        int n;
        if (!this.isValid(blockPos)) {
            return null;
        }
        TileEntity tileEntity2 = null;
        if (this.processingLoadedTiles) {
            for (n = 0; n < this.addedTileEntityList.size(); ++n) {
                tileEntity = this.addedTileEntityList.get(n);
                if (tileEntity.isInvalid() || !tileEntity.getPos().equals(blockPos)) continue;
                tileEntity2 = tileEntity;
                break;
            }
        }
        if (tileEntity2 == null) {
            tileEntity2 = this.getChunkFromBlockCoords(blockPos).getTileEntity(blockPos, Chunk.EnumCreateEntityType.IMMEDIATE);
        }
        if (tileEntity2 == null) {
            for (n = 0; n < this.addedTileEntityList.size(); ++n) {
                tileEntity = this.addedTileEntityList.get(n);
                if (tileEntity.isInvalid() || !tileEntity.getPos().equals(blockPos)) continue;
                tileEntity2 = tileEntity;
                break;
            }
        }
        return tileEntity2;
    }

    public void setTileEntity(BlockPos blockPos, TileEntity tileEntity) {
        if (tileEntity != null && !tileEntity.isInvalid()) {
            if (this.processingLoadedTiles) {
                tileEntity.setPos(blockPos);
                Iterator<TileEntity> iterator2 = this.addedTileEntityList.iterator();
                while (iterator2.hasNext()) {
                    TileEntity tileEntity2 = iterator2.next();
                    if (!tileEntity2.getPos().equals(blockPos)) continue;
                    tileEntity2.invalidate();
                    iterator2.remove();
                }
                this.addedTileEntityList.add(tileEntity);
            } else {
                this.addTileEntity(tileEntity);
                this.getChunkFromBlockCoords(blockPos).addTileEntity(blockPos, tileEntity);
            }
        }
    }

    public void removeTileEntity(BlockPos blockPos) {
        TileEntity tileEntity = this.getTileEntity(blockPos);
        if (tileEntity != null && this.processingLoadedTiles) {
            tileEntity.invalidate();
            this.addedTileEntityList.remove(tileEntity);
        } else {
            if (tileEntity != null) {
                this.addedTileEntityList.remove(tileEntity);
                this.loadedTileEntityList.remove(tileEntity);
                this.tickableTileEntities.remove(tileEntity);
            }
            this.getChunkFromBlockCoords(blockPos).removeTileEntity(blockPos);
        }
    }

    public void markTileEntityForRemoval(TileEntity tileEntity) {
        this.tileEntitiesToBeRemoved.add(tileEntity);
    }

    public boolean isBlockFullCube(BlockPos blockPos) {
        IBlockState iBlockState = this.getBlockState(blockPos);
        AxisAlignedBB axisAlignedBB = iBlockState.getBlock().getCollisionBoundingBox(this, blockPos, iBlockState);
        return axisAlignedBB != null && axisAlignedBB.getAverageEdgeLength() >= 1.0;
    }

    public static boolean doesBlockHaveSolidTopSurface(IBlockAccess iBlockAccess, BlockPos blockPos) {
        IBlockState iBlockState = iBlockAccess.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.getMaterial().isOpaque() && block.isFullCube() ? true : (block instanceof BlockStairs ? iBlockState.getValue(BlockStairs.HALF) == BlockStairs.EnumHalf.TOP : (block instanceof BlockSlab ? iBlockState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP : (block instanceof BlockHopper ? true : (block instanceof BlockSnow ? iBlockState.getValue(BlockSnow.LAYERS) == 7 : false))));
    }

    public boolean isBlockNormalCube(BlockPos blockPos, boolean bl) {
        if (!this.isValid(blockPos)) {
            return bl;
        }
        Chunk chunk = this.chunkProvider.provideChunk(blockPos);
        if (chunk.isEmpty()) {
            return bl;
        }
        Block block = this.getBlockState(blockPos).getBlock();
        return block.getMaterial().isOpaque() && block.isFullCube();
    }

    public void calculateInitialSkylight() {
        int n = this.calculateSkylightSubtracted(1.0f);
        if (n != this.skylightSubtracted) {
            this.skylightSubtracted = n;
        }
    }

    public void setAllowedSpawnTypes(boolean bl, boolean bl2) {
        this.spawnHostileMobs = bl;
        this.spawnPeacefulMobs = bl2;
    }

    public void tick() {
        this.updateWeather();
    }

    protected void calculateInitialWeather() {
        if (this.worldInfo.isRaining()) {
            this.rainingStrength = 1.0f;
            if (this.worldInfo.isThundering()) {
                this.thunderingStrength = 1.0f;
            }
        }
    }

    protected void updateWeather() {
        if (!this.provider.getHasNoSky() && !this.isRemote) {
            int n;
            int n2 = this.worldInfo.getCleanWeatherTime();
            if (n2 > 0) {
                this.worldInfo.setCleanWeatherTime(--n2);
                this.worldInfo.setThunderTime(this.worldInfo.isThundering() ? 1 : 2);
                this.worldInfo.setRainTime(this.worldInfo.isRaining() ? 1 : 2);
            }
            if ((n = this.worldInfo.getThunderTime()) <= 0) {
                if (this.worldInfo.isThundering()) {
                    this.worldInfo.setThunderTime(this.rand.nextInt(12000) + 3600);
                } else {
                    this.worldInfo.setThunderTime(this.rand.nextInt(168000) + 12000);
                }
            } else {
                this.worldInfo.setThunderTime(--n);
                if (n <= 0) {
                    this.worldInfo.setThundering(!this.worldInfo.isThundering());
                }
            }
            this.prevThunderingStrength = this.thunderingStrength;
            this.thunderingStrength = this.worldInfo.isThundering() ? (float)((double)this.thunderingStrength + 0.01) : (float)((double)this.thunderingStrength - 0.01);
            this.thunderingStrength = MathHelper.clamp_float(this.thunderingStrength, 0.0f, 1.0f);
            int n3 = this.worldInfo.getRainTime();
            if (n3 <= 0) {
                if (this.worldInfo.isRaining()) {
                    this.worldInfo.setRainTime(this.rand.nextInt(12000) + 12000);
                } else {
                    this.worldInfo.setRainTime(this.rand.nextInt(168000) + 12000);
                }
            } else {
                this.worldInfo.setRainTime(--n3);
                if (n3 <= 0) {
                    this.worldInfo.setRaining(!this.worldInfo.isRaining());
                }
            }
            this.prevRainingStrength = this.rainingStrength;
            this.rainingStrength = this.worldInfo.isRaining() ? (float)((double)this.rainingStrength + 0.01) : (float)((double)this.rainingStrength - 0.01);
            this.rainingStrength = MathHelper.clamp_float(this.rainingStrength, 0.0f, 1.0f);
        }
    }

    protected void setActivePlayerChunksAndCheckLight() {
        int n;
        int n2;
        int n3;
        boolean bl;
        this.theProfiler.startSection("buildList");
        int n4 = this.getRenderDistanceChunks();
        boolean bl2 = bl = n4 != this.activeChunkDistance;
        if (this.isRemote) {
            EntityPlayerSP entityPlayerSP;
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayerSP entityPlayerSP2 = entityPlayerSP = minecraft == null ? null : minecraft.thePlayer;
            if (entityPlayerSP != null && entityPlayerSP.worldObj != this) {
                entityPlayerSP = null;
            }
            n3 = entityPlayerSP == null ? Integer.MIN_VALUE : MathHelper.floor_double(entityPlayerSP.posX / 16.0);
            n2 = entityPlayerSP == null ? Integer.MIN_VALUE : MathHelper.floor_double(entityPlayerSP.posZ / 16.0);
            bl |= n3 != this.activeChunkX || n2 != this.activeChunkZ;
            this.activeChunkX = n3;
            this.activeChunkZ = n2;
        } else {
            int n5 = this.playerEntities.size();
            if (n5 != this.activePlayerChunkXs.length) {
                this.activePlayerChunkXs = new int[n5];
                this.activePlayerChunkZs = new int[n5];
                bl = true;
            }
            for (int i = 0; i < n5; ++i) {
                EntityPlayer entityPlayer = this.playerEntities.get(i);
                n2 = MathHelper.floor_double(entityPlayer.posX / 16.0);
                n = MathHelper.floor_double(entityPlayer.posZ / 16.0);
                bl |= n2 != this.activePlayerChunkXs[i] || n != this.activePlayerChunkZs[i];
                this.activePlayerChunkXs[i] = n2;
                this.activePlayerChunkZs[i] = n;
            }
        }
        if (bl) {
            this.activeChunkSet.clear();
            if (this.isRemote) {
                if (this.activeChunkX != Integer.MIN_VALUE) {
                    this.addActiveChunks(this.activeChunkX, this.activeChunkZ, n4);
                }
            } else {
                for (int i = 0; i < this.activePlayerChunkXs.length; ++i) {
                    this.addActiveChunks(this.activePlayerChunkXs[i], this.activePlayerChunkZs[i], n4);
                }
            }
            this.activeChunkDistance = n4;
        }
        this.theProfiler.endSection();
        if (this.ambientTickCountdown > 0) {
            --this.ambientTickCountdown;
        }
        this.theProfiler.startSection("playerCheckLight");
        if (!this.playerEntities.isEmpty()) {
            int n6 = this.rand.nextInt(this.playerEntities.size());
            EntityPlayer entityPlayer = this.playerEntities.get(n6);
            n3 = MathHelper.floor_double(entityPlayer.posX) + this.rand.nextInt(11) - 5;
            n2 = MathHelper.floor_double(entityPlayer.posY) + this.rand.nextInt(11) - 5;
            n = MathHelper.floor_double(entityPlayer.posZ) + this.rand.nextInt(11) - 5;
            this.checkLight(new BlockPos(n3, n2, n));
        }
        this.theProfiler.endSection();
    }

    private void addActiveChunks(int n, int n2, int n3) {
        for (int i = -n3; i <= n3; ++i) {
            for (int j = -n3; j <= n3; ++j) {
                this.activeChunkSet.add(new ChunkCoordIntPair(n + i, n2 + j));
            }
        }
    }

    protected abstract int getRenderDistanceChunks();

    protected void playMoodSoundAndCheckLight(int n, int n2, Chunk chunk) {
        this.theProfiler.endStartSection("moodSound");
        if (this.ambientTickCountdown == 0 && !this.isRemote) {
            EntityPlayer entityPlayer;
            this.updateLCG = this.updateLCG * 3 + 1013904223;
            int n3 = this.updateLCG >> 2;
            int n4 = n3 & 0xF;
            int n5 = n3 >> 8 & 0xF;
            int n6 = n3 >> 16 & 0xFF;
            BlockPos blockPos = new BlockPos(n4, n6, n5);
            Block block = chunk.getBlock(blockPos);
            if (block.getMaterial() == Material.air && this.getLight(blockPos) <= this.rand.nextInt(8) && this.getLightFor(EnumSkyBlock.SKY, blockPos) <= 0 && (entityPlayer = this.getClosestPlayer((double)(n4 += n) + 0.5, (double)n6 + 0.5, (double)(n5 += n2) + 0.5, 8.0)) != null && entityPlayer.getDistanceSq((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5) > 4.0) {
                this.playSoundEffect((double)n4 + 0.5, (double)n6 + 0.5, (double)n5 + 0.5, "ambient.cave.cave", 0.7f, 0.8f + this.rand.nextFloat() * 0.2f);
                this.ambientTickCountdown = this.rand.nextInt(12000) + 6000;
            }
        }
        this.theProfiler.endStartSection("checkLight");
        chunk.enqueueRelightChecks();
    }

    protected void updateBlocks() {
        this.setActivePlayerChunksAndCheckLight();
    }

    public void forceBlockUpdateTick(Block block, BlockPos blockPos, Random random) {
        this.scheduledUpdatesAreImmediate = true;
        block.updateTick(this, blockPos, this.getBlockState(blockPos), random);
        this.scheduledUpdatesAreImmediate = false;
    }

    public boolean canBlockFreezeWater(BlockPos blockPos) {
        return this.canBlockFreeze(blockPos, false);
    }

    public boolean canBlockFreezeNoWater(BlockPos blockPos) {
        return this.canBlockFreeze(blockPos, true);
    }

    public boolean canBlockFreeze(BlockPos blockPos, boolean bl) {
        IBlockState iBlockState;
        Block block;
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(blockPos);
        float f = biomeGenBase.getFloatTemperature(blockPos);
        if (f > 0.15f) {
            return false;
        }
        if (blockPos.getY() >= 0 && blockPos.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, blockPos) < 10 && ((block = (iBlockState = this.getBlockState(blockPos)).getBlock()) == Blocks.water || block == Blocks.flowing_water) && iBlockState.getValue(BlockLiquid.LEVEL) == 0) {
            boolean bl2;
            if (!bl) {
                return true;
            }
            boolean bl3 = bl2 = this.isWater(blockPos.west()) && this.isWater(blockPos.east()) && this.isWater(blockPos.north()) && this.isWater(blockPos.south());
            if (!bl2) {
                return true;
            }
        }
        return false;
    }

    private boolean isWater(BlockPos blockPos) {
        return this.getBlockState(blockPos).getBlock().getMaterial() == Material.water;
    }

    public boolean canSnowAt(BlockPos blockPos, boolean bl) {
        Block block;
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(blockPos);
        float f = biomeGenBase.getFloatTemperature(blockPos);
        if (f > 0.15f) {
            return false;
        }
        if (!bl) {
            return true;
        }
        return blockPos.getY() >= 0 && blockPos.getY() < 256 && this.getLightFor(EnumSkyBlock.BLOCK, blockPos) < 10 && (block = this.getBlockState(blockPos).getBlock()).getMaterial() == Material.air && Blocks.snow_layer.canPlaceBlockAt(this, blockPos);
    }

    public boolean checkLight(BlockPos blockPos) {
        boolean bl = false;
        if (!this.provider.getHasNoSky()) {
            bl |= this.checkLightFor(EnumSkyBlock.SKY, blockPos);
        }
        return bl |= this.checkLightFor(EnumSkyBlock.BLOCK, blockPos);
    }

    private int getRawLight(BlockPos blockPos, EnumSkyBlock enumSkyBlock) {
        if (enumSkyBlock == EnumSkyBlock.SKY && this.canSeeSky(blockPos)) {
            return 15;
        }
        Block block = this.getBlockState(blockPos).getBlock();
        int n = enumSkyBlock == EnumSkyBlock.SKY ? 0 : block.getLightValue();
        int n2 = block.getLightOpacity();
        if (n2 >= 15 && block.getLightValue() > 0) {
            n2 = 1;
        }
        if (n2 < 1) {
            n2 = 1;
        }
        if (n2 >= 15) {
            return 0;
        }
        if (n >= 14) {
            return n;
        }
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        int n3 = blockPos.getX();
        int n4 = blockPos.getY();
        int n5 = blockPos.getZ();
        for (EnumFacing enumFacing : EnumFacing.VALUES) {
            mutableBlockPos.set(n3 + enumFacing.getFrontOffsetX(), n4 + enumFacing.getFrontOffsetY(), n5 + enumFacing.getFrontOffsetZ());
            int n6 = this.getLightFor(enumSkyBlock, mutableBlockPos) - n2;
            if (n6 > n) {
                n = n6;
            }
            if (n < 14) continue;
            return n;
        }
        return n;
    }

    public boolean checkLightFor(EnumSkyBlock enumSkyBlock, BlockPos blockPos) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        int n8;
        if (!this.isAreaLoaded(blockPos, 17, false)) {
            return false;
        }
        int n9 = 0;
        int n10 = 0;
        this.theProfiler.startSection("getBrightness");
        int n11 = this.getLightFor(enumSkyBlock, blockPos);
        int n12 = this.getRawLight(blockPos, enumSkyBlock);
        int n13 = blockPos.getX();
        int n14 = blockPos.getY();
        int n15 = blockPos.getZ();
        if (n12 > n11) {
            this.lightUpdateBlockList[n10++] = 133152;
        } else if (n12 < n11) {
            this.lightUpdateBlockList[n10++] = 0x20820 | n11 << 18;
            while (n9 < n10) {
                n8 = this.lightUpdateBlockList[n9++];
                n7 = (n8 & 0x3F) - 32 + n13;
                n6 = (n8 >> 6 & 0x3F) - 32 + n14;
                n5 = (n8 >> 12 & 0x3F) - 32 + n15;
                int n16 = n8 >> 18 & 0xF;
                BlockPos blockPos2 = new BlockPos(n7, n6, n5);
                n4 = this.getLightFor(enumSkyBlock, blockPos2);
                if (n4 != n16) continue;
                this.setLightFor(enumSkyBlock, blockPos2, 0);
                if (n16 <= 0 || (n3 = MathHelper.abs_int(n7 - n13)) + (n2 = MathHelper.abs_int(n6 - n14)) + (n = MathHelper.abs_int(n5 - n15)) >= 17) continue;
                BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
                for (EnumFacing enumFacing : EnumFacing.values()) {
                    int n17 = n7 + enumFacing.getFrontOffsetX();
                    int n18 = n6 + enumFacing.getFrontOffsetY();
                    int n19 = n5 + enumFacing.getFrontOffsetZ();
                    mutableBlockPos.set(n17, n18, n19);
                    int n20 = Math.max(1, this.getBlockState(mutableBlockPos).getBlock().getLightOpacity());
                    n4 = this.getLightFor(enumSkyBlock, mutableBlockPos);
                    if (n4 != n16 - n20 || n10 >= this.lightUpdateBlockList.length) continue;
                    this.lightUpdateBlockList[n10++] = n17 - n13 + 32 | n18 - n14 + 32 << 6 | n19 - n15 + 32 << 12 | n16 - n20 << 18;
                }
            }
            n9 = 0;
        }
        this.theProfiler.endSection();
        this.theProfiler.startSection("checkedPosition < toCheckCount");
        while (n9 < n10) {
            boolean bl;
            n8 = this.lightUpdateBlockList[n9++];
            n7 = (n8 & 0x3F) - 32 + n13;
            n6 = (n8 >> 6 & 0x3F) - 32 + n14;
            n5 = (n8 >> 12 & 0x3F) - 32 + n15;
            BlockPos blockPos3 = new BlockPos(n7, n6, n5);
            int n21 = this.getLightFor(enumSkyBlock, blockPos3);
            n4 = this.getRawLight(blockPos3, enumSkyBlock);
            if (n4 == n21) continue;
            this.setLightFor(enumSkyBlock, blockPos3, n4);
            if (n4 <= n21) continue;
            n3 = Math.abs(n7 - n13);
            n2 = Math.abs(n6 - n14);
            n = Math.abs(n5 - n15);
            boolean bl2 = bl = n10 < this.lightUpdateBlockList.length - 6;
            if (n3 + n2 + n >= 17 || !bl) continue;
            if (this.getLightFor(enumSkyBlock, blockPos3.west()) < n4) {
                this.lightUpdateBlockList[n10++] = n7 - 1 - n13 + 32 + (n6 - n14 + 32 << 6) + (n5 - n15 + 32 << 12);
            }
            if (this.getLightFor(enumSkyBlock, blockPos3.east()) < n4) {
                this.lightUpdateBlockList[n10++] = n7 + 1 - n13 + 32 + (n6 - n14 + 32 << 6) + (n5 - n15 + 32 << 12);
            }
            if (this.getLightFor(enumSkyBlock, blockPos3.down()) < n4) {
                this.lightUpdateBlockList[n10++] = n7 - n13 + 32 + (n6 - 1 - n14 + 32 << 6) + (n5 - n15 + 32 << 12);
            }
            if (this.getLightFor(enumSkyBlock, blockPos3.up()) < n4) {
                this.lightUpdateBlockList[n10++] = n7 - n13 + 32 + (n6 + 1 - n14 + 32 << 6) + (n5 - n15 + 32 << 12);
            }
            if (this.getLightFor(enumSkyBlock, blockPos3.north()) < n4) {
                this.lightUpdateBlockList[n10++] = n7 - n13 + 32 + (n6 - n14 + 32 << 6) + (n5 - 1 - n15 + 32 << 12);
            }
            if (this.getLightFor(enumSkyBlock, blockPos3.south()) >= n4) continue;
            this.lightUpdateBlockList[n10++] = n7 - n13 + 32 + (n6 - n14 + 32 << 6) + (n5 + 1 - n15 + 32 << 12);
        }
        this.theProfiler.endSection();
        return true;
    }

    public boolean tickUpdates(boolean bl) {
        return false;
    }

    public List<NextTickListEntry> getPendingBlockUpdates(Chunk chunk, boolean bl) {
        return null;
    }

    public List<NextTickListEntry> func_175712_a(StructureBoundingBox structureBoundingBox, boolean bl) {
        return null;
    }

    public List<Entity> getEntitiesWithinAABBExcludingEntity(Entity entity, AxisAlignedBB axisAlignedBB) {
        return this.getEntitiesInAABBexcluding(entity, axisAlignedBB, EntitySelectors.NOT_SPECTATING);
    }

    public List<Entity> getEntitiesInAABBexcluding(Entity entity, AxisAlignedBB axisAlignedBB, Predicate<? super Entity> predicate) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        int n = MathHelper.floor_double((axisAlignedBB.minX - 2.0) / 16.0);
        int n2 = MathHelper.floor_double((axisAlignedBB.maxX + 2.0) / 16.0);
        int n3 = MathHelper.floor_double((axisAlignedBB.minZ - 2.0) / 16.0);
        int n4 = MathHelper.floor_double((axisAlignedBB.maxZ + 2.0) / 16.0);
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.isChunkLoaded(i, j, true)) continue;
                this.getChunkFromChunkCoords(i, j).getEntitiesWithinAABBForEntity(entity, axisAlignedBB, arrayList, predicate);
            }
        }
        return arrayList;
    }

    public <T extends Entity> List<T> getEntities(Class<? extends T> clazz, Predicate<? super T> predicate) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        for (Entity entity : this.loadedEntityList) {
            if (!clazz.isAssignableFrom(entity.getClass()) || !predicate.apply(entity)) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public <T extends Entity> List<T> getPlayers(Class<? extends T> clazz, Predicate<? super T> predicate) {
        ArrayList<Entity> arrayList = Lists.newArrayList();
        for (Entity entity : this.playerEntities) {
            if (!clazz.isAssignableFrom(entity.getClass()) || !predicate.apply(entity)) continue;
            arrayList.add(entity);
        }
        return arrayList;
    }

    public <T extends Entity> List<T> getEntitiesWithinAABB(Class<? extends T> clazz, AxisAlignedBB axisAlignedBB) {
        return this.getEntitiesWithinAABB(clazz, axisAlignedBB, EntitySelectors.NOT_SPECTATING);
    }

    public <T extends Entity> List<T> getEntitiesWithinAABB(Class<? extends T> clazz, AxisAlignedBB axisAlignedBB, Predicate<? super T> predicate) {
        int n = MathHelper.floor_double((axisAlignedBB.minX - 2.0) / 16.0);
        int n2 = MathHelper.floor_double((axisAlignedBB.maxX + 2.0) / 16.0);
        int n3 = MathHelper.floor_double((axisAlignedBB.minZ - 2.0) / 16.0);
        int n4 = MathHelper.floor_double((axisAlignedBB.maxZ + 2.0) / 16.0);
        ArrayList arrayList = Lists.newArrayList();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                if (!this.isChunkLoaded(i, j, true)) continue;
                this.getChunkFromChunkCoords(i, j).getEntitiesOfTypeWithinAAAB(clazz, axisAlignedBB, arrayList, predicate);
            }
        }
        return arrayList;
    }

    public <T extends Entity> T findNearestEntityWithinAABB(Class<? extends T> clazz, AxisAlignedBB axisAlignedBB, T t) {
        List<T> list = this.getEntitiesWithinAABB(clazz, axisAlignedBB);
        Entity entity = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            double d2;
            Entity entity2 = (Entity)list.get(i);
            if (entity2 == t || !EntitySelectors.NOT_SPECTATING.apply(entity2) || !((d2 = t.getDistanceSqToEntity(entity2)) <= d)) continue;
            entity = entity2;
            d = d2;
        }
        return (T)entity;
    }

    public Entity getEntityByID(int n) {
        return this.entitiesById.lookup(n);
    }

    public List<Entity> getLoadedEntityList() {
        return this.loadedEntityList;
    }

    public void markChunkDirty(BlockPos blockPos, TileEntity tileEntity) {
        if (this.isBlockLoaded(blockPos)) {
            this.getChunkFromBlockCoords(blockPos).setChunkModified();
        }
    }

    public int countEntities(Class<?> clazz) {
        int n = 0;
        for (Entity entity : this.loadedEntityList) {
            if (entity instanceof EntityLiving && ((EntityLiving)entity).isNoDespawnRequired() || !clazz.isAssignableFrom(entity.getClass())) continue;
            ++n;
        }
        return n;
    }

    public void loadEntities(Collection<Entity> collection) {
        this.loadedEntityList.addAll(collection);
        for (Entity entity : collection) {
            this.onEntityAdded(entity);
        }
    }

    public void unloadEntities(Collection<Entity> collection) {
        this.unloadedEntityList.addAll(collection);
    }

    public boolean canBlockBePlaced(Block block, BlockPos blockPos, boolean bl, EnumFacing enumFacing, Entity entity, ItemStack itemStack) {
        AxisAlignedBB axisAlignedBB;
        Block block2 = this.getBlockState(blockPos).getBlock();
        AxisAlignedBB axisAlignedBB2 = axisAlignedBB = bl ? null : block.getCollisionBoundingBox(this, blockPos, block.getDefaultState());
        return axisAlignedBB != null && !this.checkNoEntityCollision(axisAlignedBB, entity) ? false : (block2.getMaterial() == Material.circuits && block == Blocks.anvil ? true : block2.getMaterial().isReplaceable() && block.canReplace(this, blockPos, enumFacing, itemStack));
    }

    public int getSeaLevel() {
        return this.seaLevel;
    }

    public void setSeaLevel(int n) {
        this.seaLevel = n;
    }

    @Override
    public int getStrongPower(BlockPos blockPos, EnumFacing enumFacing) {
        IBlockState iBlockState = this.getBlockState(blockPos);
        return iBlockState.getBlock().getStrongPower(this, blockPos, iBlockState, enumFacing);
    }

    @Override
    public WorldType getWorldType() {
        return this.worldInfo.getTerrainType();
    }

    public int getStrongPower(BlockPos blockPos) {
        int n = 0;
        if ((n = Math.max(n, this.getStrongPower(blockPos.down(), EnumFacing.DOWN))) >= 15) {
            return n;
        }
        if ((n = Math.max(n, this.getStrongPower(blockPos.up(), EnumFacing.UP))) >= 15) {
            return n;
        }
        if ((n = Math.max(n, this.getStrongPower(blockPos.north(), EnumFacing.NORTH))) >= 15) {
            return n;
        }
        if ((n = Math.max(n, this.getStrongPower(blockPos.south(), EnumFacing.SOUTH))) >= 15) {
            return n;
        }
        if ((n = Math.max(n, this.getStrongPower(blockPos.west(), EnumFacing.WEST))) >= 15) {
            return n;
        }
        return (n = Math.max(n, this.getStrongPower(blockPos.east(), EnumFacing.EAST))) >= 15 ? n : n;
    }

    public boolean isSidePowered(BlockPos blockPos, EnumFacing enumFacing) {
        return this.getRedstonePower(blockPos, enumFacing) > 0;
    }

    public int getRedstonePower(BlockPos blockPos, EnumFacing enumFacing) {
        IBlockState iBlockState = this.getBlockState(blockPos);
        Block block = iBlockState.getBlock();
        return block.isNormalCube() ? this.getStrongPower(blockPos) : block.getWeakPower(this, blockPos, iBlockState, enumFacing);
    }

    public boolean isBlockPowered(BlockPos blockPos) {
        return this.getRedstonePower(blockPos.down(), EnumFacing.DOWN) > 0 ? true : (this.getRedstonePower(blockPos.up(), EnumFacing.UP) > 0 ? true : (this.getRedstonePower(blockPos.north(), EnumFacing.NORTH) > 0 ? true : (this.getRedstonePower(blockPos.south(), EnumFacing.SOUTH) > 0 ? true : (this.getRedstonePower(blockPos.west(), EnumFacing.WEST) > 0 ? true : this.getRedstonePower(blockPos.east(), EnumFacing.EAST) > 0))));
    }

    public int isBlockIndirectlyGettingPowered(BlockPos blockPos) {
        int n = 0;
        for (EnumFacing enumFacing : EnumFacing.values()) {
            int n2 = this.getRedstonePower(blockPos.offset(enumFacing), enumFacing);
            if (n2 >= 15) {
                return 15;
            }
            if (n2 <= n) continue;
            n = n2;
        }
        return n;
    }

    public EntityPlayer getClosestPlayerToEntity(Entity entity, double d) {
        return this.getClosestPlayer(entity.posX, entity.posY, entity.posZ, d);
    }

    public EntityPlayer getClosestPlayer(double d, double d2, double d3, double d4) {
        double d5 = -1.0;
        EntityPlayer entityPlayer = null;
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer2 = this.playerEntities.get(i);
            if (!EntitySelectors.NOT_SPECTATING.apply(entityPlayer2)) continue;
            double d6 = entityPlayer2.getDistanceSq(d, d2, d3);
            if (!(d4 < 0.0) && !(d6 < d4 * d4) || d5 != -1.0 && !(d6 < d5)) continue;
            d5 = d6;
            entityPlayer = entityPlayer2;
        }
        return entityPlayer;
    }

    public boolean isAnyPlayerWithinRangeAt(double d, double d2, double d3, double d4) {
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer = this.playerEntities.get(i);
            if (!EntitySelectors.NOT_SPECTATING.apply(entityPlayer)) continue;
            double d5 = entityPlayer.getDistanceSq(d, d2, d3);
            if (!(d4 < 0.0) && !(d5 < d4 * d4)) continue;
            return true;
        }
        return false;
    }

    public EntityPlayer getPlayerEntityByName(String string) {
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer = this.playerEntities.get(i);
            if (!string.equals(entityPlayer.getName())) continue;
            return entityPlayer;
        }
        return null;
    }

    public EntityPlayer getPlayerEntityByUUID(UUID uUID) {
        for (int i = 0; i < this.playerEntities.size(); ++i) {
            EntityPlayer entityPlayer = this.playerEntities.get(i);
            if (!uUID.equals(entityPlayer.getUniqueID())) continue;
            return entityPlayer;
        }
        return null;
    }

    public void sendQuittingDisconnectingPacket() {
    }

    public void checkSessionLock() throws MinecraftException {
        this.saveHandler.checkSessionLock();
    }

    public void setTotalWorldTime(long l) {
        this.worldInfo.setWorldTotalTime(l);
    }

    public long getSeed() {
        return this.worldInfo.getSeed();
    }

    public long getTotalWorldTime() {
        return this.worldInfo.getWorldTotalTime();
    }

    public long getWorldTime() {
        return this.worldInfo.getWorldTime();
    }

    public void setWorldTime(long l) {
        this.worldInfo.setWorldTime(l);
    }

    public BlockPos getSpawnPoint() {
        BlockPos blockPos = new BlockPos(this.worldInfo.getSpawnX(), this.worldInfo.getSpawnY(), this.worldInfo.getSpawnZ());
        if (!this.getWorldBorder().contains(blockPos)) {
            blockPos = this.getHeight(new BlockPos(this.getWorldBorder().getCenterX(), 0.0, this.getWorldBorder().getCenterZ()));
        }
        return blockPos;
    }

    public void setSpawnPoint(BlockPos blockPos) {
        this.worldInfo.setSpawn(blockPos);
    }

    public void joinEntityInSurroundings(Entity entity) {
        int n = MathHelper.floor_double(entity.posX / 16.0);
        int n2 = MathHelper.floor_double(entity.posZ / 16.0);
        int n3 = 2;
        for (int i = n - n3; i <= n + n3; ++i) {
            for (int j = n2 - n3; j <= n2 + n3; ++j) {
                this.getChunkFromChunkCoords(i, j);
            }
        }
        if (!this.loadedEntityList.contains(entity)) {
            this.loadedEntityList.add(entity);
        }
    }

    public boolean isBlockModifiable(EntityPlayer entityPlayer, BlockPos blockPos) {
        return true;
    }

    public void setEntityState(Entity entity, byte by) {
    }

    public IChunkProvider getChunkProvider() {
        return this.chunkProvider;
    }

    public void addBlockEvent(BlockPos blockPos, Block block, int n, int n2) {
        block.onBlockEventReceived(this, blockPos, this.getBlockState(blockPos), n, n2);
    }

    public ISaveHandler getSaveHandler() {
        return this.saveHandler;
    }

    public WorldInfo getWorldInfo() {
        return this.worldInfo;
    }

    public GameRules getGameRules() {
        return this.worldInfo.getGameRulesInstance();
    }

    public void updateAllPlayersSleepingFlag() {
    }

    public float getThunderStrength(float f) {
        float f2;
        float f3 = f2 = (this.prevThunderingStrength + (this.thunderingStrength - this.prevThunderingStrength) * f) * this.getRainStrength(f);
        occ52191e479 occ52191e4792 = new occ52191e479("getThunderStrength", true, f2);
        this.mimeow$setThunderStrength(occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u0439() : f3;
    }

    public void setThunderStrength(float f) {
        this.prevThunderingStrength = f;
        this.thunderingStrength = f;
    }

    public float getRainStrength(float f) {
        float f2;
        float f3 = f2 = this.prevRainingStrength + (this.rainingStrength - this.prevRainingStrength) * f;
        occ52191e479 occ52191e4792 = new occ52191e479("getRainStrength", true, f2);
        this.mimeow$setPrecipitationStrength(occ52191e4792);
        return occ52191e4792.z$24lpjeeur71n9() ? occ52191e4792.\u0439() : f3;
    }

    public void setRainStrength(float f) {
        this.prevRainingStrength = f;
        this.rainingStrength = f;
    }

    public boolean isThundering() {
        return (double)this.getThunderStrength(1.0f) > 0.9;
    }

    public boolean isRaining() {
        return (double)this.getRainStrength(1.0f) > 0.2;
    }

    public boolean isRainingAt(BlockPos blockPos) {
        if (!this.isRaining()) {
            return false;
        }
        if (!this.canSeeSky(blockPos)) {
            return false;
        }
        if (this.getPrecipitationHeight(blockPos).getY() > blockPos.getY()) {
            return false;
        }
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(blockPos);
        return biomeGenBase.getEnableSnow() ? false : (this.canSnowAt(blockPos, false) ? false : biomeGenBase.canRain());
    }

    public boolean isBlockinHighHumidity(BlockPos blockPos) {
        BiomeGenBase biomeGenBase = this.getBiomeGenForCoords(blockPos);
        return biomeGenBase.isHighHumidity();
    }

    public MapStorage getMapStorage() {
        return this.mapStorage;
    }

    public void setItemData(String string, WorldSavedData worldSavedData) {
        this.mapStorage.setData(string, worldSavedData);
    }

    public WorldSavedData loadItemData(Class<? extends WorldSavedData> clazz, String string) {
        return this.mapStorage.loadData(clazz, string);
    }

    public int getUniqueDataId(String string) {
        return this.mapStorage.getUniqueDataId(string);
    }

    public void playBroadcastSound(int n, BlockPos blockPos, int n2) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            this.worldAccesses.get(i).broadcastSound(n, blockPos, n2);
        }
    }

    public void playAuxSFX(int n, BlockPos blockPos, int n2) {
        this.playAuxSFXAtEntity(null, n, blockPos, n2);
    }

    public void playAuxSFXAtEntity(EntityPlayer entityPlayer, int n, BlockPos blockPos, int n2) {
        try {
            for (int i = 0; i < this.worldAccesses.size(); ++i) {
                this.worldAccesses.get(i).playAuxSFX(entityPlayer, n, blockPos, n2);
            }
        }
        catch (Throwable throwable) {
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Playing level event");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Level event being played");
            crashReportCategory.addCrashSection("Block coordinates", CrashReportCategory.getCoordinateInfo(blockPos));
            crashReportCategory.addCrashSection("Event source", entityPlayer);
            crashReportCategory.addCrashSection("Event type", n);
            crashReportCategory.addCrashSection("Event data", n2);
            throw new ReportedException(crashReport);
        }
    }

    public int getHeight() {
        return 256;
    }

    public int getActualHeight() {
        return this.provider.getHasNoSky() ? 128 : 256;
    }

    public Random setRandomSeed(int n, int n2, int n3) {
        long l = (long)n * 341873128712L + (long)n2 * 132897987541L + this.getWorldInfo().getSeed() + (long)n3;
        this.rand.setSeed(l);
        return this.rand;
    }

    public BlockPos getStrongholdPos(String string, BlockPos blockPos) {
        return this.getChunkProvider().getStrongholdGen(this, string, blockPos);
    }

    @Override
    public boolean extendedLevelsInChunkCache() {
        return false;
    }

    public double getHorizon() {
        return this.worldInfo.getTerrainType() == WorldType.FLAT ? 0.0 : 63.0;
    }

    public CrashReportCategory addWorldInfoToCrashReport(CrashReport crashReport) {
        CrashReportCategory crashReportCategory = crashReport.makeCategoryDepth("Affected level", 1);
        crashReportCategory.addCrashSection("Level name", this.worldInfo == null ? "????" : this.worldInfo.getWorldName());
        crashReportCategory.addCrashSectionCallable("All players", new Callable<String>(){

            @Override
            public String call() {
                return World.this.playerEntities.size() + " total; " + World.this.playerEntities.toString();
            }
        });
        crashReportCategory.addCrashSectionCallable("Chunk stats", new Callable<String>(){

            @Override
            public String call() {
                return World.this.chunkProvider.makeString();
            }
        });
        try {
            this.worldInfo.addToCrashReport(crashReportCategory);
        }
        catch (Throwable throwable) {
            crashReportCategory.addCrashSectionThrowable("Level Data Unobtainable", throwable);
        }
        return crashReportCategory;
    }

    public void sendBlockBreakProgress(int n, BlockPos blockPos, int n2) {
        for (int i = 0; i < this.worldAccesses.size(); ++i) {
            IWorldAccess iWorldAccess = this.worldAccesses.get(i);
            iWorldAccess.sendBlockBreakProgress(n, blockPos, n2);
        }
    }

    public Calendar getCurrentDate() {
        if (this.getTotalWorldTime() % 600L == 0L) {
            this.theCalendar.setTimeInMillis(MinecraftServer.getCurrentTimeMillis());
        }
        return this.theCalendar;
    }

    public void makeFireworks(double d, double d2, double d3, double d4, double d5, double d6, NBTTagCompound nBTTagCompound) {
    }

    public Scoreboard getScoreboard() {
        return this.worldScoreboard;
    }

    public void updateComparatorOutputLevel(BlockPos blockPos, Block block) {
        for (EnumFacing enumFacing : EnumFacing.Plane.HORIZONTAL) {
            BlockPos blockPos2 = blockPos.offset(enumFacing);
            if (!this.isBlockLoaded(blockPos2)) continue;
            IBlockState iBlockState = this.getBlockState(blockPos2);
            if (Blocks.unpowered_comparator.isAssociated(iBlockState.getBlock())) {
                iBlockState.getBlock().onNeighborBlockChange(this, blockPos2, iBlockState, block);
                continue;
            }
            if (!iBlockState.getBlock().isNormalCube() || !Blocks.unpowered_comparator.isAssociated((iBlockState = this.getBlockState(blockPos2 = blockPos2.offset(enumFacing))).getBlock())) continue;
            iBlockState.getBlock().onNeighborBlockChange(this, blockPos2, iBlockState, block);
        }
    }

    public DifficultyInstance getDifficultyForLocation(BlockPos blockPos) {
        long l = 0L;
        float f = 0.0f;
        if (this.isBlockLoaded(blockPos)) {
            f = this.getCurrentMoonPhaseFactor();
            l = this.getChunkFromBlockCoords(blockPos).getInhabitedTime();
        }
        return new DifficultyInstance(this.getDifficulty(), this.getWorldTime(), l, f);
    }

    public EnumDifficulty getDifficulty() {
        return this.getWorldInfo().getDifficulty();
    }

    public int getSkylightSubtracted() {
        return this.skylightSubtracted;
    }

    public void setSkylightSubtracted(int n) {
        this.skylightSubtracted = n;
    }

    public int getLastLightningBolt() {
        return this.lastLightningBolt;
    }

    public void setLastLightningBolt(int n) {
        this.lastLightningBolt = n;
    }

    public boolean isFindingSpawnPoint() {
        return this.findingSpawnPoint;
    }

    public VillageCollection getVillageCollection() {
        return this.villageCollectionObj;
    }

    public WorldBorder getWorldBorder() {
        return this.worldBorder;
    }

    public boolean isSpawnChunk(int n, int n2) {
        BlockPos blockPos = this.getSpawnPoint();
        int n3 = n * 16 + 8 - blockPos.getX();
        int n4 = n2 * 16 + 8 - blockPos.getZ();
        int n5 = 128;
        return n3 >= -n5 && n3 <= n5 && n4 >= -n5 && n4 <= n5;
    }

    public void mimeow$setThunderStrength(occ52191e479 occ52191e4792) {
        if (oc9755810e45.\u0470 != null && oc9755810e45.\u0470.z$3rzb3dil7uydr() && oc9755810e45.\u0470.\u01ff.\u04c1() > 0.0) {
            occ52191e4792.\u04ea(Float.valueOf((float)oc9755810e45.\u0470.\u01ff.\u04c1()));
        }
    }

    public void mimeow$setPrecipitationStrength(occ52191e479 occ52191e4792) {
        if (oc9755810e45.\u0470 != null && oc9755810e45.\u0470.z$3rzb3dil7uydr() && oc9755810e45.\u0470.\u042e.\u01ed()) {
            occ52191e4792.\u04ea(Float.valueOf(1.0f));
        }
    }

    private long mimeow$redirect$setTimeForMoonPhase(WorldInfo worldInfo) {
        return oc9755810e45.\u0470 != null && oc9755810e45.\u0470.z$3rzb3dil7uydr() ? (long)MathHelper.clamp_double(oc9755810e45.\u0470.\u02a4.\u04c1() * 1000.0, 0.0, 23999.0) : worldInfo.getWorldTime();
    }
}

