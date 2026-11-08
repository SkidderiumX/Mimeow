/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.ResolvableProfile;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;
import java.util.UUID;

public class ResolvableProfileType
extends Type<ResolvableProfile> {
    public ResolvableProfileType() {
        super(ResolvableProfile.class);
    }

    @Override
    public ResolvableProfile read(ByteBuf byteBuf) {
        GameProfile gameProfile;
        Object object;
        String string;
        Object object2;
        if (byteBuf.readBoolean()) {
            object2 = (UUID)Types.UUID.read(byteBuf);
            string = (String)Types.STRING.read(byteBuf);
            object = (GameProfile.Property[])Types.PROFILE_PROPERTY_ARRAY.read(byteBuf);
            gameProfile = new GameProfile(string, (UUID)object2, (GameProfile.Property[])object, false);
        } else {
            gameProfile = (GameProfile)Types.GAME_PROFILE.read(byteBuf);
        }
        object2 = (String)Types.OPTIONAL_STRING.read(byteBuf);
        string = (String)Types.OPTIONAL_STRING.read(byteBuf);
        object = (String)Types.OPTIONAL_STRING.read(byteBuf);
        Boolean bl = (Boolean)Types.OPTIONAL_BOOLEAN.read(byteBuf);
        Integer n = bl != null ? Integer.valueOf(bl != false ? 0 : 1) : null;
        return new ResolvableProfile(gameProfile, (String)object2, string, (String)object, n);
    }

    @Override
    public void write(ByteBuf byteBuf, ResolvableProfile resolvableProfile) {
        GameProfile gameProfile = resolvableProfile.profile();
        if (!gameProfile.dynamic()) {
            byteBuf.writeBoolean(true);
            Types.UUID.write(byteBuf, gameProfile.id());
            Types.STRING.write(byteBuf, gameProfile.name());
            Types.PROFILE_PROPERTY_ARRAY.write(byteBuf, gameProfile.properties());
        } else {
            byteBuf.writeBoolean(false);
            Types.GAME_PROFILE.write(byteBuf, gameProfile);
        }
        Types.OPTIONAL_STRING.write(byteBuf, resolvableProfile.bodyTexture());
        Types.OPTIONAL_STRING.write(byteBuf, resolvableProfile.capeTexture());
        Types.OPTIONAL_STRING.write(byteBuf, resolvableProfile.elytraTexture());
        Types.OPTIONAL_BOOLEAN.write(byteBuf, resolvableProfile.modelType() != null ? Boolean.valueOf(resolvableProfile.modelType() == 0) : null);
    }

    @Override
    public void write(Ops ops, ResolvableProfile resolvableProfile) {
        String string = resolvableProfile.modelType() != null ? (resolvableProfile.modelType() == 0 ? "slim" : "wide") : null;
        ops.writeMap(mapSerializer -> mapSerializer.writeInlinedMap(Types.GAME_PROFILE, resolvableProfile.profile()).writeOptional("texture", Types.IDENTIFIER, resolvableProfile.bodyTexture() != null ? Key.of(resolvableProfile.bodyTexture()) : null).writeOptional("cape", Types.IDENTIFIER, resolvableProfile.capeTexture() != null ? Key.of(resolvableProfile.capeTexture()) : null).writeOptional("elytra", Types.IDENTIFIER, resolvableProfile.elytraTexture() != null ? Key.of(resolvableProfile.elytraTexture()) : null).writeOptional("model", Types.OPTIONAL_STRING, string));
    }
}

