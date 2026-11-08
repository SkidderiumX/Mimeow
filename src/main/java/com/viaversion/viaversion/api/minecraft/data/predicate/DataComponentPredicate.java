/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.predicate;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import io.netty.buffer.ByteBuf;

public record DataComponentPredicate(PredicateType type, Tag predicate) {
    public static final Type<DataComponentPredicate> TYPE1_21_5 = new Type<DataComponentPredicate>(DataComponentPredicate.class){

        @Override
        public DataComponentPredicate read(ByteBuf byteBuf) {
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new DataComponentPredicate(n, tag);
        }

        @Override
        public void write(ByteBuf byteBuf, DataComponentPredicate dataComponentPredicate) {
            Types.VAR_INT.writePrimitive(byteBuf, dataComponentPredicate.type().id());
            Types.TAG.write(byteBuf, dataComponentPredicate.predicate());
        }
    };
    public static final Type<DataComponentPredicate[]> ARRAY_TYPE1_21_5 = new ArrayType<DataComponentPredicate>(TYPE1_21_5, 64);
    public static final Type<DataComponentPredicate> TYPE1_21_11 = new Type<DataComponentPredicate>(DataComponentPredicate.class){

        @Override
        public DataComponentPredicate read(ByteBuf byteBuf) {
            boolean bl = Types.BOOLEAN.read(byteBuf);
            PredicateType predicateType = new PredicateType(Types.VAR_INT.readPrimitive(byteBuf), bl);
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            return new DataComponentPredicate(predicateType, tag);
        }

        @Override
        public void write(ByteBuf byteBuf, DataComponentPredicate dataComponentPredicate) {
            Types.BOOLEAN.write(byteBuf, (Boolean)dataComponentPredicate.type().isPredicateType());
            Types.VAR_INT.writePrimitive(byteBuf, dataComponentPredicate.type().id());
            Types.TAG.write(byteBuf, dataComponentPredicate.predicate());
        }
    };
    public static final Type<DataComponentPredicate[]> ARRAY_TYPE1_21_11 = new ArrayType<DataComponentPredicate>(TYPE1_21_11, 64);

    public DataComponentPredicate(int n, Tag tag) {
        this(PredicateType.ofPredicateType(n), tag);
    }

    public record PredicateType(int id, boolean isPredicateType) {
        public static PredicateType ofPredicateType(int n) {
            return new PredicateType(n, true);
        }

        public static PredicateType ofDataComponentType(int n) {
            return new PredicateType(n, false);
        }
    }
}

