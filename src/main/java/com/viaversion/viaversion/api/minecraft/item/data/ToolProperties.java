/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.ToolRule;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record ToolProperties(ToolRule[] rules, float defaultMiningSpeed, int damagePerBlock, boolean canDestroyBlocksInCreative) implements Rewritable
{
    public static final Type<ToolProperties> TYPE1_20_5 = new Type<ToolProperties>(ToolProperties.class){

        @Override
        public ToolProperties read(ByteBuf byteBuf) {
            ToolRule[] toolRuleArray = (ToolRule[])ToolRule.ARRAY_TYPE.read(byteBuf);
            float f = byteBuf.readFloat();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            return new ToolProperties(toolRuleArray, f, n, true);
        }

        @Override
        public void write(ByteBuf byteBuf, ToolProperties toolProperties) {
            ToolRule.ARRAY_TYPE.write(byteBuf, toolProperties.rules());
            byteBuf.writeFloat(toolProperties.defaultMiningSpeed());
            Types.VAR_INT.writePrimitive(byteBuf, toolProperties.damagePerBlock());
        }
    };
    public static final Type<ToolProperties> TYPE1_21_5 = new Type<ToolProperties>(ToolProperties.class){

        @Override
        public ToolProperties read(ByteBuf byteBuf) {
            ToolRule[] toolRuleArray = (ToolRule[])ToolRule.ARRAY_TYPE.read(byteBuf);
            float f = byteBuf.readFloat();
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ToolProperties(toolRuleArray, f, n, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, ToolProperties toolProperties) {
            ToolRule.ARRAY_TYPE.write(byteBuf, toolProperties.rules());
            byteBuf.writeFloat(toolProperties.defaultMiningSpeed());
            Types.VAR_INT.writePrimitive(byteBuf, toolProperties.damagePerBlock());
            byteBuf.writeBoolean(toolProperties.canDestroyBlocksInCreative());
        }

        @Override
        public void write(Ops ops, ToolProperties toolProperties) {
            ops.writeMap(mapSerializer -> mapSerializer.write("rules", ToolRule.ARRAY_TYPE, toolProperties.rules()).writeOptional("default_mining_speed", Types.FLOAT, Float.valueOf(toolProperties.defaultMiningSpeed()), Float.valueOf(1.0f)).writeOptional("damage_per_block", Types.INT, toolProperties.damagePerBlock(), 1).writeOptional("can_destroy_blocks_in_creative", Types.BOOLEAN, toolProperties.canDestroyBlocksInCreative(), true));
        }
    };

    public ToolProperties(ToolRule[] toolRuleArray, float f, int n) {
        this(toolRuleArray, f, n, false);
    }

    @Override
    public ToolProperties rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        ToolRule[] toolRuleArray = new ToolRule[this.rules.length];
        for (int i = 0; i < toolRuleArray.length; ++i) {
            toolRuleArray[i] = this.rules[i].rewrite(userConnection, (Protocol)protocol, bl);
        }
        return new ToolProperties(toolRuleArray, this.defaultMiningSpeed, this.damagePerBlock, this.canDestroyBlocksInCreative);
    }
}

