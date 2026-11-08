/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.configuration.ViaVersionConfig;

public class DontBugMeSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "dontbugme";
    }

    @Override
    public String description() {
        return "Toggle checking for updates.";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        ViaVersionConfig viaVersionConfig = Via.getConfig();
        boolean bl = !viaVersionConfig.isCheckForUpdates();
        viaVersionConfig.setCheckForUpdates(bl);
        viaVersionConfig.save();
        this.sendMessage(viaCommandSender, "&6We will %snotify &6you about updates.", bl ? "&a" : "&cnot ");
        return true;
    }
}

