/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldSettings;

public class CommandPublishLocalServer
extends CommandBase {
    @Override
    public String getCommandName() {
        return "publish";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.publish.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        String string = MinecraftServer.getServer().shareToLAN(WorldSettings.GameType.SURVIVAL, false);
        if (string != null) {
            CommandPublishLocalServer.notifyOperators(iCommandSender, (ICommand)this, "commands.publish.started", string);
        } else {
            CommandPublishLocalServer.notifyOperators(iCommandSender, (ICommand)this, "commands.publish.failed", new Object[0]);
        }
    }
}

