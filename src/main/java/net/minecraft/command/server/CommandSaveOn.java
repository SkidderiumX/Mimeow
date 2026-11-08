/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandSaveOn
extends CommandBase {
    @Override
    public String getCommandName() {
        return "save-on";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.save-on.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        boolean bl = false;
        for (int i = 0; i < minecraftServer.worldServers.length; ++i) {
            if (minecraftServer.worldServers[i] == null) continue;
            WorldServer worldServer = minecraftServer.worldServers[i];
            if (!worldServer.disableLevelSaving) continue;
            worldServer.disableLevelSaving = false;
            bl = true;
        }
        if (!bl) {
            throw new CommandException("commands.save-on.alreadyOn", new Object[0]);
        }
        CommandSaveOn.notifyOperators(iCommandSender, (ICommand)this, "commands.save.enabled", new Object[0]);
    }
}

