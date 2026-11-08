/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;

public class C10
extends CPacket {
    public int slot;
    public ItemStack itemStack;

    public C10(int n, ItemStack itemStack) {
        super(null);
        this.slot = n;
        this.itemStack = itemStack;
    }

    public C10(C10PacketCreativeInventoryAction c10PacketCreativeInventoryAction) {
        super(c10PacketCreativeInventoryAction);
        this.slot = c10PacketCreativeInventoryAction.getSlotId();
        this.itemStack = ItemStack.convert(c10PacketCreativeInventoryAction.getStack());
    }

    @Override
    public C10PacketCreativeInventoryAction convert() {
        return new C10PacketCreativeInventoryAction(this.slot, this.itemStack.itemStack);
    }
}

