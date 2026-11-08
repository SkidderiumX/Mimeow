/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.entity.model;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.entity.model.CustomEntityModelParser;
import net.optifine.entity.model.CustomEntityRenderer;
import net.optifine.entity.model.CustomModelRegistry;
import net.optifine.entity.model.CustomModelRenderer;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.entity.model.ModelAdapter;
import net.optifine.entity.model.anim.ModelResolver;
import net.optifine.entity.model.anim.ModelUpdater;

public class CustomEntityModels {
    private static boolean active = false;
    private static Map<Class, Render> originalEntityRenderMap = null;
    private static Map<Class, TileEntitySpecialRenderer> originalTileEntityRenderMap = null;

    public static void update() {
        Map<Class, Render> map = CustomEntityModels.getEntityRenderMap();
        Map<Class, TileEntitySpecialRenderer> map2 = CustomEntityModels.getTileEntityRenderMap();
        if (map == null) {
            Config.warn("Entity render map not found, custom entity models are DISABLED.");
        } else if (map2 == null) {
            Config.warn("Tile entity render map not found, custom entity models are DISABLED.");
        } else {
            active = false;
            map.clear();
            map2.clear();
            map.putAll(originalEntityRenderMap);
            map2.putAll(originalTileEntityRenderMap);
            if (Config.isCustomEntityModels()) {
                ResourceLocation[] resourceLocationArray = CustomEntityModels.getModelLocations();
                for (int i = 0; i < resourceLocationArray.length; ++i) {
                    Class clazz;
                    ResourceLocation resourceLocation = resourceLocationArray[i];
                    Config.dbg("CustomEntityModel: " + resourceLocation.getResourcePath());
                    IEntityRenderer iEntityRenderer = CustomEntityModels.parseEntityRender(resourceLocation);
                    if (iEntityRenderer == null || (clazz = iEntityRenderer.getEntityClass()) == null) continue;
                    if (iEntityRenderer instanceof Render) {
                        map.put(clazz, (Render)iEntityRenderer);
                    } else if (iEntityRenderer instanceof TileEntitySpecialRenderer) {
                        map2.put(clazz, (TileEntitySpecialRenderer)iEntityRenderer);
                    } else {
                        Config.warn("Unknown renderer type: " + iEntityRenderer.getClass().getName());
                    }
                    active = true;
                }
            }
        }
    }

    private static Map<Class, Render> getEntityRenderMap() {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        Map<Class, Render> map = renderManager.getEntityRenderMap();
        if (map == null) {
            return null;
        }
        if (originalEntityRenderMap == null) {
            originalEntityRenderMap = new HashMap<Class, Render>(map);
        }
        return map;
    }

    private static Map<Class, TileEntitySpecialRenderer> getTileEntityRenderMap() {
        Map<Class, TileEntitySpecialRenderer> map = TileEntityRendererDispatcher.instance.mapSpecialRenderers;
        if (originalTileEntityRenderMap == null) {
            originalTileEntityRenderMap = new HashMap<Class, TileEntitySpecialRenderer>(map);
        }
        return map;
    }

    private static ResourceLocation[] getModelLocations() {
        String string = "optifine/cem/";
        String string2 = ".jem";
        ArrayList<ResourceLocation> arrayList = new ArrayList<ResourceLocation>();
        String[] stringArray = CustomModelRegistry.getModelNames();
        for (int i = 0; i < stringArray.length; ++i) {
            String string3 = stringArray[i];
            String string4 = string + string3 + string2;
            ResourceLocation resourceLocation = new ResourceLocation(string4);
            if (!Config.hasResource(resourceLocation)) continue;
            arrayList.add(resourceLocation);
        }
        ResourceLocation[] resourceLocationArray = arrayList.toArray(new ResourceLocation[arrayList.size()]);
        return resourceLocationArray;
    }

