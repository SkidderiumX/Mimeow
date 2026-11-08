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

public class PPSSubCmd
implements ViaSubCommand {
    @Override
    public String name() {
        return "pps";
    }

    @Override
    public String description() {
        return "Shows the packets per second of online players.";
    }

    @Override
    public String usage() {
        return "pps";
    }

    @Override
    public boolean execute(ViaCommandSender viaCommandSender, String[] stringArray) {
        TreeMap treeMap = new TreeMap(ProtocolVersion::compareTo);
        int n = 0;
        int n2 = 0;
        long l = 0L;
        for (UserConnection object : Via.getManager().getConnectionManager().getConnections()) {
            ProtocolVersion protocolVersion = object.getProtocolInfo().protocolVersion();
            if (!treeMap.containsKey(protocolVersion)) {
                treeMap.put(protocolVersion, new HashSet());
            }
            if (object.getPacketTracker().getPacketsPerSecond() <= -1) continue;
            ((Set)treeMap.get(protocolVersion)).add(object.getProtocolInfo().getUsername() + " (" + object.getPacketTracker().getPacketsPerSecond() + " PPS)");
            n += object.getPacketTracker().getPacketsPerSecond();
            if ((long)object.getPacketTracker().getPacketsPerSecond() > l) {
                l = object.getPacketTracker().getPacketsPerSecond();
            }
            ++n2;
        }
        this.sendMessage(viaCommandSender, "&4Live Packets Per Second", new Object[0]);
        if (n2 > 1) {
            this.sendMessage(viaCommandSender, "&cAverage: &f" + n / n2, new Object[0]);
            this.sendMessage(viaCommandSender, "&cHighest: &f" + l, new Object[0]);
        }
        if (n2 == 0) {
            this.sendMessage(viaCommandSender, "&cNo clients to display.", new Object[0]);
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            this.sendMessage(viaCommandSender, "&8[&6%s&8]: &b%s", ((ProtocolVersion)entry.getKey()).getName(), entry.getValue());
        }
        treeMap.clear();
        return true;
    }
}

