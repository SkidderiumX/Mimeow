/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.util.ArrayDeque;
import java.util.Deque;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.network.play.client.C18PacketSpectate;
import net.minecraft.network.play.client.C19PacketResourcePackStatus;
import net.minecraft.network.play.server.S1CPacketEntityMetadata;
import x.oc70b09af715;
import x.oc75d51ec7eb;
import x.oc9d4393f3ce;
import x.ocb67361fd4e;
import x.ocd6ae010123;
import x.oce79181588d;

public class oc278c6c6c7f {
    private static final long \u0169 = 100L;
    private final Deque<oc70b09af715> \u02a0 = new ArrayDeque<oc70b09af715>();
    private boolean \u0133;
    private boolean \u011e;
    private long i;
    private long \u03dd;
    public static int \u0394;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public synchronized void \u0552(long l, boolean bl) {
        block7: {
            long l2;
            block8: {
                block10: {
                    oc278c6c6c7f oc278c6c6c7f2;
                    long l3;
                    block9: {
                        int n = oc75d51ec7eb.\u03e9;
                        l2 = System.currentTimeMillis();
                        if (n != 0) break block7;
                        if (!this.\u0133) break block8;
                        l3 = l2;
                        oc278c6c6c7f2 = this;
                        if (n != 0) break block9;
                        if (l3 > oc278c6c6c7f2.i) break block10;
                        l3 = l2;
                        oc278c6c6c7f2 = this;
                    }
                    if (l3 - oc278c6c6c7f2.\u03dd <= (0xBA35472A54596AC8L ^ 0xBA35472A54596AACL)) break block8;
                }
                this.\u00fa();
            }
            this.\u0133 = true;
            this.\u011e = bl;
            this.i = l2 + l;
            this.\u03dd = l2;
        }
    }

    public synchronized void \u0533(oc9d4393f3ce oc9d4393f3ce2) {
        Packet<?> packet;
        block25: {
            block21: {
                boolean bl;
                block26: {
                    int n;
                    block24: {
                        Packet<?> packet2;
                        block23: {
                            boolean bl2;
                            block22: {
                                block20: {
                                    this.\u043f();
                                    n = oc75d51ec7eb.\u03e9;
                                    packet = oc9d4393f3ce2.\u025f();
                                    bl2 = oc9d4393f3ce2.isCanceled();
                                    if (n != 0) break block20;
                                    if (bl2) break block21;
                                    bl2 = this.\u0133;
                                }
                                if (n != 0) break block22;
                                if (!bl2) break block21;
                                packet2 = packet;
                                if (n != 0) break block23;
                                bl2 = ocb67361fd4e.\u0126(packet2);
                            }
                            if (bl2) break block21;
                            packet2 = packet;
                        }
                        bl = oc278c6c6c7f.\u01fd(packet2);
                        if (n != 0) break block24;
                        if (bl) break block25;
                        bl = this.\u011e;
                    }
                    if (n != 0) break block26;
                    if (!bl) break block21;
                    bl = oc278c6c6c7f.\u01d0(packet);
                }
                if (bl) break block25;
            }
            return;
        }
        this.\u02a0.addLast(new oc70b09af715(packet, true));
        oc9d4393f3ce2.setCanceled(true);
    }

    public synchronized void \u041e(oce79181588d oce79181588d2) {
        oce79181588d oce79181588d3;
        block15: {
            block16: {
                block13: {
                    boolean bl;
                    block14: {
                        oc278c6c6c7f oc278c6c6c7f2;
                        int n;
                        block12: {
                            n = oc75d51ec7eb.\u03e9;
                            oc278c6c6c7f2 = this;
                            if (n != 0) break block12;
                            oc278c6c6c7f2.\u043f();
                            if (oce79181588d2.isCanceled()) break block13;
                            oc278c6c6c7f2 = this;
                        }
                        bl = oc278c6c6c7f2.\u0133;
                        if (n != 0) break block14;
                        if (!bl) break block13;
                        oce79181588d3 = oce79181588d2;
                        if (n != 0) break block15;
                        bl = oce79181588d3.\u04a0() instanceof S1CPacketEntityMetadata;
                    }
                    if (bl) break block16;
                }
                return;
            }
            this.\u02a0.addLast(new oc70b09af715(oce79181588d2.\u04a0(), false));
            oce79181588d3 = oce79181588d2;
        }
        oce79181588d3.setCanceled(true);
    }

    public synchronized void \u0148() {
        this.\u00fa();
    }

    public synchronized void \u0255() {
        this.\u02a0.clear();
        this.\u0133 = false;
        this.\u011e = false;
        this.i = 0L;
        this.\u03dd = 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void \u043f() {
        block9: {
            oc278c6c6c7f oc278c6c6c7f2;
            long l;
            block8: {
                long l2;
                int n = oc75d51ec7eb.\u03e9;
                if (!this.\u0133) {
                    return;
                }
                l = l2 = System.currentTimeMillis();
                oc278c6c6c7f2 = this;
                if (n != 0) break block8;
                if (l > oc278c6c6c7f2.i) break block9;
                l = l2;
                oc278c6c6c7f2 = this;
            }
            if (l - oc278c6c6c7f2.\u03dd <= (0x17BD5009D18A948EL ^ 0x17BD5009D18A94EAL)) return;
        }
        this.\u00fa();
    }

    private void \u00fa() {
        block9: {
            this.\u0133 = false;
            int n = oc75d51ec7eb.\u03e9;
            this.\u011e = false;
            while (!this.\u02a0.isEmpty()) {
                block12: {
                    oc70b09af715 oc70b09af7152;
                    block10: {
                        oc70b09af715 oc70b09af7153;
                        block11: {
                            oc70b09af7153 = this.\u02a0.removeFirst();
                            if (n != 0) break block9;
                            oc70b09af7152 = oc70b09af7153;
                            if (n != 0) break block10;
                            if (!oc70b09af7152.\u03bf) break block11;
                            ocd6ae010123.\u0115(oc70b09af7153.\u054d);
                            if (n == 0) break block12;
                        }
                        oc70b09af7152 = oc70b09af7153;
                    }
                    ocd6ae010123.\u046f(oc70b09af7152.\u054d);
                }
                if (n == 0) continue;
            }
            this.i = 0L;
            this.\u03dd = 0L;
        }
    }

    private static boolean \u01fd(Packet<?> packet) {
        return packet instanceof C0FPacketConfirmTransaction;
    }

    private static boolean \u01d0(Packet<?> packet) {
        boolean bl;
        block62: {
            block64: {
                block63: {
                    int n = oc75d51ec7eb.\u03e9;
                    bl = packet instanceof C02PacketUseEntity;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C03PacketPlayer;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C07PacketPlayerDigging;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C08PacketPlayerBlockPlacement;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C09PacketHeldItemChange;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C0APacketAnimation;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C0BPacketEntityAction;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C0CPacketInput;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C0DPacketCloseWindow;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C0EPacketClickWindow;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C13PacketPlayerAbilities;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C15PacketClientSettings;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C16PacketClientStatus;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C17PacketCustomPayload;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C18PacketSpectate;
                    if (n != 0) break block62;
                    if (bl) break block63;
                    bl = packet instanceof C19PacketResourcePackStatus;
                    if (n != 0) break block62;
                    if (!bl) break block64;
                }
                bl = true;
                break block62;
            }
            bl = false;
        }
        return bl;
    }
}

