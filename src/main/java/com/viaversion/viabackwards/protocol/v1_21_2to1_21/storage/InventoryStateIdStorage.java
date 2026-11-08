/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_21_2to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class InventoryStateIdStorage
implements StorableObject {
    private boolean smithingTableOpen;
    private int stateId = -1;
    private int nextClearedSlot;

    public int stateId() {
        return this.stateId;
    }

    public void setStateId(int n) {
        this.stateId = n;
    }

    public int nextClearedSlot() {
        return this.nextClearedSlot;
    }

    public void setNextClearedSlot(int n) {
        this.nextClearedSlot = n;
    }

    public boolean smithingTableOpen() {
        return this.smithingTableOpen;
    }

    public void setSmithingTableOpen(boolean bl) {
        this.smithingTableOpen = bl;
    }
}

