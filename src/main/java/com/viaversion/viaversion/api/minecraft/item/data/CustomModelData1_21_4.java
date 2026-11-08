/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.ArrayUtil;
import com.viaversion.viaversion.util.Copyable;
import io.netty.buffer.ByteBuf;

public record CustomModelData1_21_4(float[] floats, boolean[] booleans, String[] strings, int[] colors) implements Copyable
{
    public static final Type<CustomModelData1_21_4> TYPE = new Type<CustomModelData1_21_4>(CustomModelData1_21_4.class){

        @Override
        public CustomModelData1_21_4 read(ByteBuf byteBuf) {
            float[] fArray = (float[])Types.FLOAT_ARRAY_PRIMITIVE.read(byteBuf);
            boolean[] blArray = (boolean[])Types.BOOLEAN_ARRAY_PRIMITIVE.read(byteBuf);
            String[] stringArray = (String[])Types.STRING_ARRAY.read(byteBuf);
            int[] nArray = (int[])Types.INT_ARRAY_PRIMITIVE.read(byteBuf);
            return new CustomModelData1_21_4(fArray, blArray, stringArray, nArray);
        }

        @Override
        public void write(ByteBuf byteBuf, CustomModelData1_21_4 customModelData1_21_4) {
            Types.FLOAT_ARRAY_PRIMITIVE.write(byteBuf, customModelData1_21_4.floats());
            Types.BOOLEAN_ARRAY_PRIMITIVE.write(byteBuf, customModelData1_21_4.booleans());
            Types.STRING_ARRAY.write(byteBuf, customModelData1_21_4.strings());
            Types.INT_ARRAY_PRIMITIVE.write(byteBuf, customModelData1_21_4.colors());
        }

        @Override
        public void write(Ops ops, CustomModelData1_21_4 customModelData1_21_4) {
            ops.writeMap(mapSerializer -> mapSerializer.writeOptional("floats", new ArrayType<Float>(Types.FLOAT), ArrayUtil.boxedArray(customModelData1_21_4.floats), new Float[0]).writeOptional("flags", new ArrayType<Boolean>(Types.BOOLEAN), ArrayUtil.boxedArray(customModelData1_21_4.booleans), new Boolean[0]).writeOptional("strings", Types.STRING_ARRAY, customModelData1_21_4.strings(), new String[0]).writeOptional("colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(customModelData1_21_4.colors), new Integer[0]));
        }
    };

    @Override
    public CustomModelData1_21_4 copy() {
        return new CustomModelData1_21_4(Copyable.copy(this.floats), Copyable.copy(this.booleans), Copyable.copy(this.strings), Copyable.copy(this.colors));
    }
}

