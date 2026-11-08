/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.ListTag;
import com.viaversion.nbt.tag.NumberTag;
import com.viaversion.viabackwards.ViaBackwards;
import com.viaversion.viabackwards.api.entities.storage.EntityReplacement;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.Protocol1_19_4To1_19_3;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage.EntityTracker1_19_4;
import com.viaversion.viabackwards.protocol.v1_19_4to1_19_3.storage.LinkedEntityStorage;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_3;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_19_4;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandler;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_19_3;
import com.viaversion.viaversion.api.type.types.version.Types1_19_4;
import com.viaversion.viaversion.libs.fastutil.ints.IntArrayList;
import com.viaversion.viaversion.libs.gson.JsonElement;
import com.viaversion.viaversion.libs.gson.JsonPrimitive;
import com.viaversion.viaversion.libs.mcstructs.text.TextComponent;
import com.viaversion.viaversion.libs.mcstructs.text.utils.TextUtils;
import com.viaversion.viaversion.protocols.v1_19_1to1_19_3.packet.ClientboundPackets1_19_3;
import com.viaversion.viaversion.protocols.v1_19_3to1_19_4.packet.ClientboundPackets1_19_4;
import com.viaversion.viaversion.util.SerializerVersion;
import com.viaversion.viaversion.util.TagUtil;
import java.util.ArrayList;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityPacketRewriter1_19_4
extends EntityRewriter<ClientboundPackets1_19_4, Protocol1_19_4To1_19_3> {
    private static final double TEXT_DISPLAY_LINE_HEIGHT = 0.25;

    public EntityPacketRewriter1_19_4(Protocol1_19_4To1_19_3 protocol1_19_4To1_19_3) {
        super(protocol1_19_4To1_19_3, Types1_19_3.ENTITY_DATA_TYPES.optionalComponentType, Types1_19_3.ENTITY_DATA_TYPES.booleanType);
    }

    @Override
    public void registerPackets() {
        this.registerSetEntityData(ClientboundPackets1_19_4.SET_ENTITY_DATA, Types1_19_4.ENTITY_DATA_LIST, Types1_19_3.ENTITY_DATA_LIST);
        ((Protocol1_19_4To1_19_3)this.protocol).replaceClientbound(ClientboundPackets1_19_4.ADD_ENTITY, new PacketHandlers(){

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
                this.map(Types.VAR_INT);
                this.handler(packetWrapper -> {
                    TrackedEntity trackedEntity;
                    int n = packetWrapper.get(Types.VAR_INT, 0);
                    int n2 = packetWrapper.get(Types.VAR_INT, 1);
                    if (!(ViaBackwards.getConfig().mapDisplayEntities() || n2 != EntityTypes1_19_4.BLOCK_DISPLAY.getId() && n2 != EntityTypes1_19_4.ITEM_DISPLAY.getId() && n2 != EntityTypes1_19_4.TEXT_DISPLAY.getId())) {
                        packetWrapper.cancel();
                        return;
                    }
                    double d = packetWrapper.get(Types.DOUBLE, 1);
                    if (n2 == EntityTypes1_19_4.TEXT_DISPLAY.getId()) {
                        packetWrapper.set(Types.DOUBLE, 1, d - 0.25);
                    }
                    if ((trackedEntity = EntityPacketRewriter1_19_4.this.trackAndRewrite(packetWrapper, n2, n)).entityType() == EntityTypes1_19_4.FALLING_BLOCK) {
                        int n3 = packetWrapper.get(Types.VAR_INT, 2);
                        packetWrapper.set(Types.VAR_INT, 2, ((Protocol1_19_4To1_19_3)EntityPacketRewriter1_19_4.this.protocol).getMappingData().getNewBlockStateId(n3));
                    }
                    LinkedEntityStorage linkedEntityStorage = new LinkedEntityStorage();
                    double d2 = packetWrapper.get(Types.DOUBLE, 0);
                    double d3 = packetWrapper.get(Types.DOUBLE, 2);
                    linkedEntityStorage.setPosition(d2, d, d3);
                    trackedEntity.put(linkedEntityStorage);
                });
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.ADD_PLAYER, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.UUID);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(packetWrapper.user());
            TrackedEntity trackedEntity = entityTracker1_19_4.addEntity(n, EntityTypes1_19_4.PLAYER);
            LinkedEntityStorage linkedEntityStorage = new LinkedEntityStorage();
            linkedEntityStorage.setPosition(d, d2, d3);
            trackedEntity.put(linkedEntityStorage);
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.STRING_ARRAY);
                this.map(Types.NAMED_COMPOUND_TAG);
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_4.this.dimensionDataHandler());
                this.handler(EntityPacketRewriter1_19_4.this.biomeSizeTracker());
                this.handler(EntityPacketRewriter1_19_4.this.worldDataTrackerHandlerByKey());
                this.handler(packetWrapper -> {
                    CompoundTag compoundTag = packetWrapper.get(Types.NAMED_COMPOUND_TAG, 0);
                    TagUtil.removeNamespaced(compoundTag, "trim_pattern");
                    TagUtil.removeNamespaced(compoundTag, "trim_material");
                    TagUtil.removeNamespaced(compoundTag, "damage_type");
                    ListTag<CompoundTag> listTag = TagUtil.getRegistryEntries(compoundTag, "worldgen/biome");
                    for (CompoundTag compoundTag2 : listTag) {
                        CompoundTag compoundTag3;
                        NumberTag numberTag = (compoundTag3 = compoundTag2.getCompoundTag("element")).getNumberTag("has_precipitation");
                        compoundTag3.putString("precipitation", numberTag.asByte() == 1 ? "rain" : "none");
                    }
                });
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.PLAYER_POSITION, new PacketHandlers(){

            @Override
            protected void register() {
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.DOUBLE);
                this.map(Types.FLOAT);
                this.map(Types.FLOAT);
                this.map(Types.BYTE);
                this.map(Types.VAR_INT);
                this.create(Types.BOOLEAN, false);
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.DAMAGE_EVENT, ClientboundPackets1_19_3.ENTITY_EVENT, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT, Types.INT);
                this.read(Types.VAR_INT);
                this.read(Types.OPTIONAL_VAR_INT);
                this.read(Types.OPTIONAL_VAR_INT);
                this.handler(packetWrapper -> {
                    if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.DOUBLE);
                        packetWrapper.read(Types.DOUBLE);
                    }
                });
                this.create(Types.BYTE, (byte)2);
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.HURT_ANIMATION, ClientboundPackets1_19_3.ANIMATE, (PacketHandler)new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.VAR_INT);
                this.read(Types.FLOAT);
                this.create(Types.UNSIGNED_BYTE, (short)1);
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.RESPAWN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.STRING);
                this.map(Types.STRING);
                this.handler(EntityPacketRewriter1_19_4.this.worldDataTrackerHandlerByKey());
            }
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.UPDATE_MOB_EFFECT, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.passthrough(Types.BYTE);
            int n = packetWrapper.read(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, n == -1 ? 999999 : n);
        });
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.TELEPORT_ENTITY, packetWrapper -> {
            int[] nArray;
            LinkedEntityStorage linkedEntityStorage;
            boolean bl;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(packetWrapper.user());
            TrackedEntity trackedEntity = entityTracker1_19_4.entity(n);
            if (trackedEntity == null) {
                return;
            }
            boolean bl2 = bl = trackedEntity.entityType() == EntityTypes1_19_4.TEXT_DISPLAY;
            if (bl) {
                packetWrapper.set(Types.DOUBLE, 1, d2 - 0.25);
            }
            if ((linkedEntityStorage = trackedEntity.get(LinkedEntityStorage.class)) == null) {
                return;
            }
            double d4 = d - linkedEntityStorage.x();
            double d5 = d2 - linkedEntityStorage.y();
            double d6 = d3 - linkedEntityStorage.z();
            linkedEntityStorage.setPosition(d, d2, d3);
            if (bl) {
                this.teleportTextDisplayLines(packetWrapper.user(), linkedEntityStorage);
            }
            if ((nArray = linkedEntityStorage.passengers()) != null) {
                for (int n2 : nArray) {
                    LinkedEntityStorage linkedEntityStorage2 = this.riddenTextDisplayStorage(entityTracker1_19_4, n2, n);
                    if (linkedEntityStorage2 == null) continue;
                    linkedEntityStorage2.addRelativePosition(d4, d5, d6);
                    this.sendTeleport(packetWrapper.user(), n2, linkedEntityStorage2.x(), linkedEntityStorage2.y() - 0.25, linkedEntityStorage2.z());
                    this.teleportTextDisplayLines(packetWrapper.user(), linkedEntityStorage2);
                }
            }
        });
        PacketHandler packetHandler = packetWrapper -> {
            int[] nArray;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(packetWrapper.user());
            TrackedEntity trackedEntity = entityTracker1_19_4.entity(n);
            if (trackedEntity == null) {
                return;
            }
            LinkedEntityStorage linkedEntityStorage = trackedEntity.get(LinkedEntityStorage.class);
            if (linkedEntityStorage == null) {
                return;
            }
            short s = packetWrapper.passthrough(Types.SHORT);
            short s2 = packetWrapper.passthrough(Types.SHORT);
            short s3 = packetWrapper.passthrough(Types.SHORT);
            double d = (double)s / 4096.0;
            double d2 = (double)s2 / 4096.0;
            double d3 = (double)s3 / 4096.0;
            linkedEntityStorage.addRelativePosition(d, d2, d3);
            if (trackedEntity.entityType() == EntityTypes1_19_4.TEXT_DISPLAY) {
                this.moveTextDisplayLines(packetWrapper.user(), linkedEntityStorage, s, s2, s3);
            }
            if ((nArray = linkedEntityStorage.passengers()) != null) {
                for (int n2 : nArray) {
                    LinkedEntityStorage linkedEntityStorage2 = this.riddenTextDisplayStorage(entityTracker1_19_4, n2, n);
                    if (linkedEntityStorage2 == null) continue;
                    linkedEntityStorage2.addRelativePosition(d, d2, d3);
                    this.sendRelativeMove(packetWrapper.user(), n2, s, s2, s3);
                    this.moveTextDisplayLines(packetWrapper.user(), linkedEntityStorage2, s, s2, s3);
                }
            }
        };
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.MOVE_ENTITY_POS, packetHandler);
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.MOVE_ENTITY_POS_ROT, packetHandler);
        ((Protocol1_19_4To1_19_3)this.protocol).registerClientbound(ClientboundPackets1_19_4.SET_PASSENGERS, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int[] nArray = packetWrapper.read(Types.VAR_INT_ARRAY_PRIMITIVE);
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(packetWrapper.user());
            LinkedEntityStorage linkedEntityStorage = entityTracker1_19_4.linkedEntityStorage(n);
            if (linkedEntityStorage == null) {
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, nArray);
                return;
            }
            if (linkedEntityStorage.passengers() != null) {
                for (int n2 : linkedEntityStorage.passengers()) {
                    LinkedEntityStorage linkedEntityStorage2 = entityTracker1_19_4.linkedEntityStorage(n2);
                    if (linkedEntityStorage2 == null || !linkedEntityStorage2.isVehicle(n)) continue;
                    linkedEntityStorage2.setVehicleId(null);
                }
            }
            boolean bl = false;
            IntArrayList intArrayList = new IntArrayList(nArray.length);
            for (int n3 : nArray) {
                double d;
                double d2;
                if (entityTracker1_19_4.entityType(n3) != EntityTypes1_19_4.TEXT_DISPLAY) {
                    intArrayList.add(n3);
                    continue;
                }
                bl = true;
                LinkedEntityStorage linkedEntityStorage3 = entityTracker1_19_4.linkedEntityStorage(n3);
                if (linkedEntityStorage3 == null) {
                    intArrayList.add(n3);
                    continue;
                }
                linkedEntityStorage3.setVehicleId(n);
                if (linkedEntityStorage3.entities() == null) {
                    intArrayList.add(n3);
                    continue;
                }
                double d3 = linkedEntityStorage3.x() - linkedEntityStorage.x();
                if (!(d3 * d3 + (d2 = linkedEntityStorage3.y() - linkedEntityStorage.y()) * d2 + (d = linkedEntityStorage3.z() - linkedEntityStorage.z()) * d > 16.0)) continue;
                linkedEntityStorage3.setPosition(linkedEntityStorage.x(), linkedEntityStorage.y(), linkedEntityStorage.z());
                this.sendTeleport(packetWrapper.user(), n3, linkedEntityStorage3.x(), linkedEntityStorage3.y() - 0.25, linkedEntityStorage3.z());
                this.teleportTextDisplayLines(packetWrapper.user(), linkedEntityStorage3);
            }
            linkedEntityStorage.setPassengers((int[])(bl ? nArray : null));
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, intArrayList.size() == nArray.length ? nArray : intArrayList.toIntArray());
        });
    }

    @Override
    public void registerRewrites() {
        this.filter().handler((entityDataHandlerEvent, entityData) -> {
            int n = entityData.dataType().typeId();
            if (n >= 25) {
                entityDataHandlerEvent.cancel();
                return;
            }
            if (n >= 15) {
                --n;
            }
            entityData.setDataType(Types1_19_3.ENTITY_DATA_TYPES.byId(n));
        });
        this.registerEntityDataTypeHandler(Types1_19_3.ENTITY_DATA_TYPES.itemType, null, Types1_19_3.ENTITY_DATA_TYPES.optionalBlockStateType, Types1_19_3.ENTITY_DATA_TYPES.particleType, Types1_19_3.ENTITY_DATA_TYPES.componentType, Types1_19_3.ENTITY_DATA_TYPES.optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_19_4.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_19_4.BOAT).index(11).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            if (n > 4) {
                entityData.setValue(n - 1);
            }
        });
        this.filter().type(EntityTypes1_19_4.TEXT_DISPLAY).index(22).handler((entityDataHandlerEvent, entityData) -> {
            int n;
            entityDataHandlerEvent.setIndex(2);
            entityData.setDataType(Types1_19_3.ENTITY_DATA_TYPES.optionalComponentType);
            entityDataHandlerEvent.createExtraData(new EntityData(3, Types1_19_3.ENTITY_DATA_TYPES.booleanType, true));
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(entityDataHandlerEvent.user());
            JsonElement jsonElement = (JsonElement)entityData.value();
            if (!EntityPacketRewriter1_19_4.containsNewLine(jsonElement)) {
                this.clearTextDisplayLines(entityDataHandlerEvent.user(), entityTracker1_19_4, entityDataHandlerEvent.entityId());
                return;
            }
            TextComponent[] textComponentArray = TextUtils.split(SerializerVersion.V1_19_4.toComponent(jsonElement), "\n", false);
            if (textComponentArray.length <= 1) {
                this.clearTextDisplayLines(entityDataHandlerEvent.user(), entityTracker1_19_4, entityDataHandlerEvent.entityId());
                return;
            }
            entityData.setValue(SerializerVersion.V1_19_4.toJson(textComponentArray[textComponentArray.length - 1]));
            LinkedEntityStorage linkedEntityStorage = entityTracker1_19_4.linkedEntityStorage(entityDataHandlerEvent.entityId());
            if (linkedEntityStorage == null) {
                return;
            }
            int n2 = textComponentArray.length - 1;
            int[] nArray = linkedEntityStorage.entities();
            if (nArray == null || nArray.length != n2) {
                LinkedEntityStorage linkedEntityStorage2;
                n = nArray == null && linkedEntityStorage.vehicleId() != null ? 1 : 0;
                entityTracker1_19_4.clearLinkedEntities(linkedEntityStorage);
                LinkedEntityStorage linkedEntityStorage3 = linkedEntityStorage2 = n != 0 ? entityTracker1_19_4.linkedEntityStorage(linkedEntityStorage.vehicleId()) : null;
                if (linkedEntityStorage2 != null) {
                    linkedEntityStorage.setPosition(linkedEntityStorage2.x(), linkedEntityStorage2.y(), linkedEntityStorage2.z());
                }
                nArray = new int[n2];
                for (int i = 0; i < n2; ++i) {
                    double d = linkedEntityStorage.y() + 0.25 * (double)i;
                    nArray[i] = entityTracker1_19_4.spawnEntity(EntityTypes1_19_3.ARMOR_STAND, linkedEntityStorage.x(), d, linkedEntityStorage.z(), 0);
                }
                linkedEntityStorage.setEntities(nArray);
                if (linkedEntityStorage2 != null) {
                    this.sendVehiclePassengers(entityDataHandlerEvent.user(), entityTracker1_19_4, linkedEntityStorage.vehicleId());
                    this.sendTeleport(entityDataHandlerEvent.user(), entityDataHandlerEvent.entityId(), linkedEntityStorage.x(), linkedEntityStorage.y() - 0.25, linkedEntityStorage.z());
                }
            }
            for (n = 0; n < n2; ++n) {
                this.sendLineData(entityDataHandlerEvent.user(), nArray[n], SerializerVersion.V1_19_4.toJson(textComponentArray[n2 - 1 - n]));
            }
        });
        this.filter().type(EntityTypes1_19_4.BLOCK_DISPLAY).index(22).handler((entityDataHandlerEvent, entityData) -> {
            int n = (Integer)entityData.value();
            EntityTracker1_19_4 entityTracker1_19_4 = (EntityTracker1_19_4)this.tracker(entityDataHandlerEvent.user());
            LinkedEntityStorage linkedEntityStorage = entityDataHandlerEvent.trackedEntity().get(LinkedEntityStorage.class);
            if (linkedEntityStorage == null) {
                return;
            }
            entityTracker1_19_4.clearLinkedEntities(linkedEntityStorage);
            int n2 = entityTracker1_19_4.spawnEntity(EntityTypes1_19_3.FALLING_BLOCK, linkedEntityStorage.x(), linkedEntityStorage.y(), linkedEntityStorage.z(), n);
            linkedEntityStorage.setEntities(n2);
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.SET_PASSENGERS, entityDataHandlerEvent.user());
            packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
            packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{n2});
            packetWrapper.send(Protocol1_19_4To1_19_3.class);
        });
        this.filter().type(EntityTypes1_19_4.ITEM_DISPLAY).index(22).handler((entityDataHandlerEvent, entityData) -> {
            Item item = (Item)entityData.value();
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.SET_EQUIPMENT, entityDataHandlerEvent.user());
            packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
            packetWrapper.write(Types.BYTE, (byte)5);
            packetWrapper.write(Types.ITEM1_13_2, item);
            packetWrapper.send(Protocol1_19_4To1_19_3.class);
        });
        this.filter().type(EntityTypes1_19_4.DISPLAY).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() > 7) {
                entityDataHandlerEvent.cancel();
            }
        });
        this.filter().type(EntityTypes1_19_4.INTERACTION).cancel(8);
        this.filter().type(EntityTypes1_19_4.INTERACTION).cancel(9);
        this.filter().type(EntityTypes1_19_4.INTERACTION).cancel(10);
        this.filter().type(EntityTypes1_19_4.SNIFFER).cancel(17);
        this.filter().type(EntityTypes1_19_4.SNIFFER).cancel(18);
        this.filter().type(EntityTypes1_19_4.ABSTRACT_HORSE).addIndex(18);
    }

    private void clearTextDisplayLines(UserConnection userConnection, EntityTracker1_19_4 entityTracker1_19_4, int n) {
        LinkedEntityStorage linkedEntityStorage = entityTracker1_19_4.linkedEntityStorage(n);
        if (linkedEntityStorage == null || linkedEntityStorage.entities() == null) {
            return;
        }
        entityTracker1_19_4.clearLinkedEntities(linkedEntityStorage);
        this.sendVehiclePassengers(userConnection, entityTracker1_19_4, linkedEntityStorage.vehicleId());
    }

    private LinkedEntityStorage riddenTextDisplayStorage(EntityTracker1_19_4 entityTracker1_19_4, int n, int n2) {
        TrackedEntity trackedEntity = entityTracker1_19_4.entity(n);
        if (trackedEntity == null || trackedEntity.entityType() != EntityTypes1_19_4.TEXT_DISPLAY) {
            return null;
        }
        LinkedEntityStorage linkedEntityStorage = trackedEntity.get(LinkedEntityStorage.class);
        return linkedEntityStorage != null && linkedEntityStorage.entities() != null && linkedEntityStorage.isVehicle(n2) ? linkedEntityStorage : null;
    }

    private boolean isMultiLineTextDisplay(EntityTracker1_19_4 entityTracker1_19_4, int n) {
        if (entityTracker1_19_4.entityType(n) != EntityTypes1_19_4.TEXT_DISPLAY) {
            return false;
        }
        LinkedEntityStorage linkedEntityStorage = entityTracker1_19_4.linkedEntityStorage(n);
        return linkedEntityStorage != null && linkedEntityStorage.entities() != null;
    }

    private int[] withoutMultiLineTextDisplays(EntityTracker1_19_4 entityTracker1_19_4, int[] nArray) {
        IntArrayList intArrayList = new IntArrayList(nArray.length);
        for (int n : nArray) {
            if (this.isMultiLineTextDisplay(entityTracker1_19_4, n)) continue;
            intArrayList.add(n);
        }
        return intArrayList.size() == nArray.length ? nArray : intArrayList.toIntArray();
    }

    private void sendVehiclePassengers(UserConnection userConnection, EntityTracker1_19_4 entityTracker1_19_4, @Nullable Integer n) {
        if (n == null) {
            return;
        }
        LinkedEntityStorage linkedEntityStorage = entityTracker1_19_4.linkedEntityStorage(n);
        if (linkedEntityStorage == null || linkedEntityStorage.passengers() == null) {
            return;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.SET_PASSENGERS, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, this.withoutMultiLineTextDisplays(entityTracker1_19_4, linkedEntityStorage.passengers()));
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
    }

    private void teleportTextDisplayLines(UserConnection userConnection, LinkedEntityStorage linkedEntityStorage) {
        int[] nArray = linkedEntityStorage.entities();
        if (nArray == null) {
            return;
        }
        for (int i = 0; i < nArray.length; ++i) {
            this.sendTeleport(userConnection, nArray[i], linkedEntityStorage.x(), linkedEntityStorage.y() + 0.25 * (double)i, linkedEntityStorage.z());
        }
    }

    private void moveTextDisplayLines(UserConnection userConnection, LinkedEntityStorage linkedEntityStorage, short s, short s2, short s3) {
        int[] nArray = linkedEntityStorage.entities();
        if (nArray == null) {
            return;
        }
        for (int n : nArray) {
            this.sendRelativeMove(userConnection, n, s, s2, s3);
        }
    }

    private void sendTeleport(UserConnection userConnection, int n, double d, double d2, double d3) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.TELEPORT_ENTITY, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.DOUBLE, d);
        packetWrapper.write(Types.DOUBLE, d2);
        packetWrapper.write(Types.DOUBLE, d3);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BOOLEAN, false);
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
    }

    private void sendRelativeMove(UserConnection userConnection, int n, short s, short s2, short s3) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.MOVE_ENTITY_POS, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.SHORT, s);
        packetWrapper.write(Types.SHORT, s2);
        packetWrapper.write(Types.SHORT, s3);
        packetWrapper.write(Types.BOOLEAN, false);
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
    }

    private static boolean containsNewLine(JsonElement jsonElement) {
        block4: {
            block3: {
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive jsonPrimitive = jsonElement.getAsJsonPrimitive();
                    return jsonPrimitive.isString() && jsonPrimitive.getAsString().indexOf(10) != -1;
                }
                if (!jsonElement.isJsonArray()) break block3;
                for (JsonElement jsonElement2 : jsonElement.getAsJsonArray()) {
                    if (!EntityPacketRewriter1_19_4.containsNewLine(jsonElement2)) continue;
                    return true;
                }
                break block4;
            }
            if (!jsonElement.isJsonObject()) break block4;
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                if (!EntityPacketRewriter1_19_4.containsNewLine(entry.getValue())) continue;
                return true;
            }
        }
        return false;
    }

    private void sendLineData(UserConnection userConnection, int n, JsonElement jsonElement) {
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(0, Types1_19_3.ENTITY_DATA_TYPES.byteType, (byte)32));
        arrayList.add(new EntityData(2, Types1_19_3.ENTITY_DATA_TYPES.optionalComponentType, jsonElement));
        arrayList.add(new EntityData(3, Types1_19_3.ENTITY_DATA_TYPES.booleanType, true));
        arrayList.add(new EntityData(5, Types1_19_3.ENTITY_DATA_TYPES.booleanType, true));
        arrayList.add(new EntityData(15, Types1_19_3.ENTITY_DATA_TYPES.byteType, (byte)17));
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_19_3.SET_ENTITY_DATA, userConnection);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types1_19_3.ENTITY_DATA_LIST, arrayList);
        packetWrapper.send(Protocol1_19_4To1_19_3.class);
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        EntityReplacement.EntityDataCreator entityDataCreator = wrappedEntityData -> {
            wrappedEntityData.add(new EntityData(0, Types1_19_3.ENTITY_DATA_TYPES.byteType, (byte)32));
            wrappedEntityData.add(new EntityData(5, Types1_19_3.ENTITY_DATA_TYPES.booleanType, true));
            wrappedEntityData.add(new EntityData(15, Types1_19_3.ENTITY_DATA_TYPES.byteType, (byte)17));
        };
        this.mapEntityTypeWithData(EntityTypes1_19_4.TEXT_DISPLAY, EntityTypes1_19_4.ARMOR_STAND).spawnEntityData(entityDataCreator);
        this.mapEntityTypeWithData(EntityTypes1_19_4.ITEM_DISPLAY, EntityTypes1_19_4.ARMOR_STAND).spawnEntityData(entityDataCreator);
        this.mapEntityTypeWithData(EntityTypes1_19_4.BLOCK_DISPLAY, EntityTypes1_19_4.ARMOR_STAND).spawnEntityData(entityDataCreator);
        this.mapEntityTypeWithData(EntityTypes1_19_4.INTERACTION, EntityTypes1_19_4.ARMOR_STAND).spawnEntityData(entityDataCreator);
        this.mapEntityTypeWithData(EntityTypes1_19_4.SNIFFER, EntityTypes1_19_4.RAVAGER).jsonName();
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_19_4.getTypeFromId(n);
    }
}

