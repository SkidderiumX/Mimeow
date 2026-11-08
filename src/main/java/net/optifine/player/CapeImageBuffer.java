/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.player;

import java.awt.image.BufferedImage;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.util.ResourceLocation;
import net.optifine.player.CapeUtils;

public class CapeImageBuffer
extends ImageBufferDownload {
    private AbstractClientPlayer player;
    private ResourceLocation resourceLocation;
    private boolean elytraOfCape;

    public CapeImageBuffer(AbstractClientPlayer abstractClientPlayer, ResourceLocation resourceLocation) {
        this.player = abstractClientPlayer;
        this.resourceLocation = resourceLocation;
    }

    @Override
    public BufferedImage parseUserSkin(BufferedImage bufferedImage) {
        BufferedImage bufferedImage2 = CapeUtils.parseCape(bufferedImage);
        this.elytraOfCape = CapeUtils.isElytraCape(bufferedImage, bufferedImage2);
        return bufferedImage2;
    }

    @Override
    public void skinAvailable() {
        if (this.player != null) {
            this.player.setLocationOfCape(this.resourceLocation);
            this.player.setElytraOfCape(this.elytraOfCape);
        }
        this.cleanup();
    }

    public void cleanup() {
        this.player = null;
    }

    public boolean isElytraOfCape() {
        return this.elytraOfCape;
    }
}

