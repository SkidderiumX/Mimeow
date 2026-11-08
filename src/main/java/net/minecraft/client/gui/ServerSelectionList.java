/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.gui;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.ServerListEntryLanDetected;
import net.minecraft.client.gui.ServerListEntryLanScan;
import net.minecraft.client.gui.ServerListEntryNormal;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;

public class ServerSelectionList
extends GuiListExtended {
    private final GuiMultiplayer owner;
    private final List<ServerListEntryNormal> serverListInternet = Lists.newArrayList();
    private final List<ServerListEntryLanDetected> serverListLan = Lists.newArrayList();
    private final GuiListExtended.IGuiListEntry lanScanEntry = new ServerListEntryLanScan();
    private int selectedSlotIndex = -1;

    public ServerSelectionList(GuiMultiplayer guiMultiplayer, Minecraft minecraft, int n, int n2, int n3, int n4, int n5) {
        super(minecraft, n, n2, n3, n4, n5);
        this.owner = guiMultiplayer;
    }

    @Override
    public GuiListExtended.IGuiListEntry getListEntry(int n) {
        if (n < this.serverListInternet.size()) {
            return this.serverListInternet.get(n);
        }
        if ((n -= this.serverListInternet.size()) == 0) {
            return this.lanScanEntry;
        }
        return this.serverListLan.get(--n);
    }

    @Override
    protected int getSize() {
        return this.serverListInternet.size() + 1 + this.serverListLan.size();
    }

    public void setSelectedSlotIndex(int n) {
        this.selectedSlotIndex = n;
    }

    @Override
    protected boolean isSelected(int n) {
        return n == this.selectedSlotIndex;
    }

    public int func_148193_k() {
        return this.selectedSlotIndex;
    }

    public void func_148195_a(ServerList serverList) {
        this.serverListInternet.clear();
        for (int i = 0; i < serverList.countServers(); ++i) {
            this.serverListInternet.add(new ServerListEntryNormal(this.owner, serverList.getServerData(i)));
        }
    }

    public void func_148194_a(List<LanServerDetector.LanServer> list) {
        this.serverListLan.clear();
        for (LanServerDetector.LanServer lanServer : list) {
            this.serverListLan.add(new ServerListEntryLanDetected(this.owner, lanServer));
        }
    }

    @Override
    protected int getScrollBarX() {
        return super.getScrollBarX() + 30;
    }

    @Override
    public int getListWidth() {
        return super.getListWidth() + 85;
    }
}

