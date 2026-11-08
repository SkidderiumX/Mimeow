/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.CustomSkyLayer;
import net.optifine.render.Blender;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.TextureUtils;

public class CustomSky {
    private static CustomSkyLayer[][] worldSkyLayers = null;

    public static void reset() {
        worldSkyLayers = null;
    }

    public static void update() {
        CustomSky.reset();
        if (Config.isCustomSky()) {
            worldSkyLayers = CustomSky.readCustomSkies();
        }
    }

    private static CustomSkyLayer[][] readCustomSkies() {
        String string;
        int n;
        CustomSkyLayer[][] customSkyLayerArray = new CustomSkyLayer[10][0];
        String string2 = "mcpatcher/sky/world";
        int n2 = -1;
        for (n = 0; n < customSkyLayerArray.length; ++n) {
            string = string2 + n + "/sky";
            ArrayList<CustomSkyLayer> arrayList = new ArrayList<CustomSkyLayer>();
            for (int i = 1; i < 1000; ++i) {
                String string3 = string + i + ".properties";
                try {
                    ResourceLocation resourceLocation = new ResourceLocation(string3);
                    InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                    if (inputStream2 == null) break;
                    PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                    propertiesOrdered.load(inputStream2);
                    inputStream2.close();
                    Config.dbg("CustomSky properties: " + string3);
                    String string4 = string + i + ".png";
                    CustomSkyLayer customSkyLayer = new CustomSkyLayer(propertiesOrdered, string4);
                    if (!customSkyLayer.isValid(string3)) continue;
                    ResourceLocation resourceLocation2 = new ResourceLocation(customSkyLayer.source);
                    ITextureObject iTextureObject = TextureUtils.getTexture(resourceLocation2);
                    if (iTextureObject == null) {
                        Config.log("CustomSky: Texture not found: " + String.valueOf(resourceLocation2));
                        continue;
                    }
                    customSkyLayer.textureId = iTextureObject.getGlTextureId();
                    arrayList.add(customSkyLayer);
                    inputStream2.close();
                    continue;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    break;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (arrayList.size() <= 0) continue;
            CustomSkyLayer[] customSkyLayerArray2 = arrayList.toArray(new CustomSkyLayer[arrayList.size()]);
            customSkyLayerArray[n] = customSkyLayerArray2;
            n2 = n;
        }
        if (n2 < 0) {
            return null;
        }
        n = n2 + 1;
        string = new CustomSkyLayer[n][0];
        for (int i = 0; i < ((CustomSkyLayer[][])string).length; ++i) {
            string[i] = customSkyLayerArray[i];
        }
        return string;
    }

    public static void renderSky(World world2, TextureManager textureManager, float f) {
        CustomSkyLayer[] customSkyLayerArray;
        int n;
        if (worldSkyLayers != null && (n = world2.provider.getDimensionId()) >= 0 && n < worldSkyLayers.length && (customSkyLayerArray = worldSkyLayers[n]) != null) {
            long l = world2.getWorldTime();
            int n2 = (int)(l % 24000L);
            float f2 = world2.getCelestialAngle(f);
            float f3 = world2.getRainStrength(f);
            float f4 = world2.getThunderStrength(f);
            if (f3 > 0.0f) {
                f4 /= f3;
            }
            for (int i = 0; i < customSkyLayerArray.length; ++i) {
                CustomSkyLayer customSkyLayer = customSkyLayerArray[i];
                if (!customSkyLayer.isActive(world2, n2)) continue;
                customSkyLayer.render(world2, n2, f2, f3, f4);
            }
            float f5 = 1.0f - f3;
            Blender.clearBlend(f5);
        }
    }

    public static boolean hasSkyLayers(World world2) {
        if (worldSkyLayers == null) {
            return false;
        }
        int n = world2.provider.getDimensionId();
        if (n >= 0 && n < worldSkyLayers.length) {
            CustomSkyLayer[] customSkyLayerArray = worldSkyLayers[n];
            return customSkyLayerArray == null ? false : customSkyLayerArray.length > 0;
        }
        return false;
    }
}

