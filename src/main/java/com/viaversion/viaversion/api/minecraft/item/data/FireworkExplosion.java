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

public record FireworkExplosion(int shape, int[] colors, int[] fadeColors, boolean hasTrail, boolean hasTwinkle) implements Copyable
{
    public static final String[] SHAPES = new String[]{"small_ball", "large_ball", "star", "creeper", "burst"};
    public static final Type<FireworkExplosion> TYPE = new Type<FireworkExplosion>(FireworkExplosion.class){

        @Override
        public FireworkExplosion read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            int[] nArray = (int[])Types.INT_ARRAY_PRIMITIVE.read(byteBuf);
            int[] nArray2 = (int[])Types.INT_ARRAY_PRIMITIVE.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            boolean bl2 = byteBuf.readBoolean();
            return new FireworkExplosion(n, nArray, nArray2, bl, bl2);
        }

        @Override
        public void write(ByteBuf byteBuf, FireworkExplosion fireworkExplosion) {
            Types.VAR_INT.writePrimitive(byteBuf, fireworkExplosion.shape);
            Types.INT_ARRAY_PRIMITIVE.write(byteBuf, fireworkExplosion.colors);
            Types.INT_ARRAY_PRIMITIVE.write(byteBuf, fireworkExplosion.fadeColors);
            byteBuf.writeBoolean(fireworkExplosion.hasTrail);
            byteBuf.writeBoolean(fireworkExplosion.hasTwinkle);
        }

        @Override
        public void write(Ops ops, FireworkExplosion fireworkExplosion) {
            ops.writeMap(mapSerializer -> mapSerializer.write("shape", Types.STRING, SHAPES[fireworkExplosion.shape]).writeOptional("colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(fireworkExplosion.colors), new Integer[0]).writeOptional("fade_colors", new ArrayType<Integer>(Types.INT), ArrayUtil.boxedArray(fireworkExplosion.fadeColors), new Integer[0]).writeOptional("has_trail", Types.BOOLEAN, fireworkExplosion.hasTrail, false).writeOptional("has_twinkle", Types.BOOLEAN, fireworkExplosion.hasTwinkle, false));
        }
    };
    public static final Type<FireworkExplosion[]> ARRAY_TYPE = new ArrayType<FireworkExplosion>(TYPE);

    @Override
    public FireworkExplosion copy() {
        return new FireworkExplosion(this.shape, Copyable.copy(this.colors), Copyable.copy(this.fadeColors), this.hasTrail, this.hasTwinkle);
    }
}

