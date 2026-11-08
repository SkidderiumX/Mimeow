/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import io.netty.util.ResourceLeakDetector;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisplayLeaksSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "displayleaks";
    }

    @Override
    public String description() {
        return "Try to hunt memory leaks!";
    }

    @Override
    public String usage() {
        return "displayleaks [level]";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            try {
                ResourceLeakDetector.Level level = ResourceLeakDetector.Level.valueOf(stringArray[0]);
                ResourceLeakDetector.setLevel(level);
                this.sendMessage(viaCommandSender, "&6Set leak detector level to &2" + String.valueOf((Object)level), new Object[0]);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                this.sendMessage(viaCommandSender, "&cInvalid level (" + Arrays.toString((Object[])ResourceLeakDetector.Level.values()) + ")", new Object[0]);
            }
        } else {
            this.sendMessage(viaCommandSender, "&6Current leak detection level is &2" + String.valueOf((Object)ResourceLeakDetector.getLevel()), new Object[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(ViaCommandSender viaCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            return Arrays.stream(ResourceLeakDetector.Level.values()).map(Enum::name).filter(string -> string.startsWith(stringArray[0])).collect(Collectors.toList());
        }
        return ViaSubCommand.super.onTabComplete(viaCommandSender, stringArray);
    }
}

