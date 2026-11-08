/*
 * Decompiled with CFR 0.152.
 */
package io.netty.channel;

public class ChannelMetadata {
    private final boolean hasDisconnect;

    public ChannelMetadata(boolean bl) {
        this.hasDisconnect = bl;
    }

    public boolean hasDisconnect() {
        return this.hasDisconnect;
    }
}

