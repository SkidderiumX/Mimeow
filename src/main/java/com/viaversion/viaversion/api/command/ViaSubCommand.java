/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.command;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.util.ChatColorUtil;
import java.util.Collections;
import java.util.List;

public interface ViaSubCommand {
    public String name();

    public String description();

    default public String usage() {
        return this.name();
    }

    default public String permission() {
        return "viaversion.admin." + this.name();
    }

    public boolean execute(ViaCommandSender var1, String[] var2);

    default public List<String> onTabComplete(ViaCommandSender viaCommandSender, String[] stringArray) {
        return Collections.emptyList();
    }

    public static String color(String string) {
        return ChatColorUtil.translateAlternateColorCodes(string);
    }

    default public void sendMessage(ViaCommandSender viaCommandSender, String string, Object ... objectArray) {
        viaCommandSender.sendMessage(ViaSubCommand.color(objectArray == null ? string : String.format(string, objectArray)));
    }
}

