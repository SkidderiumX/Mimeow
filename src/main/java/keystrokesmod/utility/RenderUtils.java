/*
 * Decompiled with CFR 0.152.
 */
package keystrokesmod.utility;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import x.oc170ea29aae;
import x.ocbd4917c4b1;
import x.ocda171fe5d8;

public class RenderUtils
extends ocbd4917c4b1 {
    private static final Frustum frustum = new Frustum();

    public static void glColor(int n) {
        GL11.glColor4f((float)(n >> (0x775CC3DA ^ 0x775CC3CA) & (0x775CC335 ^ 0x775CC3CA)) / 255.0f, (float)(n >> (0x775CC3C2 ^ 0x775CC3CA) & (0x775CC335 ^ 0x775CC3CA)) / 255.0f, (float)(n & (0x775CC335 ^ 0x775CC3CA)) / 255.0f, (float)(n >> (0x775CC3D2 ^ 0x775CC3CA) & (0x775CC335 ^ 0x775CC3CA)) / 255.0f);
    }

    public static boolean isInViewFrustum(Entity entity) {
        if (entity == null) {
            return false;
        }
        return RenderUtils.isInViewFrustum(entity.getEntityBoundingBox()) || entity.ignoreFrustumCheck;
    }

    public static boolean isInViewFrustum(AxisAlignedBB axisAlignedBB) {
        if (axisAlignedBB == null) {
            return false;
        }
        Entity entity = ocda171fe5d8.\u01d4.getRenderViewEntity();
        if (entity == null) {
            return true;
        }
        frustum.setPosition(entity.posX, entity.posY, entity.posZ);
        return frustum.isBoundingBoxInFrustum(axisAlignedBB);
    }

    public static void drawRoundedRectangle(float f, float f2, float f3, float f4, float f5, int n) {
        double d;
        int n2;
        if (f3 <= f || f4 <= f2) {
            return;
        }
        f5 = Math.max(0.0f, Math.min(f5, Math.min(f3 - f, f4 - f2)));
        f *= 2.0f;
        f2 *= 2.0f;
        f3 *= 2.0f;
        f4 *= 2.0f;
        GL11.glPushMatrix();
        GL11.glPushAttrib(0x2539AC23 ^ 0x253653DC);
        GL11.glScaled(0.5, 0.5, 0.5);
        GL11.glEnable(0x2536583E ^ 0x253653DC);
        GL11.glDisable(0x25365E3D ^ 0x253653DC);
        GL11.glEnable(0x253658FC ^ 0x253653DC);
        GL11.glBegin(0x253653D5 ^ 0x253653DC);
        RenderUtils.glColor(n);
        for (n2 = 0; n2 <= (0x25365386 ^ 0x253653DC); n2 += 3) {
            d = (float)n2 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f + f5) + Math.sin(d) * (double)f5 * -1.0, (double)(f2 + f5) + Math.cos(d) * (double)f5 * -1.0);
        }
        for (n2 = 0x25365386 ^ 0x253653DC; n2 <= (0x25365368 ^ 0x253653DC); n2 += 3) {
            d = (float)n2 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f + f5) + Math.sin(d) * (double)f5 * -1.0, (double)(f4 - f5) + Math.cos(d) * (double)f5 * -1.0);
        }
        for (n2 = 0; n2 <= (0x25365386 ^ 0x253653DC); ++n2) {
            d = (float)n2 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f3 - f5) + Math.sin(d) * (double)f5, (double)(f4 - f5) + Math.cos(d) * (double)f5);
        }
        for (n2 = 0x25365386 ^ 0x253653DC; n2 <= (0x25365368 ^ 0x253653DC); ++n2) {
            d = (float)n2 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f3 - f5) + Math.sin(d) * (double)f5, (double)(f2 + f5) + Math.cos(d) * (double)f5);
        }
        oc170ea29aae.\u0177();
        GL11.glEnable(0x25365E3D ^ 0x253653DC);
        GL11.glDisable(0x2536583E ^ 0x253653DC);
        GL11.glDisable(0x253658FC ^ 0x253653DC);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
        GlStateManager.resetColor();
    }

    public static void drawRoundedGradientRect(float f, float f2, float f3, float f4, float f5, int n, int n2, int n3, int n4) {
        double d;
        int n5;
        if (f3 <= f) {
            return;
        }
        float f6 = f3 - f;
        if (f6 < 3.0f) {
            f5 = Math.min(f5, f6 / 2.0f);
        }
        GL11.glEnable(0x57963789 ^ 0x57963C6B);
        GL11.glDisable(0x5796318A ^ 0x57963C6B);
        GL11.glBlendFunc(0x57963F69 ^ 0x57963C6B, 0x57963F68 ^ 0x57963C6B);
        GL11.glEnable(0x5796374B ^ 0x57963C6B);
        GL11.glShadeModel(0x5796216A ^ 0x57963C6B);
        GL11.glPushMatrix();
        GL11.glPushAttrib(0x5799C394 ^ 0x57963C6B);
        GL11.glScaled(0.5, 0.5, 0.5);
        f *= 2.0f;
        f2 *= 2.0f;
        f3 *= 2.0f;
        f4 *= 2.0f;
        RenderUtils.glColor(n);
        GL11.glBegin(0x57963C62 ^ 0x57963C6B);
        for (n5 = 0; n5 <= (0x57963C31 ^ 0x57963C6B); n5 += 3) {
            d = (float)n5 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f + f5) + Math.sin(d) * (double)f5 * -1.0, (double)(f2 + f5) + Math.cos(d) * (double)f5 * -1.0);
        }
        RenderUtils.glColor(n2);
        for (n5 = 0x57963C31 ^ 0x57963C6B; n5 <= (0x57963CDF ^ 0x57963C6B); n5 += 3) {
            d = (float)n5 * ((float)Math.PI / 180);
            GL11.glVertex2d((double)(f + f5) + Math.sin(d) * (double)f5 * -1.0, (double)(f4 - f5) + Math.cos(d) * (double)f5 * -1.0);
        }
        if ((double)(f3 - f) >= 4.5) {
            RenderUtils.glColor(n3);
            for (n5 = 0; n5 <= (0x57963C31 ^ 0x57963C6B); n5 += 3) {
                d = (float)n5 * ((float)Math.PI / 180);
                GL11.glVertex2d((double)(f3 - f5) + Math.sin(d) * (double)f5, (double)(f4 - f5) + Math.cos(d) * (double)f5);
            }
            RenderUtils.glColor(n4);
            for (n5 = 0x57963C31 ^ 0x57963C6B; n5 <= (0x57963CDF ^ 0x57963C6B); n5 += 3) {
                d = (float)n5 * ((float)Math.PI / 180);
                GL11.glVertex2d((double)(f3 - f5) + Math.sin(d) * (double)f5, (double)(f2 + f5) + Math.cos(d) * (double)f5);
            }
        }
        oc170ea29aae.\u0177();
        GL11.glDisable(0x5796374B ^ 0x57963C6B);
        GL11.glEnable(0x5796318A ^ 0x57963C6B);
        GL11.glDisable(0x57963789 ^ 0x57963C6B);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
        GlStateManager.resetColor();
    }
}

