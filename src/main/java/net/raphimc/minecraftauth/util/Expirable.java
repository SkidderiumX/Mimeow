/*
 * Decompiled with CFR 0.152.
 */
package net.raphimc.minecraftauth.util;

public interface Expirable {
    public long getExpireTimeMs();

    default public boolean isExpired() {
        return this.getExpireTimeMs() <= System.currentTimeMillis();
    }
}

