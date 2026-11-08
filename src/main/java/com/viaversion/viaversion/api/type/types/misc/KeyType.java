/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.OptionalType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class KeyType
extends Type<Key> {
    public KeyType() {
        super(Key.class);
    }

    @Override
    public Key read(ByteBuf byteBuf) {
        String string = (String)Types.STRING.read(byteBuf);
        return Key.of(string);
    }

    @Override
    public void write(ByteBuf byteBuf, Key key) {
        Types.STRING.write(byteBuf, key.original());
    }

    @Override
    public void write(Ops ops, Key key) {
        Types.STRING.write(ops, key.toString());
    }

    public static final class OptionalKeyType
    extends OptionalType<Key> {
        public OptionalKeyType() {
            super(Types.IDENTIFIER);
        }
    }
}

