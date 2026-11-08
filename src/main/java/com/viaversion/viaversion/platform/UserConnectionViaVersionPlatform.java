/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.platform;

import com.viaversion.viaversion.UserConnectionViaAPI;
import com.viaversion.viaversion.api.ViaAPI;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.ViaPlatform;
import com.viaversion.viaversion.configuration.AbstractViaConfig;
import java.io.File;
import java.util.logging.Logger;

public abstract class UserConnectionViaVersionPlatform
implements ViaPlatform<UserConnection> {
    private final UserConnectionViaAPI api = new UserConnectionViaAPI();
    private final AbstractViaConfig config;
    private final File dataFolder;
    private final Logger logger;

    protected UserConnectionViaVersionPlatform(File file) {
        this.dataFolder = file;
        this.logger = this.createLogger("ViaVersion");
        this.config = this.createConfig();
    }

    protected AbstractViaConfig createConfig() {
        return new AbstractViaConfig(new File(this.getDataFolder(), "viaversion.yml"), this.getLogger());
    }

    @Override
    public abstract Logger createLogger(String var1);

    @Override
    public boolean isProxy() {
        return true;
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public ViaAPI<UserConnection> getApi() {
        return this.api;
    }

    @Override
    public ViaVersionConfig getConf() {
        return this.config;
    }

    @Override
    public File getDataFolder() {
        return this.dataFolder;
    }
}

