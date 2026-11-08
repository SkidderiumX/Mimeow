/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.village;

import java.io.IOException;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.PacketBuffer;
import net.minecraft.village.MerchantRecipe;

public class MerchantRecipeList
extends ArrayList<MerchantRecipe> {
    public MerchantRecipeList() {
    }

    public MerchantRecipeList(NBTTagCompound nBTTagCompound) {
        this.readRecipiesFromTags(nBTTagCompound);
    }

    public MerchantRecipe canRecipeBeUsed(ItemStack itemStack, ItemStack itemStack2, int n) {
        if (n > 0 && n < this.size()) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(n);
            return !this.func_181078_a(itemStack, merchantRecipe.getItemToBuy()) || (itemStack2 != null || merchantRecipe.hasSecondItemToBuy()) && (!merchantRecipe.hasSecondItemToBuy() || !this.func_181078_a(itemStack2, merchantRecipe.getSecondItemToBuy())) || itemStack.stackSize < merchantRecipe.getItemToBuy().stackSize || merchantRecipe.hasSecondItemToBuy() && itemStack2.stackSize < merchantRecipe.getSecondItemToBuy().stackSize ? null : merchantRecipe;
        }
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            if (!this.func_181078_a(itemStack, merchantRecipe.getItemToBuy()) || itemStack.stackSize < merchantRecipe.getItemToBuy().stackSize || (merchantRecipe.hasSecondItemToBuy() || itemStack2 != null) && (!merchantRecipe.hasSecondItemToBuy() || !this.func_181078_a(itemStack2, merchantRecipe.getSecondItemToBuy()) || itemStack2.stackSize < merchantRecipe.getSecondItemToBuy().stackSize)) continue;
            return merchantRecipe;
        }
        return null;
    }

    private boolean func_181078_a(ItemStack itemStack, ItemStack itemStack2) {
        return ItemStack.areItemsEqual(itemStack, itemStack2) && (!itemStack2.hasTagCompound() || itemStack.hasTagCompound() && NBTUtil.func_181123_a(itemStack2.getTagCompound(), itemStack.getTagCompound(), false));
    }

    public void writeToBuf(PacketBuffer packetBuffer) {
        packetBuffer.writeByte((byte)(this.size() & 0xFF));
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            packetBuffer.writeItemStackToBuffer(merchantRecipe.getItemToBuy());
            packetBuffer.writeItemStackToBuffer(merchantRecipe.getItemToSell());
            ItemStack itemStack = merchantRecipe.getSecondItemToBuy();
            packetBuffer.writeBoolean(itemStack != null);
            if (itemStack != null) {
                packetBuffer.writeItemStackToBuffer(itemStack);
            }
            packetBuffer.writeBoolean(merchantRecipe.isRecipeDisabled());
            packetBuffer.writeInt(merchantRecipe.getToolUses());
            packetBuffer.writeInt(merchantRecipe.getMaxTradeUses());
        }
    }

    public static MerchantRecipeList readFromBuf(PacketBuffer packetBuffer) throws IOException {
        MerchantRecipeList merchantRecipeList = new MerchantRecipeList();
        int n = packetBuffer.readByte() & 0xFF;
        for (int i = 0; i < n; ++i) {
            ItemStack itemStack = packetBuffer.readItemStackFromBuffer();
            ItemStack itemStack2 = packetBuffer.readItemStackFromBuffer();
            ItemStack itemStack3 = null;
            if (packetBuffer.readBoolean()) {
                itemStack3 = packetBuffer.readItemStackFromBuffer();
            }
            boolean bl = packetBuffer.readBoolean();
            int n2 = packetBuffer.readInt();
            int n3 = packetBuffer.readInt();
            MerchantRecipe merchantRecipe = new MerchantRecipe(itemStack, itemStack3, itemStack2, n2, n3);
            if (bl) {
                merchantRecipe.compensateToolUses();
            }
            merchantRecipeList.add(merchantRecipe);
        }
        return merchantRecipeList;
    }

    public void readRecipiesFromTags(NBTTagCompound nBTTagCompound) {
        NBTTagList nBTTagList = nBTTagCompound.getTagList("Recipes", 10);
        for (int i = 0; i < nBTTagList.tagCount(); ++i) {
            NBTTagCompound nBTTagCompound2 = nBTTagList.getCompoundTagAt(i);
            this.add(new MerchantRecipe(nBTTagCompound2));
        }
    }

    public NBTTagCompound getRecipiesAsTags() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        NBTTagList nBTTagList = new NBTTagList();
        for (int i = 0; i < this.size(); ++i) {
            MerchantRecipe merchantRecipe = (MerchantRecipe)this.get(i);
            nBTTagList.appendTag(merchantRecipe.writeToTags());
        }
        nBTTagCompound.setTag("Recipes", nBTTagList);
        return nBTTagCompound;
    }
}

