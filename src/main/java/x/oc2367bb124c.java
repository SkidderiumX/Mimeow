/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.occ0b63c0426;

public class oc2367bb124c {
    public static boolean \u025e;

    public void \u0116() {
        GL11.glPushAttrib(0x2C58A8D1 ^ 0x2C57572E);
    }

    public void \u04bb() {
        GL11.glPopAttrib();
    }

    public void \u042b() {
        GL11.glPushMatrix();
    }

    public void \u0522() {
        GL11.glPopMatrix();
    }

    public void \u0422(int n) {
        GL11.glBegin(n);
    }

    public void Y() {
        oc170ea29aae.\u0177();
    }

    public void \u0235(float f, float f2) {
        GL11.glVertex2f(f, f2);
    }

    public void \u0288(double d, double d2) {
        GL11.glVertex2d(d, d2);
    }

    public void \u046a(float f, float f2, float f3) {
        GL11.glVertex3f(f, f2, f3);
    }

    public void \u037c(double d, double d2, double d3) {
        GL11.glVertex3d(d, d2, d3);
    }

    public void \u040e(float f, float f2, float f3) {
        GL11.glTranslatef(f, f2, f3);
    }

    public void \u046f(double d, double d2, double d3) {
        GL11.glTranslated(d, d2, d3);
    }

    public void \u01ed(float f, float f2, float f3, float f4) {
        GL11.glRotatef(f, f2, f3, f4);
    }

    public void \u0517(double d, double d2, double d3, double d4) {
        GL11.glRotated(d, d2, d3, d4);
    }

    public void \u01f4(float f, float f2, float f3) {
        GL11.glScalef(f, f2, f3);
    }

    public void \u0230(double d, double d2, double d3, double d4) {
        GL11.glColor4d(d, d2, d3, d4);
    }

    public void \u00e2(float f, float f2, float f3, float f4) {
        GL11.glColor4f(f, f2, f3, f4);
    }

    public void Y(int n, int n2, int n3, int n4) {
        GL11.glColor4ub((byte)n, (byte)n2, (byte)n3, (byte)n4);
    }

    public void \u0408(int n) {
        GL11.glDepthFunc(n);
    }

    public void \u044e(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        GL11.glColorMask(bl, bl2, bl3, bl4);
    }

    public void \u04f0(float f, float f2) {
        GL11.glPolygonOffset(f, f2);
    }

    public void \u04a2(boolean bl) {
        this.\u014a(0x7C5E91B ^ 0x7C5692C, bl);
    }

    public void \u0449(float f, float f2) {
        GL11.glTexCoord2f(f, f2);
    }

    public void \u0420(double d, double d2) {
        GL11.glTexCoord2d(d, d2);
    }

    public void \u0410(String string) {
        block6: {
            Minecraft minecraft;
            block7: {
                int n = occ0b63c0426.\u039f;
                if (string == null) break block6;
                minecraft = Minecraft.getMinecraft();
                if (n != 0) break block7;
                if (minecraft.getTextureManager() == null) break block6;
                minecraft = Minecraft.getMinecraft();
            }
            minecraft.getTextureManager().bindTexture(new ResourceLocation(string));
        }
    }

    public void \u04a4(int n) {
        GL11.glBindTexture(0x240DE63D ^ 0x240DEBDC, n);
    }

    public int \u0564() {
        return GL11.glGetInteger(0x9369F228 ^ 0x93697241);
    }

    public void \u02ac(float f) {
        GL11.glLineWidth(f);
    }

    public void \u0490(double d) {
        GL11.glLineWidth((float)d);
    }

    public void \u0283(float f, float f2, float f3) {
        GL11.glNormal3f(f, f2, f3);
    }

    public void \u01fe(double d, double d2, double d3) {
        GL11.glNormal3d(d, d2, d3);
    }

    public void \u0250(boolean bl) {
        GL11.glDepthMask(bl);
    }

    public void \u0134(boolean bl) {
        block3: {
            int n;
            block2: {
                this.\u014a(0x4E6F2258 ^ 0x4E6F29BA, bl);
                int n2 = occ0b63c0426.\u039f;
                n = bl;
                if (n2 != 0) break block2;
                if (n == 0) break block3;
                n = 0x4E6F2AB8 ^ 0x4E6F29BA;
            }
            GL11.glBlendFunc(n, 0x4E6F2AB9 ^ 0x4E6F29BA);
        }
    }

    public void \u024c(boolean bl) {
        this.\u014a(0xDE400877 ^ 0xDE400596, bl);
    }

    public void \u0283(boolean bl) {
        this.\u014a(0x982EA913 ^ 0x982EA2D3, bl);
    }

    public void \u020e(boolean bl) {
        this.\u014a(0x84E14881 ^ 0x84E143C5, bl);
    }

    public void \u00d6(boolean bl) {
        this.\u014a(0x88EB3E90 ^ 0x88EB35E1, bl);
    }

    public void \u0260(boolean bl) {
        this.\u014a(0x671A5D0F ^ 0x671A562F, bl);
    }

    public void W(boolean bl) {
        this.\u014a(0x9A3E3B3A ^ 0x9A3E306A, bl);
    }

    public void \u01fc(int n) {
        GL11.glEnable(n);
    }

    public void \u017a(int n) {
        GL11.glDisable(n);
    }

    public void \u01a5(int n, int n2, int n3, int n4) {
        GL11.glScissor(n, n2, n3, n4);
    }

    public void \u0442(boolean bl) {
        this.\u014a(0xAAB1920 ^ 0xAAB1531, bl);
    }

    public void \u03b3() {
    }

    public void \u016c(boolean bl) {
    }

    public void \u03ae() {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    private void \u014a(int n, boolean bl) {
        block8: {
            int n2;
            block6: {
                block7: {
                    int n3 = occ0b63c0426.\u039f;
                    n2 = bl;
                    if (n3 != 0) break block6;
                    if (n2 == 0) break block7;
                    GL11.glEnable(n);
                    if (n3 == 0) break block8;
                }
                n2 = n;
            }
            GL11.glDisable(n2);
        }
    }
}

