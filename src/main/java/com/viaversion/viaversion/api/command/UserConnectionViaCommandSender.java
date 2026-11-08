/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.command;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.command.ViaCommandSender;
import com.viaversion.viaversion.api.connection.UserConnection;
import java.util.UUID;

public class UserConnectionViaCommandSender
implements ViaCommandSender {
    private final UserConnection connection;

    public UserConnectionViaCommandSender(UserConnection userConnection) {
        this.connection = userConnection;
    }

    @Override
    public boolean hasPermission(String string) {
        return true;
    }

    @Override
    public void sendMessage(String string) {
        Via.getPlatform().sendMessage(this.connection, string);
    }

    @Override
    public UUID getUUID() {
        return this.connection.getProtocolInfo().getUuid();
    }

    @Override
    public String getName() {
        return this.connection.getProtocolInfo().getUsername();
    }
}

