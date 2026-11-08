/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class S12
extends SPacket {
    public int entityId;
    public Vec3 motion;

    public S12(S12PacketEntityVelocity s12PacketEntityVelocity) {
        super(s12PacketEntityVelocity);
        this.entityId = s12PacketEntityVelocity.getEntityID();
        this.motion = new Vec3(s12PacketEntityVelocity.getMotionX(), s12PacketEntityVelocity.getMotionY(), s12PacketEntityVelocity.getMotionZ());
    }

    public S12(int n, Vec3 vec3) {
        super(new S12PacketEntityVelocity(n, vec3.x, vec3.y, vec3.z));
        this.entityId = n;
        this.motion = vec3;
    }
}

