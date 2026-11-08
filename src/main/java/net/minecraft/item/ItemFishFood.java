/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.item;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFishFood
extends ItemFood {
    private final boolean cooked;

    public ItemFishFood(boolean bl) {
        super(0, 0.0f, false);
        this.cooked = bl;
    }

    @Override
    public int getHealAmount(ItemStack itemStack) {
        FishType fishType = FishType.byItemStack(itemStack);
        return this.cooked && fishType.canCook() ? fishType.getCookedHealAmount() : fishType.getUncookedHealAmount();
    }

    @Override
    public float getSaturationModifier(ItemStack itemStack) {
        FishType fishType = FishType.byItemStack(itemStack);
        return this.cooked && fishType.canCook() ? fishType.getCookedSaturationModifier() : fishType.getUncookedSaturationModifier();
    }

    @Override
    public String getPotionEffect(ItemStack itemStack) {
        return FishType.byItemStack(itemStack) == FishType.PUFFERFISH ? "+0-1+2+3+13&4-4" : null;
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world2, EntityPlayer entityPlayer) {
        FishType fishType = FishType.byItemStack(itemStack);
        if (fishType == FishType.PUFFERFISH) {
            entityPlayer.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3));
            entityPlayer.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
            entityPlayer.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));
        }
        super.onFoodEaten(itemStack, world2, entityPlayer);
    }

    @Override
    public void getSubItems(Item item, CreativeTabs creativeTabs, List<ItemStack> list) {
        for (FishType fishType : FishType.values()) {
            if (this.cooked && !fishType.canCook()) continue;
            list.add(new ItemStack(this, 1, fishType.getMetadata()));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack) {
        FishType fishType = FishType.byItemStack(itemStack);
        return this.getUnlocalizedName() + "." + fishType.getUnlocalizedName() + "." + (this.cooked && fishType.canCook() ? "cooked" : "raw");
    }

    public static enum FishType {
        COD(0, "cod", 2, 0.1f, 5, 0.6f),
        SALMON(1, "salmon", 2, 0.1f, 6, 0.8f),
        CLOWNFISH(2, "clownfish", 1, 0.1f),
        PUFFERFISH(3, "pufferfish", 1, 0.1f);

        private static final Map<Integer, FishType> META_LOOKUP;
        private final int meta;
        private final String unlocalizedName;
        private final int uncookedHealAmount;
        private final float uncookedSaturationModifier;
        private final int cookedHealAmount;
        private final float cookedSaturationModifier;
        private boolean cookable = false;

        private FishType(int n2, String string2, int n3, float f, int n4, float f2) {
            this.meta = n2;
            this.unlocalizedName = string2;
            this.uncookedHealAmount = n3;
            this.uncookedSaturationModifier = f;
            this.cookedHealAmount = n4;
            this.cookedSaturationModifier = f2;
            this.cookable = true;
        }

        private FishType(int n2, String string2, int n3, float f) {
            this.meta = n2;
            this.unlocalizedName = string2;
            this.uncookedHealAmount = n3;
            this.uncookedSaturationModifier = f;
            this.cookedHealAmount = 0;
            this.cookedSaturationModifier = 0.0f;
            this.cookable = false;
        }

        public int getMetadata() {
            return this.meta;
        }

        public String getUnlocalizedName() {
            return this.unlocalizedName;
        }

        public int getUncookedHealAmount() {
            return this.uncookedHealAmount;
        }

        public float getUncookedSaturationModifier() {
            return this.uncookedSaturationModifier;
        }

        public int getCookedHealAmount() {
            return this.cookedHealAmount;
        }

        public float getCookedSaturationModifier() {
            return this.cookedSaturationModifier;
        }

        public boolean canCook() {
            return this.cookable;
        }

        public static FishType byMetadata(int n) {
            FishType fishType = META_LOOKUP.get(n);
            return fishType == null ? COD : fishType;
        }

        public static FishType byItemStack(ItemStack itemStack) {
            return itemStack.getItem() instanceof ItemFishFood ? FishType.byMetadata(itemStack.getMetadata()) : COD;
        }

        static {
            META_LOOKUP = Maps.newHashMap();
            for (FishType fishType : FishType.values()) {
                META_LOOKUP.put(fishType.getMetadata(), fishType);
            }
        }
    }
}

