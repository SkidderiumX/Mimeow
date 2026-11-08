/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_9to1_21_7.storage;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.entitydata.EntityData;
import com.viaversion.viaversion.api.minecraft.item.Item;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MannequinData
implements StorableObject {
    private final UUID uuid;
    private final String name;
    private boolean hasTeam;
    private double x;
    private double y;
    private double z;
    private byte yaw;
    private byte pitch;
    private byte headYaw;
    private int[] passengers;
    private final List<EntityData> entityData = new ArrayList<EntityData>();
    private final Map<Byte, Item> itemMap = new HashMap<Byte, Item>();
    private Tag displayName;

    public MannequinData(UUID uUID, String string) {
        this.uuid = uUID;
        this.name = string;
    }

    public void setHasTeam(boolean bl) {
        this.hasTeam = bl;
    }

    public boolean hasTeam() {
        return this.hasTeam;
    }

    public UUID uuid() {
        return this.uuid;
    }

    public String name() {
        return this.name;
    }

    public void setPosition(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public void setRotation(byte by, byte by2) {
        this.yaw = by;
        this.pitch = by2;
    }

    public void setPassengers(int[] nArray) {
        this.passengers = nArray;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public byte yaw() {
        return this.yaw;
    }

    public byte pitch() {
        return this.pitch;
    }

    public List<EntityData> entityData() {
        return this.entityData;
    }

    public int[] passengers() {
        return this.passengers;
    }

    public void setDisplayName(Tag tag) {
        this.displayName = tag;
    }

    public Tag displayName() {
        return this.displayName;
    }

    public void setEquipment(byte by, Item item) {
        this.itemMap.put(by, item);
    }

    public Map<Byte, Item> itemMap() {
        return this.itemMap;
    }

    public byte headYaw() {
        return this.headYaw;
    }

    public void setHeadYaw(byte by) {
        this.headYaw = by;
    }
}

