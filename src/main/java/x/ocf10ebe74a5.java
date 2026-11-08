/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.oc29a4412fc2;
import x.oc3aa1e3d90a;
import x.oc5fe36d3bb5;
import x.oc69da1aa7f5;
import x.ocbd4917c4b1;
import x.ocbf5a535fb8;
import x.occ0b63c0426;
import x.occ2ace216f9;
import x.ocd2958dac48;

public class ocf10ebe74a5 {
    private final Minecraft \u00d0 = Minecraft.getMinecraft();
    public static int \u01f8;

    public ocbf5a535fb8 \u0185() {
        return new ocbf5a535fb8(this.\u00d0.getRenderManager().viewerPosX, this.\u00d0.getRenderManager().viewerPosY, this.\u00d0.getRenderManager().viewerPosZ);
    }

    public double[] \u03ea() {
        double[] dArray;
        block3: {
            Entity entity;
            block2: {
                entity = this.\u00d0.getRenderViewEntity();
                if (entity != null) break block2;
                dArray = null;
                break block3;
            }
            double[] dArray2 = new double[0xACDC1074 ^ 0xACDC1076];
            dArray2[0] = entity.rotationYaw;
            dArray = dArray2;
            dArray2[1] = entity.rotationPitch;
        }
        return dArray;
    }

    public int \u04c0(String string) {
        return this.\u00d0.fontRendererObj.getStringWidth(string);
    }

    public void \u00fa(String string, float f, float f2, float f3, int n, boolean n2) {
        block6: {
            int n3;
            block7: {
                GL11.glPushMatrix();
                int n4 = occ0b63c0426.\u039f;
                GL11.glScalef(f3, f3, 1.0f);
                n3 = n2;
                if (n4 != 0) break block6;
                if (n3 == 0) break block7;
                this.\u00d0.fontRendererObj.drawStringWithShadow(string, f / f3, f2 / f3, n);
                if (n4 == 0) break block6;
            }
            n3 = this.\u00d0.fontRendererObj.drawString(string, (int)(f / f3), (int)(f2 / f3), n);
        }
        GL11.glPopMatrix();
    }

    public void O(String string, float f, float f2, float f3, int n, boolean bl) {
        block4: {
            block5: {
                int n2 = occ0b63c0426.\u039f;
                GlStateManager.pushMatrix();
                if (n2 != 0) break block4;
                if (f3 == 1.0f) break block5;
                GlStateManager.scale(f3, f3, f3);
            }
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(0x15E4364F ^ 0x15E4354D, 0x15E4364E ^ 0x15E4354D, 1, 0);
            this.\u00d0.fontRendererObj.drawString(string, f / f3, f2 / f3, n, bl);
            GlStateManager.disableBlend();
            GlStateManager.popMatrix();
        }
    }

    public void \u0563(ocbf5a535fb8 ocbf5a535fb82, int n, boolean bl, boolean bl2) {
        int n2;
        block9: {
            block8: {
                int n3;
                int n4;
                block7: {
                    int n5 = occ0b63c0426.\u039f;
                    if (ocbf5a535fb82 == null) {
                        return;
                    }
                    n4 = n;
                    n3 = 0xCC2E1CA ^ 0xF3C2E1CA;
                    if (n5 != 0) break block7;
                    if ((n4 & n3) != 0) break block8;
                    n4 = 0x95C2E1CA ^ 0xF3C2E1CA;
                    n3 = n & (0xF33D1E35 ^ 0xF3C2E1CA);
                }
                n2 = n4 | n3;
                break block9;
            }
            n2 = n;
        }
        int n6 = n2;
        ocbd4917c4b1.\u044c(new BlockPos(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0), n6, bl, bl2);
    }

    public void \u0469(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.\u0563(new ocbf5a535fb8(n, n2, n3), n4, bl, bl2);
    }

    public int \u01bf(String string) {
        return ocd2958dac48.\u016f(0.0);
    }

    public void \u01e0(oc5fe36d3bb5 oc5fe36d3bb52, int n, float f, boolean bl, boolean bl2) {
        block7: {
            oc5fe36d3bb5 oc5fe36d3bb53;
            block8: {
                int n2;
                block6: {
                    n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                    if (n2 != 0) break block6;
                    if (oc5fe36d3bb53 == null) break block7;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                }
                if (n2 != 0) break block8;
                if (oc5fe36d3bb53.\u057f == null) break block7;
                oc5fe36d3bb53 = oc5fe36d3bb52;
            }
            ocbd4917c4b1.\u01a8(oc5fe36d3bb53.\u057f, n, f, 0.0, -1, bl);
        }
    }

