/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBeach;
import net.minecraft.world.biome.BiomeGenDesert;
import net.minecraft.world.biome.BiomeGenEnd;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenHell;
import net.minecraft.world.biome.BiomeGenHills;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.biome.BiomeGenMesa;
import net.minecraft.world.biome.BiomeGenMushroomIsland;
import net.minecraft.world.biome.BiomeGenMutated;
import net.minecraft.world.biome.BiomeGenOcean;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenRiver;
import net.minecraft.world.biome.BiomeGenSavanna;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenStoneBeach;
import net.minecraft.world.biome.BiomeGenSwamp;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenDoublePlant;
import net.minecraft.world.gen.feature.WorldGenSwamp;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BiomeGenBase {
    private static final Logger logger = LogManager.getLogger();
    protected static final Height height_Default = new Height(0.1f, 0.2f);
    protected static final Height height_ShallowWaters = new Height(-0.5f, 0.0f);
    protected static final Height height_Oceans = new Height(-1.0f, 0.1f);
    protected static final Height height_DeepOceans = new Height(-1.8f, 0.1f);
    protected static final Height height_LowPlains = new Height(0.125f, 0.05f);
    protected static final Height height_MidPlains = new Height(0.2f, 0.2f);
    protected static final Height height_LowHills = new Height(0.45f, 0.3f);
    protected static final Height height_HighPlateaus = new Height(1.5f, 0.025f);
    protected static final Height height_MidHills = new Height(1.0f, 0.5f);
    protected static final Height height_Shores = new Height(0.0f, 0.025f);
    protected static final Height height_RockyWaters = new Height(0.1f, 0.8f);
    protected static final Height height_LowIslands = new Height(0.2f, 0.3f);
    protected static final Height height_PartiallySubmerged = new Height(-0.2f, 0.1f);
    private static final BiomeGenBase[] biomeList = new BiomeGenBase[256];
    public static final Set<BiomeGenBase> explorationBiomesList = Sets.newHashSet();
    public static final Map<String, BiomeGenBase> BIOME_ID_MAP = Maps.newHashMap();
    public static final BiomeGenBase ocean = new BiomeGenOcean(0).setColor(112).setBiomeName("Ocean").setHeight(height_Oceans);
    public static final BiomeGenBase plains = new BiomeGenPlains(1).setColor(9286496).setBiomeName("Plains");
    public static final BiomeGenBase desert = new BiomeGenDesert(2).setColor(16421912).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0f, 0.0f).setHeight(height_LowPlains);
    public static final BiomeGenBase extremeHills = new BiomeGenHills(3, false).setColor(0x606060).setBiomeName("Extreme Hills").setHeight(height_MidHills).setTemperatureRainfall(0.2f, 0.3f);
    public static final BiomeGenBase forest = new BiomeGenForest(4, 0).setColor(353825).setBiomeName("Forest");
    public static final BiomeGenBase taiga = new BiomeGenTaiga(5, 0).setColor(747097).setBiomeName("Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(height_MidPlains);
    public static final BiomeGenBase swampland = new BiomeGenSwamp(6).setColor(522674).setBiomeName("Swampland").setFillerBlockMetadata(9154376).setHeight(height_PartiallySubmerged).setTemperatureRainfall(0.8f, 0.9f);
    public static final BiomeGenBase river = new BiomeGenRiver(7).setColor(255).setBiomeName("River").setHeight(height_ShallowWaters);
    public static final BiomeGenBase hell = new BiomeGenHell(8).setColor(0xFF0000).setBiomeName("Hell").setDisableRain().setTemperatureRainfall(2.0f, 0.0f);
    public static final BiomeGenBase sky = new BiomeGenEnd(9).setColor(0x8080FF).setBiomeName("The End").setDisableRain();
    public static final BiomeGenBase frozenOcean = new BiomeGenOcean(10).setColor(0x9090A0).setBiomeName("FrozenOcean").setEnableSnow().setHeight(height_Oceans).setTemperatureRainfall(0.0f, 0.5f);
    public static final BiomeGenBase frozenRiver = new BiomeGenRiver(11).setColor(0xA0A0FF).setBiomeName("FrozenRiver").setEnableSnow().setHeight(height_ShallowWaters).setTemperatureRainfall(0.0f, 0.5f);
    public static final BiomeGenBase icePlains = new BiomeGenSnow(12, false).setColor(0xFFFFFF).setBiomeName("Ice Plains").setEnableSnow().setTemperatureRainfall(0.0f, 0.5f).setHeight(height_LowPlains);
    public static final BiomeGenBase iceMountains = new BiomeGenSnow(13, false).setColor(0xA0A0A0).setBiomeName("Ice Mountains").setEnableSnow().setHeight(height_LowHills).setTemperatureRainfall(0.0f, 0.5f);
    public static final BiomeGenBase mushroomIsland = new BiomeGenMushroomIsland(14).setColor(0xFF00FF).setBiomeName("MushroomIsland").setTemperatureRainfall(0.9f, 1.0f).setHeight(height_LowIslands);
    public static final BiomeGenBase mushroomIslandShore = new BiomeGenMushroomIsland(15).setColor(0xA000FF).setBiomeName("MushroomIslandShore").setTemperatureRainfall(0.9f, 1.0f).setHeight(height_Shores);
    public static final BiomeGenBase beach = new BiomeGenBeach(16).setColor(16440917).setBiomeName("Beach").setTemperatureRainfall(0.8f, 0.4f).setHeight(height_Shores);
    public static final BiomeGenBase desertHills = new BiomeGenDesert(17).setColor(13786898).setBiomeName("DesertHills").setDisableRain().setTemperatureRainfall(2.0f, 0.0f).setHeight(height_LowHills);
    public static final BiomeGenBase forestHills = new BiomeGenForest(18, 0).setColor(2250012).setBiomeName("ForestHills").setHeight(height_LowHills);
    public static final BiomeGenBase taigaHills = new BiomeGenTaiga(19, 0).setColor(1456435).setBiomeName("TaigaHills").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(height_LowHills);
    public static final BiomeGenBase extremeHillsEdge = new BiomeGenHills(20, true).setColor(7501978).setBiomeName("Extreme Hills Edge").setHeight(height_MidHills.attenuate()).setTemperatureRainfall(0.2f, 0.3f);
    public static final BiomeGenBase jungle = new BiomeGenJungle(21, false).setColor(5470985).setBiomeName("Jungle").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.9f);
    public static final BiomeGenBase jungleHills = new BiomeGenJungle(22, false).setColor(2900485).setBiomeName("JungleHills").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.9f).setHeight(height_LowHills);
    public static final BiomeGenBase jungleEdge = new BiomeGenJungle(23, true).setColor(6458135).setBiomeName("JungleEdge").setFillerBlockMetadata(5470985).setTemperatureRainfall(0.95f, 0.8f);
    public static final BiomeGenBase deepOcean = new BiomeGenOcean(24).setColor(48).setBiomeName("Deep Ocean").setHeight(height_DeepOceans);
    public static final BiomeGenBase stoneBeach = new BiomeGenStoneBeach(25).setColor(10658436).setBiomeName("Stone Beach").setTemperatureRainfall(0.2f, 0.3f).setHeight(height_RockyWaters);
    public static final BiomeGenBase coldBeach = new BiomeGenBeach(26).setColor(16445632).setBiomeName("Cold Beach").setTemperatureRainfall(0.05f, 0.3f).setHeight(height_Shores).setEnableSnow();
    public static final BiomeGenBase birchForest = new BiomeGenForest(27, 2).setBiomeName("Birch Forest").setColor(3175492);
    public static final BiomeGenBase birchForestHills = new BiomeGenForest(28, 2).setBiomeName("Birch Forest Hills").setColor(2055986).setHeight(height_LowHills);
    public static final BiomeGenBase roofedForest = new BiomeGenForest(29, 3).setColor(4215066).setBiomeName("Roofed Forest");
    public static final BiomeGenBase coldTaiga = new BiomeGenTaiga(30, 0).setColor(3233098).setBiomeName("Cold Taiga").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f).setHeight(height_MidPlains).func_150563_c(0xFFFFFF);
    public static final BiomeGenBase coldTaigaHills = new BiomeGenTaiga(31, 0).setColor(2375478).setBiomeName("Cold Taiga Hills").setFillerBlockMetadata(5159473).setEnableSnow().setTemperatureRainfall(-0.5f, 0.4f).setHeight(height_LowHills).func_150563_c(0xFFFFFF);
    public static final BiomeGenBase megaTaiga = new BiomeGenTaiga(32, 1).setColor(5858897).setBiomeName("Mega Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.3f, 0.8f).setHeight(height_MidPlains);
    public static final BiomeGenBase megaTaigaHills = new BiomeGenTaiga(33, 1).setColor(4542270).setBiomeName("Mega Taiga Hills").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.3f, 0.8f).setHeight(height_LowHills);
    public static final BiomeGenBase extremeHillsPlus = new BiomeGenHills(34, true).setColor(0x507050).setBiomeName("Extreme Hills+").setHeight(height_MidHills).setTemperatureRainfall(0.2f, 0.3f);
    public static final BiomeGenBase savanna = new BiomeGenSavanna(35).setColor(12431967).setBiomeName("Savanna").setTemperatureRainfall(1.2f, 0.0f).setDisableRain().setHeight(height_LowPlains);
    public static final BiomeGenBase savannaPlateau = new BiomeGenSavanna(36).setColor(10984804).setBiomeName("Savanna Plateau").setTemperatureRainfall(1.0f, 0.0f).setDisableRain().setHeight(height_HighPlateaus);
    public static final BiomeGenBase mesa = new BiomeGenMesa(37, false, false).setColor(14238997).setBiomeName("Mesa");
    public static final BiomeGenBase mesaPlateau_F = new BiomeGenMesa(38, false, true).setColor(11573093).setBiomeName("Mesa Plateau F").setHeight(height_HighPlateaus);
    public static final BiomeGenBase mesaPlateau = new BiomeGenMesa(39, false, false).setColor(13274213).setBiomeName("Mesa Plateau").setHeight(height_HighPlateaus);
    public static final BiomeGenBase field_180279_ad = ocean;
    protected static final NoiseGeneratorPerlin temperatureNoise;
    protected static final NoiseGeneratorPerlin GRASS_COLOR_NOISE;
    protected static final WorldGenDoublePlant DOUBLE_PLANT_GENERATOR;
    public String biomeName;
    public int color;
    public int field_150609_ah;
    public IBlockState topBlock = Blocks.grass.getDefaultState();
    public IBlockState fillerBlock = Blocks.dirt.getDefaultState();
    public int fillerBlockMetadata = 5169201;
    public float minHeight;
    public float maxHeight;
    public float temperature;
    public float rainfall;
    public int waterColorMultiplier;
    public BiomeDecorator theBiomeDecorator;
    protected List<SpawnListEntry> spawnableMonsterList;
    protected List<SpawnListEntry> spawnableCreatureList;
    protected List<SpawnListEntry> spawnableWaterCreatureList;
    protected List<SpawnListEntry> spawnableCaveCreatureList;
    protected boolean enableSnow;
    protected boolean enableRain;
    public final int biomeID;
    protected WorldGenTrees worldGeneratorTrees;
    protected WorldGenBigTree worldGeneratorBigTree;
    protected WorldGenSwamp worldGeneratorSwamp;

    protected BiomeGenBase(int n) {
        this.minHeight = BiomeGenBase.height_Default.rootHeight;
        this.maxHeight = BiomeGenBase.height_Default.variation;
        this.temperature = 0.5f;
        this.rainfall = 0.5f;
        this.waterColorMultiplier = 0xFFFFFF;
        this.spawnableMonsterList = Lists.newArrayList();
        this.spawnableCreatureList = Lists.newArrayList();
        this.spawnableWaterCreatureList = Lists.newArrayList();
        this.spawnableCaveCreatureList = Lists.newArrayList();
        this.enableRain = true;
        this.worldGeneratorTrees = new WorldGenTrees(false);
        this.worldGeneratorBigTree = new WorldGenBigTree(false);
        this.worldGeneratorSwamp = new WorldGenSwamp();
        this.biomeID = n;
        BiomeGenBase.biomeList[n] = this;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityRabbit.class, 10, 3, 3));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 100, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 10, 1, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityWitch.class, 5, 1, 1));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
        this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
    }

    protected BiomeDecorator createBiomeDecorator() {
        return new BiomeDecorator();
    }

    protected BiomeGenBase setTemperatureRainfall(float f, float f2) {
        if (f > 0.1f && f < 0.2f) {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        this.temperature = f;
        this.rainfall = f2;
        return this;
    }

    protected final BiomeGenBase setHeight(Height height) {
        this.minHeight = height.rootHeight;
        this.maxHeight = height.variation;
        return this;
    }

    protected BiomeGenBase setDisableRain() {
        this.enableRain = false;
        return this;
    }

    public WorldGenAbstractTree genBigTreeChance(Random random) {
        return random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees;
    }

    public WorldGenerator getRandomWorldGenForGrass(Random random) {
        return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }

    public BlockFlower.EnumFlowerType pickRandomFlower(Random random, BlockPos blockPos) {
        return random.nextInt(3) > 0 ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
    }

    protected BiomeGenBase setEnableSnow() {
        this.enableSnow = true;
        return this;
    }

    protected BiomeGenBase setBiomeName(String string) {
        this.biomeName = string;
        return this;
    }

    protected BiomeGenBase setFillerBlockMetadata(int n) {
        this.fillerBlockMetadata = n;
        return this;
    }

    protected BiomeGenBase setColor(int n) {
        this.func_150557_a(n, false);
        return this;
    }

    protected BiomeGenBase func_150563_c(int n) {
        this.field_150609_ah = n;
        return this;
    }

    protected BiomeGenBase func_150557_a(int n, boolean bl) {
        this.color = n;
        this.field_150609_ah = bl ? (n & 0xFEFEFE) >> 1 : n;
        return this;
    }

    public int getSkyColorByTemp(float f) {
        f /= 3.0f;
        f = MathHelper.clamp_float(f, -1.0f, 1.0f);
        return MathHelper.hsvToRGB(0.62222224f - f * 0.05f, 0.5f + f * 0.1f, 1.0f);
    }

    public List<SpawnListEntry> getSpawnableList(EnumCreatureType enumCreatureType) {
        switch (enumCreatureType) {
            case MONSTER: {
                return this.spawnableMonsterList;
            }
            case CREATURE: {
                return this.spawnableCreatureList;
            }
            case WATER_CREATURE: {
                return this.spawnableWaterCreatureList;
            }
            case AMBIENT: {
                return this.spawnableCaveCreatureList;
            }
        }
        return Collections.emptyList();
    }

    public boolean getEnableSnow() {
        return this.isSnowyBiome();
    }

    public boolean canRain() {
        return this.isSnowyBiome() ? false : this.enableRain;
    }

    public boolean isHighHumidity() {
        return this.rainfall > 0.85f;
    }

    public float getSpawningChance() {
        return 0.1f;
    }

    public final int getIntRainfall() {
        return (int)(this.rainfall * 65536.0f);
    }

    public final float getFloatRainfall() {
        return this.rainfall;
    }

    public final float getFloatTemperature(BlockPos blockPos) {
        if (blockPos.getY() > 64) {
            float f = (float)(temperatureNoise.func_151601_a((double)blockPos.getX() * 1.0 / 8.0, (double)blockPos.getZ() * 1.0 / 8.0) * 4.0);
            return this.temperature - (f + (float)blockPos.getY() - 64.0f) * 0.05f / 30.0f;
        }
        return this.temperature;
    }

    public void decorate(World world2, Random random, BlockPos blockPos) {
        this.theBiomeDecorator.decorate(world2, random, this, blockPos);
    }

    public int getGrassColorAtPos(BlockPos blockPos) {
        double d = MathHelper.clamp_float(this.getFloatTemperature(blockPos), 0.0f, 1.0f);
        double d2 = MathHelper.clamp_float(this.getFloatRainfall(), 0.0f, 1.0f);
        return ColorizerGrass.getGrassColor(d, d2);
    }

    public int getFoliageColorAtPos(BlockPos blockPos) {
        double d = MathHelper.clamp_float(this.getFloatTemperature(blockPos), 0.0f, 1.0f);
        double d2 = MathHelper.clamp_float(this.getFloatRainfall(), 0.0f, 1.0f);
        return ColorizerFoliage.getFoliageColor(d, d2);
    }

    public boolean isSnowyBiome() {
        return this.enableSnow;
    }

    public void genTerrainBlocks(World world2, Random random, ChunkPrimer chunkPrimer, int n, int n2, double d) {
        this.generateBiomeTerrain(world2, random, chunkPrimer, n, n2, d);
    }

    public final void generateBiomeTerrain(World world2, Random random, ChunkPrimer chunkPrimer, int n, int n2, double d) {
        int n3 = world2.getSeaLevel();
        IBlockState iBlockState = this.topBlock;
        IBlockState iBlockState2 = this.fillerBlock;
        int n4 = -1;
        int n5 = (int)(d / 3.0 + 3.0 + random.nextDouble() * 0.25);
        int n6 = n & 0xF;
        int n7 = n2 & 0xF;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        for (int i = 255; i >= 0; --i) {
            if (i <= random.nextInt(5)) {
                chunkPrimer.setBlockState(n7, i, n6, Blocks.bedrock.getDefaultState());
                continue;
            }
            IBlockState iBlockState3 = chunkPrimer.getBlockState(n7, i, n6);
            if (iBlockState3.getBlock().getMaterial() == Material.air) {
                n4 = -1;
                continue;
            }
            if (iBlockState3.getBlock() != Blocks.stone) continue;
            if (n4 == -1) {
                if (n5 <= 0) {
                    iBlockState = null;
                    iBlockState2 = Blocks.stone.getDefaultState();
                } else if (i >= n3 - 4 && i <= n3 + 1) {
                    iBlockState = this.topBlock;
                    iBlockState2 = this.fillerBlock;
                }
                if (i < n3 && (iBlockState == null || iBlockState.getBlock().getMaterial() == Material.air)) {
                    iBlockState = this.getFloatTemperature(mutableBlockPos.set(n, i, n2)) < 0.15f ? Blocks.ice.getDefaultState() : Blocks.water.getDefaultState();
                }
                n4 = n5;
                if (i >= n3 - 1) {
                    chunkPrimer.setBlockState(n7, i, n6, iBlockState);
                    continue;
                }
                if (i < n3 - 7 - n5) {
                    iBlockState = null;
                    iBlockState2 = Blocks.stone.getDefaultState();
                    chunkPrimer.setBlockState(n7, i, n6, Blocks.gravel.getDefaultState());
                    continue;
                }
                chunkPrimer.setBlockState(n7, i, n6, iBlockState2);
                continue;
            }
            if (n4 <= 0) continue;
            chunkPrimer.setBlockState(n7, i, n6, iBlockState2);
            if (--n4 != 0 || iBlockState2.getBlock() != Blocks.sand) continue;
            n4 = random.nextInt(4) + Math.max(0, i - 63);
            iBlockState2 = iBlockState2.getValue(BlockSand.VARIANT) == BlockSand.EnumType.RED_SAND ? Blocks.red_sandstone.getDefaultState() : Blocks.sandstone.getDefaultState();
        }
    }

    protected BiomeGenBase createMutation() {
        return this.createMutatedBiome(this.biomeID + 128);
    }

    protected BiomeGenBase createMutatedBiome(int n) {
        return new BiomeGenMutated(n, this);
    }

    public Class<? extends BiomeGenBase> getBiomeClass() {
        return this.getClass();
    }

    public boolean isEqualTo(BiomeGenBase biomeGenBase) {
        return biomeGenBase == this ? true : (biomeGenBase == null ? false : this.getBiomeClass() == biomeGenBase.getBiomeClass());
    }

    public TempCategory getTempCategory() {
        return (double)this.temperature < 0.2 ? TempCategory.COLD : ((double)this.temperature < 1.0 ? TempCategory.MEDIUM : TempCategory.WARM);
    }

    public static BiomeGenBase[] getBiomeGenArray() {
        return biomeList;
    }

    public static BiomeGenBase getBiome(int n) {
        return BiomeGenBase.getBiomeFromBiomeList(n, null);
    }

    public static BiomeGenBase getBiomeFromBiomeList(int n, BiomeGenBase biomeGenBase) {
        if (n >= 0 && n <= biomeList.length) {
            BiomeGenBase biomeGenBase2 = biomeList[n];
            return biomeGenBase2 == null ? biomeGenBase : biomeGenBase2;
        }
        logger.warn("Biome ID is out of bounds: " + n + ", defaulting to 0 (Ocean)");
        return ocean;
    }

    static {
        plains.createMutation();
        desert.createMutation();
        forest.createMutation();
        taiga.createMutation();
        swampland.createMutation();
        icePlains.createMutation();
        jungle.createMutation();
        jungleEdge.createMutation();
        coldTaiga.createMutation();
        savanna.createMutation();
        savannaPlateau.createMutation();
        mesa.createMutation();
        mesaPlateau_F.createMutation();
        mesaPlateau.createMutation();
        birchForest.createMutation();
        birchForestHills.createMutation();
        roofedForest.createMutation();
        megaTaiga.createMutation();
        extremeHills.createMutation();
        extremeHillsPlus.createMutation();
        megaTaiga.createMutatedBiome(BiomeGenBase.megaTaigaHills.biomeID + 128).setBiomeName("Redwood Taiga Hills M");
        for (BiomeGenBase biomeGenBase : biomeList) {
            if (biomeGenBase == null) continue;
            if (BIOME_ID_MAP.containsKey(biomeGenBase.biomeName)) {
                throw new Error("Biome \"" + biomeGenBase.biomeName + "\" is defined as both ID " + BiomeGenBase.BIOME_ID_MAP.get((Object)biomeGenBase.biomeName).biomeID + " and " + biomeGenBase.biomeID);
            }
            BIOME_ID_MAP.put(biomeGenBase.biomeName, biomeGenBase);
            if (biomeGenBase.biomeID >= 128) continue;
            explorationBiomesList.add(biomeGenBase);
        }
        explorationBiomesList.remove(hell);
        explorationBiomesList.remove(sky);
        explorationBiomesList.remove(frozenOcean);
        explorationBiomesList.remove(extremeHillsEdge);
        temperatureNoise = new NoiseGeneratorPerlin(new Random(1234L), 1);
        GRASS_COLOR_NOISE = new NoiseGeneratorPerlin(new Random(2345L), 1);
        DOUBLE_PLANT_GENERATOR = new WorldGenDoublePlant();
    }

    public static class Height {
        public float rootHeight;
        public float variation;

        public Height(float f, float f2) {
            this.rootHeight = f;
            this.variation = f2;
        }

        public Height attenuate() {
            return new Height(this.rootHeight * 0.8f, this.variation * 0.6f);
        }
    }

    public static class SpawnListEntry
    extends WeightedRandom.Item {
        public Class<? extends EntityLiving> entityClass;
        public int minGroupCount;
        public int maxGroupCount;

        public SpawnListEntry(Class<? extends EntityLiving> clazz, int n, int n2, int n3) {
            super(n);
            this.entityClass = clazz;
            this.minGroupCount = n2;
            this.maxGroupCount = n3;
        }

        public String toString() {
            return this.entityClass.getSimpleName() + "*(" + this.minGroupCount + "-" + this.maxGroupCount + "):" + this.itemWeight;
        }
    }

    public static enum TempCategory {
        OCEAN,
        COLD,
        MEDIUM,
        WARM;

    }
}

