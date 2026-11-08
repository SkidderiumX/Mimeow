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
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C0EPacketClickWindow;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.network.play.server.S09PacketHeldItemChange;
import net.minecraft.network.play.server.S27PacketExplosion;
import x.oc5e549848f3;
import x.ocd6ae010123;

public class oc0f63871c3b {
    public static Packet<?> \u04fb;
    public static Packet<?> \u03b8;
    public static Packet<?> \u013f;
    public static boolean \u044d;
    public static boolean E;
    public static boolean \u0543;
    public static boolean \u0169;
    public static boolean \u027f;
    public static boolean \u01a7;
    public static boolean \u0552;
    public static boolean \u0526;
    public static boolean \u010d;
    public static boolean \u0196;
    public static boolean \u048a;
    public static int \u0472;
    public static int \u03e6;
    public static int \u00fb;
    public static int \u0178;
    public static boolean M;
    public static boolean \u00dd;
    public static int \u010b;
    public static int \u04c3;
    public static int \u051c;
    public static long \u02af;
    public static boolean O;

    private static Minecraft \u01c7() {
        return Minecraft.getMinecraft();
    }

    private oc0f63871c3b() {
    }

    public static void \u0429(Packet<?> packet) {
        Packet<?> packet2 = \u04fb;
        \u04fb = packet;
        try {
            oc0f63871c3b.\u01c7().getNetHandler().addToSendQueue(packet);
        }
        finally {
            \u04fb = packet2;
        }
    }

    public static void \u057a(Packet<?> packet) {
        ocd6ae010123.\u0115(packet);
    }

    public static void \u01bd(Packet<?> packet) {
        \u03b8 = packet;
        oc0f63871c3b.\u057a(\u03b8);
        \u03b8 = null;
    }

    public static void \u044e(Packet<?> packet) {
        \u013f = packet;
        oc0f63871c3b.\u0429(\u013f);
        \u013f = null;
    }

    public static void p(Packet<?> packet) {
        ocd6ae010123.\u0115(packet);
    }

