/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S2FPacketSetSlot;

public class S2F
extends SPacket {
    public int windowId;
    public int slot;
    public ItemStack itemStack;

    public S2F(S2FPacketSetSlot s2FPacketSetSlot) {
        super(s2FPacketSetSlot);
        this.windowId = s2FPacketSetSlot.func_149175_c();
        this.slot = s2FPacketSetSlot.func_149173_d();
        this.itemStack = ItemStack.convert(s2FPacketSetSlot.func_149174_e());
    }

    public S2F(int n, int n2, ItemStack itemStack) {
        super(new S2FPacketSetSlot(n, n2, itemStack.itemStack));
        this.windowId = n;
        this.slot = n2;
        this.itemStack = itemStack;
    }
}

