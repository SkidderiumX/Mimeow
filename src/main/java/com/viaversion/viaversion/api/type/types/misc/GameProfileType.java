/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;
import java.util.UUID;

public class GameProfileType
extends Type<GameProfile> {
    private static final GameProfile.Property[] EMPTY_PROPERTIES = new GameProfile.Property[0];

    public GameProfileType() {
        super(GameProfile.class);
    }

    @Override
    public GameProfile read(ByteBuf byteBuf) {
        String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
        UUID uUID = (UUID)Types.OPTIONAL_UUID.read(byteBuf);
        GameProfile.Property[] propertyArray = (GameProfile.Property[])Types.PROFILE_PROPERTY_ARRAY.read(byteBuf);
        return new GameProfile(string, uUID, propertyArray);
    }

    @Override
    public void write(ByteBuf byteBuf, GameProfile gameProfile) {
        Types.OPTIONAL_STRING.write(byteBuf, gameProfile.name());
        Types.OPTIONAL_UUID.write(byteBuf, gameProfile.id());
        Types.PROFILE_PROPERTY_ARRAY.write(byteBuf, gameProfile.properties());
    }

    @Override
    public void write(Ops ops, GameProfile gameProfile) {
        ops.writeMap(mapSerializer -> mapSerializer.writeOptional("name", Types.STRING, gameProfile.name()).writeOptional("id", Types.UUID, gameProfile.id()).writeOptional("properties", Types.PROFILE_PROPERTY_ARRAY, gameProfile.properties(), EMPTY_PROPERTIES));
    }
}

