/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record UseCooldown(float seconds, @Nullable String cooldownGroup) implements Rewritable
{
    public static final Type<UseCooldown> TYPE = new Type<UseCooldown>(UseCooldown.class){

        @Override
        public UseCooldown read(ByteBuf byteBuf) {
            float f = byteBuf.readFloat();
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            return new UseCooldown(f, string);
        }

        @Override
        public void write(ByteBuf byteBuf, UseCooldown useCooldown) {
            byteBuf.writeFloat(useCooldown.seconds());
            Types.OPTIONAL_STRING.write(byteBuf, useCooldown.cooldownGroup());
        }

        @Override
        public void write(Ops ops, UseCooldown useCooldown) {
            Key key = useCooldown.cooldownGroup != null ? Key.of(useCooldown.cooldownGroup) : null;
            ops.writeMap(mapSerializer -> mapSerializer.write("seconds", Types.FLOAT, Float.valueOf(useCooldown.seconds())).writeOptional("cooldown_group", Types.IDENTIFIER, key));
        }
    };

    @Override
    public UseCooldown rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (this.cooldownGroup == null) {
            return this;
        }
        String string = Rewritable.rewriteItem(protocol, bl, this.cooldownGroup);
        return new UseCooldown(this.seconds, string);
    }
}

