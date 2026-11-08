/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.util;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.chunks.BaseChunk;
import com.viaversion.viaversion.api.minecraft.chunks.Chunk;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSection;
import com.viaversion.viaversion.api.minecraft.chunks.ChunkSectionImpl;
import com.viaversion.viaversion.api.minecraft.chunks.PaletteType;
import java.util.ArrayList;
import java.util.Arrays;

public class ChunkUtil {
    public static Chunk createEmptyChunk(int n, int n2) {
        return ChunkUtil.createEmptyChunk(n, n2, 16, 65535);
    }

    public static Chunk createEmptyChunk(int n, int n2, int n3) {
        int n4 = 0;
        for (int i = 0; i < n3; ++i) {
            n4 = n4 << 1 | 1;
        }
        return ChunkUtil.createEmptyChunk(n, n2, n3, n4);
    }

    public static Chunk createEmptyChunk(int n, int n2, int n3, int n4) {
        ChunkSection[] chunkSectionArray = new ChunkSection[n3];
        for (int i = 0; i < chunkSectionArray.length; ++i) {
            chunkSectionArray[i] = new ChunkSectionImpl(true);
            chunkSectionArray[i].palette(PaletteType.BLOCKS).addId(0);
        }
        return new BaseChunk(n, n2, true, false, n4, chunkSectionArray, new int[256], new ArrayList<CompoundTag>());
    }

    public static void setDummySkylight(Chunk chunk) {
        ChunkUtil.setDummySkylight(chunk, false);
    }

    public static void setDummySkylight(Chunk chunk, boolean bl) {
        for (ChunkSection chunkSection : chunk.getSections()) {
            if (chunkSection == null || !chunkSection.hasLight()) continue;
            byte[] byArray = new byte[2048];
            if (bl) {
                Arrays.fill(byArray, (byte)-1);
            }
            chunkSection.getLight().setSkyLight(byArray);
        }
    }
}

