/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_2to1_20_3.rewriter;

import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_3;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_2;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.Protocol1_20_2To1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundConfigurationPackets1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPacket1_20_2;
import com.viaversion.viaversion.protocols.v1_20to1_20_2.packet.ClientboundPackets1_20_2;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Key;

public class EntityPacketRewriter1_20_3
extends EntityRewriter<ClientboundPacket1_20_2, Protocol1_20_2To1_20_3> {
    public EntityPacketRewriter1_20_3(Protocol1_20_2To1_20_3 protocol1_20_2To1_20_3) {
        super(protocol1_20_2To1_20_3);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_20_2.SET_ENTITY_DATA, Types1_20_2.ENTITY_DATA_LIST, Types1_20_3.ENTITY_DATA_LIST);
        ((Protocol1_20_2To1_20_3)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_2.REGISTRY_DATA, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.COMPOUND_TAG);
                this.handler(EntityPacketRewriter1_20_3.this.configurationDimensionDataHandler());
                this.handler(EntityPacketRewriter1_20_3.this.configurationBiomeSizeTracker());
            }
        });
        ((Protocol1_20_2To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_2.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING_ARRAY);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_20_3.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> EntityPacketRewriter1_20_3.this.sendChunksSentGameEvent(packetWrapper));
            }
        });
        ((Protocol1_20_2To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_2.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_20_3.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> EntityPacketRewriter1_20_3.this.sendChunksSentGameEvent(packetWrapper));
            }
        });
        ((Protocol1_20_2To1_20_3)this.protocol).registerClientbound(ClientboundPackets1_20_2.INITIALIZE_BORDER, this::sendChunksSentGameEvent);
    }

    private void sendChunksSentGameEvent(PacketWrapper packetWrapper) {
        packetWrapper.send(Protocol1_20_2To1_20_3.class);
        packetWrapper.cancel();
        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_20_3.GAME_EVENT);
        packetWrapper2.write(Types.UNSIGNED_BYTE, (short)13);
        packetWrapper2.write(Types.FLOAT, Float.valueOf(0.0f));
        packetWrapper2.send(Protocol1_20_2To1_20_3.class);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            EntityDataType entityDataType = entityData.dataType();
            if (entityDataType == Types1_20_2.ENTITY_DATA_TYPES.componentType) {
                entityData.setTypeAndValue(Types1_20_3.ENTITY_DATA_TYPES.componentType, ComponentUtil.jsonToTag((JsonElement)entityData.value()));
            } else if (entityDataType == Types1_20_2.ENTITY_DATA_TYPES.optionalComponentType) {
                entityData.setTypeAndValue(Types1_20_3.ENTITY_DATA_TYPES.optionalComponentType, ComponentUtil.jsonToTag((JsonElement)entityData.value()));
            } else {
                entityData.setDataType(Types1_20_3.ENTITY_DATA_TYPES.byId(entityDataType.typeId()));
            }
        });
        this.filter().dataType(Types1_20_3.ENTITY_DATA_TYPES.particleType).handler((entityDataHandlerEvent, entityData) -> {
            Particle particle = (Particle)entityData.value();
            ParticleMappings particleMappings = ((Protocol1_20_2To1_20_3)this.protocol).getMappingData().getParticleMappings();
            if (particle.id() == particleMappings.id("vibration")) {
                String string = (String)particle.removeArgument(0).getValue();
                if (Key.stripMinecraftNamespace(string).equals("block")) {
                    particle.add(0, Types.VAR_INT, 0);
                } else {
                    particle.add(0, Types.VAR_INT, 1);
                }
            }
        });
        this.registerEntityDataTypeHandler(Types1_20_3.ENTITY_DATA_TYPES.itemType, Types1_20_3.ENTITY_DATA_TYPES.blockStateType, Types1_20_3.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20_3.ENTITY_DATA_TYPES.particleType, null);
        this.registerBlockStateHandler(EntityTypes1_20_3.ABSTRACT_MINECART, 11);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_3.getTypeFromId(n);
    }
}

