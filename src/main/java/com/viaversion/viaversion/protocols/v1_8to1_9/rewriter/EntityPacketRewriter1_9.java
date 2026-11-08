/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.rewriter;

import com.google.common.collect.ImmutableList;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.minecraft.EulerAngle;
import com.viaversion.viaversion.api.minecraft.Vector;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_9;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.protocol.remapper.ValueTransformer;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.data.EntityDataIndex1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ServerboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.rewriter.SpawnPacketRewriter1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEvent;
import com.viaversion.viaversion.util.ComponentUtil;
import com.viaversion.viaversion.util.Pair;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.Triple;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EntityPacketRewriter1_9
extends EntityRewriter<ClientboundPackets1_8, Protocol1_8To1_9> {
    public static final ValueTransformer<Byte, Short> toNewShort = new ValueTransformer<Byte, Short>((Type)Types.SHORT){

        @Override
        public Short transform(PacketWrapper packetWrapper, Byte by) {
            return (short)(by * 128);
        }
    };

    public EntityPacketRewriter1_9(Protocol1_8To1_9 protocol1_8To1_9) {
        super(protocol1_8To1_9);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.SET_ENTITY_LINK, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    short s = packetWrapper.read(Types.UNSIGNED_BYTE);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (s == 0) {
                        int n = packetWrapper.get(Types.INT, 0);
                        int n2 = packetWrapper.get(Types.INT, 1);
                        packetWrapper.cancel();
                        PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundPackets1_9.SET_PASSENGERS);
                        if (n2 == -1) {
                            if (!entityTracker1_9.getVehicleMap().containsKey(n)) {
                                return;
                            }
                            packetWrapper2.write(Types.VAR_INT, entityTracker1_9.getVehicleMap().remove(n));
                            packetWrapper2.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[0]);
                        } else {
                            packetWrapper2.write(Types.VAR_INT, n2);
                            packetWrapper2.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{n});
                            entityTracker1_9.getVehicleMap().put(n, n2);
                        }
                        packetWrapper2.send(Protocol1_8To1_9.class);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.TELEPORT_ENTITY, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.INT, SpawnPacketRewriter1_9.toNewDouble);
                this.map(Types.INT, SpawnPacketRewriter1_9.toNewDouble);
                this.map(Types.INT, SpawnPacketRewriter1_9.toNewDouble);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    if (Via.getConfig().isHologramPatch() && (entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class)).getKnownHolograms().contains(n)) {
                        Double d = packetWrapper.get(Types.DOUBLE, 1);
                        d = d + Via.getConfig().getHologramYOffset();
                        packetWrapper.set(Types.DOUBLE, 1, d);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY_POS_ROT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.MOVE_ENTITY_POS, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BYTE, toNewShort);
                this.map(Types.BOOLEAN);
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.SET_EQUIPPED_ITEM, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.SHORT, new ValueTransformer<Short, Integer>((Type)Types.VAR_INT){

                    @Override
                    public Integer transform(PacketWrapper packetWrapper, Short s) {
                        int n = packetWrapper.get(Types.VAR_INT, 0);
                        int n2 = packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class).clientEntityId();
                        if (s < 0 || s > 4 || n == n2 && s > 3) {
                            packetWrapper.cancel();
                            return 0;
                        }
                        if (n == n2) {
                            return s.intValue() + 2;
                        }
                        return s > 0 ? s.intValue() + 1 : s.intValue();
                    }
                });
                this.map(Types.ITEM1_8);
                this.handler(packetWrapper -> {
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    ((Protocol1_8To1_9)EntityPacketRewriter1_9.this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), item);
                });
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    Item item = packetWrapper.get(Types.ITEM1_8, 0);
                    if (item != null && Protocol1_8To1_9.isSword(item.identifier())) {
                        entityTracker1_9.getValidBlocking().add(n);
                        return;
                    }
                    entityTracker1_9.getValidBlocking().remove(n);
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.SET_ENTITY_DATA, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.ENTITY_DATA_LIST1_8, Types.ENTITY_DATA_LIST1_9);
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (entityTracker1_9.hasEntity(n)) {
                        EntityPacketRewriter1_9.this.handleEntityData(n, list, packetWrapper.user());
                    } else {
                        packetWrapper.cancel();
                    }
                });
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    entityTracker1_9.handleEntityData(n, list);
                });
                this.handler(packetWrapper -> {
                    List<EntityData> list = packetWrapper.get(Types.ENTITY_DATA_LIST1_9, 0);
                    if (list.isEmpty()) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.UPDATE_MOB_EFFECT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    boolean bl = packetWrapper.read(Types.BOOLEAN);
                    boolean bl2 = Via.getConfig().isNewEffectIndicator();
                    packetWrapper.write(Types.BYTE, (byte)(bl ? (bl2 ? 2 : 1) : 0));
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).cancelClientbound(ClientboundPackets1_8.UPDATE_ENTITY_NBT);
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.PLAYER_COMBAT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.VAR_INT, 0) == 2) {
                        packetWrapper.passthrough(Types.VAR_INT);
                        packetWrapper.passthrough(Types.INT);
                        Protocol1_8To1_9.STRING_TO_JSON.write(packetWrapper, packetWrapper.read(Types.STRING));
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)packetWrapper.user().getEntityTracker(Protocol1_8To1_9.class);
                    if (packetWrapper.get(Types.VAR_INT, 0).intValue() != entityTracker1_9.getProvidedEntityId()) {
                        return;
                    }
                    int n = packetWrapper.read(Types.INT);
                    HashMap<String, Pair<Double, AbstractCollection>> hashMap = new HashMap<String, Pair<Double, AbstractCollection>>(n);
                    for (int i = 0; i < n; ++i) {
                        String object = packetWrapper.read(Types.STRING);
                        Double d = packetWrapper.read(Types.DOUBLE);
                        int n2 = packetWrapper.read(Types.VAR_INT);
                        ArrayList<Triple<UUID, Double, Byte>> arrayList = new ArrayList<Triple<UUID, Double, Byte>>(n2);
                        for (int j = 0; j < n2; ++j) {
                            arrayList.add(new Triple<UUID, Double, Byte>(packetWrapper.read(Types.UUID), packetWrapper.read(Types.DOUBLE), packetWrapper.read(Types.BYTE)));
                        }
                        hashMap.put(object, new Pair(d, arrayList));
                    }
                    hashMap.put("generic.attackSpeed", new Pair<Double, ImmutableList<Triple<UUID, Double, Byte>>>(20.0, ImmutableList.of(new Triple<UUID, Double, Byte>(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"), 0.0, (byte)0), new Triple<UUID, Double, Byte>(UUID.fromString("AF8B6E3F-3328-4C0A-AA36-5BA2BB9DBEF3"), 0.0, (byte)2), new Triple<UUID, Double, Byte>(UUID.fromString("55FCED67-E92A-486E-9800-B47F202C4386"), 0.0, (byte)2))));
                    packetWrapper.write(Types.INT, hashMap.size());
                    for (Map.Entry entry : hashMap.entrySet()) {
                        packetWrapper.write(Types.STRING, (String)entry.getKey());
                        packetWrapper.write(Types.DOUBLE, (Double)((Pair)entry.getValue()).key());
                        packetWrapper.write(Types.VAR_INT, ((List)((Pair)entry.getValue()).value()).size());
                        for (Triple triple : (List)((Pair)entry.getValue()).value()) {
                            packetWrapper.write(Types.UUID, (UUID)triple.first());
                            packetWrapper.write(Types.DOUBLE, (Double)triple.second());
                            packetWrapper.write(Types.BYTE, (Byte)triple.third());
                        }
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerClientbound(ClientboundPackets1_8.ANIMATE, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UNSIGNED_BYTE);
                this.handler(packetWrapper -> {
                    if (packetWrapper.get(Types.UNSIGNED_BYTE, 0) == 3) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.PLAYER_COMMAND, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n = packetWrapper.get(Types.VAR_INT, 1);
                    if (n == 6 || n == 8) {
                        packetWrapper.cancel();
                    }
                    if (n == 7) {
                        packetWrapper.set(Types.VAR_INT, 1, 6);
                    }
                });
            }
        });
        ((Protocol1_8To1_9)this.protocol).registerServerbound(ServerboundPackets1_9.INTERACT, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    if (n2 == 2) {
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                        packetWrapper.passthrough(Types.FLOAT);
                    }
                    if ((n2 == 0 || n2 == 2) && (n = packetWrapper.read(Types.VAR_INT).intValue()) == 1) {
                        packetWrapper.cancel();
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.filter().handler(this::handleEntityData);
    }

    private void handleEntityData(EntityDataHandlerEvent entityDataHandlerEvent, EntityData entityData) {
        EntityType entityType = entityDataHandlerEvent.entityType();
        EntityDataIndex1_9 entityDataIndex1_9 = EntityDataIndex1_9.searchIndex(entityType, entityData.id());
        if (entityDataIndex1_9 == null) {
            entityDataHandlerEvent.cancel();
            return;
        }
        if (entityDataIndex1_9.getNewType() == null) {
            entityDataHandlerEvent.cancel();
            return;
        }
        entityData.setId(entityDataIndex1_9.getNewIndex());
        entityData.setDataTypeUnsafe(entityDataIndex1_9.getNewType());
        Object object = entityData.getValue();
        switch (entityDataIndex1_9.getNewType()) {
            case BYTE: {
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.BYTE) {
                    entityData.setValue(object);
                }
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.INT) {
                    entityData.setValue(((Integer)object).byteValue());
                }
                if (entityDataIndex1_9 != EntityDataIndex1_9.ENTITY_STATUS || entityType != EntityTypes1_9.EntityType.PLAYER) break;
                byte by = 0;
                if (((Byte)object & 0x10) == 16) {
                    by = 1;
                }
                int n = EntityDataIndex1_9.PLAYER_HAND.getNewIndex();
                EntityDataTypes1_9 entityDataTypes1_9 = EntityDataIndex1_9.PLAYER_HAND.getNewType();
                entityDataHandlerEvent.createExtraData(new EntityData(n, entityDataTypes1_9, by));
                break;
            }
            case OPTIONAL_UUID: {
                String string = (String)object;
                UUID uUID = null;
                if (!string.isEmpty()) {
                    try {
                        uUID = UUID.fromString(string);
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }
                entityData.setValue(uUID);
                break;
            }
            case VAR_INT: {
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.BYTE) {
                    entityData.setValue(((Byte)object).intValue());
                }
                if (entityDataIndex1_9.getOldType() == EntityDataTypes1_8.SHORT) {
                    entityData.setValue(((Short)object).intValue());
                }
                if (entityDataIndex1_9.getOldType() != EntityDataTypes1_8.INT) break;
                entityData.setValue(object);
                break;
            }
            case FLOAT: 
            case STRING: {
                entityData.setValue(object);
                break;
            }
            case BOOLEAN: {
                if (entityDataIndex1_9 == EntityDataIndex1_9.ABSTRACT_AGEABLE_AGE) {
                    entityData.setValue((Byte)object < 0);
                    break;
                }
                entityData.setValue((Byte)object != 0);
                break;
            }
            case ITEM: {
                entityData.setValue(object);
                ((Protocol1_8To1_9)this.protocol).getItemRewriter().handleItemToClient(entityDataHandlerEvent.user(), (Item)entityData.getValue());
                break;
            }
            case BLOCK_POSITION: {
                Vector vector = (Vector)object;
                entityData.setValue(vector);
                break;
            }
            case ROTATIONS: {
                EulerAngle eulerAngle = (EulerAngle)object;
                entityData.setValue(eulerAngle);
                break;
            }
            case COMPONENT: {
                String string = (String)object;
                entityData.setValue(ComponentUtil.convertJsonOrEmpty(string, SerializerVersion.V1_8, SerializerVersion.V1_9));
                break;
            }
            case OPTIONAL_BLOCK_STATE: {
                entityData.setValue(((Number)object).intValue());
                break;
            }
            default: {
                throw new RuntimeException("Unhandled EntityDataType: " + String.valueOf(entityDataIndex1_9.getNewType()));
            }
        }
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_9.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_9.ObjectType.getEntityType(n, n2);
    }
}

