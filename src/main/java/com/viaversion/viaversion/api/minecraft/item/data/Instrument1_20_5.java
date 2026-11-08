/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record Instrument1_20_5(Holder<SoundEvent> soundEvent, int useDuration, float range) implements Rewritable
{
    public static final HolderType<Instrument1_20_5> TYPE = new HolderType<Instrument1_20_5>(){

        @Override
        public Instrument1_20_5 readDirect(ByteBuf byteBuf) {
            Object object = Types.SOUND_EVENT.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            float f = Types.FLOAT.readPrimitive(byteBuf);
            return new Instrument1_20_5((Holder<SoundEvent>)object, n, f);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, Instrument1_20_5 instrument1_20_5) {
            Types.SOUND_EVENT.write(byteBuf, instrument1_20_5.soundEvent());
            Types.VAR_INT.writePrimitive(byteBuf, instrument1_20_5.useDuration());
            Types.FLOAT.writePrimitive(byteBuf, instrument1_20_5.range());
        }
    };

    @Override
    public Instrument1_20_5 rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, bl));
        return holder == this.soundEvent ? this : new Instrument1_20_5(holder, this.useDuration, this.range);
    }
}

