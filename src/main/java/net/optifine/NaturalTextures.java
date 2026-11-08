/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.optifine.ConnectedTextures;
import net.optifine.NaturalProperties;
import net.optifine.util.TextureUtils;

public class NaturalTextures {
    private static NaturalProperties[] propertiesByIndex = new NaturalProperties[0];

    public static void update() {
        propertiesByIndex = new NaturalProperties[0];
        if (Config.isNaturalTextures()) {
            String string = "optifine/natural.properties";
            try {
                ResourceLocation resourceLocation = new ResourceLocation(string);
                if (!Config.hasResource(resourceLocation)) {
                    Config.dbg("NaturalTextures: configuration \"" + string + "\" not found");
                    return;
                }
                boolean bl = Config.isFromDefaultResourcePack(resourceLocation);
                InputStream inputStream2 = Config.getResourceStream(resourceLocation);
                ArrayList<NaturalProperties> arrayList = new ArrayList<NaturalProperties>(256);
                String string2 = Config.readInputStream(inputStream2);
                inputStream2.close();
                String[] stringArray = Config.tokenize(string2, "\n\r");
                if (bl) {
                    Config.dbg("Natural Textures: Parsing default configuration \"" + string + "\"");
                    Config.dbg("Natural Textures: Valid only for textures from default resource pack");
                } else {
                    Config.dbg("Natural Textures: Parsing configuration \"" + string + "\"");
                }
                TextureMap textureMap = TextureUtils.getTextureMapBlocks();
                for (int i = 0; i < stringArray.length; ++i) {
                    String string3 = stringArray[i].trim();
                    if (string3.startsWith("#")) continue;
                    String[] stringArray2 = Config.tokenize(string3, "=");
                    if (stringArray2.length != 2) {
                        Config.warn("Natural Textures: Invalid \"" + string + "\" line: " + string3);
                        continue;
                    }
                    String string4 = stringArray2[0].trim();
                    String string5 = stringArray2[1].trim();
                    TextureAtlasSprite textureAtlasSprite = textureMap.getSpriteSafe("minecraft:blocks/" + string4);
                    if (textureAtlasSprite == null) {
                        Config.warn("Natural Textures: Texture not found: \"" + string + "\" line: " + string3);
                        continue;
                    }
                    int n = textureAtlasSprite.getIndexInMap();
                    if (n < 0) {
                        Config.warn("Natural Textures: Invalid \"" + string + "\" line: " + string3);
                        continue;
                    }
                    if (bl && !Config.isFromDefaultResourcePack(new ResourceLocation("textures/blocks/" + string4 + ".png"))) {
                        return;
                    }
                    NaturalProperties naturalProperties = new NaturalProperties(string5);
                    if (!naturalProperties.isValid()) continue;
                    while (arrayList.size() <= n) {
                        arrayList.add(null);
                    }
                    arrayList.set(n, naturalProperties);
                    Config.dbg("NaturalTextures: " + string4 + " = " + string5);
                }
                propertiesByIndex = arrayList.toArray(new NaturalProperties[arrayList.size()]);
            }
            catch (FileNotFoundException fileNotFoundException) {
                Config.warn("NaturalTextures: configuration \"" + string + "\" not found");
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public static BakedQuad getNaturalTexture(BlockPos blockPos, BakedQuad bakedQuad) {
        TextureAtlasSprite textureAtlasSprite = bakedQuad.getSprite();
        if (textureAtlasSprite == null) {
            return bakedQuad;
        }
        NaturalProperties naturalProperties = NaturalTextures.getNaturalProperties(textureAtlasSprite);
        if (naturalProperties == null) {
            return bakedQuad;
        }
        int n = ConnectedTextures.getSide(bakedQuad.getFace());
        int n2 = Config.getRandom(blockPos, n);
        int n3 = 0;
        boolean bl = false;
        if (naturalProperties.rotation > 1) {
            n3 = n2 & 3;
        }
        if (naturalProperties.rotation == 2) {
            n3 = n3 / 2 * 2;
        }
        if (naturalProperties.flip) {
            bl = (n2 & 4) != 0;
        }
        return naturalProperties.getQuad(bakedQuad, n3, bl);
    }

    public static NaturalProperties getNaturalProperties(TextureAtlasSprite textureAtlasSprite) {
        if (!(textureAtlasSprite instanceof TextureAtlasSprite)) {
            return null;
        }
        int n = textureAtlasSprite.getIndexInMap();
        if (n >= 0 && n < propertiesByIndex.length) {
            NaturalProperties naturalProperties = propertiesByIndex[n];
            return naturalProperties;
        }
        return null;
    }
}

