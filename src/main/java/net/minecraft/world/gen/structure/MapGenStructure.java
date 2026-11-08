/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ReportedException;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.structure.MapGenStructureData;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;

public abstract class MapGenStructure
extends MapGenBase {
    private MapGenStructureData structureData;
    protected Map<Long, StructureStart> structureMap = Maps.newHashMap();

    public abstract String getStructureName();

    @Override
    protected final void recursiveGenerate(World world2, final int n, final int n2, int n3, int n4, ChunkPrimer chunkPrimer) {
        this.initializeStructureData(world2);
        if (!this.structureMap.containsKey(ChunkCoordIntPair.chunkXZ2Int(n, n2))) {
            this.rand.nextInt();
            try {
                if (this.canSpawnStructureAtCoords(n, n2)) {
                    StructureStart structureStart = this.getStructureStart(n, n2);
                    this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(n, n2), structureStart);
                    this.setStructureStart(n, n2, structureStart);
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Exception preparing structure feature");
                CrashReportCategory crashReportCategory = crashReport.makeCategory("Feature being prepared");
                crashReportCategory.addCrashSectionCallable("Is feature chunk", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.canSpawnStructureAtCoords(n, n2) ? "True" : "False";
                    }
                });
                crashReportCategory.addCrashSection("Chunk location", String.format("%d,%d", n, n2));
                crashReportCategory.addCrashSectionCallable("Chunk pos hash", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return String.valueOf(ChunkCoordIntPair.chunkXZ2Int(n, n2));
                    }
                });
                crashReportCategory.addCrashSectionCallable("Structure type", new Callable<String>(){

                    @Override
                    public String call() throws Exception {
                        return MapGenStructure.this.getClass().getCanonicalName();
                    }
                });
                throw new ReportedException(crashReport);
            }
        }
    }

    public boolean generateStructure(World world2, Random random, ChunkCoordIntPair chunkCoordIntPair) {
        this.initializeStructureData(world2);
        int n = (chunkCoordIntPair.chunkXPos << 4) + 8;
        int n2 = (chunkCoordIntPair.chunkZPos << 4) + 8;
        boolean bl = false;
        for (StructureStart structureStart : this.structureMap.values()) {
            if (!structureStart.isSizeableStructure() || !structureStart.func_175788_a(chunkCoordIntPair) || !structureStart.getBoundingBox().intersectsWith(n, n2, n + 15, n2 + 15)) continue;
            structureStart.generateStructure(world2, random, new StructureBoundingBox(n, n2, n + 15, n2 + 15));
            structureStart.func_175787_b(chunkCoordIntPair);
            bl = true;
            this.setStructureStart(structureStart.getChunkPosX(), structureStart.getChunkPosZ(), structureStart);
        }
        return bl;
    }

    public boolean func_175795_b(BlockPos blockPos) {
        this.initializeStructureData(this.worldObj);
        return this.func_175797_c(blockPos) != null;
    }

    protected StructureStart func_175797_c(BlockPos blockPos) {
        for (StructureStart structureStart : this.structureMap.values()) {
            if (!structureStart.isSizeableStructure() || !structureStart.getBoundingBox().isVecInside(blockPos)) continue;
            for (StructureComponent structureComponent : structureStart.getComponents()) {
                if (!structureComponent.getBoundingBox().isVecInside(blockPos)) continue;
                return structureStart;
            }
        }
        return null;
    }

    public boolean isPositionInStructure(World world2, BlockPos blockPos) {
        this.initializeStructureData(world2);
        for (StructureStart structureStart : this.structureMap.values()) {
            if (!structureStart.isSizeableStructure() || !structureStart.getBoundingBox().isVecInside(blockPos)) continue;
            return true;
        }
        return false;
    }

    /*
     * WARNING - void declaration
     */
    public BlockPos getClosestStrongholdPos(World world2, BlockPos blockPos) {
        double d;
        this.worldObj = world2;
        this.initializeStructureData(world2);
        this.rand.setSeed(world2.getSeed());
        long l = this.rand.nextLong();
        long l2 = this.rand.nextLong();
        long l3 = (long)(blockPos.getX() >> 4) * l;
        long l4 = (long)(blockPos.getZ() >> 4) * l2;
        this.rand.setSeed(l3 ^ l4 ^ world2.getSeed());
        this.recursiveGenerate(world2, blockPos.getX() >> 4, blockPos.getZ() >> 4, 0, 0, null);
        double d2 = Double.MAX_VALUE;
        BlockPos blockPos2 = null;
        for (StructureStart object : this.structureMap.values()) {
            Object object2;
            BlockPos blockPos3;
            if (!object.isSizeableStructure() || !((d = (blockPos3 = ((StructureComponent)(object2 = object.getComponents().get(0))).getBoundingBoxCenter()).distanceSq(blockPos)) < d2)) continue;
            d2 = d;
            blockPos2 = blockPos3;
        }
        if (blockPos2 != null) {
            return blockPos2;
        }
        List<BlockPos> list = this.getCoordList();
        if (list != null) {
            BlockPos var15_12 = null;
            for (BlockPos blockPos3 : list) {
                d = blockPos3.distanceSq(blockPos);
                if (!(d < d2)) continue;
            BlockPos blockPos4 = blockPos3;
                d2 = d;
                var15_12 = blockPos3;
            }
            return var15_12;
        }
        return null;
    }

    protected List<BlockPos> getCoordList() {
        return null;
    }

    private void initializeStructureData(World world2) {
        if (this.structureData == null) {
            this.structureData = (MapGenStructureData)world2.loadItemData(MapGenStructureData.class, this.getStructureName());
            if (this.structureData == null) {
                this.structureData = new MapGenStructureData(this.getStructureName());
                world2.setItemData(this.getStructureName(), this.structureData);
            } else {
                NBTTagCompound nBTTagCompound = this.structureData.getTagCompound();
                for (String string : nBTTagCompound.getKeySet()) {
                    NBTTagCompound nBTTagCompound2;
                    NBTBase nBTBase = nBTTagCompound.getTag(string);
                    if (nBTBase.getId() != 10 || !(nBTTagCompound2 = (NBTTagCompound)nBTBase).hasKey("ChunkX") || !nBTTagCompound2.hasKey("ChunkZ")) continue;
                    int n = nBTTagCompound2.getInteger("ChunkX");
                    int n2 = nBTTagCompound2.getInteger("ChunkZ");
                    StructureStart structureStart = MapGenStructureIO.getStructureStart(nBTTagCompound2, world2);
                    if (structureStart == null) continue;
                    this.structureMap.put(ChunkCoordIntPair.chunkXZ2Int(n, n2), structureStart);
                }
            }
        }
    }

    private void setStructureStart(int n, int n2, StructureStart structureStart) {
        this.structureData.writeInstance(structureStart.writeStructureComponentsToNBT(n, n2), n, n2);
        this.structureData.markDirty();
    }

    protected abstract boolean canSpawnStructureAtCoords(int var1, int var2);

    protected abstract StructureStart getStructureStart(int var1, int var2);
}

