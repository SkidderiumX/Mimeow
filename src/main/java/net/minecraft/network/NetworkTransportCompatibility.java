/*
 * Decompiled with CFR 0.152.
 */
package net.minecraft.network;

import io.netty.channel.epoll.Epoll;
import io.netty.util.internal.PlatformDependent;

public class NetworkTransportCompatibility {
    private NetworkTransportCompatibility() {
    }

    static boolean shouldUseEpoll(boolean bl) {
        return NetworkTransportCompatibility.shouldUseEpoll(bl, Epoll.isAvailable(), PlatformDependent.directBufferPreferred());
    }

    static boolean shouldUseEpoll(boolean bl, boolean bl2, boolean bl3) {
        return bl && bl2 && bl3;
    }
}

