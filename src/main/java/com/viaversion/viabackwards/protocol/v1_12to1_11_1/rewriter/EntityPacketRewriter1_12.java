/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_12to1_11_1.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viabackwards.api.rewriters.LegacyEntityRewriter;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.Protocol1_12To1_11_1;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.storage.ParrotStorage;
import com.viaversion.viabackwards.protocol.v1_12to1_11_1.storage.ShoulderTracker;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_12;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_12;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.protocols.v1_11_1to1_12.packet.ClientboundPackets1_12;
import com.viaversion.viaversion.protocols.v1_9_1to1_9_3.packet.ClientboundPackets1_9_3;

public class EntityPacketRewriter1_12
extends LegacyEntityRewriter<ClientboundPackets1_12, Protocol1_12To1_11_1> {
    public EntityPacketRewriter1_12(Protocol1_12To1_11_1 protocol1_12To1_11_1) {
        super(protocol1_12To1_11_1);
    }

    @Override
    protected void registerPackets() {
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.ADD_ENTITY, new PacketHandlers(){

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
                this.handler(EntityPacketRewriter1_12.this.getObjectTrackerHandler());
                this.handler(EntityPacketRewriter1_12.this.getObjectRewriter(EntityTypes1_12.ObjectType::findById));
                this.handler(((Protocol1_12To1_11_1)EntityPacketRewriter1_12.this.protocol).getItemRewriter().getFallingBlockHandler());
            }
        });
        this.registerTracker(ClientboundPackets1_12.ADD_EXPERIENCE_ORB, EntityTypes1_12.EntityType.EXPERIENCE_ORB);
        this.registerTracker(ClientboundPackets1_12.ADD_GLOBAL_ENTITY, EntityTypes1_12.EntityType.LIGHTNING_BOLT);
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.ADD_MOB, new PacketHandlers(){

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
                this.map(Types.ENTITY_DATA_LIST1_12, Types.ENTITY_DATA_LIST1_9);
                this.handler(EntityPacketRewriter1_12.this.getTrackerHandler());
                this.handler(EntityPacketRewriter1_12.this.getMobSpawnRewriter1_11(Types.ENTITY_DATA_LIST1_9));
            }
        });
        this.registerTracker(ClientboundPackets1_12.ADD_PAINTING, EntityTypes1_12.EntityType.PAINTING);
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.ADD_PLAYER, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.UUID);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.ENTITY_DATA_LIST1_12, Types.ENTITY_DATA_LIST1_9);
                this.handler(EntityPacketRewriter1_12.this.getTrackerAndDataHandler(Types.ENTITY_DATA_LIST1_9, EntityTypes1_12.EntityType.PLAYER));
            }
        });
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.UNSIGNED_BYTE);
                this.map(Types.INT);
                this.handler(EntityPacketRewriter1_12.this.getDimensionHandler(1));
                this.handler(EntityPacketRewriter1_12.this.playerTrackerHandler());
                this.handler(packetWrapper -> {
                    ShoulderTracker shoulderTracker = packetWrapper.user().get(ShoulderTracker.class);
                    shoulderTracker.setEntityId(packetWrapper.get(Types.INT, 0));
                });
                this.handler(packetWrapper -> {
                    PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_9_3.AWARD_STATS, packetWrapper.user());
                    packetWrapper2.write(Types.VAR_INT, 1);
                    packetWrapper2.write(Types.STRING, "achievement.openInventory");
                    packetWrapper2.write(Types.VAR_INT, 1);
                    packetWrapper2.scheduleSend(Protocol1_12To1_11_1.class);
                });
            }
        });
        this.registerRespawn(ClientboundPackets1_12.RESPAWN);
        this.registerRemoveEntities(ClientboundPackets1_12.REMOVE_ENTITIES);
        this.registerSetEntityData(ClientboundPackets1_12.SET_ENTITY_DATA, Types.ENTITY_DATA_LIST1_12, Types.ENTITY_DATA_LIST1_9);
        ((Protocol1_12To1_11_1)this.protocol).registerClientbound(ClientboundPackets1_12.UPDATE_ATTRIBUTES, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.map(Types.INT);
                this.handler(packetWrapper -> {
                    int n;
                    int n2 = n = packetWrapper.get(Types.INT, 0).intValue();
                    for (int i = 0; i < n; ++i) {
                        int n3;
                        int n4;
                        String string = packetWrapper.read(Types.STRING);
                        if (string.equals("generic.flyingSpeed")) {
                            --n2;
                            packetWrapper.read(Types.DOUBLE);
                            n4 = packetWrapper.read(Types.VAR_INT);
                            for (n3 = 0; n3 < n4; ++n3) {
                                packetWrapper.read(Types.UUID);
                                packetWrapper.read(Types.DOUBLE);
                                packetWrapper.read(Types.BYTE);
                            }
                            continue;
                        }
                        packetWrapper.write(Types.STRING, string);
                        packetWrapper.passthrough(Types.DOUBLE);
                        n4 = packetWrapper.passthrough(Types.VAR_INT);
                        for (n3 = 0; n3 < n4; ++n3) {
                            packetWrapper.passthrough(Types.UUID);
                            packetWrapper.passthrough(Types.DOUBLE);
                            packetWrapper.passthrough(Types.BYTE);
                        }
                    }
                    if (n2 != n) {
                        packetWrapper.set(Types.INT, 0, n2);
                    }
                });
            }
        });
    }

    @Override
    protected void registerRewrites() {
        this.mapEntityTypeWithData(EntityTypes1_12.EntityType.PARROT, EntityTypes1_12.EntityType.BAT).plainName().spawnEntityData(wrappedEntityData -> wrappedEntityData.add(new EntityData(12, EntityDataTypes1_12.BYTE, (byte)0)));
        this.mapEntityTypeWithData(EntityTypes1_12.EntityType.ILLUSIONER, EntityTypes1_12.EntityType.EVOKER).plainName();
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            if (entityData.dataType() == EntityDataTypes1_12.COMPONENT) {
                ((Protocol1_12To1_11_1)this.protocol).getComponentRewriter().processText(entityDataHandlerEvent.user(), (JsonElement)entityData.getValue());
            }
        });
        this.filter().type(EntityTypes1_12.EntityType.EVOKER).removeIndex(12);
        this.filter().type(EntityTypes1_12.EntityType.ILLUSIONER).index(0).handler((entityDataHandlerEvent, entityData) -> {
            byte by = (Byte)entityData.getValue();
            if ((by & 0x20) == 32) {
                by = (byte)(by & 0xFFFFFFDF);
            }
            entityData.setValue(by);
        });
        this.filter().type(EntityTypes1_12.EntityType.PARROT).handler((entityDataHandlerEvent, entityData) -> {
            if (!entityDataHandlerEvent.trackedEntity().has(ParrotStorage.class)) {
                entityDataHandlerEvent.trackedEntity().put(new ParrotStorage());
            }
        });
        this.filter().type(EntityTypes1_12.EntityType.PARROT).cancel(12);
        this.filter().type(EntityTypes1_12.EntityType.PARROT).index(13).handler((entityDataHandlerEvent, entityData) -> {
            boolean bl;
            ParrotStorage parrotStorage = entityDataHandlerEvent.trackedEntity().get(ParrotStorage.class);
            boolean bl2 = ((Byte)entityData.getValue() & 1) == 1;
            boolean bl3 = bl = ((Byte)entityData.getValue() & 4) == 4;
            if (parrotStorage.isTamed() || bl) {
                // empty if block
            }
            parrotStorage.setTamed(bl);
            if (bl2) {
                entityDataHandlerEvent.setIndex(12);
                entityData.setValue((byte)1);
                parrotStorage.setSitting(true);
            } else if (parrotStorage.isSitting()) {
                entityDataHandlerEvent.setIndex(12);
                entityData.setValue((byte)0);
                parrotStorage.setSitting(false);
            } else {
                entityDataHandlerEvent.cancel();
            }
        });
        this.filter().type(EntityTypes1_12.EntityType.PARROT).cancel(14);
        this.filter().type(EntityTypes1_12.EntityType.PARROT).cancel(15);
        this.filter().type(EntityTypes1_12.EntityType.PLAYER).index(15).handler((entityDataHandlerEvent, entityData) -> {
            CompoundTag compoundTag = (CompoundTag)entityData.getValue();
            ShoulderTracker shoulderTracker = entityDataHandlerEvent.user().get(ShoulderTracker.class);
            if (compoundTag.isEmpty() && shoulderTracker.getLeftShoulder() != null) {
                shoulderTracker.setLeftShoulder(null);
                shoulderTracker.update();
            } else if (compoundTag.getStringTag("id") != null && entityDataHandlerEvent.entityId() == shoulderTracker.getEntityId()) {
                String string = compoundTag.getStringTag("id").getValue();
                if (shoulderTracker.getLeftShoulder() == null || !shoulderTracker.getLeftShoulder().equals(string)) {
                    shoulderTracker.setLeftShoulder(string);
                    shoulderTracker.update();
                }
            }
            entityDataHandlerEvent.cancel();
        });
        this.filter().type(EntityTypes1_12.EntityType.PLAYER).index(16).handler((entityDataHandlerEvent, entityData) -> {
            CompoundTag compoundTag = (CompoundTag)entityDataHandlerEvent.data().getValue();
            ShoulderTracker shoulderTracker = entityDataHandlerEvent.user().get(ShoulderTracker.class);
            if (compoundTag.isEmpty() && shoulderTracker.getRightShoulder() != null) {
                shoulderTracker.setRightShoulder(null);
                shoulderTracker.update();
            } else if (compoundTag.getStringTag("id") != null && entityDataHandlerEvent.entityId() == shoulderTracker.getEntityId()) {
                String string = compoundTag.getStringTag("id").getValue();
                if (shoulderTracker.getRightShoulder() == null || !shoulderTracker.getRightShoulder().equals(string)) {
                    shoulderTracker.setRightShoulder(string);
                    shoulderTracker.update();
                }
            }
            entityDataHandlerEvent.cancel();
        });
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_12.EntityType.findById(n);
    }

    @Override
    public EntityType objectTypeFromId(int n, int n2) {
        return EntityTypes1_12.ObjectType.getEntityType(n, n2);
    }
}

