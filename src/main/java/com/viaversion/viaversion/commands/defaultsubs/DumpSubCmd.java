/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.util.DumpUtil;

public class DumpSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "dump";
    }

    @Override
    public String description() {
        return "Dump information about your platform implementation, this is helpful if you report bugs.";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        DumpUtil.postDump(viaCommandSender.getUUID()).whenComplete((string, throwable) -> {
            if (throwable != null) {
                viaCommandSender.sendMessage("\u00a74" + throwable.getMessage());
                return;
            }
            viaCommandSender.sendMessage("\u00a72We've made a dump with useful information, report your issue and provide this url: " + string);
        });
        return true;
    }
}

