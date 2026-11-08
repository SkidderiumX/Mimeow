/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_14to1_13_2.rewriter;

import com.viaversion.viabackwards.api.entities.storage.EntityPositionHandler;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.Protocol1_14To1_13_2;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.ChunkLightStorage;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.DifficultyStorage;
import com.viaversion.viabackwards.protocol.v1_14to1_13_2.storage.EntityPositionStorage1_14;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.VillagerData;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13_2;
import com.viaversion.viaversion.api.type.types.version.Types1_14;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ServerboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_13_2to1_14.packet.ClientboundPackets1_14;
import com.viaversion.viaversion.rewriter.ParticleRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;

public class EntityPacketRewriter1_14
extends LegacyEntityRewriter<ClientboundPackets1_14, Protocol1_14To1_13_2> {
    private EntityPositionHandler positionHandler;

    public EntityPacketRewriter1_14(Protocol1_14To1_13_2 protocol1_14To1_13_2) {
        super(protocol1_14To1_13_2, Types1_13_2.ENTITY_DATA_TYPES.optionalComponentType, Types1_13_2.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    protected void registerPackets() {
        this.positionHandler = new EntityPositionHandler(this, EntityPositionStorage1_14.class, EntityPositionStorage1_14::new);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ENTITY_EVENT, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.INT);
            byte by = packetWrapper.passthrough(Types.BYTE);
            if (by != 3) {
                return;
            }
            Object e = this.tracker(packetWrapper.user());
            EntityType entityType = e.entityType(n);
            if (entityType != EntityTypes1_14.PLAYER) {
                return;
            }
            for (int i = 0; i <= 5; ++i) {
                PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_13.SET_EQUIPPED_ITEM);
                packetWrapper2.write(Types.VAR_INT, n);
                packetWrapper2.write(Types.VAR_INT, i);
                packetWrapper2.write(Types.ITEM1_13_2, null);
                packetWrapper2.send(Protocol1_14To1_13_2.class);
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.positionHandler.cacheEntityPosition(packetWrapper, false, false));
            }
        });
        PacketHandlers packetHandlers = new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    double d = (double)packetWrapper.get(Types.SHORT, 0).shortValue() / 4096.0;
                    double d2 = (double)packetWrapper.get(Types.SHORT, 1).shortValue() / 4096.0;
                    double d3 = (double)packetWrapper.get(Types.SHORT, 2).shortValue() / 4096.0;
                    EntityPacketRewriter1_14.this.positionHandler.cacheEntityPosition(packetWrapper, d, d2, d3, false, true);
                });
            }
        };
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MOVE_ENTITY_POS, packetHandlers);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.MOVE_ENTITY_POS_ROT, packetHandlers);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT, Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.handler(packetWrapper -> {
                    int n;
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    EntityType entityType = EntityPacketRewriter1_14.this.objectTypeFromId(by, n = packetWrapper.get(Types.INT, 0).intValue());
                    if (entityType == null) {
                        return;
                    }
                    EntityPacketRewriter1_14.this.trackAndCacheEntityPosition(packetWrapper, entityType);
                });
                this.handler(packetWrapper -> {
                    int n;
                    EntityTypes1_13.ObjectType objectType;
                    EntityTypes1_13.EntityType entityType;
                    block16: {
                        block15: {
                            byte by = packetWrapper.get(Types.BYTE, 0);
                            int n2 = EntityPacketRewriter1_14.this.newEntityId(by);
                            entityType = EntityTypes1_13.EntityType.findById(n2);
                            if (entityType == null) {
                                return;
                            }
                            objectType = null;
                            if (!entityType.isOrHasParent(EntityTypes1_13.EntityType.ABSTRACT_MINECART)) break block15;
                            objectType = EntityTypes1_13.ObjectType.MINECART;
                            switch (entityType) {
                                case CHEST_MINECART: {
                                    int n3 = 1;
                                    break;
                                }
                                case FURNACE_MINECART: {
                                    int n3 = 2;
                                    break;
                                }
                                case TNT_MINECART: {
                                    int n3 = 3;
                                    break;
                                }
                                case SPAWNER_MINECART: {
                                    int n3 = 4;
                                    break;
                                }
                                case HOPPER_MINECART: {
                                    int n3 = 5;
                                    break;
                                }
                                case COMMAND_BLOCK_MINECART: {
                                    int n3 = 6;
                                    break;
                                }
                                default: {
                                    int n3 = n = 0;
                                }
                            }
                            if (n == 0) break block16;
                            packetWrapper.set(Types.INT, 0, n);
                            break block16;
                        }
                        if (entityType.is(EntityTypes1_13.EntityType.EXPERIENCE_ORB)) {
                            packetWrapper.cancel();
                            int n4 = packetWrapper.get(Types.VAR_INT, 0);
                            PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_13.ADD_EXPERIENCE_ORB, packetWrapper.user());
                            packetWrapper2.write(Types.VAR_INT, n4);
                            packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 0));
                            packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 1));
                            packetWrapper2.write(Types.DOUBLE, packetWrapper.get(Types.DOUBLE, 2));
                            packetWrapper2.write(Types.SHORT, (short)0);
                            packetWrapper2.send(Protocol1_14To1_13_2.class);
                            PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_13.SET_ENTITY_MOTION, packetWrapper.user());
                            packetWrapper3.write(Types.VAR_INT, n4);
                            packetWrapper3.write(Types.SHORT, packetWrapper.get(Types.SHORT, 0));
                            packetWrapper3.write(Types.SHORT, packetWrapper.get(Types.SHORT, 1));
                            packetWrapper3.write(Types.SHORT, packetWrapper.get(Types.SHORT, 2));
                            packetWrapper3.send(Protocol1_14To1_13_2.class);
                            return;
                        }
                        for (EntityTypes1_13.ObjectType objectType2 : EntityTypes1_13.ObjectType.values()) {
                            if (objectType2.getType() != entityType) continue;
                            objectType = objectType2;
                            break;
                        }
                    }
                    if (objectType == null) {
                        return;
                    }
                    packetWrapper.set(Types.BYTE, 0, (byte)objectType.getId());
                    n = packetWrapper.get(Types.INT, 0);
                    if (objectType == EntityTypes1_13.ObjectType.FALLING_BLOCK) {
                        int n5 = packetWrapper.get(Types.INT, 0);
                        int n6 = ((Protocol1_14To1_13_2)EntityPacketRewriter1_14.this.protocol).getMappingData().getNewBlockStateId(n5);
                        packetWrapper.set(Types.INT, 0, n6);
                    } else if (entityType.isOrHasParent(EntityTypes1_13.EntityType.ABSTRACT_ARROW)) {
                        packetWrapper.set(Types.INT, 0, n + 1);
                    }
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_MOB, new PacketHandlers(){

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
                this.map(Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    EntityType entityType = EntityTypes1_14.getTypeFromId(n);
                    EntityPacketRewriter1_14.this.trackAndCacheEntityPosition(packetWrapper, entityType);
                    int n2 = EntityPacketRewriter1_14.this.newEntityId(n);
                    if (n2 == -1) {
                        EntityReplacement entityReplacement = EntityPacketRewriter1_14.this.entityDataForType(entityType);
                        if (entityReplacement == null) {
                            ((Protocol1_14To1_13_2)EntityPacketRewriter1_14.this.protocol).getLogger().warning("Could not find entity type mapping " + n + "/" + String.valueOf(entityType));
                            packetWrapper.cancel();
                        } else {
                            packetWrapper.set(Types.VAR_INT, 1, entityReplacement.replacementId());
                        }
                    } else {
                        packetWrapper.set(Types.VAR_INT, 1, n2);
                    }
                });
                this.handler(EntityPacketRewriter1_14.this.getMobSpawnRewriter1_11(Types1_13_2.ENTITY_DATA_LIST));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_EXPERIENCE_ORB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.trackAndCacheEntityPosition(packetWrapper, EntityTypes1_14.EXPERIENCE_ORB));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_GLOBAL_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.trackAndCacheEntityPosition(packetWrapper, EntityTypes1_14.LIGHTNING_BOLT));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.VAR_INT);
                this.map(Types.BLOCK_POSITION1_14, Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.trackAndCacheEntityPosition(packetWrapper, EntityTypes1_14.PAINTING));
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
                this.handler(EntityPacketRewriter1_14.this.getTrackerAndDataHandler(Types1_13_2.ENTITY_DATA_LIST, EntityTypes1_14.PLAYER));
                this.handler(packetWrapper -> EntityPacketRewriter1_14.this.positionHandler.cacheEntityPosition(packetWrapper, true, false));
            }
        });
        this.registerSetEntityData(ClientboundPackets1_14.SET_ENTITY_DATA, Types1_14.ENTITY_DATA_LIST, Types1_13_2.ENTITY_DATA_LIST);
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_14.this.getDimensionHandler(1));
                this.handler(EntityPacketRewriter1_14.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    short s = packetWrapper.user().get(DifficultyStorage.class).getDifficulty();
                    packetWrapper.write(Types.UNSIGNED_BYTE, s);
                    packetWrapper.passthrough(Types.UNSIGNED_BYTE);
                    packetWrapper.passthrough(Types.STRING);
                    packetWrapper.read(Types.VAR_INT);
                    int n = packetWrapper.get(Types.INT, 0);
                    TrackedEntity trackedEntity = EntityPacketRewriter1_14.this.tracker(packetWrapper.user()).entity(n);
                    trackedEntity.put(new EntityPositionStorage1_14());
                });
            }
        });
        ((Protocol1_14To1_13_2)this.protocol).registerClientbound(ClientboundPackets1_14.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_14To1_13_2.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        Object e = EntityPacketRewriter1_14.this.tracker(packetWrapper.user());
                        e.clearEntities();
                        packetWrapper.user().get(ChunkLightStorage.class).clear();
                        e.entity(e.clientEntityId()).put(new EntityPositionStorage1_14());
                    }
                    short s = packetWrapper.user().get(DifficultyStorage.class).getDifficulty();
                    packetWrapper.write(Types.UNSIGNED_BYTE, s);
                });
            }
        });
        PacketHandler packetHandler = packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            this.positionHandler.cacheEntityPosition(packetWrapper, this.tracker(packetWrapper.user()).clientEntityId(), d, d2, d3, false, false);
        };
        ((Protocol1_14To1_13_2)this.protocol).registerServerbound(ServerboundPackets1_13.MOVE_PLAYER_POS, packetHandler);
        ((Protocol1_14To1_13_2)this.protocol).registerServerbound(ServerboundPackets1_13.MOVE_PLAYER_POS_ROT, packetHandler);
    }

    private void trackAndCacheEntityPosition(PacketWrapper packetWrapper, EntityType entityType) {
        int n = packetWrapper.get(Types.VAR_INT, 0);
        this.tracker(packetWrapper.user()).addEntity(n, entityType);
        if (entityType == EntityTypes1_14.PAINTING) {
            BlockPosition blockPosition = packetWrapper.get(Types.BLOCK_POSITION1_8, 0);
            this.positionHandler.cacheEntityPosition(packetWrapper, blockPosition.x(), blockPosition.y(), blockPosition.z(), true, false);
        } else {
            this.positionHandler.cacheEntityPosition(packetWrapper, true, false);
        }
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n = entityData.dataType().typeId();
            if (n <= 15) {
                entityData.setDataType(Types1_13_2.ENTITY_DATA_TYPES.byId(n));
            }
        });
        this.registerEntityDataTypeHandler(Types1_13_2.ENTITY_DATA_TYPES.itemType, null, Types1_13_2.ENTITY_DATA_TYPES.optionalBlockStateType, null, Types1_13_2.ENTITY_DATA_TYPES.componentType, Types1_13_2.ENTITY_DATA_TYPES.optionalComponentType);
        this.filter().type(EntityTypes1_14.PILLAGER).cancel(15);
        this.filter().type(EntityTypes1_14.FOX).cancel(15);
        this.filter().type(EntityTypes1_14.FOX).cancel(16);
        this.filter().type(EntityTypes1_14.FOX).cancel(17);
        this.filter().type(EntityTypes1_14.FOX).cancel(18);
        this.filter().type(EntityTypes1_14.PANDA).cancel(15);
        this.filter().type(EntityTypes1_14.PANDA).cancel(16);
        this.filter().type(EntityTypes1_14.PANDA).cancel(17);
        this.filter().type(EntityTypes1_14.PANDA).cancel(18);
        this.filter().type(EntityTypes1_14.PANDA).cancel(19);
        this.filter().type(EntityTypes1_14.PANDA).cancel(20);
        this.filter().type(EntityTypes1_14.CAT).cancel(18);
        this.filter().type(EntityTypes1_14.CAT).cancel(19);
        this.filter().type(EntityTypes1_14.CAT).cancel(20);
        this.filter().type(EntityTypes1_14.ABSTRACT_RAIDER).removeIndex(14);
        this.filter().type(EntityTypes1_14.AREA_EFFECT_CLOUD).index(10).handler((entityDataHandlerEvent, entityData) -> ((ParticleRewriter)((Protocol1_14To1_13_2)this.protocol).getParticleRewriter()).rewriteParticle(entityDataHandlerEvent.user(), (Particle)entityData.getValue()));
        this.filter().type(EntityTypes1_14.FIREWORK_ROCKET).index(8).handler((entityDataHandlerEvent, entityData) -> {
            entityData.setDataType(Types1_13_2.ENTITY_DATA_TYPES.varIntType);
            Integer n = (Integer)entityData.getValue();
            if (n == null) {
                entityData.setValue(0);
            }
        });
        this.filter().type(EntityTypes1_14.ABSTRACT_ARROW).removeIndex(9);
        this.filter().type(EntityTypes1_14.VILLAGER).cancel(15);
        EntityDataHandler entityDataHandler = (entityDataHandlerEvent, entityData) -> {
            VillagerData villagerData = (VillagerData)entityData.getValue();
            entityData.setTypeAndValue(Types1_13_2.ENTITY_DATA_TYPES.varIntType, this.villagerDataToProfession(villagerData));
            if (entityData.id() == 16) {
                entityDataHandlerEvent.setIndex(15);
            }
        };
        this.filter().type(EntityTypes1_14.ZOMBIE_VILLAGER).index(18).handler(entityDataHandler);
        this.filter().type(EntityTypes1_14.VILLAGER).index(16).handler(entityDataHandler);
        this.filter().type(EntityTypes1_14.ABSTRACT_SKELETON).index(13).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.getValue();
            if ((by & 4) != 0) {
                entityDataHandlerEvent.createExtraData(new EntityData(14, Types1_13_2.ENTITY_DATA_TYPES.booleanType, true));
            }
        });
        this.filter().type(EntityTypes1_14.ZOMBIE).index(13).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.getValue();
            if ((by & 4) != 0) {
                entityDataHandlerEvent.createExtraData(new EntityData(16, Types1_13_2.ENTITY_DATA_TYPES.booleanType, true));
            }
        });
        this.filter().type(EntityTypes1_14.ZOMBIE).addIndex(16);
        this.filter().type(EntityTypes1_14.LIVING_ENTITY).handler((entityDataHandlerEvent, entityData) -> {
            int n = entityDataHandlerEvent.index();
            if (n == 12) {
                BlockPosition blockPosition = (BlockPosition)entityData.getValue();
                if (blockPosition != null && entityDataHandlerEvent.entityType() == EntityTypes1_14.PLAYER) {
                    PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_13.PLAYER_SLEEP, null, entityDataHandlerEvent.user());
                    packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                    packetWrapper.write(Types.BLOCK_POSITION1_8, blockPosition);
                    packetWrapper.scheduleSend(Protocol1_14To1_13_2.class);
                }
                entityDataHandlerEvent.cancel();
            } else if (n > 12) {
                entityDataHandlerEvent.setIndex(n - 1);
            }
        });
        this.filter().removeIndex(6);
        this.filter().type(EntityTypes1_14.OCELOT).index(13).handler((entityDataHandlerEvent, entityData) -> {
            entityDataHandlerEvent.setIndex(15);
            entityData.setTypeAndValue(Types1_13_2.ENTITY_DATA_TYPES.varIntType, 0);
        });
        this.filter().type(EntityTypes1_14.CAT).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() == 15) {
                entityData.setValue(1);
            } else if (entityDataHandlerEvent.index() == 13) {
                entityData.setValue((byte)((Byte)entityData.getValue() & 4));
            }
        });
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.dataType().typeId() > 15) {
                entityDataHandlerEvent.cancel();
            }
        });
    }

    public int villagerDataToProfession(VillagerData villagerData) {
        switch (villagerData.profession()) {
            case 1: 
            case 10: 
            case 13: 
            case 14: {
                return 3;
            }
            case 2: 
            case 8: {
                return 4;
            }
            case 3: 
            case 9: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: 
            case 6: 
            case 7: 
            case 12: {
                return 0;
            }
        }
        return 5;
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_14.CAT, EntityTypes1_14.OCELOT).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.TRADER_LLAMA, EntityTypes1_14.LLAMA).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.FOX, EntityTypes1_14.WOLF).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.PANDA, EntityTypes1_14.POLAR_BEAR).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.PILLAGER, EntityTypes1_14.VILLAGER).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.WANDERING_TRADER, EntityTypes1_14.VILLAGER).jsonName();
        this.mapEntityTypeWithData(EntityTypes1_14.RAVAGER, EntityTypes1_14.COW).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_14.getTypeFromId(n);
    }
}

