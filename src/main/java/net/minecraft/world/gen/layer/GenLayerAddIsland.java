/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerAddIsland
extends GenLayer {
    public GenLayerAddIsland(long l, GenLayer genLayer) {
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
                int n9 = nArray[j + 0 + (i + 0) * n7];
                int n10 = nArray[j + 2 + (i + 0) * n7];
                int n11 = nArray[j + 0 + (i + 2) * n7];
                int n12 = nArray[j + 2 + (i + 2) * n7];
                int n13 = nArray[j + 1 + (i + 1) * n7];
                this.initChunkSeed(j + n, i + n2);
                if (n13 != 0 || n9 == 0 && n10 == 0 && n11 == 0 && n12 == 0) {
                    if (n13 > 0 && (n9 == 0 || n10 == 0 || n11 == 0 || n12 == 0)) {
                        if (this.nextInt(5) == 0) {
                            if (n13 == 4) {
                                nArray2[j + i * n3] = 4;
                                continue;
                            }
                            nArray2[j + i * n3] = 0;
                            continue;
                        }
                        nArray2[j + i * n3] = n13;
                        continue;
                    }
                    nArray2[j + i * n3] = n13;
                    continue;
                }
                int n14 = 1;
                int n15 = 1;
                if (n9 != 0 && this.nextInt(n14++) == 0) {
                    n15 = n9;
                }
                if (n10 != 0 && this.nextInt(n14++) == 0) {
                    n15 = n10;
                }
                if (n11 != 0 && this.nextInt(n14++) == 0) {
                    n15 = n11;
                }
                if (n12 != 0 && this.nextInt(n14++) == 0) {
                    n15 = n12;
                }
                nArray2[j + i * n3] = this.nextInt(3) == 0 ? n15 : (n15 == 4 ? 4 : 0);
            }
        }
        return nArray2;
    }
}

