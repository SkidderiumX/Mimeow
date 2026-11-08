/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;

public class MapGenBase {
    protected int range = 8;
    protected Random rand = new Random();
    protected World worldObj;

    public void generate(IChunkProvider iChunkProvider, World world2, int n, int n2, ChunkPrimer chunkPrimer) {
        int n3 = this.range;
        this.worldObj = world2;
        this.rand.setSeed(world2.getSeed());
        long l = this.rand.nextLong();
        long l2 = this.rand.nextLong();
        for (int i = n - n3; i <= n + n3; ++i) {
            for (int j = n2 - n3; j <= n2 + n3; ++j) {
                long l3 = (long)i * l;
                long l4 = (long)j * l2;
                this.rand.setSeed(l3 ^ l4 ^ world2.getSeed());
                this.recursiveGenerate(world2, i, j, n, n2, chunkPrimer);
            }
        }
    }

    protected void recursiveGenerate(World world2, int n, int n2, int n3, int n4, ChunkPrimer chunkPrimer) {
    }
}

