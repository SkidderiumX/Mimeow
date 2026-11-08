/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.src.Config;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.entity.model.ModelAdapterArmorStand;
import net.optifine.entity.model.ModelAdapterBanner;
import net.optifine.entity.model.ModelAdapterBat;
import net.optifine.entity.model.ModelAdapterBlaze;
import net.optifine.entity.model.ModelAdapterBoat;
import net.optifine.entity.model.ModelAdapterBook;
import net.optifine.entity.model.ModelAdapterCaveSpider;
import net.optifine.entity.model.ModelAdapterChest;
import net.optifine.entity.model.ModelAdapterChestLarge;
import net.optifine.entity.model.ModelAdapterChicken;
import net.optifine.entity.model.ModelAdapterCow;
import net.optifine.entity.model.ModelAdapterCreeper;
import net.optifine.entity.model.ModelAdapterDragon;
import net.optifine.entity.model.ModelAdapterEnderChest;
import net.optifine.entity.model.ModelAdapterEnderCrystal;
import net.optifine.entity.model.ModelAdapterEnderman;
import net.optifine.entity.model.ModelAdapterEndermite;
import net.optifine.entity.model.ModelAdapterGhast;
import net.optifine.entity.model.ModelAdapterGuardian;
import net.optifine.entity.model.ModelAdapterHeadHumanoid;
import net.optifine.entity.model.ModelAdapterHeadSkeleton;
import net.optifine.entity.model.ModelAdapterHorse;
import net.optifine.entity.model.ModelAdapterIronGolem;
import net.optifine.entity.model.ModelAdapterLeadKnot;
import net.optifine.entity.model.ModelAdapterMagmaCube;
import net.optifine.entity.model.ModelAdapterMinecart;
import net.optifine.entity.model.ModelAdapterMinecartMobSpawner;
import net.optifine.entity.model.ModelAdapterMinecartTnt;
import net.optifine.entity.model.ModelAdapterMooshroom;
import net.optifine.entity.model.ModelAdapterOcelot;
import net.optifine.entity.model.ModelAdapterPig;
import net.optifine.entity.model.ModelAdapterPigZombie;
import net.optifine.entity.model.ModelAdapterRabbit;
import net.optifine.entity.model.ModelAdapterSheep;
import net.optifine.entity.model.ModelAdapterSheepWool;
import net.optifine.entity.model.ModelAdapterSign;
import net.optifine.entity.model.ModelAdapterSilverfish;
import net.optifine.entity.model.ModelAdapterSkeleton;
import net.optifine.entity.model.ModelAdapterSlime;
import net.optifine.entity.model.ModelAdapterSnowman;
import net.optifine.entity.model.ModelAdapterSpider;
import net.optifine.entity.model.ModelAdapterSquid;
import net.optifine.entity.model.ModelAdapterVillager;
import net.optifine.entity.model.ModelAdapterWitch;
import net.optifine.entity.model.ModelAdapterWither;
import net.optifine.entity.model.ModelAdapterWitherSkull;
import net.optifine.entity.model.ModelAdapterWolf;
import net.optifine.entity.model.ModelAdapterZombie;

public class CustomModelRegistry {
    private static Map<String, ModelAdapter> mapModelAdapters = CustomModelRegistry.makeMapModelAdapters();

    private static Map<String, ModelAdapter> makeMapModelAdapters() {
        LinkedHashMap<String, ModelAdapter> linkedHashMap = new LinkedHashMap<String, ModelAdapter>();
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterArmorStand());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterBat());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterBlaze());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterBoat());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterCaveSpider());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterChicken());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterCow());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterCreeper());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterDragon());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterEnderCrystal());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterEnderman());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterEndermite());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterGhast());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterGuardian());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterHorse());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterIronGolem());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterLeadKnot());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterMagmaCube());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterMinecart());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterMinecartTnt());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterMinecartMobSpawner());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterMooshroom());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterOcelot());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterPig());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterPigZombie());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterRabbit());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSheep());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSilverfish());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSkeleton());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSlime());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSnowman());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSpider());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSquid());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterVillager());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterWitch());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterWither());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterWitherSkull());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterWolf());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterZombie());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSheepWool());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterBanner());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterBook());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterChest());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterChestLarge());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterEnderChest());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterHeadHumanoid());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterHeadSkeleton());
        CustomModelRegistry.addModelAdapter(linkedHashMap, new ModelAdapterSign());
        return linkedHashMap;
    }

    private static void addModelAdapter(Map<String, ModelAdapter> map, ModelAdapter modelAdapter) {
        Object object;
        CustomModelRegistry.addModelAdapter(map, modelAdapter, modelAdapter.getName());
        String[] stringArray = modelAdapter.getAliases();
        if (stringArray != null) {
            for (int i = 0; i < stringArray.length; ++i) {
                object = stringArray[i];
                CustomModelRegistry.addModelAdapter(map, modelAdapter, (String)object);
            }
        }
        ModelBase modelBase = modelAdapter.makeModel();
        object = modelAdapter.getModelRendererNames();
        for (int i = 0; i < ((String[])object).length; ++i) {
            String string = object[i];
            ModelRenderer modelRenderer = modelAdapter.getModelRenderer(modelBase, string);
            if (modelRenderer != null) continue;
            Config.warn("Model renderer not found, model: " + modelAdapter.getName() + ", name: " + string);
        }
    }

    private static void addModelAdapter(Map<String, ModelAdapter> map, ModelAdapter modelAdapter, String string) {
        if (map.containsKey(string)) {
            Config.warn("Model adapter already registered for id: " + string + ", class: " + modelAdapter.getEntityClass().getName());
        }
        map.put(string, modelAdapter);
    }

    public static ModelAdapter getModelAdapter(String string) {
        return mapModelAdapters.get(string);
    }

    public static String[] getModelNames() {
        Set<String> set = mapModelAdapters.keySet();
        String[] stringArray = set.toArray(new String[set.size()]);
        return stringArray;
    }
}

