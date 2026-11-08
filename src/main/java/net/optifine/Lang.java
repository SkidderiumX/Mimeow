/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class Lang {
    private static final Splitter splitter = Splitter.on('=').limit(2);
    private static final Pattern pattern = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");

    public static void resourcesReloaded() {
        Map map = I18n.getLocaleProperties();
        ArrayList<CallSite> arrayList = new ArrayList<CallSite>();
        String string = "optifine/lang/";
        String string2 = "en_US";
        String string3 = ".lang";
        arrayList.add((CallSite)((Object)(string + string2 + string3)));
        if (!Config.getGameSettings().language.equals(string2)) {
            arrayList.add((CallSite)((Object)(string + Config.getGameSettings().language + string3)));
        }
        String[] stringArray = arrayList.toArray(new String[arrayList.size()]);
        Lang.loadResources(Config.getDefaultResourcePack(), stringArray, map);
        IResourcePack[] iResourcePackArray = Config.getResourcePacks();
        for (int i = 0; i < iResourcePackArray.length; ++i) {
            IResourcePack iResourcePack = iResourcePackArray[i];
            Lang.loadResources(iResourcePack, stringArray, map);
        }
    }

    private static void loadResources(IResourcePack iResourcePack, String[] stringArray, Map map) {
        try {
            for (int i = 0; i < stringArray.length; ++i) {
                InputStream inputStream2;
                String string = stringArray[i];
                ResourceLocation resourceLocation = new ResourceLocation(string);
                if (!iResourcePack.resourceExists(resourceLocation) || (inputStream2 = iResourcePack.getInputStream(resourceLocation)) == null) continue;
                Lang.loadLocaleData(inputStream2, map);
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public static void loadLocaleData(InputStream inputStream2, Map map) throws IOException {
        Iterator<String> iterator2 = IOUtils.readLines(inputStream2, Charsets.UTF_8).iterator();
        inputStream2.close();
        while (iterator2.hasNext()) {
            String[] stringArray;
            String string = iterator2.next();
            if (string.isEmpty() || string.charAt(0) == '#' || (stringArray = Iterables.toArray(splitter.split(string), String.class)) == null || stringArray.length != 2) continue;
            String string2 = stringArray[0];
            String string3 = pattern.matcher(stringArray[1]).replaceAll("%$1s");
            map.put(string2, string3);
        }
    }

    public static String get(String string) {
        return I18n.format(string, new Object[0]);
    }

    public static String get(String string, String string2) {
        String string3 = I18n.format(string, new Object[0]);
        return string3 != null && !string3.equals(string) ? string3 : string2;
    }

    public static String getOn() {
        return I18n.format("options.on", new Object[0]);
    }

    public static String getOff() {
        return I18n.format("options.off", new Object[0]);
    }

    public static String getFast() {
        return I18n.format("options.graphics.fast", new Object[0]);
    }

    public static String getFancy() {
        return I18n.format("options.graphics.fancy", new Object[0]);
    }

    public static String getDefault() {
        return I18n.format("generator.default", new Object[0]);
    }
}

