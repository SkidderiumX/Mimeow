/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.storage;

import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.model.MessageMetadata;
import com.viaversion.viaversion.api.minecraft.signature.storage.ChatSession;
import com.viaversion.viaversion.util.GsonUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.util.UUID;

public class ChatSession1_19_0
extends ChatSession {
    public ChatSession1_19_0(UUID uUID, PrivateKey privateKey, ProfileKey profileKey) {
        super(uUID, privateKey, profileKey);
    }

    public byte[] signChatMessage(MessageMetadata messageMetadata, DecoratableMessage decoratableMessage) throws SignatureException {
        return this.sign(dataConsumer -> {
            byte[] byArray = new byte[32];
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray).order(ByteOrder.BIG_ENDIAN);
            byteBuffer.putLong(messageMetadata.salt());
            byteBuffer.putLong(messageMetadata.sender().getMostSignificantBits()).putLong(messageMetadata.sender().getLeastSignificantBits());
            byteBuffer.putLong(messageMetadata.timestamp().getEpochSecond());
            dataConsumer.accept(byArray);
            dataConsumer.accept(GsonUtil.sort(decoratableMessage.decorated()).toString().getBytes(StandardCharsets.UTF_8));
        });
    }
}

