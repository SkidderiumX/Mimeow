/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EnumTypes;
import com.viaversion.viaversion.api.minecraft.item.data.PotionEffect;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.misc.HolderSetType;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record Consumable1_21_2(float consumeSeconds, int animationType, Holder<SoundEvent> sound, boolean hasConsumeParticles, ConsumeEffect<?>[] consumeEffects) implements Copyable,
Rewritable
{
    private static final HolderSetType REMOVE_EFFECTS_TYPE = new HolderSetType(){

        @Override
        public void write(Ops ops, HolderSet holderSet) {
            ops.writeMap(mapSerializer -> mapSerializer.write("effects", new HolderSetType(EnumTypes.MOB_EFFECT), holderSet));
        }
    };
    private static final Type<Float> TELEPORT_RANDOMLY_TYPE = new Type<Float>(Float.class){

        @Override
        public void write(ByteBuf byteBuf, Float f) {
            Types.FLOAT.writePrimitive(byteBuf, f.floatValue());
        }

        @Override
        public Float read(ByteBuf byteBuf) {
            return Float.valueOf(Types.FLOAT.readPrimitive(byteBuf));
        }

        @Override
        public void write(Ops ops, Float f) {
            ops.writeMap(mapSerializer -> mapSerializer.write("diameter", Types.FLOAT, Float.valueOf(16.0f)));
        }
    };
    private static final HolderType<SoundEvent> PLAY_SOUND_TYPE = new HolderType<SoundEvent>(MappingData.MappingType.SOUND){

        @Override
        public SoundEvent readDirect(ByteBuf byteBuf) {
            return Types.SOUND_EVENT.readDirect(byteBuf);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, SoundEvent soundEvent) {
            Types.SOUND_EVENT.writeDirect(byteBuf, soundEvent);
        }

        @Override
        public void write(Ops ops, Holder<SoundEvent> holder) {
            ops.writeMap(mapSerializer -> mapSerializer.write("sound", Types.SOUND_EVENT, holder));
        }
    };
    public static final Type<?>[] EFFECT_TYPES = new Type[]{ApplyStatusEffects.TYPE, REMOVE_EFFECTS_TYPE, Types.EMPTY, TELEPORT_RANDOMLY_TYPE, PLAY_SOUND_TYPE};
    public static final Type<Consumable1_21_2> TYPE = new Type<Consumable1_21_2>(Consumable1_21_2.class){

        @Override
        public Consumable1_21_2 read(ByteBuf byteBuf) {
            float f = byteBuf.readFloat();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Object object = Types.SOUND_EVENT.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            ConsumeEffect[] consumeEffectArray = (ConsumeEffect[])ConsumeEffect.ARRAY_TYPE.read(byteBuf);
            return new Consumable1_21_2(f, n, (Holder<SoundEvent>)object, bl, consumeEffectArray);
        }

        @Override
        public void write(ByteBuf byteBuf, Consumable1_21_2 consumable1_21_2) {
            byteBuf.writeFloat(consumable1_21_2.consumeSeconds);
            Types.VAR_INT.writePrimitive(byteBuf, consumable1_21_2.animationType);
            Types.SOUND_EVENT.write(byteBuf, consumable1_21_2.sound);
            byteBuf.writeBoolean(consumable1_21_2.hasConsumeParticles);
            ConsumeEffect.ARRAY_TYPE.write(byteBuf, consumable1_21_2.consumeEffects);
        }

        @Override
        public void write(Ops ops, Consumable1_21_2 consumable1_21_2) {
            Holder<int> holder = Holder.of(ops.context().registryAccess().id(MappingData.MappingType.SOUND, "entity.generic.eat"));
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("consume_seconds", Types.FLOAT, Float.valueOf(consumable1_21_2.consumeSeconds), Float.valueOf(1.6f)).writeOptional("animation", EnumTypes.ITEM_USE_ANIMATION, consumable1_21_2.animationType, 1).writeOptional("sound", Types.SOUND_EVENT, consumable1_21_2.sound, holder).writeOptional("has_consume_particles", Types.BOOLEAN, consumable1_21_2.hasConsumeParticles, true).writeOptional("consume_effects", ConsumeEffect.ARRAY_TYPE, consumable1_21_2.consumeEffects, new ConsumeEffect[0]));
        }
    };

    @Override
    public Consumable1_21_2 rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.sound, Rewritable.soundRewriteFunction(protocol, bl));
        return holder == this.sound ? this : new Consumable1_21_2(this.consumeSeconds, this.animationType, holder, this.hasConsumeParticles, this.consumeEffects);
    }

    @Override
    public Consumable1_21_2 copy() {
        return new Consumable1_21_2(this.consumeSeconds, this.animationType, this.sound, this.hasConsumeParticles, Copyable.copy(this.consumeEffects));
    }

    public record ConsumeEffect<T>(int id, Type<T> type, T value) {
        public static final Type<ConsumeEffect<?>> TYPE = new Type<ConsumeEffect<?>>(ConsumeEffect.class){

            @Override
            public ConsumeEffect<?> read(ByteBuf byteBuf) {
                int n = Types.VAR_INT.readPrimitive(byteBuf);
                Type<?> type = EFFECT_TYPES[n];
                Object t = type.read(byteBuf);
                return ConsumeEffect.of(n, type, t);
            }

            @Override
            public void write(ByteBuf byteBuf, ConsumeEffect<?> consumeEffect) {
                Types.VAR_INT.writePrimitive(byteBuf, consumeEffect.id);
                consumeEffect.writeValue(byteBuf);
            }

            @Override
            public void write(Ops ops, ConsumeEffect<?> consumeEffect) {
                this.writeGeneric(ops, consumeEffect);
            }

            private <E> void writeGeneric(Ops ops, ConsumeEffect<E> consumeEffect) {
                ops.writeMap(mapSerializer -> mapSerializer.write("type", EnumTypes.CONSUME_EFFECT, consumeEffect.id).writeInlinedMap(consumeEffect.type, consumeEffect.value));
            }
        };
        public static final Type<ConsumeEffect<?>[]> ARRAY_TYPE = new ArrayType(TYPE);

        static <T> ConsumeEffect<T> of(int n, Type<T> type, Object object) {
            return new ConsumeEffect<Object>(n, type, object);
        }

        void writeValue(ByteBuf byteBuf) {
            this.type.write(byteBuf, this.value);
        }
    }

    public record ApplyStatusEffects(PotionEffect[] effects, float probability) {
        public static final Type<ApplyStatusEffects> TYPE = new Type<ApplyStatusEffects>(ApplyStatusEffects.class){

            @Override
            public ApplyStatusEffects read(ByteBuf byteBuf) {
                PotionEffect[] potionEffectArray = (PotionEffect[])PotionEffect.ARRAY_TYPE.read(byteBuf);
                float f = byteBuf.readFloat();
                return new ApplyStatusEffects(potionEffectArray, f);
            }

            @Override
            public void write(ByteBuf byteBuf, ApplyStatusEffects applyStatusEffects) {
                PotionEffect.ARRAY_TYPE.write(byteBuf, applyStatusEffects.effects);
                byteBuf.writeFloat(applyStatusEffects.probability);
            }

            @Override
            public void write(Ops ops, ApplyStatusEffects applyStatusEffects) {
                ops.writeMap(mapSerializer -> mapSerializer.write("effects", PotionEffect.ARRAY_TYPE, applyStatusEffects.effects).writeOptional("probability", Types.FLOAT, Float.valueOf(applyStatusEffects.probability), Float.valueOf(1.0f)));
            }
        };
    }
}

