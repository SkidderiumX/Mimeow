/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.Protocol1_12_2To1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.blockconnections.ConnectionData;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.EntityIdMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.data.ParticleIdMappings1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.rewriter.WorldPacketRewriter1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.storage.BlockStorage;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.util.ComponentUtil;

public class EntityPacketRewriter1_13
extends EntityRewriter<ClientboundPackets1_12_1, Protocol1_12_2To1_13> {
    public EntityPacketRewriter1_13(Protocol1_12_2To1_13 protocol1_12_2To1_13) {
        super(protocol1_12_2To1_13);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.ADD_ENTITY, new PacketHandlers(){

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
                    packetWrapper.user().getEntityTracker(Protocol1_12_2To1_13.class).addEntity(n2, entityType);
                    if (entityType.is(EntityTypes1_13.EntityType.FALLING_BLOCK)) {
                        int n3 = packetWrapper.get(Types.INT, 0);
                        int n4 = (n3 & 0xFFF) << 4 | n3 >> 12 & 0xF;
                        packetWrapper.set(Types.INT, 0, WorldPacketRewriter1_13.toNewId(n4));
                    }
                    if (entityType.is(EntityTypes1_13.EntityType.ITEM_FRAME)) {
                        switch (n) {
                            case 0: {
                                n = 3;
                                break;
                            }
                            case 1: {
                                n = 4;
                                break;
                            }
                            case 3: {
                                n = 5;
                            }
                        }
                        packetWrapper.set(Types.INT, 0, n);
                    }
                });
            }
        });
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.ADD_MOB, new PacketHandlers(){

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
                this.map(Types.ENTITY_DATA_LIST1_12, Types1_13.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_13.this.trackerAndRewriterHandler(Types1_13.ENTITY_DATA_LIST));
            }
        });
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.ENTITY_DATA_LIST1_12, Types1_13.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_13.this.trackerAndRewriterHandler(Types1_13.ENTITY_DATA_LIST, EntityTypes1_13.EntityType.PLAYER));
            }
        });
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_12_2To1_13.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
                this.handler(EntityPacketRewriter1_13.this.playerTrackerHandler());
                this.handler(Protocol1_12_2To1_13.SEND_DECLARE_COMMANDS_AND_TAGS);
            }
        });
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_12_2To1_13.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        if (Via.getConfig().isServersideBlockConnections()) {
                            ConnectionData.clearBlockStorage(packetWrapper.user());
                        }
                        EntityPacketRewriter1_13.this.tracker(packetWrapper.user()).clearEntities();
                        packetWrapper.user().get(BlockStorage.class).clear();
                    }
                });
                this.handler(Protocol1_12_2To1_13.SEND_DECLARE_COMMANDS_AND_TAGS);
            }
        });
        ((Protocol1_12_2To1_13)this.protocol).registerClientbound(ClientboundPackets1_12_1.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    byte by = packetWrapper.read(Types.BYTE);
                    if (Via.getConfig().isNewEffectIndicator()) {
                        by = (byte)(by | 4);
                    }
                    packetWrapper.write(Types.BYTE, by);
                });
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_12_1.REMOVE_ENTITIES);
        this.registerSetEntityData(ClientboundPackets1_12_1.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_12, Types1_13.ENTITY_DATA_LIST);
    }

    @Override
    protected void registerRewrites() {
        this.filter().mapDataType(n -> Types1_13.ENTITY_DATA_TYPES.byId(n > 4 ? n + 1 : n));
        this.filter().dataType(Types1_13.ENTITY_DATA_TYPES.itemType).handler((entityDataHandlerEvent, entityData) -> ((Protocol1_12_2To1_13)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.value()));
        this.filter().dataType(Types1_13.ENTITY_DATA_TYPES.optionalBlockStateType).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n != 0) {
                int n2 = (n & 0xFFF) << 4 | n >> 12 & 0xF;
                int n3 = WorldPacketRewriter1_13.toNewId(n2);
                entityData.setValue(n3);
            }
        });
        this.filter().index(0).handler((entityDataHandlerEvent, entityData) -> entityData.setValue((byte)((Byte)entityData.getValue() & 0xFFFFFFEF)));
        this.filter().index(2).handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.getValue() != null && !((String)entityData.getValue()).isEmpty()) {
                entityData.setTypeAndValue(Types1_13.ENTITY_DATA_TYPES.optionalComponentType, ComponentUtil.legacyToJson((String)entityData.getValue()));
            } else {
                entityData.setTypeAndValue(Types1_13.ENTITY_DATA_TYPES.optionalComponentType, null);
            }
        });
        this.filter().type(EntityTypes1_13.EntityType.WOLF).index(17).handler((entityDataHandlerEvent, entityData) -> entityData.setValue(15 - (Integer)entityData.getValue()));
        this.filter().type(EntityTypes1_13.EntityType.ZOMBIE).addIndex(15);
        this.filter().type(EntityTypes1_13.EntityType.ABSTRACT_MINECART).index(9).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            int n2 = (n & 0xFFF) << 4 | n >> 12 & 0xF;
            int n3 = WorldPacketRewriter1_13.toNewId(n2);
            entityData.setValue(n3);
        });
        this.filter().type(EntityTypes1_13.EntityType.AREA_EFFECT_CLOUD).handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.id() == 9) {
                int n = (Integer)entityData.value();
                EntityData entityData2 = entityDataHandlerEvent.dataAtIndex(10);
                EntityData entityData3 = entityDataHandlerEvent.dataAtIndex(11);
                int n2 = entityData2 != null ? (Integer)entityData2.value() : 0;
                int n3 = entityData3 != null ? (Integer)entityData3.value() : 0;
                Particle particle = ParticleIdMappings1_13.rewriteParticle(n, new Integer[]{n2, n3});
                if (particle != null && particle.id() != -1) {
                    entityDataHandlerEvent.createExtraData(new EntityData(9, Types1_13.ENTITY_DATA_TYPES.particleType, particle));
                }
            }
            if (entityData.id() >= 9) {
                entityDataHandlerEvent.cancel();
            }
        });
    }

    @Override
    public int newEntityId(int n) {
        return EntityIdMappings1_13.getNewId(n);
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

