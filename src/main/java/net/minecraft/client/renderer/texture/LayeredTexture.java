/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LayeredTexture
extends AbstractTexture {
    private static final Logger logger = LogManager.getLogger();
    public final List<String> layeredTextureNames;
    private ResourceLocation textureLocation;

    public LayeredTexture(String ... stringArray) {
        this.layeredTextureNames = Lists.newArrayList(stringArray);
        if (stringArray.length > 0 && stringArray[0] != null) {
            this.textureLocation = new ResourceLocation(stringArray[0]);
        }
    }

    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        this.deleteGlTexture();
        BufferedImage bufferedImage = null;
        try {
            for (String string : this.layeredTextureNames) {
                if (string == null) continue;
                InputStream inputStream2 = iResourceManager.getResource(new ResourceLocation(string)).getInputStream();
                BufferedImage bufferedImage2 = TextureUtil.readBufferedImage(inputStream2);
                if (bufferedImage == null) {
                    bufferedImage = new BufferedImage(bufferedImage2.getWidth(), bufferedImage2.getHeight(), 2);
                }
                bufferedImage.getGraphics().drawImage(bufferedImage2, 0, 0, null);
            }
        }
        catch (IOException iOException) {
            logger.error("Couldn't load layered image", (Throwable)iOException);
            return;
        }
        if (Config.isShaders()) {
            ShadersTex.loadSimpleTexture(this.getGlTextureId(), bufferedImage, false, false, iResourceManager, this.textureLocation, this.getMultiTexID());
        } else {
            TextureUtil.uploadTextureImage(this.getGlTextureId(), bufferedImage);
        }
    }
}

