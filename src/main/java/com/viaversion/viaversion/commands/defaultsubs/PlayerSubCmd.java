/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import java.util.ArrayList;
import java.util.List;

public class PlayerSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "player";
    }

    @Override
    public String description() {
        return "Shows connection information about one or all players.";
    }

    @Override
    public String usage() {
        return "player <name|*>";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        if (stringArray.length == 0) {
            return false;
        }
        boolean bl = stringArray[0].equals("*");
        boolean bl2 = false;
        for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolInfo protocolInfo = userConnection.getProtocolInfo();
            if (!stringArray[0].equalsIgnoreCase(protocolInfo.getUsername()) && !bl) continue;
            this.sendMessage(viaCommandSender, "&7[&6" + protocolInfo.getUsername() + "&7] UUID: &2" + String.valueOf(protocolInfo.getUuid()) + " &7Client protocol: &2" + protocolInfo.protocolVersion().getName() + " &7Server protocol: &2" + protocolInfo.serverProtocolVersion().getName() + " &7Client: &2" + userConnection.isClientSide(), new Object[0]);
            bl2 = true;
        }
        if (!bl2) {
            this.sendMessage(viaCommandSender, (String)(bl ? "&cNo players found!" : "&cNo player found with the name: " + stringArray[0]), new Object[0]);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(ViaCommandSender viaCommandSender, String[] stringArray) {
        if (stringArray.length == 1) {
            String string = stringArray[0].toLowerCase();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (UserConnection userConnection : Via.getManager().getConnectionManager().getConnections()) {
                String string2 = userConnection.getProtocolInfo().getUsername();
                if (!string.isEmpty() && !string2.toLowerCase().startsWith(string)) continue;
                arrayList.add(string2);
            }
            arrayList.add("*");
            return arrayList;
        }
        return ViaSubCommand.super.onTabComplete(viaCommandSender, stringArray);
    }
}

