/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data;

import com.viaversion.viarewind.api.minecraft.entitydata.EntityDataTypes1_7_6_10;
import com.viaversion.viarewind.api.minecraft.math.AABB;
import com.viaversion.viarewind.api.minecraft.math.Vector3d;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.EntityDataIndex1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.rewriter.EntityPacketRewriter1_8;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.EntityTracker1_8;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_8;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.TrackedEntityImpl;
import com.viaversion.viaversion.rewriter.entitydata.EntityDataHandlerEventImpl;
import java.util.ArrayList;
import java.util.List;

public class VirtualHologramEntity {
    private final List<EntityData> entityDataTracker = new ArrayList<EntityData>();
    private final UserConnection user;
    private final int entityId;
    private double locX;
    private double locY;
    private double locZ;
    private int[] entityIds = null;
    private State currentState = null;
    private String name = null;
    private float yaw;
    private float pitch;
    private float headYaw;
    private byte flags = 0;
    private byte armorStandFlags = 0;
    private boolean small = false;
    private boolean marker = false;
    private boolean sneaking = false;
    private boolean gravity = false;
    private byte alwaysShowNametag;

    public VirtualHologramEntity(UserConnection userConnection, int n) {
        this.user = userConnection;
        this.entityId = n;
    }

    public void setPosition(double d, double d2, double d3) {
        if (d == this.locX && d2 == this.locY && d3 == this.locZ) {
            return;
        }
        this.locX = d;
        this.locY = d2;
        this.locZ = d3;
        this.updateLocation();
    }

    public void setRelativePosition(double d, double d2, double d3) {
        if (d == 0.0 && d2 == 0.0 && d3 == 0.0) {
            return;
        }
        this.locX += d;
        this.locY += d2;
        this.locZ += d3;
        this.updateLocation();
    }

    public void setRotation(float f, float f2) {
        if (this.yaw == f || this.headYaw == f || this.pitch == f2) {
            return;
        }
        this.yaw = f;
        this.headYaw = f;
        this.pitch = f2;
        this.updateLocation();
    }

    public void setHeadYaw(float f) {
        if (this.headYaw == f) {
            return;
        }
        this.headYaw = f;
        this.updateLocation();
    }

    public void syncState(EntityPacketRewriter1_8 entityPacketRewriter1_8, List<EntityData> list) {
        Object object2;
        for (Object object2 : list) {
            this.entityDataTracker.removeIf(arg_0 -> VirtualHologramEntity.lambda$syncState$0((EntityData)object2, arg_0));
            this.entityDataTracker.add((EntityData)object2);
        }
        for (Object object2 : this.entityDataTracker) {
            if (object2.id() == 0 && object2.dataType() == EntityDataTypes1_8.BYTE) {
                this.flags = ((Number)object2.getValue()).byteValue();
                continue;
            }
            if (object2.id() == 2 && object2.dataType() == EntityDataTypes1_8.STRING) {
                this.name = object2.getValue().toString();
                if (this.name == null || !this.name.isEmpty()) continue;
                this.name = null;
                continue;
            }
            if (object2.id() == 3 && object2.dataType() == EntityDataTypes1_8.BYTE) {
                this.alwaysShowNametag = ((Number)object2.getValue()).byteValue();
                continue;
            }
            if (object2.id() != 10 || object2.dataType() != EntityDataTypes1_8.BYTE) continue;
            this.armorStandFlags = ((Number)object2.getValue()).byteValue();
        }
        boolean bl = (this.flags & 0x20) != 0;
        this.sneaking = (this.flags & 2) != 0;
        this.small = (this.armorStandFlags & 1) != 0;
        this.marker = (this.armorStandFlags & 0x10) != 0;
        this.gravity = (this.armorStandFlags & 2) == 0;
        object2 = this.currentState;
        this.currentState = bl && this.name != null && this.alwaysShowNametag == 1 ? State.HOLOGRAM : (this.gravity ? State.ZOMBIE : State.ZOMBIE_NO_GRAVITY);
        if (this.currentState != object2) {
            this.deleteEntity();
            this.sendSpawnPacket(entityPacketRewriter1_8);
        } else {
            this.sendEntityDataUpdate(entityPacketRewriter1_8);
            this.updateLocation();
        }
    }

