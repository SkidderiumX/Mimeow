/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.rewriter;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.Protocol1_20_3To1_20_2;
import com.viaversion.viabackwards.protocol.v1_20_3to1_20_2.storage.SpawnPositionStorage;
import com.viaversion.viaversion.api.data.ParticleMappings;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_20_3;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityDataType;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_2;
import com.viaversion.viaversion.api.type.types.version.Types1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundConfigurationPackets1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPacket1_20_3;
import com.viaversion.viaversion.protocols.v1_20_2to1_20_3.packet.ClientboundPackets1_20_3;
import com.viaversion.viaversion.util.ComponentUtil;

public class EntityPacketRewriter1_20_3
extends EntityRewriter<ClientboundPacket1_20_3, Protocol1_20_3To1_20_2> {
    public EntityPacketRewriter1_20_3(Protocol1_20_3To1_20_2 protocol1_20_3To1_20_2) {
        super(protocol1_20_3To1_20_2, Types1_20_2.ENTITY_DATA_TYPES.optionalComponentType, Types1_20_2.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_20_3.SET_ENTITY_DATA, Types1_20_3.ENTITY_DATA_LIST, Types1_20_2.ENTITY_DATA_LIST);
        ((Protocol1_20_3To1_20_2)this.protocol).registerClientbound(ClientboundConfigurationPackets1_20_3.REGISTRY_DATA, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.COMPOUND_TAG);
                this.handler(EntityPacketRewriter1_20_3.this.configurationDimensionDataHandler());
                this.handler(EntityPacketRewriter1_20_3.this.configurationBiomeSizeTracker());
            }
        });
        ((Protocol1_20_3To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_20_3.LOGIN, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_20_3.this.spawnPositionHandler());
                this.handler(EntityPacketRewriter1_20_3.this.worldDataTrackerHandlerByKey());
            }
        });
        ((Protocol1_20_3To1_20_2)this.protocol).registerClientbound(ClientboundPackets1_20_3.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_20_3.this.spawnPositionHandler());
                this.handler(EntityPacketRewriter1_20_3.this.worldDataTrackerHandlerByKey());
            }
        });
    }

    private PacketHandler spawnPositionHandler() {
        return packetWrapper -> {
            String string = packetWrapper.get(Types.STRING, 1);
            packetWrapper.user().get(SpawnPositionStorage.class).setDimension(string);
        };
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n;
            EntityDataType entityDataType = entityData.dataType();
            if (entityDataType == Types1_20_3.ENTITY_DATA_TYPES.componentType) {
                entityData.setTypeAndValue(Types1_20_2.ENTITY_DATA_TYPES.componentType, ComponentUtil.tagToJson((Tag)entityData.value()));
                return;
            }
            if (entityDataType == Types1_20_3.ENTITY_DATA_TYPES.optionalComponentType) {
                entityData.setTypeAndValue(Types1_20_2.ENTITY_DATA_TYPES.optionalComponentType, ComponentUtil.tagToJson((Tag)entityData.value()));
                return;
            }
            if (entityDataType == Types1_20_3.ENTITY_DATA_TYPES.particleType) {
                Particle particle = (Particle)entityData.getValue();
                ParticleMappings particleMappings = ((Protocol1_20_3To1_20_2)this.protocol).getMappingData().getParticleMappings();
                if (particle.id() == particleMappings.id("vibration")) {
                    int n2 = (Integer)particle.removeArgument(0).getValue();
                    if (n2 == 0) {
                        particle.add(0, Types.STRING, "minecraft:block");
                    } else {
                        particle.add(0, Types.STRING, "minecraft:entity");
                    }
                }
            } else if (entityDataType == Types1_20_3.ENTITY_DATA_TYPES.poseType && (n = ((Integer)entityData.value()).intValue()) >= 15) {
                entityDataHandlerEvent.cancel();
            }
            entityData.setDataType(Types1_20_2.ENTITY_DATA_TYPES.byId(entityDataType.typeId()));
        });
        this.registerEntityDataTypeHandler(Types1_20_2.ENTITY_DATA_TYPES.itemType, Types1_20_2.ENTITY_DATA_TYPES.blockStateType, Types1_20_2.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_20_2.ENTITY_DATA_TYPES.particleType, Types1_20_2.ENTITY_DATA_TYPES.componentType, Types1_20_2.ENTITY_DATA_TYPES.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_20_3.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_20_3.TNT).removeIndex(9);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_20_3.BREEZE, EntityTypes1_20_3.BLAZE).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_20_3.WIND_CHARGE, EntityTypes1_20_3.SHULKER_BULLET).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_20_3.getTypeFromId(n);
    }
}

