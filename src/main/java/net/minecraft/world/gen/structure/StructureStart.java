/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.structure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public abstract class StructureStart {
    protected LinkedList<StructureComponent> components = new LinkedList();
    protected StructureBoundingBox boundingBox;
    private int chunkPosX;
    private int chunkPosZ;

    public StructureStart() {
    }

    public StructureStart(int n, int n2) {
        this.chunkPosX = n;
        this.chunkPosZ = n2;
    }

    public StructureBoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    public LinkedList<StructureComponent> getComponents() {
        return this.components;
    }

    public void generateStructure(World world2, Random random, StructureBoundingBox structureBoundingBox) {
        Iterator iterator2 = this.components.iterator();
        while (iterator2.hasNext()) {
            StructureComponent structureComponent = (StructureComponent)iterator2.next();
            if (!structureComponent.getBoundingBox().intersectsWith(structureBoundingBox) || structureComponent.addComponentParts(world2, random, structureBoundingBox)) continue;
            iterator2.remove();
        }
    }

    protected void updateBoundingBox() {
        this.boundingBox = StructureBoundingBox.getNewBoundingBox();
        for (StructureComponent structureComponent : this.components) {
            this.boundingBox.expandTo(structureComponent.getBoundingBox());
        }
    }

    public NBTTagCompound writeStructureComponentsToNBT(int n, int n2) {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound.setString("id", MapGenStructureIO.getStructureStartName(this));
        nBTTagCompound.setInteger("ChunkX", n);
        nBTTagCompound.setInteger("ChunkZ", n2);
        nBTTagCompound.setTag("BB", this.boundingBox.toNBTTagIntArray());
        NBTTagList nBTTagList = new NBTTagList();
        for (StructureComponent structureComponent : this.components) {
            nBTTagList.appendTag(structureComponent.createStructureBaseNBT());
        }
        nBTTagCompound.setTag("Children", nBTTagList);
        this.writeToNBT(nBTTagCompound);
        return nBTTagCompound;
    }

    public void writeToNBT(NBTTagCompound nBTTagCompound) {
    }

    public void readStructureComponentsFromNBT(World world2, NBTTagCompound nBTTagCompound) {
        this.chunkPosX = nBTTagCompound.getInteger("ChunkX");
        this.chunkPosZ = nBTTagCompound.getInteger("ChunkZ");
        if (nBTTagCompound.hasKey("BB")) {
            this.boundingBox = new StructureBoundingBox(nBTTagCompound.getIntArray("BB"));
        }
        NBTTagList nBTTagList = nBTTagCompound.getTagList("Children", 10);
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            this.components.add(MapGenStructureIO.getStructureComponent(nBTTagList.getCompoundTagAt(i), world2));
        }
        this.readFromNBT(nBTTagCompound);
    }

    public void readFromNBT(NBTTagCompound nBTTagCompound) {
    }

    protected void markAvailableHeight(World world2, Random random, int n) {
        int n2 = world2.getSeaLevel() - n;
        int n3 = this.boundingBox.getYSize() + 1;
        if (n3 < n2) {
            n3 += random.nextInt(n2 - n3);
        }
        int n4 = n3 - this.boundingBox.maxY;
        this.boundingBox.offset(0, n4, 0);
        for (StructureComponent structureComponent : this.components) {
            structureComponent.func_181138_a(0, n4, 0);
        }
    }

    protected void setRandomHeight(World world2, Random random, int n, int n2) {
        int n3 = n2 - n + 1 - this.boundingBox.getYSize();
        int n4 = 1;
        n4 = n3 > 1 ? n + random.nextInt(n3) : n;
        int n5 = n4 - this.boundingBox.minY;
        this.boundingBox.offset(0, n5, 0);
        for (StructureComponent structureComponent : this.components) {
            structureComponent.func_181138_a(0, n5, 0);
        }
    }

    public boolean isSizeableStructure() {
        return true;
    }

    public boolean func_175788_a(ChunkCoordIntPair chunkCoordIntPair) {
        return true;
    }

    public void func_175787_b(ChunkCoordIntPair chunkCoordIntPair) {
    }

    public int getChunkPosX() {
        return this.chunkPosX;
    }

    public int getChunkPosZ() {
        return this.chunkPosZ;
    }
}

