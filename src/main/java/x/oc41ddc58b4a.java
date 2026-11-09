/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumFacing;
import x.oc4034802c1a;
import x.oc683264f07d;
import x.oc70db705765;
import x.oc7ab2161b9f;
import x.oc84f20a0bc5;
import x.ocb4881cd49b;

public class oc41ddc58b4a {
    static final double \u01ec = 0.268;
    private static final double \u01ca = (double)0.91f;
    private static final double \u0117 = 0.031;
    static final int \u0209 = 3;
    static final double \u01db = 0.17;
    private int \u0166;
    private boolean \u0194;
    private boolean \u0562;
    private boolean \u0233;
    private boolean \u0106;
    private double \u00fc;
    private double \u0526;
    private double \u02b0;
    private boolean \u016f;
    private boolean \u0207;
    private boolean \u00ce;
    private String \u01a1 = "";
    private String \u0277 = "";
    private String \u0521 = "unattributed";
    private boolean \u0549;
    private String \u0133 = "unknown";

    oc41ddc58b4a() {
    }

    synchronized void \u010e() {
        this.\u0106 = false;
        this.\u016f = false;
        this.\u0207 = false;
        this.\u00ce = false;
        this.\u01a1 = "";
        this.\u0277 = "";
        this.\u0521 = "unattributed";
        this.\u0549 = false;
        this.\u0133 = "unknown";
        this.\u0166 = 0;
        this.\u0194 = false;
        this.\u0233 = false;
        this.\u0562 = false;
    }

    synchronized void z(String string, boolean bl) {
        this.\u039d(string, bl, false);
    }

    synchronized void \u039d(String string, boolean bl, boolean bl2) {
        block8: {
            block6: {
                oc41ddc58b4a oc41ddc58b4a2;
                block7: {
                    int n = oc84f20a0bc5.\u0117;
                    oc41ddc58b4a2 = this;
                    if (n != 0) break block6;
                    oc41ddc58b4a2.\u0521 = string;
                    this.\u0549 = bl;
                    this.\u0194 = false;
                    this.\u0233 = false;
                    if (bl2) break block7;
                    if (!bl) break block8;
                }
                oc41ddc58b4a2 = this;
            }
            oc41ddc58b4a2.\u0166 = 0;
        }
    }

    synchronized boolean \u04bd() {
        return this.\u0194;
    }

    synchronized boolean \u0431() {
        return this.\u0233;
    }

