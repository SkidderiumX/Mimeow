/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_18_2to1_19.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class LoomStorage
implements StorableObject {
    private int containerId = -1;

    public int containerId() {
        return this.containerId;
    }

    public void setContainerId(int n) {
        this.containerId = n;
    }

    public void reset() {
        this.containerId = -1;
    }
}

