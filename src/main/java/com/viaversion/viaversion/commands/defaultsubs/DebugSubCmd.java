/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.debug.DebugHandler;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class DebugSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "debug";
    }

    @Override
    public String description() {
        return "Toggle various debug modes.";
    }

    @Override
    public String usage() {
        return "debug [clear|pre|post], or debug <add|remove> <packet>";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        DebugHandler debugHandler = Via.getManager().debugHandler();
        if (stringArray.length == 0) {
            Via.getManager().debugHandler().setEnabled(!Via.getManager().debugHandler().enabled());
            this.sendMessage(viaCommandSender, "&6Debug mode is now %s", Via.getManager().debugHandler().enabled() ? "&aenabled" : "&cdisabled");
            return true;
        }
        if (stringArray.length == 1) {
            if (stringArray[0].equalsIgnoreCase("clear")) {
                debugHandler.clearPacketTypesToLog();
                this.sendMessage(viaCommandSender, "&6Cleared packet types to log", new Object[0]);
                return true;
            }
            if (stringArray[0].equalsIgnoreCase("pre")) {
                debugHandler.setLogPrePacketTransform(!debugHandler.logPrePacketTransform());
                this.sendMessage(viaCommandSender, "&6Pre transform packet logging is now %s", debugHandler.logPrePacketTransform() ? "&aenabled" : "&cdisabled");
                return true;
            }
            if (stringArray[0].equalsIgnoreCase("post")) {
                debugHandler.setLogPostPacketTransform(!debugHandler.logPostPacketTransform());
                this.sendMessage(viaCommandSender, "&6Post transform packet logging is now %s", debugHandler.logPostPacketTransform() ? "&aenabled" : "&cdisabled");
                return true;
            }
        } else if (stringArray.length == 2) {
            if (stringArray[0].equalsIgnoreCase("add")) {
                debugHandler.addPacketTypeNameToLog(stringArray[1].toUpperCase(Locale.ROOT));
                this.sendMessage(viaCommandSender, "&6Added packet type %s to debug logging", stringArray[1]);
                return true;
            }
            if (stringArray[0].equalsIgnoreCase("remove")) {
                debugHandler.removePacketTypeNameToLog(stringArray[1].toUpperCase(Locale.ROOT));
                this.sendMessage(viaCommandSender, "&6Removed packet type %s from debug logging", stringArray[1]);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(ViaCommandSender viaCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return Arrays.asList("clear", "pre", "post", "add", "remove");
        }
        return Collections.emptyList();
    }
}

