/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13to1_13_1.rewriter;

import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13to1_13_1.Protocol1_13To1_13_1;
import com.viaversion.viaversion.rewriter.EntityRewriter;

public class EntityPacketRewriter1_13_1
extends EntityRewriter<ClientboundPackets1_13, Protocol1_13To1_13_1> {
    public EntityPacketRewriter1_13_1(Protocol1_13To1_13_1 protocol1_13To1_13_1) {
        super(protocol1_13To1_13_1);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    Object t = packetWrapper.user().getClientWorld(Protocol1_13To1_13_1.class);
                    int n = packetWrapper.get(Types.INT, 1);
                    ((ClientWorld)t).setEnvironment(n);
                });
            }
        });
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_13To1_13_1.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_13_1.this.tracker(packetWrapper.user()).clearEntities();
                    }
                });
            }
        });
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_ENTITY, new PacketHandlers(){

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
                    if (entityType != null) {
                        if (entityType.is(EntityTypes1_13.EntityType.FALLING_BLOCK)) {
                            packetWrapper.set(Types.INT, 0, ((Protocol1_13To1_13_1)EntityPacketRewriter1_13_1.this.protocol).getMappingData().getNewBlockStateId(n));
                        }
                        packetWrapper.user().getEntityTracker(Protocol1_13To1_13_1.class).addEntity(n2, entityType);
                    }
                });
            }
        });
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_MOB, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_13_1.this.trackerAndRewriterHandler(Types1_13.ENTITY_DATA_LIST));
            }
        });
        ((Protocol1_13To1_13_1)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PLAYER, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_13_1.this.trackerAndRewriterHandler(Types1_13.ENTITY_DATA_LIST, EntityTypes1_13.EntityType.PLAYER));
            }
        });
        this.registerSetEntityData(ClientboundPackets1_13.SET_ENTITY_DATA, Types1_13.ENTITY_DATA_LIST);
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_13.ENTITY_DATA_TYPES.itemType, Types1_13.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_13.ENTITY_DATA_TYPES.particleType);
        this.registerBlockStateHandler(EntityTypes1_13.EntityType.ABSTRACT_MINECART, 9);
        this.filter().type(EntityTypes1_13.EntityType.ABSTRACT_ARROW).addIndex(7);
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

