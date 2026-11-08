/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C0APacketAnimation;

public class C0A
extends CPacket {
    public C0A(C0APacketAnimation c0APacketAnimation) {
        super(c0APacketAnimation);
    }

    public C0A() {
        super(new C0APacketAnimation());
    }
}

