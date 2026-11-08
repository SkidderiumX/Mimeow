/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.util.Config;

public class AutoTeamSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "autoteam";
    }

    @Override
    public String description() {
        return "Toggle automatically teaming to prevent colliding.";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        boolean bl = !Via.getConfig().isAutoTeam();
        Config config2 = (Config)((Object)Via.getConfig());
        config2.set("auto-team", bl);
        config2.save();
        this.sendMessage(viaCommandSender, "&6We will %s", bl ? "&aautomatically team players" : "&cno longer auto team players");
        this.sendMessage(viaCommandSender, "&6All players will need to re-login for the change to take place.", new Object[0]);
        return true;
    }
}