    private static IEntityRenderer parseEntityRender(ResourceLocation resourceLocation) {
        try {
            JsonObject jsonObject = CustomEntityModelParser.loadJson(resourceLocation);
            IEntityRenderer iEntityRenderer = CustomEntityModels.parseEntityRender(jsonObject, resourceLocation.getResourcePath());
            return iEntityRenderer;
        }
        catch (IOException iOException) {
            Config.error(iOException.getClass().getName() + ": " + iOException.getMessage());
            return null;
        }
        catch (JsonParseException jsonParseException) {
            Config.error(jsonParseException.getClass().getName() + ": " + jsonParseException.getMessage());
            return null;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    private static IEntityRenderer parseEntityRender(JsonObject jsonObject, String string) {
        CustomEntityRenderer customEntityRenderer = CustomEntityModelParser.parseEntityRender(jsonObject, string);
        String string2 = customEntityRenderer.getName();
        ModelAdapter modelAdapter = CustomModelRegistry.getModelAdapter(string2);
        CustomEntityModels.checkNull(modelAdapter, "Entity not found: " + string2);
        Class clazz = modelAdapter.getEntityClass();
        CustomEntityModels.checkNull(clazz, "Entity class not found: " + string2);
        IEntityRenderer iEntityRenderer = CustomEntityModels.makeEntityRender(modelAdapter, customEntityRenderer);
        if (iEntityRenderer == null) {
            return null;
        }
        iEntityRenderer.setEntityClass(clazz);
        return iEntityRenderer;
    }

    private static IEntityRenderer makeEntityRender(ModelAdapter modelAdapter, CustomEntityRenderer customEntityRenderer) {
        ModelBase modelBase;
        ResourceLocation resourceLocation = customEntityRenderer.getTextureLocation();
        CustomModelRenderer[] customModelRendererArray = customEntityRenderer.getCustomModelRenderers();
        float f = customEntityRenderer.getShadowSize();
        if (f < 0.0f) {
            f = modelAdapter.getShadowSize();
        }
        if ((modelBase = modelAdapter.makeModel()) == null) {
            return null;
        }
        ModelResolver modelResolver = new ModelResolver(modelAdapter, modelBase, customModelRendererArray);
        if (!CustomEntityModels.modifyModel(modelAdapter, modelBase, customModelRendererArray, modelResolver)) {
            return null;
        }
        IEntityRenderer iEntityRenderer = modelAdapter.makeEntityRender(modelBase, f);
        if (iEntityRenderer == null) {
            throw new JsonParseException("Entity renderer is null, model: " + modelAdapter.getName() + ", adapter: " + modelAdapter.getClass().getName());
        }
        if (resourceLocation != null) {
            iEntityRenderer.setLocationTextureCustom(resourceLocation);
        }
        return iEntityRenderer;
    }

    private static boolean modifyModel(ModelAdapter modelAdapter, ModelBase modelBase, CustomModelRenderer[] customModelRendererArray, ModelResolver modelResolver) {
        for (int i = 0; i < customModelRendererArray.length; ++i) {
            CustomModelRenderer customModelRenderer = customModelRendererArray[i];
            if (CustomEntityModels.modifyModel(modelAdapter, modelBase, customModelRenderer, modelResolver)) continue;
            return false;
        }
        return true;
    }

    private static boolean modifyModel(ModelAdapter modelAdapter, ModelBase modelBase, CustomModelRenderer customModelRenderer, ModelResolver modelResolver) {
        ModelRenderer[] modelRendererArray;
        String string = customModelRenderer.getModelPart();
        ModelRenderer modelRenderer = modelAdapter.getModelRenderer(modelBase, string);
        if (modelRenderer == null) {
            Config.warn("Model part not found: " + string + ", model: " + String.valueOf(modelBase));
            return false;
        }
        if (!customModelRenderer.isAttach()) {
            if (modelRenderer.cubeList != null) {
                modelRenderer.cubeList.clear();
            }
            if (modelRenderer.spriteList != null) {
                modelRenderer.spriteList.clear();
            }
            if (modelRenderer.childModels != null) {
                modelRendererArray = modelAdapter.getModelRenderers(modelBase);
                Set set = Collections.newSetFromMap(new IdentityHashMap());
                set.addAll(Arrays.asList(modelRendererArray));
                List<ModelRenderer> list = modelRenderer.childModels;
                Iterator<ModelRenderer> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    ModelRenderer modelRenderer2 = iterator2.next();
                    if (set.contains(modelRenderer2)) continue;
                    iterator2.remove();
                }
            }
        }
        modelRenderer.addChild(customModelRenderer.getModelRenderer());
        modelRendererArray = customModelRenderer.getModelUpdater();
        if (modelRendererArray != null) {
            modelResolver.setThisModelRenderer(customModelRenderer.getModelRenderer());
            modelResolver.setPartModelRenderer(modelRenderer);
            if (!modelRendererArray.initialize(modelResolver)) {
                return false;
            }
            customModelRenderer.getModelRenderer().setModelUpdater((ModelUpdater)modelRendererArray);
        }
        return true;
    }

    private static void checkNull(Object object, String string) {
        if (object == null) {
            throw new JsonParseException(string);
        }
    }

    public static boolean isActive() {
        return active;
    }
}

