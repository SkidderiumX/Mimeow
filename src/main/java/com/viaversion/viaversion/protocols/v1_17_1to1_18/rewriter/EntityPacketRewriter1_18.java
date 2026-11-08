/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_17_1to1_18.rewriter;

import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_17;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_17;
import com.viaversion.viaversion.api.type.types.version.Types1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.Protocol1_17_1To1_18;
import com.viaversion.viaversion.protocols.v1_17_1to1_18.storage.ChunkLightStorage;
import com.viaversion.viaversion.protocols.v1_17to1_17_1.packet.ClientboundPackets1_17_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.ParticleRewriter;

public class EntityPacketRewriter1_18
extends EntityRewriter<ClientboundPackets1_17_1, Protocol1_17_1To1_18> {
    public EntityPacketRewriter1_18(Protocol1_17_1To1_18 protocol1_17_1To1_18) {
        super(protocol1_17_1To1_18);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_17_1.SET_ENTITY_DATA, Types1_17.ENTITY_DATA_LIST, Types1_18.ENTITY_DATA_LIST);
        ((Protocol1_17_1To1_18)this.protocol).registerClientbound(ClientboundPackets1_17_1.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.passthrough(Types.VAR_INT);
                    packetWrapper.write(Types.VAR_INT, n);
                });
                this.handler(EntityPacketRewriter1_18.this.worldDataTrackerHandler(1));
                this.handler(EntityPacketRewriter1_18.this.biomeSizeTracker());
            }
        });
        ((Protocol1_17_1To1_18)this.protocol).registerClientbound(ClientboundPackets1_17_1.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.handler(packetWrapper -> {
                    Object e;
                    String string = packetWrapper.get(Types.STRING, 0);
                    if (!string.equals((e = EntityPacketRewriter1_18.this.tracker(packetWrapper.user())).currentWorld())) {
                        packetWrapper.user().get(ChunkLightStorage.class).clear();
                    }
                });
                this.handler(EntityPacketRewriter1_18.this.worldDataTrackerHandler(0));
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(Types1_18.ENTITY_DATA_TYPES::byId);
        this.filter().dataType(Types1_18.ENTITY_DATA_TYPES.particleType).handler((entityDataHandlerEvent, entityData) -> {
            Particle particle = (Particle)entityData.getValue();
            if (particle.id() == 2) {
                particle.setId(3);
                particle.add(Types.VAR_INT, 7754);
            } else if (particle.id() == 3) {
                particle.add(Types.VAR_INT, 7786);
            } else {
                ((ParticleRewriter)((Protocol1_17_1To1_18)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), particle);
            }
        });
        this.registerEntityDataTypeHandler(Types1_18.ENTITY_DATA_TYPES.itemType, null, null);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_17.getTypeFromId(n);
    }
}

