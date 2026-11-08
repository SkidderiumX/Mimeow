/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerEdge
extends GenLayer {
    private final Mode field_151627_c;

    public GenLayerEdge(long l, GenLayer genLayer, Mode mode) {
        super(l);
        this.parent = genLayer;
        this.field_151627_c = mode;
    }

    @Override
    public int[] getInts(int n, int n2, int n3, int n4) {
        switch (this.field_151627_c) {
            default: {
                return this.getIntsCoolWarm(n, n2, n3, n4);
            }
            case HEAT_ICE: {
                return this.getIntsHeatIce(n, n2, n3, n4);
            }
            case SPECIAL: 
        }
        return this.getIntsSpecial(n, n2, n3, n4);
    }

    private int[] getIntsCoolWarm(int n, int n2, int n3, int n4) {
        int n5 = n - 1;
        int n6 = n2 - 1;
        int n7 = 1 + n3 + 1;
        int n8 = 1 + n4 + 1;
        int[] nArray = this.parent.getInts(n5, n6, n7, n8);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.initChunkSeed(j + n, i + n2);
                int n9 = nArray[j + 1 + (i + 1) * n7];
                if (n9 == 1) {
                    boolean bl;
                    int n10 = nArray[j + 1 + (i + 1 - 1) * n7];
                    int n11 = nArray[j + 1 + 1 + (i + 1) * n7];
                    int n12 = nArray[j + 1 - 1 + (i + 1) * n7];
                    int n13 = nArray[j + 1 + (i + 1 + 1) * n7];
                    boolean bl2 = n10 == 3 || n11 == 3 || n12 == 3 || n13 == 3;
                    boolean bl3 = bl = n10 == 4 || n11 == 4 || n12 == 4 || n13 == 4;
                    if (bl2 || bl) {
                        n9 = 2;
                    }
                }
                nArray2[j + i * n3] = n9;
            }
        }
        return nArray2;
    }

    private int[] getIntsHeatIce(int n, int n2, int n3, int n4) {
        int n5 = n - 1;
        int n6 = n2 - 1;
        int n7 = 1 + n3 + 1;
        int n8 = 1 + n4 + 1;
        int[] nArray = this.parent.getInts(n5, n6, n7, n8);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                int n9 = nArray[j + 1 + (i + 1) * n7];
                if (n9 == 4) {
                    boolean bl;
                    int n10 = nArray[j + 1 + (i + 1 - 1) * n7];
                    int n11 = nArray[j + 1 + 1 + (i + 1) * n7];
                    int n12 = nArray[j + 1 - 1 + (i + 1) * n7];
                    int n13 = nArray[j + 1 + (i + 1 + 1) * n7];
                    boolean bl2 = n10 == 2 || n11 == 2 || n12 == 2 || n13 == 2;
                    boolean bl3 = bl = n10 == 1 || n11 == 1 || n12 == 1 || n13 == 1;
                    if (bl || bl2) {
                        n9 = 3;
                    }
                }
                nArray2[j + i * n3] = n9;
            }
        }
        return nArray2;
    }

    private int[] getIntsSpecial(int n, int n2, int n3, int n4) {
        int[] nArray = this.parent.getInts(n, n2, n3, n4);
        int[] nArray2 = IntCache.getIntCache(n3 * n4);
        for (int i = 0; i < n4; ++i) {
            for (int j = 0; j < n3; ++j) {
                this.initChunkSeed(j + n, i + n2);
                int n5 = nArray[j + i * n3];
                if (n5 != 0 && this.nextInt(13) == 0) {
                    n5 |= 1 + this.nextInt(15) << 8 & 0xF00;
                }
                nArray2[j + i * n3] = n5;
            }
        }
        return nArray2;
    }

    public static enum Mode {
        COOL_WARM,
        HEAT_ICE,
        SPECIAL;

    }
}

