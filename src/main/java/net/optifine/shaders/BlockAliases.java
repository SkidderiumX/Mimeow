/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorCompat;
import net.optifine.shaders.BlockAlias;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.MacroProcessor;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.StrUtils;

public class BlockAliases {
    private static BlockAlias[][] blockAliases = null;
    private static PropertiesOrdered blockLayerPropertes = null;
    private static boolean updateOnResourcesReloaded;

    public static int getBlockAliasId(int n, int n2) {
        if (blockAliases == null) {
            return n;
        }
        if (n >= 0 && n < blockAliases.length) {
            BlockAlias[] blockAliasArray = blockAliases[n];
            if (blockAliasArray == null) {
                return n;
            }
            for (int i = 0; i < blockAliasArray.length; ++i) {
                BlockAlias blockAlias = blockAliasArray[i];
                if (!blockAlias.matches(n, n2)) continue;
                return blockAlias.getBlockAliasId();
            }
            return n;
        }
        return n;
    }

    public static void resourcesReloaded() {
        if (updateOnResourcesReloaded) {
            updateOnResourcesReloaded = false;
            BlockAliases.update(Shaders.getShaderPack());
        }
    }

    public static void update(IShaderPack iShaderPack) {
        BlockAliases.reset();
        if (iShaderPack != null) {
            if (Reflector.Loader_getActiveModList.exists() && Minecraft.getMinecraft().getResourcePackRepository() == null) {
                Config.dbg("[Shaders] Delayed loading of block mappings after resources are loaded");
                updateOnResourcesReloaded = true;
            } else {
                ArrayList<List<BlockAlias>> arrayList = new ArrayList<List<BlockAlias>>();
                String string = "/shaders/block.properties";
                InputStream inputStream2 = iShaderPack.getResourceAsStream(string);
                if (inputStream2 != null) {
                    BlockAliases.loadBlockAliases(inputStream2, string, arrayList);
                }
                BlockAliases.loadModBlockAliases(arrayList);
                if (arrayList.size() > 0) {
                    blockAliases = BlockAliases.toArrays(arrayList);
                }
            }
        }
    }

    private static void loadModBlockAliases(List<List<BlockAlias>> list) {
        String[] stringArray = ReflectorCompat.getCompatModIds();
        for (int i = 0; i < stringArray.length; ++i) {
            String string = stringArray[i];
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string, "shaders/block.properties");
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                BlockAliases.loadBlockAliases(inputStream2, resourceLocation.toString(), list);
                continue;
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
    }

    private static void loadBlockAliases(InputStream inputStream2, String string, List<List<BlockAlias>> list) {
        if (inputStream2 != null) {
            try {
                inputStream2 = MacroProcessor.process(inputStream2, string);
                PropertiesOrdered propertiesOrdered = new PropertiesOrdered();
                propertiesOrdered.load(inputStream2);
                inputStream2.close();
                Config.dbg("[Shaders] Parsing block mappings: " + string);
                ConnectedParser connectedParser = new ConnectedParser("Shaders");
                for (Object object : ((Properties)propertiesOrdered).keySet()) {
                    String string2 = (String)object;
                    String string3 = propertiesOrdered.getProperty(string2);
                    if (string2.startsWith("layer.")) {
                        if (blockLayerPropertes == null) {
                            blockLayerPropertes = new PropertiesOrdered();
                        }
                        blockLayerPropertes.put(string2, string3);
                        continue;
                    }
                    String string4 = "block.";
                    if (!string2.startsWith(string4)) {
                        Config.warn("[Shaders] Invalid block ID: " + string2);
                        continue;
                    }
                    String string5 = StrUtils.removePrefix(string2, string4);
                    int n = Config.parseInt(string5, -1);
                    if (n < 0) {
                        Config.warn("[Shaders] Invalid block ID: " + string2);
                        continue;
                    }
                    MatchBlock[] matchBlockArray = connectedParser.parseMatchBlocks(string3);
                    if (matchBlockArray != null && matchBlockArray.length >= 1) {
                        BlockAlias blockAlias = new BlockAlias(n, matchBlockArray);
                        BlockAliases.addToList(list, blockAlias);
                        continue;
                    }
                    Config.warn("[Shaders] Invalid block ID mapping: " + string2 + "=" + string3);
                }
            }
            catch (IOException iOException) {
                Config.warn("[Shaders] Error reading: " + string);
            }
        }
    }

    private static void addToList(List<List<BlockAlias>> list, BlockAlias blockAlias) {
        int[] nArray = blockAlias.getMatchBlockIds();
        for (int i = 0; i < nArray.length; ++i) {
            int n = nArray[i];
            while (n >= list.size()) {
                list.add(null);
            }
            List<BlockAlias> list2 = list.get(n);
            if (list2 == null) {
                list2 = new ArrayList<BlockAlias>();
                list.set(n, list2);
            }
            BlockAlias blockAlias2 = new BlockAlias(blockAlias.getBlockAliasId(), blockAlias.getMatchBlocks(n));
            list2.add(blockAlias2);
        }
    }

    private static BlockAlias[][] toArrays(List<List<BlockAlias>> list) {
        BlockAlias[][] blockAliasArray = new BlockAlias[list.size()][];
        for (int i = 0; i < blockAliasArray.length; ++i) {
            List<BlockAlias> list2 = list.get(i);
            if (list2 == null) continue;
            blockAliasArray[i] = list2.toArray(new BlockAlias[list2.size()]);
        }
        return blockAliasArray;
    }

    public static PropertiesOrdered getBlockLayerPropertes() {
        return blockLayerPropertes;
    }

    public static void reset() {
        blockAliases = null;
        blockLayerPropertes = null;
    }
}

