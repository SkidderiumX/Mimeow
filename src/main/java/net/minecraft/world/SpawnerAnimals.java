/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3i;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.optifine.BlockPosM;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;

public class SpawnerAnimals {
    private static final int MOB_COUNT_DIV = (int)Math.pow(17.0, 2.0);
    private final Set<ChunkCoordIntPair> eligibleChunksForSpawning = Sets.newHashSet();
    private Map<Class, EntityLiving> mapSampleEntitiesByClass = new HashMap<Class, EntityLiving>();
    private int lastPlayerChunkX = Integer.MAX_VALUE;
    private int lastPlayerChunkZ = Integer.MAX_VALUE;
    private int countChunkPos;

    public int findChunksForSpawning(WorldServer worldServer, boolean bl, boolean bl2, boolean bl3) {
        Object object;
        int n;
        int n2;
        Object object22;
        int n3;
        if (!bl && !bl2) {
            return 0;
        }
        boolean bl4 = true;
        EntityPlayer entityPlayer = null;
        if (worldServer.playerEntities.size() == 1) {
            entityPlayer = (EntityPlayer)worldServer.playerEntities.get(0);
            if (this.eligibleChunksForSpawning.size() > 0 && entityPlayer != null && entityPlayer.chunkCoordX == this.lastPlayerChunkX && entityPlayer.chunkCoordZ == this.lastPlayerChunkZ) {
                bl4 = false;
            }
        }
        if (bl4) {
            this.eligibleChunksForSpawning.clear();
            n3 = 0;
            for (Object object22_r : worldServer.playerEntities) {
                if (((EntityPlayer)object22_r).isSpectator()) continue;
                int n4 = MathHelper.floor_double(((EntityPlayer)object22_r).posX / 16.0);
                int n5 = MathHelper.floor_double(((EntityPlayer)object22_r).posZ / 16.0);
                int n6 = 8;
                for (int i = -n6; i <= n6; ++i) {
                    for (n2 = -n6; n2 <= n6; ++n2) {
                        n = i == -n6 || i == n6 || n2 == -n6 || n2 == n6 ? 1 : 0;
                        object = new ChunkCoordIntPair(i + n4, n2 + n5);
                        if (this.eligibleChunksForSpawning.contains(object)) continue;
                        ++n3;
                        if (n != 0 || !worldServer.getWorldBorder().contains((ChunkCoordIntPair)object)) continue;
                        this.eligibleChunksForSpawning.add((ChunkCoordIntPair)object);
                    }
                }
            }
            this.countChunkPos = n3;
            if (entityPlayer != null) {
                this.lastPlayerChunkX = entityPlayer.chunkCoordX;
                this.lastPlayerChunkZ = entityPlayer.chunkCoordZ;
            }
        }
        n3 = 0;
        BlockPos blockPos = worldServer.getSpawnPoint();
        object22 = new BlockPosM(0, 0, 0);
        new BlockPos.MutableBlockPos();
        for (EnumCreatureType enumCreatureType : EnumCreatureType.values()) {
            Object object3;
            if (enumCreatureType.getPeacefulCreature() && !bl2 || !enumCreatureType.getPeacefulCreature() && !bl || enumCreatureType.getAnimal() && !bl3 || (n2 = Reflector.CompatWorld_countEntities.exists() ? Reflector.callInt(worldServer, Reflector.CompatWorld_countEntities, new Object[]{enumCreatureType, true}) : worldServer.countEntities(enumCreatureType.getCreatureClass())) > (n = enumCreatureType.getMaxNumberOfCreature() * this.countChunkPos / MOB_COUNT_DIV)) continue;
            object = this.eligibleChunksForSpawning;
            if (Reflector.CompatHooksClient.exists()) {
                object3 = Lists.newArrayList(object);
                Collections.shuffle(object3);
                object = object3;
            }
            object3 = object.iterator();
            block6: while (object3.hasNext()) {
                ChunkCoordIntPair chunkCoordIntPair = (ChunkCoordIntPair)object3.next();
                BlockPosM blockPosM = SpawnerAnimals.getRandomChunkPosition(worldServer, chunkCoordIntPair.chunkXPos, chunkCoordIntPair.chunkZPos, (BlockPosM)object22);
                int n7 = ((Vec3i)blockPosM).getX();
                int n8 = ((Vec3i)blockPosM).getY();
                int n9 = ((Vec3i)blockPosM).getZ();
                Block block = worldServer.getBlockState(blockPosM).getBlock();
                if (block.isNormalCube()) continue;
                int n10 = 0;
                block7: for (int i = 0; i < 3; ++i) {
                    int n11 = n7;
                    int n12 = n8;
                    int n13 = n9;
                    int n14 = 6;
                    BiomeGenBase.SpawnListEntry spawnListEntry = null;
                    IEntityLivingData iEntityLivingData = null;
                    for (int j = 0; j < 4; ++j) {
                        boolean bl5;
                        EntityLiving entityLiving;
                        BlockPos blockPos2 = new BlockPos(n11 += worldServer.rand.nextInt(n14) - worldServer.rand.nextInt(n14), n12 += worldServer.rand.nextInt(1) - worldServer.rand.nextInt(1), n13 += worldServer.rand.nextInt(n14) - worldServer.rand.nextInt(n14));
                        float f = (float)n11 + 0.5f;
                        float f2 = (float)n13 + 0.5f;
                        if (worldServer.isAnyPlayerWithinRangeAt(f, n12, f2, 24.0) || !(blockPos.distanceSq(f, n12, f2) >= 576.0)) continue;
                        if (spawnListEntry == null && (spawnListEntry = worldServer.getSpawnListEntryForTypeAt(enumCreatureType, blockPos2)) == null) continue block7;
                        if (!worldServer.canCreatureTypeSpawnHere(enumCreatureType, spawnListEntry, blockPos2) || !SpawnerAnimals.canCreatureTypeSpawnAtLocation(EntitySpawnPlacementRegistry.getPlacementForEntity(spawnListEntry.entityClass), worldServer, blockPos2)) continue;
                        try {
                            entityLiving = this.mapSampleEntitiesByClass.get(spawnListEntry.entityClass);
                            if (entityLiving == null) {
                                entityLiving = spawnListEntry.entityClass.getConstructor(World.class).newInstance(worldServer);
                                this.mapSampleEntitiesByClass.put(spawnListEntry.entityClass, entityLiving);
                            }
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                            return n3;
                        }
                        entityLiving.setLocationAndAngles(f, n12, f2, worldServer.rand.nextFloat() * 360.0f, 0.0f);
                        boolean bl6 = Reflector.CompatEventFactory_canEntitySpawn.exists() ? ReflectorCompat.canEntitySpawn(entityLiving, worldServer, f, n12, f2) : (bl5 = entityLiving.getCanSpawnHere() && entityLiving.isNotColliding());
                        if (bl5) {
                            int n15;
                            this.mapSampleEntitiesByClass.remove(spawnListEntry.entityClass);
                            if (!ReflectorCompat.doSpecialSpawn(entityLiving, worldServer, f, n12, f2)) {
                                iEntityLivingData = entityLiving.onInitialSpawn(worldServer.getDifficultyForLocation(new BlockPos(entityLiving)), iEntityLivingData);
                            }
                            if (entityLiving.isNotColliding()) {
                                ++n10;
                                worldServer.spawnEntityInWorld(entityLiving);
                            }
                            int n16 = n15 = Reflector.CompatEventFactory_getMaxSpawnPackSize.exists() ? Reflector.callInt(Reflector.CompatEventFactory_getMaxSpawnPackSize, entityLiving) : entityLiving.getMaxSpawnedInChunk();
                            if (n10 >= n15) continue block6;
                        }
                        n3 += n10;
                    }
                }
            }
        }
        return n3;
    }

