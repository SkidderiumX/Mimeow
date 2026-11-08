/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage;

import com.viaversion.viaversion.api.connection.StoredObject;
import com.viaversion.viaversion.api.connection.UserConnection;

public class WorldBorderEmulator
extends StoredObject {
    private double x;
    private double z;
    private double oldDiameter;
    private double newDiameter;
    private long lerpTime;
    private long lerpStartTime;
    private boolean init = false;

    public WorldBorderEmulator(UserConnection userConnection) {
        super(userConnection);
    }

    public void init(double d, double d2, double d3, double d4, long l) {
        this.x = d;
        this.z = d2;
        this.oldDiameter = d3;
        this.newDiameter = d4;
        this.lerpTime = l;
        this.init = true;
    }

    public void setCenter(double d, double d2) {
        this.x = d;
        this.z = d2;
    }

    public void lerpSize(double d, double d2, long l) {
        this.oldDiameter = d;
        this.newDiameter = d2;
        this.lerpTime = l;
        this.lerpStartTime = System.currentTimeMillis();
    }

    public double getSize() {
        if (this.lerpTime == 0L) {
            return this.newDiameter;
        }
        double d = (double)(System.currentTimeMillis() - this.lerpStartTime) / (double)this.lerpTime;
        if (d > 1.0) {
            d = 1.0;
        } else if (d < 0.0) {
            d = 0.0;
        }
        return this.oldDiameter + (this.newDiameter - this.oldDiameter) * d;
    }

    public void setSize(double d) {
        this.oldDiameter = d;
        this.newDiameter = d;
        this.lerpTime = 0L;
    }

    public double getX() {
        return this.x;
    }

    public double getZ() {
        return this.z;
    }

    public boolean isInit() {
        return this.init;
    }

    public static enum Side {
        NORTH(0, -1),
        EAST(1, 0),
        SOUTH(0, 1),
        WEST(-1, 0);

        public final int modX;
        public final int modZ;

        private Side(int n2, int n3) {
            this.modX = n2;
            this.modZ = n3;
        }
    }
}

