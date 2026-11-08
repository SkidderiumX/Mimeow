/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.EntityData;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record Bee(EntityData entityData, int ticksInHive, int minTicksInHive) implements Copyable
{
    public static final Type<Bee> TYPE1_20_5 = new Type<Bee>(Bee.class){

        @Override
        public Bee read(ByteBuf byteBuf) {
            CompoundTag compoundTag = (CompoundTag)Types.COMPOUND_TAG.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            return new Bee(new EntityData(-1, compoundTag), n, n2);
        }

        @Override
        public void write(ByteBuf byteBuf, Bee bee) {
            Types.COMPOUND_TAG.write(byteBuf, bee.entityData.tag());
            Types.VAR_INT.writePrimitive(byteBuf, bee.ticksInHive);
            Types.VAR_INT.writePrimitive(byteBuf, bee.minTicksInHive);
        }

        @Override
        public void write(Ops ops, Bee bee) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("entity_data", Types.COMPOUND_TAG, bee.entityData.tag(), new CompoundTag()).write("ticks_in_hive", Types.INT, bee.ticksInHive).write("min_ticks_in_hive", Types.INT, bee.minTicksInHive));
        }
    };
    public static final Type<Bee[]> ARRAY_TYPE1_20_5 = new ArrayType<Bee>(TYPE1_20_5);
    public static final Type<Bee> TYPE1_21_9 = new Type<Bee>(Bee.class){

        @Override
        public Bee read(ByteBuf byteBuf) {
            EntityData entityData = (EntityData)EntityData.TYPE.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int n2 = Types.VAR_INT.readPrimitive(byteBuf);
            return new Bee(entityData, n, n2);
        }

        @Override
        public void write(ByteBuf byteBuf, Bee bee) {
            EntityData.TYPE.write(byteBuf, bee.entityData);
            Types.VAR_INT.writePrimitive(byteBuf, bee.ticksInHive);
            Types.VAR_INT.writePrimitive(byteBuf, bee.minTicksInHive);
        }

        @Override
        public void write(Ops ops, Bee bee) {
            ops.writeMap(mapSerializer -> mapSerializer.write("entity_data", EntityData.TYPE, bee.entityData).write("ticks_in_hive", Types.INT, bee.ticksInHive).write("min_ticks_in_hive", Types.INT, bee.minTicksInHive));
        }
    };
    public static final Type<Bee[]> ARRAY_TYPE1_21_9 = new ArrayType<Bee>(TYPE1_21_9);

    public Bee(CompoundTag compoundTag, int n, int n2) {
        this(new EntityData(-1, compoundTag), n, n2);
    }

    @Override
    public Bee copy() {
        return new Bee(this.entityData.copy(), this.ticksInHive, this.minTicksInHive);
    }
}

