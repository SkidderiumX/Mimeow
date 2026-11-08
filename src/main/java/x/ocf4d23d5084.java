/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import x.oc113704e9b1;
import x.oc66fa4f2195;
import x.oc75d51ec7eb;
import x.oc8ce2882092;
import x.oc9d4393f3ce;
import x.ocda171fe5d8;
import x.oce79181588d;

public class ocf4d23d5084
implements ocda171fe5d8 {
    public AtomicInteger \u0205 = new AtomicInteger(-1);
    public AtomicInteger \u0103 = new AtomicInteger(-1);
    private final boolean \u0397 = true;
    public static int \u056c;

    @oc66fa4f2195(priority=oc8ce2882092.HIGH)
    public void \u0283(oc9d4393f3ce oc9d4393f3ce2) {
        block17: {
            Packet<?> packet;
            block16: {
                Packet<?> packet2;
                int n;
                block14: {
                    block15: {
                        oc9d4393f3ce oc9d4393f3ce3;
                        block12: {
                            block13: {
                                n = oc75d51ec7eb.\u03e9;
                                oc9d4393f3ce3 = oc9d4393f3ce2;
                                if (n != 0) break block12;
                                if (!oc9d4393f3ce3.isCanceled()) break block13;
                                return;
                            }
                            oc9d4393f3ce3 = oc9d4393f3ce2;
                        }
                        packet2 = oc9d4393f3ce3.\u025f();
                        packet = packet2;
                        if (n != 0) break block14;
                        if (!oc113704e9b1.\u00c5(packet)) break block15;
                        oc9d4393f3ce2.setCanceled(true);
                        return;
                    }
                    packet = packet2;
                }
                if (n != 0) break block16;
                if (!(packet instanceof C09PacketHeldItemChange)) break block17;
                packet = packet2;
            }
            C09PacketHeldItemChange c09PacketHeldItemChange = (C09PacketHeldItemChange)packet;
            int n = c09PacketHeldItemChange.getSlotId();
            this.\u0205.set(n);
            this.\u0103.set(n);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @oc66fa4f2195
    public void \u03a8(oce79181588d oce79181588d2) {
        block27: {
            Packet<INetHandlerPlayClient> packet;
            oce79181588d oce79181588d3;
            block23: {
                block24: {
                    int n;
                    block26: {
                        int n2;
                        int n3;
                        block25: {
                            Packet<?> packet2;
                            block22: {
                                n = oc75d51ec7eb.\u03e9;
                                oce79181588d oce79181588d4 = oce79181588d2;
                                if (n == 0) {
                                    if (oce79181588d4.isCanceled()) {
                                        return;
                                    }
                                    oce79181588d4 = oce79181588d2;
                                }
                                packet2 = oce79181588d4.\u04a0();
                                if (n != 0) break block22;
                                if (oc113704e9b1.\u04bc(packet2)) {
                                    oce79181588d2.setCanceled(true);
                                    return;
                                }
                                oce79181588d3 = oce79181588d2;
                                if (n != 0) break block23;
                                packet2 = oce79181588d3.\u04a0();
                            }
                            if (!(packet2 instanceof S09PacketHeldItemChange)) break block24;
                            packet = (S09PacketHeldItemChange)oce79181588d2.\u04a0();
                            n2 = n3 = ((S09PacketHeldItemChange)packet).getHeldItemHotbarIndex();
                            if (n != 0) break block25;
                            if (n2 < 0) break block26;
                            n2 = n3;
                        }
                        if (n2 < InventoryPlayer.getHotbarSize()) {
                            this.\u0103.set(n3);
                        }
                    }
                    if (n == 0) break block27;
                }
                oce79181588d3 = oce79181588d2;
            }
            if (oce79181588d3.\u04a0() instanceof S0CPacketSpawnPlayer && Minecraft.getMinecraft().thePlayer != null) {
                packet = (S0CPacketSpawnPlayer)oce79181588d2.\u04a0();
                if (((S0CPacketSpawnPlayer)packet).getEntityID() != Minecraft.getMinecraft().thePlayer.getEntityId()) {
                    return;
                }
                this.\u0205.set(-1);
            }
        }
    }
}

