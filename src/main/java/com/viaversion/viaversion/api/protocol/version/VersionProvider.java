/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.protocol.version;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;

@FunctionalInterface
public interface VersionProvider
extends Provider {
    default public ProtocolVersion getClientProtocol(UserConnection userConnection) {
        return null;
    }

    default public ProtocolVersion getServerProtocol(UserConnection userConnection) {
        try {
            return this.getClosestServerProtocol(userConnection);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public ProtocolVersion getClosestServerProtocol(UserConnection var1) throws Exception;
}

