/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldSavedData;

public class VillageCollection
extends WorldSavedData {
    private World worldObj;
    private final List<BlockPos> villagerPositionsList = Lists.newArrayList();
    private final List<VillageDoorInfo> newDoors = Lists.newArrayList();
    private final List<Village> villageList = Lists.newArrayList();
    private int tickCounter;

    public VillageCollection(String string) {
        super(string);
    }

    public VillageCollection(World world2) {
        super(VillageCollection.fileNameForProvider(world2.provider));
        this.worldObj = world2;
        this.markDirty();
    }

    public void setWorldsForAll(World world2) {
        this.worldObj = world2;
        for (Village village : this.villageList) {
            village.setWorld(world2);
        }
    }

    public void addToVillagerPositionList(BlockPos blockPos) {
        if (this.villagerPositionsList.size() <= 64 && !this.positionInList(blockPos)) {
            this.villagerPositionsList.add(blockPos);
        }
    }

    public void tick() {
        ++this.tickCounter;
        for (Village village : this.villageList) {
            village.tick(this.tickCounter);
        }
        this.removeAnnihilatedVillages();
        this.dropOldestVillagerPosition();
        this.addNewDoorsToVillageOrCreateVillage();
        if (this.tickCounter % 400 == 0) {
            this.markDirty();
        }
    }

    private void removeAnnihilatedVillages() {
        Iterator<Village> iterator2 = this.villageList.iterator();
        while (iterator2.hasNext()) {
            Village village = iterator2.next();
            if (!village.isAnnihilated()) continue;
            iterator2.remove();
            this.markDirty();
        }
    }

    public List<Village> getVillageList() {
        return this.villageList;
    }

    public Village getNearestVillage(BlockPos blockPos, int n) {
        Village village = null;
        double d = 3.4028234663852886E38;
        for (Village village2 : this.villageList) {
            float f;
            double d2 = village2.getCenter().distanceSq(blockPos);
            if (!(d2 < d) || !(d2 <= (double)((f = (float)(n + village2.getVillageRadius())) * f))) continue;
            village = village2;
            d = d2;
        }
        return village;
    }

    private void dropOldestVillagerPosition() {
        if (!this.villagerPositionsList.isEmpty()) {
            this.addDoorsAround(this.villagerPositionsList.remove(0));
        }
    }

    private void addNewDoorsToVillageOrCreateVillage() {
        for (int i = 0; i < this.newDoors.size(); ++i) {
            VillageDoorInfo villageDoorInfo = this.newDoors.get(i);
            Village village = this.getNearestVillage(villageDoorInfo.getDoorBlockPos(), 32);
            if (village == null) {
                village = new Village(this.worldObj);
                this.villageList.add(village);
                this.markDirty();
            }
            village.addVillageDoorInfo(villageDoorInfo);
        }
        this.newDoors.clear();
    }

    private void addDoorsAround(BlockPos blockPos) {
        int n = 16;
        int n2 = 4;
        int n3 = 16;
        for (int i = -n; i < n; ++i) {
            for (int j = -n2; j < n2; ++j) {
                for (int k = -n3; k < n3; ++k) {
                    BlockPos blockPos2 = blockPos.add(i, j, k);
                    if (!this.isWoodDoor(blockPos2)) continue;
                    VillageDoorInfo villageDoorInfo = this.checkDoorExistence(blockPos2);
                    if (villageDoorInfo == null) {
                        this.addToNewDoorsList(blockPos2);
                        continue;
                    }
                    villageDoorInfo.func_179849_a(this.tickCounter);
                }
            }
        }
    }

    private VillageDoorInfo checkDoorExistence(BlockPos blockPos) {
        for (VillageDoorInfo object : this.newDoors) {
            if (object.getDoorBlockPos().getX() != blockPos.getX() || object.getDoorBlockPos().getZ() != blockPos.getZ() || Math.abs(object.getDoorBlockPos().getY() - blockPos.getY()) > 1) continue;
            return object;
        }
        for (Village village : this.villageList) {
            VillageDoorInfo villageDoorInfo = village.getExistedDoor(blockPos);
            if (villageDoorInfo == null) continue;
            return villageDoorInfo;
        }
        return null;
    }

    private void addToNewDoorsList(BlockPos blockPos) {
        int n;
        EnumFacing enumFacing = BlockDoor.getFacing(this.worldObj, blockPos);
        EnumFacing enumFacing2 = enumFacing.getOpposite();
        int n2 = this.countBlocksCanSeeSky(blockPos, enumFacing, 5);
        if (n2 != (n = this.countBlocksCanSeeSky(blockPos, enumFacing2, n2 + 1))) {
            this.newDoors.add(new VillageDoorInfo(blockPos, n2 < n ? enumFacing : enumFacing2, this.tickCounter));
        }
    }

    private int countBlocksCanSeeSky(BlockPos blockPos, EnumFacing enumFacing, int n) {
        int n2 = 0;
        for (int i = 1; i <= 5; ++i) {
            if (!this.worldObj.canSeeSky(blockPos.offset(enumFacing, i)) || ++n2 < n) continue;
            return n2;
        }
        return n2;
    }

    private boolean positionInList(BlockPos blockPos) {
        for (BlockPos blockPos2 : this.villagerPositionsList) {
            if (!blockPos2.equals(blockPos)) continue;
            return true;
        }
        return false;
    }

    private boolean isWoodDoor(BlockPos blockPos) {
        Block block = this.worldObj.getBlockState(blockPos).getBlock();
        return block instanceof BlockDoor ? block.getMaterial() == Material.wood : false;
    }

    @Override
    public void readFromNBT(NBTTagCompound nBTTagCompound) {
        this.tickCounter = nBTTagCompound.getInteger("Tick");
        NBTTagList nBTTagList = nBTTagCompound.getTagList("Villages", 10);
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
            Village village = new Village();
            village.readVillageDataFromNBT(nBTTagCompound2);
            this.villageList.add(village);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nBTTagCompound) {
        nBTTagCompound.setInteger("Tick", this.tickCounter);
        NBTTagList nBTTagList = new NBTTagList();
        for (Village village : this.villageList) {
            NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
            village.writeVillageDataToNBT(nBTTagCompound2);
            nBTTagList.appendTag(nBTTagCompound2);
        }
        nBTTagCompound.setTag("Villages", nBTTagList);
    }

    public static String fileNameForProvider(WorldProvider worldProvider) {
        return "villages" + worldProvider.getInternalNameSuffix();
    }
}

