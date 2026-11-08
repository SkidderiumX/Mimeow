/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.nio.FloatBuffer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

public class RenderHelper {
    private static FloatBuffer colorBuffer = GLAllocation.createDirectFloatBuffer(16);
    private static final Vec3 LIGHT0_POS = new Vec3(0.2f, 1.0, -0.7f).normalize();
    private static final Vec3 LIGHT1_POS = new Vec3(-0.2f, 1.0, 0.7f).normalize();

    public static void disableStandardItemLighting() {
        GlStateManager.disableLighting();
        GlStateManager.disableLight(0);
        GlStateManager.disableLight(1);
        GlStateManager.disableColorMaterial();
    }

    public static void enableStandardItemLighting() {
        GlStateManager.enableLighting();
        GlStateManager.enableLight(0);
        GlStateManager.enableLight(1);
        GlStateManager.enableColorMaterial();
        GlStateManager.colorMaterial(1032, 5634);
        float f = 0.4f;
        float f2 = 0.6f;
        float f3 = 0.0f;
        GL11.glLightfv(16384, 4611, RenderHelper.setColorBuffer(RenderHelper.LIGHT0_POS.xCoord, RenderHelper.LIGHT0_POS.yCoord, RenderHelper.LIGHT0_POS.zCoord, 0.0));
        GL11.glLightfv(16384, 4609, RenderHelper.setColorBuffer(f2, f2, f2, 1.0f));
        GL11.glLightfv(16384, 4608, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLightfv(16384, 4610, RenderHelper.setColorBuffer(f3, f3, f3, 1.0f));
        GL11.glLightfv(16385, 4611, RenderHelper.setColorBuffer(RenderHelper.LIGHT1_POS.xCoord, RenderHelper.LIGHT1_POS.yCoord, RenderHelper.LIGHT1_POS.zCoord, 0.0));
        GL11.glLightfv(16385, 4609, RenderHelper.setColorBuffer(f2, f2, f2, 1.0f));
        GL11.glLightfv(16385, 4608, RenderHelper.setColorBuffer(0.0f, 0.0f, 0.0f, 1.0f));
        GL11.glLightfv(16385, 4610, RenderHelper.setColorBuffer(f3, f3, f3, 1.0f));
        GlStateManager.shadeModel(7424);
        GL11.glLightModelfv(2899, RenderHelper.setColorBuffer(f, f, f, 1.0f));
    }

    private static FloatBuffer setColorBuffer(double d, double d2, double d3, double d4) {
        return RenderHelper.setColorBuffer((float)d, (float)d2, (float)d3, (float)d4);
    }

    private static FloatBuffer setColorBuffer(float f, float f2, float f3, float f4) {
        colorBuffer.clear();
        colorBuffer.put(f).put(f2).put(f3).put(f4);
        colorBuffer.flip();
        return colorBuffer;
    }

    public static void enableGUIStandardItemLighting() {
        GlStateManager.pushMatrix();
        GlStateManager.rotate(-30.0f, 0.0f, 1.0f, 0.0f);
        GlStateManager.rotate(165.0f, 1.0f, 0.0f, 0.0f);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.popMatrix();
    }
}

