/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.storage;

import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_1.MessageBody;
import com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_1.MessageHeader;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession;
import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.util.UUID;

public class ChatSession1_19_1
extends ChatSession {
    private byte[] precedingSignature;

    public ChatSession1_19_1(UUID uUID, PrivateKey privateKey, ProfileKey profileKey) {
        super(uUID, privateKey, profileKey);
    }

    public byte[] signChatMessage(MessageMetadata messageMetadata, DecoratableMessage decoratableMessage, PlayerMessageSignature[] playerMessageSignatureArray) throws SignatureException {
        byte[] byArray = this.sign(dataConsumer -> {
            MessageHeader messageHeader = new MessageHeader(this.precedingSignature, messageMetadata.sender());
            MessageBody messageBody = new MessageBody(decoratableMessage, messageMetadata.timestamp(), messageMetadata.salt(), playerMessageSignatureArray);
            messageHeader.update((DataConsumer)dataConsumer);
            messageBody.update((DataConsumer)dataConsumer);
        });
        this.precedingSignature = byArray;
        return byArray;
    }
}

