/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import net.minecraft.block.BlockAir;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.EmptyChunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.optifine.BlockPosM;

public class ClearWater {
    public static void updateWaterOpacity(GameSettings gameSettings, World world2) {
        Entity entity;
        IChunkProvider iChunkProvider;
        if (gameSettings != null) {
            int n = 3;
            if (gameSettings.ofClearWater) {
                n = 1;
            }
            BlockAir.setLightOpacity(Blocks.water, n);
            BlockAir.setLightOpacity(Blocks.flowing_water, n);
        }
        if (world2 != null && (iChunkProvider = world2.getChunkProvider()) != null && (entity = Config.getMinecraft().getRenderViewEntity()) != null) {
            int n = (int)entity.posX / 16;
            int n2 = (int)entity.posZ / 16;
            int n3 = n - 512;
            int n4 = n + 512;
            int n5 = n2 - 512;
            int n6 = n2 + 512;
            int n7 = 0;
            for (int i = n3; i < n4; ++i) {
                for (int j = n5; j < n6; ++j) {
                    Chunk chunk;
                    if (!iChunkProvider.chunkExists(i, j) || (chunk = iChunkProvider.provideChunk(i, j)) == null || chunk instanceof EmptyChunk) continue;
                    int n8 = i << 4;
                    int n9 = j << 4;
                    int n10 = n8 + 16;
                    int n11 = n9 + 16;
                    BlockPosM blockPosM = new BlockPosM(0, 0, 0);
                    BlockPosM blockPosM2 = new BlockPosM(0, 0, 0);
                    for (int k = n8; k < n10; ++k) {
                        block3: for (int i2 = n9; i2 < n11; ++i2) {
                            blockPosM.setXyz(k, 0, i2);
                            BlockPos blockPos = world2.getPrecipitationHeight(blockPosM);
                            for (int i3 = 0; i3 < blockPos.getY(); ++i3) {
                                blockPosM2.setXyz(k, i3, i2);
                                IBlockState iBlockState = world2.getBlockState(blockPosM2);
                                if (iBlockState.getBlock().getMaterial() != Material.water) continue;
                                world2.markBlocksDirtyVertical(k, i2, blockPosM2.getY(), blockPos.getY());
                                ++n7;
                                continue block3;
                            }
                        }
                    }
                }
            }
            if (n7 > 0) {
                String string = "server";
                if (Config.isMinecraftThread()) {
                    string = "client";
                }
                Config.dbg("ClearWater (" + string + ") relighted " + n7 + " chunks");
            }
        }
    }
}

