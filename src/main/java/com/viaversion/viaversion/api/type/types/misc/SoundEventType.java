/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.type.types.misc;

import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Key;
import io.netty.buffer.ByteBuf;

public class SoundEventType
extends HolderType<SoundEvent> {
    public SoundEventType() {
        super(MappingData.MappingType.SOUND);
    }

    @Override
    public SoundEvent readDirect(ByteBuf byteBuf) {
        String string = (String)Types.STRING.read(byteBuf);
        Float f = (Float)Types.OPTIONAL_FLOAT.read(byteBuf);
        return new SoundEvent(string, f);
    }

    @Override
    public void writeDirect(ByteBuf byteBuf, SoundEvent soundEvent) {
        Types.STRING.write(byteBuf, soundEvent.identifier());
        Types.OPTIONAL_FLOAT.write(byteBuf, soundEvent.fixedRange());
    }

    @Override
    public void writeDirect(Ops ops, SoundEvent soundEvent) {
        ops.writeMap(mapSerializer -> mapSerializer.write("sound_id", Types.IDENTIFIER, Key.of(soundEvent.identifier())).writeOptional("range", Types.FLOAT, soundEvent.fixedRange()));
    }

    public static final class OptionalSoundEventType
    extends HolderType.OptionalHolderType<SoundEvent> {
        public OptionalSoundEventType() {
            super(Types.SOUND_EVENT);
        }
    }
}