    protected static BlockPos getRandomChunkPosition(World world2, int n, int n2) {
        Chunk chunk = world2.getChunkFromChunkCoords(n, n2);
        int n3 = n * 16 + world2.rand.nextInt(16);
        int n4 = n2 * 16 + world2.rand.nextInt(16);
        int n5 = MathHelper.roundUp(chunk.getHeight(new BlockPos(n3, 0, n4)) + 1, 16);
        int n6 = world2.rand.nextInt(n5 > 0 ? n5 : chunk.getTopFilledSegment() + 16 - 1);
        return new BlockPos(n3, n6, n4);
    }

    private static BlockPosM getRandomChunkPosition(World world2, int n, int n2, BlockPosM blockPosM) {
        Chunk chunk = world2.getChunkFromChunkCoords(n, n2);
        int n3 = n * 16 + world2.rand.nextInt(16);
        int n4 = n2 * 16 + world2.rand.nextInt(16);
        int n5 = MathHelper.roundUp(chunk.getHeightValue(n3 & 0xF, n4 & 0xF) + 1, 16);
        int n6 = world2.rand.nextInt(n5 > 0 ? n5 : chunk.getTopFilledSegment() + 16 - 1);
        blockPosM.setXyz(n3, n6, n4);
        return blockPosM;
    }

