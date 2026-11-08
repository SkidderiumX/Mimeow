/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.data.predicate;

import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public record DataComponentMatchers(StructuredData<?>[] exactPredicates, DataComponentPredicate[] predicates) {

    public static final class DataComponentMatchersType
    extends Type<DataComponentMatchers> {
        private final Type<StructuredData<?>[]> dataArrayType;
        private final Type<DataComponentPredicate[]> predicateArrayType;

        public DataComponentMatchersType(Type<StructuredData<?>[]> type, Type<DataComponentPredicate[]> type2) {
            super(DataComponentMatchers.class);
            this.dataArrayType = type;
            this.predicateArrayType = type2;
        }

        @Override
        public DataComponentMatchers read(ByteBuf byteBuf) {
            StructuredData[] structuredDataArray = (StructuredData[])this.dataArrayType.read(byteBuf);
            DataComponentPredicate[] dataComponentPredicateArray = (DataComponentPredicate[])this.predicateArrayType.read(byteBuf);
            return new DataComponentMatchers(structuredDataArray, dataComponentPredicateArray);
        }

        @Override
        public void write(ByteBuf byteBuf, DataComponentMatchers dataComponentMatchers) {
            this.dataArrayType.write(byteBuf, dataComponentMatchers.exactPredicates());
            this.predicateArrayType.write(byteBuf, dataComponentMatchers.predicates());
        }
    }
}

