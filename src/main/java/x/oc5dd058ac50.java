/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import x.oc2f61de30bc;
import x.oc5e6785e9df;
import x.oc66fa4f2195;
import x.oc75d51ec7eb;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.ocebec3dfd67;

public class oc5dd058ac50 {
    private static boolean \u01c7;
    private static boolean \u0216;
    private static boolean \u03fc;
    private static boolean \u04e7;
    private static boolean \u03e5;
    private static boolean \u041d;
    private static boolean \u053a;
    private static boolean \u00c6;
    private static boolean \u0414;
    private static boolean \u02b2;
    public static boolean \u0152;

    public static boolean \u0238(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        boolean bl6;
        block30: {
            block39: {
                block31: {
                    int n;
                    block38: {
                        block36: {
                            block37: {
                                block34: {
                                    block35: {
                                        block32: {
                                            block33: {
                                                block28: {
                                                    block29: {
                                                        n = oc75d51ec7eb.\u03e9;
                                                        bl6 = \u041d;
                                                        if (n != 0) break block28;
                                                        if (!bl6) break block29;
                                                        bl6 = bl;
                                                        if (n != 0) break block30;
                                                        if (bl6) break block31;
                                                    }
                                                    bl6 = \u053a;
                                                }
                                                if (n != 0) break block32;
                                                if (!bl6) break block33;
                                                bl6 = bl2;
                                                if (n != 0) break block30;
                                                if (bl6) break block31;
                                            }
                                            bl6 = \u00c6;
                                        }
                                        if (n != 0) break block34;
                                        if (!bl6) break block35;
                                        bl6 = bl3;
                                        if (n != 0) break block30;
                                        if (bl6) break block31;
                                    }
                                    bl6 = \u0414;
                                }
                                if (n != 0) break block36;
                                if (!bl6) break block37;
                                bl6 = bl4;
                                if (n != 0) break block30;
                                if (bl6) break block31;
                            }
                            bl6 = \u02b2;
                        }
                        if (n != 0) break block38;
                        if (!bl6) break block39;
                        bl6 = bl5;
                    }
                    if (n != 0) break block30;
                    if (!bl6) break block39;
                }
                bl6 = true;
                break block30;
            }
            bl6 = false;
        }
        return bl6;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u00d0(oc9d4393f3ce oc9d4393f3ce2) {
        oc5dd058ac50.\u0413(oc9d4393f3ce2.\u025f());
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u00c5(oc5e6785e9df oc5e6785e9df2) {
        oc5dd058ac50.\u0413(oc5e6785e9df2.\u011f());
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0225(oc2f61de30bc oc2f61de30bc2) {
        \u041d = \u01c7;
        \u053a = \u0216;
        \u00c6 = \u03fc;
        \u0414 = \u04e7;
        \u02b2 = \u03e5;
    }

    @oc66fa4f2195(priority=oc8ce2882092.LOWEST)
    public void \u01ae(ocebec3dfd67 ocebec3dfd672) {
        oc5dd058ac50.\u0102();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void \u0413(Packet<?> packet) {
        block25: {
            boolean bl;
            block34: {
                block35: {
                    Packet<?> packet2;
                    block36: {
                        Packet<?> packet3;
                        int n;
                        block32: {
                            block33: {
                                block30: {
                                    boolean bl2;
                                    block31: {
                                        Packet<?> packet4;
                                        block28: {
                                            block29: {
                                                block26: {
                                                    block27: {
                                                        block23: {
                                                            block24: {
                                                                n = oc75d51ec7eb.\u03e9;
                                                                packet4 = packet;
                                                                if (n != 0) break block23;
                                                                if (!(packet4 instanceof C09PacketHeldItemChange)) break block24;
                                                                \u01c7 = true;
                                                                if (n == 0) break block25;
                                                            }
                                                            packet4 = packet;
                                                        }
                                                        if (n != 0) break block26;
                                                        if (!(packet4 instanceof C0APacketAnimation)) break block27;
                                                        \u03fc = true;
                                                        if (n == 0) break block25;
                                                    }
                                                    packet4 = packet;
                                                }
                                                if (n != 0) break block28;
                                                if (!(packet4 instanceof C02PacketUseEntity)) break block29;
                                                \u0216 = true;
                                                if (n == 0) break block25;
                                            }
                                            packet4 = packet;
                                        }
                                        bl2 = packet4 instanceof C08PacketPlayerBlockPlacement;
                                        if (n != 0) break block30;
                                        if (bl2) break block31;
                                        packet3 = packet;
                                        if (n != 0) break block32;
                                        if (!(packet3 instanceof C07PacketPlayerDigging)) break block33;
                                    }
                                    bl2 = \u04e7 = true;
                                }
                                if (n == 0) break block25;
                            }
                            packet3 = packet;
                        }
                        bl = packet3 instanceof C0EPacketClickWindow;
                        if (n != 0) break block34;
                        if (bl) break block35;
                        bl = packet instanceof C0DPacketCloseWindow;
                        if (n != 0) break block34;
                        if (bl) break block35;
                        packet2 = packet;
                        if (n != 0) break block36;
                        if (!(packet2 instanceof C16PacketClientStatus)) break block25;
                        packet2 = packet;
                    }
                    if (((C16PacketClientStatus)packet2).getStatus() != C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT) break block25;
                }
                bl = true;
            }
            \u03e5 = bl;
        }
    }

    public static void \u0102() {
        \u01c7 = false;
        \u0216 = false;
        \u03fc = false;
        \u04e7 = false;
        \u03e5 = false;
        \u041d = false;
        \u053a = false;
        \u00c6 = false;
        \u0414 = false;
        \u02b2 = false;
    }
}

