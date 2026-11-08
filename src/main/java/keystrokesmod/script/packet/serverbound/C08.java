/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.ItemStack;
import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;

public class C08
extends CPacket {
    public ItemStack itemStack;
    public Vec3 position;
    public int direction;
    public Vec3 offset;

    public C08(ItemStack itemStack, Vec3 vec3, int n, Vec3 vec32) {
        super(null);
        this.itemStack = itemStack;
        this.position = vec3;
        this.direction = n;
        this.offset = vec32;
    }

    public C08(C08PacketPlayerBlockPlacement c08PacketPlayerBlockPlacement) {
        super(c08PacketPlayerBlockPlacement);
        this.itemStack = ItemStack.convert(c08PacketPlayerBlockPlacement.getStack());
        this.position = Vec3.convert(c08PacketPlayerBlockPlacement.getPosition());
        this.direction = c08PacketPlayerBlockPlacement.getPlacedBlockDirection();
        this.offset = new Vec3(c08PacketPlayerBlockPlacement.getPlacedBlockOffsetX(), c08PacketPlayerBlockPlacement.getPlacedBlockOffsetY(), c08PacketPlayerBlockPlacement.getPlacedBlockOffsetZ());
    }

    @Override
    public C08PacketPlayerBlockPlacement convert() {
        return new C08PacketPlayerBlockPlacement(Vec3.getBlockPos(this.position), this.direction, this.itemStack != null ? this.itemStack.itemStack : null, (float)this.offset.x, (float)this.offset.y, (float)this.offset.z);
    }
}

