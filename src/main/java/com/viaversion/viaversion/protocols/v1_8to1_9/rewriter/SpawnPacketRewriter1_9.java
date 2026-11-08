/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_8;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.minecraft.item.DataItem;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import java.util.ArrayList;
import java.util.List;

public class SpawnPacketRewriter1_9 {
    public static final ValueTransformer<Integer, Double> toNewDouble = new ValueTransformer<Integer, Double>((Type)Types.DOUBLE){

        @Override
        public Double transform(PacketWrapper packetWrapper, Integer n) {
            return (double)n.intValue() / 32.0;
        }
    };

    public static void register(final Protocol1_8To1_9 protocol1_8To1_9) {
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    packetWrapper.write(Types.UUID, entityTracker1_9.getEntityUUID(n));
                });
                this.map(Types.BYTE);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    int n2 = packetWrapper.get(Types.INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    EntityTypes1_9.EntityType entityType = EntityTypes1_9.ObjectType.getEntityType(by, n2);
                    if (entityType != null) {
                        entityTracker1_9.addEntity(n, entityType);
                    }
                });
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.INT, 0);
                    short s = 0;
                    short s2 = 0;
                    short s3 = 0;
                    if (n > 0) {
                        s = packetWrapper.read(Types.SHORT);
                        s2 = packetWrapper.read(Types.SHORT);
                        s3 = packetWrapper.read(Types.SHORT);
                    }
                    packetWrapper.write(Types.SHORT, s);
                    packetWrapper.write(Types.SHORT, s2);
                    packetWrapper.write(Types.SHORT, s3);
                });
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.INT, 0);
                    byte by = packetWrapper.get(Types.BYTE, 0);
                    if (EntityTypes1_8.ObjectType.findById(by, n2) == EntityTypes1_8.ObjectType.POTION) {
                        PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_9.SET_ENTITY_DATA, packetWrapper2 -> {
                            packetWrapper2.write(Types.VAR_INT, n);
                            ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                            DataItem dataItem = new DataItem(373, 1, (short)n2, null);
                            protocol1_8To1_9.getItemRewriter().handleItemToClient(packetWrapper.user(), dataItem);
                            EntityData entityData = new EntityData(6, EntityDataTypes1_9.ITEM, dataItem);
                            arrayList.add(entityData);
                            packetWrapper2.write(Types.ENTITY_DATA_LIST1_9, arrayList);
                        });
                        packetWrapper.send(Protocol1_8To1_9.class);
                        packetWrapper3.send(Protocol1_8To1_9.class);
                        packetWrapper.cancel();
                    }
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_EXPERIENCE_ORB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addEntity(n, EntityTypes1_9.EntityType.EXPERIENCE_ORB);
                });
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.SHORT);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_GLOBAL_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addEntity(n, EntityTypes1_9.EntityType.LIGHTNING_BOLT);
                });
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_MOB, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    packetWrapper.write(Types.UUID, entityTracker1_9.getEntityUUID(n));
                });
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    short s = packetWrapper.get(Types.UNSIGNED_BYTE, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    EntityTypes1_9.EntityType entityType = EntityTypes1_9.EntityType.findById(s);
                    if (entityType != null) {
                        entityTracker1_9.addEntity(n, entityType);
                    }
                });
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.SHORT);
                this.map(Types.ENTITY_DATA_LIST1_8, Types.ENTITY_DATA_LIST1_9);
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (entityTracker1_9.hasEntity(n)) {
                        protocol1_8To1_9.getEntityRewriter().handleEntityData(n, list, packetWrapper.user());
                    } else {
                        protocol1_8To1_9.getLogger().warning("Unable to find entity for entity data, entity ID: " + n);
                        list.clear();
                    }
                });
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.handleEntityData(n, list);
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_PAINTING, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addEntity(n, EntityTypes1_9.EntityType.PAINTING);
                });
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    packetWrapper.write(Types.UUID, entityTracker1_9.getEntityUUID(n));
                });
                this.map(Types.STRING);
                this.map(Types.BLOCK_POSITION1_8);
                this.map(Types.BYTE);
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.addEntity(n, EntityTypes1_9.EntityType.PLAYER);
                });
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.INT, toNewDouble);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.SHORT);
                    if (s != 0) {
                        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_9.SET_EQUIPPED_ITEM, null, packetWrapper.user());
                        packetWrapper2.write(Types.VAR_INT, packetWrapper.get(Types.VAR_INT, 0));
                        packetWrapper2.write(Types.VAR_INT, 0);
                        packetWrapper2.write(Types.ITEM1_8, new DataItem(s, 1, 0, null));
                        packetWrapper2.send(Protocol1_8To1_9.class);
                    }
                });
                this.map(Types.ENTITY_DATA_LIST1_8, Types.ENTITY_DATA_LIST1_9);
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (entityTracker1_9.hasEntity(n)) {
                        protocol1_8To1_9.getEntityRewriter().handleEntityData(n, list, packetWrapper.user());
                    } else {
                        protocol1_8To1_9.getLogger().warning("Unable to find entity for entity data, entity ID: " + n);
                        list.clear();
                    }
                });
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.handleEntityData(n, list);
                });
            }
        });
        protocol1_8To1_9.registerClientbound(ClientboundPackets1_8.REMOVE_ENTITIES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT_ARRAY_PRIMITIVE);
                this.handler(packetWrapper -> {
                    int[] nArray = packetWrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0);
                    Object t = packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    for (int n : nArray) {
                        t.removeEntity(n);
                    }
                });
            }
        });
    }
}

