/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.function.IntUnaryOperator;
import net.minecraft.entity.player.InventoryPlayer;
import x.oc47ba9d5fd2;
import x.oc6111f05032;
import x.oca75e2afde8;
import x.ocf5b7e839f8;

public class ocd5cc9ffddf {
    private static int \u0290;
    private static boolean \u0524;
    private static Object \u04eb;
    private static oca75e2afde8 \u03e0;
    private static Object \u0542;
    private static int \u022d;
    private static int \u042f;
    private static int \u0135;
    private static int \u01c7;
    private static int \u0440;
    private static int \u057e;
    public static boolean \u0406;

    private ocd5cc9ffddf() {
    }

    public static synchronized void \u0419(int n, boolean bl) {
        \u0290 = n;
        \u0524 = bl;
    }

    public static oca75e2afde8 \u0523(InventoryPlayer inventoryPlayer) {
        return new oc47ba9d5fd2(inventoryPlayer);
    }

    public static synchronized void \u03c7() {
        block3: {
            Object object;
            block2: {
                boolean bl = \u0406;
                object = \u04eb;
                if (bl) break block2;
                if (object == null) break block3;
                object = \u04eb;
            }
            ocf5b7e839f8.\u0130(object);
        }
        \u04eb = null;
        ++\u042f;
        \u0290 = 0;
        \u0524 = false;
    }

    public static synchronized void \u01dc(oca75e2afde8 oca75e2afde82) {
        block21: {
            int n;
            block26: {
                int n2;
                block27: {
                    int n3;
                    block24: {
                        block25: {
                            oca75e2afde8 oca75e2afde83;
                            boolean bl;
                            block23: {
                                int n4;
                                block22: {
                                    int n5;
                                    block20: {
                                        bl = \u0406;
                                        n5 = \u0135;
                                        if (bl) break block20;
                                        if (n5 != 0) break block21;
                                        n5 = oca75e2afde82.z$u0i97vtlfwrv();
                                    }
                                    n2 = n5;
                                    oca75e2afde83 = oca75e2afde82;
                                    n4 = n2;
                                    if (bl) break block22;
                                    if (!oca75e2afde83.z$39wouso4y16is(n4)) break block21;
                                    oca75e2afde83 = oca75e2afde82;
                                    if (bl) break block23;
                                    n4 = n2;
                                }
                                if (!oca75e2afde83.z$1lg9n53t5fysv(n4)) break block21;
                                \u0135 = oca75e2afde82.z$1x9lvqwr1hi6a(n2);
                                oca75e2afde83 = oca75e2afde82;
                            }
                            \u01c7 = oca75e2afde83.z$dreqphaxw0s4(n2);
                            n3 = \u042f;
                            if (bl) break block24;
                            if (Integer.compareUnsigned(n3, 0x4FD7F129 ^ 0x4FD7F13D) > 0) break block25;
                            n = \u0440;
                            if (bl) break block26;
                            if (n == n2) break block27;
                        }
                        n3 = \u01c7;
                    }
                    \u057e = n3;
                }
                \u042f = 0;
                n = n2;
            }
            \u0440 = n;
        }
    }

    public static void \u0142(oc6111f05032 oc6111f050322) {
        block5: {
            oc6111f05032 oc6111f050323;
            block4: {
                boolean bl = \u0406;
                oc6111f050323 = oc6111f050322;
                if (bl) break block4;
                if (!oc6111f050323.\u0544()) break block5;
                oc6111f050323 = oc6111f050322;
            }
            ocd5cc9ffddf.\u01dc(ocd5cc9ffddf.\u0523(oc6111f050323.\u016d().inventory));
        }
    }

    public static synchronized void \u028a(oca75e2afde8 oca75e2afde82) {
        block31: {
            int n;
            block39: {
                block40: {
                    boolean bl;
                    block35: {
                        int n2;
                        block36: {
                            int n3;
                            block37: {
                                block38: {
                                    int n4;
                                    int n5;
                                    block32: {
                                        block34: {
                                            block33: {
                                                int n6;
                                                block30: {
                                                    bl = \u0406;
                                                    n6 = \u0135;
                                                    if (bl) break block30;
                                                    if (n6 == 0) break block31;
                                                    n6 = oca75e2afde82.z$u0i97vtlfwrv();
                                                }
                                                n5 = n6;
                                                n4 = oca75e2afde82.z$39wouso4y16is(n5);
                                                if (bl) break block32;
                                                if (n4 == 0) break block33;
                                                n4 = oca75e2afde82.z$1nwt8p8bpa19d(n5);
                                                if (bl) break block32;
                                                if (n4 == 0) break block33;
                                                n4 = oca75e2afde82.z$1x9lvqwr1hi6a(n5);
                                                if (bl) break block32;
                                                if (n4 != 0) break block34;
                                            }
                                            n4 = 1;
                                            break block32;
                                        }
                                        n4 = 0;
                                    }
                                    n2 = n4;
                                    n = n2;
                                    if (bl) break block35;
                                    if (n != 0) break block36;
                                    n = oca75e2afde82.z$dreqphaxw0s4(n5);
                                    if (bl) break block35;
                                    if (n >= \u01c7) break block36;
                                    n3 = \u057e - 1;
                                    if (bl) break block37;
                                    \u057e = n3;
                                    if (n3 != 0) break block38;
                                    n3 = 1;
                                    break block37;
                                }
                                n3 = 0;
                            }
                            n2 = n3;
                        }
                        n = n2;
                    }
                    if (bl) break block39;
                    if (n == 0) break block40;
                    \u0290 = \u0135;
                    \u0524 = true;
                }
                n = 0;
            }
            \u0135 = n;
        }
    }

