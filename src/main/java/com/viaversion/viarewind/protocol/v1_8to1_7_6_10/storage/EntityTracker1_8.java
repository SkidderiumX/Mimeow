/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage;

import com.viaversion.viarewind.ViaRewind;
import com.viaversion.viarewind.api.minecraft.entitydata.EntityDataTypes1_7_6_10;
import com.viaversion.viarewind.api.type.RewindTypes;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ServerboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.Protocol1_8To1_7_6_10;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.data.VirtualHologramEntity;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.GameProfileStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.PlayerSessionStorage;
import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.ScoreboardTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityType;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_8;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2IntMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectArrayMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntMap;
import com.viaversion.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_8;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;

public class EntityTracker1_8
extends EntityTrackerBase {
    private final Int2ObjectMap<VirtualHologramEntity> holograms = new Int2ObjectArrayMap<VirtualHologramEntity>();
    private final Int2IntMap extraHologramIds = new Int2IntArrayMap();
    private final Int2IntMap vehicles = new Int2IntArrayMap();
    private final Int2ObjectMap<UUID> entityIdToUUID = new Int2ObjectArrayMap<UUID>();
    private final Object2IntMap<UUID> entityUUIDToId = new Object2IntOpenHashMap<UUID>();
    private final Int2IntMap playerNametagHiderEntities = new Int2IntArrayMap();
    private final List<EntityData> entityData = new ArrayList<EntityData>();
    public Integer spectatingClientEntityId;
    private int clientEntityGameMode;

    public EntityTracker1_8(UserConnection userConnection) {
        super(userConnection, EntityTypes1_8.EntityType.PLAYER);
    }

    @Override
    public TrackedEntity addEntity(int n, EntityType entityType) {
        if (entityType == EntityTypes1_8.EntityType.ARMOR_STAND) {
            this.holograms.put(n, new VirtualHologramEntity(this.user(), n));
        }
        return super.addEntity(n, entityType);
    }

    @Override
    public TrackedEntity removeEntity(int n) {
        VirtualHologramEntity virtualHologramEntity = (VirtualHologramEntity)this.holograms.get(n);
        if (virtualHologramEntity != null) {
            virtualHologramEntity.deleteEntity();
            this.holograms.remove(n);
        }
        if (this.playerNametagHiderEntities.containsKey(n)) {
            this.despawnNametagHiderEntity(n);
        }
        if (this.entityIdToUUID.containsKey(n)) {
            UUID uUID = (UUID)this.entityIdToUUID.remove(n);
            this.entityUUIDToId.removeInt(uUID);
            this.user().get(PlayerSessionStorage.class).getPlayerEquipment().remove(uUID);
        }
        return super.removeEntity(n);
    }

    @Override
    public void clearEntities() {
        super.clearEntities();
        this.holograms.clear();
        this.extraHologramIds.clear();
        this.vehicles.clear();
        this.playerNametagHiderEntities.clear();
    }

    @Override
    public void setClientEntityId(int n) {
        if (Objects.equals(this.spectatingClientEntityId, this.clientEntityIdOrNull())) {
            this.spectatingClientEntityId = n;
        }
        super.setClientEntityId(n);
    }

    public Integer clientEntityIdOrNull() {
        return this.hasClientEntityId() ? Integer.valueOf(this.clientEntityId()) : null;
    }

    public void addPlayer(int n, UUID uUID) {
        this.entityUUIDToId.put(uUID, n);
        this.entityIdToUUID.put(n, uUID);
    }

    public UUID getPlayerUUID(int n) {
        return (UUID)this.entityIdToUUID.get(n);
    }

    public int getPlayerEntityId(UUID uUID) {
        return this.entityUUIDToId.getOrDefault((Object)uUID, -1);
    }

    public int getVehicle(int n) {
        for (Map.Entry entry : this.vehicles.int2IntEntrySet()) {
            if ((Integer)entry.getValue() != n) continue;
            return (Integer)entry.getValue();
        }
        return -1;
    }

    public int getPassenger(int n) {
        return this.vehicles.getOrDefault(n, -1);
    }

    protected void startSneaking() {
        try {
            PacketWrapper packetWrapper = PacketWrapper.create(ServerboundPackets1_7_2_5.PLAYER_COMMAND, this.user());
            packetWrapper.write(Types.VAR_INT, this.clientEntityId());
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.write(Types.VAR_INT, 0);
            packetWrapper.sendToServer(Protocol1_8To1_7_6_10.class);
        }
        catch (Exception exception) {
            ViaRewind.getPlatform().getLogger().log(Level.SEVERE, "Failed to send sneak packet", exception);
        }
    }

    public void setPassenger(int n, int n2) {
        if (n == this.spectatingClientEntityId && this.spectatingClientEntityId.intValue() != this.clientEntityId()) {
            this.startSneaking();
            this.setSpectating(this.clientEntityId());
        }
        if (n == -1) {
            this.vehicles.remove(this.getVehicle(n2));
        } else if (n2 == -1) {
            this.vehicles.remove(n);
        } else {
            this.vehicles.put(n, n2);
        }
        if (n != -1 && this.entityIdToUUID.containsKey(n)) {
            this.checkNametagVisibility(n);
        }
    }

    protected void attachEntity(int n) {
        try {
            PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_8.SET_ENTITY_LINK, this.user());
            packetWrapper.write(Types.INT, this.clientEntityId());
            packetWrapper.write(Types.INT, n);
            packetWrapper.write(Types.BOOLEAN, false);
            packetWrapper.scheduleSend(Protocol1_8To1_7_6_10.class);
        }
        catch (Exception exception) {
            ViaRewind.getPlatform().getLogger().log(Level.SEVERE, "Failed to send attach packet", exception);
        }
    }

    public void setSpectating(int n) {
        if (n != this.clientEntityId() && this.getPassenger(n) != -1) {
            this.startSneaking();
            this.setSpectating(this.clientEntityId());
            return;
        }
        if (this.spectatingClientEntityId != n && this.spectatingClientEntityId.intValue() != this.clientEntityId()) {
            this.attachEntity(-1);
        }
        this.spectatingClientEntityId = n;
        if (n != this.clientEntityId()) {
            this.attachEntity(this.spectatingClientEntityId);
        }
    }

    public void checkNametagVisibility(int n) {
        if (!this.entityIdToUUID.containsKey(n)) {
            return;
        }
        boolean bl = this.isPlayerNametagHidden(n);
        boolean bl2 = this.getPassenger(n) != -1;
        boolean bl3 = this.playerNametagHiderEntities.containsKey(n);
        if (bl && !bl2 && !bl3) {
            this.spawnNametagHiderEntity(n);
        } else if ((!bl || bl2) && bl3) {
            this.despawnNametagHiderEntity(n);
        }
    }

    public void checkNametagVisbility(String string) {
        GameProfileStorage gameProfileStorage = this.user().get(GameProfileStorage.class);
        List<GameProfileStorage.GameProfile> list = gameProfileStorage.get(string, false);
        for (GameProfileStorage.GameProfile gameProfile : list) {
            int n = this.getPlayerEntityId(gameProfile.uuid);
            if (n == -1) {
                return;
            }
            this.checkNametagVisibility(n);
        }
    }

    private boolean isPlayerNametagHidden(int n) {
        UUID uUID = (UUID)this.entityIdToUUID.get(n);
        if (uUID == null) {
            return false;
        }
        GameProfileStorage gameProfileStorage = this.user().get(GameProfileStorage.class);
        GameProfileStorage.GameProfile gameProfile = gameProfileStorage.get(uUID);
        if (gameProfile == null) {
            return false;
        }
        return this.user().get(ScoreboardTracker.class).isNametagHidden(gameProfile.name);
    }

    private int getNametagHiderEntityId(int n) {
        return 2147451647 - n;
    }

    private void spawnNametagHiderEntity(int n) {
        int n2 = this.getNametagHiderEntityId(n);
        this.playerNametagHiderEntities.put(n, n2);
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(0, EntityDataTypes1_7_6_10.BYTE, (byte)32));
        arrayList.add(new EntityData(16, EntityDataTypes1_7_6_10.BYTE, (byte)0));
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.ADD_MOB, this.user());
        packetWrapper.write(Types.VAR_INT, n2);
        packetWrapper.write(Types.UNSIGNED_BYTE, (short)EntityTypes1_8.EntityType.MAGMA_CUBE.getId());
        packetWrapper.write(Types.INT, 0);
        packetWrapper.write(Types.INT, 0);
        packetWrapper.write(Types.INT, 0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(RewindTypes.ENTITY_DATA_LIST1_7, arrayList);
        packetWrapper.scheduleSend(Protocol1_8To1_7_6_10.class);
        PacketWrapper packetWrapper2 = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_LINK, this.user());
        packetWrapper2.write(Types.INT, n2);
        packetWrapper2.write(Types.INT, n);
        packetWrapper2.write(Types.BOOLEAN, false);
        packetWrapper2.scheduleSend(Protocol1_8To1_7_6_10.class);
    }

    private void despawnNametagHiderEntity(int n) {
        if (!this.playerNametagHiderEntities.containsKey(n)) {
            return;
        }
        int n2 = this.playerNametagHiderEntities.remove(n);
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.REMOVE_ENTITIES, this.user());
        packetWrapper.write(Types.BYTE, (byte)1);
        packetWrapper.write(Types.INT, n2);
        packetWrapper.scheduleSend(Protocol1_8To1_7_6_10.class);
    }

    public Int2ObjectMap<VirtualHologramEntity> getHolograms() {
        return this.holograms;
    }

    public void setExtraHologramId(int n, int n2) {
        this.extraHologramIds.put(n2, n);
    }

    public void removeExtraHologramId(int n) {
        this.extraHologramIds.remove(n);
    }

    public int getHologramIdWithExtra(int n) {
        if (this.holograms.containsKey(n)) {
            return n;
        }
        return this.extraHologramIds.getOrDefault(n, -1);
    }

    public boolean isSpectator() {
        return this.clientEntityGameMode == 3;
    }

    public void setClientEntityGameMode(int n) {
        this.clientEntityGameMode = n;
    }

    public void updateEntityData(List<EntityData> list) {
        this.entityData.removeIf(entityData -> list.stream().anyMatch(entityData2 -> entityData.id() == entityData2.id()));
        for (EntityData entityData2 : list) {
            Object t = entityData2.value();
            if (t instanceof Item) {
                Item item = (Item)t;
                this.entityData.add(new EntityData(entityData2.id(), entityData2.dataType(), item.copy()));
                continue;
            }
            this.entityData.add(new EntityData(entityData2.id(), entityData2.dataType(), t));
        }
    }

    public List<EntityData> getEntityData() {
        return this.entityData;
    }
}

