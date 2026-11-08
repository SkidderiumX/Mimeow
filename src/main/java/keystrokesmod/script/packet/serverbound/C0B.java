/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import x.oc7ab2161b9f;

public class C0B
extends CPacket {
    public String action;
    public int horsePower;

    public C0B(String string, int n) {
        super(null);
        this.action = string;
        this.horsePower = n;
    }

    public C0B(C0BPacketEntityAction c0BPacketEntityAction) {
        super(c0BPacketEntityAction);
        this.action = c0BPacketEntityAction.getAction().name();
        this.horsePower = c0BPacketEntityAction.getAuxData();
    }

    @Override
    public C0BPacketEntityAction convert() {
        return new C0BPacketEntityAction(Minecraft.getMinecraft().thePlayer, oc7ab2161b9f.\u0120(C0BPacketEntityAction.Action.class, this.action), this.horsePower);
    }
}

