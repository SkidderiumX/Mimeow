/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorImproved;

public class NoiseGeneratorOctaves
extends NoiseGenerator {
    private NoiseGeneratorImproved[] generatorCollection;
    private int octaves;

    public NoiseGeneratorOctaves(Random random, int n) {
        this.octaves = n;
        this.generatorCollection = new NoiseGeneratorImproved[n];
        for (int i = 0; i < n; ++i) {
            this.generatorCollection[i] = new NoiseGeneratorImproved(random);
        }
    }

    public double[] generateNoiseOctaves(double[] dArray, int n, int n2, int n3, int n4, int n5, int n6, double d, double d2, double d3) {
        if (dArray == null) {
            dArray = new double[n4 * n5 * n6];
        } else {
            for (int i = 0; i < dArray.length; ++i) {
                dArray[i] = 0.0;
            }
        }
        double d4 = 1.0;
        for (int i = 0; i < this.octaves; ++i) {
            double d5 = (double)n * d4 * d;
            double d6 = (double)n2 * d4 * d2;
            double d7 = (double)n3 * d4 * d3;
            long l = MathHelper.floor_double_long(d5);
            long l2 = MathHelper.floor_double_long(d7);
            d5 -= (double)l;
            d7 -= (double)l2;
            this.generatorCollection[i].populateNoiseArray(dArray, d5 += (double)(l %= 0x1000000L), d6, d7 += (double)(l2 %= 0x1000000L), n4, n5, n6, d * d4, d2 * d4, d3 * d4, d4);
            d4 /= 2.0;
        }
        return dArray;
    }

    public double[] generateNoiseOctaves(double[] dArray, int n, int n2, int n3, int n4, double d, double d2, double d3) {
        return this.generateNoiseOctaves(dArray, n, 10, n2, n3, 1, n4, d, 1.0, d2);
    }
}

