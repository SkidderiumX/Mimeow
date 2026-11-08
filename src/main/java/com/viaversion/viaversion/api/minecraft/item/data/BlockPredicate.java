/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.CompoundTag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.data.StructuredData;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentMatchers;
import com.viaversion.viaversion.api.minecraft.data.predicate.DataComponentPredicate;
import com.viaversion.viaversion.api.minecraft.item.data.StatePropertyMatcher;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record BlockPredicate(@Nullable HolderSet holderSet, StatePropertyMatcher @Nullable [] propertyMatchers, @Nullable CompoundTag tag, DataComponentMatchers dataMatchers) implements Copyable,
Rewritable
{
    public static final Type<BlockPredicate> TYPE1_20_5 = new Type<BlockPredicate>(BlockPredicate.class){

        @Override
        public BlockPredicate read(ByteBuf byteBuf) {
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            StatePropertyMatcher[] statePropertyMatcherArray = byteBuf.readBoolean() ? (StatePropertyMatcher[])StatePropertyMatcher.ARRAY_TYPE.read(byteBuf) : null;
            CompoundTag compoundTag = (CompoundTag)Types.OPTIONAL_COMPOUND_TAG.read(byteBuf);
            return new BlockPredicate(holderSet, statePropertyMatcherArray, compoundTag, null);
        }

        @Override
        public void write(ByteBuf byteBuf, BlockPredicate blockPredicate) {
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, blockPredicate.holderSet);
            byteBuf.writeBoolean(blockPredicate.propertyMatchers != null);
            if (blockPredicate.propertyMatchers != null) {
                StatePropertyMatcher.ARRAY_TYPE.write(byteBuf, blockPredicate.propertyMatchers);
            }
            Types.OPTIONAL_COMPOUND_TAG.write(byteBuf, blockPredicate.tag);
        }
    };
    public static final Type<BlockPredicate[]> ARRAY_TYPE1_20_5 = new ArrayType<BlockPredicate>(TYPE1_20_5);

    public BlockPredicate(@Nullable HolderSet holderSet, StatePropertyMatcher @Nullable [] statePropertyMatcherArray, @Nullable CompoundTag compoundTag) {
        this(holderSet, statePropertyMatcherArray, compoundTag, new DataComponentMatchers(new StructuredData[0], new DataComponentPredicate[0]));
    }

    @Override
    public BlockPredicate rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        if (this.holderSet == null || this.holderSet.hasTagKey()) {
            return this;
        }
        HolderSet holderSet = this.holderSet.rewrite(Rewritable.blockRewriteFunction(protocol, bl));
        return new BlockPredicate(holderSet, this.propertyMatchers, this.tag);
    }

    @Override
    public BlockPredicate copy() {
        return new BlockPredicate(this.holderSet, Copyable.copy(this.propertyMatchers), this.tag == null ? null : this.tag.copy());
    }

    public static final class BlockPredicateType1_21_5
    extends Type<BlockPredicate> {
        private final Type<DataComponentMatchers> matchersType;

        public BlockPredicateType1_21_5(Type<StructuredData<?>[]> type, Type<DataComponentPredicate[]> type2) {
            super(BlockPredicate.class);
            this.matchersType = new DataComponentMatchers.DataComponentMatchersType(type, type2);
        }

        @Override
        public BlockPredicate read(ByteBuf byteBuf) {
            HolderSet holderSet = (HolderSet)Types.OPTIONAL_HOLDER_SET.read(byteBuf);
            StatePropertyMatcher[] statePropertyMatcherArray = byteBuf.readBoolean() ? (StatePropertyMatcher[])StatePropertyMatcher.ARRAY_TYPE.read(byteBuf) : null;
            CompoundTag compoundTag = (CompoundTag)Types.OPTIONAL_COMPOUND_TAG.read(byteBuf);
            DataComponentMatchers dataComponentMatchers = (DataComponentMatchers)this.matchersType.read(byteBuf);
            return new BlockPredicate(holderSet, statePropertyMatcherArray, compoundTag, dataComponentMatchers);
        }

        @Override
        public void write(ByteBuf byteBuf, BlockPredicate blockPredicate) {
            Types.OPTIONAL_HOLDER_SET.write(byteBuf, blockPredicate.holderSet);
            byteBuf.writeBoolean(blockPredicate.propertyMatchers != null);
            if (blockPredicate.propertyMatchers != null) {
                StatePropertyMatcher.ARRAY_TYPE.write(byteBuf, blockPredicate.propertyMatchers);
            }
            Types.OPTIONAL_COMPOUND_TAG.write(byteBuf, blockPredicate.tag);
            this.matchersType.write(byteBuf, blockPredicate.dataMatchers);
        }
    }
}

