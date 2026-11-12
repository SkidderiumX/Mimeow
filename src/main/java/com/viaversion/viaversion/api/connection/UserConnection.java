/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.connection;

import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.PacketTracker;
import com.viaversion.viaversion.exception.InformativeException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.handler.codec.CodecException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface UserConnection {
    public <T extends StorableObject> @Nullable T get(Class<T> var1);

    public boolean has(Class<? extends StorableObject> var1);

    public <T extends StorableObject> @Nullable T remove(Class<T> var1);

    public void put(StorableObject var1);

    public Collection<EntityTracker> getEntityTrackers();

    public <T extends EntityTracker> @Nullable T getEntityTracker(Class<? extends Protocol> var1);

    public void addEntityTracker(Class<? extends Protocol> var1, EntityTracker var2);

    public void addItemHasher(Class<? extends Protocol> var1, ItemHasher var2);

    public <T extends ItemHasher> @Nullable T getItemHasher(Class<? extends Protocol> var1);

    public <T extends ClientWorld> @Nullable T getClientWorld(Class<? extends Protocol> var1);

    public void addClientWorld(Class<? extends Protocol> var1, ClientWorld var2);

    public void clearStoredObjects();

    public void sendRawPacket(ByteBuf var1);

    public void scheduleSendRawPacket(ByteBuf var1);

    public ChannelFuture sendRawPacketFuture(ByteBuf var1);

    public PacketTracker getPacketTracker();

    public void disconnect(String var1);

    public void sendRawPacketToServer(ByteBuf var1);

    public void scheduleSendRawPacketToServer(ByteBuf var1);

    public boolean checkServerboundPacket(int var1);

    @java.lang.Deprecated(forRemoval=true)
    default public boolean checkServerboundPacket() {
        return this.checkServerboundPacket(0);
    }

    public boolean checkClientboundPacket();

    default public boolean checkIncomingPacket(int n) {
        return this.isClientSide() ? this.checkClientboundPacket() : this.checkServerboundPacket(n);
    }

    @java.lang.Deprecated(forRemoval=true)
    default public boolean checkIncomingPacket() {
        return this.isClientSide() ? this.checkClientboundPacket() : this.checkServerboundPacket();
    }

    default public boolean checkOutgoingPacket() {
        return this.isClientSide() ? this.checkServerboundPacket() : this.checkClientboundPacket();
    }

    public boolean shouldTransformPacket();

    public void transformClientbound(ByteBuf var1, Function<Throwable, CodecException> var2) throws InformativeException;

    public void transformServerbound(ByteBuf var1, Function<Throwable, CodecException> var2) throws InformativeException;

    default public void transformOutgoing(ByteBuf byteBuf, Function<Throwable, CodecException> function) throws InformativeException {
        if (this.isClientSide()) {
            this.transformServerbound(byteBuf, function);
        } else {
            this.transformClientbound(byteBuf, function);
        }
    }

    default public void transformIncoming(ByteBuf byteBuf, Function<Throwable, CodecException> function) throws InformativeException {
        if (this.isClientSide()) {
            this.transformClientbound(byteBuf, function);
        } else {
            this.transformServerbound(byteBuf, function);
        }
    }

    public long getId();

    public @Nullable Channel getChannel();

    public ProtocolInfo getProtocolInfo();

    public Map<Class<?>, StorableObject> getStoredObjects();

    public boolean isActive();

    public void setActive(boolean var1);

    public boolean isPendingDisconnect();

    public void setPendingDisconnect(boolean var1);

    public boolean isClientSide();

    default public boolean isServerSide() {
        return !this.isClientSide();
    }

    default public boolean shouldApplyBlockProtocol() {
        return this.isServerSide();
    }

    public long generatePassthroughToken();
}

