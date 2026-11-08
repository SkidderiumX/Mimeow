/*
 * Decompiled with CFR 0.152.
 */
package com.viaversion.viaversion.api.minecraft.item.data;

import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.minecraft.Holder;
import com.viaversion.viaversion.api.minecraft.codec.Ops;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimMaterial;
import com.viaversion.viaversion.api.minecraft.item.data.ArmorTrimPattern;
import com.viaversion.viaversion.api.protocol.Protocol;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.util.Rewritable;
import io.netty.buffer.ByteBuf;

public record ArmorTrim(Holder<ArmorTrimMaterial> material, Holder<ArmorTrimPattern> pattern, boolean showInTooltip) implements Rewritable
{
    public static final Type<ArmorTrim> TYPE1_20_5 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf byteBuf) {
            Object object = ArmorTrimMaterial.TYPE1_20_5.read(byteBuf);
            Object object2 = ArmorTrimPattern.TYPE1_20_5.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)object, (Holder<ArmorTrimPattern>)object2, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, ArmorTrim armorTrim) {
            ArmorTrimMaterial.TYPE1_20_5.write(byteBuf, armorTrim.material);
            ArmorTrimPattern.TYPE1_20_5.write(byteBuf, armorTrim.pattern);
            byteBuf.writeBoolean(armorTrim.showInTooltip);
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_2 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf byteBuf) {
            Object object = ArmorTrimMaterial.TYPE1_21_2.read(byteBuf);
            Object object2 = ArmorTrimPattern.TYPE1_20_5.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)object, (Holder<ArmorTrimPattern>)object2, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, ArmorTrim armorTrim) {
            ArmorTrimMaterial.TYPE1_21_2.write(byteBuf, armorTrim.material);
            ArmorTrimPattern.TYPE1_20_5.write(byteBuf, armorTrim.pattern);
            byteBuf.writeBoolean(armorTrim.showInTooltip);
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_4 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf byteBuf) {
            Object object = ArmorTrimMaterial.TYPE1_21_4.read(byteBuf);
            Object object2 = ArmorTrimPattern.TYPE1_20_5.read(byteBuf);
            boolean bl = byteBuf.readBoolean();
            return new ArmorTrim((Holder<ArmorTrimMaterial>)object, (Holder<ArmorTrimPattern>)object2, bl);
        }

        @Override
        public void write(ByteBuf byteBuf, ArmorTrim armorTrim) {
            ArmorTrimMaterial.TYPE1_21_4.write(byteBuf, armorTrim.material);
            ArmorTrimPattern.TYPE1_20_5.write(byteBuf, armorTrim.pattern);
            byteBuf.writeBoolean(armorTrim.showInTooltip);
        }
    };
    public static final Type<ArmorTrim> TYPE1_21_5 = new Type<ArmorTrim>(ArmorTrim.class){

        @Override
        public ArmorTrim read(ByteBuf byteBuf) {
            Object object = ArmorTrimMaterial.TYPE1_21_5.read(byteBuf);
            Object object2 = ArmorTrimPattern.TYPE1_21_5.read(byteBuf);
            return new ArmorTrim((Holder<ArmorTrimMaterial>)object, (Holder<ArmorTrimPattern>)object2);
        }

        @Override
        public void write(ByteBuf byteBuf, ArmorTrim armorTrim) {
            ArmorTrimMaterial.TYPE1_21_5.write(byteBuf, armorTrim.material);
            ArmorTrimPattern.TYPE1_21_5.write(byteBuf, armorTrim.pattern);
        }

        @Override
        public void write(Ops ops, ArmorTrim armorTrim) {
            ops.writeMap(mapSerializer -> mapSerializer.write("material", ArmorTrimMaterial.TYPE1_21_5, armorTrim.material).write("pattern", ArmorTrimPattern.TYPE1_21_5, armorTrim.pattern));
        }
    };

    public ArmorTrim(Holder<ArmorTrimMaterial> holder, Holder<ArmorTrimPattern> holder2) {
        this(holder, holder2, true);
    }

    @Override
    public ArmorTrim rewrite(UserConnection userConnection, Protocol<?, ?, ?, ?> protocol, boolean bl) {
        Holder<Object> holder;
        Holder<Object> holder2 = this.material;
        if (holder2.isDirect()) {
            holder2 = Holder.of(holder2.value().rewrite(userConnection, (Protocol)protocol, bl));
        }
        if ((holder = this.pattern).isDirect()) {
            holder = Holder.of(holder.value().rewrite(userConnection, (Protocol)protocol, bl));
        }
        return new ArmorTrim(holder2, holder, this.showInTooltip);
    }
}

