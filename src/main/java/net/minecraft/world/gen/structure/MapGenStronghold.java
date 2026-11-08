/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureStrongholdPieces;

public class MapGenStronghold
extends MapGenStructure {
    private List<BiomeGenBase> field_151546_e;
    private boolean ranBiomeCheck;
    private ChunkCoordIntPair[] structureCoords = new ChunkCoordIntPair[3];
    private double field_82671_h = 32.0;
    private int field_82672_i = 3;

    public MapGenStronghold() {
        this.field_151546_e = Lists.newArrayList();
        for (BiomeGenBase biomeGenBase : BiomeGenBase.getBiomeGenArray()) {
            if (biomeGenBase == null || !(biomeGenBase.minHeight > 0.0f)) continue;
            this.field_151546_e.add(biomeGenBase);
        }
    }

    public MapGenStronghold(Map<String, String> map) {
        this();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals("distance")) {
                this.field_82671_h = MathHelper.parseDoubleWithDefaultAndMax(entry.getValue(), this.field_82671_h, 1.0);
                continue;
            }
            if (entry.getKey().equals("count")) {
                this.structureCoords = new ChunkCoordIntPair[MathHelper.parseIntWithDefaultAndMax(entry.getValue(), this.structureCoords.length, 1)];
                continue;
            }
            if (!entry.getKey().equals("spread")) continue;
            this.field_82672_i = MathHelper.parseIntWithDefaultAndMax(entry.getValue(), this.field_82672_i, 1);
        }
    }

    @Override
    public String getStructureName() {
        return "Stronghold";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int n, int n2) {
        if (!this.ranBiomeCheck) {
            Random random = new Random();
            random.setSeed(this.worldObj.getSeed());
            double d = random.nextDouble() * Math.PI * 2.0;
            int n3 = 1;
            for (int i = 0; i < this.structureCoords.length; ++i) {
                double d2 = (1.25 * (double)n3 + random.nextDouble()) * this.field_82671_h * (double)n3;
                int n4 = (int)Math.round(Math.cos(d) * d2);
                int n5 = (int)Math.round(Math.sin(d) * d2);
                BlockPos blockPos = this.worldObj.getWorldChunkManager().findBiomePosition((n4 << 4) + 8, (n5 << 4) + 8, 112, this.field_151546_e, random);
                if (blockPos != null) {
                    n4 = blockPos.getX() >> 4;
                    n5 = blockPos.getZ() >> 4;
                }
                this.structureCoords[i] = new ChunkCoordIntPair(n4, n5);
                d += Math.PI * 2 * (double)n3 / (double)this.field_82672_i;
                if (i != this.field_82672_i) continue;
                n3 += 2 + random.nextInt(5);
                this.field_82672_i += 1 + random.nextInt(2);
            }
            this.ranBiomeCheck = true;
        }
        for (ChunkCoordIntPair chunkCoordIntPair : this.structureCoords) {
            if (n != chunkCoordIntPair.chunkXPos || n2 != chunkCoordIntPair.chunkZPos) continue;
            return true;
        }
        return false;
    }

    @Override
    protected List<BlockPos> getCoordList() {
        ArrayList<BlockPos> arrayList = Lists.newArrayList();
        for (ChunkCoordIntPair chunkCoordIntPair : this.structureCoords) {
            if (chunkCoordIntPair == null) continue;
            arrayList.add(chunkCoordIntPair.getCenterBlock(64));
        }
        return arrayList;
    }

    @Override
    protected StructureStart getStructureStart(int n, int n2) {
        Start start = new Start(this.worldObj, this.rand, n, n2);
        while (start.getComponents().isEmpty() || ((StructureStrongholdPieces.Stairs2)start.getComponents().get((int)0)).strongholdPortalRoom == null) {
            start = new Start(this.worldObj, this.rand, n, n2);
        }
        return start;
    }

    public static class Start
    extends StructureStart {
        public Start() {
        }

        public Start(World world2, Random random, int n, int n2) {
            super(n, n2);
            StructureStrongholdPieces.prepareStructurePieces();
            StructureStrongholdPieces.Stairs2 stairs2 = new StructureStrongholdPieces.Stairs2(0, random, (n << 4) + 2, (n2 << 4) + 2);
            this.components.add(stairs2);
            stairs2.buildComponent(stairs2, this.components, random);
            List<StructureComponent> list = stairs2.field_75026_c;
            while (!list.isEmpty()) {
                int n3 = random.nextInt(list.size());
                StructureComponent structureComponent = list.remove(n3);
                structureComponent.buildComponent(stairs2, this.components, random);
            }
            this.updateBoundingBox();
            this.markAvailableHeight(world2, random, 10);
        }
    }
}

