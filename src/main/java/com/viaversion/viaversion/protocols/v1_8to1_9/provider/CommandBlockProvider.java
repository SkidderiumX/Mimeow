/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.protocols.v1_8to1_9.provider;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.BlockPosition;
import com.viaversion.viaversion.api.platform.providers.Provider;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_8to1_9.Protocol1_8To1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.packet.ClientboundPackets1_9;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.CommandBlockStorage;
import com.viaversion.viaversion.protocols.v1_8to1_9.storage.EntityTracker1_9;
import java.util.Optional;

public class CommandBlockProvider
implements Provider {
    public void addOrUpdateBlock(UserConnection userConnection, BlockPosition blockPosition, CompoundTag compoundTag) {
        this.checkPermission(userConnection);
        this.getStorage(userConnection).addOrUpdateBlock(blockPosition, compoundTag);
    }

    public Optional<CompoundTag> get(UserConnection userConnection, BlockPosition blockPosition) {
        this.checkPermission(userConnection);
        return this.getStorage(userConnection).getCommandBlock(blockPosition);
    }

    public void unloadChunk(UserConnection userConnection, int n, int n2) {
        this.checkPermission(userConnection);
        this.getStorage(userConnection).unloadChunk(n, n2);
    }

    private CommandBlockStorage getStorage(UserConnection userConnection) {
        return userConnection.get(CommandBlockStorage.class);
    }

    public void sendPermission(UserConnection userConnection) {
        PacketWrapper packetWrapper = PacketWrapper.create(ClientboundPackets1_9.ENTITY_EVENT, null, userConnection);
        EntityTracker1_9 entityTracker1_9 = (EntityTracker1_9)userConnection.getEntityTracker(Protocol1_8To1_9.class);
        packetWrapper.write(Types.INT, entityTracker1_9.getProvidedEntityId());
        packetWrapper.write(Types.BYTE, (byte)28);
        packetWrapper.scheduleSend(Protocol1_8To1_9.class);
        userConnection.get(CommandBlockStorage.class).setPermissions(true);
    }

    private void checkPermission(UserConnection userConnection) {
        CommandBlockStorage commandBlockStorage = this.getStorage(userConnection);
        if (!commandBlockStorage.isPermissions()) {
            this.sendPermission(userConnection);
        }
    }

    public void unloadChunks(UserConnection userConnection) {
        this.getStorage(userConnection).unloadChunks();
    }
}

