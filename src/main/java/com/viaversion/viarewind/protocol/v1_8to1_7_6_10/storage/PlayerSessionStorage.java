/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage;

import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.item.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerSessionStorage
extends StoredObject {
    private final Map<UUID, Item[]> playerEquipment = new HashMap<UUID, Item[]>();
    public boolean sprinting;
    public boolean allowFly;
    public boolean flying;
    public boolean invincible;
    public boolean creative;
    public float flySpeed;
    public float walkSpeed;
    public double receivedPosY;
    public float yaw;
    public float pitch;
    public boolean onGround;
    private double posX;
    private double posY;
    private double posZ;

    public PlayerSessionStorage(UserConnection userConnection) {
        super(userConnection);
    }

    public byte combineAbilities() {
        byte by = 0;
        if (this.invincible) {
            by = (byte)(by | 8);
        }
        if (this.allowFly) {
            by = (byte)(by | 4);
        }
        if (this.flying) {
            by = (byte)(by | 2);
        }
        if (this.creative) {
            by = (byte)(by | 1);
        }
        return by;
    }

    public double getPosX() {
        return this.posX;
    }

    public double getPosY() {
        return this.posY;
    }

    public double getPosZ() {
        return this.posZ;
    }

    public void setPos(double d, double d2, double d3) {
        this.posX = d;
        this.posY = d2;
        this.posZ = d3;
    }

    public Item getPlayerEquipment(UUID uUID, int n) {
        Item[] itemArray = this.playerEquipment.get(uUID);
        if (itemArray == null || n < 0 || n >= itemArray.length) {
            return null;
        }
        return itemArray[n];
    }

    public void setPlayerEquipment(UUID uUID2, Item item, int n) {
        Item[] itemArray = this.playerEquipment.computeIfAbsent(uUID2, uUID -> new Item[5]);
        if (n < 0 || n >= itemArray.length) {
            return;
        }
        itemArray[n] = item;
    }

    public Map<UUID, Item[]> getPlayerEquipment() {
        return this.playerEquipment;
    }
}

