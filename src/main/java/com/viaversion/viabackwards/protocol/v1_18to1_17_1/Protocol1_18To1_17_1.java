/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_18to1_17_1;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_18to1_17_1.data.BackwardsMappingData1_18;
import com.viaversion.viabackwards.protocol.v1_18to1_17_1.rewriter.BlockItemPacketRewriter1_18;
import com.viaversion.viabackwards.protocol.v1_18to1_17_1.rewriter.EntityPacketRewriter1_18;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_16_4to1_17.packet.ServerboundPackets1_17;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.packet.ClientboundPackets1_18;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class Protocol1_18To1_17_1
extends BackwardsProtocol<ClientboundPackets1_18, ClientboundPackets1_17_1, ServerboundPackets1_17, ServerboundPackets1_17> {
    private static final BackwardsMappingData1_18 MAPPINGS = new BackwardsMappingData1_18();
    private final EntityPacketRewriter1_18 entityRewriter = new EntityPacketRewriter1_18(this);
    private final BlockItemPacketRewriter1_18 itemRewriter = new BlockItemPacketRewriter1_18(this);
    private final ParticleRewriter<ClientboundPackets1_18> particleRewriter = new ParticleRewriter<ClientboundPackets1_18>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_18> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_18>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_18> tagRewriter = new TagRewriter<ClientboundPackets1_18>(this);

    public Protocol1_18To1_17_1() {
        super(ClientboundPackets1_18.class, ClientboundPackets1_17_1.class, ServerboundPackets1_17.class, ServerboundPackets1_17.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.tagRewriter.addEmptyTag(RegistryType.BLOCK, "minecraft:lava_pool_stone_replaceables");
        this.registerServerbound(ServerboundPackets1_17.CLIENT_INFORMATION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.create(Types.BOOLEAN, true);
            }
        });
        this.appendClientbound(ClientboundPackets1_18.SET_OBJECTIVE, this.cutName(0, 16));
        this.registerClientbound(ClientboundPackets1_18.SET_DISPLAY_OBJECTIVE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.BYTE);
                this.map(Types.STRING);
                this.handler(Protocol1_18To1_17_1.this.cutName(0, 16));
            }
        });
        this.appendClientbound(ClientboundPackets1_18.SET_PLAYER_TEAM, this.cutName(0, 16));
        this.registerClientbound(ClientboundPackets1_18.SET_SCORE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.handler(Protocol1_18To1_17_1.this.cutName(0, 40));
                this.handler(Protocol1_18To1_17_1.this.cutName(1, 16));
            }
        });
    }

    private PacketHandler cutName(int n, int n2) {
        return packetWrapper -> {
            String string = packetWrapper.get(Types.STRING, n);
            if (string.length() > n2) {
                packetWrapper.set(Types.STRING, n, string.substring(0, n2));
            }
        };
    }

    @Override
    public void init(UserConnection userConnection) {
        this.addEntityTracker(userConnection, new EntityTrackerBase(userConnection, EntityTypes1_17.PLAYER));
    }

    @Override
    public BackwardsMappingData1_18 getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_18 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_18 getItemRewriter() {
        return this.itemRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_18> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_18> getComponentRewriter() {
        return this.translatableRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_18> getTagRewriter() {
        return this.tagRewriter;
    }
}

