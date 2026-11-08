/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viabackwards.api.entities.storage;

import com.viaversion.viaversion.api.connection.StorableObject;

public abstract class PlayerPositionStorage
implements StorableObject {
    private double x;
    private double y;
    private double z;

    protected PlayerPositionStorage() {
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

    public void setX(double d) {
        this.x = d;
    }

    public void setY(double d) {
        this.y = d;
    }

    public void setZ(double d) {
        this.z = d;
    }

    public void setPosition(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public void addRelativePosition(double d, double d2, double d3) {
        this.x += d;
        this.y += d2;
        this.z += d3;
    }
}

