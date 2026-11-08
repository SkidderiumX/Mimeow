/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.connection;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.entity.EntityTracker;
import com.viaversion.viaversion.api.data.item.ItemHasher;
import com.viaversion.viaversion.api.minecraft.ClientWorld;
import com.viaversion.viaversion.api.platform.ViaInjector;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.protocol.packet.Direction;
import com.viaversion.viaversion.api.protocol.packet.PacketTracker;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.VarIntType;
import com.viaversion.viaversion.connection.ProtocolInfoImpl;
import com.viaversion.viaversion.exception.CancelException;
import com.viaversion.viaversion.exception.InformativeException;
import com.viaversion.viaversion.libs.fastutil.longs.LongOpenHashSet;
import com.viaversion.viaversion.libs.fastutil.longs.LongSet;
import com.viaversion.viaversion.libs.fastutil.objects.Reference2ObjectOpenHashMap;
import com.viaversion.viaversion.protocol.packet.PacketWrapperImpl;
import com.viaversion.viaversion.util.ChatColorUtil;
import com.viaversion.viaversion.util.PipelineUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.CodecException;
import java.util.Collection;
import java.util.Map;
import java.util.SplittableRandom;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import org.checkerframework.checker.nullness.qual.Nullable;

public class UserConnectionImpl
implements UserConnection {
    private static final int PASSTHROUGH_DATA_BYTES = 10;
    private static final AtomicLong IDS = new AtomicLong();
    private final long id = IDS.incrementAndGet();
    private final SplittableRandom random = new SplittableRandom();
    private final Map<Class<?>, StorableObject> storedObjects = new ConcurrentHashMap();
    private final Map<Class<? extends Protocol>, EntityTracker> entityTrackers = new Reference2ObjectOpenHashMap<Class<? extends Protocol>, EntityTracker>();
    private final Map<Class<? extends Protocol>, ItemHasher> itemHashers = new Reference2ObjectOpenHashMap<Class<? extends Protocol>, ItemHasher>();
    private final Map<Class<? extends Protocol>, ClientWorld> clientWorlds = new Reference2ObjectOpenHashMap<Class<? extends Protocol>, ClientWorld>();
    private final PacketTracker packetTracker = new PacketTracker(this);
    private final LongSet passthroughTokens = new LongOpenHashSet();
    private final ProtocolInfo protocolInfo = new ProtocolInfoImpl();
    private final Channel channel;
    private final boolean clientSide;
    private boolean active = true;
    private boolean pendingDisconnect;

    public UserConnectionImpl(@Nullable Channel channel, boolean bl) {
        this.channel = channel;
        this.clientSide = bl;
    }

    public UserConnectionImpl(@Nullable Channel channel) {
        this(channel, false);
    }

    @Override
    public <T extends StorableObject> @Nullable T get(Class<T> clazz) {
        return (T)this.storedObjects.get(clazz);
    }

    @Override
    public boolean has(Class<? extends StorableObject> clazz) {
        return this.storedObjects.containsKey(clazz);
    }

    @Override
    public <T extends StorableObject> @Nullable T remove(Class<T> clazz) {
        StorableObject storableObject = this.storedObjects.remove(clazz);
        if (storableObject != null) {
            storableObject.onRemove();
        }
        return (T)storableObject;
    }

    @Override
    public void put(StorableObject storableObject) {
        StorableObject storableObject2 = this.storedObjects.put(storableObject.getClass(), storableObject);
        if (storableObject2 != null) {
            storableObject2.onRemove();
        }
    }

    @Override
    public Collection<EntityTracker> getEntityTrackers() {
        return this.entityTrackers.values();
    }

    @Override
    public <T extends EntityTracker> @Nullable T getEntityTracker(Class<? extends Protocol> clazz) {
        return (T)this.entityTrackers.get(clazz);
    }

    @Override
    public void addEntityTracker(Class<? extends Protocol> clazz, EntityTracker entityTracker) {
        this.entityTrackers.putIfAbsent(clazz, entityTracker);
    }

    @Override
    public void addItemHasher(Class<? extends Protocol> clazz, ItemHasher itemHasher) {
        this.itemHashers.putIfAbsent(clazz, itemHasher);
    }

    @Override
    public <T extends ItemHasher> @Nullable T getItemHasher(Class<? extends Protocol> clazz) {
        return (T)this.itemHashers.get(clazz);
    }

    @Override
    public <T extends ClientWorld> @Nullable T getClientWorld(Class<? extends Protocol> clazz) {
        return (T)this.clientWorlds.get(clazz);
    }

    @Override
    public void addClientWorld(Class<? extends Protocol> clazz, ClientWorld clientWorld) {
        this.clientWorlds.putIfAbsent(clazz, clientWorld);
    }

    @Override
    public void clearStoredObjects() {
        for (StorableObject storableObject : this.storedObjects.values()) {
            storableObject.onRemove();
        }
        this.storedObjects.clear();
        this.entityTrackers.clear();
        this.itemHashers.clear();
        this.clientWorlds.clear();
    }

    @Override
    public void sendRawPacket(ByteBuf byteBuf) {
        this.sendRawPacket(byteBuf, true);
    }

    @Override
    public void scheduleSendRawPacket(ByteBuf byteBuf) {
        this.sendRawPacket(byteBuf, false);
    }

    private void sendRawPacket(ByteBuf byteBuf, boolean bl) {
        if (bl) {
            this.sendRawPacketNow(byteBuf);
        } else {
            try {
                this.channel.eventLoop().execute(() -> this.sendRawPacketNow(byteBuf));
            }
            catch (Throwable throwable) {
                byteBuf.release();
                throwable.printStackTrace();
            }
        }
    }

    private void sendRawPacketNow(ByteBuf byteBuf) {
        ChannelPipeline channelPipeline = this.getChannel().pipeline();
        ViaInjector viaInjector = Via.getManager().getInjector();
        if (this.clientSide) {
            channelPipeline.context(viaInjector.getDecoderName()).fireChannelRead(byteBuf);
        } else {
            channelPipeline.context(viaInjector.getEncoderName()).writeAndFlush(byteBuf);
        }
    }

    @Override
    public ChannelFuture sendRawPacketFuture(ByteBuf byteBuf) {
        if (this.clientSide) {
            this.getChannel().pipeline().context(Via.getManager().getInjector().getDecoderName()).fireChannelRead(byteBuf);
            return this.getChannel().newSucceededFuture();
        }
        return this.channel.pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush(byteBuf);
    }

    @Override
    public PacketTracker getPacketTracker() {
        return this.packetTracker;
    }

    @Override
    public void disconnect(String string) {
        if (!this.channel.isOpen() || this.pendingDisconnect) {
            return;
        }
        this.pendingDisconnect = true;
        if (this.isServerSide()) {
            Via.getPlatform().runSync(() -> {
                if (!Via.getPlatform().kickPlayer(this, ChatColorUtil.translateAlternateColorCodes(string))) {
                    this.channel.close();
                }
            });
        } else {
            this.channel.close();
        }
    }

    @Override
    public void sendRawPacketToServer(ByteBuf byteBuf) {
        if (this.clientSide) {
            this.sendRawPacketToServerClientSide(byteBuf, true);
        } else {
            this.sendRawPacketToServerServerSide(byteBuf, true);
        }
    }

    @Override
    public void scheduleSendRawPacketToServer(ByteBuf byteBuf) {
        if (this.clientSide) {
            this.sendRawPacketToServerClientSide(byteBuf, false);
        } else {
            this.sendRawPacketToServerServerSide(byteBuf, false);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void sendRawPacketToServerServerSide(ByteBuf byteBuf, boolean bl) {
        block7: {
            int n = this.active ? byteBuf.readableBytes() + 10 : byteBuf.readableBytes();
            ByteBuf byteBuf2 = byteBuf.alloc().buffer(n);
            try {
                ChannelHandlerContext channelHandlerContext = PipelineUtil.getPreviousContext(Via.getManager().getInjector().getDecoderName(), this.channel.pipeline());
                if (this.shouldTransformPacket()) {
                    Types.VAR_INT.writePrimitive(byteBuf2, 1000);
                    Types.LONG.writePrimitive(byteBuf2, this.generatePassthroughToken());
                }
                byteBuf2.writeBytes(byteBuf);
                if (bl) {
                    this.fireChannelRead(channelHandlerContext, byteBuf2);
                    break block7;
                }
                try {
                    this.channel.eventLoop().execute(() -> this.fireChannelRead(channelHandlerContext, byteBuf2));
                }
                catch (Throwable throwable) {
                    byteBuf2.release();
                    throw throwable;
                }
            }
            finally {
                byteBuf.release();
            }
        }
    }

    private void fireChannelRead(@Nullable ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        if (channelHandlerContext != null) {
            channelHandlerContext.fireChannelRead(byteBuf);
        } else {
            this.channel.pipeline().fireChannelRead(byteBuf);
        }
    }

    private void sendRawPacketToServerClientSide(ByteBuf byteBuf, boolean bl) {
        if (bl) {
            this.writeAndFlush(byteBuf);
        } else {
            try {
                this.getChannel().eventLoop().execute(() -> this.writeAndFlush(byteBuf));
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
                byteBuf.release();
            }
        }
    }

    private void writeAndFlush(ByteBuf byteBuf) {
        this.getChannel().pipeline().context(Via.getManager().getInjector().getEncoderName()).writeAndFlush(byteBuf);
    }

    @Override
    public boolean checkServerboundPacket(int n) {
        if (this.pendingDisconnect) {
            return false;
        }
        if (!this.packetTracker.isPacketLimiterEnabled()) {
            return true;
        }
        this.packetTracker.incrementReceived(n);
        return !this.packetTracker.exceedsLimits();
    }

    @Override
    public boolean checkClientboundPacket() {
        this.packetTracker.incrementSent();
        return true;
    }

    @Override
    public boolean shouldTransformPacket() {
        return this.active;
    }

    @Override
    public void transformClientbound(ByteBuf byteBuf, Function<Throwable, CodecException> function) throws InformativeException, CodecException {
        this.transform(byteBuf, Direction.CLIENTBOUND, function);
    }

    @Override
    public void transformServerbound(ByteBuf byteBuf, Function<Throwable, CodecException> function) throws InformativeException, CodecException {
        this.transform(byteBuf, Direction.SERVERBOUND, function);
    }

    private void transform(ByteBuf byteBuf, Direction direction, Function<Throwable, CodecException> function) throws InformativeException, CodecException {
        if (!byteBuf.isReadable()) {
            return;
        }
        int n = Types.VAR_INT.readPrimitive(byteBuf);
        if (n == 1000 && byteBuf.readableBytes() >= 8) {
            if (this.removePassthroughToken(byteBuf.readLong())) {
                return;
            }
            byteBuf.readerIndex(byteBuf.readerIndex() - 8);
        }
        int n2 = byteBuf.readerIndex();
        PacketWrapperImpl packetWrapperImpl = new PacketWrapperImpl(n, byteBuf, (UserConnection)this);
        try {
            this.protocolInfo.getPipeline().transform(direction, this.protocolInfo.getState(direction), packetWrapperImpl);
        }
        catch (CancelException cancelException) {
            throw function.apply(cancelException);
        }
        this.writeToBuffer(packetWrapperImpl, byteBuf, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void writeToBuffer(PacketWrapperImpl packetWrapperImpl, ByteBuf byteBuf, int n, int n2) {
        int n3 = byteBuf.readableBytes();
        if (byteBuf.readerIndex() == n2 && packetWrapperImpl.areStoredPacketValuesEmpty()) {
            if (packetWrapperImpl.getId() == n) {
                byteBuf.setIndex(0, n2 + n3);
                return;
            }
            if (VarIntType.varIntLength(packetWrapperImpl.getId()) == VarIntType.varIntLength(n)) {
                byteBuf.setIndex(0, 0);
                Types.VAR_INT.writePrimitive(byteBuf, packetWrapperImpl.getId());
                byteBuf.writerIndex(n2 + n3);
                return;
            }
        }
        ByteBuf byteBuf2 = byteBuf.alloc().buffer(n3, n3);
        try {
            byteBuf2.writeBytes(byteBuf, n3);
            byteBuf.setIndex(0, 0);
            packetWrapperImpl.writeProcessedValues(byteBuf);
            byteBuf.writeBytes(byteBuf2);
        }
        finally {
            byteBuf2.release();
        }
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public @Nullable Channel getChannel() {
        return this.channel;
    }

    @Override
    public ProtocolInfo getProtocolInfo() {
        return this.protocolInfo;
    }

    @Override
    public Map<Class<?>, StorableObject> getStoredObjects() {
        return this.storedObjects;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void setActive(boolean bl) {
        this.active = bl;
    }

    @Override
    public boolean isPendingDisconnect() {
        return this.pendingDisconnect;
    }

    @Override
    public void setPendingDisconnect(boolean bl) {
        this.pendingDisconnect = bl;
    }

    @Override
    public boolean isClientSide() {
        return this.clientSide;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public long generatePassthroughToken() {
        while (true) {
            LongSet longSet = this.passthroughTokens;
            synchronized (longSet) {
                long l = this.random.nextLong();
                if (this.passthroughTokens.add(l)) {
                    return l;
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean removePassthroughToken(long l) {
        LongSet longSet = this.passthroughTokens;
        synchronized (longSet) {
            return this.passthroughTokens.remove(l);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        UserConnectionImpl userConnectionImpl = (UserConnectionImpl)object;
        return this.id == userConnectionImpl.id;
    }

    public int hashCode() {
        return Long.hashCode(this.id);
    }
}

