/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.serverbound;

import keystrokesmod.script.model.Entity;
import keystrokesmod.script.packet.serverbound.CPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.Vec3;
import x.oc7ab2161b9f;

public class C02
extends CPacket {
    public Entity entity;
    public String action;
    public keystrokesmod.script.model.Vec3 hitVec;

    public C02(Entity entity, String string, keystrokesmod.script.model.Vec3 vec3) {
        super(null);
        this.entity = entity;
        this.action = string;
        this.hitVec = vec3;
    }

    public C02(C02PacketUseEntity c02PacketUseEntity) {
        super(c02PacketUseEntity);
        this.entity = c02PacketUseEntity.getEntityFromWorld(Minecraft.getMinecraft().theWorld) == null ? null : Entity.convert(c02PacketUseEntity.getEntityFromWorld(Minecraft.getMinecraft().theWorld));
        this.action = c02PacketUseEntity.getAction().name();
        if (c02PacketUseEntity.getHitVec() != null) {
            this.hitVec = new keystrokesmod.script.model.Vec3(c02PacketUseEntity.getHitVec().xCoord, c02PacketUseEntity.getHitVec().yCoord, c02PacketUseEntity.getHitVec().zCoord);
        }
    }

    @Override
    public C02PacketUseEntity convert() {
        C02PacketUseEntity.Action action = oc7ab2161b9f.\u0120(C02PacketUseEntity.Action.class, this.action);
        if (this.hitVec != null && action == C02PacketUseEntity.Action.INTERACT_AT) {
            return new C02PacketUseEntity(this.entity.entity, new Vec3(this.hitVec.x, this.hitVec.y, this.hitVec.z));
        }
        return new C02PacketUseEntity(this.entity.entity, action);
    }
}

