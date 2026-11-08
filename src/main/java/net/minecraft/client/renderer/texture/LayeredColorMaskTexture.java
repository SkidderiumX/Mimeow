/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LayeredColorMaskTexture
extends AbstractTexture {
    private static final Logger LOG = LogManager.getLogger();
    private final ResourceLocation textureLocation;
    private final List<String> field_174949_h;
    private final List<EnumDyeColor> field_174950_i;

    public LayeredColorMaskTexture(ResourceLocation resourceLocation, List<String> list, List<EnumDyeColor> list2) {
        this.textureLocation = resourceLocation;
        this.field_174949_h = list;
        this.field_174950_i = list2;
    }

    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        BufferedImage bufferedImage;
        this.deleteGlTexture();
        try {
            BufferedImage bufferedImage2 = TextureUtil.readBufferedImage(iResourceManager.getResource(this.textureLocation).getInputStream());
            int n = bufferedImage2.getType();
            if (n == 0) {
                n = 6;
            }
            bufferedImage = new BufferedImage(bufferedImage2.getWidth(), bufferedImage2.getHeight(), n);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.drawImage(bufferedImage2, 0, 0, null);
            for (int i = 0; i < 17 && i < this.field_174949_h.size() && i < this.field_174950_i.size(); ++i) {
                InputStream inputStream2;
                BufferedImage bufferedImage3;
                String string = this.field_174949_h.get(i);
                MapColor mapColor = this.field_174950_i.get(i).getMapColor();
                if (string == null || (bufferedImage3 = TextureUtil.readBufferedImage(inputStream2 = iResourceManager.getResource(new ResourceLocation(string)).getInputStream())).getWidth() != bufferedImage.getWidth() || bufferedImage3.getHeight() != bufferedImage.getHeight() || bufferedImage3.getType() != 6) continue;
                for (int j = 0; j < bufferedImage3.getHeight(); ++j) {
                    for (int k = 0; k < bufferedImage3.getWidth(); ++k) {
                        int n2 = bufferedImage3.getRGB(k, j);
                        if ((n2 & 0xFF000000) == 0) continue;
                        int n3 = (n2 & 0xFF0000) << 8 & 0xFF000000;
                        int n4 = bufferedImage2.getRGB(k, j);
                        int n5 = MathHelper.func_180188_d(n4, mapColor.colorValue) & 0xFFFFFF;
                        bufferedImage3.setRGB(k, j, n3 | n5);
                    }
                }
                bufferedImage.getGraphics().drawImage(bufferedImage3, 0, 0, null);
            }
        }
        catch (IOException iOException) {
            LOG.error("Couldn't load layered image", (Throwable)iOException);
            return;
        }
        if (Config.isShaders()) {
            ShadersTex.loadSimpleTexture(this.getGlTextureId(), bufferedImage, false, false, iResourceManager, this.textureLocation, this.getMultiTexID());
        } else {
            TextureUtil.uploadTextureImage(this.getGlTextureId(), bufferedImage);
        }
    }
}

