/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.nbt.tag.StringTag;
import com.viaversion.nbt.tag.Tag;
import com.viaversion.viabackwards.api.rewriters.EntityRewriter;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.Protocol1_21_9To1_21_7;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.MannequinData;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage.PlayerRotationStorage;
import com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.tracker.EntityTracker1_21_9;
import com.viaversion.viabackwards.utils.VelocityUtil;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.GlobalBlockPosition;
import com.viaversion.viaversion.api.minecraft.ResolvableProfile;
import com.viaversion.viaversion.api.minecraft.Vector3d;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_6;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_21_9;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_5;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_21_9;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.version.Types1_20_5;
import com.viaversion.viaversion.api.type.types.version.VersionedTypes;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ClientboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.packet.ServerboundPackets1_21_6;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPacket1_21_9;
import com.viaversion.viaversion.protocols.v1_21_7to1_21_9.packet.ClientboundPackets1_21_9;
import com.viaversion.viaversion.protocols.v1_21to1_21_2.storage.BundleStateTracker;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandler;
import com.viaversion.viaversion.util.Copyable;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityPacketRewriter1_21_9
extends EntityRewriter<ClientboundPacket1_21_9, Protocol1_21_9To1_21_7> {
    public EntityPacketRewriter1_21_9(Protocol1_21_9To1_21_7 protocol1_21_9To1_21_7) {
        super(protocol1_21_9To1_21_7, ((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).optionalComponentType, ((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).booleanType);
    }

    @Override
    public void registerPackets() {
        ((Protocol1_21_9To1_21_7)this.protocol).replaceClientbound(ClientboundPackets1_21_9.ADD_ENTITY, packetWrapper -> {
            int n = packetWrapper.passthrough(Types.VAR_INT);
            UUID uUID = packetWrapper.passthrough(Types.UUID);
            int n2 = packetWrapper.passthrough(Types.VAR_INT);
            double d = packetWrapper.passthrough(Types.DOUBLE);
            double d2 = packetWrapper.passthrough(Types.DOUBLE);
            double d3 = packetWrapper.passthrough(Types.DOUBLE);
            Vector3d vector3d = packetWrapper.read(Types.LOW_PRECISION_VECTOR);
            byte by = packetWrapper.passthrough(Types.BYTE);
            byte by2 = packetWrapper.passthrough(Types.BYTE);
            byte by3 = packetWrapper.passthrough(Types.BYTE);
            int n3 = packetWrapper.passthrough(Types.VAR_INT);
            TrackedEntity trackedEntity = this.trackAndRewrite(packetWrapper, n2, n);
            if (trackedEntity.entityType() == EntityTypes1_21_9.FALLING_BLOCK) {
                int n4 = ((Protocol1_21_9To1_21_7)this.protocol).getMappingData().getNewBlockStateId(n3);
                packetWrapper.set(Types.VAR_INT, 2, n4);
            }
            this.writeMovementShorts(packetWrapper, vector3d);
            if (EntityTypes1_21_9.getTypeFromId(n2) == EntityTypes1_21_9.MANNEQUIN) {
                String string = this.randomHackyEmptyName();
                MannequinData mannequinData = new MannequinData(uUID, string);
                TrackedEntity trackedEntity2 = this.tracker(packetWrapper.user()).entity(n);
                trackedEntity2.put(mannequinData);
                this.sendInitialPlayerInfoUpdate(packetWrapper.user(), mannequinData, new GameProfile.Property[0]);
                mannequinData.setPosition(d, d2, d3);
                mannequinData.setRotation(by2, by);
                mannequinData.setHeadYaw(by3);
            }
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.TELEPORT_ENTITY, this::trackMannequinTeleport);
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.ENTITY_POSITION_SYNC, this::trackMannequinTeleport);
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.MOVE_ENTITY_POS, packetWrapper -> this.storeMovementMannequinData(packetWrapper, true, false));
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.MOVE_ENTITY_POS_ROT, packetWrapper -> this.storeMovementMannequinData(packetWrapper, true, true));
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.MOVE_ENTITY_ROT, packetWrapper -> this.storeMovementMannequinData(packetWrapper, false, true));
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.ROTATE_HEAD, packetWrapper -> {
            MannequinData mannequinData;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            byte by = packetWrapper.passthrough(Types.BYTE);
            EntityTracker1_21_9 entityTracker1_21_9 = (EntityTracker1_21_9)this.tracker(packetWrapper.user());
            TrackedEntity trackedEntity = entityTracker1_21_9.entity(n);
            if (trackedEntity != null && (mannequinData = trackedEntity.get(MannequinData.class)) != null) {
                mannequinData.setHeadYaw(by);
            }
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_PASSENGERS, packetWrapper -> {
            MannequinData mannequinData;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            int[] nArray = packetWrapper.passthrough(Types.VAR_INT_ARRAY_PRIMITIVE);
            EntityTracker1_21_9 entityTracker1_21_9 = (EntityTracker1_21_9)this.tracker(packetWrapper.user());
            TrackedEntity trackedEntity = entityTracker1_21_9.entity(n);
            if (trackedEntity != null && (mannequinData = trackedEntity.get(MannequinData.class)) != null) {
                mannequinData.setPassengers(nArray);
            }
        });
        ((Protocol1_21_9To1_21_7)this.protocol).replaceClientbound(ClientboundPackets1_21_9.SET_EQUIPMENT, packetWrapper -> {
            byte by;
            int n = packetWrapper.passthrough(Types.VAR_INT);
            TrackedEntity trackedEntity = this.tracker(packetWrapper.user()).entity(n);
            MannequinData mannequinData = trackedEntity != null ? trackedEntity.get(MannequinData.class) : null;
            do {
                by = packetWrapper.passthrough(Types.BYTE);
                Item item = ((Protocol1_21_9To1_21_7)this.protocol).getItemRewriter().handleItemToClient(packetWrapper.user(), packetWrapper.read(((Protocol1_21_9To1_21_7)this.protocol).getItemRewriter().itemType()));
                packetWrapper.write(((Protocol1_21_9To1_21_7)this.protocol).getItemRewriter().mappedItemType(), item);
                if (mannequinData == null) continue;
                mannequinData.setEquipment((byte)(by & 0x7F), item);
            } while (by < 0);
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_ENTITY_MOTION, packetWrapper -> {
            packetWrapper.passthrough(Types.VAR_INT);
            this.writeMovementShorts(packetWrapper, packetWrapper.read(Types.LOW_PRECISION_VECTOR));
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.PLAYER_ROTATION, packetWrapper -> {
            PlayerRotationStorage playerRotationStorage = packetWrapper.user().get(PlayerRotationStorage.class);
            float f = packetWrapper.read(Types.FLOAT).floatValue();
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                f = playerRotationStorage.yaw() + f;
            }
            float f2 = packetWrapper.read(Types.FLOAT).floatValue();
            if (packetWrapper.read(Types.BOOLEAN).booleanValue()) {
                f2 = playerRotationStorage.pitch() + f2;
            }
            packetWrapper.write(Types.FLOAT, Float.valueOf(f));
            packetWrapper.write(Types.FLOAT, Float.valueOf(f2));
            playerRotationStorage.setRotation(f, f2);
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerClientbound(ClientboundPackets1_21_9.SET_DEFAULT_SPAWN_POSITION, packetWrapper -> {
            GlobalBlockPosition globalBlockPosition = packetWrapper.read(Types.GLOBAL_POSITION);
            packetWrapper.write(Types.BLOCK_POSITION1_14, new BlockPosition(globalBlockPosition.x(), globalBlockPosition.y(), globalBlockPosition.z()));
            packetWrapper.passthrough(Types.FLOAT);
            packetWrapper.read(Types.FLOAT);
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerServerbound(ServerboundPackets1_21_6.MOVE_PLAYER_POS_ROT, packetWrapper -> {
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            packetWrapper.passthrough(Types.DOUBLE);
            this.storePlayerRotation(packetWrapper);
        });
        ((Protocol1_21_9To1_21_7)this.protocol).registerServerbound(ServerboundPackets1_21_6.MOVE_PLAYER_ROT, this::storePlayerRotation);
    }

    private void trackMannequinTeleport(PacketWrapper packetWrapper) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        EntityTracker1_21_9 entityTracker1_21_9 = (EntityTracker1_21_9)this.tracker(packetWrapper.user());
        TrackedEntity trackedEntity = entityTracker1_21_9.entity(n);
        if (trackedEntity == null) {
            return;
        }
        MannequinData mannequinData = trackedEntity.get(MannequinData.class);
        if (mannequinData == null) {
            return;
        }
        double d = packetWrapper.passthrough(Types.DOUBLE);
        double d2 = packetWrapper.passthrough(Types.DOUBLE);
        double d3 = packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.passthrough(Types.DOUBLE);
        packetWrapper.passthrough(Types.DOUBLE);
        byte by = (byte)Math.floor(packetWrapper.passthrough(Types.FLOAT).floatValue() * 256.0f / 360.0f);
        byte by2 = (byte)Math.floor(packetWrapper.passthrough(Types.FLOAT).floatValue() * 256.0f / 360.0f);
        mannequinData.setPosition(d, d2, d3);
        mannequinData.setRotation(by, by2);
    }

    private void storeMovementMannequinData(PacketWrapper packetWrapper, boolean bl, boolean bl2) {
        int n = packetWrapper.passthrough(Types.VAR_INT);
        TrackedEntity trackedEntity = this.tracker(packetWrapper.user()).entity(n);
        if (trackedEntity == null) {
            return;
        }
        MannequinData mannequinData = trackedEntity.get(MannequinData.class);
        if (mannequinData == null) {
            return;
        }
        if (bl) {
            double d = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double d2 = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            double d3 = (double)packetWrapper.passthrough(Types.SHORT).shortValue() / 4096.0;
            mannequinData.setPosition(mannequinData.x() + d, mannequinData.y() + d2, mannequinData.z() + d3);
        }
        if (bl2) {
            byte by = packetWrapper.passthrough(Types.BYTE);
            byte by2 = packetWrapper.passthrough(Types.BYTE);
            mannequinData.setRotation(by, by2);
        }
    }

    private void sendInitialPlayerInfoUpdate(UserConnection userConnection, MannequinData mannequinData, GameProfile.Property[] propertyArray) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.PLAYER_INFO_UPDATE, userConnection);
        BitSet bitSet = new BitSet(8);
        for (int i = 0; i < 8; ++i) {
            bitSet.set(i);
        }
        packetWrapper.write(Types.PROFILE_ACTIONS_ENUM1_21_4, bitSet);
        packetWrapper.write(Types.VAR_INT, 1);
        packetWrapper.write(Types.UUID, mannequinData.uuid());
        packetWrapper.write(Types.STRING, mannequinData.name());
        packetWrapper.write(Types.PROFILE_PROPERTY_ARRAY, propertyArray);
        packetWrapper.write(Types.BOOLEAN, false);
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(Types.BOOLEAN, false);
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(Types.TRUSTED_OPTIONAL_TAG, null);
        packetWrapper.write(Types.VAR_INT, 1000);
        packetWrapper.write(Types.BOOLEAN, true);
        packetWrapper.send(Protocol1_21_9To1_21_7.class);
        this.sendPlayerTeamDisplayName(userConnection, mannequinData, mannequinData.displayName());
    }

    private void sendPlayerInfoDisplayNameUpdate(UserConnection userConnection, MannequinData mannequinData, @Nullable Tag tag) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.PLAYER_INFO_UPDATE, userConnection);
        BitSet bitSet = new BitSet(8);
        bitSet.set(5);
        packetWrapper.write(Types.PROFILE_ACTIONS_ENUM1_21_4, bitSet);
        packetWrapper.write(Types.VAR_INT, 1);
        packetWrapper.write(Types.UUID, mannequinData.uuid());
        packetWrapper.write(Types.TRUSTED_OPTIONAL_TAG, tag);
        packetWrapper.send(Protocol1_21_9To1_21_7.class);
        this.sendPlayerTeamDisplayName(userConnection, mannequinData, tag);
    }

    private void sendPlayerTeamDisplayName(UserConnection userConnection, MannequinData mannequinData, Tag tag) {
        Tag tag2 = tag != null ? tag : new StringTag("Mannequin");
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.SET_PLAYER_TEAM, userConnection);
        packetWrapper.write(Types.STRING, mannequinData.name());
        packetWrapper.write(Types.BYTE, mannequinData.hasTeam() ? (byte)2 : 0);
        packetWrapper.write(Types.TRUSTED_TAG, tag2);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(Types.VAR_INT, 0);
        packetWrapper.write(Types.VAR_INT, 15);
        packetWrapper.write(Types.TRUSTED_TAG, tag2);
        packetWrapper.write(Types.TRUSTED_TAG, new StringTag(""));
        if (!mannequinData.hasTeam()) {
            packetWrapper.write(Types.STRING_ARRAY, new String[]{mannequinData.name()});
            mannequinData.setHasTeam(true);
        }
        packetWrapper.send(Protocol1_21_9To1_21_7.class);
    }

    private String randomHackyEmptyName() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; ++i) {
            int n = ThreadLocalRandom.current().nextInt("0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".length());
            stringBuilder.append('\u00a7').append("0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".charAt(n));
        }
        return stringBuilder.toString();
    }

    private void writeMovementShorts(PacketWrapper packetWrapper, Vector3d vector3d) {
        packetWrapper.write(Types.SHORT, VelocityUtil.toLegacyVelocity(vector3d.x()));
        packetWrapper.write(Types.SHORT, VelocityUtil.toLegacyVelocity(vector3d.y()));
        packetWrapper.write(Types.SHORT, VelocityUtil.toLegacyVelocity(vector3d.z()));
    }

    private void storePlayerRotation(PacketWrapper packetWrapper) {
        float f = packetWrapper.passthrough(Types.FLOAT).floatValue();
        float f2 = packetWrapper.passthrough(Types.FLOAT).floatValue();
        packetWrapper.user().get(PlayerRotationStorage.class).setRotation(f, f2);
    }

    @Override
    protected void registerRewrites() {
        EntityDataTypes1_21_5 entityDataTypes1_21_5 = (EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_21_9To1_21_7)this.protocol).mappedTypes()).entityDataTypes();
        this.dataTypeMapper().added(entityDataTypes1_21_5.compoundTagType).removed(((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).copperGolemState).removed(((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).weatheringCopperState).removed(((EntityDataTypes1_21_9)VersionedTypes.V1_21_9.entityDataTypes).mannequinProfileType).register();
        this.registerEntityDataTypeHandler1_20_3(entityDataTypes1_21_5.itemType, entityDataTypes1_21_5.blockStateType, entityDataTypes1_21_5.optionalBlockStateType, entityDataTypes1_21_5.particleType, entityDataTypes1_21_5.particlesType, entityDataTypes1_21_5.componentType, entityDataTypes1_21_5.optionalComponentType);
        this.filter().type(EntityTypes1_21_9.COPPER_GOLEM).cancel(16);
        this.filter().type(EntityTypes1_21_9.COPPER_GOLEM).cancel(17);
        EntityDataHandler entityDataHandler = (entityDataHandlerEvent, entityData) -> {
            CompoundTag compoundTag = new CompoundTag();
            Integer n = (Integer)entityData.value();
            if (n != null) {
                compoundTag.putString("id", "parrot");
                compoundTag.putInt("Variant", n);
            }
            entityData.setTypeAndValue(((EntityDataTypes1_21_5)((Types1_20_5)((Protocol1_21_9To1_21_7)this.protocol).mappedTypes()).entityDataTypes).compoundTagType, compoundTag);
        };
        this.filter().type(EntityTypes1_21_9.PLAYER).index(19).handler(entityDataHandler);
        this.filter().type(EntityTypes1_21_9.PLAYER).index(20).handler(entityDataHandler);
        this.filter().type(EntityTypes1_21_9.PLAYER).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() == 15) {
                entityDataHandlerEvent.setIndex(18);
            } else if (entityDataHandlerEvent.index() == 16) {
                entityDataHandlerEvent.setIndex(17);
            } else if (entityDataHandlerEvent.index() == 17 || entityDataHandlerEvent.index() == 18) {
                entityDataHandlerEvent.setIndex(entityDataHandlerEvent.index() - 2);
            }
        });
        this.filter().type(EntityTypes1_21_9.MANNEQUIN).handler((entityDataHandlerEvent, entityData) -> {
            if (entityDataHandlerEvent.index() == 2) {
                Tag tag = (Tag)entityData.value();
                MannequinData mannequinData = entityDataHandlerEvent.trackedEntity().get(MannequinData.class);
                mannequinData.setDisplayName(tag);
                this.sendPlayerInfoDisplayNameUpdate(entityDataHandlerEvent.user(), mannequinData, tag);
            } else if (entityDataHandlerEvent.index() == 17) {
                PacketWrapper packetWrapper;
                Object object;
                boolean bl = entityDataHandlerEvent.user().get(BundleStateTracker.class).isBundling();
                if (!bl) {
                    object = PacketWrapper.create(ClientboundPackets1_21_6.BUNDLE_DELIMITER, entityDataHandlerEvent.user());
                    object.send(Protocol1_21_9To1_21_7.class);
                }
                object = (ResolvableProfile)entityData.value();
                MannequinData mannequinData = entityDataHandlerEvent.trackedEntity().get(MannequinData.class);
                UUID uUID = mannequinData.uuid();
                PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_21_6.REMOVE_ENTITIES, entityDataHandlerEvent.user());
                packetWrapper2.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{entityDataHandlerEvent.entityId()});
                packetWrapper2.send(Protocol1_21_9To1_21_7.class);
                PacketWrapper packetWrapper3 = PacketWrapper.create(ClientboundPackets1_21_6.PLAYER_INFO_REMOVE, entityDataHandlerEvent.user());
                packetWrapper3.write(Types.UUID_ARRAY, new UUID[]{uUID});
                packetWrapper3.send(Protocol1_21_9To1_21_7.class);
                this.sendInitialPlayerInfoUpdate(entityDataHandlerEvent.user(), mannequinData, ((ResolvableProfile)object).profile().properties());
                PacketWrapper packetWrapper4 = PacketWrapper.create(ClientboundPackets1_21_6.ADD_ENTITY, entityDataHandlerEvent.user());
                packetWrapper4.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                packetWrapper4.write(Types.UUID, mannequinData.uuid());
                packetWrapper4.write(Types.VAR_INT, EntityTypes1_21_6.PLAYER.getId());
                packetWrapper4.write(Types.DOUBLE, mannequinData.x());
                packetWrapper4.write(Types.DOUBLE, mannequinData.y());
                packetWrapper4.write(Types.DOUBLE, mannequinData.z());
                packetWrapper4.write(Types.BYTE, mannequinData.pitch());
                packetWrapper4.write(Types.BYTE, mannequinData.yaw());
                packetWrapper4.write(Types.BYTE, mannequinData.headYaw());
                packetWrapper4.write(Types.VAR_INT, 0);
                packetWrapper4.write(Types.SHORT, (short)0);
                packetWrapper4.write(Types.SHORT, (short)0);
                packetWrapper4.write(Types.SHORT, (short)0);
                packetWrapper4.send(Protocol1_21_9To1_21_7.class);
                PacketWrapper packetWrapper5 = PacketWrapper.create(ClientboundPackets1_21_6.SET_ENTITY_DATA, entityDataHandlerEvent.user());
                packetWrapper5.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                packetWrapper5.write(VersionedTypes.V1_21_6.entityDataList, mannequinData.entityData());
                packetWrapper5.send(Protocol1_21_9To1_21_7.class);
                if (mannequinData.passengers() != null) {
                    packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.SET_PASSENGERS, entityDataHandlerEvent.user());
                    packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                    packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, mannequinData.passengers());
                    packetWrapper.send(Protocol1_21_9To1_21_7.class);
                }
                if (!mannequinData.itemMap().isEmpty()) {
                    packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.SET_EQUIPMENT, entityDataHandlerEvent.user());
                    packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                    int n = 0;
                    for (Map.Entry<Byte, Item> entry : mannequinData.itemMap().entrySet()) {
                        boolean bl2 = n < mannequinData.itemMap().size() - 1;
                        packetWrapper.write(Types.BYTE, bl2 ? (byte)(entry.getKey() | 0xFFFFFF80) : entry.getKey());
                        packetWrapper.write(((Protocol1_21_9To1_21_7)this.protocol).getItemRewriter().mappedItemType(), entry.getValue());
                        ++n;
                    }
                    packetWrapper.send(Protocol1_21_9To1_21_7.class);
                }
                packetWrapper = PacketWrapper.create(ClientboundPackets1_21_6.ROTATE_HEAD, entityDataHandlerEvent.user());
                packetWrapper.write(Types.VAR_INT, entityDataHandlerEvent.entityId());
                packetWrapper.write(Types.BYTE, mannequinData.headYaw());
                packetWrapper.send(Protocol1_21_9To1_21_7.class);
                if (!bl) {
                    PacketWrapper packetWrapper6 = PacketWrapper.create(ClientboundPackets1_21_6.BUNDLE_DELIMITER, entityDataHandlerEvent.user());
                    packetWrapper6.send(Protocol1_21_9To1_21_7.class);
                }
                entityDataHandlerEvent.cancel();
            } else if (entityDataHandlerEvent.index() == 15) {
                entityDataHandlerEvent.setIndex(18);
            } else if (entityDataHandlerEvent.index() == 16) {
                entityDataHandlerEvent.setIndex(17);
            } else if (entityDataHandlerEvent.index() == 18) {
                entityDataHandlerEvent.cancel();
            } else if (entityDataHandlerEvent.index() == 19) {
                entityDataHandlerEvent.cancel();
            }
        });
    }

    @Override
    public void handleEntityData(int n, List<EntityData> list, UserConnection userConnection) {
        super.handleEntityData(n, list, userConnection);
        EntityTracker1_21_9 entityTracker1_21_9 = (EntityTracker1_21_9)this.tracker(userConnection);
        EntityType entityType = entityTracker1_21_9.entityType(n);
        if (entityType == null || !entityType.isOrHasParent(EntityTypes1_21_9.MANNEQUIN)) {
            return;
        }
        MannequinData mannequinData = entityTracker1_21_9.entity(n).get(MannequinData.class);
        if (mannequinData == null) {
            return;
        }
        List<EntityData> list2 = mannequinData.entityData();
        list2.removeIf(entityData -> list.stream().anyMatch(entityData2 -> entityData.id() == entityData2.id()));
        for (EntityData entityData2 : list) {
            Object t = entityData2.value();
            list2.add(new EntityData(entityData2.id(), entityData2.dataType(), Copyable.copy(t)));
        }
    }

    @Override
    public void onMappingDataLoaded() {
        super.onMappingDataLoaded();
        this.mapEntityTypeWithData(EntityTypes1_21_9.COPPER_GOLEM, EntityTypes1_21_9.FROG).tagName();
        this.mapEntityTypeWithData(EntityTypes1_21_9.MANNEQUIN, EntityTypes1_21_9.PLAYER);
    }

    @Override
    public EntityType typeFromId(int n) {
        return EntityTypes1_21_9.getTypeFromId(n);
    }
}

