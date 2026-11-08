/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.player.CapeImageBuffer;

public class CapeUtils {
    private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z0-9_]+");

    public static void downloadCape(AbstractClientPlayer abstractClientPlayer) {
        String string = abstractClientPlayer.getNameClear();
        if (string != null && !string.isEmpty() && !string.contains("\u0000") && PATTERN_USERNAME.matcher(string).matches()) {
            Object object;
            String string2 = "http://s.optifine.net/capes/" + string + ".png";
            ResourceLocation resourceLocation = new ResourceLocation("capeof/" + string);
            TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
            ITextureObject iTextureObject = textureManager.getTexture(resourceLocation);
            if (iTextureObject != null && iTextureObject instanceof ThreadDownloadImageData) {
                object = (ThreadDownloadImageData)iTextureObject;
                if (((ThreadDownloadImageData)object).imageFound != null) {
                    if (((ThreadDownloadImageData)object).imageFound.booleanValue()) {
                        abstractClientPlayer.setLocationOfCape(resourceLocation);
                        if (((ThreadDownloadImageData)object).getImageBuffer() instanceof CapeImageBuffer) {
                            CapeImageBuffer capeImageBuffer = (CapeImageBuffer)((ThreadDownloadImageData)object).getImageBuffer();
                            abstractClientPlayer.setElytraOfCape(capeImageBuffer.isElytraOfCape());
                        }
                    }
                    return;
                }
            }
            object = new CapeImageBuffer(abstractClientPlayer, resourceLocation);
            ThreadDownloadImageData threadDownloadImageData = new ThreadDownloadImageData(null, string2, null, (IImageBuffer)object);
            threadDownloadImageData.pipeline = true;
            textureManager.loadTexture(resourceLocation, threadDownloadImageData);
        }
    }

    public static BufferedImage parseCape(BufferedImage bufferedImage) {
        int n;
        int n2 = 64;
        int n3 = bufferedImage.getWidth();
        int n4 = bufferedImage.getHeight();
        for (n = 32; n2 < n3 || n < n4; n2 *= 2, n *= 2) {
        }
        BufferedImage bufferedImage2 = new BufferedImage(n2, n, 2);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        graphics.dispose();
        return bufferedImage2;
    }

    public static boolean isElytraCape(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        return bufferedImage.getWidth() > bufferedImage2.getHeight();
    }

    public static void reloadCape(AbstractClientPlayer abstractClientPlayer) {
        String string = abstractClientPlayer.getNameClear();
        ResourceLocation resourceLocation = new ResourceLocation("capeof/" + string);
        TextureManager textureManager = Config.getTextureManager();
        ITextureObject iTextureObject = textureManager.getTexture(resourceLocation);
        if (iTextureObject instanceof SimpleTexture) {
            SimpleTexture simpleTexture = (SimpleTexture)iTextureObject;
            simpleTexture.deleteGlTexture();
            textureManager.deleteTexture(resourceLocation);
        }
        abstractClientPlayer.setLocationOfCape(null);
        abstractClientPlayer.setElytraOfCape(false);
        CapeUtils.downloadCape(abstractClientPlayer);
    }
}

