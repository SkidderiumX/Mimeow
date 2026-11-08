/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_21to1_21_2.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class ClientVehicleStorage
implements StorableObject {
    private final int vehicleId;
    private float sidewaysMovement;
    private float forwardMovement;
    private byte flags;

    public ClientVehicleStorage(int n) {
        this.vehicleId = n;
    }

    public void storeMovement(float f, float f2, byte by) {
        this.sidewaysMovement = f;
        this.forwardMovement = f2;
        this.flags = by;
    }

    public int vehicleId() {
        return this.vehicleId;
    }

    public float sidewaysMovement() {
        return this.sidewaysMovement;
    }

    public float forwardMovement() {
        return this.forwardMovement;
    }

    public byte flags() {
        return this.flags;
    }
}

