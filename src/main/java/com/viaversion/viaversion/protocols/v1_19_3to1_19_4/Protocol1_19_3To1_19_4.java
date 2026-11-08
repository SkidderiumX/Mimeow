/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_19_3to1_19_4;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.protocol.AbstractProtocol;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.api.type.types.misc.ParticleType;
import com.viaversion.viaversion.api.type.types.version.Types1_19_4;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.data.MappingData1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.EntityPacketRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.rewriter.ItemPacketRewriter1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.storage.PlayerVehicleTracker;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Protocol1_19_3To1_19_4
extends AbstractProtocol<ClientboundPackets1_19_3, ClientboundPackets1_19_4, ServerboundPackets1_19_3, ServerboundPackets1_19_4> {
    public static final MappingData1_19_4 MAPPINGS = new MappingData1_19_4();
    private final EntityPacketRewriter1_19_4 entityRewriter = new EntityPacketRewriter1_19_4(this);
    private final ItemPacketRewriter1_19_4 itemRewriter = new ItemPacketRewriter1_19_4(this);
    private final ParticleRewriter<ClientboundPackets1_19_3> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_3>(this);
    private final TagRewriter<ClientboundPackets1_19_3> tagRewriter = new TagRewriter<ClientboundPackets1_19_3>(this);
    private final BlockRewriter<ClientboundPackets1_19_3> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_19_3To1_19_4() {
        super(ClientboundPackets1_19_3.class, ClientboundPackets1_19_4.class, ServerboundPackets1_19_3.class, ServerboundPackets1_19_4.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        CommandRewriter<ClientboundPackets1_19_3> commandRewriter = new CommandRewriter<ClientboundPackets1_19_3>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                if (string.equals("minecraft:time")) {
                    packetWrapper.write(Types.INT, 0);
                } else {
                    super.handleArgument(packetWrapper, string);
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_19_3.COMMANDS, commandRewriter::handle1_19);
        this.registerClientbound(ClientboundPackets1_19_3.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            if (n >= Short.MAX_VALUE) {
                packetWrapper.write(Types.VAR_INT, -1);
            } else {
                packetWrapper.write(Types.VAR_INT, n);
            }
        });
        this.registerClientbound(ClientboundPackets1_19_3.SERVER_DATA, packetWrapper -> {
            JsonElement jsonElement = packetWrapper.read(Types.OPTIONAL_COMPONENT);
            if (jsonElement != null) {
                packetWrapper.write(Types.COMPONENT, jsonElement);
            } else {
                packetWrapper.write(Types.COMPONENT, ComponentUtil.emptyJsonComponent());
            }
            String string = packetWrapper.read(Types.OPTIONAL_STRING);
            byte[] byArray = null;
            if (string != null && string.startsWith("data:image/png;base64,")) {
                byArray = Base64.getDecoder().decode(string.substring("data:image/png;base64,".length()).getBytes(StandardCharsets.UTF_8));
            }
            packetWrapper.write(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE, byArray);
        });
    }

    @Override
    protected void onMappingDataLoaded() {
        EntityTypes1_19_4.initialize(this);
        ParticleType.Fillers.fill1_19(this, Types1_19_4.PARTICLE);
        super.onMappingDataLoaded();
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_19_4.PLAYER));
        userConnection.put(new PlayerVehicleTracker());
    }

    @Override
    public MappingData1_19_4 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_19_4 getEntityRewriter() {
        return this.entityRewriter;
    }

    public ItemPacketRewriter1_19_4 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_3> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_3> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_3> getTagRewriter() {
        return this.tagRewriter;
    }
}

