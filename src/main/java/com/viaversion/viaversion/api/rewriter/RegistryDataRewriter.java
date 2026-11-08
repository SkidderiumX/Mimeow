/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.rewriter;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;

public interface RegistryDataRewriter {
    public void handle(PacketWrapper var1);

    public boolean shouldRemoveRegistry(String var1);

    public boolean hasRegistriesToRemove();

    public void updateDialog(UserConnection var1, CompoundTag var2);

    public void sendMissingRegistries(UserConnection var1);
}

