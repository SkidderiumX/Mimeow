/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_20_5to1_21.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public class PlayerPositionStorage
implements StorableObject {
    private double x;
    private double y;
    private double z;
    private boolean onGround;

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public void setPosition(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public boolean onGround() {
        return this.onGround;
    }

    public void setOnGround(boolean bl) {
        this.onGround = bl;
    }
}

