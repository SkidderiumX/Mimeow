/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.PlayerMessageSignature;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.UUID;

public class PlayerMessageSignatureType
extends Type<PlayerMessageSignature> {
    public PlayerMessageSignatureType() {
        super(PlayerMessageSignature.class);
    }

    @Override
    public PlayerMessageSignature read(ByteBuf byteBuf) {
        return new PlayerMessageSignature((UUID)Types.UUID.read(byteBuf), (byte[])Types.BYTE_ARRAY_PRIMITIVE.read(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, PlayerMessageSignature playerMessageSignature) {
        Types.UUID.write(byteBuf, playerMessageSignature.uuid());
        Types.BYTE_ARRAY_PRIMITIVE.write(byteBuf, playerMessageSignature.signatureBytes());
    }

    public static final class OptionalPlayerMessageSignatureType
    extends OptionalType<PlayerMessageSignature> {
        public OptionalPlayerMessageSignatureType() {
            super(Types.PLAYER_MESSAGE_SIGNATURE);
        }
    }
}

