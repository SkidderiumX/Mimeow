/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.commands.defaultsubs;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.command.ViaSubCommand;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ListSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "list";
    }

    @Override
    public String description() {
        return "Shows lists of the versions from logged in players.";
    }

    @Override
    public String usage() {
        return "list";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        TreeMap<ProtocolVersion, Set> treeMap = new TreeMap<ProtocolVersion, Set>(ProtocolVersion::compareTo);
        for (UserConnection object : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolVersion protocolVersion2 = object.getProtocolInfo().protocolVersion();
            treeMap.computeIfAbsent(protocolVersion2, protocolVersion -> new HashSet()).add(object.getProtocolInfo().getUsername());
        }
        if (treeMap.isEmpty()) {
            this.sendMessage(viaCommandSender, "&cNo players found!", new Object[0]);
            return true;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            this.sendMessage(viaCommandSender, "&8[&6%s&8] (&7%d&8): &b%s", ((ProtocolVersion)entry.getKey()).getName(), ((Set)entry.getValue()).size(), entry.getValue());
        }
        treeMap.clear();
        return true;
    }
}

