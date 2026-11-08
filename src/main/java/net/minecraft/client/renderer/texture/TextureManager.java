/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.client.renderer.texture.ITickableTextureObject;
import net.minecraft.client.renderer.texture.LayeredColorMaskTexture;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.src.Config;
import net.minecraft.util.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomGuis;
import net.optifine.EmissiveTextures;
import net.optifine.RandomEntities;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextureManager
implements ITickable,
IResourceManagerReloadListener {
    private static final Logger logger = LogManager.getLogger();
    private final Map<ResourceLocation, ITextureObject> mapTextureObjects = Maps.newHashMap();
    private final List<ITickable> listTickables = Lists.newArrayList();
    private final Map<String, Integer> mapTextureCounters = Maps.newHashMap();
    private IResourceManager theResourceManager;
    private ITextureObject boundTexture;
    private ResourceLocation boundTextureLocation;

    public TextureManager(IResourceManager iResourceManager) {
        this.theResourceManager = iResourceManager;
    }

    public void bindTexture(ResourceLocation resourceLocation) {
        if (Config.isRandomEntities()) {
            resourceLocation = RandomEntities.getTextureLocation(resourceLocation);
        }
        if (Config.isCustomGuis()) {
            resourceLocation = CustomGuis.getTextureLocation(resourceLocation);
        }
        ITextureObject iTextureObject = this.mapTextureObjects.get(resourceLocation);
        if (EmissiveTextures.isActive()) {
            iTextureObject = EmissiveTextures.getEmissiveTexture(iTextureObject, this.mapTextureObjects);
        }
        if (iTextureObject == null) {
            iTextureObject = new SimpleTexture(resourceLocation);
            this.loadTexture(resourceLocation, iTextureObject);
        }
        if (Config.isShaders()) {
            ShadersTex.bindTexture(iTextureObject);
        } else {
            TextureUtil.bindTexture(iTextureObject.getGlTextureId());
        }
        this.boundTexture = iTextureObject;
        this.boundTextureLocation = resourceLocation;
    }

    public boolean loadTickableTexture(ResourceLocation resourceLocation, ITickableTextureObject iTickableTextureObject) {
        if (this.loadTexture(resourceLocation, iTickableTextureObject)) {
            this.listTickables.add(iTickableTextureObject);
            return true;
        }
        return false;
    }

    public boolean loadTexture(ResourceLocation resourceLocation, ITextureObject iTextureObject) {
        boolean bl = true;
        try {
            iTextureObject.loadTexture(this.theResourceManager);
        }
        catch (IOException iOException) {
            logger.warn("Failed to load texture: " + String.valueOf(resourceLocation), (Throwable)iOException);
            iTextureObject = TextureUtil.missingTexture;
            this.mapTextureObjects.put(resourceLocation, iTextureObject);
            bl = false;
        }
        catch (Throwable throwable) {
            final ITextureObject iTextureObject2 = iTextureObject;
            CrashReport crashReport = CrashReport.makeCrashReport(throwable, "Registering texture");
            CrashReportCategory crashReportCategory = crashReport.makeCategory("Resource location being registered");
            crashReportCategory.addCrashSection("Resource location", resourceLocation);
            crashReportCategory.addCrashSectionCallable("Texture object class", new Callable<String>(){

                @Override
                public String call() throws Exception {
                    return iTextureObject2.getClass().getName();
                }
            });
            throw new ReportedException(crashReport);
        }
        this.mapTextureObjects.put(resourceLocation, iTextureObject);
        return bl;
    }

    public ITextureObject getTexture(ResourceLocation resourceLocation) {
        return this.mapTextureObjects.get(resourceLocation);
    }

    public ResourceLocation getDynamicTextureLocation(String string, DynamicTexture dynamicTexture) {
        Integer n;
        if (string.equals("logo")) {
            dynamicTexture = Config.getMojangLogoTexture(dynamicTexture);
        }
        n = (n = this.mapTextureCounters.get(string)) == null ? Integer.valueOf(1) : Integer.valueOf(n + 1);
        this.mapTextureCounters.put(string, n);
        ResourceLocation resourceLocation = new ResourceLocation(String.format("dynamic/%s_%d", string, n));
        this.loadTexture(resourceLocation, dynamicTexture);
        return resourceLocation;
    }

    @Override
    public void tick() {
        for (ITickable iTickable : this.listTickables) {
            iTickable.tick();
        }
    }

    public void deleteTexture(ResourceLocation resourceLocation) {
        ITextureObject iTextureObject = this.getTexture(resourceLocation);
        if (iTextureObject != null) {
            this.mapTextureObjects.remove(resourceLocation);
            TextureUtil.deleteTexture(iTextureObject.getGlTextureId());
        }
    }

    @Override
    public void onResourceManagerReload(IResourceManager iResourceManager) {
        Object object;
        Config.dbg("*** Reloading textures ***");
        Config.log("Resource packs: " + Config.getResourcePackNames());
        Iterator<ResourceLocation> iterator2 = this.mapTextureObjects.keySet().iterator();
        while (iterator2.hasNext()) {
            ResourceLocation resourceLocation = iterator2.next();
            String string = resourceLocation.getResourcePath();
            if (!string.startsWith("mcpatcher/") && !string.startsWith("optifine/") && !EmissiveTextures.isEmissive(resourceLocation)) continue;
            object = this.mapTextureObjects.get(resourceLocation);
            if (object instanceof AbstractTexture) {
                AbstractTexture abstractTexture = (AbstractTexture)object;
                abstractTexture.deleteGlTexture();
            }
            iterator2.remove();
        }
        EmissiveTextures.update();
        for (Object e : new HashSet<Map.Entry<ResourceLocation, ITextureObject>>(this.mapTextureObjects.entrySet())) {
            object = (Map.Entry)e;
            this.loadTexture((ResourceLocation)object.getKey(), (ITextureObject)object.getValue());
        }
    }

    public void reloadBannerTextures() {
        Iterator<Map.Entry<ResourceLocation, ITextureObject>> iterator2 = new HashSet<Map.Entry<ResourceLocation, ITextureObject>>(this.mapTextureObjects.entrySet()).iterator();
        while (iterator2.hasNext()) {
            Map.Entry<ResourceLocation, ITextureObject> entry;
            Map.Entry<ResourceLocation, ITextureObject> entry2 = entry = iterator2.next();
            ResourceLocation resourceLocation = entry2.getKey();
            ITextureObject iTextureObject = entry2.getValue();
            if (!(iTextureObject instanceof LayeredColorMaskTexture)) continue;
            this.loadTexture(resourceLocation, iTextureObject);
        }
    }

    public ITextureObject getBoundTexture() {
        return this.boundTexture;
    }

    public ResourceLocation getBoundTextureLocation() {
        return this.boundTextureLocation;
    }
}

