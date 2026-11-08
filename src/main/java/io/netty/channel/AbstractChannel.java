package io.netty.channel;

import java.nio.channels.*;
import io.netty.buffer.*;
import io.netty.util.internal.logging.*;
import io.netty.util.concurrent.*;
import io.netty.util.internal.*;
import java.net.*;
import io.netty.util.*;
import java.io.*;
import java.util.concurrent.*;

public abstract class AbstractChannel extends DefaultAttributeMap implements Channel
{
    private static final InternalLogger logger;
    static final ClosedChannelException CLOSED_CHANNEL_EXCEPTION;
    static final NotYetConnectedException NOT_YET_CONNECTED_EXCEPTION;
    private MessageSizeEstimator.Handle estimatorHandle;
    private final Channel parent;
    private final long hashCode;
    private final Unsafe unsafe;
    private final DefaultChannelPipeline pipeline;
    private final ChannelFuture succeededFuture;
    private final VoidChannelPromise voidPromise;
    private final VoidChannelPromise unsafeVoidPromise;
    private final CloseFuture closeFuture;
    private volatile SocketAddress localAddress;
    private volatile SocketAddress remoteAddress;
    private volatile EventLoop eventLoop;
    private volatile boolean registered;
    private boolean strValActive;
    private String strVal;
    
    protected AbstractChannel(final Channel parent) {
        this.hashCode = ThreadLocalRandom.current().nextLong();
        this.succeededFuture = new SucceededChannelFuture(this, null);
        this.voidPromise = new VoidChannelPromise(this, true);
        this.unsafeVoidPromise = new VoidChannelPromise(this, false);
        this.closeFuture = new CloseFuture(this);
        this.parent = parent;
        this.unsafe = this.newUnsafe();
        this.pipeline = new DefaultChannelPipeline(this);
    }
    
    @Override
    public boolean isWritable() {
        final ChannelOutboundBuffer outboundBuffer = this.unsafe.outboundBuffer();
        return outboundBuffer != null && outboundBuffer.isWritable();
    }
    
    @Override
    public Channel parent() {
        return this.parent;
    }
    
    @Override
    public ChannelPipeline pipeline() {
        return this.pipeline;
    }
    
    @Override
    public ByteBufAllocator alloc() {
        return this.config().getAllocator();
    }
    
    @Override
    public EventLoop eventLoop() {
        final EventLoop eventLoop = this.eventLoop;
        if (eventLoop == null) {
            throw new IllegalStateException("channel not registered to an event loop");
        }
        return eventLoop;
    }
    
    @Override
    public SocketAddress localAddress() {
        SocketAddress localAddress = this.localAddress;
        if (localAddress == null) {
            try {
                localAddress = (this.localAddress = this.unsafe().localAddress());
            }
            catch (final Throwable t) {
                return null;
            }
        }
        return localAddress;
    }
    
    protected void invalidateLocalAddress() {
        this.localAddress = null;
    }
    
    @Override
    public SocketAddress remoteAddress() {
        SocketAddress remoteAddress = this.remoteAddress;
        if (remoteAddress == null) {
            try {
                remoteAddress = (this.remoteAddress = this.unsafe().remoteAddress());
            }
            catch (final Throwable t) {
                return null;
            }
        }
        return remoteAddress;
    }
    
    protected void invalidateRemoteAddress() {
        this.remoteAddress = null;
    }
    
    @Override
    public boolean isRegistered() {
        return this.registered;
    }
    
    @Override
    public ChannelFuture bind(final SocketAddress socketAddress) {
        return this.pipeline.bind(socketAddress);
    }
    
    @Override
    public ChannelFuture connect(final SocketAddress socketAddress) {
        return this.pipeline.connect(socketAddress);
    }
    
    @Override
    public ChannelFuture connect(final SocketAddress socketAddress, final SocketAddress socketAddress2) {
        return this.pipeline.connect(socketAddress, socketAddress2);
    }
    
    @Override
    public ChannelFuture disconnect() {
        return this.pipeline.disconnect();
    }
    
    @Override
    public ChannelFuture close() {
        return this.pipeline.close();
    }
    
    @Override
    public ChannelFuture deregister() {
        return this.pipeline.deregister();
    }
    
