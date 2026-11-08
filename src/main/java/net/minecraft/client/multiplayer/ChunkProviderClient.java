/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.LongHashMap;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkProviderClient
implements IChunkProvider {
    private static final Logger logger = LogManager.getLogger();
    private Chunk blankChunk;
    private LongHashMap<Chunk> chunkMapping = new LongHashMap();
    private List<Chunk> chunkListing = Lists.newArrayList();
    private World worldObj;

    public ChunkProviderClient(World world2) {
        this.blankChunk = new EmptyChunk(world2, 0, 0);
        this.worldObj = world2;
    }

    @Override
    public boolean chunkExists(int n, int n2) {
        return true;
    }

    public void unloadChunk(int n, int n2) {
        Chunk chunk = this.provideChunk(n, n2);
        if (!chunk.isEmpty()) {
            chunk.onChunkUnload();
        }
        this.chunkMapping.remove(ChunkCoordIntPair.chunkXZ2Int(n, n2));
        this.chunkListing.remove(chunk);
    }

    public Chunk loadChunk(int n, int n2) {
        Chunk chunk = new Chunk(this.worldObj, n, n2);
        this.chunkMapping.add(ChunkCoordIntPair.chunkXZ2Int(n, n2), chunk);
        this.chunkListing.add(chunk);
        chunk.setChunkLoaded(true);
        return chunk;
    }

    @Override
    public Chunk provideChunk(int n, int n2) {
        Chunk chunk = this.chunkMapping.getValueByKey(ChunkCoordIntPair.chunkXZ2Int(n, n2));
        return chunk == null ? this.blankChunk : chunk;
    }

    @Override
    public boolean saveChunks(boolean bl, IProgressUpdate iProgressUpdate) {
        return true;
    }

    @Override
    public void saveExtraData() {
    }

    @Override
    public boolean unloadQueuedChunks() {
        long l = System.currentTimeMillis();
        for (Chunk chunk : this.chunkListing) {
            chunk.func_150804_b(System.currentTimeMillis() - l > 5L);
        }
        if (System.currentTimeMillis() - l > 100L) {
            logger.info("Warning: Clientside chunk ticking took {} ms", System.currentTimeMillis() - l);
        }
        return false;
    }

    @Override
    public boolean canSave() {
        return false;
    }

    @Override
    public void populate(IChunkProvider iChunkProvider, int n, int n2) {
    }

    @Override
    public boolean populateChunk(IChunkProvider iChunkProvider, Chunk chunk, int n, int n2) {
        return false;
    }

    @Override
    public String makeString() {
        return "MultiplayerChunkCache: " + this.chunkMapping.getNumHashElements() + ", " + this.chunkListing.size();
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        return null;
    }

    @Override
    public BlockPos getStrongholdGen(World world2, String string, BlockPos blockPos) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return this.chunkListing.size();
    }

    @Override
    public void recreateStructures(Chunk chunk, int n, int n2) {
    }

    @Override
    public Chunk provideChunk(BlockPos blockPos) {
        return this.provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }
}