    public static boolean canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType spawnPlacementType, World world2, BlockPos blockPos) {
        boolean bl;
        if (!world2.getWorldBorder().contains(blockPos)) {
            return false;
        }
        if (spawnPlacementType == null) {
            return false;
        }
        Block block = world2.getBlockState(blockPos).getBlock();
        if (spawnPlacementType == EntityLiving.SpawnPlacementType.IN_WATER) {
            return block.getMaterial().isLiquid() && world2.getBlockState(blockPos.down()).getBlock().getMaterial().isLiquid() && !world2.getBlockState(blockPos.up()).getBlock().isNormalCube();
        }
        BlockPos blockPos2 = blockPos.down();
        IBlockState iBlockState = world2.getBlockState(blockPos2);
        boolean bl2 = bl = Reflector.CompatBlock_canCreatureSpawn.exists() ? Reflector.callBoolean(iBlockState.getBlock(), Reflector.CompatBlock_canCreatureSpawn, new Object[]{world2, blockPos2, spawnPlacementType}) : World.doesBlockHaveSolidTopSurface(world2, blockPos2);
        if (!bl) {
            return false;
        }
        Block block2 = world2.getBlockState(blockPos2).getBlock();
        boolean bl3 = block2 != Blocks.bedrock && block2 != Blocks.barrier;
        return bl3 && !block.isNormalCube() && !block.getMaterial().isLiquid() && !world2.getBlockState(blockPos.up()).getBlock().isNormalCube();
    }

    public static void performWorldGenSpawning(World world2, BiomeGenBase biomeGenBase, int n, int n2, int n3, int n4, Random random) {
        List<BiomeGenBase.SpawnListEntry> list = biomeGenBase.getSpawnableList(EnumCreatureType.CREATURE);
        if (!list.isEmpty()) {
            while (random.nextFloat() < biomeGenBase.getSpawningChance()) {
                BiomeGenBase.SpawnListEntry spawnListEntry = WeightedRandom.getRandomItem(world2.rand, list);
                int n5 = spawnListEntry.minGroupCount + random.nextInt(1 + spawnListEntry.maxGroupCount - spawnListEntry.minGroupCount);
                IEntityLivingData iEntityLivingData = null;
                int n6 = n + random.nextInt(n3);
                int n7 = n2 + random.nextInt(n4);
                int n8 = n6;
                int n9 = n7;
                for (int i = 0; i < n5; ++i) {
                    boolean bl = false;
                    for (int j = 0; !bl && j < 4; ++j) {
                        BlockPos blockPos = world2.getTopSolidOrLiquidBlock(new BlockPos(n6, 0, n7));
                        if (SpawnerAnimals.canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType.ON_GROUND, world2, blockPos)) {
                            Object object;
                            EntityLiving entityLiving;
                            try {
                                entityLiving = spawnListEntry.entityClass.getConstructor(World.class).newInstance(world2);
                            }
                            catch (Exception exception) {
                                exception.printStackTrace();
                                continue;
                            }
                            if (Reflector.CompatEventFactory_canEntitySpawn.exists() && (object = Reflector.call(Reflector.CompatEventFactory_canEntitySpawn, entityLiving, world2, Float.valueOf((float)n6 + 0.5f), blockPos.getY(), Float.valueOf((float)n7 + 0.5f))) == ReflectorCompat.EVENT_RESULT_DENY) continue;
                            entityLiving.setLocationAndAngles((float)n6 + 0.5f, blockPos.getY(), (float)n7 + 0.5f, random.nextFloat() * 360.0f, 0.0f);
                            world2.spawnEntityInWorld(entityLiving);
                            iEntityLivingData = entityLiving.onInitialSpawn(world2.getDifficultyForLocation(new BlockPos(entityLiving)), iEntityLivingData);
                            bl = true;
                        }
                        n6 += random.nextInt(5) - random.nextInt(5);
                        n7 += random.nextInt(5) - random.nextInt(5);
                        while (n6 < n || n6 >= n + n3 || n7 < n2 || n7 >= n2 + n3) {
                            n6 = n8 + random.nextInt(5) - random.nextInt(5);
                            n7 = n9 + random.nextInt(5) - random.nextInt(5);
                        }
                    }
                }
            }
        }
    }
}

