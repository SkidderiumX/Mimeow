/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import x.oc15f53f5c1a;
import x.oc1957f41321;
import x.oc33e2bcdd33;
import x.oc6111f05032;
import x.oc714cf0262c;
import x.oc9755810e45;
import x.ocb683e2d821;
import x.occ39d36078d;
import x.ocd5cc9ffddf;
import x.oce3cc81daa8;

public class oc02a3730b27 {
    private static final oc1957f41321 \u0406 = new oc1957f41321();
    private static double \u01f6;
    public static int \u0166;

    private oc02a3730b27() {
    }

    public static oc6111f05032 \u0587() {
        return new oc6111f05032(Minecraft.getMinecraft());
    }

    private static boolean \u0228() {
        boolean bl;
        block6: {
            block5: {
                oc15f53f5c1a oc15f53f5c1a2;
                int n;
                block4: {
                    n = \u0166;
                    oc15f53f5c1a2 = oc9755810e45.\u0223;
                    if (n != 0) break block4;
                    if (oc15f53f5c1a2 == null) break block5;
                    oc15f53f5c1a2 = oc9755810e45.\u0223;
                }
                bl = oc15f53f5c1a2.z$3rzb3dil7uydr();
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    private static boolean \u0299() {
        boolean bl;
        block11: {
            block9: {
                occ39d36078d occ39d36078d2;
                int n;
                block10: {
                    block8: {
                        n = \u0166;
                        occ39d36078d2 = oc9755810e45.G;
                        if (n != 0) break block8;
                        if (occ39d36078d2 == null) break block9;
                        occ39d36078d2 = oc9755810e45.G;
                    }
                    if (n != 0) break block10;
                    if (!occ39d36078d2.z$3rzb3dil7uydr()) break block9;
                    occ39d36078d2 = oc9755810e45.G;
                }
                bl = occ39d36078d2.\u01d3();
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }

    public static void \u04e6(float f) {
        boolean bl;
        oc6111f05032 oc6111f050322;
        block38: {
            block37: {
                oc714cf0262c oc714cf0262c2;
                int n;
                block36: {
                    block33: {
                        oce3cc81daa8 oce3cc81daa82;
                        block35: {
                            block34: {
                                block32: {
                                    boolean bl2;
                                    block30: {
                                        block31: {
                                            block28: {
                                                block29: {
                                                    oc6111f050322 = oc02a3730b27.\u0587();
                                                    n = \u0166;
                                                    bl2 = oc6111f050322.\u0544();
                                                    if (n != 0) break block28;
                                                    if (bl2) break block29;
                                                    \u0406.\u03f8();
                                                    return;
                                                }
                                                bl2 = oc02a3730b27.\u0228();
                                            }
                                            if (n != 0) break block30;
                                            if (!bl2) break block31;
                                            ocb683e2d821.\u051d(oc6111f050322, 0.0, f);
                                        }
                                        bl2 = oc02a3730b27.\u0299();
                                    }
                                    if (bl2) {
                                        \u0406.\u04bd(oc6111f050322);
                                    }
                                    oce3cc81daa82 = oc9755810e45.\u050e;
                                    if (n != 0) break block32;
                                    if (oce3cc81daa82 == null) break block33;
                                    oce3cc81daa82 = oc9755810e45.\u050e;
                                }
                                if (n != 0) break block34;
                                if (!oce3cc81daa82.z$3rzb3dil7uydr()) break block33;
                                oce3cc81daa82 = oc9755810e45.\u050e;
                                if (n != 0) break block35;
                            }
                            if (!oce3cc81daa82.\u01b3()) break block33;
                            oce3cc81daa82 = oc9755810e45.\u050e;
                        }
                        oce3cc81daa82.\u04b5(oc6111f050322);
                    }
                    oc714cf0262c2 = oc9755810e45.\u0249;
                    if (n != 0) break block36;
                    if (oc714cf0262c2 == null) break block37;
                    oc714cf0262c2 = oc9755810e45.\u0249;
                }
                bl = oc714cf0262c2.\u0454();
                if (n != 0) break block38;
                if (!bl) break block37;
                oc9755810e45.\u0249.\u01d8(oc6111f050322);
            }
            bl = oc02a3730b27.\u0228();
        }
        if (bl) {
            oc9755810e45.\u0223.\u01e1(oc6111f050322);
        }
    }

    public static void \u03f7() {
        if (oc02a3730b27.\u0228()) {
            ocd5cc9ffddf.\u03c7();
        }
    }

    public static void \u0418() {
        if (oc02a3730b27.\u0228()) {
            ocb683e2d821.\u0222(oc02a3730b27.\u0587());
        }
    }

    public static void \u0224() {
        boolean bl;
        oc6111f05032 oc6111f050322;
        block9: {
            block10: {
                oc6111f050322 = oc02a3730b27.\u0587();
                int n = \u0166;
                bl = oc02a3730b27.\u0299();
                if (n != 0) break block9;
                if (!bl) break block10;
                oc9755810e45.G.L(oc6111f050322, new oc33e2bcdd33(0x8A08D0D1 ^ 0x8A08D0C3));
            }
            bl = oc02a3730b27.\u0228();
        }
        if (bl) {
            oc9755810e45.\u0223.\u00cd(oc6111f050322);
            oc33e2bcdd33 oc33e2bcdd332 = new oc33e2bcdd33(0x8A08D0CE ^ 0x8A08D0C3);
            oc33e2bcdd332.T = oc33e2bcdd332.\u00e4 = oc9755810e45.\u0223.\u0545();
            oc33e2bcdd33 oc33e2bcdd333 = oc33e2bcdd332;
            float f = ocb683e2d821.\u029d() ? ocb683e2d821.\u0524() : oc6111f050322.\u016d().rotationYaw;
            oc33e2bcdd333.\u0538 = f;
            oc33e2bcdd33 oc33e2bcdd334 = oc33e2bcdd332;
            float f2 = ocb683e2d821.\u029d() ? ocb683e2d821.\u020a() : oc6111f050322.\u016d().rotationPitch;
            oc33e2bcdd334.\u04b8 = f2;
            ocb683e2d821.W(oc6111f050322, oc33e2bcdd332);
            ocb683e2d821.\u0544(oc6111f050322, true);
        }
    }

    public static void \u0125() {
        ocb683e2d821.\u0446(oc02a3730b27.\u0587());
    }

    public static void \u0269() {
        block30: {
            boolean bl;
            double d;
            oc6111f05032 oc6111f050322;
            block33: {
                block32: {
                    oc714cf0262c oc714cf0262c2;
                    double d2;
                    int n;
                    block31: {
                        boolean bl2;
                        block28: {
                            block29: {
                                oc6111f05032 oc6111f050323;
                                block26: {
                                    block27: {
                                        double d3;
                                        block24: {
                                            block25: {
                                                oc6111f050322 = oc02a3730b27.\u0587();
                                                n = \u0166;
                                                d = (double)System.nanoTime() / 1.0E9;
                                                d3 = \u01f6;
                                                if (n != 0) break block24;
                                                if (d3 == 0.0) break block25;
                                                oc6111f050323 = oc6111f050322;
                                                if (n != 0) break block26;
                                                if (oc6111f050323.\u0544()) break block27;
                                            }
                                            d3 = d;
                                        }
                                        \u01f6 = d3;
                                    }
                                    oc6111f050323 = oc6111f050322;
                                }
                                bl2 = oc6111f050323.\u0544();
                                if (n != 0) break block28;
                                if (bl2) break block29;
                                return;
                            }
                            bl2 = oc02a3730b27.\u0228();
                        }
                        if (bl2) {
                            ocb683e2d821.\u02a9(oc6111f050322);
                        }
                        d2 = d - \u01f6;
                        if (0.002 > d2) break block30;
                        oc714cf0262c2 = oc9755810e45.\u0249;
                        if (n != 0) break block31;
                        if (oc714cf0262c2 == null) break block32;
                        oc714cf0262c2 = oc9755810e45.\u0249;
                    }
                    bl = oc714cf0262c2.\u0454();
                    if (n != 0) break block33;
                    if (!bl) break block32;
                    oc9755810e45.\u0249.\u00ca(d2);
                }
                bl = oc02a3730b27.\u0228();
            }
            if (bl) {
                ocb683e2d821.\u0544(oc6111f050322, false);
                ocb683e2d821.\u026c(oc6111f050322);
            }
            \u01f6 = d;
        }
    }

    public static void \u03bc() {
        if (oc02a3730b27.\u0228()) {
            ocb683e2d821.\u0389(oc02a3730b27.\u0587());
        }
    }

    public static void \u024f() {
        if (oc02a3730b27.\u0228()) {
            ocb683e2d821.\u04ef(oc02a3730b27.\u0587());
        }
    }

    public static void \u051b() {
        ocb683e2d821.\u027e();
    }

    public static void \u0575() {
        if (oc02a3730b27.\u0228()) {
            ocb683e2d821.\u03e7(oc02a3730b27.\u0587());
        }
    }

    public static void \u014e() {
        ocb683e2d821.\u051e();
    }

    public static void \u0167() {
        ocb683e2d821.\u0430();
    }

    public static void Y() {
        block9: {
            oc6111f05032 oc6111f050322;
            block10: {
                boolean bl;
                oc6111f05032 oc6111f050323;
                block8: {
                    oc6111f050323 = oc02a3730b27.\u0587();
                    int n = \u0166;
                    bl = oc02a3730b27.\u0228();
                    if (n != 0) break block8;
                    if (!bl) break block9;
                    oc6111f050322 = oc6111f050323;
                    if (n != 0) break block10;
                    bl = oc6111f050322.\u0544();
                }
                if (!bl) break block9;
                oc6111f050322 = oc6111f050323;
            }
            ocd5cc9ffddf.\u0142(oc6111f050322);
        }
    }

    public static void \u00da() {
        block9: {
            oc6111f05032 oc6111f050322;
            block10: {
                boolean bl;
                oc6111f05032 oc6111f050323;
                block8: {
                    oc6111f050323 = oc02a3730b27.\u0587();
                    int n = \u0166;
                    bl = oc02a3730b27.\u0228();
                    if (n != 0) break block8;
                    if (!bl) break block9;
                    oc6111f050322 = oc6111f050323;
                    if (n != 0) break block10;
                    bl = oc6111f050322.\u0544();
                }
                if (!bl) break block9;
                oc6111f050322 = oc6111f050323;
            }
            ocd5cc9ffddf.A(oc6111f050322);
        }
    }

    public static void \u0167(oc33e2bcdd33 oc33e2bcdd332) {
        block8: {
            int n;
            block7: {
                int n2 = \u0166;
                n = oc33e2bcdd332.\u0555;
                if (n2 != 0) break block7;
                if (n != (0x970BD722 ^ 0x970BD720)) break block8;
                n = oc02a3730b27.\u0299() ? 1 : 0;
            }
            if (n != 0) {
                oc9755810e45.G.\u020d(oc33e2bcdd332);
            }
        }
    }

    public static EntityPlayer \u039c() {
        return \u0406.\u03ed();
    }

    public static double \u010a() {
        return \u0406.\u0128();
    }

    public static boolean \u04da(EntityPlayer entityPlayer) {
        boolean bl;
        block6: {
            block5: {
                occ39d36078d occ39d36078d2;
                int n;
                block4: {
                    occ39d36078d occ39d36078d3 = oc9755810e45.G;
                    n = \u0166;
                    occ39d36078d2 = occ39d36078d3;
                    if (n != 0) break block4;
                    if (occ39d36078d2 == null) break block5;
                    occ39d36078d2 = occ39d36078d3;
                }
                bl = occ39d36078d2.\u0478(entityPlayer);
                if (n != 0) break block6;
                if (!bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }
}

