/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import net.minecraft.client.renderer.IImageBuffer;

public class ImageBufferDownload
implements IImageBuffer {
    private int[] imageData;
    private int imageWidth;
    private int imageHeight;

    @Override
    public BufferedImage parseUserSkin(BufferedImage bufferedImage) {
        if (bufferedImage == null) {
            return null;
        }
        this.imageWidth = 64;
        this.imageHeight = 64;
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int n3 = 1;
        while (this.imageWidth < n || this.imageHeight < n2) {
            this.imageWidth *= 2;
            this.imageHeight *= 2;
            n3 *= 2;
        }
        BufferedImage bufferedImage2 = new BufferedImage(this.imageWidth, this.imageHeight, 2);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(bufferedImage, 0, 0, null);
        if (bufferedImage.getHeight() == 32 * n3) {
            graphics.drawImage(bufferedImage2, 24 * n3, 48 * n3, 20 * n3, 52 * n3, 4 * n3, 16 * n3, 8 * n3, 20 * n3, null);
            graphics.drawImage(bufferedImage2, 28 * n3, 48 * n3, 24 * n3, 52 * n3, 8 * n3, 16 * n3, 12 * n3, 20 * n3, null);
            graphics.drawImage(bufferedImage2, 20 * n3, 52 * n3, 16 * n3, 64 * n3, 8 * n3, 20 * n3, 12 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 24 * n3, 52 * n3, 20 * n3, 64 * n3, 4 * n3, 20 * n3, 8 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 28 * n3, 52 * n3, 24 * n3, 64 * n3, 0 * n3, 20 * n3, 4 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 32 * n3, 52 * n3, 28 * n3, 64 * n3, 12 * n3, 20 * n3, 16 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 40 * n3, 48 * n3, 36 * n3, 52 * n3, 44 * n3, 16 * n3, 48 * n3, 20 * n3, null);
            graphics.drawImage(bufferedImage2, 44 * n3, 48 * n3, 40 * n3, 52 * n3, 48 * n3, 16 * n3, 52 * n3, 20 * n3, null);
            graphics.drawImage(bufferedImage2, 36 * n3, 52 * n3, 32 * n3, 64 * n3, 48 * n3, 20 * n3, 52 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 40 * n3, 52 * n3, 36 * n3, 64 * n3, 44 * n3, 20 * n3, 48 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 44 * n3, 52 * n3, 40 * n3, 64 * n3, 40 * n3, 20 * n3, 44 * n3, 32 * n3, null);
            graphics.drawImage(bufferedImage2, 48 * n3, 52 * n3, 44 * n3, 64 * n3, 52 * n3, 20 * n3, 56 * n3, 32 * n3, null);
        }
        graphics.dispose();
        this.imageData = ((DataBufferInt)bufferedImage2.getRaster().getDataBuffer()).getData();
        this.setAreaOpaque(0 * n3, 0 * n3, 32 * n3, 16 * n3);
        this.setAreaTransparent(32 * n3, 0 * n3, 64 * n3, 32 * n3);
        this.setAreaOpaque(0 * n3, 16 * n3, 64 * n3, 32 * n3);
        this.setAreaTransparent(0 * n3, 32 * n3, 16 * n3, 48 * n3);
        this.setAreaTransparent(16 * n3, 32 * n3, 40 * n3, 48 * n3);
        this.setAreaTransparent(40 * n3, 32 * n3, 56 * n3, 48 * n3);
        this.setAreaTransparent(0 * n3, 48 * n3, 16 * n3, 64 * n3);
        this.setAreaOpaque(16 * n3, 48 * n3, 48 * n3, 64 * n3);
        this.setAreaTransparent(48 * n3, 48 * n3, 64 * n3, 64 * n3);
        return bufferedImage2;
    }

    @Override
    public void skinAvailable() {
    }

    private void setAreaTransparent(int n, int n2, int n3, int n4) {
        if (!this.hasTransparency(n, n2, n3, n4)) {
            for (int i = n; i < n3; ++i) {
                for (int j = n2; j < n4; ++j) {
                    int n5 = i + j * this.imageWidth;
                    this.imageData[n5] = this.imageData[n5] & 0xFFFFFF;
                }
            }
        }
    }

    private void setAreaOpaque(int n, int n2, int n3, int n4) {
        for (int i = n; i < n3; ++i) {
            for (int j = n2; j < n4; ++j) {
                int n5 = i + j * this.imageWidth;
                this.imageData[n5] = this.imageData[n5] | 0xFF000000;
            }
        }
    }

    private boolean hasTransparency(int n, int n2, int n3, int n4) {
        for (int i = n; i < n3; ++i) {
            for (int j = n2; j < n4; ++j) {
                int n5 = this.imageData[i + j * this.imageWidth];
                if ((n5 >> 24 & 0xFF) >= 128) continue;
                return true;
            }
        }
        return false;
    }
}

