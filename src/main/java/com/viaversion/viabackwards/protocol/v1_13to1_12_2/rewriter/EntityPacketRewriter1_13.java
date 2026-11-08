/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_13to1_12_2.rewriter;

import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.entities.storage.EntityPositionHandler;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.Protocol1_13To1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.EntityIdMappings1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.PaintingNames1_13;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.data.ParticleIdMappings1_12_2;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.BackwardsBlockStorage;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.NoteBlockStorage;
import com.viaversion.viabackwards.protocol.v1_13to1_12_2.storage.PlayerPositionStorage1_13;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.minecraft.Particle;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_13;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_12;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_13;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_12_2to1_13.packet.ClientboundPackets1_13;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ClientboundPackets1_12_1;
import com.viaversion.viaversion.protocols.v1_12to1_12_1.packet.ServerboundPackets1_12_1;

public class EntityPacketRewriter1_13
extends LegacyEntityRewriter<ClientboundPackets1_13, Protocol1_13To1_12_2> {
    public EntityPacketRewriter1_13(Protocol1_13To1_12_2 protocol1_13To1_12_2) {
        super(protocol1_13To1_12_2);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_POSITION, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    if (!ViaBackwards.getConfig().isFix1_13FacePlayer()) {
                        return;
                    }
                    PlayerPositionStorage1_13 playerPositionStorage1_13 = packetWrapper.user().get(PlayerPositionStorage1_13.class);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    playerPositionStorage1_13.setX(EntityPacketRewriter1_13.toSet(by, 0, playerPositionStorage1_13.x(), packetWrapper.get(Types.DOUBLE, 0)));
                    playerPositionStorage1_13.setY(EntityPacketRewriter1_13.toSet(by, 1, playerPositionStorage1_13.y(), packetWrapper.get(Types.DOUBLE, 1)));
                    playerPositionStorage1_13.setZ(EntityPacketRewriter1_13.toSet(by, 2, playerPositionStorage1_13.z(), packetWrapper.get(Types.DOUBLE, 2)));
                });
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_ENTITY, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_13.this.getObjectTrackerHandler());
                this.handler(packetWrapper -> {
                    int n;
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    EntityTypes1_13.ObjectType objectType = EntityTypes1_13.ObjectType.findById(by, n = packetWrapper.get(Types.INT, 0).intValue());
                    if (objectType == EntityTypes1_13.ObjectType.FALLING_BLOCK) {
                        int n2 = Protocol1_13To1_12_2.MAPPINGS.getNewBlockStateId(n);
                        n2 = n2 >> 4 & 0xFFF | (n2 & 0xF) << 12;
                        packetWrapper.set(Types.INT, 0, n2);
                    } else if (objectType == EntityTypes1_13.ObjectType.ITEM_FRAME) {
                        n = switch (n) {
                            case 3 -> 0;
                            case 4 -> 1;
                            case 5 -> 3;
                            default -> n;
                        };
                        packetWrapper.set(Types.INT, 0, n);
                    } else if (objectType == EntityTypes1_13.ObjectType.TRIDENT) {
                        packetWrapper.set(Types.BYTE, 0, (byte)EntityTypes1_13.ObjectType.TIPPED_ARROW.getId());
                    }
                });
            }
        });
        this.registerTracker(ClientboundPackets1_13.ADD_EXPERIENCE_ORB, EntityTypes1_13.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_13.ADD_GLOBAL_ENTITY, EntityTypes1_13.EntityType.LIGHTNING_BOLT);
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_MOB, new PacketHandlers(){

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
                this.map(Types1_13.ENTITY_DATA_LIST, Types.ENTITY_DATA_LIST1_12);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    EntityTypes1_13.EntityType entityType = EntityTypes1_13.EntityType.findById(n);
                    if (entityType == null) {
                        return;
                    }
                    EntityPacketRewriter1_13.this.tracker(packetWrapper.user()).addEntity(packetWrapper.get(Types.VAR_INT, 0), entityType);
                    int n2 = EntityIdMappings1_12_2.getOldId(n);
                    if (n2 == -1) {
                        if (!EntityPacketRewriter1_13.this.hasData(entityType)) {
                            ((Protocol1_13To1_12_2)EntityPacketRewriter1_13.this.protocol).getLogger().warning("Could not find entity type mapping " + n + "/" + String.valueOf(entityType));
                        }
                    } else {
                        packetWrapper.set(Types.VAR_INT, 1, n2);
                    }
                });
                this.handler(EntityPacketRewriter1_13.this.getMobSpawnRewriter1_11(Types.ENTITY_DATA_LIST1_12));
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types1_13.ENTITY_DATA_LIST, Types.ENTITY_DATA_LIST1_12);
                this.handler(EntityPacketRewriter1_13.this.getTrackerAndDataHandler(Types.ENTITY_DATA_LIST1_12, EntityTypes1_13.EntityType.PLAYER));
            }
        });
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityPacketRewriter1_13.this.tracker(packetWrapper.user()).addEntity(n, EntityTypes1_13.EntityType.PAINTING);
                    int n2 = packetWrapper.read(Types.VAR_INT);
                    String string = PaintingNames1_13.getStringId(n2);
                    packetWrapper.write(Types.STRING, string);
                });
            }
        });
        this.registerJoinGame(ClientboundPackets1_13.LOGIN, EntityTypes1_13.EntityType.PLAYER);
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    Object t = packetWrapper.user().getClientWorld(Protocol1_13To1_12_2.class);
                    if (((ClientWorld)t).setEnvironment(n = packetWrapper.get(Types.INT, 0).intValue())) {
                        EntityPacketRewriter1_13.this.tracker(packetWrapper.user()).clearEntities();
                        packetWrapper.user().get(BackwardsBlockStorage.class).clear();
                        packetWrapper.user().get(NoteBlockStorage.class).clear();
                    }
                });
            }
        });
        this.registerSetEntityData(ClientboundPackets1_13.SET_ENTITY_DATA, Types1_13.ENTITY_DATA_LIST, Types.ENTITY_DATA_LIST1_12);
        ((Protocol1_13To1_12_2)this.protocol).registerClientbound(ClientboundPackets1_13.PLAYER_LOOK_AT, null, packetWrapper -> {
            packetWrapper.cancel();
            if (!ViaBackwards.getConfig().isFix1_13FacePlayer()) {
                return;
            }
            int n = packetWrapper.read(Types.VAR_INT);
            double d = packetWrapper.read(Types.DOUBLE);
            double d2 = packetWrapper.read(Types.DOUBLE);
            double d3 = packetWrapper.read(Types.DOUBLE);
            PlayerPositionStorage1_13 playerPositionStorage1_13 = packetWrapper.user().get(PlayerPositionStorage1_13.class);
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_12_1.PLAYER_POSITION);
            packetWrapper2.write(Types.DOUBLE, 0.0);
            packetWrapper2.write(Types.DOUBLE, 0.0);
            packetWrapper2.write(Types.DOUBLE, 0.0);
            EntityPositionHandler.writeFacingDegrees(packetWrapper2, playerPositionStorage1_13.x(), n == 1 ? playerPositionStorage1_13.y() + 1.62 : playerPositionStorage1_13.y(), playerPositionStorage1_13.z(), d, d2, d3);
            packetWrapper2.write(Types.BYTE, (byte)7);
            packetWrapper2.write(Types.VAR_INT, -1);
            packetWrapper2.send(Protocol1_13To1_12_2.class);
        });
        PacketHandler packetHandler = packetWrapper -> {
            if (!ViaBackwards.getConfig().isFix1_13FacePlayer()) {
                return;
            }
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.user().get(PlayerPositionStorage1_13.class).setPosition(d, d2, d3);
        };
        ((Protocol1_13To1_12_2)this.protocol).registerServerbound(ServerboundPackets1_12_1.MOVE_PLAYER_POS, packetHandler);
        ((Protocol1_13To1_12_2)this.protocol).registerServerbound(ServerboundPackets1_12_1.MOVE_PLAYER_POS_ROT, packetHandler);
        ((Protocol1_13To1_12_2)this.protocol).registerServerbound(ServerboundPackets1_12_1.MOVE_VEHICLE, packetHandler);
    }

    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.DROWNED, EntityTypes1_13.EntityType.ZOMBIE_VILLAGER).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.COD, EntityTypes1_13.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.SALMON, EntityTypes1_13.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.PUFFERFISH, EntityTypes1_13.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.TROPICAL_FISH, EntityTypes1_13.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.PHANTOM, EntityTypes1_13.EntityType.PARROT).plainName().spawnEntityData(wrappedEntityData -> wrappedEntityData.add(new EntityData(15, EntityDataTypes1_12.VAR_INT, 3)));
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.DOLPHIN, EntityTypes1_13.EntityType.SQUID).plainName();
        this.mapEntityTypeWithData(EntityTypes1_13.EntityType.TURTLE, EntityTypes1_13.EntityType.OCELOT).plainName();
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n = entityData.dataType().typeId();
            if (n == 4) {
                JsonElement jsonElement = (JsonElement)entityData.value();
                ((Protocol1_13To1_12_2)this.protocol).translatableRewriter().processText(entityDataHandlerEvent.user(), jsonElement);
                entityData.setDataType(EntityDataTypes1_12.COMPONENT);
            } else if (n == 5) {
                JsonElement jsonElement = (JsonElement)entityData.value();
                entityData.setTypeAndValue(EntityDataTypes1_12.STRING, ((Protocol1_13To1_12_2)this.protocol).jsonToLegacy(entityDataHandlerEvent.user(), jsonElement));
            } else if (n == 6) {
                Item item = (Item)entityData.getValue();
                entityData.setTypeAndValue(EntityDataTypes1_12.ITEM, ((Protocol1_13To1_12_2)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), item));
            } else if (n == 15) {
                entityDataHandlerEvent.cancel();
            } else {
                entityData.setDataType(EntityDataTypes1_12.byId(n > 5 ? n - 1 : n));
            }
        });
        this.filter().type(EntityTypes1_13.EntityType.ZOMBIE).removeIndex(15);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(13);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(14);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(15);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(16);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(17);
        this.filter().type(EntityTypes1_13.EntityType.TURTLE).cancel(18);
        this.filter().type(EntityTypes1_13.EntityType.ABSTRACT_FISH).cancel(12);
        this.filter().type(EntityTypes1_13.EntityType.ABSTRACT_FISH).cancel(13);
        this.filter().type(EntityTypes1_13.EntityType.PHANTOM).cancel(12);
        this.filter().type(EntityTypes1_13.EntityType.BOAT).cancel(12);
        this.filter().type(EntityTypes1_13.EntityType.TRIDENT).cancel(7);
        this.filter().type(EntityTypes1_13.EntityType.WOLF).index(17).handler((entityDataHandlerEvent, entityData) -> entityData.setValue(15 - (Integer)entityData.getValue()));
        this.filter().type(EntityTypes1_13.EntityType.AREA_EFFECT_CLOUD).index(9).handler((entityDataHandlerEvent, entityData) -> {
            Particle particle = (Particle)entityData.getValue();
            ParticleIdMappings1_12_2.ParticleData particleData = ParticleIdMappings1_12_2.getMapping(particle.id());
            int n = 0;
            int n2 = 0;
            int[] nArray = particleData.rewriteMeta((Protocol1_13To1_12_2)this.protocol, particle.getArguments());
            if (nArray != null && nArray.length != 0) {
                if (particleData.getHandler().isBlockHandler() && nArray[0] == 0) {
                    nArray[0] = 102;
                }
                n = nArray[0];
                n2 = nArray.length == 2 ? nArray[1] : 0;
            }
            entityDataHandlerEvent.createExtraData(new EntityData(9, EntityDataTypes1_12.VAR_INT, particleData.getHistoryId()));
            entityDataHandlerEvent.createExtraData(new EntityData(10, EntityDataTypes1_12.VAR_INT, n));
            entityDataHandlerEvent.createExtraData(new EntityData(11, EntityDataTypes1_12.VAR_INT, n2));
            entityDataHandlerEvent.cancel();
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_13.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_13.ObjectType.getEntityType(n, n2);
    }

    @Override
    public int newEntityId(int n) {
        return EntityIdMappings1_12_2.getOldId(n);
    }

    private static double toSet(int n, int n2, double d, double d2) {
        return (n & 1 << n2) != 0 ? d + d2 : d2;
    }
}

