/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.network.play.server.S14PacketEntity;

public class S14
extends SPacket {
    public int entityId;
    public byte posX;
    public byte posY;
    public byte posZ;
    public byte yaw;
    public byte pitch;
    public boolean onGround;
    public boolean rotating;

    public S14(S14PacketEntity s14PacketEntity) {
        super(s14PacketEntity);
        this.entityId = s14PacketEntity.getEntityId();
        this.posX = s14PacketEntity.func_149062_c();
        this.posY = s14PacketEntity.func_149061_d();
        this.posZ = s14PacketEntity.func_149064_e();
        this.yaw = s14PacketEntity.func_149066_f();
        this.pitch = s14PacketEntity.func_149063_g();
        this.rotating = s14PacketEntity.func_149060_h();
    }

    public S14(int n, byte by, byte by2, byte by3, byte by4, byte by5, boolean bl) {
        super(new S14PacketEntity.S17PacketEntityLookMove(n, by, by2, by3, by4, by5, bl));
        this.entityId = n;
        this.posX = by;
        this.posY = by2;
        this.posZ = by3;
        this.yaw = by4;
        this.pitch = by5;
        this.onGround = bl;
    }

    public S14(int n, byte by, byte by2, byte by3, boolean bl) {
        super(new S14PacketEntity.S15PacketEntityRelMove(n, by, by2, by3, bl));
        this.entityId = n;
        this.posX = by;
        this.posY = by2;
        this.posZ = by3;
        this.onGround = bl;
    }

    public S14(int n, byte by, byte by2, boolean bl) {
        super(new S14PacketEntity.S16PacketEntityLook(n, by, by2, bl));
        this.entityId = n;
        this.yaw = by;
        this.pitch = by2;
        this.onGround = bl;
    }
}

