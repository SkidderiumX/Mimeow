/*
 * Decompiled with CFR 0.152.
 */
package x;

import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.oce6044968f8;

public class occe09566b74 {
    private occe09566b74() {
    }

    void \u04a0() {
        GL11.glPushAttrib(0x5D4C60C1 ^ 0x5D439F3E);
    }

    void \u00cb() {
        GL11.glPopAttrib();
    }

    void \u0143() {
        GL11.glPushMatrix();
    }

    void \u0523() {
        GL11.glPopMatrix();
    }

    void \u0288(int n) {
        GL11.glBegin(n);
    }

    void \u029d() {
        oc170ea29aae.\u0177();
    }

    void \u04b6(double d, double d2, double d3) {
        GL11.glVertex3d(d, d2, d3);
    }

    void \u016a(double d, double d2, double d3) {
        GL11.glTranslated(d, d2, d3);
    }

    void \u044f(double d, double d2, double d3, double d4) {
        GL11.glRotated(d, d2, d3, d4);
    }

    void \u0377(double d, double d2, double d3, double d4) {
        GL11.glColor4d(d, d2, d3, d4);
    }

    void \u02a5(float f) {
        GL11.glLineWidth(f);
    }

    void \u040d(boolean bl) {
        GL11.glDepthMask(bl);
    }

    void \u039b(boolean bl) {
        block3: {
            int n;
            block2: {
                this.\u0287(0xAEF00EBE ^ 0xAEF0055C, bl);
                boolean bl2 = oce6044968f8.\u0452;
                n = bl;
                if (bl2) break block2;
                if (n == 0) break block3;
                n = 0xAEF0065E ^ 0xAEF0055C;
            }
            GL11.glBlendFunc(n, 0xAEF0065F ^ 0xAEF0055C);
        }
    }

    void \u04d8(boolean bl) {
        this.\u0287(0xAA4AC6DF ^ 0xAA4ACB3E, bl);
    }

    void \u0585(boolean bl) {
        this.\u0287(0x5B3AEB61 ^ 0x5B3AE025, bl);
    }

    void \u0390(boolean bl) {
        this.\u0287(0xB2F1CD0B ^ 0xB2F1C67A, bl);
    }

    void \u04be(boolean bl) {
        this.\u0287(0x901F8143 ^ 0x901F8A63, bl);
    }

    void \u013f() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void \u0287(int n, boolean bl) {
        block8: {
            int n2;
            block6: {
                block7: {
                    boolean bl2 = oce6044968f8.\u0452;
                    n2 = bl;
                    if (bl2) break block6;
                    if (n2 == 0) break block7;
                    GL11.glEnable(n);
                    if (!bl2) break block8;
                }
                n2 = n;
            }
            GL11.glDisable(n2);
        }
    }
}

