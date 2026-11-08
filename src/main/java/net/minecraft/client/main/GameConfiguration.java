/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.client.main;

import com.mojang.authlib.properties.PropertyMap;
import java.io.File;
import java.net.Proxy;
import net.minecraft.util.Session;

public class GameConfiguration {
    public final UserInformation userInfo;
    public final DisplayInformation displayInfo;
    public final FolderInformation folderInfo;
    public final GameInformation gameInfo;
    public final ServerInformation serverInfo;

    public GameConfiguration(UserInformation userInformation, DisplayInformation displayInformation, FolderInformation folderInformation, GameInformation gameInformation, ServerInformation serverInformation) {
        this.userInfo = userInformation;
        this.displayInfo = displayInformation;
        this.folderInfo = folderInformation;
        this.gameInfo = gameInformation;
        this.serverInfo = serverInformation;
    }

    public static class UserInformation {
        public final Session session;
        public final PropertyMap userProperties;
        public final PropertyMap profileProperties;
        public final Proxy proxy;

        public UserInformation(Session session, PropertyMap propertyMap, PropertyMap propertyMap2, Proxy proxy) {
            this.session = session;
            this.userProperties = propertyMap;
            this.profileProperties = propertyMap2;
            this.proxy = proxy;
        }
    }

    public static class DisplayInformation {
        public final int width;
        public final int height;
        public final boolean fullscreen;
        public final boolean checkGlErrors;

        public DisplayInformation(int n, int n2, boolean bl, boolean bl2) {
            this.width = n;
            this.height = n2;
            this.fullscreen = bl;
            this.checkGlErrors = bl2;
        }
    }

    public static class FolderInformation {
        public final File mcDataDir;
        public final File resourcePacksDir;
        public final File assetsDir;
        public final String assetIndex;

        public FolderInformation(File file, File file2, File file3, String string) {
            this.mcDataDir = file;
            this.resourcePacksDir = file2;
            this.assetsDir = file3;
            this.assetIndex = string;
        }
    }

    public static class GameInformation {
        public final boolean isDemo;
        public final String version;

        public GameInformation(boolean bl, String string) {
            this.isDemo = bl;
            this.version = string;
        }
    }

    public static class ServerInformation {
        public final String serverName;
        public final int serverPort;

        public ServerInformation(String string, int n) {
            this.serverName = string;
            this.serverPort = n;
        }
    }
}

