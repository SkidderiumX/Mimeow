/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerRiver
extends GenLayer {
    public GenLayerRiver(long l, GenLayer genLayer) {
        super(l);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int n5 = n - 1;
        int n6 = n2 - 1;
        int n7 = n3 + 2;
        int n8 = n4 + 2;
        int[] nArray = this.parent.getInts(n5, n6, n7, n8);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n9 = this.func_151630_c(nArray[j + 0 + (i + 1) * n7]);
                int n10 = this.func_151630_c(nArray[j + 2 + (i + 1) * n7]);
                int n11 = this.func_151630_c(nArray[j + 1 + (i + 0) * n7]);
                int n12 = this.func_151630_c(nArray[j + 1 + (i + 2) * n7]);
                int n13 = this.func_151630_c(nArray[j + 1 + (i + 1) * n7]);
                nArray2[j + i * n3] = n13 == n9 && n13 == n11 && n13 == n10 && n13 == n12 ? -1 : BiomeGenBase.river.biomeID;
            }
        }
        return nArray2;
    }

    private int func_151630_c(int n) {
        return n >= 2 ? 2 + (n & 1) : n;
    }
}

