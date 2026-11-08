/*
 * Decompiled with CFR 0.152.
 */
package x;

import keystrokesmod.script.model.MovementInput;
import x.oc68d6b191af;
import x.oce79181588d;

public class oc70db705765
extends oc68d6b191af {
    private float \u053d;
    private float \u020d;
    private boolean \u023d;
    private boolean \u0287;
    private double \u01fd;
    public static boolean \u0206;

    public oc70db705765(float f, float f2, boolean bl, boolean bl2, double d) {
        this.\u053d = f;
        this.\u020d = f2;
        this.\u023d = bl;
        this.\u0287 = bl2;
        this.\u01fd = d;
    }

    public float \u0509() {
        return this.\u053d;
    }

    public void \u010f(float f) {
        this.\u053d = f;
    }

    public float \u01f6() {
        return this.\u020d;
    }

    public void \u0524(float f) {
        this.\u020d = f;
    }

    public boolean \u03e7() {
        return this.\u023d;
    }

    public void \u0243(boolean bl) {
        this.\u023d = bl;
    }

    public boolean \u04a7() {
        return this.\u0287;
    }

    public void \u0413(boolean bl) {
        this.\u0287 = bl;
    }

    public double \u016b() {
        return this.\u01fd;
    }

    public void \u0179(double d) {
        this.\u01fd = d;
    }

    public boolean \u053c(MovementInput movementInput) {
        boolean bl;
        block18: {
            block15: {
                float f;
                float f2;
                int n;
                block17: {
                    MovementInput movementInput2;
                    block16: {
                        block14: {
                            n = oce79181588d.\u022d;
                            movementInput2 = movementInput;
                            if (n != 0) break block14;
                            if (movementInput2.sneak != this.\u0287) break block15;
                            movementInput2 = movementInput;
                        }
                        if (n != 0) break block16;
                        if (movementInput2.jump != this.\u023d) break block15;
                        movementInput2 = movementInput;
                    }
                    float f = movementInput2.forward;
                    f = this.\u053d;
                    if (n != 0) break block17;
                    if (f2 != f) break block15;
                    float f = movementInput.strafe;
                    f = this.\u020d;
                }
                float f3 = f2 - f;
                bl = f3 == 0.0f ? 0 : (f3 > 0.0f ? 1 : -1);
                if (n != 0) break block18;
                if (bl) break block15;
                bl = true;
                break block18;
            }
            bl = false;
        }
        return bl;
    }
}