    synchronized void \u0271(EntityPlayerSP entityPlayerSP, WorldClient worldClient, oc70db705765 oc70db7057652, boolean bl) {
        int n;
        block97: {
            int n2;
            block98: {
                int n3;
                block103: {
                    block102: {
                        double d;
                        double d2;
                        int n4;
                        block101: {
                            EntityPlayerSP entityPlayerSP2;
                            block99: {
                                block100: {
                                    int n5;
                                    block96: {
                                        block90: {
                                            int n6;
                                            boolean bl2;
                                            float f;
                                            boolean bl3;
                                            double d3;
                                            double d4;
                                            float f2;
                                            double d5;
                                            double d6;
                                            double d7;
                                            block94: {
                                                block95: {
                                                    float f3;
                                                    double d8;
                                                    double d9;
                                                    block93: {
                                                        double d10;
                                                        double d11;
                                                        block92: {
                                                            int n7;
                                                            block91: {
                                                                oc41ddc58b4a oc41ddc58b4a2;
                                                                block89: {
                                                                    float f4;
                                                                    block86: {
                                                                        block88: {
                                                                            block87: {
                                                                                boolean bl4;
                                                                                block84: {
                                                                                    block85: {
                                                                                        block82: {
                                                                                            block83: {
                                                                                                block80: {
                                                                                                    block81: {
                                                                                                        EntityPlayerSP entityPlayerSP3;
                                                                                                        block78: {
                                                                                                            block79: {
                                                                                                                block77: {
                                                                                                                    n4 = oc84f20a0bc5.\u0117;
                                                                                                                    if (!this.\u0562 || oc70db7057652 == null) break block77;
                                                                                                                    entityPlayerSP3 = entityPlayerSP;
                                                                                                                    if (n4 != 0) break block78;
                                                                                                                    if (entityPlayerSP3 != null) break block79;
                                                                                                                }
                                                                                                                return;
                                                                                                            }
                                                                                                            entityPlayerSP3 = entityPlayerSP;
                                                                                                        }
                                                                                                        bl4 = entityPlayerSP3.isSneaking();
                                                                                                        if (n4 != 0) break block80;
                                                                                                        if (bl4) break block81;
                                                                                                        bl4 = this.\u0207;
                                                                                                        if (n4 != 0) break block80;
                                                                                                        if (bl4) break block81;
                                                                                                        bl4 = this.\u016f;
                                                                                                        if (n4 != 0) break block80;
                                                                                                        if (bl4) break block81;
                                                                                                        this.\u0562 = false;
                                                                                                        return;
                                                                                                    }
                                                                                                    bl4 = bl;
                                                                                                }
                                                                                                if (n4 != 0) break block82;
                                                                                                if (!bl4) break block83;
                                                                                                this.\u0562 = false;
                                                                                                return;
                                                                                            }
                                                                                            bl4 = oc70db7057652.\u04a7();
                                                                                        }
                                                                                        if (n4 != 0) break block84;
                                                                                        if (!bl4) break block85;
                                                                                        this.\u0233 = true;
                                                                                        return;
                                                                                    }
                                                                                    bl4 = this.\u0106;
                                                                                }
                                                                                double d12 = bl4 ? Math.hypot(entityPlayerSP.posX - this.\u00fc, entityPlayerSP.posZ - this.\u02b0) : Double.NaN;
                                                                                d9 = d12;
                                                                                double d13 = this.\u0106 ? entityPlayerSP.posY - this.\u0526 : Double.NaN;
                                                                                d8 = d13;
                                                                                float f5 = oc70db7057652.\u0509() - 0.0f;
                                                                                f4 = f5 == 0.0f ? 0 : (f5 > 0.0f ? 1 : -1);
                                                                                if (n4 != 0) break block86;
                                                                                if (f4 != false) break block87;
                                                                                float f6 = oc70db7057652.\u01f6() - 0.0f;
                                                                                f4 = f6 == 0.0f ? 0 : (f6 > 0.0f ? 1 : -1);
                                                                                if (n4 != 0) break block86;
                                                                                if (f4 == false) break block88;
                                                                            }
                                                                            f4 = 1.0f;
                                                                            break block86;
                                                                        }
                                                                        f4 = 0.0f;
                                                                    }
                                                                    f3 = f4;
                                                                    oc41ddc58b4a2 = this;
                                                                    if (n4 != 0) break block89;
                                                                    if (oc41ddc58b4a2.\u016f) break block90;
                                                                    oc41ddc58b4a2 = this;
                                                                }
                                                                n7 = oc41ddc58b4a2.\u0106;
                                                                if (n4 != 0) break block91;
                                                                if (n7 == 0) break block90;
                                                                d11 = d9;
                                                                d10 = 0.031;
                                                                if (n4 != 0) break block92;
                                                                double d14 = d11 - d10;
                                                                n7 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
                                                            }
                                                            if (n7 > 0) break block90;
                                                            d7 = d8;
                                                            if (n4 != 0) break block93;
                                                            d11 = Math.abs(d7);
                                                            d10 = 0.031;
                                                        }
                                                        if (!(d11 <= d10)) break block90;
                                                        d7 = entityPlayerSP.motionX;
                                                    }
                                                    d6 = entityPlayerSP.motionY;
                                                    d5 = entityPlayerSP.motionZ;
                                                    f2 = entityPlayerSP.jumpMovementFactor;
                                                    d4 = d9;
                                                    d3 = d8;
                                                    bl3 = entityPlayerSP.onGround;
                                                    f = f3;
                                                    bl2 = oc70db7057652.\u03e7();
                                                    n6 = entityPlayerSP.getPositionUpdateTicks();
                                                    if (n4 != 0) break block94;
                                                    if (n6 < (0x455E34B6 ^ 0x455E34A2)) break block95;
                                                    n6 = 1;
                                                    break block94;
                                                }
                                                n6 = 0;
                                            }
                                            n5 = oc41ddc58b4a.\u0480(d7, d6, d5, f2, d4, d3, bl3, (boolean)f, bl2, n6 != 0) ? 1 : 0;
                                            if (n4 != 0) break block96;
                                            if (n5 == 0) break block90;
                                            n5 = 1;
                                            break block96;
                                        }
                                        n5 = 0;
                                    }
                                    n2 = n5;
                                    n = n2;
                                    if (n4 != 0) break block97;
                                    if (n == 0) break block98;
                                    n = entityPlayerSP.getPositionUpdateTicks();
                                    if (n4 != 0) break block97;
                                    if (n >= (0x455E34B6 ^ 0x455E34A2)) break block98;
                                    d2 = Math.hypot(entityPlayerSP.motionX, entityPlayerSP.motionZ) + Math.max(0.026, (double)entityPlayerSP.jumpMovementFactor);
                                    entityPlayerSP2 = entityPlayerSP;
                                    if (n4 != 0) break block99;
                                    if (!(Math.abs(entityPlayerSP2.motionY) < 0.005)) break block100;
                                    d = 0.0;
                                    break block101;
                                }
                                entityPlayerSP2 = entityPlayerSP;
                            }
                            d = entityPlayerSP2.motionY;
                        }
                        double d15 = d;
                        if (worldClient == null || entityPlayerSP.getEntityBoundingBox() == null) break block102;
                        n3 = worldClient.getCollidingBoundingBoxes(entityPlayerSP, entityPlayerSP.getEntityBoundingBox().addCoord(0.0, d15, 0.0).expand(d2, 0.001, d2)).isEmpty() ? 1 : 0;
                        if (n4 != 0) break block103;
                        if (n3 == 0) break block102;
                        n3 = 1;
                        break block103;
                    }
                    n3 = 0;
                }
                n2 = n3;
            }
            n = n2;
        }
        if (n != 0) {
            this.\u0567("Telly/optional release", false);
            return;
        }
        oc70db7057652.\u0413(true);
        this.\u0233 = true;
        this.\u0567("Telly/deferred optional release", true);
    }

