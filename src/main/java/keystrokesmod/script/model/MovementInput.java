/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.script.model;

import x.oc70db705765;

public class MovementInput {
    public float forward;
    public float strafe;
    public boolean jump;
    public boolean sneak;

    public MovementInput(oc70db705765 oc70db7057652, byte by) {
        this.forward = oc70db7057652.\u0509();
        this.strafe = oc70db7057652.\u01f6();
        this.jump = oc70db7057652.\u03e7();
        this.sneak = oc70db7057652.\u04a7();
    }

    public MovementInput(float f, float f2, boolean bl, boolean bl2) {
        this.forward = f;
        this.strafe = f2;
        this.jump = bl;
        this.sneak = bl2;
    }

    public MovementInput(Object[] objectArray) {
        this.forward = ((Float)objectArray[0]).floatValue();
        this.strafe = ((Float)objectArray[1]).floatValue();
        this.jump = (Boolean)objectArray[0x2D15A44C ^ 0x2D15A44E];
        this.sneak = (Boolean)objectArray[0x2D15A44D ^ 0x2D15A44E];
    }

    public Object[] asArray() {
        Object[] objectArray = new Object[0x4BE2162C ^ 0x4BE21628];
        objectArray[0] = Float.valueOf(this.forward);
        objectArray[1] = Float.valueOf(this.strafe);
        objectArray[0x4BE2162A ^ 0x4BE21628] = this.jump;
        objectArray[0x4BE2162B ^ 0x4BE21628] = this.sneak;
        return objectArray;
    }

    public boolean equals(MovementInput movementInput) {
        if (movementInput == null) {
            return false;
        }
        return this.forward == movementInput.forward && this.strafe == movementInput.strafe && this.jump == movementInput.jump && this.sneak == movementInput.sneak;
    }
}

