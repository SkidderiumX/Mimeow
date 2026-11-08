/*
 * Decompiled with CFR 0.152.
 */
package net.optifine;

import java.util.Comparator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;

public class ChunkPosComparator
implements Comparator<ChunkCoordIntPair> {
    private int chunkPosX;
    private int chunkPosZ;
    private double yawRad;
    private double pitchNorm;

    public ChunkPosComparator(int n, int n2, double d, double d2) {
        this.chunkPosX = n;
        this.chunkPosZ = n2;
        this.yawRad = d;
        this.pitchNorm = 1.0 - MathHelper.clamp_double(Math.abs(d2) / 1.5707963267948966, 0.0, 1.0);
    }

    @Override
    public int compare(ChunkCoordIntPair chunkCoordIntPair, ChunkCoordIntPair chunkCoordIntPair2) {
        int n = this.getDistSq(chunkCoordIntPair);
        int n2 = this.getDistSq(chunkCoordIntPair2);
        return n - n2;
    }

    private int getDistSq(ChunkCoordIntPair chunkCoordIntPair) {
        int n = chunkCoordIntPair.chunkXPos - this.chunkPosX;
        int n2 = chunkCoordIntPair.chunkZPos - this.chunkPosZ;
        int n3 = n * n + n2 * n2;
        double d = MathHelper.atan2(n2, n);
        double d2 = Math.abs(d - this.yawRad);
        if (d2 > Math.PI) {
            d2 = Math.PI * 2 - d2;
        }
        n3 = (int)((double)n3 * 1000.0 * this.pitchNorm * d2 * d2);
        return n3;
    }
}

