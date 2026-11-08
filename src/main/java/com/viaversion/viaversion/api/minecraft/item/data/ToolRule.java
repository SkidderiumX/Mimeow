/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.data.MappingData;
import com.viaversion.viaversion.api.minecraft.HolderSet;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.ArrayType;
import com.viaversion.viaversion.api.type.types.misc.HolderSetType;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public record ToolRule(HolderSet blocks, @Nullable Float speed, @Nullable Boolean correctForDrops) implements Rewritable
{
    public static final Type<ToolRule> TYPE = new Type<ToolRule>(ToolRule.class){

        @Override
        public ToolRule read(ByteBuf byteBuf) {
            HolderSet holderSet = (HolderSet)Types.HOLDER_SET.read(byteBuf);
            Float f = (Float)Types.OPTIONAL_FLOAT.read(byteBuf);
            Boolean bl = (Boolean)Types.OPTIONAL_BOOLEAN.read(byteBuf);
            return new ToolRule(holderSet, f, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, ToolRule toolRule) {
            Types.HOLDER_SET.write(byteBuf, toolRule.blocks);
            Types.OPTIONAL_FLOAT.write(byteBuf, toolRule.speed);
            Types.OPTIONAL_BOOLEAN.write(byteBuf, toolRule.correctForDrops);
        }

        @Override
        public void write(Ops ops, ToolRule toolRule) {
            ops.writeMap(mapSerializer -> mapSerializer.write("blocks", new HolderSetType(MappingData.MappingType.BLOCK), toolRule.blocks).writeOptional("speed", Types.FLOAT, toolRule.speed).writeOptional("correct_for_drops", Types.BOOLEAN, toolRule.correctForDrops));
        }
    };
    public static final Type<ToolRule[]> ARRAY_TYPE = new ArrayType<ToolRule>(TYPE);

    @Override
    public ToolRule rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return this.blocks.hasIds() ? new ToolRule(this.blocks.rewrite(Rewritable.blockRewriteFunction(protocol, bl)), this.speed, this.correctForDrops) : this;
    }
}

