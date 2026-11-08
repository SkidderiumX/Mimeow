/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind;

import com.viaversion.viarewind.api.ViaRewindPlatform;
import com.viaversion.viaversion.api.Via;
import java.io.File;
import java.util.logging.Logger;

public class ViaRewindPlatformImpl
implements ViaRewindPlatform {
    private final Logger logger = Via.getPlatform().createLogger("ViaRewind");

    public ViaRewindPlatformImpl() {
        this.init(new File(this.getDataFolder(), "viarewind.yml"));
    }

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public File getDataFolder() {
        return Via.getPlatform().getDataFolder();
    }
}

