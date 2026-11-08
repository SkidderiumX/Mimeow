/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.GameProfile;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import io.netty.buffer.ByteBuf;

public class ProfilePropertyType
extends Type<GameProfile.Property> {
    public ProfilePropertyType() {
        super(GameProfile.Property.class);
    }

    @Override
    public GameProfile.Property read(ByteBuf byteBuf) {
        String string = (String)Types.STRING.read(byteBuf);
        String string2 = (String)Types.STRING.read(byteBuf);
        String string3 = (String)Types.OPTIONAL_STRING.read(byteBuf);
        return new GameProfile.Property(string, string2, string3);
    }

    @Override
    public void write(ByteBuf byteBuf, GameProfile.Property property) {
        Types.STRING.write(byteBuf, property.name());
        Types.STRING.write(byteBuf, property.value());
        Types.OPTIONAL_STRING.write(byteBuf, property.signature());
    }

    @Override
    public void write(Ops ops, GameProfile.Property property) {
        ops.writeMap(mapSerializer -> mapSerializer.write("name", Types.STRING, property.name()).write("value", Types.STRING, property.value()).writeOptional("signature", Types.STRING, property.signature()));
    }
}

