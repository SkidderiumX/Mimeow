/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_16to1_15_2;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.data.BackwardsMappingData1_16;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter.BlockItemPacketRewriter1_16;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter.CommandRewriter1_16;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter.EntityPacketRewriter1_16;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.rewriter.TranslatableRewriter1_16;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.PlayerAttributesStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.PlayerSneakStorage;
import com.viaversion.viabackwards.protocol.v1_16to1_15_2.storage.WorldNameTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_16;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.packet.State;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonObject;
import com.viaversion.viaversion.protocols.base.ClientboundLoginPackets;
import com.viaversion.viaversion.protocols.base.ClientboundStatusPackets;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ClientboundPackets1_16;
import com.viaversion.viaversion.protocols.v1_15_2to1_16.packet.ServerboundPackets1_16;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.GsonUtil;
import java.util.UUID;

public class Protocol1_16To1_15_2
extends BackwardsProtocol<ClientboundPackets1_16, ClientboundPackets1_15, ServerboundPackets1_16, ServerboundPackets1_14> {
    public static final BackwardsMappingData1_16 MAPPINGS = new BackwardsMappingData1_16();
    private final EntityPacketRewriter1_16 entityRewriter = new EntityPacketRewriter1_16(this);
    private final BlockItemPacketRewriter1_16 blockItemPackets = new BlockItemPacketRewriter1_16(this);
    private final ParticleRewriter<ClientboundPackets1_16> particleRewriter = new ParticleRewriter<ClientboundPackets1_16>(this);
    private final TranslatableRewriter1_16 translatableRewriter = new TranslatableRewriter1_16(this);
    private final TagRewriter<ClientboundPackets1_16> tagRewriter = new TagRewriter<ClientboundPackets1_16>(this);
    private final BlockRewriter<ClientboundPackets1_16> blockRewriter = BlockRewriter.for1_14(this);

    public Protocol1_16To1_15_2() {
        super(ClientboundPackets1_16.class, ClientboundPackets1_15.class, ServerboundPackets1_16.class, ServerboundPackets1_14.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        new CommandRewriter1_16(this).registerDeclareCommands(ClientboundPackets1_16.COMMANDS);
        this.registerClientbound(State.STATUS, ClientboundStatusPackets.STATUS_RESPONSE, (PacketWrapper packetWrapper) -> {
            String string = packetWrapper.passthrough(Types.STRING);
            JsonObject jsonObject = GsonUtil.getGson().fromJson(string, JsonObject.class);
            JsonElement jsonElement = jsonObject.get("description");
            if (jsonElement == null) {
                return;
            }
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            packetWrapper.set(Types.STRING, 0, jsonObject.toString());
        });
        this.replaceClientbound(ClientboundPackets1_16.CHAT, new PacketHandlers(){

            @Override
            public void register() {
                this.handler(packetWrapper -> Protocol1_16To1_15_2.this.translatableRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT)));
                this.map(Types.BYTE);
                this.read(Types.UUID);
            }
        });
        this.replaceClientbound(ClientboundPackets1_16.OPEN_SCREEN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> Protocol1_16To1_15_2.this.translatableRewriter.processText(packetWrapper.user(), packetWrapper.passthrough(Types.COMPONENT)));
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 20) {
                        packetWrapper.set(Types.VAR_INT, 1, 7);
                    } else if (n > 20) {
                        packetWrapper.set(Types.VAR_INT, 1, --n);
                    }
                });
            }
        });
        this.registerClientbound(State.LOGIN, ClientboundLoginPackets.LOGIN_FINISHED, (PacketWrapper packetWrapper) -> {
            UUID uUID = packetWrapper.read(Types.UUID);
            packetWrapper.write(Types.STRING, uUID.toString());
        });
        this.tagRewriter.register(ClientboundPackets1_16.UPDATE_TAGS, RegistryType.ENTITY);
        this.registerServerbound(ServerboundPackets1_14.PLAYER_COMMAND, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0) {
                packetWrapper.user().get(PlayerSneakStorage.class).setSneaking(true);
            } else if (n == 1) {
                packetWrapper.user().get(PlayerSneakStorage.class).setSneaking(false);
            }
        });
        this.registerServerbound(ServerboundPackets1_14.INTERACT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (n == 0 || n == 2) {
                if (n == 2) {
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                    packetWrapper.passthrough(Types.FLOAT);
                }
                packetWrapper.passthrough(Types.VAR_INT);
            }
            packetWrapper.write(Types.BOOLEAN, packetWrapper.user().get(PlayerSneakStorage.class).isSneaking());
        });
        this.registerServerbound(ServerboundPackets1_14.PLAYER_ABILITIES, packetWrapper -> {
            byte by = packetWrapper.read(Types.BYTE);
            by = (byte)(by & 2);
            packetWrapper.write(Types.BYTE, by);
            packetWrapper.read(Types.FLOAT);
            packetWrapper.read(Types.FLOAT);
        });
        this.cancelServerbound(ServerboundPackets1_14.SET_JIGSAW_BLOCK);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_16.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new PlayerSneakStorage());
        userConnection.put(new WorldNameTracker());
        userConnection.put(new PlayerAttributesStorage());
    }

    @Override
    public TranslatableRewriter1_16 getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public BackwardsMappingData1_16 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_16 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_16 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_16> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_16> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_16> getTagRewriter() {
        return this.tagRewriter;
    }
}

