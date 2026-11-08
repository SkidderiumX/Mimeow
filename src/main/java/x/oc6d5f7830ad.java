/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.Random;
import x.oc75d51ec7eb;

public class oc6d5f7830ad {
    private final Random \u0417;
    public static boolean \u0148;

    public oc6d5f7830ad() {
        this.\u0417 = new Random();
    }

    public oc6d5f7830ad(Random random) {
        this.\u0417 = random;
    }

    public long \u0186(double d, double d2, boolean bl) {
        double d3;
        block6: {
            double d4;
            double d5;
            double d6;
            block4: {
                block5: {
                    d6 = Math.max(1.0, Math.min(d, d2));
                    d5 = Math.max(d6, Math.max(d, d2));
                    int n = oc75d51ec7eb.\u03e9;
                    d4 = d6;
                    if (n != 0) break block4;
                    if (d4 != d5) break block5;
                    d3 = d6;
                    break block6;
                }
                d4 = d6;
            }
            d3 = d4 + this.\u0417.nextDouble() * (d5 - d6);
        }
        double d7 = d3;
        return this.\u018e(d7, bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long \u018e(double d, boolean bl) {
        int n;
        block27: {
            int n2;
            block20: {
                int n3;
                block21: {
                    oc6d5f7830ad oc6d5f7830ad2;
                    int n4;
                    block26: {
                        int n5;
                        Random random;
                        block22: {
                            block23: {
                                int n6;
                                block24: {
                                    block25: {
                                        double d2 = Math.max(1.0, d);
                                        n4 = oc75d51ec7eb.\u03e9;
                                        n3 = Math.max(1, (int)Math.round(1000.0 / d2));
                                        n2 = bl;
                                        if (n4 != 0) break block20;
                                        if (n2 == 0) break block21;
                                        int n7 = this.\u0417.nextInt(n3 + 1) - n3 / (0xAE9452B3 ^ 0xAE9452B1);
                                        n = n3 + n7;
                                        random = this.\u0417;
                                        n5 = 0xAE9452D5 ^ 0xAE9452B1;
                                        if (n4 != 0) break block22;
                                        if (random.nextInt(n5) >= (0xAE9452BE ^ 0xAE9452B1)) break block23;
                                        n6 = this.\u0417.nextBoolean();
                                        if (n4 != 0) break block24;
                                        if (n6 == 0) break block25;
                                        n = (0xAE9452A8 ^ 0xAE9452B1) + this.\u0417.nextInt(0xAE9452A1 ^ 0xAE9452B1);
                                        if (n4 == 0) break block23;
                                    }
                                    n6 = n3 + (0xAE945283 ^ 0xAE9452B1) + this.\u0417.nextInt(0xAE945298 ^ 0xAE9452B1);
                                }
                                n = n6;
                            }
                            oc6d5f7830ad2 = this;
                            if (n4 != 0) break block26;
                            random = oc6d5f7830ad2.\u0417;
                            n5 = 0xAE9452D5 ^ 0xAE9452B1;
                        }
                        if (random.nextInt(n5) < (0xAE9452B9 ^ 0xAE9452B1)) {
                            int n8 = (0xAE945283 ^ 0xAE9452B1) + this.\u0417.nextInt(0xAE945226 ^ 0xAE9452B1);
                            n = n * n8 / (0xAE9452D5 ^ 0xAE9452B1);
                        }
                        oc6d5f7830ad2 = this;
                    }
                    int n9 = oc6d5f7830ad2.\u0417.nextInt(0xAE9452D5 ^ 0xAE9452B1);
                    if (n4 == 0 && n9 < (0xAE9452BB ^ 0xAE9452B1)) {
                        n9 = n = n + ((0xAE9452BB ^ 0xAE9452B1) + this.\u0417.nextInt(0xAE9452AB ^ 0xAE9452B1));
                    }
                    if (n4 == 0) break block27;
                }
                n2 = n3 + (this.\u0417.nextInt(0xAE9452A4 ^ 0xAE9452B1) - (0xAE9452BB ^ 0xAE9452B1));
            }
            n = n2;
        }
        return Math.max(0xAE945290 ^ 0xAE9452B1, Math.min(0xAE945205 ^ 0xAE9452B1, n));
    }
}

