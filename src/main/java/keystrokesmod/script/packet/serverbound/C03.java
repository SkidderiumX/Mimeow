/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.Vec3;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.network.play.client.C03PacketPlayer;

public class C03
extends CPacket {
    public Vec3 position;
    public float yaw;
    public float pitch;
    public boolean ground;
    public boolean moving;
    public boolean rotating;

    public C03(C03PacketPlayer c03PacketPlayer, byte by, byte by2, byte by3, byte by4, byte by5, byte by6) {
        super(c03PacketPlayer);
        if (c03PacketPlayer instanceof C03PacketPlayer.C04PacketPlayerPosition || c03PacketPlayer instanceof C03PacketPlayer.C06PacketPlayerPosLook) {
            this.position = new Vec3(c03PacketPlayer.getPositionX(), c03PacketPlayer.getPositionY(), c03PacketPlayer.getPositionZ());
        }
        if (c03PacketPlayer instanceof C03PacketPlayer.C05PacketPlayerLook || c03PacketPlayer instanceof C03PacketPlayer.C06PacketPlayerPosLook) {
            this.yaw = c03PacketPlayer.getYaw();
            this.pitch = c03PacketPlayer.getPitch();
        }
        this.ground = c03PacketPlayer.isOnGround();
        this.moving = c03PacketPlayer.isMoving();
        this.rotating = c03PacketPlayer.getRotating();
    }

    public C03(boolean bl) {
        super(new C03PacketPlayer(bl));
        this.ground = bl;
    }

    public C03(Vec3 vec3, boolean bl) {
        super(new C03PacketPlayer.C04PacketPlayerPosition(vec3.x, vec3.y, vec3.z, bl));
        this.position = vec3;
        this.ground = bl;
    }

    public C03(float f, float f2, boolean bl) {
        super(new C03PacketPlayer.C05PacketPlayerLook(f, f2, bl));
        this.yaw = f;
        this.pitch = f2;
        this.ground = bl;
    }

    public C03(Vec3 vec3, float f, float f2, boolean bl) {
        super(new C03PacketPlayer.C06PacketPlayerPosLook(vec3.x, vec3.y, vec3.z, f, f2, bl));
        this.position = vec3;
        this.yaw = f;
        this.pitch = f2;
        this.ground = bl;
    }
}

