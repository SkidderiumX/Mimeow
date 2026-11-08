/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_9to1_8.data;

import com.viaversion.viarewind.protocol.v1_7_6_10to1_7_2_5.packet.ClientboundPackets1_7_2_5;
import com.viaversion.viarewind.protocol.v1_9to1_8.Protocol1_9To1_8;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.legacy.bossbar.BossBar;
import com.viaversion.viaversion.api.legacy.bossbar.BossColor;
import com.viaversion.viaversion.api.legacy.bossbar.BossFlag;
import com.viaversion.viaversion.api.legacy.bossbar.BossStyle;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.entitydata.types.EntityDataTypes1_8;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.UUID;

public class WitherBossBar
implements BossBar {
    private static int highestId = 2147473647;
    private final UUID uuid;
    private final UserConnection connection;
    private final int entityId = highestId++;
    private String title;
    private float health;
    private boolean visible = false;
    private double locX;
    private double locY;
    private double locZ;

    public WitherBossBar(UserConnection userConnection, UUID uUID, String string, float f) {
        this.connection = userConnection;
        this.uuid = uUID;
        this.title = string;
        this.health = f;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public BossBar setTitle(String string) {
        this.title = string;
        if (this.visible) {
            this.updateEntityData();
        }
        return this;
    }

    @Override
    public float getHealth() {
        return this.health;
    }

    @Override
    public BossBar setHealth(float f) {
        this.health = f;
        if (this.health <= 0.0f) {
            this.health = 1.0E-4f;
        }
        if (this.visible) {
            this.updateEntityData();
        }
        return this;
    }

    @Override
    public BossColor getColor() {
        return null;
    }

    @Override
    public BossBar setColor(BossColor bossColor) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support color");
    }

    @Override
    public BossStyle getStyle() {
        return null;
    }

    @Override
    public BossBar setStyle(BossStyle bossStyle) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support styles");
    }

    @Override
    public BossBar addPlayer(UUID uUID) {
        throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
    }

    @Override
    public BossBar addConnection(UserConnection userConnection) {
        throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
    }

    @Override
    public BossBar removePlayer(UUID uUID) {
        throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
    }

    @Override
    public BossBar removeConnection(UserConnection userConnection) {
        throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
    }

    @Override
    public BossBar addFlag(BossFlag bossFlag) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support flags");
    }

    @Override
    public BossBar removeFlag(BossFlag bossFlag) {
        throw new UnsupportedOperationException(this.getClass().getName() + " does not support flags");
    }

    @Override
    public boolean hasFlag(BossFlag bossFlag) {
        return false;
    }

    @Override
    public Set<UUID> getPlayers() {
        return Collections.singleton(this.connection.getProtocolInfo().getUuid());
    }

    @Override
    public Set<UserConnection> getConnections() {
        throw new UnsupportedOperationException(this.getClass().getName() + " is only for one UserConnection!");
    }

    @Override
    public BossBar show() {
        if (!this.visible) {
            this.addWither();
            this.visible = true;
        }
        return this;
    }

    @Override
    public BossBar hide() {
        if (this.visible) {
            this.removeWither();
            this.visible = false;
        }
        return this;
    }

    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public UUID getId() {
        return this.uuid;
    }

    public void setLocation(double d, double d2, double d3) {
        this.locX = d;
        this.locY = d2;
        this.locZ = d3;
        this.updateLocation();
    }

    private void addWither() {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.ADD_MOB, this.connection);
        packetWrapper.write(Types.VAR_INT, this.entityId);
        packetWrapper.write(Types.UNSIGNED_BYTE, (short)64);
        packetWrapper.write(Types.INT, (int)(this.locX * 32.0));
        packetWrapper.write(Types.INT, (int)(this.locY * 32.0));
        packetWrapper.write(Types.INT, (int)(this.locZ * 32.0));
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        packetWrapper.write(Types.SHORT, (short)0);
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(0, EntityDataTypes1_8.BYTE, (byte)32));
        arrayList.add(new EntityData(2, EntityDataTypes1_8.STRING, this.title));
        arrayList.add(new EntityData(3, EntityDataTypes1_8.BYTE, (byte)1));
        arrayList.add(new EntityData(6, EntityDataTypes1_8.FLOAT, Float.valueOf(this.health * 300.0f)));
        arrayList.add(new EntityData(20, EntityDataTypes1_8.INT, 880));
        packetWrapper.write(Types.ENTITY_DATA_LIST1_8, arrayList);
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
    }

    private void updateLocation() {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.TELEPORT_ENTITY, this.connection);
        packetWrapper.write(Types.VAR_INT, this.entityId);
        packetWrapper.write(Types.INT, (int)(this.locX * 32.0));
        packetWrapper.write(Types.INT, (int)(this.locY * 32.0));
        packetWrapper.write(Types.INT, (int)(this.locZ * 32.0));
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BYTE, (byte)0);
        packetWrapper.write(Types.BOOLEAN, false);
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
    }

    private void updateEntityData() {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.SET_ENTITY_DATA, this.connection);
        packetWrapper.write(Types.VAR_INT, this.entityId);
        ArrayList<EntityData> arrayList = new ArrayList<EntityData>();
        arrayList.add(new EntityData(2, EntityDataTypes1_8.STRING, this.title));
        arrayList.add(new EntityData(6, EntityDataTypes1_8.FLOAT, Float.valueOf(this.health * 300.0f)));
        packetWrapper.write(Types.ENTITY_DATA_LIST1_8, arrayList);
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
    }

    private void removeWither() {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_7_2_5.REMOVE_ENTITIES, this.connection);
        packetWrapper.write(Types.VAR_INT_ARRAY_PRIMITIVE, new int[]{this.entityId});
        packetWrapper.scheduleSend(Protocol1_9To1_8.class);
    }

    public void setPlayerLocation(double d, double d2, double d3, float f, float f2) {
        double d4 = Math.toRadians(f);
        double d5 = Math.toRadians(f2);
        this.setLocation(d -= Math.cos(d5) * Math.sin(d4) * 48.0, d2 -= Math.sin(d5) * 48.0, d3 += Math.cos(d5) * Math.cos(d4) * 48.0);
    }
}