    @Override
    public Channel flush() {
        this.pipeline.flush();
        return this;
    }
    
    @Override
    public ChannelFuture bind(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        return this.pipeline.bind(socketAddress, channelPromise);
    }
    
    @Override
    public ChannelFuture connect(final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, channelPromise);
    }
    
    @Override
    public ChannelFuture connect(final SocketAddress socketAddress, final SocketAddress socketAddress2, final ChannelPromise channelPromise) {
        return this.pipeline.connect(socketAddress, socketAddress2, channelPromise);
    }
    
    @Override
    public ChannelFuture disconnect(final ChannelPromise channelPromise) {
        return this.pipeline.disconnect(channelPromise);
    }
    
    @Override
    public ChannelFuture close(final ChannelPromise channelPromise) {
        return this.pipeline.close(channelPromise);
    }
    
    @Override
    public ChannelFuture deregister(final ChannelPromise channelPromise) {
        return this.pipeline.deregister(channelPromise);
    }
    
    @Override
    public Channel read() {
        this.pipeline.read();
        return this;
    }
    
    @Override
    public ChannelFuture write(final Object o) {
        return this.pipeline.write(o);
    }
    
    @Override
    public ChannelFuture write(final Object o, final ChannelPromise channelPromise) {
        return this.pipeline.write(o, channelPromise);
    }
    
    @Override
    public ChannelFuture writeAndFlush(final Object o) {
        return this.pipeline.writeAndFlush(o);
    }
    
    @Override
    public ChannelFuture writeAndFlush(final Object o, final ChannelPromise channelPromise) {
        return this.pipeline.writeAndFlush(o, channelPromise);
    }
    
    @Override
    public ChannelPromise newPromise() {
        return new DefaultChannelPromise(this);
    }
    
    @Override
    public ChannelProgressivePromise newProgressivePromise() {
        return new DefaultChannelProgressivePromise(this);
    }
    
    @Override
    public ChannelFuture newSucceededFuture() {
        return this.succeededFuture;
    }
    
    @Override
    public ChannelFuture newFailedFuture(final Throwable t) {
        return new FailedChannelFuture(this, null, t);
    }
    
    @Override
    public ChannelFuture closeFuture() {
        return this.closeFuture;
    }
    
    @Override
    public Unsafe unsafe() {
        return this.unsafe;
    }
    
    protected abstract AbstractUnsafe newUnsafe();
    
    @Override
    public final int hashCode() {
        return (int)this.hashCode;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return this == o;
    }
    
    @Override
    public final int compareTo(final Channel channel) {
        if (this == channel) {
            return 0;
        }
        final long n = this.hashCode - channel.hashCode();
        if (n > 0L) {
            return 1;
        }
        if (n < 0L) {
            return -1;
        }
        final long n2 = System.identityHashCode(this) - System.identityHashCode(channel);
        if (n2 != 0L) {
            return (int)n2;
        }
        throw new Error();
    }
    
    @Override
    public String toString() {
        final boolean active = this.isActive();
        if (this.strValActive == active && this.strVal != null) {
            return this.strVal;
        }
        final SocketAddress remoteAddress = this.remoteAddress();
        final SocketAddress localAddress = this.localAddress();
        if (remoteAddress != null) {
            SocketAddress socketAddress;
            SocketAddress socketAddress2;
            if (this.parent == null) {
                socketAddress = localAddress;
                socketAddress2 = remoteAddress;
            }
            else {
                socketAddress = remoteAddress;
                socketAddress2 = localAddress;
            }
            this.strVal = String.format("[id: 0x%08x, %s %s %s]", (int)this.hashCode, socketAddress, active ? "=>" : ":>", socketAddress2);
        }
        else if (localAddress != null) {
            this.strVal = String.format("[id: 0x%08x, %s]", (int)this.hashCode, localAddress);
        }
        else {
            this.strVal = String.format("[id: 0x%08x]", (int)this.hashCode);
        }
        this.strValActive = active;
        return this.strVal;
    }
    
    @Override
    public final ChannelPromise voidPromise() {
        return this.voidPromise;
    }
    
    final MessageSizeEstimator.Handle estimatorHandle() {
        if (this.estimatorHandle == null) {
            this.estimatorHandle = this.config().getMessageSizeEstimator().newHandle();
        }
        return this.estimatorHandle;
    }
    
    protected abstract boolean isCompatible(final EventLoop p0);
    
    protected abstract SocketAddress localAddress0();
    
    protected abstract SocketAddress remoteAddress0();
    
    protected void doRegister() throws Exception {
    }
    
    protected abstract void doBind(final SocketAddress p0) throws Exception;
    
    protected abstract void doDisconnect() throws Exception;
    
    protected abstract void doClose() throws Exception;
    
    protected void doDeregister() throws Exception {
    }
    
    protected abstract void doBeginRead() throws Exception;
    
    protected abstract void doWrite(final ChannelOutboundBuffer p0) throws Exception;
    
    protected Object filterOutboundMessage(final Object o) throws Exception {
        return o;
    }
    
    static {
        logger = InternalLoggerFactory.getInstance(AbstractChannel.class);
        CLOSED_CHANNEL_EXCEPTION = new ClosedChannelException();
        NOT_YET_CONNECTED_EXCEPTION = new NotYetConnectedException();
        AbstractChannel.CLOSED_CHANNEL_EXCEPTION.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
        AbstractChannel.NOT_YET_CONNECTED_EXCEPTION.setStackTrace(EmptyArrays.EMPTY_STACK_TRACE);
    }
    
    static final class CloseFuture extends DefaultChannelPromise
    {
        CloseFuture(final AbstractChannel abstractChannel) {
            super(abstractChannel);
        }
        
        @Override
        public ChannelPromise setSuccess() {
            throw new IllegalStateException();
        }
        
        @Override
        public ChannelPromise setFailure(final Throwable t) {
            throw new IllegalStateException();
        }
        
        @Override
        public boolean trySuccess() {
            throw new IllegalStateException();
        }
        
        @Override
        public boolean tryFailure(final Throwable t) {
            throw new IllegalStateException();
        }
        
        boolean setClosed() {
            return super.trySuccess();
        }
    }
    
    protected abstract class AbstractUnsafe implements Unsafe
    {
        private ChannelOutboundBuffer outboundBuffer;
        private boolean inFlush0;
        
        protected AbstractUnsafe() {
            this.outboundBuffer = new ChannelOutboundBuffer(AbstractChannel.this);
        }
        
        @Override
        public final ChannelOutboundBuffer outboundBuffer() {
            return this.outboundBuffer;
        }
        
        @Override
        public final SocketAddress localAddress() {
            return AbstractChannel.this.localAddress0();
        }
        
        @Override
        public final SocketAddress remoteAddress() {
            return AbstractChannel.this.remoteAddress0();
        }
        
        @Override
        public final void register(final EventLoop eventLoop, final ChannelPromise channelPromise) {
            if (eventLoop == null) {
                throw new NullPointerException("eventLoop");
            }
            if (AbstractChannel.this.isRegistered()) {
                channelPromise.setFailure((Throwable)new IllegalStateException("registered to an event loop already"));
                return;
            }
            if (!AbstractChannel.this.isCompatible(eventLoop)) {
                channelPromise.setFailure((Throwable)new IllegalStateException("incompatible event loop type: " + eventLoop.getClass().getName()));
                return;
            }
            AbstractChannel.this.eventLoop = eventLoop;
            if (eventLoop.inEventLoop()) {
                this.register0(channelPromise);
            }
            else {
                try {
                    eventLoop.execute(new OneTimeTask() {
                        @Override
                        public void run() {
                            AbstractUnsafe.this.register0(channelPromise);
                        }
                    });
                }
                catch (final Throwable t) {
                    AbstractChannel.logger.warn("Force-closing a channel whose registration task was not accepted by an event loop: {}", AbstractChannel.this, t);
                    this.closeForcibly();
                    AbstractChannel.this.closeFuture.setClosed();
                    this.safeSetFailure(channelPromise, t);
                }
            }
        }
        
        private void register0(final ChannelPromise channelPromise) {
            try {
                if (!channelPromise.setUncancellable() || !this.ensureOpen(channelPromise)) {
                    return;
                }
                AbstractChannel.this.doRegister();
                AbstractChannel.this.registered = true;
                this.safeSetSuccess(channelPromise);
                AbstractChannel.this.pipeline.fireChannelRegistered();
                if (AbstractChannel.this.isActive()) {
                    AbstractChannel.this.pipeline.fireChannelActive();
                }
            }
            catch (final Throwable t) {
                this.closeForcibly();
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetFailure(channelPromise, t);
            }
        }
        
        @Override
        public final void bind(final SocketAddress obj, final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable() || !this.ensureOpen(channelPromise)) {
                return;
            }
            if (!PlatformDependent.isWindows() && !PlatformDependent.isRoot() && Boolean.TRUE.equals(AbstractChannel.this.config().getOption(ChannelOption.SO_BROADCAST)) && obj instanceof InetSocketAddress && !((InetSocketAddress)obj).getAddress().isAnyLocalAddress()) {
                AbstractChannel.logger.warn("A non-root user can't receive a broadcast packet if the socket is not bound to a wildcard address; binding to a non-wildcard address (" + obj + ") anyway as requested.");
            }
            final boolean active = AbstractChannel.this.isActive();
            try {
                AbstractChannel.this.doBind(obj);
            }
            catch (final Throwable t) {
                this.safeSetFailure(channelPromise, t);
                this.closeIfClosed();
                return;
            }
            if (!active && AbstractChannel.this.isActive()) {
                this.invokeLater(new OneTimeTask() {
                    @Override
                    public void run() {
                        AbstractChannel.this.pipeline.fireChannelActive();
                    }
                });
            }
            this.safeSetSuccess(channelPromise);
        }
        
        @Override
        public final void disconnect(final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            final boolean active = AbstractChannel.this.isActive();
            try {
                AbstractChannel.this.doDisconnect();
            }
            catch (final Throwable t) {
                this.safeSetFailure(channelPromise, t);
                this.closeIfClosed();
                return;
            }
            if (active && !AbstractChannel.this.isActive()) {
                this.invokeLater(new OneTimeTask() {
                    @Override
                    public void run() {
                        AbstractChannel.this.pipeline.fireChannelInactive();
                    }
                });
            }
            this.safeSetSuccess(channelPromise);
            this.closeIfClosed();
        }
        
        @Override
        public final void close(final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (this.inFlush0) {
                this.invokeLater(new OneTimeTask() {
                    @Override
                    public void run() {
                        AbstractUnsafe.this.close(channelPromise);
                    }
                });
                return;
            }
            if (AbstractChannel.this.closeFuture.isDone()) {
                this.safeSetSuccess(channelPromise);
                return;
            }
            final boolean active = AbstractChannel.this.isActive();
            final ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            this.outboundBuffer = null;
            try {
                AbstractChannel.this.doClose();
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetSuccess(channelPromise);
            }
            catch (final Throwable t) {
                AbstractChannel.this.closeFuture.setClosed();
                this.safeSetFailure(channelPromise, t);
            }
            try {
                outboundBuffer.failFlushed(AbstractChannel.CLOSED_CHANNEL_EXCEPTION);
                outboundBuffer.close(AbstractChannel.CLOSED_CHANNEL_EXCEPTION);
            }
            finally {
                if (active && !AbstractChannel.this.isActive()) {
                    this.invokeLater(new OneTimeTask() {
                        @Override
                        public void run() {
                            AbstractChannel.this.pipeline.fireChannelInactive();
                        }
                    });
                }
                this.deregister(this.voidPromise());
            }
        }
        
        @Override
        public final void closeForcibly() {
            try {
                AbstractChannel.this.doClose();
            }
            catch (final Exception ex) {
                AbstractChannel.logger.warn("Failed to close a channel.", ex);
            }
        }
        
        @Override
        public final void deregister(final ChannelPromise channelPromise) {
            if (!channelPromise.setUncancellable()) {
                return;
            }
            if (!AbstractChannel.this.registered) {
                this.safeSetSuccess(channelPromise);
                return;
            }
            try {
                AbstractChannel.this.doDeregister();
            }
            catch (final Throwable t) {
                AbstractChannel.logger.warn("Unexpected exception occurred while deregistering a channel.", t);
            }
            finally {
                if (AbstractChannel.this.registered) {
                    AbstractChannel.this.registered = false;
                    this.invokeLater(new OneTimeTask() {
                        @Override
                        public void run() {
                            AbstractChannel.this.pipeline.fireChannelUnregistered();
                        }
                    });
                    this.safeSetSuccess(channelPromise);
                }
                else {
                    this.safeSetSuccess(channelPromise);
                }
            }
        }
        
        @Override
        public final void beginRead() {
            if (!AbstractChannel.this.isActive()) {
                return;
            }
            try {
                AbstractChannel.this.doBeginRead();
            }
            catch (final Exception ex) {
                this.invokeLater(new OneTimeTask() {
                    @Override
                    public void run() {
                        AbstractChannel.this.pipeline.fireExceptionCaught(ex);
                    }
                });
                this.close(this.voidPromise());
            }
        }
        
        @Override
        public final void write(Object filterOutboundMessage, final ChannelPromise channelPromise) {
            final ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            if (outboundBuffer == null) {
                this.safeSetFailure(channelPromise, AbstractChannel.CLOSED_CHANNEL_EXCEPTION);
                ReferenceCountUtil.release(filterOutboundMessage);
                return;
            }
            int size;
            try {
                filterOutboundMessage = AbstractChannel.this.filterOutboundMessage(filterOutboundMessage);
                size = AbstractChannel.this.estimatorHandle().size(filterOutboundMessage);
                if (size < 0) {
                    size = 0;
                }
            }
            catch (final Throwable t) {
                this.safeSetFailure(channelPromise, t);
                ReferenceCountUtil.release(filterOutboundMessage);
                return;
            }
            outboundBuffer.addMessage(filterOutboundMessage, size, channelPromise);
        }
        
        @Override
        public final void flush() {
            final ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            if (outboundBuffer == null) {
                return;
            }
            outboundBuffer.addFlush();
            this.flush0();
        }
        
        protected void flush0() {
            if (this.inFlush0) {
                return;
            }
            final ChannelOutboundBuffer outboundBuffer = this.outboundBuffer;
            if (outboundBuffer == null || outboundBuffer.isEmpty()) {
                return;
            }
            this.inFlush0 = true;
            if (!AbstractChannel.this.isActive()) {
                try {
                    if (AbstractChannel.this.isOpen()) {
                        outboundBuffer.failFlushed(AbstractChannel.NOT_YET_CONNECTED_EXCEPTION);
                    }
                    else {
                        outboundBuffer.failFlushed(AbstractChannel.CLOSED_CHANNEL_EXCEPTION);
                    }
                }
                finally {
                    this.inFlush0 = false;
                }
                return;
            }
            try {
                AbstractChannel.this.doWrite(outboundBuffer);
            }
            catch (final Throwable t) {
                outboundBuffer.failFlushed(t);
                if (t instanceof IOException && AbstractChannel.this.config().isAutoClose()) {
                    this.close(this.voidPromise());
                }
            }
            finally {
                this.inFlush0 = false;
            }
        }
        
        @Override
        public final ChannelPromise voidPromise() {
            return AbstractChannel.this.unsafeVoidPromise;
        }
        
        protected final boolean ensureOpen(final ChannelPromise channelPromise) {
            if (AbstractChannel.this.isOpen()) {
                return true;
            }
            this.safeSetFailure(channelPromise, AbstractChannel.CLOSED_CHANNEL_EXCEPTION);
            return false;
        }
        
        protected final void safeSetSuccess(final ChannelPromise channelPromise) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.trySuccess()) {
                AbstractChannel.logger.warn("Failed to mark a promise as success because it is done already: {}", channelPromise);
            }
        }
        
        protected final void safeSetFailure(final ChannelPromise channelPromise, final Throwable t) {
            if (!(channelPromise instanceof VoidChannelPromise) && !channelPromise.tryFailure(t)) {
                AbstractChannel.logger.warn("Failed to mark a promise as failure because it's done already: {}", channelPromise, t);
            }
        }
        
        protected final void closeIfClosed() {
            if (AbstractChannel.this.isOpen()) {
                return;
            }
            this.close(this.voidPromise());
        }
        
        private void invokeLater(final Runnable runnable) {
            try {
                AbstractChannel.this.eventLoop().execute(runnable);
            }
            catch (final RejectedExecutionException ex) {
                AbstractChannel.logger.warn("Can't invoke task later as EventLoop rejected it", ex);
            }
        }
    }
}
