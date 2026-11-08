/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.MinecraftException;
import net.minecraft.world.WorldServer;

public class CommandSaveAll
extends CommandBase {
    @Override
    public String getCommandName() {
        return "save-all";
    }

    @Override
    public String getCommandUsage(ICommandSender iCommandSender) {
        return "commands.save.usage";
    }

    @Override
    public void processCommand(ICommandSender iCommandSender, String[] stringArray) throws CommandException {
        MinecraftServer minecraftServer = MinecraftServer.getServer();
        iCommandSender.addChatMessage(new ChatComponentTranslation("commands.save.start", new Object[0]));
        if (minecraftServer.getConfigurationManager() != null) {
            minecraftServer.getConfigurationManager().saveAllPlayerData();
        }
        try {
            boolean bl;
            WorldServer worldServer;
            int n;
            for (n = 0; n < minecraftServer.worldServers.length; ++n) {
                if (minecraftServer.worldServers[n] == null) continue;
                worldServer = minecraftServer.worldServers[n];
                bl = worldServer.disableLevelSaving;
                worldServer.disableLevelSaving = false;
                worldServer.saveAllChunks(true, null);
                worldServer.disableLevelSaving = bl;
            }
            if (stringArray.length > 0 && "flush".equals(stringArray[0])) {
                iCommandSender.addChatMessage(new ChatComponentTranslation("commands.save.flushStart", new Object[0]));
                for (n = 0; n < minecraftServer.worldServers.length; ++n) {
                    if (minecraftServer.worldServers[n] == null) continue;
                    worldServer = minecraftServer.worldServers[n];
                    bl = worldServer.disableLevelSaving;
                    worldServer.disableLevelSaving = false;
                    worldServer.saveChunkData();
                    worldServer.disableLevelSaving = bl;
                }
                iCommandSender.addChatMessage(new ChatComponentTranslation("commands.save.flushEnd", new Object[0]));
            }
        }
        catch (MinecraftException minecraftException) {
            CommandSaveAll.notifyOperators(iCommandSender, (ICommand)this, "commands.save.failed", minecraftException.getMessage());
            return;
        }
        CommandSaveAll.notifyOperators(iCommandSender, (ICommand)this, "commands.save.success", new Object[0]);
    }
}

