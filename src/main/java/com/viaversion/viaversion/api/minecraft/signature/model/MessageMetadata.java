/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.model;

import java.time.Instant;
import java.util.UUID;

public class MessageMetadata {
    private final UUID sender;
    private final Instant timestamp;
    private final long salt;

    public MessageMetadata(UUID uUID, Instant instant, long l) {
        this.sender = uUID;
        this.timestamp = instant;
        this.salt = l;
    }

    public MessageMetadata(UUID uUID, long l, long l2) {
        this(uUID, Instant.ofEpochMilli(l), l2);
    }

    public UUID sender() {
        return this.sender;
    }

    public Instant timestamp() {
        return this.timestamp;
    }

    public long salt() {
        return this.salt;
    }
}

