/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;

public class oc3c7d73111d {
    private static final int \u0189 = 16;
    private static final int \u02b6 = 32;
    private static final Vec3[][] \u021f = oc3c7d73111d.\u00dd();

    private oc3c7d73111d() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void \u0496(Vec3 vec3, double d, int n, float f, float f2, boolean bl) {
        if (d <= 0.0) {
            return;
        }
        float f3 = (float)(n >> (0x250277AE ^ 0x250277BE) & (0x25027741 ^ 0x250277BE)) / 255.0f;
        float f4 = (float)(n >> (0x250277B6 ^ 0x250277BE) & (0x25027741 ^ 0x250277BE)) / 255.0f;
        float f5 = (float)(n & (0x25027741 ^ 0x250277BE)) / 255.0f;
        GL11.glPushAttrib(0x250D8841 ^ 0x250277BE);
        GL11.glPushMatrix();
        try {
            int n2;
            int n3;
            GL11.glTranslated(vec3.xCoord, vec3.yCoord, vec3.zCoord);
            GL11.glScaled(d, d, d);
            GL11.glEnable(0x25027C5C ^ 0x250277BE);
            GL11.glBlendFunc(0x250274BC ^ 0x250277BE, 0x250274BD ^ 0x250277BE);
            GL11.glDisable(0x25027A5F ^ 0x250277BE);
            GL11.glDisable(0x25027CEE ^ 0x250277BE);
            GL11.glDisable(0x25027CDE ^ 0x250277BE);
            GL11.glDisable(0x25027C7E ^ 0x250277BE);
            GL11.glDisable(0x25027CFA ^ 0x250277BE);
            if (bl) {
                GL11.glDisable(0x25027CCF ^ 0x250277BE);
            }
            GL11.glDepthMask(false);
            if (f > 0.0f) {
                GL11.glColor4f(f3, f4, f5, f);
                GL11.glBegin(0x250277BA ^ 0x250277BE);
                for (n3 = 0; n3 < (0x250277AE ^ 0x250277BE); ++n3) {
                    for (n2 = 0; n2 < (0x2502779E ^ 0x250277BE); ++n2) {
                        oc3c7d73111d.\u04e6(n3, n2);
                        oc3c7d73111d.\u04e6(n3 + 1, n2);
                        oc3c7d73111d.\u04e6(n3 + 1, n2 + 1);
                        oc3c7d73111d.\u04e6(n3, n2);
                        oc3c7d73111d.\u04e6(n3 + 1, n2 + 1);
                        oc3c7d73111d.\u04e6(n3, n2 + 1);
                    }
                }
                oc170ea29aae.\u0177();
            }
            GL11.glEnable(0x25027C9E ^ 0x250277BE);
            GL11.glLineWidth(1.0f);
            GL11.glColor4f(f3, f4, f5, f2);
            GL11.glBegin(1);
            for (n3 = 0; n3 < (0x250277AE ^ 0x250277BE); ++n3) {
                for (n2 = 0; n2 < (0x2502779E ^ 0x250277BE); ++n2) {
                    oc3c7d73111d.\u04e6(n3, n2);
                    oc3c7d73111d.\u04e6(n3, n2 + 1);
                    oc3c7d73111d.\u04e6(n3, n2);
                    oc3c7d73111d.\u04e6(n3 + 1, n2);
                    oc3c7d73111d.\u04e6(n3, n2);
                    oc3c7d73111d.\u04e6(n3 + 1, n2 + 1);
                }
            }
            oc170ea29aae.\u0177();
        }
        finally {
            GL11.glPopMatrix();
            GL11.glPopAttrib();
        }
    }

    private static Vec3[][] \u00dd() {
        Vec3[][] vec3Array = new Vec3[0x13D880C5 ^ 0x13D880D4][0x13D880F5 ^ 0x13D880D4];
        for (int i = 0; i <= (0x13D880C4 ^ 0x13D880D4); ++i) {
            double d = Math.PI * (double)i / 16.0;
            double d2 = Math.sin(d);
            for (int j = 0; j <= (0x13D880F4 ^ 0x13D880D4); ++j) {
                double d3 = Math.PI * 2 * (double)j / 32.0;
                vec3Array[i][j] = new Vec3(d2 * Math.cos(d3), Math.cos(d), d2 * Math.sin(d3));
            }
        }
        return vec3Array;
    }

    private static void \u04e6(int n, int n2) {
        Vec3 vec3 = \u021f[n][n2];
        GL11.glVertex3d(vec3.xCoord, vec3.yCoord, vec3.zCoord);
    }
}

