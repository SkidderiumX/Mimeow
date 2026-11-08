/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.resources;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.awt.image.BufferedImage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenWorking;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.FileResourcePack;
import net.minecraft.client.resources.FolderResourcePack;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.HttpUtil;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResourcePackRepository {
    private static final Logger logger = LogManager.getLogger();
    private static final FileFilter resourcePackFilter = new FileFilter(){

        @Override
        public boolean accept(File file) {
            boolean bl = file.isFile() && file.getName().endsWith(".zip");
            boolean bl2 = file.isDirectory() && new File(file, "pack.mcmeta").isFile();
            return bl || bl2;
        }
    };
    private final File dirResourcepacks;
    public final IResourcePack rprDefaultResourcePack;
    private final File dirServerResourcepacks;
    public final IMetadataSerializer rprMetadataSerializer;
    private IResourcePack resourcePackInstance;
    private final ReentrantLock lock = new ReentrantLock();
    private ListenableFuture<Object> downloadingPacks;
    private List<Entry> repositoryEntriesAll = Lists.newArrayList();
    public List<Entry> repositoryEntries = Lists.newArrayList();

    public ResourcePackRepository(File file, File file2, IResourcePack iResourcePack, IMetadataSerializer iMetadataSerializer, GameSettings gameSettings) {
        this.dirResourcepacks = file;
        this.dirServerResourcepacks = file2;
        this.rprDefaultResourcePack = iResourcePack;
        this.rprMetadataSerializer = iMetadataSerializer;
        this.fixDirResourcepacks();
        this.updateRepositoryEntriesAll();
        Iterator<String> iterator2 = gameSettings.resourcePacks.iterator();
        block0: while (iterator2.hasNext()) {
            String string = iterator2.next();
            for (Entry entry : this.repositoryEntriesAll) {
                if (!entry.getResourcePackName().equals(string)) continue;
                if (entry.func_183027_f() == 1 || gameSettings.incompatibleResourcePacks.contains(entry.getResourcePackName())) {
                    this.repositoryEntries.add(entry);
                    continue block0;
                }
                iterator2.remove();
                logger.warn("Removed selected resource pack {} because it's no longer compatible", entry.getResourcePackName());
            }
        }
    }

    private void fixDirResourcepacks() {
        if (this.dirResourcepacks.exists()) {
            if (!(this.dirResourcepacks.isDirectory() || this.dirResourcepacks.delete() && this.dirResourcepacks.mkdirs())) {
                logger.warn("Unable to recreate resourcepack folder, it exists but is not a directory: " + String.valueOf(this.dirResourcepacks));
            }
        } else if (!this.dirResourcepacks.mkdirs()) {
            logger.warn("Unable to create resourcepack folder: " + String.valueOf(this.dirResourcepacks));
        }
    }

    private List<File> getResourcePackFiles() {
        return this.dirResourcepacks.isDirectory() ? Arrays.asList(this.dirResourcepacks.listFiles(resourcePackFilter)) : Collections.emptyList();
    }

    public void updateRepositoryEntriesAll() {
        ArrayList<Entry> arrayList = Lists.newArrayList();
        for (File object : this.getResourcePackFiles()) {
            Entry entry = new Entry(object);
            if (!this.repositoryEntriesAll.contains(entry)) {
                try {
                    entry.updateResourcePack();
                    arrayList.add(entry);
                }
                catch (Exception exception) {
                    arrayList.remove(entry);
                }
                continue;
            }
            int n = this.repositoryEntriesAll.indexOf(entry);
            if (n <= -1 || n >= this.repositoryEntriesAll.size()) continue;
            arrayList.add(this.repositoryEntriesAll.get(n));
        }
        this.repositoryEntriesAll.removeAll(arrayList);
        for (Entry entry : this.repositoryEntriesAll) {
            entry.closeResourcePack();
        }
        this.repositoryEntriesAll = arrayList;
    }

    public List<Entry> getRepositoryEntriesAll() {
        return ImmutableList.copyOf(this.repositoryEntriesAll);
    }

    public List<Entry> getRepositoryEntries() {
        return ImmutableList.copyOf(this.repositoryEntries);
    }

    public void setRepositories(List<Entry> list) {
        this.repositoryEntries.clear();
        this.repositoryEntries.addAll(list);
    }

    public File getDirResourcepacks() {
        return this.dirResourcepacks;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ListenableFuture<Object> downloadResourcePack(String string, String string2) {
        String string3 = string2.matches("^[a-f0-9]{40}$") ? string2 : "legacy";
        final File file = new File(this.dirServerResourcepacks, string3);
        this.lock.lock();
        try {
            ListenableFuture<Object> listenableFuture;
            ListenableFuture<Object> listenableFuture2;
            Object object;
            this.clearResourcePack();
            if (file.exists() && string2.length() == 40) {
                block8: {
                    ListenableFuture<Object> listenableFuture3;
                    ListenableFuture<Object> listenableFuture4;
                    object = Hashing.sha1().hashBytes(Files.toByteArray(file)).toString();
                    if (!((String)object).equals(string2)) break block8;
                    ListenableFuture<Object> listenableFuture5 = listenableFuture4 = (listenableFuture3 = this.setResourcePackInstance(file));
                    return listenableFuture5;
                }
                try {
                    logger.warn("File " + String.valueOf(file) + " had wrong hash (expected " + string2 + ", found " + (String)object + "). Deleting it.");
                    FileUtils.deleteQuietly(file);
                }
                catch (IOException iOException) {
                    logger.warn("File " + String.valueOf(file) + " couldn't be hashed. Deleting it.", (Throwable)iOException);
                    FileUtils.deleteQuietly(file);
                }
            }
            this.deleteOldServerResourcesPacks();
            object = new GuiScreenWorking();
            Map<String, String> map = Minecraft.getSessionInfo();
            final Minecraft minecraft = Minecraft.getMinecraft();
            Futures.getUnchecked(minecraft.addScheduledTask(new Runnable(){
                final /* synthetic */ GuiScreenWorking val$guiscreenworking;
                {
                    this.val$guiscreenworking = guiScreenWorking;
                }

                @Override
                public void run() {
                    minecraft.displayGuiScreen(this.val$guiscreenworking);
                }
            }));
            final SettableFuture settableFuture = SettableFuture.create();
            this.downloadingPacks = HttpUtil.downloadResourcePack(file, string, map, 0x3200000, (IProgressUpdate)object, minecraft.getProxy());
            Futures.addCallback(this.downloadingPacks, new FutureCallback<Object>(){

                @Override
                public void onSuccess(Object object) {
                    ResourcePackRepository.this.setResourcePackInstance(file);
                    settableFuture.set(null);
                }

                @Override
                public void onFailure(Throwable throwable) {
                    settableFuture.setException(throwable);
                }
            });
            ListenableFuture<Object> listenableFuture6 = listenableFuture2 = (listenableFuture = this.downloadingPacks);
            return listenableFuture6;
        }
        finally {
            this.lock.unlock();
        }
    }

    private void deleteOldServerResourcesPacks() {
        ArrayList<File> arrayList = Lists.newArrayList(FileUtils.listFiles(this.dirServerResourcepacks, TrueFileFilter.TRUE, null));
        Collections.sort(arrayList, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
        int n = 0;
        for (File file : arrayList) {
            if (n++ < 10) continue;
            logger.info("Deleting old server resource pack " + file.getName());
            FileUtils.deleteQuietly(file);
        }
    }

    public ListenableFuture<Object> setResourcePackInstance(File file) {
        this.resourcePackInstance = new FileResourcePack(file);
        return Minecraft.getMinecraft().scheduleResourcesRefresh();
    }

    public IResourcePack getResourcePackInstance() {
        return this.resourcePackInstance;
    }

    public void clearResourcePack() {
        this.lock.lock();
        try {
            if (this.downloadingPacks != null) {
                this.downloadingPacks.cancel(true);
            }
            this.downloadingPacks = null;
            if (this.resourcePackInstance != null) {
                this.resourcePackInstance = null;
                Minecraft.getMinecraft().scheduleResourcesRefresh();
            }
        }
        finally {
            this.lock.unlock();
        }
    }

    public class Entry {
        private final File resourcePackFile;
        private IResourcePack reResourcePack;
        private PackMetadataSection rePackMetadataSection;
        private BufferedImage texturePackIcon;
        private ResourceLocation locationTexturePackIcon;

        private Entry(File file) {
            this.resourcePackFile = file;
        }

        public void updateResourcePack() throws IOException {
            this.reResourcePack = this.resourcePackFile.isDirectory() ? new FolderResourcePack(this.resourcePackFile) : new FileResourcePack(this.resourcePackFile);
            this.rePackMetadataSection = (PackMetadataSection)this.reResourcePack.getPackMetadata(ResourcePackRepository.this.rprMetadataSerializer, "pack");
            try {
                this.texturePackIcon = this.reResourcePack.getPackImage();
            }
            catch (IOException iOException) {
                // empty catch block
            }
            if (this.texturePackIcon == null) {
                this.texturePackIcon = ResourcePackRepository.this.rprDefaultResourcePack.getPackImage();
            }
            if (this.texturePackIcon == null) {
                this.texturePackIcon = new BufferedImage(16, 16, 2);
            }
            this.closeResourcePack();
        }

        public void bindTexturePackIcon(TextureManager textureManager) {
            if (this.locationTexturePackIcon == null) {
                if (this.texturePackIcon == null) {
                    this.texturePackIcon = new BufferedImage(16, 16, 2);
                }
                this.locationTexturePackIcon = textureManager.getDynamicTextureLocation("texturepackicon", new DynamicTexture(this.texturePackIcon));
            }
            textureManager.bindTexture(this.locationTexturePackIcon);
        }

        public void closeResourcePack() {
            if (this.reResourcePack instanceof Closeable) {
                IOUtils.closeQuietly((Closeable)((Object)this.reResourcePack));
            }
        }

        public IResourcePack getResourcePack() {
            return this.reResourcePack;
        }

        public String getResourcePackName() {
            return this.reResourcePack.getPackName();
        }

        public String getTexturePackDescription() {
            return this.rePackMetadataSection == null ? String.valueOf((Object)EnumChatFormatting.RED) + "Invalid pack.mcmeta (or missing 'pack' section)" : this.rePackMetadataSection.getPackDescription().getFormattedText();
        }

        public int func_183027_f() {
            return this.rePackMetadataSection.getPackFormat();
        }

        public boolean equals(Object object) {
            return this == object ? true : (object instanceof Entry ? this.toString().equals(object.toString()) : false);
        }

        public int hashCode() {
            return this.toString().hashCode();
        }

        public String toString() {
            return String.format("%s:%s:%d", this.resourcePackFile.getName(), this.resourcePackFile.isDirectory() ? "folder" : "zip", this.resourcePackFile.lastModified());
        }
    }
}

