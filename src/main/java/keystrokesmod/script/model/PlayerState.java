/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import x.oc25aa89b91f;

public class PlayerState {
    public double x;
    public double y;
    public double z;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean isSprinting;
    public boolean isSneaking;

    public PlayerState(oc25aa89b91f oc25aa89b91f2, byte by) {
        this.x = oc25aa89b91f2.\u010a();
        this.y = oc25aa89b91f2.\u01f8();
        this.z = oc25aa89b91f2.\u0465();
        this.yaw = oc25aa89b91f2.\u0541();
        this.pitch = oc25aa89b91f2.\u01bd();
        this.onGround = oc25aa89b91f2.z();
        this.isSprinting = oc25aa89b91f2.\u0531();
        this.isSneaking = oc25aa89b91f2.\u0274();
    }

    public PlayerState(Object[] objectArray) {
        this.x = (Double)objectArray[0];
        this.y = (Double)objectArray[1];
        this.z = (Double)objectArray[0x1AE91BBC ^ 0x1AE91BBE];
        this.yaw = ((Float)objectArray[0x1AE91BBD ^ 0x1AE91BBE]).floatValue();
        this.pitch = ((Float)objectArray[0x1AE91BBA ^ 0x1AE91BBE]).floatValue();
        this.onGround = (Boolean)objectArray[0x1AE91BBB ^ 0x1AE91BBE];
        this.isSprinting = (Boolean)objectArray[0x1AE91BB8 ^ 0x1AE91BBE];
        this.isSneaking = (Boolean)objectArray[0x1AE91BB9 ^ 0x1AE91BBE];
    }

    public Object[] asArray() {
        Object[] objectArray = new Object[0xB26356A4 ^ 0xB26356AC];
        objectArray[0] = this.x;
        objectArray[1] = this.y;
        objectArray[0xB26356AE ^ 0xB26356AC] = this.z;
        objectArray[0xB26356AF ^ 0xB26356AC] = Float.valueOf(this.yaw);
        objectArray[0xB26356A8 ^ 0xB26356AC] = Float.valueOf(this.pitch);
        objectArray[0xB26356A9 ^ 0xB26356AC] = this.onGround;
        objectArray[0xB26356AA ^ 0xB26356AC] = this.isSprinting;
        objectArray[0xB26356AB ^ 0xB26356AC] = this.isSneaking;
        return objectArray;
    }

    public boolean equals(PlayerState playerState) {
        if (playerState == null) {
            return false;
        }
        return this.x == playerState.x && this.y == playerState.y && this.z == playerState.z && this.yaw == playerState.yaw && this.pitch == playerState.pitch && this.onGround == playerState.onGround && this.isSprinting == playerState.isSprinting && this.isSneaking == playerState.isSneaking;
    }
}

