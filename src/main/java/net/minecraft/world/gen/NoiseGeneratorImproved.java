/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.world.gen;

import java.util.Random;
import net.minecraft.world.gen.NoiseGenerator;

public class NoiseGeneratorImproved
extends NoiseGenerator {
    private int[] permutations = new int[512];
    public double xCoord;
    public double yCoord;
    public double zCoord;
    private static final double[] field_152381_e = new double[]{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0};
    private static final double[] field_152382_f = new double[]{1.0, 1.0, -1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0};
    private static final double[] field_152383_g = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0};
    private static final double[] field_152384_h = new double[]{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, -1.0, 0.0};
    private static final double[] field_152385_i = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, -1.0, -1.0, 1.0, 1.0, -1.0, -1.0, 0.0, 1.0, 0.0, -1.0};

    public NoiseGeneratorImproved() {
        this(new Random());
    }

    public NoiseGeneratorImproved(Random random) {
        this.xCoord = random.nextDouble() * 256.0;
        this.yCoord = random.nextDouble() * 256.0;
        this.zCoord = random.nextDouble() * 256.0;
        int n = 0;
        while (n < 256) {
            this.permutations[n] = n++;
        }
        for (n = 0; n < 256; ++n) {
            int n2 = random.nextInt(256 - n) + n;
            int n3 = this.permutations[n];
            this.permutations[n] = this.permutations[n2];
            this.permutations[n2] = n3;
            this.permutations[n + 256] = this.permutations[n];
        }
    }

    public final double lerp(double d, double d2, double d3) {
        return d2 + d * (d3 - d2);
    }

    public final double func_76309_a(int n, double d, double d2) {
        int n2 = n & 0xF;
        return field_152384_h[n2] * d + field_152385_i[n2] * d2;
    }

    public final double grad(int n, double d, double d2, double d3) {
        int n2 = n & 0xF;
        return field_152381_e[n2] * d + field_152382_f[n2] * d2 + field_152383_g[n2] * d3;
    }

    public void populateNoiseArray(double[] dArray, double d, double d2, double d3, int n, int n2, int n3, double d4, double d5, double d6, double d7) {
        if (n2 == 1) {
            int n4 = 0;
            int n5 = 0;
            int n6 = 0;
            int n7 = 0;
            double d8 = 0.0;
            double d9 = 0.0;
            int n8 = 0;
            double d10 = 1.0 / d7;
            for (int i = 0; i < n; ++i) {
                double d11 = d + (double)i * d4 + this.xCoord;
                int n9 = (int)d11;
                if (d11 < (double)n9) {
                    --n9;
                }
                int n10 = n9 & 0xFF;
                double d12 = (d11 -= (double)n9) * d11 * d11 * (d11 * (d11 * 6.0 - 15.0) + 10.0);
                for (int j = 0; j < n3; ++j) {
                    int n11;
                    double d13 = d3 + (double)j * d6 + this.zCoord;
                    int n12 = (int)d13;
                    if (d13 < (double)n12) {
                        --n12;
                    }
                    int n13 = n12 & 0xFF;
                    double d14 = (d13 -= (double)n12) * d13 * d13 * (d13 * (d13 * 6.0 - 15.0) + 10.0);
                    n4 = this.permutations[n10] + 0;
                    n5 = this.permutations[n4] + n13;
                    n6 = this.permutations[n10 + 1] + 0;
                    n7 = this.permutations[n6] + n13;
                    d8 = this.lerp(d12, this.func_76309_a(this.permutations[n5], d11, d13), this.grad(this.permutations[n7], d11 - 1.0, 0.0, d13));
                    d9 = this.lerp(d12, this.grad(this.permutations[n5 + 1], d11, 0.0, d13 - 1.0), this.grad(this.permutations[n7 + 1], d11 - 1.0, 0.0, d13 - 1.0));
                    double d15 = this.lerp(d14, d8, d9);
                    int n14 = n11 = n8++;
                    dArray[n14] = dArray[n14] + d15 * d10;
                }
            }
        } else {
            int n15 = 0;
            double d16 = 1.0 / d7;
            int n16 = -1;
            int n17 = 0;
            int n18 = 0;
            int n19 = 0;
            int n20 = 0;
            int n21 = 0;
            int n22 = 0;
            double d17 = 0.0;
            double d18 = 0.0;
            double d19 = 0.0;
            double d20 = 0.0;
            for (int i = 0; i < n; ++i) {
                double d21 = d + (double)i * d4 + this.xCoord;
                int n23 = (int)d21;
                if (d21 < (double)n23) {
                    --n23;
                }
                int n24 = n23 & 0xFF;
                double d22 = (d21 -= (double)n23) * d21 * d21 * (d21 * (d21 * 6.0 - 15.0) + 10.0);
                for (int j = 0; j < n3; ++j) {
                    double d23 = d3 + (double)j * d6 + this.zCoord;
                    int n25 = (int)d23;
                    if (d23 < (double)n25) {
                        --n25;
                    }
                    int n26 = n25 & 0xFF;
                    double d24 = (d23 -= (double)n25) * d23 * d23 * (d23 * (d23 * 6.0 - 15.0) + 10.0);
                    for (int k = 0; k < n2; ++k) {
                        int n27;
                        double d25 = d2 + (double)k * d5 + this.yCoord;
                        int n28 = (int)d25;
                        if (d25 < (double)n28) {
                            --n28;
                        }
                        int n29 = n28 & 0xFF;
                        double d26 = (d25 -= (double)n28) * d25 * d25 * (d25 * (d25 * 6.0 - 15.0) + 10.0);
                        if (k == 0 || n29 != n16) {
                            n16 = n29;
                            n17 = this.permutations[n24] + n29;
                            n18 = this.permutations[n17] + n26;
                            n19 = this.permutations[n17 + 1] + n26;
                            n20 = this.permutations[n24 + 1] + n29;
                            n21 = this.permutations[n20] + n26;
                            n22 = this.permutations[n20 + 1] + n26;
                            d17 = this.lerp(d22, this.grad(this.permutations[n18], d21, d25, d23), this.grad(this.permutations[n21], d21 - 1.0, d25, d23));
                            d18 = this.lerp(d22, this.grad(this.permutations[n19], d21, d25 - 1.0, d23), this.grad(this.permutations[n22], d21 - 1.0, d25 - 1.0, d23));
                            d19 = this.lerp(d22, this.grad(this.permutations[n18 + 1], d21, d25, d23 - 1.0), this.grad(this.permutations[n21 + 1], d21 - 1.0, d25, d23 - 1.0));
                            d20 = this.lerp(d22, this.grad(this.permutations[n19 + 1], d21, d25 - 1.0, d23 - 1.0), this.grad(this.permutations[n22 + 1], d21 - 1.0, d25 - 1.0, d23 - 1.0));
                        }
                        double d27 = this.lerp(d26, d17, d18);
                        double d28 = this.lerp(d26, d19, d20);
                        double d29 = this.lerp(d24, d27, d28);
                        int n30 = n27 = n15++;
                        dArray[n30] = dArray[n30] + d29 * d16;
                    }
                }
            }
        }
    }
}

