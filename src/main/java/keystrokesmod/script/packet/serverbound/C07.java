/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import x.oc7ab2161b9f;

public class C07
extends CPacket {
    public Vec3 position;
    public String status;
    public String facing;

    public C07(Vec3 vec3, String string, String string2) {
        super(null);
        this.position = vec3;
        this.status = string;
        this.facing = string2;
    }

    public C07(C07PacketPlayerDigging c07PacketPlayerDigging) {
        super(c07PacketPlayerDigging);
        this.position = Vec3.convert(c07PacketPlayerDigging.getPosition());
        this.status = c07PacketPlayerDigging.getStatus().name();
        this.facing = c07PacketPlayerDigging.getFacing().name();
    }

    @Override
    public C07PacketPlayerDigging convert() {
        return new C07PacketPlayerDigging(oc7ab2161b9f.\u0120(C07PacketPlayerDigging.Action.class, this.status), new BlockPos(this.position.x, this.position.y, this.position.z), oc7ab2161b9f.\u0120(EnumFacing.class, this.facing));
    }
}

