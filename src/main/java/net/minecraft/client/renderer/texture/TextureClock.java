/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.MathHelper;

public class TextureClock
extends TextureAtlasSprite {
    private double currentAngle;
    private double angleDelta;

    public TextureClock(String string) {
        super(string);
    }

    @Override
    public void updateAnimation() {
        if (!this.framesTextureData.isEmpty()) {
            double d;
            Minecraft minecraft = Minecraft.getMinecraft();
            double d2 = 0.0;
            if (minecraft.theWorld != null && minecraft.thePlayer != null) {
                d2 = minecraft.theWorld.getCelestialAngle(1.0f);
                if (!minecraft.theWorld.provider.isSurfaceWorld()) {
                    d2 = Math.random();
                }
            }
            for (d = d2 - this.currentAngle; d < -0.5; d += 1.0) {
            }
            while (d >= 0.5) {
                d -= 1.0;
            }
            d = MathHelper.clamp_double(d, -1.0, 1.0);
            this.angleDelta += d * 0.1;
            this.angleDelta *= 0.8;
            this.currentAngle += this.angleDelta;
            int n = (int)((this.currentAngle + 1.0) * (double)this.framesTextureData.size()) % this.framesTextureData.size();
            while (n < 0) {
                n = (n + this.framesTextureData.size()) % this.framesTextureData.size();
            }
            if (n != this.frameCounter) {
                this.frameCounter = n;
                TextureUtil.uploadTextureMipmap((int[][])this.framesTextureData.get(this.frameCounter), this.width, this.height, this.originX, this.originY, false, false);
            }
        }
    }
}

