/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.PacketMappings;
import keystrokesmod.script.packet.clientbound.S23;
import keystrokesmod.script.packet.clientbound.S3A;
import keystrokesmod.script.packet.clientbound.SPacket;
import keystrokesmod.script.packet.serverbound.C01;
import keystrokesmod.script.packet.serverbound.C02;
import keystrokesmod.script.packet.serverbound.C03;
import keystrokesmod.script.packet.serverbound.C07;
import keystrokesmod.script.packet.serverbound.C08;
import keystrokesmod.script.packet.serverbound.C09;
import keystrokesmod.script.packet.serverbound.C0A;
import keystrokesmod.script.packet.serverbound.C0B;
import keystrokesmod.script.packet.serverbound.C0D;
import keystrokesmod.script.packet.serverbound.C0E;
import keystrokesmod.script.packet.serverbound.C0F;
import keystrokesmod.script.packet.serverbound.C10;
import keystrokesmod.script.packet.serverbound.C13;
import keystrokesmod.script.packet.serverbound.C16;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.server.S23PacketBlockChange;
import net.minecraft.network.play.server.S3APacketTabComplete;

public class PacketHandler {
    public static CPacket convertServerBound(Packet packet) {
        CPacket cPacket;
        if (packet == null || packet.getClass().getSimpleName().startsWith("S")) {
            return null;
        }
        Class<? extends CPacket> clazz = PacketMappings.minecraftToScriptC.get(packet.getClass());
        if (clazz != null) {
            if (packet instanceof C03PacketPlayer) {
                cPacket = new C03((C03PacketPlayer)packet, 0, 0, 0, 0, 0, 0);
            } else if (packet instanceof C01PacketChatMessage) {
                cPacket = new C01((C01PacketChatMessage)packet, 0);
            } else if (packet instanceof C09PacketHeldItemChange) {
                cPacket = new C09((C09PacketHeldItemChange)packet, true);
            } else {
                try {
                    cPacket = clazz.getConstructor(packet.getClass()).newInstance(packet);
                }
                catch (Exception exception) {
                    cPacket = new CPacket(packet);
                }
            }
        } else {
            cPacket = new CPacket(packet);
        }
        return cPacket;
    }

    public static SPacket convertClientBound(Packet packet) {
        SPacket sPacket;
        Class<? extends SPacket> clazz = PacketMappings.minecraftToScriptS.get(packet.getClass());
        if (clazz != null) {
            if (packet instanceof S3APacketTabComplete) {
                sPacket = new S3A((S3APacketTabComplete)packet, 0);
            } else if (packet instanceof S23PacketBlockChange) {
                sPacket = new S23((S23PacketBlockChange)packet, 0);
            } else {
                try {
                    sPacket = clazz.getConstructor(packet.getClass()).newInstance(packet);
                }
                catch (Exception exception) {
                    sPacket = new SPacket(packet);
                }
            }
        } else {
            sPacket = new SPacket(packet);
        }
        return sPacket;
    }

    public static Packet convertCPacket(CPacket cPacket) {
        try {
            if (cPacket instanceof C0A) {
                return new C0APacketAnimation();
            }
            if (cPacket instanceof C0B) {
                return ((C0B)cPacket).convert();
            }
            if (cPacket instanceof C0D) {
                return ((C0D)cPacket).convert();
            }
            if (cPacket instanceof C09) {
                return ((C09)cPacket).convert();
            }
            if (cPacket instanceof C0E) {
                return ((C0E)cPacket).convert();
            }
            if (cPacket instanceof C0F) {
                return ((C0F)cPacket).convert();
            }
            if (cPacket instanceof C08) {
                return ((C08)cPacket).convert();
            }
            if (cPacket instanceof C07) {
                return ((C07)cPacket).convert();
            }
            if (cPacket instanceof C01) {
                return ((C01)cPacket).convert();
            }
            if (cPacket instanceof C02) {
                return ((C02)cPacket).convert();
            }
            if (cPacket instanceof C03) {
                return cPacket.packet;
            }
            if (cPacket instanceof C10) {
                return ((C10)cPacket).convert();
            }
            if (cPacket instanceof C13) {
                return ((C13)cPacket).convert();
            }
            if (cPacket instanceof C16) {
                return ((C16)cPacket).convert();
            }
        }
        catch (Exception exception) {
            if (cPacket != null && cPacket.packet != null && !cPacket.name.startsWith("S")) {
                return cPacket.packet;
            }
            return null;
        }
        if (cPacket == null && cPacket.packet == null) {
            return null;
        }
        return cPacket.packet;
    }
}

