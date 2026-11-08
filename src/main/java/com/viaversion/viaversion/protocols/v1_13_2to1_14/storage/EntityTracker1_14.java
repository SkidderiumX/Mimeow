/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_13_2to1_14.storage;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.TrackedEntity;
import com.viaversion.viaversion.api.minecraft.entities.EntityTypes1_14;
import com.viaversion.viaversion.data.entity.EntityTrackerBase;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.viaversion.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class EntityTracker1_14
extends EntityTrackerBase {
    private final Int2ObjectMap<Byte> insentientData = new Int2ObjectOpenHashMap<Byte>();
    private final Int2ObjectMap<Byte> sleepingAndRiptideData = new Int2ObjectOpenHashMap<Byte>();
    private final Int2ObjectMap<Byte> playerEntityFlags = new Int2ObjectOpenHashMap<Byte>();
    private int latestTradeWindowId;
    private boolean forceSendCenterChunk = true;
    private int chunkCenterX;
    private int chunkCenterZ;

    public EntityTracker1_14(UserConnection userConnection) {
        super(userConnection, EntityTypes1_14.PLAYER);
    }

    @Override
    public @Nullable TrackedEntity removeEntity(int n) {
        this.insentientData.remove(n);
        this.sleepingAndRiptideData.remove(n);
        this.playerEntityFlags.remove(n);
        return super.removeEntity(n);
    }

    public byte getInsentientData(int n) {
        Byte by = (Byte)this.insentientData.get(n);
        return by == null ? (byte)0 : by;
    }

    public void setInsentientData(int n, byte by) {
        this.insentientData.put(n, (Byte)by);
    }

    private static byte zeroIfNull(Byte by) {
        if (by == null) {
            return 0;
        }
        return by;
    }

    public boolean isSleeping(int n) {
        return (EntityTracker1_14.zeroIfNull((Byte)this.sleepingAndRiptideData.get(n)) & 1) != 0;
    }

    public void setSleeping(int n, boolean bl) {
        byte by = (byte)(EntityTracker1_14.zeroIfNull((Byte)this.sleepingAndRiptideData.get(n)) & 0xFFFFFFFE | (bl ? 1 : 0));
        if (by == 0) {
            this.sleepingAndRiptideData.remove(n);
        } else {
            this.sleepingAndRiptideData.put(n, (Byte)by);
        }
    }

    public boolean isRiptide(int n) {
        return (EntityTracker1_14.zeroIfNull((Byte)this.sleepingAndRiptideData.get(n)) & 2) != 0;
    }

    public void setRiptide(int n, boolean bl) {
        byte by = (byte)(EntityTracker1_14.zeroIfNull((Byte)this.sleepingAndRiptideData.get(n)) & 0xFFFFFFFD | (bl ? 2 : 0));
        if (by == 0) {
            this.sleepingAndRiptideData.remove(n);
        } else {
            this.sleepingAndRiptideData.put(n, (Byte)by);
        }
    }

    public byte getEntityFlags(int n) {
        return EntityTracker1_14.zeroIfNull((Byte)this.playerEntityFlags.get(n));
    }

    public void setEntityFlags(int n, byte by) {
        this.playerEntityFlags.put(n, (Byte)by);
    }

    public int getLatestTradeWindowId() {
        return this.latestTradeWindowId;
    }

    public void setLatestTradeWindowId(int n) {
        this.latestTradeWindowId = n;
    }

    public boolean isForceSendCenterChunk() {
        return this.forceSendCenterChunk;
    }

    public void setForceSendCenterChunk(boolean bl) {
        this.forceSendCenterChunk = bl;
    }

    public int getChunkCenterX() {
        return this.chunkCenterX;
    }

    public void setChunkCenterX(int n) {
        this.chunkCenterX = n;
    }

    public int getChunkCenterZ() {
        return this.chunkCenterZ;
    }

    public void setChunkCenterZ(int n) {
        this.chunkCenterZ = n;
    }
}

