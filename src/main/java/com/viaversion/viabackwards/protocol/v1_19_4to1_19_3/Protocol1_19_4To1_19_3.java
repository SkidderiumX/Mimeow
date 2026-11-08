/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter.BlockItemPacketRewriter1_19_4;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter.ComponentRewriter1_19_4;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter.EntityPacketRewriter1_19_4;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage.EntityTracker1_19_4;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.chunk.ChunkType1_18;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ServerboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.Protocol1_19_3To1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ServerboundPackets1_19_4;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.CommandRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import java.util.Base64;

public class Protocol1_19_4To1_19_3
extends BackwardsProtocol<ClientboundPackets1_19_4, ClientboundPackets1_19_3, ServerboundPackets1_19_4, ServerboundPackets1_19_3> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.19.4", "1.19.3", Protocol1_19_3To1_19_4.class);
    private final EntityPacketRewriter1_19_4 entityRewriter = new EntityPacketRewriter1_19_4(this);
    private final BlockItemPacketRewriter1_19_4 itemRewriter = new BlockItemPacketRewriter1_19_4(this);
    private final ParticleRewriter<ClientboundPackets1_19_4> particleRewriter = new ParticleRewriter<ClientboundPackets1_19_4>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_19_4> translatableRewriter = new ComponentRewriter1_19_4(this);
    private final TagRewriter<ClientboundPackets1_19_4> tagRewriter = new TagRewriter<ClientboundPackets1_19_4>(this);
    private final BlockRewriter<ClientboundPackets1_19_4> blockRewriter = BlockRewriter.for1_18(this, ChunkType1_18::new);

    public Protocol1_19_4To1_19_3() {
        super(ClientboundPackets1_19_4.class, ClientboundPackets1_19_3.class, ServerboundPackets1_19_4.class, ServerboundPackets1_19_3.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        CommandRewriter<ClientboundPackets1_19_4> commandRewriter = new CommandRewriter<ClientboundPackets1_19_4>((Protocol)this){

            @Override
            public void handleArgument(PacketWrapper packetWrapper, String string) {
                switch (string) {
                    case "minecraft:heightmap": {
                        packetWrapper.write(Types.VAR_INT, 0);
                        break;
                    }
                    case "minecraft:time": {
                        packetWrapper.read(Types.INT);
                        break;
                    }
                    case "minecraft:resource": 
                    case "minecraft:resource_or_tag": {
                        String string2 = packetWrapper.read(Types.STRING);
                        packetWrapper.write(Types.STRING, string2.equals("minecraft:damage_type") ? "minecraft:mob_effect" : string2);
                        break;
                    }
                    default: {
                        super.handleArgument(packetWrapper, string);
                    }
                }
            }
        };
        this.replaceClientbound(ClientboundPackets1_19_4.COMMANDS, commandRewriter::handle1_19);
        this.tagRewriter.removeTags("minecraft:damage_type");
        this.replaceClientbound(ClientboundPackets1_19_4.SERVER_DATA, packetWrapper -> {
            JsonElement jsonElement = packetWrapper.read(Types.COMPONENT);
            this.translatableRewriter.processText(packetWrapper.user(), jsonElement);
            packetWrapper.write(Types.OPTIONAL_COMPONENT, jsonElement);
            byte[] byArray = packetWrapper.read(Types.OPTIONAL_BYTE_ARRAY_PRIMITIVE);
            String string = byArray != null ? "data:image/png;base64," + Base64.getEncoder().encodeToString(byArray) : null;
            packetWrapper.write(Types.OPTIONAL_STRING, string);
        });
        this.cancelClientbound(ClientboundPackets1_19_4.BUNDLE_DELIMITER);
        this.cancelClientbound(ClientboundPackets1_19_4.CHUNKS_BIOMES);
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTracker1_19_4(userConnection));
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public BlockItemPacketRewriter1_19_4 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_19_4> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_19_4> getParticleRewriter() {
        return this.particleRewriter;
    }

    public EntityPacketRewriter1_19_4 getEntityRewriter() {
        return this.entityRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_19_4> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_19_4> getTagRewriter() {
        return this.tagRewriter;
    }
}

