/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.RegistryKey;
import com.viaversion.viaversion.api.minecraft.SoundEvent;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.misc.HolderSetType;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record BlocksAttacks(float blockDelaySeconds, float disableCooldownScale, DamageReduction[] damageReductions, ItemDamageFunction itemDamage, @Nullable HolderSet bypassedBy, @Nullable Holder<SoundEvent> blockSound, @Nullable Holder<SoundEvent> disableSound) implements Rewritable
{
    public static final Type<BlocksAttacks> TYPE1_21_5 = new Type<BlocksAttacks>(BlocksAttacks.class){

        @Override
        public BlocksAttacks read(ByteBuf byteBuf) {
            float f = byteBuf.readFloat();
            float f2 = byteBuf.readFloat();
            DamageReduction[] damageReductionArray = DamageReduction.ARRAY_TYPE.read(byteBuf);
            ItemDamageFunction itemDamageFunction = (ItemDamageFunction)ItemDamageFunction.TYPE.read(byteBuf);
            String string = (String)Types.OPTIONAL_STRING.read(byteBuf);
            Object object = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            Object object2 = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            return new BlocksAttacks(f, f2, damageReductionArray, itemDamageFunction, string != null ? HolderSet.of(string) : null, (Holder<SoundEvent>)object, (Holder<SoundEvent>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, BlocksAttacks blocksAttacks) {
            byteBuf.writeFloat(blocksAttacks.blockDelaySeconds());
            byteBuf.writeFloat(blocksAttacks.disableCooldownScale());
            DamageReduction.ARRAY_TYPE.write(byteBuf, (T[])blocksAttacks.damageReductions());
            ItemDamageFunction.TYPE.write(byteBuf, blocksAttacks.itemDamage());
            Types.OPTIONAL_STRING.write(byteBuf, blocksAttacks.bypassedBy() != null ? blocksAttacks.bypassedBy().tagKey() : null);
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, blocksAttacks.blockSound());
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, blocksAttacks.disableSound());
        }

        @Override
        public void write(Ops ops, BlocksAttacks blocksAttacks) {
            DamageReduction[] damageReductionArray = new DamageReduction[]{new DamageReduction(90.0f, null, 0.0f, 1.0f)};
            ItemDamageFunction itemDamageFunction = new ItemDamageFunction(1.0f, 0.0f, 1.0f);
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("block_delay_seconds", Types.FLOAT, Float.valueOf(blocksAttacks.blockDelaySeconds()), Float.valueOf(0.0f)).writeOptional("disable_cooldown_scale", Types.FLOAT, Float.valueOf(blocksAttacks.disableCooldownScale()), Float.valueOf(1.0f)).writeOptional("damage_reductions", DamageReduction.ARRAY_TYPE, blocksAttacks.damageReductions(), damageReductionArray).writeOptional("item_damage", ItemDamageFunction.TYPE, blocksAttacks.itemDamage(), itemDamageFunction).writeOptional("bypassed_by", Types.TAG_KEY, blocksAttacks.bypassedBy() != null ? Key.of(blocksAttacks.bypassedBy().tagKey()) : null).writeOptional("block_sound", Types.SOUND_EVENT, blocksAttacks.blockSound()).writeOptional("disabled_sound", Types.SOUND_EVENT, blocksAttacks.disableSound()));
        }
    };
    public static final Type<BlocksAttacks> TYPE26_1 = new Type<BlocksAttacks>(BlocksAttacks.class){

        @Override
        public BlocksAttacks read(ByteBuf byteBuf) {
            float f = byteBuf.readFloat();
            float f2 = byteBuf.readFloat();
            DamageReduction[] damageReductionArray = DamageReduction.ARRAY_TYPE.read(byteBuf);
            ItemDamageFunction itemDamageFunction = (ItemDamageFunction)ItemDamageFunction.TYPE.read(byteBuf);
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            Object object = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            Object object2 = Types.OPTIONAL_SOUND_EVENT.read(byteBuf);
            return new BlocksAttacks(f, f2, damageReductionArray, itemDamageFunction, holderSet, (Holder<SoundEvent>)object, (Holder<SoundEvent>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, BlocksAttacks blocksAttacks) {
            byteBuf.writeFloat(blocksAttacks.blockDelaySeconds());
            byteBuf.writeFloat(blocksAttacks.disableCooldownScale());
            DamageReduction.ARRAY_TYPE.write(byteBuf, (T[])blocksAttacks.damageReductions());
            ItemDamageFunction.TYPE.write(byteBuf, blocksAttacks.itemDamage());
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, blocksAttacks.bypassedBy());
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, blocksAttacks.blockSound());
            Types.OPTIONAL_SOUND_EVENT.write(byteBuf, blocksAttacks.disableSound());
        }

        @Override
        public void write(Ops ops, BlocksAttacks blocksAttacks) {
            DamageReduction[] damageReductionArray = new DamageReduction[]{new DamageReduction(90.0f, null, 0.0f, 1.0f)};
            ItemDamageFunction itemDamageFunction = new ItemDamageFunction(1.0f, 0.0f, 1.0f);
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("block_delay_seconds", Types.FLOAT, Float.valueOf(blocksAttacks.blockDelaySeconds()), Float.valueOf(0.0f)).writeOptional("disable_cooldown_scale", Types.FLOAT, Float.valueOf(blocksAttacks.disableCooldownScale()), Float.valueOf(1.0f)).writeOptional("damage_reductions", DamageReduction.ARRAY_TYPE, blocksAttacks.damageReductions(), damageReductionArray).writeOptional("item_damage", ItemDamageFunction.TYPE, blocksAttacks.itemDamage(), itemDamageFunction).writeOptional("bypassed_by", new HolderSetType(RegistryKey.of("damage_type")), blocksAttacks.bypassedBy()).writeOptional("block_sound", Types.SOUND_EVENT, blocksAttacks.blockSound()).writeOptional("disabled_sound", Types.SOUND_EVENT, blocksAttacks.disableSound()));
        }
    };

    @Override
    public BlocksAttacks rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<SoundEvent> holder = SoundEvent.rewriteHolder(this.blockSound, Rewritable.soundRewriteFunction(protocol, bl));
        Holder<SoundEvent> holder2 = SoundEvent.rewriteHolder(this.disableSound, Rewritable.soundRewriteFunction(protocol, bl));
        return new BlocksAttacks(this.blockDelaySeconds, this.disableCooldownScale, this.damageReductions, this.itemDamage, this.bypassedBy, holder, holder2);
    }

    public record DamageReduction(float horizontalBlockingAngle, @Nullable HolderSet type, float base, float factor) {
        public static final Type<DamageReduction> TYPE = new Type<DamageReduction>(DamageReduction.class){

            @Override
            public DamageReduction read(ByteBuf byteBuf) {
                float f = byteBuf.readFloat();
                HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
                float f2 = byteBuf.readFloat();
                float f3 = byteBuf.readFloat();
                return new DamageReduction(f, holderSet, f2, f3);
            }

            @Override
            public void write(ByteBuf byteBuf, DamageReduction damageReduction) {
                byteBuf.writeFloat(damageReduction.horizontalBlockingAngle());
                Types.OPTIONAL_HOLDER_SET.write(byteBuf, damageReduction.type());
                byteBuf.writeFloat(damageReduction.base());
                byteBuf.writeFloat(damageReduction.factor());
            }

            @Override
            public void write(Ops ops, DamageReduction damageReduction) {
                ops.writeMap(mapSerializer -> mapSerializer.writeOptional("horizontal_blocking_angle", Types.FLOAT, Float.valueOf(damageReduction.horizontalBlockingAngle()), Float.valueOf(90.0f)).writeOptional("type", new HolderSetType(RegistryKey.of("damage_type")), damageReduction.type()).write("base", Types.FLOAT, Float.valueOf(damageReduction.base())).write("factor", Types.FLOAT, Float.valueOf(damageReduction.factor())));
            }
        };
        public static final ArrayType<DamageReduction> ARRAY_TYPE = new ArrayType<DamageReduction>(TYPE);
    }

    public record ItemDamageFunction(float threshold, float base, float factor) {
        public static final Type<ItemDamageFunction> TYPE = new Type<ItemDamageFunction>(ItemDamageFunction.class){

            @Override
            public ItemDamageFunction read(ByteBuf byteBuf) {
                float f = byteBuf.readFloat();
                float f2 = byteBuf.readFloat();
                float f3 = byteBuf.readFloat();
                return new ItemDamageFunction(f, f2, f3);
            }

            @Override
            public void write(ByteBuf byteBuf, ItemDamageFunction itemDamageFunction) {
                byteBuf.writeFloat(itemDamageFunction.threshold());
                byteBuf.writeFloat(itemDamageFunction.base());
                byteBuf.writeFloat(itemDamageFunction.factor());
            }

            @Override
            public void write(Ops ops, ItemDamageFunction itemDamageFunction) {
                ops.writeMap(mapSerializer -> mapSerializer.write("threshold", Types.FLOAT, Float.valueOf(itemDamageFunction.threshold())).write("base", Types.FLOAT, Float.valueOf(itemDamageFunction.base())).write("factor", Types.FLOAT, Float.valueOf(itemDamageFunction.factor())));
            }
        };
    }
}

