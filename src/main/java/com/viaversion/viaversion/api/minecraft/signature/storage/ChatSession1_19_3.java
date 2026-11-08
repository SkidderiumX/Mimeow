/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.storage;

import com.google.common.primitives.Ints;
import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_3.MessageBody;
import com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_3.MessageLink;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession;
import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.util.UUID;

public class ChatSession1_19_3
extends ChatSession {
    private final UUID sessionId = UUID.randomUUID();
    private MessageLink link;

    public ChatSession1_19_3(UUID uUID, PrivateKey privateKey, ProfileKey profileKey) {
        super(uUID, privateKey, profileKey);
        this.link = new MessageLink(uUID, this.sessionId);
    }

    public byte[] signChatMessage(MessageMetadata messageMetadata, String string, PlayerMessageSignature[] playerMessageSignatureArray) throws SignatureException {
        return this.sign(dataConsumer -> {
            MessageLink messageLink = this.nextLink();
            MessageBody messageBody = new MessageBody(string, messageMetadata.timestamp(), messageMetadata.salt(), playerMessageSignatureArray);
            dataConsumer.accept(Ints.toByteArray(1));
            messageLink.update((DataConsumer)dataConsumer);
            messageBody.update((DataConsumer)dataConsumer);
        });
    }

    private MessageLink nextLink() {
        MessageLink messageLink = this.link;
        if (messageLink != null) {
            this.link = messageLink.next();
        }
        return messageLink;
    }

    public UUID getSessionId() {
        return this.sessionId;
    }
}

