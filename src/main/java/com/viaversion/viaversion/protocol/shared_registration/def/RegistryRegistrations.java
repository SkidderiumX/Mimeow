/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocol.shared_registration.def;

import com.viaversion.viaversion.api.data.Mappings;
import com.viaversion.viaversion.api.protocol.packet.ClientboundPacketType;
import com.viaversion.viaversion.api.rewriter.TagRewriter;
import com.viaversion.viaversion.protocol.shared_registration.PacketBound;
import com.viaversion.viaversion.protocol.shared_registration.RegistrationContext;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.CommandRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import com.viaversion.viaversion.rewriter.AttributeRewriter;
import com.viaversion.viaversion.rewriter.RecipeDisplayRewriter;
import com.viaversion.viaversion.rewriter.SoundRewriter;
import com.viaversion.viaversion.rewriter.StatisticsRewriter;

public class RegistryRegistrations {
    RegistryRegistrations() {
    }

    static <CU extends ClientboundPacketType> void registerTags1_17_1(RegistrationContext<CU, ?> registrationContext) {
        TagRewriter tagRewriter = registrationContext.protocol().getTagRewriter();
        if (tagRewriter instanceof com.viaversion.viaversion.rewriter.TagRewriter) {
            com.viaversion.viaversion.rewriter.TagRewriter tagRewriter2 = (com.viaversion.viaversion.rewriter.TagRewriter)tagRewriter;
            registrationContext.clientbound(ClientboundPackets1_17_1.UPDATE_TAGS, tagRewriter2::registerGeneric);
        }
    }

    static <CU extends ClientboundPacketType> void registerTags1_20_2(RegistrationContext<CU, ?> registrationContext) {
        TagRewriter tagRewriter = registrationContext.protocol().getTagRewriter();
        if (tagRewriter instanceof com.viaversion.viaversion.rewriter.TagRewriter) {
            com.viaversion.viaversion.rewriter.TagRewriter tagRewriter2 = (com.viaversion.viaversion.rewriter.TagRewriter)tagRewriter;
            registrationContext.clientbound(ClientboundPackets1_20_2.UPDATE_TAGS, tagRewriter2::registerGeneric);
            registrationContext.clientbound(ClientboundConfigurationPackets1_20_2.UPDATE_TAGS, tagRewriter2::registerGeneric, PacketBound.ADDED_AT_MIN);
        }
    }

    static <CU extends ClientboundPacketType> void registerRegistryData1_21(RegistrationContext<CU, ?> registrationContext) {
        if (registrationContext.protocol().getRegistryDataRewriter() == null) {
            return;
        }
        registrationContext.clientboundHandler(ClientboundConfigurationPackets1_21.REGISTRY_DATA, registrationContext.protocol().getRegistryDataRewriter()::handle);
    }

    static <CU extends ClientboundPacketType> void registerRecipePackets1_21_2(RegistrationContext<CU, ?> registrationContext) {
        RecipeDisplayRewriter<CU> recipeDisplayRewriter = registrationContext.protocol().getRecipeRewriter();
        if (recipeDisplayRewriter == null) {
            return;
        }
        registrationContext.clientbound(ClientboundPackets1_21_2.UPDATE_RECIPES, recipeDisplayRewriter::registerUpdateRecipes);
        registrationContext.clientbound(ClientboundPackets1_21_2.RECIPE_BOOK_ADD, recipeDisplayRewriter::registerRecipeBookAdd, PacketBound.ADDED_AT_MIN);
        registrationContext.clientbound(ClientboundPackets1_21_2.PLACE_GHOST_RECIPE, recipeDisplayRewriter::registerPlaceGhostRecipe);
    }

    static <CU extends ClientboundPacketType> void registerStatistics1_13(RegistrationContext<CU, ?> registrationContext) {
        registrationContext.clientbound(ClientboundPackets1_13.AWARD_STATS, new StatisticsRewriter<CU>(registrationContext.protocol())::register);
    }

    static <CU extends ClientboundPacketType> void registerSounds1_10(RegistrationContext<CU, ?> registrationContext) {
        registrationContext.clientbound(ClientboundPackets1_9_3.SOUND, new SoundRewriter<CU>(registrationContext.protocol())::registerSound);
    }

    static <CU extends ClientboundPacketType> void registerSounds1_14(RegistrationContext<CU, ?> registrationContext) {
        SoundRewriter<CU> soundRewriter = new SoundRewriter<CU>(registrationContext.protocol());
        registrationContext.clientbound(ClientboundPackets1_14.SOUND, soundRewriter::registerSound);
        registrationContext.clientbound(ClientboundPackets1_14.SOUND_ENTITY, soundRewriter::registerSound, PacketBound.ADDED_AT_MIN);
    }

    static <CU extends ClientboundPacketType> void registerSounds1_19_3(RegistrationContext<CU, ?> registrationContext) {
        SoundRewriter<CU> soundRewriter = new SoundRewriter<CU>(registrationContext.protocol());
        registrationContext.clientbound(ClientboundPackets1_19_3.SOUND, soundRewriter::registerSound1_19_3);
        registrationContext.clientbound(ClientboundPackets1_19_3.SOUND_ENTITY, soundRewriter::registerSound1_19_3);
    }

    static <CU extends ClientboundPacketType> void registerCommands1_19(RegistrationContext<CU, ?> registrationContext) {
        if (registrationContext.protocol().getMappingData() != null && !Mappings.isIntIdIdentity(registrationContext.protocol().getMappingData().getArgumentTypeMappings()) || registrationContext.protocol().getRegistryDataRewriter() != null) {
            registrationContext.clientbound(ClientboundPackets1_19_3.COMMANDS, new CommandRewriter1_19_4<CU>(registrationContext.protocol())::registerDeclareCommands1_19);
        }
    }

    static <CU extends ClientboundPacketType> void registerAttributes1_21(RegistrationContext<CU, ?> registrationContext) {
        registrationContext.clientbound(ClientboundPackets1_21.UPDATE_ATTRIBUTES, new AttributeRewriter<CU>(registrationContext.protocol())::register1_21);
    }
}

