/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_10to1_11.data;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.util.Key;

public class EntityMappings1_11 {
    private static final BiMap<String, String> oldToNewNames = HashBiMap.create();

    private static void rewrite(String string, String string2) {
        oldToNewNames.put(string, Key.namespaced(string2));
    }

    public static void toClient(CompoundTag compoundTag) {
        EntityMappings1_11.toClient(compoundTag, false);
    }

    public static void toClient(CompoundTag compoundTag, boolean bl) {
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag != null) {
            String string;
            String string2 = string = bl ? (String)oldToNewNames.inverse().get(stringTag.getValue()) : (String)oldToNewNames.get(stringTag.getValue());
            if (string != null) {
                stringTag.setValue(string);
            }
        }
    }

    public static void toClientSpawner(CompoundTag compoundTag) {
        EntityMappings1_11.toClientSpawner(compoundTag, false);
    }

    public static void toClientSpawner(CompoundTag compoundTag, boolean bl) {
        if (compoundTag == null) {
            return;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("SpawnData");
        if (compoundTag2 != null) {
            EntityMappings1_11.toClient(compoundTag2, bl);
        }
    }

    public static void toClientItem(Item item) {
        EntityMappings1_11.toClientItem(item, false);
    }

    public static void toClientItem(Item item, boolean bl) {
        if (EntityMappings1_11.hasEntityTag(item)) {
            EntityMappings1_11.toClient(item.tag().getCompoundTag("EntityTag"), bl);
        }
    }

    public static void toServerItem(Item item) {
        EntityMappings1_11.toServerItem(item, false);
    }

    public static void toServerItem(Item item, boolean bl) {
        if (!EntityMappings1_11.hasEntityTag(item)) {
            return;
        }
        CompoundTag compoundTag = item.tag().getCompoundTag("EntityTag");
        StringTag stringTag = compoundTag.getStringTag("id");
        if (stringTag != null) {
            String string;
            String string2 = string = bl ? (String)oldToNewNames.get(stringTag.getValue()) : (String)oldToNewNames.inverse().get(stringTag.getValue());
            if (string != null) {
                stringTag.setValue(string);
            }
        }
    }

    private static boolean hasEntityTag(Item item) {
        if (item == null || item.identifier() != 383) {
            return false;
        }
        CompoundTag compoundTag = item.tag();
        if (compoundTag == null) {
            return false;
        }
        CompoundTag compoundTag2 = compoundTag.getCompoundTag("EntityTag");
        return compoundTag2 != null && compoundTag2.getStringTag("id") != null;
    }

    static {
        EntityMappings1_11.rewrite("AreaEffectCloud", "area_effect_cloud");
        EntityMappings1_11.rewrite("ArmorStand", "armor_stand");
        EntityMappings1_11.rewrite("Arrow", "arrow");
        EntityMappings1_11.rewrite("Bat", "bat");
        EntityMappings1_11.rewrite("Blaze", "blaze");
        EntityMappings1_11.rewrite("Boat", "boat");
        EntityMappings1_11.rewrite("CaveSpider", "cave_spider");
        EntityMappings1_11.rewrite("Chicken", "chicken");
        EntityMappings1_11.rewrite("Cow", "cow");
        EntityMappings1_11.rewrite("Creeper", "creeper");
        EntityMappings1_11.rewrite("Donkey", "donkey");
        EntityMappings1_11.rewrite("DragonFireball", "dragon_fireball");
        EntityMappings1_11.rewrite("ElderGuardian", "elder_guardian");
        EntityMappings1_11.rewrite("EnderCrystal", "ender_crystal");
        EntityMappings1_11.rewrite("EnderDragon", "ender_dragon");
        EntityMappings1_11.rewrite("Enderman", "enderman");
        EntityMappings1_11.rewrite("Endermite", "endermite");
        EntityMappings1_11.rewrite("EntityHorse", "horse");
        EntityMappings1_11.rewrite("EyeOfEnderSignal", "eye_of_ender_signal");
        EntityMappings1_11.rewrite("FallingSand", "falling_block");
        EntityMappings1_11.rewrite("Fireball", "fireball");
        EntityMappings1_11.rewrite("FireworksRocketEntity", "fireworks_rocket");
        EntityMappings1_11.rewrite("Ghast", "ghast");
        EntityMappings1_11.rewrite("Giant", "giant");
        EntityMappings1_11.rewrite("Guardian", "guardian");
        EntityMappings1_11.rewrite("Husk", "husk");
        EntityMappings1_11.rewrite("Item", "item");
        EntityMappings1_11.rewrite("ItemFrame", "item_frame");
        EntityMappings1_11.rewrite("LavaSlime", "magma_cube");
        EntityMappings1_11.rewrite("LeashKnot", "leash_knot");
        EntityMappings1_11.rewrite("MinecartChest", "chest_minecart");
        EntityMappings1_11.rewrite("MinecartCommandBlock", "commandblock_minecart");
        EntityMappings1_11.rewrite("MinecartFurnace", "furnace_minecart");
        EntityMappings1_11.rewrite("MinecartHopper", "hopper_minecart");
        EntityMappings1_11.rewrite("MinecartRideable", "minecart");
        EntityMappings1_11.rewrite("MinecartSpawner", "spawner_minecart");
        EntityMappings1_11.rewrite("MinecartTNT", "tnt_minecart");
        EntityMappings1_11.rewrite("Mule", "mule");
        EntityMappings1_11.rewrite("MushroomCow", "mooshroom");
        EntityMappings1_11.rewrite("Ozelot", "ocelot");
        EntityMappings1_11.rewrite("Painting", "painting");
        EntityMappings1_11.rewrite("Pig", "pig");
        EntityMappings1_11.rewrite("PigZombie", "zombie_pigman");
        EntityMappings1_11.rewrite("PolarBear", "polar_bear");
        EntityMappings1_11.rewrite("PrimedTnt", "tnt");
        EntityMappings1_11.rewrite("Rabbit", "rabbit");
        EntityMappings1_11.rewrite("Sheep", "sheep");
        EntityMappings1_11.rewrite("Shulker", "shulker");
        EntityMappings1_11.rewrite("ShulkerBullet", "shulker_bullet");
        EntityMappings1_11.rewrite("Silverfish", "silverfish");
        EntityMappings1_11.rewrite("Skeleton", "skeleton");
        EntityMappings1_11.rewrite("SkeletonHorse", "skeleton_horse");
        EntityMappings1_11.rewrite("Slime", "slime");
        EntityMappings1_11.rewrite("SmallFireball", "small_fireball");
        EntityMappings1_11.rewrite("Snowball", "snowball");
        EntityMappings1_11.rewrite("SnowMan", "snowman");
        EntityMappings1_11.rewrite("SpectralArrow", "spectral_arrow");
        EntityMappings1_11.rewrite("Spider", "spider");
        EntityMappings1_11.rewrite("Squid", "squid");
        EntityMappings1_11.rewrite("Stray", "stray");
        EntityMappings1_11.rewrite("ThrownEgg", "egg");
        EntityMappings1_11.rewrite("ThrownEnderpearl", "ender_pearl");
        EntityMappings1_11.rewrite("ThrownExpBottle", "xp_bottle");
        EntityMappings1_11.rewrite("ThrownPotion", "potion");
        EntityMappings1_11.rewrite("Villager", "villager");
        EntityMappings1_11.rewrite("VillagerGolem", "villager_golem");
        EntityMappings1_11.rewrite("Witch", "witch");
        EntityMappings1_11.rewrite("WitherBoss", "wither");
        EntityMappings1_11.rewrite("WitherSkeleton", "wither_skeleton");
        EntityMappings1_11.rewrite("WitherSkull", "wither_skull");
        EntityMappings1_11.rewrite("Wolf", "wolf");
        EntityMappings1_11.rewrite("XPOrb", "xp_orb");
        EntityMappings1_11.rewrite("Zombie", "zombie");
        EntityMappings1_11.rewrite("ZombieHorse", "zombie_horse");
        EntityMappings1_11.rewrite("ZombieVillager", "zombie_villager");
    }
}

