/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.nbt.tag.Tag;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.api.type.types.misc.HolderType;
import com.viaversion.viaversion.util.Copyable;
import com.viaversion.viaversion.util.Key;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record ArmorTrimPattern(String assetName, int itemId, Tag description, boolean decal) implements Copyable,
Rewritable
{
    public static final HolderType<ArmorTrimPattern> TYPE1_20_5 = new HolderType<ArmorTrimPattern>(){

        @Override
        public ArmorTrimPattern readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            int n = Types.VAR_INT.readPrimitive(byteBuf);
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ArmorTrimPattern(string, n, tag, bl);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimPattern armorTrimPattern) {
            Types.STRING.write(byteBuf, armorTrimPattern.assetName());
            Types.VAR_INT.writePrimitive(byteBuf, armorTrimPattern.itemId());
            Types.TAG.write(byteBuf, armorTrimPattern.description());
            byteBuf.writeBoolean(armorTrimPattern.decal());
        }
    };
    public static final HolderType<ArmorTrimPattern> TYPE1_21_5 = new HolderType<ArmorTrimPattern>(){

        @Override
        public ArmorTrimPattern readDirect(ByteBuf byteBuf) {
            String string = (String)Types.STRING.read(byteBuf);
            Tag tag = (Tag)Types.TAG.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ArmorTrimPattern(string, tag, bl);
        }

        @Override
        public void writeDirect(ByteBuf byteBuf, ArmorTrimPattern armorTrimPattern) {
            Types.STRING.write(byteBuf, armorTrimPattern.assetName());
            Types.TAG.write(byteBuf, armorTrimPattern.description());
            byteBuf.writeBoolean(armorTrimPattern.decal());
        }

        @Override
        public void writeDirect(Ops ops, ArmorTrimPattern armorTrimPattern) {
            ops.writeMap(mapSerializer -> mapSerializer.write("asset_id", Types.IDENTIFIER, Key.of(armorTrimPattern.assetName())).write("description", Types.TEXT_COMPONENT_TAG, armorTrimPattern.description()).write("decal", Types.BOOLEAN, armorTrimPattern.decal()));
        }

        @Override
        protected Key identifier(Ops ops, int n) {
            return ops.context().registryAccess().registryKey("trim_pattern", n);
        }
    };

    public ArmorTrimPattern(String string, Tag tag, boolean bl) {
        this(string, 0, tag, bl);
    }

    @Override
    public ArmorTrimPattern rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        return new ArmorTrimPattern(this.assetName, Rewritable.rewriteItem(protocol, bl, this.itemId), this.description, this.decal);
    }

    @Override
    public ArmorTrimPattern copy() {
        return new ArmorTrimPattern(this.assetName, this.itemId, this.description.copy(), this.decal);
    }
}

