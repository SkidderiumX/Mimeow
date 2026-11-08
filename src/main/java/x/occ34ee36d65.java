/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import x.oc668fce0dbf;
import x.oc69da1aa7f5;
import x.oc9755810e45;
import x.occ2f8dff8d8;
import x.oce4cea752dd;
import x.oce6044968f8;

public class occ34ee36d65
extends oc69da1aa7f5 {
    private final occ2f8dff8d8 \u0197 = new occ2f8dff8d8("Scaffold Only", false);
    public static int \u0586;

    public occ34ee36d65() {
        super("NoSneakAnimation", oce4cea752dd.\u014e);
        this.\u028c(this.\u0197);
    }

    public static boolean \u042e(Entity entity) {
        boolean bl;
        block42: {
            block43: {
                boolean bl2;
                boolean bl3;
                boolean bl4;
                boolean bl5;
                boolean bl6;
                block41: {
                    block39: {
                        occ34ee36d65 occ34ee36d652;
                        block40: {
                            occ34ee36d65 occ34ee36d653;
                            block38: {
                                block37: {
                                    block36: {
                                        occ34ee36d65 occ34ee36d654;
                                        block35: {
                                            boolean bl7;
                                            block34: {
                                                block33: {
                                                    boolean bl8;
                                                    block32: {
                                                        block31: {
                                                            oc69da1aa7f5 oc69da1aa7f52;
                                                            block30: {
                                                                block29: {
                                                                    boolean bl9;
                                                                    block28: {
                                                                        block27: {
                                                                            Entity entity2;
                                                                            block26: {
                                                                                bl6 = oce6044968f8.\u0452;
                                                                                entity2 = entity;
                                                                                if (bl6) break block26;
                                                                                if (entity2 == null) break block27;
                                                                                entity2 = entity;
                                                                            }
                                                                            bl9 = entity2.isSneaking();
                                                                            if (bl6) break block28;
                                                                            if (bl9) break block29;
                                                                        }
                                                                        bl9 = false;
                                                                    }
                                                                    return bl9;
                                                                }
                                                                occ34ee36d653 = oc9755810e45.\u0394;
                                                                oc69da1aa7f5 oc69da1aa7f53 = oc9755810e45.\u02ac(oc668fce0dbf.class);
                                                                oc69da1aa7f52 = oc69da1aa7f53;
                                                                if (bl6) break block30;
                                                                if (oc69da1aa7f52 == null) break block31;
                                                                oc69da1aa7f52 = oc69da1aa7f53;
                                                            }
                                                            bl8 = oc69da1aa7f52.z$3rzb3dil7uydr();
                                                            if (bl6) break block32;
                                                            if (!bl8) break block31;
                                                            bl8 = true;
                                                            break block32;
                                                        }
                                                        bl8 = false;
                                                    }
                                                    bl5 = bl8;
                                                    Minecraft minecraft = Minecraft.getMinecraft();
                                                    if (minecraft == null || entity != minecraft.thePlayer) break block33;
                                                    bl7 = true;
                                                    break block34;
                                                }
                                                bl7 = false;
                                            }
                                            bl4 = bl7;
                                            occ34ee36d654 = occ34ee36d653;
                                            if (bl6) break block35;
                                            if (occ34ee36d654 == null) break block36;
                                            occ34ee36d654 = occ34ee36d653;
                                        }
                                        bl3 = occ34ee36d654.z$3rzb3dil7uydr();
                                        if (bl6) break block37;
                                        if (!bl3) break block36;
                                        bl3 = true;
                                        break block37;
                                    }
                                    bl3 = false;
                                }
                                occ34ee36d652 = occ34ee36d653;
                                if (bl6) break block38;
                                if (occ34ee36d652 == null) break block39;
                                occ34ee36d652 = occ34ee36d653;
                            }
                            if (bl6) break block40;
                            if (occ34ee36d652.\u0197 == null) break block39;
                            occ34ee36d652 = occ34ee36d653;
                        }
                        bl2 = occ34ee36d652.\u0197.\u01ed();
                        if (bl6) break block41;
                        if (!bl2) break block39;
                        bl2 = true;
                        break block41;
                    }
                    bl2 = false;
                }
                bl = occ34ee36d65.\u0199(bl3, bl2, bl5, bl4);
                if (bl6) break block42;
                if (bl) break block43;
                bl = true;
                break block42;
            }
            bl = false;
        }
        return bl;
    }

    static boolean \u0199(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5;
        block13: {
            block11: {
                block14: {
                    boolean bl6;
                    block12: {
                        block10: {
                            bl6 = oce6044968f8.\u0452;
                            bl5 = bl;
                            if (bl6) break block10;
                            if (!bl5) break block11;
                            bl5 = bl4;
                        }
                        if (bl6) break block12;
                        if (!bl5) break block11;
                        bl5 = bl2;
                    }
                    if (bl6) break block13;
                    if (!bl5) break block14;
                    bl5 = bl3;
                    if (bl6) break block13;
                    if (!bl5) break block11;
                }
                bl5 = true;
                break block13;
            }
            bl5 = false;
        }
        return bl5;
    }
}

