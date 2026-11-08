/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FallbackResourceManager
implements IResourceManager {
    private static final Logger logger = LogManager.getLogger();
    protected final List<IResourcePack> resourcePacks = Lists.newArrayList();
    private final IMetadataSerializer frmMetadataSerializer;

    public FallbackResourceManager(IMetadataSerializer iMetadataSerializer) {
        this.frmMetadataSerializer = iMetadataSerializer;
    }

    public void addResourcePack(IResourcePack iResourcePack) {
        this.resourcePacks.add(iResourcePack);
    }

    @Override
    public Set<String> getResourceDomains() {
        return null;
    }

    @Override
    public IResource getResource(ResourceLocation resourceLocation) throws IOException {
        IResourcePack iResourcePack = null;
        ResourceLocation resourceLocation2 = FallbackResourceManager.getLocationMcmeta(resourceLocation);
        for (int i = this.resourcePacks.size() - 1; i >= 0; --i) {
            IResourcePack iResourcePack2 = this.resourcePacks.get(i);
            if (iResourcePack == null && iResourcePack2.resourceExists(resourceLocation2)) {
                iResourcePack = iResourcePack2;
            }
            if (!iResourcePack2.resourceExists(resourceLocation)) continue;
            InputStream inputStream2 = null;
            if (iResourcePack != null) {
                inputStream2 = this.getInputStream(resourceLocation2, iResourcePack);
            }
            return new SimpleResource(iResourcePack2.getPackName(), resourceLocation, this.getInputStream(resourceLocation, iResourcePack2), inputStream2, this.frmMetadataSerializer);
        }
        throw new FileNotFoundException(resourceLocation.toString());
    }

    protected InputStream getInputStream(ResourceLocation resourceLocation, IResourcePack iResourcePack) throws IOException {
        InputStream inputStream2 = iResourcePack.getInputStream(resourceLocation);
        return logger.isDebugEnabled() ? new InputStreamLeakedResourceLogger(inputStream2, resourceLocation, iResourcePack.getPackName()) : inputStream2;
    }

    @Override
    public List<IResource> getAllResources(ResourceLocation resourceLocation) throws IOException {
        ArrayList<IResource> arrayList = Lists.newArrayList();
        ResourceLocation resourceLocation2 = FallbackResourceManager.getLocationMcmeta(resourceLocation);
        for (IResourcePack iResourcePack : this.resourcePacks) {
            if (!iResourcePack.resourceExists(resourceLocation)) continue;
            InputStream inputStream2 = iResourcePack.resourceExists(resourceLocation2) ? this.getInputStream(resourceLocation2, iResourcePack) : null;
            arrayList.add(new SimpleResource(iResourcePack.getPackName(), resourceLocation, this.getInputStream(resourceLocation, iResourcePack), inputStream2, this.frmMetadataSerializer));
        }
        if (arrayList.isEmpty()) {
            throw new FileNotFoundException(resourceLocation.toString());
        }
        return arrayList;
    }

    static ResourceLocation getLocationMcmeta(ResourceLocation resourceLocation) {
        return new ResourceLocation(resourceLocation.getResourceDomain(), resourceLocation.getResourcePath() + ".mcmeta");
    }

    public static class InputStreamLeakedResourceLogger
    extends InputStream {
        private final InputStream inputStream;
        private final String message;
        private boolean isClosed = false;

        public InputStreamLeakedResourceLogger(InputStream inputStream2, ResourceLocation resourceLocation, String string) {
            this.inputStream = inputStream2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new Exception().printStackTrace(new PrintStream(byteArrayOutputStream));
            this.message = "Leaked resource: '" + String.valueOf(resourceLocation) + "' loaded from pack: '" + string + "'\n" + byteArrayOutputStream.toString();
        }

        @Override
        public void close() throws IOException {
            this.inputStream.close();
            this.isClosed = true;
        }

        protected void finalize() throws Throwable {
            if (!this.isClosed) {
                logger.warn(this.message);
            }
            super.finalize();
        }

        @Override
        public int read() throws IOException {
            return this.inputStream.read();
        }
    }
}

