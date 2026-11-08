/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.BlockPredicate;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record AdventureModePredicate(BlockPredicate[] predicates, boolean showInTooltip) implements Copyable,
Rewritable
{
    public static final Type<AdventureModePredicate> TYPE1_20_5 = new Type<AdventureModePredicate>(AdventureModePredicate.class){

        @Override
        public AdventureModePredicate read(ByteBuf byteBuf) {
            BlockPredicate[] blockPredicateArray = (BlockPredicate[])BlockPredicate.ARRAY_TYPE1_20_5.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new AdventureModePredicate(blockPredicateArray, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, AdventureModePredicate adventureModePredicate) {
            BlockPredicate.ARRAY_TYPE1_20_5.write(byteBuf, adventureModePredicate.predicates);
            byteBuf.writeBoolean(adventureModePredicate.showInTooltip);
        }
    };

    public AdventureModePredicate(BlockPredicate[] blockPredicateArray) {
        this(blockPredicateArray, true);
    }

    @Override
    public AdventureModePredicate rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        BlockPredicate[] blockPredicateArray = new BlockPredicate[this.predicates.length];
        for (int i = 0; i < blockPredicateArray.length; ++i) {
            blockPredicateArray[i] = this.predicates[i].rewrite(userConnection, (Protocol)protocol, bl);
        }
        return new AdventureModePredicate(blockPredicateArray, this.showInTooltip);
    }

    @Override
    public AdventureModePredicate copy() {
        return new AdventureModePredicate(Copyable.copy(this.predicates), this.showInTooltip);
    }

    public static final class AdventureModePredicateType1_21_5
    extends Type<AdventureModePredicate> {
        private final Type<BlockPredicate[]> blockPredicateType;

        public AdventureModePredicateType1_21_5(Type<StructuredData<?>[]> type, Type<DataComponentPredicate[]> type2) {
            super(AdventureModePredicate.class);
            this.blockPredicateType = new ArrayType<BlockPredicate>(new BlockPredicate.BlockPredicateType1_21_5(type, type2));
        }

        @Override
        public AdventureModePredicate read(ByteBuf byteBuf) {
            BlockPredicate[] blockPredicateArray = (BlockPredicate[])this.blockPredicateType.read(byteBuf);
            return new AdventureModePredicate(blockPredicateArray);
        }

        @Override
        public void write(ByteBuf byteBuf, AdventureModePredicate adventureModePredicate) {
            this.blockPredicateType.write(byteBuf, adventureModePredicate.predicates);
        }
    }
}

