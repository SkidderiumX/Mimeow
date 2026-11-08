/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.util.PropertiesOrdered;

public class FontUtils {
    public static Properties readFontProperties(ResourceLocation resourceLocation) {
        String string = resourceLocation.getResourcePath();
        PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
        String string2 = ".png";
        if (!string.endsWith(string2)) {
            return propertiesOrdered;
        }
        String string3 = string.substring(0, string.length() - string2.length()) + ".properties";
        try {
            ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), string3);
            InputStream inputStream2 = Config.getResourceStream(Config.getResourceManager(), resourceLocation2);
            if (inputStream2 == null) {
                return propertiesOrdered;
            }
            Config.log("Loading " + string3);
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        return propertiesOrdered;
    }

    public static void readCustomCharWidths(Properties properties, float[] fArray) {
        for (Object object : properties.keySet()) {
            String string;
            float f;
            String string2;
            int n;
            String string3;
            String string4 = (String)object;
            if (!string4.startsWith(string3 = "width.") || (n = Config.parseInt(string2 = string4.substring(string3.length()), -1)) < 0 || n >= fArray.length || !((f = Config.parseFloat(string = properties.getProperty(string4), -1.0f)) >= 0.0f)) continue;
            fArray[n] = f;
        }
    }

    public static float readFloat(Properties properties, String string, float f) {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            return f;
        }
        float f2 = Config.parseFloat(string2, Float.MIN_VALUE);
        if (f2 == Float.MIN_VALUE) {
            Config.warn("Invalid value for " + string + ": " + string2);
            return f;
        }
        return f2;
    }

    public static boolean readBoolean(Properties properties, String string, boolean bl) {
        String string2 = properties.getProperty(string);
        if (string2 == null) {
            return bl;
        }
        String string3 = string2.toLowerCase().trim();
        if (!string3.equals("true") && !string3.equals("on")) {
            if (!string3.equals("false") && !string3.equals("off")) {
                Config.warn("Invalid value for " + string + ": " + string2);
                return bl;
            }
            return false;
        }
        return true;
    }

    public static ResourceLocation getHdFontLocation(ResourceLocation resourceLocation) {
        if (!Config.isCustomFonts()) {
            return resourceLocation;
        }
        if (resourceLocation == null) {
            return resourceLocation;
        }
        if (!Config.isMinecraftThread()) {
            return resourceLocation;
        }
        Object object = resourceLocation.getResourcePath();
        String string = "textures/";
        String string2 = "mcpatcher/";
        if (!((String)object).startsWith(string)) {
            return resourceLocation;
        }
        object = ((String)object).substring(string.length());
        object = string2 + (String)object;
        ResourceLocation resourceLocation2 = new ResourceLocation(resourceLocation.getResourceDomain(), (String)object);
        return Config.hasResource(Config.getResourceManager(), resourceLocation2) ? resourceLocation2 : resourceLocation;
    }
}

