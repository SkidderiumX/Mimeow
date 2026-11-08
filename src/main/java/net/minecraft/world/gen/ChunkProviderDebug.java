/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

public class ChunkProviderDebug
implements IChunkProvider {
    private static final List<IBlockState> field_177464_a = Lists.newArrayList();
    private static final int field_177462_b;
    private static final int field_181039_c;
    private final World world;

    public ChunkProviderDebug(World world2) {
        this.world = world2;
    }

    @Override
    public Chunk provideChunk(int n, int n2) {
        int n3;
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int n4 = n * 16 + i;
                n3 = n2 * 16 + j;
                chunkPrimer.setBlockState(i, 60, j, Blocks.barrier.getDefaultState());
                IBlockState iBlockState = ChunkProviderDebug.func_177461_b(n4, n3);
                if (iBlockState == null) continue;
                chunkPrimer.setBlockState(i, 70, j, iBlockState);
            }
        }
        Chunk chunk = new Chunk(this.world, chunkPrimer, n, n2);
        chunk.generateSkylightMap();
        BiomeGenBase[] biomeGenBaseArray = this.world.getWorldChunkManager().loadBlockGeneratorData(null, n * 16, n2 * 16, 16, 16);
        byte[] byArray = chunk.getBiomeArray();
        for (n3 = 0; n3 < byArray.length; ++n3) {
            byArray[n3] = (byte)biomeGenBaseArray[n3].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    public static IBlockState func_177461_b(int n, int n2) {
        int n3;
        IBlockState iBlockState = null;
        if (n > 0 && n2 > 0 && n % 2 != 0 && n2 % 2 != 0 && (n /= 2) <= field_177462_b && (n2 /= 2) <= field_181039_c && (n3 = MathHelper.abs_int(n * field_177462_b + n2)) < field_177464_a.size()) {
            iBlockState = field_177464_a.get(n3);
        }
        return iBlockState;
    }

    @Override
    public boolean chunkExists(int n, int n2) {
        return true;
    }

    @Override
    public void populate(IChunkProvider iChunkProvider, int n, int n2) {
    }

    @Override
    public boolean populateChunk(IChunkProvider iChunkProvider, Chunk chunk, int n, int n2) {
        return false;
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
        return false;
    }

    @Override
    public boolean canSave() {
        return true;
    }

    @Override
    public String makeString() {
        return "DebugLevelSource";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        BiomeGenBase biomeGenBase = this.world.getBiomeGenForCoords(blockPos);
        return biomeGenBase.getSpawnableList(enumCreatureType);
    }

    @Override
    public BlockPos getStrongholdGen(World world2, String string, BlockPos blockPos) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(Chunk chunk, int n, int n2) {
    }

    @Override
    public Chunk provideChunk(BlockPos blockPos) {
        return this.provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }

    static {
        for (Block block : Block.blockRegistry) {
            field_177464_a.addAll(block.getBlockState().getValidStates());
        }
        field_177462_b = MathHelper.ceiling_float_int(MathHelper.sqrt_float(field_177464_a.size()));
        field_181039_c = MathHelper.ceiling_float_int((float)field_177464_a.size() / (float)field_177462_b);
    }
}

