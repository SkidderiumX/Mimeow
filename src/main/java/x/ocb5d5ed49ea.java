/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import x.oc5e6785e9df;
import x.oc66fa4f2195;
import x.oc75d51ec7eb;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.ocadfd5cc157;
import x.ocda171fe5d8;

public class ocb5d5ed49ea
implements ocda171fe5d8 {
    public static boolean \u048b;
    public static boolean \u0183;
    public static boolean \u04fe;
    public static boolean \u0231;
    public static boolean \u02b7;
    public static int \u0236;

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u0189(oc9d4393f3ce oc9d4393f3ce2) {
        ocb5d5ed49ea.\u0533(oc9d4393f3ce2.\u025f());
    }

    @oc66fa4f2195(priority=oc8ce2882092.HIGHEST)
    public void \u019a(oc5e6785e9df oc5e6785e9df2) {
        ocb5d5ed49ea.\u0533(oc5e6785e9df2.\u011f());
    }

    @oc66fa4f2195
    public void \u015c(ocadfd5cc157 ocadfd5cc1572) {
        if (ocadfd5cc1572.\u0426 == ocda171fe5d8.\u01d4.thePlayer) {
            ocb5d5ed49ea.\u017b();
        }
    }

    private static void \u0533(Packet<?> packet) {
        Packet<?> packet2;
        block31: {
            block32: {
                int n;
                block29: {
                    block30: {
                        block27: {
                            block28: {
                                block25: {
                                    block26: {
                                        block23: {
                                            block24: {
                                                n = oc75d51ec7eb.\u03e9;
                                                packet2 = packet;
                                                if (n != 0) break block23;
                                                if (!(packet2 instanceof C02PacketUseEntity)) break block24;
                                                \u048b = true;
                                            }
                                            packet2 = packet;
                                        }
                                        if (n != 0) break block25;
                                        if (!(packet2 instanceof C07PacketPlayerDigging)) break block26;
                                        \u0183 = true;
                                    }
                                    packet2 = packet;
                                }
                                if (n != 0) break block27;
                                if (!(packet2 instanceof C08PacketPlayerBlockPlacement)) break block28;
                                \u04fe = true;
                            }
                            packet2 = packet;
                        }
                        if (n != 0) break block29;
                        if (!(packet2 instanceof C09PacketHeldItemChange)) break block30;
                        \u0231 = true;
                    }
                    packet2 = packet;
                }
                if (n != 0) break block31;
                if (!(packet2 instanceof C0APacketAnimation)) break block32;
                \u02b7 = true;
            }
            packet2 = packet;
        }
        if (packet2 instanceof C03PacketPlayer) {
            ocb5d5ed49ea.\u017b();
        }
    }

    public static void \u017b() {
        \u048b = false;
        \u0183 = false;
        \u04fe = false;
        \u0231 = false;
        \u02b7 = false;
    }
}

