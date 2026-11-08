/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.util;

import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class RenderChunkUtils {
    public static int getCountBlocks(RenderChunk renderChunk) {
        ExtendedBlockStorage[] extendedBlockStorageArray = renderChunk.getChunk().getBlockStorageArray();
        if (extendedBlockStorageArray == null) {
            return 0;
        }
        int n = renderChunk.getPosition().getY() >> 4;
        ExtendedBlockStorage extendedBlockStorage = extendedBlockStorageArray[n];
        return extendedBlockStorage == null ? 0 : extendedBlockStorage.getBlockRefCount();
    }

    public static double getRelativeBufferSize(RenderChunk renderChunk) {
        int n = RenderChunkUtils.getCountBlocks(renderChunk);
        double d = RenderChunkUtils.getRelativeBufferSize(n);
        return d;
    }

    public static double getRelativeBufferSize(int n) {
        double d = (double)n / 4096.0;
        double d2 = (d *= 0.995) * 2.0 - 1.0;
        d2 = MathHelper.clamp_double(d2, -1.0, 1.0);
        return MathHelper.sqrt_double(1.0 - d2 * d2);
    }
}

