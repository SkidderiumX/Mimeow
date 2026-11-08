/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.model.chain.v1_19_1;

import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.minecraft.signature.model.DecoratableMessage;
import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import com.viaversion.viaversion.util.GsonUtil;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class MessageBody {
    private static final byte HASH_SEPARATOR_BYTE = 70;
    private final DecoratableMessage content;
    private final Instant timestamp;
    private final long salt;
    private final PlayerMessageSignature[] lastSeenMessages;

    public MessageBody(DecoratableMessage decoratableMessage, Instant instant, long l, PlayerMessageSignature[] playerMessageSignatureArray) {
        this.content = decoratableMessage;
        this.timestamp = instant;
        this.salt = l;
        this.lastSeenMessages = playerMessageSignatureArray;
    }

    public void update(DataConsumer dataConsumer) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(this.salt);
            dataOutputStream.writeLong(this.timestamp.getEpochSecond());
            dataOutputStream.write(this.content.plain().getBytes(StandardCharsets.UTF_8));
            dataOutputStream.write(70);
            if (this.content.isDecorated()) {
                dataOutputStream.write(GsonUtil.sort(this.content.decorated()).toString().getBytes(StandardCharsets.UTF_8));
            }
            for (PlayerMessageSignature playerMessageSignature : this.lastSeenMessages) {
                dataOutputStream.writeByte(70);
                dataOutputStream.writeLong(playerMessageSignature.uuid().getMostSignificantBits());
                dataOutputStream.writeLong(playerMessageSignature.uuid().getLeastSignificantBits());
                dataOutputStream.write(playerMessageSignature.signatureBytes());
            }
            messageDigest.update(byteArrayOutputStream.toByteArray());
            dataConsumer.accept(messageDigest.digest());
        }
        catch (IOException | NoSuchAlgorithmException exception) {
            throw new RuntimeException(exception);
        }
    }
}

