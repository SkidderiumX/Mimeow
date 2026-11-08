/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C00PacketKeepAlive;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.server.S00PacketKeepAlive;
import net.minecraft.network.play.server.S01PacketJoinGame;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.network.play.server.S46PacketSetCompressionLevel;

public class ocb67361fd4e {
    public static int \u00f4;

    private ocb67361fd4e() {
    }

    public static boolean \u0505(Packet<?> packet) {
        boolean bl;
        block22: {
            block21: {
                block20: {
                    if (packet instanceof C02PacketUseEntity || packet instanceof C03PacketPlayer) break block20;
                    if (packet instanceof C07PacketPlayerDigging) break block20;
                    if (packet instanceof C08PacketPlayerBlockPlacement) break block20;
                    if (packet instanceof C09PacketHeldItemChange) break block20;
                    if (packet instanceof C0APacketAnimation) break block20;
                    if (packet instanceof C0BPacketEntityAction) break block20;
                    if (packet instanceof C0CPacketInput) break block20;
                    if (packet instanceof C0FPacketConfirmTransaction) break block20;
                    if (!(packet instanceof C13PacketPlayerAbilities)) break block21;
                }
                bl = true;
                break block22;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0424(Packet<?> packet) {
        boolean bl;
        block5: {
            block4: {
                if (!ocb67361fd4e.\u0126(packet) && !ocb67361fd4e.\u0223(packet)) break block4;
                bl = true;
                break block5;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u0126(Packet<?> packet) {
        return packet instanceof C00PacketKeepAlive;
    }

    public static boolean \u0223(Packet<?> packet) {
        boolean bl;
        block14: {
            block13: {
                block12: {
                    if (packet instanceof S00PacketKeepAlive || packet instanceof S01PacketJoinGame) break block12;
                    if (packet instanceof S07PacketRespawn) break block12;
                    if (packet instanceof S08PacketPlayerPosLook) break block12;
                    if (packet instanceof S40PacketDisconnect) break block12;
                    if (!(packet instanceof S46PacketSetCompressionLevel)) break block13;
                }
                bl = true;
                break block14;
            }
            bl = false;
        }
        return bl;
    }

    public static boolean \u022a(Packet<?> packet) {
        boolean bl;
        int n;
        block13: {
            block15: {
                block14: {
                    n = \u00f4;
                    bl = packet instanceof S00PacketKeepAlive;
                    if (n != 0) break block13;
                    if (bl) break block14;
                    bl = packet instanceof S40PacketDisconnect;
                    if (n != 0) break block13;
                    if (bl) break block14;
                    bl = packet instanceof S46PacketSetCompressionLevel;
                    if (n != 0) break block13;
                    if (!bl) break block15;
                }
                bl = true;
                break block13;
            }
            bl = false;
        }
        if (false) {
            \u00f4 = ++n;
        }
        return bl;
    }

    public static boolean \u04ea(Packet<?> packet) {
        boolean bl;
        block8: {
            block7: {
                Packet<?> packet2;
                int n;
                block6: {
                    n = \u00f4;
                    packet2 = packet;
                    if (n != 0) break block6;
                    if (!ocb67361fd4e.\u0223(packet2)) break block7;
                    packet2 = packet;
                }
                bl = packet2 instanceof S08PacketPlayerPosLook;
                if (n != 0) break block8;
                if (bl) break block7;
                bl = true;
                break block8;
            }
            bl = false;
        }
        return bl;
    }
}

