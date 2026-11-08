/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelPromise;
import java.util.LinkedHashSet;
import java.util.Set;

public class ChannelPromiseAggregator
implements ChannelFutureListener {
    private final ChannelPromise aggregatePromise;
    private Set<ChannelPromise> pendingPromises;

    public ChannelPromiseAggregator(ChannelPromise channelPromise) {
        if (channelPromise == null) {
            throw new NullPointerException("aggregatePromise");
        }
        this.aggregatePromise = channelPromise;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ChannelPromiseAggregator add(ChannelPromise ... channelPromiseArray) {
        if (channelPromiseArray == null) {
            throw new NullPointerException("promises");
        }
        if (channelPromiseArray.length == 0) {
            return this;
        }
        ChannelPromiseAggregator channelPromiseAggregator = this;
        synchronized (channelPromiseAggregator) {
            if (this.pendingPromises == null) {
                int n = channelPromiseArray.length > 1 ? channelPromiseArray.length : 2;
                this.pendingPromises = new LinkedHashSet<ChannelPromise>(n);
            }
            for (ChannelPromise channelPromise : channelPromiseArray) {
                if (channelPromise == null) continue;
                this.pendingPromises.add(channelPromise);
                channelPromise.addListener(this);
            }
        }
        return this;
    }

    @Override
    public synchronized void operationComplete(ChannelFuture channelFuture) throws Exception {
        if (this.pendingPromises == null) {
            this.aggregatePromise.setSuccess();
        } else {
            this.pendingPromises.remove(channelFuture);
            if (!channelFuture.isSuccess()) {
                this.aggregatePromise.setFailure(channelFuture.cause());
                for (ChannelPromise channelPromise : this.pendingPromises) {
                    channelPromise.setFailure(channelFuture.cause());
                }
            } else if (this.pendingPromises.isEmpty()) {
                this.aggregatePromise.setSuccess();
            }
        }
    }
}

