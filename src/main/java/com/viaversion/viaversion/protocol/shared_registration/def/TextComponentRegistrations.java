/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def;

import com.viaversion.viaversion.api.minecraft.item.data.ChatType;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.protocol.packet.ServerboundPacketType;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.protocols.v1_18_2to1_19.packet.ClientboundPackets1_19;
import com.viaversion.viaversion.protocols.v1_19to1_19_1.packet.ClientboundPackets1_19_1;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundConfigurationPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ClientboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ClientboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.rewriter.text.JsonNBTComponentRewriter;
import com.viaversion.viaversion.rewriter.text.NBTComponentRewriter;
import org.checkerframework.checker.nullness.qual.Nullable;

public class TextComponentRegistrations {
    TextComponentRegistrations() {
    }

    static <CU extends ClientboundPacketType> void registerComponents1_12_2(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_12_1.CHAT, componentRewriterBase::registerComponentPacket);
        TextComponentRegistrations.registerCombatAndTitle1_12_2(registrationContext, componentRewriterBase);
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_14(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_12_1.CHAT, componentRewriterBase::registerComponentPacket);
        TextComponentRegistrations.registerCombatAndTitle1_12_2(registrationContext, componentRewriterBase);
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_16_2(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_16.CHAT, componentRewriterBase::registerComponentPacket);
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        if (!(componentRewriterBase instanceof JsonNBTComponentRewriter)) {
            return;
        }
        JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
        registrationContext.clientbound(ClientboundPackets1_12_1.PLAYER_COMBAT, jsonNBTComponentRewriter::registerPlayerCombat, PacketBound.REMOVED_AT_MAX);
        registrationContext.clientbound(ClientboundPackets1_12_1.SET_TITLES, jsonNBTComponentRewriter::registerTitle, PacketBound.REMOVED_AT_MAX);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_17(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_16.CHAT, componentRewriterBase::registerComponentPacket, PacketBound.REMOVED_AT_MAX);
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_ACTION_BAR_TEXT, componentRewriterBase::registerComponentPacket, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_TITLE_TEXT, componentRewriterBase::registerComponentPacket, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_SUBTITLE_TEXT, componentRewriterBase::registerComponentPacket, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_17_1.PLAYER_COMBAT_KILL, jsonNBTComponentRewriter::registerPlayerCombatKill, PacketBound.ADDED_AT_MIN);
        }
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_19(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
        TextComponentRegistrations.registerActionBarTitleSubtitle1_17_1(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_17_1.PLAYER_COMBAT_KILL, jsonNBTComponentRewriter::registerPlayerCombatKill);
        }
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        registrationContext.clientbound(ClientboundPackets1_19.SYSTEM_CHAT, componentRewriterBase::registerComponentPacket, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_19.SERVER_DATA, componentRewriterBase::registerComponentPacket, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_20_3(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        TextComponentRegistrations.registerComponentsFrom1_12_2(registrationContext, componentRewriterBase);
        TextComponentRegistrations.registerActionBarTitleSubtitle1_17_1(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_16_2.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        registrationContext.clientbound(ClientboundPackets1_19_1.SYSTEM_CHAT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundConfigurationPackets1_20_3.DISCONNECT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_3.DISGUISED_CHAT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_3.SET_SCORE, componentRewriterBase::registerSetScore1_20_3);
        registrationContext.clientbound(ClientboundPackets1_20_3.PLAYER_COMBAT_KILL, componentRewriterBase::registerPlayerCombatKill1_20);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        registrationContext.clientbound(ClientboundPackets1_19.SERVER_DATA, componentRewriterBase::registerComponentPacket);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_20_3.PLAYER_CHAT, clientboundPacketType -> jsonNBTComponentRewriter.registerPlayerChat(clientboundPacketType, Types.VAR_INT));
            registrationContext.clientbound(ClientboundPackets1_20_3.PLAYER_INFO_UPDATE, jsonNBTComponentRewriter::registerPlayerInfoUpdate1_20_3);
        }
    }

    static <CU extends ClientboundPacketType> void registerCombatAndTitle1_12_2(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        if (!(componentRewriterBase instanceof JsonNBTComponentRewriter)) {
            return;
        }
        JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
        registrationContext.clientbound(ClientboundPackets1_12_1.PLAYER_COMBAT, jsonNBTComponentRewriter::registerPlayerCombat);
        registrationContext.clientbound(ClientboundPackets1_12_1.SET_TITLES, jsonNBTComponentRewriter::registerTitle);
    }

    private static <CU extends ClientboundPacketType> void registerComponentsFrom1_12_2(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_12_1.BOSS_EVENT, componentRewriterBase::registerBossEvent);
        registrationContext.clientbound(ClientboundPackets1_12_1.DISCONNECT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_12_1.TAB_LIST, componentRewriterBase::registerTabList);
        componentRewriterBase.registerLoginDisconnect();
    }

    static <CU extends ClientboundPacketType> void registerActionBarTitleSubtitle1_17_1(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_ACTION_BAR_TEXT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_TITLE_TEXT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_17_1.SET_SUBTITLE_TEXT, componentRewriterBase::registerComponentPacket);
    }

    static <CU extends ClientboundPacketType> void registerComponents1_20_5(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        TextComponentRegistrations.common1_20_5(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        registrationContext.clientbound(ClientboundPackets1_20_5.DISGUISED_CHAT, componentRewriterBase::registerComponentPacket);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_20_5.PLAYER_CHAT, clientboundPacketType -> jsonNBTComponentRewriter.registerPlayerChat(clientboundPacketType, Types.VAR_INT));
            registrationContext.clientbound(ClientboundPackets1_20_5.PLAYER_INFO_UPDATE, jsonNBTComponentRewriter::registerPlayerInfoUpdate1_20_3);
        }
    }

    private static <CU extends ClientboundPacketType> void common1_20_5(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        registrationContext.clientbound(ClientboundConfigurationPackets1_20_5.DISCONNECT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.DISCONNECT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_ACTION_BAR_TEXT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_TITLE_TEXT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_SUBTITLE_TEXT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.BOSS_EVENT, componentRewriterBase::registerBossEvent);
        registrationContext.clientbound(ClientboundPackets1_20_5.TAB_LIST, componentRewriterBase::registerTabList);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_OBJECTIVE, componentRewriterBase::registerSetObjective);
        registrationContext.clientbound(ClientboundPackets1_20_5.SET_SCORE, componentRewriterBase::registerSetScore1_20_3);
        registrationContext.clientbound(ClientboundPackets1_20_5.SYSTEM_CHAT, componentRewriterBase::registerComponentPacket);
        registrationContext.clientbound(ClientboundPackets1_20_5.PLAYER_COMBAT_KILL, componentRewriterBase::registerPlayerCombatKill1_20);
        registrationContext.clientbound(ClientboundPackets1_20_5.SERVER_DATA, componentRewriterBase::registerComponentPacket);
        componentRewriterBase.registerLoginDisconnect();
    }

    static <CU extends ClientboundPacketType> void registerComponents1_21(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        TextComponentRegistrations.common1_20_5(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_21.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        registrationContext.clientbound(ClientboundPackets1_21.DISGUISED_CHAT, componentRewriterBase::registerDisguisedChat);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_21.PLAYER_CHAT, clientboundPacketType -> jsonNBTComponentRewriter.registerPlayerChat(clientboundPacketType, ChatType.TYPE));
            registrationContext.clientbound(ClientboundPackets1_21.PLAYER_INFO_UPDATE, jsonNBTComponentRewriter::registerPlayerInfoUpdate1_20_3);
        }
    }

    static <CU extends ClientboundPacketType> void registerComponents1_21_4(RegistrationContext<CU, ?> registrationContext, ComponentRewriterBase<CU> componentRewriterBase) {
        TextComponentRegistrations.common1_20_5(registrationContext, componentRewriterBase);
        registrationContext.clientbound(ClientboundPackets1_21_2.SET_PLAYER_TEAM, componentRewriterBase::registerSetPlayerTeam1_13);
        registrationContext.clientbound(ClientboundPackets1_21_2.DISGUISED_CHAT, componentRewriterBase::registerDisguisedChat);
        registrationContext.clientbound(ClientboundPackets1_21_2.PLAYER_INFO_UPDATE, componentRewriterBase::registerPlayerInfoUpdate1_21_4);
        if (componentRewriterBase instanceof JsonNBTComponentRewriter) {
            JsonNBTComponentRewriter jsonNBTComponentRewriter = (JsonNBTComponentRewriter)componentRewriterBase;
            registrationContext.clientbound(ClientboundPackets1_21_2.PLAYER_CHAT, clientboundPacketType -> jsonNBTComponentRewriter.registerPlayerChat(clientboundPacketType, ChatType.TYPE));
        }
    }

    static <CU extends ClientboundPacketType> void registerComponents1_21_5(RegistrationContext<CU, ?> registrationContext, NBTComponentRewriter<CU> nBTComponentRewriter) {
        TextComponentRegistrations.common1_20_5(registrationContext, nBTComponentRewriter);
        registrationContext.clientbound(ClientboundPackets1_21_5.SET_PLAYER_TEAM, nBTComponentRewriter::registerSetPlayerTeam1_21_5);
        registrationContext.clientbound(ClientboundPackets1_21_5.DISGUISED_CHAT, nBTComponentRewriter::registerDisguisedChat);
        registrationContext.clientbound(ClientboundPackets1_21_5.PLAYER_INFO_UPDATE, nBTComponentRewriter::registerPlayerInfoUpdate1_21_4);
        registrationContext.clientbound(ClientboundPackets1_21_5.PLAYER_CHAT, nBTComponentRewriter::registerPlayerChat1_21_5);
    }

    static <CU extends ClientboundPacketType> void registerComponents26_2(RegistrationContext<CU, ?> registrationContext, NBTComponentRewriter<CU> nBTComponentRewriter) {
        TextComponentRegistrations.common1_20_5(registrationContext, nBTComponentRewriter);
        registrationContext.clientbound(ClientboundPackets1_21_5.SET_PLAYER_TEAM, nBTComponentRewriter::registerSetPlayerTeam26_2);
        registrationContext.clientbound(ClientboundPackets1_21_5.DISGUISED_CHAT, nBTComponentRewriter::registerDisguisedChat);
        registrationContext.clientbound(ClientboundPackets1_21_5.PLAYER_INFO_UPDATE, nBTComponentRewriter::registerPlayerInfoUpdate1_21_4);
        registrationContext.clientbound(ClientboundPackets1_21_5.PLAYER_CHAT, nBTComponentRewriter::registerPlayerChat1_21_5);
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable ComponentRewriterBase<CU> text(RegistrationContext<CU, SU> registrationContext) {
        return (ComponentRewriterBase)registrationContext.protocol().getComponentRewriter();
    }

    static <CU extends ClientboundPacketType, SU extends ServerboundPacketType> @Nullable NBTComponentRewriter<CU> nbtText(RegistrationContext<CU, SU> registrationContext) {
        return (NBTComponentRewriter)registrationContext.protocol().getComponentRewriter();
    }
}

