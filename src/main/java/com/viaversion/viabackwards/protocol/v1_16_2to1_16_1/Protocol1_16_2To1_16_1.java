/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16_2to1_16_1;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.rewriter.BlockItemPacketRewriter1_16_2;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.rewriter.CommandRewriter1_16_2;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.rewriter.EntityPacketRewriter1_16_2;
import com.viaversion.viabackwards.protocol.v1_16_2to1_16_1.storage.BiomeStorage;
import com.viaversion.viabackwards.utils.BackwardsProtocolLogger;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16_2;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.Protocol1_16_1To1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ClientboundPackets1_16_2;
import com.viaversion.viaversion.protocols.v1_16_1to1_16_2.packet.ServerboundPackets1_16_2;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ProtocolLogger;

public class Protocol1_16_2To1_16_1
extends BackwardsProtocol<ClientboundPackets1_16_2, ClientboundPackets1_16, ServerboundPackets1_16_2, ServerboundPackets1_16> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.16.2", "1.16", Protocol1_16_1To1_16_2.class);
    public static final ProtocolLogger LOGGER = new BackwardsProtocolLogger(Protocol1_16_2To1_16_1.class);
    private final EntityPacketRewriter1_16_2 entityRewriter = new EntityPacketRewriter1_16_2(this);
    private final BlockItemPacketRewriter1_16_2 blockItemPackets = new BlockItemPacketRewriter1_16_2(this);
    private final BlockRewriter<ClientboundPackets1_16_2> blockRewriter = BlockRewriter.for1_14(this);
    private final ParticleRewriter<ClientboundPackets1_16_2> particleRewriter = new ParticleRewriter<ClientboundPackets1_16_2>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_16_2> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_16_2>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_16_2> tagRewriter = new TagRewriter<ClientboundPackets1_16_2>(this);

    public Protocol1_16_2To1_16_1() {
        super(ClientboundPackets1_16_2.class, ClientboundPackets1_16.class, ServerboundPackets1_16_2.class, ServerboundPackets1_16.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        new CommandRewriter1_16_2(this).registerDeclareCommands(ClientboundPackets1_16_2.COMMANDS);
        this.replaceClientbound(ClientboundPackets1_16_2.CHAT, packetWrapper -> {
            JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by == 2) {
                packetWrapper.clearPacket();
                packetWrapper.setPacketType(ClientboundPackets1_16.SET_TITLES);
                packetWrapper.write(Types.VAR_INT, 2);
                packetWrapper.write(Types.COMPONENT, jsonElement);
            }
        });
        this.registerServerbound(ServerboundPackets1_16.RECIPE_BOOK_UPDATE, ServerboundPackets1_16_2.RECIPE_BOOK_CHANGE_SETTINGS, (PacketWrapper packetWrapper) -> {
            int n = packetWrapper.read(Types.VAR_INT);
            if (n == 0) {
                packetWrapper.passthrough(Types.STRING);
                packetWrapper.setPacketType(ServerboundPackets1_16_2.RECIPE_BOOK_SEEN_RECIPE);
            } else {
                packetWrapper.cancel();
                for (int i = 0; i < 3; ++i) {
                    Protocol1_16_2To1_16_1.sendSeenRecipePacket(i, packetWrapper);
                }
            }
        });
        this.tagRewriter.register(ClientboundPackets1_16_2.UPDATE_TAGS, RegistryType.ENTITY);
    }

    private static void sendSeenRecipePacket(int n, PacketWrapper packetWrapper) {
        boolean bl = packetWrapper.read(Types.BOOLEAN);
        boolean bl2 = packetWrapper.read(Types.BOOLEAN);
        PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_16_2.RECIPE_BOOK_CHANGE_SETTINGS);
        packetWrapper2.write(Types.VAR_INT, n);
        packetWrapper2.write(Types.BOOLEAN, bl);
        packetWrapper2.write(Types.BOOLEAN, bl2);
        packetWrapper2.sendToServer(Protocol1_16_2To1_16_1.class);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.put(new BiomeStorage());
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_16_2.PLAYER));
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_16_2> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    @Override
    public ProtocolLogger getLogger() {
        return LOGGER;
    }

    public EntityPacketRewriter1_16_2 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_16_2 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_16_2> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_16_2> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_16_2> getTagRewriter() {
        return this.tagRewriter;
    }
}

