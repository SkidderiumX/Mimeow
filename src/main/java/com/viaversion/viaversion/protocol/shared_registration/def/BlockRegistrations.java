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
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class BlockRegistrations {
    BlockRegistrations() {
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_13(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_13(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_13.CHUNK_BLOCKS_UPDATE, blockRewriter::registerChunkBlocksUpdate);
    }

    private static <CU extends ClientboundPacketType> void common1_13(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        registrationContext.clientbound(ClientboundPackets1_13.BLOCK_EVENT, blockRewriter::registerBlockEvent);
        registrationContext.clientbound(ClientboundPackets1_13.BLOCK_UPDATE, blockRewriter::registerBlockUpdate);
        registrationContext.clientbound(ClientboundPackets1_13.LEVEL_EVENT, blockRewriter::registerLevelEvent1_13);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_14_4(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_13(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_14_4.CHUNK_BLOCKS_UPDATE, blockRewriter::registerChunkBlocksUpdate, PacketBound.REMOVED_AT_MAX);
        registrationContext.clientbound(ClientboundPackets1_14_4.BLOCK_BREAK_ACK, blockRewriter::registerBlockBreakAck, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_16_2(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_13(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_16_2.BLOCK_BREAK_ACK, blockRewriter::registerBlockBreakAck);
        registrationContext.clientbound(ClientboundPackets1_16_2.SECTION_BLOCKS_UPDATE, blockRewriter::registerSectionBlocksUpdate, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_18(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_13(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_18.BLOCK_BREAK_ACK, blockRewriter::registerBlockBreakAck, PacketBound.REMOVED_AT_MAX);
        registrationContext.clientbound(ClientboundPackets1_18.LEVEL_CHUNK_WITH_LIGHT, blockRewriter::registerLevelChunk1_18, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_18.SECTION_BLOCKS_UPDATE, blockRewriter::registerSectionBlocksUpdate);
        registrationContext.clientbound(ClientboundPackets1_18.BLOCK_ENTITY_DATA, blockRewriter::registerBlockEntityData1_18);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_19(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_19(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_19.LEVEL_EVENT, blockRewriter::registerLevelEvent1_13);
        registrationContext.clientbound(ClientboundPackets1_19.SECTION_BLOCKS_UPDATE, blockRewriter::registerSectionBlocksUpdate);
    }

    private static <CU extends ClientboundPacketType> void common1_19(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        registrationContext.clientbound(ClientboundPackets1_19.BLOCK_EVENT, blockRewriter::registerBlockEvent);
        registrationContext.clientbound(ClientboundPackets1_19.BLOCK_UPDATE, blockRewriter::registerBlockUpdate);
        registrationContext.clientbound(ClientboundPackets1_19.LEVEL_CHUNK_WITH_LIGHT, blockRewriter::registerLevelChunk1_18);
        registrationContext.clientbound(ClientboundPackets1_19.BLOCK_ENTITY_DATA, blockRewriter::registerBlockEntityData1_18);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_20(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_19(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_19_4.LEVEL_EVENT, blockRewriter::registerLevelEvent1_13);
        registrationContext.clientbound(ClientboundPackets1_19_4.SECTION_BLOCKS_UPDATE, blockRewriter::registerSectionBlocksUpdate1_20);
    }

    static <CU extends ClientboundPacketType> void registerBlockPackets1_21(RegistrationContext<CU, ?> registrationContext, BlockRewriter<CU> blockRewriter) {
        BlockRegistrations.common1_19(registrationContext, blockRewriter);
        registrationContext.clientbound(ClientboundPackets1_21.LEVEL_EVENT, blockRewriter::registerLevelEvent1_21);
        registrationContext.clientbound(ClientboundPackets1_21.SECTION_BLOCKS_UPDATE, blockRewriter::registerSectionBlocksUpdate1_20);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable BlockRewriter<CU> block(RegistrationContext<CU, SU> registrationContext) {
        return registrationContext.protocol().getBlockRewriter();
    }
}

