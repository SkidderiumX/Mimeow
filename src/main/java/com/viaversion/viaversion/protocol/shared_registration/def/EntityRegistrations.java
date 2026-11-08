/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityRegistrations {
    EntityRegistrations() {
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_13(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_13.REMOVE_ENTITIES, entityRewriter::registerRemoveEntities);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_14_4(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_14_4.REMOVE_ENTITIES, entityRewriter::registerRemoveEntities);
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_ENTITY, entityRewriter::registerTrackerWithData);
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_MOB, entityRewriter::registerTracker);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_16_2(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_ENTITY, entityRewriter::registerTrackerWithData);
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_MOB, entityRewriter::registerTracker);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_17_1(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_14_4.REMOVE_ENTITIES, entityRewriter::registerRemoveEntities);
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_ENTITY, entityRewriter::registerTrackerWithData);
        registrationContext.clientbound(ClientboundPackets1_14_4.ADD_MOB, entityRewriter::registerTracker, PacketBound.REMOVED_AT_MAX);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_19(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_9.REMOVE_ENTITIES, entityRewriter::registerRemoveEntities);
        registrationContext.clientbound(ClientboundPackets1_19.ADD_ENTITY, entityRewriter::registerTrackerWithData1_19);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_20_5(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        EntityRegistrations.common1_20_5(registrationContext, entityRewriter);
        registrationContext.clientbound(ClientboundPackets1_19.ADD_ENTITY, entityRewriter::registerTrackerWithData1_19);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_21_4(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        EntityRegistrations.common1_20_5(registrationContext, entityRewriter);
        registrationContext.clientbound(ClientboundPackets1_21_2.ADD_ENTITY, entityRewriter::registerTrackerWithData1_19);
    }

    static <CU extends ClientboundPacketType> void registerEntityPackets1_21_9(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        EntityRegistrations.common1_20_5(registrationContext, entityRewriter);
        registrationContext.clientbound(ClientboundPackets1_21_9.ADD_ENTITY, entityRewriter::registerTrackerWithData1_21_9);
    }

    private static <CU extends ClientboundPacketType> void common1_20_5(RegistrationContext<CU, ?> registrationContext, EntityRewriter<CU, ?> entityRewriter) {
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_ENTITY_DATA, entityRewriter::registerSetEntityData);
        registrationContext.clientbound(ClientboundPackets1_20_5.REMOVE_ENTITIES, entityRewriter::registerRemoveEntities);
        registrationContext.clientbound(ClientboundPackets1_20_5.LOGIN, entityRewriter::registerLogin1_20_5);
        registrationContext.clientbound(ClientboundPackets1_20_5.RESPAWN, entityRewriter::registerRespawn1_20_5);
        registrationContext.clientbound(ClientboundPackets1_20_5.GAME_EVENT, entityRewriter::registerGameEvent);
        registrationContext.clientbound(ClientboundPackets1_20_5.PLAYER_ABILITIES, entityRewriter::registerPlayerAbilities);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable EntityRewriter<CU, ?> entity(RegistrationContext<CU, SU> registrationContext) {
        return (EntityRewriter)registrationContext.protocol().getEntityRewriter();
    }
}

