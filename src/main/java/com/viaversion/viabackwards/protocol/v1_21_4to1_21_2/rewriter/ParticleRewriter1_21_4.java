/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_4to1_21_2.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class ParticleRewriter1_21_4
extends ParticleRewriter<ClientboundPacket1_21_2> {
    public ParticleRewriter1_21_4(Protocol<ClientboundPacket1_21_2, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    public void rewriteParticle(UserConnection userConnection, Particle particle) {
        super.rewriteParticle(userConnection, particle);
        String string = this.protocol.getMappingData().getParticleMappings().mappedIdentifier(particle.id());
        if (string.equals("minecraft:trail")) {
            particle.removeArgument(4);
        }
    }
}

