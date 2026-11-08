/*
 * Decompiled with CFR 0.152.
 */
package x;

import keystrokesmod.script.model.PlayerState;
import x.oc68d6b191af;
import x.oce79181588d;

public class oc25aa89b91f
extends oc68d6b191af {
    private double \u0509;
    public double \u042c;
    private double \u051f;
    private float \u04a8;
    private float \u03f5;
    private boolean \u0402;
    private static boolean \u021f;
    private boolean \u0170;
    private boolean \u04bd;
    public static boolean \u02ac;
    public static float \u0268;
    public static boolean \u025b;

    public oc25aa89b91f(double d, double d2, double d3, float f, float f2, boolean bl, boolean bl2, boolean bl3) {
        this.\u0509 = d;
        this.\u042c = d2;
        this.\u051f = d3;
        this.\u04a8 = f;
        this.\u03f5 = f2;
        this.\u0402 = bl;
        this.\u0170 = bl2;
        this.\u04bd = bl3;
    }

    public double \u010a() {
        return this.\u0509;
    }

    public double \u01f8() {
        return this.\u042c;
    }

    public double \u0465() {
        return this.\u051f;
    }

    public float \u0541() {
        return this.\u04a8;
    }

    public float \u01bd() {
        return this.\u03f5;
    }

    public boolean z() {
        return this.\u0402;
    }

    public void \u0169(double d) {
        this.\u0509 = d;
    }

    public void \u0436(double d) {
        this.\u042c = d;
    }

    public void \u0271(double d) {
        this.\u051f = d;
    }

    public void \u054f(float f) {
        this.\u04a8 = f;
        \u021f = true;
        \u02ac = true;
        \u0268 = f;
    }

    public void \u0154(float f, float f2) {
        this.\u04a8 = f;
        this.\u03f5 = f2;
        \u021f = true;
        \u02ac = true;
        \u0268 = f;
    }

    public void \u022b(float f) {
        this.\u03f5 = f;
        \u02ac = true;
    }

    public void \u0133(boolean bl) {
        this.\u0402 = bl;
    }

    public static boolean \u0171() {
        return \u021f;
    }

    public static void c(boolean bl) {
        \u021f = bl;
    }

    public boolean \u0531() {
        return this.\u0170;
    }

    public void \u026f(boolean bl) {
        this.\u0170 = bl;
    }

    public boolean \u0274() {
        return this.\u04bd;
    }

    public void \u0151(boolean bl) {
        this.\u04bd = bl;
    }

    public boolean \u0101(PlayerState playerState) {
        boolean bl;
        block40: {
            block33: {
                int n;
                block39: {
                    PlayerState playerState2;
                    block38: {
                        block37: {
                            float f;
                            block36: {
                                PlayerState playerState3;
                                block35: {
                                    double d;
                                    double d2;
                                    block34: {
                                        PlayerState playerState4;
                                        block32: {
                                            n = oce79181588d.\u022d;
                                            playerState4 = playerState;
                                            if (n != 0) break block32;
                                            if (playerState4.x != this.\u0509) break block33;
                                            playerState4 = playerState;
                                        }
                                        d2 = playerState4.y;
                                        d = this.\u042c;
                                        if (n != 0) break block34;
                                        if (d2 != d) break block33;
                                        playerState3 = playerState;
                                        if (n != 0) break block35;
                                        d2 = playerState3.z;
                                        d = this.\u051f;
                                    }
                                    if (d2 != d) break block33;
                                    playerState3 = playerState;
                                }
                                f = playerState3.yaw;
                                if (n != 0) break block36;
                                if (f != this.\u04a8) break block33;
                                playerState2 = playerState;
                                if (n != 0) break block37;
                                f = playerState2.pitch;
                            }
                            if (f != this.\u03f5) break block33;
                            playerState2 = playerState;
                        }
                        if (n != 0) break block38;
                        if (playerState2.onGround != this.\u0402) break block33;
                        playerState2 = playerState;
                    }
                    bl = playerState2.isSprinting;
                    if (n != 0) break block39;
                    if (bl != this.\u0170) break block33;
                    bl = playerState.isSneaking;
                }
                if (n != 0) break block40;
                if (bl != this.\u04bd) break block33;
                bl = true;
                break block40;
            }
            bl = false;
        }
        return bl;
    }
}

