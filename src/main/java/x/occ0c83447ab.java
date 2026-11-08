/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class occ0c83447ab {
    private static final ResourceLocation \u0460 = new ResourceLocation("miau/images/splash.png");
    private static final int \u016b = 300;
    private static final int \u0471 = 100;
    private static final int \u025f = 150;
    private static final int \u01d4 = 50;
    private static final int \u03de = 116;
    private static final int \u0217 = 3;
    private static final long \u0439 = 90000000L;
    private static final long \u0403 = 600000000L;
    private static final int \u046d = 120;
    static final int \u026a = -1;
    private static float \u04ae;

    private occ0c83447ab() {
    }

    public static void \u043f(Minecraft minecraft, TextureManager textureManager) {
        occ0c83447ab.\u04b7(minecraft, textureManager, 0.0f);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void \u04b7(Minecraft minecraft, TextureManager textureManager, float f) {
        int n = Math.max(1, Display.getWidth());
        int n2 = Math.max(1, Display.getHeight());
        int n3 = occ0c83447ab.\u039a(n, n2, minecraft.gameSettings.guiScale, minecraft.isUnicode());
        int n4 = occ0c83447ab.\u03ec(n, n3);
        int n5 = occ0c83447ab.\u03ec(n2, n3);
        Framebuffer framebuffer = new Framebuffer(n, n2, true);
        float f2 = occ0c83447ab.u(f);
        float f3 = f2 < \u04ae ? 0.0f : \u04ae;
        long l = occ0c83447ab.\u00fe(f3, f2);
        long l2 = System.nanoTime();
        try {
            float f4;
            do {
                f4 = l == 0L ? 1.0f : occ0c83447ab.u((float)(System.nanoTime() - l2) / (float)l);
                float f5 = occ0c83447ab.\u018d(f3, f2, f4);
                occ0c83447ab.\u049d(minecraft, textureManager, framebuffer, n, n2, n4, n5, f5);
                if (!(f4 < 1.0f)) continue;
                Display.sync(0x733D4181 ^ 0x733D41F9);
            } while (f4 < 1.0f && !Display.isCloseRequested());
            \u04ae = f2;
        }
        finally {
            framebuffer.deleteFramebuffer();
        }
    }

    private static void \u049d(Minecraft minecraft, TextureManager textureManager, Framebuffer framebuffer, int n, int n2, int n3, int n4, float f) {
        framebuffer.bindFramebuffer(true);
        GlStateManager.viewport(0, 0, n, n2);
        occ0c83447ab.\u043e(n3, n4);
        occ0c83447ab.\u03b8();
        Gui.drawRect(0, 0, n3, n4, 0xEE7FC619 ^ 0x117FC619);
        textureManager.bindTexture(\u0460);
        GL11.glTexParameteri(0x117FCBF8 ^ 0x117FC619, 0x117FEE18 ^ 0x117FC619, 0x117FE019 ^ 0x117FC619);
        GL11.glTexParameteri(0x117FCBF8 ^ 0x117FC619, 0x117FEE19 ^ 0x117FC619, 0x117FE019 ^ 0x117FC619);
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(0x117FC41D ^ 0x117FC619, 0.0f);
        GlStateManager.tryBlendFuncSeparate(0x117FC51B ^ 0x117FC619, 0x117FC51A ^ 0x117FC619, 1, 0);
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        int n5 = (n3 - (0x117FC68F ^ 0x117FC619)) / (0x117FC61B ^ 0x117FC619);
        int n6 = (n4 - (0x117FC62B ^ 0x117FC619)) / (0x117FC61B ^ 0x117FC619) - (0x117FC61F ^ 0x117FC619);
        Gui.drawScaledCustomSizeModalRect(n5, n6, 0.0f, 0.0f, 0x117FC735 ^ 0x117FC619, 0x117FC67D ^ 0x117FC619, 0x117FC68F ^ 0x117FC619, 0x117FC62B ^ 0x117FC619, 300.0f, 100.0f);
        occ0c83447ab.\u03ea(n3 / (0x117FC61B ^ 0x117FC619), n6 + (0x117FC62B ^ 0x117FC619) - (0x117FC611 ^ 0x117FC619), f);
        GlStateManager.disableBlend();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(n, n2);
        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(0x117FC41D ^ 0x117FC619, 0.1f);
        minecraft.updateDisplay();
    }

    static int \u039a(int n, int n2, int n3, boolean bl) {
        int n4;
        int n5 = n3 == 0 ? 0x88D505B3 ^ 0x88D5065B : n3;
        for (n4 = 1; n4 < n5 && n / (n4 + 1) >= (0x88D5071B ^ 0x88D5065B) && n2 / (n4 + 1) >= (0x88D506AB ^ 0x88D5065B); ++n4) {
        }
        if (bl && n4 > 1 && n4 % (0x88D50659 ^ 0x88D5065B) != 0) {
            --n4;
        }
        return n4;
    }

    static int \u03ec(int n, int n2) {
        return (int)Math.ceil((double)n / (double)n2);
    }

    static float u(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    static int \u0137(float f) {
        return Math.round(116.0f * occ0c83447ab.u(f));
    }

    static float \u057b(float f) {
        float f2 = occ0c83447ab.u(f);
        if (f2 <= 0.0f || f2 >= 1.0f) {
            return f2;
        }
        return 1.0f - (float)Math.pow(2.0, -10.0f * f2);
    }

    static float \u018d(float f, float f2, float f3) {
        float f4 = occ0c83447ab.u(f);
        float f5 = occ0c83447ab.u(f2);
        return f4 + (f5 - f4) * occ0c83447ab.\u057b(f3);
    }

    private static long \u00fe(float f, float f2) {
        double d = Math.abs(occ0c83447ab.u(f2) - occ0c83447ab.u(f));
        if (d == 0.0) {
            return 0L;
        }
        return Math.max(0x437902C8A0B0C04DL ^ 0x437902C8A5ED8ACDL, Math.round(6.0E8 * d));
    }

    private static void \u03ea(int n, int n2, float f) {
        int n3 = n - (0x4291956D ^ 0x42919557);
        int n4 = occ0c83447ab.\u0137(f);
        occ0c83447ab.\u04eb(n3 - (0x42919555 ^ 0x42919557), n2 - (0x42919555 ^ 0x42919557), 0x4291952F ^ 0x42919557, 0x42919550 ^ 0x42919557, 0x506E6AA8 ^ 0x42919557);
        occ0c83447ab.\u04eb(n3 - 1, n2 - 1, 0x42919521 ^ 0x42919557, 0x42919552 ^ 0x42919557, 0x7A6E6AA8 ^ 0x42919557);
        occ0c83447ab.\u04eb(n3, n2, 0x42919523 ^ 0x42919557, 0x42919554 ^ 0x42919557, 0xBD808275 ^ 0x42919557);
        if (n4 > 0) {
            occ0c83447ab.\u04eb(n3 - 1, n2 - 1, n4 + (0x42919555 ^ 0x42919557), 0x42919552 ^ 0x42919557, 0x666E6AA8 ^ 0x42919557);
            occ0c83447ab.\u02b3(n3, n2, n3 + n4, n2 + (0x42919554 ^ 0x42919557), -1, -1);
        }
        int n5 = Math.max(n3 + (0x42919554 ^ 0x42919557), Math.min(n3 + n4, n3 + (0x42919523 ^ 0x42919557) - (0x42919554 ^ 0x42919557)));
        occ0c83447ab.\u0183(n5, n2 - (0x42919551 ^ 0x42919557), -1);
    }

    private static void \u04eb(int n, int n2, int n3, int n4, int n5) {
        if (n3 <= 0 || n4 <= 0) {
            return;
        }
        if (n4 < (0x89B08BC4 ^ 0x89B08BC7) || n3 < (0x89B08BC4 ^ 0x89B08BC7)) {
            Gui.drawRect(n, n2, n + n3, n2 + n4, n5);
            return;
        }
        Gui.drawRect(n + 1, n2, n + n3 - 1, n2 + n4, n5);
        Gui.drawRect(n, n2 + 1, n + n3, n2 + n4 - 1, n5);
    }

    private static void \u0183(int n, int n2, int n3) {
        Gui.drawRect(n - (0x2B867E8D ^ 0x2B867E8E), n2 + (0x2B867E8C ^ 0x2B867E8E), n + (0x2B867E8A ^ 0x2B867E8E), n2 + (0x2B867E88 ^ 0x2B867E8E), n3);
        Gui.drawRect(n - (0x2B867E8D ^ 0x2B867E8E), n2, n - 1, n2 + (0x2B867E8D ^ 0x2B867E8E), n3);
        Gui.drawRect(n + (0x2B867E8C ^ 0x2B867E8E), n2, n + (0x2B867E8A ^ 0x2B867E8E), n2 + (0x2B867E8D ^ 0x2B867E8E), n3);
        Gui.drawRect(n - 1, n2 + (0x2B867E8D ^ 0x2B867E8E), n, n2 + (0x2B867E8A ^ 0x2B867E8E), 0xE7816E94 ^ 0x2B867E8E);
        Gui.drawRect(n + (0x2B867E8C ^ 0x2B867E8E), n2 + (0x2B867E8D ^ 0x2B867E8E), n + (0x2B867E8D ^ 0x2B867E8E), n2 + (0x2B867E8A ^ 0x2B867E8E), 0xE7816E94 ^ 0x2B867E8E);
    }

    private static void \u02b3(int n, int n2, int n3, int n4, int n5, int n6) {
        if (n3 <= n) {
            return;
        }
        float f = (float)(n5 >> (0xA749C67D ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f2 = (float)(n5 >> (0xA749C675 ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f3 = (float)(n5 >> (0xA749C66D ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f4 = (float)(n5 & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f5 = (float)(n6 >> (0xA749C67D ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f6 = (float)(n6 >> (0xA749C675 ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f7 = (float)(n6 >> (0xA749C66D ^ 0xA749C665) & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        float f8 = (float)(n6 & (0xA749C69A ^ 0xA749C665)) / 255.0f;
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(0xA749C567 ^ 0xA749C665, 0xA749C566 ^ 0xA749C665, 1, 0);
        GlStateManager.shadeModel(0xA749DB64 ^ 0xA749C665);
        worldRenderer.begin(0xA749C662 ^ 0xA749C665, DefaultVertexFormats.POSITION_COLOR);
        worldRenderer.pos(n3, n2, 0.0).color(f6, f7, f8, f5).endVertex();
        worldRenderer.pos(n, n2, 0.0).color(f2, f3, f4, f).endVertex();
        worldRenderer.pos(n, n4, 0.0).color(f2, f3, f4, f).endVertex();
        worldRenderer.pos(n3, n4, 0.0).color(f6, f7, f8, f5).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(0xA749DB65 ^ 0xA749C665);
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
    }

    private static void \u043e(int n, int n2) {
        GlStateManager.matrixMode(0x5BE14FBB ^ 0x5BE158BA);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0, n, n2, 0.0, 1000.0, 3000.0);
        GlStateManager.matrixMode(0x5BE14FBA ^ 0x5BE158BA);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0f, 0.0f, -2000.0f);
    }

    private static void \u03b8() {
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();
    }
}

