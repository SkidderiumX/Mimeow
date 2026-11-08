/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ParticleRegistrations {
    ParticleRegistrations() {
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_13(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_13.LEVEL_PARTICLES, clientboundPacketType -> particleRewriter.registerLevelParticles1_13(clientboundPacketType, Types.FLOAT));
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_15_2(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_15.LEVEL_PARTICLES, clientboundPacketType -> particleRewriter.registerLevelParticles1_13(clientboundPacketType, Types.DOUBLE));
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_19(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_19.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_19);
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_20(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_19.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_19);
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_20_5(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_20_5.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_20_5);
        registrationContext.clientbound(ClientboundPackets1_20_5.EXPLODE, particleRewriter::registerExplode1_20_5);
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_21_2(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21_2.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_20_5);
        registrationContext.clientbound(ClientboundPackets1_21_2.EXPLODE, particleRewriter::registerExplode1_21_2);
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_21_4(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21_2.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_21_4);
        registrationContext.clientbound(ClientboundPackets1_21_2.EXPLODE, particleRewriter::registerExplode1_21_2);
    }

    static <CU extends ClientboundPacketType> void registerParticlePackets1_21_9(RegistrationContext<CU, ?> registrationContext, ParticleRewriter<CU> particleRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21_9.LEVEL_PARTICLES, particleRewriter::registerLevelParticles1_21_4);
        registrationContext.clientbound(ClientboundPackets1_21_9.EXPLODE, particleRewriter::registerExplode1_21_9);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable ParticleRewriter<CU> particle(RegistrationContext<CU, SU> registrationContext) {
        return (ParticleRewriter)registrationContext.protocol().getParticleRewriter();
    }
}

