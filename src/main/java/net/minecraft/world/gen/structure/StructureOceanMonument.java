/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureOceanMonumentPieces;
import net.minecraft.world.gen.structure.StructureStart;

public class StructureOceanMonument
extends MapGenStructure {
    private int field_175800_f = 32;
    private int field_175801_g = 5;
    public static final List<BiomeGenBase> field_175802_d = Arrays.asList(BiomeGenBase.ocean, BiomeGenBase.deepOcean, BiomeGenBase.river, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver);
    private static final List<BiomeGenBase.SpawnListEntry> field_175803_h = Lists.newArrayList();

    public StructureOceanMonument() {
    }

    public StructureOceanMonument(Map<String, String> map) {
        this();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals("spacing")) {
                this.field_175800_f = MathHelper.parseIntWithDefaultAndMax(entry.getValue(), this.field_175800_f, 1);
                continue;
            }
            if (!entry.getKey().equals("separation")) continue;
            this.field_175801_g = MathHelper.parseIntWithDefaultAndMax(entry.getValue(), this.field_175801_g, 1);
        }
    }

    @Override
    public String getStructureName() {
        return "Monument";
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int n, int n2) {
        int n3 = n;
        int n4 = n2;
        if (n < 0) {
            n -= this.field_175800_f - 1;
        }
        if (n2 < 0) {
            n2 -= this.field_175800_f - 1;
        }
        int n5 = n / this.field_175800_f;
        int n6 = n2 / this.field_175800_f;
        Random random = this.worldObj.setRandomSeed(n5, n6, 10387313);
        n5 *= this.field_175800_f;
        n6 *= this.field_175800_f;
        if (n3 == (n5 += (random.nextInt(this.field_175800_f - this.field_175801_g) + random.nextInt(this.field_175800_f - this.field_175801_g)) / 2) && n4 == (n6 += (random.nextInt(this.field_175800_f - this.field_175801_g) + random.nextInt(this.field_175800_f - this.field_175801_g)) / 2)) {
            if (this.worldObj.getWorldChunkManager().getBiomeGenerator(new BlockPos(n3 * 16 + 8, 64, n4 * 16 + 8), null) != BiomeGenBase.deepOcean) {
                return false;
            }
            boolean bl = this.worldObj.getWorldChunkManager().areBiomesViable(n3 * 16 + 8, n4 * 16 + 8, 29, field_175802_d);
            if (bl) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected StructureStart getStructureStart(int n, int n2) {
        return new StartMonument(this.worldObj, this.rand, n, n2);
    }

    public List<BiomeGenBase.SpawnListEntry> getScatteredFeatureSpawnList() {
        return field_175803_h;
    }

    static {
        field_175803_h.add(new BiomeGenBase.SpawnListEntry(EntityGuardian.class, 1, 2, 4));
    }

    public static class StartMonument
    extends StructureStart {
        private Set<ChunkCoordIntPair> field_175791_c = Sets.newHashSet();
        private boolean field_175790_d;

        public StartMonument() {
        }

        public StartMonument(World world2, Random random, int n, int n2) {
            super(n, n2);
            this.func_175789_b(world2, random, n, n2);
        }

        private void func_175789_b(World world2, Random random, int n, int n2) {
            random.setSeed(world2.getSeed());
            long l = random.nextLong();
            long l2 = random.nextLong();
            long l3 = (long)n * l;
            long l4 = (long)n2 * l2;
            random.setSeed(l3 ^ l4 ^ world2.getSeed());
            int n3 = n * 16 + 8 - 29;
            int n4 = n2 * 16 + 8 - 29;
            EnumFacing enumFacing = EnumFacing.Plane.HORIZONTAL.random(random);
            this.components.add(new StructureOceanMonumentPieces.MonumentBuilding(random, n3, n4, enumFacing));
            this.updateBoundingBox();
            this.field_175790_d = true;
        }

        @Override
        public void generateStructure(World world2, Random random, StructureBoundingBox structureBoundingBox) {
            if (!this.field_175790_d) {
                this.components.clear();
                this.func_175789_b(world2, random, this.getChunkPosX(), this.getChunkPosZ());
            }
            super.generateStructure(world2, random, structureBoundingBox);
        }

        @Override
        public boolean func_175788_a(ChunkCoordIntPair chunkCoordIntPair) {
            return this.field_175791_c.contains(chunkCoordIntPair) ? false : super.func_175788_a(chunkCoordIntPair);
        }

        @Override
        public void func_175787_b(ChunkCoordIntPair chunkCoordIntPair) {
            super.func_175787_b(chunkCoordIntPair);
            this.field_175791_c.add(chunkCoordIntPair);
        }

        @Override
        public void writeToNBT(NBTTagCompound nBTTagCompound) {
            super.writeToNBT(nBTTagCompound);
            NBTTagList nBTTagList = new NBTTagList();
            for (ChunkCoordIntPair chunkCoordIntPair : this.field_175791_c) {
                NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
                nBTTagCompound2.setInteger("X", chunkCoordIntPair.chunkXPos);
                nBTTagCompound2.setInteger("Z", chunkCoordIntPair.chunkZPos);
                nBTTagList.appendTag(nBTTagCompound2);
            }
            nBTTagCompound.setTag("Processed", nBTTagList);
        }

        @Override
        public void readFromNBT(NBTTagCompound nBTTagCompound) {
            super.readFromNBT(nBTTagCompound);
            if (nBTTagCompound.hasKey("Processed", 9)) {
                NBTTagList nBTTagList = nBTTagCompound.getTagList("Processed", 10);
                for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                    NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
                    this.field_175791_c.add(new ChunkCoordIntPair(nBTTagCompound2.getInteger("X"), nBTTagCompound2.getInteger("Z")));
                }
            }
        }
    }
}

