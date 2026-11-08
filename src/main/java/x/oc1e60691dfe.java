/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc84f20a0bc5;

public class oc1e60691dfe {
    private long \u016a = System.currentTimeMillis();

    private oc1e60691dfe() {
    }

    private boolean \u017f(double d) {
        int n = oc84f20a0bc5.\u0117;
        int n2 = 0xD3E481C0 ^ 0x359DC5CA;
        while (true) {
            double d2;
            block8: {
                block9: {
                    switch (n2) {
                        default: {
                            throw null;
                        }
                        case -167737923: {
                            return true;
                        }
                        case -2139540966: {
                            return false;
                        }
                        case -428260342: 
                    }
                    double d3 = (double)(System.currentTimeMillis() - this.\u016a) - d;
                    d2 = d3 == 0.0 ? 0 : (d3 > 0.0 ? 1 : -1);
                    if (n != 0) break block8;
                    if (d2 < 0) break block9;
                    n2 = 0xC39D4077 ^ 0x359DC5CA;
                    if (n == 0) continue;
                }
                d2 = 0xB5E4F7D0 ^ 0x359DC5CA;
            }
            n2 = (int)d2;
        }
    }

    private void \u0244() {
        this.\u016a = System.currentTimeMillis();
    }
}