    public static void \u0525() {
        \u051c = 0;
        \u0178 = -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u0167(Packet<?> packet) {
        Packet<?> packet2;
        int n;
        block67: {
            block68: {
                block71: {
                    block73: {
                        Enum enum_;
                        block74: {
                            Enum enum_2;
                            block72: {
                                block69: {
                                    block70: {
                                        block62: {
                                            block63: {
                                                block66: {
                                                    Enum enum_3;
                                                    block64: {
                                                        block65: {
                                                            n = oc5e549848f3.\u0130;
                                                            packet2 = packet;
                                                            if (n == 0) {
                                                                if (packet2 instanceof C03PacketPlayer) {
                                                                    \u044d = false;
                                                                    E = false;
                                                                    \u0543 = false;
                                                                    \u0169 = false;
                                                                    \u027f = false;
                                                                    \u01a7 = false;
                                                                    \u0552 = false;
                                                                    \u0526 = false;
                                                                    \u010d = false;
                                                                    \u0196 = false;
                                                                    \u048a = false;
                                                                    \u0472 = 0;
                                                                    if (n == 0) return;
                                                                }
                                                                packet2 = packet;
                                                            }
                                                            if (n == 0) {
                                                                if (packet2 instanceof C0APacketAnimation) {
                                                                    \u048a = true;
                                                                    if (n == 0) return;
                                                                }
                                                                packet2 = packet;
                                                            }
                                                            if (n != 0) break block62;
                                                            if (!(packet2 instanceof C02PacketUseEntity)) break block63;
                                                            \u010d = true;
                                                            enum_3 = enum_2 = ((C02PacketUseEntity)packet).getAction();
                                                            if (n != 0) break block64;
                                                            if (enum_3 != C02PacketUseEntity.Action.ATTACK) break block65;
                                                            \u0196 = true;
                                                            if (n == 0) break block66;
                                                        }
                                                        enum_3 = enum_2;
                                                    }
                                                    if (enum_3 == C02PacketUseEntity.Action.INTERACT_AT) {
                                                        \u0526 = true;
                                                    }
                                                }
                                                if (n == 0) return;
                                            }
                                            packet2 = packet;
                                        }
                                        if (n == 0) {
                                            if (packet2 instanceof C08PacketPlayerBlockPlacement) {
                                                \u0552 = true;
                                                if (n == 0) {
                                                    if (((C08PacketPlayerBlockPlacement)packet).getPlacedBlockDirection() == (0x795A03A5 ^ 0x795A035A)) {
                                                        \u0178 = 1;
                                                        if (n == 0) return;
                                                    }
                                                    \u01a7 = true;
                                                }
                                                if (n == 0) return;
                                            }
                                            packet2 = packet;
                                        }
                                        if (n != 0) break block67;
                                        if (!(packet2 instanceof C07PacketPlayerDigging)) break block68;
                                        \u027f = true;
                                        enum_ = enum_2 = ((C07PacketPlayerDigging)packet).getStatus();
                                        if (n != 0) break block69;
                                        if (enum_ != C07PacketPlayerDigging.Action.RELEASE_USE_ITEM) break block70;
                                        \u0178 = 0x795A0358 ^ 0x795A035A;
                                        if (n == 0) break block71;
                                    }
                                    enum_ = enum_2;
                                }
                                if (n != 0) break block72;
                                if (enum_ == C07PacketPlayerDigging.Action.START_DESTROY_BLOCK) break block73;
                                enum_ = enum_2;
                            }
                            if (n != 0) break block74;
                            if (enum_ == C07PacketPlayerDigging.Action.STOP_DESTROY_BLOCK) break block73;
                            enum_ = enum_2;
                        }
                        if (enum_ != C07PacketPlayerDigging.Action.ABORT_DESTROY_BLOCK) break block71;
                    }
                    \u0169 = true;
                }
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof C09PacketHeldItemChange) {
                \u00fb = \u03e6;
                \u03e6 = ((C09PacketHeldItemChange)packet).getSlotId();
                \u0178 = 0x795A0359 ^ 0x795A035A;
                ++\u0472;
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof C0DPacketCloseWindow) {
                \u044d = true;
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (packet2 instanceof C0EPacketClickWindow) {
                \u0543 = true;
                if (n == 0) return;
            }
            packet2 = packet;
        }
        if (n == 0) {
            if (!(packet2 instanceof C16PacketClientStatus)) return;
            packet2 = packet;
        }
        if (((C16PacketClientStatus)packet2).getStatus() != C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT) return;
        E = true;
    }

    public static void \u0459(Packet<?> packet) {
        block10: {
            block12: {
                block11: {
                    block9: {
                        if (!(packet instanceof C03PacketPlayer)) break block9;
                        M = false;
                        \u00dd = false;
                        break block10;
                    }
                    if (!(packet instanceof C02PacketUseEntity)) break block11;
                    \u00dd = true;
                    break block10;
                }
                if (!(packet instanceof C08PacketPlayerBlockPlacement)) break block12;
                M = true;
                break block10;
            }
            if (packet instanceof C09PacketHeldItemChange) {
                \u04c3 = \u010b;
                \u010b = ((C09PacketHeldItemChange)packet).getSlotId();
                ++\u051c;
            }
        }
    }

    public static void \u03f5(Packet<?> packet) {
        block15: {
            Packet<?> packet2;
            block16: {
                int n;
                block13: {
                    block14: {
                        n = oc5e549848f3.\u0130;
                        packet2 = packet;
                        if (n != 0) break block13;
                        if (!(packet2 instanceof S09PacketHeldItemChange)) break block14;
                        \u00fb = \u03e6;
                        \u03e6 = ((S09PacketHeldItemChange)packet).getHeldItemHotbarIndex();
                        if (n == 0) break block15;
                    }
                    packet2 = packet;
                }
                if (n != 0) break block16;
                if (!(packet2 instanceof S27PacketExplosion)) break block15;
                packet2 = packet;
            }
            S27PacketExplosion s27PacketExplosion = (S27PacketExplosion)packet2;
            if (oc0f63871c3b.\u01c7().thePlayer.getDistanceSq(s27PacketExplosion.getX(), s27PacketExplosion.getY(), s27PacketExplosion.getZ()) <= 25.0) {
                \u02af = System.currentTimeMillis();
            }
        }
    }

    public static boolean \u0503() {
        boolean bl;
        block6: {
            block5: {
                int n;
                block4: {
                    n = oc5e549848f3.\u0130;
                    bl = \u010d;
                    if (n != 0) break block4;
                    if (bl) break block5;
                    bl = \u027f;
                }
                if (n != 0) break block6;
                if (bl) break block5;
                bl = true;
                break block6;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0431() {
        boolean bl;
        block9: {
            block7: {
                int n;
                block8: {
                    block6: {
                        n = oc5e549848f3.\u0130;
                        bl = \u010d;
                        if (n != 0) break block6;
                        if (bl) break block7;
                        bl = \u0552;
                    }
                    if (n != 0) break block8;
                    if (bl) break block7;
                    bl = \u027f;
                }
                if (n != 0) break block9;
                if (bl) break block7;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u04cd() {
        boolean bl;
        block9: {
            block7: {
                int n;
                block8: {
                    block6: {
                        n = oc5e549848f3.\u0130;
                        bl = \u010d;
                        if (n != 0) break block6;
                        if (bl) break block7;
                        bl = \u0552;
                    }
                    if (n != 0) break block8;
                    if (bl) break block7;
                    bl = \u0169;
                }
                if (n != 0) break block9;
                if (bl) break block7;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0266() {
        boolean bl;
        block9: {
            block7: {
                int n;
                block8: {
                    block6: {
                        n = oc5e549848f3.\u0130;
                        bl = \u0196;
                        if (n != 0) break block6;
                        if (bl) break block7;
                        bl = \u0552;
                    }
                    if (n != 0) break block8;
                    if (bl) break block7;
                    bl = \u027f;
                }
                if (n != 0) break block9;
                if (bl) break block7;
                bl = true;
                break block9;
            }
            bl = false;
        }
        return bl;
    }

    static {
        \u0178 = -1;
    }
}

