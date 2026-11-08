/*
 * Decompiled with CFR 0.152.
 */
package x;

import x.oc46245c2b20;
import x.oc69da1aa7f5;

public class occda47ba572 {
    static final int \u0139 = 100;

    private occda47ba572() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static byte[] \u0525(String string) {
        int n;
        int n2;
        byte[] byArray;
        block21: {
            int n3 = oc46245c2b20.\u04a5;
            if (string == null) {
                throw new NullPointerException("value");
            }
            byArray = new byte[0x9B58604 ^ 0x9B58661];
            n2 = 0;
            int n4 = 0;
            block12: while (n4 < string.length()) {
                block22: {
                    int[] nArray;
                    block25: {
                        int n5;
                        int n6;
                        block28: {
                            block29: {
                                block26: {
                                    block27: {
                                        block23: {
                                            block24: {
                                                n = string.charAt(n4);
                                                if (n3 != 0) break block21;
                                                n5 = n6 = n;
                                                if (n3 != 0) break block23;
                                                if (n5 != 0) break block24;
                                                int[] nArray2 = new int[0x9B58663 ^ 0x9B58661];
                                                nArray2[0] = 0x9B586A1 ^ 0x9B58661;
                                                nArray2[1] = 0x9B586E1 ^ 0x9B58661;
                                                nArray = nArray2;
                                                if (n3 == 0) break block25;
                                                boolean bl = true;
                                                oc69da1aa7f5.\u04ac = bl;
                                            }
                                            n5 = n6;
                                        }
                                        if (n3 != 0) break block26;
                                        if (n5 > (0x9B5861E ^ 0x9B58661)) break block27;
                                        nArray = new int[]{n6};
                                        if (n3 == 0) break block25;
                                    }
                                    n5 = n6;
                                }
                                if (n3 != 0) break block28;
                                if (n5 > (0x9B5819E ^ 0x9B58661)) break block29;
                                int[] nArray3 = new int[0x9B58663 ^ 0x9B58661];
                                nArray3[0] = 0x9B586A1 ^ 0x9B58661 | n6 >> (0x9B58667 ^ 0x9B58661);
                                nArray3[1] = 0x9B586E1 ^ 0x9B58661 | n6 & (0x9B5865E ^ 0x9B58661);
                                nArray = nArray3;
                                if (n3 == 0) break block25;
                            }
                            n5 = 0x9B58662 ^ 0x9B58661;
                        }
                        int[] nArray4 = new int[n5];
                        nArray4[0] = 0x9B58681 ^ 0x9B58661 | n6 >> (0x9B5866D ^ 0x9B58661);
                        nArray4[1] = 0x9B586E1 ^ 0x9B58661 | n6 >> (0x9B58667 ^ 0x9B58661) & (0x9B5865E ^ 0x9B58661);
                        nArray4[0x9B58663 ^ 0x9B58661] = 0x9B586E1 ^ 0x9B58661 | n6 & (0x9B5865E ^ 0x9B58661);
                        nArray = nArray4;
                    }
                    int[] nArray5 = nArray;
                    int n7 = nArray5.length;
                    int n8 = 0;
                    while (n8 < n7) {
                        int n9 = nArray5[n8];
                        if (n3 == 0) {
                            if (n3 != 0) break block22;
                            if (n2 == (0x9B58605 ^ 0x9B58661) && n3 == 0) break block12;
                            byArray[n2++] = (byte)n9;
                            ++n8;
                        }
                        if (n3 == 0) continue;
                    }
                    ++n4;
                }
                if (n3 == 0) continue;
            }
            n = n2 + 1;
        }
        byte[] byArray2 = new byte[n];
        System.arraycopy(byArray, 0, byArray2, 0, n2);
        return byArray2;
    }
}

