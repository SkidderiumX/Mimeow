/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C09PacketHeldItemChange;

public class C09
extends CPacket {
    public int slot;

    public C09(int n) {
        super(null);
        this.slot = n;
    }

    public C09(C09PacketHeldItemChange c09PacketHeldItemChange, boolean bl) {
        super(c09PacketHeldItemChange);
        this.slot = c09PacketHeldItemChange.getSlotId();
    }

    @Override
    public C09PacketHeldItemChange convert() {
        return new C09PacketHeldItemChange(this.slot);
    }
}

