/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record Instrument1_21_2(Holder<SoundEvent> soundEvent, float useDuration, float range, Tag description) implements Copyable,
Rewritable
{
    public static final HolderType<Instrument1_21_2> TYPE = new HolderType<Instrument1_21_2>(){

        @Override
        public Instrument1_21_2 readDirect(ByteBuf byteBuf) {
            Object object = Types.SOUND_EVENT.read(byteBuf);
            float f = Types.FLOAT.readPrimitive(byteBuf);
            float f2 = Types.FLOAT.readPrimitive(byteBuf);
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new Instrument1_21_2((Holder<SoundEvent>)object, f, f2, tag);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, Instrument1_21_2 instrument1_21_2) {
            Types.SOUND_EVENT.write(byteBuf, instrument1_21_2.soundEvent());
            Types.FLOAT.writePrimitive(byteBuf, instrument1_21_2.useDuration());
            Types.FLOAT.writePrimitive(byteBuf, instrument1_21_2.range());
            Types.TAG.write(byteBuf, instrument1_21_2.description());
        }

        @Override
        public void writeDirect(Ops ops, Instrument1_21_2 instrument1_21_2) {
            ops.writeMap(mapSerializer -> mapSerializer.write("sound_event", Types.SOUND_EVENT, instrument1_21_2.soundEvent()).write("use_duration", Types.FLOAT, Float.valueOf(instrument1_21_2.useDuration())).write("range", Types.FLOAT, Float.valueOf(instrument1_21_2.range())).write("description", Types.TAG, instrument1_21_2.description()));
        }

        @Override
        protected Key identifier(Ops ops, int n) {
            return ops.context().registryAccess().registryKey("instrument", n);
        }
    };
    public static final EitherHolderType<Instrument1_21_2> EITHER_HOLDER_TYPE = new EitherHolderType<Instrument1_21_2>(TYPE);

    @Override
    public Instrument1_21_2 rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, bl));
        return holder == this.soundEvent ? this : new Instrument1_21_2(holder, this.useDuration, this.range, this.description);
    }

    @Override
    public Instrument1_21_2 copy() {
        return new Instrument1_21_2(this.soundEvent, this.useDuration, this.range, this.description.copy());
    }
}