    static boolean \u0480(double d, double d2, double d3, float f, double d4, double d5, boolean bl, boolean bl2, boolean bl3, boolean n) {
        int n2;
        block67: {
            block69: {
                block68: {
                    double d6;
                    double d7;
                    double d8;
                    int n3;
                    block66: {
                        double d9;
                        block64: {
                            block65: {
                                block62: {
                                    block63: {
                                        block59: {
                                            boolean bl4;
                                            block60: {
                                                block61: {
                                                    block58: {
                                                        block56: {
                                                            block57: {
                                                                int n4;
                                                                block54: {
                                                                    block55: {
                                                                        n3 = oc84f20a0bc5.\u0117;
                                                                        n4 = Double.isFinite(d);
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 == 0) break block55;
                                                                        n4 = Double.isFinite(d2);
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 == 0) break block55;
                                                                        n4 = Double.isFinite(d3);
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 == 0) break block55;
                                                                        n4 = Float.isFinite(f);
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 == 0) break block55;
                                                                        float f2 = f - 0.0f;
                                                                        n4 = f2 == 0.0f ? 0 : (f2 < 0.0f ? -1 : 1);
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 < 0) break block55;
                                                                        n4 = Double.isFinite(d4) ? 1 : 0;
                                                                        if (n3 != 0) break block54;
                                                                        if (n4 == 0) break block55;
                                                                        bl4 = Double.isFinite(d5);
                                                                        if (n3 != 0) break block56;
                                                                        if (bl4) break block57;
                                                                    }
                                                                    n4 = 0;
                                                                }
                                                                return n4 != 0;
                                                            }
                                                            bl4 = bl;
                                                        }
                                                        if (n3 != 0) break block58;
                                                        if (!bl4) break block59;
                                                        bl4 = bl2;
                                                    }
                                                    if (n3 != 0) break block60;
                                                    if (bl4) break block61;
                                                    bl4 = bl3;
                                                    if (n3 != 0) break block60;
                                                    if (!bl4) break block59;
                                                }
                                                bl4 = false;
                                            }
                                            return bl4;
                                        }
                                        d8 = Math.max(0.026, (double)f);
                                        d7 = Math.hypot(d, d3);
                                        double d9_r2 = d7 + d8 + d4 - 0.268;
                                        d9_r2 = d9_r2 == 0.0 ? 0 : (d9_r2 > 0.0 ? 1 : -1);
                                        if (n3 != 0) break block62;
                                        if (d9_r2 <= 0) break block63;
                                        return false;
                                    }
                                    d9 = (double)bl;
                                }
                                if (n3 != 0) break block64;
                                if (d9 == false) break block65;
                                d6 = 0.0;
                                break block66;
                            }
                            d6 = d2;
                            if (n3 != 0) break block66;
                            double d9_r = Math.abs(d6) - 0.005;
                            d9_r = d9_r == 0.0 ? 0 : (d9_r < 0.0 ? -1 : 1);
                        }
                        d6 = d9 < 0 ? 0.0 : d2;
                    }
                    double d12 = d6;
                    n2 = n;
                    if (n3 != 0) break block67;
                    if (n2 != 0) break block68;
                    double d13 = d7 - d8 - d4 - 0.031;
                    n2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                    if (n3 != 0) break block67;
                    if (n2 > 0) break block68;
                    double d14 = Math.abs(d12 + d5) - 0.031;
                    n2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
                    if (n3 != 0) break block67;
                    if (n2 <= 0) break block69;
                }
                n2 = 1;
                break block67;
            }
            n2 = 0;
        }
        return n2 != 0;
    }

    synchronized void \u0567(String string, boolean bl) {
        this.\u0521 = string;
        this.\u0549 = bl;
    }

    synchronized void \u03d8(String string) {
        this.\u0562 = true;
        this.\u0567(string, true);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    synchronized boolean \u0256(EntityPlayerSP entityPlayerSP, WorldClient worldClient, oc70db705765 oc70db7057652, String string) {
        block145: {
            int n;
            int n2;
            block143: {
                oc4034802c1a oc4034802c1a2;
                block144: {
                    double d;
                    double d2;
                    block142: {
                        float f;
                        float f2;
                        int n3;
                        block141: {
                            EntityPlayerSP entityPlayerSP2;
                            block139: {
                                block140: {
                                    EntityPlayerSP entityPlayerSP3;
                                    block137: {
                                        block138: {
                                            EntityPlayerSP entityPlayerSP4;
                                            int n4;
                                            block136: {
                                                EntityPlayerSP entityPlayerSP5;
                                                block134: {
                                                    block135: {
                                                        oc70db705765 oc70db7057653;
                                                        block133: {
                                                            this.\u0194 = false;
                                                            n2 = oc84f20a0bc5.\u0117;
                                                            oc70db7057653 = oc70db7057652;
                                                            if (n2 != 0) break block133;
                                                            if (oc70db7057653 == null) return 0 != 0;
                                                            oc70db7057653 = oc70db7057652;
                                                        }
                                                        n4 = oc70db7057653.\u04a7();
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                        if (entityPlayerSP == null) return 0 != 0;
                                                        if (worldClient == null) return 0 != 0;
                                                        n4 = this.\u0106;
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 == 0) return 0 != 0;
                                                        n4 = this.\u016f;
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                        n4 = this.\u0207;
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                        n4 = entityPlayerSP.isSneaking();
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                        n4 = entityPlayerSP.getServerSneakState();
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                        entityPlayerSP5 = entityPlayerSP;
                                                        if (n2 != 0) break block134;
                                                        if (entityPlayerSP5.movementInput == null) break block135;
                                                        n4 = entityPlayerSP.movementInput.sneak;
                                                        if (n2 != 0) return n4 != 0;
                                                        if (n4 != 0) return 0 != 0;
                                                    }
                                                    entityPlayerSP5 = entityPlayerSP;
                                                }
                                                n4 = entityPlayerSP5.onGround;
                                                if (n2 != 0) return n4 != 0;
                                                if (n4 != 0) return 0 != 0;
                                                n4 = entityPlayerSP.hurtTime;
                                                if (n2 != 0) return n4 != 0;
                                                if (n4 > 0) return 0 != 0;
                                                n4 = entityPlayerSP.isRiding() ? 1 : 0;
                                                if (n2 != 0) return n4 != 0;
                                                if (n4 != 0) return 0 != 0;
                                                n4 = entityPlayerSP.isInWater() ? 1 : 0;
                                                if (n2 != 0) return n4 != 0;
                                                if (n4 != 0) return 0 != 0;
                                                n4 = entityPlayerSP.isInLava() ? 1 : 0;
                                                if (n2 != 0) return n4 != 0;
                                                if (n4 != 0) return 0 != 0;
                                                entityPlayerSP4 = entityPlayerSP;
                                                if (n2 != 0) break block136;
                                                if (entityPlayerSP4.capabilities == null) return 0 != 0;
                                                entityPlayerSP4 = entityPlayerSP;
                                            }
                                            n4 = entityPlayerSP4.capabilities.isFlying ? 1 : 0;
                                            if (n2 != 0) return n4 != 0;
                                            if (n4 != 0) return 0 != 0;
                                            entityPlayerSP3 = entityPlayerSP;
                                            if (n2 != 0) break block137;
                                            if (!entityPlayerSP3.noClip) break block138;
                                            return 0 != 0;
                                        }
                                        entityPlayerSP3 = entityPlayerSP;
                                    }
                                    boolean bl = Double.isFinite(entityPlayerSP3.posX);
                                    if (n2 != 0) return bl;
                                    if (!bl) return false;
                                    bl = Double.isFinite(entityPlayerSP.posY);
                                    if (n2 != 0) return bl;
                                    if (!bl) return false;
                                    entityPlayerSP2 = entityPlayerSP;
                                    if (n2 != 0) break block139;
                                    if (Double.isFinite(entityPlayerSP2.posZ)) break block140;
                                    return false;
                                }
                                entityPlayerSP2 = entityPlayerSP;
                            }
                            d2 = Math.hypot(entityPlayerSP2.posX - this.\u00fc, entityPlayerSP.posZ - this.\u02b0);
                            d = entityPlayerSP.posY - this.\u0526;
                            n3 = Double.isFinite(d2);
                            if (n2 != 0) return n3 != 0;
                            if (n3 == 0) return 0 != 0;
                            n3 = Double.isFinite(d);
                            if (n2 != 0) return n3 != 0;
                            if (n3 == 0) return 0 != 0;
                            double d3 = d2 - 0.031;
                            n3 = d3 == 0.0 ? 0 : (d3 > 0.0 ? 1 : -1);
                            if (n2 != 0) return n3 != 0;
                            if (n3 > 0) return 0 != 0;
                            double d4 = Math.abs(d) - 0.031;
                            n3 = d4 == 0.0 ? 0 : (d4 > 0.0 ? 1 : -1);
                            if (n2 != 0) return n3 != 0;
                            if (n3 > 0) return 0 != 0;
                            n3 = Double.isFinite(oc70db7057652.\u016b()) ? 1 : 0;
                            if (n2 != 0) return n3 != 0;
                            if (n3 == 0) return 0 != 0;
                            double d5 = oc70db7057652.\u016b() - 0.0;
                            n3 = d5 == 0.0 ? 0 : (d5 < 0.0 ? -1 : 1);
                            if (n2 != 0) return n3 != 0;
                            if (n3 < 0) return 0 != 0;
                            double d6 = oc70db7057652.\u016b() - 0.3;
                            n3 = d6 == 0.0 ? 0 : (d6 > 0.0 ? 1 : -1);
                            if (n2 != 0) return n3 != 0;
                            if (n3 > 0) return 0 != 0;
                            n3 = Float.isFinite(oc70db7057652.\u0509()) ? 1 : 0;
                            if (n2 != 0) return n3 != 0;
                            if (n3 == 0) return 0 != 0;
                            n3 = Float.isFinite(oc70db7057652.\u01f6()) ? 1 : 0;
                            if (n2 != 0) return n3 != 0;
                            if (n3 == 0) return 0 != 0;
                            float f_r2 = oc70db7057652.\u0509();
                            f_r2 = 0.0f;
                            if (n2 != 0) break block141;
                            if (f2 != f_r2) break block142;
                            float f_r = oc70db7057652.\u01f6();
                            f_r = 0.0f;
                        }
                        float f3 = f2 - f;
                        n3 = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                        if (n2 != 0) return n3 != 0;
                        if (n3 != 0) break block142;
                        return 0 != 0;
                    }
                    oc4034802c1a2 = oc41ddc58b4a.\u03c9(entityPlayerSP.motionX, entityPlayerSP.motionY, entityPlayerSP.motionZ, entityPlayerSP.jumpMovementFactor, d2, d, (0xFF566110 ^ 0xFF566113) - this.\u0166);
                    if (oc4034802c1a2 == null) {
                        return false;
                    }
                    AxisAlignedBB axisAlignedBB = entityPlayerSP.getEntityBoundingBox();
                    AxisAlignedBB axisAlignedBB2 = new AxisAlignedBB(axisAlignedBB.minX, axisAlignedBB.minY + oc4034802c1a2.\u01df, axisAlignedBB.minZ, axisAlignedBB.maxX, axisAlignedBB.maxY + oc4034802c1a2.\u0418, axisAlignedBB.maxZ).expand(oc4034802c1a2.\u0440, 0.001, oc4034802c1a2.\u0440);
                    n = worldClient.getCollidingBoundingBoxes(entityPlayerSP, axisAlignedBB2).isEmpty();
                    if (n2 != 0) break block143;
                    if (n != 0) break block144;
                    return false;
                }
                n = oc4034802c1a2.\u00cb;
            }
            if (n2 != 0) return n != 0;
            if (n <= 0) break block145;
            ++this.\u0166;
            this.\u0194 = true;
            oc70db7057652.\u010f(0.0f);
            oc70db7057652.\u0524(0.0f);
            this.\u0567(string + "/prepare", false);
            return false;
        }
        oc70db7057652.\u0413(true);
        this.\u0562 = true;
        this.\u0567(string, true);
        return 1 != 0;
    }

    static ocb4881cd49b \u0450(double d, double d2, double d3, float f) {
        return oc41ddc58b4a.\u01fb(d, d2, d3, f, 0.0, 0.0);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static ocb4881cd49b \u01fb(double d, double d2, double d3, float f, double d4, double d5) {
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        block60: {
            int n;
            block58: {
                double d11;
                block59: {
                    double d12;
                    double d13;
                    double d14;
                    double d15;
                    block57: {
                        double d16;
                        block55: {
                            block56: {
                                block54: {
                                    int n2;
                                    block53: {
                                        block52: {
                                            block51: {
                                                double d17;
                                                block50: {
                                                    block49: {
                                                        n = oc84f20a0bc5.\u0117;
                                                        d17 = d;
                                                        if (n != 0) break block49;
                                                        if (!Double.isFinite(d17)) return null;
                                                        d17 = d2;
                                                    }
                                                    if (n != 0) break block50;
                                                    if (!Double.isFinite(d17)) return null;
                                                    d17 = d3;
                                                }
                                                n2 = Double.isFinite(d17);
                                                if (n != 0) break block51;
                                                if (n2 == 0) return null;
                                                n2 = Float.isFinite(f);
                                            }
                                            if (n != 0) break block52;
                                            if (n2 == 0) return null;
                                            double d18 = d2 - 0.0;
                                            n2 = d18 == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1);
                                        }
                                        if (n != 0) break block53;
                                        if (n2 > 0) return null;
                                        float f2 = f - 0.0f;
                                        n2 = f2 == 0.0f ? 0 : (f2 < 0.0f ? -1 : 1);
                                    }
                                    if (n2 < 0) {
                                        return null;
                                    }
                                    d15 = Math.hypot(d, d3);
                                    d14 = Math.max(0.026, (double)f);
                                    d13 = d14 * 0.3 * 0.98 * Math.sqrt(2.0);
                                    d10 = d15 + d13;
                                    d9 = d10 * (double)0.91f + d14;
                                    d16 = d10 + d4;
                                    if (n != 0) break block54;
                                    if (d16 > 0.268) return null;
                                    d16 = d9;
                                }
                                if (n != 0) break block55;
                                if (!(d16 > 0.268)) break block56;
                                return null;
                            }
                            d12 = d2;
                            if (n != 0) break block57;
                            d16 = Math.abs(d12);
                        }
                        d12 = d16 < 0.005 ? 0.0 : d2;
                    }
                    d8 = d12;
                    d7 = (d8 - 0.08) * (double)0.98f;
                    double d19 = Math.max(0.0, d15 - d13);
                    d11 = Math.max(0.0, d19 * (double)0.91f - d14);
                    d6 = d19 - d4;
                    if (n != 0) break block58;
                    if (!(d6 <= 0.031)) break block59;
                    d6 = d8 + d5;
                    if (n != 0) break block58;
                    if (Math.abs(d6) <= 0.031) return null;
                }
                d6 = d11;
            }
            if (n != 0) break block60;
            if (!(d6 <= 0.031)) return new ocb4881cd49b(d10 + d4, d9, d8 + d7);
            d6 = Math.abs(d7);
        }
        if (!(d6 <= 0.031)) return new ocb4881cd49b(d10 + d4, d9, d8 + d7);
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static oc4034802c1a \u03c9(double d, double d2, double d3, float f, double d4, double d5, int n) {
        double d6;
        int n2;
        block55: {
            block54: {
                block53: {
                    block52: {
                        float f2;
                        block51: {
                            float f3;
                            block50: {
                                boolean bl;
                                block49: {
                                    double d7;
                                    block48: {
                                        block47: {
                                            n2 = oc84f20a0bc5.\u0117;
                                            d7 = d;
                                            if (n2 != 0) break block47;
                                            if (!Double.isFinite(d7)) return null;
                                            d7 = d2;
                                        }
                                        if (n2 != 0) break block48;
                                        if (!Double.isFinite(d7)) return null;
                                        d7 = d3;
                                    }
                                    bl = Double.isFinite(d7);
                                    if (n2 != 0) break block49;
                                    if (!bl) return null;
                                    f3 = f;
                                    if (n2 != 0) break block50;
                                    bl = Float.isFinite(f3);
                                }
                                if (!bl) return null;
                                f3 = f;
                            }
                            float f4 = f3 - 0.0f;
                            f2 = f4 == 0.0f ? 0 : (f4 < 0.0f ? -1 : 1);
                            if (n2 != 0) break block51;
                            if (f2 < 0) return null;
                            d6 = d2;
                            if (n2 != 0) break block52;
                            double d8 = d6 - 0.17;
                            f2 = d8 == 0.0 ? 0 : (d8 > 0.0 ? 1 : -1);
                        }
                        if (f2 > 0) return null;
                        d6 = d4;
                        if (n2 != 0) break block53;
                    }
                    if (!Double.isFinite(d6)) return null;
                    d6 = d4;
                }
                if (n2 != 0) break block54;
                if (d6 < 0.0) return null;
                d6 = d5;
                if (n2 != 0) break block55;
            }
            if (!Double.isFinite(d6)) {
                return null;
            }
            d6 = d;
        }
        double d9 = d6;
        double d10 = d3;
        double d11 = d2;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        double d15 = 0.0;
        for (int i = 0; i <= Math.min(0xE143C09E ^ 0xE143C09D, n); ++i) {
            double d16;
            block58: {
                double d17;
                double d18;
                block56: {
                    block57: {
                        double d19 = d9;
                        double d20 = d11;
                        double d21 = d10;
                        float f5 = f;
                        double d22 = i == 0 ? d4 : 0.0;
                        double d23 = i == 0 ? d5 : 0.0;
                        ocb4881cd49b ocb4881cd49b2 = oc41ddc58b4a.\u01fb(d19, d20, d21, f5, d22, d23);
                        if (ocb4881cd49b2 != null) {
                            return new oc4034802c1a(i, Math.min(d13, d12 + ocb4881cd49b2.\u03e7), d14, d15 + ocb4881cd49b2.\u01fc);
                        }
                        d18 = Math.hypot(d9, d10);
                        d17 = 0.268;
                        if (n2 != 0) break block56;
                        if (!(d18 <= d17 - Math.max(0.026, (double)f))) break block57;
                        return null;
                    }
                    d15 += Math.hypot(d9, d10);
                    d16 = d11;
                    if (n2 != 0) break block58;
                    d18 = Math.abs(d16);
                    d17 = 0.005;
                }
                d16 = d18 < d17 ? 0.0 : d11;
            }
            d11 = d16;
            d13 = Math.min(d13, d12 += d11);
            d14 = Math.max(d14, d12);
            d9 *= (double)0.91f;
            d10 *= (double)0.91f;
            d11 = (d11 - 0.08) * (double)0.98f;
            if (n2 == 0) continue;
        }
        return null;
    }

    synchronized oc683264f07d \u0213(Packet<?> packet, String string) {
        boolean bl;
        oc683264f07d oc683264f07d2;
        block84: {
            block82: {
                double d;
                int n;
                block83: {
                    block81: {
                        Packet<?> packet2;
                        block79: {
                            block80: {
                                block77: {
                                    block78: {
                                        block65: {
                                            block66: {
                                                block69: {
                                                    Object object;
                                                    C0BPacketEntityAction.Action action;
                                                    block76: {
                                                        String string2;
                                                        block73: {
                                                            oc41ddc58b4a oc41ddc58b4a2;
                                                            block74: {
                                                                block75: {
                                                                    block72: {
                                                                        block70: {
                                                                            oc41ddc58b4a oc41ddc58b4a3;
                                                                            block71: {
                                                                                C0BPacketEntityAction.Action action2;
                                                                                block67: {
                                                                                    block68: {
                                                                                        block61: {
                                                                                            block62: {
                                                                                                block64: {
                                                                                                    int n2;
                                                                                                    int n3;
                                                                                                    block63: {
                                                                                                        n = oc84f20a0bc5.\u0117;
                                                                                                        packet2 = packet;
                                                                                                        if (n != 0) break block61;
                                                                                                        if (!(packet2 instanceof C08PacketPlayerBlockPlacement)) break block62;
                                                                                                        n3 = ((C08PacketPlayerBlockPlacement)packet).getPlacedBlockDirection();
                                                                                                        n2 = n3;
                                                                                                        if (n != 0) break block63;
                                                                                                        if (n2 < 0) break block64;
                                                                                                        n2 = n3;
                                                                                                    }
                                                                                                    if (n2 < (0x576BB751 ^ 0x576BB757)) {
                                                                                                        this.\u0133 = EnumFacing.getFront(n3).name();
                                                                                                    }
                                                                                                }
                                                                                                return null;
                                                                                            }
                                                                                            packet2 = packet;
                                                                                        }
                                                                                        if (n != 0) break block65;
                                                                                        if (!(packet2 instanceof C0BPacketEntityAction)) break block66;
                                                                                        action = ((C0BPacketEntityAction)packet).getAction();
                                                                                        action2 = action;
                                                                                        if (n != 0) break block67;
                                                                                        if (action2 == C0BPacketEntityAction.Action.START_SNEAKING) break block68;
                                                                                        action2 = action;
                                                                                        if (n != 0) break block67;
                                                                                        if (action2 != C0BPacketEntityAction.Action.STOP_SNEAKING) break block69;
                                                                                    }
                                                                                    action2 = action;
                                                                                }
                                                                                String string3 = action2 == C0BPacketEntityAction.Action.START_SNEAKING ? "START" : "STOP";
                                                                                string2 = string3;
                                                                                oc41ddc58b4a oc41ddc58b4a4 = this;
                                                                                boolean bl2 = action == C0BPacketEntityAction.Action.START_SNEAKING;
                                                                                oc41ddc58b4a4.\u0207 = bl2;
                                                                                oc41ddc58b4a3 = this;
                                                                                if (n != 0) break block70;
                                                                                if (oc41ddc58b4a3.\u0207) break block71;
                                                                                this.\u0562 = false;
                                                                            }
                                                                            oc41ddc58b4a3 = this;
                                                                        }
                                                                        oc41ddc58b4a2 = this;
                                                                        if (n != 0) break block72;
                                                                        if (!oc41ddc58b4a2.\u016f) break block73;
                                                                        oc41ddc58b4a2 = this;
                                                                    }
                                                                    if (n != 0) break block74;
                                                                    if (oc41ddc58b4a2.\u01a1.length() >= (0x576BB707 ^ 0x576BB757)) break block75;
                                                                    object = this.\u01a1 + "+" + string2;
                                                                    break block76;
                                                                }
                                                                oc41ddc58b4a2 = this;
                                                            }
                                                            object = oc41ddc58b4a2.\u01a1;
                                                            break block76;
                                                        }
                                                        object = string2;
                                                    }
                                                    oc41ddc58b4a3.\u01a1 = object;
                                                    oc41ddc58b4a oc41ddc58b4a5 = this;
                                                    oc41ddc58b4a oc41ddc58b4a6 = oc41ddc58b4a5;
                                                    boolean bl3 = oc41ddc58b4a5.\u00ce;
                                                    boolean bl4 = action == C0BPacketEntityAction.Action.START_SNEAKING;
                                                    boolean bl5 = bl4 != this.\u0549;
                                                    oc41ddc58b4a6.\u00ce = bl3 | bl5;
                                                    String string4 = this.\u00ce ? "packet/input mismatch; " : "";
                                                    String string5 = string4;
                                                    this.\u0277 = string5 + this.\u0521 + "; lastC08Face=" + this.\u0133 + "; " + string;
                                                    this.\u016f = true;
                                                }
                                                return null;
                                            }
                                            packet2 = packet;
                                        }
                                        if (n != 0) break block77;
                                        if (packet2 instanceof C03PacketPlayer) break block78;
                                        return null;
                                    }
                                    packet2 = packet;
                                }
                                if (n != 0) break block79;
                                if (((C03PacketPlayer)packet2).isMoving()) break block80;
                                return null;
                            }
                            packet2 = packet;
                        }
                        C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)packet2;
                        double d2 = this.\u0106 ? Math.hypot(c03PacketPlayer.getPositionX() - this.\u00fc, c03PacketPlayer.getPositionZ() - this.\u02b0) : Double.NaN;
                        double d3 = d2;
                        oc683264f07d oc683264f07d3 = this.\u016f ? new oc683264f07d(this.\u01a1, this.\u0277, d3) : null;
                        oc683264f07d2 = oc683264f07d3;
                        this.\u00fc = c03PacketPlayer.getPositionX();
                        oc41ddc58b4a oc41ddc58b4a7 = this;
                        d = c03PacketPlayer.getPositionY();
                        if (n != 0) break block81;
                        oc41ddc58b4a7.\u0526 = d;
                        this.\u02b0 = c03PacketPlayer.getPositionZ();
                        oc41ddc58b4a7 = this;
                        if (!Double.isFinite(this.\u00fc)) break block82;
                        d = this.\u0526;
                    }
                    if (n != 0) break block83;
                    if (!Double.isFinite(d)) break block82;
                    d = this.\u02b0;
                }
                bl = Double.isFinite(d);
                if (n != 0) break block84;
                if (!bl) break block82;
                bl = true;
                break block84;
            }
            bl = false;
        }
        oc41ddc58b4a7.\u0106 = bl;
        this.\u016f = false;
        this.\u00ce = false;
        this.\u01a1 = "";
        this.\u0277 = "";
        return oc683264f07d2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void \u049b(Packet<?> packet, String string) {
        oc683264f07d oc683264f07d2;
        block9: {
            double d;
            block8: {
                oc683264f07d2 = this.\u0213(packet, string);
                int n = oc84f20a0bc5.\u0117;
                oc683264f07d oc683264f07d3 = oc683264f07d2;
                if (n == 0) {
                    if (oc683264f07d3 == null) return;
                    oc683264f07d3 = oc683264f07d2;
                }
                d = oc683264f07d3.\u04b4;
                if (n != 0) break block8;
                if (!Double.isFinite(d)) break block9;
                d = oc683264f07d2.\u04b4;
            }
            if (!(d > 0.268)) return;
        }
        Object[] objectArray = new Object[0xCEE9BBFE ^ 0xCEE9BBFD];
        objectArray[0] = oc683264f07d2.\u01a7;
        objectArray[1] = oc683264f07d2.\u04b4;
        objectArray[0xCEE9BBFF ^ 0xCEE9BBFD] = oc683264f07d2.\u017e;
        oc7ab2161b9f.\u00f4.warn("[ScaffoldSneak] actions={} deltaXZ={} context={}", objectArray);
    }
}

