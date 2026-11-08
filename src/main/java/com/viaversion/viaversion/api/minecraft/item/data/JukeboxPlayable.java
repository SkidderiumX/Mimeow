/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.EitherHolder;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.TransformingType;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.EitherHolderType;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record JukeboxPlayable(EitherHolder<JukeboxSong> song, boolean showInTooltip) implements Rewritable
{
    public static final Type<JukeboxPlayable> TYPE1_21 = new Type<JukeboxPlayable>(JukeboxPlayable.class){

        @Override
        public JukeboxPlayable read(ByteBuf byteBuf) {
            EitherHolder<JukeboxSong> eitherHolder = EitherHolderType.read(byteBuf, JukeboxSong.TYPE);
            boolean bl = byteBuf.readBoolean();
            return new JukeboxPlayable(eitherHolder, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, JukeboxPlayable jukeboxPlayable) {
            EitherHolderType.write(byteBuf, jukeboxPlayable.song, JukeboxSong.TYPE);
            byteBuf.writeBoolean(jukeboxPlayable.showInTooltip);
        }
    };
    public static final Type<JukeboxPlayable> TYPE1_21_5 = TransformingType.of(new EitherHolderType<JukeboxSong>(JukeboxSong.TYPE), JukeboxPlayable.class, eitherHolder -> new JukeboxPlayable((EitherHolder<JukeboxSong>)eitherHolder, true), JukeboxPlayable::song);

    public JukeboxPlayable(Holder<JukeboxSong> holder, boolean bl) {
        this(EitherHolder.of(holder), bl);
    }

    public JukeboxPlayable(String string, boolean bl) {
        this(EitherHolder.of(string), bl);
    }

    @Override
    public JukeboxPlayable rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (this.song.hasKey()) {
            return this;
        }
        Holder<JukeboxSong> holder = this.song.holder();
        if (holder.hasId()) {
            return this;
        }
        Object object = holder.value().rewrite(userConnection, (Protocol)protocol, bl);
        return object == holder.value() ? this : new JukeboxPlayable(Holder.of(object), this.showInTooltip);
    }

    public record JukeboxSong(Holder<SoundEvent> soundEvent, Tag description, float lengthInSeconds, int comparatorOutput) implements Rewritable
    {
        public static final HolderType<JukeboxSong> TYPE = new HolderType<JukeboxSong>(){

            @Override
            public JukeboxSong readDirect(ByteBuf byteBuf) {
                Object object = Types.SOUND_EVENT.read(byteBuf);
                Tag tag = (Tag)Types.TAG.read(byteBuf);
                float f = byteBuf.readFloat();
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                return new JukeboxSong((Holder<SoundEvent>)object, tag, f, n);
            }

            @Override
            public void writeDirect(ByteBuf byteBuf, JukeboxSong jukeboxSong) {
                Types.SOUND_EVENT.write(byteBuf, jukeboxSong.soundEvent);
                Types.TAG.write(byteBuf, jukeboxSong.description);
                byteBuf.writeFloat(jukeboxSong.lengthInSeconds);
                Types.VAR_INT.writePrimitive(byteBuf, jukeboxSong.comparatorOutput);
            }

            @Override
            public void writeDirect(Ops ops, JukeboxSong jukeboxSong) {
                ops.writeMap(mapSerializer -> mapSerializer.write("sound_event", Types.SOUND_EVENT, jukeboxSong.soundEvent).write("description", Types.TAG, jukeboxSong.description).write("length_in_seconds", Types.FLOAT, Float.valueOf(jukeboxSong.lengthInSeconds)).write("comparator_output", Types.INT, jukeboxSong.comparatorOutput));
            }

            @Override
            protected Key identifier(Ops ops, int n) {
                return ops.context().registryAccess().registryKey("jukebox_song", n);
            }
        };

        @Override
        public JukeboxSong rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
            Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.soundEvent, Rewritable.soundRewriteFunction(protocol, bl));
            return holder == this.soundEvent ? this : new JukeboxSong(holder, this.description, this.lengthInSeconds, this.comparatorOutput);
        }
    }
}

