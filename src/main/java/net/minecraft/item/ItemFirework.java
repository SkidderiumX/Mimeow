/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.entity.item.EntityFireworkRocket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFireworkCharge;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemFirework
extends Item {
    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world2, BlockPos blockPos, EnumFacing enumFacing, float f, float f2, float f3) {
        if (!world2.isRemote) {
            EntityFireworkRocket entityFireworkRocket = new EntityFireworkRocket(world2, (float)blockPos.getX() + f, (float)blockPos.getY() + f2, (float)blockPos.getZ() + f3, itemStack);
            world2.spawnEntityInWorld(entityFireworkRocket);
            if (!entityPlayer.capabilities.isCreativeMode) {
                --itemStack.stackSize;
            }
            return true;
        }
        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List<String> list, boolean bl) {
        NBTTagCompound nBTTagCompound;
        if (itemStack.hasTagCompound() && (nBTTagCompound = itemStack.getTagCompound().getCompoundTag("Fireworks")) != null) {
            NBTTagList nBTTagList;
            if (nBTTagCompound.hasKey("Flight", 99)) {
                list.add(StatCollector.translateToLocal("item.fireworks.flight") + " " + nBTTagCompound.getByte("Flight"));
            }
            if ((nBTTagList = nBTTagCompound.getTagList("Explosions", 10)) != null && nBTTagList.tagCount() > 0) {
                for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                    NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
                    ArrayList<String> arrayList = Lists.newArrayList();
                    ItemFireworkCharge.addExplosionInfo(nBTTagCompound2, arrayList);
                    if (arrayList.size() <= 0) continue;
                    for (int j = 1; j < arrayList.size(); ++j) {
                        arrayList.set(j, "  " + (String)arrayList.get(j));
                    }
                    list.addAll(arrayList);
                }
            }
        }
    }
}

