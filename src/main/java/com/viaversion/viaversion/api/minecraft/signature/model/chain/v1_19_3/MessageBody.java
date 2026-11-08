/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_3;

import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

public class MessageBody {
    private final String content;
    private final Instant timestamp;
    private final long salt;
    private final PlayerMessageSignature[] lastSeenMessages;

    public MessageBody(String string, Instant instant, long l, PlayerMessageSignature[] playerMessageSignatureArray) {
        this.content = string;
        this.timestamp = instant;
        this.salt = l;
        this.lastSeenMessages = playerMessageSignatureArray;
    }

    public void update(DataConsumer dataConsumer) {
        dataConsumer.accept(Longs.toByteArray(this.salt));
        dataConsumer.accept(Longs.toByteArray(this.timestamp.getEpochSecond()));
        byte[] byArray = this.content.getBytes(StandardCharsets.UTF_8);
        dataConsumer.accept(Ints.toByteArray(byArray.length));
        dataConsumer.accept(byArray);
        dataConsumer.accept(Ints.toByteArray(this.lastSeenMessages.length));
        for (PlayerMessageSignature playerMessageSignature : this.lastSeenMessages) {
            dataConsumer.accept(playerMessageSignature.signatureBytes());
        }
    }
}

