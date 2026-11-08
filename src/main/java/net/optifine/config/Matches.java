/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.config;

import net.minecraft.block.state.BlockStateBase;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.config.MatchBlock;

public class Matches {
    public static boolean block(BlockStateBase blockStateBase, MatchBlock[] matchBlockArray) {
        if (matchBlockArray == null) {
            return true;
        }
        for (int i = 0; i < matchBlockArray.length; ++i) {
            MatchBlock matchBlock = matchBlockArray[i];
            if (!matchBlock.matches(blockStateBase)) continue;
            return true;
        }
        return false;
    }

    public static boolean block(int n, int n2, MatchBlock[] matchBlockArray) {
        if (matchBlockArray == null) {
            return true;
        }
        for (int i = 0; i < matchBlockArray.length; ++i) {
            MatchBlock matchBlock = matchBlockArray[i];
            if (!matchBlock.matches(n, n2)) continue;
            return true;
        }
        return false;
    }

    public static boolean blockId(int n, MatchBlock[] matchBlockArray) {
        if (matchBlockArray == null) {
            return true;
        }
        for (int i = 0; i < matchBlockArray.length; ++i) {
            MatchBlock matchBlock = matchBlockArray[i];
            if (matchBlock.getBlockId() != n) continue;
            return true;
        }
        return false;
    }

    public static boolean metadata(int n, int[] nArray) {
        if (nArray == null) {
            return true;
        }
        for (int i = 0; i < nArray.length; ++i) {
            if (nArray[i] != n) continue;
            return true;
        }
        return false;
    }

    public static boolean sprite(TextureAtlasSprite textureAtlasSprite, TextureAtlasSprite[] textureAtlasSpriteArray) {
        if (textureAtlasSpriteArray == null) {
            return true;
        }
        for (int i = 0; i < textureAtlasSpriteArray.length; ++i) {
            if (textureAtlasSpriteArray[i] != textureAtlasSprite) continue;
            return true;
        }
        return false;
    }

    public static boolean biome(BiomeGenBase biomeGenBase, BiomeGenBase[] biomeGenBaseArray) {
        if (biomeGenBaseArray == null) {
            return true;
        }
        for (int i = 0; i < biomeGenBaseArray.length; ++i) {
            if (biomeGenBaseArray[i] != biomeGenBase) continue;
            return true;
        }
        return false;
    }
}

