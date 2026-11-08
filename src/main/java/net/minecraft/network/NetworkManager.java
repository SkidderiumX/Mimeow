/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.viaversion.viaversion.connection.UserConnectionImpl;
import com.viaversion.viaversion.protocol.ProtocolPipelineImpl;
import de.florianmichael.vialoadingbase.ViaLoadingBase;
import de.florianmichael.vialoadingbase.netty.event.CompressionReorderEvent;
import de.florianmichael.viamcp.MCPVLBPipeline;
import de.florianmichael.viamcp.ViaMCP;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.MultithreadEventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.SecretKey;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.EnumPacketDirection;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NettyCompressionDecoder;
import net.minecraft.network.NettyCompressionEncoder;
import net.minecraft.network.NettyEncryptingDecoder;
import net.minecraft.network.NettyEncryptingEncoder;
import net.minecraft.network.NetworkTransportCompatibility;
import net.minecraft.network.Packet;
import net.minecraft.network.TerrainTransitionGate;
import net.minecraft.network.ThreadQuickExitException;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S08PacketPlayerPosLook;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.CryptManager;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.MessageDeserializer;
import net.minecraft.util.MessageDeserializer2;
import net.minecraft.util.MessageSerializer;
import net.minecraft.util.MessageSerializer2;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import x.oc04ce76e767;
import x.oc2cf3d80e17;
import x.oc51fb428ba0;
import x.oc5e549848f3;
import x.oc5e6785e9df;
import x.oc640d815dd7;
import x.oc6c7463093f;
import x.oc9755810e45;
import x.oc9d4393f3ce;
import x.oca92b9fb920;
import x.ocb67361fd4e;
import x.ocd6ae010123;
import x.ocdab58ca6e4;
import x.oce79181588d;
import x.ocea775c9d5c;
import x.ocee33618a8d;

