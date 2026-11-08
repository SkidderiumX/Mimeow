/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.protocol.v1_11to1_10.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class WindowTracker
implements StorableObject {
    private String inventory;
    private int entityId = -1;

    public String getInventory() {
        return this.inventory;
    }

    public void setInventory(String string) {
        this.inventory = string;
    }

    public int getEntityId() {
        return this.entityId;
    }

    public void setEntityId(int n) {
        this.entityId = n;
    }

    public String toString() {
        return "WindowTracker{inventory='" + this.inventory + "', entityId=" + this.entityId + "}";
    }
}

