/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.signature.storage;

import com.viaversion.viaversion.api.connection.StorableObject;
import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.minecraft.signature.util.DataConsumer;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;

public class ChatSession
implements StorableObject {
    private final UUID uuid;
    private final PrivateKey privateKey;
    private final ProfileKey profileKey;
    private final Signature signer;

    public ChatSession(UUID uUID, PrivateKey privateKey, ProfileKey profileKey) {
        Objects.requireNonNull(uUID, "uuid");
        Objects.requireNonNull(privateKey, "privateKey");
        Objects.requireNonNull(profileKey, "profileKey");
        this.uuid = uUID;
        this.privateKey = privateKey;
        this.profileKey = profileKey;
        try {
            this.signer = Signature.getInstance("SHA256withRSA");
            this.signer.initSign(this.privateKey);
        }
        catch (Throwable throwable) {
            throw new RuntimeException("Failed to initialize signature", throwable);
        }
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public ProfileKey getProfileKey() {
        return this.profileKey;
    }

    public byte[] sign(Consumer<DataConsumer> consumer) throws SignatureException {
        consumer.accept(byArray -> {
            try {
                this.signer.update((byte[])byArray);
            }
            catch (SignatureException signatureException) {
                throw new RuntimeException(signatureException);
            }
        });
        return this.signer.sign();
    }
}

