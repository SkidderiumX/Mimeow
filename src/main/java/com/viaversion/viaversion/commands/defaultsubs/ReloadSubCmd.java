/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;

public class ReloadSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "reload";
    }

    @Override
    public String description() {
        return "Reload the config from the disk.";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        Via.getManager().getConfigurationProvider().reloadConfigs();
        this.sendMessage(viaCommandSender, "&6Configuration successfully reloaded! Some config options may require a restart to take effect.", new Object[0]);
        return true;
    }
}

