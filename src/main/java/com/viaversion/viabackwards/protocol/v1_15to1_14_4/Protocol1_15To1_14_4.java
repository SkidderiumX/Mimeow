/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_15to1_14_4;

import com.viaversion.viabackwards.api.BackwardsProtocol;
import com.viaversion.viabackwards.api.data.BackwardsMappingData;
import com.viaversion.viabackwards.api.rewriters.text.JsonNBTComponentRewriter;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.rewriter.BlockItemPacketRewriter1_15;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.rewriter.EntityPacketRewriter1_15;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.storage.ImmediateRespawnStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.RegistryType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_15;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_3to1_14_4.packet.ClientboundPackets1_14_4;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.Protocol1_14_4To1_15;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import com.viaversion.viaversion.rewriter.BlockRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.TagRewriter;
import com.viaversion.viaversion.rewriter.text.ComponentRewriterBase;

public class Protocol1_15To1_14_4
extends BackwardsProtocol<ClientboundPackets1_15, ClientboundPackets1_14_4, ServerboundPackets1_14, ServerboundPackets1_14> {
    public static final BackwardsMappingData MAPPINGS = new BackwardsMappingData("1.15", "1.14", Protocol1_14_4To1_15.class);
    private final EntityPacketRewriter1_15 entityRewriter = new EntityPacketRewriter1_15(this);
    private final BlockItemPacketRewriter1_15 blockItemPackets = new BlockItemPacketRewriter1_15(this);
    private final BlockRewriter<ClientboundPackets1_15> blockRewriter = BlockRewriter.for1_14(this);
    private final ParticleRewriter<ClientboundPackets1_15> particleRewriter = new ParticleRewriter<ClientboundPackets1_15>(this);
    private final JsonNBTComponentRewriter<ClientboundPackets1_15> translatableRewriter = new JsonNBTComponentRewriter<ClientboundPackets1_15>(this, ComponentRewriterBase.ReadType.JSON);
    private final TagRewriter<ClientboundPackets1_15> tagRewriter = new TagRewriter<ClientboundPackets1_15>(this);

    public Protocol1_15To1_14_4() {
        super(ClientboundPackets1_15.class, ClientboundPackets1_14_4.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
    }

    @Override
    protected void registerPackets() {
        super.registerPackets();
        this.registerClientbound(ClientboundPackets1_15.EXPLODE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_14_4.SOUND);
                    packetWrapper2.write(Types.VAR_INT, 243);
                    packetWrapper2.write(Types.VAR_INT, 4);
                    packetWrapper2.write(Types.INT, this.toEffectCoordinate(packetWrapper.get(Types.FLOAT, 0).floatValue()));
                    packetWrapper2.write(Types.INT, this.toEffectCoordinate(packetWrapper.get(Types.FLOAT, 1).floatValue()));
                    packetWrapper2.write(Types.INT, this.toEffectCoordinate(packetWrapper.get(Types.FLOAT, 2).floatValue()));
                    packetWrapper2.write(Types.FLOAT, Float.valueOf(4.0f));
                    packetWrapper2.write(Types.FLOAT, Float.valueOf(1.0f));
                    packetWrapper2.send(Protocol1_15To1_14_4.class);
                });
            }

            private int toEffectCoordinate(float f) {
                return (int)(f * 8.0f);
            }
        });
        this.tagRewriter.register(ClientboundPackets1_15.UPDATE_TAGS, RegistryType.ENTITY);
    }

    @Override
    public void init(UserConnection userConnection) {
        userConnection.addEntityTracker(this.getClass(), new EntityTrackerBase(userConnection, EntityTypes1_15.PLAYER));
        userConnection.addClientWorld(this.getClass(), new ClientWorld());
        userConnection.put(new ImmediateRespawnStorage());
    }

    @Override
    public BackwardsMappingData getMappingData() {
        return MAPPINGS;
    }

    public EntityPacketRewriter1_15 getEntityRewriter() {
        return this.entityRewriter;
    }

    public BlockItemPacketRewriter1_15 getItemRewriter() {
        return this.blockItemPackets;
    }

    @Override
    public BlockRewriter<ClientboundPackets1_15> getBlockRewriter() {
        return this.blockRewriter;
    }

    @Override
    public ParticleRewriter<ClientboundPackets1_15> getParticleRewriter() {
        return this.particleRewriter;
    }

    @Override
    public TagRewriter<ClientboundPackets1_15> getTagRewriter() {
        return this.tagRewriter;
    }

    @Override
    public JsonNBTComponentRewriter<ClientboundPackets1_15> getComponentRewriter() {
        return this.translatableRewriter;
    }
}