public class NetworkManager
extends SimpleChannelInboundHandler<Packet>
implements oc640d815dd7 {
    private static final Logger logger = LogManager.getLogger();
    public static final Marker logMarkerNetwork = MarkerManager.getMarker("NETWORK");
    public static final Marker logMarkerPackets = MarkerManager.getMarker("NETWORK_PACKETS", logMarkerNetwork);
    public static final AttributeKey<EnumConnectionState> attrKeyConnectionState = AttributeKey.valueOf("protocol");
    public static final LazyLoadBase<NioEventLoopGroup> CLIENT_NIO_EVENTLOOP = new LazyLoadBase<NioEventLoopGroup>(){

        @Override
        protected NioEventLoopGroup load() {
            return new NioEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Client IO #%d").setDaemon(true).build());
        }
    };
    public static final LazyLoadBase<EpollEventLoopGroup> CLIENT_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>(){

        @Override
        protected EpollEventLoopGroup load() {
            return new EpollEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
        }
    };
    public static final LazyLoadBase<LocalEventLoopGroup> CLIENT_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>(){

        @Override
        protected LocalEventLoopGroup load() {
            return new LocalEventLoopGroup(0, new ThreadFactoryBuilder().setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
        }
    };
    private final EnumPacketDirection direction;
    private final Queue<InboundHandlerTuplePacketListener> outboundPacketsQueue = Queues.newConcurrentLinkedQueue();
    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private Channel channel;
    private SocketAddress socketAddress;
    private INetHandler packetListener;
    private IChatComponent terminationReason;
    private boolean isEncrypted;
    private boolean disconnected;
    private final TerrainTransitionGate mimeow$terrainTransitionGate = new TerrainTransitionGate();

    public NetworkManager(EnumPacketDirection enumPacketDirection) {
        this.direction = enumPacketDirection;
    }

    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.channelActive(channelHandlerContext);
        this.channel = channelHandlerContext.channel();
        this.socketAddress = this.channel.remoteAddress();
        try {
            this.setConnectionState(EnumConnectionState.HANDSHAKING);
        }
        catch (Throwable throwable) {
            logger.fatal(throwable);
        }
    }

    public void setConnectionState(EnumConnectionState enumConnectionState) {
        this.channel.attr(attrKeyConnectionState).set(enumConnectionState);
        this.channel.read();
        this.channel.config().setAutoRead(true);
        logger.debug("Enabled auto read");
    }

    @Override
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.mimeow$terrainTransitionGate.reset();
        this.closeChannel(new ChatComponentTranslation("disconnect.endOfStream", new Object[0]));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable throwable) throws Exception {
        ChatComponentTranslation chatComponentTranslation = throwable instanceof TimeoutException ? new ChatComponentTranslation("disconnect.timeout", new Object[0]) : new ChatComponentTranslation("disconnect.genericReason", "Internal Exception: " + String.valueOf(throwable));
        this.closeChannel(chatComponentTranslation);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Packet packet) throws Exception {
        Minecraft minecraft = Minecraft.getMinecraft();
        if (this.packetListener instanceof NetHandlerPlayClient && oc04ce76e767.\u01de(minecraft, packet, () -> this.mimeow$processIncomingPacket(channelHandlerContext, packet))) {
            return;
        }
        this.mimeow$processIncomingPacket(channelHandlerContext, packet);
    }

    private void mimeow$processIncomingPacket(ChannelHandlerContext channelHandlerContext, Packet packet) {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("channelRead0", true);
        this.mimeow$receivePacket(channelHandlerContext, packet, ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9() && this.channel.isOpen()) {
            try {
                packet.processPacket(this.packetListener);
            }
            catch (ThreadQuickExitException threadQuickExitException) {
                // empty catch block
            }
        }
    }

    public void setNetHandler(INetHandler iNetHandler) {
        Validate.notNull(iNetHandler, "packetListener", new Object[0]);
        logger.debug("Set listener of {} to {}", this, iNetHandler);
        this.mimeow$terrainTransitionGate.reset();
        this.packetListener = iNetHandler;
    }

    public void sendPacket(Packet packet) {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("sendPacket", true);
        this.mimeow$sendPacket(packet, ocee33618a8d2);
        if (!ocee33618a8d2.z$24lpjeeur71n9()) {
            if (this.isChannelOpen()) {
                this.flushOutboundQueue();
                this.dispatchPacket(packet, null);
            } else {
                this.readWriteLock.writeLock().lock();
                try {
                    this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(packet, null));
                }
                finally {
                    this.readWriteLock.writeLock().unlock();
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void sendPacket(Packet packet, GenericFutureListener<? extends Future<? super Void>> genericFutureListener, GenericFutureListener<? extends Future<? super Void>> ... genericFutureListenerArray) {
        if (this.isChannelOpen()) {
            this.flushOutboundQueue();
            this.dispatchPacket(packet, ArrayUtils.add(genericFutureListenerArray, 0, genericFutureListener));
        } else {
            this.readWriteLock.writeLock().lock();
            try {
                this.outboundPacketsQueue.add(new InboundHandlerTuplePacketListener(packet, ArrayUtils.add(genericFutureListenerArray, 0, genericFutureListener)));
            }
            finally {
                this.readWriteLock.writeLock().unlock();
            }
        }
    }

    private void dispatchPacket(final Packet packet, final GenericFutureListener<? extends Future<? super Void>>[] genericFutureListenerArray) {
        ocee33618a8d ocee33618a8d2 = new ocee33618a8d("dispatchPacket", false);
        this.mimeow$dispatchPacket(packet, genericFutureListenerArray, ocee33618a8d2);
        if (ocee33618a8d2.z$24lpjeeur71n9()) {
            return;
        }
        final EnumConnectionState enumConnectionState = EnumConnectionState.getFromPacket(packet);
        final EnumConnectionState enumConnectionState2 = this.channel.attr(attrKeyConnectionState).get();
        if (enumConnectionState2 != enumConnectionState) {
            logger.debug("Disabled auto read");
            this.channel.config().setAutoRead(false);
        }
        if (this.channel.eventLoop().inEventLoop()) {
            if (enumConnectionState != enumConnectionState2) {
                this.setConnectionState(enumConnectionState);
            }
            ChannelFuture channelFuture = this.channel.writeAndFlush(packet);
            if (genericFutureListenerArray != null) {
                channelFuture.addListeners(genericFutureListenerArray);
            }
            channelFuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
        } else {
            this.channel.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    if (enumConnectionState != enumConnectionState2) {
                        NetworkManager.this.setConnectionState(enumConnectionState);
                    }
                    ChannelFuture channelFuture = NetworkManager.this.channel.writeAndFlush(packet);
                    if (genericFutureListenerArray != null) {
                        channelFuture.addListeners(genericFutureListenerArray);
                    }
                    channelFuture.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
                }
            });
        }
    }

    private void flushOutboundQueue() {
        if (this.channel != null && this.channel.isOpen()) {
            this.readWriteLock.readLock().lock();
            try {
                while (!this.outboundPacketsQueue.isEmpty()) {
                    InboundHandlerTuplePacketListener inboundHandlerTuplePacketListener = this.outboundPacketsQueue.poll();
                    this.dispatchPacket(inboundHandlerTuplePacketListener.packet, inboundHandlerTuplePacketListener.futureListeners);
                }
            }
            finally {
                this.readWriteLock.readLock().unlock();
            }
        }
    }

    public void processReceivedPackets() {
        this.flushOutboundQueue();
        if (this.packetListener instanceof ITickable) {
            ((ITickable)((Object)this.packetListener)).update();
        }
        this.channel.flush();
    }

    public SocketAddress getRemoteAddress() {
        return this.socketAddress;
    }

    public void closeChannel(IChatComponent iChatComponent) {
        if (this.terminationReason == null) {
            this.terminationReason = iChatComponent;
        }
        if (this.packetListener instanceof NetHandlerPlayClient) {
            this.mimeow$clearLagQueues();
        }
        if (this.channel != null && this.channel.isOpen()) {
            this.channel.close().awaitUninterruptibly();
        }
    }

    public boolean isLocalChannel() {
        return this.channel instanceof LocalChannel || this.channel instanceof LocalServerChannel;
    }

    public static NetworkManager createNetworkManagerAndConnect(InetAddress inetAddress, int n, boolean bl) {
        LazyLoadBase<MultithreadEventLoopGroup> lazyLoadBase;
        Class clazz;
        final NetworkManager networkManager = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        if (NetworkTransportCompatibility.shouldUseEpoll(bl)) {
            clazz = EpollSocketChannel.class;
            lazyLoadBase = CLIENT_EPOLL_EVENTLOOP;
        } else {
            clazz = NioSocketChannel.class;
            lazyLoadBase = CLIENT_NIO_EVENTLOOP;
        }
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(lazyLoadBase.getValue())).handler(new ChannelInitializer<Channel>(){

            @Override
            protected void initChannel(Channel channel) throws Exception {
                try {
                    channel.config().setOption(ChannelOption.TCP_NODELAY, true);
                }
                catch (ChannelException channelException) {
                    // empty catch block
                }
                channel.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("splitter", (ChannelHandler)new MessageDeserializer2()).addLast("decoder", (ChannelHandler)new MessageDeserializer(EnumPacketDirection.CLIENTBOUND)).addLast("prepender", (ChannelHandler)new MessageSerializer2()).addLast("encoder", (ChannelHandler)new MessageSerializer(EnumPacketDirection.SERVERBOUND)).addLast("mimeow_slinky_packets", (ChannelHandler)new ocdab58ca6e4()).addLast("packet_handler", (ChannelHandler)networkManager);
                if (channel instanceof SocketChannel && ViaMCP.isReady() && ViaLoadingBase.getInstance().getTargetVersion().getVersion() != 47) {
                    UserConnectionImpl userConnectionImpl = new UserConnectionImpl(channel, true);
                    new ProtocolPipelineImpl(userConnectionImpl);
                    channel.pipeline().addLast(new MCPVLBPipeline(userConnectionImpl));
                }
            }
        })).channel(clazz)).connect(inetAddress, n).syncUninterruptibly();
        return networkManager;
    }

    public static NetworkManager provideLocalClient(SocketAddress socketAddress) {
        final NetworkManager networkManager = new NetworkManager(EnumPacketDirection.CLIENTBOUND);
        ((Bootstrap)((Bootstrap)((Bootstrap)new Bootstrap().group(CLIENT_LOCAL_EVENTLOOP.getValue())).handler(new ChannelInitializer<Channel>(){

            @Override
            protected void initChannel(Channel channel) throws Exception {
                channel.pipeline().addLast("mimeow_slinky_packets", (ChannelHandler)new ocdab58ca6e4()).addLast("packet_handler", (ChannelHandler)networkManager);
            }
        })).channel(LocalChannel.class)).connect(socketAddress).syncUninterruptibly();
        return networkManager;
    }

    public void enableEncryption(SecretKey secretKey) {
        this.isEncrypted = true;
        this.channel.pipeline().addBefore("splitter", "decrypt", new NettyEncryptingDecoder(CryptManager.createNetCipherInstance(2, secretKey)));
        this.channel.pipeline().addBefore("prepender", "encrypt", new NettyEncryptingEncoder(CryptManager.createNetCipherInstance(1, secretKey)));
    }

    public boolean getIsencrypted() {
        return this.isEncrypted;
    }

    public boolean isChannelOpen() {
        return this.channel != null && this.channel.isOpen();
    }

    public boolean hasNoChannel() {
        return this.channel == null;
    }

    public INetHandler getNetHandler() {
        return this.packetListener;
    }

    public IChatComponent getExitMessage() {
        return this.terminationReason;
    }

    public void disableAutoRead() {
        this.channel.config().setAutoRead(false);
    }

    public void setCompressionTreshold(int n) {
        if (n >= 0) {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                ((NettyCompressionDecoder)this.channel.pipeline().get("decompress")).setCompressionTreshold(n);
            } else {
                this.channel.pipeline().addBefore("decoder", "decompress", new NettyCompressionDecoder(n));
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                ((NettyCompressionEncoder)this.channel.pipeline().get("compress")).setCompressionTreshold(n);
            } else {
                this.channel.pipeline().addBefore("encoder", "compress", new NettyCompressionEncoder(n));
            }
        } else {
            if (this.channel.pipeline().get("decompress") instanceof NettyCompressionDecoder) {
                this.channel.pipeline().remove("decompress");
            }
            if (this.channel.pipeline().get("compress") instanceof NettyCompressionEncoder) {
                this.channel.pipeline().remove("compress");
            }
        }
        this.channel.pipeline().fireUserEventTriggered(new CompressionReorderEvent());
    }

    public void checkDisconnected() {
        if (this.channel != null && !this.channel.isOpen()) {
            if (!this.disconnected) {
                this.disconnected = true;
                if (this.getExitMessage() != null) {
                    this.getNetHandler().onDisconnect(this.getExitMessage());
                } else if (this.getNetHandler() != null) {
                    this.getNetHandler().onDisconnect(new ChatComponentText("Disconnected"));
                }
            } else {
                logger.warn("handleDisconnection() called twice");
            }
        }
    }

    public void mimeow$sendPacket(Packet packet, ocee33618a8d ocee33618a8d2) {
        boolean bl = ocd6ae010123.\u0129(packet);
        if (ocb67361fd4e.\u0126(packet) || oc51fb428ba0.\u0450(packet)) {
            return;
        }
        if (!this.mimeow$isPlaySessionReady()) {
            return;
        }
        if (bl) {
            boolean bl2;
            ocea775c9d5c.\u0173.post(new oc5e6785e9df(packet));
            if (oc51fb428ba0.\u038f(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
                return;
            }
            boolean bl3 = oc2cf3d80e17.\u02ad != null && oc2cf3d80e17.\u02ad.\u0494();
            boolean bl4 = bl2 = oc2cf3d80e17.\u04be != null && oc2cf3d80e17.\u04be.\u0119();
            if (!bl3 && !bl2 && oc9755810e45.\u017f != null && oc9755810e45.\u017f.\u0278(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
                return;
            }
            if (!bl3 && !bl2 && oc2cf3d80e17.\u04be != null && oc2cf3d80e17.\u04be.\u0111(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            } else if (!bl3 && !bl2 && oc2cf3d80e17.\u02ad != null && oc2cf3d80e17.\u02ad.\u027a(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            }
        } else {
            oc9d4393f3ce oc9d4393f3ce2 = new oc9d4393f3ce(packet);
            ocea775c9d5c.\u0173.post(oc9d4393f3ce2);
            if (oc9d4393f3ce2.isCanceled() || oc51fb428ba0.\u038f(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            } else if (oca92b9fb920.\u0464(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            } else if (oc2cf3d80e17.\u02ad != null && !oc2cf3d80e17.\u02ad.\u0494() && oc2cf3d80e17.\u02ad.\u027a(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            }
        }
        if (!ocee33618a8d2.z$24lpjeeur71n9() && !oc5e549848f3.\u038f(packet)) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
        }
    }

    public void mimeow$dispatchPacket(Packet packet, GenericFutureListener[] genericFutureListenerArray, ocee33618a8d ocee33618a8d2) {
        if (oc51fb428ba0.\u038f(packet)) {
            ocee33618a8d2.z$2vp8d6bhwkrey();
            return;
        }
        oc51fb428ba0.\u057f(packet);
        if (!this.mimeow$isPlaySessionReady()) {
            return;
        }
        oc6c7463093f oc6c7463093f2 = new oc6c7463093f(packet);
        ocea775c9d5c.\u0173.post(oc6c7463093f2);
    }

    public void mimeow$receivePacket(ChannelHandlerContext channelHandlerContext, Packet packet, ocee33618a8d ocee33618a8d2) {
        boolean bl = ocd6ae010123.\u04ca(packet);
        boolean bl2 = this.mimeow$terrainTransitionGate.beginIfBoundary(packet);
        if (bl2 || packet instanceof S40PacketDisconnect) {
            this.mimeow$clearLagQueues();
        } else if (packet instanceof S08PacketPlayerPosLook) {
            this.mimeow$handleLagServerCorrection();
        }
        if (ocb67361fd4e.\u04ea(packet)) {
            return;
        }
        if (this.mimeow$terrainTransitionGate.shouldBypassHooks() && !bl2) {
            return;
        }
        if (!this.mimeow$isPlaySessionReady()) {
            return;
        }
        if (!bl) {
            boolean bl3;
            oce79181588d oce79181588d2 = new oce79181588d(packet);
            ocea775c9d5c.\u0173.post(oce79181588d2);
            boolean bl4 = bl3 = bl2 || packet instanceof S07PacketRespawn || packet instanceof S08PacketPlayerPosLook || ocb67361fd4e.\u0424(packet);
            if (oce79181588d2.isCanceled() && (!bl3 || oce79181588d2.\u0146()) || oc51fb428ba0.\u0422(packet)) {
                ocee33618a8d2.z$2vp8d6bhwkrey();
            }
        }
    }

    public void mimeow$completeTerrainTransition() {
        this.mimeow$terrainTransitionGate.complete();
    }

    private boolean mimeow$isPlaySessionReady() {
        if (!(this.packetListener instanceof NetHandlerPlayClient)) {
            return false;
        }
        Minecraft minecraft = Minecraft.getMinecraft();
        NetHandlerPlayClient netHandlerPlayClient = (NetHandlerPlayClient)this.packetListener;
        return minecraft != null && minecraft.theWorld != null && minecraft.thePlayer != null && minecraft.getNetHandler() == netHandlerPlayClient && netHandlerPlayClient.isDoneLoadingTerrain();
    }

    private void mimeow$clearLagQueues() {
        if (oc9755810e45.\u03ce != null) {
            oc9755810e45.\u03ce.\u025c();
        }
        if (oc9755810e45.\u04a9 != null) {
            oc9755810e45.\u04a9.\u0185();
        }
        if (oc9755810e45.\u017f != null) {
            oc9755810e45.\u017f.\u0579();
        }
        if (oc2cf3d80e17.\u02ad != null) {
            oc2cf3d80e17.\u02ad.\u01c7();
        }
        if (oc2cf3d80e17.\u04be != null) {
            oc2cf3d80e17.\u04be.\u040b(false);
        }
    }

    private void mimeow$handleLagServerCorrection() {
        if (oc9755810e45.\u03ce != null) {
            oc9755810e45.\u03ce.\u022c();
        }
        if (oc2cf3d80e17.\u02ad != null) {
            oc2cf3d80e17.\u02ad.\u01c7();
        }
        if (oc2cf3d80e17.\u04be != null) {
            oc2cf3d80e17.\u04be.\u016d();
        }
        if (oc9755810e45.\u017f != null) {
            oc9755810e45.\u017f.\u04e9();
        }
    }

    @Override
    public INetHandler getPacketListener() {
        return this.packetListener;
    }

    public static class InboundHandlerTuplePacketListener {
        private final Packet packet;
        private final GenericFutureListener<? extends Future<? super Void>>[] futureListeners;

        public InboundHandlerTuplePacketListener(Packet packet, GenericFutureListener<? extends Future<? super Void>> ... genericFutureListenerArray) {
            this.packet = packet;
            this.futureListeners = genericFutureListenerArray;
        }
    }
}

