/*
 * Decompiled with CFR 0.152.
 */
package net.optifine.shaders;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import net.optifine.shaders.SMCLog;
import net.optifine.shaders.Shaders;
import org.apache.commons.io.IOUtils;

public class SimpleShaderTexture
extends AbstractTexture {
    private String texturePath;
    private static final IMetadataSerializer METADATA_SERIALIZER = SimpleShaderTexture.makeMetadataSerializer();

    public SimpleShaderTexture(String string) {
        this.texturePath = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void loadTexture(IResourceManager iResourceManager) throws IOException {
        this.deleteGlTexture();
        InputStream inputStream2 = Shaders.getShaderPackResourceStream(this.texturePath);
        if (inputStream2 == null) {
            throw new FileNotFoundException("Shader texture not found: " + this.texturePath);
        }
        try {
            BufferedImage bufferedImage = TextureUtil.readBufferedImage(inputStream2);
            TextureMetadataSection textureMetadataSection = SimpleShaderTexture.loadTextureMetadataSection(this.texturePath, new TextureMetadataSection(false, false, new ArrayList<Integer>()));
            TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), bufferedImage, textureMetadataSection.getTextureBlur(), textureMetadataSection.getTextureClamp());
        }
        finally {
            IOUtils.closeQuietly(inputStream2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static TextureMetadataSection loadTextureMetadataSection(String string, TextureMetadataSection textureMetadataSection) {
        String string2 = string + ".mcmeta";
        String string3 = "texture";
        InputStream inputStream2 = Shaders.getShaderPackResourceStream(string2);
        if (inputStream2 != null) {
            TextureMetadataSection textureMetadataSection2;
            TextureMetadataSection textureMetadataSection3;
            IMetadataSerializer iMetadataSerializer = METADATA_SERIALIZER;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
            try {
                JsonObject jsonObject = new JsonParser().parse(bufferedReader).getAsJsonObject();
                textureMetadataSection3 = (TextureMetadataSection)iMetadataSerializer.parseMetadataSection(string3, jsonObject);
                if (textureMetadataSection3 == null) {
                    TextureMetadataSection textureMetadataSection4 = textureMetadataSection;
                    return textureMetadataSection4;
                }
                textureMetadataSection2 = textureMetadataSection3;
            }
            catch (RuntimeException runtimeException) {
                SMCLog.warning("Error reading metadata: " + string2);
                SMCLog.warning(runtimeException.getClass().getName() + ": " + runtimeException.getMessage());
                textureMetadataSection3 = textureMetadataSection;
                return textureMetadataSection3;
            }
            finally {
                IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(inputStream2);
            }
            return textureMetadataSection2;
        }
        return textureMetadataSection;
    }

    private static IMetadataSerializer makeMetadataSerializer() {
        IMetadataSerializer iMetadataSerializer = new IMetadataSerializer();
        iMetadataSerializer.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
        iMetadataSerializer.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
        iMetadataSerializer.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
        iMetadataSerializer.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
        iMetadataSerializer.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
        return iMetadataSerializer;
    }
}

