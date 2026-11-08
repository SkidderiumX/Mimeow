/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.sctp.oio;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.channel.sctp.SctpServerChannelConfig;
import io.netty.channel.sctp.oio.OioSctpChannel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class OioSctpServerChannel
extends AbstractOioMessageChannel
implements SctpServerChannel {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSctpServerChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final com.sun.nio.sctp.SctpServerChannel sch;
    private final SctpServerChannelConfig config;
    private final Selector selector;

    private static com.sun.nio.sctp.SctpServerChannel newServerSocket() {
        try {
            return com.sun.nio.sctp.SctpServerChannel.open();
        }
        catch (IOException iOException) {
            throw new ChannelException("failed to create a sctp server channel", iOException);
        }
    }

    public OioSctpServerChannel() {
        this(OioSctpServerChannel.newServerSocket());
    }

    public OioSctpServerChannel(com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
        super(null);
        if (sctpServerChannel == null) {
            throw new NullPointerException("sctp server channel");
        }
        this.sch = sctpServerChannel;
        boolean bl = false;
        try {
            sctpServerChannel.configureBlocking(false);
            this.selector = Selector.open();
            sctpServerChannel.register(this.selector, 16);
            this.config = new OioSctpServerChannelConfig(this, sctpServerChannel);
            bl = true;
        }
        catch (Exception exception) {
            throw new ChannelException("failed to initialize a sctp server channel", exception);
        }
        finally {
            if (!bl) {
                try {
                    sctpServerChannel.close();
                }
                catch (IOException iOException) {
                    logger.warn("Failed to close a sctp server channel.", iOException);
                }
            }
        }
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override
    public SctpServerChannelConfig config() {
        return this.config;
    }

    @Override
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override
    public InetSocketAddress localAddress() {
        return (InetSocketAddress)super.localAddress();
    }

    @Override
    public boolean isOpen() {
        return this.sch.isOpen();
    }

    @Override
    protected SocketAddress localAddress0() {
        try {
            Iterator<SocketAddress> iterator2 = this.sch.getAllLocalAddresses().iterator();
            if (iterator2.hasNext()) {
                return iterator2.next();
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return null;
    }

    @Override
    public Set<InetSocketAddress> allLocalAddresses() {
        try {
            Set<SocketAddress> set = this.sch.getAllLocalAddresses();
            LinkedHashSet<InetSocketAddress> linkedHashSet = new LinkedHashSet<InetSocketAddress>(set.size());
            for (SocketAddress socketAddress : set) {
                linkedHashSet.add((InetSocketAddress)socketAddress);
            }
            return linkedHashSet;
        }
        catch (Throwable throwable) {
            return Collections.emptySet();
        }
    }

    @Override
    public boolean isActive() {
        return this.isOpen() && this.localAddress0() != null;
    }

    @Override
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.sch.bind(socketAddress, this.config.getBacklog());
    }

    @Override
    protected void doClose() throws Exception {
        try {
            this.selector.close();
        }
        catch (IOException iOException) {
            logger.warn("Failed to close a selector.", iOException);
        }
        this.sch.close();
    }

    @Override
    protected int doReadMessages(List<Object> list) throws Exception {
        int n;
        block7: {
            if (!this.isActive()) {
                return -1;
            }
            AbstractInterruptibleChannel abstractInterruptibleChannel = null;
            n = 0;
            try {
                int n2 = this.selector.select(1000L);
                if (n2 > 0) {
                    Iterator<SelectionKey> iterator2 = this.selector.selectedKeys().iterator();
                    do {
                        SelectionKey selectionKey = iterator2.next();
                        iterator2.remove();
                        if (!selectionKey.isAcceptable() || (abstractInterruptibleChannel = this.sch.accept()) == null) continue;
                        list.add(new OioSctpChannel(this, (SctpChannel)abstractInterruptibleChannel));
                        ++n;
                    } while (iterator2.hasNext());
                    return n;
                }
            }
            catch (Throwable throwable) {
                logger.warn("Failed to create a new channel from an accepted sctp channel.", throwable);
                if (abstractInterruptibleChannel == null) break block7;
                try {
                    abstractInterruptibleChannel.close();
                }
                catch (Throwable throwable2) {
                    logger.warn("Failed to close a sctp channel.", throwable2);
                }
            }
        }
        return n;
    }

    @Override
    public ChannelFuture bindAddress(InetAddress inetAddress) {
        return this.bindAddress(inetAddress, this.newPromise());
    }

    @Override
    public ChannelFuture bindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (this.eventLoop().inEventLoop()) {
            try {
                this.sch.bindAddress(inetAddress);
                channelPromise.setSuccess();
            }
            catch (Throwable throwable) {
                channelPromise.setFailure(throwable);
            }
        } else {
            this.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    OioSctpServerChannel.this.bindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override
    public ChannelFuture unbindAddress(InetAddress inetAddress) {
        return this.unbindAddress(inetAddress, this.newPromise());
    }

    @Override
    public ChannelFuture unbindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (this.eventLoop().inEventLoop()) {
            try {
                this.sch.unbindAddress(inetAddress);
                channelPromise.setSuccess();
            }
            catch (Throwable throwable) {
                channelPromise.setFailure(throwable);
            }
        } else {
            this.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    OioSctpServerChannel.this.unbindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object filterOutboundMessage(Object object) throws Exception {
        throw new UnsupportedOperationException();
    }

    private final class OioSctpServerChannelConfig
    extends DefaultSctpServerChannelConfig {
        private OioSctpServerChannelConfig(OioSctpServerChannel oioSctpServerChannel2, com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
            super(oioSctpServerChannel2, sctpServerChannel);
        }

        @Override
        protected void autoReadCleared() {
            OioSctpServerChannel.this.setReadPending(false);
        }
    }
}

