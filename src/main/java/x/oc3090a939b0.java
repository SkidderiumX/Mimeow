/*
 * Decompiled with CFR 0.152.
 */
package x;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import x.oc1378bc114d;

public class oc3090a939b0
extends GuiButton {
    private static final String \u04c1 = "<";
    private static final ResourceLocation \u0159 = new ResourceLocation("miau", "gui.menu_button_hover");
    private static final float \u0284 = 3.0f;
    private static final float \u0443 = 0.035f;
    private static final float \u04f2 = 0.22f;
    private static final Color \u0273 = new Color(0x5B0D110E ^ 0x5B0D11E5, 0x5B0D1108 ^ 0x5B0D11E5, 0x5B0D1117 ^ 0x5B0D11E5);
    private static final Color \u037c = Color.WHITE;
    private final int \u03bc;
    private final oc1378bc114d \u02a5;
    private final boolean \u026c;
    private final long \u0376;
    private long \u0391;
    private float F;
    private boolean \u0532;

    public oc3090a939b0(int n, int n2, int n3, int n4, int n5, String string, int n6, oc1378bc114d oc1378bc114d2) {
        this(n, n2, n3, n4, n5, string, n6, oc1378bc114d2, false);
    }

    public oc3090a939b0(int n, int n2, int n3, int n4, int n5, String string, int n6, oc1378bc114d oc1378bc114d2, boolean bl) {
        super(n, n2, n3, n4, n5, string);
        this.\u03bc = n6;
        this.\u02a5 = oc1378bc114d2;
        this.\u026c = bl;
        this.\u0391 = this.\u0376 = System.nanoTime();
    }

    @Override
    public void drawButton(Minecraft minecraft, int n, int n2) {
        if (!this.visible) {
            this.\u0532 = false;
            return;
        }
        long l = System.nanoTime();
        float f = Math.min((float)(l - this.\u0391) / 1.0E9f, 0.05f);
        this.\u0391 = l;
        this.hovered = n >= this.xPosition && n2 >= this.yPosition && n < this.xPosition + this.width && n2 < this.yPosition + this.height;
        float f2 = this.enabled && this.hovered ? 1.0f : 0.0f;
        this.F += (f2 - this.F) * Math.min(1.0f, f * 14.0f);
        float f3 = (float)(l - this.\u0376) / 1.0E9f;
        float f4 = oc3090a939b0.\u0257(f3, this.\u03bc);
        if (this.\u0121(this.enabled && this.hovered && f4 > 0.0f)) {
            minecraft.getSoundHandler().playSound(PositionedSoundRecord.create(\u0159));
        }
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = (float)this.xPosition + (float)this.width / 2.0f;
        float f6 = (float)this.yPosition + (float)this.height / 2.0f;
        float f7 = 0.97f + f4 * 0.03f;
        Color color = this.enabled ? oc3090a939b0.m(\u0273, \u037c, this.F) : new Color(0xBCD4543A ^ 0xBCD45447, 0xBCD454C7 ^ 0xBCD45447, 0xBCD454CD ^ 0xBCD45447);
        GlStateManager.pushMatrix();
        GlStateManager.translate(f5, f6 + (1.0f - f4) * 4.0f, 0.0f);
        GlStateManager.scale(f7, f7, 1.0f);
        GlStateManager.translate(-f5, -f6, 0.0f);
        int n3 = this.\u02a5.z$toz8pt08w0nc(this.displayString);
        int n4 = this.\u026c ? this.\u02a5.z$toz8pt08w0nc("<") : 0;
        float f8 = this.\u026c ? ((float)n4 + 3.0f) * this.F : 0.0f;
        float f9 = (float)this.xPosition + (this.\u026c ? (float)(this.width - n3) - f8 : 0.0f);
        float f10 = (float)this.yPosition + (float)(this.height - this.\u02a5.z$1tqmx4tpnr6lq()) / 2.0f;
        this.\u02a5.z$ao2ykh4tuw6w(this.displayString, f9, f10, color.getRGB(), false);
        if (this.\u026c && this.F > 0.01f) {
            int n5 = Math.max(1, Math.round(255.0f * this.F));
            Color color2 = new Color(color.getRed(), color.getGreen(), color.getBlue(), n5);
            float f11 = this.xPosition + this.width;
            GlStateManager.pushMatrix();
            GlStateManager.translate(f11, f6, 0.0f);
            GlStateManager.scale(this.F, this.F, 1.0f);
            GlStateManager.translate(-f11, -f6, 0.0f);
            this.\u02a5.z$ao2ykh4tuw6w("<", f11 - (float)n4, f10, color2.getRGB(), false);
            GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    boolean \u0121(boolean bl) {
        boolean bl2 = bl && !this.\u0532;
        this.\u0532 = bl;
        return bl2;
    }

    private static float \u0406(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    public static float \u0257(float f, int n) {
        float f2 = (float)Math.max(0, n) * 0.035f;
        float f3 = oc3090a939b0.\u0406((f - f2) / 0.22f);
        return 1.0f - (float)Math.pow(1.0f - f3, 3.0);
    }

    private static Color m(Color color, Color color2, float f) {
        float f2 = oc3090a939b0.\u0406(f);
        return new Color(Math.round((float)color.getRed() + (float)(color2.getRed() - color.getRed()) * f2), Math.round((float)color.getGreen() + (float)(color2.getGreen() - color.getGreen()) * f2), Math.round((float)color.getBlue() + (float)(color2.getBlue() - color.getBlue()) * f2), Math.round((float)color.getAlpha() + (float)(color2.getAlpha() - color.getAlpha()) * f2));
    }
}

