/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiResourcePackAvailable;
import net.minecraft.client.gui.GuiResourcePackSelected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.ResourcePackListEntry;
import net.minecraft.client.resources.ResourcePackListEntryDefault;
import net.minecraft.client.resources.ResourcePackListEntryFound;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.Sys;

public class GuiScreenResourcePacks
extends GuiScreen {
    private static final Logger logger = LogManager.getLogger();
    private final GuiScreen parentScreen;
    private List<ResourcePackListEntry> availableResourcePacks;
    private List<ResourcePackListEntry> selectedResourcePacks;
    private GuiResourcePackAvailable availableResourcePacksList;
    private GuiResourcePackSelected selectedResourcePacksList;
    private boolean changed = false;
    private int updateTimer = -1;

    public GuiScreenResourcePacks(GuiScreen guiScreen) {
        this.parentScreen = guiScreen;
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiOptionButton(2, this.width / 2 - 154, this.height - 48, I18n.format("resourcePack.openFolder", new Object[0])));
        this.buttonList.add(new GuiOptionButton(1, this.width / 2 + 4, this.height - 48, I18n.format("gui.done", new Object[0])));
        if (!this.changed) {
            this.availableResourcePacks = Lists.newArrayList();
            this.selectedResourcePacks = Lists.newArrayList();
            ResourcePackRepository resourcePackRepository = this.mc.getResourcePackRepository();
            resourcePackRepository.updateRepositoryEntriesAll();
            ArrayList<ResourcePackRepository.Entry> arrayList = Lists.newArrayList(resourcePackRepository.getRepositoryEntriesAll());
            arrayList.removeAll(resourcePackRepository.getRepositoryEntries());
            for (ResourcePackRepository.Entry entry : arrayList) {
                this.availableResourcePacks.add(new ResourcePackListEntryFound(this, entry));
            }
            for (ResourcePackRepository.Entry entry : Lists.reverse(resourcePackRepository.getRepositoryEntries())) {
                this.selectedResourcePacks.add(new ResourcePackListEntryFound(this, entry));
            }
            this.selectedResourcePacks.add(new ResourcePackListEntryDefault(this));
        }
        this.availableResourcePacksList = new GuiResourcePackAvailable(this.mc, 200, this.height, this.availableResourcePacks);
        this.availableResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 - 4 - 200);
        this.availableResourcePacksList.registerScrollButtons(7, 8);
        this.selectedResourcePacksList = new GuiResourcePackSelected(this.mc, 200, this.height, this.selectedResourcePacks);
        this.selectedResourcePacksList.setSlotXBoundsFromLeft(this.width / 2 + 4);
        this.selectedResourcePacksList.registerScrollButtons(7, 8);
        this.updateTimer = 20;
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        this.selectedResourcePacksList.handleMouseInput();
        this.availableResourcePacksList.handleMouseInput();
    }

    public boolean hasResourcePackEntry(ResourcePackListEntry resourcePackListEntry) {
        return this.selectedResourcePacks.contains(resourcePackListEntry);
    }

    public List<ResourcePackListEntry> getListContaining(ResourcePackListEntry resourcePackListEntry) {
        return this.hasResourcePackEntry(resourcePackListEntry) ? this.selectedResourcePacks : this.availableResourcePacks;
    }

    public List<ResourcePackListEntry> getAvailableResourcePacks() {
        return this.availableResourcePacks;
    }

    public List<ResourcePackListEntry> getSelectedResourcePacks() {
        return this.selectedResourcePacks;
    }

    @Override
    protected void actionPerformed(GuiButton guiButton) throws IOException {
        if (guiButton.enabled) {
            if (guiButton.id == 2) {
                boolean bl;
                this.updateTimer = 0;
                File file = this.mc.getResourcePackRepository().getDirResourcepacks();
                String string = file.getAbsolutePath();
                if (Util.getOSType() == Util.EnumOS.OSX) {
                    try {
                        logger.info(string);
                        Runtime.getRuntime().exec(new String[]{"/usr/bin/open", string});
                        return;
                    }
                    catch (IOException iOException) {
                        logger.error("Couldn't open file", (Throwable)iOException);
                    }
                } else if (Util.getOSType() == Util.EnumOS.WINDOWS) {
                    String string2 = String.format("cmd.exe /C start \"Open file\" \"%s\"", string);
                    try {
                        Runtime.getRuntime().exec(string2);
                        return;
                    }
                    catch (IOException iOException) {
                        logger.error("Couldn't open file", (Throwable)iOException);
                    }
                }
                boolean object = false;
                try {
                    Class<?> clazz = Class.forName("java.awt.Desktop");
                    Object object2 = clazz.getMethod("getDesktop", new Class[0]).invoke(null, new Object[0]);
                    clazz.getMethod("browse", URI.class).invoke(object2, file.toURI());
                }
                catch (Throwable throwable) {
                    logger.error("Couldn't open link", throwable);
                    bl = true;
                }
                if (bl) {
                    logger.info("Opening via system class!");
                    Sys.openURL("file://" + string);
                }
            } else if (guiButton.id == 1) {
                if (this.changed) {
                    ArrayList<ResourcePackRepository.Entry> arrayList = Lists.newArrayList();
                    for (ResourcePackListEntry resourcePackListEntry : this.selectedResourcePacks) {
                        if (!(resourcePackListEntry instanceof ResourcePackListEntryFound)) continue;
                        arrayList.add(((ResourcePackListEntryFound)resourcePackListEntry).func_148318_i());
                    }
                    Collections.reverse(arrayList);
                    this.mc.getResourcePackRepository().setRepositories(arrayList);
                    this.mc.gameSettings.resourcePacks.clear();
                    this.mc.gameSettings.incompatibleResourcePacks.clear();
                    for (ResourcePackRepository.Entry entry : arrayList) {
                        this.mc.gameSettings.resourcePacks.add(entry.getResourcePackName());
                        if (entry.func_183027_f() == 1) continue;
                        this.mc.gameSettings.incompatibleResourcePacks.add(entry.getResourcePackName());
                    }
                    this.mc.gameSettings.saveOptions();
                    this.mc.refreshResources();
                }
                this.mc.displayGuiScreen(this.parentScreen);
            }
        }
    }

    @Override
    protected void mouseClicked(int n, int n2, int n3) throws IOException {
        super.mouseClicked(n, n2, n3);
        this.availableResourcePacksList.mouseClicked(n, n2, n3);
        this.selectedResourcePacksList.mouseClicked(n, n2, n3);
    }

    @Override
    protected void mouseReleased(int n, int n2, int n3) {
        super.mouseReleased(n, n2, n3);
    }

    @Override
    public void updateScreen() {
        super.updateScreen();
        --this.updateTimer;
    }

    @Override
    public void drawScreen(int n, int n2, float f) {
        this.drawBackground(0);
        if (this.updateTimer <= 0) {
            this.updateResourcePacks();
            this.updateTimer += 20;
        }
        this.availableResourcePacksList.drawScreen(n, n2, f);
        this.selectedResourcePacksList.drawScreen(n, n2, f);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.title", new Object[0]), this.width / 2, 16, 0xFFFFFF);
        this.drawCenteredString(this.fontRendererObj, I18n.format("resourcePack.folderInfo", new Object[0]), this.width / 2 - 77, this.height - 26, 0x808080);
        super.drawScreen(n, n2, f);
    }

    public void updateResourcePacks() {
        Object object;
        Object object2;
        if (this.mc == null) {
            return;
        }
        ResourcePackRepository resourcePackRepository = this.mc.getResourcePackRepository();
        if (resourcePackRepository == null || this.availableResourcePacks == null || this.selectedResourcePacks == null) {
            return;
        }
        resourcePackRepository.updateRepositoryEntriesAll();
        ArrayList<ResourcePackRepository.Entry> arrayList = Lists.newArrayList(resourcePackRepository.getRepositoryEntriesAll());
        ArrayList<Object> arrayList2 = Lists.newArrayList();
        boolean bl = false;
        Iterator<ResourcePackListEntry> iterator2 = this.selectedResourcePacks.iterator();
        while (iterator2.hasNext()) {
            object2 = iterator2.next();
            if (!(object2 instanceof ResourcePackListEntryFound)) continue;
            object = ((ResourcePackListEntryFound)object2).func_148318_i();
            if (!arrayList.contains(object)) {
                iterator2.remove();
                bl = true;
                continue;
            }
            arrayList2.add(object);
        }
        if (bl) {
            this.markChanged();
        }
        object2 = Lists.newArrayList(arrayList);
        object2.removeAll(arrayList2);
        object = Lists.newArrayList();
        for (ResourcePackListEntry object3 : this.availableResourcePacks) {
            if (!(object3 instanceof ResourcePackListEntryFound)) continue;
            object.add(((ResourcePackListEntryFound)object3).func_148318_i());
        }
        if (!object.equals(object2)) {
            HashMap hashMap = Maps.newHashMap();
            for (ResourcePackListEntry resourcePackListEntry : this.availableResourcePacks) {
                if (!(resourcePackListEntry instanceof ResourcePackListEntryFound)) continue;
                hashMap.put(((ResourcePackListEntryFound)resourcePackListEntry).func_148318_i(), (ResourcePackListEntryFound)resourcePackListEntry);
            }
            this.availableResourcePacks.clear();
            Iterator iterator3 = object2.iterator();
            while (iterator3.hasNext()) {
                ResourcePackRepository.Entry entry = (ResourcePackRepository.Entry)iterator3.next();
                ResourcePackListEntryFound resourcePackListEntryFound = (ResourcePackListEntryFound)hashMap.get(entry);
                if (resourcePackListEntryFound == null) {
                    resourcePackListEntryFound = new ResourcePackListEntryFound(this, entry);
                }
                this.availableResourcePacks.add(resourcePackListEntryFound);
            }
        }
    }

    public void markChanged() {
        this.changed = true;
    }
}

