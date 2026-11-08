/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.RegistryEntry;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_2;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.protocol.remapper.PacketHandlers;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_20_3to1_20_5.packet.ServerboundPackets1_20_5;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundConfigurationPackets1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPacket1_21;
import com.viaversion.viaversion.protocols.v1_20_5to1_21.packet.ClientboundPackets1_21;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.Protocol1_21To1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ClientboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.packet.ServerboundPackets1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ChunkLoadTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.ClientVehicleStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.EntityTracker1_21_2;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.GroundFlagTracker;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.PlayerPositionStorage;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.TeleportAckCancelStorage;
import com.viaversion.viaversion.rewriter.EntityRewriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class EntityPacketRewriter1_21_2
extends EntityRewriter<ClientboundPacket1_21, Protocol1_21To1_21_2> {
    private static final String[] GOAT_HORN_INSTRUMENTS = new String[]{"ponder_goat_horn", "sing_goat_horn", "seek_goat_horn", "feel_goat_horn", "admire_goat_horn", "call_goat_horn", "yearn_goat_horn", "dream_goat_horn"};
    private static final float IMPULSE = 0.98f;
    private final boolean isVF = Via.getPlatform().getPlatformName().equals("ViaFabric");

    public EntityPacketRewriter1_21_2(Protocol1_21To1_21_2 protocol1_21To1_21_2) {
        super(protocol1_21To1_21_2);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21To1_21_2)this.protocol).appendClientbound(ClientboundPackets1_21.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.get(Types.VAR_INT, 1);
            EntityType entityType = this.typeFromId(n);
            if (entityType == null || !entityType.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
                return;
            }
            int n2 = packetWrapper.get(Types.VAR_INT, 0);
            UUID uUID = packetWrapper.get(Types.UUID, 0);
            double d = packetWrapper.get(Types.DOUBLE, 0);
            double d2 = packetWrapper.get(Types.DOUBLE, 1);
            double d3 = packetWrapper.get(Types.DOUBLE, 2);
            float f = (float)packetWrapper.get(Types.BYTE, 0).byteValue() * 256.0f / 360.0f;
            float f2 = (float)packetWrapper.get(Types.BYTE, 1).byteValue() * 256.0f / 360.0f;
            int n3 = packetWrapper.get(Types.VAR_INT, 2);
            EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(packetWrapper.user());
            EntityTracker1_21_2.BoatEntity boatEntity = entityTracker1_21_2.trackBoatEntity(n2, uUID, n3);
            boatEntity.setPosition(d, d2, d3);
            boatEntity.setRotation(f2, f);
        });
        ((Protocol1_21To1_21_2)this.protocol).appendClientbound(ClientboundConfigurationPackets1_21.FINISH_CONFIGURATION, packetWrapper -> {
            PacketWrapper packetWrapper2 = packetWrapper.create(ClientboundConfigurationPackets1_21.REGISTRY_DATA);
            packetWrapper2.write(Types.STRING, "minecraft:instrument");
            RegistryEntry[] registryEntryArray = new RegistryEntry[GOAT_HORN_INSTRUMENTS.length];
            for (int i = 0; i < GOAT_HORN_INSTRUMENTS.length; ++i) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.putString("sound_event", "item.goat_horn.sound." + i);
                compoundTag.putFloat("use_duration", 7.0f);
                compoundTag.putInt("range", 256);
                compoundTag.putString("description", "");
                registryEntryArray[i] = new RegistryEntry(GOAT_HORN_INSTRUMENTS[i], compoundTag);
            }
            packetWrapper2.write(Types.REGISTRY_ENTRY_ARRAY, registryEntryArray);
            packetWrapper2.send(Protocol1_21To1_21_2.class);
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.LOGIN, new PacketHandlers(){

            @Override
            public void register() {
                this.map(Types.INT);
                this.map(Types.BOOLEAN);
                this.map(Types.STRING_ARRAY);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.VAR_INT);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.VAR_INT);
                this.map(Types.STRING);
                this.map(Types.LONG);
                this.map(Types.BYTE);
                this.map(Types.BYTE);
                this.map(Types.BOOLEAN);
                this.map(Types.BOOLEAN);
                this.map(Types.OPTIONAL_GLOBAL_POSITION);
                this.map(Types.VAR_INT);
                this.handler(EntityPacketRewriter1_21_2.this.worldDataTrackerHandlerByKey1_20_5(3));
                this.handler(EntityPacketRewriter1_21_2.this.playerTrackerHandler());
                this.create(Types.VAR_INT, 64);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).replaceClientbound(ClientboundPackets1_21.RESPAWN, packetWrapper -> {
            ChunkLoadTracker chunkLoadTracker;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            String string = packetWrapper.passthrough(Types.STRING);
            packetWrapper.passthrough(Types.LONG);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BYTE);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.BOOLEAN);
            packetWrapper.passthrough(Types.OPTIONAL_GLOBAL_POSITION);
            packetWrapper.passthrough(Types.VAR_INT);
            packetWrapper.write(Types.VAR_INT, 64);
            byte by = packetWrapper.passthrough(Types.BYTE);
            EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(packetWrapper.user());
            if (entityTracker1_21_2.currentWorld() != null && !entityTracker1_21_2.currentWorld().equals(string) && (chunkLoadTracker = packetWrapper.user().get(ChunkLoadTracker.class)) != null) {
                chunkLoadTracker.clear();
            }
            this.trackWorldDataByKey1_20_5(packetWrapper.user(), n, string);
            packetWrapper.user().put(new GroundFlagTracker());
            packetWrapper.user().remove(ClientVehicleStorage.class);
            if ((by & 1) == 0) {
                entityTracker1_21_2.setPlayerMaxHealthAttributeValue(20.0);
            }
            if ((by & 2) != 0) {
                PacketWrapper packetWrapper2;
                boolean bl = packetWrapper.user().get(BundleStateTracker.class).isBundling();
                if (!bl) {
                    packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    packetWrapper2.send(Protocol1_21To1_21_2.class);
                }
                packetWrapper.send(Protocol1_21To1_21_2.class);
                packetWrapper.cancel();
                packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA);
                packetWrapper2.write(Types.VAR_INT, entityTracker1_21_2.clientEntityId());
                ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
                arrayList.add(new EntityData(6, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).poseType, 0));
                arrayList.add(new EntityData(9, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).floatType, Float.valueOf((float)entityTracker1_21_2.playerMaxHealthAttributeValue())));
                packetWrapper2.write(VersionedTypes.V1_21_2.entityDataList, arrayList);
                packetWrapper2.send(Protocol1_21To1_21_2.class);
                int n2 = ThreadLocalRandom.current().nextInt();
                packetWrapper.user().get(TeleportAckCancelStorage.class).cancelTeleportId(n2);
                PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
                if (playerPositionStorage != null) {
                    playerPositionStorage.sendPing(packetWrapper.user(), ThreadLocalRandom.current().nextInt());
                }
                PacketWrapper packetWrapper3 = packetWrapper.create(ClientboundPackets1_21_2.PLAYER_POSITION);
                packetWrapper3.write(Types.VAR_INT, n2);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.DOUBLE, 0.0);
                packetWrapper3.write(Types.FLOAT, Float.valueOf(-180.0f));
                packetWrapper3.write(Types.FLOAT, Float.valueOf(0.0f));
                packetWrapper3.write(Types.INT, 7);
                packetWrapper3.send(Protocol1_21To1_21_2.class);
                if (!bl) {
                    PacketWrapper packetWrapper4 = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                    packetWrapper4.send(Protocol1_21To1_21_2.class);
                }
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.PLAYER_POSITION, packetWrapper -> {
            PacketWrapper packetWrapper2;
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.DOUBLE, 0.0);
            packetWrapper.write(Types.DOUBLE, 0.0);
            packetWrapper.write(Types.DOUBLE, 0.0);
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            int n = packetWrapper.read(Types.BYTE) & 0x1F;
            if ((n & 1) != 0) {
                n |= 0x20;
            }
            if ((n & 2) != 0) {
                n |= 0x40;
            }
            if ((n & 4) != 0) {
                n |= 0x80;
            }
            packetWrapper.write(Types.INT, n);
            int n2 = packetWrapper.read(Types.VAR_INT);
            packetWrapper.set(Types.VAR_INT, 0, n2);
            PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
            if (playerPositionStorage == null) {
                return;
            }
            boolean bl = packetWrapper.user().get(BundleStateTracker.class).isBundling();
            if (!bl) {
                packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                packetWrapper2.send(Protocol1_21To1_21_2.class);
            }
            playerPositionStorage.sendPing(packetWrapper.user(), ThreadLocalRandom.current().nextInt());
            packetWrapper.send(Protocol1_21To1_21_2.class);
            packetWrapper.cancel();
            if (!bl) {
                packetWrapper2 = packetWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER);
                packetWrapper2.send(Protocol1_21To1_21_2.class);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.SET_PASSENGERS, packetWrapper -> {
            EntityTracker1_21_2 entityTracker1_21_2;
            EntityTracker1_21_2.BoatEntity boatEntity;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage != null && n == clientVehicleStorage.vehicleId()) {
                packetWrapper.user().remove(ClientVehicleStorage.class);
            }
            if ((boatEntity = (entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(packetWrapper.user())).trackedBoatEntity(n)) != null) {
                boatEntity.setPassengers(nArray);
            }
            int n2 = this.tracker(packetWrapper.user()).clientEntityId();
            for (int n3 : nArray) {
                if (n3 != n2) continue;
                packetWrapper.user().put(new ClientVehicleStorage(n));
                break;
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).appendClientbound(ClientboundPackets1_21.REMOVE_ENTITIES, packetWrapper -> {
            int[] nArray;
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage == null) {
                return;
            }
            for (int n : nArray = packetWrapper.get(Types.VAR_INT_ARRAY_PRIMITIVE, 0)) {
                if (n != clientVehicleStorage.vehicleId()) continue;
                packetWrapper.user().remove(ClientVehicleStorage.class);
                break;
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.PLAYER_INPUT, packetWrapper -> {
            boolean bl;
            boolean bl2;
            packetWrapper.cancel();
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage == null) {
                return;
            }
            byte by = packetWrapper.read(Types.BYTE);
            boolean bl3 = (by & 4) != 0;
            boolean bl4 = bl2 = (by & 8) != 0;
            float f = bl3 ? 0.98f : (bl2 ? -0.98f : 0.0f);
            boolean bl5 = (by & 1) != 0;
            boolean bl6 = bl = (by & 2) != 0;
            float f2 = bl5 ? 0.98f : (bl ? -0.98f : 0.0f);
            byte by2 = 0;
            if ((by & 0x10) != 0) {
                by2 = (byte)(by2 | 1);
            }
            if ((by & 0x20) != 0) {
                by2 = (byte)(by2 | 2);
            }
            if (packetWrapper.user().isServerSide() && this.isVF) {
                packetWrapper.write(Types.FLOAT, Float.valueOf(f));
                packetWrapper.write(Types.FLOAT, Float.valueOf(f2));
                packetWrapper.write(Types.BYTE, by);
            } else {
                clientVehicleStorage.storeMovement(f, f2, by2);
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.TELEPORT_ENTITY, ClientboundPackets1_21_2.ENTITY_POSITION_SYNC, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.write(Types.DOUBLE, 0.0);
            packetWrapper.write(Types.DOUBLE, 0.0);
            packetWrapper.write(Types.DOUBLE, 0.0);
            float f = (float)packetWrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f;
            float f2 = (float)packetWrapper.read(Types.BYTE).byteValue() * 360.0f / 256.0f;
            packetWrapper.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f2));
            EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(packetWrapper.user());
            EntityTracker1_21_2.BoatEntity boatEntity = entityTracker1_21_2.trackedBoatEntity(n);
            if (boatEntity == null) {
                return;
            }
            boatEntity.setPosition(d, d2, d3);
            boatEntity.setRotation(f, f2);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_POS, packetWrapper -> this.storeEntityPositionRotation(packetWrapper, true, false));
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_POS_ROT, packetWrapper -> this.storeEntityPositionRotation(packetWrapper, true, true));
        ((Protocol1_21To1_21_2)this.protocol).registerClientbound(ClientboundPackets1_21.MOVE_ENTITY_ROT, packetWrapper -> this.storeEntityPositionRotation(packetWrapper, false, true));
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_POS, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            this.handleOnGround(packetWrapper);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
            float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
            this.handleOnGround(packetWrapper);
            PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
            if (playerPositionStorage != null && playerPositionStorage.checkCaptureNextPlayerPositionPacket()) {
                boolean bl = packetWrapper.get(Types.BOOLEAN, 0);
                playerPositionStorage.setPlayerPosition(new PlayerPositionStorage.PlayerPosition(d, d2, d3, f, f2, bl));
                packetWrapper.cancel();
            } else if (packetWrapper.user().get(TeleportAckCancelStorage.class).checkShouldCancelPlayerPositionPacket()) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_ROT, packetWrapper -> {
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.passthrough(Types.FLOAT);
            this.handleOnGround(packetWrapper);
            ClientVehicleStorage clientVehicleStorage = packetWrapper.user().get(ClientVehicleStorage.class);
            if (clientVehicleStorage == null || packetWrapper.user().isServerSide() && this.isVF) {
                return;
            }
            packetWrapper.sendToServer(Protocol1_21To1_21_2.class);
            packetWrapper.cancel();
            PacketWrapper packetWrapper2 = packetWrapper.create(ServerboundPackets1_20_5.PLAYER_INPUT);
            packetWrapper2.write(Types.FLOAT, Float.valueOf(clientVehicleStorage.sidewaysMovement()));
            packetWrapper2.write(Types.FLOAT, Float.valueOf(clientVehicleStorage.forwardMovement()));
            packetWrapper2.write(Types.BYTE, clientVehicleStorage.flags());
            packetWrapper2.sendToServer(Protocol1_21To1_21_2.class);
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.MOVE_PLAYER_STATUS_ONLY, packetWrapper -> {
            GroundFlagTracker groundFlagTracker = packetWrapper.user().get(GroundFlagTracker.class);
            boolean bl = groundFlagTracker.onGround();
            boolean bl2 = groundFlagTracker.horizontalCollision();
            this.handleOnGround(packetWrapper);
            if (bl == groundFlagTracker.onGround() && bl2 != groundFlagTracker.horizontalCollision()) {
                packetWrapper.cancel();
            }
        });
        ((Protocol1_21To1_21_2)this.protocol).registerServerbound(ServerboundPackets1_21_2.ACCEPT_TELEPORTATION, packetWrapper -> {
            TeleportAckCancelStorage teleportAckCancelStorage = packetWrapper.user().get(TeleportAckCancelStorage.class);
            PlayerPositionStorage playerPositionStorage = packetWrapper.user().get(PlayerPositionStorage.class);
            int n = packetWrapper.passthrough(Types.VAR_INT);
            if (teleportAckCancelStorage.checkShouldCancelTeleportAck(n)) {
                packetWrapper.cancel();
                if (playerPositionStorage != null && playerPositionStorage.checkHasPlayerPosition()) {
                    playerPositionStorage.reset();
                    teleportAckCancelStorage.checkShouldCancelPlayerPositionPacket();
                }
                return;
            }
            if (playerPositionStorage != null && playerPositionStorage.checkHasPlayerPosition()) {
                packetWrapper.sendToServer(Protocol1_21To1_21_2.class);
                packetWrapper.cancel();
                playerPositionStorage.sendMovePlayerPosRot(packetWrapper.user());
            }
        });
    }

    private void handleOnGround(PacketWrapper packetWrapper) {
        GroundFlagTracker groundFlagTracker = packetWrapper.user().get(GroundFlagTracker.class);
        short s = packetWrapper.read(Types.UNSIGNED_BYTE);
        packetWrapper.write(Types.BOOLEAN, groundFlagTracker.setOnGround((s & 1) != 0));
        groundFlagTracker.setHorizontalCollision((s & 2) != 0);
    }

    private void storeEntityPositionRotation(PacketWrapper packetWrapper, boolean bl, boolean bl2) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(packetWrapper.user());
        EntityTracker1_21_2.BoatEntity boatEntity = entityTracker1_21_2.trackedBoatEntity(n);
        if (boatEntity == null) {
            return;
        }
        if (bl) {
            double d = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double d2 = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double d3 = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            boatEntity.setPosition(boatEntity.x() + d, boatEntity.y() + d2, boatEntity.z() + d3);
        }
        if (bl2) {
            float f = (float)packetWrapper.passthrough(Types.BYTE).byteValue() * 360.0f / 256.0f;
            float f2 = (float)packetWrapper.passthrough(Types.BYTE).byteValue() * 360.0f / 256.0f;
            boatEntity.setRotation(f, f2);
        }
    }

    @Override
    protected void registerRewrites() {
        this.dataTypeMapper().register();
        this.registerEntityDataTypeHandler(((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).itemType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).blockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalBlockStateType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particleType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).particlesType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).componentType, ((EntityDataTypes1_21_2)VersionedTypes.V1_21_2.entityDataTypes).optionalComponentType);
        this.registerBlockStateHandler(EntityTypes1_21_2.ABSTRACT_MINECART, 11);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_BOAT).handler((entityDataHandlerEvent, entityData) -> {
            PacketWrapper packetWrapper;
            PacketWrapper packetWrapper2;
            int n = entityDataHandlerEvent.index();
            if (n > 11) {
                entityDataHandlerEvent.setIndex(n - 1);
                return;
            }
            if (n != 11) {
                return;
            }
            entityDataHandlerEvent.cancel();
            EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(entityDataHandlerEvent.user());
            EntityTracker1_21_2.BoatEntity boatEntity = entityTracker1_21_2.trackedBoatEntity(entityDataHandlerEvent.entityId());
            if (boatEntity == null) {
                return;
            }
            boolean bl = entityDataHandlerEvent.user().get(BundleStateTracker.class).isBundling();
            if (!bl) {
                packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER, entityDataHandlerEvent.user());
                packetWrapper2.send(Protocol1_21To1_21_2.class);
            }
            packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_2.REMOVE_ENTITIES, entityDataHandlerEvent.user());
            packetWrapper2.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{entityDataHandlerEvent.entityId()});
            packetWrapper2.send(Protocol1_21To1_21_2.class);
            int n2 = (Integer)entityData.getValue();
            EntityType entityType = entityTracker1_21_2.entityType(entityDataHandlerEvent.entityId()).isOrHasParent(EntityTypes1_21_2.ABSTRACT_CHEST_BOAT) ? this.entityTypeFromChestBoatType(n2) : this.entityTypeFromBoatType(n2);
            PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_21_2.ADD_ENTITY, entityDataHandlerEvent.user());
            packetWrapper3.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
            packetWrapper3.write(Types.UUID, boatEntity.uuid());
            packetWrapper3.write(Types.VAR_INT, entityType.getId());
            packetWrapper3.write(Types.DOUBLE, boatEntity.x());
            packetWrapper3.write(Types.DOUBLE, boatEntity.y());
            packetWrapper3.write(Types.DOUBLE, boatEntity.z());
            packetWrapper3.write(Types.BYTE, (byte)Math.floor(boatEntity.pitch() * 256.0f / 360.0f));
            packetWrapper3.write(Types.BYTE, (byte)Math.floor(boatEntity.yaw() * 256.0f / 360.0f));
            packetWrapper3.write(Types.BYTE, (byte)0);
            packetWrapper3.write(Types.VAR_INT, boatEntity.data());
            packetWrapper3.write(Types.SHORT, (short)0);
            packetWrapper3.write(Types.SHORT, (short)0);
            packetWrapper3.write(Types.SHORT, (short)0);
            packetWrapper3.send(Protocol1_21To1_21_2.class);
            entityTracker1_21_2.updateBoatType(entityDataHandlerEvent.entityId(), entityType);
            PacketWrapper packetWrapper4 = PacketWrapper.create(ClientboundPackets1_21_2.SET_ENTITY_DATA, entityDataHandlerEvent.user());
            packetWrapper4.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
            packetWrapper4.write(VersionedTypes.V1_21_2.entityDataList, boatEntity.entityData());
            packetWrapper4.send(Protocol1_21To1_21_2.class);
            if (boatEntity.passengers() != null) {
                packetWrapper = PacketWrapper.create(ClientboundPackets1_21_2.SET_PASSENGERS, entityDataHandlerEvent.user());
                packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, boatEntity.passengers());
                packetWrapper.send(Protocol1_21To1_21_2.class);
            }
            if (!bl) {
                packetWrapper = PacketWrapper.create(ClientboundPackets1_21_2.BUNDLE_DELIMITER, entityDataHandlerEvent.user());
                packetWrapper.send(Protocol1_21To1_21_2.class);
            }
        });
        this.filter().type(EntityTypes1_21_2.SALMON).addIndex(17);
        this.filter().type(EntityTypes1_21_2.AGEABLE_WATER_CREATURE).addIndex(16);
        this.filter().type(EntityTypes1_21_2.ABSTRACT_ARROW).addIndex(10);
    }

    @Override
    public void handleEntityData(int n, List<EntityData> list, UserConnection userConnection) {
        super.handleEntityData(n, list, userConnection);
        EntityTracker1_21_2 entityTracker1_21_2 = (EntityTracker1_21_2)this.tracker(userConnection);
        EntityType entityType = entityTracker1_21_2.entityType(n);
        if (entityType == null || !entityType.isOrHasParent(EntityTypes1_21_2.ABSTRACT_BOAT)) {
            return;
        }
        List<EntityData> list2 = entityTracker1_21_2.trackedBoatEntity(n).entityData();
        list2.removeIf(entityData -> list.stream().anyMatch(entityData2 -> entityData.id() == entityData2.id()));
        for (EntityData entityData2 : list) {
            Object t = entityData2.value();
            if (t instanceof Item) {
                Item item = (Item)t;
                list2.add(new EntityData(entityData2.id(), entityData2.dataType(), item.copy()));
                continue;
            }
            list2.add(new EntityData(entityData2.id(), entityData2.dataType(), t));
        }
    }

    private EntityType entityTypeFromBoatType(int n) {
        if (n == 0) {
            return EntityTypes1_21_2.OAK_BOAT;
        }
        if (n == 1) {
            return EntityTypes1_21_2.SPRUCE_BOAT;
        }
        if (n == 2) {
            return EntityTypes1_21_2.BIRCH_BOAT;
        }
        if (n == 3) {
            return EntityTypes1_21_2.JUNGLE_BOAT;
        }
        if (n == 4) {
            return EntityTypes1_21_2.ACACIA_BOAT;
        }
        if (n == 5) {
            return EntityTypes1_21_2.CHERRY_BOAT;
        }
        if (n == 6) {
            return EntityTypes1_21_2.DARK_OAK_BOAT;
        }
        if (n == 7) {
            return EntityTypes1_21_2.MANGROVE_BOAT;
        }
        if (n == 8) {
            return EntityTypes1_21_2.BAMBOO_RAFT;
        }
        return EntityTypes1_21_2.OAK_BOAT;
    }

    private EntityType entityTypeFromChestBoatType(int n) {
        if (n == 0) {
            return EntityTypes1_21_2.OAK_CHEST_BOAT;
        }
        if (n == 1) {
            return EntityTypes1_21_2.SPRUCE_CHEST_BOAT;
        }
        if (n == 2) {
            return EntityTypes1_21_2.BIRCH_CHEST_BOAT;
        }
        if (n == 3) {
            return EntityTypes1_21_2.JUNGLE_CHEST_BOAT;
        }
        if (n == 4) {
            return EntityTypes1_21_2.ACACIA_CHEST_BOAT;
        }
        if (n == 5) {
            return EntityTypes1_21_2.CHERRY_CHEST_BOAT;
        }
        if (n == 6) {
            return EntityTypes1_21_2.DARK_OAK_CHEST_BOAT;
        }
        if (n == 7) {
            return EntityTypes1_21_2.MANGROVE_CHEST_BOAT;
        }
        if (n == 8) {
            return EntityTypes1_21_2.BAMBOO_CHEST_RAFT;
        }
        return EntityTypes1_21_2.OAK_CHEST_BOAT;
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_2.getTypeFromId(n);
    }
}

