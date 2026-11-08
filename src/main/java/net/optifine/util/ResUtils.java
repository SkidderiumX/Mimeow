/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.StrUtils;

public class ResUtils {
    public static String[] collectFiles(String string, String string2) {
        return ResUtils.collectFiles(new String[]{string}, new String[]{string2});
    }

    public static String[] collectFiles(String[] stringArray, String[] stringArray2) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        IResourcePack[] iResourcePackArray = Config.getResourcePacks();
        for (int i = 0; i < iResourcePackArray.length; ++i) {
            IResourcePack iResourcePack = iResourcePackArray[i];
            String[] stringArray3 = ResUtils.collectFiles(iResourcePack, stringArray, stringArray2, (String[])null);
            linkedHashSet.addAll(Arrays.asList(stringArray3));
        }
        String[] stringArray4 = linkedHashSet.toArray(new String[linkedHashSet.size()]);
        return stringArray4;
    }

    public static String[] collectFiles(IResourcePack iResourcePack, String string, String string2, String[] stringArray) {
        return ResUtils.collectFiles(iResourcePack, new String[]{string}, new String[]{string2}, stringArray);
    }

    public static String[] collectFiles(IResourcePack iResourcePack, String[] stringArray, String[] stringArray2) {
        return ResUtils.collectFiles(iResourcePack, stringArray, stringArray2, (String[])null);
    }

    public static String[] collectFiles(IResourcePack iResourcePack, String[] stringArray, String[] stringArray2, String[] stringArray3) {
        if (iResourcePack instanceof DefaultResourcePack) {
            return ResUtils.collectFilesFixed(iResourcePack, stringArray3);
        }
        if (!(iResourcePack instanceof AbstractResourcePack)) {
            Config.warn("Unknown resource pack type: " + String.valueOf(iResourcePack));
            return new String[0];
        }
        AbstractResourcePack abstractResourcePack = (AbstractResourcePack)iResourcePack;
        File file = abstractResourcePack.resourcePackFile;
        if (file == null) {
            return new String[0];
        }
        if (file.isDirectory()) {
            return ResUtils.collectFilesFolder(file, "", stringArray, stringArray2);
        }
        if (file.isFile()) {
            return ResUtils.collectFilesZIP(file, stringArray, stringArray2);
        }
        Config.warn("Unknown resource pack file: " + String.valueOf(file));
        return new String[0];
    }

    private static String[] collectFilesFixed(IResourcePack iResourcePack, String[] stringArray) {
        if (stringArray == null) {
            return new String[0];
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            ResourceLocation resourceLocation = new ResourceLocation(string);
            if (!iResourcePack.resourceExists(resourceLocation)) continue;
            arrayList.add(string);
        }
        String[] stringArray2 = arrayList.toArray(new String[arrayList.size()]);
        return stringArray2;
    }

    private static String[] collectFilesFolder(File file, String string, String[] stringArray, String[] stringArray2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = "assets/minecraft/";
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return new String[0];
        }
        for (int i = 0; i < fileArray.length; ++i) {
            Object object;
            File file2 = fileArray[i];
            if (file2.isFile()) {
                object = string + file2.getName();
                if (!((String)object).startsWith(string2) || !StrUtils.startsWith((String)(object = ((String)object).substring(string2.length())), stringArray) || !StrUtils.endsWith((String)object, stringArray2)) continue;
                arrayList.add(object);
                continue;
            }
            if (!file2.isDirectory()) continue;
            object = string + file2.getName() + "/";
            String[] stringArray3 = ResUtils.collectFilesFolder(file2, (String)object, stringArray, stringArray2);
            for (int j = 0; j < stringArray3.length; ++j) {
                String string3 = stringArray3[j];
                arrayList.add(string3);
            }
        }
        String[] stringArray4 = arrayList.toArray(new String[arrayList.size()]);
        return stringArray4;
    }

    private static String[] collectFilesZIP(File file, String[] stringArray, String[] stringArray2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string = "assets/minecraft/";
        try {
            String[] stringArray3;
            ZipFile zipFile = new ZipFile(file);
            Enumeration<? extends ZipEntry> enumeration = zipFile.entries();
            while (enumeration.hasMoreElements()) {
                stringArray3 = enumeration.nextElement();
                String string2 = stringArray3.getName();
                if (!string2.startsWith(string) || !StrUtils.startsWith(string2 = string2.substring(string.length()), stringArray) || !StrUtils.endsWith(string2, stringArray2)) continue;
                arrayList.add(string2);
            }
            zipFile.close();
            stringArray3 = arrayList.toArray(new String[arrayList.size()]);
            return stringArray3;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return new String[0];
        }
    }

    private static boolean isLowercase(String string) {
        return string.equals(string.toLowerCase(Locale.ROOT));
    }

    public static Properties readProperties(String string, String string2) {
        ResourceLocation resourceLocation = new ResourceLocation(string);
        try {
            InputStream inputStream2 = Config.getResourceStream(resourceLocation);
            if (inputStream2 == null) {
                return null;
            }
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            Config.dbg(string2 + ": Loading " + string);
            return propertiesOrdered;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (IOException iOException) {
            Config.warn(string2 + ": Error reading " + string);
            return null;
        }
    }

    public static Properties readProperties(InputStream inputStream2, String string) {
        if (inputStream2 == null) {
            return null;
        }
        try {
            PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
            propertiesOrdered.load(inputStream2);
            inputStream2.close();
            return propertiesOrdered;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
        catch (IOException iOException) {
            return null;
        }
    }
}

