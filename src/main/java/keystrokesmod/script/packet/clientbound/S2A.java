/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S2APacketParticles;
import net.minecraft.util.EnumParticleTypes;
import x.oc7ab2161b9f;

public class S2A
extends SPacket {
    public String type;
    public Vec3 position;
    public Vec3 offset;
    public float speed;
    public int count;
    public boolean longDistance;
    public int[] args;

    public S2A(S2APacketParticles s2APacketParticles) {
        super(s2APacketParticles);
        this.type = s2APacketParticles.getParticleType().name();
        this.longDistance = s2APacketParticles.isLongDistance();
        this.position = new Vec3(s2APacketParticles.getXCoordinate(), s2APacketParticles.getYCoordinate(), s2APacketParticles.getZCoordinate());
        this.offset = new Vec3(s2APacketParticles.getXOffset(), s2APacketParticles.getYOffset(), s2APacketParticles.getZOffset());
        this.speed = s2APacketParticles.getParticleSpeed();
        this.count = s2APacketParticles.getParticleCount();
        this.args = s2APacketParticles.getParticleArgs();
    }

    public S2A(String string, boolean bl, Vec3 vec3, Vec3 vec32, float f, int n, int[] nArray) {
        super(new S2APacketParticles(oc7ab2161b9f.\u0120(EnumParticleTypes.class, string), bl, (float)vec3.x, (float)vec3.y, (float)vec3.z, (float)vec32.x, (float)vec32.y, (float)vec32.z, f, n, nArray));
        this.type = string;
        this.longDistance = bl;
        this.position = vec3;
        this.offset = vec32;
        this.speed = f;
        this.count = n;
        this.args = nArray;
    }
}

