/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21_7to1_21_9.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPacket1_21_6;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class ParticleRewriter1_21_9
extends ParticleRewriter<ClientboundPacket1_21_6> {
    public ParticleRewriter1_21_9(Protocol<ClientboundPacket1_21_6, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    public void rewriteParticle(UserConnection userConnection, Particle particle) {
        super.rewriteParticle(userConnection, particle);
        String string = this.protocol.getMappingData().getParticleMappings().mappedIdentifier(particle.id());
        if ("minecraft:dragon_breath".equals(string)) {
            particle.add(Types.FLOAT, Float.valueOf(1.0f));
        } else if ("minecraft:flash".equals(string)) {
            particle.add(Types.INT, -1);
        } else if ("minecraft:effect".equals(string) || "minecraft:instant_effect".equals(string)) {
            particle.add(Types.INT, -1);
            particle.add(Types.FLOAT, Float.valueOf(1.0f));
        }
    }
}

