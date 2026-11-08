/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.EmissiveTextures;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleTexture
extends AbstractTexture {
    private static final Logger logger = LogManager.getLogger();
    protected final ResourceLocation textureLocation;
    public ResourceLocation locationEmissive;
    public boolean isEmissive;

    public SimpleTexture(ResourceLocation resourceLocation) {
        this.textureLocation = resourceLocation;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        this.deleteGlTexture();
        try (InputStream inputStream2 = null;){
            IResource iResource = iResourceManager.getResource(this.textureLocation);
            inputStream2 = iResource.getInputStream();
            BufferedImage bufferedImage = TextureUtil.readBufferedImage(inputStream2);
            boolean bl = false;
            boolean bl2 = false;
            if (iResource.hasMetadata()) {
                try {
                    TextureMetadataSection textureMetadataSection = (TextureMetadataSection)iResource.getMetadata("texture");
                    if (textureMetadataSection != null) {
                        bl = textureMetadataSection.getTextureBlur();
                        bl2 = textureMetadataSection.getTextureClamp();
                    }
                }
                catch (RuntimeException runtimeException) {
                    logger.warn("Failed reading metadata of: " + String.valueOf(this.textureLocation), (Throwable)runtimeException);
                }
            }
            if (Config.isShaders()) {
                ShadersTex.loadSimpleTexture(this.getGlTextureId(), bufferedImage, bl, bl2, iResourceManager, this.textureLocation, this.getMultiTexID());
            } else {
                TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), bufferedImage, bl, bl2);
            }
            if (EmissiveTextures.isActive()) {
                EmissiveTextures.loadTexture(this.textureLocation, this);
            }
        }
    }
}

