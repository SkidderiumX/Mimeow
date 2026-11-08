/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data;

import java.util.HashMap;

public enum Particles1_8 {
    EXPLOSION_NORMAL("explode"),
    EXPLOSION_LARGE("largeexplode"),
    EXPLOSION_HUGE("hugeexplosion"),
    FIREWORKS_SPARK("fireworksSpark"),
    WATER_BUBBLE("bubble"),
    WATER_SPLASH("splash"),
    WATER_WAKE("wake"),
    SUSPENDED("suspended"),
    SUSPENDED_DEPTH("depthsuspend"),
    CRIT("crit"),
    CRIT_MAGIC("magicCrit"),
    SMOKE_NORMAL("smoke"),
    SMOKE_LARGE("largesmoke"),
    SPELL("spell"),
    SPELL_INSTANT("instantSpell"),
    SPELL_MOB("mobSpell"),
    SPELL_MOB_AMBIENT("mobSpellAmbient"),
    SPELL_WITCH("witchMagic"),
    DRIP_WATER("dripWater"),
    DRIP_LAVA("dripLava"),
    VILLAGER_ANGRY("angryVillager"),
    VILLAGER_HAPPY("happyVillager"),
    TOWN_AURA("townaura"),
    NOTE("note"),
    PORTAL("portal"),
    ENCHANTMENT_TABLE("enchantmenttable"),
    FLAME("flame"),
    LAVA("lava"),
    FOOTSTEP("footstep"),
    CLOUD("cloud"),
    REDSTONE("reddust"),
    SNOWBALL("snowballpoof"),
    SNOW_SHOVEL("snowshovel"),
    SLIME("slime"),
    HEART("heart"),
    BARRIER("barrier"),
    ICON_CRACK("iconcrack", 2),
    BLOCK_CRACK("blockcrack", 1),
    BLOCK_DUST("blockdust", 1),
    WATER_DROP("droplet"),
    ITEM_TAKE("take"),
    MOB_APPEARANCE("mobappearance");
    private static final Particles1_8[] $VALUES_REF;










































    private static final HashMap<String, Particles1_8> particleMap;
    public final String name;
    public final int extra;
    



    private Particles1_8(String string2) {
        this(string2, 0);
    }

    private Particles1_8(String string2, int n2) {
        this.name = string2;
        this.extra = n2;
    }

    public static Particles1_8 find(String string) {
        return particleMap.get(string);
    }

    public static Particles1_8 find(int n) {
        if (n < 0) {
            return null;
        }
        Particles1_8[] particles1_8Array = Particles1_8.values();
        return n >= particles1_8Array.length ? null : particles1_8Array[n];
    }

    private static /* synthetic */ Particles1_8[] $values() {
        return new Particles1_8[]{EXPLOSION_NORMAL, EXPLOSION_LARGE, EXPLOSION_HUGE, FIREWORKS_SPARK, WATER_BUBBLE, WATER_SPLASH, WATER_WAKE, SUSPENDED, SUSPENDED_DEPTH, CRIT, CRIT_MAGIC, SMOKE_NORMAL, SMOKE_LARGE, SPELL, SPELL_INSTANT, SPELL_MOB, SPELL_MOB_AMBIENT, SPELL_WITCH, DRIP_WATER, DRIP_LAVA, VILLAGER_ANGRY, VILLAGER_HAPPY, TOWN_AURA, NOTE, PORTAL, ENCHANTMENT_TABLE, FLAME, LAVA, FOOTSTEP, CLOUD, REDSTONE, SNOWBALL, SNOW_SHOVEL, SLIME, HEART, BARRIER, ICON_CRACK, BLOCK_CRACK, BLOCK_DUST, WATER_DROP, ITEM_TAKE, MOB_APPEARANCE};
    }

    static {
        Particles1_8[] particles1_8Array;










































        $VALUES_REF = Particles1_8.$values();
        particleMap = new HashMap();
        for (Particles1_8 particles1_8 : particles1_8Array = Particles1_8.values()) {
            particleMap.put(particles1_8.name, particles1_8);
        }
    }
}

