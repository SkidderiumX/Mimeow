/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def;

import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ServerboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ServerboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundConfigurationPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.ItemRewriter;
import com.viaversion.viaversion.rewriter.StructuredItemRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemRegistrations {
    ItemRegistrations() {
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_13(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        ItemRegistrations.common1_13(registrationContext, itemRewriter);
        registrationContext.clientbound(ClientboundPackets1_13.SET_EQUIPPED_ITEM, itemRewriter::registerSetEquippedItem);
    }

    private static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void common1_13(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_13.CONTAINER_SET_DATA, itemRewriter::registerContainerSetData);
        registrationContext.clientbound(ClientboundPackets1_13.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot);
        registrationContext.clientbound(ClientboundPackets1_13.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent);
        registrationContext.clientbound(ClientboundPackets1_13.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements);
        registrationContext.clientbound(ClientboundPackets1_13.COOLDOWN, itemRewriter::registerCooldown);
        registrationContext.serverbound(ServerboundPackets1_13.CONTAINER_CLICK, itemRewriter::registerContainerClick);
        registrationContext.serverbound(ServerboundPackets1_13.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_14(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        ItemRegistrations.common1_13(registrationContext, itemRewriter);
        registrationContext.clientbound(ClientboundPackets1_14.SET_EQUIPPED_ITEM, itemRewriter::registerSetEquippedItem);
        registrationContext.clientbound(ClientboundPackets1_14.OPEN_SCREEN, itemRewriter::registerOpenScreen);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_14_4(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        ItemRegistrations.common1_13(registrationContext, itemRewriter);
        registrationContext.clientbound(ClientboundPackets1_14_4.SET_EQUIPPED_ITEM, itemRewriter::registerSetEquippedItem, PacketBound.REMOVED_AT_MAX);
        registrationContext.clientbound(ClientboundPackets1_14_4.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_14_4.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_14_4);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_16(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        ItemRegistrations.common1_13(registrationContext, itemRewriter);
        registrationContext.clientbound(ClientboundPackets1_16.SET_EQUIPMENT, itemRewriter::registerSetEquipment, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_16.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_16.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_14_4);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_17_1(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_17_1.CONTAINER_SET_DATA, itemRewriter::registerContainerSetData);
        registrationContext.clientbound(ClientboundPackets1_17_1.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot1_17_1);
        registrationContext.clientbound(ClientboundPackets1_17_1.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent1_17_1);
        registrationContext.clientbound(ClientboundPackets1_17_1.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements);
        registrationContext.clientbound(ClientboundPackets1_17_1.COOLDOWN, itemRewriter::registerCooldown);
        registrationContext.serverbound(ServerboundPackets1_17.CONTAINER_CLICK, itemRewriter::registerContainerClick1_17_1);
        registrationContext.serverbound(ServerboundPackets1_17.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_EQUIPMENT, itemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_17_1.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_17_1.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_14_4);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_19_1(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_19_1.CONTAINER_SET_DATA, itemRewriter::registerContainerSetData);
        registrationContext.clientbound(ClientboundPackets1_19_1.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot1_17_1);
        registrationContext.clientbound(ClientboundPackets1_19_1.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent1_17_1);
        registrationContext.clientbound(ClientboundPackets1_19_1.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements);
        registrationContext.clientbound(ClientboundPackets1_19_1.COOLDOWN, itemRewriter::registerCooldown);
        registrationContext.serverbound(ServerboundPackets1_19_3.CONTAINER_CLICK, itemRewriter::registerContainerClick1_17_1);
        registrationContext.serverbound(ServerboundPackets1_19_3.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot);
        registrationContext.clientbound(ClientboundPackets1_19_1.SET_EQUIPMENT, itemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_19_1.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_19_1.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_19);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_20_3(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_20_3.CONTAINER_SET_DATA, itemRewriter::registerContainerSetData);
        registrationContext.clientbound(ClientboundPackets1_20_3.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot1_17_1);
        registrationContext.clientbound(ClientboundPackets1_20_3.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent1_17_1);
        registrationContext.clientbound(ClientboundPackets1_20_5.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements1_20_3);
        registrationContext.clientbound(ClientboundPackets1_20_3.COOLDOWN, itemRewriter::registerCooldown);
        registrationContext.serverbound(ServerboundPackets1_20_3.CONTAINER_CLICK, itemRewriter::registerContainerClick1_17_1);
        registrationContext.serverbound(ServerboundPackets1_20_2.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_EQUIPMENT, itemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_19_4.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_20_2.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_19);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_20_5(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_20_3.CONTAINER_SET_DATA, itemRewriter::registerContainerSetData);
        ItemRegistrations.registerItemPackets1_21(registrationContext, itemRewriter);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_21(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot1_17_1);
        registrationContext.clientbound(ClientboundPackets1_21.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent1_17_1);
        registrationContext.clientbound(ClientboundPackets1_21.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements1_20_3);
        registrationContext.clientbound(ClientboundPackets1_21.COOLDOWN, itemRewriter::registerCooldown);
        registrationContext.serverbound(ServerboundPackets1_20_5.CONTAINER_CLICK, itemRewriter::registerContainerClick1_17_1);
        registrationContext.serverbound(ServerboundPackets1_20_5.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot1_20_5);
        registrationContext.clientbound(ClientboundPackets1_21.SET_EQUIPMENT, itemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_21.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_21.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_20_5);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_21_2(RegistrationContext<CU, SU> registrationContext, ItemRewriter<CU, SU, ?> itemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21_2.CONTAINER_SET_SLOT, itemRewriter::registerSetSlot1_21_2);
        registrationContext.clientbound(ClientboundPackets1_21_2.CONTAINER_SET_CONTENT, itemRewriter::registerSetContent1_21_2);
        registrationContext.clientbound(ClientboundPackets1_21_2.UPDATE_ADVANCEMENTS, itemRewriter::registerAdvancements1_20_3);
        registrationContext.clientbound(ClientboundPackets1_21_2.COOLDOWN, itemRewriter::registerCooldown1_21_2);
        registrationContext.serverbound(ServerboundPackets1_21_2.CONTAINER_CLICK, itemRewriter::registerContainerClick1_21_2);
        registrationContext.serverbound(ServerboundPackets1_21_2.SET_CREATIVE_MODE_SLOT, itemRewriter::registerSetCreativeModeSlot1_20_5);
        registrationContext.clientbound(ClientboundPackets1_21_2.SET_EQUIPMENT, itemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_21_2.OPEN_SCREEN, itemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_21_2.MERCHANT_OFFERS, itemRewriter::registerMerchantOffers1_20_5);
        registrationContext.clientbound(ClientboundPackets1_21_2.SET_PLAYER_INVENTORY, itemRewriter::registerSetPlayerInventory, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_21_2.SET_CURSOR_ITEM, itemRewriter::registerSetCursorItem, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_21_5(RegistrationContext<CU, SU> registrationContext, StructuredItemRewriter<CU, SU, ?> structuredItemRewriter) {
        registrationContext.clientbound(ClientboundPackets1_21_5.CONTAINER_SET_SLOT, structuredItemRewriter::registerSetSlot1_21_2);
        registrationContext.clientbound(ClientboundPackets1_21_5.CONTAINER_SET_CONTENT, structuredItemRewriter::registerSetContent1_21_2);
        registrationContext.clientbound(ClientboundPackets1_21_5.UPDATE_ADVANCEMENTS, structuredItemRewriter::registerAdvancements1_20_3);
        registrationContext.clientbound(ClientboundPackets1_21_5.COOLDOWN, structuredItemRewriter::registerCooldown1_21_2);
        registrationContext.serverbound(ServerboundPackets1_21_5.CONTAINER_CLICK, structuredItemRewriter::registerContainerClick1_21_5);
        registrationContext.serverbound(ServerboundPackets1_21_5.SET_CREATIVE_MODE_SLOT, structuredItemRewriter::registerSetCreativeModeSlot1_21_5);
        registrationContext.clientbound(ClientboundPackets1_21_5.SET_EQUIPMENT, structuredItemRewriter::registerSetEquipment);
        registrationContext.clientbound(ClientboundPackets1_21_5.OPEN_SCREEN, structuredItemRewriter::registerOpenScreen);
        registrationContext.clientbound(ClientboundPackets1_21_5.MERCHANT_OFFERS, structuredItemRewriter::registerMerchantOffers1_20_5);
        registrationContext.clientbound(ClientboundPackets1_21_5.SET_PLAYER_INVENTORY, structuredItemRewriter::registerSetPlayerInventory);
        registrationContext.clientbound(ClientboundPackets1_21_5.SET_CURSOR_ITEM, structuredItemRewriter::registerSetCursorItem);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> void registerItemPackets1_21_6(RegistrationContext<CU, SU> registrationContext, StructuredItemRewriter<CU, SU, ?> structuredItemRewriter) {
        ItemRegistrations.registerItemPackets1_21_5(registrationContext, structuredItemRewriter);
        registrationContext.clientbound(ClientboundPackets1_21_6.SHOW_DIALOG, structuredItemRewriter::registerShowDialog, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundConfigurationPackets1_21_6.SHOW_DIALOG, structuredItemRewriter::registerShowDialogDirect, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable ItemRewriter<CU, SU, ?> item(RegistrationContext<CU, SU> registrationContext) {
        return (ItemRewriter)registrationContext.protocol().getItemRewriter();
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable StructuredItemRewriter<CU, SU, ?> structuredItem(RegistrationContext<CU, SU> registrationContext) {
        return (StructuredItemRewriter)registrationContext.protocol().getItemRewriter();
    }
}

