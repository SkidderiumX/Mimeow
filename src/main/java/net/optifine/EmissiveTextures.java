/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.util.PropertiesOrdered;

public class EmissiveTextures {
    private static String suffixEmissive = null;
    private static String suffixEmissivePng = null;
    private static boolean active = false;
    private static boolean render = false;
    private static boolean hasEmissive = false;
    private static boolean renderEmissive = false;
    private static float lightMapX;
    private static float lightMapY;
    private static final String SUFFIX_PNG = ".png";
    private static final ResourceLocation LOCATION_EMPTY;

    public static boolean isActive() {
        return active;
    }

    public static String getSuffixEmissive() {
        return suffixEmissive;
    }

    public static void beginRender() {
        render = true;
        hasEmissive = false;
    }

    public static ITextureObject getEmissiveTexture(ITextureObject iTextureObject, Map<ResourceLocation, ITextureObject> map) {
        ITextureObject iTextureObject2;
        if (!render) {
            return iTextureObject;
        }
        if (!(iTextureObject instanceof SimpleTexture)) {
            return iTextureObject;
        }
        SimpleTexture simpleTexture = (SimpleTexture)iTextureObject;
        ResourceLocation resourceLocation = simpleTexture.locationEmissive;
        if (!renderEmissive) {
            if (resourceLocation != null) {
                hasEmissive = true;
            }
            return iTextureObject;
        }
        if (resourceLocation == null) {
            resourceLocation = LOCATION_EMPTY;
        }
        if ((iTextureObject2 = map.get(resourceLocation)) == null) {
            iTextureObject2 = new SimpleTexture(resourceLocation);
            TextureManager textureManager = Config.getTextureManager();
            textureManager.loadTexture(resourceLocation, iTextureObject2);
        }
        return iTextureObject2;
    }

    public static boolean hasEmissive() {
        return hasEmissive;
    }

    public static void beginRenderEmissive() {
        lightMapX = OpenGlHelper.lastBrightnessX;
        lightMapY = OpenGlHelper.lastBrightnessY;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, lightMapY);
        renderEmissive = true;
    }

    public static void endRenderEmissive() {
        renderEmissive = false;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightMapX, lightMapY);
    }

    public static void endRender() {
        render = false;
        hasEmissive = false;
    }

    public static void update() {
        active = false;
        suffixEmissive = null;
        suffixEmissivePng = null;
        if (Config.isEmissiveTextures()) {
            try {
                String string = "optifine/emissive.properties";
                ResourceLocation resourceLocation = new ResourceLocation(string);
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                if (inputStream2 == null) {
                    return;
                }
                EmissiveTextures.dbg("Loading " + string);
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                suffixEmissive = propertiesOrdered.getProperty("suffix.emissive");
                if (suffixEmissive != null) {
                    suffixEmissivePng = suffixEmissive + SUFFIX_PNG;
                }
                active = suffixEmissive != null;
            }
            catch (FileNotFoundException fileNotFoundException) {
                return;
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    private static void dbg(String string) {
        Config.dbg("EmissiveTextures: " + string);
    }

    private static void warn(String string) {
        Config.warn("EmissiveTextures: " + string);
    }

    public static boolean isEmissive(ResourceLocation resourceLocation) {
        return suffixEmissivePng == null ? false : resourceLocation.getResourcePath().endsWith(suffixEmissivePng);
    }

    public static void loadTexture(ResourceLocation resourceLocation, SimpleTexture simpleTexture) {
        if (resourceLocation != null && simpleTexture != null) {
            String string;
            simpleTexture.isEmissive = false;
            simpleTexture.locationEmissive = null;
            if (suffixEmissivePng != null && (string = resourceLocation.getResourcePath()).endsWith(SUFFIX_PNG)) {
                if (string.endsWith(suffixEmissivePng)) {
                    simpleTexture.isEmissive = true;
                } else {
                    String string2 = string.substring(0, string.length() - SUFFIX_PNG.length()) + suffixEmissivePng;
                    ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string2);
                    if (Config.hasResource(resourceLocation2)) {
                        simpleTexture.locationEmissive = resourceLocation2;
                    }
                }
            }
        }
    }

    static {
        LOCATION_EMPTY = new ResourceLocation("mcpatcher/ctm/default/empty.png");
    }
}

