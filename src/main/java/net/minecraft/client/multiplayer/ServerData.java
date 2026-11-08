/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.multiplayer;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class ServerData {
    public String serverName;
    public String serverIP;
    public String populationInfo;
    public String serverMOTD;
    public long pingToServer;
    public int version = 47;
    public String gameVersion = "1.8.9";
    public boolean field_78841_f;
    public String playerList;
    private ServerResourceMode resourceMode = ServerResourceMode.PROMPT;
    private String serverIcon;
    private boolean lanServer;

    public ServerData(String string, String string2, boolean bl) {
        this.serverName = string;
        this.serverIP = string2;
        this.lanServer = bl;
    }

    public NBTTagCompound getNBTCompound() {
        NBTTagCompound nBTTagCompound = new NBTTagCompound();
        nBTTagCompound.setString("name", this.serverName);
        nBTTagCompound.setString("ip", this.serverIP);
        if (this.serverIcon != null) {
            nBTTagCompound.setString("icon", this.serverIcon);
        }
        if (this.resourceMode == ServerResourceMode.ENABLED) {
            nBTTagCompound.setBoolean("acceptTextures", true);
        } else if (this.resourceMode == ServerResourceMode.DISABLED) {
            nBTTagCompound.setBoolean("acceptTextures", false);
        }
        return nBTTagCompound;
    }

    public ServerResourceMode getResourceMode() {
        return this.resourceMode;
    }

    public void setResourceMode(ServerResourceMode serverResourceMode) {
        this.resourceMode = serverResourceMode;
    }

    public static ServerData getServerDataFromNBTCompound(NBTTagCompound nBTTagCompound) {
        ServerData serverData = new ServerData(nBTTagCompound.getString("name"), nBTTagCompound.getString("ip"), false);
        if (nBTTagCompound.hasKey("icon", 8)) {
            serverData.setBase64EncodedIconData(nBTTagCompound.getString("icon"));
        }
        if (nBTTagCompound.hasKey("acceptTextures", 1)) {
            if (nBTTagCompound.getBoolean("acceptTextures")) {
                serverData.setResourceMode(ServerResourceMode.ENABLED);
            } else {
                serverData.setResourceMode(ServerResourceMode.DISABLED);
            }
        } else {
            serverData.setResourceMode(ServerResourceMode.PROMPT);
        }
        return serverData;
    }

    public String getBase64EncodedIconData() {
        return this.serverIcon;
    }

    public void setBase64EncodedIconData(String string) {
        this.serverIcon = string;
    }

    public boolean isOnLAN() {
        return this.lanServer;
    }

    public void copyFrom(ServerData serverData) {
        this.serverIP = serverData.serverIP;
        this.serverName = serverData.serverName;
        this.setResourceMode(serverData.getResourceMode());
        this.serverIcon = serverData.serverIcon;
        this.lanServer = serverData.lanServer;
    }

    public static enum ServerResourceMode {
        ENABLED("enabled"),
        DISABLED("disabled"),
        PROMPT("prompt");

        private final IChatComponent motd;

        private ServerResourceMode(String string2) {
            this.motd = new ChatComponentTranslation("addServer.resourcePack." + string2, new Object[0]);
        }

        public IChatComponent getMotd() {
            return this.motd;
        }
    }
}

