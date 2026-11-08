/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.rewriter;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPacket1_21_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class ParticleRewriter1_21_2
extends ParticleRewriter<ClientboundPacket1_21_2> {
    public ParticleRewriter1_21_2(Protocol<ClientboundPacket1_21_2, ?, ?, ?> protocol) {
        super(protocol);
    }

    @Override
    public void rewriteParticle(UserConnection userConnection, Particle particle) {
        String string = this.protocol.getMappingData().getParticleMappings().identifier(particle.id());
        super.rewriteParticle(userConnection, particle);
        if (string.equals("minecraft:dust_color_transition")) {
            this.argbToVector(particle, 0);
            this.argbToVector(particle, 3);
        } else if (string.equals("minecraft:dust")) {
            this.argbToVector(particle, 0);
        } else if (string.equals("minecraft:trail")) {
            particle.removeArgument(2);
            particle.removeArgument(1);
            particle.removeArgument(0);
        }
    }

    private void argbToVector(Particle particle, int n) {
        int n2 = (Integer)particle.removeArgument(n).getValue();
        float f = (float)(n2 >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(n2 >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(n2 & 0xFF) / 255.0f;
        particle.add(n, Types.FLOAT, Float.valueOf(f));
        particle.add(n + 1, Types.FLOAT, Float.valueOf(f2));
        particle.add(n + 2, Types.FLOAT, Float.valueOf(f3));
    }
}

