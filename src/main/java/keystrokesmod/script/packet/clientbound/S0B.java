/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.packet.clientbound;

import com.mojang.authlib.GameProfile;
import java.util.UUID;
import keystrokesmod.script.packet.clientbound.SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0BPacketAnimation;

public class S0B
extends SPacket {
    public int entityId;
    public int type;

    public S0B(S0BPacketAnimation s0BPacketAnimation) {
        super(s0BPacketAnimation);
        this.entityId = s0BPacketAnimation.getEntityID();
        this.type = s0BPacketAnimation.getAnimationType();
    }

    public S0B(int n, int n2) {
        super(new S0BPacketAnimation(S0B.createEntityWithCustomID(n), n2));
        this.entityId = n;
        this.type = n2;
    }

    private static Entity createEntityWithCustomID(int n) {
        EntityOtherPlayerMP entityOtherPlayerMP = new EntityOtherPlayerMP(Minecraft.getMinecraft().theWorld, new GameProfile(UUID.fromString("ae7a42d0-31b1-4926-ba4c-f28d6efad4a9"), ""));
        entityOtherPlayerMP.setEntityId(n);
        return entityOtherPlayerMP;
    }
}

