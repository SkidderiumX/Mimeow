/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorSimplex;

public class NoiseGeneratorPerlin
extends NoiseGenerator {
    private NoiseGeneratorSimplex[] field_151603_a;
    private int field_151602_b;

    public NoiseGeneratorPerlin(Random random, int n) {
        this.field_151602_b = n;
        this.field_151603_a = new NoiseGeneratorSimplex[n];
        for (int i = 0; i < n; ++i) {
            this.field_151603_a[i] = new NoiseGeneratorSimplex(random);
        }
    }

    public double func_151601_a(double d, double d2) {
        double d3 = 0.0;
        double d4 = 1.0;
        for (int i = 0; i < this.field_151602_b; ++i) {
            d3 += this.field_151603_a[i].func_151605_a(d * d4, d2 * d4) / d4;
            d4 /= 2.0;
        }
        return d3;
    }

    public double[] func_151599_a(double[] dArray, double d, double d2, int n, int n2, double d3, double d4, double d5) {
        return this.func_151600_a(dArray, d, d2, n, n2, d3, d4, d5, 0.5);
    }

    public double[] func_151600_a(double[] dArray, double d, double d2, int n, int n2, double d3, double d4, double d5, double d6) {
        if (dArray != null && dArray.length >= n * n2) {
            for (int i = 0; i < dArray.length; ++i) {
                dArray[i] = 0.0;
            }
        } else {
            dArray = new double[n * n2];
        }
        double d7 = 1.0;
        double d8 = 1.0;
        for (int i = 0; i < this.field_151602_b; ++i) {
            this.field_151603_a[i].func_151606_a(dArray, d, d2, n, n2, d3 * d8 * d7, d4 * d8 * d7, 0.55 / d7);
            d8 *= d5;
            d7 *= d6;
        }
        return dArray;
    }
}

