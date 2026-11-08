/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ConnectionManager;
import com.viaversion.viaversion.api.connection.UserConnection;
import io.netty.channel.Channel;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ConnectionManagerImpl
implements ConnectionManager {
    protected final Map<UUID, UserConnection> serverConnections = new ConcurrentHashMap<UUID, UserConnection>();
    protected final Map<UUID, UserConnection> clientConnections = new ConcurrentHashMap<UUID, UserConnection>();
    protected final Set<UserConnection> connections = ConcurrentHashMap.newKeySet();
    private final Set<UserConnection> connectionsView = Collections.unmodifiableSet(this.connections);

    @Override
    public void onLoginSuccess(UserConnection userConnection) {
        Objects.requireNonNull(userConnection, "connection is null!");
        Channel channel = userConnection.getChannel();
        if (channel != null && !channel.isOpen()) {
            return;
        }
        boolean bl = this.connections.add(userConnection);
        UUID uUID = userConnection.getProtocolInfo().getUuid();
        if (userConnection.isServerSide()) {
            UserConnection userConnection2 = this.serverConnections.put(uUID, userConnection);
            if (userConnection2 != null && userConnection2 != userConnection) {
                Via.getPlatform().getLogger().warning("Duplicate UUID on frontend connection! (" + String.valueOf(uUID) + ")");
            }
        } else {
            this.clientConnections.put(uUID, userConnection);
        }
        if (channel != null) {
            if (!channel.isOpen()) {
                this.onDisconnect(userConnection);
            } else if (bl) {
                channel.closeFuture().addListener(channelFuture -> this.onDisconnect(userConnection));
            }
        }
    }

    @Override
    public void onDisconnect(UserConnection userConnection) {
        Objects.requireNonNull(userConnection, "connection is null!");
        userConnection.setActive(false);
        this.connections.remove(userConnection);
        UUID uUID = userConnection.getProtocolInfo().getUuid();
        if (userConnection.isServerSide()) {
            this.serverConnections.remove(uUID, userConnection);
        } else {
            this.clientConnections.remove(uUID, userConnection);
        }
        userConnection.getChannel().eventLoop().execute(userConnection::clearStoredObjects);
    }

    @Override
    public boolean hasServerConnection(UUID uUID) {
        return this.serverConnections.containsKey(uUID);
    }

    @Override
    public @Nullable UserConnection getServerConnection(UUID uUID) {
        return this.serverConnections.get(uUID);
    }

    @Override
    public boolean hasClientConnection(UUID uUID) {
        return this.clientConnections.containsKey(uUID);
    }

    @Override
    public @Nullable UserConnection getClientConnection(UUID uUID) {
        return this.clientConnections.get(uUID);
    }

    @Override
    public Map<UUID, UserConnection> getServerConnections() {
        return Collections.unmodifiableMap(this.serverConnections);
    }

    @Override
    public Map<UUID, UserConnection> getClientConnections() {
        return Collections.unmodifiableMap(this.clientConnections);
    }

    @Override
    public Set<UserConnection> getConnections() {
        return this.connectionsView;
    }
}

