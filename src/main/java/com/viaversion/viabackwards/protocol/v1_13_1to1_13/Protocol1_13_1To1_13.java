/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13_1to1_13;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter.CommandRewriter1_13_1;
import com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter.EntityPacketRewriter1_13_1;
import com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter.ItemPacketRewriter1_13_1;
import com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter.WorldPacketRewriter1_13_1;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;
import com.viaversion.viaversion.util.ComponentUtil;

public class Protocol1_13_1To1_13
extends BackwardsProtocol<ClientboundPackets1_13, ClientboundPackets1_13, ServerboundPackets1_13, ServerboundPackets1_13> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.13.2", "1.13", Protocol1_13To1_13_1.class);
    private final EntityPacketRewriter1_13_1 entityRewriter = new EntityPacketRewriter1_13_1(this);
    private final ItemPacketRewriter1_13_1 itemRewriter = new ItemPacketRewriter1_13_1(this);
    private final ParticleRewriter<ClientboundPackets1_13> particleRewriter = new ParticleRewriter<ClientboundPackets1_13>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_13> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_13>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_13> tagRewriter = new TagRewriter<ClientboundPackets1_13>(this);

    public Protocol1_13_1To1_13() {
        super(ClientboundPackets1_13.class, ClientboundPackets1_13.class, ServerboundPackets1_13.class, ServerboundPackets1_13.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        WorldPacketRewriter1_13_1.register(this);
        new CommandRewriter1_13_1(this).registerDeclareCommands(ClientboundPackets1_13.COMMANDS);
        this.registerServerbound(ServerboundPackets1_13.COMMAND_SUGGESTION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.STRING, new ValueTransformer<String, String>(Types.STRING){

                    @Override
                    public String transform(PacketWrapper packetWrapper, String string) {
                        return !string.startsWith("/") ? "/" + string : string;
                    }
                });
            }
        });
        this.registerServerbound(ServerboundPackets1_13.EDIT_BOOK, packetWrapper -> {
            Item item = this.itemRewriter.handleItemToServer(packetWrapper.user(), packetWrapper.read(Types.ITEM1_13));
            packetWrapper.write(Types.ITEM1_13, item);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.write(Types.VAR_INT, 0);
        });
        this.registerClientbound(ClientboundPackets1_13.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    JsonElement jsonElement = packetWrapper.passthrough(Types.COMPONENT);
                    Protocol1_13_1To1_13.this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
                    if (ViaBackwards.getConfig().fix1_13FormattedInventoryTitle()) {
                        if (jsonElement.isJsonObject() && jsonElement.getAsJsonObject().size() == 1 && jsonElement.getAsJsonObject().has("translate")) {
                            return;
                        }
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("text", ComponentUtil.jsonToLegacy(jsonElement));
                        packetWrapper.set(Types.COMPONENT, 0, jsonObject);
                    }
                });
            }
        });
        this.registerClientbound(ClientboundPackets1_13.COMMAND_SUGGESTIONS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    packetWrapper.set(Types.VAR_INT, 1, n - 1);
                    int n2 = packetWrapper.get(Types.VAR_INT, 3);
                    for (int i = 0; i < n2; ++i) {
                        packetWrapper.passthrough(Types.STRING);
                        packetWrapper.passthrough(Types.OPTIONAL_COMPONENT);
                    }
                });
            }
        });
        this.replaceClientbound(ClientboundPackets1_13.BOSS_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (n == 0 || n == 3) {
                        Protocol1_13_1To1_13.this.translatableRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT));
                        if (n == 0) {
                            packetWrapper.passthrough(Types.FLOAT);
                            packetWrapper.passthrough(Types.VAR_INT);
                            packetWrapper.passthrough(Types.VAR_INT);
                            short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                            if ((s & 4) != 0) {
                                s = (short)(s | 2);
                            }
                            packetWrapper.write(Types.UNSIGNED_BYTE, s);
                        }
                    }
                });
            }
        });
        this.tagRewriter.register(ClientboundPackets1_13.UPDATE_TAGS, RegistryType.ITEM);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_13.EntityType.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_13_1 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_13_1 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_13> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_13> getComponentRewriter() {
        return this.translatableRewriter;
    }

    public JsonNBTComponentRewriter<ClientboundPackets1_13> translatableRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_13> getTagRewriter() {
        return this.tagRewriter;
    }
}

