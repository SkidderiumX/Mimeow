/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import x.oc2f61de30bc;
import x.oc507025139f;
import x.oc66fa4f2195;
import x.oc75d51ec7eb;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.ocadfd5cc157;
import x.occ48acb5d22;
import x.ocda171fe5d8;
import x.oce79181588d;

public class G
implements ocda171fe5d8 {
    public static final G S = new G();
    public static int \u053e = 0xD9962307 ^ 0xD99620EF;
    public static int \u0272 = 0xD9962307 ^ 0xD99620EF;
    public static int \u01cd = 0xD9962307 ^ 0xD99620EF;
    public static int \u01a2;
    public static int \u01de;
    public static boolean \u03b8;
    public static boolean \u03ab;
    public static int \u04a8;

    private G() {
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u03bd(oce79181588d oce79181588d2) {
        block16: {
            int n;
            block17: {
                S12PacketEntityVelocity s12PacketEntityVelocity;
                int n2;
                block14: {
                    S12PacketEntityVelocity s12PacketEntityVelocity2;
                    block15: {
                        s12PacketEntityVelocity2 = oce79181588d2.\u04a0();
                        n2 = oc75d51ec7eb.\u03e9;
                        s12PacketEntityVelocity = s12PacketEntityVelocity2;
                        if (n2 != 0) break block14;
                        if (!(s12PacketEntityVelocity instanceof S12PacketEntityVelocity)) break block15;
                        if (ocda171fe5d8.\u01d4.thePlayer == null) break block15;
                        s12PacketEntityVelocity = s12PacketEntityVelocity2;
                        if (n2 != 0) break block14;
                        if (s12PacketEntityVelocity.getEntityID() != ocda171fe5d8.\u01d4.thePlayer.getEntityId()) break block15;
                        \u053e = 0;
                        if (n2 == 0) break block16;
                    }
                    s12PacketEntityVelocity = s12PacketEntityVelocity2;
                }
                n = s12PacketEntityVelocity instanceof S08PacketPlayerPosLook;
                if (n2 != 0) break block17;
                if (n == 0) break block16;
                n = 0;
            }
            \u0272 = n;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u03e9(oc9d4393f3ce oc9d4393f3ce2) {
        block23: {
            boolean bl;
            block32: {
                Packet<?> packet;
                int n;
                block30: {
                    Packet<?> packet2;
                    block31: {
                        block28: {
                            boolean bl2;
                            block29: {
                                Packet<?> packet3;
                                block26: {
                                    block27: {
                                        block24: {
                                            boolean bl3;
                                            block25: {
                                                Packet<?> packet4;
                                                block21: {
                                                    block22: {
                                                        packet2 = oc9d4393f3ce2.\u025f();
                                                        n = oc75d51ec7eb.\u03e9;
                                                        packet4 = packet2;
                                                        if (n != 0) break block21;
                                                        if (!(packet4 instanceof C02PacketUseEntity)) break block22;
                                                        packet4 = packet2;
                                                        if (n != 0) break block21;
                                                        if (((C02PacketUseEntity)packet4).getAction() != C02PacketUseEntity.Action.ATTACK) break block22;
                                                        \u01cd = 0;
                                                        if (n == 0) break block23;
                                                    }
                                                    packet4 = packet2;
                                                }
                                                bl3 = packet4 instanceof C08PacketPlayerBlockPlacement;
                                                if (n != 0) break block24;
                                                if (bl3) break block25;
                                                packet3 = packet2;
                                                if (n != 0) break block26;
                                                if (!(packet3 instanceof C07PacketPlayerDigging)) break block27;
                                            }
                                            bl3 = \u03b8 = true;
                                        }
                                        if (n == 0) break block23;
                                    }
                                    packet3 = packet2;
                                }
                                bl2 = packet3 instanceof C0EPacketClickWindow;
                                if (n != 0) break block28;
                                if (bl2) break block29;
                                packet = packet2;
                                if (n != 0) break block30;
                                if (!(packet instanceof C16PacketClientStatus)) break block31;
                                packet = packet2;
                                if (n != 0) break block30;
                                if (((C16PacketClientStatus)packet).getStatus() != C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT) break block31;
                            }
                            bl2 = \u03ab = true;
                        }
                        if (n == 0) break block23;
                    }
                    packet = packet2;
                }
                bl = packet instanceof C03PacketPlayer;
                if (n != 0) break block32;
                if (!bl) break block23;
                \u03b8 = false;
                bl = false;
            }
            \u03ab = bl;
        }
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u00f9(occ48acb5d22 occ48acb5d222) {
        \u01cd = 0;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u049a(oc507025139f oc507025139f2) {
        \u01cd = 0;
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u027a(oc2f61de30bc oc2f61de30bc2) {
        block14: {
            int n;
            block12: {
                block13: {
                    Minecraft minecraft;
                    int n2;
                    block10: {
                        block11: {
                            n2 = oc75d51ec7eb.\u03e9;
                            minecraft = ocda171fe5d8.\u01d4;
                            if (n2 != 0) break block10;
                            if (minecraft.thePlayer != null) break block11;
                            return;
                        }
                        ++\u053e;
                        n = \u0272 + 1;
                        if (n2 != 0) break block12;
                        \u0272 = n;
                        ++\u01cd;
                        minecraft = ocda171fe5d8.\u01d4;
                    }
                    if (!minecraft.thePlayer.onGround) break block13;
                    ++\u01de;
                    \u01a2 = 0;
                    if (n2 == 0) break block14;
                }
                ++\u01a2;
                n = 0;
            }
            \u01de = n;
        }
    }

    @oc66fa4f2195
    public void \u016f(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == ocda171fe5d8.\u01d4.thePlayer) {
            G.\u040e();
        }
    }

    public static boolean \u0574() {
        boolean bl;
        block6: {
            block8: {
                block7: {
                    int n = oc75d51ec7eb.\u03e9;
                    bl = \u03b8;
                    if (n != 0) break block6;
                    if (bl) break block7;
                    bl = \u03ab;
                    if (n != 0) break block6;
                    if (!bl) break block8;
                }
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public static void \u040e() {
        \u053e = 0xC4949C4D ^ 0xC4949FA5;
        \u0272 = 0xC4949C4D ^ 0xC4949FA5;
        \u01cd = 0xC4949C4D ^ 0xC4949FA5;
        \u01a2 = 0;
        \u01de = 0;
        \u03b8 = false;
        \u03ab = false;
    }
}

