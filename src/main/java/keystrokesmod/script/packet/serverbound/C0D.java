/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C0DPacketCloseWindow;

public class C0D
extends CPacket {
    public int windowId;

    public C0D(int n) {
        super(null);
        this.windowId = n;
    }

    public C0D(C0DPacketCloseWindow c0DPacketCloseWindow) {
        super(c0DPacketCloseWindow);
    }

    @Override
    public C0DPacketCloseWindow convert() {
        return new C0DPacketCloseWindow(this.windowId);
    }
}

