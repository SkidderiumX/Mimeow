/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import net.minecraft.block.state.BlockStateBase;
import net.minecraft.block.state.IBlockState;
import net.minecraft.src.Config;
import net.minecraft.util.EnumWorldBlockLayer;
import net.optifine.config.ConnectedParser;
import net.optifine.config.MatchBlock;
import net.optifine.shaders.BlockAliases;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;

public class CustomBlockLayers {
    private static EnumWorldBlockLayer[] renderLayers = null;
    public static boolean active = false;

    public static EnumWorldBlockLayer getRenderLayer(IBlockState iBlockState) {
        if (renderLayers == null) {
            return null;
        }
        if (iBlockState.getBlock().isOpaqueCube()) {
            return null;
        }
        if (!(iBlockState instanceof BlockStateBase)) {
            return null;
        }
        BlockStateBase blockStateBase = (BlockStateBase)iBlockState;
        int n = blockStateBase.getBlockId();
        return n > 0 && n < renderLayers.length ? renderLayers[n] : null;
    }

    public static void update() {
        PropertiesOrdered propertiesOrdered;
        renderLayers = null;
        active = false;
        ArrayList<EnumWorldBlockLayer> arrayList = new ArrayList<EnumWorldBlockLayer>();
        String string = "optifine/block.properties";
        Properties properties = ResUtils.readProperties(string, "CustomBlockLayers");
        if (properties != null) {
            CustomBlockLayers.readLayers(string, properties, arrayList);
        }
        if (Config.isShaders() && (propertiesOrdered = BlockAliases.getBlockLayerPropertes()) != null) {
            String string2 = "shaders/block.properties";
            CustomBlockLayers.readLayers(string2, propertiesOrdered, arrayList);
        }
        if (!arrayList.isEmpty()) {
            renderLayers = arrayList.toArray(new EnumWorldBlockLayer[arrayList.size()]);
            active = true;
        }
    }

    private static void readLayers(String string, Properties properties, List<EnumWorldBlockLayer> list) {
        Config.dbg("CustomBlockLayers: " + string);
        CustomBlockLayers.readLayer("solid", EnumWorldBlockLayer.SOLID, properties, list);
        CustomBlockLayers.readLayer("cutout", EnumWorldBlockLayer.CUTOUT, properties, list);
        CustomBlockLayers.readLayer("cutout_mipped", EnumWorldBlockLayer.CUTOUT_MIPPED, properties, list);
        CustomBlockLayers.readLayer("translucent", EnumWorldBlockLayer.TRANSLUCENT, properties, list);
    }

    private static void readLayer(String string, EnumWorldBlockLayer enumWorldBlockLayer, Properties properties, List<EnumWorldBlockLayer> list) {
        ConnectedParser connectedParser;
        MatchBlock[] matchBlockArray;
        String string2 = "layer." + string;
        String string3 = properties.getProperty(string2);
        if (string3 != null && (matchBlockArray = (connectedParser = new ConnectedParser("CustomBlockLayers")).parseMatchBlocks(string3)) != null) {
            for (int i = 0; i < matchBlockArray.length; ++i) {
                MatchBlock matchBlock = matchBlockArray[i];
                int n = matchBlock.getBlockId();
                if (n <= 0) continue;
                while (list.size() < n + 1) {
                    list.add(null);
                }
                if (list.get(n) != null) {
                    Config.warn("CustomBlockLayers: Block layer is already set, block: " + n + ", layer: " + string);
                }
                list.set(n, enumWorldBlockLayer);
            }
        }
    }

    public static boolean isActive() {
        return active;
    }
}

