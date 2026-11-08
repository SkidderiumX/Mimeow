/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.base.Charsets;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractResourcePack
implements IResourcePack {
    private static final Logger resourceLog = LogManager.getLogger();
    public final File resourcePackFile;

    public AbstractResourcePack(File file) {
        this.resourcePackFile = file;
    }

    private static String locationToName(ResourceLocation resourceLocation) {
        return String.format("%s/%s/%s", "assets", resourceLocation.getResourceDomain(), resourceLocation.getResourcePath());
    }

    protected static String getRelativeName(File file, File file2) {
        return file.toURI().relativize(file2.toURI()).getPath();
    }

    @Override
    public InputStream getInputStream(ResourceLocation resourceLocation) throws IOException {
        return this.getInputStreamByName(AbstractResourcePack.locationToName(resourceLocation));
    }

    @Override
    public boolean resourceExists(ResourceLocation resourceLocation) {
        return this.hasResourceName(AbstractResourcePack.locationToName(resourceLocation));
    }

    protected abstract InputStream getInputStreamByName(String var1) throws IOException;

    protected abstract boolean hasResourceName(String var1);

    protected void logNameNotLowercase(String string) {
        resourceLog.warn("ResourcePack: ignored non-lowercase namespace: {} in {}", string, this.resourcePackFile);
    }

    @Override
    public <T extends IMetadataSection> T getPackMetadata(IMetadataSerializer iMetadataSerializer, String string) throws IOException {
        return AbstractResourcePack.readMetadata(iMetadataSerializer, this.getInputStreamByName("pack.mcmeta"), string);
    }

    static <T extends IMetadataSection> T readMetadata(IMetadataSerializer iMetadataSerializer, InputStream inputStream2, String string) {
        JsonObject jsonObject = null;
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, Charsets.UTF_8));
            jsonObject = new JsonParser().parse(bufferedReader).getAsJsonObject();
        }
        catch (RuntimeException runtimeException) {
            try {
                throw new JsonParseException(runtimeException);
            }
            catch (Throwable throwable) {
                IOUtils.closeQuietly(bufferedReader);
                throw throwable;
            }
        }
        IOUtils.closeQuietly(bufferedReader);
        return iMetadataSerializer.parseMetadataSection(string, jsonObject);
    }

    @Override
    public BufferedImage getPackImage() throws IOException {
        return TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
    }

    @Override
    public String getPackName() {
        return this.resourcePackFile.getName();
    }
}

