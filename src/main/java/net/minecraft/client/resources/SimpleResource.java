/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.IOUtils;

public class SimpleResource
implements IResource {
    private final Map<String, IMetadataSection> mapMetadataSections = Maps.newHashMap();
    private final String resourcePackName;
    private final ResourceLocation srResourceLocation;
    private final InputStream resourceInputStream;
    private final InputStream mcmetaInputStream;
    private final IMetadataSerializer srMetadataSerializer;
    private boolean mcmetaJsonChecked;
    private JsonObject mcmetaJson;

    public SimpleResource(String string, ResourceLocation resourceLocation, InputStream inputStream2, InputStream inputStream3, IMetadataSerializer iMetadataSerializer) {
        this.resourcePackName = string;
        this.srResourceLocation = resourceLocation;
        this.resourceInputStream = inputStream2;
        this.mcmetaInputStream = inputStream3;
        this.srMetadataSerializer = iMetadataSerializer;
    }

    @Override
    public ResourceLocation getResourceLocation() {
        return this.srResourceLocation;
    }

    @Override
    public InputStream getInputStream() {
        return this.resourceInputStream;
    }

    @Override
    public boolean hasMetadata() {
        return this.mcmetaInputStream != null;
    }

    @Override
    public <T extends IMetadataSection> T getMetadata(String string) {
        Object object;
        if (!this.hasMetadata()) {
            return (T)((IMetadataSection)null);
        }
        if (this.mcmetaJson == null && !this.mcmetaJsonChecked) {
            this.mcmetaJsonChecked = true;
            object = null;
            try {
                object = new BufferedReader(new InputStreamReader(this.mcmetaInputStream));
                this.mcmetaJson = new JsonParser().parse((Reader)object).getAsJsonObject();
            }
            finally {
                IOUtils.closeQuietly((Reader)object);
            }
        }
        if ((object = this.mapMetadataSections.get(string)) == null) {
            object = this.srMetadataSerializer.parseMetadataSection(string, this.mcmetaJson);
        }
        return (T)object;
    }

    @Override
    public String getResourcePackName() {
        return this.resourcePackName;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SimpleResource)) {
            return false;
        }
        SimpleResource simpleResource = (SimpleResource)object;
        if (this.srResourceLocation != null ? !this.srResourceLocation.equals(simpleResource.srResourceLocation) : simpleResource.srResourceLocation != null) {
            return false;
        }
        return !(this.resourcePackName != null ? !this.resourcePackName.equals(simpleResource.resourcePackName) : simpleResource.resourcePackName != null);
    }

    public int hashCode() {
        int n = this.resourcePackName != null ? this.resourcePackName.hashCode() : 0;
        n = 31 * n + (this.srResourceLocation != null ? this.srResourceLocation.hashCode() : 0);
        return n;
    }
}

