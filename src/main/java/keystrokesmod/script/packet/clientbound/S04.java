/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S04PacketEntityEquipment;

public class S04
extends SPacket {
    public int entityId;
    public int slot;
    public ItemStack item;

    public S04(S04PacketEntityEquipment s04PacketEntityEquipment) {
        super(s04PacketEntityEquipment);
        this.entityId = s04PacketEntityEquipment.getEntityID();
        this.slot = s04PacketEntityEquipment.getEquipmentSlot();
        this.item = ItemStack.convert(s04PacketEntityEquipment.getItemStack());
    }

    public S04(int n, int n2, ItemStack itemStack) {
        super(new S04PacketEntityEquipment(n, n2, itemStack.itemStack));
        this.entityId = n;
        this.slot = n2;
        this.item = itemStack;
    }
}