    public static void A(oc6111f05032 oc6111f050322) {
        block5: {
            oc6111f05032 oc6111f050323;
            block4: {
                boolean bl = \u0406;
                oc6111f050323 = oc6111f050322;
                if (bl) break block4;
                if (!oc6111f050323.\u0544()) break block5;
                oc6111f050323 = oc6111f050322;
            }
            ocd5cc9ffddf.\u028a(ocd5cc9ffddf.\u0523(oc6111f050323.\u016d().inventory));
        }
    }

    public static synchronized int \u029e() {
        return \u0290;
    }

    public static synchronized boolean \u00f2() {
        return \u0524;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int \u010a(int n) {
        int n2;
        boolean bl = \u0406;
        int n3 = n;
        if (!bl) {
            switch (n3) {
                case 1: 
                case 2: 
                case 3: 
                case 35: 
                case 45: {
                    return 0x2632C3B8 ^ 0x2632C3BA;
                }
                case 5: 
                case 17: 
                case 20: 
                case 24: 
                case 87: {
                    return 1;
                }
            }
            n3 = n - (0x2632C3C3 ^ 0x2632C3BA);
        }
        int n4 = n2 = n3;
        if (!bl) {
            if (Integer.compareUnsigned(n4, 0x2632C393 ^ 0x2632C3BA) > 0) return -1;
            long l = ((0x975C539AD9746F5BL ^ 0x975C51DAD9746F5AL) >>> (n2 & (0x2632C385 ^ 0x2632C3BA)) & 1L) - 0L;
            n4 = l == 0L ? 0 : (l < 0L ? -1 : 1);
        }
        if (bl) return n4;
        if (n4 == 0) return -1;
        return 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int \u0188(int n) {
        boolean bl = \u0406;
        int n2 = n;
        if (bl) return n2;
        switch (n2) {
            case 1: 
            case 2: 
            case 3: 
            case 20: 
            case 24: 
            case 45: 
            case 87: 
            case 159: {
                return 0xA173B20C ^ 0xA173B20E;
            }
            case 4: 
            case 5: 
            case 17: 
            case 121: 
            case 162: {
                return 0xA173B20D ^ 0xA173B20E;
            }
            case 35: {
                return 1;
            }
            case 49: {
                return 0xA173B20A ^ 0xA173B20E;
            }
        }
        return -1;
    }

    public static int \u03df(int[] nArray, int n, int n2, boolean bl, IntUnaryOperator intUnaryOperator) {
        int n3;
        block19: {
            int n4;
            int n5;
            boolean bl2;
            block17: {
                block18: {
                    bl2 = \u0406;
                    int n4 = n;
                    n4 = bl;
                    if (bl2) break block17;
                    if (n4 == 0) break block18;
                    n4 = 1;
                    break block17;
                }
                n4 = 0;
            }
            int n6 = n5 + n4;
            int n7 = -1;
            int n8 = -1;
            int n9 = 0;
            while (n9 < (0x990723BF ^ 0x990723B6)) {
                block20: {
                    block21: {
                        int n10;
                        int n11;
                        block22: {
                            int n12;
                            block23: {
                                n11 = (n6 + n9) % (0x990723BF ^ 0x990723B6);
                                n3 = nArray[n11];
                                if (bl2) break block19;
                                n12 = n3;
                                if (bl2) break block20;
                                if (n12 == 0) break block21;
                                n10 = n2;
                                if (bl2) break block22;
                                if (n10 == 0) break block23;
                                n10 = n12;
                                if (bl2) break block22;
                                if (n10 != n2) break block23;
                                return n11;
                            }
                            n10 = intUnaryOperator.applyAsInt(n12);
                        }
                        int n13 = n10;
                        if (bl2) break block20;
                        if (n13 <= n8) break block21;
                        n8 = n13;
                        n7 = n11;
                    }
                    ++n9;
                }
                if (!bl2) continue;
            }
            n3 = n7;
        }
        return n3;
    }

    public static synchronized boolean \u046e(oc6111f05032 oc6111f050322, Object object, boolean bl, boolean bl2) {
        int n;
        block14: {
            block12: {
                block15: {
                    boolean bl3;
                    block13: {
                        bl3 = \u0406;
                        if (\u04eb != null) break block12;
                        n = oc6111f050322.\u0544();
                        if (bl3) break block13;
                        if (n == 0) break block12;
                        n = bl;
                    }
                    if (bl3) break block14;
                    if (n != 0) break block15;
                    n = \u0290;
                    if (bl3) break block14;
                    if (n == 0) break block12;
                }
                n = ocd5cc9ffddf.\u01d2(ocd5cc9ffddf.\u0523(oc6111f050322.\u016d().inventory), object, bl, bl2) ? 1 : 0;
                break block14;
            }
            n = 0;
        }
        return n != 0;
    }

    public static synchronized boolean \u01d2(oca75e2afde8 oca75e2afde82, Object object, boolean bl, boolean bl2) {
        int n;
        block28: {
            block25: {
                int n2;
                block31: {
                    block30: {
                        Object object2;
                        int n3;
                        block32: {
                            block33: {
                                boolean bl3;
                                block29: {
                                    int n4;
                                    block26: {
                                        block27: {
                                            bl3 = \u0406;
                                            if (\u04eb != null) break block25;
                                            n4 = bl;
                                            if (bl3) break block26;
                                            if (n4 != 0) break block27;
                                            n = \u0290;
                                            if (bl3) break block28;
                                            if (n == 0) break block25;
                                        }
                                        n4 = 0x5944C127 ^ 0x5944C12E;
                                    }
                                    int[] nArray = new int[n4];
                                    for (n3 = 0; n3 < (0x5944C127 ^ 0x5944C12E); ++n3) {
                                        if (!bl3) {
                                            nArray[n3] = oca75e2afde82.z$1x9lvqwr1hi6a(n3);
                                            if (!bl3) continue;
                                            break;
                                        }
                                        break block29;
                                    }
                                    int[] nArray2 = nArray;
                                    int n6 = oca75e2afde82.z$u0i97vtlfwrv();
                                    n6 = \u0290;
                                    boolean bl4 = \u0524;
                                    IntUnaryOperator intUnaryOperator = bl2 ? ocd5cc9ffddf::\u0188 : ocd5cc9ffddf::\u010a;
                                    n2 = ocd5cc9ffddf.\u03df(nArray2, n5, n6, bl4, intUnaryOperator);
                                    if (bl3) break block31;
                                    n3 = n2;
                                }
                                if (n3 == -1) break block30;
                                n2 = ocf5b7e839f8.\u04e1(object) ? 1 : 0;
                                if (bl3) break block31;
                                if (n2 == 0) break block30;
                                object2 = \u0542;
                                if (bl3) break block32;
                                if (object2 == object) break block33;
                                \u022d = oca75e2afde82.z$u0i97vtlfwrv();
                                \u03e0 = oca75e2afde82;
                                \u0542 = object;
                            }
                            object2 = object;
                        }
                        \u04eb = object2;
                        oca75e2afde82.z$f8yzt7edcdjd(n3);
                        return true;
                    }
                    n2 = 0;
                }
                return n2 != 0;
            }
            n = 0;
        }
        return n != 0;
    }

    public static synchronized void \u0143(Object object) {
        Object object2;
        block10: {
            block11: {
                boolean bl;
                block8: {
                    block9: {
                        bl = \u0406;
                        object2 = \u0542;
                        if (bl) break block8;
                        if (object2 != object) break block9;
                        \u03e0.z$f8yzt7edcdjd(\u022d);
                        \u0542 = null;
                        \u03e0 = null;
                    }
                    object2 = \u04eb;
                }
                if (bl) break block10;
                if (object2 != object) break block11;
                \u04eb = null;
            }
            object2 = object;
        }
        ocf5b7e839f8.\u0130(object2);
    }

    public static synchronized void \u0156() {
        block9: {
            Object object;
            block8: {
                boolean bl;
                block6: {
                    block7: {
                        bl = \u0406;
                        object = \u03e0;
                        if (bl) break block6;
                        if (object == null) break block7;
                        \u03e0.z$f8yzt7edcdjd(\u022d);
                    }
                    object = \u04eb;
                }
                if (bl) break block8;
                if (object == null) break block9;
                object = \u04eb;
            }
            ocf5b7e839f8.\u0130(object);
        }
        \u0542 = null;
        \u04eb = null;
        \u03e0 = null;
        \u0290 = 0;
        \u0524 = false;
        \u057e = 0;
        \u0440 = 0;
        \u01c7 = 0;
        \u0135 = 0;
        \u042f = 0;
    }
}

