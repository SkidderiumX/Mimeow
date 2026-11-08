/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def.base;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.rewriter.RegistryDataRewriter;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;

public class ConfigurationRegistrations {
    public static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerConfigurationStateSwitching(RegistrationContext<CU, SU> registrationContext) {
        registrationContext.serverbound(ServerboundPackets1_20_2.CONFIGURATION_ACKNOWLEDGED, serverboundPacketType -> registrationContext.protocol().registerServerbound((ServerboundPacketType)serverboundPacketType, packetWrapper -> packetWrapper.user().getProtocolInfo().setClientState(State.CONFIGURATION)), PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_20_2.START_CONFIGURATION, clientboundPacketType -> registrationContext.protocol().registerClientbound((ClientboundPacketType)clientboundPacketType, packetWrapper -> {
            packetWrapper.user().getProtocolInfo().setServerState(State.CONFIGURATION);
            Object t = packetWrapper.user().getEntityTracker(registrationContext.protocol().getClass());
            if (t != null) {
                t.clear();
            }
        }), PacketBound.ADDED_AT_MIN);
        registrationContext.serverbound(ServerboundConfigurationPackets1_20_2.FINISH_CONFIGURATION, serverboundPacketType -> registrationContext.protocol().registerServerbound((ServerboundPacketType)serverboundPacketType, packetWrapper -> packetWrapper.user().getProtocolInfo().setClientState(State.PLAY)), PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundConfigurationPackets1_20_2.FINISH_CONFIGURATION, clientboundPacketType -> registrationContext.protocol().registerClientbound((ClientboundPacketType)clientboundPacketType, packetWrapper -> {
            RegistryDataRewriter registryDataRewriter = registrationContext.protocol().getRegistryDataRewriter();
            if (registryDataRewriter != null) {
                registryDataRewriter.sendMissingRegistries(packetWrapper.user());
            }
            packetWrapper.user().getProtocolInfo().setServerState(State.PLAY);
        }), PacketBound.ADDED_AT_MIN);
    }
}

