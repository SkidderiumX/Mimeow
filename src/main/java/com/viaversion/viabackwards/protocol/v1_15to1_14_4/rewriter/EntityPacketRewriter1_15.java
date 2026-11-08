/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_15to1_14_4.rewriter;

import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.Protocol1_15To1_14_4;
import com.viaversion.viabackwards.protocol.v1_15to1_14_4.storage.ImmediateRespawnStorage;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_15;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ServerboundPackets1_14;
import com.viaversion.viaversion.protocols.v1_14_4to1_15.packet.ClientboundPackets1_15;
import java.util.ArrayList;

public class EntityPacketRewriter1_15
extends EntityRewriter<ClientboundPackets1_15, Protocol1_15To1_14_4> {
    public EntityPacketRewriter1_15(Protocol1_15To1_14_4 protocol1_15To1_14_4) {
        super(protocol1_15To1_14_4);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.SET_HEALTH, packetWrapper -> {
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            if (f > 0.0f) {
                return;
            }
            if (!packetWrapper.user().get(ImmediateRespawnStorage.class).isImmediateRespawn()) {
                return;
            }
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_14.CLIENT_COMMAND);
            packetWrapper2.write(Types.VAR_INT, 0);
            packetWrapper2.sendToServer(Protocol1_15To1_14_4.class);
        });
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.GAME_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.FLOAT);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 11) {
                        packetWrapper.user().get(ImmediateRespawnStorage.class).setImmediateRespawn(packetWrapper.get(Types.FLOAT, 0).floatValue() == 1.0f);
                    }
                });
            }
        });
        ((Protocol1_15To1_14_4)this.protocol).replaceClientbound(ClientboundPackets1_15.ADD_MOB, new PacketHandlers(){

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
                this.handler(packetWrapper -> packetWrapper.write(Types1_14.ENTITY_DATA_LIST, new ArrayList()));
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    EntityType entityType = EntityTypes1_15.getTypeFromId(n);
                    EntityPacketRewriter1_15.this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), entityType);
                    packetWrapper.set(Types.VAR_INT, 1, EntityPacketRewriter1_15.this.newEntityId(n));
                });
            }
        });
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.read(Types.LONG);
                this.handler(EntityPacketRewriter1_15.this.getDimensionHandler(0));
            }
        });
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_15.this.getDimensionHandler(1));
                this.read(Types.LONG);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.STRING);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.handler(EntityPacketRewriter1_15.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN) == false;
                    packetWrapper.user().get(ImmediateRespawnStorage.class).setImmediateRespawn(bl);
                });
            }
        });
        this.registerTracker(ClientboundPackets1_15.ADD_EXPERIENCE_ORB, EntityTypes1_15.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_15.ADD_GLOBAL_ENTITY, EntityTypes1_15.LIGHTNING_BOLT);
        this.registerTracker(ClientboundPackets1_15.ADD_PAINTING, EntityTypes1_15.PAINTING);
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityPacketRewriter1_15.this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_15.PLAYER);
                    packetWrapper.write(Types1_14.ENTITY_DATA_LIST, new ArrayList());
                });
            }
        });
        this.registerSetEntityData(ClientboundPackets1_15.SET_ENTITY_DATA, Types1_14.ENTITY_DATA_LIST);
        ((Protocol1_15To1_14_4)this.protocol).registerClientbound(ClientboundPackets1_15.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.VAR_INT, 0);
                    EntityType entityType = EntityPacketRewriter1_15.this.tracker(packetWrapper.user()).entityType(n2);
                    if (entityType != EntityTypes1_15.BEE) {
                        return;
                    }
                    int n3 = n = packetWrapper.get(Types.INT, 0).intValue();
                    for (int i = 0; i < n; ++i) {
                        int n4;
                        int n5;
                        String string = packetWrapper.read(Types.STRING);
                        if (string.equals("generic.flyingSpeed")) {
                            --n3;
                            packetWrapper.read(Types.DOUBLE);
                            n5 = packetWrapper.read(Types.VAR_INT);
                            for (n4 = 0; n4 < n5; ++n4) {
                                packetWrapper.read(Types.UUID);
                                packetWrapper.read(Types.DOUBLE);
                                packetWrapper.read(Types.BYTE);
                            }
                            continue;
                        }
                        packetWrapper.write(Types.STRING, string);
                        packetWrapper.passthrough(Types.DOUBLE);
                        n5 = packetWrapper.passthrough(Types.VAR_INT);
                        for (n4 = 0; n4 < n5; ++n4) {
                            packetWrapper.passthrough(Types.UUID);
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.BYTE);
                        }
                    }
                    if (n3 != n) {
                        packetWrapper.set(Types.INT, 0, n3);
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.registerEntityDataTypeHandler(Types1_14.ENTITY_DATA_TYPES.itemType, null, Types1_14.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_14.ENTITY_DATA_TYPES.particleType, Types1_14.ENTITY_DATA_TYPES.componentType, Types1_14.ENTITY_DATA_TYPES.optionalComponentType);
        this.filter().type(EntityTypes1_15.LIVING_ENTITY).removeIndex(12);
        this.filter().type(EntityTypes1_15.BEE).cancel(15);
        this.filter().type(EntityTypes1_15.BEE).cancel(16);
        this.filter().type(EntityTypes1_15.ENDERMAN).cancel(16);
        this.filter().type(EntityTypes1_15.TRIDENT).cancel(10);
        this.filter().type(EntityTypes1_15.WOLF).addIndex(17);
        this.filter().type(EntityTypes1_15.WOLF).index(8).handler((entityDataHandlerEvent, entityData) -> entityDataHandlerEvent.createExtraData(new EntityData(17, Types1_14.ENTITY_DATA_TYPES.floatType, entityDataHandlerEvent.data().value())));
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_15.BEE, EntityTypes1_15.PUFFERFISH).jsonName().spawnEntityData(wrappedEntityData -> {
            wrappedEntityData.add(new EntityData(14, Types1_14.ENTITY_DATA_TYPES.booleanType, false));
            wrappedEntityData.add(new EntityData(15, Types1_14.ENTITY_DATA_TYPES.varIntType, 2));
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_15.getTypeFromId(n);
    }
}