    public void \u0290(oc5fe36d3bb5 oc5fe36d3bb52, int n, int n2, float f, float f2, int n3) {
        this.\u01e0(oc5fe36d3bb52, 0, f, false, false);
    }

    public void \u0121() {
        block5: {
            Minecraft minecraft;
            block4: {
                int n = occ0b63c0426.\u039f;
                minecraft = this.\u00d0;
                if (n != 0) break block4;
                if (minecraft.getItemRenderer() == null) break block5;
                minecraft = this.\u00d0;
            }
            minecraft.getItemRenderer().resetEquippedProgress();
        }
    }

    public void \u00d5(oc5fe36d3bb5 oc5fe36d3bb52, float f, int n, float f2) {
        block7: {
            oc5fe36d3bb5 oc5fe36d3bb53;
            block8: {
                int n2;
                block6: {
                    n2 = occ0b63c0426.\u039f;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                    if (n2 != 0) break block6;
                    if (oc5fe36d3bb53 == null) break block7;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                }
                if (n2 != 0) break block8;
                if (oc5fe36d3bb53.\u057f == null) break block7;
                oc5fe36d3bb53 = oc5fe36d3bb52;
            }
            ocbd4917c4b1.\u029f(oc5fe36d3bb53.\u057f, n, f, f2);
        }
    }

    public void \u0408() {
    }

    public void q(occ2ace216f9 occ2ace216f92, float f, float f2, float f3) {
        block7: {
            occ2ace216f9 occ2ace216f93;
            block8: {
                int n;
                block6: {
                    n = occ0b63c0426.\u039f;
                    occ2ace216f93 = occ2ace216f92;
                    if (n != 0) break block6;
                    if (occ2ace216f93 == null) break block7;
                    occ2ace216f93 = occ2ace216f92;
                }
                if (n != 0) break block8;
                if (occ2ace216f93.W() == null) break block7;
                GL11.glPushMatrix();
                GL11.glTranslatef(f, f2, 0.0f);
                GL11.glScalef(f3, f3, f3);
                occ2ace216f93 = occ2ace216f92;
            }
            ocbd4917c4b1.\u04f0(occ2ace216f93.W(), 0, 0);
            GL11.glPopMatrix();
        }
    }

    public void \u01e5(oc3aa1e3d90a oc3aa1e3d90a2, float f, float f2, float f3, float f4) {
    }

    public ocbf5a535fb8 \u0127(double d, double d2, double d3, int n, float f) {
        oc29a4412fc2 oc29a4412fc22 = new oc29a4412fc2();
        double[] dArray = new double[0x49A7C0F6 ^ 0x49A7C0F5];
        ocbf5a535fb8 ocbf5a535fb82 = ocbd4917c4b1.\u01db(oc29a4412fc22, d, d2, d3, dArray) ? new ocbf5a535fb8(dArray[0], dArray[1], dArray[0x49A7C0F7 ^ 0x49A7C0F5]) : null;
        return ocbf5a535fb82;
    }

    public void \u0455(float f, float f2, float f3, float f4, float f5, int n) {
        ocbd4917c4b1.\u04da(f, f2, f3, f4, f5, n);
    }

    public void n(float f, float f2, float f3, float f4, int n, int n2) {
        ocbd4917c4b1.\u04f6(f, f2, f3, f4, 0.0f, n, n, n2, n2);
    }

    public void \u0471(float f, float f2, float f3, float f4, int n, int n2, int n3, int n4) {
        ocbd4917c4b1.\u04f6(f, f2, f3, f4, 0.0f, n, n2, n3, n4);
    }

    public double[] \u04a0() {
        return this.\u03ea();
    }

    public int \u0454() {
        return this.\u00d0.fontRendererObj.FONT_HEIGHT;
    }

    public void \u03d4(String string, ocbf5a535fb8 ocbf5a535fb82, float f, boolean bl, boolean bl2, boolean bl3, int n) {
        if (ocbf5a535fb82 == null) {
            return;
        }
        this.\u00fa(string, (float)ocbf5a535fb82.\u03ba, (float)ocbf5a535fb82.\u0418, f, n, bl);
    }

    public void \u0293(float f, float f2, float f3, float f4, int n) {
        ocbd4917c4b1.\u0109(f, f2, f + f3, f2 + f4, n);
    }

