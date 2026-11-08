/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel.sctp.nio;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.nio.AbstractNioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.channel.sctp.SctpServerChannelConfig;
import io.netty.channel.sctp.nio.NioSctpChannel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class NioSctpServerChannel
extends AbstractNioMessageChannel
implements SctpServerChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private final SctpServerChannelConfig config = new NioSctpServerChannelConfig(this, this.javaChannel());

    private static com.sun.nio.sctp.SctpServerChannel newSocket() {
        try {
            return com.sun.nio.sctp.SctpServerChannel.open();
        }
        catch (IOException iOException) {
            throw new ChannelException("Failed to open a server socket.", iOException);
        }
    }

    public NioSctpServerChannel() {
        super(null, NioSctpServerChannel.newSocket(), 16);
    }

    @Override
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override
    public Set<InetSocketAddress> allLocalAddresses() {
        try {
            Set<SocketAddress> set = this.javaChannel().getAllLocalAddresses();
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
    public SctpServerChannelConfig config() {
        return this.config;
    }

    @Override
    public boolean isActive() {
        return this.isOpen() && !this.allLocalAddresses().isEmpty();
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
    protected com.sun.nio.sctp.SctpServerChannel javaChannel() {
        return (com.sun.nio.sctp.SctpServerChannel)super.javaChannel();
    }

    @Override
    protected SocketAddress localAddress0() {
        try {
            Iterator<SocketAddress> iterator2 = this.javaChannel().getAllLocalAddresses().iterator();
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
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.javaChannel().bind(socketAddress, this.config.getBacklog());
    }

    @Override
    protected void doClose() throws Exception {
        this.javaChannel().close();
    }

    @Override
    protected int doReadMessages(List<Object> list) throws Exception {
        SctpChannel sctpChannel = this.javaChannel().accept();
        if (sctpChannel == null) {
            return 0;
        }
        list.add(new NioSctpChannel(this, sctpChannel));
        return 1;
    }

    @Override
    public ChannelFuture bindAddress(InetAddress inetAddress) {
        return this.bindAddress(inetAddress, this.newPromise());
    }

    @Override
    public ChannelFuture bindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (this.eventLoop().inEventLoop()) {
            try {
                this.javaChannel().bindAddress(inetAddress);
                channelPromise.setSuccess();
            }
            catch (Throwable throwable) {
                channelPromise.setFailure(throwable);
            }
        } else {
            this.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    NioSctpServerChannel.this.bindAddress(inetAddress, channelPromise);
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
                this.javaChannel().unbindAddress(inetAddress);
                channelPromise.setSuccess();
            }
            catch (Throwable throwable) {
                channelPromise.setFailure(throwable);
            }
        } else {
            this.eventLoop().execute(new Runnable(){

                @Override
                public void run() {
                    NioSctpServerChannel.this.unbindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override
    protected boolean doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void doFinishConnect() throws Exception {
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
    protected boolean doWriteMessage(Object object, ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override
    protected Object filterOutboundMessage(Object object) throws Exception {
        throw new UnsupportedOperationException();
    }

    private final class NioSctpServerChannelConfig
    extends DefaultSctpServerChannelConfig {
        private NioSctpServerChannelConfig(NioSctpServerChannel nioSctpServerChannel2, com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
            super(nioSctpServerChannel2, sctpServerChannel);
        }

        @Override
        protected void autoReadCleared() {
            NioSctpServerChannel.this.setReadPending(false);
        }
    }
}

