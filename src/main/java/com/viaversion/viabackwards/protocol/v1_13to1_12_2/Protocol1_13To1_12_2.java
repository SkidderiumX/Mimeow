/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.BackwardsMappingData1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.PaintingNames1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.provider.BackwardsBlockEntityProvider;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter.BlockItemPacketRewriter1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter.EntityPacketRewriter1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter.PlayerPacketRewriter1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter.SoundPacketRewriter1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.BackwardsBlockStorage;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.NoteBlockStorage;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.PlayerPositionStorage1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.TabCompleteStorage;
import com.viaversion.viabackwards.utils.BackwardsProtocolLogger;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.libs.gson.JsonParser;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.ProtocolLogger;
import org.checkerframework.checker.nullness.qual.Nullable;

public class Protocol1_13To1_12_2
extends BackwardsProtocol<ClientboundPackets1_13, ClientboundPackets1_12_1, ServerboundPackets1_13, ServerboundPackets1_12_1> {
    public static final BackwardsMappingData1_13 MAPPINGS = new BackwardsMappingData1_13();
    public static final ProtocolLogger LOGGER = new BackwardsProtocolLogger(Protocol1_13To1_12_2.class);
    private final EntityPacketRewriter1_13 entityRewriter = new EntityPacketRewriter1_13(this);
    private final BlockItemPacketRewriter1_13 blockItemPackets = new BlockItemPacketRewriter1_13(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_13> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_13>((BackwardsProtocol)this, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject jsonObject, String string) {
            String string2 = this.mappedTranslationKey(string);
            if (string2 != null || (string2 = Protocol1_13To1_12_2.this.getMappingData().getTranslateMappings().get(string)) != null) {
                jsonObject.addProperty("translate", string2);
            }
        }
    };
    private final JsonNBTComponentRewriter<ClientboundPackets1_13> translatableToLegacyRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_13>((BackwardsProtocol)this, ComponentRewriterBase.ReadType.JSON){

        @Override
        protected void handleTranslate(JsonObject jsonObject, String string) {
            String string2 = this.mappedTranslationKey(string);
            if (string2 != null || (string2 = Protocol1_13To1_12_2.this.getMappingData().getTranslateMappings().get(string)) != null) {
                jsonObject.addProperty("translate", Protocol1_12_2To1_13.MAPPINGS.getMojangTranslation().getOrDefault(string2, string2));
            }
        }
    };

    public Protocol1_13To1_12_2() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_12_1.class, ServerboundPackets1_13.class, ServerboundPackets1_12_1.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        PaintingNames1_13.init();
        Via.getManager().getProviders().register(BackwardsBlockEntityProvider.class, new BackwardsBlockEntityProvider());
        this.translatableRewriter.registerLoginDisconnect();
        this.translatableRewriter.registerBossEvent(ClientboundPackets1_13.BOSS_EVENT);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_13.CHAT);
        this.translatableRewriter.registerLegacyOpenWindow(ClientboundPackets1_13.OPEN_SCREEN);
        this.translatableRewriter.registerComponentPacket(ClientboundPackets1_13.DISCONNECT);
        this.translatableRewriter.registerPlayerCombat(ClientboundPackets1_13.PLAYER_COMBAT);
        this.translatableRewriter.registerTitle(ClientboundPackets1_13.SET_TITLES);
        this.translatableRewriter.registerTabList(ClientboundPackets1_13.TAB_LIST);
        new PlayerPacketRewriter1_13(this).register();
        new SoundPacketRewriter1_13(this).register();
        this.cancelClientbound(ClientboundPackets1_13.TAG_QUERY);
        this.cancelClientbound(ClientboundPackets1_13.PLACE_GHOST_RECIPE);
        this.cancelClientbound(ClientboundPackets1_13.RECIPE);
        this.cancelClientbound(ClientboundPackets1_13.UPDATE_RECIPES);
        this.cancelClientbound(ClientboundPackets1_13.UPDATE_TAGS);
        this.replaceClientbound(ClientboundPackets1_13.UPDATE_ADVANCEMENTS, PacketWrapper::cancel);
        this.cancelServerbound(ServerboundPackets1_12_1.PLACE_RECIPE);
        this.cancelServerbound(ServerboundPackets1_12_1.RECIPE_BOOK_UPDATE);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_13.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new BackwardsBlockStorage());
        userConnection.put(new TabCompleteStorage());
        if (ViaBackwards.getConfig().isFix1_13FacePlayer() && !userConnection.has(PlayerPositionStorage1_13.class)) {
            userConnection.put(new PlayerPositionStorage1_13());
        }
        userConnection.put(new NoteBlockStorage());
    }

    @Override
    public BackwardsMappingData1_13 getMappingData() {
        return MAPPINGS;
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    public EntityPacketRewriter1_13 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_13 getItemRewriter() {
        return this.blockItemPackets;
    }

    public JsonNBTComponentRewriter<ClientboundPackets1_13> translatableRewriter() {
        return this.translatableRewriter;
    }

    public String jsonToLegacy(UserConnection userConnection, String string) {
        if (string.isEmpty()) {
            return "";
        }
        try {
            return this.jsonToLegacy(userConnection, JsonParser.parseString(string));
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return "";
        }
    }

    public String jsonToLegacy(UserConnection userConnection, @Nullable JsonElement jsonElement) {
        if (jsonElement == null || jsonElement.isJsonNull()) {
            return "";
        }
        this.translatableToLegacyRewriter.processText(userConnection, jsonElement);
        return ComponentUtil.jsonToLegacy(jsonElement);
    }
}

