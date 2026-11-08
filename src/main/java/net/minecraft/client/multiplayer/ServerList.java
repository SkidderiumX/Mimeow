/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerList {
    private static final Logger logger = LogManager.getLogger();
    private final Minecraft mc;
    private final List<ServerData> servers = Lists.newArrayList();

    public ServerList(Minecraft minecraft) {
        this.mc = minecraft;
        this.loadServerList();
    }

    public void loadServerList() {
        try {
            this.servers.clear();
            NBTTagCompound nBTTagCompound = CompressedStreamTools.read(new File(this.mc.mcDataDir, "servers.dat"));
            if (nBTTagCompound == null) {
                return;
            }
            NBTTagList nBTTagList = nBTTagCompound.getTagList("servers", 10);
            for (int i = 0; i < nBTTagList.tagCount(); ++i) {
                this.servers.add(ServerData.getServerDataFromNBTCompound(nBTTagList.getCompoundTagAt(i)));
            }
        }
        catch (Exception exception) {
            logger.error("Couldn't load server list", (Throwable)exception);
        }
    }

    public void saveServerList() {
        try {
            NBTTagList nBTTagList = new NBTTagList();
            for (ServerData serverData : this.servers) {
                nBTTagList.appendTag(serverData.getNBTCompound());
            }
            NBTTagCompound nBTTagCompound = new NBTTagCompound();
            nBTTagCompound.setTag("servers", nBTTagList);
            CompressedStreamTools.safeWrite(nBTTagCompound, new File(this.mc.mcDataDir, "servers.dat"));
        }
        catch (Exception exception) {
            logger.error("Couldn't save server list", (Throwable)exception);
        }
    }

    public ServerData getServerData(int n) {
        return this.servers.get(n);
    }

    public void removeServerData(int n) {
        this.servers.remove(n);
    }

    public void addServerData(ServerData serverData) {
        this.servers.add(serverData);
    }

    public int countServers() {
        return this.servers.size();
    }

    public void swapServers(int n, int n2) {
        ServerData serverData = this.getServerData(n);
        this.servers.set(n, this.getServerData(n2));
        this.servers.set(n2, serverData);
        this.saveServerList();
    }

    public void func_147413_a(int n, ServerData serverData) {
        this.servers.set(n, serverData);
    }

    public static void func_147414_b(ServerData serverData) {
        ServerList serverList = new ServerList(Minecraft.getMinecraft());
        serverList.loadServerList();
        for (int i = 0; i < serverList.countServers(); ++i) {
            ServerData serverData2 = serverList.getServerData(i);
            if (!serverData2.serverName.equals(serverData.serverName) || !serverData2.serverIP.equals(serverData.serverIP)) continue;
            serverList.func_147413_a(i, serverData);
            break;
        }
        serverList.saveServerList();
    }
}

