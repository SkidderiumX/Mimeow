/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class ParticleRewriter1_21_2
extends ParticleRewriter<ClientboundPacket1_21> {
    public ParticleRewriter1_21_2(Protocol<ClientboundPacket1_21, ?, ?, ?> protocol) {
        super(protocol);
    }

    private void floatsToARGB(Particle particle, int n) {
        Particle.ParticleData particleData = particle.removeArgument(n);
        Particle.ParticleData particleData2 = particle.removeArgument(n);
        Particle.ParticleData particleData3 = particle.removeArgument(n);
        int n2 = 0xFF000000 | (int)(((Float)particleData.getValue()).floatValue() * 255.0f) << 16 | (int)(((Float)particleData2.getValue()).floatValue() * 255.0f) << 8 | (int)(((Float)particleData3.getValue()).floatValue() * 255.0f);
        particle.add(n, Types.INT, n2);
    }

    @Override
    public void rewriteParticle(UserConnection userConnection, Particle particle) {
        super.rewriteParticle(userConnection, particle);
        String string = this.protocol.getMappingData().getParticleMappings().mappedIdentifier(particle.id());
        if ("minecraft:dust_color_transition".equals(string)) {
            this.floatsToARGB(particle, 0);
            this.floatsToARGB(particle, 1);
        } else if ("minecraft:dust".equals(string)) {
            this.floatsToARGB(particle, 0);
        }
    }
}

