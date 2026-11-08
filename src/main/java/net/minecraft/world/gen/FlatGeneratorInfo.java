/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.FlatLayerInfo;

public class FlatGeneratorInfo {
    private final List<FlatLayerInfo> flatLayers = Lists.newArrayList();
    private final Map<String, Map<String, String>> worldFeatures = Maps.newHashMap();
    private int biomeToUse;

    public int getBiome() {
        return this.biomeToUse;
    }

    public void setBiome(int n) {
        this.biomeToUse = n;
    }

    public Map<String, Map<String, String>> getWorldFeatures() {
        return this.worldFeatures;
    }

    public List<FlatLayerInfo> getFlatLayers() {
        return this.flatLayers;
    }

    public void func_82645_d() {
        int n = 0;
        for (FlatLayerInfo flatLayerInfo : this.flatLayers) {
            flatLayerInfo.setMinY(n);
            n += flatLayerInfo.getLayerCount();
        }
    }

    public String toString() {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(3);
        stringBuilder.append(";");
        for (n = 0; n < this.flatLayers.size(); ++n) {
            if (n > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(this.flatLayers.get(n).toString());
        }
        stringBuilder.append(";");
        stringBuilder.append(this.biomeToUse);
        if (!this.worldFeatures.isEmpty()) {
            stringBuilder.append(";");
            n = 0;
            for (Map.Entry<String, Map<String, String>> entry : this.worldFeatures.entrySet()) {
                if (n++ > 0) {
                    stringBuilder.append(",");
                }
                stringBuilder.append(entry.getKey().toLowerCase());
                Map<String, String> map = entry.getValue();
                if (map.isEmpty()) continue;
                stringBuilder.append("(");
                int n2 = 0;
                for (Map.Entry<String, String> entry2 : map.entrySet()) {
                    if (n2++ > 0) {
                        stringBuilder.append(" ");
                    }
                    stringBuilder.append(entry2.getKey());
                    stringBuilder.append("=");
                    stringBuilder.append(entry2.getValue());
                }
                stringBuilder.append(")");
            }
        } else {
            stringBuilder.append(";");
        }
        return stringBuilder.toString();
    }

    private static FlatLayerInfo func_180715_a(int n, String string, int n2) {
        Object object;
        String[] stringArray = n >= 3 ? string.split("\\*", 2) : string.split("x", 2);
        int n3 = 1;
        int n4 = 0;
        if (stringArray.length == 2) {
            try {
                n3 = Integer.parseInt(stringArray[0]);
                if (n2 + n3 >= 256) {
                    n3 = 256 - n2;
                }
                if (n3 < 0) {
                    n3 = 0;
                }
            }
            catch (Throwable throwable) {
                return null;
            }
        }
        Block block = null;
        try {
            object = stringArray[stringArray.length - 1];
            if (n < 3) {
                stringArray = ((String)object).split(":", 2);
                if (stringArray.length > 1) {
                    n4 = Integer.parseInt(stringArray[1]);
                }
                block = Block.getBlockById(Integer.parseInt(stringArray[0]));
            } else {
                stringArray = ((String)object).split(":", 3);
                Block block2 = block = stringArray.length > 1 ? Block.getBlockFromName(stringArray[0] + ":" + stringArray[1]) : null;
                if (block != null) {
                    n4 = stringArray.length > 2 ? Integer.parseInt(stringArray[2]) : 0;
                } else {
                    block = Block.getBlockFromName(stringArray[0]);
                    if (block != null) {
                        int n5 = n4 = stringArray.length > 1 ? Integer.parseInt(stringArray[1]) : 0;
                    }
                }
                if (block == null) {
                    return null;
                }
            }
            if (block == Blocks.air) {
                n4 = 0;
            }
            if (n4 < 0 || n4 > 15) {
                n4 = 0;
            }
        }
        catch (Throwable throwable) {
            return null;
        }
        object = new FlatLayerInfo(n, n3, block, n4);
        ((FlatLayerInfo)object).setMinY(n2);
        return object;
    }

    private static List<FlatLayerInfo> func_180716_a(int n, String string) {
        if (string != null && string.length() >= 1) {
            ArrayList<FlatLayerInfo> arrayList = Lists.newArrayList();
            String[] stringArray = string.split(",");
            int n2 = 0;
            for (String string2 : stringArray) {
                FlatLayerInfo flatLayerInfo = FlatGeneratorInfo.func_180715_a(n, string2, n2);
                if (flatLayerInfo == null) {
                    return null;
                }
                arrayList.add(flatLayerInfo);
                n2 += flatLayerInfo.getLayerCount();
            }
            return arrayList;
        }
        return null;
    }

    public static FlatGeneratorInfo createFlatGeneratorFromString(String string) {
        int n;
        if (string == null) {
            return FlatGeneratorInfo.getDefaultFlatGenerator();
        }
        String[] stringArray = string.split(";", -1);
        int n2 = n = stringArray.length == 1 ? 0 : MathHelper.parseIntWithDefault(stringArray[0], 0);
        if (n >= 0 && n <= 3) {
            List<FlatLayerInfo> list;
            FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
            int n3 = stringArray.length == 1 ? 0 : 1;
            if ((list = FlatGeneratorInfo.func_180716_a(n, stringArray[n3++])) != null && !list.isEmpty()) {
                flatGeneratorInfo.getFlatLayers().addAll(list);
                flatGeneratorInfo.func_82645_d();
                int n4 = BiomeGenBase.plains.biomeID;
                if (n > 0 && stringArray.length > n3) {
                    n4 = MathHelper.parseIntWithDefault(stringArray[n3++], n4);
                }
                flatGeneratorInfo.setBiome(n4);
                if (n > 0 && stringArray.length > n3) {
                    String[] stringArray2;
                    for (String string2 : stringArray2 = stringArray[n3++].toLowerCase().split(",")) {
                        String[] stringArray3 = string2.split("\\(", 2);
                        HashMap<String, String> hashMap = Maps.newHashMap();
                        if (stringArray3[0].length() <= 0) continue;
                        flatGeneratorInfo.getWorldFeatures().put(stringArray3[0], hashMap);
                        if (stringArray3.length <= 1 || !stringArray3[1].endsWith(")") || stringArray3[1].length() <= 1) continue;
                        String[] stringArray4 = stringArray3[1].substring(0, stringArray3[1].length() - 1).split(" ");
                        for (int i = 0; i < stringArray4.length; ++i) {
                            String[] stringArray5 = stringArray4[i].split("=", 2);
                            if (stringArray5.length != 2) continue;
                            hashMap.put(stringArray5[0], stringArray5[1]);
                        }
                    }
                } else {
                    flatGeneratorInfo.getWorldFeatures().put("village", Maps.newHashMap());
                }
                return flatGeneratorInfo;
            }
            return FlatGeneratorInfo.getDefaultFlatGenerator();
        }
        return FlatGeneratorInfo.getDefaultFlatGenerator();
    }

    public static FlatGeneratorInfo getDefaultFlatGenerator() {
        FlatGeneratorInfo flatGeneratorInfo = new FlatGeneratorInfo();
        flatGeneratorInfo.setBiome(BiomeGenBase.plains.biomeID);
        flatGeneratorInfo.getFlatLayers().add(new FlatLayerInfo(1, Blocks.bedrock));
        flatGeneratorInfo.getFlatLayers().add(new FlatLayerInfo(2, Blocks.dirt));
        flatGeneratorInfo.getFlatLayers().add(new FlatLayerInfo(1, Blocks.grass));
        flatGeneratorInfo.func_82645_d();
        flatGeneratorInfo.getWorldFeatures().put("village", Maps.newHashMap());
        return flatGeneratorInfo;
    }
}

