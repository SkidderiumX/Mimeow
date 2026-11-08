/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerZoom
extends GenLayer {
    public GenLayerZoom(long l, GenLayer genLayer) {
        super(l);
        this.parent = genLayer;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        int n5;
        int n6 = n >> 1;
        int n7 = n2 >> 1;
        int n8 = (n3 >> 1) + 2;
        int n9 = (n4 >> 1) + 2;
        int[] nArray = this.parent.getInts(n6, n7, n8, n9);
        int n10 = n8 - 1 << 1;
        int n11 = n9 - 1 << 1;
        int[] nArray2 = IntCache.getIntCache(n10 * n11);
        for (int i = 0; i < n9 - 1; ++i) {
            int n12;
            n5 = (i << 1) * n10;
            int n13 = nArray[n12 + 0 + (i + 0) * n8];
            int n14 = nArray[n12 + 0 + (i + 1) * n8];
            for (n12 = 0; n12 < n8 - 1; ++n12) {
                this.initChunkSeed(n12 + n6 << 1, i + n7 << 1);
                int n15 = nArray[n12 + 1 + (i + 0) * n8];
                int n16 = nArray[n12 + 1 + (i + 1) * n8];
                nArray2[n5] = n13;
                nArray2[n5++ + n10] = this.selectRandom2(n13, n14);
                nArray2[n5] = this.selectRandom2(n13, n15);
                nArray2[n5++ + n10] = this.selectModeOrRandom(n13, n15, n14, n16);
                n13 = n15;
                n14 = n16;
            }
        }
        int[] nArray3 = IntCache.getIntCache(n3 * n4);
        for (n5 = 0; n5 < n4; ++n5) {
            System.arraycopy(nArray2, (n5 + (n2 & 1)) * n10 + (n & 1), nArray3, n5 * n3, n3);
        }
        return nArray3;
    }

    public static GenLayer magnify(long l, GenLayer genLayer, int n) {
        GenLayer genLayer2 = genLayer;
        for (int i = 0; i < n; ++i) {
            genLayer2 = new GenLayerZoom(l + (long)i, genLayer2);
        }
        return genLayer2;
    }

    protected int selectRandom2(int n, int n2) {
        int n3 = this.nextInt(2);
        return n3 == 0 ? n : n2;
    }
}

