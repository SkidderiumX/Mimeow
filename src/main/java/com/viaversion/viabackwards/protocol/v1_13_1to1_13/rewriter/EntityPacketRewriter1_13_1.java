/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13_1to1_13.rewriter;

import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_13_1to1_13.Protocol1_13_1To1_13;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import java.util.List;

public class EntityPacketRewriter1_13_1
extends LegacyEntityRewriter<ClientboundPackets1_13, Protocol1_13_1To1_13> {
    public EntityPacketRewriter1_13_1(Protocol1_13_1To1_13 protocol1_13_1To1_13) {
        super(protocol1_13_1To1_13);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    EntityTypes1_13.EntityType entityType = EntityTypes1_13.ObjectType.getEntityType(by, n = packetWrapper.get(Types.INT, 0).intValue());
                    if (entityType == null) {
                        return;
                    }
                    if (entityType.is(EntityTypes1_13.EntityType.FALLING_BLOCK)) {
                        packetWrapper.set(Types.INT, 0, ((Protocol1_13_1To1_13)EntityPacketRewriter1_13_1.this.protocol).getMappingData().getNewBlockStateId(n));
                    }
                    EntityPacketRewriter1_13_1.this.tracker(packetWrapper.user()).addEntity(n2, entityType);
                });
            }
        });
        this.registerTracker(ClientboundPackets1_13.ADD_EXPERIENCE_ORB, EntityTypes1_13.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_13.ADD_GLOBAL_ENTITY, EntityTypes1_13.EntityType.LIGHTNING_BOLT);
        ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types1_13.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_13_1.this.getTrackerHandler());
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types1_13.ENTITY_DATA_LIST, 0);
                    EntityPacketRewriter1_13_1.this.handleEntityData(packetWrapper.get(Types.VAR_INT, 0), list, packetWrapper.user());
                });
            }
        });
        ((Protocol1_13_1To1_13)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_13.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_13_1.this.getTrackerAndDataHandler(Types1_13.ENTITY_DATA_LIST, EntityTypes1_13.EntityType.PLAYER));
            }
        });
        this.registerTracker(ClientboundPackets1_13.ADD_PAINTING, EntityTypes1_13.EntityType.PAINTING);
        this.registerJoinGame(ClientboundPackets1_13.LOGIN, EntityTypes1_13.EntityType.PLAYER);
        this.registerRespawn(ClientboundPackets1_13.RESPAWN);
        this.registerSetEntityData(ClientboundPackets1_13.SET_ENTITY_DATA, Types1_13.ENTITY_DATA_LIST);
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.dataType() == Types1_13.ENTITY_DATA_TYPES.itemType) {
                entityData.setValue(((Protocol1_13_1To1_13)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.getValue()));
            } else if (entityData.dataType() == Types1_13.ENTITY_DATA_TYPES.optionalBlockStateType) {
                int n = (Integer)entityData.getValue();
                entityData.setValue(((Protocol1_13_1To1_13)this.protocol).getMappingData().getNewBlockStateId(n));
            } else if (entityData.dataType() == Types1_13.ENTITY_DATA_TYPES.particleType) {
                ((ParticleRewriter)((Protocol1_13_1To1_13)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.getValue());
            } else if (entityData.dataType() == Types1_13.ENTITY_DATA_TYPES.optionalComponentType || entityData.dataType() == Types1_13.ENTITY_DATA_TYPES.componentType) {
                JsonElement jsonElement = (JsonElement)entityData.value();
                ((Protocol1_13_1To1_13)this.protocol).translatableRewriter().processText(entityDataHandlerEvent.user(), jsonElement);
            }
        });
        this.filter().type(EntityTypes1_13.EntityType.ABSTRACT_ARROW).cancel(7);
        this.filter().type(EntityTypes1_13.EntityType.SPECTRAL_ARROW).index(8).toIndex(7);
        this.filter().type(EntityTypes1_13.EntityType.TRIDENT).index(8).toIndex(7);
        this.registerBlockStateHandler(EntityTypes1_13.EntityType.ABSTRACT_MINECART, 9);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_13.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_13.ObjectType.getEntityType(n, n2);
    }
}

