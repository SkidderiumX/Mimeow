/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_1;

import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import java.util.UUID;

public class MessageHeader {
    private final byte[] precedingSignature;
    private final UUID sender;

    public MessageHeader(byte[] byArray, UUID uUID) {
        this.precedingSignature = byArray;
        this.sender = uUID;
    }

    public void update(DataConsumer dataConsumer) {
        if (this.precedingSignature != null) {
            dataConsumer.accept(this.precedingSignature);
        }
        dataConsumer.accept(this.sender);
    }
}

