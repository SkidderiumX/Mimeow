/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.Vec3i;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.FlatLayerInfo;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraft.world.gen.structure.StructureOceanMonument;

public class ChunkProviderFlat
implements IChunkProvider {
    private World worldObj;
    private Random random;
    private final IBlockState[] cachedBlockIDs = new IBlockState[256];
    private final FlatGeneratorInfo flatWorldGenInfo;
    private final List<MapGenStructure> structureGenerators = Lists.newArrayList();
    private final boolean hasDecoration;
    private final boolean hasDungeons;
    private WorldGenLakes waterLakeGenerator;
    private WorldGenLakes lavaLakeGenerator;

    public ChunkProviderFlat(World world2, long l, boolean bl, String string) {
        this.worldObj = world2;
        this.random = new Random(l);
        this.flatWorldGenInfo = FlatGeneratorInfo.createFlatGeneratorFromString(string);
        if (bl) {
            Map<String, Map<String, String>> map = this.flatWorldGenInfo.getWorldFeatures();
            if (map.containsKey("village")) {
                Map<String, String> map2 = map.get("village");
                if (!map2.containsKey("size")) {
                    map2.put("size", "1");
                }
                this.structureGenerators.add(new MapGenVillage(map2));
            }
            if (map.containsKey("biome_1")) {
                this.structureGenerators.add(new MapGenScatteredFeature(map.get("biome_1")));
            }
            if (map.containsKey("mineshaft")) {
                this.structureGenerators.add(new MapGenMineshaft(map.get("mineshaft")));
            }
            if (map.containsKey("stronghold")) {
                this.structureGenerators.add(new MapGenStronghold(map.get("stronghold")));
            }
            if (map.containsKey("oceanmonument")) {
                this.structureGenerators.add(new StructureOceanMonument(map.get("oceanmonument")));
            }
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lake")) {
            this.waterLakeGenerator = new WorldGenLakes(Blocks.water);
        }
        if (this.flatWorldGenInfo.getWorldFeatures().containsKey("lava_lake")) {
            this.lavaLakeGenerator = new WorldGenLakes(Blocks.lava);
        }
        this.hasDungeons = this.flatWorldGenInfo.getWorldFeatures().containsKey("dungeon");
        int n = 0;
        int n2 = 0;
        boolean bl2 = true;
        for (FlatLayerInfo flatLayerInfo : this.flatWorldGenInfo.getFlatLayers()) {
            for (int i = flatLayerInfo.getMinY(); i < flatLayerInfo.getMinY() + flatLayerInfo.getLayerCount(); ++i) {
                IBlockState iBlockState = flatLayerInfo.getLayerMaterial();
                if (iBlockState.getBlock() == Blocks.air) continue;
                bl2 = false;
                this.cachedBlockIDs[i] = iBlockState;
            }
            if (flatLayerInfo.getLayerMaterial().getBlock() == Blocks.air) {
                n2 += flatLayerInfo.getLayerCount();
                continue;
            }
            n += flatLayerInfo.getLayerCount() + n2;
            n2 = 0;
        }
        world2.setSeaLevel(n);
        this.hasDecoration = bl2 ? false : this.flatWorldGenInfo.getWorldFeatures().containsKey("decoration");
    }

    @Override
    public Chunk provideChunk(int n, int n2) {
        int n3;
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        for (int i = 0; i < this.cachedBlockIDs.length; ++i) {
            IBlockState object2 = this.cachedBlockIDs[i];
            if (object2 == null) continue;
            for (int j = 0; j < 16; ++j) {
                for (n3 = 0; n3 < 16; ++n3) {
                    chunkPrimer.setBlockState(j, i, n3, object2);
                }
            }
        }
        for (MapGenBase mapGenBase : this.structureGenerators) {
            mapGenBase.generate(this, this.worldObj, n, n2, chunkPrimer);
        }
        Chunk chunk = new Chunk(this.worldObj, chunkPrimer, n, n2);
        BiomeGenBase[] biomeGenBaseArray = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(null, n * 16, n2 * 16, 16, 16);
        byte[] byArray = chunk.getBiomeArray();
        for (n3 = 0; n3 < byArray.length; ++n3) {
            byArray[n3] = (byte)biomeGenBaseArray[n3].biomeID;
        }
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public boolean chunkExists(int n, int n2) {
        return true;
    }

    @Override
    public void populate(IChunkProvider iChunkProvider, int n, int n2) {
        int n3 = n * 16;
        int n4 = n2 * 16;
        BlockPos blockPos = new BlockPos(n3, 0, n4);
        BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(new BlockPos(n3 + 16, 0, n4 + 16));
        boolean bl = false;
        this.random.setSeed(this.worldObj.getSeed());
        long l = this.random.nextLong() / 2L * 2L + 1L;
        long l2 = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed((long)n * l + (long)n2 * l2 ^ this.worldObj.getSeed());
        ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(n, n2);
        Object object = this.structureGenerators.iterator();
        while (object.hasNext()) {
            MapGenStructure mapGenStructure = object.next();
            boolean bl2 = mapGenStructure.generateStructure(this.worldObj, this.random, chunkCoordIntPair);
            if (!(mapGenStructure instanceof MapGenVillage)) continue;
            bl |= bl2;
        }
        if (this.waterLakeGenerator != null && !bl && this.random.nextInt(4) == 0) {
            this.waterLakeGenerator.generate(this.worldObj, this.random, blockPos.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
        }
        if (!(this.lavaLakeGenerator == null || bl || this.random.nextInt(8) != 0 || ((Vec3i)(object = blockPos.add(this.random.nextInt(16) + 8, this.random.nextInt(this.random.nextInt(248) + 8), this.random.nextInt(16) + 8))).getY() >= this.worldObj.getSeaLevel() && this.random.nextInt(10) != 0)) {
            this.lavaLakeGenerator.generate(this.worldObj, this.random, (BlockPos)object);
        }
        if (this.hasDungeons) {
            for (int i = 0; i < 8; ++i) {
                new WorldGenDungeons().generate(this.worldObj, this.random, blockPos.add(this.random.nextInt(16) + 8, this.random.nextInt(256), this.random.nextInt(16) + 8));
            }
        }
        if (this.hasDecoration) {
            biomeGenBase.decorate(this.worldObj, this.random, blockPos);
        }
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
        return "FlatLevelSource";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType enumCreatureType, BlockPos blockPos) {
        BiomeGenBase biomeGenBase = this.worldObj.getBiomeGenForCoords(blockPos);
        return biomeGenBase.getSpawnableList(enumCreatureType);
    }

    @Override
    public BlockPos getStrongholdGen(World world2, String string, BlockPos blockPos) {
        if ("Stronghold".equals(string)) {
            for (MapGenStructure mapGenStructure : this.structureGenerators) {
                if (!(mapGenStructure instanceof MapGenStronghold)) continue;
                return mapGenStructure.getClosestStrongholdPos(world2, blockPos);
            }
        }
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(Chunk chunk, int n, int n2) {
        for (MapGenStructure mapGenStructure : this.structureGenerators) {
            mapGenStructure.generate(this, this.worldObj, n, n2, null);
        }
    }

    @Override
    public Chunk provideChunk(BlockPos blockPos) {
        return this.provideChunk(blockPos.getX() >> 4, blockPos.getZ() >> 4);
    }
}

