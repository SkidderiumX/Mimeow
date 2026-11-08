/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.ProfileKey;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class ProfileKeyType
extends Type<ProfileKey> {
    public ProfileKeyType() {
        super(ProfileKey.class);
    }

    @Override
    public ProfileKey read(ByteBuf byteBuf) {
        return new ProfileKey(byteBuf.readLong(), (byte[])Types.BYTE_ARRAY_PRIMITIVE.read(byteBuf), (byte[])Types.BYTE_ARRAY_PRIMITIVE.read(byteBuf));
    }

    @Override
    public void write(ByteBuf byteBuf, ProfileKey profileKey) {
        byteBuf.writeLong(profileKey.expiresAt());
        Types.BYTE_ARRAY_PRIMITIVE.write(byteBuf, profileKey.publicKey());
        Types.BYTE_ARRAY_PRIMITIVE.write(byteBuf, profileKey.keySignature());
    }

    public static final class OptionalProfileKeyType
    extends OptionalType<ProfileKey> {
        public OptionalProfileKeyType() {
            super(Types.PROFILE_KEY);
        }
    }
}

