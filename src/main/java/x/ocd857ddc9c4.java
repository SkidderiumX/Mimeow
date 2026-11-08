/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;
import x.oc33e2bcdd33;
import x.oc497d0cdf29;
import x.ocdab58ca6e4;

public class ocd857ddc9c4 {
    private static final int[] l;
    private static final int[] \u0461;
    public static boolean \u026d;

    private ocd857ddc9c4() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void \u011f(oc33e2bcdd33 oc33e2bcdd332, Vec3 vec3, Vec3 vec32, float f, float f2, boolean bl, boolean bl2, float f3, Color color) {
        Vec3 vec33 = oc497d0cdf29.\u01f6(vec3, vec32, oc33e2bcdd332.\u01a1);
        GL11.glPushAttrib(0xFFA12556 ^ 0xFFAEDAA9);
        GL11.glPushMatrix();
        boolean bl4 = ocdab58ca6e4.\u02e3;
        try {
            GL11.glDisable(0xFFAED748 ^ 0xFFAEDAA9);
            GL11.glDisable(0xFFAED1F9 ^ 0xFFAEDAA9);
            int n = 0xFFAED14B ^ 0xFFAEDAA9;
            if (!bl4) {
                GL11.glEnable(n);
                GL11.glBlendFunc(0xFFAED9AB ^ 0xFFAEDAA9, 0xFFAED9AA ^ 0xFFAEDAA9);
                GL11.glLineWidth(f3);
                GL11.glTranslatef((float)(vec33.xCoord - oc33e2bcdd332.\u028a), (float)(vec33.yCoord - oc33e2bcdd332.\u0446 + 1.0), (float)(vec33.zCoord - oc33e2bcdd332.\u0421));
                GL11.glScalef(0.3f, 1.0f, 0.3f);
                if (bl) {
                    GL11.glRotatef(180.0f - ((f2 - f) * oc33e2bcdd332.\u01a1 + f), 0.0f, 1.0f, 0.0f);
                }
                n = bl2 ? 1 : 0;
            }
            if (!bl4) {
                if (n != 0) {
                    GL11.glColor4f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f, 0.4f);
                    ocd857ddc9c4.\u04ca(0xFFAEDAAC ^ 0xFFAEDAA9, l);
                }
                GL11.glColor3f((float)color.getRed() / 255.0f, (float)color.getGreen() / 255.0f, (float)color.getBlue() / 255.0f);
                n = 1;
            }
            ocd857ddc9c4.\u04ca(n, \u0461);
            return;
        }
        finally {
            GL11.glPopMatrix();
            GL11.glPopAttrib();
        }
    }

    private static void \u04ca(int n, int[] nArray) {
        block9: {
            GL11.glBegin(n);
            int[] nArray2 = nArray;
            int n2 = nArray2.length;
            boolean bl = ocdab58ca6e4.\u02e3;
            for (int i = 0; i < n2; ++i) {
                float f;
                int n3;
                block11: {
                    block10: {
                        n3 = nArray2[i];
                        if (bl) break block9;
                        if ((n3 & (0xC78837DE ^ 0xC78837DA)) != 0) break block10;
                        f = -1.0f;
                        break block11;
                    }
                    f = 1.0f;
                }
                float f2 = (n3 & (0xC78837D8 ^ 0xC78837DA)) == 0 ? -1.0f : 1.0f;
                float f3 = (n3 & 1) == 0 ? -1.0f : 1.0f;
                GL11.glVertex3f(f, f2, f3);
                if (!bl) continue;
            }
            GL11.glEnd();
        }
    }

    static {
        int[] nArray = new int[0xF712380C ^ 0xF7123802];
        nArray[0] = 0xF7123801 ^ 0xF7123802;
        nArray[1] = 0xF7123805 ^ 0xF7123802;
        nArray[0xF7123800 ^ 0xF7123802] = 1;
        nArray[0xF7123801 ^ 0xF7123802] = 0xF7123807 ^ 0xF7123802;
        nArray[0xF7123806 ^ 0xF7123802] = 0xF7123806 ^ 0xF7123802;
        nArray[0xF7123807 ^ 0xF7123802] = 0xF7123805 ^ 0xF7123802;
        nArray[0xF7123804 ^ 0xF7123802] = 0xF7123804 ^ 0xF7123802;
        nArray[0xF7123805 ^ 0xF7123802] = 0xF7123801 ^ 0xF7123802;
        nArray[0xF712380A ^ 0xF7123802] = 0xF7123800 ^ 0xF7123802;
        nArray[0xF712380B ^ 0xF7123802] = 1;
        nArray[0xF7123808 ^ 0xF7123802] = 0;
        nArray[0xF7123809 ^ 0xF7123802] = 0xF7123806 ^ 0xF7123802;
        nArray[0xF712380E ^ 0xF7123802] = 0xF7123800 ^ 0xF7123802;
        nArray[0xF712380F ^ 0xF7123802] = 0xF7123804 ^ 0xF7123802;
        l = nArray;
        int[] nArray2 = new int[0xF712381A ^ 0xF7123802];
        nArray2[0] = 0;
        nArray2[1] = 1;
        nArray2[0xF7123800 ^ 0xF7123802] = 1;
        nArray2[0xF7123801 ^ 0xF7123802] = 0xF7123807 ^ 0xF7123802;
        nArray2[0xF7123806 ^ 0xF7123802] = 0xF7123807 ^ 0xF7123802;
        nArray2[0xF7123807 ^ 0xF7123802] = 0xF7123806 ^ 0xF7123802;
        nArray2[0xF7123804 ^ 0xF7123802] = 0xF7123806 ^ 0xF7123802;
        nArray2[0xF7123805 ^ 0xF7123802] = 0;
        nArray2[0xF712380A ^ 0xF7123802] = 0xF7123800 ^ 0xF7123802;
        nArray2[0xF712380B ^ 0xF7123802] = 0xF7123801 ^ 0xF7123802;
        nArray2[0xF7123808 ^ 0xF7123802] = 0xF7123801 ^ 0xF7123802;
        nArray2[0xF7123809 ^ 0xF7123802] = 0xF7123805 ^ 0xF7123802;
        nArray2[0xF712380E ^ 0xF7123802] = 0xF7123805 ^ 0xF7123802;
        nArray2[0xF712380F ^ 0xF7123802] = 0xF7123804 ^ 0xF7123802;
        nArray2[0xF712380C ^ 0xF7123802] = 0xF7123804 ^ 0xF7123802;
        nArray2[0xF712380D ^ 0xF7123802] = 0xF7123800 ^ 0xF7123802;
        nArray2[0xF7123812 ^ 0xF7123802] = 0;
        nArray2[0xF7123813 ^ 0xF7123802] = 0xF7123800 ^ 0xF7123802;
        nArray2[0xF7123810 ^ 0xF7123802] = 1;
        nArray2[0xF7123811 ^ 0xF7123802] = 0xF7123801 ^ 0xF7123802;
        nArray2[0xF7123816 ^ 0xF7123802] = 0xF7123806 ^ 0xF7123802;
        nArray2[0xF7123817 ^ 0xF7123802] = 0xF7123804 ^ 0xF7123802;
        nArray2[0xF7123814 ^ 0xF7123802] = 0xF7123807 ^ 0xF7123802;
        nArray2[0xF7123815 ^ 0xF7123802] = 0xF7123805 ^ 0xF7123802;
        \u0461 = nArray2;
    }
}