    public void \u00ca(double d, double d2, double d3, double d4, float f, int n) {
        float f2 = (float)(n >>> (0x8A740A4E ^ 0x8A740A5E) & (0x8A740AA1 ^ 0x8A740A5E)) / 255.0f;
        float f3 = (float)(n >>> (0x8A740A56 ^ 0x8A740A5E) & (0x8A740AA1 ^ 0x8A740A5E)) / 255.0f;
        float f4 = (float)(n & (0x8A740AA1 ^ 0x8A740A5E)) / 255.0f;
        float f5 = (float)(n >>> (0x8A740A46 ^ 0x8A740A5E) & (0x8A740AA1 ^ 0x8A740A5E)) / 255.0f;
        GL11.glPushMatrix();
        GL11.glLineWidth(f);
        GL11.glColor4f(f2, f3, f4, f5);
        GL11.glBegin(1);
        GL11.glVertex2d(d, d2);
        GL11.glVertex2d(d3, d4);
        oc170ea29aae.\u0177();
        int n2 = occ0b63c0426.\u039f;
        GL11.glPopMatrix();
        if (false) {
            occ0b63c0426.\u039f = ++n2;
        }
    }

    public void \u01a6(ocbf5a535fb8 ocbf5a535fb82, ocbf5a535fb8 ocbf5a535fb83, float f, int n) {
        block6: {
            block5: {
                ocbf5a535fb8 ocbf5a535fb84;
                block4: {
                    int n2 = occ0b63c0426.\u039f;
                    ocbf5a535fb84 = ocbf5a535fb82;
                    if (n2 != 0) break block4;
                    if (ocbf5a535fb84 == null) break block5;
                    ocbf5a535fb84 = ocbf5a535fb83;
                }
                if (ocbf5a535fb84 != null) break block6;
            }
            return;
        }
        this.\u0281(ocbf5a535fb82.\u03ba, ocbf5a535fb82.\u0418, ocbf5a535fb82.\u03e0, ocbf5a535fb83.\u03ba, ocbf5a535fb83.\u0418, ocbf5a535fb83.\u03e0, f, n);
    }

    public void \u0281(double d, double d2, double d3, double d4, double d5, double d6, float f, int n) {
        block4: {
            boolean bl;
            block6: {
                block5: {
                    float f2 = (float)(n >>> (0xC725D9D3 ^ 0xC725D9C3) & (0xC725D93C ^ 0xC725D9C3)) / 255.0f;
                    int n2 = occ0b63c0426.\u039f;
                    float f3 = (float)(n >>> (0xC725D9CB ^ 0xC725D9C3) & (0xC725D93C ^ 0xC725D9C3)) / 255.0f;
                    float f4 = (float)(n & (0xC725D93C ^ 0xC725D9C3)) / 255.0f;
                    float f5 = (float)(n >>> (0xC725D9DB ^ 0xC725D9C3) & (0xC725D93C ^ 0xC725D9C3)) / 255.0f;
                    GL11.glPushMatrix();
                    GL11.glTranslated(-this.\u00d0.getRenderManager().viewerPosX, -this.\u00d0.getRenderManager().viewerPosY, -this.\u00d0.getRenderManager().viewerPosZ);
                    GL11.glLineWidth(f);
                    GL11.glColor4f(f2, f3, f4, f5);
                    GL11.glBegin(1);
                    GL11.glVertex3d(d, d2, d3);
                    GL11.glVertex3d(d4, d5, d6);
                    oc170ea29aae.\u0177();
                    GL11.glPopMatrix();
                    if (n2 == 0) break block4;
                    if (!false) break block5;
                    bl = false;
                    break block6;
                }
                bl = true;
            }
            oc69da1aa7f5.\u04ac = bl;
        }
    }

    public boolean \u0416(oc5fe36d3bb5 oc5fe36d3bb52) {
        boolean bl;
        block11: {
            block9: {
                oc5fe36d3bb5 oc5fe36d3bb53;
                int n;
                block10: {
                    block8: {
                        n = occ0b63c0426.\u039f;
                        oc5fe36d3bb53 = oc5fe36d3bb52;
                        if (n != 0) break block8;
                        if (oc5fe36d3bb53 == null) break block9;
                        oc5fe36d3bb53 = oc5fe36d3bb52;
                    }
                    if (n != 0) break block10;
                    if (oc5fe36d3bb53.\u057f == null) break block9;
                    oc5fe36d3bb53 = oc5fe36d3bb52;
                }
                bl = ocbd4917c4b1.\u017e(oc5fe36d3bb53.\u057f);
                if (n != 0) break block11;
                if (!bl) break block9;
                bl = true;
                break block11;
            }
            bl = false;
        }
        return bl;
    }
}

