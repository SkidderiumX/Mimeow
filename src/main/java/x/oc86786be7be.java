/*
 * Decompiled with CFR 0.152.
 */
package x;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import x.oc66fa4f2195;
import x.oc69da1aa7f5;
import x.oc746a23b244;
import x.oc7ab2161b9f;
import x.oca9cc61aada;
import x.ocdd342096f8;
import x.oce4cea752dd;
import x.oce6044968f8;

public class oc86786be7be
extends oc69da1aa7f5 {
    private static final String[] \u03e6;
    private static final String[] \u018e;
    private static final int \u028b;
    private static final int \u0445 = 33;
    private static final int \u046d = 30;
    private static final ResourceLocation[] \u0109;
    private static final ResourceLocation[] \u0106;
    private final oca9cc61aada \u0575;
    private final oca9cc61aada \u0376;
    private final oca9cc61aada \u015a;
    private final oca9cc61aada \u020f;
    public static boolean \u0263;

    public oc86786be7be() {
        super("Emojify", oce4cea752dd.\u014e);
        this.\u0105("Displays icon above your combat target.");
        this.\u0575 = new oca9cc61aada("Mode", 0, \u03e6);
        this.\u028c(this.\u0575);
        this.\u0376 = new oca9cc61aada("Scale", "x", 1.5, 0.1, 5.0, 0.1);
        this.\u028c(this.\u0376);
        this.\u015a = new oca9cc61aada("Height offset", 0.5, -2.0, 3.0, 0.1);
        this.\u028c(this.\u015a);
        this.\u020f = new oca9cc61aada("Opacity", 1.0, 0.1, 1.0, 0.05);
        this.\u028c(this.\u020f);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @oc66fa4f2195
    public void \u053f(oc746a23b244 oc746a23b2442) {
        EntityLivingBase entityLivingBase;
        EntityLivingBase entityLivingBase2;
        block17: {
            boolean bl;
            block16: {
                block15: {
                    entityLivingBase2 = ocdd342096f8.f;
                    bl = oce6044968f8.\u0452;
                    if (!oc7ab2161b9f.\u00d0()) return;
                    entityLivingBase = entityLivingBase2;
                    if (bl) break block15;
                    if (entityLivingBase == null) return;
                    entityLivingBase = entityLivingBase2;
                }
                if (bl) break block16;
                if (entityLivingBase.isDead) return;
                entityLivingBase = entityLivingBase2;
            }
            if (bl) break block17;
            if (!entityLivingBase.isEntityAlive()) return;
            entityLivingBase = entityLivingBase2;
        }
        if (entityLivingBase.isInvisible()) {
            return;
        }
        RenderManager renderManager = oc69da1aa7f5.\u0151.getRenderManager();
        float f = oc746a23b2442.\u0401;
        double d = entityLivingBase2.lastTickPosX + (entityLivingBase2.posX - entityLivingBase2.lastTickPosX) * (double)f - renderManager.viewerPosX;
        double d2 = entityLivingBase2.lastTickPosY + (entityLivingBase2.posY - entityLivingBase2.lastTickPosY) * (double)f - renderManager.viewerPosY;
        double d3 = entityLivingBase2.lastTickPosZ + (entityLivingBase2.posZ - entityLivingBase2.lastTickPosZ) * (double)f - renderManager.viewerPosZ;
        this.\u0170(renderManager, d, d2 + (double)entityLivingBase2.getEyeHeight() + this.\u015a.\u04c1(), d3);
    }

    private void \u0170(RenderManager renderManager, double d, double d2, double d3) {
        float f;
        block10: {
            block11: {
                float f2;
                float f3;
                boolean bl;
                block8: {
                    block9: {
                        GL11.glPushMatrix();
                        bl = oce6044968f8.\u0452;
                        GlStateManager.translate(d, d2, d3);
                        f3 = -renderManager.playerViewY;
                        f2 = 0.0f;
                        if (bl) break block8;
                        GlStateManager.rotate(f3, f2, 1.0f, 0.0f);
                        f3 = renderManager.playerViewX;
                        if (oc69da1aa7f5.\u0151.gameSettings.thirdPersonView != (0x95ACE524 ^ 0x95ACE526)) break block9;
                        f2 = -1.0f;
                        break block8;
                    }
                    f2 = 1.0f;
                }
                GlStateManager.rotate(f3 * f2, 1.0f, 0.0f, 0.0f);
                float f4 = 0.025f * (float)this.\u0376.\u04c1();
                GlStateManager.scale(-f4, -f4, f4);
                GlStateManager.disableLighting();
                GlStateManager.depthMask(false);
                GlStateManager.disableDepth();
                GlStateManager.enableBlend();
                GlStateManager.enableTexture2D();
                GlStateManager.tryBlendFuncSeparate(0x95ACE624 ^ 0x95ACE526, 0x95ACE625 ^ 0x95ACE526, 1, 0);
                oc69da1aa7f5.\u0151.getTextureManager().bindTexture(this.\u01a8());
                float f5 = GL11.glGetTexLevelParameteri(0x95ACE8C7 ^ 0x95ACE526, 0, 0x95ACF526 ^ 0x95ACE526);
                float f6 = GL11.glGetTexLevelParameteri(0x95ACE8C7 ^ 0x95ACE526, 0, 0x95ACF527 ^ 0x95ACE526);
                f = f6;
                if (bl) break block10;
                if (!(f > 0.0f)) break block11;
                f = f5 / f6;
                break block10;
            }
            f = 1.0f;
        }
        float f7 = f;
        float f8 = 50.0f;
        float f9 = f8 * f7;
        GlStateManager.color(1.0f, 1.0f, 1.0f, (float)this.\u020f.\u04c1());
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.begin(0x95ACE521 ^ 0x95ACE526, DefaultVertexFormats.POSITION_TEX);
        worldRenderer.pos(-f9, -f8, 0.0).tex(0.0, 0.0).endVertex();
        worldRenderer.pos(-f9, f8, 0.0).tex(0.0, 1.0).endVertex();
        worldRenderer.pos(f9, f8, 0.0).tex(1.0, 1.0).endVertex();
        worldRenderer.pos(f9, -f8, 0.0).tex(1.0, 0.0).endVertex();
        tessellator.draw();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        GlStateManager.depthMask(true);
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GL11.glPopMatrix();
    }

    private ResourceLocation \u01a8() {
        int n = (int)Math.max(0.0, Math.min((double)(\u03e6.length - 1), this.\u0575.\u04c1()));
        if (n != \u028b) {
            return \u0109[n];
        }
        long l = 0x4A2A46649EB24891L ^ 0x4A2A46649EB248B0L;
        int n2 = (int)(System.currentTimeMillis() / l % (0x4A2A46649EB24891L ^ 0x4A2A46649EB248B0L));
        return \u0106[n2];
    }

    @Override
    public String getInfo() {
        int n = (int)Math.max(0.0, Math.min((double)(\u03e6.length - 1), this.\u0575.\u04c1()));
        return \u03e6[n];
    }

    private static ResourceLocation[] \u0546() {
        ResourceLocation[] resourceLocationArray = new ResourceLocation[\u018e.length];
        for (int i = 0; i < \u018e.length; ++i) {
            resourceLocationArray[i] = oc86786be7be.\u01a7(\u018e[i]);
        }
        return resourceLocationArray;
    }

    private static ResourceLocation[] \u0494() {
        ResourceLocation[] resourceLocationArray = new ResourceLocation[0x1D5EF7EF ^ 0x1D5EF7CE];
        for (int i = 0; i < (0x1D5EF7EF ^ 0x1D5EF7CE); ++i) {
            resourceLocationArray[i] = oc86786be7be.\u01a7(String.format("owo15/ezgif-frame-%03d.png", i + 1));
        }
        return resourceLocationArray;
    }

    static ResourceLocation \u01a7(String string) {
        return new ResourceLocation("mimeow/targeticon/" + string);
    }

    static {
        String[] stringArray = new String[0x32AF21B3 ^ 0x32AF21BC];
        stringArray[0] = "Ibuki";
        stringArray[1] = "Bocchi";
        stringArray[0x32AF21BE ^ 0x32AF21BC] = "Lappland";
        stringArray[0x32AF21BF ^ 0x32AF21BC] = "Jane Doe";
        stringArray[0x32AF21B8 ^ 0x32AF21BC] = "Hoshino1";
        stringArray[0x32AF21B9 ^ 0x32AF21BC] = "Hoshino2";
        stringArray[0x32AF21BA ^ 0x32AF21BC] = "Miyu";
        stringArray[0x32AF21BB ^ 0x32AF21BC] = "Reisa1";
        stringArray[0x32AF21B4 ^ 0x32AF21BC] = "Reisa2";
        stringArray[0x32AF21B5 ^ 0x32AF21BC] = "Seia";
        stringArray[0x32AF21B6 ^ 0x32AF21BC] = "Nachoneko1";
        stringArray[0x32AF21B7 ^ 0x32AF21BC] = "Nachoneko2";
        stringArray[0x32AF21B0 ^ 0x32AF21BC] = "Nachoneko3";
        stringArray[0x32AF21B1 ^ 0x32AF21BC] = "Nachoneko4";
        stringArray[0x32AF21B2 ^ 0x32AF21BC] = "MaoTuanMaoMao";
        \u03e6 = stringArray;
        String[] stringArray2 = new String[0x32AF21B2 ^ 0x32AF21BC];
        stringArray2[0] = "owo.png";
        stringArray2[1] = "owo2.png";
        stringArray2[0x32AF21BE ^ 0x32AF21BC] = "owo3.png";
        stringArray2[0x32AF21BF ^ 0x32AF21BC] = "owo4.png";
        stringArray2[0x32AF21B8 ^ 0x32AF21BC] = "owo5.png";
        stringArray2[0x32AF21B9 ^ 0x32AF21BC] = "owo6.png";
        stringArray2[0x32AF21BA ^ 0x32AF21BC] = "owo7.png";
        stringArray2[0x32AF21BB ^ 0x32AF21BC] = "owo8.png";
        stringArray2[0x32AF21B4 ^ 0x32AF21BC] = "owo9.png";
        stringArray2[0x32AF21B5 ^ 0x32AF21BC] = "owo10.png";
        stringArray2[0x32AF21B6 ^ 0x32AF21BC] = "owo11.png";
        stringArray2[0x32AF21B7 ^ 0x32AF21BC] = "owo12.png";
        stringArray2[0x32AF21B0 ^ 0x32AF21BC] = "owo13.png";
        stringArray2[0x32AF21B1 ^ 0x32AF21BC] = "owo14.png";
        \u018e = stringArray2;
        \u028b = \u03e6.length - 1;
        \u0109 = oc86786be7be.\u0546();
        \u0106 = oc86786be7be.\u0494();
    }
}

