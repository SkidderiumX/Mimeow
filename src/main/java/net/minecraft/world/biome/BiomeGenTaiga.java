/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.biome;

import java.util.Random;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenTaiga
extends BiomeGenBase {
    private static final WorldGenTaiga1 field_150639_aC = new WorldGenTaiga1();
    private static final WorldGenTaiga2 field_150640_aD = new WorldGenTaiga2(false);
    private static final WorldGenMegaPineTree field_150641_aE = new WorldGenMegaPineTree(false, false);
    private static final WorldGenMegaPineTree field_150642_aF = new WorldGenMegaPineTree(false, true);
    private static final WorldGenBlockBlob field_150643_aG = new WorldGenBlockBlob(Blocks.mossy_cobblestone, 0);
    private int field_150644_aH;

    public BiomeGenTaiga(int n, int n2) {
        super(n);
        this.field_150644_aH = n2;
        this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWolf.class, 8, 4, 4));
        this.theBiomeDecorator.treesPerChunk = 10;
        if (n2 != 1 && n2 != 2) {
            this.theBiomeDecorator.grassPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 1;
        } else {
            this.theBiomeDecorator.grassPerChunk = 7;
            this.theBiomeDecorator.deadBushPerChunk = 1;
            this.theBiomeDecorator.mushroomsPerChunk = 3;
        }
    }

    @Override
    public WorldGenAbstractTree genBigTreeChance(Random random) {
        return (this.field_150644_aH == 1 || this.field_150644_aH == 2) && random.nextInt(3) == 0 ? (this.field_150644_aH != 2 && random.nextInt(13) != 0 ? field_150641_aE : field_150642_aF) : (random.nextInt(3) == 0 ? field_150639_aC : field_150640_aD);
    }

    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random random) {
        return random.nextInt(5) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }

    @Override
    public void decorate(World world2, Random random, BlockPos blockPos) {
        int n;
        int n2;
        int n3;
        int n4;
        if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
            n4 = random.nextInt(3);
            for (n3 = 0; n3 < n4; ++n3) {
                n2 = random.nextInt(16) + 8;
                n = random.nextInt(16) + 8;
                BlockPos blockPos2 = world2.getHeight(blockPos.add(n2, 0, n));
                field_150643_aG.generate(world2, random, blockPos2);
            }
        }
        DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);
        for (n4 = 0; n4 < 7; ++n4) {
            n3 = random.nextInt(16) + 8;
            n2 = random.nextInt(16) + 8;
            n = random.nextInt(world2.getHeight(blockPos.add(n3, 0, n2)).getY() + 32);
            DOUBLE_PLANT_GENERATOR.generate(world2, random, blockPos.add(n3, n, n2));
        }
        super.decorate(world2, random, blockPos);
    }

    @Override
    public void genTerrainBlocks(World world2, Random random, ChunkPrimer chunkPrimer, int n, int n2, double d) {
        if (this.field_150644_aH == 1 || this.field_150644_aH == 2) {
            this.topBlock = Blocks.grass.getDefaultState();
            this.fillerBlock = Blocks.dirt.getDefaultState();
            if (d > 1.75) {
                this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            } else if (d > -0.95) {
                this.topBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }
        }
        this.generateBiomeTerrain(world2, random, chunkPrimer, n, n2, d);
    }

    @Override
    protected BiomeGenBase createMutatedBiome(int n) {
        return this.biomeID == BiomeGenBase.megaTaiga.biomeID ? new BiomeGenTaiga(n, 2).func_150557_a(5858897, true).setBiomeName("Mega Spruce Taiga").setFillerBlockMetadata(5159473).setTemperatureRainfall(0.25f, 0.8f).setHeight(new BiomeGenBase.Height(this.minHeight, this.maxHeight)) : super.createMutatedBiome(n);
    }
}

