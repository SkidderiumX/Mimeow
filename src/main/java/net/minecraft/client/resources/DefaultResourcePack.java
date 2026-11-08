/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.ImmutableSet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import net.optifine.reflect.ReflectorCompat;

public class DefaultResourcePack
implements IResourcePack {
    public static final Set<String> defaultResourceDomains = ImmutableSet.of("minecraft", "realms", "miau");
    private final Map<String, File> mapAssets;

    public DefaultResourcePack(Map<String, File> map) {
        this.mapAssets = map;
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) throws IOException {
        InputStream inputStream2 = this.getResourceStream(resourceLocation);
        if (inputStream2 != null) {
            return inputStream2;
        }
        InputStream inputStream3 = this.getInputStreamAssets(resourceLocation);
        if (inputStream3 != null) {
            return inputStream3;
        }
        throw new FileNotFoundException(resourceLocation.getResourcePath());
    }

    public InputStream getInputStreamAssets(ResourceLocation resourceLocation) throws IOException, FileNotFoundException {
        File file = this.mapAssets.get(resourceLocation.toString());
        return file != null && file.isFile() ? new FileInputStream(file) : null;
    }

    private InputStream getResourceStream(ResourceLocation resourceLocation) {
        String string = "/assets/" + resourceLocation.getResourceDomain() + "/" + resourceLocation.getResourcePath();
        InputStream inputStream2 = ReflectorCompat.getOptiFineResourceStream(string);
        return inputStream2 != null ? inputStream2 : DefaultResourcePack.class.getResourceAsStream(string);
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation) {
        return this.getResourceStream(resourceLocation) != null || this.mapAssets.containsKey(resourceLocation.toString());
    }

    @Override
    public Set<String> getResourceDomains() {
        return defaultResourceDomains;
    }

    @Override
    public <T extends IMetadataSection> T getPackMetadata(IMetadataSerializer iMetadataSerializer, String string) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.mapAssets.get("pack.mcmeta"));
            return AbstractResourcePack.readMetadata(iMetadataSerializer, fileInputStream, string);
        }
        catch (RuntimeException runtimeException) {
            return (T)((IMetadataSection)null);
        }
        catch (FileNotFoundException fileNotFoundException) {
            return (T)((IMetadataSection)null);
        }
    }

    @Override
    public BufferedImage getPackImage() throws IOException {
        BufferedImage bufferedImage;
        InputStream inputStream2 = DefaultResourcePack.class.getResourceAsStream("/" + new ResourceLocation("pack.png").getResourcePath());
        if (inputStream2 == null) {
            inputStream2 = DefaultResourcePack.class.getResourceAsStream("/assets/minecraft/textures/misc/unknown_pack.png");
        }
        if ((bufferedImage = TextureUtil.readBufferedImage(inputStream2)) != null) {
            return bufferedImage;
        }
        BufferedImage bufferedImage2 = new BufferedImage(16, 16, 2);
        for (int i = 0; i < bufferedImage2.getWidth(); ++i) {
            for (int j = 0; j < bufferedImage2.getHeight(); ++j) {
                int n = (i + j & 1) == 0 ? -8421505 : -10526881;
                bufferedImage2.setRGB(i, j, n);
            }
        }
        return bufferedImage2;
    }

    @Override
    public String getPackName() {
        return "Default";
    }
}

