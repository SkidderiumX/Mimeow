/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viarewind.protocol.v1_8to1_7_6_10.provider;

import com.viaversion.viarewind.protocol.v1_8to1_7_6_10.storage.CompressionStatusTracker;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.platform.providers.Provider;

public abstract class CompressionHandlerProvider
implements Provider {
    public abstract void setCompressionThreshold(UserConnection var1, int var2);

    public abstract void onTransformPacket(UserConnection var1);

    public boolean isRemoveCompression(UserConnection userConnection) {
        return userConnection.get(CompressionStatusTracker.class).removeCompression;
    }

    public void setRemoveCompression(UserConnection userConnection, boolean bl) {
        userConnection.get(CompressionStatusTracker.class).removeCompression = bl;
    }
}

