/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDeepOcean
extends GenLayer {
    public GenLayerDeepOcean(long l, GenLayer genLayer) {
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
                int n9 = nArray[j + 1 + (i + 1 - 1) * (n3 + 2)];
                int n10 = nArray[j + 1 + 1 + (i + 1) * (n3 + 2)];
                int n11 = nArray[j + 1 - 1 + (i + 1) * (n3 + 2)];
                int n12 = nArray[j + 1 + (i + 1 + 1) * (n3 + 2)];
                int n13 = nArray[j + 1 + (i + 1) * n7];
                int n14 = 0;
                if (n9 == 0) {
                    ++n14;
                }
                if (n10 == 0) {
                    ++n14;
                }
                if (n11 == 0) {
                    ++n14;
                }
                if (n12 == 0) {
                    ++n14;
                }
                nArray2[j + i * n3] = n13 == 0 && n14 > 3 ? BiomeGenBase.deepOcean.biomeID : n13;
            }
        }
        return nArray2;
    }
}

