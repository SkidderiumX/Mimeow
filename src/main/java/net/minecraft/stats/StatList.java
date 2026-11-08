/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.stats;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.stats.StatCrafting;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;

public class StatList {
    protected static Map<String, StatBase> oneShotStats = Maps.newHashMap();
    public static List<StatBase> allStats = Lists.newArrayList();
    public static List<StatBase> generalStats = Lists.newArrayList();
    public static List<StatCrafting> itemStats = Lists.newArrayList();
    public static List<StatCrafting> objectMineStats = Lists.newArrayList();
    public static StatBase leaveGameStat = new StatBasic("stat.leaveGame", new ChatComponentTranslation("stat.leaveGame", new Object[0])).initIndependentStat().registerStat();
    public static StatBase minutesPlayedStat = new StatBasic("stat.playOneMinute", new ChatComponentTranslation("stat.playOneMinute", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
    public static StatBase timeSinceDeathStat = new StatBasic("stat.timeSinceDeath", new ChatComponentTranslation("stat.timeSinceDeath", new Object[0]), StatBase.timeStatType).initIndependentStat().registerStat();
    public static StatBase distanceWalkedStat = new StatBasic("stat.walkOneCm", new ChatComponentTranslation("stat.walkOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceCrouchedStat = new StatBasic("stat.crouchOneCm", new ChatComponentTranslation("stat.crouchOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceSprintedStat = new StatBasic("stat.sprintOneCm", new ChatComponentTranslation("stat.sprintOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceSwumStat = new StatBasic("stat.swimOneCm", new ChatComponentTranslation("stat.swimOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceFallenStat = new StatBasic("stat.fallOneCm", new ChatComponentTranslation("stat.fallOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceClimbedStat = new StatBasic("stat.climbOneCm", new ChatComponentTranslation("stat.climbOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceFlownStat = new StatBasic("stat.flyOneCm", new ChatComponentTranslation("stat.flyOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceDoveStat = new StatBasic("stat.diveOneCm", new ChatComponentTranslation("stat.diveOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceByMinecartStat = new StatBasic("stat.minecartOneCm", new ChatComponentTranslation("stat.minecartOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceByBoatStat = new StatBasic("stat.boatOneCm", new ChatComponentTranslation("stat.boatOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceByPigStat = new StatBasic("stat.pigOneCm", new ChatComponentTranslation("stat.pigOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase distanceByHorseStat = new StatBasic("stat.horseOneCm", new ChatComponentTranslation("stat.horseOneCm", new Object[0]), StatBase.distanceStatType).initIndependentStat().registerStat();
    public static StatBase jumpStat = new StatBasic("stat.jump", new ChatComponentTranslation("stat.jump", new Object[0])).initIndependentStat().registerStat();
    public static StatBase dropStat = new StatBasic("stat.drop", new ChatComponentTranslation("stat.drop", new Object[0])).initIndependentStat().registerStat();
    public static StatBase damageDealtStat = new StatBasic("stat.damageDealt", new ChatComponentTranslation("stat.damageDealt", new Object[0]), StatBase.field_111202_k).registerStat();
    public static StatBase damageTakenStat = new StatBasic("stat.damageTaken", new ChatComponentTranslation("stat.damageTaken", new Object[0]), StatBase.field_111202_k).registerStat();
    public static StatBase deathsStat = new StatBasic("stat.deaths", new ChatComponentTranslation("stat.deaths", new Object[0])).registerStat();
    public static StatBase mobKillsStat = new StatBasic("stat.mobKills", new ChatComponentTranslation("stat.mobKills", new Object[0])).registerStat();
    public static StatBase animalsBredStat = new StatBasic("stat.animalsBred", new ChatComponentTranslation("stat.animalsBred", new Object[0])).registerStat();
    public static StatBase playerKillsStat = new StatBasic("stat.playerKills", new ChatComponentTranslation("stat.playerKills", new Object[0])).registerStat();
    public static StatBase fishCaughtStat = new StatBasic("stat.fishCaught", new ChatComponentTranslation("stat.fishCaught", new Object[0])).registerStat();
    public static StatBase junkFishedStat = new StatBasic("stat.junkFished", new ChatComponentTranslation("stat.junkFished", new Object[0])).registerStat();
    public static StatBase treasureFishedStat = new StatBasic("stat.treasureFished", new ChatComponentTranslation("stat.treasureFished", new Object[0])).registerStat();
    public static StatBase timesTalkedToVillagerStat = new StatBasic("stat.talkedToVillager", new ChatComponentTranslation("stat.talkedToVillager", new Object[0])).registerStat();
    public static StatBase timesTradedWithVillagerStat = new StatBasic("stat.tradedWithVillager", new ChatComponentTranslation("stat.tradedWithVillager", new Object[0])).registerStat();
    public static StatBase field_181724_H = new StatBasic("stat.cakeSlicesEaten", new ChatComponentTranslation("stat.cakeSlicesEaten", new Object[0])).registerStat();
    public static StatBase field_181725_I = new StatBasic("stat.cauldronFilled", new ChatComponentTranslation("stat.cauldronFilled", new Object[0])).registerStat();
    public static StatBase field_181726_J = new StatBasic("stat.cauldronUsed", new ChatComponentTranslation("stat.cauldronUsed", new Object[0])).registerStat();
    public static StatBase field_181727_K = new StatBasic("stat.armorCleaned", new ChatComponentTranslation("stat.armorCleaned", new Object[0])).registerStat();
    public static StatBase field_181728_L = new StatBasic("stat.bannerCleaned", new ChatComponentTranslation("stat.bannerCleaned", new Object[0])).registerStat();
    public static StatBase field_181729_M = new StatBasic("stat.brewingstandInteraction", new ChatComponentTranslation("stat.brewingstandInteraction", new Object[0])).registerStat();
    public static StatBase field_181730_N = new StatBasic("stat.beaconInteraction", new ChatComponentTranslation("stat.beaconInteraction", new Object[0])).registerStat();
    public static StatBase field_181731_O = new StatBasic("stat.dropperInspected", new ChatComponentTranslation("stat.dropperInspected", new Object[0])).registerStat();
    public static StatBase field_181732_P = new StatBasic("stat.hopperInspected", new ChatComponentTranslation("stat.hopperInspected", new Object[0])).registerStat();
    public static StatBase field_181733_Q = new StatBasic("stat.dispenserInspected", new ChatComponentTranslation("stat.dispenserInspected", new Object[0])).registerStat();
    public static StatBase field_181734_R = new StatBasic("stat.noteblockPlayed", new ChatComponentTranslation("stat.noteblockPlayed", new Object[0])).registerStat();
    public static StatBase field_181735_S = new StatBasic("stat.noteblockTuned", new ChatComponentTranslation("stat.noteblockTuned", new Object[0])).registerStat();
    public static StatBase field_181736_T = new StatBasic("stat.flowerPotted", new ChatComponentTranslation("stat.flowerPotted", new Object[0])).registerStat();
    public static StatBase field_181737_U = new StatBasic("stat.trappedChestTriggered", new ChatComponentTranslation("stat.trappedChestTriggered", new Object[0])).registerStat();
    public static StatBase field_181738_V = new StatBasic("stat.enderchestOpened", new ChatComponentTranslation("stat.enderchestOpened", new Object[0])).registerStat();
    public static StatBase field_181739_W = new StatBasic("stat.itemEnchanted", new ChatComponentTranslation("stat.itemEnchanted", new Object[0])).registerStat();
    public static StatBase field_181740_X = new StatBasic("stat.recordPlayed", new ChatComponentTranslation("stat.recordPlayed", new Object[0])).registerStat();
    public static StatBase field_181741_Y = new StatBasic("stat.furnaceInteraction", new ChatComponentTranslation("stat.furnaceInteraction", new Object[0])).registerStat();
    public static StatBase field_181742_Z = new StatBasic("stat.craftingTableInteraction", new ChatComponentTranslation("stat.workbenchInteraction", new Object[0])).registerStat();
    public static StatBase field_181723_aa = new StatBasic("stat.chestOpened", new ChatComponentTranslation("stat.chestOpened", new Object[0])).registerStat();
    public static final StatBase[] mineBlockStatArray = new StatBase[4096];
    public static final StatBase[] objectCraftStats = new StatBase[32000];
    public static final StatBase[] objectUseStats = new StatBase[32000];
    public static final StatBase[] objectBreakStats = new StatBase[32000];

    public static void init() {
        StatList.initMiningStats();
        StatList.initStats();
        StatList.initItemDepleteStats();
        StatList.initCraftableStats();
        AchievementList.init();
        EntityList.func_151514_a();
    }

    private static void initCraftableStats() {
        HashSet<Item> hashSet = Sets.newHashSet();
        for (IRecipe object : CraftingManager.getInstance().getRecipeList()) {
            if (object.getRecipeOutput() == null) continue;
            hashSet.add(object.getRecipeOutput().getItem());
        }
        for (ItemStack itemStack : FurnaceRecipes.instance().getSmeltingList().values()) {
            hashSet.add(itemStack.getItem());
        }
        for (Item item : hashSet) {
            if (item == null) continue;
            int n = Item.getIdFromItem(item);
            String string = StatList.func_180204_a(item);
            if (string == null) continue;
            StatList.objectCraftStats[n] = new StatCrafting("stat.craftItem.", string, new ChatComponentTranslation("stat.craftItem", new ItemStack(item).getChatComponent()), item).registerStat();
        }
        StatList.replaceAllSimilarBlocks(objectCraftStats);
    }

    private static void initMiningStats() {
        for (Block block : Block.blockRegistry) {
            Item item = Item.getItemFromBlock(block);
            if (item == null) continue;
            int n = Block.getIdFromBlock(block);
            String string = StatList.func_180204_a(item);
            if (string == null || !block.getEnableStats()) continue;
            StatList.mineBlockStatArray[n] = new StatCrafting("stat.mineBlock.", string, new ChatComponentTranslation("stat.mineBlock", new ItemStack(block).getChatComponent()), item).registerStat();
            objectMineStats.add((StatCrafting)mineBlockStatArray[n]);
        }
        StatList.replaceAllSimilarBlocks(mineBlockStatArray);
    }

    private static void initStats() {
        for (Item item : Item.itemRegistry) {
            if (item == null) continue;
            int n = Item.getIdFromItem(item);
            String string = StatList.func_180204_a(item);
            if (string == null) continue;
            StatList.objectUseStats[n] = new StatCrafting("stat.useItem.", string, new ChatComponentTranslation("stat.useItem", new ItemStack(item).getChatComponent()), item).registerStat();
            if (item instanceof ItemBlock) continue;
            itemStats.add((StatCrafting)objectUseStats[n]);
        }
        StatList.replaceAllSimilarBlocks(objectUseStats);
    }

    private static void initItemDepleteStats() {
        for (Item item : Item.itemRegistry) {
            if (item == null) continue;
            int n = Item.getIdFromItem(item);
            String string = StatList.func_180204_a(item);
            if (string == null || !item.isDamageable()) continue;
            StatList.objectBreakStats[n] = new StatCrafting("stat.breakItem.", string, new ChatComponentTranslation("stat.breakItem", new ItemStack(item).getChatComponent()), item).registerStat();
        }
        StatList.replaceAllSimilarBlocks(objectBreakStats);
    }

    private static String func_180204_a(Item item) {
        ResourceLocation resourceLocation = Item.itemRegistry.getNameForObject(item);
        return resourceLocation != null ? resourceLocation.toString().replace(':', '.') : null;
    }

    private static void replaceAllSimilarBlocks(StatBase[] statBaseArray) {
        StatList.mergeStatBases(statBaseArray, Blocks.water, Blocks.flowing_water);
        StatList.mergeStatBases(statBaseArray, Blocks.lava, Blocks.flowing_lava);
        StatList.mergeStatBases(statBaseArray, Blocks.lit_pumpkin, Blocks.pumpkin);
        StatList.mergeStatBases(statBaseArray, Blocks.lit_furnace, Blocks.furnace);
        StatList.mergeStatBases(statBaseArray, Blocks.lit_redstone_ore, Blocks.redstone_ore);
        StatList.mergeStatBases(statBaseArray, Blocks.powered_repeater, Blocks.unpowered_repeater);
        StatList.mergeStatBases(statBaseArray, Blocks.powered_comparator, Blocks.unpowered_comparator);
        StatList.mergeStatBases(statBaseArray, Blocks.redstone_torch, Blocks.unlit_redstone_torch);
        StatList.mergeStatBases(statBaseArray, Blocks.lit_redstone_lamp, Blocks.redstone_lamp);
        StatList.mergeStatBases(statBaseArray, Blocks.double_stone_slab, Blocks.stone_slab);
        StatList.mergeStatBases(statBaseArray, Blocks.double_wooden_slab, Blocks.wooden_slab);
        StatList.mergeStatBases(statBaseArray, Blocks.double_stone_slab2, Blocks.stone_slab2);
        StatList.mergeStatBases(statBaseArray, Blocks.grass, Blocks.dirt);
        StatList.mergeStatBases(statBaseArray, Blocks.farmland, Blocks.dirt);
    }

    private static void mergeStatBases(StatBase[] statBaseArray, Block block, Block block2) {
        int n = Block.getIdFromBlock(block);
        int n2 = Block.getIdFromBlock(block2);
        if (statBaseArray[n] != null && statBaseArray[n2] == null) {
            statBaseArray[n2] = statBaseArray[n];
        } else {
            allStats.remove(statBaseArray[n]);
            objectMineStats.remove(statBaseArray[n]);
            generalStats.remove(statBaseArray[n]);
            statBaseArray[n] = statBaseArray[n2];
        }
    }

    public static StatBase getStatKillEntity(EntityList.EntityEggInfo entityEggInfo) {
        String string = EntityList.getStringFromID(entityEggInfo.spawnedID);
        return string == null ? null : new StatBase("stat.killEntity." + string, new ChatComponentTranslation("stat.entityKill", new ChatComponentTranslation("entity." + string + ".name", new Object[0]))).registerStat();
    }

    public static StatBase getStatEntityKilledBy(EntityList.EntityEggInfo entityEggInfo) {
        String string = EntityList.getStringFromID(entityEggInfo.spawnedID);
        return string == null ? null : new StatBase("stat.entityKilledBy." + string, new ChatComponentTranslation("stat.entityKilledBy", new ChatComponentTranslation("entity." + string + ".name", new Object[0]))).registerStat();
    }

    public static StatBase getOneShotStat(String string) {
        return oneShotStats.get(string);
    }
}

