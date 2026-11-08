/*
 * Decompiled with CFR 0.152.
 */
package io.netty.bootstrap;

import io.netty.bootstrap.ChannelFactory;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.UniqueName;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.StringUtil;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractBootstrap<B extends AbstractBootstrap<B, C>, C extends Channel>
implements Cloneable {
    private volatile EventLoopGroup group;
    private volatile ChannelFactory<? extends C> channelFactory;
    private volatile SocketAddress localAddress;
    private final Map<ChannelOption<?>, Object> options = new LinkedHashMap();
    private final Map<AttributeKey<?>, Object> attrs = new LinkedHashMap();
    private volatile ChannelHandler handler;

    AbstractBootstrap() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AbstractBootstrap(AbstractBootstrap<B, C> abstractBootstrap) {
        this.group = abstractBootstrap.group;
        this.channelFactory = abstractBootstrap.channelFactory;
        this.handler = abstractBootstrap.handler;
        this.localAddress = abstractBootstrap.localAddress;
        Map<UniqueName, Object> map = abstractBootstrap.options;
        synchronized (map) {
            this.options.putAll(abstractBootstrap.options);
        }
        map = abstractBootstrap.attrs;
        synchronized (map) {
            this.attrs.putAll(abstractBootstrap.attrs);
        }
    }

    public B group(EventLoopGroup eventLoopGroup) {
        if (eventLoopGroup == null) {
            throw new NullPointerException("group");
        }
        if (this.group != null) {
            throw new IllegalStateException("group set already");
        }
        this.group = eventLoopGroup;
        return (B)this;
    }

    public B channel(Class<? extends C> clazz) {
        if (clazz == null) {
            throw new NullPointerException("channelClass");
        }
        return this.channelFactory(new BootstrapChannelFactory<C>(clazz));
    }

    public B channelFactory(ChannelFactory<? extends C> channelFactory) {
        if (channelFactory == null) {
            throw new NullPointerException("channelFactory");
        }
        if (this.channelFactory != null) {
            throw new IllegalStateException("channelFactory set already");
        }
        this.channelFactory = channelFactory;
        return (B)this;
    }

    public B localAddress(SocketAddress socketAddress) {
        this.localAddress = socketAddress;
        return (B)this;
    }

    public B localAddress(int n) {
        return this.localAddress(new InetSocketAddress(n));
    }

    public B localAddress(String string, int n) {
        return this.localAddress(new InetSocketAddress(string, n));
    }

    public B localAddress(InetAddress inetAddress, int n) {
        return this.localAddress(new InetSocketAddress(inetAddress, n));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> B option(ChannelOption<T> channelOption, T t) {
        if (channelOption == null) {
            throw new NullPointerException("option");
        }
        if (t == null) {
            Map<ChannelOption<?>, Object> map = this.options;
            synchronized (map) {
                this.options.remove(channelOption);
            }
        }
        Map<ChannelOption<?>, Object> map = this.options;
        synchronized (map) {
            this.options.put(channelOption, t);
        }
        return (B)this;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> B attr(AttributeKey<T> attributeKey, T t) {
        Object object;
        if (attributeKey == null) {
            throw new NullPointerException("key");
        }
        if (t == null) {
            object = this.attrs;
            synchronized (object) {
                this.attrs.remove(attributeKey);
            }
        }
        object = this.attrs;
        synchronized (object) {
            this.attrs.put(attributeKey, t);
        }
        object = this;
        return (B)object;
    }

    public B validate() {
        if (this.group == null) {
            throw new IllegalStateException("group not set");
        }
        if (this.channelFactory == null) {
            throw new IllegalStateException("channel or channelFactory not set");
        }
        return (B)this;
    }

    public abstract B clone();

    public ChannelFuture register() {
        this.validate();
        return this.initAndRegister();
    }

    public ChannelFuture bind() {
        this.validate();
        SocketAddress socketAddress = this.localAddress;
        if (socketAddress == null) {
            throw new IllegalStateException("localAddress not set");
        }
        return this.doBind(socketAddress);
    }

    public ChannelFuture bind(int n) {
        return this.bind(new InetSocketAddress(n));
    }

    public ChannelFuture bind(String string, int n) {
        return this.bind(new InetSocketAddress(string, n));
    }

    public ChannelFuture bind(InetAddress inetAddress, int n) {
        return this.bind(new InetSocketAddress(inetAddress, n));
    }

    public ChannelFuture bind(SocketAddress socketAddress) {
        this.validate();
        if (socketAddress == null) {
            throw new NullPointerException("localAddress");
        }
        return this.doBind(socketAddress);
    }

    private ChannelFuture doBind(final SocketAddress socketAddress) {
        ChannelPromise channelPromise;
        final ChannelFuture channelFuture = this.initAndRegister();
        final Channel channel = channelFuture.channel();
        if (channelFuture.cause() != null) {
            return channelFuture;
        }
        if (channelFuture.isDone()) {
            channelPromise = channel.newPromise();
            AbstractBootstrap.doBind0(channelFuture, channel, socketAddress, channelPromise);
        } else {
            channelPromise = new PendingRegistrationPromise(channel);
            channelFuture.addListener(new ChannelFutureListener(){

                @Override
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractBootstrap.doBind0(channelFuture, channel, socketAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    final ChannelFuture initAndRegister() {
        C c = this.channelFactory().newChannel();
        try {
            this.init((Channel)c);
        }
        catch (Throwable throwable) {
            c.unsafe().closeForcibly();
            return new DefaultChannelPromise((Channel)c, GlobalEventExecutor.INSTANCE).setFailure(throwable);
        }
        ChannelFuture channelFuture = this.group().register((Channel)c);
        if (channelFuture.cause() != null) {
            if (c.isRegistered()) {
                c.close();
            } else {
                c.unsafe().closeForcibly();
            }
        }
        return channelFuture;
    }

    abstract void init(Channel var1) throws Exception;

    private static void doBind0(final ChannelFuture channelFuture, final Channel channel, final SocketAddress socketAddress, final ChannelPromise channelPromise) {
        channel.eventLoop().execute(new Runnable(){

            @Override
            public void run() {
                if (channelFuture.isSuccess()) {
                    channel.bind(socketAddress, channelPromise).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                } else {
                    channelPromise.setFailure(channelFuture.cause());
                }
            }
        });
    }

    public B handler(ChannelHandler channelHandler) {
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        }
        this.handler = channelHandler;
        return (B)this;
    }

    final SocketAddress localAddress() {
        return this.localAddress;
    }

    final ChannelFactory<? extends C> channelFactory() {
        return this.channelFactory;
    }

    final ChannelHandler handler() {
        return this.handler;
    }

    public final EventLoopGroup group() {
        return this.group;
    }

    final Map<ChannelOption<?>, Object> options() {
        return this.options;
    }

    final Map<AttributeKey<?>, Object> attrs() {
        return this.attrs;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(StringUtil.simpleClassName(this));
        stringBuilder.append('(');
        if (this.group != null) {
            stringBuilder.append("group: ");
            stringBuilder.append(StringUtil.simpleClassName(this.group));
            stringBuilder.append(", ");
        }
        if (this.channelFactory != null) {
            stringBuilder.append("channelFactory: ");
            stringBuilder.append(this.channelFactory);
            stringBuilder.append(", ");
        }
        if (this.localAddress != null) {
            stringBuilder.append("localAddress: ");
            stringBuilder.append(this.localAddress);
            stringBuilder.append(", ");
        }
        Map<UniqueName, Object> map = this.options;
        synchronized (map) {
            if (!this.options.isEmpty()) {
                stringBuilder.append("options: ");
                stringBuilder.append(this.options);
                stringBuilder.append(", ");
            }
        }
        map = this.attrs;
        synchronized (map) {
            if (!this.attrs.isEmpty()) {
                stringBuilder.append("attrs: ");
                stringBuilder.append(this.attrs);
                stringBuilder.append(", ");
            }
        }
        if (this.handler != null) {
            stringBuilder.append("handler: ");
            stringBuilder.append(this.handler);
            stringBuilder.append(", ");
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == '(') {
            stringBuilder.append(')');
        } else {
            stringBuilder.setCharAt(stringBuilder.length() - 2, ')');
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static final class PendingRegistrationPromise
    extends DefaultChannelPromise {
        private PendingRegistrationPromise(Channel channel) {
            super(channel);
        }

        @Override
        protected EventExecutor executor() {
            if (this.channel().isRegistered()) {
                return super.executor();
            }
            return GlobalEventExecutor.INSTANCE;
        }
    }

    private static final class BootstrapChannelFactory<T extends Channel>
    implements ChannelFactory<T> {
        private final Class<? extends T> clazz;

        BootstrapChannelFactory(Class<? extends T> clazz) {
            this.clazz = clazz;
        }

        @Override
        public T newChannel() {
            try {
                return (T)((Channel)this.clazz.newInstance());
            }
            catch (Throwable throwable) {
                throw new ChannelException("Unable to create Channel from class " + this.clazz, throwable);
            }
        }

        public String toString() {
            return StringUtil.simpleClassName(this.clazz) + ".class";
        }
    }
}

