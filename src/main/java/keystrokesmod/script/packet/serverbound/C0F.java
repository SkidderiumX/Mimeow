/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C0FPacketConfirmTransaction;

public class C0F
extends CPacket {
    public int windowId;
    public short uid;

    public C0F(int n, short s) {
        super(null);
        this.windowId = n;
        this.uid = s;
    }

    public C0F(C0FPacketConfirmTransaction c0FPacketConfirmTransaction) {
        super(c0FPacketConfirmTransaction);
        this.windowId = c0FPacketConfirmTransaction.getWindowId();
        this.uid = c0FPacketConfirmTransaction.getUid();
    }

    @Override
    public C0FPacketConfirmTransaction convert() {
        return new C0FPacketConfirmTransaction(this.windowId, this.uid, true);
    }
}