    private void updateLocation() {
        if (this.entityIds == null) {
            return;
        }
        if (this.currentState == State.ZOMBIE) {
            this.teleportEntity(this.entityId, this.locX, this.locY, this.locZ, this.yaw, this.pitch);
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.ROTATE_HEAD, this.user);
            packetWrapper.write(Types.INT, this.entityId);
            packetWrapper.write(Types.BYTE, (byte)(this.headYaw / 360.0f * 256.0f));
            packetWrapper.send(Protocol1_8To1_7_6_10.class);
        } else if (this.currentState == State.HOLOGRAM || this.currentState == State.ZOMBIE_NO_GRAVITY) {
            this.teleportEntity(this.entityIds[1], this.locX, this.locY + this.getOffset(), this.locZ, 0.0f, 0.0f);
        }
    }

    private double getOffset() {
        if (this.currentState == State.HOLOGRAM) {
            double d = 54.35;
            if (this.marker) {
                return d;
            }
            if (this.small) {
                return d + 0.9875;
            }
            return d + 1.975;
        }
        if (this.currentState == State.ZOMBIE_NO_GRAVITY) {
            double d = -2.0625;
            if (this.marker) {
                return d;
            }
            return d + 1.48125;
        }
        return -0.4;
    }

    protected void teleportEntity(int n, double d, double d2, double d3, float f, float f2) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.TELEPORT_ENTITY, this.user);
        packetWrapper.write(Types.INT, n);
        packetWrapper.write(Types.INT, (int)(d * 32.0));
        packetWrapper.write(Types.INT, (int)(d2 * 32.0));
        packetWrapper.write(Types.INT, (int)(d3 * 32.0));
        packetWrapper.write(Types.BYTE, (byte)(f / 360.0f * 256.0f));
        packetWrapper.write(Types.BYTE, (byte)(f2 / 360.0f * 256.0f));
        packetWrapper.send(Protocol1_8To1_7_6_10.class);
    }

    protected void spawnEntity(int n, int n2, double d, double d2, double d3, List<EntityData> list) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.ADD_MOB, this.user);
        packetWrapper.write(Types.VAR_INT, n);
        packetWrapper.write(Types.UNSIGNED_BYTE, (short)n2);
        packetWrapper.write(Types.INT, (int)(d * 32.0));
        packetWrapper.write(Types.INT, (int)(d2 * 32.0));
        packetWrapper.write(Types.INT, (int)(d3 * 32.0));
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(RewindTypes.ENTITY_DATA_LIST1_7, list);
        packetWrapper.send(Protocol1_8To1_7_6_10.class);
    }

    public void sendEntityDataUpdate(EntityPacketRewriter1_8 entityPacketRewriter1_8) {
        if (this.entityIds == null) {
            return;
        }
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_DATA, this.user);
        if (this.currentState == State.ZOMBIE || this.currentState == State.ZOMBIE_NO_GRAVITY) {
            this.writeZombieMeta(entityPacketRewriter1_8, packetWrapper);
        } else if (this.currentState == State.HOLOGRAM) {
            this.writeHologramMeta(packetWrapper);
        } else {
            return;
        }
        packetWrapper.send(Protocol1_8To1_7_6_10.class);
    }

    private void writeZombieMeta(EntityPacketRewriter1_8 entityPacketRewriter1_8, PacketWrapper packetWrapper) {
        packetWrapper.write(Types.INT, this.entityIds[0]);
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        for (EntityData entityData : this.entityDataTracker) {
            if (entityData.id() < 0 || entityData.id() > 9) continue;
            arrayList.add(new EntityData(entityData.id(), entityData.dataType(), entityData.getValue()));
        }
        if (this.small) {
            arrayList.add(new EntityData(12, EntityDataTypes1_8.BYTE, (byte)1));
        }
        for (EntityData entityData : arrayList.toArray(new EntityData[0])) {
            EntityDataHandlerEventImpl entityDataHandlerEventImpl = new EntityDataHandlerEventImpl(packetWrapper.user(), new TrackedEntityImpl(EntityTypes1_8.EntityType.ZOMBIE), -1, entityData, arrayList);
            try {
                entityPacketRewriter1_8.handleEntityData(entityDataHandlerEventImpl, entityData);
            }
            catch (Exception exception) {
                arrayList.remove(entityData);
                break;
            }
            if (!entityDataHandlerEventImpl.cancelled()) continue;
            arrayList.remove(entityData);
            break;
        }
        packetWrapper.write(RewindTypes.ENTITY_DATA_LIST1_7, arrayList);
    }

    private void writeHologramMeta(PacketWrapper packetWrapper) {
        packetWrapper.write(Types.INT, this.entityIds[0]);
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(EntityDataIndex1_7_6_10.ENTITY_FLAGS.getIndex(), EntityDataTypes1_7_6_10.BYTE, (byte)(this.sneaking ? 2 : 0)));
        arrayList.add(new EntityData(EntityDataIndex1_7_6_10.ABSTRACT_AGEABLE_AGE.getIndex(), EntityDataTypes1_7_6_10.INT, -1700000));
        arrayList.add(new EntityData(EntityDataIndex1_7_6_10.LIVING_ENTITY_BASE_NAME_TAG.getIndex(), EntityDataTypes1_7_6_10.STRING, this.name));
        arrayList.add(new EntityData(EntityDataIndex1_7_6_10.LIVING_ENTITY_BASE_NAME_TAG_VISIBILITY.getIndex(), EntityDataTypes1_7_6_10.BYTE, this.alwaysShowNametag));
        packetWrapper.write(RewindTypes.ENTITY_DATA_LIST1_7, arrayList);
    }

    public void sendSpawnPacket(EntityPacketRewriter1_8 entityPacketRewriter1_8) {
        Object object;
        if (this.entityIds != null) {
            this.deleteEntity();
        }
        if (this.currentState == State.ZOMBIE) {
            this.spawnEntity(this.entityId, EntityTypes1_8.EntityType.ZOMBIE.getId(), this.locX, this.locY, this.locZ, new ArrayList<EntityData>());
            this.entityIds = new int[]{this.entityId};
        } else if (this.currentState == State.ZOMBIE_NO_GRAVITY || this.currentState == State.HOLOGRAM) {
            object = new int[]{this.entityId, this.additionalEntityId()};
            ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
            arrayList.add(new EntityData(0, EntityDataTypes1_8.BYTE, (byte)32));
            if (this.currentState == State.HOLOGRAM) {
                this.spawnEntity(object[0], EntityTypes1_8.EntityType.HORSE.getId(), this.locX, this.locY + (this.getOffset() + 0.68), this.locZ, new ArrayList<EntityData>());
            } else {
                this.spawnEntity(object[0], EntityTypes1_8.EntityType.ZOMBIE.getId(), this.locX, this.locY, this.locZ, new ArrayList<EntityData>());
            }
            this.spawnEntity((int)object[1], EntityTypes1_8.EntityType.SQUID.getId(), this.locX, this.locY + this.getOffset(), this.locZ, arrayList);
            this.entityIds = (int[])object;
        }
        for (int n : this.entityIds) {
            if (n == this.entityId) continue;
            ((EntityTracker1_8)this.user.getEntityTracker(Protocol1_8To1_7_6_10.class)).setExtraHologramId(this.entityId, n);
        }
        this.sendEntityDataUpdate(entityPacketRewriter1_8);
        if (this.entityIds == null) {
            return;
        }
        if (this.currentState == State.ZOMBIE) {
            this.updateLocation();
        } else {
            object = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_LINK, this.user);
            object.write(Types.INT, this.entityIds[0]);
            object.write(Types.INT, this.entityIds[1]);
            object.write(Types.BOOLEAN, false);
            object.send(Protocol1_8To1_7_6_10.class);
        }
    }

    public AABB getBoundingBox() {
        double d = this.small ? 0.25 : 0.5;
        double d2 = this.small ? 0.9875 : 1.975;
        Vector3d vector3d = new Vector3d(this.locX - d / 2.0, this.locY, this.locZ - d / 2.0);
        Vector3d vector3d2 = new Vector3d(this.locX + d / 2.0, this.locY + d2, this.locZ + d / 2.0);
        return new AABB(vector3d, vector3d2);
    }

    private int additionalEntityId() {
        return 2147467647 - this.entityId;
    }

    public void deleteEntity() {
        if (this.entityIds == null) {
            return;
        }
        for (int n : this.entityIds) {
            if (n == this.entityId) continue;
            ((EntityTracker1_8)this.user.getEntityTracker(Protocol1_8To1_7_6_10.class)).removeExtraHologramId(n);
        }
        Object object = PacketWrapper.create(ClientboundPackets1_7_2_5.REMOVE_ENTITIES, this.user);
        object.write(Types.BYTE, (byte)this.entityIds.length);
        for (int n : this.entityIds) {
            object.write(Types.INT, n);
        }
        this.entityIds = null;
        object.send(Protocol1_8To1_7_6_10.class);
    }

    private static /* synthetic */ boolean lambda$syncState$0(EntityData entityData, EntityData entityData2) {
        return entityData2.id() == entityData.id();
    }

    private static enum State {
        HOLOGRAM,
        ZOMBIE,
        ZOMBIE_NO_GRAVITY;

    }
}

