/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_11to1_10.rewriter;

import com.viaversion.viabackwards.api.entities.storage.WrappedEntityData;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_11to1_10.Protocol1_11To1_10;
import com.viaversion.viabackwards.protocol.v1_11to1_10.data.SplashPotionMappings1_10;
import com.viaversion.viabackwards.protocol.v1_11to1_10.storage.ChestedHorseStorage;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_11;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;
import java.util.List;

public class EntityPacketRewriter1_11
extends LegacyEntityRewriter<ClientboundPackets1_9_3, Protocol1_11To1_10> {
    public EntityPacketRewriter1_11(Protocol1_11To1_10 protocol1_11To1_10) {
        super(protocol1_11To1_10);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.LEVEL_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n == 2002 || n == 2007) {
                        int n2;
                        if (n == 2007) {
                            packetWrapper.set(Types.INT, 0, 2002);
                        }
                        if ((n2 = SplashPotionMappings1_10.getOldData(packetWrapper.get(Types.INT, 1))) != -1) {
                            packetWrapper.set(Types.INT, 1, n2);
                        }
                    }
                });
            }
        });
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_ENTITY, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_11.this.getObjectTrackerHandler());
                this.handler(EntityPacketRewriter1_11.this.getObjectRewriter(EntityTypes1_11.ObjectType::findById));
                this.handler(((Protocol1_11To1_10)EntityPacketRewriter1_11.this.protocol).getItemRewriter().getFallingBlockHandler());
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.ADD_EXPERIENCE_ORB, EntityTypes1_11.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_9_3.ADD_GLOBAL_ENTITY, EntityTypes1_11.EntityType.LIGHTNING_BOLT);
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT, Types.UNSIGNED_BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_9);
                this.handler(EntityPacketRewriter1_11.this.getTrackerHandler(Types.UNSIGNED_BYTE, 0));
                this.handler(EntityPacketRewriter1_11.this.getMobSpawnRewriter(Types.ENTITY_DATA_LIST1_9));
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    if (list.isEmpty()) {
                        list.add(new EntityData(0, EntityDataTypes1_9.BYTE, (byte)0));
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_9_3.ADD_PAINTING, EntityTypes1_11.EntityType.PAINTING);
        this.registerJoinGame(ClientboundPackets1_9_3.LOGIN, EntityTypes1_11.EntityType.PLAYER);
        this.registerRespawn(ClientboundPackets1_9_3.RESPAWN);
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.ENTITY_DATA_LIST1_9);
                this.handler(EntityPacketRewriter1_11.this.getTrackerAndDataHandler(Types.ENTITY_DATA_LIST1_9, EntityTypes1_11.EntityType.PLAYER));
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    if (list.isEmpty()) {
                        list.add(new EntityData(0, EntityDataTypes1_9.BYTE, (byte)0));
                    }
                });
            }
        });
        this.registerRemoveEntities(ClientboundPackets1_9_3.REMOVE_ENTITIES);
        this.registerSetEntityData(ClientboundPackets1_9_3.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_9);
        ((Protocol1_11To1_10)this.protocol).registerClientbound(ClientboundPackets1_9_3.ENTITY_EVENT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    if (n != EntityPacketRewriter1_11.this.tracker(packetWrapper.user()).clientEntityId()) {
                        return;
                    }
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (by == 35) {
                        packetWrapper.clearPacket();
                        packetWrapper.setPacketType(ClientboundPackets1_9_3.GAME_EVENT);
                        packetWrapper.write(Types.UNSIGNED_BYTE, (short)10);
                        packetWrapper.write(Types.FLOAT, Float.valueOf(0.0f));
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.ELDER_GUARDIAN, EntityTypes1_11.EntityType.GUARDIAN);
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.WITHER_SKELETON, EntityTypes1_11.EntityType.SKELETON).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getSkeletonTypeData(1)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.STRAY, EntityTypes1_11.EntityType.SKELETON).plainName().spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getSkeletonTypeData(2)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.HUSK, EntityTypes1_11.EntityType.ZOMBIE).plainName().spawnEntityData(wrappedEntityData -> this.handleZombieType(wrappedEntityData, 6));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.ZOMBIE_VILLAGER, EntityTypes1_11.EntityType.ZOMBIE).spawnEntityData(wrappedEntityData -> this.handleZombieType(wrappedEntityData, 1));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.HORSE, EntityTypes1_11.EntityType.HORSE).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(0)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.DONKEY, EntityTypes1_11.EntityType.HORSE).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(1)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.MULE, EntityTypes1_11.EntityType.HORSE).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(2)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.SKELETON_HORSE, EntityTypes1_11.EntityType.HORSE).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(4)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.ZOMBIE_HORSE, EntityTypes1_11.EntityType.HORSE).spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(3)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.EVOKER_FANGS, EntityTypes1_11.EntityType.SHULKER);
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.EVOKER, EntityTypes1_11.EntityType.VILLAGER).plainName();
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.VEX, EntityTypes1_11.EntityType.BAT).plainName();
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.VINDICATOR, EntityTypes1_11.EntityType.VILLAGER).plainName().spawnEntityData(wrappedEntityData -> wrappedEntityData.add(new EntityData(13, EntityDataTypes1_9.VAR_INT, 4)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.LLAMA, EntityTypes1_11.EntityType.HORSE).plainName().spawnEntityData(wrappedEntityData -> wrappedEntityData.add(this.getHorseDataType(1)));
        this.mapEntityTypeWithData(EntityTypes1_11.EntityType.LLAMA_SPIT, EntityTypes1_11.EntityType.SNOWBALL);
        this.mapObjectType(EntityTypes1_11.ObjectType.LLAMA_SPIT, EntityTypes1_11.ObjectType.SNOWBALL, -1);
        this.mapObjectType(EntityTypes1_11.ObjectType.EVOKER_FANGS, EntityTypes1_11.ObjectType.FALLING_BLOCK, 4294);
        this.filter().type(EntityTypes1_11.EntityType.GUARDIAN).index(12).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            boolean bl = (Boolean)entityData.getValue();
            int n2 = n = bl ? 2 : 0;
            if (entityDataHandlerEvent.entityType() == EntityTypes1_11.EntityType.ELDER_GUARDIAN) {
                n |= 4;
            }
            entityData.setTypeAndValue(EntityDataTypes1_9.BYTE, (byte)n);
        });
        this.filter().type(EntityTypes1_11.EntityType.ABSTRACT_SKELETON).index(12).toIndex(13);
        this.filter().type(EntityTypes1_11.EntityType.ZOMBIE).handler((entityDataHandlerEvent, entityData) -> {
            switch (entityData.id()) {
                case 13: {
                    entityDataHandlerEvent.cancel();
                    break;
                }
                case 14: {
                    entityDataHandlerEvent.setIndex(15);
                    break;
                }
                case 15: {
                    entityDataHandlerEvent.setIndex(14);
                    break;
                }
                case 16: {
                    entityDataHandlerEvent.setIndex(13);
                    entityData.setValue(1 + (Integer)entityData.getValue());
                }
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.EVOKER).index(12).handler((entityDataHandlerEvent, entityData) -> {
            entityDataHandlerEvent.setIndex(13);
            entityData.setTypeAndValue(EntityDataTypes1_9.VAR_INT, ((Byte)entityData.getValue()).intValue());
        });
        this.filter().type(EntityTypes1_11.EntityType.VEX).index(12).handler((entityDataHandlerEvent, entityData) -> entityData.setValue((byte)0));
        this.filter().type(EntityTypes1_11.EntityType.VINDICATOR).index(12).handler((entityDataHandlerEvent, entityData) -> {
            entityDataHandlerEvent.setIndex(13);
            entityData.setTypeAndValue(EntityDataTypes1_9.VAR_INT, ((Number)entityData.getValue()).intValue() == 1 ? 2 : 4);
        });
        this.filter().type(EntityTypes1_11.EntityType.ABSTRACT_HORSE).index(13).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.getValue();
            ChestedHorseStorage chestedHorseStorage = entityDataHandlerEvent.trackedEntity().get(ChestedHorseStorage.class);
            if (chestedHorseStorage != null && chestedHorseStorage.isChested()) {
                by = (byte)(by | 8);
                entityData.setValue(by);
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.CHESTED_HORSE).handler((entityDataHandlerEvent, entityData) -> {
            if (!entityDataHandlerEvent.trackedEntity().has(ChestedHorseStorage.class)) {
                entityDataHandlerEvent.trackedEntity().put(new ChestedHorseStorage());
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.HORSE).index(16).toIndex(17);
        this.filter().type(EntityTypes1_11.EntityType.CHESTED_HORSE).index(15).handler((entityDataHandlerEvent, entityData) -> {
            ChestedHorseStorage chestedHorseStorage = entityDataHandlerEvent.trackedEntity().get(ChestedHorseStorage.class);
            boolean bl = (Boolean)entityData.getValue();
            chestedHorseStorage.setChested(bl);
            entityDataHandlerEvent.cancel();
        });
        this.filter().type(EntityTypes1_11.EntityType.LLAMA).handler((entityDataHandlerEvent, entityData) -> {
            ChestedHorseStorage chestedHorseStorage = entityDataHandlerEvent.trackedEntity().get(ChestedHorseStorage.class);
            int n = entityDataHandlerEvent.index();
            switch (n) {
                case 16: {
                    chestedHorseStorage.setLiamaStrength((Integer)entityData.getValue());
                    entityDataHandlerEvent.cancel();
                    break;
                }
                case 17: {
                    chestedHorseStorage.setLiamaCarpetColor((Integer)entityData.getValue());
                    entityDataHandlerEvent.cancel();
                    break;
                }
                case 18: {
                    chestedHorseStorage.setLiamaVariant((Integer)entityData.getValue());
                    entityDataHandlerEvent.cancel();
                }
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.ABSTRACT_HORSE).index(14).toIndex(16);
        this.filter().type(EntityTypes1_11.EntityType.VILLAGER).index(13).handler((entityDataHandlerEvent, entityData) -> {
            if ((Integer)entityData.getValue() == 5) {
                entityData.setValue(0);
            }
        });
        this.filter().type(EntityTypes1_11.EntityType.SHULKER).cancel(15);
    }

    private EntityData getSkeletonTypeData(int n) {
        return new EntityData(12, EntityDataTypes1_9.VAR_INT, n);
    }

    private EntityData getZombieTypeData(int n) {
        return new EntityData(13, EntityDataTypes1_9.VAR_INT, n);
    }

    private void handleZombieType(WrappedEntityData wrappedEntityData, int n) {
        EntityData entityData = wrappedEntityData.get(13);
        if (entityData == null) {
            wrappedEntityData.add(this.getZombieTypeData(n));
        }
    }

    private EntityData getHorseDataType(int n) {
        return new EntityData(14, EntityDataTypes1_9.VAR_INT, n);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_11.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_11.ObjectType.getEntityType(n, n2);
    }
}

